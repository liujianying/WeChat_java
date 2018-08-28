package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.i.c;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.h.b;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.o;
import java.util.ArrayList;
import java.util.List;

public final class a {
    public final float aCi;
    public final List<byte[]> adY;
    public final int alp;
    public final int height;
    public final int width;

    public static a m(j jVar) {
        int i = 0;
        try {
            jVar.da(4);
            int readUnsignedByte = (jVar.readUnsignedByte() & 3) + 1;
            if (readUnsignedByte == 3) {
                throw new IllegalStateException();
            }
            int i2;
            List arrayList = new ArrayList();
            int readUnsignedByte2 = jVar.readUnsignedByte() & 31;
            for (i2 = 0; i2 < readUnsignedByte2; i2++) {
                arrayList.add(n(jVar));
            }
            i2 = jVar.readUnsignedByte();
            while (i < i2) {
                arrayList.add(n(jVar));
                i++;
            }
            float f = 1.0f;
            if (readUnsignedByte2 > 0) {
                b j = h.j((byte[]) arrayList.get(0), readUnsignedByte, ((byte[]) arrayList.get(0)).length);
                i = j.width;
                i2 = j.height;
                f = j.aCi;
            } else {
                i = -1;
                i2 = -1;
            }
            return new a(arrayList, readUnsignedByte, i, i2, f);
        } catch (Throwable e) {
            throw new o("Error parsing AVC config", e);
        }
    }

    private a(List<byte[]> list, int i, int i2, int i3, float f) {
        this.adY = list;
        this.alp = i;
        this.width = i2;
        this.height = i3;
        this.aCi = f;
    }

    private static byte[] n(j jVar) {
        int readUnsignedShort = jVar.readUnsignedShort();
        int i = jVar.position;
        jVar.da(readUnsignedShort);
        return c.i(jVar.data, i, readUnsignedShort);
    }
}
