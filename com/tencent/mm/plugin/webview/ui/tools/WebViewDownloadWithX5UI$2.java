package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;

class WebViewDownloadWithX5UI$2 implements OnClickListener {
    final /* synthetic */ String pWG;
    final /* synthetic */ WebViewDownloadWithX5UI pWO;
    final /* synthetic */ long pWP;
    final /* synthetic */ String val$url;

    WebViewDownloadWithX5UI$2(WebViewDownloadWithX5UI webViewDownloadWithX5UI, long j, String str, String str2) {
        this.pWO = webViewDownloadWithX5UI;
        this.pWP = j;
        this.val$url = str;
        this.pWG = str2;
    }

    public final void onClick(View view) {
        if (ao.isNetworkConnected(WebViewDownloadWithX5UI.a(this.pWO))) {
            au.HU();
            if (!c.isSDCardAvailable()) {
                Toast.makeText(WebViewDownloadWithX5UI.a(this.pWO), this.pWO.getString(R.l.game_download_sdcard_unavailable), 0).show();
                x.i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, sdcard not ready");
                return;
            } else if (this.pWP > 0 && !f.aM(this.pWP)) {
                Toast.makeText(WebViewDownloadWithX5UI.a(this.pWO), this.pWO.getString(R.l.game_download_not_enough_space), 0).show();
                x.i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, not enough space, require size = " + this.pWP);
                return;
            } else if (ao.isWifi(WebViewDownloadWithX5UI.a(this.pWO))) {
                WebViewDownloadWithX5UI.a(this.pWO, this.val$url, this.pWG);
                return;
            } else {
                h.mEJ.h(14217, new Object[]{"", Integer.valueOf(4), this.pWG, this.val$url, Integer.valueOf(1)});
                com.tencent.mm.ui.base.h.a(this.pWO, this.pWO.getString(R.l.webview_download_ui_download_not_in_wifi_tips), this.pWO.getString(R.l.webview_download_ui_download_not_in_wifi_title), this.pWO.getString(R.l.webview_download_ui_btn_state_to_download), this.pWO.getString(R.l.app_cancel), false, new 1(this), new 2(this), R.e.wechat_green);
                return;
            }
        }
        Toast.makeText(WebViewDownloadWithX5UI.a(this.pWO), this.pWO.getString(R.l.game_download_network_unavailable), 0).show();
        x.i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, network not ready");
    }
}
