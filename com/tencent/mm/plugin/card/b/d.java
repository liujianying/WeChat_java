package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.ab.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.b.k.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.kx;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d implements e, a, com.tencent.mm.plugin.card.base.d {
    public WeakReference<Context> Wv;
    public List<WeakReference<a>> htB = new ArrayList();
    public HashMap<a, Boolean> htN = new HashMap();
    public HashMap<String, Boolean> htO = new HashMap();
    public HashMap<String, Boolean> htP = new HashMap();
    public b htQ = null;
    public boolean htR = false;
    public String htS;

    public final void release() {
        g.Eh().dpP.b(910, this);
        am.axp().b(this);
        b axh = am.axh();
        if (axh.htB != null && this != null) {
            for (int i = 0; i < axh.htB.size(); i++) {
                WeakReference weakReference = (WeakReference) axh.htB.get(i);
                if (weakReference != null) {
                    com.tencent.mm.plugin.card.base.d dVar = (com.tencent.mm.plugin.card.base.d) weakReference.get();
                    if (dVar != null && dVar.equals(this)) {
                        axh.htB.remove(weakReference);
                        break;
                    }
                }
            }
        }
        this.htB.clear();
        this.htN.clear();
        this.htP.clear();
        this.htR = false;
    }

    public final void a(a aVar) {
        if (this.htB == null) {
            this.htB = new ArrayList();
        }
        if (aVar != null) {
            this.htB.add(new WeakReference(aVar));
        }
    }

    public final void b(a aVar) {
        if (this.htB != null && aVar != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.htB.size()) {
                    WeakReference weakReference = (WeakReference) this.htB.get(i2);
                    if (weakReference != null) {
                        a aVar2 = (a) weakReference.get();
                        if (aVar2 != null && aVar2.equals(aVar)) {
                            this.htB.remove(weakReference);
                            return;
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final void d(b bVar) {
        boolean z = false;
        this.htQ = bVar;
        if (!(!this.htR || this.htQ == null || bVar.awq() == null || bVar.awq().equals(this.htQ.awq()))) {
            this.htR = false;
        }
        if (this.htB != null) {
            while (true) {
                boolean z2 = z;
                if (z2 < this.htB.size()) {
                    WeakReference weakReference = (WeakReference) this.htB.get(z2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        Boolean bool = (Boolean) this.htN.get(aVar);
                        if (!(aVar == null || bool == null || bool.booleanValue())) {
                            aVar.f(bVar);
                        }
                    }
                    z = z2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final void a(a aVar, boolean z) {
        if (this.htN == null) {
            this.htN = new HashMap();
        }
        this.htN.put(aVar, Boolean.valueOf(z));
    }

    public final void c(a aVar) {
        if (this.htN == null) {
            this.htN = new HashMap();
        }
        this.htN.remove(aVar);
    }

    public final void awx() {
        x.i("MicroMsg.CardConsumedMgr", "onDBchange()");
        if (this.htQ == null) {
            x.e("MicroMsg.CardConsumedMgr", "onDBchange(), do nothing, mCardInfo == null");
            return;
        }
        b xC;
        if (this.htQ.avS()) {
            xC = am.axq().xC(this.htQ.awq());
        } else {
            xC = am.axi().xm(this.htQ.awq());
        }
        if (xC != null && xC.awn() != null && this.htQ != null && this.htQ.awn() != null) {
            x.d("MicroMsg.CardConsumedMgr", "onDBchange() oldState %s, newStatus %s, isDoingConsumedInfo %s, isShareCard %s", new Object[]{Integer.valueOf(this.htQ.awn().status), Integer.valueOf(xC.awn().status), Boolean.valueOf(this.htR), Boolean.valueOf(this.htQ.avS())});
            if (this.htQ.avS() && (this.htQ instanceof ShareCardInfo)) {
                x.d("MicroMsg.CardConsumedMgr", "onDBchange() shareCardState %s", new Object[]{Integer.valueOf(((ShareCardInfo) this.htQ).field_status)});
            } else if (this.htQ.avS()) {
                x.e("MicroMsg.CardConsumedMgr", "onDBchange() mCardInfo is ShareCard, but not the ShareCardInfo instance!");
            }
            if (xC.awn().status != r2) {
                awF();
                if (this.htQ.avS() && !this.htR && xC.awn().status == 1) {
                    x.i("MicroMsg.CardConsumedMgr", "onDBchange(), need to get the consumedinfo , don't finish UI!");
                    Boolean bool = (Boolean) this.htO.get(this.htQ.awq());
                    if (bool == null || !bool.booleanValue()) {
                        x.i("MicroMsg.CardConsumedMgr", "consumed is null or consumed is false!");
                        long currentTimeMillis = System.currentTimeMillis();
                        Context context = (Context) this.Wv.get();
                        x.i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.htQ.awq());
                        com.tencent.mm.plugin.card.sharecard.a.b.a(context, this.htQ);
                        this.htO.put(this.htQ.awq(), Boolean.valueOf(true));
                        long currentTimeMillis2 = System.currentTimeMillis();
                        ArrayList arrayList = new ArrayList();
                        IDKey iDKey = new IDKey();
                        iDKey.SetID(281);
                        iDKey.SetKey(30);
                        iDKey.SetValue(1);
                        IDKey iDKey2 = new IDKey();
                        iDKey2.SetID(281);
                        iDKey2.SetKey(31);
                        iDKey2.SetValue((long) ((int) (currentTimeMillis2 - currentTimeMillis)));
                        arrayList.add(iDKey);
                        arrayList.add(iDKey2);
                        h.mEJ.b(arrayList, true);
                    } else {
                        x.i("MicroMsg.CardConsumedMgr", "consumed:" + bool.booleanValue());
                    }
                    awH();
                } else if (this.htQ.avS() && this.htR) {
                    x.i("MicroMsg.CardConsumedMgr", "onDBchange(), is getting the consumedinfo!");
                } else {
                    x.i("MicroMsg.CardConsumedMgr", "onDBchange(),finish CardConsumeCodeUI!");
                    awG();
                }
                x.i("MicroMsg.CardConsumedMgr", "onDBchange(),card coupon is consumde success!");
            }
            this.htQ = xC;
            e(this.htQ);
        }
    }

    public final void auM() {
        awF();
    }

    public final void a(com.tencent.mm.plugin.card.model.g gVar) {
        x.i("MicroMsg.CardConsumedMgr", "onChange()");
        x.i("MicroMsg.CardConsumedMgr", "card msg card id is " + gVar.field_card_id);
        if (this.htQ == null) {
            x.e("MicroMsg.CardConsumedMgr", "onChange(), do nothing, mCardInfo == null");
            awG();
            return;
        }
        x.i("MicroMsg.CardConsumedMgr", "card msg card id is " + gVar.field_card_id);
        if (this.htQ.avR() && gVar.field_card_id != null && gVar.field_card_id.equals(this.htQ.awq()) && gVar.hwz == 3) {
            x.i("MicroMsg.CardConsumedMgr", "it is card type, don't do NetSceneGetShareCardConsumedInfo! finish UI");
            awG();
        } else if (!this.htQ.avS()) {
            x.i("MicroMsg.CardConsumedMgr", "it is not card type, don't update share card data!");
            awG();
        } else if (gVar.hwz == 3 || !(gVar.field_card_id == null || !gVar.field_card_id.equals(this.htQ.awq()) || TextUtils.isEmpty(gVar.field_consumed_box_id))) {
            long currentTimeMillis = System.currentTimeMillis();
            x.i("MicroMsg.CardConsumedMgr", "consumed share card msg,  update share card data!");
            kx awn;
            if (gVar.field_card_id != null && gVar.field_card_id.equals(this.htQ.awq())) {
                ShareCardInfo xC = am.axq().xC(this.htQ.awq());
                if (!(xC == null || xC.awn() == null)) {
                    int i = this.htQ.awn().status;
                    x.d("MicroMsg.CardConsumedMgr", "onChange() current oldState %s, newStatus %s, shareCardStatus %s", new Object[]{Integer.valueOf(i), Integer.valueOf(xC.awn().status), Integer.valueOf(((ShareCardInfo) this.htQ).field_status)});
                    if (xC.awn().status != i) {
                        awF();
                    } else if (i != 1) {
                        x.i("MicroMsg.CardConsumedMgr", "share card oldState status is " + i);
                        awn = this.htQ.awn();
                        awn.status = 1;
                        ((ShareCardInfo) this.htQ).field_status = 1;
                        this.htQ.a(awn);
                        l.j(this.htQ);
                    }
                }
            } else if (gVar.field_card_id != null) {
                ShareCardInfo xC2 = am.axq().xC(gVar.field_card_id);
                if (xC2 == null || xC2.awn() == null) {
                    x.w("MicroMsg.CardConsumedMgr", "tempCard is null");
                } else {
                    x.d("MicroMsg.CardConsumedMgr", "onChange() not current oldState %s,shareCardStatus %s", new Object[]{Integer.valueOf(xC2.awn().status), Integer.valueOf(xC2.field_status)});
                    if (xC2.awn().status != 1) {
                        awn = xC2.awn();
                        awn.status = 1;
                        xC2.field_status = 1;
                        xC2.a(awn);
                        l.j(xC2);
                    }
                }
            }
            e(this.htQ);
            Boolean bool = (Boolean) this.htO.get(this.htQ.awq());
            if (bool == null || !bool.booleanValue()) {
                Context context = (Context) this.Wv.get();
                x.i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.htQ.awq());
                com.tencent.mm.plugin.card.sharecard.a.b.a(context, this.htQ);
                this.htO.put(this.htQ.awq(), Boolean.valueOf(true));
                long currentTimeMillis2 = System.currentTimeMillis();
                ArrayList arrayList = new ArrayList();
                IDKey iDKey = new IDKey();
                iDKey.SetID(281);
                iDKey.SetKey(30);
                iDKey.SetValue(1);
                IDKey iDKey2 = new IDKey();
                iDKey2.SetID(281);
                iDKey2.SetKey(31);
                iDKey2.SetValue((long) ((int) (currentTimeMillis2 - currentTimeMillis)));
                arrayList.add(iDKey);
                arrayList.add(iDKey2);
                h.mEJ.b(arrayList, true);
            } else {
                x.i("MicroMsg.CardConsumedMgr", "consumed:" + bool.booleanValue());
            }
            awH();
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i("MicroMsg.CardConsumedMgr", "onSceneEnd, errType = " + i + " errCode = " + i2);
        if (i == 0 && i2 == 0) {
            if (lVar instanceof com.tencent.mm.plugin.card.sharecard.model.d) {
                com.tencent.mm.plugin.card.sharecard.model.d dVar = (com.tencent.mm.plugin.card.sharecard.model.d) lVar;
                if (TextUtils.isEmpty(dVar.hwU)) {
                    x.e("MicroMsg.CardConsumedMgr", "consumed return json is empty!");
                } else {
                    xd(dVar.hwU);
                }
                this.htR = false;
                x.e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo ok! finish UI!");
                awG();
            }
        } else if (lVar instanceof com.tencent.mm.plugin.card.sharecard.model.d) {
            this.htR = false;
            x.e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo failed! finish UI!");
            awG();
        }
    }

    private void xd(String str) {
        x.i("MicroMsg.CardConsumedMgr", "startConsumedSuccUI()");
        if (this.htB != null) {
            int i = 0;
            boolean z = false;
            while (i < this.htB.size()) {
                boolean z2;
                WeakReference weakReference = (WeakReference) this.htB.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    Boolean bool = (Boolean) this.htN.get(aVar);
                    if (!(aVar == null || bool == null || !bool.booleanValue())) {
                        aVar.xe(str);
                        z2 = true;
                        i++;
                        z = z2;
                    }
                }
                z2 = z;
                i++;
                z = z2;
            }
            Boolean bool2 = (Boolean) this.htO.get(this.htQ.awq());
            if (z) {
                x.i("MicroMsg.CardConsumedMgr", "onStartConsumedSuccUI is handled!");
                this.htS = "";
            } else if (bool2 != null && bool2.booleanValue()) {
                x.i("MicroMsg.CardConsumedMgr", "add to launch pending list!");
                this.htS = str;
                this.htP.put(this.htQ.awq(), Boolean.valueOf(true));
            }
        }
    }

    private void e(b bVar) {
        x.i("MicroMsg.CardConsumedMgr", "doUpdateCardInfo()");
        if (this.htB != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.htB.size()) {
                    WeakReference weakReference = (WeakReference) this.htB.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.f(bVar);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void awF() {
        x.i("MicroMsg.CardConsumedMgr", "doVibrate()");
        if (this.htB != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.htB.size()) {
                    WeakReference weakReference = (WeakReference) this.htB.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.awJ();
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void awG() {
        x.i("MicroMsg.CardConsumedMgr", "doFinishUI()");
        if (this.htB != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.htB.size()) {
                    WeakReference weakReference = (WeakReference) this.htB.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.awK();
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void awH() {
        x.i("MicroMsg.CardConsumedMgr", "needDoConsumedInfo(), need to do NetSceneGetShareCardConsumedInfo. ");
        awI();
    }

    private synchronized void awI() {
        if (this.htR) {
            x.i("MicroMsg.CardConsumedMgr", "isDoingConsumedInfo is true, is doing NetSceneGetShareCardConsumedInfo. return");
        } else {
            x.i("MicroMsg.CardConsumedMgr", "isDoingConsumedInfo is false, do NetSceneGetShareCardConsumedInfo. ");
            this.htR = true;
            g.Eh().dpP.a(new com.tencent.mm.plugin.card.sharecard.model.d(this.htQ.awq(), "", ""), 0);
        }
    }
}
