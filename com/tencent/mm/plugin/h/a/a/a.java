package com.tencent.mm.plugin.h.a.a;

public final class a {
    int[] heM = null;

    public a(int[] iArr) {
        if (iArr.length == 0) {
            throw new NullPointerException("null == aDataGroup || 0 == aDataGroup.length");
        }
        this.heM = iArr;
    }
}
