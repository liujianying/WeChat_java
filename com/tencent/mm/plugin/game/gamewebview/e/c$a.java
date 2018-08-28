package com.tencent.mm.plugin.game.gamewebview.e;

import android.os.Bundle;
import com.tencent.mm.plugin.game.gamewebview.ipc.CommonLogicTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class c$a implements b {
    final /* synthetic */ c jKY;

    private c$a(c cVar) {
        this.jKY = cVar;
    }

    /* synthetic */ c$a(c cVar, byte b) {
        this(cVar);
    }

    public final boolean Dt(String str) {
        if (bi.oW(str)) {
            return false;
        }
        return s.fj(str, "weixin://jump/");
    }

    public final boolean Du(String str) {
        if (this.jKY.gcP == null || !this.jKY.gcP.bVS().cgg()) {
            x.e("MicroMsg.UrlHandler", "ActivityJumpHandler not allow, no inner url generalcontrol, url = %s", new Object[]{str});
        } else {
            CommonLogicTask commonLogicTask = new CommonLogicTask();
            commonLogicTask.type = 1;
            Bundle bundle = new Bundle();
            bundle.putBoolean("permission_allow", this.jKY.gcP.bVR().gu(7));
            bundle.putString("url", str);
            commonLogicTask.jfZ = bundle;
            GameWebViewMainProcessService.a(commonLogicTask);
        }
        return true;
    }
}
