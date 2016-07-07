package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by v-zhoguo on 7/5/2016.
 */
public class ValidParentheses {
    public boolean isValid_1(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()){
            if (!stack.empty()){
                char recent = stack.peek();
                switch (recent){
                    case '(': if (c == ')'){stack.pop();}else {stack.push(c);} break;
                    case '[': if (c == ']'){stack.pop();}else {stack.push(c);} break;
                    case '{': if (c == '}'){stack.pop();}else {stack.push(c);} break;
                    default: stack.push(c);break;
                }
            }else {
                stack.push(c);
            }
        }
        return stack.empty();
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (char c : s.toCharArray()) {
            if (!stack.empty()) {
                char recent = stack.peek();
                if (map.containsKey(recent) && c== map.get(recent)){
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }else {
                stack.push(c);
            }
        }
        return stack.empty();
    }
    public static void main (String[] args){
        ValidParentheses vp = new ValidParentheses();
        System.out.print(vp.isValid("[]"));
    }
}
