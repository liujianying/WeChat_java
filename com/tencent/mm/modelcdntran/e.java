package com.tencent.mm.modelcdntran;

import android.net.wifi.WifiInfo;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnInfoParams;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.abb;
import com.tencent.mm.protocal.c.abc;
import com.tencent.mm.protocal.c.kf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class e extends l implements k {
    public static long dPt = 0;
    private static Map<String, a> dPu = new HashMap();
    private String dPv = "";
    private final b diG;
    private com.tencent.mm.ab.e diJ;
    int scene = 0;
    public long startTime = 0;

    static class a {
        boolean dPw = false;
        long dPx = 0;
        long dPy = 0;
        long dPz = 0;

        a() {
        }

        public final String toString() {
            return String.format("LastGetResult(%x){isTimeOut=%b, lastGetCDNDns_TenSecond=%d, lastTime_Hour=%d, lastCount_Hour=%d}", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(this.dPw), Long.valueOf(this.dPx), Long.valueOf(this.dPy), Long.valueOf(this.dPz)});
        }
    }

    protected e(int i) {
        x.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn init Scene:%d  [%s]", new Object[]{Integer.valueOf(i), bi.cjd()});
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new abb();
        aVar.dIH = new abc();
        aVar.uri = "/cgi-bin/micromsg-bin/getcdndns";
        aVar.dIF = 379;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.scene = i;
        ((abb) this.diG.dID.dIL).rGh = "";
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        g.Eg();
        int Df = com.tencent.mm.kernel.a.Df();
        if (Df == 0) {
            x.e("MicroMsg.NetSceneGetCDNDns", "has not set uin.");
            return -1;
        }
        if (dPt != ((long) Df)) {
            dPt = (long) Df;
            dPu.clear();
        }
        long VE = bi.VE();
        a aVar;
        if (this.scene == 0) {
            this.dPv = bi.aG(Nz(), "");
            aVar = (a) dPu.get(this.dPv);
            if (aVar == null) {
                aVar = new a();
                dPu.put(this.dPv, aVar);
                x.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn doScene NEW lastGetResult[%s] path[%s]", new Object[]{aVar, this.dPv});
            }
            if (aVar.dPw) {
                aVar.dPx = VE;
                aVar.dPy = VE;
                aVar.dPz = 0;
            }
            x.d("MicroMsg.NetSceneGetCDNDns", "cdntra doscene Sec:%d Hour[%d,%d]", new Object[]{Long.valueOf(VE - aVar.dPx), Long.valueOf(VE - aVar.dPy), Long.valueOf(aVar.dPz)});
            if (VE > aVar.dPx && VE - aVar.dPx < 10) {
                x.w("MicroMsg.NetSceneGetCDNDns", "Last get dns at %d ago . ignore!, lastGetResult[%s]", new Object[]{Long.valueOf(VE - aVar.dPx), aVar});
                return -1;
            } else if (VE <= aVar.dPy || VE - aVar.dPy >= 3600 || aVar.dPz < 90) {
                aVar.dPx = VE;
                if (VE < aVar.dPy || VE - aVar.dPz > 3600) {
                    aVar.dPy = VE;
                    aVar.dPz = 0;
                } else {
                    aVar.dPz++;
                }
            } else {
                x.w("MicroMsg.NetSceneGetCDNDns", "in 1 hour , get dns more than 90  (%d). ignore!, lastGetResult[%s]", new Object[]{Long.valueOf(VE - aVar.dPy), aVar});
                return -1;
            }
        }
        this.dPv = "";
        Iterator it = dPu.values().iterator();
        if (it != null) {
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar != null) {
                    aVar.dPx = VE;
                    if (VE < aVar.dPy || VE - aVar.dPz > 3600) {
                        aVar.dPy = VE;
                        aVar.dPz = 0;
                    } else {
                        aVar.dPz++;
                    }
                }
            }
        }
        this.startTime = VE;
        h.mEJ.a(546, this.scene == 0 ? 0 : 1, 1, true);
        return a(eVar, this.diG, this);
    }

    private static String Nz() {
        if (!ao.isConnected(ad.getContext())) {
            return null;
        }
        String str;
        if (ao.isWifi(ad.getContext())) {
            WifiInfo wifiInfo = ao.getWifiInfo(ad.getContext());
            if (wifiInfo == null) {
                return null;
            }
            str = "wifi_" + wifiInfo.getSSID();
        } else {
            str = "mobile_" + ao.getNetTypeString(ad.getContext()) + "_" + ao.getISPCode(ad.getContext());
        }
        x.d("MicroMsg.NetSceneGetCDNDns", "cdntra getCurCacheFullPath file:%s", new Object[]{str});
        if (str == null || str.length() < 2) {
            return null;
        }
        str = String.format("%x", new Object[]{Integer.valueOf(str.hashCode())});
        StringBuilder stringBuilder = new StringBuilder();
        g.NA();
        return stringBuilder.append(g.NB()).append(str).toString();
    }

    private static CdnInfoParams a(kf kfVar) {
        CdnInfoParams cdnInfoParams = new CdnInfoParams();
        cdnInfoParams.c2CretryIntervalMs = kfVar.rlT;
        cdnInfoParams.c2CrwtimeoutMs = kfVar.rlV;
        cdnInfoParams.c2CshowErrorDelayMs = kfVar.rlR;
        cdnInfoParams.snsretryIntervalMs = kfVar.rlU;
        cdnInfoParams.snsrwtimeoutMs = kfVar.rlW;
        cdnInfoParams.snsshowErrorDelayMs = kfVar.rlS;
        return cdnInfoParams;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd errtype:" + i2 + " errcode:" + i3);
        abc abc = (abc) ((b) qVar).dIE.dIL;
        if (i2 == 0 && i3 == 0 && abc.roC != null) {
            String Nz = Nz();
            if (!(bi.oW(Nz) || bi.oW(this.dPv) || Nz.equals(this.dPv))) {
                x.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd revised cacheFullPath[%s] to [%s]", new Object[]{Nz, this.dPv});
                h.mEJ.a(546, 6, 1, true);
            }
            dPu.clear();
            byte[] bArr2 = null;
            if (abc.roF != null && abc.roF.siI > 0) {
                x.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd cdnrule:%d", new Object[]{Integer.valueOf(abc.roF.siI)});
                bArr2 = ab.a(abc.roF);
            }
            byte[] bArr3 = null;
            if (abc.roG != null && abc.roG.siI > 0) {
                x.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd safecdnrule:%d", new Object[]{Integer.valueOf(abc.roG.siI)});
                bArr3 = ab.a(abc.roG);
            }
            x.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo:%s", new Object[]{abc.roH});
            if (abc.roH != null) {
                x.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo FakeUin:%d NewAuthKey:%s", new Object[]{Integer.valueOf(abc.roH.iwE), abc.roH.rmd});
            }
            if (g.NE().a(abc.roC, abc.roD, abc.roE, bArr2, bArr3, abc.roH)) {
                x.i("MicroMsg.NetSceneGetCDNDns", "getcdndns defaultcfg %s, disastercfg %s, getcdninterval %d", new Object[]{abc.roJ, abc.roK, Integer.valueOf(abc.roI)});
                if (!(abc.roJ == null || abc.roK == null)) {
                    CdnLogic.setCdnInfoParams(a(abc.roJ), a(abc.roK), abc.roI);
                }
                this.diJ.a(i2, i3, str, this);
                return;
            }
            x.e("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd setCDNDnsInfo failed ");
            this.diJ.a(i2, i3, str, this);
            return;
        }
        h.mEJ.h(10769, new Object[]{Integer.valueOf(d.dPs), Integer.valueOf(0), Long.valueOf(this.startTime)});
        String str2 = "MicroMsg.NetSceneGetCDNDns";
        String str3 = "onGYNetEnd: [%d ,%d]  info is null :%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Boolean.valueOf(abc.roC == null);
        x.w(str2, str3, objArr);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 379;
    }
}
