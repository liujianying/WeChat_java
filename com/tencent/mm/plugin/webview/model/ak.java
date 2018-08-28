package com.tencent.mm.plugin.webview.model;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.a;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLEncoder;
import java.util.Map.Entry;

public final class ak {
    private static int jIn = 0;
    private static int pSm = 0;
    public m pRZ;
    public k pSa;
    public l pSb;
    public j pSc;
    public f pSd;
    public b pSe;
    public g pSf;
    public d pSg;
    private e pSh;
    private i pSi;
    private h pSj;
    private c pSk;
    public a pSl;

    public static /* synthetic */ void a(d dVar, String str, Object[] objArr) {
        if (dVar != null) {
            com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11215, objArr);
            if (str != null && str.startsWith("official_mall")) {
                com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 14919, objArr);
            }
        }
    }

    public static int bUp() {
        switch (ao.getNetType(ad.getContext())) {
            case -1:
                return 255;
            case 0:
                return 1;
            case 1:
            case 6:
            case 8:
                return 3;
            case 2:
            case 5:
            case 7:
                return 2;
            case 3:
            case 4:
                return 4;
            case 10:
                return 5;
            default:
                return 6;
        }
    }

    public static String bUq() {
        ConnectivityManager connectivityManager = (ConnectivityManager) ad.getContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return "no";
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return "no";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        x.d("MicroMsg.WebviewReporter", "activeNetInfo extra=%s, type=%d, %s", new Object[]{activeNetworkInfo.getExtraInfo(), Integer.valueOf(activeNetworkInfo.getType()), activeNetworkInfo.getExtraInfo()});
        if (activeNetworkInfo.getExtraInfo() != null) {
            return activeNetworkInfo.getExtraInfo().toLowerCase();
        }
        return "no";
    }

    public final m bUr() {
        if (this.pRZ == null) {
            this.pRZ = new m(this);
        }
        return this.pRZ;
    }

    public final k bUs() {
        if (this.pSa == null) {
            this.pSa = new k(this);
        }
        return this.pSa;
    }

    public final l bUt() {
        if (this.pSb == null) {
            this.pSb = new l(this);
        }
        return this.pSb;
    }

    public final e bUu() {
        if (this.pSh == null) {
            this.pSh = new e(this);
        }
        return this.pSh;
    }

    public final j bUv() {
        if (this.pSc == null) {
            this.pSc = new j();
        }
        return this.pSc;
    }

    public final f bUw() {
        if (this.pSd == null) {
            this.pSd = new f(this);
        }
        return this.pSd;
    }

    public final b bUx() {
        if (this.pSe == null) {
            this.pSe = new b();
        }
        return this.pSe;
    }

    public final g bUy() {
        if (this.pSf == null) {
            this.pSf = new g();
        }
        return this.pSf;
    }

    public final d bUz() {
        if (this.pSg == null) {
            this.pSg = new d();
        }
        return this.pSg;
    }

    public final i bUA() {
        if (this.pSi == null) {
            this.pSi = new i();
        }
        return this.pSi;
    }

    public final h bUB() {
        if (this.pSj == null) {
            this.pSj = new h();
        }
        return this.pSj;
    }

    public final c bUC() {
        if (this.pSk == null) {
            this.pSk = new c();
        }
        return this.pSk;
    }

    public final void u(String str, Object obj) {
        if (this.pSl != null) {
            try {
                this.pSl.putValue(str, obj);
            } catch (Exception e) {
            }
        }
    }

    public final void Qy(String str) {
        if (this.pSl != null) {
            try {
                a aVar = this.pSl;
                if (aVar.jfZ.containsKey(str)) {
                    try {
                        aVar.putValue(str, Integer.valueOf(aVar.jfZ.getInt(str) + 1));
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                aVar.putValue(str, Integer.valueOf(1));
            } catch (Exception e2) {
            }
        }
    }

    public static void K(boolean z, boolean z2) {
        if (z) {
            jIn = 1;
        } else {
            jIn = 0;
        }
        if (z2) {
            pSm = 1;
        } else {
            pSm = 0;
        }
    }

    public final void c(d dVar) {
        String str;
        l bUt = bUt();
        if (dVar != null) {
            int bUp = bUp();
            for (Entry entry : bUt.pSI.entrySet()) {
                String str2 = (String) entry.getKey();
                long longValue = ((Long) entry.getValue()).longValue();
                h.mEJ.a(32, 0, 1, true);
                if (longValue >= 0 && longValue <= 180000) {
                    str = bUt.pSv;
                    Object[] objArr = new Object[11];
                    objArr[0] = Integer.valueOf(3);
                    objArr[1] = Long.valueOf(longValue);
                    objArr[2] = Integer.valueOf(bUp);
                    objArr[3] = str2 == null ? str2 : str2.replace(",", "!");
                    objArr[4] = Integer.valueOf(0);
                    objArr[5] = Integer.valueOf(0);
                    objArr[6] = Integer.valueOf(0);
                    objArr[7] = Integer.valueOf(jIn);
                    objArr[8] = Integer.valueOf(pSm);
                    objArr[9] = Integer.valueOf(bUt.cfR);
                    objArr[10] = bUt.pSv;
                    a(dVar, str, objArr);
                    h.mEJ.a(160, 0, 1, false);
                    if (-1 != a.fD(longValue)) {
                        h.mEJ.a(160, (long) a.fD(longValue), 1, false);
                    }
                    h.mEJ.a(32, 3, 1, true);
                    h.mEJ.a(32, 7, longValue, true);
                    if (pSm == 1) {
                        h.mEJ.a(32, 16, 1, true);
                        h.mEJ.a(32, 17, longValue, true);
                    }
                    x.i("MicroMsg.WebviewReporter", "WebviewOpenUrlReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", new Object[]{str2, Long.valueOf(longValue), Integer.valueOf(bUp), Integer.valueOf(jIn), Integer.valueOf(pSm), Integer.valueOf(bUt.cfR), bUt.pSv});
                }
            }
        }
        j bUv = bUv();
        if (!bi.oW(bUv.pSy)) {
            x.d("MicroMsg.WebviewReporter", "WebViewVisitReporter report viewID = %s", new Object[]{bUv.pSy});
        }
        if (dVar != null) {
            Object obj;
            String str3 = "";
            try {
                Bundle g = dVar.g(23, new Bundle(0));
                if (g != null) {
                    str3 = g.getString("config_info_username");
                }
                obj = str3;
            } catch (RemoteException e) {
                x.w("MicroMsg.WebviewReporter", "invokeAsResult error, %s", new Object[]{e});
                str = str3;
            }
            PString pString = new PString();
            x.d("MicroMsg.WebviewReporter", "report 10643(%s), username : %s, msgId : %s, msgIndex : %s, scene : %s, enterTime : %s, stayTime : %s, rawUrl : %s, publisher : %s, viewId : %s, publishId : %s,appId : %s, newMsgId : %s, preUsername : %s, curUsername : %s, referUrl : %s, statExtStr:%s(%s), chatType:%d, title:%s, expidstr[chatting_exp]:%s, sourceAppId:%s, allStayTime %d", new Object[]{Integer.valueOf(10643), bUv.username, Long.valueOf(bUv.pSz), Integer.valueOf(bUv.pSA), Integer.valueOf(bUv.scene), Long.valueOf(bUv.cYb), Long.valueOf(bUv.grJ), bUv.cbP, bUv.pSx, bUv.pSy, bUv.jHv, bUv.appId, bUv.pSB, bUv.pSC, obj, bUv.pSD, bUv.nNV, ((i) g.l(i.class)).a(bUv.nNV, pString), Integer.valueOf(bUv.pSE), bUv.title, bUv.cGK, pString.value, Long.valueOf(System.currentTimeMillis() - bUv.cYb)});
            str3 = bUv.title;
            try {
                str3 = URLEncoder.encode(bUv.title, "UTF-8");
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.WebviewReporter", e2, "", new Object[0]);
            }
            Object[] objArr2 = new Object[26];
            objArr2[0] = bUv.username;
            objArr2[1] = Long.valueOf(bUv.pSz);
            objArr2[2] = Integer.valueOf(bUv.pSA);
            objArr2[3] = Integer.valueOf(bUv.scene);
            objArr2[4] = Long.valueOf(bUv.cYb);
            objArr2[5] = Long.valueOf(bUv.grJ);
            objArr2[6] = bUv.cbP == null ? bUv.cbP : bUv.cbP.replace(",", "!");
            objArr2[7] = bUv.pSx;
            objArr2[8] = bUv.pSy;
            objArr2[9] = bUv.jHv;
            objArr2[10] = bUv.appId;
            objArr2[11] = bUv.pSB;
            objArr2[12] = bUv.pSC;
            objArr2[13] = obj;
            objArr2[14] = bUv.pSD == null ? bUv.pSD : bUv.pSD.replace(",", "!");
            objArr2[15] = r7;
            objArr2[16] = Integer.valueOf(bUv.pSE);
            objArr2[17] = str3;
            objArr2[18] = bUv.cGK;
            objArr2[19] = pString.value;
            objArr2[20] = "";
            objArr2[21] = "";
            objArr2[22] = "";
            objArr2[23] = Long.valueOf(System.currentTimeMillis() - bUv.cYb);
            objArr2[24] = Long.valueOf(System.currentTimeMillis());
            objArr2[25] = Integer.valueOf(bUv.pSF);
            com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 10643, objArr2);
        }
        bUs().c(dVar);
        bUu().c(dVar);
        b bUx = bUx();
        if (dVar != null) {
            int bUp2 = bUp();
            if (!bUx.pSp) {
                com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11575, new Object[]{bUx.cbP, Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(bUp2)});
            } else if (bUx.pSo) {
                com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11575, new Object[]{bUx.cbP, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(bUp2)});
            } else {
                com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11575, new Object[]{bUx.cbP, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(bUp2)});
            }
        }
    }
}
