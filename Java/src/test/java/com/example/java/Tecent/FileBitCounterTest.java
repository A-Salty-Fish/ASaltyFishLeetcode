package com.example.java.Tecent;

import com.example.java.Tecent.FileBitCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author dzy
 * @title: FileBitCounterTest
 * @projectName Java
 * @description: TODO
 * @date 2021/8/16 16:53
 */
@SpringBootTest
public class FileBitCounterTest {
    @Test
    void testFileBitCount() throws IOException {
        // 创建测试文件
        File testFile = new File("test.txt");
        testFile.createNewFile();
        // 指定测试的输入大小
        final int SIZE = 1024;
        byte[] testBytes = new byte[SIZE];
        // 指定写入 1 的数目
        int targetOneBits = SIZE / 2;
        for (int i = 0; i < targetOneBits; i++) {
            testBytes[i] = 1;
        }
        // 写入测试文件
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(testFile))) {
            dataOutputStream.write(testBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 验证结果
        FileBitCounter fileBitCounter = new FileBitCounter(testFile);
        System.out.println(fileBitCounter.countBit());
        Assertions.assertEquals(targetOneBits, fileBitCounter.countBit().intValue());
    }
}
