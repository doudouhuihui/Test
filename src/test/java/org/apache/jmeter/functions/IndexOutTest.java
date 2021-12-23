package org.apache.jmeter.functions;

import java.util.ArrayList;
import java.util.List;

public class IndexOutTest {
    public static void main(String[] args) {
        String s = substring("123456", -4, 6);
        System.out.println(s);

    }
    public static String substring(String str, int start, int end) {
        if (str == null) {
            return null;
        } else {
            if (end < 0) {
                end += str.length();
            }

            if (start < 0) {
                start += str.length();
            }

            if (end > str.length()) {
                end = str.length();
            }

            if (start > end) {
                return "";
            } else {
                if (start < 0) {
                    start = 0;
                }

                if (end < 0) {
                    end = 0;
                }

                return str.substring(start, end);
            }
        }
    }
}
