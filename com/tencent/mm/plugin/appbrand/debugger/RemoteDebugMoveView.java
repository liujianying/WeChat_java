package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.m;

public class RemoteDebugMoveView extends FrameLayout {
    int ftm;
    int ftn;
    float fto;
    float ftp;
    float ftq;
    float ftr;

    static /* synthetic */ int b(RemoteDebugMoveView remoteDebugMoveView) {
        int width = remoteDebugMoveView.getWidth();
        return width > 0 ? width : a.fromDPToPix(remoteDebugMoveView.getContext(), m.CTRL_INDEX);
    }

    public RemoteDebugMoveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RemoteDebugMoveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.fto = motionEvent.getRawX();
                this.ftp = motionEvent.getRawY();
                break;
            case 2:
                this.ftq = motionEvent.getRawX();
                this.ftr = motionEvent.getRawY();
                float x = getX() + (this.ftq - this.fto);
                if (0.0f < x && x < ((float) (this.ftm - getWidth()))) {
                    setX(x);
                }
                x = this.ftr - this.ftp;
                float height = (float) (this.ftn - getHeight());
                float y = getY() + x;
                if ((0.0f < y && y < height) || ((y <= 0.0f && x > 0.0f) || (y >= height && x < 0.0f))) {
                    setY(y);
                }
                this.fto = this.ftq;
                this.ftp = this.ftr;
                break;
        }
        return true;
    }
}
