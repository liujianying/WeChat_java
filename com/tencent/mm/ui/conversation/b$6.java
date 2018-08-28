package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import com.tencent.mm.model.bd.a;
import com.tencent.mm.pointers.PBool;

class b$6 implements a {
    final /* synthetic */ ProgressDialog hsv;
    final /* synthetic */ PBool unC;

    b$6(PBool pBool, ProgressDialog progressDialog) {
        this.unC = pBool;
        this.hsv = progressDialog;
    }

    public final boolean Ip() {
        return this.unC.value;
    }

    public final void Io() {
        if (this.hsv != null) {
            this.hsv.dismiss();
        }
    }
}
