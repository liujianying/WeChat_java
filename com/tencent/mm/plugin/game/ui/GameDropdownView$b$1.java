package com.tencent.mm.plugin.game.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.game.ui.GameDropdownView.b;

class GameDropdownView$b$1 implements OnTouchListener {
    final /* synthetic */ b jXT;

    GameDropdownView$b$1(b bVar) {
        this.jXT = bVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 4) {
            return false;
        }
        this.jXT.dismiss();
        return true;
    }
}
