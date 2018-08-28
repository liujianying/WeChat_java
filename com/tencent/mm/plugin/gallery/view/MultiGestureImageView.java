package com.tencent.mm.plugin.gallery.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.OverScroller;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.lang.ref.WeakReference;

public class MultiGestureImageView extends LinearLayout {
    private int SQ;
    private int SR;
    private float bwH;
    private int count = 0;
    private int hmV;
    private int hmW;
    private MultiTouchImageView jEO;
    private long jEP = 0;
    private long jEQ = 0;
    private float jER = 0.0f;
    private float jES = 0.0f;
    private long jET = 0;
    private boolean jEU = false;
    private OverScroller jEV;
    private GestureDetector jEW;
    private RectF jEX = new RectF();
    private a jEY;
    private float jEZ;
    private boolean jFa = false;
    private boolean jFb = false;
    private boolean jFc = false;
    private boolean jFd = false;
    private j jFe;
    private j jFf;
    private j jFg;
    private d jFh;
    private b jFi;

    private abstract class a {
        protected boolean bwt = false;

        public abstract void play();

        public final boolean aSc() {
            return this.bwt;
        }
    }

    private class f extends a {
        float[] jFk = new float[9];
        MultiTouchImageView jFl;

        public f(MultiTouchImageView multiTouchImageView) {
            super();
            this.jFl = multiTouchImageView;
        }

        public final void play() {
            MultiGestureImageView.this.jEO.getHandler().post(new 1(this));
        }
    }

    public MultiGestureImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MultiGestureImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    public void setSingleClickOverListener(d dVar) {
        this.jFh = dVar;
    }

    public void setLongClickOverListener(b bVar) {
        this.jFi = bVar;
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.jEO = new MultiTouchImageView(context, attributeSet);
        this.jEW = new GestureDetector(context, new c(this, (byte) 0));
        this.jEV = new OverScroller(context, new DecelerateInterpolator(2.0f));
        this.jEO.setLayoutParams(new LayoutParams(-1, -1));
        addView(this.jEO);
        this.jFe = new j(this, new WeakReference(this));
        this.jFf = new j(this, new WeakReference(this));
        this.jFg = new j(this, new WeakReference(this));
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.hmV = MeasureSpec.getSize(i);
        this.hmW = MeasureSpec.getSize(i2);
        this.jEX.set(0.0f, 0.0f, (float) this.hmV, (float) this.hmW);
        x.v("MicroMsg.MuitlGestureImageView", "MMGestureGallery width:" + this.hmV + " height:" + this.hmW);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.jEW.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0) {
            this.jEV.forceFinished(true);
            this.jFg.removeMessages(2);
            this.jFg.h(2, 500, 0);
            this.jEO.crn();
            this.count++;
            if (this.count == 1) {
                this.jEP = System.currentTimeMillis();
                this.jER = com.tencent.mm.ui.base.f.i(motionEvent, 0);
                this.jES = com.tencent.mm.ui.base.f.j(motionEvent, 0);
            } else if (this.count == 2) {
                this.jET = System.currentTimeMillis();
                if (this.jET - this.jEQ >= 350) {
                    this.count = 1;
                } else if (Math.abs(this.jER - com.tencent.mm.ui.base.f.i(motionEvent, 0)) >= 35.0f || Math.abs(this.jES - com.tencent.mm.ui.base.f.j(motionEvent, 0)) >= 35.0f) {
                    this.count = 1;
                } else {
                    this.count = 0;
                    x.d("MicroMsg.MuitlGestureImageView", "double click!");
                    if (this.jEO.getScale() <= this.jEO.getScaleRate()) {
                        this.jEO.U(com.tencent.mm.ui.base.f.i(motionEvent, 0), com.tencent.mm.ui.base.f.j(motionEvent, 0));
                    } else {
                        this.jEO.T(com.tencent.mm.ui.base.f.i(motionEvent, 0), com.tencent.mm.ui.base.f.j(motionEvent, 0));
                        this.jEO.csa();
                    }
                }
            }
        }
        if (motionEvent.getAction() == 6 || motionEvent.getAction() == 262) {
            this.jFg.removeMessages(2);
            this.bwH = 0.0f;
            this.jEZ = this.jEO.getScale();
            this.jEU = true;
            if (this.jEZ < this.jEO.getScaleRate()) {
                this.jEO.T((com.tencent.mm.ui.base.f.i(motionEvent, 0) - com.tencent.mm.ui.base.f.i(motionEvent, 1)) + com.tencent.mm.ui.base.f.i(motionEvent, 1), (com.tencent.mm.ui.base.f.j(motionEvent, 0) - com.tencent.mm.ui.base.f.j(motionEvent, 1)) + com.tencent.mm.ui.base.f.j(motionEvent, 1));
            }
            if (this.jEZ > this.jEO.getDoubleTabScale()) {
                this.jEO.U((com.tencent.mm.ui.base.f.i(motionEvent, 0) - com.tencent.mm.ui.base.f.i(motionEvent, 1)) + com.tencent.mm.ui.base.f.i(motionEvent, 1), (com.tencent.mm.ui.base.f.j(motionEvent, 0) - com.tencent.mm.ui.base.f.j(motionEvent, 1)) + com.tencent.mm.ui.base.f.j(motionEvent, 1));
            }
        }
        if (motionEvent.getAction() == 1) {
            this.jFg.removeMessages(2);
            if ((this.jFc || this.jFd) && (this.jFa || this.jFb)) {
                this.jEY = new f(this.jEO);
                aSb();
                this.jFc = false;
                this.jFd = false;
                this.jFa = false;
                this.jFb = false;
            } else {
                if (this.jFc) {
                    this.jFc = false;
                    this.jEY = new g(this, this.jEO);
                    aSb();
                }
                if (this.jFd) {
                    this.jFd = false;
                    this.jEY = new h(this, this.jEO);
                    aSb();
                }
                if (this.jFa) {
                    this.jFa = false;
                    this.jEY = new i(this, this.jEO);
                    aSb();
                }
                if (this.jFb) {
                    this.jFb = false;
                    this.jEY = new e(this, this.jEO);
                    aSb();
                }
            }
            this.bwH = 0.0f;
            this.jEZ = this.jEO.getScale();
            if (this.count == 1) {
                this.jEQ = System.currentTimeMillis();
                if (this.jEQ - this.jEP >= 350) {
                    this.count = 0;
                    x.d("MicroMsg.MuitlGestureImageView", "single long click over!");
                } else if (Math.abs(this.jER - com.tencent.mm.ui.base.f.i(motionEvent, 0)) < 10.0f && Math.abs(this.jES - com.tencent.mm.ui.base.f.j(motionEvent, 0)) < 10.0f) {
                    j jVar = this.jFf;
                    jVar.ccd = false;
                    jVar.h(0, 350, 0);
                }
            }
        }
        if (motionEvent.getAction() == 5 || motionEvent.getAction() == 261) {
            this.bwH = 0.0f;
            this.jEZ = this.jEO.getScale();
            this.jEU = true;
        }
        if (motionEvent.getAction() == 2) {
            if (com.tencent.mm.ui.base.f.L(motionEvent) == 2) {
                this.jFg.removeMessages(2);
                this.jEU = true;
                this.count = 0;
                float i = com.tencent.mm.ui.base.f.i(motionEvent, 0) - com.tencent.mm.ui.base.f.i(motionEvent, 1);
                float j = com.tencent.mm.ui.base.f.j(motionEvent, 0) - com.tencent.mm.ui.base.f.j(motionEvent, 1);
                float sqrt = (float) Math.sqrt((double) ((i * i) + (j * j)));
                if (this.bwH == 0.0f) {
                    this.bwH = sqrt;
                } else {
                    sqrt /= this.bwH;
                    if (this.jEU) {
                        this.jEO.h(sqrt * this.jEZ, i + com.tencent.mm.ui.base.f.i(motionEvent, 1), j + com.tencent.mm.ui.base.f.j(motionEvent, 1));
                    }
                }
            } else if (Math.abs(this.jER - com.tencent.mm.ui.base.f.i(motionEvent, 0)) > 10.0f || Math.abs(this.jES - com.tencent.mm.ui.base.f.j(motionEvent, 0)) > 10.0f) {
                this.jFg.removeMessages(2);
                this.count = 0;
                computeScroll();
            }
        }
        return true;
    }

    public void computeScroll() {
        int i = 0;
        if (this.jEO != null && this.jEV.computeScrollOffset()) {
            int currX = this.jEV.getCurrX() - this.SQ;
            int currY = this.jEV.getCurrY() - this.SR;
            this.SQ = this.jEV.getCurrX();
            this.SR = this.jEV.getCurrY();
            float scale = this.jEO.getScale();
            float imageWidth = ((float) this.jEO.getImageWidth()) * scale;
            scale *= (float) this.jEO.getImageHeight();
            float[] fArr = new float[9];
            this.jEO.getImageMatrix().getValues(fArr);
            float f = fArr[2];
            imageWidth += f;
            float f2 = fArr[5];
            float f3 = f2 + scale;
            if (currX < 0 && ((float) currX) < this.jEX.right - ((float) Math.round(imageWidth))) {
                currX = (int) (this.jEX.right - ((float) Math.round(imageWidth)));
            }
            if (currX > 0 && ((float) currX) > this.jEX.left - ((float) Math.round(f))) {
                currX = (int) (this.jEX.left - ((float) Math.round(f)));
            }
            if (currY < 0 && ((float) currY) < this.jEX.bottom - ((float) Math.round(f3))) {
                currY = (int) (this.jEX.bottom - ((float) Math.round(f3)));
            }
            if (currY > 0 && ((float) currY) > this.jEX.top - ((float) Math.round(f2))) {
                currY = (int) (this.jEX.top - ((float) Math.round(f2)));
            }
            if (((float) Math.round(f)) >= this.jEX.left || ((float) Math.round(imageWidth)) <= this.jEX.right) {
                currX = 0;
            } else if (((float) Math.round(f2)) >= this.jEX.top || ((float) Math.round(f3)) <= this.jEX.bottom) {
                currY = 0;
            }
            if (scale >= ((float) this.hmW)) {
                i = currY;
            }
            this.jEO.V((float) currX, (float) i);
            postInvalidate();
        }
    }

    private void aSa() {
        this.jFe.removeMessages(1);
    }

    private void aSb() {
        aSa();
        this.jFe.h(1, 15, 15);
    }

    public void setEnableHorLongBmpMode(boolean z) {
        this.jEO.setEnableHorLongBmpMode(z);
    }

    public int getImageWidth() {
        return this.jEO.getImageWidth();
    }

    public void setImageWidth(int i) {
        this.jEO.setImageWidth(i);
    }

    public int getImageHeight() {
        return this.jEO.getImageHeight();
    }

    public void setImageHeight(int i) {
        this.jEO.setImageHeight(i);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.jEO.setImageBitmap(bitmap);
        this.jEO.crm();
    }
}
