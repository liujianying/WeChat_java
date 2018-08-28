package com.tencent.mm.plugin.game.gamewebview.e;

import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.ipc.CommonLogicTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class c$b implements b {
    final /* synthetic */ c jKY;

    private c$b(c cVar) {
        this.jKY = cVar;
    }

    /* synthetic */ c$b(c cVar, byte b) {
        this(cVar);
    }

    public final boolean Dt(String str) {
        if (bi.oW(str)) {
            return false;
        }
        return s.fj(str, "weixin://");
    }

    public final boolean Du(String str) {
        if (!d.al(str, this.jKY.jKX)) {
            return false;
        }
        try {
            CommonLogicTask commonLogicTask = new CommonLogicTask();
            if ("weixin://dl/posts".equals(str)) {
                commonLogicTask.type = 3;
                GameWebViewMainProcessService.a(commonLogicTask);
                return true;
            } else if ("weixin://dl/moments".equals(str)) {
                commonLogicTask.type = 4;
                GameWebViewMainProcessService.a(commonLogicTask);
                return true;
            } else if ("weixin://dl/scan".equals(str)) {
                com.tencent.mm.bg.d.c(ad.getContext(), "scanner", ".ui.SingleTopScanUI", new Intent());
                return true;
            } else {
                d.SD(str);
                return true;
            }
        } catch (Exception e) {
            x.e("MicroMsg.UrlHandler", "kv report fail, ex = %s", new Object[]{e.getMessage()});
            return true;
        }
    }
}
