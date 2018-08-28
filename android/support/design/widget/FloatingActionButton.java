package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.a;
import android.support.design.a.d;
import android.support.design.a.h;
import android.support.design.widget.CoordinatorLayout.b;
import android.support.v7.widget.i;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;

@b(a.class)
public class FloatingActionButton extends VisibilityAwareImageButton {
    private ColorStateList fe;
    private Mode ff;
    private int fg;
    private int fh;
    private int fi;
    private int fj;
    private boolean fk;
    private final Rect fl;
    private i fn;
    private l fo;

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        Mode mode;
        super(context, attributeSet, i);
        this.fl = new Rect();
        t.G(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.i.FloatingActionButton, i, h.Widget_Design_FloatingActionButton);
        this.fe = obtainStyledAttributes.getColorStateList(a.i.FloatingActionButton_backgroundTint);
        switch (obtainStyledAttributes.getInt(a.i.FloatingActionButton_backgroundTintMode, -1)) {
            case 3:
                mode = Mode.SRC_OVER;
                break;
            case 5:
                mode = Mode.SRC_IN;
                break;
            case 9:
                mode = Mode.SRC_ATOP;
                break;
            case 14:
                mode = Mode.MULTIPLY;
                break;
            case 15:
                mode = Mode.SCREEN;
                break;
            default:
                mode = null;
                break;
        }
        this.ff = mode;
        this.fh = obtainStyledAttributes.getColor(a.i.FloatingActionButton_rippleColor, 0);
        this.fi = obtainStyledAttributes.getInt(a.i.FloatingActionButton_fabSize, 0);
        this.fg = obtainStyledAttributes.getDimensionPixelSize(a.i.FloatingActionButton_borderWidth, 0);
        float dimension = obtainStyledAttributes.getDimension(a.i.FloatingActionButton_elevation, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(a.i.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.fk = obtainStyledAttributes.getBoolean(a.i.FloatingActionButton_useCompatPadding, false);
        obtainStyledAttributes.recycle();
        this.fn = new i(this, android.support.v7.widget.h.eJ());
        this.fn.b(attributeSet, i);
        this.fj = (getSizeDimension() - ((int) getResources().getDimension(d.design_fab_image_size))) / 2;
        getImpl().a(this.fe, this.ff, this.fh, this.fg);
        getImpl().setElevation(dimension);
        l impl = getImpl();
        if (impl.fL != dimension2) {
            impl.fL = dimension2;
            impl.m(dimension2);
        }
        getImpl().as();
    }

    protected void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        sizeDimension = Math.min(resolveAdjustedSize(sizeDimension, i), resolveAdjustedSize(sizeDimension, i2));
        setMeasuredDimension((this.fl.left + sizeDimension) + this.fl.right, (sizeDimension + this.fl.top) + this.fl.bottom);
    }

    public void setRippleColor(int i) {
        if (this.fh != i) {
            this.fh = i;
            getImpl().setRippleColor(i);
        }
    }

    public ColorStateList getBackgroundTintList() {
        return this.fe;
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.fe != colorStateList) {
            this.fe = colorStateList;
            getImpl().setBackgroundTintList(colorStateList);
        }
    }

    public Mode getBackgroundTintMode() {
        return this.ff;
    }

    public void setBackgroundTintMode(Mode mode) {
        if (this.ff != mode) {
            this.ff = mode;
            getImpl().setBackgroundTintMode(mode);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
    }

    public void setBackgroundResource(int i) {
    }

    public void setBackgroundColor(int i) {
    }

    public void setImageResource(int i) {
        this.fn.setImageResource(i);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.fk != z) {
            this.fk = z;
            getImpl().ao();
        }
    }

    public boolean getUseCompatPadding() {
        return this.fk;
    }

    final int getSizeDimension() {
        switch (this.fi) {
            case 1:
                return getResources().getDimensionPixelSize(d.design_fab_size_mini);
            default:
                return getResources().getDimensionPixelSize(d.design_fab_size_normal);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        l impl = getImpl();
        if (impl.aq()) {
            if (impl.fP == null) {
                impl.fP = new l$1(impl);
            }
            impl.fN.getViewTreeObserver().addOnPreDrawListener(impl.fP);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l impl = getImpl();
        if (impl.fP != null) {
            impl.fN.getViewTreeObserver().removeOnPreDrawListener(impl.fP);
            impl.fP = null;
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().c(getDrawableState());
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().al();
    }

    public Drawable getContentBackground() {
        return getImpl().fJ;
    }

    private static int resolveAdjustedSize(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(i, size);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    public float getCompatElevation() {
        return getImpl().getElevation();
    }

    public void setCompatElevation(float f) {
        getImpl().setElevation(f);
    }

    private l getImpl() {
        if (this.fo == null) {
            int i = VERSION.SDK_INT;
            l mVar = i >= 21 ? new m(this, new b(this, (byte) 0)) : i >= 14 ? new k(this, new b(this, (byte) 0)) : new j(this, new b(this, (byte) 0));
            this.fo = mVar;
        }
        return this.fo;
    }
}
