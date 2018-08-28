package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;

public final class b extends t$a$a<b> {
    public int[] voe;

    public final /* synthetic */ int compareTo(Object obj) {
        b bVar = (b) obj;
        int length = this.voe.length;
        int length2 = bVar.voe.length;
        if (length != length2) {
            return c.fI(length, length2);
        }
        for (length2 = 0; length2 < length; length2++) {
            if (this.voe[length2] != bVar.voe[length2]) {
                return c.fI(this.voe[length2], bVar.voe[length2]);
            }
        }
        return 0;
    }

    public b(int i, int[] iArr) {
        super(i);
        this.voe = iArr;
    }
}
