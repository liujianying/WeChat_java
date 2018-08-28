package com.tencent.tencentmap.mapsdk.a;

import java.util.Comparator;

final class td$a implements Comparator<td> {
    private td$a() {
    }

    /* synthetic */ td$a(byte b) {
        this();
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        td tdVar = (td) obj;
        td tdVar2 = (td) obj2;
        return tdVar == null ? -1 : tdVar2 == null ? 1 : Float.compare(tdVar.j(), tdVar2.j());
    }
}
