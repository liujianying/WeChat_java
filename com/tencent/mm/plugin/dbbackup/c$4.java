package com.tencent.mm.plugin.dbbackup;

import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.mm.sdk.platformtools.ah;

class c$4 implements b {
    final /* synthetic */ long dUQ;
    final /* synthetic */ ProgressDialog hZo;
    final /* synthetic */ c hZp;
    final /* synthetic */ Context val$context;

    c$4(c cVar, ProgressDialog progressDialog, long j, Context context) {
        this.hZp = cVar;
        this.hZo = progressDialog;
        this.dUQ = j;
        this.val$context = context;
    }

    public final void ov(int i) {
        ah.A(new 1(this, i));
    }
}
