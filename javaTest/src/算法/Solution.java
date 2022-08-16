package 算法;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<String, Deque<Integer>> scope = new HashMap<String, Deque<Integer>>();

    public int evaluate(String expression) {
        Deque<Deque<String>> vars = new ArrayDeque<Deque<String>>();
        int start = 0, n = expression.length();
        Deque<Expr> stack = new ArrayDeque<Expr>();
        Expr cur = new Expr(ExprStatus.VALUE);
        while (start < n) {
            if (expression.charAt(start) == ' ') {
                start++; // 去掉空格
                continue;
            }
            if (expression.charAt(start) == '(') {
                start++; // 去掉左括号
                stack.push(cur);
                cur = new Expr(ExprStatus.NONE);
                continue;
            }
            StringBuffer sb = new StringBuffer();
            if (expression.charAt(start) == ')') { // 本质上是把表达式转成一个 token
                start++; // 去掉右括号
                if (cur.status == ExprStatus.LET2) {
                    sb = new StringBuffer(Integer.toString(cur.value));
                    for (String var : vars.peek()) { // 清除作用域
                        scope.get(var).pop();
                    }
                    vars.pop();
                } else if (cur.status == ExprStatus.ADD2) {
                    sb = new StringBuffer(Integer.toString(cur.e1 + cur.e2));
                } else {
                    sb = new StringBuffer(Integer.toString(cur.e1 * cur.e2));
                }
                cur = stack.pop(); // 获取上层状态
            } else {
                while (start < n && expression.charAt(start) != ' ' && expression.charAt(start) != ')') {
                    sb.append(expression.charAt(start));
                    start++;
                }
            }
            String token = sb.toString();
            switch (cur.status.toString()) {
                case "VALUE":
                    cur.value = Integer.parseInt(token);
                    cur.status = ExprStatus.DONE;
                    break;
                case "NONE":
                    if ("let".equals(token)) {
                        cur.status = ExprStatus.LET;
                        vars.push(new ArrayDeque<String>()); // 记录该层作用域的所有变量, 方便后续的清除
                    } else if ("add".equals(token)) {
                        cur.status = ExprStatus.ADD;
                    } else if ("mult".equals(token)) {
                        cur.status = ExprStatus.MULT;
                    }
                    break;
                case "LET":
                    if (expression.charAt(start) == ')') { // let 表达式的最后一个 expr 表达式
                        cur.value = calculateToken(token);
                        cur.status = ExprStatus.LET2;
                    } else {
                        cur.var = token;
                        vars.peek().push(token); // 记录该层作用域的所有变量, 方便后续的清除
                        cur.status = ExprStatus.LET1;
                    }
                    break;
                case "LET1":
                    scope.putIfAbsent(cur.var, new ArrayDeque<Integer>());
                    scope.get(cur.var).push(calculateToken(token));
                    cur.status = ExprStatus.LET;
                    break;
                case "ADD":
                    cur.e1 = calculateToken(token);
                    cur.status = ExprStatus.ADD1;
                    break;
                case "ADD1":
                    cur.e2 = calculateToken(token);
                    cur.status = ExprStatus.ADD2;
                    break;
                case "MULT":
                    cur.e1 = calculateToken(token);
                    cur.status = ExprStatus.MULT1;
                    break;
                case "MULT1":
                    cur.e2 = calculateToken(token);
                    cur.status = ExprStatus.MULT2;
                    break;
            }
        }
        return cur.value;
    }

    public int calculateToken(String token) {
        if (Character.isLowerCase(token.charAt(0))) {
            return scope.get(token).peek();
        } else {
            return Integer.parseInt(token);
        }
    }
}

enum ExprStatus {
    VALUE,     // 初始状态
    NONE,      // 表达式类型未知
    LET,       // let 表达式
    LET1,      // let 表达式已经解析了 vi 变量
    LET2,      // let 表达式已经解析了最后一个表达式 expr
    ADD,       // add 表达式
    ADD1,      // add 表达式已经解析了 e1 表达式
    ADD2,      // add 表达式已经解析了 e2 表达式
    MULT,      // mult 表达式
    MULT1,     // mult 表达式已经解析了 e1 表达式
    MULT2,     // mult 表达式已经解析了 e2 表达式
    DONE       // 解析完成
}

class Expr {
    ExprStatus status;
    String var; // let 的变量 vi
    int value; // VALUE 状态的数值，或者 LET2 状态最后一个表达式的数值
    int e1, e2; // add 或 mult 表达式的两个表达式 e1 和 e2 的数值

    public Expr(ExprStatus s) {
        status = s;
    }
}