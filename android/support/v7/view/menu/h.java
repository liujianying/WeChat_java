package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.c.a.b;
import android.support.v4.view.d;
import android.support.v4.view.m.e;
import android.support.v7.view.menu.m.a;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;

public final class h implements b {
    static String IL;
    static String IM;
    static String IN;
    static String IO;
    private final int Hm;
    private final int Hn;
    final int Ho;
    private CharSequence Hp;
    private Intent Hq;
    private char Hr;
    private char Hs;
    private Drawable Ht;
    private int Hu = 0;
    private OnMenuItemClickListener Hv;
    private p IC;
    private Runnable IE;
    int IF = 0;
    private View IG;
    public d IH;
    private e II;
    private boolean IJ = false;
    ContextMenuInfo IK;
    f bq;
    private final int mId;
    private int rJ = 16;
    private CharSequence sn;

    public final /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    h(f fVar, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.bq = fVar;
        this.mId = i2;
        this.Hm = i;
        this.Hn = i3;
        this.Ho = i4;
        this.sn = charSequence;
        this.IF = i5;
    }

    public final boolean dR() {
        if ((this.Hv != null && this.Hv.onMenuItemClick(this)) || this.bq.b(this.bq.dQ(), (MenuItem) this)) {
            return true;
        }
        if (this.IE != null) {
            this.IE.run();
            return true;
        }
        if (this.Hq != null) {
            try {
                this.bq.mContext.startActivity(this.Hq);
                return true;
            } catch (ActivityNotFoundException e) {
            }
        }
        if (this.IH == null || !this.IH.onPerformDefaultAction()) {
            return false;
        }
        return true;
    }

    public final boolean isEnabled() {
        return (this.rJ & 16) != 0;
    }

    public final MenuItem setEnabled(boolean z) {
        if (z) {
            this.rJ |= 16;
        } else {
            this.rJ &= -17;
        }
        this.bq.p(false);
        return this;
    }

    public final int getGroupId() {
        return this.Hm;
    }

    @CapturedViewProperty
    public final int getItemId() {
        return this.mId;
    }

    public final int getOrder() {
        return this.Hn;
    }

    public final Intent getIntent() {
        return this.Hq;
    }

    public final MenuItem setIntent(Intent intent) {
        this.Hq = intent;
        return this;
    }

    public final char getAlphabeticShortcut() {
        return this.Hs;
    }

    public final MenuItem setAlphabeticShortcut(char c) {
        if (this.Hs != c) {
            this.Hs = Character.toLowerCase(c);
            this.bq.p(false);
        }
        return this;
    }

    public final char getNumericShortcut() {
        return this.Hr;
    }

    public final MenuItem setNumericShortcut(char c) {
        if (this.Hr != c) {
            this.Hr = c;
            this.bq.p(false);
        }
        return this;
    }

    public final MenuItem setShortcut(char c, char c2) {
        this.Hr = c;
        this.Hs = Character.toLowerCase(c2);
        this.bq.p(false);
        return this;
    }

    final char dS() {
        return this.bq.dH() ? this.Hs : this.Hr;
    }

    final boolean dT() {
        return this.bq.dI() && dS() != 0;
    }

    public final SubMenu getSubMenu() {
        return this.IC;
    }

    public final boolean hasSubMenu() {
        return this.IC != null;
    }

    public final void b(p pVar) {
        this.IC = pVar;
        pVar.setHeaderTitle(getTitle());
    }

    @CapturedViewProperty
    public final CharSequence getTitle() {
        return this.sn;
    }

    final CharSequence a(a aVar) {
        return (aVar == null || !aVar.M()) ? getTitle() : getTitleCondensed();
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.sn = charSequence;
        this.bq.p(false);
        if (this.IC != null) {
            this.IC.setHeaderTitle(charSequence);
        }
        return this;
    }

    public final MenuItem setTitle(int i) {
        return setTitle(this.bq.mContext.getString(i));
    }

    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.Hp != null ? this.Hp : this.sn;
        if (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) {
            return charSequence;
        }
        return charSequence.toString();
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.Hp = charSequence;
        this.bq.p(false);
        return this;
    }

    public final Drawable getIcon() {
        if (this.Ht != null) {
            return this.Ht;
        }
        if (this.Hu == 0) {
            return null;
        }
        Drawable a = android.support.v7.widget.h.eJ().a(this.bq.mContext, this.Hu, false);
        this.Hu = 0;
        this.Ht = a;
        return a;
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.Hu = 0;
        this.Ht = drawable;
        this.bq.p(false);
        return this;
    }

    public final MenuItem setIcon(int i) {
        this.Ht = null;
        this.Hu = i;
        this.bq.p(false);
        return this;
    }

    public final boolean isCheckable() {
        return (this.rJ & 1) == 1;
    }

    public final MenuItem setCheckable(boolean z) {
        int i = this.rJ;
        this.rJ = (z ? 1 : 0) | (this.rJ & -2);
        if (i != this.rJ) {
            this.bq.p(false);
        }
        return this;
    }

    public final void K(boolean z) {
        this.rJ = (z ? 4 : 0) | (this.rJ & -5);
    }

    public final boolean dU() {
        return (this.rJ & 4) != 0;
    }

    public final boolean isChecked() {
        return (this.rJ & 2) == 2;
    }

    public final MenuItem setChecked(boolean z) {
        if ((this.rJ & 4) != 0) {
            f fVar = this.bq;
            int groupId = getGroupId();
            int size = fVar.bA.size();
            for (int i = 0; i < size; i++) {
                h hVar = (h) fVar.bA.get(i);
                if (hVar.getGroupId() == groupId && hVar.dU() && hVar.isCheckable()) {
                    hVar.L(hVar == this);
                }
            }
        } else {
            L(z);
        }
        return this;
    }

    private void L(boolean z) {
        int i;
        int i2 = this.rJ;
        int i3 = this.rJ & -3;
        if (z) {
            i = 2;
        } else {
            i = 0;
        }
        this.rJ = i | i3;
        if (i2 != this.rJ) {
            this.bq.p(false);
        }
    }

    public final boolean isVisible() {
        if (this.IH == null || !this.IH.overridesItemVisibility()) {
            if ((this.rJ & 8) != 0) {
                return false;
            }
            return true;
        } else if ((this.rJ & 8) == 0 && this.IH.isVisible()) {
            return true;
        } else {
            return false;
        }
    }

    final boolean M(boolean z) {
        int i = this.rJ;
        this.rJ = (z ? 0 : 8) | (this.rJ & -9);
        if (i != this.rJ) {
            return true;
        }
        return false;
    }

    public final MenuItem setVisible(boolean z) {
        if (M(z)) {
            this.bq.dL();
        }
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.Hv = onMenuItemClickListener;
        return this;
    }

    public final String toString() {
        return this.sn != null ? this.sn.toString() : null;
    }

    public final ContextMenuInfo getMenuInfo() {
        return this.IK;
    }

    public final boolean dV() {
        return (this.rJ & 32) == 32;
    }

    public final boolean dW() {
        return (this.IF & 1) == 1;
    }

    public final boolean dX() {
        return (this.IF & 2) == 2;
    }

    public final void N(boolean z) {
        if (z) {
            this.rJ |= 32;
        } else {
            this.rJ &= -33;
        }
    }

    public final void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.IF = i;
                this.bq.dM();
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    private b aJ(View view) {
        this.IG = view;
        this.IH = null;
        if (view != null && view.getId() == -1 && this.mId > 0) {
            view.setId(this.mId);
        }
        this.bq.dM();
        return this;
    }

    public final View getActionView() {
        if (this.IG != null) {
            return this.IG;
        }
        if (this.IH == null) {
            return null;
        }
        this.IG = this.IH.onCreateActionView(this);
        return this.IG;
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public final d bJ() {
        return this.IH;
    }

    public final b a(d dVar) {
        if (this.IH != null) {
            d dVar2 = this.IH;
            dVar2.ue = null;
            dVar2.ud = null;
        }
        this.IG = null;
        this.IH = dVar;
        this.bq.p(true);
        if (this.IH != null) {
            this.IH.a(new d.b() {
                public final void ca() {
                    h.this.bq.dL();
                }
            });
        }
        return this;
    }

    public final boolean expandActionView() {
        if (!dY()) {
            return false;
        }
        if (this.II == null || this.II.onMenuItemActionExpand(this)) {
            return this.bq.g(this);
        }
        return false;
    }

    public final boolean collapseActionView() {
        if ((this.IF & 8) == 0) {
            return false;
        }
        if (this.IG == null) {
            return true;
        }
        if (this.II == null || this.II.onMenuItemActionCollapse(this)) {
            return this.bq.h(this);
        }
        return false;
    }

    public final b a(e eVar) {
        this.II = eVar;
        return this;
    }

    public final boolean dY() {
        if ((this.IF & 8) == 0) {
            return false;
        }
        if (this.IG == null && this.IH != null) {
            this.IG = this.IH.onCreateActionView(this);
        }
        if (this.IG != null) {
            return true;
        }
        return false;
    }

    public final void O(boolean z) {
        this.IJ = z;
        this.bq.p(false);
    }

    public final boolean isActionViewExpanded() {
        return this.IJ;
    }

    public final MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }
}
