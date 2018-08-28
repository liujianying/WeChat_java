package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.am;
import android.support.v4.view.an;
import android.support.v4.view.ao;
import android.support.v4.view.z;
import android.support.v7.a.a.k;
import android.support.v7.view.b;
import android.support.v7.view.g;
import android.support.v7.view.h;
import android.support.v7.view.menu.f;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ai;
import android.support.v7.widget.u;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class o extends ActionBar implements android.support.v7.widget.ActionBarOverlayLayout.a {
    static final /* synthetic */ boolean $assertionsDisabled = (!o.class.desiredAssertionStatus());
    private static final Interpolator FN = new AccelerateInterpolator();
    private static final Interpolator FO = new DecelerateInterpolator();
    private static final boolean FP;
    private Context FQ;
    private ActionBarOverlayLayout FR;
    private ActionBarContainer FS;
    private ActionBarContextView FT;
    private View FU;
    private ai FV;
    private int FW = -1;
    private boolean FX;
    a FY;
    b FZ;
    private u Fs;
    private boolean Fw;
    private ArrayList<Object> Fx = new ArrayList();
    android.support.v7.view.b.a Ga;
    private boolean Gb;
    private int Gc = 0;
    private boolean Gd = true;
    private boolean Ge;
    private boolean Gf;
    private boolean Gg;
    private boolean Gh = true;
    private h Gi;
    private boolean Gj;
    boolean Gk;
    final am Gl = new an() {
        public final void q(View view) {
            if (o.this.Gd && o.this.FU != null) {
                z.c(o.this.FU, 0.0f);
                z.c(o.this.FS, 0.0f);
            }
            o.this.FS.setVisibility(8);
            o.this.FS.setTransitioning(false);
            o.this.Gi = null;
            o oVar = o.this;
            if (oVar.Ga != null) {
                oVar.Ga.a(oVar.FZ);
                oVar.FZ = null;
                oVar.Ga = null;
            }
            if (o.this.FR != null) {
                z.Y(o.this.FR);
            }
        }
    };
    final am Gm = new an() {
        public final void q(View view) {
            o.this.Gi = null;
            o.this.FS.requestLayout();
        }
    };
    final ao Gn = new ao() {
        public final void cn() {
            ((View) o.this.FS.getParent()).invalidate();
        }
    };
    private ArrayList<Object> hk = new ArrayList();
    private Activity mActivity;
    private Context mContext;
    private Dialog nt;

    public class a extends b implements android.support.v7.view.menu.f.a {
        private final Context Gp;
        private android.support.v7.view.b.a Gq;
        private WeakReference<View> Gr;
        private final f bq;

        public a(Context context, android.support.v7.view.b.a aVar) {
            this.Gp = context;
            this.Gq = aVar;
            f fVar = new f(context);
            this.bq = fVar;
            this.bq.a((android.support.v7.view.menu.f.a) this);
        }

        public final MenuInflater getMenuInflater() {
            return new g(this.Gp);
        }

        public final Menu getMenu() {
            return this.bq;
        }

        public final void finish() {
            if (o.this.FY == this) {
                if (o.d(o.this.Ge, o.this.Gf, false)) {
                    this.Gq.a(this);
                } else {
                    o.this.FZ = this;
                    o.this.Ga = this.Gq;
                }
                this.Gq = null;
                o.this.I(false);
                o.this.FT.eb();
                o.this.Fs.eQ().sendAccessibilityEvent(32);
                o.this.FR.setHideOnContentScrollEnabled(o.this.Gk);
                o.this.FY = null;
            }
        }

        public final void invalidate() {
            if (o.this.FY == this) {
                this.bq.dJ();
                try {
                    this.Gq.b(this, this.bq);
                } finally {
                    this.bq.dK();
                }
            }
        }

        public final boolean dq() {
            this.bq.dJ();
            try {
                boolean a = this.Gq.a((b) this, this.bq);
                return a;
            } finally {
                this.bq.dK();
            }
        }

        public final void setCustomView(View view) {
            o.this.FT.setCustomView(view);
            this.Gr = new WeakReference(view);
        }

        public final void setSubtitle(CharSequence charSequence) {
            o.this.FT.setSubtitle(charSequence);
        }

        public final void setTitle(CharSequence charSequence) {
            o.this.FT.setTitle(charSequence);
        }

        public final void setTitle(int i) {
            setTitle(o.this.mContext.getResources().getString(i));
        }

        public final void setSubtitle(int i) {
            setSubtitle(o.this.mContext.getResources().getString(i));
        }

        public final CharSequence getTitle() {
            return o.this.FT.getTitle();
        }

        public final CharSequence getSubtitle() {
            return o.this.FT.getSubtitle();
        }

        public final void setTitleOptionalHint(boolean z) {
            super.setTitleOptionalHint(z);
            o.this.FT.setTitleOptional(z);
        }

        public final boolean isTitleOptional() {
            return o.this.FT.JL;
        }

        public final View getCustomView() {
            return this.Gr != null ? (View) this.Gr.get() : null;
        }

        public final boolean a(f fVar, MenuItem menuItem) {
            if (this.Gq != null) {
                return this.Gq.a((b) this, menuItem);
            }
            return false;
        }

        public final void b(f fVar) {
            if (this.Gq != null) {
                invalidate();
                o.this.FT.showOverflowMenu();
            }
        }
    }

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 14) {
            z = false;
        }
        FP = z;
    }

    public o(Activity activity, boolean z) {
        this.mActivity = activity;
        View decorView = activity.getWindow().getDecorView();
        aI(decorView);
        if (!z) {
            this.FU = decorView.findViewById(16908290);
        }
    }

    public o(Dialog dialog) {
        this.nt = dialog;
        aI(dialog.getWindow().getDecorView());
    }

    private void aI(View view) {
        u uVar;
        this.FR = (ActionBarOverlayLayout) view.findViewById(android.support.v7.a.a.f.decor_content_parent);
        if (this.FR != null) {
            this.FR.setActionBarVisibilityCallback(this);
        }
        View findViewById = view.findViewById(android.support.v7.a.a.f.action_bar);
        if (findViewById instanceof u) {
            uVar = (u) findViewById;
        } else if (findViewById instanceof Toolbar) {
            uVar = ((Toolbar) findViewById).getWrapper();
        } else {
            throw new IllegalStateException(new StringBuilder("Can't make a decor toolbar out of ").append(findViewById).toString() != null ? findViewById.getClass().getSimpleName() : "null");
        }
        this.Fs = uVar;
        this.FT = (ActionBarContextView) view.findViewById(android.support.v7.a.a.f.action_context_bar);
        this.FS = (ActionBarContainer) view.findViewById(android.support.v7.a.a.f.action_bar_container);
        if (this.Fs == null || this.FT == null || this.FS == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.mContext = this.Fs.getContext();
        if ((this.Fs.getDisplayOptions() & 4) != 0) {
            this.FX = true;
        }
        android.support.v7.view.a R = android.support.v7.view.a.R(this.mContext);
        R.ds();
        F(R.dr());
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, k.ActionBar, android.support.v7.a.a.a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(k.ActionBar_hideOnContentScroll, false)) {
            if (this.FR.JV) {
                this.Gk = true;
                this.FR.setHideOnContentScrollEnabled(true);
            } else {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(k.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            setElevation((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    public final void setElevation(float f) {
        z.g(this.FS, f);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        F(android.support.v7.view.a.R(this.mContext).dr());
    }

    private void F(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        this.Gb = z;
        if (this.Gb) {
            this.FS.setTabContainer(null);
            this.Fs.a(this.FV);
        } else {
            this.Fs.a(null);
            this.FS.setTabContainer(this.FV);
        }
        if (this.Fs.getNavigationMode() == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.FV != null) {
            if (z2) {
                this.FV.setVisibility(0);
                if (this.FR != null) {
                    z.Y(this.FR);
                }
            } else {
                this.FV.setVisibility(8);
            }
        }
        u uVar = this.Fs;
        if (this.Gb || !z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        uVar.setCollapsible(z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.FR;
        if (this.Gb || !z2) {
            z4 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z4);
    }

    public final void onWindowVisibilityChanged(int i) {
        this.Gc = i;
    }

    public final void D(boolean z) {
        this.Gj = z;
        if (!z && this.Gi != null) {
            this.Gi.cancel();
        }
    }

    public final void E(boolean z) {
        if (z != this.Fw) {
            this.Fw = z;
            int size = this.Fx.size();
            for (int i = 0; i < size; i++) {
                this.Fx.get(i);
            }
        }
    }

    public final void setCustomView(int i) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i, this.Fs.eQ(), false));
    }

    public final void cZ() {
        setDisplayOptions(0, 2);
    }

    public final void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    public final void da() {
        setDisplayOptions(0, 8);
    }

    public final void db() {
        setDisplayOptions(16, 16);
    }

    public final void setWindowTitle(CharSequence charSequence) {
        this.Fs.setWindowTitle(charSequence);
    }

    public final boolean requestFocus() {
        ViewGroup eQ = this.Fs.eQ();
        if (eQ == null || eQ.hasFocus()) {
            return false;
        }
        eQ.requestFocus();
        return true;
    }

    public final void setDisplayOptions(int i) {
        if ((i & 4) != 0) {
            this.FX = true;
        }
        this.Fs.setDisplayOptions(i);
    }

    private void setDisplayOptions(int i, int i2) {
        int displayOptions = this.Fs.getDisplayOptions();
        if ((i2 & 4) != 0) {
            this.FX = true;
        }
        this.Fs.setDisplayOptions((displayOptions & (i2 ^ -1)) | (i & i2));
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.FS.setPrimaryBackground(drawable);
    }

    public final View getCustomView() {
        return this.Fs.getCustomView();
    }

    public final CharSequence getTitle() {
        return this.Fs.getTitle();
    }

    public final int getDisplayOptions() {
        return this.Fs.getDisplayOptions();
    }

    public final b a(android.support.v7.view.b.a aVar) {
        if (this.FY != null) {
            this.FY.finish();
        }
        this.FR.setHideOnContentScrollEnabled(false);
        this.FT.ec();
        b aVar2 = new a(this.FT.getContext(), aVar);
        if (!aVar2.dq()) {
            return null;
        }
        aVar2.invalidate();
        this.FT.c(aVar2);
        I(true);
        this.FT.sendAccessibilityEvent(32);
        this.FY = aVar2;
        return aVar2;
    }

    public final int getHeight() {
        return this.FS.getHeight();
    }

    public final void G(boolean z) {
        this.Gd = z;
    }

    public final void show() {
        if (this.Ge) {
            this.Ge = false;
            H(false);
        }
    }

    public final void dn() {
        if (this.Gf) {
            this.Gf = false;
            H(true);
        }
    }

    public final void hide() {
        if (!this.Ge) {
            this.Ge = true;
            H(false);
        }
    }

    public final void do() {
        if (!this.Gf) {
            this.Gf = true;
            H(true);
        }
    }

    private static boolean d(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        if (z || z2) {
            return false;
        }
        return true;
    }

    private void H(boolean z) {
        float f;
        h hVar;
        android.support.v4.view.ai v;
        if (d(this.Ge, this.Gf, this.Gg)) {
            if (!this.Gh) {
                this.Gh = true;
                if (this.Gi != null) {
                    this.Gi.cancel();
                }
                this.FS.setVisibility(0);
                if (this.Gc == 0 && FP && (this.Gj || z)) {
                    z.c(this.FS, 0.0f);
                    f = (float) (-this.FS.getHeight());
                    if (z) {
                        int[] iArr = new int[]{0, 0};
                        this.FS.getLocationInWindow(iArr);
                        f -= (float) iArr[1];
                    }
                    z.c(this.FS, f);
                    hVar = new h();
                    v = z.U(this.FS).v(0.0f);
                    v.a(this.Gn);
                    hVar.g(v);
                    if (this.Gd && this.FU != null) {
                        z.c(this.FU, f);
                        hVar.g(z.U(this.FU).v(0.0f));
                    }
                    hVar.d(FO);
                    hVar.dx();
                    hVar.b(this.Gm);
                    this.Gi = hVar;
                    hVar.start();
                } else {
                    z.d(this.FS, 1.0f);
                    z.c(this.FS, 0.0f);
                    if (this.Gd && this.FU != null) {
                        z.c(this.FU, 0.0f);
                    }
                    this.Gm.q(null);
                }
                if (this.FR != null) {
                    z.Y(this.FR);
                }
            }
        } else if (this.Gh) {
            this.Gh = false;
            if (this.Gi != null) {
                this.Gi.cancel();
            }
            if (this.Gc == 0 && FP && (this.Gj || z)) {
                z.d(this.FS, 1.0f);
                this.FS.setTransitioning(true);
                hVar = new h();
                f = (float) (-this.FS.getHeight());
                if (z) {
                    int[] iArr2 = new int[]{0, 0};
                    this.FS.getLocationInWindow(iArr2);
                    f -= (float) iArr2[1];
                }
                v = z.U(this.FS).v(f);
                v.a(this.Gn);
                hVar.g(v);
                if (this.Gd && this.FU != null) {
                    hVar.g(z.U(this.FU).v(f));
                }
                hVar.d(FN);
                hVar.dx();
                hVar.b(this.Gl);
                this.Gi = hVar;
                hVar.start();
                return;
            }
            this.Gl.q(null);
        }
    }

    public final boolean isShowing() {
        int height = this.FS.getHeight();
        return this.Gh && (height == 0 || this.FR.getActionBarHideOffset() < height);
    }

    public final void I(boolean z) {
        android.support.v4.view.ai c;
        android.support.v4.view.ai c2;
        if (z) {
            if (!this.Gg) {
                this.Gg = true;
                if (this.FR != null) {
                    this.FR.setShowingForActionMode(true);
                }
                H(false);
            }
        } else if (this.Gg) {
            this.Gg = false;
            if (this.FR != null) {
                this.FR.setShowingForActionMode(false);
            }
            H(false);
        }
        if (z) {
            c = this.Fs.c(4, 100);
            c2 = this.FT.c(0, 200);
        } else {
            c2 = this.Fs.c(0, 200);
            c = this.FT.c(8, 100);
        }
        h hVar = new h();
        hVar.a(c, c2);
        hVar.start();
    }

    public final Context getThemedContext() {
        if (this.FQ == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.FQ = new ContextThemeWrapper(this.mContext, i);
            } else {
                this.FQ = this.mContext;
            }
        }
        return this.FQ;
    }

    public final void setHomeActionContentDescription(int i) {
        this.Fs.setNavigationContentDescription(i);
    }

    public final void dp() {
        if (this.Gi != null) {
            this.Gi.cancel();
            this.Gi = null;
        }
    }

    public final boolean collapseActionView() {
        if (this.Fs == null || !this.Fs.hasExpandedActionView()) {
            return false;
        }
        this.Fs.collapseActionView();
        return true;
    }

    public final void setCustomView(View view) {
        this.Fs.setCustomView(view);
    }

    public final void setIcon(int i) {
        this.Fs.setIcon(i);
    }

    public final void setLogo(Drawable drawable) {
        this.Fs.setLogo(drawable);
    }

    public final void C(boolean z) {
        if (!this.FX) {
            setDisplayHomeAsUpEnabled(z);
        }
    }
}
