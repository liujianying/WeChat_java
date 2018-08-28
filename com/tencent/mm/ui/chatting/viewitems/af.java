package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ar.r;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.viewitems.ae.a;
import com.tencent.mm.ui.chatting.viewitems.ae.b;

final class af implements a {
    af() {
    }

    public final void b(b.a aVar, int i, com.tencent.mm.ui.chatting.c.a aVar2, bd bdVar) {
        b bVar = (b) aVar;
        bVar.ucQ.setText(bdVar.field_content);
        Bundle bundle = new Bundle();
        bundle.putString("chatroom_name", aVar2.getTalkerUserName());
        bundle.putLong("msg_id", bdVar.field_msgId);
        if ((bdVar.field_flag & 8) != 0) {
            j.a(bVar.ucQ, false, bundle);
            bVar.ucQ.setClickable(true);
        } else {
            j.a(bVar.ucQ, bundle);
        }
        com.tencent.mm.ar.a mw = r.Qq().mw(aVar2.getTalkerUserName());
        au.HU();
        int intValue = ((Integer) c.DT().get(12311, Integer.valueOf(-2))).intValue();
        if ((mw == null || mw.ecv == -2) && (mw != null || intValue == -2)) {
            bVar.ucQ.setTextColor(aVar2.tTq.getContext().getResources().getColor(R.e.white_text_color));
            bVar.ucQ.setBackground(aVar2.tTq.getContext().getResources().getDrawable(R.g.chat_tips_bg));
        } else {
            bVar.ucQ.setTextColor(aVar2.tTq.getContext().getResources().getColor(R.e.black_text_color));
            bVar.ucQ.setBackground(aVar2.tTq.getContext().getResources().getDrawable(R.g.chat_tips_light_bg));
        }
        bVar.ucQ.invalidate();
    }
}
