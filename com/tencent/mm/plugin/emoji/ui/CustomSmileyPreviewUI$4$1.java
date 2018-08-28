package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.4;

class CustomSmileyPreviewUI$4$1 implements OnClickListener {
    final /* synthetic */ 4 ikZ;

    CustomSmileyPreviewUI$4$1(4 4) {
        this.ikZ = 4;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        this.ikZ.ikY.finish();
    }
}
