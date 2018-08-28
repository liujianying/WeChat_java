package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n$d;

class CustomSmileyPreviewUI$2 implements n$d {
    final /* synthetic */ CustomSmileyPreviewUI ikY;

    CustomSmileyPreviewUI$2(CustomSmileyPreviewUI customSmileyPreviewUI) {
        this.ikY = customSmileyPreviewUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                CustomSmileyPreviewUI customSmileyPreviewUI = this.ikY;
                EmojiInfo Zy = i.aEA().igx.Zy(customSmileyPreviewUI.getIntent().getStringExtra("custom_smiley_preview_md5"));
                if (Zy == null) {
                    x.w("MicroMsg.emoji.CustomSmileyPreviewUI", "[cpan] save custom emoji failed. emoji is null.");
                    return;
                } else if (Zy.field_catalog == EmojiInfo.tcD) {
                    return;
                } else {
                    if (Zy.field_catalog == EmojiInfo.tcH) {
                        h.bA(customSmileyPreviewUI, customSmileyPreviewUI.getString(R.l.app_added));
                        return;
                    } else {
                        i.aEw().a(customSmileyPreviewUI.mController.tml, Zy, 4, customSmileyPreviewUI.ikV);
                        return;
                    }
                }
            case 1:
                CustomSmileyPreviewUI.n(this.ikY);
                return;
            case 2:
                CustomSmileyPreviewUI.o(this.ikY);
                return;
            default:
                return;
        }
    }
}
