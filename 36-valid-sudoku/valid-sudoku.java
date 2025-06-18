class Solution {
    public boolean isValidSudoku(char[][] board) {
    List<List<Set<Character>>> setsList = new ArrayList<>();

    for(int j=0;j<9;j++){
        List<Set<Character>> qList = new ArrayList<>();
        for(int q=0;q<3;q++){
            for(int i=0;i<3;i++){
                char check = board[3*q+i][j];
                if(check=='.') {
                    if(i==0){
                        Set<Character> set = new HashSet<>();
                        qList.add(q,set);
                        if(q==0)
                        setsList.add(j,qList);
                    }
                    continue;
                }
                
                int qCheck = q;
                while(qCheck>0){
                    if(setsList.get(j).get(qCheck-1).contains(check)){
                        return false;
                    }
                        
                    qCheck--;    
                }
                int jCheck = j;
                int loop=j%3;
                while(loop>0){
                    if(setsList.get(jCheck-1).get(q).contains(check)){
                        return false;
                    }
                    loop--;    
                    jCheck--;
                }
                if(i==0){
                    Set<Character> set = new HashSet<>();
                    set.add(check);
                    qList.add(q,set);
                    if(q==0)
                    setsList.add(j,qList);
                     
                }
                else {
                    Set<Character> set = setsList.get(j).get(q);
                    if(set.contains(check)){
                        return false;
                    }
                    set.add(check);
                }
            }

        }
       
    }
        
            

    setsList.clear();
    for(int i=0;i<9;i++){
        List<Set<Character>> qList = new ArrayList<>();
        for(int q=0;q<3;q++){
            
            for(int j=0;j<3;j++){
                char check = board[i][3*q+j];
                if(check=='.') {
                    if(j==0){
                        Set<Character> set = new HashSet<>();
                        qList.add(q,set);
                        if(q==0)
                        setsList.add(i,qList);
                    }
                    continue;
                }
                if(j==0){
                    Set<Character> set = new HashSet<>();
                    set.add(check);
                    qList.add(q,set);
                    if(q==0)
                    setsList.add(i,qList);
                }
                else {
                    Set<Character> set = setsList.get(i).get(q);
                    set.add(check);
                }
                 int qCheck =q;
                while(qCheck>0){
                    if(setsList.get(i).get(qCheck-1).contains(check)){
                        return false;
                    }
                    qCheck--;  
                }
                
            }
           
        }
    }
        
            
    return true;

    }
}


