package com.tencent.mm.ui.chatting;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class TextPreviewUI$15 implements OnTouchListener {
    final /* synthetic */ TextPreviewUI tNo;

    TextPreviewUI$15(TextPreviewUI textPreviewUI) {
        this.tNo = textPreviewUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                TextPreviewUI.a(this.tNo, true);
                break;
            case 1:
                TextPreviewUI.a(this.tNo, false);
                TextPreviewUI.b(this.tNo, false);
                break;
            case 2:
                if (!TextPreviewUI.e(this.tNo)) {
                    TextPreviewUI.b(this.tNo, true);
                    TextPreviewUI.a(this.tNo, true);
                    break;
                }
                break;
        }
        return false;
    }
}
