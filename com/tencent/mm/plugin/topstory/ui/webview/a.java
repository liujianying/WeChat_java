package com.tencent.mm.plugin.topstory.ui.webview;

import android.webkit.ConsoleMessage;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.e;
import com.tencent.xweb.f;
import com.tencent.xweb.j;

public final class a extends j {
    public final void a(WebView webView, int i) {
    }

    public final boolean b(WebView webView, String str, String str2, f fVar) {
        x.i("MicroMsg.TopStory.TopStoryWebChromeClient", "onJsConfirm %s %s", new Object[]{str, str2});
        return super.b(webView, str, str2, fVar);
    }

    public final boolean a(WebView webView, String str, String str2, String str3, e eVar) {
        x.i("MicroMsg.TopStory.TopStoryWebChromeClient", "onJsPrompt %s %s", new Object[]{str, str2});
        return super.a(webView, str, str2, str3, eVar);
    }

    public final boolean a(WebView webView, String str, String str2, f fVar) {
        x.i("MicroMsg.TopStory.TopStoryWebChromeClient", "onJsAlert %s %s", new Object[]{str, str2});
        return super.a(webView, str, str2, fVar);
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        x.i("MicroMsg.TopStory.TopStoryWebChromeClient", "onConsoleMessage %d %s %s %s", new Object[]{Integer.valueOf(consoleMessage.lineNumber()), consoleMessage.messageLevel().name(), consoleMessage.message(), consoleMessage.sourceId()});
        return super.onConsoleMessage(consoleMessage);
    }
}
