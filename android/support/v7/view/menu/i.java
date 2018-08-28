package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.view.m.e;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

@TargetApi(14)
public class i extends c<android.support.v4.c.a.b> implements MenuItem {
    public Method IQ;

    class a extends android.support.v4.view.d {
        final ActionProvider IR;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.IR = actionProvider;
        }

        public final View onCreateActionView() {
            return this.IR.onCreateActionView();
        }

        public final boolean onPerformDefaultAction() {
            return this.IR.onPerformDefaultAction();
        }

        public final boolean hasSubMenu() {
            return this.IR.hasSubMenu();
        }

        public final void onPrepareSubMenu(SubMenu subMenu) {
            this.IR.onPrepareSubMenu(i.this.a(subMenu));
        }
    }

    static class b extends FrameLayout implements android.support.v7.view.c {
        final CollapsibleActionView IT;

        b(View view) {
            super(view.getContext());
            this.IT = (CollapsibleActionView) view;
            addView(view);
        }

        public final void onActionViewExpanded() {
            this.IT.onActionViewExpanded();
        }

        public final void onActionViewCollapsed() {
            this.IT.onActionViewCollapsed();
        }
    }

    private class c extends d<OnActionExpandListener> implements e {
        c(OnActionExpandListener onActionExpandListener) {
            super(onActionExpandListener);
        }

        public final boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((OnActionExpandListener) this.HM).onMenuItemActionExpand(i.this.f(menuItem));
        }

        public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((OnActionExpandListener) this.HM).onMenuItemActionCollapse(i.this.f(menuItem));
        }
    }

    private class d extends d<OnMenuItemClickListener> implements OnMenuItemClickListener {
        d(OnMenuItemClickListener onMenuItemClickListener) {
            super(onMenuItemClickListener);
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            return ((OnMenuItemClickListener) this.HM).onMenuItemClick(i.this.f(menuItem));
        }
    }

    i(Context context, android.support.v4.c.a.b bVar) {
        super(context, bVar);
    }

    public int getItemId() {
        return ((android.support.v4.c.a.b) this.HM).getItemId();
    }

    public int getGroupId() {
        return ((android.support.v4.c.a.b) this.HM).getGroupId();
    }

    public int getOrder() {
        return ((android.support.v4.c.a.b) this.HM).getOrder();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((android.support.v4.c.a.b) this.HM).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((android.support.v4.c.a.b) this.HM).setTitle(i);
        return this;
    }

    public CharSequence getTitle() {
        return ((android.support.v4.c.a.b) this.HM).getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((android.support.v4.c.a.b) this.HM).setTitleCondensed(charSequence);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return ((android.support.v4.c.a.b) this.HM).getTitleCondensed();
    }

    public MenuItem setIcon(Drawable drawable) {
        ((android.support.v4.c.a.b) this.HM).setIcon(drawable);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((android.support.v4.c.a.b) this.HM).setIcon(i);
        return this;
    }

    public Drawable getIcon() {
        return ((android.support.v4.c.a.b) this.HM).getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        ((android.support.v4.c.a.b) this.HM).setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return ((android.support.v4.c.a.b) this.HM).getIntent();
    }

    public MenuItem setShortcut(char c, char c2) {
        ((android.support.v4.c.a.b) this.HM).setShortcut(c, c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((android.support.v4.c.a.b) this.HM).setNumericShortcut(c);
        return this;
    }

    public char getNumericShortcut() {
        return ((android.support.v4.c.a.b) this.HM).getNumericShortcut();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((android.support.v4.c.a.b) this.HM).setAlphabeticShortcut(c);
        return this;
    }

    public char getAlphabeticShortcut() {
        return ((android.support.v4.c.a.b) this.HM).getAlphabeticShortcut();
    }

    public MenuItem setCheckable(boolean z) {
        ((android.support.v4.c.a.b) this.HM).setCheckable(z);
        return this;
    }

    public boolean isCheckable() {
        return ((android.support.v4.c.a.b) this.HM).isCheckable();
    }

    public MenuItem setChecked(boolean z) {
        ((android.support.v4.c.a.b) this.HM).setChecked(z);
        return this;
    }

    public boolean isChecked() {
        return ((android.support.v4.c.a.b) this.HM).isChecked();
    }

    public MenuItem setVisible(boolean z) {
        return ((android.support.v4.c.a.b) this.HM).setVisible(z);
    }

    public boolean isVisible() {
        return ((android.support.v4.c.a.b) this.HM).isVisible();
    }

    public MenuItem setEnabled(boolean z) {
        ((android.support.v4.c.a.b) this.HM).setEnabled(z);
        return this;
    }

    public boolean isEnabled() {
        return ((android.support.v4.c.a.b) this.HM).isEnabled();
    }

    public boolean hasSubMenu() {
        return ((android.support.v4.c.a.b) this.HM).hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return a(((android.support.v4.c.a.b) this.HM).getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((android.support.v4.c.a.b) this.HM).setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(onMenuItemClickListener) : null);
        return this;
    }

    public ContextMenuInfo getMenuInfo() {
        return ((android.support.v4.c.a.b) this.HM).getMenuInfo();
    }

    public void setShowAsAction(int i) {
        ((android.support.v4.c.a.b) this.HM).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((android.support.v4.c.a.b) this.HM).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new b(view);
        }
        ((android.support.v4.c.a.b) this.HM).setActionView(view);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((android.support.v4.c.a.b) this.HM).setActionView(i);
        View actionView = ((android.support.v4.c.a.b) this.HM).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((android.support.v4.c.a.b) this.HM).setActionView(new b(actionView));
        }
        return this;
    }

    public View getActionView() {
        View actionView = ((android.support.v4.c.a.b) this.HM).getActionView();
        if (actionView instanceof b) {
            return (View) ((b) actionView).IT;
        }
        return actionView;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((android.support.v4.c.a.b) this.HM).a(actionProvider != null ? a(actionProvider) : null);
        return this;
    }

    public ActionProvider getActionProvider() {
        android.support.v4.view.d bJ = ((android.support.v4.c.a.b) this.HM).bJ();
        if (bJ instanceof a) {
            return ((a) bJ).IR;
        }
        return null;
    }

    public boolean expandActionView() {
        return ((android.support.v4.c.a.b) this.HM).expandActionView();
    }

    public boolean collapseActionView() {
        return ((android.support.v4.c.a.b) this.HM).collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return ((android.support.v4.c.a.b) this.HM).isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((android.support.v4.c.a.b) this.HM).a(onActionExpandListener != null ? new c(onActionExpandListener) : null);
        return this;
    }

    a a(ActionProvider actionProvider) {
        return new a(this.mContext, actionProvider);
    }
}
