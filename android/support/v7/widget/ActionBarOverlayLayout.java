package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ai;
import android.support.v4.view.am;
import android.support.v4.view.an;
import android.support.v4.view.r;
import android.support.v4.view.s;
import android.support.v4.view.z;
import android.support.v4.widget.q;
import android.support.v7.a.a.f;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window.Callback;

public class ActionBarOverlayLayout extends ViewGroup implements r, t {
    static final int[] vA = new int[]{android.support.v7.a.a.a.actionBarSize, 16842841};
    private final s AR;
    private u Fs;
    private boolean Gk;
    private int JP;
    private int JQ = 0;
    private ContentFrameLayout JR;
    private ActionBarContainer JS;
    private Drawable JT;
    private boolean JU;
    public boolean JV;
    private boolean JW;
    private boolean JX;
    private int JY;
    private int JZ;
    private final Rect Ka = new Rect();
    private final Rect Kb = new Rect();
    private final Rect Kc = new Rect();
    private final Rect Kd = new Rect();
    private final Rect Ke = new Rect();
    private final Rect Kf = new Rect();
    private a Kg;
    private final int Kh = 600;
    private q Ki;
    private ai Kj;
    private final am Kk = new an() {
        public final void q(View view) {
            ActionBarOverlayLayout.this.Kj = null;
            ActionBarOverlayLayout.this.JX = false;
        }

        public final void ar(View view) {
            ActionBarOverlayLayout.this.Kj = null;
            ActionBarOverlayLayout.this.JX = false;
        }
    };
    private final Runnable Kl = new Runnable() {
        public final void run() {
            ActionBarOverlayLayout.this.ee();
            ActionBarOverlayLayout.this.Kj = z.U(ActionBarOverlayLayout.this.JS).v(0.0f).a(ActionBarOverlayLayout.this.Kk);
        }
    };
    private final Runnable Km = new Runnable() {
        public final void run() {
            ActionBarOverlayLayout.this.ee();
            ActionBarOverlayLayout.this.Kj = z.U(ActionBarOverlayLayout.this.JS).v((float) (-ActionBarOverlayLayout.this.JS.getHeight())).a(ActionBarOverlayLayout.this.Kk);
        }
    };

    public static class LayoutParams extends MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public interface a {
        void G(boolean z);

        void dn();

        void do();

        void dp();

        void onWindowVisibilityChanged(int i);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
        this.AR = new s(this);
    }

    private void init(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(vA);
        this.JP = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.JT = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.JT == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.JU = z;
        this.Ki = q.a(context, null);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ee();
    }

    public void setActionBarVisibilityCallback(a aVar) {
        this.Kg = aVar;
        if (getWindowToken() != null) {
            this.Kg.onWindowVisibilityChanged(this.JQ);
            if (this.JZ != 0) {
                onWindowSystemUiVisibilityChanged(this.JZ);
                z.Y(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.JV = z;
        boolean z2 = z && getContext().getApplicationInfo().targetSdkVersion < 19;
        this.JU = z2;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.JW = z;
    }

    public void setShowingForActionMode(boolean z) {
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        init(getContext());
        z.Y(this);
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z;
        boolean z2 = true;
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        ed();
        int i2 = this.JZ ^ i;
        this.JZ = i;
        boolean z3 = (i & 4) == 0;
        if ((i & 256) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.Kg != null) {
            a aVar = this.Kg;
            if (z) {
                z2 = false;
            }
            aVar.G(z2);
            if (z3 || !z) {
                this.Kg.dn();
            } else {
                this.Kg.do();
            }
        }
        if ((i2 & 256) != 0 && this.Kg != null) {
            z.Y(this);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.JQ = i;
        if (this.Kg != null) {
            this.Kg.onWindowVisibilityChanged(i);
        }
    }

    private static boolean a(View view, Rect rect, boolean z) {
        boolean z2 = false;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.leftMargin != rect.left) {
            layoutParams.leftMargin = rect.left;
            z2 = true;
        }
        if (layoutParams.topMargin != rect.top) {
            layoutParams.topMargin = rect.top;
            z2 = true;
        }
        if (layoutParams.rightMargin != rect.right) {
            layoutParams.rightMargin = rect.right;
            z2 = true;
        }
        if (!z || layoutParams.bottomMargin == rect.bottom) {
            return z2;
        }
        layoutParams.bottomMargin = rect.bottom;
        return true;
    }

    protected boolean fitSystemWindows(Rect rect) {
        ed();
        z.X(this);
        boolean a = a(this.JS, rect, false);
        this.Kd.set(rect);
        at.a(this, this.Kd, this.Ka);
        if (!this.Kb.equals(this.Ka)) {
            this.Kb.set(this.Ka);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        ed();
        measureChildWithMargins(this.JS, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.JS.getLayoutParams();
        int max = Math.max(0, (this.JS.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin);
        int max2 = Math.max(0, layoutParams.bottomMargin + (this.JS.getMeasuredHeight() + layoutParams.topMargin));
        int combineMeasuredStates = at.combineMeasuredStates(0, z.M(this.JS));
        boolean z = (z.X(this) & 256) != 0;
        if (z) {
            i3 = this.JP;
            if (this.JW && this.JS.getTabContainer() != null) {
                i3 += this.JP;
            }
        } else {
            i3 = this.JS.getVisibility() != 8 ? this.JS.getMeasuredHeight() : 0;
        }
        this.Kc.set(this.Ka);
        this.Ke.set(this.Kd);
        Rect rect;
        Rect rect2;
        if (this.JV || z) {
            rect = this.Ke;
            rect.top = i3 + rect.top;
            rect2 = this.Ke;
            rect2.bottom += 0;
        } else {
            rect = this.Kc;
            rect.top = i3 + rect.top;
            rect2 = this.Kc;
            rect2.bottom += 0;
        }
        a(this.JR, this.Kc, true);
        if (!this.Kf.equals(this.Ke)) {
            this.Kf.set(this.Ke);
            this.JR.g(this.Ke);
        }
        measureChildWithMargins(this.JR, i, 0, i2, 0);
        layoutParams = (LayoutParams) this.JR.getLayoutParams();
        int max3 = Math.max(max, (this.JR.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin);
        i3 = Math.max(max2, layoutParams.bottomMargin + (this.JR.getMeasuredHeight() + layoutParams.topMargin));
        int combineMeasuredStates2 = at.combineMeasuredStates(combineMeasuredStates, z.M(this.JR));
        setMeasuredDimension(z.resolveSizeAndState(Math.max(max3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, combineMeasuredStates2), z.resolveSizeAndState(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i6 = layoutParams.leftMargin + paddingLeft;
                int i7 = layoutParams.topMargin + paddingTop;
                childAt.layout(i6, i7, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + i7);
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.JT != null && !this.JU) {
            int bottom = this.JS.getVisibility() == 0 ? (int) ((((float) this.JS.getBottom()) + z.R(this.JS)) + 0.5f) : 0;
            this.JT.setBounds(0, bottom, getWidth(), this.JT.getIntrinsicHeight() + bottom);
            this.JT.draw(canvas);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.JS.getVisibility() != 0) {
            return false;
        }
        return this.Gk;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.AR.uX = i;
        this.JY = getActionBarHideOffset();
        ee();
        if (this.Kg != null) {
            this.Kg.dp();
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.JY += i2;
        setActionBarHideOffset(this.JY);
    }

    public void onStopNestedScroll(View view) {
        if (this.Gk && !this.JX) {
            if (this.JY <= this.JS.getHeight()) {
                ee();
                postDelayed(this.Kl, 600);
                return;
            }
            ee();
            postDelayed(this.Km, 600);
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        boolean z2 = false;
        if (!this.Gk || !z) {
            return false;
        }
        this.Ki.b(0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.Ki.getFinalY() > this.JS.getHeight()) {
            z2 = true;
        }
        if (z2) {
            ee();
            this.Km.run();
        } else {
            ee();
            this.Kl.run();
        }
        this.JX = true;
        return true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public int getNestedScrollAxes() {
        return this.AR.uX;
    }

    private void ed() {
        if (this.JR == null) {
            u uVar;
            this.JR = (ContentFrameLayout) findViewById(f.action_bar_activity_content);
            this.JS = (ActionBarContainer) findViewById(f.action_bar_container);
            View findViewById = findViewById(f.action_bar);
            if (findViewById instanceof u) {
                uVar = (u) findViewById;
            } else if (findViewById instanceof Toolbar) {
                uVar = ((Toolbar) findViewById).getWrapper();
            } else {
                throw new IllegalStateException("Can't make a decor toolbar out of " + findViewById.getClass().getSimpleName());
            }
            this.Fs = uVar;
        }
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.Gk) {
            this.Gk = z;
            if (!z) {
                ee();
                setActionBarHideOffset(0);
            }
        }
    }

    public int getActionBarHideOffset() {
        return this.JS != null ? -((int) z.R(this.JS)) : 0;
    }

    public void setActionBarHideOffset(int i) {
        ee();
        z.c(this.JS, (float) (-Math.max(0, Math.min(i, this.JS.getHeight()))));
    }

    private void ee() {
        removeCallbacks(this.Kl);
        removeCallbacks(this.Km);
        if (this.Kj != null) {
            this.Kj.cancel();
        }
    }

    public void setWindowCallback(Callback callback) {
        ed();
        this.Fs.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        ed();
        this.Fs.setWindowTitle(charSequence);
    }

    public CharSequence getTitle() {
        ed();
        return this.Fs.getTitle();
    }

    public final void aJ(int i) {
        ed();
        switch (i) {
            case 109:
                setOverlayMode(true);
                return;
            default:
                return;
        }
    }

    public void setUiOptions(int i) {
    }

    public void setIcon(int i) {
        ed();
        this.Fs.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        ed();
        this.Fs.setIcon(drawable);
    }

    public void setLogo(int i) {
        ed();
        this.Fs.setLogo(i);
    }

    public final boolean ef() {
        ed();
        return this.Fs.ef();
    }

    public final boolean isOverflowMenuShowing() {
        ed();
        return this.Fs.isOverflowMenuShowing();
    }

    public final boolean eg() {
        ed();
        return this.Fs.eg();
    }

    public final boolean showOverflowMenu() {
        ed();
        return this.Fs.showOverflowMenu();
    }

    public final boolean hideOverflowMenu() {
        ed();
        return this.Fs.hideOverflowMenu();
    }

    public final void eh() {
        ed();
        this.Fs.eh();
    }

    public final void a(Menu menu, android.support.v7.view.menu.l.a aVar) {
        ed();
        this.Fs.a(menu, aVar);
    }

    public final void ei() {
        ed();
        this.Fs.dismissPopupMenus();
    }
}
