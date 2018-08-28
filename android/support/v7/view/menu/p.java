package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.f.a;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class p extends f implements SubMenu {
    public f Jk;
    private h Jl;

    public p(Context context, f fVar, h hVar) {
        super(context);
        this.Jk = fVar;
        this.Jl = hVar;
    }

    public void setQwertyMode(boolean z) {
        this.Jk.setQwertyMode(z);
    }

    public final boolean dH() {
        return this.Jk.dH();
    }

    public final boolean dI() {
        return this.Jk.dI();
    }

    public MenuItem getItem() {
        return this.Jl;
    }

    public final void a(a aVar) {
        this.Jk.a(aVar);
    }

    public final f dQ() {
        return this.Jk;
    }

    final boolean b(f fVar, MenuItem menuItem) {
        return super.b(fVar, menuItem) || this.Jk.b(fVar, menuItem);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.Jl.setIcon(drawable);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.Jl.setIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.k(drawable);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        super.k(android.support.v4.content.a.f(this.mContext, i));
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.g(charSequence);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        super.g(this.mContext.getResources().getString(i));
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.a(null, null, view);
        return this;
    }

    public final boolean g(h hVar) {
        return this.Jk.g(hVar);
    }

    public final boolean h(h hVar) {
        return this.Jk.h(hVar);
    }

    public final String dG() {
        int itemId = this.Jl != null ? this.Jl.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.dG() + ":" + itemId;
    }
}
