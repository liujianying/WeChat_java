package com.tencent.mm.plugin.websearch.api;

import android.net.Uri;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.aa.2;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.b;

class aa$7 implements Runnable {
    final /* synthetic */ aa pMf;
    final /* synthetic */ String val$url;

    aa$7(aa aaVar, String str) {
        this.pMf = aaVar;
        this.val$url = str;
    }

    public final void run() {
        aa aaVar = this.pMf;
        String str = this.val$url;
        try {
            x.i(aaVar.TAG, "preLoadWebView cached webview size %d", new Object[]{Integer.valueOf(aaVar.pMd.size())});
            if (aaVar.pMd.size() <= 0) {
                aaVar.pMe = System.currentTimeMillis();
                MMWebView bTf = aaVar.bTf();
                if (bTf == null) {
                    x.w(aaVar.TAG, "create webview fail");
                } else {
                    aaVar.pMc = false;
                    x.i(aaVar.TAG, "preload %s", new Object[]{bTf.toString()});
                    bTf.setPreload(true);
                    bTf.setRandomStr(bi.Dc(16));
                    bTf.getSettings().setJavaScriptEnabled(true);
                    bTf.getSettings().setPluginsEnabled(true);
                    bTf.getSettings().cIv();
                    bTf.getSettings().setBuiltInZoomControls(false);
                    bTf.getSettings().setUseWideViewPort(true);
                    bTf.getSettings().setLoadWithOverviewMode(true);
                    bTf.getSettings().cIq();
                    bTf.getSettings().cIp();
                    bTf.getSettings().setGeolocationEnabled(true);
                    bTf.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                    bTf.getSettings().cIx();
                    bTf.getSettings().cIt();
                    bTf.getSettings().setAppCachePath(bTf.getContext().getDir("webviewcache", 0).getAbsolutePath());
                    bTf.getSettings().cIs();
                    bTf.getSettings().cIu();
                    bTf.getSettings().setDatabasePath(e.duM + "databases/");
                    b.cIi().cIj();
                    b.cIi().c(bTf);
                    bTf.getSettings().setUserAgentString(y.aV(bTf.getContext(), bTf.getSettings().getUserAgentString()));
                    w wVar = new w();
                    bTf.addJavascriptInterface(wVar, "__wx");
                    bTf.loadUrl(str);
                    bTf.setWebViewClient(new 2(aaVar, bTf));
                    Uri parse = Uri.parse(str);
                    aaVar.pMd.add(new ab(bTf, parse.getQueryParameter("sessionId"), parse.getQueryParameter("subSessionId"), wVar));
                    h.mEJ.h(15005, new Object[]{Integer.valueOf(aaVar.pMb), Integer.valueOf(1), Integer.valueOf(0)});
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace(aaVar.TAG, e, "", new Object[0]);
        }
        this.pMf.done();
    }
}
