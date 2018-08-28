package com.tencent.mm.modelcdntran;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class c$7 implements Runnable {
    final /* synthetic */ c dPb;
    final /* synthetic */ keep_ProgressInfo dPe;
    final /* synthetic */ keep_SceneResult dPf;
    final /* synthetic */ String sl;

    c$7(c cVar, String str, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult) {
        this.dPb = cVar;
        this.sl = str;
        this.dPe = keep_progressinfo;
        this.dPf = keep_sceneresult;
    }

    public final void run() {
        int i = 0;
        i iVar = (i) this.dPb.dOW.get(this.sl);
        if (iVar == null) {
            x.d("MicroMsg.CdnTransportService", " task in jni get info failed mediaid[%s] hash[%s]", this.sl, Integer.valueOf(this.dPb.hashCode()));
            h.mEJ.a(594, 7, 1, true);
            return;
        }
        if (this.dPe != null) {
            this.dPe.mediaId = this.sl;
            x.i("MicroMsg.CdnTransportService", "MTL: total:%d, cur:%d, mtl:%b", Integer.valueOf(this.dPe.field_toltalLength), Integer.valueOf(this.dPe.field_finishedLength), Boolean.valueOf(this.dPe.field_mtlnotify));
        }
        if (this.dPf != null) {
            this.dPf.mediaId = this.sl;
        }
        if (iVar.dPV != null) {
            long VF = bi.VF();
            if (this.dPf != null || this.dPe == null || this.dPe.field_mtlnotify || ao.getNetWorkType(ad.getContext()) != -1) {
                iVar.field_lastProgressCallbackTime = VF;
                iVar.dPV.a(this.sl, 0, this.dPe, this.dPf, iVar.field_onlycheckexist);
            } else {
                return;
            }
        }
        keep_ProgressInfo keep_progressinfo = this.dPe;
        if (keep_progressinfo == null || keep_progressinfo.field_finishedLength == keep_progressinfo.field_toltalLength) {
            i = 1;
        }
        if (i != 0) {
            this.dPb.dOX.remove(this.sl);
        }
        if (this.dPf != null) {
            this.dPb.dOW.remove(this.sl);
            if (this.dPf.field_retCode == -5103011) {
                x.i("MicroMsg.CdnTransportService", "summersafecdn ERR_VALIDATE_AUTHKEY");
                h.mEJ.a(546, 4, 1, true);
                g.NE().keep_OnRequestDoGetCdnDnsInfo(999);
            }
        }
    }

    public final String toString() {
        return super.toString() + "|callback";
    }
}
