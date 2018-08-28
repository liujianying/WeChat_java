package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b;

public class o$a {
    public static byte[] f(byte[] bArr, String str) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        byte[] bytes = str.getBytes();
        byte[] bArr2 = new byte[256];
        for (i = 0; i < 256; i++) {
            bArr2[i] = (byte) i;
        }
        if (bytes == null || bytes.length == 0) {
            bArr2 = null;
        } else {
            i2 = 0;
            i3 = 0;
            for (i = 0; i < 256; i++) {
                i2 = (i2 + ((bytes[i3] & b.CTRL_BYTE) + (bArr2[i] & b.CTRL_BYTE))) & b.CTRL_BYTE;
                byte b = bArr2[i];
                bArr2[i] = bArr2[i2];
                bArr2[i2] = b;
                i3 = (i3 + 1) % bytes.length;
            }
        }
        bytes = new byte[bArr.length];
        if (bArr2 != null) {
            i = 0;
            i2 = 0;
            while (true) {
                i3 = i4;
                if (i >= bArr.length) {
                    break;
                }
                i3 = (i3 + 1) & b.CTRL_BYTE;
                i4 = ((bArr2[i3] & b.CTRL_BYTE) + i2) & b.CTRL_BYTE;
                byte b2 = bArr2[i3];
                bArr2[i3] = bArr2[i4];
                bArr2[i4] = b2;
                i2 = ((bArr2[i3] & b.CTRL_BYTE) + (bArr2[i4] & b.CTRL_BYTE)) & b.CTRL_BYTE;
                i2 = (byte) (bArr2[i2] ^ bArr[i]);
                bytes[i] = i2;
                i++;
            }
        }
        return bytes;
    }
}
