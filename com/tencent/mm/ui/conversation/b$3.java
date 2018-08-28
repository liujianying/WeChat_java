package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import com.tencent.mm.model.bd.a;
import com.tencent.mm.pointers.PBool;

class b$3 implements a {
    final /* synthetic */ PBool unC;
    final /* synthetic */ ProgressDialog unD;

    b$3(PBool pBool, ProgressDialog progressDialog) {
        this.unC = pBool;
        this.unD = progressDialog;
    }

    public final boolean Ip() {
        return this.unC.value || this.unD == null || !this.unD.isShowing();
    }

    public final void Io() {
        if (this.unD != null) {
            this.unD.dismiss();
        }
    }
}
