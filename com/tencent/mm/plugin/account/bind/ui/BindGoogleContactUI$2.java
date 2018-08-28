package com.tencent.mm.plugin.account.bind.ui;

import android.text.TextUtils;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;

class BindGoogleContactUI$2 extends p {
    final /* synthetic */ BindGoogleContactUI eFm;

    BindGoogleContactUI$2(BindGoogleContactUI bindGoogleContactUI) {
        this.eFm = bindGoogleContactUI;
    }

    public final void a(WebView webView, String str) {
        x.d("MicroMsg.GoogleContact.BindGoogleContactUI", "onPageFinished URL:" + str);
        if (!(BindGoogleContactUI.a(this.eFm) == null || BindGoogleContactUI.a(this.eFm).getVisibility() == 0)) {
            BindGoogleContactUI.a(this.eFm).setVisibility(0);
            if (BindGoogleContactUI.b(this.eFm) != null) {
                BindGoogleContactUI.b(this.eFm).setVisibility(4);
            }
        }
        BindGoogleContactUI.c(this.eFm);
        if (webView != null) {
            String title = webView.getTitle();
            x.d("MicroMsg.GoogleContact.BindGoogleContactUI", "title:%s", new Object[]{title});
            if (!TextUtils.isEmpty(title)) {
                if (title.toLowerCase().contains("success")) {
                    if (BindGoogleContactUI.a(this.eFm) != null) {
                        BindGoogleContactUI.a(this.eFm).setVisibility(4);
                    }
                    s.a(BindGoogleContactUI.a(this.eFm), "weixin://private/googlegetcode", "document.getElementById('code').value");
                } else if (title.toLowerCase().contains("error")) {
                    x.w("MicroMsg.GoogleContact.BindGoogleContactUI", "failed." + title.substring(title.indexOf("=")));
                }
            }
        }
    }

    public final boolean b(WebView webView, String str) {
        x.d("MicroMsg.GoogleContact.BindGoogleContactUI", "shouldOverrideUrlLoading, url = %s", new Object[]{str});
        if (!str.toLowerCase().startsWith("weixin://private/googlegetcode")) {
            return super.b(webView, str);
        }
        BindGoogleContactUI.a(this.eFm, str);
        return true;
    }
}
