package com.tencent.mm.plugin.walletlock.gesture.a;

import java.lang.reflect.Array;

public final class f {
    private static f[][] pGY = ((f[][]) Array.newInstance(f.class, new int[]{3, 3}));
    public int pGW = 0;
    public int pGX = 0;

    static {
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                pGY[i][i2] = new f(i, i2);
            }
        }
    }

    private f(int i, int i2) {
        this.pGW = i;
        this.pGX = i2;
    }

    public static synchronized f eb(int i, int i2) {
        f fVar;
        synchronized (f.class) {
            if (i < 0 || i > 2) {
                throw new IllegalArgumentException("row id should be in range [0..2]");
            } else if (i2 < 0 || i2 > 2) {
                throw new IllegalArgumentException("col id should be in range [0..2]");
            } else {
                fVar = pGY[i][i2];
            }
        }
        return fVar;
    }

    public final String toString() {
        return String.format("{row: %d, col: %d}", new Object[]{Integer.valueOf(this.pGW), Integer.valueOf(this.pGX)});
    }
}
