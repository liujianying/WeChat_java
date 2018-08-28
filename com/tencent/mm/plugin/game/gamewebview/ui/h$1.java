package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.model.QBarLogicTask;
import com.tencent.mm.plugin.webview.modeltools.f$c;

class h$1 implements f$c {
    final /* synthetic */ h jKm;

    h$1(h hVar) {
        this.jKm = hVar;
    }

    public final void ug(String str) {
        QBarLogicTask qBarLogicTask = new QBarLogicTask();
        qBarLogicTask.type = 1;
        qBarLogicTask.bSw = str;
        GameWebViewMainProcessService.a(qBarLogicTask);
    }
}
