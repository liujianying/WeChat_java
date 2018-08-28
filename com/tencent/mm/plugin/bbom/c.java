package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.f;
import com.tencent.mm.ac.z;
import com.tencent.mm.ax.g;
import com.tencent.mm.g.a.er;
import com.tencent.mm.g.a.ha;
import com.tencent.mm.g.a.it;
import com.tencent.mm.g.a.jn;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.g.a.rm;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.g.a.rs;
import com.tencent.mm.l.a;
import com.tencent.mm.model.am;
import com.tencent.mm.model.au;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.plugin.account.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.aue;
import com.tencent.mm.protocal.c.auf;
import com.tencent.mm.protocal.c.aur;
import com.tencent.mm.protocal.c.bar;
import com.tencent.mm.protocal.c.bas;
import com.tencent.mm.protocal.c.bqd;
import com.tencent.mm.protocal.c.my;
import com.tencent.mm.protocal.c.qt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bq;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class c implements e, com.tencent.mm.plugin.messenger.foundation.a.c {
    public final void a(ab abVar, ab abVar2, aue aue, byte[] bArr, boolean z) {
        Object obj;
        String str;
        String str2 = abVar.field_username;
        String str3 = abVar.field_encryptUsername;
        if (!(abVar2 == null || bi.oV(abVar2.csU).equals(bi.oV(aue.rXt)))) {
            com.tencent.mm.at.c.Qt();
            com.tencent.mm.at.c.mA(str2);
        }
        if (bi.bC(bArr)) {
            a(abVar, aue, true);
        } else if (ab.Dk(abVar.field_verifyFlag)) {
            a(aue, str2, abVar, true);
        }
        if (abVar2 == null || a.gd(abVar2.field_type) || !a.gd(abVar.field_type)) {
            obj = null;
        } else {
            obj = 1;
        }
        String str4 = "MicroMsg.BigBallContactAssemblerImpl";
        String str5 = "username:%s PhoneNumList size:%s";
        Object[] objArr = new Object[2];
        objArr[0] = abVar.field_username;
        if (aue.rXu == null) {
            str = "";
        } else {
            str = Integer.valueOf(bi.f(Integer.valueOf(aue.rXu.sdd.size())));
        }
        objArr[1] = str;
        x.i(str4, str5, objArr);
        StringBuffer stringBuffer = new StringBuffer();
        if (!(aue.rXu == null || aue.rXu.sdd == null)) {
            Iterator it = aue.rXu.sdd.iterator();
            while (it.hasNext()) {
                bar bar = (bar) it.next();
                if (bar.sdc != null) {
                    stringBuffer.append(bar.sdc + ",");
                }
            }
        }
        x.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[]{abVar.field_username, stringBuffer.toString()});
        str = null;
        Object obj2 = null;
        if (abVar2 != null) {
            str = abVar2.csZ;
        }
        if (str == null || str.equals("")) {
            au.HU();
            bq Hh = com.tencent.mm.model.c.FS().Hh(str3);
            if (Hh != null) {
                str = Hh.field_conPhone;
            }
        }
        x.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, oldPhoneList %s", new Object[]{abVar.field_username, bi.oV(str)});
        if (!bi.oW(str)) {
            int i;
            Object obj3 = null;
            for (String str6 : str.split(",")) {
                if (!bi.oW(stringBuffer.toString())) {
                    String[] split = stringBuffer.toString().split(",");
                    int length = split.length;
                    int i2 = 0;
                    while (i2 < length) {
                        if (str6.equals(split[i2])) {
                            obj3 = null;
                            break;
                        } else {
                            obj3 = 1;
                            i2++;
                        }
                    }
                    if (obj3 != null) {
                        stringBuffer.append(str6);
                        obj2 = 1;
                    }
                }
            }
            if (obj2 != null) {
                aur aur = new aur();
                aur.rXy = abVar.field_username;
                bas bas = new bas();
                if (!bi.oW(stringBuffer.toString())) {
                    String[] split2 = stringBuffer.toString().split(",");
                    bas.hbF = split2.length;
                    bas.sdd = new LinkedList();
                    for (String str7 : split2) {
                        bar bar2 = new bar();
                        bar2.sdc = str7;
                        bas.sdd.add(bar2);
                    }
                    aur.rXu = bas;
                    au.HU();
                    com.tencent.mm.model.c.FQ().b(new h.a(60, aur));
                }
            }
            if (!(obj == null || 15 != aue.rdq || bi.oW(abVar.field_username))) {
                com.tencent.mm.plugin.account.friend.a.a pp = b.getAddrUploadStg().pp(abVar.field_username);
                if (pp != null) {
                    com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.mEJ;
                    Object[] objArr2 = new Object[4];
                    objArr2[0] = abVar.field_username;
                    objArr2[1] = Integer.valueOf(3);
                    objArr2[2] = Integer.valueOf(bi.oW(pp.Xh()) ? 0 : 1);
                    if (stringBuffer.toString().split(",").length >= 5) {
                        i = 5;
                    } else {
                        i = stringBuffer.toString().split(",").length;
                    }
                    objArr2[3] = Integer.valueOf(i);
                    hVar.h(12040, objArr2);
                }
            }
        }
        x.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[]{abVar.field_username, stringBuffer.toString()});
        str = stringBuffer.toString();
        if (!bi.oW(str)) {
            x.i("MicroMsg.BigBallContactAssemblerImpl", str);
            abVar.dZ(str);
        }
        if (!(s.fq(str2) || aue.rGM == null)) {
            m.a(str2, aue.rGM);
        }
        boolean z2 = false;
        au.HU();
        bq Hh2 = com.tencent.mm.model.c.FS().Hh(abVar.field_username);
        if (bi.oW(abVar.field_conRemark)) {
            if ((Hh2 == null || bi.oW(Hh2.field_encryptUsername)) && !bi.oW(str3)) {
                au.HU();
                Hh2 = com.tencent.mm.model.c.FS().Hh(str3);
            }
            if (!(Hh2 == null || bi.oW(Hh2.field_encryptUsername))) {
                x.i("MicroMsg.BigBallContactAssemblerImpl", "mod stranger remark : " + Hh2.field_encryptUsername);
                abVar.dv(Hh2.field_conRemark);
                abVar.dB(com.tencent.mm.platformtools.h.oI(Hh2.field_conRemark));
                abVar.dC(com.tencent.mm.platformtools.h.oJ(Hh2.field_conRemark));
                z2 = a(abVar, Hh2);
            }
            switch (abVar.getSource()) {
                case 10:
                case 11:
                case 13:
                    com.tencent.mm.plugin.account.friend.a.a aVar = null;
                    if (aue != null && !bi.oW(aue.rXm)) {
                        x.i("MicroMsg.BigBallContactAssemblerImpl", "MobileHash[%s],MobileFullHash[%s]", new Object[]{aue.rXm, aue.rXn});
                        com.tencent.mm.plugin.account.friend.a.b addrUploadStg = b.getAddrUploadStg();
                        String str8 = aue.rXm;
                        str5 = aue.rXn;
                        aVar = addrUploadStg.pq(str8);
                        if (aVar == null) {
                            aVar = addrUploadStg.pq(str5);
                        }
                    } else if (!bi.oW(str3)) {
                        aVar = b.getAddrUploadStg().pp(str3);
                    }
                    if (aVar == null) {
                        x.i("MicroMsg.BigBallContactAssemblerImpl", "dealWithRemark-> addr == null");
                    } else {
                        x.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], needSetRemark[%s]", new Object[]{bi.oV(aVar.Xj()), bi.oV(aVar.getUsername()), Boolean.valueOf(aVar.Xs())});
                    }
                    if (!(aVar == null || bi.oW(aVar.Xj()) || !aVar.Xs())) {
                        x.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], remarkChange[%s]", new Object[]{aVar.Xj(), aVar.getUsername(), Boolean.valueOf(z2)});
                        aVar.username = abVar.field_username;
                        aVar.status = 2;
                        aVar.Xr();
                        if (!z2) {
                            abVar.dv(aVar.Xj());
                            abVar.dB(com.tencent.mm.platformtools.h.oI(aVar.Xj()));
                            abVar.dC(com.tencent.mm.platformtools.h.oJ(aVar.Xj()));
                            z2 = true;
                        }
                        if (a.gd(abVar.field_type)) {
                            x.i("MicroMsg.BigBallContactAssemblerImpl", "updateAddrUp RealName[%s], User[%s], remarkChange[%s]", new Object[]{aVar.Xj(), aVar.getUsername(), Boolean.valueOf(z2)});
                            b.getAddrUploadStg().a(aVar.Xh(), aVar);
                            break;
                        }
                    }
                    break;
            }
        }
        if (!(Hh2 == null || bi.oW(abVar.csT) || abVar.csT.equals(Hh2.field_conDescription))) {
            a(abVar, Hh2);
        }
        z2 = false;
        x.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s needModContact %s encryptUser:%s", new Object[]{abVar.field_username, Boolean.valueOf(z2), str3});
        if (z2) {
            s.u(abVar);
        }
        str = null;
        au.HU();
        Hh2 = com.tencent.mm.model.c.FS().Hh(abVar.field_encryptUsername);
        if (Hh2 != null) {
            str = Hh2.field_contactLabels;
        }
        if (bi.oW(str)) {
            au.HU();
            Hh2 = com.tencent.mm.model.c.FS().Hh(abVar.field_username);
            if (Hh2 != null) {
                str = Hh2.field_contactLabels;
            }
        }
        if (!bi.oW(str)) {
            com.tencent.mm.plugin.label.a.a.aYK().dw(abVar.field_username, str);
            Hh2.field_contactLabels = "";
            au.HU();
            com.tencent.mm.model.c.FS().a(Hh2);
        }
    }

    public final void b(ab abVar, ab abVar2, aue aue, byte[] bArr, boolean z) {
        Object obj;
        int i;
        Object obj2;
        d kA;
        it itVar;
        String str = abVar.field_username;
        String str2 = abVar.field_encryptUsername;
        if (s.fq(str)) {
            String SD;
            if (aue.rGM != null) {
                Iterator it;
                my myVar;
                LinkedList linkedList = aue.rGM.rqV;
                if (com.tencent.mm.ay.d.eli == null) {
                    obj = null;
                } else {
                    SD = com.tencent.mm.ay.d.eli.SD();
                    if (!bi.oW(SD) && SD.equals(str) && s.fq(str)) {
                        if (linkedList != null) {
                            it = linkedList.iterator();
                            while (it.hasNext()) {
                                myVar = (my) it.next();
                                if (!bi.oW(myVar.hbL) && myVar.hbL.equals(q.GF())) {
                                    obj = null;
                                    break;
                                }
                            }
                        }
                        if (com.tencent.mm.ay.d.elh != null) {
                            if (com.tencent.mm.ay.d.elh.az(str, q.GF())) {
                                x.i("MicroMsg.BigBallContactAssemblerImpl", "kicked self shareing");
                                rs rsVar = new rs();
                                rsVar.ccD.userName = str;
                                com.tencent.mm.sdk.b.a.sFg.m(rsVar);
                            }
                            com.tencent.mm.ay.d.elh.a(str, null, 0.0d, 0.0d, "", "", "");
                        }
                        if (!(com.tencent.mm.ay.d.eli == null || bi.oW(com.tencent.mm.ay.d.elh.SC()))) {
                            x.i("MicroMsg.BigBallContactAssemblerImpl", "sync remove chatroom end track %s", new Object[]{com.tencent.mm.ay.d.eli.SD()});
                            er erVar = new er();
                            erVar.bMv.username = com.tencent.mm.ay.d.eli.SD();
                            com.tencent.mm.sdk.b.a.sFg.m(erVar);
                        }
                        obj = 1;
                    } else {
                        obj = null;
                    }
                }
                if (obj == null) {
                    linkedList = aue.rGM.rqV;
                    rn rnVar = new rn();
                    rnVar.ccn.ccp = true;
                    com.tencent.mm.sdk.b.a.sFg.m(rnVar);
                    if (!bi.oW(str) && s.fq(str) && !bi.oW(rnVar.cco.ccr) && str.equals(rnVar.cco.ccr)) {
                        if (linkedList != null) {
                            it = linkedList.iterator();
                            while (it.hasNext()) {
                                myVar = (my) it.next();
                                if (!bi.oW(myVar.hbL)) {
                                    if (myVar.hbL.equals(q.GF())) {
                                        break;
                                    }
                                }
                            }
                        }
                        if (g.elf != null) {
                            g.elf.a(str, null, "", "", 0);
                        }
                        rn rnVar2 = new rn();
                        rnVar2.ccn.ccq = true;
                        com.tencent.mm.sdk.b.a.sFg.m(rnVar2);
                        rm rmVar = new rm();
                        rmVar.ccl.ccm = true;
                        com.tencent.mm.sdk.b.a.sFg.m(rmVar);
                    }
                }
                linkedList = aue.rGM.rqV;
                if (o.a.qyi != null && linkedList != null) {
                    it = linkedList.iterator();
                    while (it.hasNext()) {
                        myVar = (my) it.next();
                        if (bi.oW(myVar.hbL) || !myVar.hbL.equals(q.GF())) {
                        }
                    }
                    obj = 1;
                    if (!(obj == null || o.a.qyi == null)) {
                        o.a.qyi.HB(str);
                    }
                }
                obj = null;
                o.a.qyi.HB(str);
            }
            SD = "MicroMsg.BigBallContactAssemblerImpl";
            String str3 = "processModContact chatroom:%s count:%d ChatRoomData:%s owner:%s type:%d max:%d upgrader:%s ver:%d infomask:%d ";
            Object[] objArr = new Object[9];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(aue.rGM == null ? 0 : aue.rGM.hLg);
            objArr[2] = aue.rXh;
            objArr[3] = aue.rXg;
            objArr[4] = Integer.valueOf(aue.rXr);
            objArr[5] = Integer.valueOf(aue.rXq);
            objArr[6] = aue.jTB;
            objArr[7] = Integer.valueOf(aue.rXp);
            if (aue.rGM == null) {
                i = -1;
            } else {
                i = aue.rGM.rqW;
            }
            objArr[8] = Integer.valueOf(i);
            x.i(SD, str3, objArr);
            if (!(aue.rGM == null || aue.rGM.hLg == 0)) {
                com.tencent.mm.i.a.a.a aVar = new com.tencent.mm.i.a.a.a();
                aVar.type = aue.rXr;
                aVar.daw = aue.rXq;
                aVar.dax = aue.jTB;
                aVar.daz = aue.rXp;
                if (aue.rGM.rqW == 0) {
                    aVar.bUd = aue.rXp;
                }
                if (m.F(str, aue.rXp)) {
                    com.tencent.mm.sdk.b.a.sFg.m(new ha());
                    m.G(str, aue.rXr);
                }
                jy jyVar = new jy();
                jyVar.bUc.chatroomName = str;
                jyVar.bUc.bUd = aVar.bUd;
                m.a(str, aue.rXg, aue.rGM, q.GF(), aVar, jyVar);
            }
        }
        if (!(a.gd(abVar.field_type) || abVar.By() || ab.gY(abVar.field_username) || s.fq(abVar.field_username))) {
            x.w("MicroMsg.BigBallContactAssemblerImpl", "processModContact delChatContact now user:%s ,type:%d", new Object[]{abVar.field_username, Integer.valueOf(abVar.field_type)});
            au.HU();
            com.tencent.mm.model.c.FW().Yp(abVar.field_username);
        }
        if ((abVar.field_type & 2048) != 0) {
            if (abVar2 == null || (abVar2.field_type & 2048) != (abVar.field_type & 2048)) {
                if (f.kL(abVar.field_username) && !f.eZ(abVar.field_username)) {
                    A(abVar);
                } else if (abVar.ckW() && f.kJ(abVar.field_username) && abVar != null && abVar.ckW() && f.kJ(abVar.field_username)) {
                    x.i("MicroMsg.BigBallContactAssemblerImpl", "dealPlaceSubscribeBizToTop uct : " + abVar.field_username);
                    au.HU();
                    ai Yq = com.tencent.mm.model.c.FW().Yq(abVar.field_username);
                    z.MY().kA(abVar.field_username);
                    if (Yq == null) {
                        au.HU();
                        if (com.tencent.mm.model.c.FW().Yq("officialaccounts") == null) {
                            Yq = new ai("officialaccounts");
                            Yq.clx();
                            au.HU();
                            com.tencent.mm.model.c.FW().d(Yq);
                        }
                        Yq = new ai(abVar.field_username);
                        Yq.ef("officialaccounts");
                        au.HU();
                        com.tencent.mm.model.c.FW().d(Yq);
                    }
                }
            }
        } else if ((abVar2 == null || (abVar2.field_type & 2048) != (abVar.field_type & 2048)) && f.kL(abVar.field_username) && !f.eZ(abVar.field_username)) {
            A(abVar);
        }
        if (abVar2 == null || a.gd(abVar2.field_type) || !a.gd(abVar.field_type)) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        if (a.gd(abVar.field_type)) {
            au.HU();
            bq Hh = com.tencent.mm.model.c.FS().Hh(str);
            if ((Hh == null || bi.oW(Hh.field_encryptUsername)) && !bi.oW(str2)) {
                au.HU();
                Hh = com.tencent.mm.model.c.FS().Hh(str2);
            }
            if (!(Hh == null || bi.oW(Hh.field_encryptUsername))) {
                au.HU();
                com.tencent.mm.model.c.FS().Hi(Hh.field_encryptUsername);
            }
        }
        if (f.kK(abVar.field_username)) {
            z.Nh();
            com.tencent.mm.ac.c.a(abVar.field_username, null);
            if (obj2 != null && f.kL(abVar.field_username)) {
                if (f.eZ(abVar.field_username)) {
                    z.Ng();
                    com.tencent.mm.ac.a.h.a(abVar.field_username, null);
                } else if (f.kO(abVar.field_username)) {
                    au.HU();
                    if (com.tencent.mm.model.c.FW().Yq(abVar.field_username) == null) {
                        kA = z.MY().kA(abVar.field_username);
                        ai aiVar = new ai(abVar.field_username);
                        if (kA.Ma()) {
                            aiVar.ef(null);
                        } else {
                            x.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", new Object[]{kA.Mg(), abVar.field_username});
                            aiVar.ef(bi.oV(kA.Mg()));
                        }
                        aiVar.clx();
                        au.HU();
                        com.tencent.mm.model.c.FW().d(aiVar);
                    }
                }
            }
        }
        kA = f.kH(abVar.field_username);
        if (kA != null) {
            d.b bG = kA.bG(false);
            if (bG != null) {
                i = 0;
                if (bG.dKT != null) {
                    i = bG.dKT.optInt("WXAppType", 0);
                }
                if (i != 0) {
                    String str4;
                    obj = 1;
                    if (obj != null) {
                        z.Nk();
                        str4 = abVar.field_username;
                        if (!bi.oW(str4)) {
                            kA = z.MY().kA(str4);
                            kA.field_attrSyncVersion = null;
                            kA.field_incrementUpdateTime = 0;
                            z.MY().e(kA);
                        }
                    }
                    if ((abVar.field_type & 8) == 0) {
                        if (abVar2 == null || (abVar2.field_type & 8) != (abVar.field_type & 8)) {
                            au.HU();
                            com.tencent.mm.model.c.FW().d(new String[]{abVar.field_username}, "@blacklist");
                        }
                    } else if (abVar2 == null || (abVar2.field_type & 8) != (abVar.field_type & 8)) {
                        au.HU();
                        com.tencent.mm.model.c.FW().d(new String[]{abVar.field_username}, "");
                    }
                    if (!z) {
                        if (abVar != null && abVar.ckW() && a.gd(abVar.field_type)) {
                            long currentTimeMillis = System.currentTimeMillis();
                            au.HU();
                            ai Yq2 = com.tencent.mm.model.c.FW().Yq(abVar.field_username);
                            if (Yq2 != null && Yq2.gh(4194304)) {
                                au.HU();
                                boolean a = com.tencent.mm.model.c.FW().a(abVar.field_username, 4194304, false, Yq2.field_attrflag);
                                x.i("MicroMsg.BigBallContactAssemblerImpl", "Reset temp session attr flag.(talker %s, updateSucc %s, cost %s)", new Object[]{abVar.field_username, Boolean.valueOf(a), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                            }
                        }
                        if (abVar2 != null && ((int) abVar2.dhP) > 0 && abVar2.csR != 0 && abVar2.csS == 0 && abVar.csS == 1) {
                            x.d("MicroMsg.BigBallContactAssemblerImpl", "hakon removeParentRefAndUnread user = %s", new Object[]{abVar.field_username});
                            au.HU();
                            com.tencent.mm.model.c.FW().YG(abVar.field_username);
                            au.HU();
                            ai Yq3 = com.tencent.mm.model.c.FW().Yq("officialaccounts");
                            if (Yq3 != null) {
                                au.HU();
                                Yq3.eV(com.tencent.mm.model.c.FW().clH());
                                x.d("MicroMsg.BigBallContactAssemblerImpl", "unread count is %d", new Object[]{Integer.valueOf(Yq3.field_unReadCount)});
                                au.HU();
                                str4 = com.tencent.mm.model.c.FW().YD("officialaccounts");
                                au.HU();
                                bd GE = com.tencent.mm.model.c.FT().GE(str4);
                                if (GE == null || GE.field_msgId <= 0) {
                                    Yq3.clx();
                                } else {
                                    Yq3.aj(GE);
                                    Yq3.setContent(GE.field_talker + ":" + GE.field_content);
                                    Yq3.ec(Integer.toString(GE.getType()));
                                    au.HU();
                                    az.b vu = com.tencent.mm.model.c.FW().vu();
                                    if (vu != null) {
                                        PString pString = new PString();
                                        PString pString2 = new PString();
                                        PInt pInt = new PInt();
                                        GE.ep("officialaccounts");
                                        GE.setContent(Yq3.field_content);
                                        vu.a(GE, pString, pString2, pInt, true);
                                        Yq3.ed(pString.value);
                                        Yq3.ee(pString2.value);
                                        Yq3.eY(pInt.value);
                                    }
                                }
                                au.HU();
                                com.tencent.mm.model.c.FW().a(Yq3, Yq3.field_username);
                            }
                        }
                    }
                    if (obj2 != null) {
                        jn jnVar = new jn();
                        jnVar.bTh.username = abVar.field_username;
                        jnVar.bTh.bTi = abVar.bTi;
                        com.tencent.mm.sdk.b.a.sFg.m(jnVar);
                    }
                    if (obj2 != null && aue.rdq == 18) {
                        itVar = new it();
                        itVar.bSl.bSm = abVar.field_encryptUsername;
                        itVar.bSl.type = 2;
                        com.tencent.mm.az.d.SG().YQ(itVar.bSl.bSm);
                        com.tencent.mm.sdk.b.a.sFg.m(itVar);
                    }
                    if (obj2 != null) {
                        aU(abVar.field_username, aue.rdq);
                    }
                    com.tencent.mm.plugin.label.a.a.aYK().aYE();
                }
            }
        }
        obj = null;
        if (obj != null) {
            z.Nk();
            str4 = abVar.field_username;
            if (!bi.oW(str4)) {
                kA = z.MY().kA(str4);
                kA.field_attrSyncVersion = null;
                kA.field_incrementUpdateTime = 0;
                z.MY().e(kA);
            }
        }
        if ((abVar.field_type & 8) == 0) {
            if (abVar2 == null || (abVar2.field_type & 8) != (abVar.field_type & 8)) {
                au.HU();
                com.tencent.mm.model.c.FW().d(new String[]{abVar.field_username}, "");
            }
        } else if (abVar2 == null || (abVar2.field_type & 8) != (abVar.field_type & 8)) {
            au.HU();
            com.tencent.mm.model.c.FW().d(new String[]{abVar.field_username}, "@blacklist");
        }
        if (z) {
            if (abVar != null && abVar.ckW() && a.gd(abVar.field_type)) {
                long currentTimeMillis2 = System.currentTimeMillis();
                au.HU();
                ai Yq22 = com.tencent.mm.model.c.FW().Yq(abVar.field_username);
                if (Yq22 != null && Yq22.gh(4194304)) {
                    au.HU();
                    boolean a2 = com.tencent.mm.model.c.FW().a(abVar.field_username, 4194304, false, Yq22.field_attrflag);
                    x.i("MicroMsg.BigBallContactAssemblerImpl", "Reset temp session attr flag.(talker %s, updateSucc %s, cost %s)", new Object[]{abVar.field_username, Boolean.valueOf(a2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
                }
            }
            if (abVar2 != null && ((int) abVar2.dhP) > 0 && abVar2.csR != 0 && abVar2.csS == 0 && abVar.csS == 1) {
                x.d("MicroMsg.BigBallContactAssemblerImpl", "hakon removeParentRefAndUnread user = %s", new Object[]{abVar.field_username});
                au.HU();
                com.tencent.mm.model.c.FW().YG(abVar.field_username);
                au.HU();
                ai Yq32 = com.tencent.mm.model.c.FW().Yq("officialaccounts");
                if (Yq32 != null) {
                    au.HU();
                    Yq32.eV(com.tencent.mm.model.c.FW().clH());
                    x.d("MicroMsg.BigBallContactAssemblerImpl", "unread count is %d", new Object[]{Integer.valueOf(Yq32.field_unReadCount)});
                    au.HU();
                    str4 = com.tencent.mm.model.c.FW().YD("officialaccounts");
                    au.HU();
                    bd GE2 = com.tencent.mm.model.c.FT().GE(str4);
                    if (GE2 == null || GE2.field_msgId <= 0) {
                        Yq32.clx();
                    } else {
                        Yq32.aj(GE2);
                        Yq32.setContent(GE2.field_talker + ":" + GE2.field_content);
                        Yq32.ec(Integer.toString(GE2.getType()));
                        au.HU();
                        az.b vu2 = com.tencent.mm.model.c.FW().vu();
                        if (vu2 != null) {
                            PString pString3 = new PString();
                            PString pString22 = new PString();
                            PInt pInt2 = new PInt();
                            GE2.ep("officialaccounts");
                            GE2.setContent(Yq32.field_content);
                            vu2.a(GE2, pString3, pString22, pInt2, true);
                            Yq32.ed(pString3.value);
                            Yq32.ee(pString22.value);
                            Yq32.eY(pInt2.value);
                        }
                    }
                    au.HU();
                    com.tencent.mm.model.c.FW().a(Yq32, Yq32.field_username);
                }
            }
        }
        if (obj2 != null) {
            jn jnVar2 = new jn();
            jnVar2.bTh.username = abVar.field_username;
            jnVar2.bTh.bTi = abVar.bTi;
            com.tencent.mm.sdk.b.a.sFg.m(jnVar2);
        }
        itVar = new it();
        itVar.bSl.bSm = abVar.field_encryptUsername;
        itVar.bSl.type = 2;
        com.tencent.mm.az.d.SG().YQ(itVar.bSl.bSm);
        com.tencent.mm.sdk.b.a.sFg.m(itVar);
        if (obj2 != null) {
            aU(abVar.field_username, aue.rdq);
        }
        com.tencent.mm.plugin.label.a.a.aYK().aYE();
    }

    private static void a(aue aue, String str, ab abVar, boolean z) {
        String GF = q.GF();
        if (GF != null && !GF.equals(str)) {
            d kA = z.MY().kA(str);
            kA.field_username = str;
            kA.field_brandList = aue.eJR;
            qt qtVar = aue.rTl;
            if (qtVar != null) {
                kA.field_brandFlag = qtVar.eJV;
                kA.field_brandInfo = qtVar.eJX;
                kA.field_brandIconURL = qtVar.eJY;
                kA.field_extInfo = qtVar.eJW;
                if (z) {
                    kA.field_attrSyncVersion = null;
                    kA.field_incrementUpdateTime = 0;
                    x.i("MicroMsg.BigBallContactAssemblerImpl", "Reset biz(%s) Attribute syncVersion and incUpdateTime.", new Object[]{str});
                }
                if (!bi.oW(kA.field_extInfo)) {
                    kA.bG(true);
                }
            }
            if (!(kA.bG(false) == null || kA.bG(false).Mw() != 3 || kA.bG(false).MB() == null || bi.oW(kA.Mg()))) {
                kA.field_enterpriseFather = kA.Mg();
                x.d("MicroMsg.BigBallContactAssemblerImpl", "saveBizInfo, %s set enterpriseFather %s", new Object[]{str, kA.field_enterpriseFather});
            }
            if (!z.MY().e(kA)) {
                z.MY().d(kA);
            }
            abVar.eR(kA.field_type);
        }
    }

    public static boolean a(ab abVar, aue aue, boolean z) {
        if (abVar == null || bi.oW(abVar.field_username)) {
            x.e("MicroMsg.BigBallContactAssemblerImpl", "dkinit dealModContactExtInfo failed invalid contact");
            return false;
        }
        String str = abVar.field_username;
        String str2 = abVar.field_encryptUsername;
        com.tencent.mm.aa.q.KH().a(com.tencent.mm.aa.c.a(str, aue));
        bqd bqd = aue.rTk;
        if (!(abVar.field_username.endsWith("@chatroom") || bqd == null)) {
            x.i("MicroMsg.BigBallContactAssemblerImpl", "SnsFlag modcontact " + bqd.eJS + " " + aue.rvi);
            x.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBg modcontact " + bqd.eJT);
            x.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + bqd.eJU);
            x.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + bqd.sod);
            if (n.nky != null) {
                n.nky.a(abVar.field_username, bqd);
            }
        }
        if (a.gd(abVar.field_type)) {
            boolean db = com.tencent.mm.az.d.SF().db(str, 1);
            if (db) {
                x.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, user = " + str);
            } else {
                db = com.tencent.mm.az.d.SF().db(str2, 1);
                x.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, encryptUser = " + str2);
            }
            x.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact, update state(ADDED) FMessageConversation, ret = " + db);
        }
        if (a.gd(abVar.field_type) && (abVar.getSource() == 10 || abVar.getSource() == 13)) {
            Context context = ad.getContext();
            str2 = abVar.field_username;
            String str3 = abVar.field_encryptUsername;
            if (com.tencent.mm.platformtools.x.cc(context)) {
                com.tencent.mm.sdk.f.e.b(new i(context, com.tencent.mm.platformtools.x.ce(context), str2, str3), "MMAccountManager_updateSpecifiedContact").start();
            } else {
                com.tencent.mm.platformtools.x.H(context, null);
                x.d("MicroMsg.MMAccountManager", "no account added or not current account");
            }
            com.tencent.mm.plugin.account.friend.a.a pp = b.getAddrUploadStg().pp(abVar.field_encryptUsername);
            if (!(pp == null || bi.oW(pp.eJG))) {
                pp.username = abVar.field_username;
                x.d("MicroMsg.BigBallContactAssemblerImpl", "account sync: update addr " + b.getAddrUploadStg().a(pp.eJG, pp));
            }
        }
        a(aue, str, abVar, z);
        return true;
    }

    private static boolean a(ab abVar, bq bqVar) {
        boolean z = false;
        if (!bi.oW(bqVar.field_conDescription)) {
            abVar.dT(bqVar.field_conDescription);
        }
        if (!s.hd(abVar.field_username) && a.gd(abVar.field_type)) {
            z = true;
            if (!bi.oW(bqVar.field_conDescription)) {
                auf auf = new auf();
                auf.rXy = abVar.field_username;
                auf.jOS = bqVar.field_conDescription;
                au.HU();
                com.tencent.mm.model.c.FQ().b(new h.a(54, auf));
            }
        }
        return z;
    }

    private static void A(ab abVar) {
        if (abVar != null && f.kL(abVar.field_username) && !f.eZ(abVar.field_username)) {
            au.HU();
            ai Yq = com.tencent.mm.model.c.FW().Yq(abVar.field_username);
            d kA = z.MY().kA(abVar.field_username);
            if (f.kO(kA.field_username) && Yq == null) {
                Yq = new ai(kA.field_username);
                x.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", new Object[]{kA.Mg(), kA.field_username});
                Yq.ef(bi.oV(kA.Mg()));
                Yq.clx();
                au.HU();
                com.tencent.mm.model.c.FW().d(Yq);
            }
        }
    }

    private static void aU(String str, int i) {
        com.tencent.mm.pluginsdk.ui.preference.b[] a;
        bo[] boVarArr;
        at[] atVarArr;
        ba[] baVarArr;
        if (i == 26 || i == 27 || i == 28 || i == 29) {
            x.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is shake");
            bo[] Zp = com.tencent.mm.az.d.SH().Zp(str);
            a = com.tencent.mm.pluginsdk.ui.preference.b.a(ad.getContext(), Zp);
            boVarArr = Zp;
            atVarArr = null;
            baVarArr = null;
        } else if (i == 18) {
            x.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is lbs");
            ba[] YR = com.tencent.mm.az.d.SG().YR(str);
            a = com.tencent.mm.pluginsdk.ui.preference.b.a(ad.getContext(), YR);
            boVarArr = null;
            atVarArr = null;
            baVarArr = YR;
        } else {
            at[] YM = com.tencent.mm.az.d.SE().YM(str);
            a = com.tencent.mm.pluginsdk.ui.preference.b.a(ad.getContext(), YM);
            boVarArr = null;
            atVarArr = YM;
            baVarArr = null;
        }
        if (a != null) {
            int i2 = 0;
            int length = a.length;
            int i3 = 0;
            while (i3 < length) {
                int i4;
                com.tencent.mm.pluginsdk.ui.preference.b bVar = a[i3];
                bd bdVar = new bd();
                bdVar.setContent(bVar.dzA);
                int hQ = s.hQ(bVar.username);
                if (atVarArr != null) {
                    i4 = i2 + 1;
                    bdVar.ay(atVarArr[i2].field_createTime);
                } else if (baVarArr != null) {
                    i4 = i2 + 1;
                    bdVar.ay(baVarArr[i2].field_createtime * 1000);
                } else if (boVarArr != null) {
                    i4 = i2 + 1;
                    bdVar.ay(boVarArr[i2].field_createtime * 1000);
                } else {
                    i4 = i2;
                }
                bdVar.ep(bVar.username);
                bdVar.setType(hQ);
                if (bVar.ceW) {
                    bdVar.setStatus(2);
                    bdVar.eX(1);
                } else {
                    bdVar.setStatus(6);
                    bdVar.eX(0);
                }
                au.HU();
                long T = com.tencent.mm.model.c.FT().T(bdVar);
                Assert.assertTrue(T != -1);
                x.i("MicroMsg.BigBallContactAssemblerImpl", "new msg inserted to db , local id = " + T);
                i3++;
                i2 = i4;
            }
            bd bdVar2 = new bd();
            if (atVarArr != null) {
                bdVar2.ay(atVarArr[atVarArr.length - 1].field_createTime + 1);
            } else if (baVarArr != null) {
                bdVar2.ay((baVarArr[baVarArr.length - 1].field_createtime * 1000) + 1);
            } else if (boVarArr != null) {
                bdVar2.ay((boVarArr[boVarArr.length - 1].field_createtime * 1000) + 1);
            }
            bdVar2.ep(str);
            bdVar2.setContent(ad.getContext().getString(R.l.transfer_greet_msg_tip));
            bdVar2.setType(10000);
            bdVar2.setStatus(6);
            bdVar2.eX(0);
            au.HU();
            com.tencent.mm.model.c.FT().T(bdVar2);
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.BigBallContactAssemblerImpl", "onsceneEnd errType:%d,errCode:%d,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (lVar.getType() != 681 || i != 0 || i2 != 0) {
            return;
        }
        if (com.tencent.mm.kernel.g.Eg().dpD) {
            List<h.b> list = ((com.tencent.mm.aq.a) lVar).ebW;
            Set<String> hashSet = new HashSet();
            try {
                for (h.b bVar : list) {
                    if (bVar.getCmdId() == 2) {
                        hashSet.add(com.tencent.mm.platformtools.ab.a(((aue) new aue().aG(bVar.getBuffer())).rvi));
                    } else if (bVar.getCmdId() == 54) {
                        hashSet.add(((auf) new auf().aG(bVar.getBuffer())).rXy);
                    } else if (bVar.getCmdId() == 60) {
                        hashSet.add(((aur) new aur().aG(bVar.getBuffer())).rXy);
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.BigBallContactAssemblerImpl", e, "BaseProtoBuf parseFrom error!", new Object[0]);
            }
            for (String str2 : hashSet) {
                if (!bi.oW(str2)) {
                    am.a.dBr.a(str2, null, null);
                }
            }
            return;
        }
        x.w("MicroMsg.BigBallContactAssemblerImpl", "initialize notify is not done.");
    }
}
