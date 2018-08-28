package com.tencent.mm.ui.tools;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.f;
import java.util.Timer;

class CropImageView$3 implements OnTouchListener {
    final /* synthetic */ CropImageView uwH;

    CropImageView$3(CropImageView cropImageView) {
        this.uwH = cropImageView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (!CropImageView.u(this.uwH) || CropImageView.i(this.uwH) == null) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        x.d("MicroMsg.CropImageView", "on touch : event type=" + action + ", isDownOnImg=" + CropImageView.v(this.uwH));
        if (!CropImageView.v(this.uwH) && action != 0) {
            return false;
        }
        switch (action) {
            case 0:
                x.d("MicroMsg.CropImageView", "action_down");
                CropImageView.a(this.uwH, motionEvent.getRawX());
                CropImageView.b(this.uwH, motionEvent.getRawY());
                x.d("MicroMsg.CropImageView", "lastX=" + CropImageView.w(this.uwH) + ",lastY=" + CropImageView.x(this.uwH));
                CropImageView.c(this.uwH, CropImageView.w(this.uwH));
                CropImageView.d(this.uwH, CropImageView.x(this.uwH));
                Matrix imageMatrix = this.uwH.getImageMatrix();
                RectF rectF = new RectF();
                rectF.set(0.0f, 0.0f, (float) CropImageView.i(this.uwH).getWidth(), (float) CropImageView.i(this.uwH).getHeight());
                imageMatrix.mapRect(rectF);
                CropImageView.a(this.uwH, rectF.contains(CropImageView.w(this.uwH), CropImageView.x(this.uwH)));
                CropImageView.a(this.uwH, System.currentTimeMillis());
                return false;
            case 1:
                x.d("MicroMsg.CropImageView", "action_up");
                if (CropImageView.z(this.uwH)) {
                    CropImageView.c(this.uwH, false);
                    if (CropImageView.A(this.uwH)) {
                        CropImageView.d(this.uwH, false);
                        this.uwH.zoomOut();
                        this.uwH.zoomOut();
                        this.uwH.zoomOut();
                        this.uwH.zoomOut();
                        this.uwH.zoomOut();
                        return false;
                    }
                    CropImageView.d(this.uwH, true);
                    this.uwH.zoomIn();
                    this.uwH.zoomIn();
                    this.uwH.zoomIn();
                    this.uwH.zoomIn();
                    this.uwH.zoomIn();
                    return false;
                }
                CropImageView.c(this.uwH, true);
                CropImageView.a(this.uwH, new Timer());
                CropImageView.B(this.uwH).schedule(new 1(this, motionEvent), 200);
                return false;
            case 2:
                float f;
                x.d("MicroMsg.CropImageView", "action_move");
                if (this.uwH.uwq) {
                    x.d("MicroMsg.CropImageView", "is valid mult down");
                    this.uwH.nNa = f.K(motionEvent);
                    f = this.uwH.nNa - this.uwH.nMZ;
                    if (this.uwH.nNa > 5.0f && Math.abs(f) > 5.0f) {
                        f.a(CropImageView.h(this.uwH), motionEvent);
                        x.d("MicroMsg.CropImageView", "mX=" + CropImageView.h(this.uwH).x + ",mY=" + CropImageView.h(this.uwH).y);
                        if (f > 0.0f) {
                            x.d("MicroMsg.CropImageView", "zoom in");
                            this.uwH.zoomIn();
                        } else {
                            x.d("MicroMsg.CropImageView", "zoom out");
                            this.uwH.zoomOut();
                        }
                    }
                    this.uwH.nMZ = this.uwH.nNa;
                }
                if (!CropImageView.y(this.uwH)) {
                    f = motionEvent.getRawX() - CropImageView.w(this.uwH);
                    float rawY = motionEvent.getRawY() - CropImageView.x(this.uwH);
                    if (Math.abs(f) > 5.0f || Math.abs(rawY) > 5.0f) {
                        this.uwH.getImageMatrix().postTranslate(f, rawY);
                    }
                    this.uwH.invalidate();
                }
                CropImageView.b(this.uwH, false);
                CropImageView.a(this.uwH, motionEvent.getRawX());
                CropImageView.b(this.uwH, motionEvent.getRawY());
                return false;
            case 5:
                x.d("MicroMsg.CropImageView", "action_mult_down");
                CropImageView.b(this.uwH, true);
                this.uwH.nMZ = f.K(motionEvent);
                if (this.uwH.nMZ <= 5.0f) {
                    return false;
                }
                this.uwH.uwq = true;
                f.a(CropImageView.h(this.uwH), motionEvent);
                return true;
            case 6:
                x.d("MicroMsg.CropImageView", "action_mult_up");
                this.uwH.uwq = false;
                CropImageView.b(this.uwH, true);
                return true;
            default:
                return false;
        }
    }
}
