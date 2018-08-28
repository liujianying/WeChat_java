package com.tencent.mm.ui.chatting;

import android.widget.ScrollView;
import com.tencent.mm.ui.base.CustomScrollView.a;

class TextPreviewUI$2 implements a {
    final /* synthetic */ TextPreviewUI tNo;

    TextPreviewUI$2(TextPreviewUI textPreviewUI) {
        this.tNo = textPreviewUI;
    }

    public final void a(ScrollView scrollView, int i, int i2) {
        int i3 = i - i2;
        TextPreviewUI.f(this.tNo);
        if (scrollView.getChildAt(0).getMeasuredHeight() == scrollView.getHeight() + scrollView.getScrollY()) {
            TextPreviewUI.a(this.tNo, scrollView.getScrollY());
        }
        if (scrollView.getScrollY() <= 0 || (scrollView.getScrollY() >= TextPreviewUI.g(this.tNo) - 10 && TextPreviewUI.g(this.tNo) > 0)) {
            TextPreviewUI.h(this.tNo);
        } else if (TextPreviewUI.i(this.tNo)) {
            if (i2 > i) {
                TextPreviewUI.h(this.tNo);
            } else if (i2 < i) {
                TextPreviewUI.j(this.tNo);
            }
            TextPreviewUI.a(this.tNo, false);
        }
        TextPreviewUI.b(this.tNo, i3);
    }
}
