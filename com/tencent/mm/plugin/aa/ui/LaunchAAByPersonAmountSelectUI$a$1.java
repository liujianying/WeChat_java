package com.tencent.mm.plugin.aa.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.a;

class LaunchAAByPersonAmountSelectUI$a$1 implements OnTouchListener {
    final /* synthetic */ LaunchAAByPersonAmountSelectUI$a$a eDj;
    final /* synthetic */ a eDk;

    LaunchAAByPersonAmountSelectUI$a$1(a aVar, LaunchAAByPersonAmountSelectUI$a$a launchAAByPersonAmountSelectUI$a$a) {
        this.eDk = aVar;
        this.eDj = launchAAByPersonAmountSelectUI$a$a;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.eDj.eCN.d(this.eDk.eDf);
        return false;
    }
}
