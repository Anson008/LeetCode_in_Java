package dsa.MonotonicStack;

import java.util.LinkedList;

public class LC409 {
    public String removeKdigits(String num, int k) {
        if (num.length() == k)
            return "0";

        StringBuilder sb = new StringBuilder();
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < num.length(); ++i) {
            while (k > 0 && !stack.isEmpty() && stack.getLast() > num.charAt(i)) {
                stack.pollLast();
                --k;
            }
            stack.addLast(num.charAt(i));
        }

        while (k-- > 0)
            stack.pollLast();

        for (final char c : stack) {
            if (c == '0' && sb.isEmpty())
                continue;
            sb.append(c);
        }

        return sb.isEmpty() ? "0" : sb.toString();
    }
}
