package 베스트앨범;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    class Song implements Comparable{
        int idx;
        int cnt;

        public Song(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }

        public int getIdx() {
            return idx;
        }

        @Override
        public int compareTo(Object o) {
            Song otherSong = (Song) o;

            if (this.cnt < otherSong.cnt) return 1;
            if (this.cnt > otherSong.cnt) return -1;
            if (this.idx < otherSong.idx) return -1;
            return 1;
        }
    }

    public int[] solution(String[] genres, int[] plays) {

        ArrayList<Integer> answer = new ArrayList();
        HashMap<String, Integer> genreCnt = new HashMap();
        HashMap<String, ArrayList<Song>> genreSong = new HashMap();

        for(int i = 0; i < genres.length; i++) {
            if (genreCnt.containsKey(genres[i])) {
                genreCnt.replace(genres[i], genreCnt.get(genres[i]) + plays[i]);
                genreSong.get(genres[i]).add(new Song(i, plays[i]));
            }
            else {
                genreCnt.put(genres[i], plays[i]);
                genreSong.put(genres[i], new ArrayList());
                genreSong.get(genres[i]).add(new Song(i, plays[i]));
            }
        }

        for (String key : genreSong.keySet()) {
            Collections.sort(genreSong.get(key));
        }

        List<Map.Entry<String, Integer>> sortedGenreCnt = genreCnt.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());


        for(Map.Entry<String, Integer> genre : sortedGenreCnt) {
            int cnt = 0;
            while(cnt < 2 && cnt < genreSong.get(genre.getKey()).size()) {
                answer.add(genreSong.get(genre.getKey()).get(cnt).getIdx());
                cnt++;
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        String [] genres = {"classic", "pop", "classic", "classic", "pop"};
        int [] plays = {500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(new Solution().solution(genres, plays)));
    }
}
