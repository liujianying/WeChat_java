package com.tencent.c.f;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class f {
    public static String Y(File file) {
        Throwable th;
        String str = "";
        Closeable closeable = null;
        Closeable bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                str = bufferedReader.readLine();
                if (str != null) {
                    b(bufferedReader);
                } else {
                    b(bufferedReader);
                }
            } catch (Throwable th2) {
                th = th2;
                closeable = bufferedReader;
                if (closeable != null) {
                    b(closeable);
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (closeable != null) {
                b(closeable);
            }
            throw th;
        }
        return str;
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }

    public static byte[] Z(File file) {
        Throwable th;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        byte[] bArr;
        try {
            randomAccessFile2 = new RandomAccessFile(file, "r");
            try {
                long length = randomAccessFile2.length();
                int i = (int) length;
                if (((long) i) != length) {
                    throw new IOException("");
                }
                bArr = new byte[i];
                randomAccessFile2.readFully(bArr);
                try {
                    randomAccessFile2.close();
                } catch (IOException e) {
                }
                return bArr;
            } catch (Throwable th2) {
                try {
                    bArr = new byte[0];
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (IOException e2) {
                        }
                    }
                    return bArr;
                } catch (Throwable th3) {
                    th = th3;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e32) {
                }
            }
            throw th;
        }
    }
}
