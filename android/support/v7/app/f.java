package android.support.v7.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.view.g;
import android.support.v7.view.i;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;

abstract class f extends e {
    final Window CS;
    final Callback Ef = this.CS.getCallback();
    final Callback Eg;
    final d Eh;
    boolean Ei;
    boolean Ej;
    boolean Ek;
    boolean El;
    boolean Em;
    boolean En;
    MenuInflater gh;
    ActionBar mActionBar;
    final Context mContext;
    CharSequence sn;

    private class a implements android.support.v7.app.a.a {
        private a() {
        }

        /* synthetic */ a(f fVar, byte b) {
            this();
        }

        public final void aD(int i) {
            ActionBar supportActionBar = f.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeActionContentDescription(i);
            }
        }
    }

    class b extends i {
        b(Callback callback) {
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return f.this.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || f.this.onKeyShortcut(keyEvent.getKeyCode(), keyEvent);
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof android.support.v7.view.menu.f)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public void onContentChanged() {
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            android.support.v7.view.menu.f fVar;
            if (menu instanceof android.support.v7.view.menu.f) {
                fVar = (android.support.v7.view.menu.f) menu;
            } else {
                fVar = null;
            }
            if (i == 0 && fVar == null) {
                return false;
            }
            if (fVar != null) {
                fVar.Iy = true;
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (fVar == null) {
                return onPreparePanel;
            }
            fVar.Iy = false;
            return onPreparePanel;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            f.this.aF(i);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            f.this.aE(i);
        }
    }

    abstract void aE(int i);

    abstract boolean aF(int i);

    abstract android.support.v7.view.b b(android.support.v7.view.b.a aVar);

    abstract void dh();

    abstract boolean dispatchKeyEvent(KeyEvent keyEvent);

    abstract void f(CharSequence charSequence);

    abstract boolean onKeyShortcut(int i, KeyEvent keyEvent);

    f(Context context, Window window, d dVar) {
        this.mContext = context;
        this.CS = window;
        this.Eh = dVar;
        if (this.Ef instanceof b) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.Eg = a(this.Ef);
        this.CS.setCallback(this.Eg);
    }

    Callback a(Callback callback) {
        return new b(callback);
    }

    public final ActionBar getSupportActionBar() {
        dh();
        return this.mActionBar;
    }

    public final MenuInflater getMenuInflater() {
        if (this.gh == null) {
            dh();
            this.gh = new g(this.mActionBar != null ? this.mActionBar.getThemedContext() : this.mContext);
        }
        return this.gh;
    }

    public final android.support.v7.app.a.a getDrawerToggleDelegate() {
        return new a(this, (byte) 0);
    }

    final Context di() {
        Context context = null;
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            context = supportActionBar.getThemedContext();
        }
        if (context == null) {
            return this.mContext;
        }
        return context;
    }

    public void onDestroy() {
        this.En = true;
    }

    public boolean df() {
        return false;
    }

    public final void setTitle(CharSequence charSequence) {
        this.sn = charSequence;
        f(charSequence);
    }

    public void onSaveInstanceState(Bundle bundle) {
    }
}
