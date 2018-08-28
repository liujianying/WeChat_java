package oicq.wlogin_sdk.tools;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

final class a {
    int contextStart;
    int crypt;
    boolean header = true;
    byte[] key;
    byte[] out;
    int padding;
    byte[] plain;
    int pos;
    int preCrypt;
    byte[] prePlain;
    Random random = new Random();

    a() {
    }

    private static long z(byte[] bArr, int i) {
        long j = 0;
        int i2 = i + 4;
        while (i < i2) {
            j = (j << 8) | ((long) (bArr[i] & 255));
            i++;
        }
        return (j >>> 32) | (4294967295L & j);
    }

    private byte[] encipher(byte[] bArr) {
        int i = 16;
        try {
            long z = z(bArr, 0);
            long z2 = z(bArr, 4);
            long z3 = z(this.key, 0);
            long z4 = z(this.key, 4);
            long z5 = z(this.key, 8);
            long z6 = z(this.key, 12);
            long j = 0;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) z);
                    dataOutputStream.writeInt((int) z2);
                    dataOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                j = (j + 2654435769L) & 4294967295L;
                z = (z + ((((z2 << 4) + z3) ^ (z2 + j)) ^ ((z2 >>> 5) + z4))) & 4294967295L;
                z2 = (z2 + ((((z << 4) + z5) ^ (z + j)) ^ ((z >>> 5) + z6))) & 4294967295L;
                i = i2;
            }
        } catch (IOException e) {
            return null;
        }
    }

    final byte[] P(byte[] bArr) {
        int i = 16;
        try {
            long z = z(bArr, 0);
            long z2 = z(bArr, 4);
            long z3 = z(this.key, 0);
            long z4 = z(this.key, 4);
            long z5 = z(this.key, 8);
            long z6 = z(this.key, 12);
            long j = 3816266640L;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) z);
                    dataOutputStream.writeInt((int) z2);
                    dataOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                z2 = (z2 - ((((z << 4) + z5) ^ (z + j)) ^ ((z >>> 5) + z6))) & 4294967295L;
                z = (z - ((((z2 << 4) + z3) ^ (z2 + j)) ^ ((z2 >>> 5) + z4))) & 4294967295L;
                j = (j - 2654435769L) & 4294967295L;
                i = i2;
            }
        } catch (IOException e) {
            return null;
        }
    }

    final void encrypt8Bytes() {
        byte[] bArr;
        int i;
        this.pos = 0;
        while (this.pos < 8) {
            if (this.header) {
                bArr = this.plain;
                i = this.pos;
                bArr[i] = (byte) (bArr[i] ^ this.prePlain[this.pos]);
            } else {
                bArr = this.plain;
                i = this.pos;
                bArr[i] = (byte) (bArr[i] ^ this.out[this.preCrypt + this.pos]);
            }
            this.pos++;
        }
        System.arraycopy(encipher(this.plain), 0, this.out, this.crypt, 8);
        this.pos = 0;
        while (this.pos < 8) {
            bArr = this.out;
            i = this.crypt + this.pos;
            bArr[i] = (byte) (bArr[i] ^ this.prePlain[this.pos]);
            this.pos++;
        }
        System.arraycopy(this.plain, 0, this.prePlain, 0, 8);
        this.preCrypt = this.crypt;
        this.crypt += 8;
        this.pos = 0;
        this.header = false;
    }

    final boolean A(byte[] bArr, int i) {
        this.pos = 0;
        while (this.pos < 8) {
            if (this.contextStart + this.pos >= i) {
                return true;
            }
            byte[] bArr2 = this.prePlain;
            int i2 = this.pos;
            bArr2[i2] = (byte) (bArr2[i2] ^ bArr[(this.crypt + 0) + this.pos]);
            this.pos++;
        }
        this.prePlain = P(this.prePlain);
        if (this.prePlain == null) {
            return false;
        }
        this.contextStart += 8;
        this.crypt += 8;
        this.pos = 0;
        return true;
    }
}
