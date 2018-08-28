package com.tencent.mm.plugin.exdevice.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;

class ab$1 implements OnCancelListener {
    final /* synthetic */ u ivT;
    final /* synthetic */ ab ivU;

    ab$1(ab abVar, u uVar) {
        this.ivU = abVar;
        this.ivT = uVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.ivT);
        if (this.ivU.ivS.bJX != null) {
            this.ivU.ivS.bQe.ret = 1;
            this.ivU.ivS.bJX.run();
        }
    }
}
