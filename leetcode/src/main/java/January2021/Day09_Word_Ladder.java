package January2021;

import java.util.*;

public class Day09_Word_Ladder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";

        ArrayList wordList1 = new ArrayList(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(new Day09_Word_Ladder.Solution().ladderLength(beginWord, endWord, wordList1));

        ArrayList wordList2 = new ArrayList(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        System.out.println(new Day09_Word_Ladder.Solution().ladderLength(beginWord, endWord, wordList2));
    }

    static class Node {
        String word;
        int index;
        HashSet<String> visited;

        public Node (String word, int index, HashSet<String> visited) {
            this.word = word;
            this.index = index;
            this.visited = visited;
        }
    }

    static class Solution {
        Map<String, List<String>> allDictionary;

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if(!wordList.contains(endWord)) return 0;

            allDictionary = new HashMap<>();
            int L = beginWord.length();

            wordList.forEach(
                    word -> {
                        for (int i = 0; i < L; i++) {
                            String newString = word.substring(0, i) + "*" + word.substring(i + 1);
                            List<String> curList = allDictionary.getOrDefault(newString, new ArrayList<>());
                            curList.add(word);
                            allDictionary.put(newString, curList);
                        }
                    });

            Queue<Node> frontQueue = new LinkedList<>();
            Queue<Node> backQueue = new LinkedList<>();

            frontQueue.add(new Node(beginWord, 1, new HashSet<>()));
            backQueue.add(new Node(endWord, 1, new HashSet<>()));

            while (true) {
                if (!frontQueue.isEmpty()) {
                    Node cur = frontQueue.poll();
                    cur.visited.add(cur.word);

                    if (cur.word.equals(endWord)) {
                        return cur.index;
                    }

                    for(int i = 0; i < cur.word.length(); i++) {
                        String newString = cur.word.substring(0, i) + "*" + cur.word.substring(i + 1);

                        if (!allDictionary.containsKey(newString))
                            continue;

                        List<String> candidateList = allDictionary.get(newString);
                        for(String candidate : candidateList) {
                            if (!cur.visited.contains(candidate))
                                frontQueue.add(new Node(candidate, cur.index + 1, cur.visited));
                        }
                    }
                }

                if (!backQueue.isEmpty()) {
                    Node cur = backQueue.poll();
                    cur.visited.add(cur.word);

                    if (cur.word.equals(beginWord)) {
                        return cur.index;
                    }

                    for(int i = 0; i < cur.word.length(); i++) {
                        String newString = cur.word.substring(0, i) + "*" + cur.word.substring(i + 1);

                        if (!allDictionary.containsKey(newString))
                            continue;

                        List<String> candidateList = allDictionary.get(newString);
                        for(String candidate : candidateList) {
                            if (!cur.visited.contains(candidate))
                                frontQueue.add(new Node(candidate, cur.index + 1, cur.visited));
                        }
                    }
                }

                if (frontQueue.isEmpty() && backQueue.isEmpty())
                    break;
            }

            return 0;
        }
    }
}
