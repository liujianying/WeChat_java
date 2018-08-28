package com.tencent.mm.plugin.ext.ui;

class RedirectToChattingByPhoneStubUI$1 implements Runnable {
    final /* synthetic */ RedirectToChattingByPhoneStubUI iLa;

    RedirectToChattingByPhoneStubUI$1(RedirectToChattingByPhoneStubUI redirectToChattingByPhoneStubUI) {
        this.iLa = redirectToChattingByPhoneStubUI;
    }

    public final void run() {
        this.iLa.hideVKB();
    }
}
