package com.tencent.mm.plugin.mmsight.segment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.d;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.e;

class RecyclerThumbSeekBar$c extends a<e> {
    final /* synthetic */ RecyclerThumbSeekBar llX;
    d lmb;
    int lmc;
    int lmd;
    private View lme;
    private View lmf;

    private RecyclerThumbSeekBar$c(RecyclerThumbSeekBar recyclerThumbSeekBar) {
        this.llX = recyclerThumbSeekBar;
        this.lmb = new d(this.llX);
        this.lmc = RecyclerThumbSeekBar.f(this.llX);
        this.lmd = RecyclerThumbSeekBar.f(this.llX);
    }

    /* synthetic */ RecyclerThumbSeekBar$c(RecyclerThumbSeekBar recyclerThumbSeekBar, byte b) {
        this(recyclerThumbSeekBar);
    }

    public final int getItemViewType(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == getItemCount() - 1) {
            return 2;
        }
        return 0;
    }

    public final void n(boolean z, int i) {
        if (z) {
            if (this.lme != null) {
                this.lme.setMinimumWidth(i);
            }
            if (((LinearLayoutManager) RecyclerThumbSeekBar.n(this.llX).getLayoutManager()).fi() == 0) {
                RecyclerThumbSeekBar.n(this.llX).scrollBy(i - this.lmc, 0);
            }
            this.lmc = i;
            return;
        }
        this.lmd = i;
        if (this.lmf != null) {
            this.lmf.setMinimumWidth(this.lmd);
        }
    }

    public final int getItemCount() {
        return RecyclerThumbSeekBar.i(this.llX) <= 0 ? 0 : Math.max(0, (int) Math.floor((double) (((float) RecyclerThumbSeekBar.i(this.llX)) / ((float) RecyclerThumbSeekBar.b(this.llX))))) + 2;
    }
}
