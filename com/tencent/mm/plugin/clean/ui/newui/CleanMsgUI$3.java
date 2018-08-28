package com.tencent.mm.plugin.clean.ui.newui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

class CleanMsgUI$3 implements OnClickListener {
    final /* synthetic */ CleanMsgUI hTx;

    CleanMsgUI$3(CleanMsgUI cleanMsgUI) {
        this.hTx = cleanMsgUI;
    }

    public final void onClick(View view) {
        this.hTx.startActivityForResult(new Intent(this.hTx, CleanChattingUI.class), 0);
        h.mEJ.a(282, 4, 1, false);
    }
}
