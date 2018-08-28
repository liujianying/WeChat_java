package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

class WebViewUI$u implements b {
    final /* synthetic */ WebViewUI pZJ;

    private WebViewUI$u(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    /* synthetic */ WebViewUI$u(WebViewUI webViewUI, byte b) {
        this(webViewUI);
    }

    public final boolean Dt(String str) {
        if (bi.oW(str)) {
            return false;
        }
        return s.fj(str, "weixin://readershare/");
    }

    public final boolean Du(String str) {
        h.a(this.pZJ, "", new String[]{this.pZJ.getString(R.l.readerapp_share_weibo)}, "", new c() {
            public final void ju(int i) {
                if (i == 0) {
                    WebViewUI$u webViewUI$u = WebViewUI$u.this;
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString("shortUrl", webViewUI$u.pZJ.getIntent().getStringExtra("shortUrl"));
                        bundle.putInt(DownloadSettingTable$Columns.TYPE, webViewUI$u.pZJ.getIntent().getIntExtra(DownloadSettingTable$Columns.TYPE, 0));
                        webViewUI$u.pZJ.gcO.a(4, bundle, webViewUI$u.hashCode());
                    } catch (Exception e) {
                        x.e("MicroMsg.WebViewUI", "share fail, ex = " + e.getMessage());
                    }
                }
            }
        });
        return true;
    }
}
