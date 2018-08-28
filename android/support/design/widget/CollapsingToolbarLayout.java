package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.a$i;
import android.support.design.a.e;
import android.support.design.a.h;
import android.support.design.widget.AppBarLayout.a;
import android.support.v4.view.ap;
import android.support.v4.view.z;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.smtt.sdk.WebView;

public class CollapsingToolbarLayout extends FrameLayout {
    private ap bW;
    private boolean dR;
    private int dS;
    private Toolbar dT;
    private View dU;
    private View dV;
    private int dW;
    private int dX;
    private int dY;
    private int dZ;
    private final Rect ea;
    private final f eb;
    private boolean ec;
    private boolean ed;
    private Drawable ee;
    private Drawable ef;
    private int eg;
    private boolean eh;
    private u ei;
    private a ej;
    private int ek;

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dR = true;
        this.ea = new Rect();
        t.G(context);
        this.eb = new f(this);
        this.eb.b(a.bP);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a$i.CollapsingToolbarLayout, i, h.Widget_Design_CollapsingToolbar);
        this.eb.x(obtainStyledAttributes.getInt(a$i.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        this.eb.y(obtainStyledAttributes.getInt(a$i.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(a$i.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.dZ = dimensionPixelSize;
        this.dY = dimensionPixelSize;
        this.dX = dimensionPixelSize;
        this.dW = dimensionPixelSize;
        if (obtainStyledAttributes.hasValue(a$i.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.dW = obtainStyledAttributes.getDimensionPixelSize(a$i.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (obtainStyledAttributes.hasValue(a$i.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.dY = obtainStyledAttributes.getDimensionPixelSize(a$i.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (obtainStyledAttributes.hasValue(a$i.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.dX = obtainStyledAttributes.getDimensionPixelSize(a$i.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (obtainStyledAttributes.hasValue(a$i.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.dZ = obtainStyledAttributes.getDimensionPixelSize(a$i.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.ec = obtainStyledAttributes.getBoolean(a$i.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(obtainStyledAttributes.getText(a$i.CollapsingToolbarLayout_title));
        this.eb.A(h.TextAppearance_Design_CollapsingToolbar_Expanded);
        this.eb.z(h.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (obtainStyledAttributes.hasValue(a$i.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            this.eb.A(obtainStyledAttributes.getResourceId(a$i.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (obtainStyledAttributes.hasValue(a$i.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            this.eb.z(obtainStyledAttributes.getResourceId(a$i.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        setContentScrim(obtainStyledAttributes.getDrawable(a$i.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(obtainStyledAttributes.getDrawable(a$i.CollapsingToolbarLayout_statusBarScrim));
        this.dS = obtainStyledAttributes.getResourceId(a$i.CollapsingToolbarLayout_toolbarId, -1);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        z.b(this, new 1(this));
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            if (this.ej == null) {
                this.ej = new a(this, (byte) 0);
            }
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            a aVar = this.ej;
            if (!(aVar == null || appBarLayout.bX.contains(aVar))) {
                appBarLayout.bX.add(aVar);
            }
        }
        z.Y(this);
    }

    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        if (this.ej != null && (parent instanceof AppBarLayout)) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            a aVar = this.ej;
            if (aVar != null) {
                appBarLayout.bX.remove(aVar);
            }
        }
        super.onDetachedFromWindow();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        ad();
        if (this.dT == null && this.ee != null && this.eg > 0) {
            this.ee.mutate().setAlpha(this.eg);
            this.ee.draw(canvas);
        }
        if (this.ec && this.ed) {
            this.eb.draw(canvas);
        }
        if (this.ef != null && this.eg > 0) {
            int systemWindowInsetTop = this.bW != null ? this.bW.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.ef.setBounds(0, -this.ek, getWidth(), systemWindowInsetTop - this.ek);
                this.ef.mutate().setAlpha(this.eg);
                this.ef.draw(canvas);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        ad();
        if (view == this.dT && this.ee != null && this.eg > 0) {
            this.ee.mutate().setAlpha(this.eg);
            this.ee.draw(canvas);
        }
        return super.drawChild(canvas, view, j);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.ee != null) {
            this.ee.setBounds(0, 0, i, i2);
        }
    }

    private void ad() {
        if (this.dR) {
            View view;
            this.dT = null;
            this.dU = null;
            if (this.dS != -1) {
                this.dT = (Toolbar) findViewById(this.dS);
                if (this.dT != null) {
                    view = this.dT;
                    CollapsingToolbarLayout parent = view.getParent();
                    while (parent != this && parent != null) {
                        if (parent instanceof View) {
                            view = parent;
                        }
                        parent = parent.getParent();
                    }
                    this.dU = view;
                }
            }
            if (this.dT == null) {
                Toolbar toolbar;
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    view = getChildAt(i);
                    if (view instanceof Toolbar) {
                        toolbar = (Toolbar) view;
                        break;
                    }
                }
                toolbar = null;
                this.dT = toolbar;
            }
            af();
            this.dR = false;
        }
    }

    private void af() {
        if (!(this.ec || this.dV == null)) {
            ViewParent parent = this.dV.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.dV);
            }
        }
        if (this.ec && this.dT != null) {
            if (this.dV == null) {
                this.dV = new View(getContext());
            }
            if (this.dV.getParent() == null) {
                this.dT.addView(this.dV, -1, -1);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        ad();
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6 = 1;
        int i7 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.ec && this.dV != null) {
            boolean z2 = z.ak(this.dV) && this.dV.getVisibility() == 0;
            this.ed = z2;
            if (this.ed) {
                if (this.dU == null || this.dU == this) {
                    i5 = 0;
                } else {
                    i5 = ((LayoutParams) this.dU.getLayoutParams()).bottomMargin;
                }
                x.a(this, this.dV, this.ea);
                this.eb.c(this.ea.left, (i4 - this.ea.height()) - i5, this.ea.right, i4 - i5);
                if (z.I(this) != 1) {
                    i6 = 0;
                }
                f fVar = this.eb;
                i5 = i6 != 0 ? this.dY : this.dW;
                int i8 = this.ea.bottom + this.dX;
                int i9 = i3 - i;
                if (i6 != 0) {
                    i6 = this.dW;
                } else {
                    i6 = this.dY;
                }
                fVar.b(i5, i8, i9 - i6, (i4 - i2) - this.dZ);
                this.eb.Z();
            }
        }
        i5 = getChildCount();
        while (i7 < i5) {
            View childAt = getChildAt(i7);
            if (!(this.bW == null || z.Z(childAt))) {
                int systemWindowInsetTop = this.bW.getSystemWindowInsetTop();
                if (childAt.getTop() < systemWindowInsetTop) {
                    z.j(childAt, systemWindowInsetTop);
                }
            }
            j(childAt).aS();
            i7++;
        }
        if (this.dT != null) {
            if (this.ec && TextUtils.isEmpty(this.eb.mText)) {
                this.eb.setText(this.dT.getTitle());
            }
            if (this.dU == null || this.dU == this) {
                setMinimumHeight(i(this.dT));
            } else {
                setMinimumHeight(i(this.dU));
            }
        }
    }

    private static int i(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof MarginLayoutParams)) {
            return view.getHeight();
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
        return marginLayoutParams.bottomMargin + (view.getHeight() + marginLayoutParams.topMargin);
    }

    private static z j(View view) {
        z zVar = (z) view.getTag(e.view_offset_helper);
        if (zVar != null) {
            return zVar;
        }
        zVar = new z(view);
        view.setTag(e.view_offset_helper, zVar);
        return zVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.eb.setText(charSequence);
    }

    public CharSequence getTitle() {
        return this.ec ? this.eb.mText : null;
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.ec) {
            this.ec = z;
            af();
            requestLayout();
        }
    }

    public void setScrimsShown(boolean z) {
        int i;
        int i2 = WebView.NORMAL_MODE_ALPHA;
        int i3 = 0;
        if (!z.ai(this) || isInEditMode()) {
            i = 0;
        } else {
            i = 1;
        }
        if (this.eh != z) {
            if (i != 0) {
                if (z) {
                    i3 = WebView.NORMAL_MODE_ALPHA;
                }
                ad();
                if (this.ei == null) {
                    this.ei = aa.aP();
                    this.ei.setDuration(600);
                    this.ei.setInterpolator(i3 > this.eg ? a.bN : a.bO);
                    this.ei.a(new 2(this));
                } else if (this.ei.iO.isRunning()) {
                    this.ei.iO.cancel();
                }
                this.ei.i(this.eg, i3);
                this.ei.iO.start();
            } else {
                if (!z) {
                    i2 = 0;
                }
                setScrimAlpha(i2);
            }
            this.eh = z;
        }
    }

    private void setScrimAlpha(int i) {
        if (i != this.eg) {
            if (!(this.ee == null || this.dT == null)) {
                z.E(this.dT);
            }
            this.eg = i;
            z.E(this);
        }
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.ee != drawable) {
            if (this.ee != null) {
                this.ee.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.ee = drawable2;
            if (this.ee != null) {
                this.ee.setBounds(0, 0, getWidth(), getHeight());
                this.ee.setCallback(this);
                this.ee.setAlpha(this.eg);
            }
            z.E(this);
        }
    }

    public void setContentScrimColor(int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(int i) {
        setContentScrim(android.support.v4.content.a.f(getContext(), i));
    }

    public Drawable getContentScrim() {
        return this.ee;
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.ef != drawable) {
            if (this.ef != null) {
                this.ef.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.ef = drawable2;
            if (this.ef != null) {
                if (this.ef.isStateful()) {
                    this.ef.setState(getDrawableState());
                }
                android.support.v4.b.a.a.b(this.ef, z.I(this));
                this.ef.setVisible(getVisibility() == 0, false);
                this.ef.setCallback(this);
                this.ef.setAlpha(this.eg);
            }
            z.E(this);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.ef;
        if (drawable != null && drawable.isStateful()) {
            i = drawable.setState(drawableState) | 0;
        }
        drawable = this.ee;
        if (drawable != null && drawable.isStateful()) {
            i |= drawable.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.ee || drawable == this.ef;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (!(this.ef == null || this.ef.isVisible() == z)) {
            this.ef.setVisible(z, false);
        }
        if (this.ee != null && this.ee.isVisible() != z) {
            this.ee.setVisible(z, false);
        }
    }

    public void setStatusBarScrimColor(int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(int i) {
        setStatusBarScrim(android.support.v4.content.a.f(getContext(), i));
    }

    public Drawable getStatusBarScrim() {
        return this.ef;
    }

    public void setCollapsedTitleTextAppearance(int i) {
        this.eb.z(i);
    }

    public void setCollapsedTitleTextColor(int i) {
        this.eb.v(i);
    }

    public void setCollapsedTitleGravity(int i) {
        this.eb.y(i);
    }

    public int getCollapsedTitleGravity() {
        return this.eb.di;
    }

    public void setExpandedTitleTextAppearance(int i) {
        this.eb.A(i);
    }

    public void setExpandedTitleColor(int i) {
        this.eb.w(i);
    }

    public void setExpandedTitleGravity(int i) {
        this.eb.x(i);
    }

    public int getExpandedTitleGravity() {
        return this.eb.dh;
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        f fVar = this.eb;
        if (fVar.dt != typeface) {
            fVar.dt = typeface;
            fVar.Z();
        }
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.eb.X();
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        f fVar = this.eb;
        if (fVar.du != typeface) {
            fVar.du = typeface;
            fVar.Z();
        }
    }

    public Typeface getExpandedTitleTypeface() {
        f fVar = this.eb;
        return fVar.du != null ? fVar.du : Typeface.DEFAULT;
    }

    public int getExpandedTitleMarginStart() {
        return this.dW;
    }

    public void setExpandedTitleMarginStart(int i) {
        this.dW = i;
        requestLayout();
    }

    public int getExpandedTitleMarginTop() {
        return this.dX;
    }

    public void setExpandedTitleMarginTop(int i) {
        this.dX = i;
        requestLayout();
    }

    public int getExpandedTitleMarginEnd() {
        return this.dY;
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.dY = i;
        requestLayout();
    }

    public int getExpandedTitleMarginBottom() {
        return this.dZ;
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.dZ = i;
        requestLayout();
    }

    final int getScrimTriggerOffset() {
        return z.T(this) * 2;
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    private LayoutParams ag() {
        return new LayoutParams(super.generateDefaultLayoutParams());
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
