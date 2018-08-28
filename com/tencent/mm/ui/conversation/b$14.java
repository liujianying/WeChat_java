package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.storage.ai;

class b$14 implements OnClickListener {
    final /* synthetic */ String dhh;
    final /* synthetic */ ai taG;
    final /* synthetic */ PBool unC;
    final /* synthetic */ ProgressDialog unD;
    final /* synthetic */ Runnable unE;
    final /* synthetic */ boolean unG;
    final /* synthetic */ Context val$context;

    b$14(ProgressDialog progressDialog, PBool pBool, Context context, String str, ai aiVar, Runnable runnable, boolean z) {
        this.unD = progressDialog;
        this.unC = pBool;
        this.val$context = context;
        this.dhh = str;
        this.taG = aiVar;
        this.unE = runnable;
        this.unG = z;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.unD.show();
        this.unC.value = false;
        b.a(this.dhh, this.taG, this.unC, this.unD);
        if (this.unE != null) {
            this.unE.run();
        }
        if (this.unG) {
            h.mEJ.h(14553, new Object[]{Integer.valueOf(0), Integer.valueOf(3), this.dhh});
        }
    }
}
