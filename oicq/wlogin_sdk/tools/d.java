package oicq.wlogin_sdk.tools;

public final class d {
    public static byte[] b(byte[] bArr, int i, byte[] bArr2) {
        int i2;
        byte[] bArr3;
        int i3;
        Object obj = new byte[i];
        System.arraycopy(bArr, 0, obj, 0, i);
        a aVar = new a();
        int length = obj.length;
        aVar.plain = new byte[8];
        aVar.prePlain = new byte[8];
        aVar.pos = 1;
        aVar.padding = 0;
        aVar.preCrypt = 0;
        aVar.crypt = 0;
        aVar.key = bArr2;
        aVar.header = true;
        aVar.pos = (length + 10) % 8;
        if (aVar.pos != 0) {
            aVar.pos = 8 - aVar.pos;
        }
        aVar.out = new byte[((aVar.pos + length) + 10)];
        aVar.plain[0] = (byte) ((aVar.random.nextInt() & 248) | aVar.pos);
        for (i2 = 1; i2 <= aVar.pos; i2++) {
            aVar.plain[i2] = (byte) (aVar.random.nextInt() & 255);
        }
        aVar.pos++;
        for (i2 = 0; i2 < 8; i2++) {
            aVar.prePlain[i2] = (byte) 0;
        }
        aVar.padding = 1;
        while (aVar.padding <= 2) {
            if (aVar.pos < 8) {
                bArr3 = aVar.plain;
                i3 = aVar.pos;
                aVar.pos = i3 + 1;
                bArr3[i3] = (byte) (aVar.random.nextInt() & 255);
                aVar.padding++;
            }
            if (aVar.pos == 8) {
                aVar.encrypt8Bytes();
            }
        }
        i3 = 0;
        while (length > 0) {
            if (aVar.pos < 8) {
                byte[] bArr4 = aVar.plain;
                int i4 = aVar.pos;
                aVar.pos = i4 + 1;
                i2 = i3 + 1;
                bArr4[i4] = obj[i3];
                length--;
            } else {
                i2 = i3;
            }
            if (aVar.pos == 8) {
                aVar.encrypt8Bytes();
            }
            i3 = i2;
        }
        aVar.padding = 1;
        while (aVar.padding <= 7) {
            if (aVar.pos < 8) {
                bArr3 = aVar.plain;
                int i5 = aVar.pos;
                aVar.pos = i5 + 1;
                bArr3[i5] = (byte) 0;
                aVar.padding++;
            }
            if (aVar.pos == 8) {
                aVar.encrypt8Bytes();
            }
        }
        return aVar.out;
    }

    public static byte[] decrypt(byte[] bArr, int i, int i2, byte[] bArr2) {
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        a aVar = new a();
        int length = obj.length;
        aVar.preCrypt = 0;
        aVar.crypt = 0;
        aVar.key = bArr2;
        byte[] bArr3 = new byte[8];
        if (length % 8 != 0 || length < 16) {
            return null;
        }
        aVar.prePlain = aVar.P(obj);
        aVar.pos = aVar.prePlain[0] & 7;
        int i3 = (length - aVar.pos) - 10;
        if (i3 < 0) {
            return null;
        }
        int i4;
        for (i4 = 0; i4 < 8; i4++) {
            bArr3[i4] = (byte) 0;
        }
        aVar.out = new byte[i3];
        aVar.preCrypt = 0;
        aVar.crypt = 8;
        aVar.contextStart = 8;
        aVar.pos++;
        aVar.padding = 1;
        while (aVar.padding <= 2) {
            if (aVar.pos < 8) {
                aVar.pos++;
                aVar.padding++;
            }
            if (aVar.pos == 8) {
                if (!aVar.A(obj, length)) {
                    return null;
                }
                bArr3 = obj;
            }
        }
        i4 = 0;
        byte[] bArr4 = bArr3;
        while (i3 != 0) {
            int i5;
            if (aVar.pos < 8) {
                aVar.out[i4] = (byte) (bArr4[(aVar.preCrypt + 0) + aVar.pos] ^ aVar.prePlain[aVar.pos]);
                i5 = i4 + 1;
                i4 = i3 - 1;
                aVar.pos++;
                i3 = i4;
            } else {
                i5 = i4;
            }
            if (aVar.pos == 8) {
                aVar.preCrypt = aVar.crypt - 8;
                if (!aVar.A(obj, length)) {
                    return null;
                }
                i4 = i5;
                bArr4 = obj;
            } else {
                i4 = i5;
            }
        }
        aVar.padding = 1;
        bArr3 = bArr4;
        while (aVar.padding < 8) {
            if (aVar.pos < 8) {
                if ((bArr3[(aVar.preCrypt + 0) + aVar.pos] ^ aVar.prePlain[aVar.pos]) != 0) {
                    return null;
                }
                aVar.pos++;
            }
            if (aVar.pos == 8) {
                aVar.preCrypt = aVar.crypt;
                if (!aVar.A(obj, length)) {
                    return null;
                }
                bArr3 = obj;
            }
            aVar.padding++;
        }
        return aVar.out;
    }
}
