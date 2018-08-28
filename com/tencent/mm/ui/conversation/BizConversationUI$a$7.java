package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import com.tencent.mm.model.bd.a;

class BizConversationUI$a$7 implements a {
    final /* synthetic */ ProgressDialog hsv;
    final /* synthetic */ BizConversationUI.a unz;

    BizConversationUI$a$7(BizConversationUI.a aVar, ProgressDialog progressDialog) {
        this.unz = aVar;
        this.hsv = progressDialog;
    }

    public final boolean Ip() {
        return BizConversationUI.a.l(this.unz);
    }

    public final void Io() {
        if (this.hsv != null) {
            this.hsv.dismiss();
        }
    }
}
