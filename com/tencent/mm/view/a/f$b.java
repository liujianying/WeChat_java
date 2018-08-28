package com.tencent.mm.view.a;

import android.view.View;
import com.tencent.mm.plugin.n.a.e;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.RecommendView;
import com.tencent.mm.view.SmileySubGrid;

class f$b {
    final /* synthetic */ f uUa;
    RecommendView uUb;
    SmileySubGrid uUc;

    public f$b(f fVar, View view, int i) {
        this.uUa = fVar;
        switch (i) {
            case 0:
                this.uUb = (RecommendView) view;
                return;
            case 1:
            case 2:
            case 3:
                this.uUc = (SmileySubGrid) view.findViewById(e.smiley_panel_grid);
                return;
            default:
                return;
        }
    }
}
