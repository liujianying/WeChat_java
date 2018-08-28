package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

class EmojiStoreDetailUI$12 implements OnClickListener {
    final /* synthetic */ EmojiStoreDetailUI inz;

    EmojiStoreDetailUI$12(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.inz = emojiStoreDetailUI;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.emoji.EmojiStoreDetailUI", "ApplicationLanguage" + w.chP());
        String str = this.inz.getString(R.l.emoji_privacy_doc) + w.chP();
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("neverGetA8Key", true);
        d.b(this.inz, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }
}
