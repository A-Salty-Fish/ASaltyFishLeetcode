package com.example.java.Tecent;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author dzy
 * @title FileBitCounter
 * @projectName Java
 * @description 统计二进制文件中的比特数
 * @date 2021/8/16 16:14
 */
public class FileBitCounter {

    /**
     * 输入文件
     */
    private final File inputFile;

    public FileBitCounter(File file) {
        inputFile = file;
    }

    public BigDecimal countBit() {
        // 初始化结果
        BigDecimal bitResult = BigDecimal.ZERO;
        try {
            // 如果内存够 就全读进来
            byte[] bytes = Files.readAllBytes(inputFile.toPath());
            for (Byte b : bytes) {
                bitResult = bitResult.add(new BigDecimal(Integer.bitCount((int) b)));
            }
            return bitResult;
        } catch (OutOfMemoryError outErr) {
            bitResult = BigDecimal.ZERO;
            // todo test
            // 内存不够 则每次只读取 1024 byte
            // 缓冲区大小
            int bufferSize = 1 << 10;
            byte[] bytes = new byte[bufferSize];
            try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(inputFile))) {
                // 文件的 byte 数
                long fileBytes = inputFile.length();
                // 当前偏移
                int start = 0;
                // 这次读入的数量，如果小于缓冲区大小说明到了文件尾
                int curInputSize;
                while ((curInputSize = dataInputStream.read(bytes, start, bufferSize)) == bufferSize) {
                    for (Byte b : bytes) {
                        bitResult = bitResult.add(new BigDecimal(Integer.bitCount((int) b)));
                    }
                    start += bufferSize;
                }
                // 读入尾部不满缓冲区部分
                for (int i = 0; i < curInputSize; i++) {
                    bitResult = bitResult.add(new BigDecimal(Integer.bitCount((int) bytes[i])));
                }
            } catch (IOException ioErr) {
                ioErr.printStackTrace();
            }
        } catch (IOException ioErr) {
            ioErr.printStackTrace();
        }
        return bitResult;
    }

}
