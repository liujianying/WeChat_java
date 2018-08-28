package com.tencent.mm.ui.chatting;

import android.view.ViewTreeObserver.OnPreDrawListener;

class TextPreviewUI$1 implements OnPreDrawListener {
    final /* synthetic */ TextPreviewUI tNo;

    TextPreviewUI$1(TextPreviewUI textPreviewUI) {
        this.tNo = textPreviewUI;
    }

    public final boolean onPreDraw() {
        TextPreviewUI.a(this.tNo).getViewTreeObserver().removeOnPreDrawListener(this);
        TextPreviewUI.a(this.tNo).getLineCount();
        return false;
    }
}
