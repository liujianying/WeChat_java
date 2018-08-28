package com.tencent.mm.plugin.clean.ui.newui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class CleanChattingDetailUI$5 implements OnClickListener {
    final /* synthetic */ CleanChattingDetailUI hTr;

    CleanChattingDetailUI$5(CleanChattingDetailUI cleanChattingDetailUI) {
        this.hTr = cleanChattingDetailUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (CleanChattingDetailUI.c(this.hTr).hQM.size() == 0) {
            this.hTr.finish();
        }
    }
}
