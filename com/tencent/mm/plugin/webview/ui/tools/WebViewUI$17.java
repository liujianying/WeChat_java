package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.regex.Pattern;

class WebViewUI$17 implements DownloadListener {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$17(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        int i = 1;
        x.i("MicroMsg.WebViewUI", "edw onDownloadStart, url = " + str + ", mimetype = " + str4 + ", userAgent = " + str2);
        int intExtra = this.pZJ.getIntent().getIntExtra("key_download_restrict", 0);
        if (!bi.oW(this.pZJ.getIntent().getStringExtra("key_function_id"))) {
            h.mEJ.h(14596, new Object[]{this.pZJ.getIntent().getStringExtra("key_function_id"), Integer.valueOf(intExtra), Integer.valueOf(0)});
        }
        if (intExtra == 1) {
            x.e("MicroMsg.WebViewUI", "not allow download file : %s", new Object[]{str});
            return;
        }
        if (str4 == null || !str4.equalsIgnoreCase("application/vnd.android.package-archive")) {
            intExtra = 0;
        } else {
            x.v("MicroMsg.WebViewUI", "edw onDownloadStart, report download url: %s", new Object[]{str});
            d.a(this.pZJ.gcO, 11154, str);
            intExtra = 1;
        }
        if (this.pZJ.gcP == null || this.pZJ.gcP.bVR() == null) {
            x.e("MicroMsg.WebViewUI", "onDownloadStart fail, wvPerm is null");
            return;
        }
        if (str4 != null) {
            x.i("MicroMsg.WebViewUI", "onDownloadStart configOpen:%s", new Object[]{Boolean.valueOf(WebViewUI.E(this.pZJ))});
            CharSequence Rt = WebViewUI.Rt(str3);
            int i2 = (Rt == null || !Pattern.matches("(?i).*\\.(doc|ppt|xls|docx|pptx|xlsx|wps|dps|et|txt|pdf)$", Rt)) ? 0 : 1;
            boolean contains = a.qgW.contains(str4.toLowerCase());
            if (!r4 || (i2 == 0 && !contains)) {
                i = 0;
            }
        } else {
            i = 0;
        }
        if (i == 0 && !this.pZJ.gcP.bVR().gu(24) && !WebViewUI.F(this.pZJ)) {
            x.e("MicroMsg.WebViewUI", "onDownloadStart permission fail");
        } else if (intExtra != 0) {
            WebViewUI.a(this.pZJ, str, j);
        } else {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            try {
                this.pZJ.startActivity(intent);
            } catch (Exception e) {
                x.e("MicroMsg.WebViewUI", "startActivity fail, e = " + e.getMessage());
            }
        }
    }
}
