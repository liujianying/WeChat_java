package com.tencent.mm.booter;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class o$a {
    int cXA;
    int cXB = 1;
    int cXC;
    int cXD;
    int cXE;

    o$a() {
    }

    public final boolean eF(String str) {
        String[] split = str.split(",");
        if (split == null || split.length != 5) {
            x.e("MicroMsg.ProcessReport", "error format");
            return false;
        }
        try {
            this.cXA = bi.getInt(split[0], 0);
            this.cXB = bi.getInt(split[1], 0);
            this.cXC = bi.getInt(split[2], 0);
            this.cXD = bi.getInt(split[3], 0);
            this.cXE = bi.getInt(split[4], 0);
            return true;
        } catch (Throwable e) {
            x.e("MicroMsg.ProcessReport", "ParseFrom parse failed");
            x.printErrStackTrace("MicroMsg.ProcessReport", e, "", new Object[0]);
            return false;
        }
    }

    public final String toString() {
        return String.format("%d,%d,%d,%d,%d", new Object[]{Integer.valueOf(this.cXA), Integer.valueOf(this.cXB), Integer.valueOf(this.cXC), Integer.valueOf(this.cXD), Integer.valueOf(this.cXE)});
    }
}
