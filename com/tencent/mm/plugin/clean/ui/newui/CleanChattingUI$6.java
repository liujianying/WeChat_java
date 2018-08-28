package com.tencent.mm.plugin.clean.ui.newui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.clean.c.d;

class CleanChattingUI$6 implements OnClickListener {
    final /* synthetic */ CleanChattingUI hTu;

    CleanChattingUI$6(CleanChattingUI cleanChattingUI) {
        this.hTu = cleanChattingUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (d.aBi() != null && d.aBi().size() == 0) {
            this.hTu.finish();
        }
    }
}
