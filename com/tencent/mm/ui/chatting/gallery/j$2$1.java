package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.ui.chatting.gallery.j.2;

class j$2$1 implements Runnable {
    final /* synthetic */ 2 tXs;
    final /* synthetic */ Intent val$intent;

    j$2$1(2 2, Intent intent) {
        this.tXs = 2;
        this.val$intent = intent;
    }

    public final void run() {
        d.b(this.tXs.tXq.tTU.tTy.mController.tml, "webview", ".ui.tools.WebViewUI", this.val$intent);
    }
}
