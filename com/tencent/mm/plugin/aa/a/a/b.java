package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ab.a;
import com.tencent.mm.protocal.c.r;
import com.tencent.mm.protocal.c.s;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends a<s> {
    public b(String str, String str2, int i) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        r rVar = new r();
        rVar.qYc = str;
        rVar.qYd = str2;
        rVar.scene = i;
        aVar.dIG = rVar;
        aVar.dIH = new s();
        aVar.uri = "/cgi-bin/mmpay-bin/newaapayurge";
        aVar.dIF = 1644;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        x.i("MicroMsg.CgiAAPayUrge", "CgiAAPayUrge, billNo: %s, chatroom: %s, scene: %s", new Object[]{str, str2, Integer.valueOf(i)});
    }
}
