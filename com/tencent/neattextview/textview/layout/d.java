package com.tencent.neattextview.textview.layout;

import android.text.Spanned;
import java.lang.reflect.Array;

public final class d<E> {
    private final Class<? extends E> vaY;
    public int vaZ = 0;
    public E[] vba;
    public int[] vbb;
    public int[] vbc;
    public int[] vbd;

    d(Class<? extends E> cls) {
        this.vaY = cls;
    }

    public final void a(Spanned spanned, int i) {
        if (r3 > 0 && (this.vba == null || this.vba.length < r3)) {
            this.vba = (Object[]) Array.newInstance(this.vaY, r3);
            this.vbb = new int[r3];
            this.vbc = new int[r3];
            this.vbd = new int[r3];
        }
        this.vaZ = 0;
        for (Object obj : spanned.getSpans(0, i, this.vaY)) {
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (spanStart != spanEnd) {
                int spanFlags = spanned.getSpanFlags(obj);
                this.vba[this.vaZ] = obj;
                this.vbb[this.vaZ] = spanStart;
                this.vbc[this.vaZ] = spanEnd;
                this.vbd[this.vaZ] = spanFlags;
                this.vaZ++;
            }
        }
    }

    public final E fB(int i, int i2) {
        int i3 = 0;
        while (i3 < this.vaZ) {
            if (this.vbb[i3] < i2 && this.vbc[i3] > i) {
                return this.vba[i3];
            }
            i3++;
        }
        return null;
    }

    public final boolean[] fC(int i, int i2) {
        boolean[] zArr = new boolean[this.vaZ];
        int i3 = 0;
        while (i3 < this.vaZ) {
            if (this.vbb[i3] < i2 && this.vbc[i3] > i) {
                zArr[i3] = true;
            }
            i3++;
        }
        return zArr;
    }

    public final E fD(int i, int i2) {
        int i3 = 0;
        while (i3 < this.vaZ) {
            if (this.vbb[i3] == i && this.vbc[i3] == i2) {
                return this.vba[i3];
            }
            i3++;
        }
        return null;
    }
}
