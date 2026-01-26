class Solution {

    class Element{
        int position;
        int speed;
        double time;
        public Element(int position, int speed, double time){
            this.position = position;
            this.speed = speed;
            this.time = time;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        
        PriorityQueue<Element> pq = new PriorityQueue<>((a,b)-> Integer.compare(b.position,a.position));
        int result = 0;
        for(int i=0;i<n;i++){
            pq.add(new Element(position[i], speed[i],(double)(target - position[i])/speed[i]));
        }

        while(!pq.isEmpty()){
            Element e1 = pq.poll();

            if(!pq.isEmpty()){
                Element e2 = pq.poll();
                if(e1.time>=e2.time){
                    pq.add(e1);
                }
                else{
                    pq.add(e2);
                    result++;
                }
            }
            else result++;
            
        }
        return result;
    }
}