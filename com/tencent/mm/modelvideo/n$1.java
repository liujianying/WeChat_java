package com.tencent.mm.modelvideo;

import com.tencent.mm.a.e;
import com.tencent.mm.g.b.a.i;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelvideo.n.a;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.video.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

class n$1 implements Runnable {
    final /* synthetic */ String dhm;
    final /* synthetic */ keep_SceneResult enc;
    final /* synthetic */ n ene;

    n$1(n nVar, String str, keep_SceneResult keep_sceneresult) {
        this.ene = nVar;
        this.dhm = str;
        this.enc = keep_sceneresult;
    }

    public final void run() {
        a aVar = (a) n.a(this.ene).remove(this.dhm);
        if (aVar != null) {
            com.tencent.mm.plugin.sight.base.a aVar2;
            int i;
            int cm = e.cm(aVar.enp);
            com.tencent.mm.plugin.sight.base.a Lo = d.Lo(aVar.enp);
            if (bi.oW(aVar.eno)) {
                aVar2 = Lo;
                i = cm;
            } else {
                aVar2 = d.Lo(aVar.eno);
                i = e.cm(aVar.eno);
            }
            if (aVar2 == null || Lo == null) {
                x.w("MicroMsg.SubCoreMediaRpt", "upload video but media info is null. %s", new Object[]{aVar.enp});
                return;
            }
            StringBuffer stringBuffer;
            int fJ = ao.fJ(ad.getContext());
            long j = this.enc.field_startTime != 0 ? this.enc.field_startTime : aVar.startTime;
            long VF = this.enc.field_endTime != 0 ? this.enc.field_endTime : bi.VF();
            String str = null;
            if (this.enc.field_usedSvrIps != null) {
                stringBuffer = new StringBuffer();
                for (String append : this.enc.field_usedSvrIps) {
                    stringBuffer.append(append).append("|");
                }
                str = stringBuffer.toString();
            }
            stringBuffer = new StringBuffer();
            stringBuffer.append(aVar.toUser).append(",").append(aVar.cqb).append(",");
            stringBuffer.append(fJ).append(",").append(this.enc.field_fileId).append(",");
            stringBuffer.append(this.enc.field_mp4identifymd5).append(",").append(c.OC(aVar.enq)).append(",");
            stringBuffer.append(j).append(",").append(VF).append(",");
            stringBuffer.append(i).append(",").append(aVar2.jdD).append(",");
            stringBuffer.append(aVar2.videoBitrate / BaseReportManager.MAX_READ_COUNT).append(",").append(aVar2.dQF / BaseReportManager.MAX_READ_COUNT).append(",");
            stringBuffer.append(aVar2.ljG).append(",").append(aVar2.width).append(",");
            stringBuffer.append(aVar2.height).append(",").append(aVar.enr).append(",");
            stringBuffer.append(cm).append(",").append(Lo.jdD).append(",");
            stringBuffer.append(Lo.videoBitrate / BaseReportManager.MAX_READ_COUNT).append(",").append(Lo.dQF / BaseReportManager.MAX_READ_COUNT).append(",");
            stringBuffer.append(Lo.ljG).append(",").append(Lo.width).append(",");
            stringBuffer.append(Lo.height).append(",").append(aVar.ens).append(",");
            stringBuffer.append(str).append(",").append(aVar2.nbS).append(",").append(this.enc.field_fileUrl);
            x.i("MicroMsg.SubCoreMediaRpt", "upload video rpt %s", new Object[]{stringBuffer.toString()});
            new i(stringBuffer.toString()).RD();
            n.bq(Lo.videoBitrate, aVar.ens);
        }
    }
}
