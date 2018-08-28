package com.tencent.mm.plugin.game.ui.tab;

import com.tencent.mm.plugin.game.ui.tab.GameTabBridgeUI.1;
import com.tencent.mm.sdk.platformtools.x;

class GameTabBridgeUI$1$1 implements Runnable {
    final /* synthetic */ 1 kcW;

    GameTabBridgeUI$1$1(1 1) {
        this.kcW = 1;
    }

    public final void run() {
        x.i("MicroMsg.GameTabBridgeUI", "load tools process, web page load time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - this.kcW.dUQ)});
        if (GameTabWidget.kda == this.kcW.kcV.hashCode()) {
            GameTabWidget.a(this.kcW.kcV, this.kcW.val$intent, false, true, true, false);
            return;
        }
        x.i("MicroMsg.GameTabBridgeUI", "GameTabWidget.mHashCode(%d) != hashCode(%d), dont need turn page!", new Object[]{Integer.valueOf(GameTabWidget.kda), Integer.valueOf(this.kcW.kcV.hashCode())});
    }
}
