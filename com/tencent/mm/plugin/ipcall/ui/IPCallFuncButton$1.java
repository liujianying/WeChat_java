package com.tencent.mm.plugin.ipcall.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class IPCallFuncButton$1 implements OnTouchListener {
    final /* synthetic */ IPCallFuncButton kwv;

    IPCallFuncButton$1(IPCallFuncButton iPCallFuncButton) {
        this.kwv = iPCallFuncButton;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (IPCallFuncButton.a(this.kwv)) {
            if (motionEvent.getAction() == 0) {
                if (IPCallFuncButton.b(this.kwv)) {
                    if (IPCallFuncButton.e(this.kwv)) {
                        IPCallFuncButton.d(this.kwv).setImageDrawable(IPCallFuncButton.f(this.kwv));
                        IPCallFuncButton.a(this.kwv, false);
                    } else {
                        IPCallFuncButton.d(this.kwv).setImageDrawable(IPCallFuncButton.c(this.kwv));
                        IPCallFuncButton.a(this.kwv, true);
                    }
                    if (IPCallFuncButton.g(this.kwv) != null) {
                        IPCallFuncButton.g(this.kwv).ga(IPCallFuncButton.e(this.kwv));
                    }
                } else if (IPCallFuncButton.c(this.kwv) != null) {
                    IPCallFuncButton.d(this.kwv).setImageDrawable(IPCallFuncButton.c(this.kwv));
                }
            } else if ((motionEvent.getAction() == 3 || motionEvent.getAction() == 1) && !IPCallFuncButton.b(this.kwv)) {
                if (IPCallFuncButton.f(this.kwv) != null) {
                    IPCallFuncButton.d(this.kwv).setImageDrawable(IPCallFuncButton.f(this.kwv));
                }
                if (IPCallFuncButton.g(this.kwv) != null) {
                    IPCallFuncButton.g(this.kwv).ga(false);
                }
            }
        }
        return false;
    }
}
