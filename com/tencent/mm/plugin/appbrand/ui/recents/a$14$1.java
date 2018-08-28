package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.ui.recents.a.14;
import java.util.ArrayList;

class a$14$1 implements Runnable {
    final /* synthetic */ ArrayList gyU;
    final /* synthetic */ ArrayList gyW;
    final /* synthetic */ 14 gzb;

    a$14$1(14 14, ArrayList arrayList, ArrayList arrayList2) {
        this.gzb = 14;
        this.gyW = arrayList;
        this.gyU = arrayList2;
    }

    public final void run() {
        a.a(this.gzb.gyS, this.gyW);
        a.a(this.gzb.gyS, this.gyU, true);
    }
}
