package com.tencent.mm.plugin.fav.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class FavBaseUI$5 implements OnTouchListener {
    final /* synthetic */ FavBaseUI iYp;

    FavBaseUI$5(FavBaseUI favBaseUI) {
        this.iYp = favBaseUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.iYp.YC();
        return false;
    }
}
