package com.tencent.mm.plugin.cdndownloader.b;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.modelcdntran.b.b;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public final class a implements b {
    private static a hJU = null;
    Queue<String> dOU = new LinkedList();
    public Map<String, i> dOV = new ConcurrentHashMap();
    public Map<String, i> dOW = new ConcurrentHashMap();
    public Map<String, Integer> dOX = new ConcurrentHashMap();
    private String dOY = "";
    private long dOZ = 0;
    public HashSet<String> dPa = new HashSet();
    private ah dqM = new ah();
    com.tencent.mm.modelcdntran.b hJV = new com.tencent.mm.modelcdntran.b(ad.getContext().getFilesDir() + "/NativeCDNInfo", this);

    public static synchronized a aAj() {
        a aVar;
        synchronized (a.class) {
            if (hJU == null) {
                hJU = new a();
            }
            aVar = hJU;
        }
        return aVar;
    }

    public final int d(i iVar) {
        if (bi.oW(iVar.field_mediaId)) {
            x.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId is null");
            return -1;
        }
        if (iVar.field_fileId == null) {
            iVar.field_fileId = "";
        }
        if (iVar.field_aesKey == null) {
            iVar.field_aesKey = "";
        }
        if (this.dOU.contains(iVar.field_fileId)) {
            x.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in queueTask");
            return -2;
        } else if (this.dOV.containsKey(iVar.field_fileId)) {
            x.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in mapWaitTask");
            return -2;
        } else if (this.dOW.containsKey(iVar.field_fileId)) {
            x.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in mapTaskInJni");
            return -2;
        } else {
            iVar.ceW = false;
            this.dqM.H(new 1(this, iVar));
            return 0;
        }
    }

    public static boolean ym(String str) {
        x.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra pauseRecvTask mediaid:%s, ret:%d", new Object[]{str, Integer.valueOf(CdnLogic.pauseHttpMultiSocketDownloadTask(str))});
        if (CdnLogic.pauseHttpMultiSocketDownloadTask(str) == 0) {
            return true;
        }
        return false;
    }

    public final int a(String str, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult) {
        if (bi.oW(str)) {
            x.e("MicroMsg.CdnDownloadNativeService", "cdn callback mediaid is null");
            return -1;
        } else if (keep_progressinfo == null && keep_sceneresult == null) {
            x.e("MicroMsg.CdnDownloadNativeService", "cdn callback info all null");
            return -2;
        } else {
            if (keep_progressinfo != null) {
                x.d("MicroMsg.CdnDownloadNativeService", "CDN progress. total:%d, cur:%d, canshow:%b, isUploadTask:%b", new Object[]{Integer.valueOf(keep_progressinfo.field_toltalLength), Integer.valueOf(keep_progressinfo.field_finishedLength), Boolean.valueOf(keep_progressinfo.field_mtlnotify), Boolean.valueOf(keep_progressinfo.field_isUploadTask)});
            }
            boolean z = keep_progressinfo != null ? keep_progressinfo.field_isUploadTask : false;
            this.dOZ = bi.VF();
            this.dOY = str;
            this.dqM.H(new 2(this, str, keep_progressinfo, z, keep_sceneresult));
            return 0;
        }
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        if (bi.oW(str)) {
            x.e("MicroMsg.CdnDownloadNativeService", "cdn callback getauthbuf mediaid is null");
            return;
        }
        i iVar = (i) this.dOW.get(str);
        if (iVar == null) {
            x.e("MicroMsg.CdnDownloadNativeService", " getauthbuf task in jni get info failed mediaid:%s", new Object[]{str});
        } else if (iVar.dPV != null) {
            iVar.dPV.a(str, byteArrayOutputStream);
        } else {
            x.e("MicroMsg.CdnDownloadNativeService", "getCdnAuthInfo fail, null taskcallback.");
        }
    }

    public final byte[] i(String str, byte[] bArr) {
        if (bi.oW(str)) {
            x.e("MicroMsg.CdnDownloadNativeService", "cdn callback decodePrepareResponse mediaid is null");
            return null;
        }
        i iVar = (i) this.dOW.get(str);
        if (iVar == null) {
            x.e("MicroMsg.CdnDownloadNativeService", " decodePrepareResponse task in jni get info failed mediaid:%s", new Object[]{str});
            return null;
        } else if (iVar.dPV != null) {
            return iVar.dPV.i(str, bArr);
        } else {
            x.e("MicroMsg.CdnDownloadNativeService", "decodePrepareResponse fail, null taskcallback.");
            return null;
        }
    }

    public final void b(final String str, final keep_SceneResult keep_sceneresult) {
        if (!bi.oW(str)) {
            this.dqM.H(new Runnable() {
                public final void run() {
                    i iVar = (i) a.this.dOW.get(str);
                    if (iVar == null) {
                        x.e("MicroMsg.CdnDownloadNativeService", " task in jni get info failed mediaid:%s", new Object[]{str});
                    } else if (iVar.dQi != null) {
                        iVar.dQi.b(str, keep_sceneresult);
                    }
                }
            });
        }
    }
}
