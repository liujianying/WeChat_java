package com.tencent.mm.plugin.fts.ui.widget;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.mm.protocal.c.bhr;
import java.util.List;

class FTSLocalPageRelevantView$b extends a<a> {
    final /* synthetic */ FTSLocalPageRelevantView jzI;
    public List<bhr> jzK;

    public FTSLocalPageRelevantView$b(FTSLocalPageRelevantView fTSLocalPageRelevantView) {
        this.jzI = fTSLocalPageRelevantView;
    }

    public final int getItemCount() {
        return this.jzK.size();
    }
}
