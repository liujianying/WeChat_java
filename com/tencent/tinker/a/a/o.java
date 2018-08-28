package com.tencent.tinker.a.a;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b;
import com.tencent.tinker.a.a.b.a;

public final class o {
    public static int a(a aVar) {
        int readByte;
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            readByte = aVar.readByte() & b.CTRL_BYTE;
            i = ((readByte & 127) << (i3 * 7)) | i;
            i2 <<= 7;
            i3++;
            if ((readByte & 128) != 128 || i3 >= 5) {
            }
        }
        if ((readByte & 128) == 128) {
            throw new j("invalid LEB128 sequence");
        } else if (((i2 >> 1) & i) != 0) {
            return i | i2;
        } else {
            return i;
        }
    }

    public static int b(a aVar) {
        int readByte;
        int i = 0;
        int i2 = 0;
        while (true) {
            readByte = aVar.readByte() & b.CTRL_BYTE;
            i = ((readByte & 127) << (i2 * 7)) | i;
            i2++;
            if ((readByte & 128) != 128 || i2 >= 5) {
            }
        }
        if ((readByte & 128) != 128) {
            return i;
        }
        throw new j("invalid LEB128 sequence");
    }

    public static int c(a aVar) {
        return b(aVar) - 1;
    }

    public static int a(com.tencent.tinker.a.a.b.b bVar, int i) {
        int i2 = 0;
        for (int i3 = i >>> 7; i3 != 0; i3 >>>= 7) {
            bVar.writeByte((byte) ((i & 127) | 128));
            i2++;
            i = i3;
        }
        bVar.writeByte((byte) (i & 127));
        return i2 + 1;
    }

    public static int b(com.tencent.tinker.a.a.b.b bVar, int i) {
        return a(bVar, i + 1);
    }

    public static int c(com.tencent.tinker.a.a.b.b bVar, int i) {
        int i2 = i >> 7;
        int i3 = (Integer.MIN_VALUE & i) == 0 ? 0 : -1;
        int i4 = 0;
        Object obj = 1;
        int i5 = i2;
        while (obj != null) {
            if (i5 == i3 && (i5 & 1) == ((i >> 6) & 1)) {
                obj = null;
            } else {
                obj = 1;
            }
            int i6 = i & 127;
            if (obj != null) {
                i2 = 128;
            } else {
                i2 = 0;
            }
            bVar.writeByte((byte) (i2 | i6));
            i4++;
            i = i5;
            i5 >>= 7;
        }
        return i4;
    }
}
