package com.tencent.mm.plugin.fav.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class FavPostVoiceUI$7 implements a {
    final /* synthetic */ FavPostVoiceUI iZn;

    FavPostVoiceUI$7(FavPostVoiceUI favPostVoiceUI) {
        this.iZn = favPostVoiceUI;
    }

    public final boolean vD() {
        if (FavPostVoiceUI.q(this.iZn) == -1) {
            FavPostVoiceUI.a(this.iZn, bi.VG());
        }
        long bI = bi.bI(FavPostVoiceUI.q(this.iZn));
        if (bI >= 3590000 && bI <= 3600000) {
            if (FavPostVoiceUI.r(this.iZn) == null) {
                FavPostVoiceUI.a(this.iZn, Toast.makeText(this.iZn, this.iZn.getString(i.fav_rcd_time_limit, new Object[]{Integer.valueOf((int) ((3600000 - bI) / 1000))}), 0));
            } else {
                FavPostVoiceUI.r(this.iZn).setText(this.iZn.getString(i.fav_rcd_time_limit, new Object[]{Integer.valueOf((int) ((3600000 - bI) / 1000))}));
            }
            FavPostVoiceUI.r(this.iZn).show();
        }
        if (bI < 3600000) {
            return true;
        }
        x.v("MicroMsg.FavPostVoiceUI", "record stop on countdown");
        FavPostVoiceUI.s(this.iZn);
        FavPostVoiceUI.p(this.iZn);
        return false;
    }
}
