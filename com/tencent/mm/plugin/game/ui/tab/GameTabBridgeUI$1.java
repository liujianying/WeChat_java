package com.tencent.mm.plugin.game.ui.tab;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.sdk.platformtools.ah;

class GameTabBridgeUI$1 implements c<Bundle> {
    final /* synthetic */ long dUQ;
    final /* synthetic */ GameTabBridgeUI kcV;
    final /* synthetic */ Intent val$intent;

    GameTabBridgeUI$1(GameTabBridgeUI gameTabBridgeUI, long j, Intent intent) {
        this.kcV = gameTabBridgeUI;
        this.dUQ = j;
        this.val$intent = intent;
    }

    public final /* synthetic */ void at(Object obj) {
        ah.A(new 1(this));
    }
}
