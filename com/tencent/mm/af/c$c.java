package com.tencent.mm.af;

import java.io.Serializable;

class c$c implements Serializable {
    long dQX = 0;
    long dRc = 0;
    long dRd = 0;
    long dRe = 0;
    long dRs = 0;
    int pid = 0;

    c$c(int i, long j, long j2, long j3, long j4, long j5) {
        this.pid = i;
        this.dQX = j;
        this.dRs = j2;
        this.dRc = j3;
        this.dRd = j4;
        this.dRe = j5;
    }

    public final String toString() {
        return String.format("pid:%s, server time:%s, client time:%s, msg server time:%s, intervalTime:%s, msg server id:%s", new Object[]{Integer.valueOf(this.pid), a.bn(this.dQX), a.bn(this.dRs), a.bn(this.dRc), Long.valueOf(this.dRd), Long.valueOf(this.dRe)});
    }
}
