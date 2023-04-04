import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
	Map<String, List<String>> adjacencyList = new HashMap<>();

        void readFile(String fileName) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(" -> ");
				String src = parts[0];
				List<String> destList = new ArrayList<>();
				for (int i = 1; i < parts.length; i++) {
					destList.add(parts[i]);
				}
				adjacencyList.put(src, destList);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void printAdjacencyList() {
		System.out.println("Komsuluk Listesi:");
		adjacencyList.forEach((src, destList) -> System.out.println(src + " -> " + destList));
		System.out.println();
	}

	void printInOutDegrees(String code) {
		int outDegree = adjacencyList.getOrDefault(code, new ArrayList<>()).size();
		int inDegree = 0;
		for (List<String> destList : adjacencyList.values()) {
			if (destList.contains(code)) {
				inDegree++;
			}
		}
		System.out.println("Giris derecesi: " + inDegree + ", cikis derecesi: " + outDegree);
	}

	int totalEdges() {
		return adjacencyList.values().stream().mapToInt(List::size).sum();
	}

	void printDestinations(String code) {
		List<String> destinations = adjacencyList.getOrDefault(code, new ArrayList<>());
		System.out.println("Plakadan gidilen sehirler: " + destinations);
	}

	void printSources(String code) {
		List<String> sources = new ArrayList<>();
		adjacencyList.forEach((src, destList) -> {
			if (destList.contains(code)) {
				sources.add(src);
			}
		});
		System.out.println("Plakadan gelinen sehirler: " + sources);
	}
}