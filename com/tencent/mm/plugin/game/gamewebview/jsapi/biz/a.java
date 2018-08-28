package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.game.gamewebview.jsapi.a {
    public static final int CTRL_BYTE = 269;
    public static final String NAME = "addDownloadTaskStraight";

    public final void a(final d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiAddDownloadTaskStraight", "invoke");
        Context pageActivity = dVar.getPageActivity();
        String optString = jSONObject.optString("task_url");
        long optLong = jSONObject.optLong("task_size");
        if (bi.oW(optString)) {
            x.e("MicroMsg.GameJsApiAddDownloadTaskStraight", "url is null");
            dVar.E(i, com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("add_download_task:fail", null));
        } else if (!ao.isNetworkConnected(dVar.getContext())) {
            dVar.E(i, com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("add_download_task:fail_network_not_connected", null));
            com.tencent.mm.plugin.game.gamewebview.a.d.runOnUiThread(new 1(this, dVar));
            x.i("MicroMsg.GameJsApiAddDownloadTaskStraight", " fail, network not ready");
        } else if (!f.zZ()) {
            dVar.E(i, com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("add_download_task:fail_sdcard_not_ready", null));
            com.tencent.mm.plugin.game.gamewebview.a.d.runOnUiThread(new 2(this, dVar));
            x.i("MicroMsg.GameJsApiAddDownloadTaskStraight", " fail, sdcard not ready");
        } else if (optLong > 0 && !f.aM(optLong)) {
            dVar.E(i, com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("add_download_task:fail_has_not_enough_space", null));
            com.tencent.mm.plugin.game.gamewebview.a.d.runOnUiThread(new Runnable() {
                public final void run() {
                    Toast.makeText(dVar.getContext(), dVar.getContext().getString(R.l.game_download_not_enough_space), 0).show();
                }
            });
            x.i("MicroMsg.GameJsApiAddDownloadTaskStraight", "fail, not enough space, require size = " + optLong);
        } else if (ao.isWifi(pageActivity)) {
            b(dVar, jSONObject, i);
        } else {
            h.a(pageActivity, pageActivity.getString(R.l.webview_download_ui_download_not_in_wifi_tips), pageActivity.getString(R.l.webview_download_ui_download_not_in_wifi_title), pageActivity.getString(R.l.webview_download_ui_btn_state_to_download), pageActivity.getString(R.l.app_cancel), false, new 4(this, dVar, jSONObject, i), new 5(this, dVar, i), R.e.wechat_green);
        }
    }

    static void b(d dVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("task_name");
        String optString2 = jSONObject.optString("task_url");
        String optString3 = jSONObject.optString("alternative_url");
        long optLong = jSONObject.optLong("task_size");
        String optString4 = jSONObject.optString("file_md5");
        String optString5 = jSONObject.optString("extInfo");
        String optString6 = jSONObject.optString("fileType");
        String optString7 = jSONObject.optString("appid");
        String optString8 = jSONObject.optString("packageName");
        int optInt = jSONObject.optInt("scene", 1000);
        DoDownloadTask doDownloadTask = new DoDownloadTask();
        doDownloadTask.type = 1;
        doDownloadTask.jGC = optString;
        doDownloadTask.url = optString2;
        doDownloadTask.jGD = optString3;
        doDownloadTask.bKg = optString4;
        doDownloadTask.extInfo = optString5;
        doDownloadTask.jGE = optString6;
        doDownloadTask.appId = optString7;
        doDownloadTask.packageName = optString8;
        doDownloadTask.fHs = optLong;
        doDownloadTask.scene = optInt;
        GameWebViewMainProcessService.b(doDownloadTask);
        if (doDownloadTask.bGm <= 0) {
            x.e("MicroMsg.GameJsApiAddDownloadTaskStraight", "fail, downloadId = " + doDownloadTask.bGm);
            dVar.E(i, com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("add_download_task:fail", null));
            return;
        }
        Map hashMap = new HashMap();
        hashMap.put("download_id", Long.valueOf(doDownloadTask.bGm));
        dVar.E(i, f("add_download_task:ok", hashMap));
    }
}
