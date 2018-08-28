package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;

class ControlBoardPanel$3 implements OnClickListener {
    final /* synthetic */ ControlBoardPanel gQL;

    ControlBoardPanel$3(ControlBoardPanel controlBoardPanel) {
        this.gQL = controlBoardPanel;
    }

    public final void onClick(View view) {
        if (this.gQL.gQE.getVisibility() == 0) {
            this.gQL.gQC.setVisibility(8);
            this.gQL.gQE.setVisibility(8);
            this.gQL.gQH.setSelected(false);
            ControlBoardPanel.a(this.gQL);
            return;
        }
        this.gQL.gQC.setVisibility(0);
        this.gQL.fxO.setVisibility(8);
        this.gQL.gQD.setVisibility(8);
        this.gQL.gQE.setVisibility(0);
        this.gQL.gQF.setSelected(false);
        this.gQL.gQG.setSelected(false);
        this.gQL.gQH.setSelected(true);
        ControlBoardPanel.b(this.gQL);
    }
}
