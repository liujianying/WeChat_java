package com.tencent.mm.plugin.downloader.d;

import android.content.Intent;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.plugin.downloader.c.a;
import com.tencent.mm.plugin.downloader.e.b;
import com.tencent.mm.plugin.downloader.model.FileDownloadService;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import java.io.File;
import java.util.Iterator;

class a$5 implements ITMAssistantDownloadSDKClientListener {
    final /* synthetic */ a icL;

    a$5(a aVar) {
        this.icL = aVar;
    }

    public final void OnDwonloadSDKServiceInvalid(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient) {
        x.e("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistant Service unavailable");
        Iterator it = this.icL.icH.iterator();
        while (it.hasNext()) {
            a cs = c.cs(((Long) it.next()).longValue());
            if (cs != null) {
                cs.field_status = 4;
                cs.field_errCode = com.tencent.mm.plugin.downloader.a.a.ibc;
                c.e(cs);
                this.icL.ibT.c(cs.field_downloadId, com.tencent.mm.plugin.downloader.a.a.ibc, false);
                a.a(this.icL, cs.field_downloadUrl, 5, 0, false);
            }
        }
        this.icL.icH.clear();
    }

    public final void OnDownloadSDKTaskStateChanged(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, String str, int i, int i2, String str2, boolean z, boolean z2) {
        x.i("MicroMsg.FileDownloaderImplTMAssistant", "OnDownloadSDKTaskStateChanged State: " + i + " | ErrorCode: " + i2 + " | ErrorMsg: " + str2);
        a yN = c.yN(str);
        if (yN == null) {
            x.e("MicroMsg.FileDownloaderImplTMAssistant", "getDownloadInfoByURL failed");
            return;
        }
        x.i("MicroMsg.FileDownloaderImplTMAssistant", "State: %d, Id: %d, Path: %s, File Exists: %b, URL: %s", new Object[]{Integer.valueOf(i), Long.valueOf(yN.field_downloadId), yN.field_filePath, Boolean.valueOf(new File(yN.field_filePath).exists()), str});
        if (!(i == 1 || i == 2)) {
            FileDownloadTaskInfo cm = this.icL.cm(yN.field_downloadId);
            long a = bi.a((Long) this.icL.ibE.get(yN.field_downloadUrl), yN.field_startTime);
            int i3 = (int) ((((float) cm.icq) / ((float) cm.gTK)) * 100.0f);
            b.a(yN.field_downloadId, ((((float) (cm.icq - bi.a((Long) this.icL.ibD.get(yN.field_downloadUrl), yN.field_startSize))) * 1000.0f) / ((float) (System.currentTimeMillis() - a))) / 1048576.0f, i3);
            this.icL.ibD.remove(yN.field_downloadUrl);
            this.icL.ibE.remove(yN.field_downloadUrl);
        }
        switch (i) {
            case 2:
                c.k(yN.field_downloadId, 1);
                return;
            case 3:
                c.k(yN.field_downloadId, 2);
                this.icL.cancelNotification(str);
                this.icL.icH.remove(Long.valueOf(yN.field_downloadId));
                this.icL.ibT.cq(yN.field_downloadId);
                return;
            case 4:
                x.i("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistant Download Succeed event received");
                yN.field_downloadedSize = (long) e.cm(yN.field_filePath);
                x.i("MicroMsg.FileDownloaderImplTMAssistant", "download succeed, downloadedSize = %d, startSize = %d", new Object[]{Long.valueOf(yN.field_downloadedSize), Long.valueOf(yN.field_startSize)});
                c.e(yN);
                if (z2) {
                    gt gtVar = new gt();
                    gtVar.bPU.appId = yN.field_appId;
                    gtVar.bPU.opType = 6;
                    com.tencent.mm.sdk.b.a.sFg.m(gtVar);
                }
                Intent intent = new Intent();
                intent.putExtra(FileDownloadService.icm, 1);
                intent.setClass(this.icL.mContext, FileDownloadService.class);
                intent.putExtra(FileDownloadService.EXTRA_ID, yN.field_downloadId);
                intent.putExtra(FileDownloadService.icp, z);
                try {
                    this.icL.mContext.startService(intent);
                } catch (Exception e) {
                    x.e("MicroMsg.FileDownloaderImplTMAssistant", e.getMessage());
                }
                this.icL.cancelNotification(str);
                this.icL.icH.remove(Long.valueOf(yN.field_downloadId));
                return;
            case 5:
                if (i2 == 601 || i2 == 602 || i2 == 603 || i2 == 605 || i2 == 606) {
                    x.d("MicroMsg.FileDownloaderImplTMAssistant", "releaseTimer 4 min");
                    this.icL.icJ.J(240000, 240000);
                }
                if (ao.isWifi(ad.getContext()) && yN.field_downloadInWifi) {
                    yN.field_downloadInWifi = false;
                }
                a.a(this.icL, str, i, 0, false);
                this.icL.icH.remove(Long.valueOf(yN.field_downloadId));
                yN.field_errCode = i2;
                yN.field_status = 4;
                c.e(yN);
                this.icL.ibT.c(yN.field_downloadId, i2, z);
                return;
            default:
                return;
        }
    }

    public final void OnDownloadSDKTaskProgressChanged(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, String str, long j, long j2) {
        a yN = c.yN(str);
        if (yN == null) {
            x.e("MicroMsg.FileDownloaderImplTMAssistant", "getDownloadInfoByURL failed");
            return;
        }
        Long valueOf = Long.valueOf(bi.c((Long) this.icL.ibD.get(yN.field_downloadUrl)));
        if (valueOf.longValue() == 0) {
            valueOf = Long.valueOf(j);
            this.icL.ibD.put(yN.field_downloadUrl, Long.valueOf(j));
        }
        long longValue = j - valueOf.longValue();
        if (j2 == 0) {
            x.i("MicroMsg.FileDownloaderImplTMAssistant", "onDownloadTaskProgressChanged, totalDataLen = 0");
        } else {
            int i = (int) ((((float) j) / ((float) j2)) * 100.0f);
            if ((100 * longValue) / j2 >= 1) {
                long a = bi.a((Long) this.icL.ibE.get(yN.field_downloadUrl), yN.field_startTime);
                long currentTimeMillis = System.currentTimeMillis();
                float f = ((((float) longValue) * 1000.0f) / ((float) (currentTimeMillis - a))) / 1048576.0f;
                x.d("MicroMsg.FileDownloaderImplTMAssistant", "downloadSpeed, appId = %s, speed = %f, period = %d, downloadedSize = %d, totalSize = %d", new Object[]{yN.field_appId, Float.valueOf(f), Long.valueOf(currentTimeMillis - a), Long.valueOf(longValue), Long.valueOf(j2)});
                b.a(yN.field_downloadId, f, i);
                this.icL.ibE.put(yN.field_downloadUrl, Long.valueOf(currentTimeMillis));
                this.icL.ibD.put(yN.field_downloadUrl, Long.valueOf(j));
            }
        }
        valueOf = (Long) this.icL.icF.get(str);
        Long valueOf2 = Long.valueOf(System.currentTimeMillis());
        if (valueOf == null || valueOf2.longValue() - valueOf.longValue() >= 500) {
            this.icL.icF.put(str, valueOf2);
            x.i("MicroMsg.FileDownloaderImplTMAssistant", "onProgressChanged");
            a.a(this.icL, str, 2, (int) ((100 * j) / j2), false);
            longValue = yN.field_downloadId;
            com.tencent.mm.plugin.downloader.c.b FX = c.FX();
            if (FX != null) {
                FX.fV("FileDownloadInfo", "update FileDownloadInfo set downloadedSize = " + j + ",totalSize= " + j2 + " where downloadId = " + longValue);
            }
            this.icL.ibT.cr(yN.field_downloadId);
        }
    }
}
