package com.tencent.mm.plugin.game.ui;

import android.annotation.TargetApi;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.a;
import android.support.v7.app.ActionBar;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowInsets;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.game.d.db;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.f.b;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.w.a.k;

public abstract class GameCenterActivity extends GameBaseActivity {
    protected int gwO;
    protected View jUX;
    protected View jUY;
    protected int jUZ = 0;
    protected String jVa = null;
    private db jVb;
    protected ActionBar mActionBar;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mActionBar = getSupportActionBar();
        this.jVb = h.aTL().aTN();
        if (this.jVb != null) {
            this.jUZ = c.parseColor(this.jVb.dxh);
            this.jVa = this.jVb.jOk;
        }
        try {
            this.jUX = this.mController.contentView;
            if (this.jUX != null) {
                aUQ();
                ((ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0)).addOnLayoutChangeListener(new 1(this));
            }
        } catch (Exception e) {
            x.e("MicroMsg.GameCenterActivity", "fixContentMargin error : %s", new Object[]{e.getMessage()});
        }
        try {
            if (d.fR(21)) {
                ViewGroup viewGroup = (ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0);
                viewGroup.setOnApplyWindowInsetsListener(new 2(this, viewGroup));
                return;
            }
            ((ViewGroup) getWindow().getDecorView()).setFitsSystemWindows(true);
        } catch (Exception e2) {
            x.e("MicroMsg.GameCenterActivity", "tryToExpandToStatusBar error : %s", new Object[]{e2.getMessage()});
        }
    }

    protected final void onCreateBeforeSetContentView() {
        supportRequestWindowFeature(5);
        supportRequestWindowFeature(9);
        setProgressBarIndeterminateVisibility(false);
    }

    protected final void aUQ() {
        if (this.jUX != null) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.jUX.getLayoutParams();
            int height = (this.mActionBar != null ? this.mActionBar.getHeight() : 0) + this.gwO;
            if (height != marginLayoutParams.topMargin) {
                marginLayoutParams.topMargin = height;
                this.jUX.setLayoutParams(marginLayoutParams);
            }
        }
    }

    @TargetApi(21)
    protected final void a(ViewGroup viewGroup, WindowInsets windowInsets) {
        if (this.gwO != windowInsets.getSystemWindowInsetTop()) {
            View viewGroup2;
            this.gwO = windowInsets.getSystemWindowInsetTop();
            aUQ();
            if (viewGroup2 instanceof SwipeBackLayout) {
                viewGroup2 = viewGroup2.getChildAt(0);
            }
            int i = e.action_bar_container;
            if (i > 0) {
                View findViewById = viewGroup2.findViewById(i);
                if (findViewById != null) {
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) findViewById.getLayoutParams();
                    marginLayoutParams.topMargin = windowInsets.getSystemWindowInsetTop();
                    findViewById.setLayoutParams(marginLayoutParams);
                    findViewById.requestLayout();
                }
            }
            x.i("MicroMsg.GameCenterActivity", "setInitialStatusBarStyle");
            if (!d.fR(21)) {
                return;
            }
            if (this.jUZ != 0) {
                lF(this.jUZ);
                if (aUR()) {
                    x.i("MicroMsg.GameCenterActivity", "setBackBtnColorFilter");
                    cqf();
                }
                i = this.jUZ;
                boolean aUR = aUR();
                if (VERSION.SDK_INT >= 23 && !com.tencent.mm.compatible.util.h.Ae()) {
                    setStatusBarColor(i);
                    Window window = getWindow();
                    i = window.getDecorView().getSystemUiVisibility();
                    window.getDecorView().setSystemUiVisibility(aUR ? i | 8192 : i & -8193);
                    return;
                } else if (VERSION.SDK_INT >= 21) {
                    if (aUR) {
                        i = ak.AD(i);
                    }
                    setStatusBarColor(i);
                    return;
                } else {
                    return;
                }
            }
            setStatusBarColor(an.n(getResources().getColor(b.statusbar_fg_color), this.mController.cqm()));
        }
    }

    public final void setBackBtn(OnMenuItemClickListener onMenuItemClickListener, int i) {
        x.i("MicroMsg.GameCenterActivity", "setBackBtn");
        super.setBackBtn(onMenuItemClickListener, i);
        if (d.fR(21) && aUR()) {
            x.i("MicroMsg.GameCenterActivity", "setBackBtn, setBackBtnColorFilter");
            cqf();
        }
    }

    public final void setBackBtn(OnMenuItemClickListener onMenuItemClickListener) {
        x.i("MicroMsg.GameCenterActivity", "setBackBtn");
        super.setBackBtn(onMenuItemClickListener, 0);
        if (d.fR(21) && aUR()) {
            x.i("MicroMsg.GameCenterActivity", "setBackBtn, setBackBtnColorFilter");
            cqf();
        }
    }

    @TargetApi(21)
    private void setStatusBarColor(int i) {
        if (this.gwO > 0 && !d.fS(21)) {
            getWindow().setStatusBarColor(0);
            if (this.jUY == null) {
                this.jUY = new View(this);
                this.jUY.setId(e.game_action_btn);
                ((ViewGroup) findViewById(16908290)).addView(this.jUY, new LayoutParams(-1, this.gwO));
            } else {
                LayoutParams layoutParams = this.jUY.getLayoutParams();
                if (layoutParams.height != this.gwO) {
                    layoutParams.height = this.gwO;
                    this.jUY.setLayoutParams(layoutParams);
                }
            }
            this.jUY.setBackgroundColor(i);
        }
    }

    private boolean aUR() {
        if (bi.oW(this.jVa) || !this.jVa.equals("black")) {
            return false;
        }
        return true;
    }

    public final void setMMTitle(int i) {
        super.setMMTitle(i);
        if (d.fR(21) && aUR()) {
            nS(-16777216);
        }
    }

    public final void addTextOptionMenu(int i, String str, OnMenuItemClickListener onMenuItemClickListener) {
        if (d.fR(21) && aUR()) {
            a(i, str, -16777216, onMenuItemClickListener);
        } else {
            super.addTextOptionMenu(i, str, onMenuItemClickListener);
        }
    }

    public final void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        if (d.fR(21)) {
            Drawable f = a.f(this, i2);
            if (f != null) {
                if (aUR()) {
                    f.setColorFilter(-16777216, Mode.SRC_ATOP);
                } else {
                    f.clearColorFilter();
                }
                a(i, getString(k.app_more), f, onMenuItemClickListener);
                return;
            }
            return;
        }
        super.addIconOptionMenu(i, i2, onMenuItemClickListener);
    }
}
