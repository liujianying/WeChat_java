package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;

class ControlBoardPanel$2 implements OnClickListener {
    final /* synthetic */ ControlBoardPanel gQL;

    ControlBoardPanel$2(ControlBoardPanel controlBoardPanel) {
        this.gQL = controlBoardPanel;
    }

    public final void onClick(View view) {
        if (this.gQL.gQD.getVisibility() == 0) {
            this.gQL.gQC.setVisibility(8);
            this.gQL.gQD.setVisibility(8);
            this.gQL.gQG.setSelected(false);
            ControlBoardPanel.a(this.gQL);
            return;
        }
        this.gQL.gQC.setVisibility(0);
        this.gQL.fxO.setVisibility(8);
        this.gQL.gQD.setVisibility(0);
        this.gQL.gQE.setVisibility(8);
        this.gQL.gQF.setSelected(false);
        this.gQL.gQG.setSelected(true);
        this.gQL.gQH.setSelected(false);
        ControlBoardPanel.b(this.gQL);
    }
}
