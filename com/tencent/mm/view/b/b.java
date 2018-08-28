package com.tencent.mm.view.b;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.b.d;
import com.tencent.mm.b.d.1;
import com.tencent.mm.b.d.2;
import com.tencent.mm.d.a;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends a {
    private d uUu = new d(this);
    private PointF uUv = new PointF();
    private float uUw = 0.0f;
    private float uUx = 0.0f;
    private boolean uUy = false;
    public boolean uUz = false;

    public b(Context context, com.tencent.mm.bi.b bVar) {
        super(context, bVar);
    }

    public final boolean cCg() {
        return true;
    }

    protected final void onDraw(Canvas canvas) {
        canvas.drawColor(0, Mode.CLEAR);
        canvas.setMatrix(getMainMatrix());
        canvas.save();
        canvas.clipRect(getAliveRect());
        Bitmap cfS = getPresenter().cfS();
        if (!(cfS == null || cfS.isRecycled())) {
            canvas.drawBitmap(cfS, 0.0f, 0.0f, null);
        }
        canvas.restore();
        getPresenter().onDraw(canvas);
    }

    protected final void R(MotionEvent motionEvent) {
        float x = motionEvent.getX(motionEvent.getPointerCount() - 1);
        float y = motionEvent.getY(motionEvent.getPointerCount() - 1);
        float centerX;
        float minScale;
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.uUv.set(x, y);
                this.uUw = 0.0f;
                this.uUx = getCurScale();
                d dVar = this.uUu;
                x.d("MicroMsg.StickRoundAnim", "[cancel]");
                if (dVar.bwg != null && (dVar.bwg.isRunning() || dVar.bwg.isStarted())) {
                    dVar.bwg.cancel();
                }
                this.uUz = false;
                break;
            case 1:
                this.uUw = 0.0f;
                if (this.uUz) {
                    d dVar2 = this.uUu;
                    if (dVar2.bwt) {
                        x.d("MicroMsg.StickRoundAnim", "[play] start");
                        RectF curImageRect = dVar2.bwB.getCurImageRect();
                        Rect boardRect = dVar2.bwB.getBoardRect();
                        dVar2.bwC = curImageRect.centerX();
                        dVar2.bwD = curImageRect.centerY();
                        float centerY = ((float) boardRect.centerY()) - curImageRect.centerY();
                        centerX = ((float) boardRect.centerX()) - curImageRect.centerX();
                        float curScale = dVar2.bwB.getCurScale();
                        float maxScale = dVar2.bwB.getMaxScale();
                        minScale = dVar2.bwB.getMinScale();
                        if (curScale > maxScale) {
                            dVar2.dD = maxScale;
                            dVar2.bwE = true;
                        } else if (curScale < minScale) {
                            dVar2.dD = minScale;
                            dVar2.bwE = true;
                        } else {
                            dVar2.bwE = false;
                        }
                        Object obj = ((float) boardRect.height()) < curImageRect.height() ? 1 : null;
                        Object obj2 = ((float) boardRect.width()) < curImageRect.width() ? 1 : null;
                        if (obj != null) {
                            centerY = 0.0f;
                        }
                        if (obj2 != null) {
                            centerX = 0.0f;
                        }
                        minScale = (curImageRect.top <= ((float) boardRect.top) || obj == null) ? (curImageRect.bottom >= ((float) boardRect.bottom) || obj == null) ? centerY : ((float) boardRect.bottom) - curImageRect.bottom : ((float) boardRect.top) - curImageRect.top;
                        if (curImageRect.left > ((float) boardRect.left) && obj2 != null) {
                            centerX = ((float) boardRect.left) - curImageRect.left;
                        } else if (curImageRect.right < ((float) boardRect.right) && obj2 != null) {
                            centerX = ((float) boardRect.right) - curImageRect.right;
                        }
                        x.d("MicroMsg.StickRoundAnim", "%s %s ", new Object[]{Float.valueOf(centerX), Float.valueOf(minScale)});
                        if (curScale > maxScale) {
                            dVar2.bwF = true;
                        } else {
                            dVar2.bwF = false;
                        }
                        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("deltaY", new float[]{0.0f, minScale});
                        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("deltaX", new float[]{0.0f, centerX});
                        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("scale", new float[]{0.0f, 80.0f});
                        dVar2.bwg = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat, ofFloat2, ofFloat3});
                        dVar2.bwg.addUpdateListener(new 1(dVar2, curScale));
                        dVar2.bwg.addListener(new 2(dVar2));
                        dVar2.bwg.setInterpolator(new LinearInterpolator());
                        dVar2.bwg.setDuration(80);
                        dVar2.bwg.start();
                        break;
                    }
                }
                break;
            case 2:
                if (!this.uUy) {
                    if (motionEvent.getPointerCount() != 2) {
                        if (motionEvent.getPointerCount() == 1 && cCf()) {
                            this.uUz = true;
                            this.uUu.bwt = true;
                            translate(x, y);
                            postInvalidate();
                            break;
                        }
                    }
                    this.uUz = true;
                    minScale = motionEvent.getX(0) - motionEvent.getX(1);
                    centerX = motionEvent.getY(0) - motionEvent.getY(1);
                    minScale = (float) Math.sqrt((double) ((minScale * minScale) + (centerX * centerX)));
                    if (this.uUw != 0.0f) {
                        minScale = (minScale / this.uUw) * this.uUx;
                        if (this.uUl * 0.5f <= minScale) {
                            if (minScale > this.uUk) {
                                minScale = ((minScale - this.uUk) * 0.2f) + this.uUk;
                            }
                            getMainMatrix().postScale(minScale / getCurScale(), minScale / getCurScale(), x, y);
                        }
                        this.uUu.bwt = true;
                        translate(x, y);
                        postInvalidate();
                        break;
                    }
                    this.uUw = minScale;
                    break;
                }
                this.uUy = false;
                return;
            case 5:
                this.uUw = 0.0f;
                this.uUx = getCurScale();
                break;
            case 6:
                this.uUw = 0.0f;
                this.uUy = true;
                break;
        }
        this.uUv.x = x;
        this.uUv.y = y;
    }

    private void translate(float f, float f2) {
        RectF curImageRect = getCurImageRect();
        float f3 = f - this.uUv.x;
        float f4 = f2 - this.uUv.y;
        if (f3 > 0.0f) {
            if (((float) getBoardRect().left) <= curImageRect.left) {
                f3 *= 0.5f;
            } else if (Math.abs(f3) > Math.abs(curImageRect.left - ((float) getBoardRect().left))) {
                f3 = ((float) getBoardRect().left) - curImageRect.left;
            }
        } else if (((float) getBoardRect().right) >= curImageRect.right) {
            f3 *= 0.5f;
        } else if (Math.abs(f3) > Math.abs(((float) getBoardRect().right) - curImageRect.right)) {
            f3 = ((float) getBoardRect().right) - curImageRect.right;
        }
        if (f4 > 0.0f) {
            if (((float) getBoardRect().top) <= curImageRect.top) {
                f4 *= 0.5f;
            } else if (Math.abs(f4) > Math.abs(curImageRect.top - ((float) getBoardRect().top))) {
                f4 = ((float) getBoardRect().top) - curImageRect.top;
            }
        } else if (((float) getBoardRect().bottom) >= curImageRect.bottom) {
            f4 *= 0.5f;
        } else if (Math.abs(f4) > Math.abs(((float) getBoardRect().bottom) - curImageRect.bottom)) {
            f4 = ((float) getBoardRect().bottom) - curImageRect.bottom;
        }
        getMainMatrix().postTranslate(f3, f4);
    }

    public final float getMinScale() {
        if (getPresenter().cfR().vE() != a.bBk) {
            return super.getMinScale();
        }
        float width = ((float) getBoardRect().width()) / getCurImageRect().width();
        float height = ((float) getBoardRect().height()) / getCurImageRect().height();
        if (width <= height) {
            width = height;
        }
        return width * getCurScale();
    }
}
