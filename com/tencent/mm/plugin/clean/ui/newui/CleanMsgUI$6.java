package com.tencent.mm.plugin.clean.ui.newui;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;

class CleanMsgUI$6 implements d {
    final /* synthetic */ CleanMsgUI hTx;

    CleanMsgUI$6(CleanMsgUI cleanMsgUI) {
        this.hTx = cleanMsgUI;
    }

    public final void bx(int i, int i2) {
        switch (i2) {
            case 0:
                if (CleanMsgUI.aBA() > 0) {
                    h.a(this.hTx, this.hTx.getString(R.l.clean_three_month_res, new Object[]{bi.bF(r2)}), "", this.hTx.getString(R.l.delete), this.hTx.getString(R.l.cancel), new 1(this), null);
                    return;
                }
                Toast.makeText(this.hTx, R.l.no_three_month_res, 0).show();
                return;
            default:
                return;
        }
    }
}
