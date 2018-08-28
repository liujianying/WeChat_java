package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI.5;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;

class WebViewDownloadUI$2 implements OnClickListener {
    final /* synthetic */ String bAj;
    final /* synthetic */ String bpQ;
    final /* synthetic */ String fFX;
    final /* synthetic */ String fRy;
    final /* synthetic */ WebViewDownloadUI pWE;
    final /* synthetic */ String pWF;
    final /* synthetic */ String pWG;
    final /* synthetic */ String pWH;
    final /* synthetic */ String val$url;

    WebViewDownloadUI$2(WebViewDownloadUI webViewDownloadUI, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.pWE = webViewDownloadUI;
        this.val$url = str;
        this.fRy = str2;
        this.fFX = str3;
        this.bAj = str4;
        this.pWF = str5;
        this.pWG = str6;
        this.pWH = str7;
        this.bpQ = str8;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick state=%s", new Object[]{WebViewDownloadUI.a(this.pWE)});
        switch (5.pWJ[WebViewDownloadUI.a(this.pWE).ordinal()]) {
            case 1:
                if (!ao.isNetworkConnected(WebViewDownloadUI.b(this.pWE))) {
                    Toast.makeText(WebViewDownloadUI.b(this.pWE), this.pWE.getString(R.l.game_download_network_unavailable), 0).show();
                    x.i("MicroMsg.WebViewDownloadUI", "startDownload fail, network not ready");
                    return;
                } else if (ao.isWifi(WebViewDownloadUI.b(this.pWE))) {
                    WebViewDownloadUI.a(this.pWE, this.val$url, this.fRy, this.fFX, this.bAj, this.pWF, this.pWG, this.pWH, this.bpQ);
                    return;
                } else {
                    h.mEJ.h(14217, new Object[]{this.bAj, Integer.valueOf(4), this.pWG, this.val$url, Integer.valueOf(0)});
                    com.tencent.mm.ui.base.h.a(this.pWE, this.pWE.getString(R.l.webview_download_ui_download_not_in_wifi_tips), this.pWE.getString(R.l.webview_download_ui_download_not_in_wifi_title), this.pWE.getString(R.l.webview_download_ui_btn_state_to_download), this.pWE.getString(R.l.app_cancel), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            h.mEJ.h(14217, new Object[]{WebViewDownloadUI$2.this.bAj, Integer.valueOf(5), WebViewDownloadUI$2.this.pWG, WebViewDownloadUI$2.this.val$url, Integer.valueOf(0)});
                            WebViewDownloadUI.a(WebViewDownloadUI$2.this.pWE, WebViewDownloadUI$2.this.val$url, WebViewDownloadUI$2.this.fRy, WebViewDownloadUI$2.this.fFX, WebViewDownloadUI$2.this.bAj, WebViewDownloadUI$2.this.pWF, WebViewDownloadUI$2.this.pWG, WebViewDownloadUI$2.this.pWH, WebViewDownloadUI$2.this.bpQ);
                            dialogInterface.dismiss();
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            h.mEJ.h(14217, new Object[]{WebViewDownloadUI$2.this.bAj, Integer.valueOf(6), WebViewDownloadUI$2.this.pWG, WebViewDownloadUI$2.this.val$url, Integer.valueOf(0)});
                            dialogInterface.dismiss();
                        }
                    }, R.e.wechat_green);
                    return;
                }
            default:
                x.e("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick unexpected download state");
                return;
        }
    }
}
