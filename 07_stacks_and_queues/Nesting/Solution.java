class Solution {
    public int solution(String S) {
        return isProperlyNested(S);
    }

    private int isProperlyNested(String s) {
        int opened = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                opened++;
            } else if (opened == 0) {
                return 0;
            } else {
                opened--;
            }
        }

        return opened == 0 ? 1 : 0;
    }
}
