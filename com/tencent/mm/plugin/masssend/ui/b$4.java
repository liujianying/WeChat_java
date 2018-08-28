package com.tencent.mm.plugin.masssend.ui;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class b$4 implements a {
    final /* synthetic */ b laG;

    b$4(b bVar) {
        this.laG = bVar;
    }

    public final boolean vD() {
        if (this.laG.hng == -1) {
            this.laG.hng = bi.VG();
        }
        long bI = bi.bI(this.laG.hng);
        if (bI >= 50000 && bI <= 60000) {
            int i;
            if (this.laG.hnh == null) {
                i = (int) ((60000 - bI) / 1000);
                this.laG.hnh = Toast.makeText(this.laG.laz, this.laG.laz.getResources().getQuantityString(R.j.chatting_rcd_time_limit, i, new Object[]{Integer.valueOf(i)}), 0);
            } else {
                i = (int) ((60000 - bI) / 1000);
                this.laG.hnh.setText(this.laG.laz.getResources().getQuantityString(R.j.chatting_rcd_time_limit, i, new Object[]{Integer.valueOf(i)}));
            }
            this.laG.hnh.show();
        }
        if (bI < 60000) {
            return true;
        }
        x.v("MicroMsg.MassSendFooterEventImpl", "record stop on countdown");
        if (this.laG.laB.wk()) {
            this.laG.bcr();
        }
        this.laG.laA.aMo();
        as.I(this.laG.laz, R.l.time_limit);
        return false;
    }
}
