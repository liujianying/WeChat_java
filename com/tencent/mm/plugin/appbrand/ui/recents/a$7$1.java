package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.ui.recents.a.7;
import java.util.ArrayList;

class a$7$1 implements Runnable {
    final /* synthetic */ ArrayList gyU;
    final /* synthetic */ ArrayList gyW;
    final /* synthetic */ 7 gyX;

    a$7$1(7 7, ArrayList arrayList, ArrayList arrayList2) {
        this.gyX = 7;
        this.gyW = arrayList;
        this.gyU = arrayList2;
    }

    public final void run() {
        a.a(this.gyX.gyS, this.gyW);
        a.a(this.gyX.gyS, this.gyU, false);
    }
}
