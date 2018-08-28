package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.sdk.platformtools.x;

class o$11 implements OnClickListener {
    final /* synthetic */ o oMC;
    final /* synthetic */ Context oMM;

    public o$11(o oVar, Context context) {
        this.oMC = oVar;
        this.oMM = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.Voip.VoipMgr", "show Permission settings");
        b.bu(this.oMM);
        if (o.b(this.oMC)) {
            if (o.e(this.oMC)) {
                this.oMC.bKr();
            } else {
                this.oMC.bKs();
            }
        } else if (o.e(this.oMC)) {
            this.oMC.bKn();
        } else {
            this.oMC.bKp();
        }
    }
}
