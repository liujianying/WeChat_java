package com.tencent.mm.ui;

import com.tencent.mm.g.a.rr;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

public final class ai {
    public static void ba(int i, String str) {
        if (a.sFg != null) {
            b rrVar = new rr();
            rrVar.ccB.className = str;
            rrVar.ccB.ccC = i;
            a.sFg.m(rrVar);
        }
    }
}
