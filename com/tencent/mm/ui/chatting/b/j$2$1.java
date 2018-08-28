package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.b.j.2;
import com.tencent.mm.ui.chatting.i;

class j$2$1 implements OnClickListener {
    final /* synthetic */ g tOT;
    final /* synthetic */ 2 tOU;
    final /* synthetic */ Context val$context;

    j$2$1(2 2, Context context, g gVar) {
        this.tOU = 2;
        this.val$context = context;
        this.tOT = gVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.ChattingMoreBtnBarHelper", "delete message");
        i.a(this.val$context, this.tOT.ctL(), this.tOU.tOS);
        this.tOU.tOS.cuQ();
    }
}
