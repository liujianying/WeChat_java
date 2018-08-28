package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.viewitems.d.c;

class d$c$1 implements OnClickListener {
    final /* synthetic */ String fYG;
    final /* synthetic */ String qjl;
    final /* synthetic */ a tZG;
    final /* synthetic */ String uaN;
    final /* synthetic */ String uaO;
    final /* synthetic */ String uaP;
    final /* synthetic */ String uaQ;
    final /* synthetic */ String uaR;
    final /* synthetic */ c uaS;
    final /* synthetic */ String val$url;

    d$c$1(c cVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, a aVar) {
        this.uaS = cVar;
        this.qjl = str;
        this.uaN = str2;
        this.uaO = str3;
        this.uaP = str4;
        this.uaQ = str5;
        this.val$url = str6;
        this.fYG = str7;
        this.uaR = str8;
        this.tZG = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("key_scene", 1);
        intent.putExtra("key_receiver", this.qjl);
        intent.putExtra("key_receivertitle", this.uaN);
        intent.putExtra("key_sendertitle", this.uaO);
        intent.putExtra("key_sender_des", this.uaP);
        intent.putExtra("key_receiver_des", this.uaQ);
        intent.putExtra("key_url", this.val$url);
        intent.putExtra("key_templateid", this.fYG);
        intent.putExtra("key_sceneid", this.uaR);
        d.b(this.tZG.tTq.getContext(), "wallet_index", ".ui.WalletSendC2CMsgUI", intent);
    }
}
