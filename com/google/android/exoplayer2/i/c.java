package com.google.android.exoplayer2.i;

import android.util.Pair;

public final class c {
    private static final byte[] aBV = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1};
    private static final int[] aBW = new int[]{96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] aBX = new int[]{0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static Pair<Integer, Integer> i(byte[] bArr) {
        i iVar = new i(bArr);
        int c = c(iVar);
        int d = d(iVar);
        int cY = iVar.cY(4);
        if (c == 5 || c == 29) {
            d = d(iVar);
            if (c(iVar) == 22) {
                cY = iVar.cY(4);
            }
        }
        int i = aBX[cY];
        a.ao(i != -1);
        return Pair.create(Integer.valueOf(d), Integer.valueOf(i));
    }

    public static byte[] t(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & 248) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }

    public static byte[] i(byte[] bArr, int i, int i2) {
        Object obj = new byte[(aBV.length + i2)];
        System.arraycopy(aBV, 0, obj, 0, aBV.length);
        System.arraycopy(bArr, i, obj, aBV.length, i2);
        return obj;
    }

    private static int c(i iVar) {
        int cY = iVar.cY(5);
        if (cY == 31) {
            return iVar.cY(6) + 32;
        }
        return cY;
    }

    private static int d(i iVar) {
        int cY = iVar.cY(4);
        if (cY == 15) {
            return iVar.cY(24);
        }
        a.ao(cY < 13);
        return aBW[cY];
    }
}
