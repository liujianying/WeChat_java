package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$a;
import android.support.v7.widget.RecyclerView.t;
import android.util.AttributeSet;
import android.view.View;

public class MRecyclerView extends RecyclerView {
    protected a gQa;
    private a gQb;
    private b gQc;
    private View gQd;

    public MRecyclerView(Context context) {
        super(context);
        init();
    }

    public MRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.gQa = new a();
        this.gQa.fX();
        super.setAdapter(this.gQa);
        this.gQa.a(new 1(this));
    }

    public final int G(t tVar) {
        if (this.gQa == null) {
            return -1;
        }
        a aVar = this.gQa;
        if (tVar == null || tVar.gm() == -1) {
            return -1;
        }
        return tVar.gm() - (aVar.gPN.isEmpty() ? 0 : 1);
    }

    public void setAdapter(RecyclerView$a recyclerView$a) {
        a aVar = this.gQa;
        if (aVar.QU != null) {
            if (!aVar.QU.equals(recyclerView$a)) {
                aVar.QU.b(aVar.gPR);
            } else {
                return;
            }
        }
        aVar.QU = recyclerView$a;
        if (aVar.QU != null) {
            aVar.QU.a(aVar.gPR);
        }
    }

    public RecyclerView$a getAdapter() {
        return this.gQa;
    }

    public final void bg(int i) {
        super.bg(i);
    }

    public final void addHeaderView(View view) {
        a aVar = this.gQa;
        aVar.gPN.add(view);
        aVar.X(0, 1);
    }

    public void addFooterView(View view) {
        this.gQa.addFooterView(view);
    }

    public final void b(int i, View view) {
        this.gQa.b(i, view);
    }

    public final void cj(View view) {
        this.gQa.cj(view);
    }

    public void setEmptyView(View view) {
        if (this.gQd != view) {
            this.gQd = view;
            if (this.gQd != null) {
                this.gQd.setVisibility(aqD() ? 0 : 8);
            }
        }
    }

    public View getEmptyView() {
        return this.gQd;
    }

    public void setOnItemClickListener(a aVar) {
        this.gQb = aVar;
        this.gQa.gPP = new 2(this);
    }

    public void setOnItemLongClickListener(b bVar) {
        this.gQc = bVar;
        this.gQa.gPQ = new 3(this);
    }

    protected boolean aqD() {
        return this.gQa.getItemCount() == 0;
    }
}
