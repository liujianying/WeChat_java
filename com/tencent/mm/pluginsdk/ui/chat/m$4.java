package com.tencent.mm.pluginsdk.ui.chat;

import android.view.MotionEvent;
import com.tencent.mm.ui.base.HorizontalListView.a;

class m$4 implements a {
    final /* synthetic */ m qNl;

    m$4(m mVar) {
        this.qNl = mVar;
    }

    public final boolean q(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.qNl.mHandler.sendEmptyMessage(20002);
                break;
            case 1:
            case 3:
                this.qNl.mHandler.sendEmptyMessageDelayed(20001, 3000);
                break;
        }
        return false;
    }
}
