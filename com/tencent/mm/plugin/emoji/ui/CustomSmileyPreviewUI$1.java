package com.tencent.mm.plugin.emoji.ui;

import android.os.Message;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class CustomSmileyPreviewUI$1 extends ag {
    final /* synthetic */ CustomSmileyPreviewUI ikY;

    CustomSmileyPreviewUI$1(CustomSmileyPreviewUI customSmileyPreviewUI) {
        this.ikY = customSmileyPreviewUI;
    }

    public final void handleMessage(Message message) {
        int i;
        String string;
        switch (message.what) {
            case 2:
                CustomSmileyPreviewUI.a(this.ikY, CustomSmileyPreviewUI.c(this.ikY), CustomSmileyPreviewUI.b(this.ikY));
                return;
            case 131075:
                i = message.getData().getInt("progress");
                string = message.getData().getString("product_id");
                if (bi.oW(string)) {
                    x.w("MicroMsg.emoji.CustomSmileyPreviewUI", "product id is null.");
                    return;
                } else if (CustomSmileyPreviewUI.d(this.ikY) != null && CustomSmileyPreviewUI.d(this.ikY).ien != null) {
                    CustomSmileyPreviewUI.d(this.ikY).bf(string, i);
                    CustomSmileyPreviewUI.d(this.ikY).aoV();
                    return;
                } else {
                    return;
                }
            case 131076:
                i = message.getData().getInt("status");
                string = message.getData().getString("product_id");
                if (bi.oW(string)) {
                    x.w("MicroMsg.emoji.CustomSmileyPreviewUI", "product id is null.");
                    return;
                } else if (CustomSmileyPreviewUI.d(this.ikY) != null && CustomSmileyPreviewUI.d(this.ikY).ien != null) {
                    CustomSmileyPreviewUI.d(this.ikY).be(string, i);
                    return;
                } else {
                    return;
                }
            case 131077:
                if (CustomSmileyPreviewUI.a(this.ikY) != null) {
                    CustomSmileyPreviewUI.a(this.ikY).setText(((c) g.n(c.class)).getEmojiMgr().zf(CustomSmileyPreviewUI.b(this.ikY).Xh()));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
