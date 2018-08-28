package com.tencent.mm.plugin.emoji.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.pluginsdk.ui.emoji.MMEmojiView;

class CustomSmileyPreviewUI$5 implements OnClickListener {
    final /* synthetic */ CustomSmileyPreviewUI ikY;
    final /* synthetic */ MMEmojiView ila;

    CustomSmileyPreviewUI$5(CustomSmileyPreviewUI customSmileyPreviewUI, MMEmojiView mMEmojiView) {
        this.ikY = customSmileyPreviewUI;
        this.ila = mMEmojiView;
    }

    public final void onClick(View view) {
        Toast.makeText(this.ikY.mController.tml, "isHevc:" + this.ila.qNX, 0).show();
    }
}
