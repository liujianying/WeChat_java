package com.tencent.mm.plugin.fav.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class FavTagEditUI$2 implements OnTouchListener {
    final /* synthetic */ FavTagEditUI jaA;

    FavTagEditUI$2(FavTagEditUI favTagEditUI) {
        this.jaA = favTagEditUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        FavTagEditUI.d(this.jaA).crP();
        return false;
    }
}
