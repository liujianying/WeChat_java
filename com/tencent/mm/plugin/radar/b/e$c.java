package com.tencent.mm.plugin.radar.b;

import b.c.b.e;
import com.tencent.mm.protocal.c.beq;

public final class e$c {
    public final beq mkp;
    public final c$e mkq;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001c;
    L_0x0002:
        r0 = r3 instanceof com.tencent.mm.plugin.radar.b.e$c;
        if (r0 == 0) goto L_0x001e;
    L_0x0006:
        r3 = (com.tencent.mm.plugin.radar.b.e$c) r3;
        r0 = r2.mkp;
        r1 = r3.mkp;
        r0 = b.c.b.e.i(r0, r1);
        if (r0 == 0) goto L_0x001e;
    L_0x0012:
        r0 = r2.mkq;
        r1 = r3.mkq;
        r0 = b.c.b.e.i(r0, r1);
        if (r0 == 0) goto L_0x001e;
    L_0x001c:
        r0 = 1;
    L_0x001d:
        return r0;
    L_0x001e:
        r0 = 0;
        goto L_0x001d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.radar.b.e$c.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i = 0;
        beq beq = this.mkp;
        int hashCode = (beq != null ? beq.hashCode() : 0) * 31;
        c$e c_e = this.mkq;
        if (c_e != null) {
            i = c_e.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        return "LatestChangeStat(member=" + this.mkp + ", state=" + this.mkq + ")";
    }

    public e$c(beq beq, c$e c_e) {
        e.i(beq, "member");
        e.i(c_e, "state");
        this.mkp = beq;
        this.mkq = c_e;
    }
}
