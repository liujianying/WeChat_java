package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.ui.v2.d.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ta;

class EmojiStoreV2SingleProductUI$10 implements a {
    final /* synthetic */ EmojiStoreV2SingleProductUI irx;

    EmojiStoreV2SingleProductUI$10(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI) {
        this.irx = emojiStoreV2SingleProductUI;
    }

    public final void ms(int i) {
        if (EmojiStoreV2SingleProductUI.h(this.irx) != null && EmojiStoreV2SingleProductUI.c(this.irx) != null) {
            ta oY = EmojiStoreV2SingleProductUI.c(this.irx).oY(i);
            if (oY != null) {
                try {
                    Intent intent = new Intent();
                    intent.putExtra("Select_Conv_User", EmojiStoreV2SingleProductUI.i(this.irx));
                    intent.putExtra("extra_object", oY.toByteArray());
                    intent.putExtra("scene", EmojiStoreV2SingleProductUI.j(this.irx));
                    intent.putExtra("searchID", EmojiStoreV2SingleProductUI.k(this.irx));
                    intent.setClass(this.irx.mController.tml, EmojiStoreV2SingleProductDialogUI.class);
                    this.irx.startActivityForResult(intent, 5001);
                    this.irx.overridePendingTransition(R.a.pop_in, R.a.pop_out);
                    h.mEJ.h(12787, new Object[]{Integer.valueOf(EmojiStoreV2SingleProductUI.j(this.irx)), Integer.valueOf(0), oY.rwk, Long.valueOf(EmojiStoreV2SingleProductUI.k(this.irx))});
                } catch (Exception e) {
                }
            }
        }
    }
}
