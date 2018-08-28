package com.tencent.mm.af;

import com.tencent.mm.model.bx;
import java.io.Serializable;

public class c$d implements Serializable {
    int dQY = 0;
    boolean dQZ = true;
    boolean dRa = false;
    long dRt = 0;
    long endTime = 0;
    int pid = 0;
    long startTime = 0;

    final void a(int i, long j, long j2, int i2) {
        this.pid = i;
        if (this.startTime <= 0) {
            this.startTime = j;
            this.dRt = bx.IR();
        }
        this.endTime = j2;
        this.dQY = i2;
    }

    static c$d b(int i, long j, long j2, int i2) {
        c$d c_d = new c$d();
        c_d.pid = i;
        c_d.startTime = j;
        c_d.endTime = j2;
        c_d.dQY = i2;
        return c_d;
    }

    public final String toString() {
        return String.format("pid:%s,startServerTime:%s,startTime:%s,endTime:%s,normalExecute:%s,changedNetworkStatus:%s,networkStatus:%s", new Object[]{Integer.valueOf(this.pid), a.bn(this.dRt), a.bn(this.startTime), a.bn(this.endTime), Boolean.valueOf(this.dQZ), Boolean.valueOf(this.dRa), Integer.valueOf(this.dQY)});
    }
}
