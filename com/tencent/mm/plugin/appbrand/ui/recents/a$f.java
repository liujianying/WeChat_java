package com.tencent.mm.plugin.appbrand.ui.recents;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$q;
import android.support.v7.widget.RecyclerView$t;
import android.support.v7.widget.RecyclerView.g;
import android.view.View;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.plugin.appbrand.ui.recents.a.d;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;

final class a$f extends g {
    final /* synthetic */ a gyS;

    private a$f(a aVar) {
        this.gyS = aVar;
    }

    /* synthetic */ a$f(a aVar, byte b) {
        this(aVar);
    }

    public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView$q recyclerView$q) {
        rect.left = 0;
        rect.right = 0;
        rect.bottom = 0;
        rect.top = 0;
        if (recyclerView instanceof MRecyclerView) {
            RecyclerView$t aP = recyclerView.aP(view);
            if (aP instanceof d) {
                j.s(((d) aP).eCO, ((MRecyclerView) recyclerView).G(aP) == a.b(this.gyS).getItemCount() + -1 ? 8 : 0);
            }
        }
    }
}
