package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.c.a.c;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

final class q extends o implements SubMenu {
    q(Context context, c cVar) {
        super(context, cVar);
    }

    public final SubMenu setHeaderTitle(int i) {
        ((c) this.HM).setHeaderTitle(i);
        return this;
    }

    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        ((c) this.HM).setHeaderTitle(charSequence);
        return this;
    }

    public final SubMenu setHeaderIcon(int i) {
        ((c) this.HM).setHeaderIcon(i);
        return this;
    }

    public final SubMenu setHeaderIcon(Drawable drawable) {
        ((c) this.HM).setHeaderIcon(drawable);
        return this;
    }

    public final SubMenu setHeaderView(View view) {
        ((c) this.HM).setHeaderView(view);
        return this;
    }

    public final void clearHeader() {
        ((c) this.HM).clearHeader();
    }

    public final SubMenu setIcon(int i) {
        ((c) this.HM).setIcon(i);
        return this;
    }

    public final SubMenu setIcon(Drawable drawable) {
        ((c) this.HM).setIcon(drawable);
        return this;
    }

    public final MenuItem getItem() {
        return f(((c) this.HM).getItem());
    }
}
