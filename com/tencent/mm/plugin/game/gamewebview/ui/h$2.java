package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.model.QBarLogicTask;

class h$2 implements OnCancelListener {
    final /* synthetic */ h jKm;

    h$2(h hVar) {
        this.jKm = hVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.jKm.gcU != null) {
            GWMainProcessTask qBarLogicTask = new QBarLogicTask();
            qBarLogicTask.type = 1;
            qBarLogicTask.bSw = this.jKm.gcU.pUp;
            GameWebViewMainProcessService.a(qBarLogicTask);
            this.jKm.gcU.bVc();
        }
    }
}
