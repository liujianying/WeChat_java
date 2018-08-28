package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ab.a;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.protocal.c.bvi;
import com.tencent.mm.protocal.c.bvj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

public final class s extends a<bvj> {
    private final String fdE;
    private final bvi fmA;
    private final b fmB;
    public volatile v.a fmC;

    protected final /* synthetic */ void a(int i, int i2, String str, bhp bhp, l lVar) {
        bvj bvj = (bvj) bhp;
        x.i("MicroMsg.AppBrand.CgiUpdateWxaUsageRecord", "onCgiBack, req [scene %d, background %b, versionType %d, recordType %d, op %d, username %s]resp [errType %d, errCode %d, errMsg %s, resp %s]", new Object[]{Integer.valueOf(this.fmA.scene), Integer.valueOf(this.fmA.srW), Integer.valueOf(this.fmA.rka), Integer.valueOf(this.fmA.srX), Integer.valueOf(this.fmA.srY), this.fmA.username, Integer.valueOf(i), Integer.valueOf(i2), str, bvj});
        if (this.fmC != null) {
            this.fmC.a(i, i2, str, this.fmB, lVar);
        }
    }

    public s(int i, boolean z, int i2, int i3, int i4, String str, int i5, String str2) {
        this.fdE = str2;
        b.a aVar = new b.a();
        bvi bvi = new bvi();
        if (i == 0) {
            i = BaseReportManager.MAX_READ_COUNT;
        }
        bvi.scene = i;
        bvi.srW = z ? 1 : 0;
        bvi.rka = i2;
        bvi.srX = i3;
        bvi.srY = i4;
        bvi.username = str;
        bvi.aAk = i5;
        bvi.srZ = str2;
        this.fmA = bvi;
        aVar.dIG = bvi;
        aVar.dIH = new bvj();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/updatewxausagerecord";
        aVar.dIF = 1149;
        b KT = aVar.KT();
        this.fmB = KT;
        this.diG = KT;
    }
}
