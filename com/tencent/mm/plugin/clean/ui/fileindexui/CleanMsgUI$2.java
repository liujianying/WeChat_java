package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;

class CleanMsgUI$2 implements OnClickListener {
    final /* synthetic */ CleanMsgUI hSL;

    CleanMsgUI$2(CleanMsgUI cleanMsgUI) {
        this.hSL = cleanMsgUI;
    }

    public final void onClick(View view) {
        h.a(this.hSL, this.hSL.getString(R.l.clean_other_acc_tips, new Object[]{bi.gc(j.aBt().hQE)}), "", this.hSL.getString(R.l.app_ok), this.hSL.getString(R.l.app_cancel), new 1(this), null, R.e.red);
    }
}
