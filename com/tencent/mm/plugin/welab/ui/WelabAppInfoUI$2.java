package com.tencent.mm.plugin.welab.ui;

import com.tencent.mm.ui.widget.MMSwitchBtn$a;

class WelabAppInfoUI$2 implements MMSwitchBtn$a {
    final /* synthetic */ WelabAppInfoUI qng;

    WelabAppInfoUI$2(WelabAppInfoUI welabAppInfoUI) {
        this.qng = welabAppInfoUI;
    }

    public final void cf(boolean z) {
        if (WelabAppInfoUI.a(this.qng).field_Switch == 2) {
            WelabAppInfoUI.a(this.qng).field_Switch = 1;
        } else if (WelabAppInfoUI.a(this.qng).field_Switch == 1) {
            WelabAppInfoUI.a(this.qng).field_Switch = 2;
        }
    }
}
