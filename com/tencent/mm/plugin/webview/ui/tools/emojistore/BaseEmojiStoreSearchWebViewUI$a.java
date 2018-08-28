package com.tencent.mm.plugin.webview.ui.tools.emojistore;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;

class BaseEmojiStoreSearchWebViewUI$a extends i {
    final /* synthetic */ BaseEmojiStoreSearchWebViewUI qcO;

    private BaseEmojiStoreSearchWebViewUI$a(BaseEmojiStoreSearchWebViewUI baseEmojiStoreSearchWebViewUI) {
        this.qcO = baseEmojiStoreSearchWebViewUI;
        super(baseEmojiStoreSearchWebViewUI);
    }

    /* synthetic */ BaseEmojiStoreSearchWebViewUI$a(BaseEmojiStoreSearchWebViewUI baseEmojiStoreSearchWebViewUI, byte b) {
        this(baseEmojiStoreSearchWebViewUI);
    }

    public final void a(WebView webView, String str) {
        x.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "onPageFinished url:%s", new Object[]{str});
        super.a(webView, str);
        this.qcO.showOptionMenu(false);
        BaseEmojiStoreSearchWebViewUI.a(this.qcO).setSearchContent(this.qcO.bWm);
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        super.b(webView, str, bitmap);
        this.qcO.showOptionMenu(false);
    }
}
