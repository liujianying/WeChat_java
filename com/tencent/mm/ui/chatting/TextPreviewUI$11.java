package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;

class TextPreviewUI$11 implements OnClickListener {
    final /* synthetic */ TextPreviewUI tNo;

    TextPreviewUI$11(TextPreviewUI textPreviewUI) {
        this.tNo = textPreviewUI;
    }

    public final void onClick(View view) {
        if (TextPreviewUI.c(this.tNo) == null || TextPreviewUI.c(this.tNo).ccw) {
            this.tNo.finish();
            return;
        }
        TextPreviewUI.c(this.tNo).cBo();
        TextPreviewUI.c(this.tNo).cBn();
    }
}
