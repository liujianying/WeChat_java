package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.v4.view.z;
import android.support.v7.a.a.h;
import android.support.v7.a.a.j;
import android.support.v7.view.i;
import android.support.v7.view.menu.e;
import android.support.v7.view.menu.f;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.aq;
import android.support.v7.widget.u;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import java.util.ArrayList;

final class l extends ActionBar {
    private final android.support.v7.widget.Toolbar.b FA = new android.support.v7.widget.Toolbar.b() {
        public final boolean onMenuItemClick(MenuItem menuItem) {
            return l.this.Fu.onMenuItemSelected(0, menuItem);
        }
    };
    u Fs;
    boolean Ft;
    Callback Fu;
    private boolean Fv;
    private boolean Fw;
    private ArrayList<Object> Fx = new ArrayList();
    e Fy;
    private final Runnable Fz = new Runnable() {
        public final void run() {
            f fVar;
            l lVar = l.this;
            Menu menu = lVar.getMenu();
            if (menu instanceof f) {
                fVar = (f) menu;
            } else {
                fVar = null;
            }
            if (fVar != null) {
                fVar.dJ();
            }
            try {
                menu.clear();
                if (!(lVar.Fu.onCreatePanelMenu(0, menu) && lVar.Fu.onPreparePanel(0, null, menu))) {
                    menu.clear();
                }
                if (fVar != null) {
                    fVar.dK();
                }
            } catch (Throwable th) {
                if (fVar != null) {
                    fVar.dK();
                }
            }
        }
    };

    private final class a implements android.support.v7.view.menu.l.a {
        private boolean EJ;

        private a() {
        }

        /* synthetic */ a(l lVar, byte b) {
            this();
        }

        public final boolean d(f fVar) {
            if (l.this.Fu == null) {
                return false;
            }
            l.this.Fu.onMenuOpened(108, fVar);
            return true;
        }

        public final void a(f fVar, boolean z) {
            if (!this.EJ) {
                this.EJ = true;
                l.this.Fs.dismissPopupMenus();
                if (l.this.Fu != null) {
                    l.this.Fu.onPanelClosed(108, fVar);
                }
                this.EJ = false;
            }
        }
    }

    private final class b implements android.support.v7.view.menu.f.a {
        private b() {
        }

        /* synthetic */ b(l lVar, byte b) {
            this();
        }

        public final boolean a(f fVar, MenuItem menuItem) {
            return false;
        }

        public final void b(f fVar) {
            if (l.this.Fu == null) {
                return;
            }
            if (l.this.Fs.isOverflowMenuShowing()) {
                l.this.Fu.onPanelClosed(108, fVar);
            } else if (l.this.Fu.onPreparePanel(0, null, fVar)) {
                l.this.Fu.onMenuOpened(108, fVar);
            }
        }
    }

    private final class c implements android.support.v7.view.menu.l.a {
        private c() {
        }

        /* synthetic */ c(l lVar, byte b) {
            this();
        }

        public final void a(f fVar, boolean z) {
            if (l.this.Fu != null) {
                l.this.Fu.onPanelClosed(0, fVar);
            }
        }

        public final boolean d(f fVar) {
            if (fVar == null && l.this.Fu != null) {
                l.this.Fu.onMenuOpened(0, fVar);
            }
            return true;
        }
    }

    private class d extends i {
        public d(Callback callback) {
            super(callback);
        }

        public final boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel && !l.this.Ft) {
                l.this.Fs.eh();
                l.this.Ft = true;
            }
            return onPreparePanel;
        }

        public final View onCreatePanelView(int i) {
            switch (i) {
                case 0:
                    Menu menu = l.this.Fs.getMenu();
                    if (onPreparePanel(i, null, menu) && onMenuOpened(i, menu)) {
                        l lVar = l.this;
                        if (lVar.Fy == null && (menu instanceof f)) {
                            f fVar = (f) menu;
                            Context context = lVar.Fs.getContext();
                            TypedValue typedValue = new TypedValue();
                            Theme newTheme = context.getResources().newTheme();
                            newTheme.setTo(context.getTheme());
                            newTheme.resolveAttribute(android.support.v7.a.a.a.actionBarPopupTheme, typedValue, true);
                            if (typedValue.resourceId != 0) {
                                newTheme.applyStyle(typedValue.resourceId, true);
                            }
                            newTheme.resolveAttribute(android.support.v7.a.a.a.panelMenuListTheme, typedValue, true);
                            if (typedValue.resourceId != 0) {
                                newTheme.applyStyle(typedValue.resourceId, true);
                            } else {
                                newTheme.applyStyle(j.Theme_AppCompat_CompactMenu, true);
                            }
                            Context contextThemeWrapper = new ContextThemeWrapper(context, 0);
                            contextThemeWrapper.getTheme().setTo(newTheme);
                            lVar.Fy = new e(contextThemeWrapper, h.abc_list_menu_item_layout);
                            lVar.Fy.bp = new c(lVar, (byte) 0);
                            fVar.a(lVar.Fy);
                        }
                        if (menu == null || lVar.Fy == null) {
                            return null;
                        }
                        return lVar.Fy.getAdapter().getCount() > 0 ? (View) lVar.Fy.e(lVar.Fs.eQ()) : null;
                    }
                    break;
            }
            return super.onCreatePanelView(i);
        }
    }

    public l(Toolbar toolbar, CharSequence charSequence, Callback callback) {
        this.Fs = new aq(toolbar, false);
        this.Fu = new d(callback);
        this.Fs.setWindowCallback(this.Fu);
        toolbar.setOnMenuItemClickListener(this.FA);
        this.Fs.setWindowTitle(charSequence);
    }

    public final void setCustomView(View view) {
        LayoutParams layoutParams = new ActionBar.LayoutParams();
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        this.Fs.setCustomView(view);
    }

    public final void setCustomView(int i) {
        setCustomView(LayoutInflater.from(this.Fs.getContext()).inflate(i, this.Fs.eQ(), false));
    }

    public final void setIcon(int i) {
        this.Fs.setIcon(i);
    }

    public final void setLogo(Drawable drawable) {
        this.Fs.setLogo(drawable);
    }

    public final void setElevation(float f) {
        z.g(this.Fs.eQ(), f);
    }

    public final Context getThemedContext() {
        return this.Fs.getContext();
    }

    public final void C(boolean z) {
    }

    public final void setHomeActionContentDescription(int i) {
        this.Fs.setNavigationContentDescription(i);
    }

    public final void D(boolean z) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
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
        setDisplayOptions(i, -1);
    }

    private void setDisplayOptions(int i, int i2) {
        this.Fs.setDisplayOptions((this.Fs.getDisplayOptions() & (i2 ^ -1)) | (i & i2));
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

    public final void setBackgroundDrawable(Drawable drawable) {
        this.Fs.setBackgroundDrawable(drawable);
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

    public final int getHeight() {
        return this.Fs.getHeight();
    }

    public final void show() {
        this.Fs.setVisibility(0);
    }

    public final void hide() {
        this.Fs.setVisibility(8);
    }

    public final boolean isShowing() {
        return this.Fs.getVisibility() == 0;
    }

    public final boolean dc() {
        this.Fs.eQ().removeCallbacks(this.Fz);
        z.a(this.Fs.eQ(), this.Fz);
        return true;
    }

    public final boolean collapseActionView() {
        if (!this.Fs.hasExpandedActionView()) {
            return false;
        }
        this.Fs.collapseActionView();
        return true;
    }

    public final boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        Menu menu = getMenu();
        if (menu != null) {
            boolean z;
            if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
                z = true;
            } else {
                z = false;
            }
            menu.setQwertyMode(z);
            menu.performShortcut(i, keyEvent, 0);
        }
        return true;
    }

    final void onDestroy() {
        this.Fs.eQ().removeCallbacks(this.Fz);
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

    final Menu getMenu() {
        if (!this.Fv) {
            this.Fs.a(new a(this, (byte) 0), new b(this, (byte) 0));
            this.Fv = true;
        }
        return this.Fs.getMenu();
    }
}
