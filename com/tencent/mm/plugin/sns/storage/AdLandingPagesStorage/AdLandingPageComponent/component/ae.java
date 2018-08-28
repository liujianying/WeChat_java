package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.AsyncTask;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashSet;
import java.util.Set;

public final class ae extends AsyncTask<String, Void, Void> {
    private static Set<String> nGe = new HashSet();
    private static byte[] nGf = new byte[0];
    final String fileName;
    final String filePath;
    final ag handler;
    final String nGg;
    final String nGh;
    final String nGi;
    final a nGj;
    final int nGk;
    private boolean nGl;
    private int nGm;
    private int scene = 0;

    public ae(String str, String str2, boolean z, int i, ag agVar, a aVar) {
        FileOp.mL(str);
        this.nGi = str;
        this.fileName = str2;
        this.filePath = str + "/" + str2;
        this.nGl = z;
        this.nGm = i;
        this.nGh = "temp_" + str2;
        this.nGg = str + "/" + this.nGh;
        this.handler = agVar;
        this.nGk = 409600;
        this.nGj = new 1(this, agVar, aVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Void y(java.lang.String... r13) {
        /*
        r12 = this;
        r0 = r12.filePath;
        r0 = com.tencent.mm.modelsfs.FileOp.cn(r0);
        if (r0 == 0) goto L_0x0011;
    L_0x0008:
        r0 = r12.nGj;
        r1 = r12.filePath;
        r0.MZ(r1);
        r0 = 0;
    L_0x0010:
        return r0;
    L_0x0011:
        r1 = nGf;
        monitor-enter(r1);
        r0 = nGe;	 Catch:{ all -> 0x0022 }
        r2 = 0;
        r2 = r13[r2];	 Catch:{ all -> 0x0022 }
        r0 = r0.contains(r2);	 Catch:{ all -> 0x0022 }
        if (r0 == 0) goto L_0x0025;
    L_0x001f:
        r0 = 0;
        monitor-exit(r1);	 Catch:{ all -> 0x0022 }
        goto L_0x0010;
    L_0x0022:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0022 }
        throw r0;
    L_0x0025:
        r0 = nGe;	 Catch:{ all -> 0x0022 }
        r2 = 0;
        r2 = r13[r2];	 Catch:{ all -> 0x0022 }
        r0.add(r2);	 Catch:{ all -> 0x0022 }
        monitor-exit(r1);	 Catch:{ all -> 0x0022 }
        r10 = com.tencent.mm.sdk.platformtools.bi.VF();
        r7 = 0;
        r6 = 0;
        r4 = 0;
        r3 = 0;
        r2 = 0;
        r0 = r12.nGg;	 Catch:{ Exception -> 0x0321, all -> 0x0458 }
        r0 = com.tencent.mm.modelsfs.FileOp.cn(r0);	 Catch:{ Exception -> 0x0321, all -> 0x0458 }
        if (r0 == 0) goto L_0x0044;
    L_0x003f:
        r0 = r12.nGg;	 Catch:{ Exception -> 0x0321, all -> 0x0458 }
        com.tencent.mm.modelsfs.FileOp.deleteFile(r0);	 Catch:{ Exception -> 0x0321, all -> 0x0458 }
    L_0x0044:
        r0 = new java.net.URL;	 Catch:{ Exception -> 0x0321, all -> 0x0458 }
        r1 = 0;
        r1 = r13[r1];	 Catch:{ Exception -> 0x0321, all -> 0x0458 }
        r0.<init>(r1);	 Catch:{ Exception -> 0x0321, all -> 0x0458 }
        r0 = r0.openConnection();	 Catch:{ Exception -> 0x0321, all -> 0x0458 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x0321, all -> 0x0458 }
        r0.connect();	 Catch:{ Exception -> 0x05b9, all -> 0x0598 }
        r8 = r0.getResponseCode();	 Catch:{ Exception -> 0x05b9, all -> 0x0598 }
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r8 == r1) goto L_0x01a5;
    L_0x005d:
        r1 = r12.nGj;	 Catch:{ Exception -> 0x05bf, all -> 0x059e }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x05bf, all -> 0x059e }
        r5 = "Server returned HTTP ";
        r2.<init>(r5);	 Catch:{ Exception -> 0x05bf, all -> 0x059e }
        r5 = r0.getResponseCode();	 Catch:{ Exception -> 0x05bf, all -> 0x059e }
        r2 = r2.append(r5);	 Catch:{ Exception -> 0x05bf, all -> 0x059e }
        r5 = " ";
        r2 = r2.append(r5);	 Catch:{ Exception -> 0x05bf, all -> 0x059e }
        r5 = r0.getResponseMessage();	 Catch:{ Exception -> 0x05bf, all -> 0x059e }
        r2 = r2.append(r5);	 Catch:{ Exception -> 0x05bf, all -> 0x059e }
        r2 = r2.toString();	 Catch:{ Exception -> 0x05bf, all -> 0x059e }
        r1.MY(r2);	 Catch:{ Exception -> 0x05bf, all -> 0x059e }
        if (r0 == 0) goto L_0x008a;
    L_0x0087:
        r0.disconnect();
    L_0x008a:
        r1 = nGf;
        monitor-enter(r1);
        r0 = nGe;	 Catch:{ all -> 0x019f }
        r2 = 0;
        r2 = r13[r2];	 Catch:{ all -> 0x019f }
        r0.remove(r2);	 Catch:{ all -> 0x019f }
        monitor-exit(r1);	 Catch:{ all -> 0x019f }
        r0 = 0;
        r0 = r13[r0];
        r0 = com.tencent.mm.sdk.platformtools.ac.ce(r0);
        r1 = r12.bzb();
        r2 = com.tencent.mm.sdk.platformtools.bi.bH(r10);
        r2 = (int) r2;
        r3 = new com.tencent.mm.modelsns.d;
        r3.<init>();
        r4 = "20UrlMd5";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r0 = r5.append(r0);
        r5 = ",";
        r0 = r0.append(r5);
        r0 = r0.toString();
        r3.r(r4, r0);
        r0 = "21MediaType";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r1 = r4.append(r1);
        r4 = ",";
        r1 = r1.append(r4);
        r1 = r1.toString();
        r3.r(r0, r1);
        r1 = "22IsPreload";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r0 = r12.nGl;
        if (r0 == 0) goto L_0x01a2;
    L_0x00eb:
        r0 = 1;
    L_0x00ec:
        r0 = r4.append(r0);
        r4 = ",";
        r0 = r0.append(r4);
        r0 = r0.toString();
        r3.r(r1, r0);
        r0 = "23CostTime";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r2);
        r2 = ",";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r3.r(r0, r1);
        r0 = "24RetCode";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r8);
        r2 = ",";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r3.r(r0, r1);
        r0 = "25Scene";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r12.scene;
        r1 = r1.append(r2);
        r2 = ",";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r3.r(r0, r1);
        r0 = "26Size";
        r1 = "0,";
        r3.r(r0, r1);
        r0 = "27StartDownloadTime";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r10 / r4;
        r1 = r1.append(r4);
        r2 = ",";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r3.r(r0, r1);
        r0 = "MicroMsg.LandingpageDowloadAsynTask";
        r1 = new java.lang.StringBuilder;
        r2 = "report logbuffer MM_KVSTAT_AdDownload(13572): ";
        r1.<init>(r2);
        r2 = r3.wF();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = com.tencent.mm.plugin.report.service.h.mEJ;
        r1 = 13572; // 0x3504 float:1.9018E-41 double:6.7055E-320;
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r4 = 0;
        r2[r4] = r3;
        r0.h(r1, r2);
        r0 = 0;
        goto L_0x0010;
    L_0x019f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x019f }
        throw r0;
    L_0x01a2:
        r0 = 0;
        goto L_0x00ec;
    L_0x01a5:
        r0.getContentLength();	 Catch:{ Exception -> 0x05bf, all -> 0x059e }
        r5 = r0.getInputStream();	 Catch:{ Exception -> 0x05bf, all -> 0x059e }
        r4 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x05c4, all -> 0x05a3 }
        r1 = r12.nGg;	 Catch:{ Exception -> 0x05c4, all -> 0x05a3 }
        r4.<init>(r1);	 Catch:{ Exception -> 0x05c4, all -> 0x05a3 }
        r1 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r3 = new byte[r1];	 Catch:{ Exception -> 0x05c8, all -> 0x05a7 }
        r2 = 0;
        r1 = 0;
        r7 = r2;
    L_0x01ba:
        r2 = r5.read(r3);	 Catch:{ Exception -> 0x05c8, all -> 0x05a7 }
        r9 = -1;
        if (r2 == r9) goto L_0x01da;
    L_0x01c1:
        r9 = 0;
        r4.write(r3, r9, r2);	 Catch:{ Exception -> 0x05c8, all -> 0x05a7 }
        r2 = r2 + r7;
        r7 = r12.nGk;	 Catch:{ Exception -> 0x05c8, all -> 0x05a7 }
        if (r7 == 0) goto L_0x05d6;
    L_0x01ca:
        r7 = r2 - r1;
        r9 = r12.nGk;	 Catch:{ Exception -> 0x05c8, all -> 0x05a7 }
        if (r7 < r9) goto L_0x05d6;
    L_0x01d0:
        r1 = r12.nGj;	 Catch:{ Exception -> 0x05c8, all -> 0x05a7 }
        r7 = r12.nGg;	 Catch:{ Exception -> 0x05c8, all -> 0x05a7 }
        r1.cg(r7, r2);	 Catch:{ Exception -> 0x05c8, all -> 0x05a7 }
        r1 = r2;
        r7 = r2;
        goto L_0x01ba;
    L_0x01da:
        r1 = r12.nGg;	 Catch:{ Exception -> 0x05cd, all -> 0x05ac }
        r2 = r12.filePath;	 Catch:{ Exception -> 0x05cd, all -> 0x05ac }
        com.tencent.mm.modelsfs.FileOp.av(r1, r2);	 Catch:{ Exception -> 0x05cd, all -> 0x05ac }
        r1 = r12.nGj;	 Catch:{ Exception -> 0x05cd, all -> 0x05ac }
        r2 = r12.filePath;	 Catch:{ Exception -> 0x05cd, all -> 0x05ac }
        r1.MZ(r2);	 Catch:{ Exception -> 0x05cd, all -> 0x05ac }
        r4.close();	 Catch:{ IOException -> 0x05d3 }
        if (r5 == 0) goto L_0x01f0;
    L_0x01ed:
        r5.close();	 Catch:{ IOException -> 0x05d3 }
    L_0x01f0:
        if (r0 == 0) goto L_0x01f5;
    L_0x01f2:
        r0.disconnect();
    L_0x01f5:
        r1 = nGf;
        monitor-enter(r1);
        r0 = nGe;	 Catch:{ all -> 0x031b }
        r2 = 0;
        r2 = r13[r2];	 Catch:{ all -> 0x031b }
        r0.remove(r2);	 Catch:{ all -> 0x031b }
        monitor-exit(r1);	 Catch:{ all -> 0x031b }
        r0 = 0;
        r0 = r13[r0];
        r0 = com.tencent.mm.sdk.platformtools.ac.ce(r0);
        r1 = r12.bzb();
        r2 = com.tencent.mm.sdk.platformtools.bi.bH(r10);
        r2 = (int) r2;
        r3 = new com.tencent.mm.modelsns.d;
        r3.<init>();
        r4 = "20UrlMd5";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r0 = r5.append(r0);
        r5 = ",";
        r0 = r0.append(r5);
        r0 = r0.toString();
        r3.r(r4, r0);
        r0 = "21MediaType";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r1 = r4.append(r1);
        r4 = ",";
        r1 = r1.append(r4);
        r1 = r1.toString();
        r3.r(r0, r1);
        r1 = "22IsPreload";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r0 = r12.nGl;
        if (r0 == 0) goto L_0x031e;
    L_0x0256:
        r0 = 1;
    L_0x0257:
        r0 = r4.append(r0);
        r4 = ",";
        r0 = r0.append(r4);
        r0 = r0.toString();
        r3.r(r1, r0);
        r0 = "23CostTime";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r2);
        r2 = ",";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r3.r(r0, r1);
        r0 = "24RetCode";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r8);
        r2 = ",";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r3.r(r0, r1);
        r0 = "25Scene";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r12.scene;
        r1 = r1.append(r2);
        r2 = ",";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r3.r(r0, r1);
        r0 = "26Size";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r7);
        r2 = ",";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r3.r(r0, r1);
        r0 = "27StartDownloadTime";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r10 / r4;
        r1 = r1.append(r4);
        r2 = ",";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r3.r(r0, r1);
        r0 = "MicroMsg.LandingpageDowloadAsynTask";
        r1 = new java.lang.StringBuilder;
        r2 = "report logbuffer MM_KVSTAT_AdDownload(13572): ";
        r1.<init>(r2);
        r2 = r3.wF();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = com.tencent.mm.plugin.report.service.h.mEJ;
        r1 = 13572; // 0x3504 float:1.9018E-41 double:6.7055E-320;
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r4 = 0;
        r2[r4] = r3;
        r0.h(r1, r2);
        r0 = 0;
        goto L_0x0010;
    L_0x031b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x031b }
        throw r0;
    L_0x031e:
        r0 = 0;
        goto L_0x0257;
    L_0x0321:
        r0 = move-exception;
        r1 = r0;
        r5 = r4;
        r8 = r7;
    L_0x0325:
        r0 = r12.nGj;	 Catch:{ all -> 0x05b2 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x05b2 }
        r0.MY(r1);	 Catch:{ all -> 0x05b2 }
        if (r3 == 0) goto L_0x0333;
    L_0x0330:
        r3.close();	 Catch:{ IOException -> 0x05b6 }
    L_0x0333:
        if (r5 == 0) goto L_0x0338;
    L_0x0335:
        r5.close();	 Catch:{ IOException -> 0x05b6 }
    L_0x0338:
        if (r2 == 0) goto L_0x033d;
    L_0x033a:
        r2.disconnect();
    L_0x033d:
        r1 = nGf;
        monitor-enter(r1);
        r0 = nGe;	 Catch:{ all -> 0x0452 }
        r2 = 0;
        r2 = r13[r2];	 Catch:{ all -> 0x0452 }
        r0.remove(r2);	 Catch:{ all -> 0x0452 }
        monitor-exit(r1);	 Catch:{ all -> 0x0452 }
        r0 = 0;
        r0 = r13[r0];
        r0 = com.tencent.mm.sdk.platformtools.ac.ce(r0);
        r1 = r12.bzb();
        r2 = com.tencent.mm.sdk.platformtools.bi.bH(r10);
        r2 = (int) r2;
        r3 = new com.tencent.mm.modelsns.d;
        r3.<init>();
        r4 = "20UrlMd5";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r0 = r5.append(r0);
        r5 = ",";
        r0 = r0.append(r5);
        r0 = r0.toString();
        r3.r(r4, r0);
        r0 = "21MediaType";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r1 = r4.append(r1);
        r4 = ",";
        r1 = r1.append(r4);
        r1 = r1.toString();
        r3.r(r0, r1);
        r1 = "22IsPreload";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r0 = r12.nGl;
        if (r0 == 0) goto L_0x0455;
    L_0x039e:
        r0 = 1;
    L_0x039f:
        r0 = r4.append(r0);
        r4 = ",";
        r0 = r0.append(r4);
        r0 = r0.toString();
        r3.r(r1, r0);
        r0 = "23CostTime";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r2);
        r2 = ",";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r3.r(r0, r1);
        r0 = "24RetCode";
        r1 = "-1,";
        r3.r(r0, r1);
        r0 = "25Scene";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r12.scene;
        r1 = r1.append(r2);
        r2 = ",";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r3.r(r0, r1);
        r0 = "26Size";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r6);
        r2 = ",";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r3.r(r0, r1);
        r0 = "27StartDownloadTime";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r10 / r4;
        r1 = r1.append(r4);
        r2 = ",";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r3.r(r0, r1);
        r0 = "MicroMsg.LandingpageDowloadAsynTask";
        r1 = new java.lang.StringBuilder;
        r2 = "report logbuffer MM_KVSTAT_AdDownload(13572): ";
        r1.<init>(r2);
        r2 = r3.wF();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = com.tencent.mm.plugin.report.service.h.mEJ;
        r1 = 13572; // 0x3504 float:1.9018E-41 double:6.7055E-320;
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r4 = 0;
        r2[r4] = r3;
        r0.h(r1, r2);
        r0 = 0;
        goto L_0x0010;
    L_0x0452:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0452 }
        throw r0;
    L_0x0455:
        r0 = 0;
        goto L_0x039f;
    L_0x0458:
        r0 = move-exception;
        r1 = r0;
        r5 = r4;
        r8 = r7;
    L_0x045c:
        if (r3 == 0) goto L_0x0461;
    L_0x045e:
        r3.close();	 Catch:{ IOException -> 0x0595 }
    L_0x0461:
        if (r5 == 0) goto L_0x0466;
    L_0x0463:
        r5.close();	 Catch:{ IOException -> 0x0595 }
    L_0x0466:
        if (r2 == 0) goto L_0x046b;
    L_0x0468:
        r2.disconnect();
    L_0x046b:
        r2 = nGf;
        monitor-enter(r2);
        r0 = nGe;	 Catch:{ all -> 0x058f }
        r3 = 0;
        r3 = r13[r3];	 Catch:{ all -> 0x058f }
        r0.remove(r3);	 Catch:{ all -> 0x058f }
        monitor-exit(r2);	 Catch:{ all -> 0x058f }
        r0 = 0;
        r0 = r13[r0];
        r0 = com.tencent.mm.sdk.platformtools.ac.ce(r0);
        r2 = r12.bzb();
        r4 = com.tencent.mm.sdk.platformtools.bi.bH(r10);
        r3 = (int) r4;
        r4 = new com.tencent.mm.modelsns.d;
        r4.<init>();
        r5 = "20UrlMd5";
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r0 = r7.append(r0);
        r7 = ",";
        r0 = r0.append(r7);
        r0 = r0.toString();
        r4.r(r5, r0);
        r0 = "21MediaType";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r2 = r5.append(r2);
        r5 = ",";
        r2 = r2.append(r5);
        r2 = r2.toString();
        r4.r(r0, r2);
        r2 = "22IsPreload";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r0 = r12.nGl;
        if (r0 == 0) goto L_0x0592;
    L_0x04cc:
        r0 = 1;
    L_0x04cd:
        r0 = r5.append(r0);
        r5 = ",";
        r0 = r0.append(r5);
        r0 = r0.toString();
        r4.r(r2, r0);
        r0 = "23CostTime";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r3);
        r3 = ",";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r4.r(r0, r2);
        r0 = "24RetCode";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r8);
        r3 = ",";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r4.r(r0, r2);
        r0 = "25Scene";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r12.scene;
        r2 = r2.append(r3);
        r3 = ",";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r4.r(r0, r2);
        r0 = "26Size";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r6);
        r3 = ",";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r4.r(r0, r2);
        r0 = "27StartDownloadTime";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r10 / r6;
        r2 = r2.append(r6);
        r3 = ",";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r4.r(r0, r2);
        r0 = "MicroMsg.LandingpageDowloadAsynTask";
        r2 = new java.lang.StringBuilder;
        r3 = "report logbuffer MM_KVSTAT_AdDownload(13572): ";
        r2.<init>(r3);
        r3 = r4.wF();
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);
        r0 = com.tencent.mm.plugin.report.service.h.mEJ;
        r2 = 13572; // 0x3504 float:1.9018E-41 double:6.7055E-320;
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r5 = 0;
        r3[r5] = r4;
        r0.h(r2, r3);
        throw r1;
    L_0x058f:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x058f }
        throw r0;
    L_0x0592:
        r0 = 0;
        goto L_0x04cd;
    L_0x0595:
        r0 = move-exception;
        goto L_0x0466;
    L_0x0598:
        r1 = move-exception;
        r2 = r0;
        r5 = r4;
        r8 = r7;
        goto L_0x045c;
    L_0x059e:
        r1 = move-exception;
        r2 = r0;
        r5 = r4;
        goto L_0x045c;
    L_0x05a3:
        r1 = move-exception;
        r2 = r0;
        goto L_0x045c;
    L_0x05a7:
        r1 = move-exception;
        r2 = r0;
        r3 = r4;
        goto L_0x045c;
    L_0x05ac:
        r1 = move-exception;
        r2 = r0;
        r3 = r4;
        r6 = r7;
        goto L_0x045c;
    L_0x05b2:
        r0 = move-exception;
        r1 = r0;
        goto L_0x045c;
    L_0x05b6:
        r0 = move-exception;
        goto L_0x0338;
    L_0x05b9:
        r1 = move-exception;
        r2 = r0;
        r5 = r4;
        r8 = r7;
        goto L_0x0325;
    L_0x05bf:
        r1 = move-exception;
        r2 = r0;
        r5 = r4;
        goto L_0x0325;
    L_0x05c4:
        r1 = move-exception;
        r2 = r0;
        goto L_0x0325;
    L_0x05c8:
        r1 = move-exception;
        r2 = r0;
        r3 = r4;
        goto L_0x0325;
    L_0x05cd:
        r1 = move-exception;
        r2 = r0;
        r3 = r4;
        r6 = r7;
        goto L_0x0325;
    L_0x05d3:
        r1 = move-exception;
        goto L_0x01f0;
    L_0x05d6:
        r7 = r2;
        goto L_0x01ba;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae.y(java.lang.String[]):java.lang.Void");
    }

    private int bzb() {
        switch (this.nGm) {
            case s$l.AppCompatTheme_textAppearanceSmallPopupMenu /*41*/:
            case s$l.AppCompatTheme_listDividerAlertDialog /*44*/:
            case s$l.AppCompatTheme_actionDropDownStyle /*45*/:
            case 1000000001:
                return 1;
            case s$l.AppCompatTheme_popupWindowStyle /*61*/:
                return 2;
            case s$l.AppCompatTheme_editTextColor /*62*/:
                return 3;
            default:
                return 0;
        }
    }
}
