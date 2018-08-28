package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.abtest.a;
import com.tencent.mm.plugin.sns.ui.a.a$c;
import com.tencent.mm.protocal.c.atf;
import com.tencent.mm.sdk.platformtools.x;

class av$4 implements OnClickListener {
    final /* synthetic */ av ocj;

    av$4(av avVar) {
        this.ocj = avVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn");
        this.ocj.obV.nLM = false;
        a.bwC();
        if (view.getTag() instanceof a$c) {
            a$c a_c = (a$c) view.getTag();
            if (a_c.ojM != null && a_c.ojM.sqc.ruz == 21) {
                atf atf = a_c.nJn;
                if (!q.GF().equals(a_c.ojM.hbL) && (atf == null || atf.ceS == 0)) {
                    com.tencent.mm.plugin.sns.lucky.ui.a.e(this.ocj.bGc, a_c.oji.xm(0));
                    return;
                }
            }
            if (this.ocj.bGc instanceof u) {
                ((u) this.ocj.bGc).cK(view);
                return;
            }
            return;
        }
        x.e("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn err1");
    }
}
