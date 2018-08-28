package com.tencent.mm.plugin.fts.ui.widget;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class FTSEditTextView$1 implements OnKeyListener {
    final /* synthetic */ FTSEditTextView jzA;

    FTSEditTextView$1(FTSEditTextView fTSEditTextView) {
        this.jzA = fTSEditTextView;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && 67 == i) {
            int selectionStart = FTSEditTextView.a(this.jzA).getSelectionStart();
            int selectionEnd = FTSEditTextView.a(this.jzA).getSelectionEnd();
            if (selectionStart == 0 && selectionEnd == 0 && FTSEditTextView.b(this.jzA).size() > 0 && FTSEditTextView.c(this.jzA)) {
                FTSEditTextView.b(this.jzA).remove(FTSEditTextView.b(this.jzA).size() - 1);
                FTSEditTextView.d(this.jzA);
                FTSEditTextView.e(this.jzA);
            }
        }
        return false;
    }
}
