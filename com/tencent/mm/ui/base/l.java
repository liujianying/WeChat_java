package com.tencent.mm.ui.base;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class l implements ContextMenu {
    public CharSequence Io;
    private Context mContext;
    public List<MenuItem> twb = new ArrayList();

    public l(Context context) {
        this.mContext = context;
    }

    public final boolean crF() {
        return this.twb.size() == 0;
    }

    public final MenuItem add(int i, int i2, int i3, int i4) {
        MenuItem mVar = new m(this.mContext, i2, i);
        mVar.setTitle(i4);
        this.twb.add(mVar);
        return mVar;
    }

    public final MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        MenuItem mVar = new m(this.mContext, i2, i);
        mVar.setTitle(charSequence);
        this.twb.add(mVar);
        return mVar;
    }

    public final MenuItem add(int i) {
        MenuItem mVar = new m(this.mContext, 0, 0);
        mVar.setTitle(i);
        this.twb.add(mVar);
        return mVar;
    }

    public final MenuItem add(CharSequence charSequence) {
        MenuItem mVar = new m(this.mContext, 0, 0);
        mVar.setTitle(charSequence);
        this.twb.add(mVar);
        return mVar;
    }

    public final MenuItem ak(int i, int i2, int i3) {
        MenuItem mVar = new m(this.mContext, i, 0);
        mVar.setTitle(i2);
        mVar.setIcon(i3);
        this.twb.add(mVar);
        return mVar;
    }

    public final MenuItem a(int i, CharSequence charSequence, Drawable drawable) {
        MenuItem mVar = new m(this.mContext, i, 0);
        mVar.setTitle(charSequence);
        mVar.setIcon(drawable);
        this.twb.add(mVar);
        return mVar;
    }

    public final MenuItem a(int i, CharSequence charSequence, CharSequence charSequence2, Drawable drawable, boolean z) {
        MenuItem mVar = new m(this.mContext, i, 0);
        mVar.setTitle(charSequence);
        mVar.jyi = charSequence2;
        mVar.setIcon(drawable);
        mVar.spC = z;
        this.twb.add(mVar);
        return mVar;
    }

    public final MenuItem a(int i, CharSequence charSequence, int i2, boolean z) {
        MenuItem mVar = new m(this.mContext, i, 0);
        mVar.setTitle(charSequence);
        mVar.setIcon(i2);
        mVar.spC = z;
        this.twb.add(mVar);
        return mVar;
    }

    public final MenuItem a(int i, CharSequence charSequence, CharSequence charSequence2) {
        MenuItem mVar = new m(this.mContext, i, 0);
        mVar.setTitle(charSequence);
        mVar.jyi = charSequence2;
        mVar.setIcon(0);
        this.twb.add(mVar);
        return mVar;
    }

    public final MenuItem eR(int i, int i2) {
        MenuItem mVar = new m(this.mContext, i, 0);
        mVar.setTitle(i2);
        this.twb.add(mVar);
        return mVar;
    }

    public final MenuItem e(int i, CharSequence charSequence) {
        MenuItem mVar = new m(this.mContext, i, 0);
        mVar.setTitle(charSequence);
        this.twb.add(mVar);
        return mVar;
    }

    public final MenuItem a(int i, CharSequence charSequence, int i2) {
        MenuItem mVar = new m(this.mContext, i, 0);
        mVar.setTitle(charSequence);
        mVar.setIcon(i2);
        this.twb.add(mVar);
        return mVar;
    }

    public final MenuItem a(int i, int i2, CharSequence charSequence) {
        MenuItem mVar = new m(this.mContext, i, 0);
        CharSequence spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ForegroundColorSpan(i2), 0, spannableString.length(), 0);
        mVar.setTitle(spannableString);
        this.twb.add(mVar);
        return mVar;
    }

    public final SubMenu addSubMenu(CharSequence charSequence) {
        return null;
    }

    public final SubMenu addSubMenu(int i) {
        return null;
    }

    public final SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return null;
    }

    public final SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return null;
    }

    public final int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        return 0;
    }

    public final void removeItem(int i) {
        Collection arrayList = new ArrayList();
        for (MenuItem menuItem : this.twb) {
            if (menuItem.getItemId() == i) {
                arrayList.add(menuItem);
            }
        }
        this.twb.removeAll(arrayList);
    }

    public final void removeGroup(int i) {
    }

    public final void clear() {
        for (MenuItem menuItem : this.twb) {
            ((m) menuItem).twe = null;
            ((m) menuItem).setOnMenuItemClickListener(null);
        }
        this.twb.clear();
        this.Io = null;
    }

    public final void setGroupCheckable(int i, boolean z, boolean z2) {
    }

    public final void setGroupVisible(int i, boolean z) {
    }

    public final void setGroupEnabled(int i, boolean z) {
    }

    public final boolean hasVisibleItems() {
        return false;
    }

    public final MenuItem findItem(int i) {
        for (MenuItem menuItem : this.twb) {
            if (menuItem.getItemId() == i) {
                return menuItem;
            }
        }
        return null;
    }

    public final int size() {
        return this.twb == null ? 0 : this.twb.size();
    }

    public final MenuItem getItem(int i) {
        return (MenuItem) this.twb.get(i);
    }

    public final void close() {
    }

    public final boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return false;
    }

    public final boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return false;
    }

    public final boolean performIdentifierAction(int i, int i2) {
        return false;
    }

    public final void setQwertyMode(boolean z) {
    }

    public final ContextMenu setHeaderTitle(int i) {
        if (i > 0) {
            return setHeaderTitle(this.mContext.getString(i));
        }
        return this;
    }

    public final ContextMenu setHeaderTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.Io = charSequence;
        }
        return this;
    }

    public final ContextMenu setHeaderIcon(int i) {
        return this;
    }

    public final ContextMenu setHeaderIcon(Drawable drawable) {
        return this;
    }

    public final ContextMenu setHeaderView(View view) {
        return this;
    }

    public final void clearHeader() {
    }
}
