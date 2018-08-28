package com.tencent.mm.plugin.appbrand.r;

import java.util.Comparator;

class k$1 implements Comparator<k$e> {
    k$1() {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        k$e k_e = (k$e) obj;
        k$e k_e2 = (k$e) obj2;
        int i = k_e.x - k_e2.x;
        return i == 0 ? k_e.y - k_e2.y : i;
    }
}
