package com.tencent.mm.plugin.ipcall.ui;

class IPCallContactUI$10 implements Runnable {
    final /* synthetic */ IPCallContactUI kuK;

    IPCallContactUI$10(IPCallContactUI iPCallContactUI) {
        this.kuK = iPCallContactUI;
    }

    public final void run() {
        if (IPCallContactUI.d(this.kuK) != null && IPCallContactUI.b(this.kuK) != null && !IPCallContactUI.d(this.kuK).hoW) {
            IPCallContactUI.d(this.kuK).pi(IPCallContactUI.h(this.kuK));
            IPCallContactUI.f(this.kuK).sendEmptyMessage(2);
            IPCallContactUI.b(this.kuK).invalidateViews();
        }
    }
}
