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
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.appbrand.jsapi.container.AppBrandNativeContainerView;
import com.tencent.mm.plugin.appbrand.jsapi.o.e;

public class CoverViewContainer extends AppBrandNativeContainerView implements e {
    private View Sy;
    private float cQ;
    private int doi;
    private float fPH;
    private int fPI;
    private Paint fPJ = new Paint();

    public CoverViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public CoverViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void setTargetView(View view) {
        this.Sy = view;
        super.addView(view, 0, new LayoutParams(-1, -1));
    }

    public CoverViewContainer(Context context, View view) {
        super(context);
        setTargetView(view);
        init();
    }

    private void init() {
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
        super.draw(canvas);
        if (obj != null) {
            canvas.restore();
        }
    }

    public final <T extends View> T A(Class<T> cls) {
        try {
            if (cls.isAssignableFrom(this.Sy.getClass())) {
                return this.Sy;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void addView(View view, int i) {
        if (i < 0) {
            i = 0;
        } else if (i > getChildCount() - 1) {
            i = getChildCount() - 1;
        }
        super.addView(view, i + 1);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (i < 0) {
            i = 0;
        } else if (i > getChildCount() - 1) {
            i = getChildCount() - 1;
        }
        super.addView(view, i + 1, layoutParams);
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
}
