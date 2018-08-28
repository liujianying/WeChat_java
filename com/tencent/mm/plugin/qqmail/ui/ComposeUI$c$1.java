package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.plugin.qqmail.ui.ComposeUI.c;

class ComposeUI$c$1 implements Runnable {
    final /* synthetic */ c mfG;

    ComposeUI$c$1(c cVar) {
        this.mfG = cVar;
    }

    public final void run() {
        if (!ComposeUI.e(this.mfG.mfs).mgU.isFocused() && !ComposeUI.f(this.mfG.mfs).mgU.isFocused() && ComposeUI.e(this.mfG.mfs).getMailAddrs().size() == 0 && ComposeUI.f(this.mfG.mfs).getMailAddrs().size() == 0 && ComposeUI.e(this.mfG.mfs).boY() && ComposeUI.f(this.mfG.mfs).boY()) {
            ComposeUI.z(this.mfG.mfs).setVisibility(0);
            ComposeUI.A(this.mfG.mfs).setVisibility(8);
            ComposeUI.B(this.mfG.mfs).setVisibility(8);
        }
    }
}
