package com.tencent.mm.plugin.appbrand.appcache;

import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.appbrand.appcache.base.a;
import com.tencent.mm.plugin.appbrand.appcache.l.1;
import com.tencent.mm.plugin.appbrand.launching.e;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.report.a.n;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.util.ArrayList;
import java.util.regex.Pattern;

final class l$a implements s$a {
    private final a ffN;
    private final int ffO;
    private final boolean ffP;
    private a ffQ;
    private ArrayList<IDKey> ffR;
    private long ffS;
    private long ffT;
    private long ffU;
    private n ffV;

    /* synthetic */ l$a(a aVar, byte b) {
        this(aVar);
    }

    private l$a(a aVar) {
        this.ffS = 0;
        this.ffT = 0;
        this.ffU = 0;
        this.ffN = aVar;
        this.ffO = l.qF(aVar.appId) ? 776 : 368;
        String[] split = aVar.appId.split(Pattern.quote("$"));
        this.ffP = (split == null ? -1 : split.length) == 2;
    }

    private void jE(int i) {
        bA(this.ffO, i);
    }

    private void bA(int i, int i2) {
        if (this.ffR == null) {
            this.ffR = new ArrayList();
        }
        this.ffR.add(new IDKey(i, i2, 1));
    }

    private void abI() {
        try {
            f.mDy.b(this.ffR, false);
            this.ffR.clear();
        } catch (Exception e) {
        }
    }

    public final void abs() {
        int i = 0;
        if (this.ffN instanceof ae) {
            this.ffQ = "@LibraryAppId".equals(this.ffN.appId) ? a.fga : a.ffZ;
            this.ffV = new n(this.ffN.appId, ((ae) this.ffN).fgJ, ((ae) this.ffN).fgK);
            this.ffV.gsv = bi.VF();
        } else if ("@LibraryAppId".equals(this.ffN.appId)) {
            this.ffQ = a.ffY;
        } else if (d.a.jC(this.ffN.bPh)) {
            WxaPkgWrappingInfo aG = e.aG(this.ffN.appId, 1);
            this.ffQ = aG != null ? a.ffX : a.ffW;
            this.ffV = new n(this.ffN.appId, aG == null ? 0 : aG.fii, this.ffN.version);
            this.ffV.gsv = bi.VF();
        } else {
            this.ffQ = a.ffW;
        }
        switch (1.ffM[this.ffQ.ordinal()]) {
            case 1:
                i = 1;
                break;
            case 2:
                i = 10;
                break;
            case 3:
                i = 20;
                break;
            case 4:
                i = 35;
                break;
            case 5:
                i = 46;
                break;
        }
        jE(i);
        this.ffS = SystemClock.elapsedRealtime();
    }

    public final void abt() {
        jE(32);
    }

    public final void abu() {
        int i;
        switch (1.ffM[this.ffQ.ordinal()]) {
            case 3:
            case 5:
                i = 30;
                break;
            default:
                i = 31;
                break;
        }
        jE(i);
    }

    public final void a(m mVar) {
        int i;
        String str;
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.ffS;
        int i2 = (mVar == null || mVar.status != 2) ? 0 : 1;
        switch (1.ffM[this.ffQ.ordinal()]) {
            case 1:
                jE(i2 != 0 ? 2 : 3);
                break;
            case 2:
                jE(i2 != 0 ? 11 : 12);
                break;
            case 3:
                jE(i2 != 0 ? 21 : 22);
                break;
            case 4:
                jE(i2 != 0 ? 36 : 37);
                break;
            case 5:
                jE(i2 != 0 ? 47 : 48);
                break;
        }
        if (!(i2 != 0 || "@LibraryAppId".equals(this.ffN.appId) || 999 == this.ffN.bPh)) {
            int i3;
            if (mVar == null || !(mVar.httpStatusCode == TbsListener$ErrorCode.INFO_DISABLE_X5 || mVar.httpStatusCode == TbsListener$ErrorCode.INFO_MISS_SDKEXTENSION_JAR)) {
                i3 = 19;
            } else {
                i3 = 23;
            }
            com.tencent.mm.plugin.appbrand.report.a.G(this.ffN.appId, i3, this.ffN.bPh + 1);
        }
        if (mVar != null) {
            try {
                if (mVar.status == 2) {
                    i = 1;
                    str = (a.ffY != this.ffQ || a.fga == this.ffQ) ? "" : this.ffN.appId;
                    com.tencent.mm.plugin.appbrand.report.a.a(str, this.ffQ.value, i, elapsedRealtime, this.ffP);
                    AppBrandPerformanceManager.v(this.ffN.appId, elapsedRealtime);
                    abI();
                    if (this.ffV == null) {
                        return;
                    }
                    if (i2 == 0) {
                        this.ffV.amR();
                        if (!(this.ffN instanceof ae)) {
                            this.ffV.lD(0);
                        } else if (mVar == null) {
                            this.ffV.lD(3);
                        } else if (mVar.httpStatusCode == TbsListener$ErrorCode.INFO_CAN_NOT_USE_X5_TBS_NOTAVAILABLE) {
                            this.ffV.lD(1);
                        } else if (mVar.httpStatusCode == TbsListener$ErrorCode.INFO_DISABLE_X5) {
                            this.ffV.lD(2);
                        } else {
                            this.ffV.lD(3);
                        }
                        this.ffV.xP();
                    } else if (this.ffN instanceof ae) {
                        this.ffV.gsu = com.tencent.mm.a.e.cm(this.ffN.getFilePath());
                    } else {
                        this.ffV.gst = com.tencent.mm.a.e.cm(this.ffN.getFilePath());
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrand.PkgDownloadReporterImpl", e, "report onEnd, appId %s", new Object[]{this.ffN.appId});
            }
        }
        if (mVar != null) {
            if (mVar.status == 4) {
                i = 3;
                if (a.ffY != this.ffQ) {
                }
                com.tencent.mm.plugin.appbrand.report.a.a(str, this.ffQ.value, i, elapsedRealtime, this.ffP);
                AppBrandPerformanceManager.v(this.ffN.appId, elapsedRealtime);
                abI();
                if (this.ffV == null) {
                    if (i2 == 0) {
                        this.ffV.amR();
                        if (!(this.ffN instanceof ae)) {
                            this.ffV.lD(0);
                        } else if (mVar == null) {
                            this.ffV.lD(3);
                        } else if (mVar.httpStatusCode == TbsListener$ErrorCode.INFO_CAN_NOT_USE_X5_TBS_NOTAVAILABLE) {
                            this.ffV.lD(1);
                        } else if (mVar.httpStatusCode == TbsListener$ErrorCode.INFO_DISABLE_X5) {
                            this.ffV.lD(2);
                        } else {
                            this.ffV.lD(3);
                        }
                        this.ffV.xP();
                    } else if (this.ffN instanceof ae) {
                        this.ffV.gsu = com.tencent.mm.a.e.cm(this.ffN.getFilePath());
                    } else {
                        this.ffV.gst = com.tencent.mm.a.e.cm(this.ffN.getFilePath());
                    }
                }
                return;
            }
        }
        i = 2;
        if (a.ffY != this.ffQ) {
        }
        com.tencent.mm.plugin.appbrand.report.a.a(str, this.ffQ.value, i, elapsedRealtime, this.ffP);
        AppBrandPerformanceManager.v(this.ffN.appId, elapsedRealtime);
        abI();
        if (this.ffV == null) {
            return;
        }
        if (i2 == 0) {
            this.ffV.amR();
            if (!(this.ffN instanceof ae)) {
                this.ffV.lD(0);
            } else if (mVar == null) {
                this.ffV.lD(3);
            } else if (mVar.httpStatusCode == TbsListener$ErrorCode.INFO_CAN_NOT_USE_X5_TBS_NOTAVAILABLE) {
                this.ffV.lD(1);
            } else if (mVar.httpStatusCode == TbsListener$ErrorCode.INFO_DISABLE_X5) {
                this.ffV.lD(2);
            } else {
                this.ffV.lD(3);
            }
            this.ffV.xP();
        } else if (this.ffN instanceof ae) {
            this.ffV.gsu = com.tencent.mm.a.e.cm(this.ffN.getFilePath());
        } else {
            this.ffV.gst = com.tencent.mm.a.e.cm(this.ffN.getFilePath());
        }
    }

    public final void abv() {
        this.ffU = SystemClock.elapsedRealtime();
        bA(697, 1);
    }

    public final void jD(int i) {
        SystemClock.elapsedRealtime();
        if (i == 0) {
            bA(697, 2);
        } else if (i < 0) {
            bA(697, -i);
        } else if (i == 1) {
            bA(697, 10);
        }
        abI();
        if (this.ffV == null) {
            return;
        }
        if (i != 0) {
            if (i == -4) {
                this.ffV.lD(4);
            } else {
                this.ffV.lD(5);
            }
            this.ffV.amR();
            this.ffV.xP();
            return;
        }
        this.ffV.gst = com.tencent.mm.a.e.cm(((ae) this.ffN).abR());
    }

    public final void abw() {
        if (a.ffY != this.ffQ && a.fga != this.ffQ) {
            com.tencent.mm.plugin.appbrand.report.a.G(this.ffN.appId, 20, this.ffN.bPh + 1);
        }
    }

    public final void abx() {
        this.ffT = SystemClock.elapsedRealtime();
        switch (1.ffM[this.ffQ.ordinal()]) {
            case 1:
                jE(5);
                return;
            case 2:
                jE(14);
                return;
            case 3:
                jE(24);
                return;
            case 4:
                jE(41);
                return;
            case 5:
                jE(49);
                return;
            default:
                return;
        }
    }

    public final void ct(boolean z) {
        int i;
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.ffT;
        switch (1.ffM[this.ffQ.ordinal()]) {
            case 1:
                if (!z) {
                    i = 7;
                    break;
                } else {
                    i = 6;
                    break;
                }
            case 2:
                if (!z) {
                    i = 16;
                    break;
                } else {
                    i = 15;
                    break;
                }
            case 3:
                if (!z) {
                    i = 26;
                    break;
                } else {
                    i = 25;
                    break;
                }
            case 4:
                if (!z) {
                    i = 43;
                    break;
                } else {
                    i = 42;
                    break;
                }
            case 5:
                if (!z) {
                    i = 51;
                    break;
                } else {
                    i = 50;
                    break;
                }
            default:
                i = 0;
                break;
        }
        jE(i);
        abI();
        String str = (a.ffY == this.ffQ || a.fga == this.ffQ) ? "" : this.ffN.appId;
        com.tencent.mm.plugin.appbrand.report.a.a(str, this.ffQ.value + 1, z ? 1 : 2, elapsedRealtime, this.ffP);
        if (!z) {
            com.tencent.mm.plugin.appbrand.report.a.G(this.ffN.appId, 22, this.ffN.bPh + 1);
        }
        if (this.ffV != null) {
            this.ffV.amR();
            if (this.ffQ != a.ffZ && this.ffQ != a.fga) {
                this.ffV.gsr = z;
            } else if (z) {
                this.ffV.gsr = true;
                this.ffV.gss = true;
            } else {
                this.ffV.lD(6);
            }
            this.ffV.xP();
        }
    }
}
