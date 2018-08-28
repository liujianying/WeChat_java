package com.tencent.mm.ui.conversation;

import com.tencent.mm.ui.LauncherUI;

class m$10 implements Runnable {
    final /* synthetic */ m urw;

    m$10(m mVar) {
        this.urw = mVar;
    }

    public final void run() {
        m mVar = this.urw;
        LauncherUI launcherUI = (LauncherUI) mVar.bOb;
        if (launcherUI == null || launcherUI.tkn.tjF.iUy == 0) {
            mVar.uqX.coE();
        }
    }
}
