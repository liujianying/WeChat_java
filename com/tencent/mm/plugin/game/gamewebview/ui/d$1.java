package com.tencent.mm.plugin.game.gamewebview.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.game.gamewebview.ipc.CommonLogicTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.webview.ui.tools.game.c;

class d$1 extends c {
    final /* synthetic */ d jJO;

    d$1(d dVar) {
        this.jJO = dVar;
    }

    protected final void A(Bundle bundle) {
        CommonLogicTask commonLogicTask = new CommonLogicTask();
        commonLogicTask.type = 11;
        commonLogicTask.jfZ = bundle;
        GameWebViewMainProcessService.b(commonLogicTask);
    }
}
