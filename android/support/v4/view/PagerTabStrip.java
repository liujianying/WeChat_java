package android.support.v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class PagerTabStrip extends PagerTitleStrip {
    private final Rect bJ = new Rect();
    private int fW;
    private int va = this.vD;
    private int vb;
    private int vc;
    private int vd;
    private int ve;
    private int vf;
    private final Paint vg = new Paint();
    private int vh = 255;
    private boolean vi = false;
    private boolean vj = false;
    private int vk;
    private boolean vl;
    private float vm;
    private float vn;

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.vg.setColor(this.va);
        float f = context.getResources().getDisplayMetrics().density;
        this.vb = (int) ((3.0f * f) + 0.5f);
        this.vc = (int) ((6.0f * f) + 0.5f);
        this.vd = (int) (64.0f * f);
        this.vf = (int) ((16.0f * f) + 0.5f);
        this.vk = (int) ((1.0f * f) + 0.5f);
        this.ve = (int) ((f * 32.0f) + 0.5f);
        this.fW = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.vq.setFocusable(true);
        this.vq.setOnClickListener(new 1(this));
        this.vs.setFocusable(true);
        this.vs.setOnClickListener(new 2(this));
        if (getBackground() == null) {
            this.vi = true;
        }
    }

    public void setTabIndicatorColor(int i) {
        this.va = i;
        this.vg.setColor(this.va);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i) {
        setTabIndicatorColor(getContext().getResources().getColor(i));
    }

    public int getTabIndicatorColor() {
        return this.va;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (i4 < this.vc) {
            i4 = this.vc;
        }
        super.setPadding(i, i2, i3, i4);
    }

    public void setTextSpacing(int i) {
        if (i < this.vd) {
            i = this.vd;
        }
        super.setTextSpacing(i);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.vj) {
            this.vi = drawable == null;
        }
    }

    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (!this.vj) {
            this.vi = (-16777216 & i) == 0;
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (!this.vj) {
            this.vi = i == 0;
        }
    }

    public void setDrawFullUnderline(boolean z) {
        this.vi = z;
        this.vj = true;
        invalidate();
    }

    public boolean getDrawFullUnderline() {
        return this.vi;
    }

    int getMinHeight() {
        return Math.max(super.getMinHeight(), this.ve);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.vl) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (action) {
            case 0:
                this.vm = x;
                this.vn = y;
                this.vl = false;
                break;
            case 1:
                if (x >= ((float) (this.vr.getLeft() - this.vf))) {
                    if (x > ((float) (this.vr.getRight() + this.vf))) {
                        this.vp.setCurrentItem(this.vp.getCurrentItem() + 1);
                        break;
                    }
                }
                this.vp.setCurrentItem(this.vp.getCurrentItem() - 1);
                break;
                break;
            case 2:
                if (Math.abs(x - this.vm) > ((float) this.fW) || Math.abs(y - this.vn) > ((float) this.fW)) {
                    this.vl = true;
                    break;
                }
        }
        return true;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.vr.getLeft() - this.vf;
        int right = this.vr.getRight() + this.vf;
        int i = height - this.vb;
        this.vg.setColor((this.vh << 24) | (this.va & 16777215));
        canvas.drawRect((float) left, (float) i, (float) right, (float) height, this.vg);
        if (this.vi) {
            this.vg.setColor(-16777216 | (this.va & 16777215));
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.vk), (float) (getWidth() - getPaddingRight()), (float) height, this.vg);
        }
    }

    final void a(int i, float f, boolean z) {
        Rect rect = this.bJ;
        int height = getHeight();
        int i2 = height - this.vb;
        rect.set(this.vr.getLeft() - this.vf, i2, this.vr.getRight() + this.vf, height);
        super.a(i, f, z);
        this.vh = (int) ((Math.abs(f - 0.5f) * 2.0f) * 255.0f);
        rect.union(this.vr.getLeft() - this.vf, i2, this.vr.getRight() + this.vf, height);
        invalidate(rect);
    }
}
