class Solution {
    Map<Character, List<Character>> map;
    public List<String> letterCombinations(String digits) {
        map = new HashMap<>();
        map.put('2',new ArrayList<>(List.of('a','b','c')));
        map.put('3',new ArrayList<>(List.of('d','e','f')));
        map.put('4',new ArrayList<>(List.of('g','h','i')));
        map.put('5',new ArrayList<>(List.of('j','k','l')));
        map.put('6',new ArrayList<>(List.of('m','n','o')));
        map.put('7',new ArrayList<>(List.of('p','q','r','s')));
        map.put('8',new ArrayList<>(List.of('t','u','v')));
        map.put('9',new ArrayList<>(List.of('w','x','y','z')));
        List<String> result = new ArrayList<>();
        addString(digits, 0, result, "");
        return result;
        
    }

    public void addString(String digits, int position, List<String> result, String word){
        if(position==digits.length()) {
            result.add(word);
            return;
        }
        for(char ch: map.get(digits.charAt(position))){
            addString(digits, position+1, result, word+ch);
        }

    }


}