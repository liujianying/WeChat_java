package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import com.tencent.mm.model.bd.a;
import com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI;

class AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$4 implements a {
    final /* synthetic */ ProgressDialog hsv;
    final /* synthetic */ AppBrandServiceConversationFmUI umW;

    AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$4(AppBrandServiceConversationFmUI appBrandServiceConversationFmUI, ProgressDialog progressDialog) {
        this.umW = appBrandServiceConversationFmUI;
        this.hsv = progressDialog;
    }

    public final boolean Ip() {
        return AppBrandServiceConversationFmUI.access$900(this.umW);
    }

    public final void Io() {
        if (this.hsv != null) {
            this.hsv.dismiss();
        }
    }
}
