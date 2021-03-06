package com.example.java.bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dzy
 * @title: Solutions
 * @projectName Java
 * @description: TODO
 * @date 2021/8/16 14:26
 */
public class Solutions {
    /**
     * 504 七进制数
      */
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

    /**
     * 405. 数字转换为十六进制数
     * @param num
     * @return
     */
    public String toHex(int num) {
        char[] dig2Hex = new char[16];
        for (int i = 0; i < 10 ; i++) {
            dig2Hex[i] = (char) ('0' + i);
        }
        for (int i = 10; i < 16 ; i++) {
            dig2Hex[i] = (char) ('a' + i - 10);
        }
        long n = num;
        if (n < 0) {
            n += (1L << 32L);
        }
        StringBuilder result = new StringBuilder(8);
        do {
            result.append(dig2Hex[(int)(n%16L)]);
            n /= 16;
        } while(n != 0);
        return result.reverse().toString();
    }

    /**
     * 191. 位1的个数
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            n &= n - 1;
            result++;
        }
        return result;
    }

    /**
     * 190. 颠倒二进制位
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int ans = 0;
        for (int bitsSize = 31; n != 0; n = n >>> 1, bitsSize--) {
            ans |= (n & 1) << bitsSize;
        }
        return ans;
    }

    /**
     * 371. 两整数之和
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        int carry = (a&b)<<1;
        int result = a^b;
        while (carry!=0) {
            int tmp = result & carry;
            result = result ^ carry;
            carry = tmp << 1;
        }
        return result;
    }

    /**
     * 89. 格雷编码
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        int powN = 1 << n;
        for (int i = 0; i < powN; ++i) {
            result.add(i^(i>>1));
        }
        return result;
    }
}
