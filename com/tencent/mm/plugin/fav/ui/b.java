package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.g.a.ch;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.protocal.c.auj;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class b {
    static int a(ch chVar) {
        Object obj;
        g Bs;
        g gVar = new g();
        gVar.field_favProto = chVar.bJF.bJH;
        gVar.field_sessionId = chVar.bJF.bJK;
        int i = chVar.bJF.bJM;
        wr wrVar = gVar.field_favProto.rBG;
        if (wrVar != null) {
            gVar.field_sourceId = wrVar.rBQ;
            if (gVar.field_sourceId == null || gVar.field_sourceId.equals("")) {
                obj = null;
            } else {
                Bs = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().Bs(gVar.field_sourceId);
                if (Bs != null && Bs.field_id > 0) {
                    int i2 = Bs.field_id;
                    if (i2 <= 0) {
                        x.e("MicroMsg.Fav.FavAddService", "modUpdateTime favId illegal:%d", new Object[]{Integer.valueOf(i2)});
                    } else {
                        LinkedList linkedList = new LinkedList();
                        auj auj = new auj();
                        auj.rXA = 1;
                        auj.rXB = (int) (System.currentTimeMillis() / 1000);
                        linkedList.add(auj);
                        com.tencent.mm.kernel.g.DF().a(new al(i2, linkedList, null), 0);
                    }
                }
                obj = Bs != null ? 1 : null;
            }
            if (obj != null) {
                x.w("MicroMsg.Fav.FavAddService", "handleEvent, msg already exist, do not insert");
                obj = null;
                if (obj != null) {
                    Bs = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().Bs(gVar.field_sourceId);
                    if (Bs != null) {
                        com.tencent.mm.plugin.fav.a.b.dn(Bs.field_localId);
                    }
                    return 0;
                }
                gVar.field_flag = 0;
                gVar.field_updateTime = System.currentTimeMillis();
                gVar.field_localId = System.currentTimeMillis();
                com.tencent.mm.plugin.fav.a.b.dn(gVar.field_localId);
                gVar.field_type = chVar.bJF.type;
                if (chVar.bJF.desc == null || chVar.bJF.desc.length() < 10001) {
                    gVar.field_favProto.Vv(chVar.bJF.desc);
                } else {
                    x.w("MicroMsg.Fav.FavAddService", "length more than 10000, do cut desc");
                    gVar.field_favProto.Vv(chVar.bJF.desc.substring(0, 10001));
                }
                gVar.field_xml = g.s(gVar);
                C(gVar);
                com.tencent.mm.plugin.fav.a.b.j(gVar);
                gVar.Bi("MicroMsg.Fav.FavAddService");
                return 0;
            }
            switch (wrVar.bJt) {
                case 1:
                    if (!s.hf(gVar.field_fromUser)) {
                        if (!s.fq(gVar.field_fromUser)) {
                            gVar.field_sourceType = 21;
                            break;
                        }
                        gVar.field_sourceType = 22;
                        break;
                    }
                    gVar.field_sourceType = 23;
                    break;
                case 3:
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                gVar.field_sourceType = wrVar.bJt;
                                break;
                            }
                            gVar.field_sourceType = 26;
                            break;
                        }
                        gVar.field_sourceType = 25;
                        break;
                    }
                    gVar.field_sourceType = 24;
                    break;
                default:
                    gVar.field_sourceType = wrVar.bJt;
                    break;
            }
            gVar.field_fromUser = wrVar.bSS;
            gVar.field_toUser = wrVar.toUser;
            gVar.field_sourceId = wrVar.rBQ;
            gVar.field_sourceCreateTime = wrVar.createTime;
        }
        x.i("MicroMsg.Fav.FavAddService", "deal with source item, fromUser is %s, toUser %s, sourceId %s, sourceType %d", new Object[]{gVar.field_fromUser, gVar.field_toUser, gVar.field_sourceId, Integer.valueOf(gVar.field_sourceType)});
        obj = 1;
        if (obj != null) {
            gVar.field_flag = 0;
            gVar.field_updateTime = System.currentTimeMillis();
            gVar.field_localId = System.currentTimeMillis();
            com.tencent.mm.plugin.fav.a.b.dn(gVar.field_localId);
            gVar.field_type = chVar.bJF.type;
            if (chVar.bJF.desc == null || chVar.bJF.desc.length() < 10001) {
                gVar.field_favProto.Vv(chVar.bJF.desc);
            } else {
                x.w("MicroMsg.Fav.FavAddService", "length more than 10000, do cut desc");
                gVar.field_favProto.Vv(chVar.bJF.desc.substring(0, 10001));
            }
            gVar.field_xml = g.s(gVar);
            C(gVar);
            com.tencent.mm.plugin.fav.a.b.j(gVar);
            gVar.Bi("MicroMsg.Fav.FavAddService");
            return 0;
        }
        Bs = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().Bs(gVar.field_sourceId);
        if (Bs != null) {
            com.tencent.mm.plugin.fav.a.b.dn(Bs.field_localId);
        }
        return 0;
    }

    public static void B(g gVar) {
        gVar.field_updateTime = System.currentTimeMillis();
        if (!com.tencent.mm.plugin.fav.a.b.k(gVar)) {
            gVar.field_localId = System.currentTimeMillis();
        }
        C(gVar);
        com.tencent.mm.plugin.fav.a.b.j(gVar);
    }

    private static void C(g gVar) {
        h.dq(gVar.field_localId);
        if (gVar.field_favProto.rBI.size() > 0) {
            e.post(new a(gVar), "AddFavService_copy");
            return;
        }
        gVar.field_itemStatus = 9;
        if (com.tencent.mm.plugin.fav.a.b.k(gVar)) {
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().a(gVar, new String[0]);
        } else {
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().y(gVar);
        }
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getSendService().run();
    }
}
