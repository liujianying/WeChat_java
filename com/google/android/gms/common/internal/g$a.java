package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;

class g$a extends g {
    List<g> aNN;

    g$a(List<g> list) {
        this.aNN = list;
    }

    public final g a(g gVar) {
        List arrayList = new ArrayList(this.aNN);
        arrayList.add(w.ah(gVar));
        return new g$a(arrayList);
    }

    public final boolean e(char c) {
        for (g e : this.aNN) {
            if (e.e(c)) {
                return true;
            }
        }
        return false;
    }
}
