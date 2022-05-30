package bw.co.roguesystems.hdbscan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bw.co.roguesystems.Hdbscan;

@RestController
@RequestMapping("hdbscan")
public class HdbscanController {

    private double[][] readInDataSet(BufferedReader reader) throws IOException {
		ArrayList<double[]> dataSet = new ArrayList<double[]>();
		int numAttributes = -1;
		int lineIndex = 0;
		String line = reader.readLine();

		while (line != null) {
			line = line.trim();
			lineIndex++;
			String[] lineContents = line.split(",");
			if (numAttributes == -1)
				numAttributes = lineContents.length;
			else if (lineContents.length != numAttributes)
				System.err.println("Line " + lineIndex + " of data set has incorrect number of attributes.");

			double[] attributes = new double[numAttributes];
			for (int i = 0; i < numAttributes; i++) {
				try {
					// If an exception occurs, the attribute will remain 0:
					attributes[i] = Double.parseDouble(lineContents[i].trim());
				} catch (NumberFormatException nfe) {
					System.err.println("Illegal value on line " + lineIndex + " of data set: " + lineContents[i]);
				}
			}

			dataSet.add(attributes);
			line = reader.readLine();
		}

		reader.close();
		double[][] finalDataSet = new double[dataSet.size()][numAttributes];

		for (int i = 0; i < dataSet.size(); i++) {
			finalDataSet[i] = dataSet.get(i);
		}

		return finalDataSet;
	}

    @PostMapping("/upload")
    public ResponseEntity<?> loadFile(@RequestParam("file") MultipartFile multipartFile, @RequestParam("minPts") int minPts, @RequestParam("getMap") Boolean getMap) {

        if(multipartFile.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()));
            double[][] finalDataSet = this.readInDataSet(reader);

            Hdbscan sc = new Hdbscan(minPts);
		    sc.run(finalDataSet);

            HdbscanResult result = new HdbscanResult();
            result.setLabels(sc.getLabels());

            if(getMap) {
                result.setClusterMap(sc.getClusterMap());
            }

            return ResponseEntity.ok().body(result);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.toString());
        }
    }
}
