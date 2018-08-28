package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.ag;

class ak$1 implements OnClickListener {
    final /* synthetic */ bd ueR;
    final /* synthetic */ int ueS;
    final /* synthetic */ ak ueT;

    ak$1(ak akVar, bd bdVar, int i) {
        this.ueT = akVar;
        this.ueR = bdVar;
        this.ueS = i;
    }

    public final void onClick(View view) {
        if (ai.oW(this.ueR.field_imgPath)) {
            x.d("MicroMsg.ChattingItemVoiceRemindConfirm", "filename is null");
        } else {
            ((ag) ak.a(this.ueT).O(ag.class)).cwl().b(this.ueS, this.ueR);
        }
    }
}
