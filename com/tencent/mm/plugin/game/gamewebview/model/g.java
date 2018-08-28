package com.tencent.mm.plugin.game.gamewebview.model;

import com.tencent.mm.plugin.game.gamewebview.ipc.CommonLogicTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.m;
import java.io.InputStream;

public final class g {
    public static m Dj(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.GameWebViewResourceInterrupter", "url is null, return ");
            return null;
        } else if (bi.oW(str) || !str.startsWith("weixin://resourceid/")) {
            return null;
        } else {
            x.i("MicroMsg.GameWebViewResourceInterrupter", "it is wechat resource is, should intercept");
            try {
                m mVar;
                CommonLogicTask commonLogicTask = new CommonLogicTask();
                commonLogicTask.type = 8;
                commonLogicTask.jfZ.putString("localId", str);
                GameWebViewMainProcessService.b(commonLogicTask);
                InputStream Qw = aj.Qw(commonLogicTask.jfZ.getString("file_path"));
                if (Qw != null) {
                    mVar = new m("image/*", "utf-8", Qw);
                } else {
                    mVar = null;
                }
                return mVar;
            } catch (Exception e) {
                x.e("MicroMsg.GameWebViewResourceInterrupter", "get webview jssdk resource failed %s", new Object[]{e.getMessage()});
                return null;
            }
        }
    }
}
