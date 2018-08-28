package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

class EmojiStoreV2DesignerUI$6 implements d {
    final /* synthetic */ EmojiStoreV2DesignerUI ipH;

    EmojiStoreV2DesignerUI$6(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        this.ipH = emojiStoreV2DesignerUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case BaseReportManager.MAX_READ_COUNT /*1000*/:
                if (EmojiStoreV2DesignerUI.l(this.ipH) != null) {
                    k.a(this.ipH.mController.tml, EmojiStoreV2DesignerUI.l(this.ipH).jPe + this.ipH.getString(R.l.emoji_store_designer_source), EmojiStoreV2DesignerUI.l(this.ipH).jOS, EmojiStoreV2DesignerUI.l(this.ipH).rxm, EmojiStoreV2DesignerUI.m(this.ipH), EmojiLogic.h(EmojiStoreV2DesignerUI.k(this.ipH), EmojiStoreV2DesignerUI.n(this.ipH), EmojiStoreV2DesignerUI.m(this.ipH)), 10);
                    h.mEJ.h(13224, new Object[]{Integer.valueOf(3), Integer.valueOf(1), "", Integer.valueOf(EmojiStoreV2DesignerUI.k(this.ipH))});
                    return;
                }
                return;
            case 1001:
                k.cZ(this.ipH.mController.tml);
                this.ipH.mController.tml.overridePendingTransition(R.a.push_up_in, R.a.fast_faded_out);
                h.mEJ.h(13224, new Object[]{Integer.valueOf(3), Integer.valueOf(2), "", Integer.valueOf(EmojiStoreV2DesignerUI.k(this.ipH))});
                return;
            default:
                return;
        }
    }
}
