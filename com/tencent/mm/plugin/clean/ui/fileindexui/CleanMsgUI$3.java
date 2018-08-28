package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

class CleanMsgUI$3 implements OnClickListener {
    final /* synthetic */ CleanMsgUI hSL;

    CleanMsgUI$3(CleanMsgUI cleanMsgUI) {
        this.hSL = cleanMsgUI;
    }

    public final void onClick(View view) {
        this.hSL.startActivityForResult(new Intent(this.hSL, CleanChattingUI.class), 0);
        h.mEJ.a(714, 12, 1, false);
    }
}
