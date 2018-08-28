package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.ui.widget.a.c.a.b;

class SelectConversationUI$14 implements b {
    final /* synthetic */ SelectConversationUI uEC;
    final /* synthetic */ String val$url;

    SelectConversationUI$14(SelectConversationUI selectConversationUI, String str) {
        this.uEC = selectConversationUI;
        this.val$url = str;
    }

    public final void aMV() {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.val$url);
        intent.putExtra("showShare", false);
        d.b(this.uEC.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
    }
}
