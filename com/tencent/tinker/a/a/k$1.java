package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.a;

class k$1 implements a {
    private int position = 0;
    final /* synthetic */ k vpa;

    k$1(k kVar) {
        this.vpa = kVar;
    }

    public final byte readByte() {
        byte[] bArr = this.vpa.data;
        int i = this.position;
        this.position = i + 1;
        return bArr[i];
    }
}
