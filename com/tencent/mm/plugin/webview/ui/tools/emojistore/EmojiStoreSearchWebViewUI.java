package com.tencent.mm.plugin.webview.ui.tools.emojistore;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.x;

public class EmojiStoreSearchWebViewUI extends BaseEmojiStoreSearchWebViewUI {
    protected final void t(int i, Bundle bundle) {
        x.i("MicroMsg.emoji.EmojiStoreSearchWebViewUI", "handleEmojiStoreAction action:%d", Integer.valueOf(i));
        super.t(i, bundle);
    }
}
