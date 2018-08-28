package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.View;
import com.tencent.mm.R;
import java.util.List;

class EmojiStoreV2DesignerUI$2 implements Runnable {
    final /* synthetic */ EmojiStoreV2DesignerUI ipH;
    final /* synthetic */ List ipI;

    EmojiStoreV2DesignerUI$2(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI, List list) {
        this.ipH = emojiStoreV2DesignerUI;
        this.ipI = list;
    }

    public final void run() {
        int i;
        int i2 = 8;
        EmojiStoreV2DesignerUI emojiStoreV2DesignerUI = this.ipH;
        if (this.ipI.size() > 3) {
            i = 1;
        } else {
            i = 0;
        }
        if (emojiStoreV2DesignerUI.ipr != null) {
            emojiStoreV2DesignerUI.ipr.setVisibility(0);
        }
        if (emojiStoreV2DesignerUI.ipu != null) {
            emojiStoreV2DesignerUI.ipu.setVisibility(0);
        }
        if (emojiStoreV2DesignerUI.ipt != null) {
            emojiStoreV2DesignerUI.ipt.setVisibility(0);
        }
        if (emojiStoreV2DesignerUI.ipv != null) {
            emojiStoreV2DesignerUI.ipv.setVisibility(i != 0 ? 0 : 8);
        }
        if (emojiStoreV2DesignerUI.ipw != null) {
            emojiStoreV2DesignerUI.ipw.setText(R.l.emoji_store_product_more_title);
        }
        if (emojiStoreV2DesignerUI.ipx != null) {
            View view = emojiStoreV2DesignerUI.ipx;
            if (i != 0) {
                i2 = 0;
            }
            view.setVisibility(i2);
        }
        if (emojiStoreV2DesignerUI.ipo != null) {
            emojiStoreV2DesignerUI.ipo.setPadding(0, 0, 0, 0);
        }
    }
}
