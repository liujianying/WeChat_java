package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.webview.ui.tools.widget.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.f.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public final class h extends a {
    public h(Context context, s sVar, ViewGroup viewGroup) {
        super(context, sVar, viewGroup);
    }

    protected final void bzQ() {
        if (((x) bzL()) != null) {
            String str;
            WebView webView = (WebView) getView();
            x xVar = (x) bzL();
            if (TextUtils.isEmpty(xVar.url) || TextUtils.isEmpty(xVar.ntU)) {
                str = xVar.url;
            } else {
                String uin = AdLandingPagesProxy.getInstance().getUin();
                String l = ad.l(xVar.url, new String[]{"uxinfo=" + xVar.ntU, "uin=" + uin});
                if (xVar.bID == 1) {
                    str = AdLandingPagesProxy.getInstance().getAdVoteInfo(xVar.url, xVar.ntU, uin);
                    if (!bi.oW(str)) {
                        str = l + "&" + str;
                    }
                }
                str = l;
            }
            webView.loadUrl(str);
        }
    }

    protected final View bzR() {
        MMWebView cS = a.qkE.cS(this.context);
        cS.getSettings().cIs();
        cS.getSettings().cIw();
        cS.getSettings().cIv();
        cS.setWebViewClient(c.a.qkD.a(cS, new d() {
            public final boolean c(int i, Bundle bundle) {
                switch (i) {
                    case 150:
                        x xVar = (x) h.this.bzL();
                        AdLandingPagesProxy.getInstance().saveAdVoteInfo(xVar.url, xVar.ntU, xVar.uin, bundle.getInt("sns_landing_pages_ad_vote_index"), 0);
                        break;
                }
                return false;
            }
        }));
        return cS;
    }

    public final void bzz() {
        super.bzz();
        WebView webView = (WebView) getView();
        if (!(webView == null || webView.getParent() == null)) {
            ((ViewGroup) webView.getParent()).removeView(webView);
            webView.setTag(null);
            webView.destroy();
        }
        this.contentView = null;
    }
}
