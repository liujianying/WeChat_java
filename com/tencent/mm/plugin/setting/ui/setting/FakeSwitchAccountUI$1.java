package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class FakeSwitchAccountUI$1 implements a {
    final /* synthetic */ FakeSwitchAccountUI mPX;

    FakeSwitchAccountUI$1(FakeSwitchAccountUI fakeSwitchAccountUI) {
        this.mPX = fakeSwitchAccountUI;
    }

    public final boolean vD() {
        int a = FakeSwitchAccountUI.a(this.mPX);
        x.i("MicroMsg.FakeSwitchAccountUI", "oldPid %d, mm pid %d", new Object[]{Integer.valueOf(FakeSwitchAccountUI.b(this.mPX)), Integer.valueOf(a)});
        if (FakeSwitchAccountUI.b(this.mPX) == 0 || a == 0 || FakeSwitchAccountUI.b(this.mPX) == a) {
            FakeSwitchAccountUI.d(this.mPX);
            if (FakeSwitchAccountUI.c(this.mPX) <= 20) {
                return true;
            }
            FakeSwitchAccountUI.e(this.mPX);
            return false;
        } else if (FakeSwitchAccountUI.c(this.mPX) <= 0) {
            FakeSwitchAccountUI.d(this.mPX);
            return true;
        } else {
            FakeSwitchAccountUI.e(this.mPX);
            return false;
        }
    }
}
