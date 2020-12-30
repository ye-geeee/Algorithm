import java.util.Arrays;
import java.util.Comparator;

public class Day6_QueueReconstructionByHeight {
    class Solution {
        public int[][] reconstructQueue(int[][] people) {

            Arrays.sort(people, new Comparator<int[]>(){
                @Override
                public int compare(final int[] o1, final int[] o2) {
                    if(o1[0] < o2[0]) return -1;
                    else if((o1[0] == o2[0]) && (o1[1] > o2[1])) return -1;
                    else return 1;
                }
            });

            int res[][] = new int[people.length][2];
            boolean isFilled[] = new boolean[people.length];

            for(int[] person : people){
                int cnt = 0, index = 0;
                for(index = 0; index < people.length; index++){
                    if(cnt == person[1] && !isFilled[index]){
                        break;
                    }
                    if(isFilled[index]) continue;
                    else cnt++;
                }
                res[index] = person;
                isFilled[index] = true;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int tc [][] = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        Solution sol = new Day6_QueueReconstructionByHeight().new Solution();
        System.out.println(sol.reconstructQueue(tc));
    }
}
