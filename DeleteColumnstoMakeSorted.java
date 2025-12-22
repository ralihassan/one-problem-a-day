class DeleteColumnstoMakeSorted {
    public int minDeletionSize(String[] strs) {
        int size = strs[0].length();
        int res = 0;

        for (int i=0; i<size; i++) {
            char c = '0';
            for (int j=0; j<strs.length; j++) {
                if ( c > strs[j].charAt(i)) {
                    res++;
                    break;
                }
                c = strs[j].charAt(i);
            }
        }
        
        return res;
    }
}