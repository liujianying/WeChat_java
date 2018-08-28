package android.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckedTextView;

public class AppCompatCheckedTextView extends CheckedTextView {
    private static final int[] HN = new int[]{16843016};
    private h Mb;
    private l Md;

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i) {
        super(am.T(context), attributeSet, i);
        this.Md = l.c(this);
        this.Md.b(attributeSet, i);
        this.Md.eL();
        this.Mb = h.eJ();
        ap a = ap.a(getContext(), attributeSet, HN, i);
        setCheckMarkDrawable(a.getDrawable(0));
        a.Ww.recycle();
    }

    public void setCheckMarkDrawable(int i) {
        if (this.Mb != null) {
            setCheckMarkDrawable(this.Mb.a(getContext(), i, false));
        } else {
            super.setCheckMarkDrawable(i);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.Md != null) {
            this.Md.l(context, i);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.Md != null) {
            this.Md.eL();
        }
    }
}
