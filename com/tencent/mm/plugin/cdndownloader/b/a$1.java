package com.tencent.mm.plugin.cdndownloader.b;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements Runnable {
    final /* synthetic */ int dPc = -1;
    final /* synthetic */ i dPd;
    final /* synthetic */ a hJW;

    a$1(a aVar, i iVar) {
        this.hJW = aVar;
        this.dPd = iVar;
    }

    public final void run() {
        if (this.dPc != -1) {
            a.a(this.hJW).put(this.dPd.field_mediaId, Integer.valueOf(this.dPc));
        }
        a.b(this.hJW).add(this.dPd.field_mediaId);
        a.c(this.hJW).put(this.dPd.field_mediaId, this.dPd);
        a aVar = this.hJW;
        x.i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart queue:%d", new Object[]{Integer.valueOf(aVar.dOU.size())});
        while (!aVar.dOU.isEmpty()) {
            i iVar = (i) aVar.dOV.remove((String) aVar.dOU.poll());
            if (iVar == null) {
                x.e("MicroMsg.CdnDownloadNativeService", "summersafecdn task queue is empty , maybe bug here");
                return;
            }
            x.i("MicroMsg.CdnDownloadNativeService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", new Object[]{iVar.field_mediaId, Boolean.valueOf(iVar.field_autostart), Integer.valueOf(iVar.field_chattype)});
            iVar.field_startTime = bi.VF();
            String str;
            int b;
            if (iVar.ceW) {
                String str2 = "MicroMsg.CdnDownloadNativeService";
                str = "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]";
                Object[] objArr = new Object[7];
                objArr[0] = Integer.valueOf(iVar.field_fullpath == null ? -1 : iVar.field_fullpath.length());
                objArr[1] = Integer.valueOf(iVar.field_thumbpath == null ? -1 : iVar.field_thumbpath.length());
                objArr[2] = bi.Xf(iVar.field_svr_signature);
                objArr[3] = bi.Xf(iVar.field_aesKey);
                objArr[4] = Integer.valueOf(iVar.field_fileType);
                objArr[5] = iVar.field_mediaId;
                objArr[6] = Boolean.valueOf(iVar.field_onlycheckexist);
                x.i(str2, str, objArr);
                if (iVar.field_fullpath == null) {
                    iVar.field_fullpath = "";
                }
                if (iVar.field_thumbpath == null) {
                    iVar.field_thumbpath = "";
                }
                b = b.b(iVar);
                if (b != 0) {
                    x.e("MicroMsg.CdnDownloadNativeService", "summersafecdn startupUploadMedia error:%d clientid:%s", new Object[]{Integer.valueOf(b), iVar.field_mediaId});
                    if (iVar.dPV != null) {
                        iVar.dPV.a(iVar.field_mediaId, b, null, null, iVar.field_onlycheckexist);
                    }
                } else {
                    x.i("MicroMsg.CdnDownloadNativeService", "summersafecdn startupUploadMedia ok, field_mediaId[%s]", new Object[]{iVar.field_mediaId});
                    aVar.dOW.put(iVar.field_mediaId, iVar);
                }
            } else {
                int i = -1;
                String str3;
                Object[] objArr2;
                if (iVar.field_fileType == b.dOw || iVar.field_fileType == b.dOy || iVar.field_fileType == b.dOz || iVar.field_fileType == b.dOA || iVar.field_fileType == b.dOB) {
                    if (!(iVar.field_fullpath == null || iVar.field_fullpath.isEmpty())) {
                        i = b.a(iVar.field_mediaId, iVar.dPW, iVar.field_fullpath, iVar.field_fileType, iVar.dPX, iVar.dPY, iVar.dPZ, iVar.dQa);
                    }
                    str = "MicroMsg.CdnDownloadNativeService";
                    str3 = "url download tryStart recv file:%d field_mediaId[%s], download_url[%s], filetype:[%d], ret:%d";
                    objArr2 = new Object[5];
                    objArr2[0] = Integer.valueOf(iVar.field_fullpath == null ? -1 : iVar.field_fullpath.length());
                    objArr2[1] = iVar.field_mediaId;
                    objArr2[2] = iVar.dPW;
                    objArr2[3] = Integer.valueOf(iVar.field_fileType);
                    objArr2[4] = Integer.valueOf(i);
                    x.i(str, str3, objArr2);
                    b = i;
                } else if (iVar.dQc) {
                    if (!(iVar.field_fullpath == null || iVar.field_fullpath.isEmpty())) {
                        i = b.a(iVar.field_mediaId, iVar.field_fullpath, iVar.dPW, iVar.dQd, iVar.dQe, iVar.allow_mobile_net_download, iVar.dPX, iVar.dPY, iVar.is_resume_task, iVar.dQb, iVar.dPZ);
                    }
                    str = "MicroMsg.CdnDownloadNativeService";
                    str3 = "game package download tryStart recv file:%s field_mediaId[%s], download_url[%s] https url[%s]";
                    objArr2 = new Object[4];
                    objArr2[0] = iVar.field_fullpath == null ? "" : iVar.field_fullpath;
                    objArr2[1] = iVar.field_mediaId;
                    objArr2[2] = iVar.dPW;
                    objArr2[3] = iVar.dQd;
                    x.i(str, str3, objArr2);
                    b = i;
                } else {
                    str = "MicroMsg.CdnDownloadNativeService";
                    str3 = "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]";
                    objArr2 = new Object[7];
                    objArr2[0] = Integer.valueOf(iVar.field_fullpath == null ? -1 : iVar.field_fullpath.length());
                    objArr2[1] = Integer.valueOf(iVar.field_thumbpath == null ? -1 : iVar.field_thumbpath.length());
                    objArr2[2] = iVar.field_svr_signature;
                    objArr2[3] = iVar.field_aesKey;
                    objArr2[4] = Integer.valueOf(iVar.field_fileType);
                    objArr2[5] = iVar.field_mediaId;
                    objArr2[6] = Boolean.valueOf(iVar.field_onlycheckexist);
                    x.i(str, str3, objArr2);
                    if (iVar.dQg != 2) {
                        b = CdnLogic.startC2CDownload(b.a(iVar));
                    } else if (iVar instanceof j) {
                        j jVar = (j) iVar;
                        if (jVar.NI()) {
                            b = b.a(iVar, 2);
                        } else {
                            if (jVar.NG()) {
                                i = b.a(jVar.field_mediaId, jVar.url, jVar.referer, jVar.field_fullpath, jVar.dQm, jVar.dPQ, jVar.initialDownloadOffset, jVar.initialDownloadLength, jVar.isColdSnsData, jVar.signalQuality, jVar.snsScene, jVar.field_preloadRatio);
                            }
                            b = i;
                        }
                    } else {
                        b = -1;
                    }
                }
                if (b != 0) {
                    x.e("MicroMsg.CdnDownloadNativeService", "summersafecdn startupDownloadMedia error:%d clientid:%s", new Object[]{Integer.valueOf(b), iVar.field_mediaId});
                    if (iVar.dPV != null) {
                        iVar.dPV.a(iVar.field_mediaId, b, null, null, iVar.field_onlycheckexist);
                    }
                } else {
                    x.i("MicroMsg.CdnDownloadNativeService", "summersafecdn startupDownloadMedia ok, field_mediaId[%s]", new Object[]{iVar.field_mediaId});
                    aVar.dOW.put(iVar.field_mediaId, iVar);
                }
            }
        }
    }

    public final String toString() {
        return super.toString() + "|addRecvTask";
    }
}
