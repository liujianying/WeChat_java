package com.tencent.mm.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class LauncherUITabView$2 extends ag {
    final /* synthetic */ LauncherUITabView tlq;

    LauncherUITabView$2(LauncherUITabView launcherUITabView) {
        this.tlq = launcherUITabView;
    }

    public final void handleMessage(Message message) {
        x.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUITabView.d(this.tlq).oV(0);
    }
}
