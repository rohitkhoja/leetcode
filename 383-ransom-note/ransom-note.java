class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Integer, Integer> magazineMap = new HashMap<>();
        Map<Integer, Integer> ransomNoteMap = new HashMap<>();

        magazine.chars().forEach(ch -> magazineMap.put(ch,magazineMap.getOrDefault(ch,0)+1));
        ransomNote.chars().forEach(ch -> ransomNoteMap.put(ch, ransomNoteMap.getOrDefault(ch,0)+1));

        return !ransomNoteMap.entrySet().stream().anyMatch(
            entry -> magazineMap.getOrDefault(entry.getKey(),0)<entry.getValue()
        );
    }
}