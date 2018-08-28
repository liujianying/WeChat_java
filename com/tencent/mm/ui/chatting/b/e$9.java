package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.g.a.jx;
import com.tencent.mm.ui.chatting.c.a;
import java.util.LinkedList;

class e$9 implements OnClickListener {
    final /* synthetic */ int eeg = 1;
    final /* synthetic */ e tOC;
    final /* synthetic */ LinkedList tOn;

    e$9(e eVar, LinkedList linkedList) {
        this.tOC = eVar;
        this.tOn = linkedList;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        final jx jxVar = new jx();
        a aVar = this.tOC.bAG;
        Context context = this.tOC.bAG.tTq.getContext();
        this.tOC.bAG.tTq.getMMResources().getString(R.l.app_tip);
        aVar.d(context, this.tOC.bAG.tTq.getMMResources().getString(R.l.room_del_member), new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                jxVar.bTZ.bTN = true;
                com.tencent.mm.sdk.b.a.sFg.m(jxVar);
            }
        });
        jxVar.bTZ.chatroomName = this.tOC.bAG.getTalkerUserName();
        jxVar.bTZ.bUb = this.tOn;
        jxVar.bTZ.scene = this.eeg;
        com.tencent.mm.sdk.b.a.sFg.m(jxVar);
    }
}
