package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {
    private LayoutInflater Bc;
    private int XA;
    private WeakReference<View> XB;
    private a XC;
    private int Xz;

    public interface a {
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Xz = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.ViewStubCompat, i, 0);
        this.XA = obtainStyledAttributes.getResourceId(k.ViewStubCompat_android_inflatedId, -1);
        this.Xz = obtainStyledAttributes.getResourceId(k.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(k.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public final int getInflatedId() {
        return this.XA;
    }

    public final void setInflatedId(int i) {
        this.XA = i;
    }

    public final int getLayoutResource() {
        return this.Xz;
    }

    public final void setLayoutResource(int i) {
        this.Xz = i;
    }

    public final void setLayoutInflater(LayoutInflater layoutInflater) {
        this.Bc = layoutInflater;
    }

    public final LayoutInflater getLayoutInflater() {
        return this.Bc;
    }

    protected final void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public final void draw(Canvas canvas) {
    }

    protected final void dispatchDraw(Canvas canvas) {
    }

    public final void setVisibility(int i) {
        if (this.XB != null) {
            View view = (View) this.XB.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            inflate();
        }
    }

    public final View inflate() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.Xz != 0) {
            LayoutInflater layoutInflater;
            ViewGroup viewGroup = (ViewGroup) parent;
            if (this.Bc != null) {
                layoutInflater = this.Bc;
            } else {
                layoutInflater = LayoutInflater.from(getContext());
            }
            View inflate = layoutInflater.inflate(this.Xz, viewGroup, false);
            if (this.XA != -1) {
                inflate.setId(this.XA);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.XB = new WeakReference(inflate);
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    public final void setOnInflateListener(a aVar) {
        this.XC = aVar;
    }
}
