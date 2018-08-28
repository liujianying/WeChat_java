package com.tencent.mm.ui.chatting;

import com.tencent.mm.pluginsdk.e;

class AppBrandServiceChattingUI$2 implements Runnable {
    final /* synthetic */ AppBrandServiceChattingUI tGI;

    AppBrandServiceChattingUI$2(AppBrandServiceChattingUI appBrandServiceChattingUI) {
        this.tGI = appBrandServiceChattingUI;
    }

    public final void run() {
        if (this.tGI.tGG != null) {
            e.a(this.tGI, this.tGI.tGG.getBodyView());
        }
    }
}
