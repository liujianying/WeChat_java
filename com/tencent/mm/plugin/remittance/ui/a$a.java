package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.protocal.c.xb;
import java.util.Comparator;

class a$a implements Comparator {
    final /* synthetic */ a myJ;

    a$a(a aVar) {
        this.myJ = aVar;
    }

    public final int compare(Object obj, Object obj2) {
        return ((xb) obj).rCw - ((xb) obj2).rCw > 0 ? -1 : 1;
    }
}
