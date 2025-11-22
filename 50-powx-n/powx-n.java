class Solution {
    public double myPow(double x, int n) {
        double result = 1;
        long temp = n;
        if(n==0) return 1;
        if(temp<0){
            x = 1/x;
            temp = -temp;
        }
        while(temp>0){

            if(temp==2){
                x = x*x;
                break;
            }
            else if(temp==1){
                break;
            }
            else if(temp%2==0){
                x = x*x;
                temp = temp/2;
            }
            else {
                result *= x;
                temp--;
            }
        }

        return result*x;
        
    }
}