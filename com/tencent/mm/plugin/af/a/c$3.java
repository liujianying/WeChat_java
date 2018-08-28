package com.tencent.mm.plugin.af.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.af.a.c.a;

class c$3 implements OnClickListener {
    final /* synthetic */ Intent dgK;
    final /* synthetic */ a mje;

    c$3(a aVar, Intent intent) {
        this.mje = aVar;
        this.dgK = intent;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        d.b(this.mje.getContext(), "freewifi", ".ui.FreeWifiEntryUI", this.dgK);
        this.mje.hk(false);
    }
}
