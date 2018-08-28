package com.tencent.mm.ui.voicesearch;

import java.util.ArrayList;
import java.util.List;

class b$5 implements Runnable {
    final /* synthetic */ List gco;
    final /* synthetic */ b uFM;

    b$5(b bVar, List list) {
        this.uFM = bVar;
        this.gco = list;
    }

    public final void run() {
        if (b.a(this.uFM) == null) {
            b.a(this.uFM, new ArrayList());
        }
        b.a(this.uFM).clear();
        b.a(this.uFM).addAll(this.gco);
        b.a(this.uFM).add("officialaccounts");
        b.a(this.uFM).add("helper_entry");
    }
}
