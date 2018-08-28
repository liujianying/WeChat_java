package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PBool;

class b$8 implements OnClickListener {
    final /* synthetic */ String dhh;
    final /* synthetic */ ProgressDialog hsv;
    final /* synthetic */ PBool unC;
    final /* synthetic */ Runnable unE;
    final /* synthetic */ boolean unG;

    b$8(ProgressDialog progressDialog, PBool pBool, String str, boolean z, Runnable runnable) {
        this.hsv = progressDialog;
        this.unC = pBool;
        this.dhh = str;
        this.unG = z;
        this.unE = runnable;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.hsv.show();
        this.unC.value = false;
        b.a(this.dhh, this.unC, this.hsv);
        if (this.unG) {
            h.mEJ.h(14553, new Object[]{Integer.valueOf(1), Integer.valueOf(3), this.dhh});
        }
        if (this.unE != null) {
            this.unE.run();
        }
    }
}
