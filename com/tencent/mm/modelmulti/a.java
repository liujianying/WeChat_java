package com.tencent.mm.modelmulti;

import com.tencent.mm.aa.f;
import com.tencent.mm.aa.g;
import com.tencent.mm.aa.j;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.z;
import com.tencent.mm.g.a.mc;
import com.tencent.mm.g.a.oe;
import com.tencent.mm.g.a.rk;
import com.tencent.mm.g.a.sd;
import com.tencent.mm.g.c.am;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.account.b;
import com.tencent.mm.plugin.account.friend.a.p;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.anx;
import com.tencent.mm.protocal.c.atw;
import com.tencent.mm.protocal.c.atz;
import com.tencent.mm.protocal.c.aue;
import com.tencent.mm.protocal.c.auo;
import com.tencent.mm.protocal.c.aux;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.bcu;
import com.tencent.mm.protocal.c.bse;
import com.tencent.mm.protocal.c.bxb;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.protocal.c.bz;
import com.tencent.mm.protocal.c.pm;
import com.tencent.mm.protocal.c.qt;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import java.util.Map;
import junit.framework.Assert;

public final class a implements q {
    public final void a(pm pmVar, byte[] bArr, boolean z, s sVar) {
        String a;
        ab Yg;
        ab Yg2;
        j jVar;
        String GF;
        switch (pmVar.rtM) {
            case 13:
                auo auo = (auo) new auo().aG(bArr);
                if (1 == auo.rXI) {
                    au.HU();
                    c.FZ().e(com.tencent.mm.platformtools.ab.a(auo.rvi), auo.rXs == 1, auo.rXJ == 1);
                    return;
                }
                x.e("MicroMsg.BigBallOfMudSyncExtension", "unknown micro blog type:" + auo.rXI);
                return;
            case 15:
                atz atz = (atz) new atz().aG(bArr);
                if (atz != null) {
                    x.d("MicroMsg.BigBallOfMudSyncExtension", "processModChatRoomMember username:" + atz.rvi + " nickname:" + atz.rQz);
                    a = com.tencent.mm.platformtools.ab.a(atz.rvi);
                    au.HU();
                    Yg = c.FR().Yg(a);
                    Yg.setUsername(a);
                    Yg.dx(com.tencent.mm.platformtools.ab.a(atz.rQz));
                    Yg.dy(com.tencent.mm.platformtools.ab.a(atz.ruT));
                    Yg.dz(com.tencent.mm.platformtools.ab.a(atz.ruU));
                    Yg.eJ(atz.eJH);
                    Yg.dv(com.tencent.mm.platformtools.ab.a(atz.rWH));
                    Yg.dB(com.tencent.mm.platformtools.ab.a(atz.rWJ));
                    Yg.dC(com.tencent.mm.platformtools.ab.a(atz.rWI));
                    Yg.eM(atz.rup);
                    j jVar2 = new j();
                    jVar2.bWA = -1;
                    jVar2.username = Yg.field_username;
                    jVar2.dHQ = atz.rra;
                    jVar2.dHR = atz.rqZ;
                    x.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl chatmember %s b[%s] s[%s]", new Object[]{jVar2.getUsername(), jVar2.Kx(), jVar2.Ky()});
                    jVar2.by(true);
                    if (atz.rWZ == 3 || atz.rWZ == 4) {
                        Yg.eI(atz.rWZ);
                        jVar2.csA = atz.rWZ;
                    } else if (atz.rWZ == 2) {
                        Yg.eI(3);
                        jVar2.csA = 3;
                        Yg.eI(3);
                        if (!com.tencent.mm.model.q.GF().equals(Yg.field_username)) {
                            com.tencent.mm.aa.q.Kp();
                            f.B(Yg.field_username, false);
                            com.tencent.mm.aa.q.Kp();
                            f.B(Yg.field_username, true);
                            com.tencent.mm.aa.q.KJ().jO(Yg.field_username);
                        }
                    }
                    com.tencent.mm.aa.q.KH().a(jVar2);
                    au.HU();
                    c.FR().S(Yg);
                    d kA = z.MY().kA(Yg.field_username);
                    kA.field_username = Yg.field_username;
                    kA.field_brandList = atz.eJR;
                    qt qtVar = atz.rTl;
                    if (qtVar != null) {
                        kA.field_brandFlag = qtVar.eJV;
                        kA.field_brandInfo = qtVar.eJX;
                        kA.field_brandIconURL = qtVar.eJY;
                        kA.field_extInfo = qtVar.eJW;
                    }
                    if (!z.MY().e(kA)) {
                        z.MY().d(kA);
                        return;
                    }
                    return;
                }
                return;
            case 22:
                anx anx = (anx) new anx().aG(bArr);
                p pVar = new p();
                pVar.username = anx.hbL;
                pVar.eKy = anx.rQA;
                pVar.dLB = (int) bi.VE();
                b.getInviteFriendOpenStg().a(pVar);
                return;
            case 23:
                xt xtVar = (xt) new xt().aG(bArr);
                switch (xtVar.rDz) {
                    case 1:
                        au.HU();
                        c.DT().set(17, Integer.valueOf(xtVar.rDA));
                        return;
                    case 4:
                        return;
                    default:
                        x.e("MicroMsg.BigBallOfMudSyncExtension", "unknown function switch id:" + xtVar.rDz);
                        return;
                }
            case 24:
                bcu bcu = (bcu) new bcu().aG(bArr);
                Assert.assertTrue(bcu != null);
                Assert.assertTrue(bi.oV(bcu.hbL).length() > 0);
                if (ab.XQ(bcu.hbL)) {
                    au.HU();
                    Yg2 = c.FR().Yg(bcu.hbL);
                    if (Yg2 == null || ((int) Yg2.dhP) == 0) {
                        Yg2 = new ab(bcu.hbL);
                        Yg2.Bh();
                        Yg2.dx(bcu.rqY);
                        Yg2.dv(bcu.rqY);
                        Yg2.eM(4);
                        au.HU();
                        if (c.FR().U(Yg2) == -1) {
                            x.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: insert contact failed");
                            return;
                        }
                        com.tencent.mm.aa.c.jL(Yg2.field_username);
                    } else if (!bi.oV(bcu.rqY).equals(bi.oV(Yg2.field_username))) {
                        Yg2.dx(bcu.rqY);
                        Yg2.dv(bcu.rqY);
                        au.HU();
                        if (c.FR().a(Yg2.field_username, Yg2) == -1) {
                            x.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: update contact failed");
                        }
                    }
                    mc mcVar = new mc();
                    mcVar.bWF.opType = 1;
                    mcVar.bWF.bWJ = bcu.hbL;
                    mcVar.bWF.bWK = bcu.seX;
                    mcVar.bWF.bWL = bcu.ruw;
                    com.tencent.mm.sdk.b.a.sFg.m(mcVar);
                    return;
                }
                x.w("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: qcontact should ends with @t.qq.com");
                return;
            case 25:
                bse bse = (bse) new bse().aG(bArr);
                Assert.assertTrue(bse != null);
                Assert.assertTrue(bi.oV(bse.hbL).length() > 0);
                if (ab.XO(bse.hbL)) {
                    au.HU();
                    Yg2 = c.FR().Yg(bse.hbL);
                    if (Yg2 == null || ((int) Yg2.dhP) == 0) {
                        Yg2 = new ab(bse.hbL);
                        Yg2.dv(bse.rqY);
                        Yg2.eM(1);
                        Yg2.Bh();
                        au.HU();
                        if (c.FR().U(Yg2) == -1) {
                            x.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: insert contact failed");
                            return;
                        }
                        a = Yg2.field_username;
                        if (a == null) {
                            x.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
                        } else if (a.endsWith("@t.qq.com")) {
                            jVar = new j();
                            jVar.username = a;
                            jVar.csA = 3;
                            jVar.bWA = 3;
                            com.tencent.mm.aa.q.KH().a(jVar);
                        } else {
                            x.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
                        }
                    } else if (!bi.oV(bse.rqY).equals(bi.oV(Yg2.field_username))) {
                        Yg2.dv(bse.rqY);
                        au.HU();
                        if (c.FR().a(Yg2.field_username, Yg2) == -1) {
                            x.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: update contact failed");
                        }
                    }
                    rk rkVar = new rk();
                    rkVar.ccg.opType = 1;
                    rkVar.ccg.bWJ = bse.hbL;
                    rkVar.ccg.bWK = bse.seX;
                    rkVar.ccg.bWL = bse.ruw;
                    com.tencent.mm.sdk.b.a.sFg.m(rkVar);
                    return;
                }
                x.w("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: tcontact should ends with @t.qq.com");
                return;
            case 33:
                atw atw = (atw) new atw().aG(bArr);
                Assert.assertTrue(atw != null);
                Assert.assertTrue(bi.oV(atw.hbL).length() > 0);
                Yg = new ab();
                Yg.setUsername(atw.hbL);
                Yg.setType(atw.hcE);
                Yg.eJ(atw.eJH);
                Yg.dS(RegionCodeDecoder.aq(atw.eJQ, atw.eJI, atw.eJJ));
                Yg.dM(atw.eJK);
                j jVar3 = new j();
                jVar3.bWA = -1;
                jVar3.username = atw.hbL;
                jVar3.dHQ = atw.rra;
                jVar3.dHR = atw.rqZ;
                x.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl bottle %s b[%s] s[%s]", new Object[]{jVar3.getUsername(), jVar3.Kx(), jVar3.Ky()});
                x.d("MicroMsg.BigBallOfMudSyncExtension", "bottlecontact imgflag:" + atw.rWZ + " hd:" + atw.rXa);
                jVar3.by(atw.rXa != 0);
                if (atw.rWZ == 3 || atw.rWZ == 4) {
                    Yg.eI(atw.rWZ);
                    jVar3.csA = atw.rWZ;
                } else if (atw.rWZ == 2) {
                    Yg.eI(3);
                    jVar3.csA = 3;
                    com.tencent.mm.aa.q.Kp();
                    f.B(atw.hbL, false);
                    com.tencent.mm.aa.q.Kp();
                    f.B(atw.hbL, true);
                    com.tencent.mm.aa.q.KJ().jO(atw.hbL);
                } else {
                    Yg.eI(3);
                    jVar3.csA = 3;
                }
                com.tencent.mm.aa.q.KH().a(jVar3);
                au.HU();
                c.FR().R(Yg);
                return;
            case 35:
                String str;
                String str2;
                aux aux = (aux) new aux().aG(bArr);
                Assert.assertTrue(aux != null);
                GF = com.tencent.mm.model.q.GF();
                int i = aux.rjI;
                if (i == 2) {
                    GF = ab.XV(GF);
                    au.HU();
                    str = GF;
                    str2 = (String) c.DT().get(12553, null);
                } else {
                    au.HU();
                    str = GF;
                    str2 = (String) c.DT().get(12297, null);
                }
                boolean z2 = false;
                if (str2 == null || !str2.equals(aux.rXS)) {
                    com.tencent.mm.aa.q.Kp();
                    f.B(str, true);
                    au.HU();
                    c.DT().set(i == 2 ? 12553 : 12297, aux.rXS);
                    z2 = true;
                }
                x.d("MicroMsg.BigBallOfMudSyncExtension", "ModUserImg beRemove:%b imgtype:%d md5:%s big:%s sm:%s", new Object[]{Boolean.valueOf(z2), Integer.valueOf(i), aux.rXS, aux.rqZ, aux.rra});
                jVar = new j();
                jVar.username = str;
                jVar.dHR = aux.rqZ;
                jVar.dHQ = aux.rra;
                if (!bi.oW(jVar.Ky())) {
                    if (i == 1) {
                        au.HU();
                        c.DT().set(59, Boolean.valueOf(true));
                    } else {
                        au.HU();
                        c.DT().set(60, Boolean.valueOf(true));
                    }
                }
                jVar.by(false);
                jVar.bWA = 56;
                if (!bi.oW(aux.rXS)) {
                    jVar.by(true);
                }
                com.tencent.mm.aa.q.KH().a(jVar);
                if (z2) {
                    new g().a(str, new 2(this));
                    return;
                }
                return;
            case f$k.AppCompatTheme_listDividerAlertDialog /*44*/:
                bxb bxb = (bxb) new bxb().aG(bArr);
                x.d("MicroMsg.BigBallOfMudSyncExtension", "snsExtFlag " + bxb.rTk.eJS);
                au.HU();
                a = (String) c.DT().get(2, null);
                if (a != null && a.length() > 0) {
                    if (n.nky != null) {
                        n.nky.a(a, bxb.rTk);
                    }
                    d kH = com.tencent.mm.ac.f.kH(com.tencent.mm.model.q.GF());
                    if (kH == null) {
                        kH = new d();
                    }
                    kH.field_username = a;
                    kH.field_brandList = bxb.eJR;
                    if (!(!kH.LZ() || kH.bG(false) == null || kH.bG(false).MB() == null || bi.oW(kH.Mg()))) {
                        kH.field_enterpriseFather = kH.Mg();
                        x.d("MicroMsg.BigBallOfMudSyncExtension", "processModUserInfoExt, %s set enterpriseFather %s", new Object[]{a, kH.field_enterpriseFather});
                    }
                    if (!z.MY().e(kH)) {
                        z.MY().d(kH);
                    }
                    int i2 = bxb.str;
                    int i3 = bxb.sts;
                    int i4 = bxb.stt;
                    x.d("MicroMsg.BigBallOfMudSyncExtension", "roomSize :" + i2 + " rommquota: " + i3 + " invite: " + i4);
                    au.HU();
                    c.DT().set(135175, Integer.valueOf(i2));
                    au.HU();
                    c.DT().set(135176, Integer.valueOf(i3));
                    au.HU();
                    c.DT().set(135177, Integer.valueOf(i4));
                    au.HU();
                    c.DT().set(144385, Integer.valueOf(bxb.stx));
                    au.HU();
                    c.DT().a(com.tencent.mm.storage.aa.a.sTs, Integer.valueOf(bxb.rEA));
                    au.HU();
                    c.DT().set(339975, Integer.valueOf(bxb.stF));
                    x.i("MicroMsg.BigBallOfMudSyncExtension", "hy: sync do cmd pay wallet type: %d %d", new Object[]{Integer.valueOf(bxb.stF), Integer.valueOf(bxb.rEA)});
                    au.HU();
                    c.DT().a(com.tencent.mm.storage.aa.a.sRy, bi.aG(bxb.csY, ""));
                    x.d("MicroMsg.BigBallOfMudSyncExtension", "weidianinfo:%s", new Object[]{bxb.csY});
                    au.HU();
                    c.DT().set(147457, Long.valueOf(bxb.stG));
                    au.HU();
                    c.DT().a(com.tencent.mm.storage.aa.a.sVy, bxb.stH);
                    jVar = new j();
                    jVar.bWA = -1;
                    jVar.username = a;
                    jVar.dHR = bxb.rqZ;
                    jVar.dHQ = bxb.rra;
                    jVar.by(true);
                    jVar.csA = 3;
                    x.d("MicroMsg.BigBallOfMudSyncExtension", "dkavatar user:[%s] big:[%s] sm:[%s]", new Object[]{jVar.getUsername(), jVar.Kx(), jVar.Ky()});
                    com.tencent.mm.aa.q.KH().a(jVar);
                    a = bxb.rXk;
                    GF = bxb.rXl;
                    au.HU();
                    c.DT().set(274433, GF);
                    au.HU();
                    c.DT().set(274434, a);
                    if (bxb.rcy != null) {
                        au.HU();
                        c.DT().set(286721, bxb.rcy.rhn);
                        au.HU();
                        c.DT().set(286722, bxb.rcy.rho);
                        au.HU();
                        c.DT().set(286723, bxb.rcy.rhp);
                    }
                    if (bxb.stD != null && bxb.stD.sbL != null && bxb.stD.sbL.siI > 0) {
                        x.i("MicroMsg.BigBallOfMudSyncExtension", "tomgest PatternLockInfo %d", new Object[]{Integer.valueOf(bxb.stD.sbL.siI)});
                        sd sdVar = new sd();
                        sdVar.ccW.ccX = bxb.stD;
                        com.tencent.mm.sdk.b.a.sFg.m(sdVar);
                        return;
                    }
                    return;
                }
                return;
            case f$k.AppCompatTheme_selectableItemBackgroundBorderless /*53*/:
                avu avu = (avu) new avu().aG(bArr);
                x.d("MicroMsg.BigBallOfMudSyncExtension", "rollback, msgtype is %d, msgid is %d", new Object[]{Integer.valueOf(avu.jQd), Long.valueOf(avu.rcq)});
                if (com.tencent.mm.model.s.hv(avu.jTv)) {
                    oe oeVar = new oe();
                    oeVar.bZd.bJC = avu.rcq;
                    com.tencent.mm.sdk.b.a.sFg.m(oeVar);
                    return;
                }
                return;
            case 204:
                a((bz) new bz().aG(bArr), sVar);
                return;
            case 999999:
                try {
                    int r = com.tencent.mm.a.n.r(bArr, 0);
                    x.d("MicroMsg.BigBallOfMudSyncExtension", "local test synccmd, sleep %d", new Object[]{Integer.valueOf(r)});
                    if (r > 0) {
                        Thread.sleep((long) r);
                        return;
                    }
                    return;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", e, "", new Object[0]);
                    return;
                }
            default:
                x.e("MicroMsg.BigBallOfMudSyncExtension", "doCmd: no processing method, cmd id=" + pmVar.rtM);
                return;
        }
    }

    public static boolean a(ab abVar) {
        String str;
        String str2;
        Object[] objArr;
        if (abVar == null || bi.oW(abVar.field_username)) {
            String str3;
            str = "MicroMsg.BigBallOfMudSyncExtension";
            str2 = "dealModContactExtInfo username:%s ";
            objArr = new Object[1];
            if (abVar == null) {
                str3 = "-1";
            } else {
                str3 = abVar.field_username;
            }
            objArr[0] = str3;
            x.w(str, str2, objArr);
            return false;
        }
        au.HU();
        byte[] Yk = c.FR().Yk(abVar.field_username);
        if (bi.bC(Yk)) {
            str = "MicroMsg.BigBallOfMudSyncExtension";
            str2 = "dealModContactExtInfo username:%s  buf:%d";
            objArr = new Object[2];
            objArr[0] = abVar.field_username;
            objArr[1] = Integer.valueOf(Yk == null ? -1 : Yk.length);
            x.w(str, str2, objArr);
            return false;
        }
        aue aue;
        try {
            aue = (aue) new aue().aG(Yk);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", e, "", new Object[0]);
            aue = null;
        }
        au.HU();
        c.FR().Yl(abVar.field_username);
        if (aue != null) {
            return com.tencent.mm.plugin.bbom.c.a(abVar, aue, false);
        }
        x.e("MicroMsg.BigBallOfMudSyncExtension", "dkinit dealModContactExtInfo failed parse buf failed.");
        return false;
    }

    public final void a(bz bzVar, s sVar) {
        long Gv;
        am amVar;
        Object obj;
        int i;
        bd J;
        String str;
        String a = com.tencent.mm.platformtools.ab.a(bzVar.rcs);
        long j = bzVar.rcq;
        int i2 = bzVar.lOH;
        int i3 = bzVar.rcv;
        int i4 = bzVar.rcr;
        int i5 = bzVar.jQd;
        int i6 = bzVar.rct;
        String a2 = com.tencent.mm.platformtools.ab.a(bzVar.rcu);
        x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList chatRoomId[%s], newMsgId[%d], createTime[%d], isActed[%d], msgseq[%d], msgType[%d], unDeliverCount[%d], content[%s]", new Object[]{a, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), bi.Xf(a2)});
        if (bi.oW(a)) {
            x.e("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList chatRoomId is null and ret");
        }
        if (i6 == 0) {
            com.tencent.mm.plugin.report.f.mDy.a(403, 24, 1, false);
            if (bi.aG(com.tencent.mm.model.bd.iB(a2), "").equals(com.tencent.mm.model.q.GF())) {
                au.HU();
                bd I = c.FT().I(a, j);
                if (I.field_msgId > 0 && I.field_isSend == 1) {
                    x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList self send msg[%d] createtime[%d, %d] svrid[%d, %d] seq[%d, %d]", new Object[]{Long.valueOf(I.field_msgId), Long.valueOf(I.field_createTime), Integer.valueOf(i2), Long.valueOf(I.field_msgSvrId), Long.valueOf(j), Long.valueOf(I.field_msgSeq), Integer.valueOf(i4)});
                    if (I.field_msgSeq == 0) {
                        com.tencent.mm.plugin.report.f.mDy.a(403, 25, 1, false);
                        I.aA((long) i4);
                        au.HU();
                        c.FT().a(I.field_msgId, I);
                        return;
                    }
                    return;
                }
            }
        }
        au.HU();
        ai Yq = c.FW().Yq(a);
        if (Yq == null) {
            com.tencent.mm.plugin.report.f.mDy.a(403, 22, 1, false);
            ai aiVar = new ai(a);
            aiVar.as(((long) i2) * 1000);
            aiVar.au((long) i4);
            aiVar.eV(i6);
            aiVar.fc(i6);
            au.HU();
            Gv = c.Gx().Gv(a);
            x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList new conv lastDeleteSeq(FirstUnDeliverSeq)[%d], msgSeq[%d]", new Object[]{Long.valueOf(Gv), Integer.valueOf(i4)});
            if (Gv > 0) {
                aiVar.av(Gv);
                amVar = aiVar;
                obj = 1;
            } else {
                aiVar.av((long) i4);
                amVar = aiVar;
                int obj2 = 1;
            }
        } else {
            i = (int) Yq.field_lastSeq;
            com.tencent.mm.plugin.report.f.mDy.a(403, 23, 1, false);
            if (i6 < Yq.field_UnDeliverCount) {
                com.tencent.mm.plugin.report.f.mDy.a(403, 26, (long) Yq.field_UnDeliverCount, false);
            }
            if (i4 > i) {
                Yq.au((long) i4);
                Yq.fc(i6);
                Yq.as(com.tencent.mm.model.bd.o(a, (long) i2));
                if (i6 > Yq.field_unReadCount) {
                    Yq.eV(i6);
                }
                x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList  msgSeq[%d], firstSeq[%d], lastseq[%d]", new Object[]{Integer.valueOf(i4), Long.valueOf(Yq.field_firstUnDeliverSeq), Integer.valueOf(i)});
                if (Yq.field_firstUnDeliverSeq > 0) {
                    au.HU();
                    J = c.FT().J(a, (long) i);
                    if (J.field_msgId > 0) {
                        Yq.av(J.field_msgSeq);
                        x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList unDeliverCount:%d reset firstSeq:%d to last exist: %d", new Object[]{Integer.valueOf(i6), Long.valueOf(Gv), Long.valueOf(Yq.field_firstUnDeliverSeq)});
                        com.tencent.mm.plugin.report.f.mDy.a(403, 28, 1, false);
                        amVar = Yq;
                        obj2 = null;
                    } else {
                        com.tencent.mm.plugin.report.f.mDy.a(403, 29, 1, false);
                        x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList unDeliverCount:%d lastSeq:%d not existed", new Object[]{Integer.valueOf(i6), Integer.valueOf(i)});
                        amVar = Yq;
                        obj2 = null;
                    }
                } else {
                    long Gv2 = ((i) com.tencent.mm.kernel.g.l(i.class)).Gx().Gv(a);
                    x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList lastDeleteSeq[%s]", new Object[]{Long.valueOf(Gv2)});
                    if (Gv2 > 0) {
                        com.tencent.mm.plugin.report.f.mDy.a(403, 30, 1, false);
                        Yq.av(Gv2);
                        amVar = Yq;
                        obj2 = null;
                    } else {
                        au.HU();
                        long Ha = c.FT().Ha(a);
                        x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList lastMsgSeq[%s]", new Object[]{Long.valueOf(Ha)});
                        if (Ha > 0) {
                            Yq.av(Ha);
                            com.tencent.mm.plugin.report.f.mDy.a(403, 31, 1, false);
                            amVar = Yq;
                            obj2 = null;
                        } else {
                            com.tencent.mm.plugin.report.f.mDy.a(403, 32, 1, false);
                            amVar = Yq;
                            obj2 = null;
                        }
                    }
                }
            } else {
                if (i4 == i && i6 == 0 && Yq.field_unReadCount > 0) {
                    com.tencent.mm.plugin.report.f.mDy.a(403, 33, 1, false);
                    Yq.eV(0);
                }
                x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList msgSeq <= lastSeq, do nothing [%d, %d]", new Object[]{Integer.valueOf(i4), Integer.valueOf(i)});
                return;
            }
        }
        if (i3 > 0) {
            amVar.fa(amVar.field_atCount + i3);
        }
        J = new bd();
        J.eX(0);
        J.ep(a);
        J.setType(i5);
        J.setContent(a2);
        if (i5 == 49) {
            com.tencent.mm.y.g.a gp = com.tencent.mm.y.g.a.gp(com.tencent.mm.pluginsdk.model.app.j.fB(a, a2));
            J.setType(l.d(gp));
            J.setContent(J.cky() ? gp.content : a2);
        } else if (i5 == 10002) {
            au.getSysCmdMsgExtension();
            if (J.getType() == 10002 && !bi.oW(a2)) {
                if (bi.oW(a2)) {
                    x.e("MicroMsg.SysCmdMsgExtension", "null msg content");
                } else {
                    String str2;
                    Map map;
                    if (a2.startsWith("~SEMI_XML~")) {
                        Map WA = ay.WA(a2);
                        if (WA == null) {
                            x.e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", new Object[]{a2});
                        } else {
                            str2 = "brand_service";
                            map = WA;
                        }
                    } else {
                        i = a2.indexOf("<sysmsg");
                        if (i == -1) {
                            x.e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg");
                        } else {
                            map = bl.z(a2.substring(i), "sysmsg");
                            if (map == null) {
                                x.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", new Object[]{a2});
                            } else {
                                str2 = (String) map.get(".sysmsg.$type");
                            }
                        }
                    }
                    if (str2 != null && str2.equals("revokemsg")) {
                        x.i("MicroMsg.SysCmdMsgExtension", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
                        map.get(".sysmsg.revokemsg.session");
                        str = (String) map.get(".sysmsg.revokemsg.newmsgid");
                        x.i("MicroMsg.SysCmdMsgExtension", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", new Object[]{str, (String) map.get(".sysmsg.revokemsg.replacemsg")});
                        J.setContent(r4);
                        J.setType(10000);
                    }
                }
            }
        }
        amVar.eX(0);
        amVar.setContent(J.field_content);
        amVar.ec(Integer.toString(J.getType()));
        au.HU();
        az.b vu = c.FW().vu();
        if (vu != null) {
            PString pString = new PString();
            PString pString2 = new PString();
            PInt pInt = new PInt();
            vu.a(J, pString, pString2, pInt, false);
            amVar.ed(pString.value);
            amVar.ee(pString2.value);
            amVar.eY(pInt.value);
            if (J.getType() == 49) {
                str = (String) bl.z(amVar.field_content, "msg").get(".msg.appmsg.title");
                amVar.ed(bi.oV(amVar.field_digest).concat(bi.oW(str) ? "" : " " + bi.oV(str)));
            }
        } else {
            amVar.ed(amVar.field_content);
        }
        if (obj2 != null) {
            au.HU();
            Gv = c.FW().d(amVar);
            x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr, processAddMsgDigestList insert username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", new Object[]{a, Long.valueOf(Gv), Long.valueOf(amVar.field_firstUnDeliverSeq), Long.valueOf(amVar.field_lastSeq), Integer.valueOf(amVar.field_UnDeliverCount)});
        } else {
            amVar.eZ(amVar.field_attrflag & -1048577);
            au.HU();
            Gv = (long) c.FW().a(amVar, a, true);
            x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr, processAddMsgDigestList update username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", new Object[]{a, Long.valueOf(Gv), Long.valueOf(amVar.field_firstUnDeliverSeq), Long.valueOf(amVar.field_lastSeq), Integer.valueOf(amVar.field_UnDeliverCount)});
        }
        au.HU();
        u ii = c.Ga().ii(a);
        au.HU();
        ab Yg = c.FR().Yg(a);
        if (Yg == null || ((int) Yg.dhP) <= 0) {
            x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList chatRoomId[%s], contact is null need get", new Object[]{a});
            com.tencent.mm.model.am.a.dBr.a(a, null, new 1(this, ii, a));
        }
        if (com.tencent.mm.sdk.a.b.foreground && i5 != 10002 && i6 > 0) {
            by byVar = new by();
            byVar.rcj = bzVar.rcs;
            byVar.rck = com.tencent.mm.platformtools.ab.oT(com.tencent.mm.model.q.GF());
            byVar.lOH = bzVar.lOH;
            byVar.rcl = bzVar.rcu;
            byVar.jQd = bzVar.jQd;
            byVar.rcq = bzVar.rcq;
            byVar.rcr = bzVar.rcr;
            if (sVar != null) {
                sVar.a(J, byVar);
            }
        }
    }
}
