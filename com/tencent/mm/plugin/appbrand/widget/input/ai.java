package com.tencent.mm.plugin.appbrand.widget.input;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

public class ai implements OnTouchListener {
    private static final int ul = ViewConfiguration.getLongPressTimeout();
    private final Handler gJH = new 1(this, Looper.getMainLooper());
    private float gJI;
    private float gJJ;
    private boolean gJK = false;

    static /* synthetic */ boolean a(ai aiVar) {
        if (aiVar.gJK) {
            return false;
        }
        aiVar.apC();
        return true;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                view.setPressed(true);
                this.gJH.sendMessageDelayed(Message.obtain(this.gJH, 1), (long) ul);
                this.gJI = motionEvent.getX();
                this.gJJ = motionEvent.getY();
                break;
            case 1:
                if (!this.gJK && this.gJH.hasMessages(1)) {
                    ajJ();
                }
                ch(view);
                break;
            case 2:
                int scaledTouchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (((float) (-scaledTouchSlop)) > x || x > ((float) (view.getWidth() + scaledTouchSlop)) || ((float) (-scaledTouchSlop)) > y || y > ((float) (scaledTouchSlop + view.getHeight()))) {
                    this.gJK = true;
                    break;
                }
            case 3:
                ch(view);
                break;
        }
        return true;
    }

    private void ch(View view) {
        view.setPressed(false);
        this.gJK = false;
        this.gJH.removeMessages(1);
        this.gJH.removeMessages(2);
    }

    protected void ajJ() {
    }

    protected void apC() {
    }
}
