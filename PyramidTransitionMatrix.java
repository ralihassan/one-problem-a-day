
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PyramidTransitionMatrix {
    public boolean pyramidTransition(String bottom, List<String> allowed) {

        Map<String, List<Character>> cache = new HashMap<>();

        for (String value : allowed) {
            String key = value.substring(0,2);
            cache.computeIfAbsent(key, k -> new ArrayList<Character>());
            cache.get(key).add(value.charAt(2));
        }
        
        return bkt(bottom, cache, 0, "");
    }

    private boolean bkt(String bottom,
                        Map<String, List<Character>> cache,
                        int idx,
                        String next) {

        if (bottom.length() == 1) return true;

        if (idx == bottom.length() - 1) {
            return bkt(next, cache, 0, "");
        }

        String base = bottom.substring(idx, idx + 2);
        if (!cache.containsKey(base)) return false;

        for (char c : cache.get(base)) {
            if (bkt(bottom, cache, idx + 1, next + c)) {
                return true;
            }
        }

        return false;
    }
}