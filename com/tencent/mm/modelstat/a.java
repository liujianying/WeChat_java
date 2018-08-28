package com.tencent.mm.modelstat;

import com.tencent.mm.model.q;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

public final class a {
    public static void a(bd bdVar, a aVar) {
        if (!bi.oW(bdVar.cGK)) {
            int i;
            d dVar = new d();
            dVar.r("20ExpIdStr", bdVar.cGK + ",");
            dVar.r("21OpType", aVar.value + ",");
            dVar.r("22msgId", bdVar.field_msgSvrId + ",");
            dVar.r("23MessageType", bdVar.getType() + ",");
            if (bdVar.aQm()) {
                com.tencent.mm.y.g.a J = com.tencent.mm.y.g.a.J(bdVar.field_content, bdVar.field_reserved);
                i = J == null ? 0 : J.type;
            } else {
                i = 0;
            }
            String str = bdVar.field_talker;
            dVar.r("24AppMsgInnerType", i + ",");
            dVar.r("25curUsername", str + ",");
            String str2 = "";
            if (bdVar.field_isSend == 1) {
                str2 = q.GF();
            } else if (str == null || !str.endsWith("@chatroom")) {
                str2 = str;
            } else if (bdVar.field_content != null) {
                int iA = com.tencent.mm.model.bd.iA(bdVar.field_content);
                if (iA != -1) {
                    str2 = bdVar.field_content.substring(0, iA).trim();
                }
            }
            dVar.r("26msgPostUserName", str2 + ",");
            dVar.r("27MediaState", bdVar.cGL + ",");
            x.v("MicroMsg.ChattingExpUtil", "report logbuffer(13564): [chatting_exp]" + dVar.wF());
            h.mEJ.h(13564, new Object[]{dVar});
        }
    }
}
