package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.h;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

public class LoadMoreRecyclerView extends MRecyclerView {
    private View gPU;
    private a gPV;
    boolean gPW;

    public LoadMoreRecyclerView(Context context) {
        super(context);
        init();
    }

    public LoadMoreRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LoadMoreRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public LinearLayoutManager aoc() {
        getContext();
        return new LinearLayoutManager();
    }

    private void init() {
        LinearLayoutManager aoc = aoc();
        super.setLayoutManager(aoc);
        a(new 1(this, aoc));
        this.gQa.a(new 2(this, aoc));
    }

    public final void addFooterView(View view) {
        int aqC = this.gQa.aqC() - 1;
        if (this.gPU == null || aqC < 0) {
            super.addFooterView(view);
        } else {
            super.b(aqC, view);
        }
    }

    public void setLayoutManager(h hVar) {
    }

    public void setLoadingView(View view) {
        if (this.gPU != view) {
            if (!(this.gPU == null || this.gPU.equals(view))) {
                cj(this.gPU);
            }
            this.gPU = view;
            if (this.gPU != null) {
                addFooterView(this.gPU);
                this.gPU.setVisibility(this.gPW ? 0 : 8);
            }
        }
    }

    public void setLoadingView(int i) {
        setLoadingView(LayoutInflater.from(getContext()).inflate(i, this, false));
    }

    public final void ds(boolean z) {
        if (this.gPW != z) {
            this.gPW = z;
            if (this.gPU != null) {
                this.gPU.setVisibility(this.gPW ? 0 : 8);
            }
        }
    }

    public void setOnLoadingStateChangedListener(a aVar) {
        this.gPV = aVar;
    }

    protected final boolean aqD() {
        if (this.gPU == null) {
            return super.aqD();
        }
        if (this.gQa.getItemCount() == 1 && this.gQa.aqC() == 1) {
            return true;
        }
        return false;
    }
}
