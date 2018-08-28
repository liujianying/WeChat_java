package com.tencent.mm.plugin.game.gamewebview.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.model.FavUrlTask;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.d;

class i$8 implements d {
    final /* synthetic */ i jKv;

    i$8(i iVar) {
        this.jKv = iVar;
    }

    public final void bx(int i, int i2) {
        switch (i2) {
            case -1:
                Bundle bundle = new Bundle();
                bundle.putLong("fav_local_id", this.jKv.getBundle().getLong("fav_local_id", -1));
                FavUrlTask favUrlTask = new FavUrlTask();
                favUrlTask.actionType = 4;
                favUrlTask.jfZ = bundle;
                GameWebViewMainProcessService.b(favUrlTask);
                if (favUrlTask.bGZ) {
                    x.i("MicroMsg.OptionMenuBtnHelp", "del fav web url ok, finish webview ui");
                    this.jKv.jIJ.finish();
                    return;
                }
                return;
            default:
                x.i("MicroMsg.OptionMenuBtnHelp", "do del cancel");
                return;
        }
    }
}
