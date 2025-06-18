class Solution {
    public boolean isValidSudoku(char[][] board) {
    List<List<Set<Character>>> setsList = new ArrayList<>();

    for(int j=0;j<9;j++){
        List<Set<Character>> qList = new ArrayList<>();
        for(int q=0;q<3;q++){
            for(int i=0;i<3;i++){
                char check = board[3*q+i][j];
                //System.out.println("first "+j+" "+q+" "+i +" "+ check);
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
                        // System.out.println("first "+j+" "+q+" "+i+check +" "+ qCheck);
                        // System.out.println(setsList.get(j).get(qCheck-1));
                        // System.out.println(setsList.get(j));
                        // System.out.println(setsList);
                        return false;
                    }
                        
                    qCheck--;    
                }
                int jCheck = j;
                int loop=j%3;
                while(loop>0){
                    if(setsList.get(jCheck-1).get(q).contains(check)){
                        // System.out.println("first "+j+" "+q+" "+i+check);
                        // System.out.println(setsList.get(jCheck-1).get(q));
                        // System.out.println(setsList.get(j));
                        // System.out.println(setsList);
                        return false;
                    }
                    loop--;    
                    jCheck--;
                }
                if(i==0){
                    Set<Character> set = new HashSet<>();
                    set.add(check);
                    // System.out.println(set);
                    // System.out.println(qList);
                    qList.add(q,set);
                    if(q==0)
                    setsList.add(j,qList);
                     
                }
                else {
                    Set<Character> set = setsList.get(j).get(q);
                    //System.out.println(set);
                    if(set.contains(check)){
                        System.out.println("first "+j+" "+q+" "+i+check);
                        return false;
                    }
                    set.add(check);
                    // System.out.println(set);
                    // System.out.println(qList);
                    // qList.add(q,set);
                    // System.out.println(qList);
                    // setsList.add(j,qList);
                    // System.out.println(setsList);
                }
                // if( j==5){
                //     System.out.println(setsList);
                //     System.out.println(setsList.get(j-1).get(q));
                //     System.out.println(setsList.get(j-2).get(q));
                    
                // }
                
                // System.out.println(setsList.get(j).get(q));
                // System.out.println(j+" "+q+ " "+ i);
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
                    // qList.add(q,set);
                    // setsList.add(i,qList);
                }
                 int qCheck =q;
                while(qCheck>0){
                    if(setsList.get(i).get(qCheck-1).contains(check)){
                        //System.out.println("second "+j+" "+q+" "+i+check);
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


// j from 0 to 9
// first loop q=0, i=0 start
// q=0 - i from q*i to q*i+3 while entering check last q set and top j%3 set
// q=1 - i forom q*i to q*i+3 while entering check last q set and top j%3 set
// q=2 - i forom q*i to q*i+3 while entering check last q set and top j%3 set


// i 0 to 9
// q 0 to 3
// j q*j to q*j+3 q last set compare
//