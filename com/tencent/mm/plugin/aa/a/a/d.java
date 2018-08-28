package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ab.a;
import com.tencent.mm.ab.b;
import com.tencent.mm.protocal.c.c;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends a<c> {
    public d(String str, String str2) {
        b.a aVar = new b.a();
        com.tencent.mm.protocal.c.b bVar = new com.tencent.mm.protocal.c.b();
        bVar.qYc = str;
        bVar.qYd = str2;
        aVar.dIG = bVar;
        aVar.dIH = new c();
        aVar.uri = "/cgi-bin/mmpay-bin/newaaclosenotify";
        aVar.dIF = 1672;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        x.i("MicroMsg.CgiCloseAAUrgeNotify", "CgiCloseAAUrgeNotify, billNo: %s, chatroom: %s", new Object[]{str, str2});
    }
}
