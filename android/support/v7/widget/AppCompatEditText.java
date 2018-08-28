package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.x;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.widget.EditText;

public class AppCompatEditText extends EditText implements x {
    private h Mb;
    private f Mc;
    private l Md;

    public AppCompatEditText(Context context) {
        this(context, null);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.editTextStyle);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int i) {
        super(am.T(context), attributeSet, i);
        this.Mb = h.eJ();
        this.Mc = new f(this, this.Mb);
        this.Mc.b(attributeSet, i);
        this.Md = l.c(this);
        this.Md.b(attributeSet, i);
        this.Md.eL();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.Mc != null) {
            this.Mc.aT(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.Mc != null) {
            this.Mc.b(null);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.Mc != null) {
            this.Mc.setSupportBackgroundTintList(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.Mc != null ? this.Mc.getSupportBackgroundTintList() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.Mc != null) {
            this.Mc.setSupportBackgroundTintMode(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.Mc != null ? this.Mc.getSupportBackgroundTintMode() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.Mc != null) {
            this.Mc.eG();
        }
        if (this.Md != null) {
            this.Md.eL();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.Md != null) {
            this.Md.l(context, i);
        }
    }
}
