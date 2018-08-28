package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.storage.ai;

class b$2 implements OnClickListener {
    final /* synthetic */ String dhh;
    final /* synthetic */ ai taG;
    final /* synthetic */ PBool unC;
    final /* synthetic */ ProgressDialog unD;
    final /* synthetic */ Runnable unE;
    final /* synthetic */ Context val$context;

    b$2(Context context, String str, ai aiVar, PBool pBool, ProgressDialog progressDialog, Runnable runnable) {
        this.val$context = context;
        this.dhh = str;
        this.taG = aiVar;
        this.unC = pBool;
        this.unD = progressDialog;
        this.unE = runnable;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.a(this.dhh, this.taG, this.unC, this.unD);
        if (this.unE != null) {
            this.unE.run();
        }
    }
}
