package com.tencent.mm.ui.chatting;

import com.tencent.mm.model.au;
import com.tencent.mm.ui.appbrand.c.a;

class AppBrandServiceChattingUI$a$7 implements a {
    final /* synthetic */ AppBrandServiceChattingUI.a tGQ;

    AppBrandServiceChattingUI$a$7(AppBrandServiceChattingUI.a aVar) {
        this.tGQ = aVar;
    }

    public final void cra() {
        this.tGQ.hideVKB();
        au.Em().H(new Runnable() {
            public final void run() {
                AppBrandServiceChattingUI.a.h(AppBrandServiceChattingUI$a$7.this.tGQ);
            }
        });
    }
}
