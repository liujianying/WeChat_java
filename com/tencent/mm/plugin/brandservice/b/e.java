package com.tencent.mm.plugin.brandservice.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ai;
import com.tencent.mm.protocal.c.yu;
import com.tencent.mm.protocal.c.yv;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class e extends l implements k {
    private final b diG;
    private com.tencent.mm.ab.e diJ;
    LinkedList<String> hnM;

    public e() {
        a aVar = new a();
        aVar.dIG = new yu();
        aVar.dIH = new yv();
        aVar.uri = "/cgi-bin/micromsg-bin/getapplist";
        aVar.dIF = 387;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.hnM = new LinkedList();
        yu yuVar = (yu) this.diG.dID.dIL;
        g.Ek();
        Object obj = g.Ei().DT().get(196610, null);
        String str = "MicroMsg.BrandService.BrandServiceApplication";
        String str2 = "get config, key[%d], value[%s]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(196610);
        objArr[1] = obj == null ? "null" : obj.toString();
        x.i(str, str2, objArr);
        yuVar.rEY = bi.a((Integer) obj, 0);
        x.i("MicroMsg.BrandService.NetSceneGetAppList", "info: request hash code %d", new Object[]{Integer.valueOf(yuVar.rEY)});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.w("MicroMsg.BrandService.NetSceneGetAppList", "on scene end code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            yv yvVar = (yv) this.diG.dIE.dIL;
            x.i("MicroMsg.BrandService.NetSceneGetAppList", "ok, hash code is %d, count is %d", new Object[]{Integer.valueOf(yvVar.rEY), Integer.valueOf(yvVar.hbF)});
            x.i("MicroMsg.BrandService.NetSceneGetAppList", "result list is %s", new Object[]{yvVar.hbG.toString()});
            com.tencent.mm.plugin.brandservice.a.g(196610, Integer.valueOf(yvVar.rEY));
            Iterator it = yvVar.hbG.iterator();
            while (it.hasNext()) {
                this.hnM.add(((ai) it.next()).hbL);
            }
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 387;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        x.i("MicroMsg.BrandService.NetSceneGetAppList", "do scene");
        return a(eVar, this.diG, this);
    }
}
