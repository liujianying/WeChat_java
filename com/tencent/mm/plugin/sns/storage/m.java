package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.protocal.c.bqd;
import com.tencent.mm.protocal.c.xs;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends i<l> implements e {
    public static final String[] diD = new String[]{i.a(l.dhO, "snsExtInfo3")};
    public com.tencent.mm.sdk.e.e diF;
    private boolean nJh = false;
    private g nJi = null;

    public final void bwS() {
        x.d("MicroMsg.SnsExtStorage", "attachCache");
        this.nJh = true;
    }

    public final void bwT() {
        this.nJh = false;
        this.nJi.byF();
        x.d("MicroMsg.SnsExtStorage", "detchCache");
    }

    public m(com.tencent.mm.sdk.e.e eVar, g gVar) {
        super(eVar, l.dhO, "snsExtInfo3", null);
        this.diF = eVar;
        this.nJi = gVar;
        x.i("MicroMsg.SnsExtStorage", "createExtStorage " + eVar + "  " + Thread.currentThread().getId());
    }

    public final boolean b(l lVar) {
        return super.a(lVar);
    }

    public final boolean a(l lVar) {
        if (!this.nJh || this.nJi == null) {
            return super.a(lVar);
        }
        boolean a = this.nJi.a(lVar);
        if (this.nJi == null) {
            return a;
        }
        this.nJi.byE();
        return a;
    }

    public final void Nm(String str) {
        l Np = Np(str);
        Np.field_userName = str;
        super.a(Np, new String[]{this.sKB.sKz});
    }

    public final int l(String str, String str2, int i, int i2) {
        l Np = Np(str);
        Np.field_md5 = str2;
        Np.field_lastFirstPageRequestErrType = i;
        Np.field_lastFirstPageRequestErrCode = i2;
        super.a(Np);
        return 0;
    }

    public final int f(String str, String str2, byte[] bArr) {
        l Np = Np(str);
        Np.field_md5 = str2;
        Np.field_adsession = bArr;
        super.a(Np);
        return 0;
    }

    public final boolean eM(String str, String str2) {
        l Np = Np(str);
        Np.field_newerIds = str2;
        return super.a(Np);
    }

    public final xs Nn(String str) {
        xs xsVar;
        xs xsVar2 = new xs();
        l lVar = new l();
        lVar = Np(str);
        try {
            if (!bi.bC(lVar.field_faultS)) {
                xsVar = (xs) new xs().aG(lVar.field_faultS);
                if (xsVar != null) {
                    return new xs();
                }
                return xsVar;
            }
        } catch (Exception e) {
            x.e("MicroMsg.SnsExtStorage", "parser field_faultS error");
        }
        xsVar = xsVar2;
        if (xsVar != null) {
            return xsVar;
        }
        return new xs();
    }

    public final void No(String str) {
        l lVar = new l();
        lVar = Np(str);
        lVar.field_userName = str;
        lVar.field_local_flag &= -2;
        c(lVar);
    }

    public final l Np(String str) {
        l lVar = new l();
        if (this.nJi != null && this.nJh) {
            lVar = this.nJi.Mj(str);
            if (lVar == null) {
                lVar = new l();
            }
            return lVar;
        }
        lVar.field_userName = str;
        super.b(lVar, new String[]{this.sKB.sKz});
        return lVar;
    }

    public final boolean c(l lVar) {
        if (lVar == null || lVar.field_userName == null || lVar.field_userName.equals("")) {
            return false;
        }
        return super.a(lVar);
    }

    public final boolean a(String str, bqd bqd) {
        l Np = Np(str);
        String eF = com.tencent.mm.plugin.sns.data.i.eF(bqd.eJU);
        if (!bi.oW(bqd.eJT) && (Np.field_bgUrl == null || !Np.field_bgId.equals(eF))) {
            Np.field_older_bgId = Np.field_bgId;
            Np.field_local_flag |= 1;
            Np.bAS();
            x.d("MicroMsg.SnsExtStorage", "bg change");
        }
        Np.field_bgId = eF;
        Np.field_bgUrl = bqd.eJT;
        Np.field_iFlag = bqd.eJS;
        Np.field_snsBgId = bqd.eJU;
        Np.field_local_flag |= 4;
        if (bqd != null) {
            try {
                Np.field_snsuser = bqd.toByteArray();
            } catch (Exception e) {
            }
        }
        a(Np);
        return true;
    }

    public final bqd b(String str, bqd bqd) {
        l Np = Np(str);
        l a;
        int i;
        if (Np == null) {
            a = a(str, Np);
            if (a != null) {
                if (bqd.eJS == -1) {
                    i = a.field_iFlag;
                } else {
                    i = bqd.eJS;
                }
                bqd.eJS = i;
            }
        } else {
            bqd.eJT = bi.oW(bqd.eJT) ? Np.field_bgUrl : bqd.eJT;
            Object obj = bqd.eJS == -1 ? 1 : null;
            bqd.eJS = obj != null ? Np.field_iFlag : bqd.eJS;
            a = a(str, Np);
            if (a != null) {
                if (obj != null) {
                    i = a.field_iFlag;
                } else {
                    i = bqd.eJS;
                }
                bqd.eJS = i;
            }
        }
        return bqd;
    }

    private l a(String str, l lVar) {
        int i;
        int i2;
        Cursor b;
        if (lVar == null) {
            i = 0;
        } else {
            if ((lVar.field_iFlag & 1) > 0) {
                i = 1;
            } else {
                i = 0;
            }
            if ((lVar.field_local_flag & 4) > 0) {
                i2 = 1;
                if (i2 == 0 && r0 == 0) {
                    b = this.diF.b("select count(*)  from sqlite_master where type='table' and name = 'snsExtInfo2'", null, 2);
                    if (b.moveToFirst()) {
                        i = 0;
                    } else {
                        i = b.getInt(0);
                    }
                    b.close();
                    if (i != 0) {
                        x.v("MicroMsg.SnsExtStorage", "can not get snsextinfo2 %s", new Object[]{str});
                        return null;
                    }
                    x.d("MicroMsg.SnsExtStorage", "get from snsextinfo2 sql %s", new Object[]{"select * from snsExtInfo2 where userName=\"" + bi.oU(str) + "\""});
                    b = this.diF.b(r0, null, 2);
                    l lVar2 = new l();
                    if (b.moveToFirst()) {
                        lVar2.d(b);
                        b.close();
                        x.i("MicroMsg.SnsExtStorage", "setSnsUserInfo fix newversion change snsextinfo3 %s", new Object[]{str});
                        return lVar2;
                    }
                    b.close();
                }
                return null;
            }
        }
        i2 = 0;
        b = this.diF.b("select count(*)  from sqlite_master where type='table' and name = 'snsExtInfo2'", null, 2);
        if (b.moveToFirst()) {
            i = 0;
        } else {
            i = b.getInt(0);
        }
        b.close();
        if (i != 0) {
            x.d("MicroMsg.SnsExtStorage", "get from snsextinfo2 sql %s", new Object[]{"select * from snsExtInfo2 where userName=\"" + bi.oU(str) + "\""});
            b = this.diF.b(r0, null, 2);
            l lVar22 = new l();
            if (b.moveToFirst()) {
                lVar22.d(b);
                b.close();
                x.i("MicroMsg.SnsExtStorage", "setSnsUserInfo fix newversion change snsextinfo3 %s", new Object[]{str});
                return lVar22;
            }
            b.close();
        } else {
            x.v("MicroMsg.SnsExtStorage", "can not get snsextinfo2 %s", new Object[]{str});
            return null;
        }
    }

    public final bqd Lv(String str) {
        l Np = Np(str);
        if (Np == null) {
            return new bqd();
        }
        return Np.bAU();
    }

    public final boolean aQ(String str, boolean z) {
        l Np = Np(str);
        int i = Np.field_iFlag;
        if (z) {
            i |= 1;
        } else {
            i &= -2;
        }
        Np.field_iFlag = i;
        c(Np);
        return true;
    }

    public final bqd aR(String str, boolean z) {
        bqd bAU = Np(str).bAU();
        if (bAU == null) {
            x.e("MicroMsg.SnsExtStorage", "userinfo is null");
            return null;
        }
        int i = bAU.sod;
        if (z) {
            i |= 1;
        } else {
            i &= -2;
        }
        bAU.sod = i;
        return bAU;
    }

    public final boolean a(String str, boolean z, boolean z2, boolean z3) {
        l Np = Np(str);
        int i = Np.field_iFlag;
        if (z) {
            i |= 512;
        } else {
            i &= -513;
        }
        if (z2) {
            i |= 1024;
        } else {
            i &= -1025;
        }
        if (z3) {
            i |= 2048;
        } else {
            i &= -2049;
        }
        Np.field_iFlag = i;
        c(Np);
        return true;
    }

    public final bqd b(String str, boolean z, boolean z2, boolean z3) {
        bqd bAU = Np(str).bAU();
        if (bAU == null) {
            x.e("MicroMsg.SnsExtStorage", "userinfo is null");
            return null;
        }
        int i = bAU.sod;
        if (z) {
            i |= 512;
        } else {
            i &= -513;
        }
        if (z2) {
            i |= 1024;
        } else {
            i &= -1025;
        }
        if (z3) {
            i |= 2048;
        } else {
            i &= -2049;
        }
        bAU.sod = i;
        return bAU;
    }
}
