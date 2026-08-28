class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //if strs.length is 1
        if(strs.length == 1){
            List<String> group = new ArrayList<>();
            group.add(strs[0]);
            List<List<String>> x = new ArrayList<>();
            x.add(group);
            return x;
        }

        //unique keys (hashcodes), values are the lists
        HashMap<String, List<String>> ana = new HashMap<>();

        for(int i = 0; i<strs.length; i++){
            int[] alpha = new int[26];
            for(int j = 0; j<strs[i].length(); j++){
                int charCode = (int)(strs[i].charAt(j)) - 97;
                alpha[charCode]++;
            }
            String k = convertAlpha(alpha);
            if(ana.containsKey(k)){
                ana.get(k).add(strs[i]);
            }
            else{
                List<String> group = new ArrayList<>();
                group.add(strs[i]);
                ana.put(k, group);
            }
        
        }
        
        return new ArrayList<>(ana.values());
        
    }

    public String convertAlpha(int[] alpha){
        String a = "";
        for(int i = 0; i<alpha.length; i++){
            a+=alpha[i] + ",";
        }
        return a;
    }
}
