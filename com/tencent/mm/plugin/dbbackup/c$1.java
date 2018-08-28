package com.tencent.mm.plugin.dbbackup;

import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.mm.model.bu;
import com.tencent.mm.sdk.platformtools.ah;

class c$1 implements b {
    final /* synthetic */ bu hZn;
    final /* synthetic */ ProgressDialog hZo;
    final /* synthetic */ c hZp;
    final /* synthetic */ Context val$context;

    c$1(c cVar, bu buVar, ProgressDialog progressDialog, Context context) {
        this.hZp = cVar;
        this.hZn = buVar;
        this.hZo = progressDialog;
        this.val$context = context;
    }

    public final void ov(int i) {
        this.hZn.IL();
        ah.A(new 1(this, i));
    }
}
