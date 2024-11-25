import java.util.*;

public class ReconstructItinerary {

    public static void main(String[] args) {
        ReconstructItinerary main = new ReconstructItinerary();
        main.testFindItinerary();
    }

    public void testFindItinerary() {
        // Test case 1: Simple itinerary
        List<List<String>> tickets1 = new ArrayList<>();
        tickets1.add(Arrays.asList("JFK", "SFO"));
        tickets1.add(Arrays.asList("SFO", "LAX"));
        List<String> result1 = findItinerary(tickets1);
        System.out.println("Test case 1: " + result1);

        // Test case 2: Multiple destinations from a single airport
        List<List<String>> tickets2 = new ArrayList<>();
        tickets2.add(Arrays.asList("JFK", "SFO"));
        tickets2.add(Arrays.asList("JFK", "ATL"));
        tickets2.add(Arrays.asList("SFO", "ATL"));
        tickets2.add(Arrays.asList("ATL", "JFK"));
        tickets2.add(Arrays.asList("ATL", "SFO"));
        List<String> result2 = findItinerary(tickets2);
        System.out.println("Test case 2: " + result2);

        // Test case 3: Circular itinerary
        List<List<String>> tickets3 = new ArrayList<>();
        tickets3.add(Arrays.asList("JFK", "SFO"));
        tickets3.add(Arrays.asList("SFO", "JFK"));
        List<String> result3 = findItinerary(tickets3);
        System.out.println("Test case 3: " + result3);

        // Test case 5: Complex itinerary with multiple valid paths
        List<List<String>> tickets5 = new ArrayList<>();
        tickets5.add(Arrays.asList("JFK", "KUL"));
        tickets5.add(Arrays.asList("JFK", "NRT"));
        tickets5.add(Arrays.asList("NRT", "JFK"));
        List<String> result5 = findItinerary(tickets5);
        System.out.println("Test case 5: " + result5);

        // Test case 6: Complex itinerary with multiple valid paths
        List<List<String>> tickets6 = new ArrayList<>();
        tickets6.add(Arrays.asList("JFK", "NRT"));
        tickets6.add(Arrays.asList("JFK", "KUL"));
        tickets6.add(Arrays.asList("KUL", "JFK"));
        List<String> result6 = findItinerary(tickets6);
        System.out.println("Test case 5: " + result6);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, SortedSet<String>> map = new HashMap<>();

        for (List<String> ticket : tickets) {
            if (map.containsKey(ticket.get(0))) {
                map.get(ticket.get(0)).add(ticket.get(1));
            } else {
                SortedSet<String> set = new TreeSet<>();
                set.add(ticket.get(1));
                map.put(ticket.get(0), set);
            }
        }

        List<String> result = new ArrayList<>();

        helper("JFK", map, result);

        return result.reversed();
    }

    private void helper(String airport, Map<String, SortedSet<String>> map, List<String> result) {
        SortedSet<String> dest = map.get(airport);

        while (dest != null && !dest.isEmpty()) {
            String next = dest.removeFirst();
            helper(next, map, result);
        }

        result.add(airport);
    }
}