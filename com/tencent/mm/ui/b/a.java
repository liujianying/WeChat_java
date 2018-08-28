package com.tencent.mm.ui.b;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.view.b;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public abstract class a {
    public b Ez = null;
    public MenuInflater gh;
    public ActionBar mActionBar;
    public final Activity mActivity;

    class a implements android.support.v7.view.b.a {
        private android.support.v7.view.b.a EU;

        public a(android.support.v7.view.b.a aVar) {
            this.EU = aVar;
        }

        public final boolean a(b bVar, Menu menu) {
            return this.EU.a(bVar, menu);
        }

        public final boolean b(b bVar, Menu menu) {
            return this.EU.b(bVar, menu);
        }

        public final boolean a(b bVar, MenuItem menuItem) {
            return this.EU.a(bVar, menuItem);
        }

        public final void a(b bVar) {
            this.EU.a(bVar);
            a.this.Ez = null;
        }
    }

    abstract ActionBar cqY();

    public a(Activity activity) {
        this.mActivity = activity;
    }

    public final ActionBar getSupportActionBar() {
        if (this.mActionBar == null) {
            this.mActionBar = cqY();
        }
        return this.mActionBar;
    }
}
