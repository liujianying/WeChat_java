package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.fw;
import com.tencent.mm.protocal.c.fx;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class s extends l implements k {
    private final b diG;
    private e diJ;
    private LinkedList<ak> hwZ;
    public LinkedList<ak> hxa = new LinkedList();

    public s(LinkedList<ak> linkedList) {
        this.hwZ = linkedList;
        a aVar = new a();
        aVar.dIG = new fw();
        aVar.dIH = new fx();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetcarditem";
        aVar.dIF = 559;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((fw) this.diG.dID.dIL).rgw = G(linkedList);
    }

    public final int getType() {
        return 559;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            Object obj = ((fx) this.diG.dIE.dIL).hwU;
            if (TextUtils.isEmpty(obj)) {
                x.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd fail, resp json_ret is null");
                this.diJ.a(4, -1, null, this);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList xO = f.xO(obj);
            if (xO != null) {
                int i4;
                if (this.hwZ != null) {
                    this.hxa.addAll(this.hwZ);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                long dO = g.Ei().dqq.dO(Thread.currentThread().getId());
                int i5 = 0;
                int i6 = 0;
                Iterator it = xO.iterator();
                while (true) {
                    i4 = i5;
                    if (!it.hasNext()) {
                        break;
                    }
                    CardInfo cardInfo = (CardInfo) it.next();
                    i4++;
                    if (!com.tencent.mm.plugin.card.d.l.b(cardInfo)) {
                        i6++;
                        LinkedList linkedList = this.hxa;
                        if (cardInfo != null) {
                            ak akVar = new ak();
                            akVar.field_cardUserId = cardInfo.field_card_id;
                            linkedList.remove(akVar);
                        }
                    }
                    i5 = i6;
                }
                g.Ei().dqq.gp(dO);
                x.i("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd do transaction use time %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
                x.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, deal CardObject %d fail of %d", new Object[]{Integer.valueOf(i6), Integer.valueOf(i4)});
                com.tencent.mm.plugin.card.d.l.azQ();
                if (xO.size() > 0) {
                    i5 = (int) (System.currentTimeMillis() - currentTimeMillis);
                    ArrayList arrayList = new ArrayList();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(281);
                    iDKey.SetKey(43);
                    iDKey.SetValue(1);
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(281);
                    iDKey2.SetKey(44);
                    iDKey2.SetValue((long) i5);
                    IDKey iDKey3 = new IDKey();
                    iDKey3.SetID(281);
                    iDKey3.SetKey(45);
                    iDKey3.SetValue((long) xO.size());
                    IDKey iDKey4 = new IDKey();
                    iDKey4.SetID(281);
                    iDKey4.SetKey(47);
                    iDKey4.SetValue((long) (i5 / xO.size()));
                    arrayList.add(iDKey);
                    arrayList.add(iDKey2);
                    arrayList.add(iDKey3);
                    arrayList.add(iDKey4);
                    h.mEJ.b(arrayList, true);
                }
            }
            this.diJ.a(0, 0, str, this);
            return;
        }
        x.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.diJ.a(i2, i3, str, this);
    }

    private static LinkedList<String> G(LinkedList<ak> linkedList) {
        LinkedList<String> linkedList2 = new LinkedList();
        if (linkedList == null || linkedList.size() == 0) {
            return linkedList2;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ak akVar = (ak) it.next();
            if (akVar != null) {
                linkedList2.add(akVar.field_cardUserId);
            }
        }
        return linkedList2;
    }
}
