package com.tencent.mm.plugin.card.sharecard.model;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ahu;
import com.tencent.mm.protocal.c.ahv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class e extends l implements k {
    private final b diG;
    private com.tencent.mm.ab.e diJ;
    public LinkedList<String> hwZ;
    public LinkedList<String> hxa = new LinkedList();

    public e(LinkedList<String> linkedList) {
        this.hwZ = linkedList;
        a aVar = new a();
        aVar.dIG = new ahu();
        aVar.dIH = new ahv();
        aVar.uri = "/cgi-bin/micromsg-bin/getsharecardlist";
        aVar.dIF = 903;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((ahu) this.diG.dID.dIL).rgw = linkedList;
        x.i("MicroMsg.NetSceneGetShareCardList", "card_ids length is " + linkedList.size());
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(903), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            ahv ahv = (ahv) this.diG.dIE.dIL;
            x.v("MicroMsg.NetSceneGetShareCardList", "json:" + ahv.hwU);
            Object obj = ahv.hwU;
            if (TextUtils.isEmpty(obj)) {
                x.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd fail, resp json_ret is null");
                this.diJ.a(4, -1, null, this);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList xN = f.xN(obj);
            if (xN != null) {
                if (this.hwZ != null) {
                    this.hxa.addAll(this.hwZ);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                long dO = g.Ei().dqq.dO(Thread.currentThread().getId());
                int i4 = 0;
                Iterator it = xN.iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    ShareCardInfo shareCardInfo = (ShareCardInfo) it.next();
                    i4++;
                    if (com.tencent.mm.plugin.card.d.l.a(shareCardInfo)) {
                        x.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd update share card count");
                        com.tencent.mm.plugin.card.sharecard.a.b.aa(ad.getContext(), shareCardInfo.field_card_tp_id);
                        if (shareCardInfo.field_status != 0) {
                            com.tencent.mm.plugin.card.sharecard.a.b.cb(shareCardInfo.field_card_id, shareCardInfo.field_card_tp_id);
                        }
                    } else {
                        i5++;
                        this.hxa.remove(shareCardInfo.field_card_id);
                    }
                }
                g.Ei().dqq.gp(dO);
                x.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd do transaction use time %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
                x.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, deal CardObject %d fail of %d", new Object[]{Integer.valueOf(i5), Integer.valueOf(i4)});
                com.tencent.mm.plugin.card.d.l.azS();
                if (xN.size() > 0) {
                    int currentTimeMillis3 = (int) (System.currentTimeMillis() - currentTimeMillis);
                    ArrayList arrayList = new ArrayList();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(281);
                    iDKey.SetKey(17);
                    iDKey.SetValue(1);
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(281);
                    iDKey2.SetKey(18);
                    iDKey2.SetValue((long) currentTimeMillis3);
                    IDKey iDKey3 = new IDKey();
                    iDKey3.SetID(281);
                    iDKey3.SetKey(19);
                    iDKey3.SetValue((long) xN.size());
                    IDKey iDKey4 = new IDKey();
                    iDKey4.SetID(281);
                    iDKey4.SetKey(21);
                    iDKey4.SetValue((long) (currentTimeMillis3 / xN.size()));
                    arrayList.add(iDKey);
                    arrayList.add(iDKey2);
                    arrayList.add(iDKey3);
                    arrayList.add(iDKey4);
                    h.mEJ.b(arrayList, true);
                }
            }
            this.diJ.a(i2, i3, str, this);
            return;
        }
        x.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 903;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
