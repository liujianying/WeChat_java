package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.support.v7.widget.RecyclerView$t;
import android.support.v7.widget.RecyclerView.a;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.List;

final class n extends a {
    private LayoutInflater Bc;
    final SparseArray<o> gBb = new SparseArray();
    private final ArrayList<?> gBc;

    n(ArrayList<?> arrayList) {
        this.gBc = arrayList;
    }

    final boolean isEmpty() {
        return this.gBc == null || bi.cX(this.gBc);
    }

    final Object lM(int i) {
        return (i < 0 || i > getItemCount()) ? null : this.gBc.get(i);
    }

    public final RecyclerView$t a(ViewGroup viewGroup, int i) {
        o oVar = (o) this.gBb.get(i);
        if (oVar == null) {
            return null;
        }
        Context context = viewGroup.getContext();
        if (this.Bc == null) {
            this.Bc = LayoutInflater.from(context);
        }
        return oVar.a(this.Bc, viewGroup);
    }

    public final void a(RecyclerView$t recyclerView$t, int i) {
        o oVar = (o) this.gBb.get(getItemViewType(i));
        if (oVar != null) {
            oVar.b(recyclerView$t, lM(i));
        }
    }

    public final void a(RecyclerView$t recyclerView$t, int i, List list) {
        o oVar = (o) this.gBb.get(getItemViewType(i));
        if (oVar == null) {
            super.a(recyclerView$t, i, list);
            return;
        }
        if (list.size() > 0) {
            lM(i);
            if (oVar.a(recyclerView$t, list.get(0))) {
                return;
            }
        }
        oVar.b(recyclerView$t, lM(i));
    }

    public final int getItemViewType(int i) {
        Object lM = lM(i);
        return lM == null ? 0 : lM.getClass().hashCode();
    }

    public final long getItemId(int i) {
        Object lM = lM(i);
        o oVar = (o) this.gBb.get(getItemViewType(i));
        return (lM == null || oVar == null) ? 0 : oVar.bn(lM);
    }

    public final int getItemCount() {
        return this.gBc == null ? 0 : this.gBc.size();
    }
}
