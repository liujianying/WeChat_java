package com.tencent.mm.plugin.record.ui;

import android.view.View;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.x;

class RecordMsgBaseUI$3 implements Runnable {
    final /* synthetic */ RecordMsgBaseUI msV;
    final /* synthetic */ View msW;

    RecordMsgBaseUI$3(RecordMsgBaseUI recordMsgBaseUI, View view) {
        this.msV = recordMsgBaseUI;
        this.msW = view;
    }

    public final void run() {
        View childAt = this.msV.eVT.getChildAt(this.msV.eVT.getLastVisiblePosition());
        if (childAt != null) {
            int bottom = childAt.getBottom();
            int bottom2 = this.msV.eVT.getBottom();
            int fromDPToPix = a.fromDPToPix(this.msV.mController.tml, 64);
            x.d("MicroMsg.RecordMsgBaseUI", "lastBotm %s, listBotm %s, listEndmargin %s", new Object[]{Integer.valueOf(bottom), Integer.valueOf(bottom2), Integer.valueOf(fromDPToPix)});
            if (bottom < bottom2 - fromDPToPix) {
                x.d("MicroMsg.RecordMsgBaseUI", "offset %d", new Object[]{Integer.valueOf((bottom2 - bottom) - fromDPToPix)});
                this.msW.setPadding(0, bottom, 0, 0);
            }
        }
        this.msV.eVT.addFooterView(this.msW, null, false);
    }
}
