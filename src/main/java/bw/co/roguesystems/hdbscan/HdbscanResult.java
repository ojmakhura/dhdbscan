package bw.co.roguesystems.hdbscan;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Data
public class HdbscanResult {
    private int[] labels;
    private HashMap<Integer, ArrayList<Integer>> clusterMap;
    
}
