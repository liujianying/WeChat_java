package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.websearch.api.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g.a;

public final class c {
    static /* synthetic */ boolean a(a aVar, c cVar) {
        if (!h(aVar)) {
            return false;
        }
        cVar.tZM.setVisibility(0);
        cVar.jet.setVisibility(0);
        cVar.jet.setText(R.l.top_story_chatting_app_msg_brand_name);
        cVar.tZJ.setVisibility(0);
        cVar.tZJ.setImageResource(R.g.top_story_logo_icon);
        return true;
    }

    public static void f(bd bdVar, String str) {
        au.Em().H(new 1(bdVar.field_content, str, bdVar.field_msgId));
    }

    static boolean h(a aVar) {
        q qVar = (q) aVar.u(q.class);
        if (qVar == null || bi.oW(qVar.pLr)) {
            return false;
        }
        return true;
    }
}
