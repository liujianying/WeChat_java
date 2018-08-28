package com.tencent.mm.ui.chatting.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.chatting.n;
import java.util.List;

class j$4 implements OnClickListener {
    final /* synthetic */ j tOS;

    j$4(j jVar) {
        this.tOS = jVar;
    }

    public final void onClick(View view) {
        if (((g) this.tOS.bAG.O(g.class)).boX() == 0) {
            x.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
            return;
        }
        List c = j.c(this.tOS);
        if (j.dC(c)) {
            h.a(this.tOS.bAG.tTq.getContext(), this.tOS.bAG.tTq.getContext().getString(R.l.contain_remuxing_msg), "", this.tOS.bAG.tTq.getContext().getString(R.l.I_known), new 1(this));
        } else if (j.dD(c)) {
            h.a(this.tOS.bAG.tTq.getContext(), this.tOS.bAG.tTq.getContext().getString(R.l.contain_shortvideo_msg), "", this.tOS.bAG.tTq.getContext().getString(R.l.I_known), new 2(this));
        } else if (j.dB(c)) {
            h.a(this.tOS.bAG.tTq.getContext(), this.tOS.bAG.tTq.getContext().getString(R.l.contain_undownload_msg), "", new 3(this), null);
        } else if (n.a(this.tOS.bAG, c, j.e(this.tOS))) {
            this.tOS.cuQ();
        }
    }
}
