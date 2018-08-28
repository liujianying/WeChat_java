package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.q;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.viewitems.l.c;

class l$c$1 implements OnClickListener {
    final /* synthetic */ String qjk;
    final /* synthetic */ String qjl;
    final /* synthetic */ a tZG;
    final /* synthetic */ int ubu;
    final /* synthetic */ int ubv;
    final /* synthetic */ String ubw;
    final /* synthetic */ c ubx;

    l$c$1(c cVar, String str, String str2, int i, int i2, String str3, a aVar) {
        this.ubx = cVar;
        this.qjk = str;
        this.qjl = str2;
        this.ubu = i;
        this.ubv = i2;
        this.ubw = str3;
        this.tZG = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("transaction_id", this.qjk);
        intent.putExtra("receiver_name", this.qjl);
        intent.putExtra("resend_msg_from_flag", 2);
        intent.putExtra("invalid_time", this.ubu);
        intent.putExtra("total_fee", this.ubv);
        intent.putExtra("fee_type", this.ubw);
        if (q.GS()) {
            d.b(this.tZG.tTq.getContext(), "wallet_payu", ".remittance.ui.PayURemittanceResendMsgUI", intent);
        } else {
            d.b(this.tZG.tTq.getContext(), "remittance", ".ui.RemittanceResendMsgUI", intent);
        }
    }
}
