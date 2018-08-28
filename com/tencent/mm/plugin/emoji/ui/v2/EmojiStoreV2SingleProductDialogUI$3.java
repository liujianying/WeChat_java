package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;

class EmojiStoreV2SingleProductDialogUI$3 implements OnClickListener {
    final /* synthetic */ EmojiStoreV2SingleProductDialogUI iqU;

    EmojiStoreV2SingleProductDialogUI$3(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI) {
        this.iqU = emojiStoreV2SingleProductDialogUI;
    }

    public final void onClick(View view) {
        this.iqU.setResult(0);
        this.iqU.finish();
        this.iqU.overridePendingTransition(R.a.pop_in, R.a.pop_out);
    }
}
