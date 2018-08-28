package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.a.c.a;

public final class h extends b {
    public h(a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    public final String MJ(String str) {
        return str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean u(java.io.InputStream r15) {
        /*
        r14 = this;
        r12 = 0;
        r3 = 0;
        r1 = 1;
        r0 = 0;
        r2 = "MicroMsg.SnsDownloadSightForAdShort";
        r4 = "download sight. %s ";
        r5 = new java.lang.Object[r1];
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = r14.nsN;
        r7 = r7.getPath();
        r6 = r6.append(r7);
        r7 = r14.nsN;
        r7 = r7.byY();
        r6 = r6.append(r7);
        r6 = r6.toString();
        r6 = com.tencent.mm.modelsfs.f.mQ(r6);
        r5[r0] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r4, r5);
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r7 = new byte[r2];	 Catch:{ Exception -> 0x00d5, all -> 0x0113 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00d5, all -> 0x0113 }
        r2.<init>();	 Catch:{ Exception -> 0x00d5, all -> 0x0113 }
        r4 = r14.nsN;	 Catch:{ Exception -> 0x00d5, all -> 0x0113 }
        r4 = r4.getPath();	 Catch:{ Exception -> 0x00d5, all -> 0x0113 }
        r2 = r2.append(r4);	 Catch:{ Exception -> 0x00d5, all -> 0x0113 }
        r4 = r14.nsN;	 Catch:{ Exception -> 0x00d5, all -> 0x0113 }
        r4 = r4.byY();	 Catch:{ Exception -> 0x00d5, all -> 0x0113 }
        r2 = r2.append(r4);	 Catch:{ Exception -> 0x00d5, all -> 0x0113 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x00d5, all -> 0x0113 }
        r2 = com.tencent.mm.modelsfs.f.mQ(r2);	 Catch:{ Exception -> 0x00d5, all -> 0x0113 }
        r2 = com.tencent.mm.modelsfs.FileOp.jx(r2);	 Catch:{ Exception -> 0x00d5, all -> 0x0113 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x012a }
        r6 = r14.nsY;	 Catch:{ Exception -> 0x012a }
        r8 = "";
        r6.value = r8;	 Catch:{ Exception -> 0x012a }
        r6 = r0;
    L_0x0068:
        r8 = r15.read(r7);	 Catch:{ Exception -> 0x012a }
        r9 = -1;
        if (r8 == r9) goto L_0x00c5;
    L_0x006f:
        r6 = r14.nsZ;	 Catch:{ Exception -> 0x012a }
        if (r8 <= r6) goto L_0x007b;
    L_0x0073:
        r14.nsZ = r8;	 Catch:{ Exception -> 0x012a }
        r10 = com.tencent.mm.sdk.platformtools.bi.VE();	 Catch:{ Exception -> 0x012a }
        r14.nta = r10;	 Catch:{ Exception -> 0x012a }
    L_0x007b:
        r10 = r14.ntb;	 Catch:{ Exception -> 0x012a }
        r6 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r6 != 0) goto L_0x0089;
    L_0x0081:
        r10 = r14.ntc;	 Catch:{ Exception -> 0x012a }
        r10 = com.tencent.mm.sdk.platformtools.bi.bH(r10);	 Catch:{ Exception -> 0x012a }
        r14.ntb = r10;	 Catch:{ Exception -> 0x012a }
    L_0x0089:
        r6 = com.tencent.mm.plugin.sns.model.af.Gq();	 Catch:{ Exception -> 0x012a }
        r6 = com.tencent.mm.plugin.sns.data.i.LM(r6);	 Catch:{ Exception -> 0x012a }
        if (r6 != 0) goto L_0x00ac;
    L_0x0093:
        r2.close();	 Catch:{ Exception -> 0x012a }
        r15.close();	 Catch:{ Exception -> 0x012a }
        if (r2 == 0) goto L_0x009e;
    L_0x009b:
        r2.close();	 Catch:{ IOException -> 0x009f }
    L_0x009e:
        return r0;
    L_0x009f:
        r1 = move-exception;
        r2 = "MicroMsg.SnsDownloadSightForAdShort";
        r3 = "";
        r4 = new java.lang.Object[r0];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r1, r3, r4);
        goto L_0x009e;
    L_0x00ac:
        r6 = 0;
        r2.write(r7, r6, r8);	 Catch:{ Exception -> 0x012a }
        r6 = r14.nth;	 Catch:{ Exception -> 0x012a }
        r6 = r6 + r8;
        r14.nth = r6;	 Catch:{ Exception -> 0x012a }
        r6 = r14.nth;	 Catch:{ Exception -> 0x012a }
        r8 = r14.nsY;	 Catch:{ Exception -> 0x012a }
        r6 = a(r6, r4, r8);	 Catch:{ Exception -> 0x012a }
        if (r6 == 0) goto L_0x012c;
    L_0x00bf:
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x012a }
        r6 = r0;
        goto L_0x0068;
    L_0x00c5:
        r2.close();	 Catch:{ Exception -> 0x012a }
        if (r6 == 0) goto L_0x00d3;
    L_0x00ca:
        r2 = r14.nth;	 Catch:{ Exception -> 0x00d5, all -> 0x0113 }
        r4 = 0;
        r6 = r14.nsY;	 Catch:{ Exception -> 0x00d5, all -> 0x0113 }
        a(r2, r4, r6);	 Catch:{ Exception -> 0x00d5, all -> 0x0113 }
    L_0x00d3:
        r0 = r1;
        goto L_0x009e;
    L_0x00d5:
        r1 = move-exception;
        r2 = r3;
    L_0x00d7:
        r3 = "MicroMsg.SnsDownloadSightForAdShort";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0128 }
        r5 = "snscdndownload fail : ";
        r4.<init>(r5);	 Catch:{ all -> 0x0128 }
        r5 = r1.getMessage();	 Catch:{ all -> 0x0128 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x0128 }
        r4 = r4.toString();	 Catch:{ all -> 0x0128 }
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0128 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r1, r4, r5);	 Catch:{ all -> 0x0128 }
        r3 = "MicroMsg.SnsDownloadSightForAdShort";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0128 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r1, r4, r5);	 Catch:{ all -> 0x0128 }
        if (r2 == 0) goto L_0x009e;
    L_0x0102:
        r2.close();	 Catch:{ IOException -> 0x0106 }
        goto L_0x009e;
    L_0x0106:
        r1 = move-exception;
        r2 = "MicroMsg.SnsDownloadSightForAdShort";
        r3 = "";
        r4 = new java.lang.Object[r0];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r1, r3, r4);
        goto L_0x009e;
    L_0x0113:
        r1 = move-exception;
        r2 = r3;
    L_0x0115:
        if (r2 == 0) goto L_0x011a;
    L_0x0117:
        r2.close();	 Catch:{ IOException -> 0x011b }
    L_0x011a:
        throw r1;
    L_0x011b:
        r2 = move-exception;
        r3 = "MicroMsg.SnsDownloadSightForAdShort";
        r4 = "";
        r0 = new java.lang.Object[r0];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r0);
        goto L_0x011a;
    L_0x0128:
        r1 = move-exception;
        goto L_0x0115;
    L_0x012a:
        r1 = move-exception;
        goto L_0x00d7;
    L_0x012c:
        r6 = r1;
        goto L_0x0068;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.model.a.h.u(java.io.InputStream):boolean");
    }

    public final boolean bza() {
        FileOp.i(this.nsN.getPath(), this.nsN.byY(), i.j(this.caK));
        return true;
    }

    protected final int bzb() {
        return 2;
    }
}
