package com.tencent.mm.plugin.webview.ui.tools.emojistore;

class BaseEmojiStoreSearchWebViewUI$3 implements Runnable {
    final /* synthetic */ BaseEmojiStoreSearchWebViewUI qcO;

    BaseEmojiStoreSearchWebViewUI$3(BaseEmojiStoreSearchWebViewUI baseEmojiStoreSearchWebViewUI) {
        this.qcO = baseEmojiStoreSearchWebViewUI;
    }

    public final void run() {
        BaseEmojiStoreSearchWebViewUI.a(this.qcO).clearFocus();
        this.qcO.YC();
    }
}
