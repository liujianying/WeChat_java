package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.R;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bd;

public abstract class b extends c {
    protected static String c(String str, bd bdVar) {
        if (s.fq(str)) {
            String d = d(str, bdVar);
            return String.format(ad.getContext().getString(R.l.notification_msg_chatroom_template), new Object[]{h.PP(d), Character.valueOf(8203), h.aa(bdVar).jSA});
        }
        return String.format(ad.getContext().getString(R.l.notification_msg_single_template), new Object[]{h.aa(bdVar).jSA});
    }

    protected static String d(String str, bd bdVar) {
        if (!s.fq(str)) {
            return str;
        }
        int iA = com.tencent.mm.model.bd.iA(bdVar.field_content);
        if (iA == -1) {
            return str;
        }
        String trim = bdVar.field_content.substring(0, iA).trim();
        if (trim == null || trim.length() <= 0) {
            return str;
        }
        return trim;
    }
}
