package com.tencent.mm.plugin.downloader.model;

class g$3 implements Runnable {
    final /* synthetic */ g icw;

    g$3(g gVar) {
        this.icw = gVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r15 = this;
        r14 = -1;
        r0 = r15.icw;	 Catch:{ Exception -> 0x005f }
        r0 = r0.icu;	 Catch:{ Exception -> 0x005f }
        r1 = r0.iterator();	 Catch:{ Exception -> 0x005f }
    L_0x0009:
        r0 = r1.hasNext();	 Catch:{ Exception -> 0x005f }
        if (r0 == 0) goto L_0x006a;
    L_0x000f:
        r0 = r1.next();	 Catch:{ Exception -> 0x005f }
        r0 = (java.lang.Long) r0;	 Catch:{ Exception -> 0x005f }
        r2 = r0.longValue();	 Catch:{ Exception -> 0x005f }
        r4 = r15.icw;	 Catch:{ Exception -> 0x005f }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x005f }
        r0 = "MicroMsg.FileDownloaderImpl23";
        r3 = "updateDownloadStatus";
        com.tencent.mm.sdk.platformtools.x.d(r0, r3);	 Catch:{ Exception -> 0x005f }
        r6 = r2.longValue();	 Catch:{ Exception -> 0x005f }
        r3 = com.tencent.mm.plugin.downloader.model.c.cs(r6);	 Catch:{ Exception -> 0x005f }
        if (r3 == 0) goto L_0x0009;
    L_0x0032:
        r0 = new android.app.DownloadManager$Query;	 Catch:{ Exception -> 0x005f }
        r0.<init>();	 Catch:{ Exception -> 0x005f }
        r5 = 1;
        r5 = new long[r5];	 Catch:{ Exception -> 0x005f }
        r6 = 0;
        r8 = r3.field_sysDownloadId;	 Catch:{ Exception -> 0x005f }
        r5[r6] = r8;	 Catch:{ Exception -> 0x005f }
        r0.setFilterById(r5);	 Catch:{ Exception -> 0x005f }
        r5 = r4.ict;	 Catch:{ Exception -> 0x006b }
        r5 = r5.query(r0);	 Catch:{ Exception -> 0x006b }
        if (r5 != 0) goto L_0x008f;
    L_0x004a:
        r0 = "MicroMsg.FileDownloaderImpl23";
        r5 = "query download status failed: cursor is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r5);	 Catch:{ Exception -> 0x005f }
        r0 = r4.icu;	 Catch:{ Exception -> 0x005f }
        r0.remove(r2);	 Catch:{ Exception -> 0x005f }
        r0 = 4;
        r3.field_status = r0;	 Catch:{ Exception -> 0x005f }
        com.tencent.mm.plugin.downloader.model.c.e(r3);	 Catch:{ Exception -> 0x005f }
        goto L_0x0009;
    L_0x005f:
        r0 = move-exception;
        r1 = "MicroMsg.FileDownloaderImpl23";
        r0 = r0.getMessage();
        com.tencent.mm.sdk.platformtools.x.e(r1, r0);
    L_0x006a:
        return;
    L_0x006b:
        r0 = move-exception;
        r5 = "MicroMsg.FileDownloaderImpl23";
        r6 = "query downloadinfo from downloadmanager failed:%s, sysDownloadId:%d";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x005f }
        r8 = 0;
        r0 = r0.toString();	 Catch:{ Exception -> 0x005f }
        r7[r8] = r0;	 Catch:{ Exception -> 0x005f }
        r0 = 1;
        r7[r0] = r2;	 Catch:{ Exception -> 0x005f }
        com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);	 Catch:{ Exception -> 0x005f }
        r0 = r4.icu;	 Catch:{ Exception -> 0x005f }
        r0.remove(r2);	 Catch:{ Exception -> 0x005f }
        r0 = 4;
        r3.field_status = r0;	 Catch:{ Exception -> 0x005f }
        com.tencent.mm.plugin.downloader.model.c.e(r3);	 Catch:{ Exception -> 0x005f }
        goto L_0x0009;
    L_0x008f:
        r0 = r5.moveToFirst();	 Catch:{ Exception -> 0x005f }
        if (r0 == 0) goto L_0x00cd;
    L_0x0095:
        r0 = "status";
        r0 = r5.getColumnIndex(r0);	 Catch:{ Exception -> 0x005f }
        r6 = "local_uri";
        r6 = r5.getColumnIndex(r6);	 Catch:{ Exception -> 0x005f }
        r7 = "bytes_so_far";
        r7 = r5.getColumnIndex(r7);	 Catch:{ Exception -> 0x005f }
        r8 = "total_size";
        r8 = r5.getColumnIndex(r8);	 Catch:{ Exception -> 0x005f }
        if (r0 == r14) goto L_0x00cd;
    L_0x00b3:
        r0 = r5.getInt(r0);	 Catch:{ Exception -> 0x00f2 }
        r9 = "MicroMsg.FileDownloaderImpl23";
        r10 = "status = %d";
        r11 = 1;
        r11 = new java.lang.Object[r11];	 Catch:{ Exception -> 0x00f2 }
        r12 = 0;
        r13 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x00f2 }
        r11[r12] = r13;	 Catch:{ Exception -> 0x00f2 }
        com.tencent.mm.sdk.platformtools.x.d(r9, r10, r11);	 Catch:{ Exception -> 0x00f2 }
        switch(r0) {
            case 1: goto L_0x00d2;
            case 2: goto L_0x00d2;
            case 4: goto L_0x012a;
            case 8: goto L_0x013f;
            case 16: goto L_0x0112;
            default: goto L_0x00cd;
        };
    L_0x00cd:
        r5.close();	 Catch:{ Exception -> 0x005f }
        goto L_0x0009;
    L_0x00d2:
        if (r7 == r14) goto L_0x00da;
    L_0x00d4:
        r6 = r5.getLong(r7);	 Catch:{ Exception -> 0x00f2 }
        r3.field_downloadedSize = r6;	 Catch:{ Exception -> 0x00f2 }
    L_0x00da:
        if (r8 == r14) goto L_0x00e2;
    L_0x00dc:
        r6 = r5.getLong(r8);	 Catch:{ Exception -> 0x00f2 }
        r3.field_totalSize = r6;	 Catch:{ Exception -> 0x00f2 }
    L_0x00e2:
        r0 = 1;
        r3.field_status = r0;	 Catch:{ Exception -> 0x00f2 }
        com.tencent.mm.plugin.downloader.model.c.e(r3);	 Catch:{ Exception -> 0x00f2 }
        r0 = r4.ibT;	 Catch:{ Exception -> 0x00f2 }
        r6 = r2.longValue();	 Catch:{ Exception -> 0x00f2 }
        r0.cr(r6);	 Catch:{ Exception -> 0x00f2 }
        goto L_0x00cd;
    L_0x00f2:
        r0 = move-exception;
        r4 = r4.icu;	 Catch:{ Exception -> 0x005f }
        r4.remove(r2);	 Catch:{ Exception -> 0x005f }
        r2 = 4;
        r3.field_status = r2;	 Catch:{ Exception -> 0x005f }
        com.tencent.mm.plugin.downloader.model.c.e(r3);	 Catch:{ Exception -> 0x005f }
        r2 = "MicroMsg.FileDownloaderImpl23";
        r3 = "query download info failed: [%s]";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x005f }
        r6 = 0;
        r0 = r0.toString();	 Catch:{ Exception -> 0x005f }
        r4[r6] = r0;	 Catch:{ Exception -> 0x005f }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ Exception -> 0x005f }
        goto L_0x00cd;
    L_0x0112:
        r0 = r4.icu;	 Catch:{ Exception -> 0x00f2 }
        r0.remove(r2);	 Catch:{ Exception -> 0x00f2 }
        r0 = com.tencent.mm.plugin.downloader.a.a.ibr;	 Catch:{ Exception -> 0x00f2 }
        r6 = 4;
        r3.field_status = r6;	 Catch:{ Exception -> 0x00f2 }
        com.tencent.mm.plugin.downloader.model.c.e(r3);	 Catch:{ Exception -> 0x00f2 }
        r6 = r4.ibT;	 Catch:{ Exception -> 0x00f2 }
        r8 = r2.longValue();	 Catch:{ Exception -> 0x00f2 }
        r7 = 0;
        r6.c(r8, r0, r7);	 Catch:{ Exception -> 0x00f2 }
        goto L_0x00cd;
    L_0x012a:
        r0 = r4.icu;	 Catch:{ Exception -> 0x00f2 }
        r0.remove(r2);	 Catch:{ Exception -> 0x00f2 }
        r0 = 2;
        r3.field_status = r0;	 Catch:{ Exception -> 0x00f2 }
        com.tencent.mm.plugin.downloader.model.c.e(r3);	 Catch:{ Exception -> 0x00f2 }
        r0 = r4.ibT;	 Catch:{ Exception -> 0x00f2 }
        r6 = r2.longValue();	 Catch:{ Exception -> 0x00f2 }
        r0.cq(r6);	 Catch:{ Exception -> 0x00f2 }
        goto L_0x00cd;
    L_0x013f:
        r0 = r4.icu;	 Catch:{ Exception -> 0x00f2 }
        r0.remove(r2);	 Catch:{ Exception -> 0x00f2 }
        if (r6 == r14) goto L_0x00cd;
    L_0x0146:
        r0 = r3.field_filePath;	 Catch:{ Exception -> 0x00f2 }
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);	 Catch:{ Exception -> 0x00f2 }
        if (r0 != 0) goto L_0x0156;
    L_0x014e:
        r0 = r3.field_filePath;	 Catch:{ Exception -> 0x00f2 }
        r0 = com.tencent.mm.a.e.cn(r0);	 Catch:{ Exception -> 0x00f2 }
        if (r0 != 0) goto L_0x016f;
    L_0x0156:
        r0 = "MicroMsg.FileDownloaderImpl23";
        r6 = "path not exists, path = %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x00f2 }
        r8 = 0;
        r9 = r3.field_filePath;	 Catch:{ Exception -> 0x00f2 }
        r7[r8] = r9;	 Catch:{ Exception -> 0x00f2 }
        com.tencent.mm.sdk.platformtools.x.e(r0, r6, r7);	 Catch:{ Exception -> 0x00f2 }
        r0 = 4;
        r3.field_status = r0;	 Catch:{ Exception -> 0x00f2 }
        com.tencent.mm.plugin.downloader.model.c.e(r3);	 Catch:{ Exception -> 0x00f2 }
        goto L_0x0009;
    L_0x016f:
        r0 = new android.content.Intent;	 Catch:{ Exception -> 0x00f2 }
        r0.<init>();	 Catch:{ Exception -> 0x00f2 }
        r6 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ Exception -> 0x00f2 }
        r7 = com.tencent.mm.plugin.downloader.model.FileDownloadService.class;
        r0.setClass(r6, r7);	 Catch:{ Exception -> 0x00f2 }
        r6 = com.tencent.mm.plugin.downloader.model.FileDownloadService.EXTRA_ID;	 Catch:{ Exception -> 0x00f2 }
        r8 = r3.field_downloadId;	 Catch:{ Exception -> 0x00f2 }
        r0.putExtra(r6, r8);	 Catch:{ Exception -> 0x00f2 }
        r6 = com.tencent.mm.plugin.downloader.model.FileDownloadService.icm;	 Catch:{ Exception -> 0x00f2 }
        r7 = 1;
        r0.putExtra(r6, r7);	 Catch:{ Exception -> 0x00f2 }
        r6 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ Exception -> 0x00f2 }
        r0 = r6.startService(r0);	 Catch:{ Exception -> 0x00f2 }
        r6 = "MicroMsg.FileDownloaderImpl23";
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00f2 }
        r8 = "start download service: ";
        r7.<init>(r8);	 Catch:{ Exception -> 0x00f2 }
        r8 = r0.getClassName();	 Catch:{ Exception -> 0x00f2 }
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x00f2 }
        r8 = ", ";
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x00f2 }
        r0 = r0.getPackageName();	 Catch:{ Exception -> 0x00f2 }
        r0 = r7.append(r0);	 Catch:{ Exception -> 0x00f2 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00f2 }
        com.tencent.mm.sdk.platformtools.x.d(r6, r0);	 Catch:{ Exception -> 0x00f2 }
        goto L_0x00cd;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.downloader.model.g$3.run():void");
    }
}
