package com.tencent.mm.plugin.fts.ui;

import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.ui.n.d;

class FTSChattingConvUI$b extends t {
    TextView ePz;
    final /* synthetic */ FTSChattingConvUI jwt;

    public FTSChattingConvUI$b(FTSChattingConvUI fTSChattingConvUI, View view) {
        this.jwt = fTSChattingConvUI;
        super(view);
        this.ePz = (TextView) view.findViewById(d.title);
        this.ePz.setOnClickListener(fTSChattingConvUI);
    }
}
