package com.tencent.tencentmap.mapsdk.a;

import java.util.Collections;
import java.util.List;

public final class rq {
    private int a;
    private int b;
    private List<rp> c;

    public rq(int i, int i2, List<rp> list) {
        this.a = i;
        this.b = i2;
        this.c = list;
        Collections.sort(list, new 1(this));
    }

    public final int a() {
        return this.a;
    }

    public final String[] a(rr rrVar) {
        for (rp a : this.c) {
            if (a.a(rrVar)) {
                return new String[]{((rp) r1.next()).b(), ((rp) r1.next()).c()};
            }
        }
        return null;
    }

    public final int b() {
        return this.b;
    }
}
