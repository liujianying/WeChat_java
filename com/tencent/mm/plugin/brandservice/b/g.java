package com.tencent.mm.plugin.brandservice.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bgj;
import com.tencent.mm.protocal.c.bgk;
import com.tencent.mm.protocal.c.if;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class g extends l implements k {
    private b diG;
    private e diJ;

    public g(LinkedList<if> linkedList, int i, int i2) {
        a aVar = new a();
        aVar.dIG = new bgj();
        aVar.dIH = new bgk();
        aVar.uri = "/cgi-bin/micromsg-bin/reportshow";
        aVar.dIF = 2645;
        aVar.dII = 176;
        aVar.dIJ = 1000000176;
        this.diG = aVar.KT();
        bgj bgj = (bgj) this.diG.dID.dIL;
        bgj.shp = linkedList;
        bgj.shq = i;
        bgj.shr = i2;
        x.i("MicroMsg.NetSceneReportBizListShowInfo", "reportshow report_list size %d,enter_pos %d,exit_pos %d", new Object[]{Integer.valueOf(bgj.shp.size()), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 2645;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
