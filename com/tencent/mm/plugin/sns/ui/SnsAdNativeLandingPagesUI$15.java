package com.tencent.mm.plugin.sns.ui;

import android.support.v4.content.d;
import android.text.TextUtils;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdlandingRemoteServiceConnectedReceiver;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SnsAdNativeLandingPagesUI$15 implements Runnable {
    final /* synthetic */ SnsAdNativeLandingPagesUI nSR;

    SnsAdNativeLandingPagesUI$15(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        this.nSR = snsAdNativeLandingPagesUI;
    }

    public final void run() {
        AdlandingRemoteServiceConnectedReceiver.b(d.O(this.nSR));
        SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI = this.nSR;
        snsAdNativeLandingPagesUI.nSE = AdLandingPagesProxy.getInstance().getSnsInfo(snsAdNativeLandingPagesUI.bSZ);
        AdLandingPagesProxy.getInstance().asyncCacheXml(snsAdNativeLandingPagesUI.bSZ);
        if (snsAdNativeLandingPagesUI.values == null) {
            x.e("MicroMsg.SnsAdNativeLandingPagesUI", "parse landingpagexml is error,landingpagexml is " + snsAdNativeLandingPagesUI.nSd);
        } else {
            String valueOf;
            if (snsAdNativeLandingPagesUI.source == 1 || snsAdNativeLandingPagesUI.source == 2 || snsAdNativeLandingPagesUI.source == 14 || snsAdNativeLandingPagesUI.source == 9 || snsAdNativeLandingPagesUI.source == 10) {
                long j = 0;
                if (snsAdNativeLandingPagesUI.nSE != null) {
                    j = snsAdNativeLandingPagesUI.nSE.field_snsId;
                    if (TextUtils.isEmpty(snsAdNativeLandingPagesUI.nyk)) {
                        snsAdNativeLandingPagesUI.nyk = AdLandingPagesProxy.getInstance().getSnsAid(snsAdNativeLandingPagesUI.bSZ);
                    }
                    if (TextUtils.isEmpty(snsAdNativeLandingPagesUI.fxE)) {
                        snsAdNativeLandingPagesUI.fxE = AdLandingPagesProxy.getInstance().getSnsTraceid(snsAdNativeLandingPagesUI.bSZ);
                    }
                    snsAdNativeLandingPagesUI.egL = AdLandingPagesProxy.getInstance().getSnsAdType(snsAdNativeLandingPagesUI.bSZ);
                    snsAdNativeLandingPagesUI.nyl = AdLandingPagesProxy.getInstance().getSnsAdCanvasExtXml(snsAdNativeLandingPagesUI.bSZ);
                }
                valueOf = snsAdNativeLandingPagesUI.nSl != null ? snsAdNativeLandingPagesUI.nSl : String.valueOf(j);
                snsAdNativeLandingPagesUI.values.put("." + snsAdNativeLandingPagesUI.nSe + ".originSnsId", valueOf);
                snsAdNativeLandingPagesUI.values.put("." + snsAdNativeLandingPagesUI.nSe + ".originUxInfo", snsAdNativeLandingPagesUI.ntU);
                CharSequence charSequence = ((((("<" + snsAdNativeLandingPagesUI.nSe + ">") + String.format("<originSnsId>%s</originSnsId>", new Object[]{valueOf})) + String.format("<originUxInfo>%s</originUxInfo>", new Object[]{snsAdNativeLandingPagesUI.ntU})) + String.format("<originAdType>%d</originAdType>", new Object[]{Integer.valueOf(snsAdNativeLandingPagesUI.egL)})) + String.format("<originAid>%s</originAid>", new Object[]{snsAdNativeLandingPagesUI.nyk})) + String.format("<originTraceId>%s</originTraceId>", new Object[]{snsAdNativeLandingPagesUI.fxE});
                if (!bi.oW(snsAdNativeLandingPagesUI.nyl)) {
                    charSequence = charSequence + String.format("<originAdCanvasExt>%s</originAdCanvasExt>", new Object[]{snsAdNativeLandingPagesUI.nyl});
                }
                snsAdNativeLandingPagesUI.nSd = snsAdNativeLandingPagesUI.nSd.replace("<" + snsAdNativeLandingPagesUI.nSe + ">", charSequence);
                snsAdNativeLandingPagesUI.nSo.ntU = snsAdNativeLandingPagesUI.ntU;
                snsAdNativeLandingPagesUI.nSo.bSZ = valueOf;
            } else {
                snsAdNativeLandingPagesUI.nSo.bSZ = (String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.nSe + ".originSnsId");
                snsAdNativeLandingPagesUI.nSo.ntU = (String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.nSe + ".originUxInfo");
                snsAdNativeLandingPagesUI.ntU = snsAdNativeLandingPagesUI.nSo.ntU;
                snsAdNativeLandingPagesUI.egL = bi.WU((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.nSe + ".originAdType"));
                Matcher matcher = Pattern.compile("<originAdCanvasExt>[\\s\\S]*</originAdCanvasExt>").matcher(snsAdNativeLandingPagesUI.nSd);
                if (matcher.find()) {
                    valueOf = matcher.group();
                    if (!bi.oW(valueOf)) {
                        snsAdNativeLandingPagesUI.nyl = valueOf.replaceAll("</?originAdCanvasExt>", "");
                    }
                }
            }
            if (bi.oW(snsAdNativeLandingPagesUI.nSo.bSZ)) {
                snsAdNativeLandingPagesUI.nSo.bSZ = snsAdNativeLandingPagesUI.getIntent().getStringExtra("sns_landing_pages_rawSnsId");
            }
            snsAdNativeLandingPagesUI.nSo.nIO = AdLandingPagesProxy.getInstance().getSnsStatExtBySnsId(bi.WV(snsAdNativeLandingPagesUI.nSo.bSZ));
            snsAdNativeLandingPagesUI.ixz = bi.aG((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.nSe + ".adCanvasInfo.shareTitle"), "");
            snsAdNativeLandingPagesUI.ixy = bi.aG((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.nSe + ".adCanvasInfo.shareWebUrl"), "");
            snsAdNativeLandingPagesUI.nzH = bi.aG((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.nSe + ".adCanvasInfo.shareDesc"), "");
            snsAdNativeLandingPagesUI.nBm = bi.WU(bi.aG((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.nSe + ".adCanvasInfo.bizId"), ""));
            snsAdNativeLandingPagesUI.nSs = bi.aG((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.nSe + ".adCanvasInfo.shareAppId"), "");
            snsAdNativeLandingPagesUI.nSt = bi.aG((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.nSe + ".adCanvasInfo.shareType"), "");
            snsAdNativeLandingPagesUI.nSu = bi.aG((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.nSe + ".adCanvasInfo.userInfo"), "");
            snsAdNativeLandingPagesUI.nSx = bi.WU(bi.aG((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.nSe + ".adCanvasInfo.disableShareBitSet"), ""));
            snsAdNativeLandingPagesUI.nSy = bi.WU(bi.aG((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.nSe + ".adCanvasInfo.statusBarStyle"), ""));
            Map map = snsAdNativeLandingPagesUI.values;
            String str = "." + snsAdNativeLandingPagesUI.nSe;
            valueOf = (String) map.get(str + ".adCanvasInfo.arrowDownIconStyle.iconUrl");
            if (TextUtils.isEmpty(valueOf)) {
                snsAdNativeLandingPagesUI.nHm = null;
            } else {
                if (snsAdNativeLandingPagesUI.nHm == null) {
                    snsAdNativeLandingPagesUI.nHm = new z();
                }
                snsAdNativeLandingPagesUI.nHm.iconUrl = valueOf;
                int WU = bi.WU((String) map.get(str + ".adCanvasInfo.sizeType"));
                int WU2 = bi.WU((String) map.get(str + ".adCanvasInfo.basicRootFontSize"));
                int WU3 = bi.WU((String) map.get(str + ".adCanvasInfo.basicWidth"));
                int i = (WU2 == 0 && WU == 1) ? e.nIs : WU2;
                WU2 = (WU3 == 0 && WU == 1) ? e.nIr : WU3;
                snsAdNativeLandingPagesUI.nHm.nAZ = e.a(bi.WW((String) map.get(str + ".adCanvasInfo.arrowDownIconStyle.paddingBottom")), WU, WU2, i);
                snsAdNativeLandingPagesUI.nHm.width = e.a(bi.WW((String) map.get(str + ".adCanvasInfo.arrowDownIconStyle.layoutWidth")), WU, WU2, i);
                snsAdNativeLandingPagesUI.nHm.height = e.a(bi.WW((String) map.get(str + ".adCanvasInfo.arrowDownIconStyle.layoutHeight")), WU, WU2, i);
            }
            snsAdNativeLandingPagesUI.uin = AdLandingPagesProxy.getInstance().getUin();
            snsAdNativeLandingPagesUI.nSv = bi.aG((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.nSe + ".adCanvasInfo.officialSyncBuffer"), "");
            snsAdNativeLandingPagesUI.bCE();
            snsAdNativeLandingPagesUI.getIntent().putExtra("sns_landing_pages_adType", snsAdNativeLandingPagesUI.egL);
            snsAdNativeLandingPagesUI.getIntent().putExtra("sns_landing_pages_rawSnsId", snsAdNativeLandingPagesUI.nSo.bSZ);
            if (bi.oW(snsAdNativeLandingPagesUI.nyk)) {
                snsAdNativeLandingPagesUI.nyk = bi.aG((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.nSe + ".originAid"), "");
            }
            if (bi.oW(snsAdNativeLandingPagesUI.fxE)) {
                snsAdNativeLandingPagesUI.fxE = bi.aG((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.nSe + ".originTraceId"), "");
            }
            snsAdNativeLandingPagesUI.nRW = e.p(snsAdNativeLandingPagesUI.nSd, snsAdNativeLandingPagesUI.nSe, snsAdNativeLandingPagesUI.nyk, snsAdNativeLandingPagesUI.fxE);
            if (snsAdNativeLandingPagesUI.nRW.size() > 0) {
                String str2 = "";
                c cVar = (c) snsAdNativeLandingPagesUI.nRW.get(0);
                if (cVar.nIi.size() > 0) {
                    s sVar = (s) cVar.nIi.get(0);
                    if (sVar instanceof p) {
                        snsAdNativeLandingPagesUI.nSk = ((p) sVar).nAL;
                    } else if (sVar instanceof o) {
                        snsAdNativeLandingPagesUI.nSk = ((o) sVar).nAL;
                    } else if (sVar instanceof q) {
                        snsAdNativeLandingPagesUI.nSk = ((q) sVar).nAO;
                        str2 = ((q) sVar).nAN;
                    } else if (sVar instanceof n) {
                        n nVar = (n) sVar;
                        if (!nVar.nAH.isEmpty()) {
                            m mVar = (m) nVar.nAH.getFirst();
                            if (!mVar.nAH.isEmpty()) {
                                sVar = (s) mVar.nAH.getFirst();
                                if (sVar instanceof p) {
                                    snsAdNativeLandingPagesUI.nSk = ((p) sVar).nAL;
                                }
                            }
                        }
                    }
                }
                if (snsAdNativeLandingPagesUI.nSE != null) {
                    bsu bAJ = snsAdNativeLandingPagesUI.nSE.bAJ();
                    if (!(bAJ == null || bAJ.sqc == null || bAJ.sqc.ruA == null || bAJ.sqc.ruA.isEmpty())) {
                        ate ate = (ate) bAJ.sqc.ruA.getFirst();
                        String str3 = an.s(AdLandingPagesProxy.getInstance().getAccSnsPath(), ate.ksA) + i.j(ate);
                        valueOf = ate.jPK;
                        if (str2.equals(valueOf)) {
                            valueOf = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.eI("adId", valueOf);
                            if (!FileOp.cn(valueOf) && FileOp.cn(str3)) {
                                x.i("MicroMsg.SnsAdNativeLandingPagesUI", "copy outsideFiel:%s->%s", new Object[]{str3, valueOf});
                                FileOp.y(str3, valueOf);
                            }
                        }
                    }
                }
            }
            snsAdNativeLandingPagesUI.nSg = bi.aG((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.nSe + ".adCanvasInfo.rightBarTitle"), "");
            snsAdNativeLandingPagesUI.nSh = bi.aG((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.nSe + ".adCanvasInfo.rightBarCanvasId"), "");
            snsAdNativeLandingPagesUI.nSi = bi.aG((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.nSe + ".adCanvasInfo.rightBarCanvasExt"), "");
        }
        SnsAdNativeLandingPagesUI.b(this.nSR);
        this.nSR.initView();
        SnsAdNativeLandingPagesUI.o(this.nSR);
        this.nSR.io(true);
        SnsAdNativeLandingPagesUI.p(this.nSR);
    }
}
