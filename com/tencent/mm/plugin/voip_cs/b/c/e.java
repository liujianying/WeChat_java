package com.tencent.mm.plugin.voip_cs.b.c;

import android.telephony.TelephonyManager;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.voip.model.p;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.protocal.c.bzm;
import com.tencent.mm.protocal.c.bzn;
import com.tencent.mm.protocal.c.bzo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;
import java.util.LinkedList;

public final class e extends l implements k {
    public b diG;
    private com.tencent.mm.ab.e diJ;

    public e(long j, long j2) {
        int i;
        p bKK;
        a aVar = new a();
        aVar.dIG = new bzn();
        aVar.dIH = new bzo();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipreport";
        aVar.dIF = 312;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bzn bzn = (bzn) this.diG.dID.dIL;
        bzn.svs = j;
        bzn.rxH = j2;
        LinkedList linkedList = bzn.svI;
        c bMx = com.tencent.mm.plugin.voip_cs.b.b.bMx();
        bzm bzm = new bzm();
        bzm.hcE = 1;
        bzm.svH = bMx.kqW;
        x.i("MicroMsg.VoipCSReportHelper", "getVoipCSChannelReportData, result: %s", new Object[]{bzm.svH});
        linkedList.add(bzm);
        bzn.svI.add(com.tencent.mm.plugin.voip_cs.b.b.bMx().bMz());
        LinkedList linkedList2 = bzn.svI;
        c bMx2 = com.tencent.mm.plugin.voip_cs.b.b.bMx();
        bzm bzm2 = new bzm();
        bzm2.hcE = 3;
        bMx2.oOC = au.HV().yP();
        bMx2.za(com.tencent.mm.plugin.voip_cs.b.a.a.bMD().oNt.bMk());
        int i2 = bMx2.ovW & WebView.NORMAL_MODE_ALPHA;
        bMx2.oPR = i2;
        bMx2.oPR = i2;
        bMx2.oWY = com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx.field_audioDuration;
        bMx2.oWZ = com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx.field_videoDuration;
        if (bMx2.oWC != 1 && bMx2.oXk != 1) {
            bMx2.oWQ = 1;
        } else if (bMx2.oWC != 1) {
            bMx2.oWQ = 2;
        } else if (bMx2.oXk != 1) {
            bMx2.oWQ = 3;
        } else {
            bMx2.oWQ = 0;
        }
        bMx2.oWJ = com.tencent.mm.plugin.voip.b.a.getNetType(ad.getContext());
        v2protocal v2protocal = com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx;
        v2protocal.setJNIAppCmd(1, v2protocal.oPz, v2protocal.oPz.length);
        i2 = (int) (v2protocal.aU(v2protocal.oPz) / 1000);
        i2 = (bMx2.oXf == 0 || i2 <= bMx2.oXf) ? 0 : i2 - bMx2.oXf;
        bMx2.oWX = (long) i2;
        bzm2.svH = bMx2.oOw + "," + bMx2.oWG + "," + bMx2.kpp + "," + bMx2.oWH + "," + bMx2.oWI + "," + bMx2.oOj + "," + bMx2.oWJ + "," + bMx2.oWK + "," + bMx2.oWL + "," + bMx2.oWM + "," + bMx2.oOC + "," + bMx2.oOB + "," + bMx2.oWN + "," + bMx2.oWO + "," + bMx2.oWP + "," + bMx2.oWQ + "," + bMx2.oWR + "," + bMx2.oWS + "," + bMx2.oWT + "," + bMx2.oWU + "," + bMx2.oWV + "," + bMx2.oWW + "," + bMx2.oWX + "," + bMx2.kqM + "," + bMx2.oWY + "," + bMx2.oWZ + "," + bMx2.channelStrategy + "," + bMx2.oPR + "," + bMx2.oOD + "," + bMx2.oXa + "," + bMx2.oXb + "," + bMx2.oXc + "," + bMx2.deviceModel + "," + bMx2.oXd + "," + bMx2.oXe;
        x.i("MicroMsg.VoipCSReportHelper", "getVoipCSClientReportData, result: %s", new Object[]{bzm2.svH});
        linkedList2.add(bzm2);
        linkedList = bzn.svI;
        bMx = com.tencent.mm.plugin.voip_cs.b.b.bMx();
        bzm = new bzm();
        bzm.hcE = 4;
        bMx.networkType = c.getNetType(ad.getContext());
        String simOperator = ((TelephonyManager) ad.getContext().getSystemService("phone")).getSimOperator();
        if (simOperator != null) {
            if (simOperator.equals("46000") || simOperator.equals("46002") || simOperator.equals("46007")) {
                i = 1;
                bMx.oWD = i;
                bMx.oWu = (int) (System.currentTimeMillis() / 1000);
                bMx.oWE = c.bMA();
                bMx.oOC = au.HV().yP();
                bKK = p.bKK();
                bMx.oWF = bKK.oMU != 0 ? bKK.oMT / bKK.oMU : -1;
                if (bMx.oWF == -1) {
                    byte[] bArr = new byte[4];
                    if (com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx.setAppCmd(10, bArr, 4) < 0) {
                        bMx.oWF = 0;
                        x.d("MicroMsg.VoipCSReportHelper", "get netStatus failed");
                    } else {
                        bMx.oWF = bi.aH(bArr);
                    }
                }
                x.i("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData Report dataType=%d, dataTime=%s, isClickClose=%d, clickCloseTime=%s, videoFps=%d, videoRate=%d, cameraPixelWidth=%d, cameraPixelHeight=%d, recordPixelWidth=%d, recordPixelHeight=%d, cameraState=%d, networkType=%s, mobileType=%s, mobileNetworkType=%s, networkQuality=%d", new Object[]{Integer.valueOf(bMx.bjS), Integer.valueOf(bMx.oWu), Integer.valueOf(bMx.oWv), Integer.valueOf(bMx.oWw), Integer.valueOf(bMx.videoFps), Integer.valueOf(bMx.oWx), Integer.valueOf(bMx.oWy), Integer.valueOf(bMx.oWz), Integer.valueOf(bMx.oWA), Integer.valueOf(bMx.oWB), Integer.valueOf(bMx.oWC), Integer.valueOf(bMx.networkType), Integer.valueOf(bMx.oWD), Integer.valueOf(bMx.oWE), Integer.valueOf(bMx.oWF)});
                bzm.svH = bMx.bjS + "," + bMx.oWu + "," + bMx.oWv + "," + bMx.oWw + "," + bMx.videoFps + "," + bMx.oWx + "," + bMx.oWy + "," + bMx.oWz + "," + bMx.oWA + "," + bMx.oWB + "," + bMx.oWC + "," + bMx.networkType + "," + bMx.oWD + "," + bMx.oWE + "," + bMx.oWF + "," + bMx.oWG + "," + bMx.kpp;
                x.d("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData, result: " + bzm.svH);
                linkedList.add(bzm);
            }
            if (simOperator.equals("46001")) {
                i = 3;
            } else if (simOperator.equals("46003")) {
                i = 2;
            }
            bMx.oWD = i;
            bMx.oWu = (int) (System.currentTimeMillis() / 1000);
            bMx.oWE = c.bMA();
            bMx.oOC = au.HV().yP();
            bKK = p.bKK();
            if (bKK.oMU != 0) {
            }
            bMx.oWF = bKK.oMU != 0 ? bKK.oMT / bKK.oMU : -1;
            if (bMx.oWF == -1) {
                byte[] bArr2 = new byte[4];
                if (com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx.setAppCmd(10, bArr2, 4) < 0) {
                    bMx.oWF = 0;
                    x.d("MicroMsg.VoipCSReportHelper", "get netStatus failed");
                } else {
                    bMx.oWF = bi.aH(bArr2);
                }
            }
            x.i("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData Report dataType=%d, dataTime=%s, isClickClose=%d, clickCloseTime=%s, videoFps=%d, videoRate=%d, cameraPixelWidth=%d, cameraPixelHeight=%d, recordPixelWidth=%d, recordPixelHeight=%d, cameraState=%d, networkType=%s, mobileType=%s, mobileNetworkType=%s, networkQuality=%d", new Object[]{Integer.valueOf(bMx.bjS), Integer.valueOf(bMx.oWu), Integer.valueOf(bMx.oWv), Integer.valueOf(bMx.oWw), Integer.valueOf(bMx.videoFps), Integer.valueOf(bMx.oWx), Integer.valueOf(bMx.oWy), Integer.valueOf(bMx.oWz), Integer.valueOf(bMx.oWA), Integer.valueOf(bMx.oWB), Integer.valueOf(bMx.oWC), Integer.valueOf(bMx.networkType), Integer.valueOf(bMx.oWD), Integer.valueOf(bMx.oWE), Integer.valueOf(bMx.oWF)});
            bzm.svH = bMx.bjS + "," + bMx.oWu + "," + bMx.oWv + "," + bMx.oWw + "," + bMx.videoFps + "," + bMx.oWx + "," + bMx.oWy + "," + bMx.oWz + "," + bMx.oWA + "," + bMx.oWB + "," + bMx.oWC + "," + bMx.networkType + "," + bMx.oWD + "," + bMx.oWE + "," + bMx.oWF + "," + bMx.oWG + "," + bMx.kpp;
            x.d("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData, result: " + bzm.svH);
            linkedList.add(bzm);
        }
        i = 0;
        bMx.oWD = i;
        bMx.oWu = (int) (System.currentTimeMillis() / 1000);
        bMx.oWE = c.bMA();
        bMx.oOC = au.HV().yP();
        bKK = p.bKK();
        if (bKK.oMU != 0) {
        }
        bMx.oWF = bKK.oMU != 0 ? bKK.oMT / bKK.oMU : -1;
        if (bMx.oWF == -1) {
            byte[] bArr22 = new byte[4];
            if (com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx.setAppCmd(10, bArr22, 4) < 0) {
                bMx.oWF = 0;
                x.d("MicroMsg.VoipCSReportHelper", "get netStatus failed");
            } else {
                bMx.oWF = bi.aH(bArr22);
            }
        }
        x.i("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData Report dataType=%d, dataTime=%s, isClickClose=%d, clickCloseTime=%s, videoFps=%d, videoRate=%d, cameraPixelWidth=%d, cameraPixelHeight=%d, recordPixelWidth=%d, recordPixelHeight=%d, cameraState=%d, networkType=%s, mobileType=%s, mobileNetworkType=%s, networkQuality=%d", new Object[]{Integer.valueOf(bMx.bjS), Integer.valueOf(bMx.oWu), Integer.valueOf(bMx.oWv), Integer.valueOf(bMx.oWw), Integer.valueOf(bMx.videoFps), Integer.valueOf(bMx.oWx), Integer.valueOf(bMx.oWy), Integer.valueOf(bMx.oWz), Integer.valueOf(bMx.oWA), Integer.valueOf(bMx.oWB), Integer.valueOf(bMx.oWC), Integer.valueOf(bMx.networkType), Integer.valueOf(bMx.oWD), Integer.valueOf(bMx.oWE), Integer.valueOf(bMx.oWF)});
        bzm.svH = bMx.bjS + "," + bMx.oWu + "," + bMx.oWv + "," + bMx.oWw + "," + bMx.videoFps + "," + bMx.oWx + "," + bMx.oWy + "," + bMx.oWz + "," + bMx.oWA + "," + bMx.oWB + "," + bMx.oWC + "," + bMx.networkType + "," + bMx.oWD + "," + bMx.oWE + "," + bMx.oWF + "," + bMx.oWG + "," + bMx.kpp;
        x.d("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData, result: " + bzm.svH);
        linkedList.add(bzm);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneVoipCSReport", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 312;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
