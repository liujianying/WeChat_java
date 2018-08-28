package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class SnsMsgUI$17 implements OnTouchListener {
    final /* synthetic */ SnsMsgUI nYl;

    SnsMsgUI$17(SnsMsgUI snsMsgUI) {
        this.nYl = snsMsgUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.nYl.YC();
                SnsMsgUI.j(this.nYl)[0] = (int) motionEvent.getRawX();
                SnsMsgUI.j(this.nYl)[1] = (int) motionEvent.getRawY();
                break;
        }
        return false;
    }
}
