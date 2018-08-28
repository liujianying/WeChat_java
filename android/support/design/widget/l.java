package android.support.design.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.design.a$c;
import android.view.ViewTreeObserver.OnPreDrawListener;

abstract class l {
    static final int[] EMPTY_STATE_SET = new int[0];
    static final int[] PRESSED_ENABLED_STATE_SET = new int[]{16842919, 16842910};
    static final int[] fM = new int[]{16842908, 16842910};
    private final Rect ea = new Rect();
    Drawable fG;
    Drawable fH;
    d fI;
    Drawable fJ;
    float fK;
    float fL;
    final VisibilityAwareImageButton fN;
    final p fO;
    OnPreDrawListener fP;

    abstract void a(ColorStateList colorStateList, Mode mode, int i, int i2);

    abstract void al();

    abstract void am();

    abstract void an();

    abstract void ao();

    abstract void c(int[] iArr);

    abstract void d(Rect rect);

    abstract float getElevation();

    abstract void l(float f);

    abstract void m(float f);

    abstract void setBackgroundTintList(ColorStateList colorStateList);

    abstract void setBackgroundTintMode(Mode mode);

    abstract void setRippleColor(int i);

    l(VisibilityAwareImageButton visibilityAwareImageButton, p pVar) {
        this.fN = visibilityAwareImageButton;
        this.fO = pVar;
    }

    final void setElevation(float f) {
        if (this.fK != f) {
            this.fK = f;
            l(f);
        }
    }

    final void as() {
        Rect rect = this.ea;
        d(rect);
        e(rect);
        this.fO.d(rect.left, rect.top, rect.right, rect.bottom);
    }

    void e(Rect rect) {
    }

    boolean aq() {
        return false;
    }

    final d a(int i, ColorStateList colorStateList) {
        Resources resources = this.fN.getResources();
        d at = at();
        int color = resources.getColor(a$c.design_fab_stroke_top_outer_color);
        int color2 = resources.getColor(a$c.design_fab_stroke_top_inner_color);
        int color3 = resources.getColor(a$c.design_fab_stroke_end_inner_color);
        int color4 = resources.getColor(a$c.design_fab_stroke_end_outer_color);
        at.cR = color;
        at.cS = color2;
        at.cT = color3;
        at.cU = color4;
        float f = (float) i;
        if (at.cQ != f) {
            at.cQ = f;
            at.cN.setStrokeWidth(f * 1.3333f);
            at.cX = true;
            at.invalidateSelf();
        }
        at.a(colorStateList);
        return at;
    }

    d at() {
        return new d();
    }

    void ar() {
    }

    static GradientDrawable au() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-1);
        return gradientDrawable;
    }
}
