package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;

class ControlBoardPanel$5 implements OnClickListener {
    final /* synthetic */ ControlBoardPanel gQL;

    ControlBoardPanel$5(ControlBoardPanel controlBoardPanel) {
        this.gQL = controlBoardPanel;
    }

    public final void onClick(View view) {
        ControlBoardPanel controlBoardPanel = this.gQL;
        if (controlBoardPanel.gQK) {
            controlBoardPanel.gQK = false;
            controlBoardPanel.gQI.removeViewImmediate(controlBoardPanel);
            d.b(controlBoardPanel.fxO);
            if (controlBoardPanel.gQB != null) {
                controlBoardPanel.gQB.a(controlBoardPanel, false);
            }
        }
    }
}
