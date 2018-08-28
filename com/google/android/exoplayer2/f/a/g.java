package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.j;

public final class g {
    public static void a(long j, j jVar, k[] kVarArr) {
        while (jVar.me() > 1) {
            int e = e(jVar);
            int e2 = e(jVar);
            if (e2 == -1 || e2 > jVar.me()) {
                jVar.setPosition(jVar.limit);
            } else {
                Object obj;
                if (e != 4 || e2 < 8) {
                    obj = null;
                } else {
                    e = jVar.position;
                    int readUnsignedByte = jVar.readUnsignedByte();
                    int readUnsignedShort = jVar.readUnsignedShort();
                    int readInt = jVar.readInt();
                    int readUnsignedByte2 = jVar.readUnsignedByte();
                    jVar.setPosition(e);
                    obj = (readUnsignedByte == 181 && readUnsignedShort == 49 && readInt == 1195456820 && readUnsignedByte2 == 3) ? 1 : null;
                }
                if (obj != null) {
                    jVar.da(8);
                    int readUnsignedByte3 = jVar.readUnsignedByte() & 31;
                    jVar.da(1);
                    int i = readUnsignedByte3 * 3;
                    int i2 = jVar.position;
                    for (k kVar : kVarArr) {
                        jVar.setPosition(i2);
                        kVar.a(jVar, i);
                        kVar.a(j, 1, i, 0, null);
                    }
                    jVar.da(e2 - ((readUnsignedByte3 * 3) + 10));
                } else {
                    jVar.da(e2);
                }
            }
        }
    }

    private static int e(j jVar) {
        int i = 0;
        while (jVar.me() != 0) {
            int readUnsignedByte = jVar.readUnsignedByte();
            i += readUnsignedByte;
            if (readUnsignedByte != 255) {
                return i;
            }
        }
        return -1;
    }
}
