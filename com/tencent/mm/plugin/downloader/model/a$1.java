package com.tencent.mm.plugin.downloader.model;

import android.content.Intent;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.cdndownloader.c.b;
import com.tencent.mm.plugin.downloader.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements b {
    final /* synthetic */ a ibF;

    a$1(a aVar) {
        this.ibF = aVar;
    }

    public final void f(String str, int i, int i2, String str2) {
        a yN = c.yN(str);
        if (yN == null) {
            x.i("MicroMsg.FileCDNDownloader", "onDownloadTaskStateChanged, info is null");
            return;
        }
        x.i("MicroMsg.FileCDNDownloader", "onDownloadTaskStateChanged, url = %s, state = %d, errCode = %d, errMsg = %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2});
        switch (i) {
            case 3:
                yN.field_downloadedSize = (long) e.cm(yN.field_filePath);
                x.i("MicroMsg.FileCDNDownloader", "download succeed, downloadedSize = %d, startSize = %d", new Object[]{Long.valueOf(yN.field_downloadedSize), Long.valueOf(yN.field_startSize)});
                c.e(yN);
                Intent intent = new Intent();
                intent.putExtra(FileDownloadService.icm, 1);
                intent.setClass(a.c(this.ibF), FileDownloadService.class);
                intent.putExtra(FileDownloadService.EXTRA_ID, yN.field_downloadId);
                try {
                    a.c(this.ibF).startService(intent);
                } catch (Exception e) {
                    x.e("MicroMsg.FileCDNDownloader", e.getMessage());
                }
                a.a(this.ibF, yN.field_downloadUrl);
                a.a(this.ibF).remove(yN.field_downloadUrl);
                a.b(this.ibF).remove(yN.field_downloadUrl);
                return;
            case 4:
                yN.field_errCode = Math.abs(i2);
                yN.field_status = 4;
                if (ao.isWifi(ad.getContext()) && yN.field_downloadInWifi) {
                    yN.field_downloadInWifi = false;
                }
                c.e(yN);
                this.ibF.ibT.c(yN.field_downloadId, Math.abs(i2), false);
                a.a(this.ibF, yN.field_downloadUrl, 4, 0, false);
                a.a(this.ibF).remove(yN.field_downloadUrl);
                a.b(this.ibF).remove(yN.field_downloadUrl);
                return;
            default:
                return;
        }
    }

    public final void l(String str, long j, long j2) {
        a yN = c.yN(str);
        if (yN == null) {
            x.i("MicroMsg.FileCDNDownloader", "onDownloadTaskProgressChanged, info is null");
            return;
        }
        long a;
        Long valueOf = Long.valueOf(bi.c((Long) a.a(this.ibF).get(yN.field_downloadUrl)));
        if (valueOf.longValue() == 0) {
            valueOf = Long.valueOf(j);
            a.a(this.ibF).put(yN.field_downloadUrl, Long.valueOf(j));
        }
        long longValue = j - valueOf.longValue();
        if (j2 == 0) {
            x.i("MicroMsg.FileCDNDownloader", "onDownloadTaskProgressChanged, totalDataLen = 0");
        } else {
            int i = (int) ((((float) j) / ((float) j2)) * 100.0f);
            if ((100 * longValue) / j2 >= 1) {
                a = bi.a((Long) a.b(this.ibF).get(yN.field_downloadUrl), yN.field_startTime);
                long currentTimeMillis = System.currentTimeMillis();
                float f = ((((float) longValue) * 1000.0f) / ((float) (currentTimeMillis - a))) / 1048576.0f;
                x.d("MicroMsg.FileCDNDownloader", "downloadSpeed, appId = %s, speed = %f, period = %d, downloadedSize = %d, totalSize = %d, totalPercent = %d", new Object[]{yN.field_appId, Float.valueOf(f), Long.valueOf(currentTimeMillis - a), Long.valueOf(longValue), Long.valueOf(j2), Integer.valueOf(i)});
                com.tencent.mm.plugin.downloader.e.b.a(yN.field_downloadId, f, i);
                a.b(this.ibF).put(yN.field_downloadUrl, Long.valueOf(currentTimeMillis));
                a.a(this.ibF).put(yN.field_downloadUrl, Long.valueOf(j));
            }
        }
        valueOf = Long.valueOf(bi.c((Long) a.d(this.ibF).get(yN.field_downloadUrl)));
        Long valueOf2 = Long.valueOf(System.currentTimeMillis());
        a = valueOf2.longValue() - valueOf.longValue();
        if (valueOf == null || a >= 500) {
            a.d(this.ibF).put(yN.field_downloadUrl, valueOf2);
            yN.field_status = 1;
            yN.field_downloadedSize = j;
            yN.field_totalSize = j2;
            c.e(yN);
            this.ibF.ibT.cr(yN.field_downloadId);
            int i2 = 0;
            if (j2 > 0) {
                i2 = (int) ((((float) j) / ((float) j2)) * 100.0f);
            }
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 > 100) {
                i2 = 100;
            }
            a.a(this.ibF, yN.field_downloadUrl, 1, i2, false);
        }
    }
}
