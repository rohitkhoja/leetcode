class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] dirs = path.split("/");
        String result = "";
       
        for(String dir: dirs){
            if(dir.equals("") || dir.equals(".")) continue;
            else if(dir.equals("..")) {
                if(stack.isEmpty()) continue;
                else stack.pop();
            }
            else {
              stack.push(dir);
            }
        }
        while(!stack.isEmpty()){
            result = "/"+stack.pop()+result;

        }
        if(result.length()==0) return "/";
        return result;
    }
}