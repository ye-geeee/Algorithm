package January2021;

import java.util.Stack;

public class Day20_Valiid_Parentheses {
    public static void main(String[] args) {
        System.out.println(new Day20_Valiid_Parentheses.Solution().isValid("[](){}"));
    }

    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                switch (s.charAt(i)) {
                    case '(':
                    case '[':
                    case '{':
                        stack.push(s.charAt(i));
                        break;
                    case ')':
                        if (stack.isEmpty() || !stack.pop().equals('('))
                            return false;
                        break;
                    case ']':
                        if (stack.isEmpty() || !stack.pop().equals('['))
                            return false;
                        break;
                    case '}':
                        if (stack.isEmpty() || !stack.pop().equals('{'))
                            return false;
                        break;
                }
            }

            return stack.isEmpty();
        }
    }
}
