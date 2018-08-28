package com.tencent.mm.plugin.game.ui.tab;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;

class GameTabWebUI$2 extends BroadcastReceiver {
    final /* synthetic */ GameTabWebUI kcZ;

    GameTabWebUI$2(GameTabWebUI gameTabWebUI) {
        this.kcZ = gameTabWebUI;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null && "com.tencent.mm.ACTION_EXIT".equals(intent.getAction()) && GameTabWebUI.b(this.kcZ) != null && !GameTabWebUI.b(this.kcZ).isFinishing()) {
            x.i("MicroMsg.GameTabWebUI", "%s exit!", new Object[]{GameTabWebUI.b(this.kcZ).getClass().getSimpleName()});
            GameTabWebUI.b(this.kcZ).finish();
        }
    }
}
