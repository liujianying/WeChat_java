package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.i.a.b;
import com.tencent.mm.plugin.appbrand.i.a.d;

class n$15 implements b {
    final /* synthetic */ n gmP;
    final /* synthetic */ String gnc;
    final /* synthetic */ aa gnd;

    n$15(n nVar, String str, aa aaVar) {
        this.gmP = nVar;
        this.gnc = str;
        this.gnd = aaVar;
    }

    public final void a(d dVar) {
        if (d.gkk != dVar) {
            this.gmP.runOnUiThread(new 1(this));
        }
    }
}
