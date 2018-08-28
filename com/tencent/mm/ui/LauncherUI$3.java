package com.tencent.mm.ui;

import com.tencent.mm.g.a.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.s;

class LauncherUI$3 implements Runnable {
    final /* synthetic */ LauncherUI tkA;

    LauncherUI$3(LauncherUI launcherUI) {
        this.tkA = launcherUI;
    }

    public final void run() {
        au.hold();
        a.sFg.m(new w());
        g.Ek().gi("switch account ,delay logout");
        if (s.a(this.tkA.getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) {
            LauncherUI.b(this.tkA);
        }
        LauncherUI.a(this.tkA, this.tkA);
        au.unhold();
    }
}
