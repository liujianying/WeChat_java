package com.tencent.mm.af;

import java.io.Serializable;

class c$a implements Serializable {
    long dQX = 0;
    long time = 0;
    int type = 0;

    c$a(long j, long j2, int i) {
        this.dQX = j;
        this.time = j2;
        this.type = i;
    }

    public final String toString() {
        return String.format("serverTime:%s,time:%s,type:%s", new Object[]{a.bn(this.dQX), a.bn(this.time), Integer.valueOf(this.type)});
    }
}
