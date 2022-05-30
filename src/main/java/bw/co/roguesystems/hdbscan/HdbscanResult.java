package bw.co.roguesystems.hdbscan;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class HdbscanResult {

    private int minPts;
    private int[] labels;
    private HashMap<Integer, ArrayList<Integer>> clusterMap;

    public HdbscanResult() {
    }

    public HdbscanResult(int minPts, int[] labels, HashMap<Integer, ArrayList<Integer>> clusterMap) {
        this.minPts = minPts;
        this.labels = labels;
        this.clusterMap = clusterMap;
    }

    public int getMinPts() {
        return minPts;
    }

    public void setMinPts(int minPts) {
        this.minPts = minPts;
    }

    public int[] getLabels() {
        return labels;
    }

    public void setLabels(int[] labels) {
        this.labels = labels;
    }

    public HashMap<Integer, ArrayList<Integer>> getClusterMap() {
        return clusterMap;
    }

    public void setClusterMap(HashMap<Integer, ArrayList<Integer>> clusterMap) {
        this.clusterMap = clusterMap;
    }
}
