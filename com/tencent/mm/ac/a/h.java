package com.tencent.mm.ac.a;

import android.database.Cursor;
import com.tencent.mm.a.f;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.n;
import com.tencent.mm.ac.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.aak;
import com.tencent.mm.protocal.c.aal;
import com.tencent.mm.protocal.c.aam;
import com.tencent.mm.protocal.c.aan;
import com.tencent.mm.protocal.c.aao;
import com.tencent.mm.protocal.c.aaq;
import com.tencent.mm.protocal.c.ado;
import com.tencent.mm.protocal.c.adp;
import com.tencent.mm.protocal.c.ans;
import com.tencent.mm.protocal.c.bur;
import com.tencent.mm.protocal.c.bus;
import com.tencent.mm.protocal.c.but;
import com.tencent.mm.protocal.c.buu;
import com.tencent.mm.protocal.c.hs;
import com.tencent.mm.protocal.c.ht;
import com.tencent.mm.protocal.c.hu;
import com.tencent.mm.protocal.c.hv;
import com.tencent.mm.protocal.c.hz;
import com.tencent.mm.protocal.c.iw;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.protocal.c.ql;
import com.tencent.mm.protocal.c.qm;
import com.tencent.mm.protocal.c.xr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h implements e {
    private HashSet<a> dNE = new HashSet();
    private HashSet<a> dNF = new HashSet();
    private final Object dNG = new Object();
    private f<String, Long> dNH = new f(64);
    private HashSet<a> dNI = new HashSet();
    private HashSet<a> dNJ = new HashSet();
    private final Object dNK = new Object();
    private f<String, Long> dNL = new f(64);

    public h() {
        g.Eh().dpP.a(1352, this);
        g.Eh().dpP.a(1365, this);
        g.Eh().dpP.a(1353, this);
        g.Eh().dpP.a(1354, this);
        g.Eh().dpP.a(1357, this);
        g.Eh().dpP.a(1356, this);
        g.Eh().dpP.a(1355, this);
        g.Eh().dpP.a(1358, this);
        g.Eh().dpP.a(1367, this);
        g.Eh().dpP.a(1361, this);
        g.Eh().dpP.a(1389, this);
        g.Eh().dpP.a(1315, this);
    }

    protected final void finalize() {
        g.Eh().dpP.b(1352, this);
        g.Eh().dpP.b(1365, this);
        g.Eh().dpP.b(1353, this);
        g.Eh().dpP.b(1354, this);
        g.Eh().dpP.b(1357, this);
        g.Eh().dpP.b(1356, this);
        g.Eh().dpP.b(1355, this);
        g.Eh().dpP.b(1358, this);
        g.Eh().dpP.b(1367, this);
        g.Eh().dpP.b(1361, this);
        g.Eh().dpP.b(1389, this);
        g.Eh().dpP.b(1315, this);
        super.finalize();
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (!(i == 0 && i2 == 0)) {
            x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:Network not ok");
            if (!(lVar.getType() == 1365 || lVar.getType() == 1353)) {
                return;
            }
        }
        int i3;
        boolean a;
        int i4;
        n nVar;
        String str2;
        String str3;
        switch (lVar.getType()) {
            case 1315:
                m mVar = (m) lVar;
                qg Ns = mVar.Ns();
                i3 = 0;
                if (Ns == null || Ns.riQ == null || Ns.riQ.ret != 0) {
                    if (Ns == null || Ns.riQ == null) {
                        x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    } else {
                        x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[]{Integer.valueOf(Ns.riQ.ret)});
                    }
                    i3 = -1;
                }
                if (i3 >= 0 && Ns.ruK == null && Ns.ruJ == null) {
                    i3 = -1;
                }
                if (i3 >= 0) {
                    if (Ns.ruK != null) {
                        a = a(Ns.ruK, Ns.riK);
                        if (a) {
                            mVar.dNT = Ns.ruK.riL;
                        }
                    } else {
                        a = a(Ns.ruJ, Ns.riK, true);
                        if (a) {
                            mVar.dNT = Ns.ruJ.rDx.riE;
                        }
                    }
                    if (!a) {
                        i4 = -1;
                        nVar = (n) mVar.data;
                        if (nVar != null) {
                            nVar.a(i4, mVar);
                            return;
                        }
                        return;
                    }
                }
                i4 = i3;
                nVar = (n) mVar.data;
                if (nVar != null) {
                    nVar.a(i4, mVar);
                    return;
                }
                return;
            case 1352:
                o oVar = (o) lVar;
                aam aam = (oVar.diG == null || oVar.diG.dIE.dIL == null) ? null : (aam) oVar.diG.dIE.dIL;
                aal aal = (oVar.diG == null || oVar.diG.dID.dIL == null) ? null : (aal) oVar.diG.dID.dIL;
                boolean z = oVar.dNU;
                if (aam != null && aam.riQ != null && aam.riQ.ret == 0) {
                    a(aam.ruQ, aal.riK, z);
                    return;
                } else if (aam == null || aam.riQ == null) {
                    x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    return;
                } else {
                    x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[]{Integer.valueOf(aam.riQ.ret)});
                    return;
                }
            case 1353:
                r rVar = (r) lVar;
                nVar = (n) rVar.data;
                if (nVar == null) {
                    synchronized (this.dNK) {
                        this.dNJ.clear();
                    }
                    Nr();
                }
                if (i == 0 && i2 == 0) {
                    int i5;
                    aaq aaq = (rVar.diG == null || rVar.diG.dIE.dIL == null) ? null : (aaq) rVar.diG.dIE.dIL;
                    i4 = 0;
                    if (aaq == null || aaq.riQ == null || aaq.riQ.ret != 0) {
                        if (aaq == null || aaq.riQ == null) {
                            x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                        } else {
                            x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[]{Integer.valueOf(aaq.riQ.ret)});
                        }
                        i4 = -1;
                    }
                    if (i4 < 0 || aaq.riR != null) {
                        i5 = i4;
                    } else {
                        x.w("MicroMsg.BizChatNetworkMgr", "resp.user==null");
                        i5 = -1;
                    }
                    if (i5 >= 0) {
                        com.tencent.mm.sdk.e.e eVar = z.Nc().diF;
                        long j = 0;
                        if (eVar instanceof com.tencent.mm.bt.h) {
                            j = ((com.tencent.mm.bt.h) eVar).dO(Thread.currentThread().getId());
                        }
                        i4 = 0;
                        while (true) {
                            int i6 = i4;
                            if (i6 < aaq.riR.size()) {
                                x.d("MicroMsg.BizChatNetworkMgr", "GetBizChatUserInfoList %s", new Object[]{((hz) aaq.riR.get(i6)).hyG});
                                j jVar = new j();
                                jVar.field_userId = ((hz) aaq.riR.get(i6)).riL;
                                jVar.field_userName = ((hz) aaq.riR.get(i6)).hyG;
                                str2 = jVar.field_userId;
                                str2 = (str2 == null || rVar.dNW == null) ? null : (String) rVar.dNW.get(str2);
                                jVar.field_brandUserName = str2;
                                jVar.field_UserVersion = ((hz) aaq.riR.get(i6)).ver;
                                jVar.field_headImageUrl = ((hz) aaq.riR.get(i6)).riF;
                                jVar.field_profileUrl = ((hz) aaq.riR.get(i6)).riT;
                                jVar.field_bitFlag = ((hz) aaq.riR.get(i6)).riG;
                                jVar.field_addMemberUrl = ((hz) aaq.riR.get(i6)).riJ;
                                jVar.field_needToUpdate = false;
                                j cz = z.Nc().cz(((hz) aaq.riR.get(i6)).riL);
                                a = cz == null ? false : cz.hu(16);
                                boolean hu = jVar.hu(16);
                                if (cz == null) {
                                    z.Nc().a(jVar);
                                } else {
                                    z.Nc().b(jVar);
                                }
                                if (a != hu) {
                                    c la = z.Na().la(jVar.field_userId);
                                    if (la != null) {
                                        if (a && !hu) {
                                            z.Nb().bi(la.field_bizChatLocalId);
                                        } else if (!a && hu) {
                                            z.Nb().bh(la.field_bizChatLocalId);
                                        }
                                    }
                                }
                                i4 = i6 + 1;
                            } else if (eVar instanceof com.tencent.mm.bt.h) {
                                g.Ei().dqq.gp(j);
                            }
                        }
                    }
                    if (nVar != null) {
                        nVar.a(i5, rVar);
                        return;
                    }
                    return;
                }
                return;
            case 1354:
                int i7;
                q qVar = (q) lVar;
                aao aao = (qVar.diG == null || qVar.diG.dIE.dIL == null) ? null : (aao) qVar.diG.dIE.dIL;
                aan aan = qVar.diG == null ? null : (aan) qVar.diG.dID.dIL;
                if (aao == null || aao.riQ == null || aao.riQ.ret != 0) {
                    if (aao == null || aao.riQ == null) {
                        x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    } else {
                        x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[]{Integer.valueOf(aao.riQ.ret)});
                    }
                    i7 = -1;
                } else {
                    i7 = 0;
                }
                if (i7 >= 0) {
                    k Nc = z.Nc();
                    String str4 = aan.riK;
                    hz hzVar = aao.riN;
                    if (hzVar == null || bi.oW(str4)) {
                        x.w("MicroMsg.BizChatUserInfoStorage", "setMyUserId: wrong argument");
                    } else {
                        x.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId:%s,%s,%s", new Object[]{str4, hzVar.riL, Boolean.valueOf(bi.oW(hzVar.riJ))});
                        f lk = z.Nd().lk(str4);
                        if (lk == null) {
                            lk = new f();
                            lk.field_brandUserName = str4;
                            lk.field_userId = hzVar.riL;
                            z.Nd().a(lk);
                        } else {
                            lk.field_userId = hzVar.riL;
                            z.Nd().b(lk);
                            x.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId: MyUserId seted");
                        }
                        j jVar2 = new j();
                        jVar2.field_userId = hzVar.riL;
                        jVar2.field_userName = hzVar.hyG;
                        jVar2.field_brandUserName = str4;
                        jVar2.field_UserVersion = hzVar.ver;
                        jVar2.field_headImageUrl = hzVar.riF;
                        jVar2.field_profileUrl = hzVar.riT;
                        jVar2.field_bitFlag = hzVar.riG;
                        jVar2.field_needToUpdate = false;
                        jVar2.field_addMemberUrl = hzVar.riJ;
                        if (!Nc.b(jVar2)) {
                            Nc.a(jVar2);
                        }
                        Nc.dNh.put(str4, jVar2.field_userId);
                    }
                }
                nVar = (n) qVar.data;
                if (nVar != null) {
                    nVar.a(i7, qVar);
                    return;
                }
                return;
            case 1355:
                n nVar2 = (n) lVar;
                qm Nt = nVar2.Nt();
                ql Nu = nVar2.Nu();
                i3 = 0;
                if (Nt == null || Nt.riQ == null || Nt.riQ.ret != 0) {
                    if (Nt == null || Nt.riQ == null) {
                        x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    } else {
                        x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[]{Integer.valueOf(Nt.riQ.ret)});
                    }
                    i3 = -1;
                }
                if (i3 >= 0) {
                    i4 = a(Nt.ruQ, Nu.riK, true) ? 0 : -1;
                } else {
                    i4 = i3;
                }
                nVar = (n) nVar2.data;
                if (nVar != null) {
                    nVar.a(i4, nVar2);
                    return;
                }
                return;
            case 1356:
                w wVar = (w) lVar;
                buu buu = (wVar.diG == null || wVar.diG.dIE.dIL == null) ? null : (buu) wVar.diG.dIE.dIL;
                but but = (wVar.diG == null || wVar.diG.dID.dIL == null) ? null : (but) wVar.diG.dID.dIL;
                i3 = 0;
                if (buu == null || buu.riQ == null || buu.riQ.ret != 0 || buu.rDx == null) {
                    if (buu == null || buu.riQ == null) {
                        x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    } else {
                        x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[]{Integer.valueOf(buu.riQ.ret)});
                    }
                    i3 = -1;
                }
                if (i3 >= 0) {
                    c la2 = z.Na().la(buu.rDx.riE);
                    if (la2 == null) {
                        str3 = "MicroMsg.BizChatNetworkMgr";
                        String str5 = "bizChatInfo == null:%s, resp.chat == null:%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Boolean.valueOf(la2 == null);
                        objArr[1] = Boolean.valueOf(buu.rDx == null);
                        x.w(str3, str5, objArr);
                        i3 = -1;
                    }
                    if (i3 < 0 || ((la2.field_bitFlag == buu.rDx.riG || !la2.No()) && buu.rDx.ver <= la2.field_chatVersion)) {
                        i4 = -1;
                    } else {
                        la2.field_chatType = buu.rDx.type;
                        la2.field_headImageUrl = buu.rDx.riF;
                        la2.field_chatName = buu.rDx.name;
                        la2.field_chatVersion = buu.rDx.ver;
                        la2.field_needToUpdate = false;
                        la2.field_bitFlag = buu.rDx.riG;
                        la2.field_maxMemberCnt = buu.rDx.riH;
                        la2.field_ownerUserId = buu.rDx.riI;
                        la2.field_addMemberUrl = buu.rDx.riJ;
                        la2.field_brandUserName = but.riK;
                        z.Na().b(la2);
                        i4 = i3;
                    }
                } else {
                    i4 = i3;
                }
                nVar = (n) wVar.data;
                if (nVar != null) {
                    nVar.a(i4, wVar);
                    return;
                }
                return;
            case 1357:
                x.d("MicroMsg.BizChatNetworkMgr", "handleUpdateBizChatMemberListSceneEnd");
                x xVar = (x) lVar;
                bus bus = (xVar.diG == null || xVar.diG.dIE.dIL == null) ? null : (bus) xVar.diG.dIE.dIL;
                bur bur = (xVar.diG == null || xVar.diG.dID.dIL == null) ? null : (bur) xVar.diG.dID.dIL;
                if (bus != null && bus.riQ != null && bus.riQ.ret == 0) {
                    i4 = a(bus.ruQ, bur.riK, false) ? 0 : -1;
                    nVar = (n) xVar.data;
                    if (nVar != null) {
                        nVar.a(i4, xVar);
                        return;
                    }
                    return;
                } else if (bus == null || bus.riQ == null) {
                    x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    return;
                } else {
                    x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[]{Integer.valueOf(bus.riQ.ret)});
                    return;
                }
            case 1365:
                synchronized (this.dNG) {
                    this.dNF.clear();
                }
                Nq();
                if (i == 0 && i2 == 0) {
                    p pVar = (p) lVar;
                    aak aak = (pVar.diG == null || pVar.diG.dIE.dIL == null) ? null : (aak) pVar.diG.dIE.dIL;
                    if (aak != null && aak.riQ != null && aak.riQ.ret == 0) {
                        LinkedList linkedList = aak.rFU;
                        if (linkedList == null || linkedList.size() == 0) {
                            x.w("MicroMsg.BizChatNetworkMgr", "fullBizChats is empty");
                            return;
                        }
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            xr xrVar = (xr) it.next();
                            str2 = xrVar.rDx.riE;
                            str2 = (str2 == null || pVar.dNV == null) ? null : (String) pVar.dNV.get(str2);
                            a(xrVar, str2, false);
                        }
                        return;
                    } else if (aak == null || aak.riQ == null) {
                        x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                        return;
                    } else {
                        x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[]{Integer.valueOf(aak.riQ.ret)});
                        return;
                    }
                }
                return;
            case 1367:
                s sVar = (s) lVar;
                adp adp = (sVar.diG == null || sVar.diG.dIE.dIL == null) ? null : (adp) sVar.diG.dIE.dIL;
                ado ado = (sVar.diG == null || sVar.diG.dID.dIL == null) ? null : (ado) sVar.diG.dID.dIL;
                if (adp != null && adp.riQ != null && adp.riQ.ret == 0) {
                    List<String> list = adp.rIa;
                    d Na = z.Na();
                    str3 = ado.riK;
                    List<String> arrayList = new ArrayList();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("select bizChatServId from BizChatInfo");
                    stringBuilder.append(" where brandUserName = '").append(str3).append("'");
                    stringBuilder.append(" and (bitFlag & 8) != 0 ");
                    Cursor rawQuery = Na.rawQuery(stringBuilder.toString(), new String[0]);
                    if (rawQuery != null) {
                        if (rawQuery.moveToFirst()) {
                            do {
                                arrayList.add(rawQuery.getString(0));
                            } while (rawQuery.moveToNext());
                        }
                        rawQuery.close();
                    }
                    for (String str6 : arrayList) {
                        if (!list.contains(str6)) {
                            c la3 = z.Na().la(str6);
                            if (la3 != null) {
                                la3.field_bitFlag &= -9;
                                z.Na().b(la3);
                            }
                        }
                    }
                    for (String str62 : list) {
                        if (!arrayList.contains(str62)) {
                            c la4 = z.Na().la(str62);
                            if (la4 == null) {
                                la4 = new c();
                                la4.field_bizChatServId = str62;
                                la4.field_brandUserName = ado.riK;
                                la4.field_bitFlag |= 8;
                                z.Na().a(la4);
                            } else {
                                la4.field_bitFlag |= 8;
                                z.Na().b(la4);
                            }
                        }
                    }
                    a(adp.rIa, ado.riK);
                    return;
                } else if (adp == null || adp.riQ == null) {
                    x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    return;
                } else {
                    x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[]{Integer.valueOf(adp.riQ.ret)});
                    return;
                }
            case 1389:
                t tVar = (t) lVar;
                ans Nv = tVar.Nv();
                i3 = 0;
                if (Nv == null || Nv.riQ == null || Nv.riQ.ret != 0) {
                    if (Nv == null || Nv.riQ == null) {
                        x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    } else {
                        x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", new Object[]{Integer.valueOf(Nv.riQ.ret)});
                    }
                    i3 = -1;
                }
                if (i3 >= 0 && Nv.ruK == null && Nv.ruJ == null) {
                    i3 = -1;
                }
                if (i3 >= 0) {
                    if (Nv.ruK != null) {
                        a = a(Nv.ruK, Nv.riK);
                        if (a) {
                            tVar.dNT = Nv.ruK.riL;
                        }
                    } else {
                        a = a(Nv.ruJ, Nv.riK, true);
                        if (a) {
                            tVar.dNT = Nv.ruJ.rDx.riE;
                        }
                    }
                    if (!a) {
                        i4 = -1;
                        nVar = (n) tVar.data;
                        if (nVar != null) {
                            nVar.a(i4, tVar);
                            return;
                        }
                        return;
                    }
                }
                i4 = i3;
                nVar = (n) tVar.data;
                if (nVar != null) {
                    nVar.a(i4, tVar);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public static void f(l lVar) {
        g.Eh().dpP.c(lVar);
    }

    public final void aj(String str, String str2) {
        Long l = (Long) this.dNH.get(str);
        if (l == null || l.longValue() + 5000 < System.currentTimeMillis()) {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this.dNG) {
                a aVar = new a(str2, str);
                if (this.dNF.contains(aVar)) {
                    return;
                }
                this.dNE.add(aVar);
                this.dNH.put(str, new Long(currentTimeMillis));
                Nq();
            }
        }
    }

    public final void a(LinkedList<String> linkedList, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.dNG) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                a aVar = new a(str, str2);
                if (!this.dNF.contains(aVar)) {
                    this.dNE.add(aVar);
                    this.dNH.put(str2, new Long(currentTimeMillis));
                }
            }
            Nq();
        }
    }

    private void Nq() {
        LinkedList linkedList = new LinkedList();
        synchronized (this.dNG) {
            if (!this.dNF.isEmpty()) {
            } else if (this.dNE.isEmpty()) {
            } else {
                Iterator it = this.dNE.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    ht htVar = new ht();
                    htVar.riK = a.a(aVar);
                    htVar.riE = a.b(aVar);
                    linkedList.add(htVar);
                }
                if (linkedList.isEmpty()) {
                    return;
                }
                this.dNF.addAll(this.dNE);
                this.dNE.clear();
                g.Eh().dpP.a(new p(linkedList), 0);
            }
        }
    }

    public final void ak(String str, String str2) {
        Long l = (Long) this.dNL.get(str);
        if (l == null || l.longValue() + 5000 < System.currentTimeMillis()) {
            al(str, str2);
        }
    }

    public final void al(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.dNK) {
            a aVar = new a(str2, str);
            if (this.dNJ.contains(aVar)) {
                return;
            }
            this.dNI.add(aVar);
            this.dNL.put(str, new Long(currentTimeMillis));
            Nr();
        }
    }

    public final void b(LinkedList<String> linkedList, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.dNK) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                a aVar = new a(str, str2);
                if (this.dNJ.contains(aVar)) {
                    return;
                } else {
                    this.dNI.add(aVar);
                    this.dNL.put(str2, new Long(currentTimeMillis));
                }
            }
            Nr();
        }
    }

    private void Nr() {
        LinkedList linkedList = new LinkedList();
        synchronized (this.dNK) {
            if (!this.dNJ.isEmpty()) {
            } else if (this.dNI.isEmpty()) {
            } else {
                LinkedList linkedList2;
                HashMap hashMap = new HashMap();
                Iterator it = this.dNI.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    linkedList2 = (LinkedList) hashMap.get(a.a(aVar));
                    if (linkedList2 == null) {
                        linkedList2 = new LinkedList();
                        hashMap.put(a.a(aVar), linkedList2);
                    }
                    linkedList2.add(a.b(aVar));
                }
                for (String str : hashMap.keySet()) {
                    linkedList2 = (LinkedList) hashMap.get(str);
                    if (!(linkedList2 == null || linkedList2.isEmpty())) {
                        iw iwVar = new iw();
                        iwVar.riK = str;
                        iwVar.rkj = linkedList2;
                        linkedList.add(iwVar);
                    }
                }
                this.dNJ.addAll(this.dNI);
                this.dNI.clear();
                g.Eh().dpP.a(new r(linkedList, null), 0);
            }
        }
    }

    public static void am(String str, String str2) {
        g.Eh().dpP.a(new o(str, str2), 0);
    }

    public static void a(String str, String str2, n nVar) {
        if (nVar != null) {
            j lf = e.lf(str2);
            if (lf == null || lf.field_userId.equals(str)) {
                a(str2, nVar);
                return;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            iw iwVar = new iw();
            iwVar.riK = str2;
            iwVar.rkj = linkedList;
            linkedList = new LinkedList();
            linkedList.add(iwVar);
            g.Eh().dpP.a(new r(linkedList, nVar), 0);
        }
    }

    public static void a(String str, n nVar) {
        g.Eh().dpP.a(new q(str, nVar), 0);
    }

    public static n a(String str, xr xrVar, n nVar) {
        n nVar2 = new n(str, xrVar, nVar);
        g.Eh().dpP.a(nVar2, 0);
        return nVar2;
    }

    public static x a(String str, String str2, hv hvVar, hv hvVar2, n nVar) {
        x xVar = new x(str, str2, hvVar, hvVar2, nVar);
        g.Eh().dpP.a(xVar, 0);
        return xVar;
    }

    public static w a(String str, hs hsVar, n nVar) {
        w wVar = new w(str, hsVar, nVar);
        g.Eh().dpP.a(wVar, 0);
        return wVar;
    }

    private static boolean a(hz hzVar, String str) {
        if (bi.oW(str) || bi.oW(hzVar.riL)) {
            return false;
        }
        j jVar = new j();
        jVar.field_userId = hzVar.riL;
        jVar.field_userName = hzVar.hyG;
        jVar.field_brandUserName = str;
        jVar.field_headImageUrl = hzVar.riF;
        jVar.field_profileUrl = hzVar.riT;
        jVar.field_UserVersion = hzVar.ver;
        jVar.field_addMemberUrl = hzVar.riJ;
        if (!z.Nc().b(jVar)) {
            z.Nc().a(jVar);
        }
        c cVar = new c();
        cVar.field_bizChatServId = jVar.field_userId;
        cVar.field_brandUserName = jVar.field_brandUserName;
        cVar.field_chatName = jVar.field_userName;
        cVar.field_chatType = 1;
        if (e.e(cVar) != null) {
            return true;
        }
        return false;
    }

    private static boolean a(xr xrVar, String str, boolean z) {
        x.d("MicroMsg.BizChatNetworkMgr", "handleGetBizChatInfoSceneEnd");
        if (xrVar == null || xrVar.rDx == null || bi.oW(str)) {
            x.w("MicroMsg.BizChatNetworkMgr", "fullBizChat or fullBizChat.chat or brandUserName == null");
            return false;
        }
        boolean z2;
        c cVar;
        c la = z.Na().la(xrVar.rDx.riE);
        if (la == null) {
            x.w("MicroMsg.BizChatNetworkMgr", "bizChatInfo == null");
            la = new c();
            la.field_bizChatServId = xrVar.rDx.riE;
            la.field_brandUserName = str;
            z2 = true;
            cVar = la;
            z = true;
        } else {
            z2 = false;
            cVar = la;
        }
        if (xrVar.riM == null) {
            x.w("MicroMsg.BizChatNetworkMgr", "members==null");
            return false;
        }
        Iterator it;
        if (cVar.No() || xrVar.rDx.ver > cVar.field_chatVersion) {
            cVar.field_chatType = xrVar.rDx.type;
            cVar.field_headImageUrl = xrVar.rDx.riF;
            cVar.field_chatName = xrVar.rDx.name;
            cVar.field_chatVersion = xrVar.rDx.ver;
            cVar.field_needToUpdate = false;
            cVar.field_bitFlag = xrVar.rDx.riG;
            cVar.field_maxMemberCnt = xrVar.rDx.riH;
            cVar.field_ownerUserId = xrVar.rDx.riI;
            cVar.field_addMemberUrl = xrVar.rDx.riJ;
            cVar.field_brandUserName = str;
            List linkedList = new LinkedList();
            it = xrVar.riM.iterator();
            while (it.hasNext()) {
                linkedList.add(((hu) it.next()).riL);
            }
            cVar.field_userList = bi.c(linkedList, ";");
            if (z2) {
                z.Na().a(cVar);
            } else {
                z.Na().b(cVar);
            }
        }
        e.h(cVar);
        hu huVar;
        if (z) {
            iw iwVar = new iw();
            iwVar.riK = cVar.field_brandUserName;
            LinkedList linkedList2 = new LinkedList();
            it = xrVar.riM.iterator();
            while (it.hasNext()) {
                int i;
                huVar = (hu) it.next();
                k Nc = z.Nc();
                String str2 = huVar.riL;
                if (bi.oW(str2)) {
                    x.w("MicroMsg.BizChatUserInfoStorage", "getBizChatVersion wrong argument");
                    i = -1;
                } else {
                    j cz = Nc.cz(str2);
                    if (cz != null) {
                        i = cz.field_UserVersion;
                    } else {
                        x.w("MicroMsg.BizChatUserInfoStorage", "getBizChatVersion item == null");
                        i = -1;
                    }
                }
                if (((long) huVar.ver) > ((long) i)) {
                    linkedList2.add(huVar.riL);
                }
            }
            if (linkedList2.size() > 0) {
                iwVar.rkj = linkedList2;
                LinkedList linkedList3 = new LinkedList();
                linkedList3.add(iwVar);
                g.Eh().dpP.a(new r(linkedList3, null), 0);
            }
        } else {
            com.tencent.mm.sdk.e.e eVar = z.Nc().diF;
            long j = 0;
            if (eVar instanceof com.tencent.mm.bt.h) {
                j = ((com.tencent.mm.bt.h) eVar).dO(Thread.currentThread().getId());
            }
            Iterator it2 = xrVar.riM.iterator();
            while (it2.hasNext()) {
                huVar = (hu) it2.next();
                j cz2 = z.Nc().cz(huVar.riL);
                if (cz2 == null) {
                    cz2 = new j();
                    cz2.field_userId = huVar.riL;
                    cz2.field_userName = huVar.hyG;
                    cz2.field_brandUserName = cVar.field_brandUserName;
                    cz2.field_needToUpdate = true;
                    z.Nc().a(cz2);
                } else if (huVar.ver > cz2.field_UserVersion) {
                    cz2.field_needToUpdate = true;
                    z.Nc().b(cz2);
                }
            }
            if (eVar instanceof com.tencent.mm.bt.h) {
                g.Ei().dqq.gp(j);
            }
        }
        return true;
    }
}
