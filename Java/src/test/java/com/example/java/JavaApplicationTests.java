package com.example.java;

import com.example.java.Tecent.FileBitCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

@SpringBootTest
class JavaApplicationTests {

    @Test
    void contextLoads() throws IOException {
        // 创建
        File testFile = new File("test.txt");
        testFile.createNewFile();

        final int SIZE = 1024;
        byte[] testBytes = new byte[SIZE];

        int targetOneBits = SIZE / 2;
        for (int i = 0; i < targetOneBits; i++) {
            testBytes[i] = 1;
        }

        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(testFile))) {
            dataOutputStream.write(testBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        FileBitCounter fileBitCounter = new FileBitCounter(testFile);
        Assertions.assertEquals(targetOneBits, fileBitCounter.countBit().intValue());
    }

}
