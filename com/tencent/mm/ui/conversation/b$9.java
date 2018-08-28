package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.pointers.PBool;

class b$9 implements OnClickListener {
    final /* synthetic */ String dhh;
    final /* synthetic */ ProgressDialog hsv;
    final /* synthetic */ PBool unC;
    final /* synthetic */ Runnable unE;

    b$9(String str, PBool pBool, ProgressDialog progressDialog, Runnable runnable) {
        this.dhh = str;
        this.unC = pBool;
        this.hsv = progressDialog;
        this.unE = runnable;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.a(this.dhh, this.unC, this.hsv);
        if (this.unE != null) {
            this.unE.run();
        }
    }
}
