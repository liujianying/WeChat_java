package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.sdk.platformtools.x;

class CustomSmileyPreviewUI$8 implements OnClickListener {
    final /* synthetic */ CustomSmileyPreviewUI ikY;

    CustomSmileyPreviewUI$8(CustomSmileyPreviewUI customSmileyPreviewUI) {
        this.ikY = customSmileyPreviewUI;
    }

    public final void onClick(View view) {
        if (CustomSmileyPreviewUI.g(this.ikY) == null || CustomSmileyPreviewUI.g(this.ikY).rHp == null) {
            x.i("MicroMsg.emoji.CustomSmileyPreviewUI", "simple designer info is null");
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this.ikY.mController.tml, EmojiStoreV2DesignerUI.class);
        intent.putExtra("uin", CustomSmileyPreviewUI.g(this.ikY).rHp.rHi);
        intent.putExtra("name", CustomSmileyPreviewUI.g(this.ikY).rHp.jPe);
        intent.putExtra("headurl", CustomSmileyPreviewUI.g(this.ikY).rHp.rxm);
        intent.putExtra("extra_scence", 9);
        this.ikY.mController.tml.startActivity(intent);
    }
}
