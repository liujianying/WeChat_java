package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.b.b.ag;
import com.tencent.mm.ui.chatting.d;

class al$2 implements OnClickListener {
    final /* synthetic */ bd ueR;
    final /* synthetic */ int ueS;
    final /* synthetic */ al ueZ;

    al$2(al alVar, bd bdVar, int i) {
        this.ueZ = alVar;
        this.ueR = bdVar;
        this.ueS = i;
    }

    public final void onClick(View view) {
        if (bi.oW(this.ueR.field_imgPath)) {
            x.d("MicroMsg.ChattingItemVoiceRemindRemind", "filename is null");
            return;
        }
        d cwl = ((ag) al.c(this.ueZ).O(ag.class)).cwl();
        int i = this.ueS;
        bd bdVar = this.ueR;
        if (bdVar != null) {
            cwl.csL();
            au.HU();
            Boolean bool = (Boolean) c.DT().get(4115, null);
            if (bool == null || !bool.booleanValue()) {
                au.HU();
                c.DT().set(4115, Boolean.valueOf(true));
                cwl.csR();
                cwl.tHi = s.a(cwl.bAG.tTq.getActivity(), cwl.context.getString(R.l.chatting_music_volumn_change), 4000);
            }
            if (cwl.iWF.isPlaying() && bdVar.field_msgId == cwl.tHf) {
                cwl.csQ();
                return;
            }
            cwl.ao(bdVar);
            if (bdVar.field_isSend == 0 && !q.F(bdVar)) {
                cwl.EG(i + 1);
            }
            cwl.bhU();
        }
    }
}
