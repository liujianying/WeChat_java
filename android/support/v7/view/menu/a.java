package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.c.a.b;
import android.support.v4.view.d;
import android.support.v4.view.m.e;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

public final class a implements b {
    private final int Hm;
    private final int Hn;
    private final int Ho;
    private CharSequence Hp;
    private Intent Hq;
    private char Hr;
    private char Hs;
    private Drawable Ht;
    private int Hu = 0;
    private OnMenuItemClickListener Hv;
    private Context mContext;
    private final int mId;
    private int rJ = 16;
    private CharSequence sn;

    public final /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public a(Context context, CharSequence charSequence) {
        this.mContext = context;
        this.mId = 16908332;
        this.Hm = 0;
        this.Hn = 0;
        this.Ho = 0;
        this.sn = charSequence;
    }

    public final char getAlphabeticShortcut() {
        return this.Hs;
    }

    public final int getGroupId() {
        return this.Hm;
    }

    public final Drawable getIcon() {
        return this.Ht;
    }

    public final Intent getIntent() {
        return this.Hq;
    }

    public final int getItemId() {
        return this.mId;
    }

    public final ContextMenuInfo getMenuInfo() {
        return null;
    }

    public final char getNumericShortcut() {
        return this.Hr;
    }

    public final int getOrder() {
        return this.Ho;
    }

    public final SubMenu getSubMenu() {
        return null;
    }

    public final CharSequence getTitle() {
        return this.sn;
    }

    public final CharSequence getTitleCondensed() {
        return this.Hp != null ? this.Hp : this.sn;
    }

    public final boolean hasSubMenu() {
        return false;
    }

    public final boolean isCheckable() {
        return (this.rJ & 1) != 0;
    }

    public final boolean isChecked() {
        return (this.rJ & 2) != 0;
    }

    public final boolean isEnabled() {
        return (this.rJ & 16) != 0;
    }

    public final boolean isVisible() {
        return (this.rJ & 8) == 0;
    }

    public final MenuItem setAlphabeticShortcut(char c) {
        this.Hs = c;
        return this;
    }

    public final MenuItem setCheckable(boolean z) {
        this.rJ = (z ? 1 : 0) | (this.rJ & -2);
        return this;
    }

    public final MenuItem setChecked(boolean z) {
        this.rJ = (z ? 2 : 0) | (this.rJ & -3);
        return this;
    }

    public final MenuItem setEnabled(boolean z) {
        this.rJ = (z ? 16 : 0) | (this.rJ & -17);
        return this;
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.Ht = drawable;
        this.Hu = 0;
        return this;
    }

    public final MenuItem setIcon(int i) {
        this.Hu = i;
        this.Ht = android.support.v4.content.a.f(this.mContext, i);
        return this;
    }

    public final MenuItem setIntent(Intent intent) {
        this.Hq = intent;
        return this;
    }

    public final MenuItem setNumericShortcut(char c) {
        this.Hr = c;
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.Hv = onMenuItemClickListener;
        return this;
    }

    public final MenuItem setShortcut(char c, char c2) {
        this.Hr = c;
        this.Hs = c2;
        return this;
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.sn = charSequence;
        return this;
    }

    public final MenuItem setTitle(int i) {
        this.sn = this.mContext.getResources().getString(i);
        return this;
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.Hp = charSequence;
        return this;
    }

    public final MenuItem setVisible(boolean z) {
        this.rJ = (z ? 0 : 8) | (this.rJ & 8);
        return this;
    }

    public final void setShowAsAction(int i) {
    }

    public final View getActionView() {
        return null;
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public final d bJ() {
        return null;
    }

    public final b a(d dVar) {
        throw new UnsupportedOperationException();
    }

    public final boolean expandActionView() {
        return false;
    }

    public final boolean collapseActionView() {
        return false;
    }

    public final boolean isActionViewExpanded() {
        return false;
    }

    public final MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public final b a(e eVar) {
        return this;
    }
}
