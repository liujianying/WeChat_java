package com.tencent.mm.plugin.game.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class GameSearchUI$2 implements OnTouchListener {
    final /* synthetic */ GameSearchUI kcH;

    GameSearchUI$2(GameSearchUI gameSearchUI) {
        this.kcH = gameSearchUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        GameSearchUI.a(this.kcH).clearFocus();
        this.kcH.YC();
        return false;
    }
}
