package com.tencent.mm.plugin.fts.a.a;

import com.tencent.mm.plugin.fts.a.a.g.c;

public class d$b implements Comparable<d$b> {
    public c jrL;
    public int jrM = -1;
    public int jrN = -1;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.jrM - ((d$b) obj).jrM;
    }

    public final boolean isAvailable() {
        return (this.jrM == -1 || this.jrN == -1) ? false : true;
    }

    public final String toString() {
        String str = "FTSQueryHLRequest.Item %s %d %d";
        Object[] objArr = new Object[3];
        objArr[0] = this.jrL == null ? "" : this.jrL.aQb().replaceAll("​", ",");
        objArr[1] = Integer.valueOf(this.jrM);
        objArr[2] = Integer.valueOf(this.jrN);
        return String.format(str, objArr);
    }
}
