package com.tencent.mm.ac;

import android.os.Looper;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.aas;
import com.tencent.mm.protocal.c.blr;
import com.tencent.mm.protocal.c.fh;
import com.tencent.mm.protocal.c.ia;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bi;

public final class c extends i<b> implements e {
    public static fh dKB;
    public static final String[] diD = new String[]{i.a(b.dhO, "BizEnterprise")};
    private final k<a, a> dKC = new 1(this);
    private com.tencent.mm.sdk.e.e diF;

    public c(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, b.dhO, "BizEnterprise", null);
        this.diF = eVar;
        eVar.fV("BizEnterprise", "CREATE INDEX IF NOT EXISTS BizEnterpriseUserNameIndex ON BizEnterprise ( userName )");
        g.Eh().dpP.a(1343, this);
        g.Eh().dpP.a(1228, this);
    }

    public final void a(a aVar, Looper looper) {
        this.dKC.a(aVar, looper);
    }

    public final void a(a aVar) {
        if (this.dKC != null) {
            this.dKC.remove(aVar);
        }
    }

    public final b kn(String str) {
        if (bi.oW(str)) {
            return null;
        }
        b bVar = new b();
        bVar.field_userName = str;
        if (super.b(bVar, new String[0])) {
            return bVar;
        }
        a(str, null);
        return null;
    }

    public final b ko(String str) {
        b kn = kn(str);
        if (kn != null) {
            return kn;
        }
        kn = new b();
        kn.field_userName = str;
        kn.field_qyUin = 0;
        kn.field_userUin = 0;
        kn.field_userFlag = 0;
        kn.field_wwExposeTimes = 0;
        kn.field_wwMaxExposeTimes = 0;
        kn.field_wwUserVid = 0;
        kn.field_wwCorpId = 0;
        kn.field_chatOpen = false;
        kn.field_wwUnreadCnt = 0;
        return kn;
    }

    public final int kp(String str) {
        b kn = kn(str);
        if (kn == null) {
            return 0;
        }
        return kn.field_qyUin;
    }

    public final boolean jy(String str) {
        boolean z = false;
        if (!bi.oW(str)) {
            b bVar = new b();
            bVar.field_userName = str;
            z = super.a(bVar, new String[]{"userName"});
            if (z) {
                a aVar = new a();
                aVar.dKF = str;
                aVar.dKE = b.dKI;
                aVar.dKG = bVar;
                this.dKC.ci(aVar);
                this.dKC.doNotify();
            }
        }
        return z;
    }

    private boolean a(b bVar) {
        if (bVar == null) {
            return false;
        }
        boolean b = super.b(bVar);
        int i = b.dKH;
        if (!b) {
            b = super.a(bVar);
            i = b.dKJ;
        }
        if (!b) {
            return b;
        }
        a aVar = new a();
        aVar.dKF = bVar.field_userName;
        aVar.dKE = i;
        aVar.dKG = bVar;
        this.dKC.ci(aVar);
        this.dKC.doNotify();
        return b;
    }

    private boolean a(ia iaVar) {
        b ko = ko(iaVar.riK);
        ko.field_userName = iaVar.riK;
        ko.field_qyUin = iaVar.riU;
        ko.field_userUin = iaVar.riV;
        ko.field_wwMaxExposeTimes = iaVar.riX;
        ko.field_wwUserVid = iaVar.riY;
        ko.field_wwCorpId = iaVar.riZ;
        ko.field_userType = iaVar.rja;
        ko.field_chatOpen = iaVar.rjb;
        ko.field_wwUnreadCnt = iaVar.rjc;
        ko.field_show_confirm = iaVar.rjd;
        ko.field_use_preset_banner_tips = iaVar.rjf;
        dKB = iaVar.rje;
        if (iaVar.riY == 0 && iaVar.riZ == 0 && iaVar.riU != 0) {
            ko.field_wwUserVid = (long) iaVar.riV;
            ko.field_wwCorpId = (long) iaVar.riU;
        }
        iaVar.riW &= -9;
        ko.field_userFlag = iaVar.riW | (ko.field_userFlag & 8);
        return a(ko);
    }

    public static boolean a(String str, e eVar) {
        if (bi.oW(str)) {
            return false;
        }
        int i;
        if (f.kM(str)) {
            i = 1;
        } else if (!f.kL(str)) {
            return false;
        } else {
            i = 2;
        }
        return g.Eh().dpP.a(new s(str, i, eVar), 0);
    }

    public static y a(String str, boolean z, e eVar) {
        ia iaVar = new ia();
        iaVar.riK = str;
        iaVar.riW = z ? 1 : 0;
        iaVar.riU = 0;
        y yVar = new y(iaVar, eVar);
        return g.Eh().dpP.a(yVar, 0) ? yVar : null;
    }

    public final void kq(String str) {
        b ko = ko(str);
        if (ko.field_wwExposeTimes < ko.field_wwMaxExposeTimes) {
            ko.field_wwExposeTimes++;
            a(ko);
        }
    }

    public static void a(y yVar) {
        g.Eh().dpP.c(yVar);
        yVar.data = null;
    }

    public final boolean kr(String str) {
        b kn = kn(str);
        return (kn == null || (kn.field_userFlag & 1) == 0) ? false : true;
    }

    public static String ht(int i) {
        if (dKB == null) {
            dKB = new fh();
        }
        switch (i) {
            case 0:
                return dKB.rgh;
            case 1:
                return dKB.rgi;
            case 2:
                return dKB.rgj;
            default:
                return null;
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        int i3 = -1;
        if (i == 0 && i2 == 0) {
            e eVar;
            if (lVar instanceof s) {
                s sVar = (s) lVar;
                aas aas = (sVar.diG == null || sVar.diG.dIE.dIL == null) ? null : (aas) sVar.diG.dIE.dIL;
                if (aas != null && aas.riQ != null && aas.riQ.ret == 0 && aas.rFY != null) {
                    if (!a(aas.rFY)) {
                        i2 = -1;
                    }
                    eVar = (e) sVar.data;
                    if (eVar != null) {
                        eVar.a(i, i2, str, lVar);
                    }
                } else {
                    return;
                }
            }
            if (lVar instanceof y) {
                y yVar = (y) lVar;
                blr blr = (yVar.diG == null || yVar.diG.dIE.dIL == null) ? null : (blr) yVar.diG.dIE.dIL;
                if (blr != null && blr.riQ != null && blr.riQ.ret == 0 && blr.rFY != null) {
                    if (a(blr.rFY)) {
                        i3 = i2;
                    }
                    eVar = (e) yVar.data;
                    if (eVar != null) {
                        eVar.a(i, i3, str, lVar);
                    }
                }
            }
        }
    }
}
