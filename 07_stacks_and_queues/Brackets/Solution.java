import java.util.Stack;

class Solution {
    public int solution(String S) {
        return isProperlyNested(S);
    }

    private int isProperlyNested(String s) {
        Stack<Character> helperStack = new Stack<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '{':
                case '(':
                case '[':
                    helperStack.push(c);
                    break;
                case '}':
                    if (helperStack.empty()) return 0;
                    if (helperStack.pop() != '{') return 0;
                    break;
                case ')':
                    if (helperStack.empty()) return 0;
                    if (helperStack.pop() != '(') return 0;
                    break;
                case ']':
                    if (helperStack.empty()) return 0;
                    if (helperStack.pop() != '[') return 0;
                    break;
            }
        }

        return helperStack.empty() ? 1 : 0;
    }
}
