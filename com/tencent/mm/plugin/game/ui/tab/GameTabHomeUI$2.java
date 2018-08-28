package com.tencent.mm.plugin.game.ui.tab;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;

class GameTabHomeUI$2 extends BroadcastReceiver {
    final /* synthetic */ GameTabHomeUI kcY;

    GameTabHomeUI$2(GameTabHomeUI gameTabHomeUI) {
        this.kcY = gameTabHomeUI;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null && "com.tencent.mm.ACTION_EXIT".equals(intent.getAction()) && this.kcY != null && !this.kcY.isFinishing()) {
            x.i("MicroMsg.GameTabHomeUI", "GameTabHomeUI exit!");
            this.kcY.finish();
        }
    }
}
