package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask.a;
import com.tencent.mm.sdk.platformtools.x;

class GameIpcProxyUI$1 implements a {
    final /* synthetic */ String fEg;
    final /* synthetic */ GameProcessActivityTask jIC;
    final /* synthetic */ GameIpcProxyUI jID;

    GameIpcProxyUI$1(GameIpcProxyUI gameIpcProxyUI, GameProcessActivityTask gameProcessActivityTask, String str) {
        this.jID = gameIpcProxyUI;
        this.jIC = gameProcessActivityTask;
        this.fEg = str;
    }

    public final void ahz() {
        x.i("MicroMsg.GameIpcProxyUI", "onResult");
        Intent intent = new Intent();
        intent.putExtra("task_object", this.jIC);
        intent.putExtra("task_id", this.fEg);
        this.jID.setResult(-1, intent);
        this.jID.finish();
    }
}
