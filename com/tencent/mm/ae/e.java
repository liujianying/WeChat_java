package com.tencent.mm.ae;

import android.database.Cursor;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.az.b;
import com.tencent.mm.storage.bd;

public final class e extends ah {
    public final boolean gV(int i) {
        return i != 0 && i < 604372991;
    }

    public final void transfer(int i) {
        x.d("MicroMsg.ConversationDataTransfer", "the previous version is %d", new Object[]{Integer.valueOf(i)});
        if (i != 0 && i < 604372991) {
            h.mEJ.e(336, 14, 1);
            au.HU();
            com.tencent.mm.bt.h FO = c.FO();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select rconversation.username from rconversation, rcontact, bizinfo where rconversation.username = rcontact.username and rconversation.username = bizinfo.username and ( rcontact.verifyFlag & 8").append(" ) != 0 ");
            x.d("MicroMsg.ConversationDataTransfer", "select sql %s", new Object[]{stringBuilder.toString()});
            Cursor b = FO.b(r1, null, 2);
            if (b != null && b.moveToFirst()) {
                ai aiVar;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Update rconversation set parentRef = 'officialaccounts' where 1 !=1 ");
                do {
                    String string = b.getString(0);
                    if (!s.hM(string)) {
                        stringBuilder.append(" or username = '").append(string).append("'");
                    }
                } while (b.moveToNext());
                b.close();
                x.d("MicroMsg.ConversationDataTransfer", "changed[%B] exec sql[%s]", new Object[]{Boolean.valueOf(true), stringBuilder.toString()});
                FO.fV("rconversation", r1);
                au.HU();
                ai Yq = c.FW().Yq("officialaccounts");
                if (Yq == null) {
                    Yq = new ai("officialaccounts");
                    Yq.clx();
                    au.HU();
                    c.FW().d(Yq);
                    aiVar = Yq;
                } else {
                    aiVar = Yq;
                }
                au.HU();
                String clI = c.FW().clI();
                if (bi.oW(clI)) {
                    x.w("MicroMsg.ConversationDataTransfer", "last convBiz is null");
                    return;
                }
                au.HU();
                bd GE = c.FT().GE(clI);
                if (GE == null || GE.field_msgId == 0) {
                    x.w("MicroMsg.ConversationDataTransfer", "last biz msg is error");
                    return;
                }
                aiVar.aj(GE);
                aiVar.setContent(GE.field_talker + ":" + GE.field_content);
                aiVar.ec(Integer.toString(GE.getType()));
                au.HU();
                b vu = c.FW().vu();
                if (vu != null) {
                    PString pString = new PString();
                    PString pString2 = new PString();
                    PInt pInt = new PInt();
                    GE.ep("officialaccounts");
                    GE.setContent(aiVar.field_content);
                    vu.a(GE, pString, pString2, pInt, false);
                    aiVar.ed(pString.value);
                    aiVar.ee(pString2.value);
                    aiVar.eY(pInt.value);
                }
                au.HU();
                c.FW().a(aiVar, aiVar.field_username);
            }
            if (b != null && !b.isClosed()) {
                b.close();
            }
        }
    }

    public final String getTag() {
        return "MicroMsg.ConversationDataTransfer";
    }
}
