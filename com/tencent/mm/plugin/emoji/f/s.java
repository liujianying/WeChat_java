package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bwk;
import com.tencent.mm.protocal.c.bwl;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.List;

public final class s extends l implements k {
    private final b diG;
    private e diJ;
    private int eKI;
    private List<String> iiZ = new ArrayList();

    public s(List<String> list, int i) {
        a aVar = new a();
        aVar.dIG = new bwk();
        aVar.dIH = new bwl();
        aVar.uri = "/cgi-bin/micromsg-bin/mmuploadmypanellist";
        aVar.dIF = 717;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.iiZ = list;
        this.eKI = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.emoji.NetSceneUploadMyPanelList", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            au.HU();
            c.DT().a(aa.a.sOR, Long.valueOf(System.currentTimeMillis()));
            au.HU();
            c.DT().a(aa.a.sOU, Boolean.valueOf(true));
            h.mEJ.a(165, 0, 1, false);
        } else {
            au.HU();
            c.DT().a(aa.a.sOR, Long.valueOf((System.currentTimeMillis() - 86400000) + 3600000));
            h.mEJ.a(165, 1, 1, false);
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 717;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        bwk bwk = (bwk) this.diG.dID.dIL;
        bwk.qZc = this.eKI;
        if (this.iiZ != null) {
            for (Object obj : this.iiZ) {
                Object obj2;
                if (!bi.oW(obj2) && obj2.equals(String.valueOf(EmojiGroupInfo.tcy))) {
                    obj2 = "com.tencent.xin.emoticon.tusiji";
                }
                bwk.ssL.add(obj2);
                x.d("MicroMsg.emoji.NetSceneUploadMyPanelList", "product id is:%s", new Object[]{obj2});
            }
            x.i("MicroMsg.emoji.NetSceneUploadMyPanelList", "opcode is:%d mProductIdList size:%s", new Object[]{Integer.valueOf(this.eKI), Integer.valueOf(this.iiZ.size())});
        }
        return a(eVar, this.diG, this);
    }
}
