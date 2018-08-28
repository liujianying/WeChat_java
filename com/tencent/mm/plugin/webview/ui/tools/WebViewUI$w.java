package com.tencent.mm.plugin.webview.ui.tools;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.OpenWebview.Resp;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$w implements b {
    final /* synthetic */ WebViewUI pZJ;
    private final String qaQ;

    private WebViewUI$w(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
        this.qaQ = "weixin://openapi/openwebview/result?";
    }

    /* synthetic */ WebViewUI$w(WebViewUI webViewUI, byte b) {
        this(webViewUI);
    }

    public final boolean Dt(String str) {
        if (bi.oW(str)) {
            return false;
        }
        return s.fj(str, "weixin://openapi/openwebview/result?");
    }

    public final boolean Du(String str) {
        Resp resp = new Resp();
        Uri parse = Uri.parse(str);
        resp.result = parse.getQuery();
        resp.errCode = bi.getInt(parse.getQueryParameter("errCode"), 0);
        resp.errStr = parse.getQueryParameter("errMsg");
        resp.transaction = this.pZJ.getIntent().getStringExtra("transaction_for_openapi_openwebview");
        String queryParameter = parse.getQueryParameter("appid");
        if (bi.oW(queryParameter)) {
            x.e("MicroMsg.WebViewUI", "SDKOpenWebViewResultHandler handleUrl, appId is null");
        } else {
            Bundle bundle = new Bundle();
            resp.toBundle(bundle);
            p.ae(bundle);
            Args args = new Args();
            try {
                args.targetPkgName = this.pZJ.gcO.QR(queryParameter);
                args.bundle = bundle;
                x.d("MicroMsg.WebViewUI", "SDKOpenWebViewResultHandler, handleUrl, sendResp:%s", new Object[]{args});
                MMessageActV2.send(this.pZJ, args);
                this.pZJ.finish();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[0]);
            }
        }
        return true;
    }
}
