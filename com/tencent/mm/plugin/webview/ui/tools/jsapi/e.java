package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.util.Base64;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;

public final class e implements b {
    private MMWebView dEn;
    private d qfM;

    public e(MMWebView mMWebView, d dVar) {
        this.dEn = mMWebView;
        this.qfM = dVar;
    }

    public final boolean Dt(String str) {
        if (bi.oW(str)) {
            return false;
        }
        return s.fj(str, "weixin://private/setresult/");
    }

    public final boolean Du(String str) {
        String str2 = null;
        if (this.dEn != null) {
            this.dEn.evaluateJavascript("javascript:WeixinJSBridge._continueSetResult()", null);
        }
        String substring = str.substring(27);
        if (bi.oW(substring)) {
            x.e("MicroMsg.JsApiResultHandler", "SetResultHandler handleUrl fail, value is null");
            return false;
        }
        int indexOf = substring.indexOf("&");
        if (indexOf <= 0) {
            x.e("MicroMsg.JsApiResultHandler", "SetResultHandler, handleUrl fail, invalid splitorIdx = %d", new Object[]{Integer.valueOf(indexOf)});
            return false;
        }
        byte[] decode;
        String substring2 = substring.substring(0, indexOf);
        try {
            decode = Base64.decode(substring.substring(indexOf + 1), 0);
        } catch (Exception e) {
            x.e("MicroMsg.JsApiResultHandler", "SetResultHandler decodeBase64 failed");
            decode = null;
        }
        if (decode != null) {
            str2 = new String(decode);
        }
        x.i("MicroMsg.JsApiResultHandler", "SetResultHandler, scene = %s, result = %s", new Object[]{substring2, str2});
        this.qfM.keep_setReturnValue(substring2, str2);
        return true;
    }
}
