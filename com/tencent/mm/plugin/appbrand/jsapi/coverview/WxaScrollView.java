package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.tencent.mm.plugin.appbrand.jsapi.o.e;

public class WxaScrollView extends FrameLayout implements o, p, e {
    private float cQ;
    private int doi;
    private float fPH;
    private int fPI;
    private Paint fPJ = new Paint();
    private FrameLayout fPR;
    private ScrollView fPS;
    private m fPT;
    private boolean fPU = true;
    private boolean fPV = true;

    public WxaScrollView(Context context) {
        super(context);
        init();
    }

    public WxaScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public WxaScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.fPS = new 1(this, getContext());
        this.fPR = new FrameLayout(getContext());
        super.addView(this.fPS, 0, new LayoutParams(-1, -1));
        this.fPS.addView(this.fPR, 0, new LayoutParams(-1, -2));
        this.fPJ.setStyle(Style.STROKE);
        this.fPJ.setAntiAlias(true);
        setWillNotDraw(false);
    }

    public void draw(Canvas canvas) {
        Object obj;
        float f = 0.0f;
        Object obj2 = this.fPH > 0.0f ? 1 : null;
        if (obj2 != null) {
            canvas.save();
            Path path = new Path();
            path.addRoundRect(new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), this.fPH, this.fPH, Direction.CW);
            canvas.clipPath(path);
        }
        if (this.doi != 0) {
            canvas.drawColor(this.doi);
        }
        if (this.cQ > 0.0f) {
            float f2 = this.cQ / 2.0f;
            canvas.drawRoundRect(new RectF(f2, f2, ((float) getWidth()) - f2, ((float) getHeight()) - f2), this.fPH, this.fPH, this.fPJ);
            if (obj2 != null) {
                canvas.restore();
            }
            canvas.save();
            Path path2 = new Path();
            if (this.fPH > 0.0f && this.fPH - this.cQ > 0.0f) {
                f = this.fPH - this.cQ;
            }
            path2.addRoundRect(new RectF(this.cQ, this.cQ, ((float) getWidth()) - this.cQ, ((float) getHeight()) - this.cQ), f, f, Direction.CW);
            canvas.clipPath(path2);
            obj = 1;
        } else {
            obj = obj2;
        }
        int save = canvas.save();
        super.draw(canvas);
        canvas.restoreToCount(save);
        if (obj != null) {
            canvas.restore();
        }
    }

    public ViewGroup getTargetView() {
        return this.fPR;
    }

    public int getTargetViewChildCount() {
        return this.fPR.getChildCount();
    }

    public void addView(View view, int i) {
        this.fPR.addView(view, i);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        this.fPR.addView(view, i, layoutParams);
    }

    public void removeView(View view) {
        this.fPR.removeView(view);
    }

    public void setBorderRadius(float f) {
        this.fPH = f;
    }

    public void setBorderColor(int i) {
        this.fPI = i;
        this.fPJ.setColor(i);
    }

    public void setBorderWidth(float f) {
        this.cQ = f;
        this.fPJ.setStrokeWidth(f);
    }

    public void setBgColor(int i) {
        this.doi = i;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            boolean z;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (this.fPH > 0.0f) {
                double pow = Math.pow((double) this.fPH, 2.0d);
                float width = (float) getWidth();
                float height = (float) getHeight();
                if (x < this.fPH) {
                    if (y < this.fPH) {
                        if (Math.pow((double) (this.fPH - y), 2.0d) + Math.pow((double) (this.fPH - x), 2.0d) > pow) {
                            z = false;
                            if (!z) {
                                return false;
                            }
                        }
                    } else if (y > height - this.fPH) {
                        if (Math.pow((double) ((this.fPH + y) - height), 2.0d) + Math.pow((double) (this.fPH - x), 2.0d) > pow) {
                            z = false;
                            if (z) {
                                return false;
                            }
                        }
                    }
                } else if (x > width - this.fPH) {
                    if (y < this.fPH) {
                        if (Math.pow((double) (this.fPH - y), 2.0d) + Math.pow((double) ((x + this.fPH) - width), 2.0d) > pow) {
                            z = false;
                            if (z) {
                                return false;
                            }
                        }
                    } else if (y > height - this.fPH) {
                        if (Math.pow((double) ((this.fPH + y) - height), 2.0d) + Math.pow((double) ((x + this.fPH) - width), 2.0d) > pow) {
                            z = false;
                            if (z) {
                                return false;
                            }
                        }
                    }
                }
            }
            z = true;
            if (z) {
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnScrollChangedListener(m mVar) {
        this.fPT = mVar;
    }

    public void setScrollVertical(boolean z) {
        this.fPU = z;
    }

    public void setScrollHorizontal(boolean z) {
        this.fPV = z;
    }

    public void scrollTo(int i, int i2) {
        this.fPS.scrollTo(i, i2);
        invalidate();
    }
}
