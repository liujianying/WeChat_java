package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.t;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.widget.CheckBox;

public class AppCompatCheckBox extends CheckBox implements t {
    private h Mb;
    private g Mh;

    public AppCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.checkboxStyle);
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(am.T(context), attributeSet, i);
        this.Mb = h.eJ();
        this.Mh = new g(this, this.Mb);
        this.Mh.b(attributeSet, i);
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.Mh != null) {
            this.Mh.eH();
        }
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(this.Mb != null ? this.Mb.a(getContext(), i, false) : android.support.v4.content.a.f(getContext(), i));
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.Mh != null ? this.Mh.aU(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.Mh != null) {
            this.Mh.setSupportButtonTintList(colorStateList);
        }
    }

    public ColorStateList getSupportButtonTintList() {
        return this.Mh != null ? this.Mh.Mj : null;
    }

    public void setSupportButtonTintMode(Mode mode) {
        if (this.Mh != null) {
            this.Mh.setSupportButtonTintMode(mode);
        }
    }

    public Mode getSupportButtonTintMode() {
        return this.Mh != null ? this.Mh.Mk : null;
    }
}
