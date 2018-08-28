package com.tencent.mm.plugin.fav.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class FavSearchUI$2 implements OnTouchListener {
    final /* synthetic */ FavSearchUI iZQ;

    FavSearchUI$2(FavSearchUI favSearchUI) {
        this.iZQ = favSearchUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.iZQ.YC();
                break;
        }
        return false;
    }
}
