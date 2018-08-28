package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ar.r;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.modelappbrand.h;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI;
import com.tencent.mm.ui.chatting.viewitems.ae.a;
import com.tencent.mm.ui.chatting.viewitems.ae.b;
import java.lang.ref.WeakReference;

final class ap implements a {
    ap() {
    }

    public final void b(b.a aVar, int i, com.tencent.mm.ui.chatting.c.a aVar2, bd bdVar) {
        String str;
        int i2;
        Bundle bundle;
        String talkerUserName = aVar2.getTalkerUserName();
        b bVar = (b) aVar;
        Bundle bundle2 = new Bundle();
        bundle2.putString("conv_talker_username", talkerUserName);
        if (aVar2.tTq instanceof AppBrandServiceChattingUI.a) {
            str = "scene";
            i2 = 10;
            bundle = bundle2;
        } else if (aVar2.cwr()) {
            str = "scene";
            i2 = 2;
            bundle = bundle2;
        } else {
            str = "scene";
            if (s.hf(talkerUserName)) {
                i2 = 7;
                bundle = bundle2;
            } else {
                i2 = 1;
                bundle = bundle2;
            }
        }
        bundle.putInt(str, i2);
        bundle2.putLong("msg_id", bdVar.field_msgId);
        bundle2.putLong("msg_sever_id", bdVar.field_msgSvrId);
        bundle2.putString("send_msg_username", bdVar.field_talker);
        CharSequence a = ((h) g.l(h.class)).a(bdVar.field_content, bundle2, new WeakReference(aVar2.tTq.getContext()), new WeakReference(bVar.ucQ));
        if (a == null || a.length() == 0) {
            bVar.jEz.setVisibility(8);
        } else {
            bVar.jEz.setVisibility(0);
            bVar.ucQ.setText(a);
            bVar.ucQ.setMovementMethod(ay.getInstance());
        }
        com.tencent.mm.ar.a mw = r.Qq().mw(talkerUserName);
        au.HU();
        i2 = ((Integer) c.DT().get(12311, Integer.valueOf(-2))).intValue();
        if ((mw == null || mw.ecv == -2) && (mw != null || i2 == -2)) {
            bVar.ucQ.setTextColor(aVar2.tTq.getContext().getResources().getColor(R.e.white_text_color));
            bVar.ucQ.setBackground(aVar2.tTq.getContext().getResources().getDrawable(R.g.chat_tips_bg));
        } else {
            bVar.ucQ.setTextColor(aVar2.tTq.getContext().getResources().getColor(R.e.black_text_color));
            bVar.ucQ.setBackground(aVar2.tTq.getContext().getResources().getDrawable(R.g.chat_tips_light_bg));
        }
        bVar.ucQ.setOnClickListener(new 1(this));
        bVar.ucQ.invalidate();
    }
}
