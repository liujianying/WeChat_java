package com.tencent.mm.plugin.account.security.ui;

import com.tencent.mm.ui.widget.MMEditText.b;

class ModSafeDeviceNameUI$3 implements b {
    final /* synthetic */ ModSafeDeviceNameUI eOB;

    ModSafeDeviceNameUI$3(ModSafeDeviceNameUI modSafeDeviceNameUI) {
        this.eOB = modSafeDeviceNameUI;
    }

    public final void Yr() {
        if (ModSafeDeviceNameUI.a(this.eOB).getText().toString().trim().length() > 0) {
            this.eOB.enableOptionMenu(true);
        } else {
            this.eOB.enableOptionMenu(false);
        }
    }
}
