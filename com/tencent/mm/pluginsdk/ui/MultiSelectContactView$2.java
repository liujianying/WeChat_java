package com.tencent.mm.pluginsdk.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class MultiSelectContactView$2 implements OnKeyListener {
    final /* synthetic */ MultiSelectContactView qGe;

    MultiSelectContactView$2(MultiSelectContactView multiSelectContactView) {
        this.qGe = multiSelectContactView;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 67 && keyEvent.getAction() == 0 && MultiSelectContactView.c(this.qGe).getSelectionStart() == 0 && MultiSelectContactView.c(this.qGe).getSelectionEnd() == 0) {
            MultiSelectContactView.d(this.qGe);
        }
        return false;
    }
}
