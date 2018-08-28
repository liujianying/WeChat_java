package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.fm;
import com.tencent.mm.protocal.c.fn;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class r extends l implements k {
    private final b diG;
    private e diJ;
    private int hwY = 0;

    public r(LinkedList<String> linkedList) {
        a aVar = new a();
        aVar.dIG = new fm();
        aVar.dIH = new fn();
        aVar.uri = "/cgi-bin/micromsg-bin/batchdelcarditem";
        aVar.dIF = 560;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((fm) this.diG.dID.dIL).rgw = linkedList;
    }

    public final int getType() {
        return 560;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            LinkedList linkedList = ((fn) this.diG.dIE.dIL).rgx;
            String str2 = "MicroMsg.NetSceneBatchDelCardItem";
            String str3 = "onGYNetEnd, resp list count = %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(linkedList == null ? 0 : linkedList.size());
            x.i(str2, str3, objArr);
            if (linkedList == null || linkedList.size() == 0) {
                x.e("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd fail, resp list is null");
            } else {
                this.hwY = 0;
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    boolean z;
                    String str4 = (String) it.next();
                    if (TextUtils.isEmpty(str4)) {
                        x.e("MicroMsg.NetSceneBatchDelCardItem", "processDelCardItem fail, id is null");
                        z = false;
                    } else {
                        CardInfo cardInfo = new CardInfo();
                        cardInfo.field_card_id = str4;
                        z = am.axi().a(cardInfo, new String[0]);
                        x.i("MicroMsg.NetSceneBatchDelCardItem", "processDelCardItem, delRet = %b", new Object[]{Boolean.valueOf(z)});
                    }
                    if (!z) {
                        this.hwY++;
                    }
                }
                x.d("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, %d fail items", new Object[]{Integer.valueOf(this.hwY)});
            }
        }
        this.diJ.a(i2, i3, str, this);
    }
}
