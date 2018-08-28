package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ab.a;
import com.tencent.mm.ab.b;
import com.tencent.mm.protocal.c.abw;
import com.tencent.mm.protocal.c.abx;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public final class c extends a<abx> {
    public c(String str) {
        b.a aVar = new b.a();
        abw abw = new abw();
        abw.rvj = str;
        aVar.dIG = abw;
        aVar.dIH = new abx();
        aVar.uri = "/cgi-bin/micromsg-bin/getchatroominfodetail";
        aVar.dIF = TbsListener$ErrorCode.EXCEED_LZMA_RETRY_NUM;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }
}
