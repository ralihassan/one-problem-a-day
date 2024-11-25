import java.util.*;

public class CourseScheduleTwo {

    public static void main(String[] args) {
        CourseScheduleTwo main = new CourseScheduleTwo();
        main.testFindOrder();
    }

    public void testFindOrder() {
        // Test case 1: No prerequisites
        int numCourses1 = 4;
        int[][] prerequisites1 = {};
        int[] result1 = findOrder(numCourses1, prerequisites1);
        System.out.println("Test case 1: " + Arrays.toString(result1));

        // Test case 2: Simple linear dependency
        int numCourses2 = 2;
        int[][] prerequisites2 = { { 1, 0 } };
        int[] result2 = findOrder(numCourses2, prerequisites2);
        System.out.println("Test case 2: " + Arrays.toString(result2));

        // Test case 3: Multiple dependencies
        int numCourses3 = 4;
        int[][] prerequisites3 = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        int[] result3 = findOrder(numCourses3, prerequisites3);
        System.out.println("Test case 3: " + Arrays.toString(result3));

        // Test case 4: Cycle in prerequisites
        int numCourses4 = 2;
        int[][] prerequisites4 = { { 1, 0 }, { 0, 1 } };
        int[] result4 = findOrder(numCourses4, prerequisites4);
        System.out.println("Test case 4: " + Arrays.toString(result4));

        // Test case 5: Complex graph with multiple valid orders
        int numCourses5 = 6;
        int[][] prerequisites5 = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 4, 1 }, { 5, 2 }, { 5, 3 } };
        int[] result5 = findOrder(numCourses5, prerequisites5);
        System.out.println("Test case 5: " + Arrays.toString(result5));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            map.put(i, new HashSet<>());
            inDegree.put(i, 0);
        }

        for (int prerequisite[] : prerequisites) {
            map.get(prerequisite[1]).add(prerequisite[0]);
            inDegree.put(prerequisite[0], inDegree.get(prerequisite[0]) + 1);
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for (Integer i : inDegree.keySet()) {
            if (inDegree.get(i) == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int i = queue.poll();
            list.add(i);
            for (int temp : map.get(i)) {
                inDegree.put(temp, inDegree.get(temp) - 1);
                if (inDegree.get(temp) == 0) {
                    queue.add(temp);
                }
            }
        }

        if (list.size() != inDegree.size()) {
            return new int[] {};
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}