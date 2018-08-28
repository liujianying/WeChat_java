package com.tencent.mm.plugin.downloader.model;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.downloader.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

final class i extends h {
    public i(b bVar) {
        super(bVar);
    }

    public final long a(a aVar) {
        return 0;
    }

    public final long a(e eVar) {
        if (bi.oW(eVar.fhq)) {
            return -1;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(eVar.fhq));
        intent.addFlags(268435456);
        try {
            ad.getContext().startActivity(intent);
            return 0;
        } catch (Exception e) {
            x.e("MicroMsg.FileDownloaderImplNormal", "Add download task failed: " + e.toString());
            return -1;
        }
    }

    public final int cl(long j) {
        return 1;
    }

    public final FileDownloadTaskInfo cm(long j) {
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        fileDownloadTaskInfo.id = j;
        fileDownloadTaskInfo.status = -1;
        return fileDownloadTaskInfo;
    }

    public final boolean cn(long j) {
        return false;
    }

    public final boolean co(long j) {
        return false;
    }
}
