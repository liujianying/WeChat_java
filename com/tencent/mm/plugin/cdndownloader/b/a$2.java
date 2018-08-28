package com.tencent.mm.plugin.cdndownloader.b;

import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements Runnable {
    final /* synthetic */ keep_ProgressInfo dPe;
    final /* synthetic */ keep_SceneResult dPf;
    final /* synthetic */ a hJW;
    final /* synthetic */ boolean hJX;
    final /* synthetic */ String sl;

    a$2(a aVar, String str, keep_ProgressInfo keep_progressinfo, boolean z, keep_SceneResult keep_sceneresult) {
        this.hJW = aVar;
        this.sl = str;
        this.dPe = keep_progressinfo;
        this.hJX = z;
        this.dPf = keep_sceneresult;
    }

    public final void run() {
        i iVar = (i) a.d(this.hJW).get(this.sl);
        if (iVar == null) {
            x.e("MicroMsg.CdnDownloadNativeService", " task in jni get info failed mediaid:%s", new Object[]{this.sl});
            return;
        }
        if (this.dPe != null) {
            this.dPe.mediaId = this.sl;
            x.i("MicroMsg.CdnDownloadNativeService", "MTL: total:%d, cur:%d, mtl:%b, isSend:%b, isUploadTask:%b(%b)", new Object[]{Integer.valueOf(this.dPe.field_toltalLength), Integer.valueOf(this.dPe.field_finishedLength), Boolean.valueOf(this.dPe.field_mtlnotify), Boolean.valueOf(iVar.ceW), Boolean.valueOf(this.dPe.field_isUploadTask), Boolean.valueOf(this.hJX)});
            if (this.hJX != iVar.ceW) {
                return;
            }
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
        if (a.a(this.dPe)) {
            a.a(this.hJW).remove(this.sl);
        }
        if (this.dPf != null) {
            a.d(this.hJW).remove(this.sl);
            if (this.dPf.field_retCode == -5103011) {
                x.i("MicroMsg.CdnDownloadNativeService", "summersafecdn ERR_VALIDATE_AUTHKEY");
                h.mEJ.a(546, 4, 1, true);
                a.e(this.hJW).keep_OnRequestDoGetCdnDnsInfo(999);
            }
        }
    }

    public final String toString() {
        return super.toString() + "|callback";
    }
}
