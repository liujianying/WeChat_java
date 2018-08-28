package android.support.v7.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.c.a.b;
import android.support.v4.e.j;
import android.support.v7.view.menu.n;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

@TargetApi(11)
public final class f extends ActionMode {
    final b Gv;
    final Context mContext;

    public static class a implements android.support.v7.view.b.a {
        final Callback Gw;
        final ArrayList<f> Gx = new ArrayList();
        final j<Menu, Menu> Gy = new j();
        final Context mContext;

        public a(Context context, Callback callback) {
            this.mContext = context;
            this.Gw = callback;
        }

        public final boolean a(b bVar, Menu menu) {
            return this.Gw.onCreateActionMode(b(bVar), b(menu));
        }

        public final boolean b(b bVar, Menu menu) {
            return this.Gw.onPrepareActionMode(b(bVar), b(menu));
        }

        public final boolean a(b bVar, MenuItem menuItem) {
            return this.Gw.onActionItemClicked(b(bVar), n.a(this.mContext, (b) menuItem));
        }

        public final void a(b bVar) {
            this.Gw.onDestroyActionMode(b(bVar));
        }

        private Menu b(Menu menu) {
            Menu menu2 = (Menu) this.Gy.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            menu2 = n.a(this.mContext, (android.support.v4.c.a.a) menu);
            this.Gy.put(menu, menu2);
            return menu2;
        }

        public final ActionMode b(b bVar) {
            int size = this.Gx.size();
            for (int i = 0; i < size; i++) {
                f fVar = (f) this.Gx.get(i);
                if (fVar != null && fVar.Gv == bVar) {
                    return fVar;
                }
            }
            ActionMode fVar2 = new f(this.mContext, bVar);
            this.Gx.add(fVar2);
            return fVar2;
        }
    }

    public f(Context context, b bVar) {
        this.mContext = context;
        this.Gv = bVar;
    }

    public final Object getTag() {
        return this.Gv.hX;
    }

    public final void setTag(Object obj) {
        this.Gv.hX = obj;
    }

    public final void setTitle(CharSequence charSequence) {
        this.Gv.setTitle(charSequence);
    }

    public final void setSubtitle(CharSequence charSequence) {
        this.Gv.setSubtitle(charSequence);
    }

    public final void invalidate() {
        this.Gv.invalidate();
    }

    public final void finish() {
        this.Gv.finish();
    }

    public final Menu getMenu() {
        return n.a(this.mContext, (android.support.v4.c.a.a) this.Gv.getMenu());
    }

    public final CharSequence getTitle() {
        return this.Gv.getTitle();
    }

    public final void setTitle(int i) {
        this.Gv.setTitle(i);
    }

    public final CharSequence getSubtitle() {
        return this.Gv.getSubtitle();
    }

    public final void setSubtitle(int i) {
        this.Gv.setSubtitle(i);
    }

    public final View getCustomView() {
        return this.Gv.getCustomView();
    }

    public final void setCustomView(View view) {
        this.Gv.setCustomView(view);
    }

    public final MenuInflater getMenuInflater() {
        return this.Gv.getMenuInflater();
    }

    public final boolean getTitleOptionalHint() {
        return this.Gv.Gs;
    }

    public final void setTitleOptionalHint(boolean z) {
        this.Gv.setTitleOptionalHint(z);
    }

    public final boolean isTitleOptional() {
        return this.Gv.isTitleOptional();
    }
}
