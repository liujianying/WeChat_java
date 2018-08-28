package com.tencent.mm.ui;

import android.support.v7.app.ActionBar;
import android.support.v7.view.f;
import android.support.v7.view.g;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.ui.b.b;
import com.tencent.mm.ui.b.b.a;

public final class t extends s implements a {
    private ActionBar mActionBar;
    public x tnu = null;
    public b tnv;

    public final ActionMode startActionMode(Callback callback) {
        com.tencent.mm.ui.b.a aVar = this.tnv;
        Object aVar2 = new f.a(aVar.mActivity, callback);
        if (aVar.Ez != null) {
            aVar.Ez.finish();
        }
        android.support.v7.view.b.a aVar3 = new a(aVar2);
        ActionBar supportActionBar = aVar.getSupportActionBar();
        if (supportActionBar != null) {
            aVar.Ez = supportActionBar.a(aVar3);
        }
        android.support.v7.view.b bVar = aVar.Ez;
        return bVar != null ? aVar2.b(bVar) : null;
    }

    protected final int getLayoutId() {
        if (this.tnu != null) {
            return this.tnu.getLayoutId();
        }
        return -1;
    }

    protected final void dealContentView(View view) {
        if (this.tnu != null) {
            this.tnu.dealContentView(view);
        }
    }

    protected final String aYS() {
        if (this.tnu != null) {
            return this.tnu.getIdentityString();
        }
        return null;
    }

    protected final View getLayoutView() {
        if (this.tnu != null) {
            return this.tnu.getLayoutView();
        }
        return null;
    }

    public final void onKeyboardStateChanged() {
        if (this.tnu != null) {
            this.tnu.onKeyboardStateChanged();
        }
    }

    protected final void onCreateBeforeSetContentView() {
        if (this.tnu != null) {
            this.tnu.onCreateBeforeSetContentView();
        }
    }

    protected final String getClassName() {
        return this.tnu.getClass().getName();
    }

    protected final boolean cpZ() {
        return false;
    }

    public final ActionBar getSupportActionBar() {
        if (this.mActionBar == null) {
            this.mActionBar = this.tnv.cqY();
        }
        return this.mActionBar;
    }

    public final boolean interceptSupportInvalidateOptionsMenu() {
        return true;
    }

    public final void supportInvalidateOptionsMenu() {
        this.tnv.supportInvalidateOptionsMenu();
    }

    public final boolean c(Menu menu) {
        if (this.tnu != null) {
            this.tnu.onPrepareOptionsMenu(menu);
        }
        return true;
    }

    public final boolean d(Menu menu) {
        x xVar = this.tnu;
        com.tencent.mm.ui.b.a aVar = this.tnv;
        if (aVar.gh == null) {
            ActionBar supportActionBar = aVar.getSupportActionBar();
            if (supportActionBar != null) {
                aVar.gh = new g(supportActionBar.getThemedContext());
            } else {
                aVar.gh = new g(aVar.mActivity);
            }
        }
        xVar.onCreateOptionsMenu(menu, aVar.gh);
        return true;
    }

    public final boolean j(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }
}
