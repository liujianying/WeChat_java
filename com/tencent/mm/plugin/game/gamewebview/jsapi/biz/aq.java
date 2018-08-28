package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import org.json.JSONObject;

public final class aq extends a {
    public static final int CTRL_BYTE = 240;
    public static final String NAME = "resumeDownloadTask";
    private long bGm;
    private int scene;

    public final void a(final d dVar, JSONObject jSONObject, final int i) {
        x.i("MicroMsg.GameJsApiResumeDownloadTask", "GameJsApiResumeDownloadTask");
        GameWebViewUI pageActivity = dVar.getPageActivity();
        this.bGm = jSONObject.optLong("download_id");
        this.scene = jSONObject.optInt("scene", 1000);
        if (this.bGm <= 0) {
            x.e("MicroMsg.GameJsApiResumeDownloadTask", "fail, invalid downloadId = " + this.bGm);
            dVar.E(i, a.f("resume_download_task:fail_invalid_downloadid", null));
        } else if (ao.isWifi(pageActivity)) {
            b(dVar, i);
        } else {
            h.a(pageActivity, pageActivity.getString(R.l.webview_download_ui_download_not_in_wifi_tips), pageActivity.getString(R.l.webview_download_ui_download_not_in_wifi_title), pageActivity.getString(R.l.webview_download_ui_btn_state_to_download), pageActivity.getString(R.l.app_cancel), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    aq.this.b(dVar, i);
                    dialogInterface.dismiss();
                }
            }, new 2(this, dVar, i), R.e.wechat_green);
        }
    }

    final void b(d dVar, int i) {
        DoDownloadTask doDownloadTask = new DoDownloadTask();
        doDownloadTask.type = 3;
        doDownloadTask.bGm = this.bGm;
        doDownloadTask.scene = this.scene;
        GameWebViewMainProcessService.b(doDownloadTask);
        if (doDownloadTask.bJm) {
            dVar.E(i, a.f("resume_download_task:ok", null));
        } else {
            dVar.E(i, a.f("resume_download_task:fail", null));
        }
    }
}
