package com.tencent.mm.plugin.messenger.foundation;

import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.foundation.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.protocal.c.aue;
import com.tencent.mm.protocal.c.pm;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.vending.b.b;

public final class a implements q {
    private static final a lbM = new a((byte) 0);

    public static b a(c cVar) {
        return lbM.aI(cVar);
    }

    public final void a(pm pmVar, byte[] bArr, boolean z, s sVar) {
        switch (pmVar.rtM) {
            case 2:
            case 17:
                aue aue = (aue) new aue().aG(bArr);
                String str = "";
                if (!z) {
                    bArr = null;
                }
                a(aue, str, bArr, false, z);
                return;
            case 4:
                ra raVar = (ra) new ra().aG(bArr);
                String a = ab.a(raVar.rvi);
                x.i("MicroMsg.ContactSyncExtension", "processDelContact user:%s", new Object[]{a});
                ((i) g.l(i.class)).FW().Yp(a);
                com.tencent.mm.model.s.hh(a);
                t.b(4, raVar);
                return;
            default:
                return;
        }
    }

    public static void a(aue aue, String str, byte[] bArr, boolean z, boolean z2) {
        if (aue == null) {
            x.f("MicroMsg.ContactSyncExtension", "unable to parse mod contact");
            return;
        }
        String a = ab.a(aue.rvi);
        String oV = bi.oV(aue.rXj);
        if (bi.oW(a) && bi.oW(oV)) {
            x.e("MicroMsg.ContactSyncExtension", "processModContact user is null user:%s enuser:%s", new Object[]{a, oV});
            return;
        }
        x.i("MicroMsg.ContactSyncExtension", "username %s mobileHash %s mobileFullHash %s", new Object[]{aue.rvi, aue.rXm, aue.rXn});
        com.tencent.mm.storage.ab Yg = ((i) g.l(i.class)).FR().Yg(a);
        if (Yg == null || !a.equals(Yg.field_encryptUsername)) {
            com.tencent.mm.l.a clc;
            long j;
            String str2;
            String str3;
            Object[] objArr;
            int i;
            String str4;
            com.tencent.mm.storage.ab abVar = null;
            if (Yg != null) {
                clc = Yg.clc();
                if (clc != null) {
                    abVar = Yg;
                    if (abVar == null) {
                        abVar = new com.tencent.mm.storage.ab(a);
                    }
                    abVar.setUsername(a);
                    abVar.du(aue.eJM);
                    abVar.setType(aue.ruj & aue.ruk);
                    if (z && clc != null && ((int) clc.dhP) > 0) {
                        x.w("MicroMsg.ContactSyncExtension", "processModContact Fuck GETCONTACT can't give the REAL_TYPE (mariohuang), user:%s old:%d get:%d", new Object[]{a, Integer.valueOf(clc.field_type), Integer.valueOf(abVar.field_type)});
                        abVar.setType(abVar.field_type | clc.field_type);
                    }
                    if (!bi.oW(oV)) {
                        abVar.dD(oV);
                    } else if (clc != null && ((int) clc.dhP) > 0) {
                        abVar.dD(clc.field_encryptUsername);
                    }
                    if (clc != null) {
                        j = 0;
                    } else {
                        j = (long) ((int) clc.dhP);
                    }
                    abVar.dhP = j;
                    abVar.dx(ab.a(aue.rQz));
                    abVar.dy(ab.a(aue.ruT));
                    abVar.dz(ab.a(aue.ruU));
                    abVar.eJ(aue.eJH);
                    abVar.eM(aue.rup);
                    abVar.dw(ab.a(aue.rXd));
                    abVar.eN(aue.rut);
                    abVar.eO(aue.eJL);
                    abVar.dS(RegionCodeDecoder.aq(aue.eJQ, aue.eJI, aue.eJJ));
                    abVar.dM(aue.eJK);
                    abVar.eF(aue.rTe);
                    abVar.dR(aue.rTf);
                    abVar.setSource(aue.rdq);
                    abVar.eE(aue.rTi);
                    abVar.dA(aue.rTh);
                    if (com.tencent.mm.model.s.hU(aue.rTg)) {
                        abVar.dQ(aue.rTg);
                    }
                    if (abVar.ckZ()) {
                        abVar.eQ((int) bi.VE());
                    }
                    if (!TextUtils.isEmpty(str)) {
                        abVar.ea(str);
                    }
                    abVar.dv(ab.a(aue.rWH));
                    abVar.dB(ab.a(aue.rWJ));
                    abVar.dC(ab.a(aue.rWI));
                    abVar.dE(aue.rvl);
                    abVar.dT(aue.rej);
                    abVar.dU(aue.rXt);
                    if (bi.bC(bArr)) {
                        ((i) g.l(i.class)).FR().x(a, bArr);
                    } else {
                        ((i) g.l(i.class)).FR().Yl(a);
                    }
                    abVar.eH(aue.rXs);
                    if (!(aue.rXo == null || aue.rXo.rcy == null)) {
                        abVar.dV(aue.rXo.rcy.rhn);
                        abVar.dW(aue.rXo.rcy.rho);
                        abVar.dX(aue.rXo.rcy.rhp);
                    }
                    if (!(clc == null || com.tencent.mm.l.a.gd(clc.field_type))) {
                        com.tencent.mm.l.a.gd(abVar.field_type);
                    }
                    if (com.tencent.mm.model.s.hO(a)) {
                        abVar.Bk();
                    }
                    if (abVar.ckW()) {
                        abVar.Bn();
                    }
                    abVar.dY(aue.csY);
                    abVar.eS(aue.rXx);
                    str2 = "MicroMsg.ContactSyncExtension";
                    str3 = "processModContact:user[%s,%s] id:%d nick:%s pin:%s delflag:%d type:%d [%d,%d] contype:%d notify:%d region[%s,%s,%s] src:%d LabelIDList:%s fromGetContactService:%b remark_Description:(%s,%s,%s)";
                    objArr = new Object[20];
                    objArr[0] = a;
                    objArr[1] = oV;
                    objArr[2] = Integer.valueOf((int) abVar.dhP);
                    objArr[3] = abVar.field_nickname;
                    objArr[4] = abVar.wQ();
                    objArr[5] = Integer.valueOf(abVar.field_deleteFlag);
                    objArr[6] = Integer.valueOf(abVar.field_type);
                    objArr[7] = Integer.valueOf(aue.ruj);
                    objArr[8] = Integer.valueOf(aue.ruk);
                    objArr[9] = Integer.valueOf(abVar.csF);
                    objArr[10] = Integer.valueOf(abVar.csI);
                    objArr[11] = aue.eJQ;
                    objArr[12] = aue.eJI;
                    objArr[13] = aue.eJJ;
                    objArr[14] = Integer.valueOf(abVar.getSource());
                    objArr[15] = abVar.field_contactLabelIds;
                    objArr[16] = Boolean.valueOf(z);
                    objArr[17] = Boolean.valueOf(aue.rej != null);
                    if (aue.rej != null) {
                        i = 0;
                    } else {
                        i = aue.rej.length();
                    }
                    objArr[18] = Integer.valueOf(i);
                    if (aue.rej != null) {
                        str4 = "";
                    } else {
                        str4 = bi.Xf(aue.rej);
                    }
                    objArr[19] = str4;
                    x.i(str2, str3, objArr);
                    lbM.a(abVar, clc, aue, bArr, z2);
                    if (bi.oW(oV)) {
                        ((i) g.l(i.class)).FR().b(oV, abVar);
                    } else {
                        ((i) g.l(i.class)).FR().S(abVar);
                    }
                    lbM.b(abVar, clc, aue, bArr, z2);
                    if ((abVar.field_type & 2048) == 0) {
                        if (clc == null || (clc.field_type & 2048) != (abVar.field_type & 2048)) {
                            ((i) g.l(i.class)).FW().Yv(abVar.field_username);
                            return;
                        } else {
                            return;
                        }
                    } else if (clc == null || (clc.field_type & 2048) != (abVar.field_type & 2048)) {
                        ((i) g.l(i.class)).FW().Yw(abVar.field_username);
                        return;
                    } else {
                        return;
                    }
                }
            }
            clc = Yg;
            if (abVar == null) {
                abVar = new com.tencent.mm.storage.ab(a);
            }
            abVar.setUsername(a);
            abVar.du(aue.eJM);
            abVar.setType(aue.ruj & aue.ruk);
            x.w("MicroMsg.ContactSyncExtension", "processModContact Fuck GETCONTACT can't give the REAL_TYPE (mariohuang), user:%s old:%d get:%d", new Object[]{a, Integer.valueOf(clc.field_type), Integer.valueOf(abVar.field_type)});
            abVar.setType(abVar.field_type | clc.field_type);
            if (!bi.oW(oV)) {
                abVar.dD(oV);
            } else if (clc != null && ((int) clc.dhP) > 0) {
                abVar.dD(clc.field_encryptUsername);
            }
            if (clc != null) {
                j = (long) ((int) clc.dhP);
            } else {
                j = 0;
            }
            abVar.dhP = j;
            abVar.dx(ab.a(aue.rQz));
            abVar.dy(ab.a(aue.ruT));
            abVar.dz(ab.a(aue.ruU));
            abVar.eJ(aue.eJH);
            abVar.eM(aue.rup);
            abVar.dw(ab.a(aue.rXd));
            abVar.eN(aue.rut);
            abVar.eO(aue.eJL);
            abVar.dS(RegionCodeDecoder.aq(aue.eJQ, aue.eJI, aue.eJJ));
            abVar.dM(aue.eJK);
            abVar.eF(aue.rTe);
            abVar.dR(aue.rTf);
            abVar.setSource(aue.rdq);
            abVar.eE(aue.rTi);
            abVar.dA(aue.rTh);
            if (com.tencent.mm.model.s.hU(aue.rTg)) {
                abVar.dQ(aue.rTg);
            }
            if (abVar.ckZ()) {
                abVar.eQ((int) bi.VE());
            }
            if (TextUtils.isEmpty(str)) {
                abVar.ea(str);
            }
            abVar.dv(ab.a(aue.rWH));
            abVar.dB(ab.a(aue.rWJ));
            abVar.dC(ab.a(aue.rWI));
            abVar.dE(aue.rvl);
            abVar.dT(aue.rej);
            abVar.dU(aue.rXt);
            if (bi.bC(bArr)) {
                ((i) g.l(i.class)).FR().Yl(a);
            } else {
                ((i) g.l(i.class)).FR().x(a, bArr);
            }
            abVar.eH(aue.rXs);
            abVar.dV(aue.rXo.rcy.rhn);
            abVar.dW(aue.rXo.rcy.rho);
            abVar.dX(aue.rXo.rcy.rhp);
            com.tencent.mm.l.a.gd(abVar.field_type);
            if (com.tencent.mm.model.s.hO(a)) {
                abVar.Bk();
            }
            if (abVar.ckW()) {
                abVar.Bn();
            }
            abVar.dY(aue.csY);
            abVar.eS(aue.rXx);
            str2 = "MicroMsg.ContactSyncExtension";
            str3 = "processModContact:user[%s,%s] id:%d nick:%s pin:%s delflag:%d type:%d [%d,%d] contype:%d notify:%d region[%s,%s,%s] src:%d LabelIDList:%s fromGetContactService:%b remark_Description:(%s,%s,%s)";
            objArr = new Object[20];
            objArr[0] = a;
            objArr[1] = oV;
            objArr[2] = Integer.valueOf((int) abVar.dhP);
            objArr[3] = abVar.field_nickname;
            objArr[4] = abVar.wQ();
            objArr[5] = Integer.valueOf(abVar.field_deleteFlag);
            objArr[6] = Integer.valueOf(abVar.field_type);
            objArr[7] = Integer.valueOf(aue.ruj);
            objArr[8] = Integer.valueOf(aue.ruk);
            objArr[9] = Integer.valueOf(abVar.csF);
            objArr[10] = Integer.valueOf(abVar.csI);
            objArr[11] = aue.eJQ;
            objArr[12] = aue.eJI;
            objArr[13] = aue.eJJ;
            objArr[14] = Integer.valueOf(abVar.getSource());
            objArr[15] = abVar.field_contactLabelIds;
            objArr[16] = Boolean.valueOf(z);
            if (aue.rej != null) {
            }
            objArr[17] = Boolean.valueOf(aue.rej != null);
            if (aue.rej != null) {
                i = aue.rej.length();
            } else {
                i = 0;
            }
            objArr[18] = Integer.valueOf(i);
            if (aue.rej != null) {
                str4 = bi.Xf(aue.rej);
            } else {
                str4 = "";
            }
            objArr[19] = str4;
            x.i(str2, str3, objArr);
            lbM.a(abVar, clc, aue, bArr, z2);
            if (bi.oW(oV)) {
                ((i) g.l(i.class)).FR().S(abVar);
            } else {
                ((i) g.l(i.class)).FR().b(oV, abVar);
            }
            lbM.b(abVar, clc, aue, bArr, z2);
            if ((abVar.field_type & 2048) == 0) {
                if (clc == null || (clc.field_type & 2048) != (abVar.field_type & 2048)) {
                    ((i) g.l(i.class)).FW().Yw(abVar.field_username);
                    return;
                } else {
                    return;
                }
            } else if (clc == null || (clc.field_type & 2048) != (abVar.field_type & 2048)) {
                ((i) g.l(i.class)).FW().Yv(abVar.field_username);
                return;
            } else {
                return;
            }
        }
        x.w("MicroMsg.ContactSyncExtension", "cat's replace user with stranger  user:%s", new Object[]{a});
    }
}
