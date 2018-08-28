package com.tencent.mm.plugin.readerapp.ui;

import android.app.ProgressDialog;
import com.tencent.mm.plugin.readerapp.c.g.a;
import com.tencent.mm.plugin.readerapp.ui.b.3;

class b$3$1 implements a {
    final /* synthetic */ ProgressDialog hZo;
    final /* synthetic */ 3 mnC;

    b$3$1(3 3, ProgressDialog progressDialog) {
        this.mnC = 3;
        this.hZo = progressDialog;
    }

    public final void bpQ() {
        if (this.hZo != null) {
            this.hZo.dismiss();
        }
    }
}
