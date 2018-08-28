package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;

class EmojiStoreDetailUI$6 implements OnClickListener {
    final /* synthetic */ EmojiStoreDetailUI inz;

    EmojiStoreDetailUI$6(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.inz = emojiStoreDetailUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.inz.mController.tml, EmojiStoreV2DesignerUI.class);
        intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, EmojiStoreDetailUI.b(this.inz).rxl.rHi);
        intent.putExtra("name", EmojiStoreDetailUI.b(this.inz).rxl.jPe);
        intent.putExtra("headurl", EmojiStoreDetailUI.b(this.inz).rxl.rxm);
        intent.putExtra("rediret_url", EmojiStoreDetailUI.b(this.inz).rxj);
        intent.putExtra("searchID", EmojiStoreDetailUI.d(this.inz));
        intent.putExtra("extra_scence", 26);
        this.inz.mController.tml.startActivity(intent);
    }
}
