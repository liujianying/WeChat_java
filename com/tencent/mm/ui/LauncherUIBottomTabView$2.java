package com.tencent.mm.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class LauncherUIBottomTabView$2 extends ag {
    final /* synthetic */ LauncherUIBottomTabView tlb;

    LauncherUIBottomTabView$2(LauncherUIBottomTabView launcherUIBottomTabView) {
        this.tlb = launcherUIBottomTabView;
    }

    public final void handleMessage(Message message) {
        x.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUIBottomTabView.d(this.tlb).oV(0);
    }
}
