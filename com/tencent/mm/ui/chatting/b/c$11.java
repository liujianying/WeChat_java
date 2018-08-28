package com.tencent.mm.ui.chatting.b;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ac.a.d$a$a;
import com.tencent.mm.ac.a.d.a;
import com.tencent.mm.ac.a.d.a.b;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.a.j;
import com.tencent.mm.ac.z;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.b.b.o;

class c$11 implements a {
    final /* synthetic */ c tOm;

    c$11(c cVar) {
        this.tOm = cVar;
    }

    public final void a(b bVar) {
        if (!this.tOm.qIZ || bVar == null || bVar.dNf != this.tOm.cuC()) {
            return;
        }
        if (!this.tOm.bAG.eaR) {
            x.i("MicroMsg.ChattingUI.BizComponent", "onNotifyChange fragment not foreground, return");
        } else if (bVar.dNp != d$a$a.dNm) {
            x.i("MicroMsg.ChattingUI.BizComponent", "bizChatExtension bizChat change");
            this.tOm.tDV = z.Na().ak(this.tOm.cuC());
            if (this.tOm.tOe) {
                c.a(this.tOm, e.c(this.tOm.tDV));
                ((o) this.tOm.bAG.O(o.class)).cvp();
            } else {
                j cz = z.Nc().cz(this.tOm.tDV.field_bizChatServId);
                if (cz != null) {
                    this.tOm.lVG = cz;
                }
            }
            ((o) this.tOm.bAG.O(o.class)).cvn();
        } else if (this.tOm.tOe) {
            Toast.makeText(ad.getContext(), this.tOm.bAG.tTq.getMMResources().getString(R.l.room_delete_quit_tip), 1).show();
            this.tOm.bAG.tTq.csV();
        }
    }
}
