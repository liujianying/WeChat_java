package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.a.o;
import com.tencent.mm.plugin.offline.i.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public final class e extends a<b> {
    public String lIF = "";
    private a lIG = new 1(this);

    public final void auM() {
        if (this.lIC != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.lIC.size()) {
                    WeakReference weakReference = (WeakReference) this.lIC.get(i2);
                    if (weakReference != null) {
                        b bVar = (b) weakReference.get();
                        if (bVar != null) {
                            bVar.awE();
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public e() {
        k.bkO();
        if (k.bkR() != null) {
            k.bkO();
            k.bkR().lJj = this.lIG;
        }
    }

    private static void bkG() {
        k.bkO();
        k.bkR().dg(1, 1);
    }

    public final String k(int i, int i2, String str) {
        int i3 = 0;
        int bkH = bkH();
        if (bkH > 0) {
            if (bkH < k.lJy) {
                x.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount < %s", new Object[]{Integer.valueOf(k.lJy)});
                k.bkO();
                k.bkR().uj(2);
            }
            k.bkO();
            String uk = k.uk(196617);
            if (TextUtils.isEmpty(uk)) {
                x.e("MicroMsg.OfflineCodesMgr", "generateKey_V3 cn is null, the csr is not exist! cn:" + uk);
                return "";
            }
            com.tencent.mm.wallet_core.c.a.cCW();
            uk = com.tencent.mm.wallet_core.c.a.getToken(uk);
            if (TextUtils.isEmpty(uk)) {
                bkG();
                x.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null");
                return "";
            }
            if (uk != null) {
                x.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code length : %s ext_business_attach %s %s", new Object[]{Integer.valueOf(uk.length()), str, uk});
            }
            o oVar = new o(bkH - 1, i, i2, str);
            g.Ek();
            g.Eh().dpP.a(oVar, 0);
            x.i("MicroMsg.OfflineCodesMgr", "doNetSceneShowCode count " + (bkH - 1));
            LinkedList Jc = com.tencent.mm.plugin.offline.c.a.Jc(com.tencent.mm.plugin.offline.c.a.blO());
            if (Jc == null || Jc.size() == 0) {
                x.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 cardList is null");
                bkG();
                return "";
            } else if (uk == null || !com.tencent.mm.plugin.offline.c.a.xW(uk)) {
                x.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null or is not isNumeric");
                return "";
            } else {
                long longValue = Long.valueOf(uk, 10).longValue();
                long j = 0;
                int i4 = 0;
                while (i4 < Jc.size()) {
                    long j2;
                    com.tencent.mm.plugin.offline.c.a.a aVar = (com.tencent.mm.plugin.offline.c.a.a) Jc.get(i4);
                    if (aVar == null || aVar.lMW == null || !aVar.lMW.equals(this.lIF)) {
                        j2 = j;
                    } else {
                        j2 = (long) aVar.lMU;
                    }
                    i4++;
                    j = j2;
                }
                String valueOf = String.valueOf((j << 48) | longValue);
                if (valueOf.length() == 15) {
                    valueOf = "0" + valueOf;
                } else if (valueOf.length() == 14) {
                    valueOf = "00" + valueOf;
                } else if (valueOf.length() == 13) {
                    valueOf = "000" + valueOf;
                } else if (valueOf.length() == 12) {
                    valueOf = "0000" + valueOf;
                }
                if (TextUtils.isEmpty(com.tencent.mm.plugin.offline.c.a.blQ())) {
                    return "12" + valueOf;
                }
                return com.tencent.mm.plugin.offline.c.a.blQ() + valueOf;
            }
        }
        h hVar = h.mEJ;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(2);
        objArr[1] = Integer.valueOf(com.tencent.mm.plugin.offline.c.a.dE(ad.getContext()) ? 0 : 1);
        if (ao.isNetworkConnected(ad.getContext())) {
            i3 = 1;
        }
        objArr[2] = Integer.valueOf(i3);
        hVar.h(14163, objArr);
        h.mEJ.a(135, 29, 1, true);
        if (ao.isNetworkConnected(ad.getContext())) {
            h.mEJ.a(135, 31, 1, true);
        } else {
            h.mEJ.a(135, 30, 1, true);
        }
        bkG();
        x.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount is 0");
        return "";
    }

    public static int bkH() {
        k.bkO();
        k.bkR();
        return i.bkN();
    }
}
