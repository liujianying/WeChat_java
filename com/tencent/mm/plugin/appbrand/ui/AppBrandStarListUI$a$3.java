package com.tencent.mm.plugin.appbrand.ui;

import android.support.v7.widget.RecyclerView.e.c;
import android.support.v7.widget.RecyclerView.q;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.v;
import android.view.ViewPropertyAnimator;
import com.tencent.mm.plugin.appbrand.ui.AppBrandStarListUI.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandStarListUI.a.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AppBrandStarListUI$a$3 extends v {
    final /* synthetic */ a gvU;
    final Map<t, ViewPropertyAnimator> gvX = new HashMap();
    final Map<t, ViewPropertyAnimator> gvY = new HashMap();

    AppBrandStarListUI$a$3(a aVar) {
        this.gvU = aVar;
    }

    public final boolean a(t tVar, final t tVar2, c cVar, c cVar2) {
        if (tVar2 != null) {
            if (this.gvX.containsKey(tVar2)) {
                ((ViewPropertyAnimator) this.gvX.remove(tVar2)).cancel();
            }
            if (this.gvY.containsKey(tVar2)) {
                ((ViewPropertyAnimator) this.gvY.remove(tVar2)).cancel();
            }
        }
        AppBrandStarListUI$a$f appBrandStarListUI$a$f;
        ViewPropertyAnimator withEndAction;
        ViewPropertyAnimator withEndAction2;
        if (cVar instanceof AppBrandStarListUI$a$a) {
            appBrandStarListUI$a$f = (AppBrandStarListUI$a$f) tVar2;
            appBrandStarListUI$a$f.gwm.setAlpha(0.0f);
            appBrandStarListUI$a$f.gwm.setVisibility(0);
            withEndAction = appBrandStarListUI$a$f.gwm.animate().setDuration(200).alpha(1.0f).withEndAction(new Runnable() {
                public final void run() {
                    AppBrandStarListUI$a$3.this.gvX.remove(tVar2);
                    AppBrandStarListUI$a$3.a(AppBrandStarListUI$a$3.this, tVar2);
                }
            });
            this.gvX.put(tVar2, withEndAction);
            withEndAction.start();
            withEndAction2 = appBrandStarListUI$a$f.gwj.animate().setDuration(200).scaleX(1.0f).scaleY(1.0f).withEndAction(new 2(this, tVar2));
            this.gvY.put(tVar2, withEndAction2);
            withEndAction2.start();
            return false;
        } else if (!(cVar instanceof b)) {
            return super.a(tVar, tVar2, cVar, cVar2);
        } else {
            appBrandStarListUI$a$f = (AppBrandStarListUI$a$f) tVar2;
            withEndAction = appBrandStarListUI$a$f.gwm.animate().setDuration(200).alpha(0.0f).withEndAction(new 3(this, appBrandStarListUI$a$f, tVar2));
            this.gvX.put(tVar2, withEndAction);
            withEndAction.start();
            withEndAction2 = appBrandStarListUI$a$f.gwj.animate().setDuration(200).scaleX(0.9f).scaleY(0.9f).withEndAction(new 4(this, tVar2));
            this.gvY.put(tVar2, withEndAction2);
            withEndAction2.start();
            return false;
        }
    }

    public final c a(q qVar, t tVar, int i, List<Object> list) {
        if (2 == i) {
            for (Object next : list) {
                if ("enter_delete_mode_tag".equals(next)) {
                    return new AppBrandStarListUI$a$a().b(tVar, 0);
                }
                if ("exit_delete_mode_tag".equals(next)) {
                    return new b((byte) 0).b(tVar, 0);
                }
            }
        }
        return super.a(qVar, tVar, i, list);
    }

    public final boolean a(t tVar, List<Object> list) {
        return true;
    }
}
