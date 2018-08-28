package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.v;
import android.support.v4.view.ae;
import android.support.v4.view.ai;
import android.support.v4.view.an;
import android.support.v4.view.ap;
import android.support.v4.view.k;
import android.support.v4.view.z;
import android.support.v4.widget.m;
import android.support.v7.view.menu.e;
import android.support.v7.view.menu.f;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.at;
import android.support.v7.widget.h;
import android.support.v7.widget.t;
import android.support.v7.widget.x;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.wcdb.FileUtils;

class AppCompatDelegateImplV7 extends f implements k, android.support.v7.view.menu.f.a {
    private TextView Dm;
    ActionBarContextView EA;
    PopupWindow EB;
    Runnable EC;
    ai ED = null;
    private boolean EE;
    private ViewGroup EF;
    private View EG;
    private boolean EH;
    private boolean EI;
    private boolean EJ;
    private PanelFeatureState[] EK;
    private PanelFeatureState EL;
    private boolean EM;
    private boolean EN;
    private int EO;
    private final Runnable EP = new Runnable() {
        public final void run() {
            if ((AppCompatDelegateImplV7.this.EO & 1) != 0) {
                AppCompatDelegateImplV7.a(AppCompatDelegateImplV7.this, 0);
            }
            if ((AppCompatDelegateImplV7.this.EO & 4096) != 0) {
                AppCompatDelegateImplV7.a(AppCompatDelegateImplV7.this, 108);
            }
            AppCompatDelegateImplV7.this.EN = false;
            AppCompatDelegateImplV7.this.EO = 0;
        }
    };
    private boolean EQ;
    private k ER;
    private t Ew;
    private a Ex;
    private d Ey;
    android.support.v7.view.b Ez;
    private Rect ex;
    private Rect ey;

    private static final class PanelFeatureState {
        boolean BA;
        int EW;
        ViewGroup EX;
        View EY;
        View EZ;
        f Fa;
        e Fb;
        Context Fc;
        boolean Fd;
        boolean Fe;
        public boolean Ff;
        boolean Fg = false;
        boolean Fh;
        Bundle Fi;
        int background;
        int gravity;
        int windowAnimations;
        int x;
        int y;

        private static class SavedState implements Parcelable {
            public static final Creator<SavedState> CREATOR = android.support.v4.os.b.a(new android.support.v4.os.c<SavedState>() {
                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new SavedState[i];
                }
            });
            boolean BA;
            int EW;
            Bundle gj;

            private SavedState() {
            }

            static /* synthetic */ SavedState a(Parcel parcel, ClassLoader classLoader) {
                boolean z = true;
                SavedState savedState = new SavedState();
                savedState.EW = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.BA = z;
                if (savedState.BA) {
                    savedState.gj = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.EW);
                parcel.writeInt(this.BA ? 1 : 0);
                if (this.BA) {
                    parcel.writeBundle(this.gj);
                }
            }
        }

        PanelFeatureState(int i) {
            this.EW = i;
        }

        final void e(f fVar) {
            if (fVar != this.Fa) {
                if (this.Fa != null) {
                    this.Fa.b(this.Fb);
                }
                this.Fa = fVar;
                if (fVar != null && this.Fb != null) {
                    fVar.a(this.Fb);
                }
            }
        }
    }

    private final class a implements android.support.v7.view.menu.l.a {
        private a() {
        }

        /* synthetic */ a(AppCompatDelegateImplV7 appCompatDelegateImplV7, byte b) {
            this();
        }

        public final boolean d(f fVar) {
            Callback callback = AppCompatDelegateImplV7.this.CS.getCallback();
            if (callback != null) {
                callback.onMenuOpened(108, fVar);
            }
            return true;
        }

        public final void a(f fVar, boolean z) {
            AppCompatDelegateImplV7.this.c(fVar);
        }
    }

    class b implements android.support.v7.view.b.a {
        private android.support.v7.view.b.a EU;

        public b(android.support.v7.view.b.a aVar) {
            this.EU = aVar;
        }

        public final boolean a(android.support.v7.view.b bVar, Menu menu) {
            return this.EU.a(bVar, menu);
        }

        public final boolean b(android.support.v7.view.b bVar, Menu menu) {
            return this.EU.b(bVar, menu);
        }

        public final boolean a(android.support.v7.view.b bVar, MenuItem menuItem) {
            return this.EU.a(bVar, menuItem);
        }

        public final void a(android.support.v7.view.b bVar) {
            this.EU.a(bVar);
            if (AppCompatDelegateImplV7.this.EB != null) {
                AppCompatDelegateImplV7.this.CS.getDecorView().removeCallbacks(AppCompatDelegateImplV7.this.EC);
            }
            if (AppCompatDelegateImplV7.this.EA != null) {
                AppCompatDelegateImplV7.this.dk();
                AppCompatDelegateImplV7.this.ED = z.U(AppCompatDelegateImplV7.this.EA).t(0.0f);
                AppCompatDelegateImplV7.this.ED.a(new an() {
                    public final void q(View view) {
                        AppCompatDelegateImplV7.this.EA.setVisibility(8);
                        if (AppCompatDelegateImplV7.this.EB != null) {
                            AppCompatDelegateImplV7.this.EB.dismiss();
                        } else if (AppCompatDelegateImplV7.this.EA.getParent() instanceof View) {
                            z.Y((View) AppCompatDelegateImplV7.this.EA.getParent());
                        }
                        AppCompatDelegateImplV7.this.EA.removeAllViews();
                        AppCompatDelegateImplV7.this.ED.a(null);
                        AppCompatDelegateImplV7.this.ED = null;
                    }
                });
            }
            if (AppCompatDelegateImplV7.this.Eh != null) {
                AppCompatDelegateImplV7.this.Eh.onSupportActionModeFinished(AppCompatDelegateImplV7.this.Ez);
            }
            AppCompatDelegateImplV7.this.Ez = null;
        }
    }

    private class c extends ContentFrameLayout {
        public c(Context context) {
            super(context);
        }

        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImplV7.this.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                boolean z = x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5;
                if (z) {
                    AppCompatDelegateImplV7.this.a(AppCompatDelegateImplV7.this.aH(0), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        public final void setBackgroundResource(int i) {
            setBackgroundDrawable(h.eJ().a(getContext(), i, false));
        }
    }

    private final class d implements android.support.v7.view.menu.l.a {
        private d() {
        }

        /* synthetic */ d(AppCompatDelegateImplV7 appCompatDelegateImplV7, byte b) {
            this();
        }

        public final void a(f fVar, boolean z) {
            Menu fVar2;
            Menu dQ = fVar2.dQ();
            boolean z2 = dQ != fVar2;
            AppCompatDelegateImplV7 appCompatDelegateImplV7 = AppCompatDelegateImplV7.this;
            if (z2) {
                fVar2 = dQ;
            }
            PanelFeatureState a = appCompatDelegateImplV7.a(fVar2);
            if (a == null) {
                return;
            }
            if (z2) {
                AppCompatDelegateImplV7.this.a(a.EW, a, dQ);
                AppCompatDelegateImplV7.this.a(a, true);
                return;
            }
            AppCompatDelegateImplV7.this.a(a, z);
        }

        public final boolean d(f fVar) {
            if (fVar == null && AppCompatDelegateImplV7.this.Ei) {
                Callback callback = AppCompatDelegateImplV7.this.CS.getCallback();
                if (!(callback == null || AppCompatDelegateImplV7.this.En)) {
                    callback.onMenuOpened(108, fVar);
                }
            }
            return true;
        }
    }

    static /* synthetic */ void d(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        if (appCompatDelegateImplV7.Ew != null) {
            appCompatDelegateImplV7.Ew.ei();
        }
        if (appCompatDelegateImplV7.EB != null) {
            appCompatDelegateImplV7.CS.getDecorView().removeCallbacks(appCompatDelegateImplV7.EC);
            if (appCompatDelegateImplV7.EB.isShowing()) {
                try {
                    appCompatDelegateImplV7.EB.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            appCompatDelegateImplV7.EB = null;
        }
        appCompatDelegateImplV7.dk();
        PanelFeatureState aH = appCompatDelegateImplV7.aH(0);
        if (aH != null && aH.Fa != null) {
            aH.Fa.close();
        }
    }

    AppCompatDelegateImplV7(Context context, Window window, d dVar) {
        super(context, window, dVar);
    }

    public void onCreate(Bundle bundle) {
        if ((this.Ef instanceof Activity) && v.c((Activity) this.Ef) != null) {
            ActionBar actionBar = this.mActionBar;
            if (actionBar == null) {
                this.EQ = true;
            } else {
                actionBar.C(true);
            }
        }
    }

    public final void dd() {
        dj();
    }

    public final void dh() {
        dj();
        if (this.Ei && this.mActionBar == null) {
            if (this.Ef instanceof Activity) {
                this.mActionBar = new o((Activity) this.Ef, this.Ej);
            } else if (this.Ef instanceof Dialog) {
                this.mActionBar = new o((Dialog) this.Ef);
            }
            if (this.mActionBar != null) {
                this.mActionBar.C(this.EQ);
            }
        }
    }

    public final void setSupportActionBar(Toolbar toolbar) {
        if (this.Ef instanceof Activity) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar instanceof o) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.gh = null;
            if (supportActionBar != null) {
                supportActionBar.onDestroy();
            }
            if (toolbar != null) {
                ActionBar lVar = new l(toolbar, ((Activity) this.mContext).getTitle(), this.Eg);
                this.mActionBar = lVar;
                this.CS.setCallback(lVar.Fu);
            } else {
                this.mActionBar = null;
                this.CS.setCallback(this.Eg);
            }
            invalidateOptionsMenu();
        }
    }

    public final View findViewById(int i) {
        dj();
        return this.CS.findViewById(i);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        if (this.Ei && this.EE) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.onConfigurationChanged(configuration);
            }
        }
        df();
    }

    public final void onStop() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.D(false);
        }
    }

    public final void onPostResume() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.D(true);
        }
    }

    public final void setContentView(View view) {
        dj();
        ViewGroup viewGroup = (ViewGroup) this.EF.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.Ef.onContentChanged();
    }

    public final void setContentView(int i) {
        dj();
        ViewGroup viewGroup = (ViewGroup) this.EF.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(i, viewGroup);
        this.Ef.onContentChanged();
    }

    public final void setContentView(View view, LayoutParams layoutParams) {
        dj();
        ViewGroup viewGroup = (ViewGroup) this.EF.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.Ef.onContentChanged();
    }

    public final void addContentView(View view, LayoutParams layoutParams) {
        dj();
        ((ViewGroup) this.EF.findViewById(16908290)).addView(view, layoutParams);
        this.Ef.onContentChanged();
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.mActionBar != null) {
            this.mActionBar.onDestroy();
        }
    }

    private void dj() {
        if (!this.EE) {
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(android.support.v7.a.a.k.AppCompatTheme);
            if (obtainStyledAttributes.hasValue(android.support.v7.a.a.k.AppCompatTheme_windowActionBar)) {
                View view;
                View view2;
                if (obtainStyledAttributes.getBoolean(android.support.v7.a.a.k.AppCompatTheme_windowNoTitle, false)) {
                    requestWindowFeature(1);
                } else if (obtainStyledAttributes.getBoolean(android.support.v7.a.a.k.AppCompatTheme_windowActionBar, false)) {
                    requestWindowFeature(108);
                }
                if (obtainStyledAttributes.getBoolean(android.support.v7.a.a.k.AppCompatTheme_windowActionBarOverlay, false)) {
                    requestWindowFeature(109);
                }
                if (obtainStyledAttributes.getBoolean(android.support.v7.a.a.k.AppCompatTheme_windowActionModeOverlay, false)) {
                    requestWindowFeature(10);
                }
                this.El = obtainStyledAttributes.getBoolean(android.support.v7.a.a.k.AppCompatTheme_android_windowIsFloating, false);
                obtainStyledAttributes.recycle();
                this.CS.getDecorView();
                LayoutInflater from = LayoutInflater.from(this.mContext);
                View view3;
                if (this.Em) {
                    view = this.Ek ? (ViewGroup) from.inflate(android.support.v7.a.a.h.abc_screen_simple_overlay_action_mode, null) : (ViewGroup) from.inflate(android.support.v7.a.a.h.abc_screen_simple, null);
                    if (VERSION.SDK_INT >= 21) {
                        z.b(view, new android.support.v4.view.t() {
                            public final ap a(View view, ap apVar) {
                                int systemWindowInsetTop = apVar.getSystemWindowInsetTop();
                                int b = AppCompatDelegateImplV7.b(AppCompatDelegateImplV7.this, systemWindowInsetTop);
                                if (systemWindowInsetTop != b) {
                                    apVar = apVar.f(apVar.getSystemWindowInsetLeft(), b, apVar.getSystemWindowInsetRight(), apVar.getSystemWindowInsetBottom());
                                }
                                return z.a(view, apVar);
                            }
                        });
                        view2 = view;
                    } else {
                        ((x) view).setOnFitSystemWindowsListener(new android.support.v7.widget.x.a() {
                            public final void f(Rect rect) {
                                rect.top = AppCompatDelegateImplV7.b(AppCompatDelegateImplV7.this, rect.top);
                            }
                        });
                        view2 = view;
                    }
                } else if (this.El) {
                    view3 = (ViewGroup) from.inflate(android.support.v7.a.a.h.abc_dialog_title_material, null);
                    this.Ej = false;
                    this.Ei = false;
                    view2 = view3;
                } else if (this.Ei) {
                    TypedValue typedValue = new TypedValue();
                    this.mContext.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarTheme, typedValue, true);
                    view3 = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new android.support.v7.view.d(this.mContext, typedValue.resourceId) : this.mContext).inflate(android.support.v7.a.a.h.abc_screen_toolbar, null);
                    this.Ew = (t) view3.findViewById(android.support.v7.a.a.f.decor_content_parent);
                    this.Ew.setWindowCallback(this.CS.getCallback());
                    if (this.Ej) {
                        this.Ew.aJ(109);
                    }
                    if (this.EH) {
                        this.Ew.aJ(2);
                    }
                    if (this.EI) {
                        this.Ew.aJ(5);
                    }
                    view2 = view3;
                } else {
                    view2 = null;
                }
                if (view2 == null) {
                    throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.Ei + ", windowActionBarOverlay: " + this.Ej + ", android:windowIsFloating: " + this.El + ", windowActionModeOverlay: " + this.Ek + ", windowNoTitle: " + this.Em + " }");
                }
                if (this.Ew == null) {
                    this.Dm = (TextView) view2.findViewById(android.support.v7.a.a.f.title);
                }
                at.bw(view2);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view2.findViewById(android.support.v7.a.a.f.action_bar_activity_content);
                ViewGroup viewGroup = (ViewGroup) this.CS.findViewById(16908290);
                if (viewGroup != null) {
                    while (viewGroup.getChildCount() > 0) {
                        View childAt = viewGroup.getChildAt(0);
                        viewGroup.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup instanceof FrameLayout) {
                        ((FrameLayout) viewGroup).setForeground(null);
                    }
                }
                this.CS.setContentView(view2);
                contentFrameLayout.setAttachListener(new android.support.v7.widget.ContentFrameLayout.a() {
                    public final void onDetachedFromWindow() {
                        AppCompatDelegateImplV7.d(AppCompatDelegateImplV7.this);
                    }
                });
                this.EF = view2;
                CharSequence title = this.Ef instanceof Activity ? ((Activity) this.Ef).getTitle() : this.sn;
                if (!TextUtils.isEmpty(title)) {
                    f(title);
                }
                contentFrameLayout = (ContentFrameLayout) this.EF.findViewById(16908290);
                view = this.CS.getDecorView();
                contentFrameLayout.NL.set(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
                if (z.ai(contentFrameLayout)) {
                    contentFrameLayout.requestLayout();
                }
                TypedArray obtainStyledAttributes2 = this.mContext.obtainStyledAttributes(android.support.v7.a.a.k.AppCompatTheme);
                obtainStyledAttributes2.getValue(android.support.v7.a.a.k.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
                obtainStyledAttributes2.getValue(android.support.v7.a.a.k.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
                if (obtainStyledAttributes2.hasValue(android.support.v7.a.a.k.AppCompatTheme_windowFixedWidthMajor)) {
                    obtainStyledAttributes2.getValue(android.support.v7.a.a.k.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
                }
                if (obtainStyledAttributes2.hasValue(android.support.v7.a.a.k.AppCompatTheme_windowFixedWidthMinor)) {
                    obtainStyledAttributes2.getValue(android.support.v7.a.a.k.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
                }
                if (obtainStyledAttributes2.hasValue(android.support.v7.a.a.k.AppCompatTheme_windowFixedHeightMajor)) {
                    obtainStyledAttributes2.getValue(android.support.v7.a.a.k.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
                }
                if (obtainStyledAttributes2.hasValue(android.support.v7.a.a.k.AppCompatTheme_windowFixedHeightMinor)) {
                    obtainStyledAttributes2.getValue(android.support.v7.a.a.k.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
                }
                obtainStyledAttributes2.recycle();
                contentFrameLayout.requestLayout();
                this.EE = true;
                PanelFeatureState aH = aH(0);
                if (!this.En) {
                    if (aH == null || aH.Fa == null) {
                        invalidatePanelMenu(108);
                        return;
                    }
                    return;
                }
                return;
            }
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
    }

    public final boolean requestWindowFeature(int i) {
        if (i == 8) {
            i = 108;
        } else if (i == 9) {
            i = 109;
        }
        if (this.Em && i == 108) {
            return false;
        }
        if (this.Ei && i == 1) {
            this.Ei = false;
        }
        switch (i) {
            case 1:
                dl();
                this.Em = true;
                return true;
            case 2:
                dl();
                this.EH = true;
                return true;
            case 5:
                dl();
                this.EI = true;
                return true;
            case 10:
                dl();
                this.Ek = true;
                return true;
            case 108:
                dl();
                this.Ei = true;
                return true;
            case 109:
                dl();
                this.Ej = true;
                return true;
            default:
                return this.CS.requestFeature(i);
        }
    }

    final void f(CharSequence charSequence) {
        if (this.Ew != null) {
            this.Ew.setWindowTitle(charSequence);
        } else if (this.mActionBar != null) {
            this.mActionBar.setWindowTitle(charSequence);
        } else if (this.Dm != null) {
            this.Dm.setText(charSequence);
        }
    }

    final void aE(int i) {
        if (i == 108) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.E(false);
            }
        } else if (i == 0) {
            PanelFeatureState aH = aH(i);
            if (aH.BA) {
                a(aH, false);
            }
        }
    }

    final boolean aF(int i) {
        if (i != 108) {
            return false;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            return true;
        }
        supportActionBar.E(true);
        return true;
    }

    public final boolean a(f fVar, MenuItem menuItem) {
        Callback callback = this.CS.getCallback();
        if (!(callback == null || this.En)) {
            PanelFeatureState a = a(fVar.dQ());
            if (a != null) {
                return callback.onMenuItemSelected(a.EW, menuItem);
            }
        }
        return false;
    }

    public final void b(f fVar) {
        if (this.Ew == null || !this.Ew.ef() || (ae.b(ViewConfiguration.get(this.mContext)) && !this.Ew.eg())) {
            PanelFeatureState aH = aH(0);
            aH.Fg = true;
            a(aH, false);
            a(aH, null);
            return;
        }
        Callback callback = this.CS.getCallback();
        if (this.Ew.isOverflowMenuShowing()) {
            this.Ew.hideOverflowMenu();
            if (!this.En) {
                callback.onPanelClosed(108, aH(0).Fa);
            }
        } else if (callback != null && !this.En) {
            if (this.EN && (this.EO & 1) != 0) {
                this.CS.getDecorView().removeCallbacks(this.EP);
                this.EP.run();
            }
            PanelFeatureState aH2 = aH(0);
            if (aH2.Fa != null && !aH2.Fh && callback.onPreparePanel(0, aH2.EZ, aH2.Fa)) {
                callback.onMenuOpened(108, aH2.Fa);
                this.Ew.showOverflowMenu();
            }
        }
    }

    public final android.support.v7.view.b startSupportActionMode(android.support.v7.view.b.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.Ez != null) {
            this.Ez.finish();
        }
        android.support.v7.view.b.a bVar = new b(aVar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            this.Ez = supportActionBar.a(bVar);
            if (!(this.Ez == null || this.Eh == null)) {
                this.Eh.onSupportActionModeStarted(this.Ez);
            }
        }
        if (this.Ez == null) {
            this.Ez = b(bVar);
        }
        return this.Ez;
    }

    public final void invalidateOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null || !supportActionBar.dc()) {
            invalidatePanelMenu(0);
        }
    }

    final android.support.v7.view.b b(android.support.v7.view.b.a aVar) {
        android.support.v7.view.b onWindowStartingSupportActionMode;
        dk();
        if (this.Ez != null) {
            this.Ez.finish();
        }
        android.support.v7.view.b.a bVar = new b(aVar);
        if (!(this.Eh == null || this.En)) {
            try {
                onWindowStartingSupportActionMode = this.Eh.onWindowStartingSupportActionMode(bVar);
            } catch (AbstractMethodError e) {
            }
            if (onWindowStartingSupportActionMode == null) {
                this.Ez = onWindowStartingSupportActionMode;
            } else {
                if (this.EA == null) {
                    if (this.El) {
                        Context dVar;
                        TypedValue typedValue = new TypedValue();
                        Theme theme = this.mContext.getTheme();
                        theme.resolveAttribute(android.support.v7.a.a.a.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            Theme newTheme = this.mContext.getResources().newTheme();
                            newTheme.setTo(theme);
                            newTheme.applyStyle(typedValue.resourceId, true);
                            dVar = new android.support.v7.view.d(this.mContext, 0);
                            dVar.getTheme().setTo(newTheme);
                        } else {
                            dVar = this.mContext;
                        }
                        this.EA = new ActionBarContextView(dVar);
                        this.EB = new PopupWindow(dVar, null, android.support.v7.a.a.a.actionModePopupWindowStyle);
                        m.a(this.EB, 2);
                        this.EB.setContentView(this.EA);
                        this.EB.setWidth(-1);
                        dVar.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarSize, typedValue, true);
                        this.EA.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                        this.EB.setHeight(-2);
                        this.EC = new Runnable() {
                            public final void run() {
                                AppCompatDelegateImplV7.this.EB.showAtLocation(AppCompatDelegateImplV7.this.EA, 55, 0, 0);
                                AppCompatDelegateImplV7.this.dk();
                                z.d(AppCompatDelegateImplV7.this.EA, 0.0f);
                                AppCompatDelegateImplV7.this.ED = z.U(AppCompatDelegateImplV7.this.EA).t(1.0f);
                                AppCompatDelegateImplV7.this.ED.a(new an() {
                                    public final void q(View view) {
                                        z.d(AppCompatDelegateImplV7.this.EA, 1.0f);
                                        AppCompatDelegateImplV7.this.ED.a(null);
                                        AppCompatDelegateImplV7.this.ED = null;
                                    }

                                    public final void p(View view) {
                                        AppCompatDelegateImplV7.this.EA.setVisibility(0);
                                    }
                                });
                            }
                        };
                    } else {
                        ViewStubCompat viewStubCompat = (ViewStubCompat) this.EF.findViewById(android.support.v7.a.a.f.action_mode_bar_stub);
                        if (viewStubCompat != null) {
                            viewStubCompat.setLayoutInflater(LayoutInflater.from(di()));
                            this.EA = (ActionBarContextView) viewStubCompat.inflate();
                        }
                    }
                }
                if (this.EA != null) {
                    boolean z;
                    dk();
                    this.EA.ec();
                    Context context = this.EA.getContext();
                    ActionBarContextView actionBarContextView = this.EA;
                    if (this.EB == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    android.support.v7.view.b eVar = new android.support.v7.view.e(context, actionBarContextView, bVar, z);
                    if (aVar.a(eVar, eVar.getMenu())) {
                        eVar.invalidate();
                        this.EA.c(eVar);
                        this.Ez = eVar;
                        z.d(this.EA, 0.0f);
                        this.ED = z.U(this.EA).t(1.0f);
                        this.ED.a(new an() {
                            public final void q(View view) {
                                z.d(AppCompatDelegateImplV7.this.EA, 1.0f);
                                AppCompatDelegateImplV7.this.ED.a(null);
                                AppCompatDelegateImplV7.this.ED = null;
                            }

                            public final void p(View view) {
                                AppCompatDelegateImplV7.this.EA.setVisibility(0);
                                AppCompatDelegateImplV7.this.EA.sendAccessibilityEvent(32);
                                if (AppCompatDelegateImplV7.this.EA.getParent() != null) {
                                    z.Y((View) AppCompatDelegateImplV7.this.EA.getParent());
                                }
                            }
                        });
                        if (this.EB != null) {
                            this.CS.getDecorView().post(this.EC);
                        }
                    } else {
                        this.Ez = null;
                    }
                }
            }
            if (!(this.Ez == null || this.Eh == null)) {
                this.Eh.onSupportActionModeStarted(this.Ez);
            }
            return this.Ez;
        }
        onWindowStartingSupportActionMode = null;
        if (onWindowStartingSupportActionMode == null) {
            if (this.EA == null) {
                if (this.El) {
                    Context dVar2;
                    TypedValue typedValue2 = new TypedValue();
                    Theme theme2 = this.mContext.getTheme();
                    theme2.resolveAttribute(android.support.v7.a.a.a.actionBarTheme, typedValue2, true);
                    if (typedValue2.resourceId != 0) {
                        Theme newTheme2 = this.mContext.getResources().newTheme();
                        newTheme2.setTo(theme2);
                        newTheme2.applyStyle(typedValue2.resourceId, true);
                        dVar2 = new android.support.v7.view.d(this.mContext, 0);
                        dVar2.getTheme().setTo(newTheme2);
                    } else {
                        dVar2 = this.mContext;
                    }
                    this.EA = new ActionBarContextView(dVar2);
                    this.EB = new PopupWindow(dVar2, null, android.support.v7.a.a.a.actionModePopupWindowStyle);
                    m.a(this.EB, 2);
                    this.EB.setContentView(this.EA);
                    this.EB.setWidth(-1);
                    dVar2.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarSize, typedValue2, true);
                    this.EA.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue2.data, dVar2.getResources().getDisplayMetrics()));
                    this.EB.setHeight(-2);
                    this.EC = /* anonymous class already generated */;
                } else {
                    ViewStubCompat viewStubCompat2 = (ViewStubCompat) this.EF.findViewById(android.support.v7.a.a.f.action_mode_bar_stub);
                    if (viewStubCompat2 != null) {
                        viewStubCompat2.setLayoutInflater(LayoutInflater.from(di()));
                        this.EA = (ActionBarContextView) viewStubCompat2.inflate();
                    }
                }
            }
            if (this.EA != null) {
                boolean z2;
                dk();
                this.EA.ec();
                Context context2 = this.EA.getContext();
                ActionBarContextView actionBarContextView2 = this.EA;
                if (this.EB == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                android.support.v7.view.b eVar2 = new android.support.v7.view.e(context2, actionBarContextView2, bVar, z2);
                if (aVar.a(eVar2, eVar2.getMenu())) {
                    eVar2.invalidate();
                    this.EA.c(eVar2);
                    this.Ez = eVar2;
                    z.d(this.EA, 0.0f);
                    this.ED = z.U(this.EA).t(1.0f);
                    this.ED.a(/* anonymous class already generated */);
                    if (this.EB != null) {
                        this.CS.getDecorView().post(this.EC);
                    }
                } else {
                    this.Ez = null;
                }
            }
        } else {
            this.Ez = onWindowStartingSupportActionMode;
        }
        this.Eh.onSupportActionModeStarted(this.Ez);
        return this.Ez;
    }

    private void dk() {
        if (this.ED != null) {
            this.ED.cancel();
        }
    }

    final boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null && supportActionBar.onKeyShortcut(i, keyEvent)) {
            return true;
        }
        if (this.EL == null || !a(this.EL, keyEvent.getKeyCode(), keyEvent)) {
            if (this.EL == null) {
                PanelFeatureState aH = aH(0);
                b(aH, keyEvent);
                boolean a = a(aH, keyEvent.getKeyCode(), keyEvent);
                aH.Fd = false;
                if (a) {
                    return true;
                }
            }
            return false;
        } else if (this.EL == null) {
            return true;
        } else {
            this.EL.Fe = true;
            return true;
        }
    }

    final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82 && this.Ef.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        boolean z;
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            switch (keyCode) {
                case 4:
                    this.EM = (keyEvent.getFlags() & FileUtils.S_IWUSR) != 0;
                    break;
                case 82:
                    if (keyEvent.getRepeatCount() != 0) {
                        return true;
                    }
                    PanelFeatureState aH = aH(0);
                    if (aH.BA) {
                        return true;
                    }
                    b(aH, keyEvent);
                    return true;
            }
            if (VERSION.SDK_INT < 11) {
                onKeyShortcut(keyCode, keyEvent);
            }
            return false;
        }
        PanelFeatureState aH2;
        switch (keyCode) {
            case 4:
                z = this.EM;
                this.EM = false;
                aH2 = aH(0);
                if (aH2 == null || !aH2.BA) {
                    if (this.Ez != null) {
                        this.Ez.finish();
                        z = true;
                    } else {
                        ActionBar supportActionBar = getSupportActionBar();
                        z = supportActionBar != null && supportActionBar.collapseActionView();
                    }
                    if (z) {
                        return true;
                    }
                } else if (z) {
                    return true;
                } else {
                    a(aH2, true);
                    return true;
                }
                break;
            case 82:
                if (this.Ez != null) {
                    return true;
                }
                aH2 = aH(0);
                if (this.Ew == null || !this.Ew.ef() || ae.b(ViewConfiguration.get(this.mContext))) {
                    if (aH2.BA || aH2.Fe) {
                        z = aH2.BA;
                        a(aH2, true);
                    } else {
                        if (aH2.Fd) {
                            if (aH2.Fh) {
                                aH2.Fd = false;
                                z = b(aH2, keyEvent);
                            } else {
                                z = true;
                            }
                            if (z) {
                                a(aH2, keyEvent);
                                z = true;
                            }
                        }
                        z = false;
                    }
                } else if (this.Ew.isOverflowMenuShowing()) {
                    z = this.Ew.hideOverflowMenu();
                } else {
                    if (!this.En && b(aH2, keyEvent)) {
                        z = this.Ew.showOverflowMenu();
                    }
                    z = false;
                }
                if (!z) {
                    return true;
                }
                AudioManager audioManager = (AudioManager) this.mContext.getSystemService("audio");
                if (audioManager == null) {
                    return true;
                }
                audioManager.playSoundEffect(0);
                return true;
        }
        return false;
    }

    public final void de() {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        if (from.getFactory() == null) {
            android.support.v4.view.h.a(from, this);
        } else {
            android.support.v4.view.h.a(from);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.View r8, java.lang.String r9, android.content.Context r10, android.util.AttributeSet r11) {
        /*
        r7 = this;
        r3 = 1;
        r4 = 0;
        r0 = r7.a(r9, r10, r11);
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return r0;
    L_0x0009:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 21;
        if (r0 >= r1) goto L_0x0059;
    L_0x000f:
        r2 = r3;
    L_0x0010:
        r0 = r7.ER;
        if (r0 != 0) goto L_0x001b;
    L_0x0014:
        r0 = new android.support.v7.app.k;
        r0.<init>();
        r7.ER = r0;
    L_0x001b:
        if (r2 == 0) goto L_0x007c;
    L_0x001d:
        r0 = r8;
        r0 = (android.view.ViewParent) r0;
        if (r0 != 0) goto L_0x005b;
    L_0x0022:
        r0 = r4;
    L_0x0023:
        if (r0 == 0) goto L_0x007c;
    L_0x0025:
        r0 = r3;
    L_0x0026:
        r5 = r7.ER;
        r1 = android.support.v7.widget.ar.hi();
        if (r0 == 0) goto L_0x0176;
    L_0x002e:
        if (r8 == 0) goto L_0x0176;
    L_0x0030:
        r0 = r8.getContext();
    L_0x0034:
        r0 = android.support.v7.app.k.a(r0, r11, r2);
        if (r1 == 0) goto L_0x003e;
    L_0x003a:
        r0 = android.support.v7.widget.am.T(r0);
    L_0x003e:
        r1 = 0;
        r2 = -1;
        r6 = r9.hashCode();
        switch(r6) {
            case -1946472170: goto L_0x00fe;
            case -1455429095: goto L_0x00d7;
            case -1346021293: goto L_0x00f1;
            case -938935918: goto L_0x007e;
            case -937446323: goto L_0x00b4;
            case -658531749: goto L_0x010b;
            case -339785223: goto L_0x00a9;
            case 776382189: goto L_0x00cb;
            case 1125864064: goto L_0x0088;
            case 1413872058: goto L_0x00e4;
            case 1601505219: goto L_0x00bf;
            case 1666676343: goto L_0x009e;
            case 2001146706: goto L_0x0093;
            default: goto L_0x0047;
        };
    L_0x0047:
        r4 = r2;
    L_0x0048:
        switch(r4) {
            case 0: goto L_0x0118;
            case 1: goto L_0x011f;
            case 2: goto L_0x0126;
            case 3: goto L_0x012d;
            case 4: goto L_0x0134;
            case 5: goto L_0x013b;
            case 6: goto L_0x0142;
            case 7: goto L_0x0149;
            case 8: goto L_0x0150;
            case 9: goto L_0x0157;
            case 10: goto L_0x015e;
            case 11: goto L_0x0165;
            case 12: goto L_0x016c;
            default: goto L_0x004b;
        };
    L_0x004b:
        if (r1 != 0) goto L_0x0173;
    L_0x004d:
        if (r10 == r0) goto L_0x0173;
    L_0x004f:
        r0 = r5.a(r0, r9, r11);
    L_0x0053:
        if (r0 == 0) goto L_0x0008;
    L_0x0055:
        android.support.v7.app.k.a(r0, r11);
        goto L_0x0008;
    L_0x0059:
        r2 = r4;
        goto L_0x0010;
    L_0x005b:
        r1 = r7.CS;
        r5 = r1.getDecorView();
        r1 = r0;
    L_0x0062:
        if (r1 != 0) goto L_0x0066;
    L_0x0064:
        r0 = r3;
        goto L_0x0023;
    L_0x0066:
        if (r1 == r5) goto L_0x0075;
    L_0x0068:
        r0 = r1 instanceof android.view.View;
        if (r0 == 0) goto L_0x0075;
    L_0x006c:
        r0 = r1;
        r0 = (android.view.View) r0;
        r0 = android.support.v4.view.z.ak(r0);
        if (r0 == 0) goto L_0x0077;
    L_0x0075:
        r0 = r4;
        goto L_0x0023;
    L_0x0077:
        r1 = r1.getParent();
        goto L_0x0062;
    L_0x007c:
        r0 = r4;
        goto L_0x0026;
    L_0x007e:
        r3 = "TextView";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x0087:
        goto L_0x0048;
    L_0x0088:
        r4 = "ImageView";
        r4 = r9.equals(r4);
        if (r4 == 0) goto L_0x0047;
    L_0x0091:
        r4 = r3;
        goto L_0x0048;
    L_0x0093:
        r3 = "Button";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x009c:
        r4 = 2;
        goto L_0x0048;
    L_0x009e:
        r3 = "EditText";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00a7:
        r4 = 3;
        goto L_0x0048;
    L_0x00a9:
        r3 = "Spinner";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00b2:
        r4 = 4;
        goto L_0x0048;
    L_0x00b4:
        r3 = "ImageButton";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00bd:
        r4 = 5;
        goto L_0x0048;
    L_0x00bf:
        r3 = "CheckBox";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00c8:
        r4 = 6;
        goto L_0x0048;
    L_0x00cb:
        r3 = "RadioButton";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00d4:
        r4 = 7;
        goto L_0x0048;
    L_0x00d7:
        r3 = "CheckedTextView";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00e0:
        r4 = 8;
        goto L_0x0048;
    L_0x00e4:
        r3 = "AutoCompleteTextView";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00ed:
        r4 = 9;
        goto L_0x0048;
    L_0x00f1:
        r3 = "MultiAutoCompleteTextView";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00fa:
        r4 = 10;
        goto L_0x0048;
    L_0x00fe:
        r3 = "RatingBar";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x0107:
        r4 = 11;
        goto L_0x0048;
    L_0x010b:
        r3 = "SeekBar";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x0114:
        r4 = 12;
        goto L_0x0048;
    L_0x0118:
        r1 = new android.support.v7.widget.AppCompatTextView;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x011f:
        r1 = new android.support.v7.widget.AppCompatImageView;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0126:
        r1 = new android.support.v7.widget.AppCompatButton;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x012d:
        r1 = new android.support.v7.widget.AppCompatEditText;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0134:
        r1 = new android.support.v7.widget.AppCompatSpinner;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x013b:
        r1 = new android.support.v7.widget.AppCompatImageButton;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0142:
        r1 = new android.support.v7.widget.AppCompatCheckBox;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0149:
        r1 = new android.support.v7.widget.AppCompatRadioButton;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0150:
        r1 = new android.support.v7.widget.AppCompatCheckedTextView;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0157:
        r1 = new android.support.v7.widget.AppCompatAutoCompleteTextView;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x015e:
        r1 = new android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0165:
        r1 = new android.support.v7.widget.AppCompatRatingBar;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x016c:
        r1 = new android.support.v7.widget.AppCompatSeekBar;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0173:
        r0 = r1;
        goto L_0x0053;
    L_0x0176:
        r0 = r10;
        goto L_0x0034;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatDelegateImplV7.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    View a(String str, Context context, AttributeSet attributeSet) {
        if (this.Ef instanceof Factory) {
            View onCreateView = ((Factory) this.Ef).onCreateView(str, context, attributeSet);
            if (onCreateView != null) {
                return onCreateView;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.support.v7.app.AppCompatDelegateImplV7.PanelFeatureState r11, android.view.KeyEvent r12) {
        /*
        r10 = this;
        r1 = -1;
        r2 = -2;
        r3 = 0;
        r9 = 1;
        r0 = r11.BA;
        if (r0 != 0) goto L_0x000c;
    L_0x0008:
        r0 = r10.En;
        if (r0 == 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r0 = r11.EW;
        if (r0 != 0) goto L_0x0032;
    L_0x0011:
        r4 = r10.mContext;
        r0 = r4.getResources();
        r0 = r0.getConfiguration();
        r0 = r0.screenLayout;
        r0 = r0 & 15;
        r5 = 4;
        if (r0 != r5) goto L_0x0048;
    L_0x0022:
        r0 = r9;
    L_0x0023:
        r4 = r4.getApplicationInfo();
        r4 = r4.targetSdkVersion;
        r5 = 11;
        if (r4 < r5) goto L_0x004a;
    L_0x002d:
        r4 = r9;
    L_0x002e:
        if (r0 == 0) goto L_0x0032;
    L_0x0030:
        if (r4 != 0) goto L_0x000c;
    L_0x0032:
        r0 = r10.CS;
        r0 = r0.getCallback();
        if (r0 == 0) goto L_0x004c;
    L_0x003a:
        r4 = r11.EW;
        r5 = r11.Fa;
        r0 = r0.onMenuOpened(r4, r5);
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r10.a(r11, r9);
        goto L_0x000c;
    L_0x0048:
        r0 = r3;
        goto L_0x0023;
    L_0x004a:
        r4 = r3;
        goto L_0x002e;
    L_0x004c:
        r0 = r10.mContext;
        r4 = "window";
        r0 = r0.getSystemService(r4);
        r8 = r0;
        r8 = (android.view.WindowManager) r8;
        if (r8 == 0) goto L_0x000c;
    L_0x005a:
        r0 = r10.b(r11, r12);
        if (r0 == 0) goto L_0x000c;
    L_0x0060:
        r0 = r11.EX;
        if (r0 == 0) goto L_0x0068;
    L_0x0064:
        r0 = r11.Fg;
        if (r0 == 0) goto L_0x01bf;
    L_0x0068:
        r0 = r11.EX;
        if (r0 != 0) goto L_0x0153;
    L_0x006c:
        r0 = r10.di();
        r1 = new android.util.TypedValue;
        r1.<init>();
        r4 = r0.getResources();
        r4 = r4.newTheme();
        r5 = r0.getTheme();
        r4.setTo(r5);
        r5 = android.support.v7.a.a.a.actionBarPopupTheme;
        r4.resolveAttribute(r5, r1, r9);
        r5 = r1.resourceId;
        if (r5 == 0) goto L_0x0092;
    L_0x008d:
        r5 = r1.resourceId;
        r4.applyStyle(r5, r9);
    L_0x0092:
        r5 = android.support.v7.a.a.a.panelMenuListTheme;
        r4.resolveAttribute(r5, r1, r9);
        r5 = r1.resourceId;
        if (r5 == 0) goto L_0x014c;
    L_0x009b:
        r1 = r1.resourceId;
        r4.applyStyle(r1, r9);
    L_0x00a0:
        r1 = new android.support.v7.view.d;
        r1.<init>(r0, r3);
        r0 = r1.getTheme();
        r0.setTo(r4);
        r11.Fc = r1;
        r0 = android.support.v7.a.a.k.AppCompatTheme;
        r0 = r1.obtainStyledAttributes(r0);
        r1 = android.support.v7.a.a.k.AppCompatTheme_panelBackground;
        r1 = r0.getResourceId(r1, r3);
        r11.background = r1;
        r1 = android.support.v7.a.a.k.AppCompatTheme_android_windowAnimationStyle;
        r1 = r0.getResourceId(r1, r3);
        r11.windowAnimations = r1;
        r0.recycle();
        r0 = new android.support.v7.app.AppCompatDelegateImplV7$c;
        r1 = r11.Fc;
        r0.<init>(r1);
        r11.EX = r0;
        r0 = 81;
        r11.gravity = r0;
        r0 = r11.EX;
        if (r0 == 0) goto L_0x000c;
    L_0x00d8:
        r0 = r11.EZ;
        if (r0 == 0) goto L_0x0166;
    L_0x00dc:
        r0 = r11.EZ;
        r11.EY = r0;
        r0 = r9;
    L_0x00e1:
        if (r0 == 0) goto L_0x000c;
    L_0x00e3:
        r0 = r11.EY;
        if (r0 == 0) goto L_0x01bc;
    L_0x00e7:
        r0 = r11.EZ;
        if (r0 == 0) goto L_0x01ad;
    L_0x00eb:
        r0 = r9;
    L_0x00ec:
        if (r0 == 0) goto L_0x000c;
    L_0x00ee:
        r0 = r11.EY;
        r0 = r0.getLayoutParams();
        if (r0 != 0) goto L_0x01d2;
    L_0x00f6:
        r0 = new android.view.ViewGroup$LayoutParams;
        r0.<init>(r2, r2);
        r1 = r0;
    L_0x00fc:
        r0 = r11.background;
        r4 = r11.EX;
        r4.setBackgroundResource(r0);
        r0 = r11.EY;
        r0 = r0.getParent();
        if (r0 == 0) goto L_0x0116;
    L_0x010b:
        r4 = r0 instanceof android.view.ViewGroup;
        if (r4 == 0) goto L_0x0116;
    L_0x010f:
        r0 = (android.view.ViewGroup) r0;
        r4 = r11.EY;
        r0.removeView(r4);
    L_0x0116:
        r0 = r11.EX;
        r4 = r11.EY;
        r0.addView(r4, r1);
        r0 = r11.EY;
        r0 = r0.hasFocus();
        if (r0 != 0) goto L_0x012a;
    L_0x0125:
        r0 = r11.EY;
        r0.requestFocus();
    L_0x012a:
        r1 = r2;
    L_0x012b:
        r11.Fe = r3;
        r0 = new android.view.WindowManager$LayoutParams;
        r3 = r11.x;
        r4 = r11.y;
        r5 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r6 = 8519680; // 0x820000 float:1.1938615E-38 double:4.209281E-317;
        r7 = -3;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r1 = r11.gravity;
        r0.gravity = r1;
        r1 = r11.windowAnimations;
        r0.windowAnimations = r1;
        r1 = r11.EX;
        r8.addView(r1, r0);
        r11.BA = r9;
        goto L_0x000c;
    L_0x014c:
        r1 = android.support.v7.a.a.j.Theme_AppCompat_CompactMenu;
        r4.applyStyle(r1, r9);
        goto L_0x00a0;
    L_0x0153:
        r0 = r11.Fg;
        if (r0 == 0) goto L_0x00d8;
    L_0x0157:
        r0 = r11.EX;
        r0 = r0.getChildCount();
        if (r0 <= 0) goto L_0x00d8;
    L_0x015f:
        r0 = r11.EX;
        r0.removeAllViews();
        goto L_0x00d8;
    L_0x0166:
        r0 = r11.Fa;
        if (r0 == 0) goto L_0x01aa;
    L_0x016a:
        r0 = r10.Ey;
        if (r0 != 0) goto L_0x0175;
    L_0x016e:
        r0 = new android.support.v7.app.AppCompatDelegateImplV7$d;
        r0.<init>(r10, r3);
        r10.Ey = r0;
    L_0x0175:
        r0 = r10.Ey;
        r1 = r11.Fa;
        if (r1 != 0) goto L_0x0187;
    L_0x017b:
        r0 = 0;
    L_0x017c:
        r0 = (android.view.View) r0;
        r11.EY = r0;
        r0 = r11.EY;
        if (r0 == 0) goto L_0x01aa;
    L_0x0184:
        r0 = r9;
        goto L_0x00e1;
    L_0x0187:
        r1 = r11.Fb;
        if (r1 != 0) goto L_0x01a1;
    L_0x018b:
        r1 = new android.support.v7.view.menu.e;
        r4 = r11.Fc;
        r5 = android.support.v7.a.a.h.abc_list_menu_item_layout;
        r1.<init>(r4, r5);
        r11.Fb = r1;
        r1 = r11.Fb;
        r1.bp = r0;
        r0 = r11.Fa;
        r1 = r11.Fb;
        r0.a(r1);
    L_0x01a1:
        r0 = r11.Fb;
        r1 = r11.EX;
        r0 = r0.e(r1);
        goto L_0x017c;
    L_0x01aa:
        r0 = r3;
        goto L_0x00e1;
    L_0x01ad:
        r0 = r11.Fb;
        r0 = r0.getAdapter();
        r0 = r0.getCount();
        if (r0 <= 0) goto L_0x01bc;
    L_0x01b9:
        r0 = r9;
        goto L_0x00ec;
    L_0x01bc:
        r0 = r3;
        goto L_0x00ec;
    L_0x01bf:
        r0 = r11.EZ;
        if (r0 == 0) goto L_0x01cf;
    L_0x01c3:
        r0 = r11.EZ;
        r0 = r0.getLayoutParams();
        if (r0 == 0) goto L_0x01cf;
    L_0x01cb:
        r0 = r0.width;
        if (r0 == r1) goto L_0x012b;
    L_0x01cf:
        r1 = r2;
        goto L_0x012b;
    L_0x01d2:
        r1 = r0;
        goto L_0x00fc;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatDelegateImplV7.a(android.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState, android.view.KeyEvent):void");
    }

    private boolean b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (this.En) {
            return false;
        }
        if (panelFeatureState.Fd) {
            return true;
        }
        if (!(this.EL == null || this.EL == panelFeatureState)) {
            a(this.EL, false);
        }
        Callback callback = this.CS.getCallback();
        if (callback != null) {
            panelFeatureState.EZ = callback.onCreatePanelView(panelFeatureState.EW);
        }
        boolean z = panelFeatureState.EW == 0 || panelFeatureState.EW == 108;
        if (z && this.Ew != null) {
            this.Ew.eh();
        }
        if (panelFeatureState.EZ == null && !(z && (this.mActionBar instanceof l))) {
            if (panelFeatureState.Fa == null || panelFeatureState.Fh) {
                if (panelFeatureState.Fa == null) {
                    Context dVar;
                    f fVar;
                    Context context = this.mContext;
                    if ((panelFeatureState.EW == 0 || panelFeatureState.EW == 108) && this.Ew != null) {
                        Theme newTheme;
                        TypedValue typedValue = new TypedValue();
                        Theme theme = context.getTheme();
                        theme.resolveAttribute(android.support.v7.a.a.a.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            newTheme = context.getResources().newTheme();
                            newTheme.setTo(theme);
                            newTheme.applyStyle(typedValue.resourceId, true);
                            newTheme.resolveAttribute(android.support.v7.a.a.a.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme.resolveAttribute(android.support.v7.a.a.a.actionBarWidgetTheme, typedValue, true);
                            newTheme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (newTheme == null) {
                                newTheme = context.getResources().newTheme();
                                newTheme.setTo(theme);
                            }
                            newTheme.applyStyle(typedValue.resourceId, true);
                        }
                        Theme theme2 = newTheme;
                        if (theme2 != null) {
                            dVar = new android.support.v7.view.d(context, 0);
                            dVar.getTheme().setTo(theme2);
                            fVar = new f(dVar);
                            fVar.a((android.support.v7.view.menu.f.a) this);
                            panelFeatureState.e(fVar);
                            if (panelFeatureState.Fa == null) {
                                return false;
                            }
                        }
                    }
                    dVar = context;
                    fVar = new f(dVar);
                    fVar.a((android.support.v7.view.menu.f.a) this);
                    panelFeatureState.e(fVar);
                    if (panelFeatureState.Fa == null) {
                        return false;
                    }
                }
                if (z && this.Ew != null) {
                    if (this.Ex == null) {
                        this.Ex = new a(this, (byte) 0);
                    }
                    this.Ew.a(panelFeatureState.Fa, this.Ex);
                }
                panelFeatureState.Fa.dJ();
                if (callback.onCreatePanelMenu(panelFeatureState.EW, panelFeatureState.Fa)) {
                    panelFeatureState.Fh = false;
                } else {
                    panelFeatureState.e(null);
                    if (!z || this.Ew == null) {
                        return false;
                    }
                    this.Ew.a(null, this.Ex);
                    return false;
                }
            }
            panelFeatureState.Fa.dJ();
            if (panelFeatureState.Fi != null) {
                panelFeatureState.Fa.d(panelFeatureState.Fi);
                panelFeatureState.Fi = null;
            }
            if (callback.onPreparePanel(0, panelFeatureState.EZ, panelFeatureState.Fa)) {
                boolean z2;
                if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                panelFeatureState.Ff = z2;
                panelFeatureState.Fa.setQwertyMode(panelFeatureState.Ff);
                panelFeatureState.Fa.dK();
            } else {
                if (z && this.Ew != null) {
                    this.Ew.a(null, this.Ex);
                }
                panelFeatureState.Fa.dK();
                return false;
            }
        }
        panelFeatureState.Fd = true;
        panelFeatureState.Fe = false;
        this.EL = panelFeatureState;
        return true;
    }

    private void c(f fVar) {
        if (!this.EJ) {
            this.EJ = true;
            this.Ew.ei();
            Callback callback = this.CS.getCallback();
            if (!(callback == null || this.En)) {
                callback.onPanelClosed(108, fVar);
            }
            this.EJ = false;
        }
    }

    private void a(PanelFeatureState panelFeatureState, boolean z) {
        if (z && panelFeatureState.EW == 0 && this.Ew != null && this.Ew.isOverflowMenuShowing()) {
            c(panelFeatureState.Fa);
            return;
        }
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (!(windowManager == null || !panelFeatureState.BA || panelFeatureState.EX == null)) {
            windowManager.removeView(panelFeatureState.EX);
            if (z) {
                a(panelFeatureState.EW, panelFeatureState, null);
            }
        }
        panelFeatureState.Fd = false;
        panelFeatureState.Fe = false;
        panelFeatureState.BA = false;
        panelFeatureState.EY = null;
        panelFeatureState.Fg = true;
        if (this.EL == panelFeatureState) {
            this.EL = null;
        }
    }

    private void a(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0 && i < this.EK.length) {
                panelFeatureState = this.EK[i];
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.Fa;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.BA) && !this.En) {
            this.Ef.onPanelClosed(i, menu);
        }
    }

    private PanelFeatureState a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.EK;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.Fa == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    private PanelFeatureState aH(int i) {
        Object obj = this.EK;
        if (obj == null || obj.length <= i) {
            Object obj2 = new PanelFeatureState[(i + 1)];
            if (obj != null) {
                System.arraycopy(obj, 0, obj2, 0, obj.length);
            }
            this.EK = obj2;
            obj = obj2;
        }
        PanelFeatureState panelFeatureState = obj[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        panelFeatureState = new PanelFeatureState(i);
        obj[i] = panelFeatureState;
        return panelFeatureState;
    }

    private boolean a(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent) {
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.Fd || b(panelFeatureState, keyEvent)) && panelFeatureState.Fa != null) {
            return panelFeatureState.Fa.performShortcut(i, keyEvent, 1);
        }
        return false;
    }

    private void invalidatePanelMenu(int i) {
        this.EO |= 1 << i;
        if (!this.EN) {
            z.a(this.CS.getDecorView(), this.EP);
            this.EN = true;
        }
    }

    private void dl() {
        if (this.EE) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }
}
