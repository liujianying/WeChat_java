package com.tencent.mm.c;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

public final class a {
    public a bxg;
    public b bxh = null;

    public static class a {
        static final long bxi = ((long) "Micromsg".hashCode());
        public int bxj = 0;

        public a(int i) {
            this.bxj = i;
        }

        public static a y(byte[] bArr) {
            if (bArr.length == 8) {
                long j = 0;
                for (int i = 0; i < bArr.length; i++) {
                    j |= ((long) (bArr[i] & b.CTRL_BYTE)) << (i * 8);
                }
                if ((j >> 32) == bxi) {
                    return new a((int) j);
                }
            }
            return null;
        }

        static byte[] al(long j) {
            byte[] bArr = new byte[8];
            for (int i = 0; i < 8; i++) {
                bArr[i] = (byte) ((int) ((j >> (i * 8)) & 255));
            }
            return bArr;
        }
    }

    public a(b bVar) {
        this.bxh = bVar;
    }

    public final int o(File file) {
        try {
            if (cD(file.getAbsolutePath()) != null) {
                System.out.println("Error: duplicate append apk external info!");
                return -1;
            }
            byte[] toByteArray = this.bxh.toByteArray();
            byte[] al = a.al((a.bxi << 32) | ((long) new a(toByteArray.length).bxj));
            byte[] bArr = new byte[]{(byte) ((toByteArray.length + 8) % 256), (byte) ((toByteArray.length + 8) / 256)};
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(file.length() - 2);
            randomAccessFile.write(bArr);
            randomAccessFile.close();
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write(toByteArray);
            fileOutputStream.write(al);
            fileOutputStream.flush();
            fileOutputStream.close();
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    public static a cD(String str) {
        int i = 0;
        if (str != null) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    i = (int) file.length();
                }
            } catch (Exception e) {
                return null;
            }
        }
        if (i < 8) {
            return null;
        }
        a y = a.y(f(str, i - 8, 8));
        if (y == null || y.bxj < 0) {
            return null;
        }
        b bVar = new b();
        bVar.aG(f(str, (i - y.bxj) - 8, y.bxj));
        a aVar = new a(bVar);
        aVar.bxg = y;
        return aVar;
    }

    public static boolean cE(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        a cD = cD(str);
        if (cD == null || cD.bxh == null) {
            return false;
        }
        try {
            byte[] bArr = new byte[]{(byte) 0, (byte) 0};
            File file2 = new File(str);
            if (file2.exists()) {
                return cD.bxh.apkMd5.equalsIgnoreCase(g.a(file2, (int) ((file.length() - ((long) (cD.bxg.bxj + 8))) - 2), bArr));
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    private static byte[] f(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        int length;
        if (i2 == -1) {
            length = (int) file.length();
        } else {
            length = i2;
        }
        if (i < 0) {
            return null;
        }
        if (length <= 0) {
            return null;
        }
        if (i + length > ((int) file.length())) {
            length = ((int) file.length()) - i;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
            byte[] bArr = new byte[length];
            try {
                randomAccessFile.seek((long) i);
                randomAccessFile.readFully(bArr);
                randomAccessFile.close();
                return bArr;
            } catch (Exception e) {
                return bArr;
            }
        } catch (Exception e2) {
            return null;
        }
    }
}
