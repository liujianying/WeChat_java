package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnTaskStateInfo;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.HashMap;

public final class j extends h {
    private static final String ibz = (b.bnE + "WebNetFile");
    private HashMap<String, Long> ibB = new HashMap();
    private a icx = new 4(this);
    private Context mContext = ad.getContext();

    public j(b bVar) {
        super(bVar);
    }

    public final long a(com.tencent.mm.plugin.downloader.c.a aVar) {
        return 0;
    }

    public final long a(e eVar) {
        if (eVar == null || bi.oW(eVar.fhq)) {
            x.e("MicroMsg.FileWebNetDownloader", "Invalid Request");
            return -1;
        }
        x.i("MicroMsg.FileWebNetDownloader", "addDownloadTask: %s", new Object[]{eVar.fhq});
        String str = eVar.fhq;
        com.tencent.mm.plugin.downloader.c.a yN = c.yN(str);
        if (yN != null) {
            FileDownloadTaskInfo cm = cm(yN.field_downloadId);
            x.i("MicroMsg.FileWebNetDownloader", "addDownloadTask, status = " + cm.status);
            if (cm.status == 1) {
                return cm.id;
            }
        }
        c.yL(str);
        c.yM(eVar.mAppId);
        com.tencent.mm.plugin.downloader.c.a c = f.c(eVar);
        c.field_downloadId = System.currentTimeMillis();
        c.field_downloaderType = 4;
        c.field_filePath = ibz + "/" + ac.ce(str);
        if (yN != null) {
            str = c.field_filePath;
            String str2 = yN.field_filePath;
            if (!(str == null || str2 == null || str.equals(str2))) {
                if (new File(str2).exists()) {
                    x.i("MicroMsg.FileWebNetDownloader", "Delete previous file result: %b", new Object[]{Boolean.valueOf(new File(str2).delete())});
                }
            }
        }
        c.field_startTime = System.currentTimeMillis();
        File file = new File(ibz);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                File parentFile = file.getParentFile();
                File file2 = new File(parentFile.getAbsolutePath() + System.currentTimeMillis());
                if (file2.mkdirs()) {
                    file2.renameTo(parentFile);
                } else {
                    x.e("MicroMsg.FileWebNetDownloader", "mkdir parent error, %s", new Object[]{parentFile.getAbsolutePath()});
                }
            }
            x.i("MicroMsg.FileWebNetDownloader", "Make download dir result: %b", new Object[]{Boolean.valueOf(file.mkdirs())});
        }
        i iVar = new i();
        iVar.dPW = eVar.fhq;
        iVar.field_mediaId = eVar.fhq;
        if (eVar.icd == 2) {
            iVar.field_fileType = com.tencent.mm.modelcdntran.b.dOy;
            iVar.dPX = 20;
            iVar.dPY = 90;
        }
        iVar.field_fullpath = c.field_filePath;
        iVar.dPV = this.icx;
        boolean b = g.ND().b(iVar, -1);
        x.i("MicroMsg.FileWebNetDownloader", "addDownloadTask: " + b);
        if (b) {
            c.field_status = 1;
            c.d(c);
            this.ibT.i(c.field_downloadId, c.field_filePath);
        } else {
            c.field_status = 4;
            c.field_errCode = com.tencent.mm.plugin.downloader.a.a.ibg;
            c.d(c);
            this.ibT.c(c.field_downloadId, c.field_errCode, false);
        }
        return c.field_downloadId;
    }

    public final FileDownloadTaskInfo cm(long j) {
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        com.tencent.mm.plugin.downloader.c.a cs = c.cs(j);
        if (cs != null) {
            CdnTaskStateInfo httpMultiSocketDownloadTaskState = CdnLogic.httpMultiSocketDownloadTaskState(cs.field_downloadUrl);
            if (cs.field_status != 1 || (httpMultiSocketDownloadTaskState != null && (httpMultiSocketDownloadTaskState.taskState == 100 || httpMultiSocketDownloadTaskState.taskState == s$l.AppCompatTheme_buttonStyleSmall))) {
                fileDownloadTaskInfo.status = cs.field_status;
            } else {
                fileDownloadTaskInfo.status = 0;
            }
            fileDownloadTaskInfo.icq = cs.field_downloadedSize;
            fileDownloadTaskInfo.gTK = cs.field_totalSize;
            fileDownloadTaskInfo.id = j;
            fileDownloadTaskInfo.bPG = cs.field_downloaderType;
            fileDownloadTaskInfo.icr = cs.field_autoDownload;
            fileDownloadTaskInfo.path = cs.field_filePath;
            fileDownloadTaskInfo.url = cs.field_downloadUrl;
            fileDownloadTaskInfo.bKg = cs.field_md5;
        }
        return fileDownloadTaskInfo;
    }

    public final int cl(final long j) {
        new Thread(new Runnable() {
            public final void run() {
                com.tencent.mm.plugin.downloader.c.a cs = c.cs(j);
                if (cs != null) {
                    g.ND().lx(cs.field_downloadUrl);
                    if (cs.field_status != 5) {
                        c.k(cs.field_downloadId, 5);
                        j.this.ibT.cp(j);
                    }
                }
            }
        }).start();
        return 1;
    }

    public final boolean cn(final long j) {
        new Thread(new Runnable() {
            public final void run() {
                x.d("MicroMsg.FileWebNetDownloader", "pauseDownloadTask");
                FileDownloadTaskInfo cm = j.this.cm(j);
                if (cm != null && cm.status == 1) {
                    CdnLogic.pauseHttpMultiSocketDownloadTask(cm.url);
                    c.k(cm.id, 2);
                    j.this.ibT.cq(j);
                }
            }
        }).start();
        return true;
    }

    public final boolean co(long j) {
        com.tencent.mm.plugin.downloader.c.a cs = c.cs(j);
        if (cs == null || cs.field_status != 2) {
            return false;
        }
        new Thread(new 3(this, cs, j)).start();
        return true;
    }
}
