package com.example.java.bit;

import java.util.Arrays;

/**
 * @author dzy
 * @title: Solutions
 * @projectName Java
 * @description: TODO
 * @date 2021/8/16 14:26
 */
public class Solutions {
    // 504 七进制数
    public String convertToBase7(int num) {
        StringBuilder result = new StringBuilder(64);
        boolean isNegtive = false;
        if (num < 0) {
            isNegtive = true;
            num = -num;
        }
        do {
            result.append((char) ((num % 7) + '0'));
            num /= 7;
        }
        while(num != 0 );
        if (isNegtive) {
            result.append('-');
        }
        return result.reverse().toString();
    }
}
