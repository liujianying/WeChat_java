package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class CleanNewUI$2 implements OnClickListener {
    final /* synthetic */ CleanNewUI hTh;

    CleanNewUI$2(CleanNewUI cleanNewUI) {
        this.hTh = cleanNewUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.CleanNewUI", "%s goto clean msg ui", new Object[]{CleanNewUI.a(this.hTh)});
        h.mEJ.a(714, 2, 1, false);
        this.hTh.startActivityForResult(new Intent(this.hTh, CleanMsgUI.class), 0);
    }
}
