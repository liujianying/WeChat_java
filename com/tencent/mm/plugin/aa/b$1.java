package com.tencent.mm.plugin.aa;

import com.tencent.mm.g.a.mm;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.aa.a.a;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

class b$1 extends c<mm> {
    final /* synthetic */ b ezx;

    b$1(b bVar) {
        this.ezx = bVar;
        super(0);
        this.sFo = mm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mm mmVar = (mm) bVar;
        String str = "MicroMsg.SubCoreAA";
        String str2 = "receiveAANewXmlEventListener, content==null: %s, type: %s, fromUser: %s, toUser: %s, paymsgid: %s";
        Object[] objArr = new Object[5];
        objArr[0] = Boolean.valueOf(mmVar.bXt.content == null);
        objArr[1] = Integer.valueOf(mmVar.bXt.type);
        objArr[2] = mmVar.bXt.bSS;
        objArr[3] = mmVar.bXt.toUser;
        objArr[4] = mmVar.bXt.bXu;
        x.i(str, str2, objArr);
        if (mmVar.bXt.type == a.ezZ) {
            h.aK(mmVar.bXt.content, mmVar.bXt.toUser);
        } else if (mmVar.bXt.type == a.eAa) {
            h.w(mmVar.bXt.content, mmVar.bXt.toUser, mmVar.bXt.bXu);
        } else if (mmVar.bXt.type == a.eAb) {
            String str3 = mmVar.bXt.content;
            str = mmVar.bXt.toUser;
            x.i("MicroMsg.AAUtil", "insertUrgePaySysMsg, toUser: %s", new Object[]{str});
            if (!bi.oW(str3) && s.fq(str)) {
                bd bdVar = new bd();
                bdVar.eX(0);
                bdVar.ep(str);
                bdVar.setStatus(3);
                bdVar.setContent(str3);
                bdVar.ay(com.tencent.mm.model.bd.o(str3, System.currentTimeMillis() / 1000));
                bdVar.setType(10000);
                bdVar.fg(bdVar.field_flag | 8);
                bdVar.setMsgId(com.tencent.mm.model.bd.i(bdVar));
            }
        }
        return false;
    }
}
