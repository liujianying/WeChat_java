package com.tencent.mm.plugin.card.b;

import com.tencent.mm.ab.e;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ae;
import com.tencent.mm.plugin.card.model.ah;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.c.ayl;
import com.tencent.mm.protocal.c.bcz;
import com.tencent.mm.protocal.c.bda;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g implements e {
    public List<WeakReference<a>> htB = new ArrayList();
    public c htX;
    public int htY;
    public al htZ = new al(new 1(this), false);

    public final void release() {
        this.htY = 0;
        awD();
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "removeNetSceneListener!");
        com.tencent.mm.kernel.g.Eh().dpP.b(1382, this);
        com.tencent.mm.kernel.g.Eh().dpP.b(1275, this);
    }

    public final void a(b bVar, q qVar) {
        if (!g(bVar)) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode !");
            U(2, "");
        } else if (!l.isNetworkAvailable(ad.getContext())) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "isNetworkAvailable false cannot connet network!");
            U(-1, "");
        } else if (this.htY >= 3) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doRequestNetSceneGetDynamicQrcode is  limit requestcount:" + this.htY + ",cannot request!");
        } else {
            a(bVar.awq(), qVar);
            this.htY++;
        }
    }

    public final void a(q qVar) {
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard! fromScene=%d", new Object[]{Integer.valueOf(qVar.scene)});
        List<CardInfo> awW = am.axi().awW();
        if (awW.isEmpty()) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard do update all offileQrcode is failure! is dynamic cardList is empyt!fromScene=%d", new Object[]{Integer.valueOf(qVar.scene)});
            return;
        }
        for (CardInfo cardInfo : awW) {
            if (cardInfo == null) {
                x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  is failure! cardInfo is null fromScene=%d", new Object[]{Integer.valueOf(qVar.scene)});
            } else if (qVar == null) {
                x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  is failure! fromScene is null!");
            } else {
                x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  get dynamic code! cardId= %s,fromScene=%d", new Object[]{cardInfo.awq(), Integer.valueOf(qVar.scene)});
                if (g(cardInfo)) {
                    int i;
                    String awq = cardInfo.awq();
                    i xn = am.axx().xn(awq);
                    if (xn == null) {
                        i = 1;
                    } else {
                        List xo = am.axw().xo(awq);
                        if (xo.isEmpty()) {
                            i = 1;
                        } else if (xo.size() < xn.field_lower_bound) {
                            this.htX = c.hIC;
                            i = 1;
                        } else if (a(xn)) {
                            this.htX = c.hIw;
                            i = 1;
                        } else {
                            i = 0;
                        }
                    }
                    if (i == 0) {
                        x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "do not need  get qrCode!  cardId =%s,fromScene=%d", new Object[]{cardInfo.awq(), Integer.valueOf(qVar.scene)});
                    } else {
                        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard doNetSceneGetDynamicQrcode! fromScene=%d", new Object[]{Integer.valueOf(qVar.scene)});
                        a(cardInfo.awq(), qVar);
                    }
                } else {
                    x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode ! cardId =%s", new Object[]{cardInfo.awq()});
                }
            }
        }
    }

    public final void b(com.tencent.mm.plugin.card.model.g gVar) {
        String str = gVar.field_card_id;
        com.tencent.mm.plugin.card.model.l axw = am.axw();
        List xo;
        k xq;
        if (gVar.hwA) {
            xo = am.axw().xo(str);
            xq = axw.xq(str);
            x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is true! delete all card code data by card_id=%s", new Object[]{str});
            if (axw.jy(str)) {
                if (xq != null) {
                    x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,notify ui to refresh!", new Object[]{str});
                    b(c.hIB);
                }
                a(str, xo, c.hIB);
                return;
            }
            return;
        }
        List<com.tencent.mm.plugin.card.model.g.c> xo2 = gVar.hwB;
        if (xo2 == null) {
            x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! unavailableQrCodeList is empty, do nothing! card_id=%s", new Object[]{str});
            return;
        }
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! delete card code data by unavailableQrCodeList, card_id=%s，unavailableQrCodeList size= %d", new Object[]{str, Integer.valueOf(xo2.size())});
        xq = axw.xq(str);
        LinkedList linkedList = new LinkedList();
        for (com.tencent.mm.plugin.card.model.g.c cVar : xo2) {
            if (am.axw().ca(str, cVar.hwJ)) {
                linkedList.add(b(str, cVar.hwJ, c.hIB));
            }
        }
        if (xq != null) {
            x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,code_id= %s, notify ui to refresh!", new Object[]{str, xq.field_code_id});
            b(c.hIB);
        }
        if (!linkedList.isEmpty()) {
            F(linkedList);
        }
    }

    public static boolean a(i iVar) {
        if (System.currentTimeMillis() - iVar.field_fetch_time <= ((long) (iVar.field_expire_time_interval * 1000))) {
            return false;
        }
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code  expire time is true! currentTime= %s,codeFetchTime=%s,field_expire_time_interval=%s", new Object[]{Long.valueOf(System.currentTimeMillis()), Long.valueOf(iVar.field_fetch_time), Integer.valueOf(iVar.field_expire_time_interval)});
        return true;
    }

    public final void awD() {
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "stopRefreshCodeTimer!");
        if (!this.htZ.ciq()) {
            this.htZ.SO();
        }
    }

    private static boolean g(b bVar) {
        if (bVar == null) {
            return false;
        }
        if (bVar.awn() != null && bVar.awn().rnr) {
            return true;
        }
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get cardInfo is_commom_card is false!");
        return false;
    }

    private void a(String str, q qVar) {
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneGetDynamicQrcode, cardId:" + str + ",scene :" + (qVar == null ? 0 : qVar.scene));
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        ae aeVar = new ae(linkedList, qVar == null ? 0 : qVar.scene);
        com.tencent.mm.kernel.g.Eh().dpP.a(1382, this);
        com.tencent.mm.kernel.g.Eh().dpP.a(aeVar, 0);
    }

    private void a(String str, List<k> list, c cVar) {
        if (cVar == null) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport error! CardCodeRefreshAction is null! cannot report!");
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (k kVar : list) {
            linkedList.add(b(str, kVar.field_code_id, cVar));
        }
        F(linkedList);
    }

    public final void a(String str, String str2, c cVar) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(b(str, str2, cVar));
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport, operate_list=%d,refreshAction=%d", new Object[]{Integer.valueOf(linkedList.size()), Integer.valueOf(cVar.action)});
        F(linkedList);
    }

    private void F(LinkedList<ayl> linkedList) {
        com.tencent.mm.kernel.g.Eh().dpP.a(1275, this);
        com.tencent.mm.kernel.g.Eh().dpP.a(new ah(linkedList), 0);
    }

    private static ayl b(String str, String str2, c cVar) {
        ayl ayl = new ayl();
        ayl.cac = str;
        ayl.hwJ = str2;
        ayl.sbp = new Long(System.currentTimeMillis() / 1000).intValue();
        ayl.sbq = cVar == null ? -1 : cVar.action;
        return ayl;
    }

    private void a(bda bda) {
        if (bda != null) {
            String str = bda.cac;
            if (am.axx().xn(str) == null) {
                am.axx().b(b(bda));
            } else {
                am.axx().c(b(bda), new String[0]);
            }
            List xo = am.axw().xo(str);
            if (!(xo.isEmpty() || !am.axw().jy(str) || this.htX == null)) {
                a(str, xo, this.htX);
            }
            Iterator it = bda.sfk.iterator();
            while (it.hasNext()) {
                bcz bcz = (bcz) it.next();
                k kVar = new k();
                kVar.field_card_id = str;
                kVar.field_code_id = bcz.hwJ;
                kVar.field_code = com.tencent.mm.plugin.card.d.e.ch(str, bcz.data);
                am.axw().b(kVar);
            }
        }
    }

    private static i b(bda bda) {
        i iVar = new i();
        iVar.field_card_id = bda.cac;
        iVar.field_lower_bound = bda.sff;
        iVar.field_expire_time_interval = bda.sfi;
        iVar.field_need_insert_show_timestamp = bda.sfg;
        iVar.field_show_expire_interval = bda.sfj;
        iVar.field_show_timestamp_encrypt_key = bda.sfh;
        iVar.field_fetch_time = System.currentTimeMillis();
        return iVar;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, errType = " + i + " errCode = " + i2 + ",NetSceneBase=" + (lVar != null ? lVar.getClass() : ""));
        if (i != 0 || i2 != 0) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, errType = " + i + " errCode = " + i2 + " cmd:" + (lVar != null ? lVar.getType() : 0) + "  NetSceneBase=" + (lVar != null ? lVar.getClass() : ""));
            if (lVar instanceof ae) {
                U(i2, str);
                com.tencent.mm.kernel.g.Eh().dpP.b(1382, this);
                return;
            }
            com.tencent.mm.kernel.g.Eh().dpP.b(1275, this);
        } else if (lVar instanceof ae) {
            bda bda = ((ae) lVar).hxl;
            if (bda == null) {
                x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, resp  qr_code_item_list is null ");
                return;
            }
            a(bda);
            a(this.htX);
            com.tencent.mm.kernel.g.Eh().dpP.b(1382, this);
        } else {
            com.tencent.mm.kernel.g.Eh().dpP.b(1275, this);
        }
    }

    private void a(c cVar) {
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSuccess()");
        if (this.htB != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.htB.size()) {
                    WeakReference weakReference = (WeakReference) this.htB.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.c(cVar);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final void U(int i, String str) {
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onFail()");
        if (this.htB != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.htB.size()) {
                    WeakReference weakReference = (WeakReference) this.htB.get(i3);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.V(i, str);
                        }
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void b(c cVar) {
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onReceiveCodeUnavailable()");
        if (this.htB != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.htB.size()) {
                    WeakReference weakReference = (WeakReference) this.htB.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.b(cVar);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
