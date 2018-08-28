package com.tencent.mm.plugin.scanner.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.x;

class i$3 implements OnTouchListener {
    final /* synthetic */ i mKt;
    private float mKu;
    private float mKv = 400.0f;

    i$3(i iVar) {
        this.mKt = iVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        x.d("MicroMsg.scanner.ScanMode", "pointIndex:%d", new Object[]{Integer.valueOf(actionIndex)});
        switch (actionMasked) {
            case 0:
                x.d("MicroMsg.scanner.ScanMode", "first down,pointer:%d,x:%f,y:%f", new Object[]{Integer.valueOf(actionIndex), Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY())});
                break;
            case 1:
                x.d("MicroMsg.scanner.ScanMode", "last up,pointer:%d,x:%f,y:%f", new Object[]{Integer.valueOf(actionIndex), Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY())});
                if (motionEvent.getPointerCount() == 2) {
                    this.mKu = (float) (Math.pow((double) (motionEvent.getX(0) - motionEvent.getX(1)), 2.0d) + Math.pow((double) (motionEvent.getY(0) - motionEvent.getY(1)), 2.0d));
                    break;
                }
                break;
            case 2:
                if (motionEvent.getPointerCount() == 2) {
                    x.d("MicroMsg.scanner.ScanMode", "move,pointer:0,x:%f,y:%f", new Object[]{Float.valueOf(motionEvent.getX(0)), Float.valueOf(motionEvent.getY(0))});
                    x.d("MicroMsg.scanner.ScanMode", "move,pointer:1,x:%f,y:%f", new Object[]{Float.valueOf(motionEvent.getX(1)), Float.valueOf(motionEvent.getY(1))});
                    float pow = (float) (Math.pow((double) (motionEvent.getX(0) - motionEvent.getX(1)), 2.0d) + Math.pow((double) (motionEvent.getY(0) - motionEvent.getY(1)), 2.0d));
                    x.d("MicroMsg.scanner.ScanMode", "distance:%f,lastDistance:%f,min move:%f", new Object[]{Float.valueOf(pow), Float.valueOf(this.mKu), Float.valueOf(this.mKv)});
                    if (Math.abs(pow - this.mKu) > this.mKv) {
                        if (this.mKt.mKr) {
                            this.mKt.mKr = false;
                        }
                        if (pow - this.mKu > 0.0f) {
                            this.mKt.mKp.V(2, 2, 100);
                        } else {
                            this.mKt.mKp.V(3, 2, 100);
                        }
                        this.mKu = pow;
                        break;
                    }
                }
                break;
            case 5:
                x.d("MicroMsg.scanner.ScanMode", "down,pointer:%d,x:%f,y:%f", new Object[]{Integer.valueOf(actionIndex), Float.valueOf(motionEvent.getX(actionIndex)), Float.valueOf(motionEvent.getY(actionIndex))});
                if (motionEvent.getPointerCount() == 2) {
                    this.mKu = (float) (Math.pow((double) (motionEvent.getX(0) - motionEvent.getX(1)), 2.0d) + Math.pow((double) (motionEvent.getY(0) - motionEvent.getY(1)), 2.0d));
                    break;
                }
                break;
            case 6:
                x.d("MicroMsg.scanner.ScanMode", "up,pointer:%d,x:%f,y:%f", new Object[]{Integer.valueOf(actionIndex), Float.valueOf(motionEvent.getX(actionIndex)), Float.valueOf(motionEvent.getY(actionIndex))});
                if (motionEvent.getPointerCount() == 2) {
                    this.mKu = (float) (Math.pow((double) (motionEvent.getX(0) - motionEvent.getX(1)), 2.0d) + Math.pow((double) (motionEvent.getY(0) - motionEvent.getY(1)), 2.0d));
                    break;
                }
                break;
        }
        this.mKt.iEv.onTouchEvent(motionEvent);
        return true;
    }
}
