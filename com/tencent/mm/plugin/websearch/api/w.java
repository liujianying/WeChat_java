package com.tencent.mm.plugin.websearch.api;

import android.webkit.JavascriptInterface;

public final class w implements c {
    public c pLO;

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _sendMessage(String str) {
        if (this.pLO != null) {
            this.pLO._sendMessage(str);
        }
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _getAllHosts(String str) {
        if (this.pLO != null) {
            this.pLO._getAllHosts(str);
        }
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _getHtmlContent(String str) {
        if (this.pLO != null) {
            this.pLO._getHtmlContent(str);
        }
    }
}
