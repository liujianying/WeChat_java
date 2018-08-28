package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.subapp.c.a;
import com.tencent.mm.protocal.c.byq;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.viewitems.ak.4;
import java.util.LinkedList;

class ak$4$1 implements OnClickListener {
    final /* synthetic */ 4 ueW;

    ak$4$1(4 4) {
        this.ueW = 4;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        au.DF().a(331, ak.a(this.ueW.ueT, new 1(this)));
        LinkedList linkedList = new LinkedList();
        byq byq = new byq();
        byq.rdr = this.ueW.ueV.oro;
        linkedList.add(byq);
        a aVar = new a(linkedList, linkedList.size());
        au.DF().a(aVar, 0);
        ak akVar = this.ueW.ueT;
        Context context = ak.a(this.ueW.ueT).tTq.getContext();
        ak.a(this.ueW.ueT).tTq.getMMResources().getString(R.l.app_tip);
        ak.a(akVar, h.a(context, ak.a(this.ueW.ueT).tTq.getMMResources().getString(R.l.chatting_item_voice_reminder_delting), true, new 2(this, aVar)));
    }
}
