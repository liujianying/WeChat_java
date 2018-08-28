package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.bg.d;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class JsApiAddNativeDownloadTask extends a {
    private static final int CTRL_INDEX = 428;
    private static final String NAME = "addNativeDownloadTask";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        super.a(lVar, jSONObject, i);
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiAddNativeDownloadTask", "data is null");
            lVar.E(i, f("fail:data is null", null));
            return;
        }
        String optString = jSONObject.optString("taskName");
        String optString2 = jSONObject.optString("taskUrl");
        long j = bi.getLong(jSONObject.optString("taskSize"), 0);
        String optString3 = jSONObject.optString("fileMD5");
        String optString4 = jSONObject.optString("thumbUrl");
        String optString5 = jSONObject.optString("title");
        final Context context = lVar.getContext();
        x.i("MicroMsg.JsApiAddNativeDownloadTask", "taskUrl : %s, taskSize : %s, fileMD5:[%s], title : %s, thumbUrl : %s", new Object[]{optString2, Long.valueOf(j), optString3, optString5, optString4});
        if (!ao.isNetworkConnected(context)) {
            lVar.E(i, f("fail:fail network not connected", null));
            ah.A(new 1(this, context));
            x.i("MicroMsg.JsApiAddNativeDownloadTask", "fail, network not ready");
        } else if (!f.zZ()) {
            lVar.E(i, f("fail:fail sdcard not ready", null));
            ah.A(new Runnable() {
                public final void run() {
                    Toast.makeText(context, context.getString(j.game_download_sdcard_unavailable), 0).show();
                }
            });
            x.i("MicroMsg.JsApiAddNativeDownloadTask", "fail, sdcard not ready");
        } else if (j > 0 && !f.aM(j)) {
            lVar.E(i, f("fail:fail sdcard has not enough space", null));
            ah.A(new 3(this, context));
            x.i("MicroMsg.JsApiAddNativeDownloadTask", "fail, not enough space, require size = " + j);
        } else if (bi.oW(optString2)) {
            x.e("MicroMsg.JsApiAddNativeDownloadTask", "doAddDownloadTask fail, url is null");
            lVar.E(i, f("fail:taskUrl is null or nil", null));
        } else {
            Intent intent = new Intent();
            intent.putExtra("task_name", optString);
            intent.putExtra("task_url", optString2);
            intent.putExtra("task_size", j);
            intent.putExtra("file_md5", optString3);
            intent.putExtra("appid", lVar.mAppId);
            intent.putExtra("thumb_url", optString4);
            intent.putExtra("title", optString5);
            p d = d(lVar);
            if (d != null) {
                intent.putExtra("page_url", d.getURL());
            } else {
                x.e("MicroMsg.JsApiAddNativeDownloadTask", "getCurrentPageView is null");
            }
            intent.putExtra("page_scene", 1);
            d.b(context, "webview", ".ui.tools.WebViewDownloadUI", intent);
            AddNativeDownloadTaskTask addNativeDownloadTaskTask = new AddNativeDownloadTaskTask();
            addNativeDownloadTaskTask.fFC = new 4(this, addNativeDownloadTaskTask, lVar, i);
            addNativeDownloadTaskTask.ahA();
            AppBrandMainProcessService.a(addNativeDownloadTaskTask);
        }
    }
}
