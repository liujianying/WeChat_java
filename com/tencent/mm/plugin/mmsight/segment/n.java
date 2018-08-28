package com.tencent.mm.plugin.mmsight.segment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.mmsight.segment.k.b;
import com.tencent.mm.plugin.mmsight.segment.k.e;
import com.tencent.mm.plugin.sns.i$l;

public final class n extends View {
    private int borderWidth;
    private int lmA;
    private float lmB;
    private float lmC;
    private float lmD;
    private int lmE;
    Rect lmF;
    Rect lmG;
    private OnTouchListener lmH;
    private a lmj;
    private boolean lmk;
    boolean lml;
    private int lmm;
    private int lmn;
    Drawable lmo;
    Drawable lmp;
    private int lmq;
    private float lmr;
    private int lms;
    float lmt;
    private int lmu;
    private Paint lmv;
    private Paint lmw;
    private float lmx;
    private Paint lmy;
    private Paint lmz;
    private int padding;

    static /* synthetic */ boolean a(n nVar, Drawable drawable, float f, float f2) {
        if (!nVar.lmk || drawable == null) {
            return false;
        }
        Rect bounds = drawable.getBounds();
        return f2 <= ((float) (bounds.bottom + nVar.lmE)) && f2 >= ((float) (bounds.top - nVar.lmE)) && f >= ((float) (bounds.left - nVar.lmE)) && f <= ((float) (bounds.right + nVar.lmE));
    }

    public n(Context context) {
        super(context);
        this.lmk = false;
        this.lml = false;
        this.lmt = -1.0f;
        this.lmC = -1.0f;
        this.lmD = -1.0f;
        this.padding = 0;
        this.lmH = new 2(this);
        this.lmq = a.fromDPToPix(getContext(), 8);
        this.lmr = ((float) this.lmq) * 0.5f;
        this.lmE = a.fromDPToPix(getContext(), 8);
        this.lmo = new b(this, a.f(getContext(), e.video_clip_slider_selected), a.f(getContext(), e.video_clip_slider_normal));
        this.lmp = new b(this, a.f(getContext(), e.video_clip_slider_selected), a.f(getContext(), e.video_clip_slider_normal));
        this.lms = a.fromDPToPix(getContext(), 1);
        this.lmu = a.ad(getContext(), b.video_segment_seekbar_recycler_view_height);
        this.lmt = -1.0f;
        this.lmv = new Paint();
        this.lmv.setColor(a.g(getContext(), k.a.white));
        this.lmv.setAlpha(i$l.AppCompatTheme_checkboxStyle);
        this.lmy = new Paint();
        this.lmy.setColor(a.g(getContext(), k.a.black));
        this.lmy.setAlpha(i$l.AppCompatTheme_checkboxStyle);
        this.lmw = new Paint();
        this.lmw.setColor(a.g(getContext(), k.a.white));
        this.lmw.setStyle(Style.STROKE);
        this.borderWidth = dQ(getContext());
        this.lmw.setStrokeWidth((float) this.borderWidth);
        this.lmx = ((float) this.borderWidth) * 0.5f;
        this.lmz = new Paint();
        this.lmz.setColor(a.g(getContext(), k.a.white));
        this.lmz.setStyle(Style.STROKE);
        this.lmA = dQ(getContext());
        this.lmB = ((float) this.lmA) * 0.5f;
        this.lmz.setStrokeWidth((float) this.lmA);
        this.lmz.setAlpha(178);
        setOnTouchListener(this.lmH);
    }

    private static int dQ(Context context) {
        return Math.round(TypedValue.applyDimension(1, 1.5f, context.getResources().getDisplayMetrics()));
    }

    protected final void onDraw(Canvas canvas) {
        if (this.lmt > 0.0f) {
            float width = ((float) getWidth()) * this.lmt;
            canvas.drawRect(width - (((float) this.lms) * 0.5f), 0.0f, (((float) this.lms) * 0.5f) + width, (float) this.lmu, this.lmv);
        }
        if (this.lmk) {
            int centerX = this.lmo.getBounds().centerX();
            int centerX2 = this.lmp.getBounds().centerX();
            if (gy(true) || gy(false)) {
                canvas.drawRect(((float) this.padding) + this.lmB, this.lmB, ((float) (getWidth() - this.padding)) - this.lmB, ((float) getBottom()) - this.lmB, this.lmz);
            }
            if (this.lmo.getBounds().left > 0) {
                canvas.drawRect(0.0f, 0.0f, (float) centerX, (float) getHeight(), this.lmy);
            }
            if (this.lmp.getBounds().right < getWidth()) {
                canvas.drawRect((float) centerX2, 0.0f, (float) getWidth(), (float) getHeight(), this.lmy);
            }
            canvas.drawLine((float) centerX, this.lmx, (float) centerX2, this.lmx, this.lmw);
            canvas.drawLine((float) centerX, ((float) getHeight()) - this.lmx, (float) centerX2, ((float) getHeight()) - this.lmx, this.lmw);
            this.lmo.draw(canvas);
            this.lmp.draw(canvas);
        }
    }

    public final void setCursorPos(float f) {
        if (this.lmk) {
            this.lmt = f;
            invalidate();
        }
    }

    private boolean gy(boolean z) {
        if (z) {
            return b.a((b) this.lmo);
        }
        return b.a((b) this.lmp);
    }

    public final int getLeftSliderBound() {
        return this.lmo.getBounds().left;
    }

    public final int getRightSliderBound() {
        return this.lmp.getBounds().right;
    }

    public final void setOnSliderTouchListener(a aVar) {
        this.lmj = aVar;
    }
}
