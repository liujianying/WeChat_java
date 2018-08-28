package com.tencent.mm.plugin.cdndownloader.service;

import com.tencent.mars.BaseEvent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnTaskStateInfo;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.plugin.cdndownloader.a.a.a;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class CDNDownloadService$1 extends a {
    final /* synthetic */ CDNDownloadService hKt;

    CDNDownloadService$1(CDNDownloadService cDNDownloadService) {
        this.hKt = cDNDownloadService;
    }

    public final int a(CDNTaskInfo cDNTaskInfo) {
        x.i("MicroMsg.CDNDownloadService", "addDownloadTask: %s filepath:%s", new Object[]{cDNTaskInfo.downloadUrl, cDNTaskInfo.filePath});
        i iVar = new i();
        iVar.dQc = cDNTaskInfo.dQc;
        iVar.field_mediaId = cDNTaskInfo.mediaId;
        iVar.field_fullpath = cDNTaskInfo.filePath;
        iVar.dPW = cDNTaskInfo.downloadUrl;
        iVar.dQd = cDNTaskInfo.hKj;
        iVar.dPV = CDNDownloadService.aAq();
        iVar.dPX = cDNTaskInfo.hKl;
        iVar.dPY = cDNTaskInfo.hKm;
        iVar.allow_mobile_net_download = cDNTaskInfo.hKn;
        iVar.dQb = cDNTaskInfo.hKo;
        CDNDownloadService.a(iVar, cDNTaskInfo.hKk);
        int d = com.tencent.mm.plugin.cdndownloader.b.a.aAj().d(iVar);
        x.i("MicroMsg.CDNDownloadService", "addDownloadTask: " + d);
        return d;
    }

    public final int b(CDNTaskInfo cDNTaskInfo) {
        int resumeHttpMultiSocketDownloadTask;
        x.i("MicroMsg.CDNDownloadService", "resumeDownloadTask: %s", new Object[]{cDNTaskInfo.downloadUrl});
        i iVar = new i();
        iVar.dQc = cDNTaskInfo.dQc;
        iVar.field_mediaId = cDNTaskInfo.mediaId;
        iVar.field_fullpath = cDNTaskInfo.filePath;
        iVar.dPW = cDNTaskInfo.downloadUrl;
        iVar.dQd = cDNTaskInfo.hKj;
        iVar.dPV = CDNDownloadService.aAq();
        iVar.dPX = cDNTaskInfo.hKl;
        iVar.dPY = cDNTaskInfo.hKm;
        iVar.dQb = cDNTaskInfo.hKo;
        iVar.allow_mobile_net_download = cDNTaskInfo.hKn;
        CDNDownloadService.a(iVar, cDNTaskInfo.hKk);
        com.tencent.mm.plugin.cdndownloader.b.a aAj = com.tencent.mm.plugin.cdndownloader.b.a.aAj();
        if (aAj.dOW.containsKey(iVar.field_mediaId)) {
            resumeHttpMultiSocketDownloadTask = CdnLogic.resumeHttpMultiSocketDownloadTask(iVar.field_mediaId);
            x.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra resumeRecvTask task resume mediaid:%s, ret:%d", new Object[]{iVar.field_mediaId, Integer.valueOf(resumeHttpMultiSocketDownloadTask)});
        } else {
            x.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra resumeRecvTask task add new mediaid:%s", new Object[]{iVar.field_mediaId});
            resumeHttpMultiSocketDownloadTask = aAj.d(iVar);
        }
        x.i("MicroMsg.CDNDownloadService", "resumeDownloadTask: " + resumeHttpMultiSocketDownloadTask);
        return resumeHttpMultiSocketDownloadTask;
    }

    public final boolean yj(String str) {
        com.tencent.mm.plugin.cdndownloader.b.a.aAj();
        boolean ym = com.tencent.mm.plugin.cdndownloader.b.a.ym(str);
        x.i("MicroMsg.CDNDownloadService", "pauseDownloadTask: " + ym);
        return ym;
    }

    public final boolean yk(String str) {
        com.tencent.mm.plugin.cdndownloader.b.a aAj = com.tencent.mm.plugin.cdndownloader.b.a.aAj();
        i iVar = (i) aAj.dOW.remove(str);
        if (iVar != null) {
            if (iVar.field_fileType == b.dOw || iVar.field_fileType == b.dOy) {
                b.lt(str);
            } else if (iVar.dQc) {
                b.lu(str);
            } else {
                b.lp(str);
            }
            h.mEJ.h(10769, new Object[]{Integer.valueOf(d.dPq), Integer.valueOf(iVar.field_fileType), Long.valueOf(bi.VF() - iVar.field_startTime)});
        }
        aAj.dOV.remove(str);
        aAj.dOX.remove(str);
        x.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[]{str, iVar, Integer.valueOf(0)});
        x.i("MicroMsg.CDNDownloadService", "removeDownloadTask: true");
        return true;
    }

    public final CDNTaskState yl(String str) {
        CdnTaskStateInfo httpMultiSocketDownloadTaskState = CdnLogic.httpMultiSocketDownloadTaskState(str);
        if (httpMultiSocketDownloadTaskState == null) {
            return null;
        }
        CDNTaskState cDNTaskState = new CDNTaskState();
        cDNTaskState.taskState = httpMultiSocketDownloadTaskState.taskState;
        cDNTaskState.fileTotalSize = httpMultiSocketDownloadTaskState.fileTotalSize;
        cDNTaskState.completeSize = httpMultiSocketDownloadTaskState.completeSize;
        return cDNTaskState;
    }

    public final void a(com.tencent.mm.plugin.cdndownloader.a.b bVar) {
        x.i("MicroMsg.CDNDownloadService", "registerCallback");
        CDNDownloadService.c(bVar);
    }

    public final void b(com.tencent.mm.plugin.cdndownloader.a.b bVar) {
        CDNDownloadService.c(null);
    }

    public final void od(int i) {
        x.i("MicroMsg.CDNDownloadService", "notifyNetworkChange: " + i);
        BaseEvent.onNetworkChange();
    }

    public final void aAg() {
        if (!b$a.dns.c(this.hKt)) {
            x.i("MicroMsg.CDNDownloadService", "addIPCTaskMarker");
            b$a.dns.a(this.hKt);
        }
    }

    public final void aAh() {
        x.i("MicroMsg.CDNDownloadService", "removeIPCTaskMarker");
        b$a.dns.b(this.hKt);
    }

    public final void aAi() {
    }
}
