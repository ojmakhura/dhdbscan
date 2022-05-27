package bw.co.roguesystems.dhdbscan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import bw.co.roguesystems.Hdbscan;

@SpringBootApplication
public class DhdbscanApplication {

	public static void main(String[] args) {
		SpringApplication.run(DhdbscanApplication.class, args);
	}

	// @Bean
	// public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	// 	return args -> {

	// 		double mydata[][] = readInDataSet("/home/junior/programming/rogue/hdbscan/test_datasets/example_data_set.csv", ",");
	// 		Hdbscan sc = new Hdbscan(3);
	// 		sc.run(mydata);
	// 		int[] labels = sc.getLabels();
	// 		System.out.print("labels = [");
	// 		for (int i = 0; i < labels.length; i++) {
	// 			System.out.print(labels[i] + ", ");
	// 		}
	// 		System.out.println("]");

	// 		HashMap<Integer, ArrayList<Integer>> ds = sc.getClusterMap();

	// 		for (Integer in : ds.keySet()) {
	// 			System.out.print(in + " : ");
	// 			ArrayList<Integer> idx = ds.get(in);
	// 			for (int i = 0; i < idx.size(); i++) {
	// 				System.out.print(idx.get(i) + ", ");
	// 			}
	// 			System.out.println();
	// 		}

	// 	};
	// }

	// public static double[][] readInDataSet(String fileName, String delimiter) throws IOException {
	// 	BufferedReader reader = new BufferedReader(new FileReader(fileName));
	// 	ArrayList<double[]> dataSet = new ArrayList<double[]>();
	// 	int numAttributes = -1;
	// 	int lineIndex = 0;
	// 	String line = reader.readLine();

	// 	while (line != null) {
	// 		line = line.trim();
	// 		lineIndex++;
	// 		String[] lineContents = line.split(delimiter);
	// 		// System.out.println("Line " + lineIndex + " has " + lineContents.length);
	// 		if (numAttributes == -1)
	// 			numAttributes = lineContents.length;
	// 		else if (lineContents.length != numAttributes)
	// 			System.err.println("Line " + lineIndex + " of data set has incorrect number of attributes.");

	// 		double[] attributes = new double[numAttributes];
	// 		for (int i = 0; i < numAttributes; i++) {
	// 			try {
	// 				// If an exception occurs, the attribute will remain 0:
	// 				attributes[i] = Double.parseDouble(lineContents[i].trim());
	// 			} catch (NumberFormatException nfe) {
	// 				System.err.println("Illegal value on line " + lineIndex + " of data set: " + lineContents[i]);
	// 			}
	// 		}

	// 		dataSet.add(attributes);
	// 		line = reader.readLine();
	// 	}

	// 	reader.close();
	// 	double[][] finalDataSet = new double[dataSet.size()][numAttributes];

	// 	for (int i = 0; i < dataSet.size(); i++) {
	// 		finalDataSet[i] = dataSet.get(i);
	// 	}

	// 	return finalDataSet;
	// }
}
