package com.tencent.mm.ui.chatting;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.i.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.b.b.ag;

class p$1 implements a {
    final /* synthetic */ p tJl;

    p$1(p pVar) {
        this.tJl = pVar;
    }

    public final void onError() {
        p.a(this.tJl).reset();
        p.b(this.tJl).SO();
        p.c(this.tJl).SO();
        af.Wq("keep_app_silent");
        p.d(this.tJl).aMo();
        ((ag) p.e(this.tJl).O(ag.class)).cwl().csM();
        x.v("MicroMsg.ChattingFooterEventImpl", "record stop on error");
        p.e(this.tJl).tTq.enableOptionMenu(true);
        p.e(this.tJl).tTq.enableBackMenu(true);
        Toast.makeText(p.e(this.tJl).tTq.getContext(), p.e(this.tJl).tTq.getContext().getString(R.l.chatting_rcd_err), 0).show();
    }
}
