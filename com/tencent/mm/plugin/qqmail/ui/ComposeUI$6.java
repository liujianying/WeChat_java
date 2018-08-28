package com.tencent.mm.plugin.qqmail.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ComposeUI$6 implements OnTouchListener {
    final /* synthetic */ ComposeUI mfs;

    ComposeUI$6(ComposeUI composeUI) {
        this.mfs = composeUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 1:
                if (!view.hasFocus()) {
                    view.requestFocus();
                    break;
                }
                break;
        }
        return false;
    }
}
