package com.tencent.mm.ui.bizchat;

import android.app.ProgressDialog;
import com.tencent.mm.ac.z;
import com.tencent.mm.model.bd.a;

class BizChatroomInfoUI$2 implements a {
    final /* synthetic */ ProgressDialog hsv;
    final /* synthetic */ BizChatroomInfoUI tFD;

    BizChatroomInfoUI$2(BizChatroomInfoUI bizChatroomInfoUI, ProgressDialog progressDialog) {
        this.tFD = bizChatroomInfoUI;
        this.hsv = progressDialog;
    }

    public final boolean Ip() {
        return BizChatroomInfoUI.f(this.tFD);
    }

    public final void Io() {
        if (this.hsv != null) {
            z.Nb().be(BizChatroomInfoUI.g(this.tFD));
            z.Na().be(BizChatroomInfoUI.g(this.tFD));
            this.hsv.dismiss();
        }
    }
}
