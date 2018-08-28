package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import org.json.JSONObject;

public final class x extends a {
    public static final int CTRL_BYTE = 41;
    public static final String NAME = "installDownloadTask";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.GameJsApiGetNetworkType", "invoke");
        if (jSONObject != null) {
            long optLong = jSONObject.optLong("download_id", -1);
            if (optLong > 0) {
                DoDownloadTask doDownloadTask = new DoDownloadTask();
                doDownloadTask.type = 5;
                doDownloadTask.bGm = optLong;
                GameWebViewMainProcessService.b(doDownloadTask);
                if (doDownloadTask.bJm) {
                    dVar.E(i, a.f("install_download_task:ok", null));
                    return;
                } else {
                    dVar.E(i, a.f("install_download_task:fail", null));
                    return;
                }
            }
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.GameJsApiGetNetworkType", "data is null");
        dVar.E(i, a.f("install_download_task:fail_invalid_data", null));
    }
}
