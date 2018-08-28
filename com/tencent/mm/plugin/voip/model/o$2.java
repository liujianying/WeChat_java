package com.tencent.mm.plugin.voip.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class o$2 implements OnClickListener {
    final /* synthetic */ o oMC;

    o$2(o oVar) {
        this.oMC = oVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        o.a(this.oMC, o.g(this.oMC).getSharedPreferences("voip_plugin_prefs", 0));
        if (4096 != o.s(this.oMC)) {
            o.c(this.oMC, o.s(this.oMC));
            o.t(this.oMC);
        }
        o.u(this.oMC).post(new 1(this));
    }
}
