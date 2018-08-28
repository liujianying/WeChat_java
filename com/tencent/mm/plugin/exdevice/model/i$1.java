package com.tencent.mm.plugin.exdevice.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;

class i$1 implements OnCancelListener {
    final /* synthetic */ o ivr;
    final /* synthetic */ i$a ivs;
    final /* synthetic */ i ivt;

    i$1(i iVar, o oVar, i$a i_a) {
        this.ivt = iVar;
        this.ivr = oVar;
        this.ivs = i_a;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.ivr);
        i.a(this.ivt).dismiss();
        i.b(this.ivt);
        if (this.ivs != null) {
            this.ivs.ew(false);
        }
    }
}
