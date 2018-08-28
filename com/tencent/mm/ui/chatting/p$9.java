package com.tencent.mm.ui.chatting;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class p$9 implements a {
    final /* synthetic */ p tJl;

    p$9(p pVar) {
        this.tJl = pVar;
    }

    public final boolean vD() {
        long wu = p.a(this.tJl).wu();
        x.d("MicroMsg.ChattingFooterEventImpl", "ms " + wu);
        if (wu >= 50000 && wu <= 60000) {
            if (!p.k(this.tJl)) {
                bi.fO(p.e(this.tJl).tTq.getContext());
                p.a(this.tJl, true);
            }
            int i = (int) ((60000 - wu) / 1000);
            p.d(this.tJl).setRecordNormalWording(p.e(this.tJl).tTq.getMMResources().getQuantityString(R.j.chatting_rcd_time_limit, i, new Object[]{Integer.valueOf(i)}));
        }
        if (wu < 60000) {
            return true;
        }
        x.v("MicroMsg.ChattingFooterEventImpl", "record stop on countdown");
        p.l(this.tJl);
        p.d(this.tJl).aMo();
        as.I(p.e(this.tJl).tTq.getContext(), R.l.time_limit);
        return false;
    }
}
