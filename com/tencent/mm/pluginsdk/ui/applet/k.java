package com.tencent.mm.pluginsdk.ui.applet;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;

public final class k {
    private int background = -1;
    boolean hLy;
    int index;
    OnClickListener mtE = new 2(this);
    j qIM;
    a qIS;
    int qJC;
    b qJD;
    private final OnTouchListener qJx = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };
    int row;

    public interface a {
        void BZ(int i);
    }
}
