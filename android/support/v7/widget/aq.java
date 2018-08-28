package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ai;
import android.support.v4.view.an;
import android.support.v4.view.z;
import android.support.v7.a.a.a;
import android.support.v7.a.a.e;
import android.support.v7.a.a.f;
import android.support.v7.a.a.i;
import android.support.v7.a.a.k;
import android.support.v7.view.menu.l;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;

public final class aq implements u {
    Callback Fu;
    private ActionMenuPresenter Jp;
    private final h Mb;
    private int Xh;
    private View Xi;
    private Drawable Xj;
    private Drawable Xk;
    private boolean Xl;
    private CharSequence Xm;
    boolean Xn;
    private int Xo;
    private int Xp;
    private Drawable Xq;
    Toolbar dT;
    private View hZ;
    private Drawable hh;
    CharSequence sn;
    private CharSequence so;

    public aq(Toolbar toolbar, boolean z) {
        this(toolbar, z, i.abc_action_bar_up_description, e.abc_ic_ab_back_mtrl_am_alpha);
    }

    private aq(Toolbar toolbar, boolean z, int i, int i2) {
        this.Xo = 0;
        this.Xp = 0;
        this.dT = toolbar;
        this.sn = toolbar.getTitle();
        this.so = toolbar.getSubtitle();
        this.Xl = this.sn != null;
        this.Xk = toolbar.getNavigationIcon();
        if (z) {
            Toolbar toolbar2;
            Context context;
            ap a = ap.a(toolbar.getContext(), null, k.ActionBar, a.actionBarStyle);
            CharSequence text = a.getText(k.ActionBar_title);
            if (!TextUtils.isEmpty(text)) {
                this.Xl = true;
                i(text);
            }
            CharSequence text2 = a.getText(k.ActionBar_subtitle);
            if (!TextUtils.isEmpty(text2)) {
                this.so = text2;
                if ((this.Xh & 8) != 0) {
                    this.dT.setSubtitle(text2);
                }
            }
            Drawable drawable = a.getDrawable(k.ActionBar_logo);
            if (drawable != null) {
                setLogo(drawable);
            }
            drawable = a.getDrawable(k.ActionBar_icon);
            if (this.Xk == null && drawable != null) {
                setIcon(drawable);
            }
            drawable = a.getDrawable(k.ActionBar_homeAsUpIndicator);
            if (drawable != null) {
                this.Xk = drawable;
                hh();
            }
            setDisplayOptions(a.getInt(k.ActionBar_displayOptions, 0));
            int resourceId = a.getResourceId(k.ActionBar_customNavigationLayout, 0);
            if (resourceId != 0) {
                setCustomView(LayoutInflater.from(this.dT.getContext()).inflate(resourceId, this.dT, false));
                setDisplayOptions(this.Xh | 16);
            }
            resourceId = a.getLayoutDimension(k.ActionBar_height, 0);
            if (resourceId > 0) {
                LayoutParams layoutParams = this.dT.getLayoutParams();
                layoutParams.height = resourceId;
                this.dT.setLayoutParams(layoutParams);
            }
            resourceId = a.getDimensionPixelOffset(k.ActionBar_contentInsetStart, -1);
            int dimensionPixelOffset = a.getDimensionPixelOffset(k.ActionBar_contentInsetEnd, -1);
            if (resourceId >= 0 || dimensionPixelOffset >= 0) {
                this.dT.WN.aj(Math.max(resourceId, 0), Math.max(dimensionPixelOffset, 0));
            }
            resourceId = a.getResourceId(k.ActionBar_titleTextStyle, 0);
            if (resourceId != 0) {
                toolbar2 = this.dT;
                context = this.dT.getContext();
                toolbar2.WF = resourceId;
                if (toolbar2.Wx != null) {
                    toolbar2.Wx.setTextAppearance(context, resourceId);
                }
            }
            resourceId = a.getResourceId(k.ActionBar_subtitleTextStyle, 0);
            if (resourceId != 0) {
                toolbar2 = this.dT;
                context = this.dT.getContext();
                toolbar2.WG = resourceId;
                if (toolbar2.Wy != null) {
                    toolbar2.Wy.setTextAppearance(context, resourceId);
                }
            }
            resourceId = a.getResourceId(k.ActionBar_popupTheme, 0);
            if (resourceId != 0) {
                this.dT.setPopupTheme(resourceId);
            }
            a.Ww.recycle();
        } else {
            int i3 = 11;
            if (this.dT.getNavigationIcon() != null) {
                i3 = 15;
            }
            this.Xh = i3;
        }
        this.Mb = h.eJ();
        if (i != this.Xp) {
            this.Xp = i;
            if (TextUtils.isEmpty(this.dT.getNavigationContentDescription())) {
                setNavigationContentDescription(this.Xp);
            }
        }
        this.Xm = this.dT.getNavigationContentDescription();
        Drawable a2 = this.Mb.a(this.dT.getContext(), i2, false);
        if (this.Xq != a2) {
            this.Xq = a2;
            hh();
        }
        this.dT.setNavigationOnClickListener(new OnClickListener() {
            final android.support.v7.view.menu.a Xr = new android.support.v7.view.menu.a(aq.this.dT.getContext(), aq.this.sn);

            public final void onClick(View view) {
                if (aq.this.Fu != null && aq.this.Xn) {
                    aq.this.Fu.onMenuItemSelected(0, this.Xr);
                }
            }
        });
    }

    public final ViewGroup eQ() {
        return this.dT;
    }

    public final Context getContext() {
        return this.dT.getContext();
    }

    public final boolean hasExpandedActionView() {
        Toolbar toolbar = this.dT;
        return (toolbar.WZ == null || toolbar.WZ.Xd == null) ? false : true;
    }

    public final void collapseActionView() {
        this.dT.collapseActionView();
    }

    public final void setWindowCallback(Callback callback) {
        this.Fu = callback;
    }

    public final void setWindowTitle(CharSequence charSequence) {
        if (!this.Xl) {
            i(charSequence);
        }
    }

    public final CharSequence getTitle() {
        return this.dT.getTitle();
    }

    private void i(CharSequence charSequence) {
        this.sn = charSequence;
        if ((this.Xh & 8) != 0) {
            this.dT.setTitle(charSequence);
        }
    }

    public final void setIcon(int i) {
        setIcon(i != 0 ? this.Mb.a(this.dT.getContext(), i, false) : null);
    }

    public final void setIcon(Drawable drawable) {
        this.hh = drawable;
        hf();
    }

    public final void setLogo(int i) {
        setLogo(i != 0 ? this.Mb.a(this.dT.getContext(), i, false) : null);
    }

    public final void setLogo(Drawable drawable) {
        this.Xj = drawable;
        hf();
    }

    private void hf() {
        Drawable drawable = null;
        if ((this.Xh & 2) != 0) {
            drawable = (this.Xh & 1) != 0 ? this.Xj != null ? this.Xj : this.hh : this.hh;
        }
        this.dT.setLogo(drawable);
    }

    public final boolean ef() {
        Toolbar toolbar = this.dT;
        return toolbar.getVisibility() == 0 && toolbar.Jo != null && toolbar.Jo.Kr;
    }

    public final boolean isOverflowMenuShowing() {
        return this.dT.isOverflowMenuShowing();
    }

    public final boolean eg() {
        Toolbar toolbar = this.dT;
        if (toolbar.Jo != null) {
            boolean z;
            ActionMenuView actionMenuView = toolbar.Jo;
            if (actionMenuView.KQ != null) {
                ActionMenuPresenter actionMenuPresenter = actionMenuView.KQ;
                z = actionMenuPresenter.KF != null || actionMenuPresenter.isOverflowMenuShowing();
                if (z) {
                    z = true;
                    if (z) {
                        return true;
                    }
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean showOverflowMenu() {
        return this.dT.showOverflowMenu();
    }

    public final boolean hideOverflowMenu() {
        Toolbar toolbar = this.dT;
        if (toolbar.Jo != null) {
            ActionMenuView actionMenuView = toolbar.Jo;
            boolean z = actionMenuView.KQ != null && actionMenuView.KQ.hideOverflowMenu();
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final void eh() {
        this.Xn = true;
    }

    public final void a(Menu menu, l.a aVar) {
        if (this.Jp == null) {
            this.Jp = new ActionMenuPresenter(this.dT.getContext());
            this.Jp.mId = f.action_menu_presenter;
        }
        this.Jp.bp = aVar;
        Toolbar toolbar = this.dT;
        android.support.v7.view.menu.f fVar = (android.support.v7.view.menu.f) menu;
        l lVar = this.Jp;
        if (fVar != null || toolbar.Jo != null) {
            toolbar.hc();
            android.support.v7.view.menu.f fVar2 = toolbar.Jo.bq;
            if (fVar2 != fVar) {
                if (fVar2 != null) {
                    fVar2.b(toolbar.WY);
                    fVar2.b(toolbar.WZ);
                }
                if (toolbar.WZ == null) {
                    toolbar.WZ = new a(toolbar, (byte) 0);
                }
                lVar.Kz = true;
                if (fVar != null) {
                    fVar.a(lVar, toolbar.Jn);
                    fVar.a(toolbar.WZ, toolbar.Jn);
                } else {
                    lVar.a(toolbar.Jn, null);
                    toolbar.WZ.a(toolbar.Jn, null);
                    lVar.n(true);
                    toolbar.WZ.n(true);
                }
                toolbar.Jo.setPopupTheme(toolbar.KP);
                toolbar.Jo.setPresenter(lVar);
                toolbar.WY = lVar;
            }
        }
    }

    public final void dismissPopupMenus() {
        Toolbar toolbar = this.dT;
        if (toolbar.Jo != null) {
            toolbar.Jo.dismissPopupMenus();
        }
    }

    public final int getDisplayOptions() {
        return this.Xh;
    }

    public final void setDisplayOptions(int i) {
        int i2 = this.Xh ^ i;
        this.Xh = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    hh();
                    hg();
                } else {
                    this.dT.setNavigationIcon(null);
                }
            }
            if ((i2 & 3) != 0) {
                hf();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.dT.setTitle(this.sn);
                    this.dT.setSubtitle(this.so);
                } else {
                    this.dT.setTitle(null);
                    this.dT.setSubtitle(null);
                }
            }
            if ((i2 & 16) != 0 && this.hZ != null) {
                if ((i & 16) != 0) {
                    this.dT.addView(this.hZ);
                } else {
                    this.dT.removeView(this.hZ);
                }
            }
        }
    }

    public final void a(ai aiVar) {
        if (this.Xi != null && this.Xi.getParent() == this.dT) {
            this.dT.removeView(this.Xi);
        }
        this.Xi = aiVar;
        if (aiVar != null && this.Xo == 2) {
            this.dT.addView(this.Xi, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.Xi.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.gravity = 8388691;
            aiVar.setAllowCollapse(true);
        }
    }

    public final void setCollapsible(boolean z) {
        this.dT.setCollapsible(z);
    }

    public final int getNavigationMode() {
        return this.Xo;
    }

    public final void setCustomView(View view) {
        if (!(this.hZ == null || (this.Xh & 16) == 0)) {
            this.dT.removeView(this.hZ);
        }
        this.hZ = view;
        if (view != null && (this.Xh & 16) != 0) {
            this.dT.addView(this.hZ);
        }
    }

    public final View getCustomView() {
        return this.hZ;
    }

    public final ai c(final int i, long j) {
        return z.U(this.dT).t(i == 0 ? 1.0f : 0.0f).h(j).a(new an() {
            private boolean Ju = false;

            public final void p(View view) {
                aq.this.dT.setVisibility(0);
            }

            public final void q(View view) {
                if (!this.Ju) {
                    aq.this.dT.setVisibility(i);
                }
            }

            public final void ar(View view) {
                this.Ju = true;
            }
        });
    }

    public final void setNavigationContentDescription(int i) {
        this.Xm = i == 0 ? null : this.dT.getContext().getString(i);
        hg();
    }

    private void hg() {
        if ((this.Xh & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.Xm)) {
            this.dT.setNavigationContentDescription(this.Xp);
        } else {
            this.dT.setNavigationContentDescription(this.Xm);
        }
    }

    private void hh() {
        if ((this.Xh & 4) != 0) {
            this.dT.setNavigationIcon(this.Xk != null ? this.Xk : this.Xq);
        }
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.dT.setBackgroundDrawable(drawable);
    }

    public final int getHeight() {
        return this.dT.getHeight();
    }

    public final void setVisibility(int i) {
        this.dT.setVisibility(i);
    }

    public final int getVisibility() {
        return this.dT.getVisibility();
    }

    public final void a(l.a aVar, android.support.v7.view.menu.f.a aVar2) {
        Toolbar toolbar = this.dT;
        toolbar.KR = aVar;
        toolbar.KS = aVar2;
        if (toolbar.Jo != null) {
            toolbar.Jo.a(aVar, aVar2);
        }
    }

    public final Menu getMenu() {
        return this.dT.getMenu();
    }
}
