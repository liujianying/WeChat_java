package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.topstory.ui.b$g;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.protocal.c.bti;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import com.tencent.smtt.utils.TbsLog;

class n$13 implements b {
    final /* synthetic */ n oBM;

    n$13(n nVar) {
        this.oBM = nVar;
    }

    public final void d(String str, String str2, String str3, int i, int i2) {
        int i3;
        String str4;
        x.e("MicroMsg.TopStory.TopStoryVideoViewContainer", "onError errorMsg=%s what=%d extra=%d", new Object[]{str3, Integer.valueOf(i), Integer.valueOf(i2)});
        this.oBM.eS(this.oBM.getContext().getString(b$g.video_error_warnning, new Object[]{i + ":" + i2}), this.oBM.getContext().getString(b$g.video_retry_play));
        o bHS = n.b(this.oBM).bHS();
        if (bHS.oCd != null && bHS.oCd.getSessionId().equals(str)) {
            bHS.stopPlay();
        }
        switch (i) {
            case -21020:
                com.tencent.mm.plugin.websearch.api.a.b.kB(com.tencent.mm.plugin.websearch.api.a.b.pMO);
                break;
            case -21009:
                com.tencent.mm.plugin.websearch.api.a.b.kB(com.tencent.mm.plugin.websearch.api.a.b.pMN);
                break;
            case -10012:
                com.tencent.mm.plugin.websearch.api.a.b.kB(com.tencent.mm.plugin.websearch.api.a.b.pML);
                break;
            case -10004:
                com.tencent.mm.plugin.websearch.api.a.b.kB(com.tencent.mm.plugin.websearch.api.a.b.pMM);
                break;
            case -1010:
                com.tencent.mm.plugin.websearch.api.a.b.kB(com.tencent.mm.plugin.websearch.api.a.b.pMI);
                break;
            case -1007:
                com.tencent.mm.plugin.websearch.api.a.b.kB(com.tencent.mm.plugin.websearch.api.a.b.pMJ);
                break;
            case -1004:
                com.tencent.mm.plugin.websearch.api.a.b.kB(com.tencent.mm.plugin.websearch.api.a.b.pMK);
                break;
            case TbsListener$ErrorCode.INFO_MISS_SDKEXTENSION_JAR /*403*/:
                com.tencent.mm.plugin.websearch.api.a.b.kB(com.tencent.mm.plugin.websearch.api.a.b.pMQ);
                break;
            case TbsListener$ErrorCode.INFO_DISABLE_X5 /*404*/:
                com.tencent.mm.plugin.websearch.api.a.b.kB(com.tencent.mm.plugin.websearch.api.a.b.pMP);
                break;
            case TbsListener$ErrorCode.INFO_CAN_NOT_LOAD_TBS /*405*/:
                com.tencent.mm.plugin.websearch.api.a.b.kB(com.tencent.mm.plugin.websearch.api.a.b.pMU);
                break;
            case TbsListener$ErrorCode.INFO_USE_BACKUP_FILE_INSTALL_BY_SERVER /*416*/:
                com.tencent.mm.plugin.websearch.api.a.b.kB(com.tencent.mm.plugin.websearch.api.a.b.pMT);
                break;
            case TbsListener$ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE /*502*/:
                com.tencent.mm.plugin.websearch.api.a.b.kB(com.tencent.mm.plugin.websearch.api.a.b.pMS);
                break;
            case TbsListener$ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS /*503*/:
                com.tencent.mm.plugin.websearch.api.a.b.kB(com.tencent.mm.plugin.websearch.api.a.b.pMR);
                break;
            default:
                com.tencent.mm.plugin.websearch.api.a.b.kB(com.tencent.mm.plugin.websearch.api.a.b.pMV);
                break;
        }
        a.kB(7);
        com.tencent.mm.plugin.topstory.a.b.a aVar = n.b(this.oBM).bHU().oAm;
        if (aVar == null || aVar.oyQ <= 0) {
            i3 = 0;
        } else {
            i3 = ((int) (System.currentTimeMillis() - aVar.oyQ)) / TbsLog.TBSLOG_CODE_SDK_BASE;
        }
        bti e = n.e(this.oBM);
        int i4 = ao.isWifi(ad.getContext()) ? 2 : !ao.isConnected(ad.getContext()) ? 1 : 3;
        if (e != null) {
            str4 = e.sqZ;
        } else {
            str4 = "";
        }
        x.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportKvTopStoryVideoPlayError %s", new Object[]{String.format("%s,%s,%s,%s,%s", new Object[]{str4, Integer.valueOf(i), str3, Integer.valueOf(i4), Integer.valueOf(i3)})});
        f.mDy.k(15248, r0);
    }

    public final void bu(String str, String str2) {
        x.i("MicroMsg.TopStory.TopStoryVideoViewContainer", "onPrepared");
        c h = n.h(this.oBM);
        h.gbA = -1;
        h.gbB = 0;
        h.gbz = 0.0f;
        n.f(this.oBM).jR(n.i(this.oBM));
        if (!n.i(this.oBM)) {
            this.oBM.bIm();
        }
    }

    public final void bv(String str, String str2) {
        x.i("MicroMsg.TopStory.TopStoryVideoViewContainer", "onVideoEnded");
        o bHS = n.b(this.oBM).bHS();
        com.tencent.mm.plugin.topstory.a.b.a aVar = bHS.oAb.bHU().oAm;
        if (aVar != null) {
            aVar.oyU = 1;
        }
        if (bHS.oCd != null && bHS.oCd.getSessionId().equals(str)) {
            bHS.stopPlay();
        }
        a.kB(26);
        if (!n.b(this.oBM).bHR().aEY()) {
            this.oBM.bIp();
        } else if (n.b(this.oBM).bHQ().jMc) {
            this.oBM.bIs();
        } else {
            n.b(this.oBM).ye(n.d(this.oBM) + 1);
        }
        n.f(this.oBM).setVisibility(8);
        n.b(this.oBM, false);
    }

    public final void d(String str, String str2, int i, int i2) {
        x.i("MicroMsg.TopStory.TopStoryVideoViewContainer", "onGetVideoSize width=%d height=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (n.j(this.oBM) == n$a.AUTO) {
            n.a(this.oBM, i < i2 ? n$a.PORTRAIT : n$a.LANDSCAPE);
            x.i("MicroMsg.TopStory.TopStoryVideoViewContainer", "onGetVideoSize adjust direction from AUTO to %s", new Object[]{n.j(this.oBM)});
        }
    }

    public final void bw(String str, String str2) {
    }

    public final void bx(String str, String str2) {
    }

    public final void by(String str, String str2) {
        x.i("MicroMsg.TopStory.TopStoryVideoViewContainer", "onVideoWaiting");
        this.oBM.bIq();
        n.b(this.oBM, true);
    }

    public final void bz(String str, String str2) {
        x.i("MicroMsg.TopStory.TopStoryVideoViewContainer", "onVideoWaitingEnd");
        n.b(this.oBM, false);
        n.f(this.oBM).bTw();
        this.oBM.bIm();
        com.tencent.mm.plugin.topstory.a.b.a aVar = n.b(this.oBM).bHU().oAm;
        if (aVar != null && aVar.ozb == 0) {
            aVar.ozb = System.currentTimeMillis() - aVar.oyQ;
            x.i("MicroMsg.TopStory.TopStoryVideoViewContainer", "FirstLoadTime %d %d", new Object[]{Long.valueOf(aVar.oyY), Long.valueOf(aVar.ozb)});
        }
    }
}
