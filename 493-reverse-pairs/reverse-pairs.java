
class Solution {

    public int merge(int[] nums, int l, int m, int r){

        int n1 = m-l+1;
        int n2 = r-m;
        int[] num1 = new int[n1];
        int[] num2 = new int[n2];
        int count = 0;

        for(int i=0;i<n1;i++) num1[i] = nums[l+i];
        for(int j=0;j<n2;j++) num2[j] = nums[m+1+j];

        

        for(int j=0;j<n2;j++){
            int i=0;
            while(i<n1){
                if(num1[i]> (long) 2*num2[j]){
                    count += n1-i;
                    break;
                }
                i++;
            }
            if(i==n1) break;
        }

        int i=0;
        int j=0;

        while(i<n1 && j<n2){
            if(num1[i]>num2[j]){
                // int k=i;
                // while(k<n1){
                //     if(num1[k] > 2*num2[j]) {
                //         count += n1-k;
                //         break;
                //     }
                //     k++;
                // }
                nums[l+i+j] = num2[j];
                j++;
                
            }
            else{
                nums[l+i+j] = num1[i];
                i++;
            }
        }

        while(i<n1){
            nums[l+i+j] = num1[i];
            i++;
        }

        while(j<n2){
            nums[l+i+j] = num2[j];
            j++;
        }


        return count;
    }

    public int mergeSort(int[] nums, int l, int r){
        if(l>=r) return 0;

        int m = (l+r)/2;
        int n1 = mergeSort(nums, l, m);
        int n2 = mergeSort(nums, m+1, r);
        //System.out.println(n1 +" "+n2+" "+l +" "+m+ " "+r);
        return n1+n2+merge(nums, l, m, r);
        
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
}