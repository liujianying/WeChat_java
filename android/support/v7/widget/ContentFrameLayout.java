package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class ContentFrameLayout extends FrameLayout {
    private TypedValue NF;
    private TypedValue NG;
    private TypedValue NH;
    private TypedValue NI;
    private TypedValue NJ;
    private TypedValue NK;
    public final Rect NL;
    private a NM;

    public interface a {
        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.NL = new Rect();
    }

    public final void g(Rect rect) {
        fitSystemWindows(rect);
    }

    public void setAttachListener(a aVar) {
        this.NM = aVar;
    }

    protected void onMeasure(int i, int i2) {
        int dimension;
        Object obj;
        TypedValue typedValue;
        int dimension2;
        Object obj2 = null;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        Object obj3 = displayMetrics.widthPixels < displayMetrics.heightPixels ? 1 : null;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            TypedValue typedValue2 = obj3 != null ? this.NI : this.NH;
            if (!(typedValue2 == null || typedValue2.type == 0)) {
                if (typedValue2.type == 5) {
                    dimension = (int) typedValue2.getDimension(displayMetrics);
                } else if (typedValue2.type == 6) {
                    dimension = (int) typedValue2.getFraction((float) displayMetrics.widthPixels, (float) displayMetrics.widthPixels);
                } else {
                    dimension = 0;
                }
                if (dimension > 0) {
                    i = MeasureSpec.makeMeasureSpec(Math.min(dimension - (this.NL.left + this.NL.right), MeasureSpec.getSize(i)), 1073741824);
                    obj = 1;
                    if (mode2 == Integer.MIN_VALUE) {
                        typedValue2 = obj3 != null ? this.NJ : this.NK;
                        if (!(typedValue2 == null || typedValue2.type == 0)) {
                            if (typedValue2.type == 5) {
                                dimension = (int) typedValue2.getDimension(displayMetrics);
                            } else if (typedValue2.type == 6) {
                                dimension = (int) typedValue2.getFraction((float) displayMetrics.heightPixels, (float) displayMetrics.heightPixels);
                            } else {
                                dimension = 0;
                            }
                            if (dimension > 0) {
                                i2 = MeasureSpec.makeMeasureSpec(Math.min(dimension - (this.NL.top + this.NL.bottom), MeasureSpec.getSize(i2)), 1073741824);
                            }
                        }
                    }
                    super.onMeasure(i, i2);
                    mode2 = getMeasuredWidth();
                    dimension = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                    if (obj == null && mode == Integer.MIN_VALUE) {
                        typedValue = obj3 == null ? this.NG : this.NF;
                        if (!(typedValue == null || typedValue.type == 0)) {
                            dimension2 = typedValue.type != 5 ? (int) typedValue.getDimension(displayMetrics) : typedValue.type == 6 ? (int) typedValue.getFraction((float) displayMetrics.widthPixels, (float) displayMetrics.widthPixels) : 0;
                            if (dimension2 > 0) {
                                dimension2 -= this.NL.left + this.NL.right;
                            }
                            if (mode2 < dimension2) {
                                dimension2 = MeasureSpec.makeMeasureSpec(dimension2, 1073741824);
                                obj2 = 1;
                                if (obj2 == null) {
                                    super.onMeasure(dimension2, i2);
                                }
                            }
                        }
                    }
                    dimension2 = dimension;
                    if (obj2 == null) {
                        super.onMeasure(dimension2, i2);
                    }
                }
            }
        }
        obj = null;
        if (mode2 == Integer.MIN_VALUE) {
            typedValue2 = obj3 != null ? this.NJ : this.NK;
            if (!(typedValue2 == null || typedValue2.type == 0)) {
                if (typedValue2.type == 5) {
                    dimension = (int) typedValue2.getDimension(displayMetrics);
                } else if (typedValue2.type == 6) {
                    dimension = (int) typedValue2.getFraction((float) displayMetrics.heightPixels, (float) displayMetrics.heightPixels);
                } else {
                    dimension = 0;
                }
                if (dimension > 0) {
                    i2 = MeasureSpec.makeMeasureSpec(Math.min(dimension - (this.NL.top + this.NL.bottom), MeasureSpec.getSize(i2)), 1073741824);
                }
            }
        }
        super.onMeasure(i, i2);
        mode2 = getMeasuredWidth();
        dimension = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
        if (obj3 == null) {
        }
        if (typedValue.type != 5) {
        }
        if (dimension2 > 0) {
            dimension2 -= this.NL.left + this.NL.right;
        }
        if (mode2 < dimension2) {
            dimension2 = MeasureSpec.makeMeasureSpec(dimension2, 1073741824);
            obj2 = 1;
            if (obj2 == null) {
                super.onMeasure(dimension2, i2);
            }
        }
        dimension2 = dimension;
        if (obj2 == null) {
            super.onMeasure(dimension2, i2);
        }
    }

    public TypedValue getMinWidthMajor() {
        if (this.NF == null) {
            this.NF = new TypedValue();
        }
        return this.NF;
    }

    public TypedValue getMinWidthMinor() {
        if (this.NG == null) {
            this.NG = new TypedValue();
        }
        return this.NG;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.NH == null) {
            this.NH = new TypedValue();
        }
        return this.NH;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.NI == null) {
            this.NI = new TypedValue();
        }
        return this.NI;
    }

    public TypedValue getFixedHeightMajor() {
        if (this.NJ == null) {
            this.NJ = new TypedValue();
        }
        return this.NJ;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.NK == null) {
            this.NK = new TypedValue();
        }
        return this.NK;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.NM != null) {
            this.NM.onDetachedFromWindow();
        }
    }
}
