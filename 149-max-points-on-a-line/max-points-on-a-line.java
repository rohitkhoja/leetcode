class Solution {
    public int maxPoints(int[][] points) {
        Map<Double, Integer> map;
        int[] result = new int[points.length];
        if(points.length<3) return points.length;
        for(int i=0;i<points.length;i++){
            map = new HashMap<>();
            for(int j=i+1; j<points.length;j++){
                double slope = 0;
                if(i==j)
                    continue;
                if(points[i][1]-points[j][1]==0){
                    slope = Double.MAX_VALUE;
                }
                else if(points[i][0]-points[j][0]==0){
                    slope = 0;
                }
                else
                    slope = (double) (points[i][0]-points[j][0])/(points[i][1]-points[j][1]);

                map.put(slope, map.getOrDefault(slope, 0)+1);
                result[i] = Math.max(map.get(slope), result[i]);
            }
        }
        int rs = 0;
        for(int i=0;i<result.length;i++)
            rs = Math.max(rs, result[i]);

        return rs+1;
    }
}