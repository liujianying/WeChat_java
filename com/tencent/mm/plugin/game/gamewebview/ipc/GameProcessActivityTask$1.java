package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;

class GameProcessActivityTask$1 implements a {
    final /* synthetic */ GameProcessActivityTask jGi;

    GameProcessActivityTask$1(GameProcessActivityTask gameProcessActivityTask) {
        this.jGi = gameProcessActivityTask;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == (this.jGi.hashCode() & 65535) && intent != null) {
            GameProcessActivityTask gameProcessActivityTask = (GameProcessActivityTask) intent.getParcelableExtra("task_object");
            GameProcessActivityTask Dd = GameProcessActivityTask.Dd(intent.getStringExtra("task_id"));
            if (Dd == null) {
                x.e("MicroMsg.GameProcessActivityTask", "task is null");
                return;
            }
            GameProcessActivityTask.a(gameProcessActivityTask, Dd);
            GameProcessActivityTask.fEi.remove(Dd);
            Dd.aaj();
            this.jGi.mContext = null;
        }
    }
}
