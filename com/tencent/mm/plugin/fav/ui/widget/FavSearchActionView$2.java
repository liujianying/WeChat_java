package com.tencent.mm.plugin.fav.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.MMTagPanel.d;
import java.util.Iterator;

class FavSearchActionView$2 implements OnClickListener {
    final /* synthetic */ FavSearchActionView jfB;

    FavSearchActionView$2(FavSearchActionView favSearchActionView) {
        this.jfB = favSearchActionView;
    }

    public final void onClick(View view) {
        if (FavSearchActionView.d(this.jfB) != null) {
            d dVar;
            FavTagPanel a = FavSearchActionView.a(this.jfB);
            Iterator it = a.jfF.iterator();
            while (it.hasNext()) {
                dVar = (d) it.next();
                a.removeView(dVar.tye);
                a.a(dVar);
            }
            a.jfF.clear();
            a.crR();
            a = FavSearchActionView.a(this.jfB);
            it = a.rBV.iterator();
            while (it.hasNext()) {
                dVar = (d) it.next();
                a.removeView(dVar.tye);
                a.a(dVar);
            }
            a.rBV.clear();
            a.crR();
            FavSearchActionView.a(this.jfB).crN();
            FavSearchActionView.e(this.jfB).clear();
            FavSearchActionView.f(this.jfB).clear();
            FavSearchActionView.b(this.jfB).clear();
            FavSearchActionView.d(this.jfB).a(FavSearchActionView.e(this.jfB), FavSearchActionView.f(this.jfB), FavSearchActionView.b(this.jfB), true);
            FavSearchActionView.c(this.jfB);
        }
    }
}
