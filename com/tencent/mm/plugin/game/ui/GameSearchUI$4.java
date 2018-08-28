package com.tencent.mm.plugin.game.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class GameSearchUI$4 implements OnTouchListener {
    final /* synthetic */ GameSearchUI kcH;

    GameSearchUI$4(GameSearchUI gameSearchUI) {
        this.kcH = gameSearchUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        GameSearchUI.e(this.kcH).clearFocus();
        this.kcH.YC();
        return false;
    }
}
