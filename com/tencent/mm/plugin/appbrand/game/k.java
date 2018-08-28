package com.tencent.mm.plugin.appbrand.game;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends GameGLSurfaceView {
    private b fAk;
    private a fAl;
    private p fAm;
    private d fAn = new d((byte) 0);
    private g fdO;

    public interface b {
        void afZ();
    }

    public k(Context context, g gVar, b bVar, a aVar) {
        super(context);
        x.i("MicroMsg.WAGameView", "new GameView");
        this.fdO = gVar;
        setEGLContextClientVersion(2);
        setEGLConfigChooser(new com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.b(this));
        setPreserveEGLContextOnPause(true);
        this.fAk = new b(this);
        this.fAk.fzM = bVar;
        this.fAl = aVar;
        setRenderer(this.fAk);
        setOnTouchListener(new 1(this));
        if (h.rO(this.fdO.mAppId)) {
            postDelayed(new 2(this), 30000);
        }
        this.fAm = new p(context.getResources().getDisplayMetrics().density) {
            public final StringBuilder e(StringBuilder stringBuilder) {
                return stringBuilder.append("__WxNativeHandler__.__triggerTouchEvent__(");
            }

            public final StringBuilder f(StringBuilder stringBuilder) {
                return stringBuilder.append(");");
            }
        };
    }

    final g getRuntime() {
        return this.fdO;
    }

    final void agj() {
        x.i("MicroMsg.WAGameView", "hy: first rendered: %s ", new Object[]{this.fdO.mAppId});
        if (this.fAl != null) {
            this.fAl.agj();
            this.fAl = null;
        }
    }

    private boolean x(MotionEvent motionEvent) {
        StringBuilder stringBuilder = null;
        if (this.fAm == null || motionEvent == null || !this.fAk.dti) {
            return false;
        }
        p pVar = this.fAm;
        if (motionEvent != null) {
            int i;
            switch (motionEvent.getActionMasked()) {
                case 0:
                case 5:
                    i = 0;
                    break;
                case 1:
                case 6:
                    i = 2;
                    break;
                case 2:
                    i = 1;
                    break;
                case 3:
                    i = 3;
                    break;
                default:
                    i = -1;
                    break;
            }
            if (i != -1) {
                int i2;
                pVar.fFt.setLength(0);
                pVar.fFt = pVar.e(pVar.fFt);
                pVar.fFt.append("[[");
                int pointerCount = motionEvent.getPointerCount();
                for (i2 = 0; i2 < pointerCount; i2++) {
                    pVar.fFt.append(motionEvent.getPointerId(i2)).append(",").append(motionEvent.getX(i2) / pVar.fFs).append(",").append(motionEvent.getY(i2) / pVar.fFs).append(",").append(motionEvent.getPressure(i2));
                    if (i2 != pointerCount - 1) {
                        pVar.fFt.append(",");
                    }
                }
                pVar.fFt.append("],[");
                if (i == 1) {
                    for (i2 = 0; i2 < pointerCount; i2++) {
                        pVar.fFt.append(i2);
                        if (i2 != pointerCount - 1) {
                            pVar.fFt.append(",");
                        }
                    }
                } else {
                    pVar.fFt.append(motionEvent.getActionIndex());
                }
                pVar.fFt.append("],");
                pVar.fFt.append(motionEvent.getEventTime()).append(",");
                pVar.fFt.append(i).append("]");
                pVar.fFt = pVar.f(pVar.fFt);
                stringBuilder = pVar.fFt;
            }
        }
        if (stringBuilder == null || stringBuilder.length() == 0) {
            return false;
        }
        c cVar = (c) this.fAn.ahn();
        cVar.fAp = stringBuilder.toString();
        cVar.fAq = this.fdO.fcy.fdQ;
        queueEvent(cVar);
        return true;
    }

    public final b getMBRenderer() {
        return this.fAk;
    }
}
