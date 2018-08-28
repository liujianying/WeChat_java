package com.tencent.mm.c;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.zip.ZipException;

public final class c {
    private static final k bxs = new k(84298576);
    private static final k bxt = new k(50613072);
    private static int bxu = 0;
    private static final k bxv = new k(101010256);

    private static byte[] b(RandomAccessFile randomAccessFile) {
        int i = 1;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] bytes = bxv.getBytes();
        byte read = randomAccessFile.read();
        while (read != (byte) -1) {
            if (read == bytes[0] && randomAccessFile.read() == bytes[1] && randomAccessFile.read() == bytes[2] && randomAccessFile.read() == bytes[3]) {
                break;
            }
            length--;
            randomAccessFile.seek(length);
            read = randomAccessFile.read();
        }
        i = 0;
        if (i == 0) {
            System.err.println("archive is not a ZIP archive");
            throw new ZipException("archive is not a ZIP archive");
        }
        randomAccessFile.seek((length + 16) + 4);
        if (((long) bxu) != (length + 16) + 4) {
            bxu = (int) ((length + 16) + 4);
        }
        byte[] bArr = new byte[2];
        randomAccessFile.readFully(bArr);
        System.err.println("readComment:length bytes data = " + z(bArr));
        i = new l(bArr).value;
        if (i == 0) {
            return null;
        }
        bArr = new byte[i];
        randomAccessFile.read(bArr);
        return bArr;
    }

    public static void c(File file, String str) {
        Throwable th;
        byte[] bArr = null;
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                byte[] b = b(randomAccessFile);
                if (b != null) {
                    ByteBuffer wrap = ByteBuffer.wrap(b);
                    bxs.getBytes();
                    byte[] bArr2 = new byte[4];
                    wrap.get(bArr2);
                    if (bxs.equals(new k(bArr2))) {
                        bArr = b;
                    } else if (bxt.equals(new k(bArr2))) {
                        bArr = b;
                    } else {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byteArrayOutputStream.write(bxt.getBytes());
                        byteArrayOutputStream.write(new l(b.length).getBytes());
                        byteArrayOutputStream.write(b);
                        bArr = byteArrayOutputStream.toByteArray();
                    }
                }
                a aVar = new a((byte) 0);
                aVar.A(bArr);
                aVar.bxw.setProperty("apkSecurityCode", str);
                b = aVar.uu();
                randomAccessFile.seek((long) bxu);
                randomAccessFile.write(new l(b.length).getBytes());
                randomAccessFile.write(b);
                randomAccessFile.setLength((long) ((b.length + bxu) + 2));
                System.err.println("file length is = " + randomAccessFile.length());
                randomAccessFile.close();
                System.err.println("exit writeSecurityCode");
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                System.err.println("exit writeSecurityCode");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            System.err.println("exit writeSecurityCode");
            throw th;
        }
    }

    public static String p(File file) {
        Throwable th;
        String str = null;
        System.err.println("enter getSecurityCode");
        System.err.println("apkFile filename:" + file.getName());
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                byte[] b = b(randomAccessFile);
                if (b == null) {
                    System.err.println("null == readComment");
                    System.err.println("exit");
                    randomAccessFile.close();
                    System.err.println("exit getSecurityCode");
                } else {
                    a aVar = new a((byte) 0);
                    aVar.A(b);
                    str = aVar.bxw.getProperty("apkSecurityCode");
                    randomAccessFile.close();
                    System.err.println("exit getSecurityCode");
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                System.err.println("exit getSecurityCode");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            System.err.println("exit getSecurityCode");
            throw th;
        }
    }

    private static String z(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            stringBuilder.append(bArr[i]);
            stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }
}
