package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class ae {
    private static ae pRO = new ae();
    HashMap<String, WebViewJSSDKFileItem> pRP = new HashMap();

    public static final ae bUk() {
        return pRO;
    }

    public final void b(WebViewJSSDKFileItem webViewJSSDKFileItem) {
        if (webViewJSSDKFileItem == null || bi.oW(webViewJSSDKFileItem.bNH)) {
            x.e("MicroMsg.WebViewJSSDKFileItemManager", "item is null or local id is null, ignore this add");
            return;
        }
        x.i("MicroMsg.WebViewJSSDKFileItemManager", "add jssdk file item, local id : %s, file path : %s", new Object[]{webViewJSSDKFileItem.bNH, webViewJSSDKFileItem.fnM});
        this.pRP.put(webViewJSSDKFileItem.bNH, webViewJSSDKFileItem);
    }

    public final WebViewJSSDKFileItem Qq(String str) {
        if (!bi.oW(str)) {
            return (WebViewJSSDKFileItem) this.pRP.get(str);
        }
        x.e("MicroMsg.WebViewJSSDKFileItemManager", "get by local id error, local id is null or nil");
        return null;
    }
}
