package com.tencent.mm.plugin.qmessage.ui;

import android.app.ProgressDialog;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd.a;
import com.tencent.mm.model.c;

class QConversationUI$4 implements a {
    final /* synthetic */ String dhh;
    final /* synthetic */ ProgressDialog hsv;
    final /* synthetic */ QConversationUI mbV;

    QConversationUI$4(QConversationUI qConversationUI, String str, ProgressDialog progressDialog) {
        this.mbV = qConversationUI;
        this.dhh = str;
        this.hsv = progressDialog;
    }

    public final boolean Ip() {
        return QConversationUI.i(this.mbV);
    }

    public final void Io() {
        au.HU();
        c.FW().Yp(this.dhh);
        if (this.hsv != null) {
            this.hsv.dismiss();
        }
    }
}
