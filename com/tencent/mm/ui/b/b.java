package com.tencent.mm.ui.b;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.view.menu.f;
import android.support.v7.widget.u;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

public final class b extends a implements android.support.v7.view.menu.f.a, android.support.v7.view.menu.l.a {
    public ViewGroup CK;
    private boolean EE;
    private f bq;
    a tqW;
    boolean tqX;
    private final Runnable tqY = new Runnable() {
        public final void run() {
            android.support.v7.view.menu.f.a aVar = b.this;
            Context context = aVar.mActivity;
            ActionBar supportActionBar = aVar.getSupportActionBar();
            if (supportActionBar != null) {
                context = supportActionBar.getThemedContext();
            }
            f fVar = new f(context);
            fVar.a(aVar);
            if (b.this.tqW != null) {
                b.this.tqW.d(fVar);
                b.this.tqW.c(fVar);
                b.a(b.this, fVar);
            } else {
                b.a(b.this, null);
            }
            fVar.p(true);
            b.this.tqX = false;
        }
    };

    public interface a {
        boolean c(Menu menu);

        boolean d(Menu menu);

        boolean j(MenuItem menuItem);
    }

    public b(Activity activity, a aVar) {
        super(activity);
        this.tqW = aVar;
    }

    public final ActionBar cqY() {
        if (!this.EE) {
            this.EE = true;
            supportInvalidateOptionsMenu();
        }
        if (this.mActionBar == null) {
            this.mActionBar = new d(this.mActivity, this.CK);
        }
        return this.mActionBar;
    }

    public final boolean a(f fVar, MenuItem menuItem) {
        if (this.tqW != null) {
            return this.tqW.j(menuItem);
        }
        return false;
    }

    public final void b(f fVar) {
        if (this.mActionBar != null) {
            u uVar = ((d) this.mActionBar).Fs;
            if (uVar != null && uVar.ef()) {
                if (uVar.isOverflowMenuShowing()) {
                    uVar.hideOverflowMenu();
                    return;
                } else if (uVar.getVisibility() == 0) {
                    uVar.showOverflowMenu();
                    return;
                } else {
                    return;
                }
            }
        }
        fVar.close();
    }

    public final void a(f fVar, boolean z) {
    }

    public final boolean d(f fVar) {
        return false;
    }

    public final void supportInvalidateOptionsMenu() {
        if (!this.tqX) {
            this.tqX = true;
            this.tqY.run();
        }
    }
}
