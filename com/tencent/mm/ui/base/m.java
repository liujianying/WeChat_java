package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

public final class m implements MenuItem {
    private int GG;
    private int GN;
    public String fIb;
    private int iconId;
    private Intent intent;
    public CharSequence jyi = null;
    private Context mContext;
    public boolean spC = false;
    private CharSequence title;
    private int twc;
    private Drawable twd;
    public ContextMenuInfo twe;
    private OnMenuItemClickListener twf;

    public m(Context context, int i, int i2) {
        this.mContext = context;
        this.GN = i;
        this.GG = i2;
    }

    public final int getItemId() {
        return this.GN;
    }

    public final int getGroupId() {
        return this.GG;
    }

    public final int getOrder() {
        return 0;
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.title = charSequence;
        return this;
    }

    public final MenuItem setTitle(int i) {
        this.twc = i;
        return this;
    }

    public final CharSequence getTitle() {
        if (this.title != null) {
            return this.title;
        }
        if (this.twc == 0 || this.mContext == null) {
            return null;
        }
        return this.mContext.getString(this.twc);
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        return this;
    }

    public final CharSequence getTitleCondensed() {
        return null;
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.twd = drawable;
        return this;
    }

    public final MenuItem setIcon(int i) {
        this.iconId = i;
        return this;
    }

    public final Drawable getIcon() {
        if (this.twd != null) {
            return this.twd;
        }
        if (this.iconId == 0 || this.mContext == null) {
            return null;
        }
        return this.mContext.getResources().getDrawable(this.iconId);
    }

    public final MenuItem setIntent(Intent intent) {
        this.intent = intent;
        return this;
    }

    public final Intent getIntent() {
        return this.intent;
    }

    public final MenuItem setShortcut(char c, char c2) {
        return this;
    }

    public final MenuItem setNumericShortcut(char c) {
        return this;
    }

    public final char getNumericShortcut() {
        return 0;
    }

    public final MenuItem setAlphabeticShortcut(char c) {
        return this;
    }

    public final char getAlphabeticShortcut() {
        return 0;
    }

    public final MenuItem setCheckable(boolean z) {
        return this;
    }

    public final boolean isCheckable() {
        return false;
    }

    public final MenuItem setChecked(boolean z) {
        return this;
    }

    public final boolean isChecked() {
        return false;
    }

    public final MenuItem setVisible(boolean z) {
        return this;
    }

    public final boolean isVisible() {
        return true;
    }

    public final MenuItem setEnabled(boolean z) {
        return this;
    }

    public final boolean isEnabled() {
        return true;
    }

    public final boolean hasSubMenu() {
        return false;
    }

    public final SubMenu getSubMenu() {
        return null;
    }

    public final MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.twf = onMenuItemClickListener;
        return this;
    }

    public final boolean performClick() {
        if (this.twf != null) {
            return this.twf.onMenuItemClick(this);
        }
        return false;
    }

    public final ContextMenuInfo getMenuInfo() {
        return this.twe;
    }

    public final boolean collapseActionView() {
        return false;
    }

    public final boolean expandActionView() {
        return false;
    }

    public final ActionProvider getActionProvider() {
        return null;
    }

    public final View getActionView() {
        return null;
    }

    public final boolean isActionViewExpanded() {
        return false;
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        return null;
    }

    public final MenuItem setActionView(View view) {
        return null;
    }

    public final MenuItem setActionView(int i) {
        return null;
    }

    public final MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        return null;
    }

    public final void setShowAsAction(int i) {
    }

    public final MenuItem setShowAsActionFlags(int i) {
        return null;
    }
}
