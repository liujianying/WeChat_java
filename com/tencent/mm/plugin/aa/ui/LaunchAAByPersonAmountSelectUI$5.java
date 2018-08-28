package com.tencent.mm.plugin.aa.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.wxpay.a.c;

class LaunchAAByPersonAmountSelectUI$5 implements OnTouchListener {
    final /* synthetic */ LaunchAAByPersonAmountSelectUI eDf;

    LaunchAAByPersonAmountSelectUI$5(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        this.eDf = launchAAByPersonAmountSelectUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (!LaunchAAByPersonAmountSelectUI.k(this.eDf)) {
            return true;
        }
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
            LaunchAAByPersonAmountSelectUI.l(this.eDf).setTextColor(this.eDf.getResources().getColor(c.btn_green_color_pressed));
        } else if (LaunchAAByPersonAmountSelectUI.k(this.eDf)) {
            LaunchAAByPersonAmountSelectUI.l(this.eDf).setTextColor(this.eDf.getResources().getColor(c.btn_green_color_normal));
        } else {
            LaunchAAByPersonAmountSelectUI.l(this.eDf).setTextColor(this.eDf.getResources().getColor(c.btn_green_color_disable));
        }
        return false;
    }
}
