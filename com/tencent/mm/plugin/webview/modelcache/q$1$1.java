package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.plugin.webview.modelcache.downloaderimpl.f;
import com.tencent.mm.plugin.webview.modelcache.q.1;

class q$1$1 implements Runnable {
    final /* synthetic */ f pTt;
    final /* synthetic */ 1 pTu;

    q$1$1(1 1, f fVar) {
        this.pTu = 1;
        this.pTt = fVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r14 = this;
        r8 = r14.pTt;
        if (r8 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r8.appId;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x001d;
    L_0x000d:
        r0 = r8.cfx;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x001d;
    L_0x0015:
        r0 = r8.filePath;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 == 0) goto L_0x002d;
    L_0x001d:
        r0 = "MicroMsg.WebViewCacheDownloadResponseLogic";
        r1 = "onResponse, invalid response = %s";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r2[r3] = r8;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        goto L_0x0004;
    L_0x002d:
        r0 = "MicroMsg.WebViewCacheDownloadResponseLogic";
        r1 = "onResponse, response = %s";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r2[r3] = r8;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        r0 = com.tencent.mm.plugin.webview.modelcache.q.a.bUL();
        r0 = r0.pTp;
        r1 = r8.url;
        r2 = r8.appId;
        r3 = r8.cfx;
        r4 = r8.cfy;
        r9 = r0.q(r1, r2, r3, r4);
        r0 = r8.exception;
        if (r0 == 0) goto L_0x00f9;
    L_0x0052:
        r1 = "MicroMsg.WebViewCacheDownloadResponseLogic";
        r2 = "onResponse, response.exception = %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r3[r4] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);
        r1 = com.tencent.mm.sdk.platformtools.bi.cX(r9);
        if (r1 != 0) goto L_0x00ef;
    L_0x0067:
        r1 = r0 instanceof java.net.SocketTimeoutException;
        if (r1 == 0) goto L_0x00ae;
    L_0x006b:
        r0 = "timeout";
        r7 = r0;
    L_0x006f:
        r10 = r9.iterator();
    L_0x0073:
        r0 = r10.hasNext();
        if (r0 == 0) goto L_0x00ef;
    L_0x0079:
        r0 = r10.next();
        r1 = r0;
        r1 = (com.tencent.mm.plugin.webview.modelcache.e.c) r1;
        r0 = r1.pSV;
        r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bh(r0);
        r3 = r1.pSW;
        r0 = r8.cfz;
        r4 = 3;
        if (r0 != r4) goto L_0x00d7;
    L_0x008d:
        r0 = "publicCache";
    L_0x0090:
        r2.A(r3, r0, r7);
        r0 = r8.cfz;
        r2 = 1;
        if (r0 != r2) goto L_0x00db;
    L_0x0098:
        r0 = com.tencent.mm.plugin.webview.modelcache.q.a.bUL();
        r0 = r0.pTp;
        r1 = r1.pSV;
        r2 = r8.appId;
        r3 = r8.cfx;
        r4 = r8.cfy;
        r5 = r8.cfz;
        r6 = r8.url;
        r0.a(r1, r2, r3, r4, r5, r6);
        goto L_0x0073;
    L_0x00ae:
        r1 = r0 instanceof com.tencent.mm.pluginsdk.g.a.b.d;
        if (r1 == 0) goto L_0x00b7;
    L_0x00b2:
        r0 = "not support redirect resource";
        r7 = r0;
        goto L_0x006f;
    L_0x00b7:
        r1 = r0 instanceof com.tencent.mm.pluginsdk.g.a.b.g;
        if (r1 == 0) goto L_0x00c0;
    L_0x00bb:
        r0 = "not support 0kb resource";
        r7 = r0;
        goto L_0x006f;
    L_0x00c0:
        r0 = r0 instanceof com.tencent.mm.pluginsdk.g.a.b.a;
        if (r0 == 0) goto L_0x00d2;
    L_0x00c4:
        r0 = r8.cfA;
        r2 = 5242880; // 0x500000 float:7.34684E-39 double:2.590327E-317;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 < 0) goto L_0x00d2;
    L_0x00cd:
        r0 = "exceed cache threshold";
        r7 = r0;
        goto L_0x006f;
    L_0x00d2:
        r0 = "batch download fail";
        r7 = r0;
        goto L_0x006f;
    L_0x00d7:
        r0 = "cache";
        goto L_0x0090;
    L_0x00db:
        r0 = com.tencent.mm.plugin.webview.modelcache.q.a.bUL();
        r0 = r0.pTp;
        r1 = r1.pSV;
        r2 = r8.appId;
        r3 = r8.cfx;
        r4 = r8.cfy;
        r5 = r8.cfz;
        r0.b(r1, r2, r3, r4, r5);
        goto L_0x0073;
    L_0x00ef:
        r0 = 1;
    L_0x00f0:
        if (r0 == 0) goto L_0x00fb;
    L_0x00f2:
        r0 = 7;
        com.tencent.mm.plugin.webview.modelcache.m.fC(r0);
        goto L_0x0004;
    L_0x00f9:
        r0 = 0;
        goto L_0x00f0;
    L_0x00fb:
        r0 = r8.filePath;
        r0 = com.tencent.mm.a.e.cm(r0);
        if (r0 != 0) goto L_0x015d;
    L_0x0103:
        r0 = "MicroMsg.WebViewCacheDownloadResponseLogic";
        r1 = "onResponse, readFileLength = 0, return";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = com.tencent.mm.sdk.platformtools.bi.cX(r9);
        if (r0 != 0) goto L_0x0153;
    L_0x0112:
        r7 = r9.iterator();
    L_0x0116:
        r0 = r7.hasNext();
        if (r0 == 0) goto L_0x0153;
    L_0x011c:
        r0 = r7.next();
        r1 = r0;
        r1 = (com.tencent.mm.plugin.webview.modelcache.e.c) r1;
        r0 = r1.pSV;
        r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bh(r0);
        r3 = r1.pSW;
        r0 = r8.cfz;
        r4 = 3;
        if (r0 != r4) goto L_0x014f;
    L_0x0130:
        r0 = "publicCache";
    L_0x0133:
        r4 = "batch download fail";
        r2.A(r3, r0, r4);
        r0 = com.tencent.mm.plugin.webview.modelcache.q.a.bUL();
        r0 = r0.pTp;
        r1 = r1.pSV;
        r2 = r8.appId;
        r3 = r8.cfx;
        r4 = r8.cfy;
        r5 = r8.cfz;
        r6 = r8.url;
        r0.a(r1, r2, r3, r4, r5, r6);
        goto L_0x0116;
    L_0x014f:
        r0 = "cache";
        goto L_0x0133;
    L_0x0153:
        r0 = 0;
    L_0x0154:
        if (r0 != 0) goto L_0x036c;
    L_0x0156:
        r0 = 8;
        com.tencent.mm.plugin.webview.modelcache.m.fC(r0);
        goto L_0x0004;
    L_0x015d:
        r0 = r8.url;
        r4 = com.tencent.mm.plugin.webview.modelcache.p.QE(r0);
        r6 = com.tencent.mm.plugin.webview.modelcache.q.a.bUL();
        r1 = r8.appId;
        r2 = r8.cfx;
        r3 = r8.cfz;
        r5 = r8.cfy;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r0 != 0) goto L_0x0181;
    L_0x0175:
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r0 != 0) goto L_0x0181;
    L_0x017b:
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r4);
        if (r0 == 0) goto L_0x01fe;
    L_0x0181:
        r0 = "MicroMsg.WebViewCacheWorkerManager";
        r3 = "getWebViewCacheWriter, invalid params | appId = %s, domain = %s, mainURL = %s";
        r5 = 3;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r5[r6] = r1;
        r1 = 1;
        r5[r1] = r2;
        r1 = 2;
        r5[r1] = r4;
        com.tencent.mm.sdk.platformtools.x.e(r0, r3, r5);
        r0 = 0;
        r3 = r0;
    L_0x0198:
        r0 = 0;
        if (r3 == 0) goto L_0x01b4;
    L_0x019b:
        r0 = r8.filePath;
        r4 = r8.version;
        r5 = r8.aBC;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r1 == 0) goto L_0x0233;
    L_0x01a7:
        r0 = "MicroMsg.WebViewCacheResWriter";
        r1 = "writeRes with filePath, filePath is null or nil";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = -1;
    L_0x01b1:
        if (r0 != 0) goto L_0x0349;
    L_0x01b3:
        r0 = 1;
    L_0x01b4:
        if (r0 != 0) goto L_0x0369;
    L_0x01b6:
        r0 = com.tencent.mm.sdk.platformtools.bi.cX(r9);
        if (r0 != 0) goto L_0x0366;
    L_0x01bc:
        r7 = r9.iterator();
    L_0x01c0:
        r0 = r7.hasNext();
        if (r0 == 0) goto L_0x0366;
    L_0x01c6:
        r0 = r7.next();
        r1 = r0;
        r1 = (com.tencent.mm.plugin.webview.modelcache.e.c) r1;
        r0 = r1.pSV;
        r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bh(r0);
        r3 = r1.pSW;
        r0 = r8.cfz;
        r4 = 3;
        if (r0 != r4) goto L_0x034c;
    L_0x01da:
        r0 = "publicCache";
    L_0x01dd:
        r4 = "batch save fail";
        r2.A(r3, r0, r4);
        r0 = r8.cfz;
        r2 = 1;
        if (r0 != r2) goto L_0x0351;
    L_0x01e8:
        r0 = com.tencent.mm.plugin.webview.modelcache.q.a.bUL();
        r0 = r0.pTp;
        r1 = r1.pSV;
        r2 = r8.appId;
        r3 = r8.cfx;
        r4 = r8.cfy;
        r5 = r8.cfz;
        r6 = r8.url;
        r0.a(r1, r2, r3, r4, r5, r6);
        goto L_0x01c0;
    L_0x01fe:
        r0 = "%s_%s_%s_%s";
        r7 = 4;
        r7 = new java.lang.Object[r7];
        r10 = 0;
        r7[r10] = r1;
        r10 = 1;
        r7[r10] = r2;
        r10 = 2;
        r11 = java.lang.Integer.valueOf(r3);
        r7[r10] = r11;
        r10 = 3;
        r7[r10] = r4;
        r0 = java.lang.String.format(r0, r7);
        r7 = r0.hashCode();
        r0 = r6.pTn;
        r0 = r0.get(r7);
        r0 = (com.tencent.mm.plugin.webview.modelcache.l) r0;
        if (r0 != 0) goto L_0x0230;
    L_0x0226:
        r0 = new com.tencent.mm.plugin.webview.modelcache.l;
        r0.<init>(r1, r2, r3, r4, r5);
        r1 = r6.pTn;
        r1.put(r7, r0);
    L_0x0230:
        r3 = r0;
        goto L_0x0198;
    L_0x0233:
        r1 = com.tencent.mm.a.e.cn(r0);
        if (r1 != 0) goto L_0x0245;
    L_0x0239:
        r0 = "MicroMsg.WebViewCacheResWriter";
        r1 = "writeRes with filePath, file not exists";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = -1;
        goto L_0x01b1;
    L_0x0245:
        r1 = com.tencent.mm.a.e.cm(r0);
        if (r1 > 0) goto L_0x0257;
    L_0x024b:
        r0 = "MicroMsg.WebViewCacheResWriter";
        r1 = "writeRes with filePath, file size = 0kb";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = 6;
        goto L_0x01b1;
    L_0x0257:
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r4);
        if (r1 == 0) goto L_0x0269;
    L_0x025d:
        r0 = "MicroMsg.WebViewCacheResWriter";
        r1 = "writeRes with filePath, resVersion is null or nil, return";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = -1;
        goto L_0x01b1;
    L_0x0269:
        r1 = r3.pTb;
        if (r1 != 0) goto L_0x0279;
    L_0x026d:
        r0 = "MicroMsg.WebViewCacheResWriter";
        r1 = "writeRes with filePath, appIdDir is null, return";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = -1;
        goto L_0x01b1;
    L_0x0279:
        r2 = r3.pTb;
        r6 = r3.bVd;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r1 != 0) goto L_0x0289;
    L_0x0283:
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r6);
        if (r1 == 0) goto L_0x02c4;
    L_0x0289:
        r0 = 0;
    L_0x028b:
        r6 = com.tencent.mm.plugin.webview.modelcache.k.bUI();
        r7 = r3.appId;
        r10 = r3.cfx;
        r11 = r3.cfz;
        r12 = r3.pTa;
        r13 = r3.cfy;
        r2 = r6.fAQ;
        if (r2 == 0) goto L_0x031c;
    L_0x029d:
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r7);
        if (r2 != 0) goto L_0x02b5;
    L_0x02a3:
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r10);
        if (r2 != 0) goto L_0x02b5;
    L_0x02a9:
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r12);
        if (r2 != 0) goto L_0x02b5;
    L_0x02af:
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r13);
        if (r2 == 0) goto L_0x02de;
    L_0x02b5:
        r2 = 0;
    L_0x02b6:
        if (r2 != 0) goto L_0x031e;
    L_0x02b8:
        r0 = "MicroMsg.WebViewCacheResWriter";
        r1 = "writeRes with filePath, no db record stored";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = -1;
        goto L_0x01b1;
    L_0x02c4:
        r0 = com.tencent.mm.modelsfs.FileOp.y(r0, r6);
        r10 = 0;
        r7 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1));
        if (r7 <= 0) goto L_0x028b;
    L_0x02ce:
        r7 = r2.path;
        r6 = r6.startsWith(r7);
        if (r6 == 0) goto L_0x028b;
    L_0x02d6:
        r6 = r2.pSM;
        r2 = r2.appId;
        com.tencent.mm.plugin.webview.modelcache.a.b.a(r6, r2, r0);
        goto L_0x028b;
    L_0x02de:
        r2 = new com.tencent.mm.plugin.webview.modelcache.f;
        r2.<init>();
        r2.field_appId = r7;
        r2.field_domain = r10;
        r2.field_cacheType = r11;
        r7 = com.tencent.mm.sdk.platformtools.ac.ce(r12);
        r7 = r7.hashCode();
        r2.field_urlMd5Hashcode = r7;
        r2.field_packageId = r13;
        r7 = 5;
        r7 = new java.lang.String[r7];
        r10 = 0;
        r11 = "appId";
        r7[r10] = r11;
        r10 = 1;
        r11 = "domain";
        r7[r10] = r11;
        r10 = 2;
        r11 = "cacheType";
        r7[r10] = r11;
        r10 = 3;
        r11 = "urlMd5Hashcode";
        r7[r10] = r11;
        r10 = 4;
        r11 = "packageId";
        r7[r10] = r11;
        r6 = r6.b(r2, r7);
        if (r6 != 0) goto L_0x02b6;
    L_0x031c:
        r2 = 0;
        goto L_0x02b6;
    L_0x031e:
        r3 = r3.bVd;
        r2.field_localPath = r3;
        r2.field_version = r4;
        r2.field_contentType = r5;
        r3 = r2.field_localPath;
        r3 = com.tencent.mm.plugin.webview.modelcache.p.QH(r3);
        r2.field_contentMd5 = r3;
        r2.field_contentLength = r0;
        r0 = com.tencent.mm.plugin.webview.modelcache.k.bUI();
        r0.b(r2);
        r0 = "MicroMsg.WebViewCacheResWriter";
        r1 = "writeRes with filePath, updated record = %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r3[r4] = r2;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r3);
        r0 = 0;
        goto L_0x01b1;
    L_0x0349:
        r0 = 0;
        goto L_0x01b4;
    L_0x034c:
        r0 = "cache";
        goto L_0x01dd;
    L_0x0351:
        r0 = com.tencent.mm.plugin.webview.modelcache.q.a.bUL();
        r0 = r0.pTp;
        r1 = r1.pSV;
        r2 = r8.appId;
        r3 = r8.cfx;
        r4 = r8.cfy;
        r5 = r8.cfz;
        r0.b(r1, r2, r3, r4, r5);
        goto L_0x01c0;
    L_0x0366:
        r0 = 0;
        goto L_0x0154;
    L_0x0369:
        r0 = 1;
        goto L_0x0154;
    L_0x036c:
        r0 = r8.cfz;
        r1 = 1;
        if (r0 != r1) goto L_0x03af;
    L_0x0371:
        r0 = com.tencent.mm.sdk.platformtools.bi.cX(r9);
        if (r0 != 0) goto L_0x0004;
    L_0x0377:
        r7 = r9.iterator();
    L_0x037b:
        r0 = r7.hasNext();
        if (r0 == 0) goto L_0x0004;
    L_0x0381:
        r0 = r7.next();
        r1 = r0;
        r1 = (com.tencent.mm.plugin.webview.modelcache.e.c) r1;
        r0 = r1.pSV;
        r0 = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bh(r0);
        r2 = r1.pSW;
        r3 = "cache";
        r4 = "ok";
        r0.A(r2, r3, r4);
        r0 = com.tencent.mm.plugin.webview.modelcache.q.a.bUL();
        r0 = r0.pTp;
        r1 = r1.pSV;
        r2 = r8.appId;
        r3 = r8.cfx;
        r4 = r8.cfy;
        r5 = r8.cfz;
        r6 = r8.url;
        r0.a(r1, r2, r3, r4, r5, r6);
        goto L_0x037b;
    L_0x03af:
        r0 = com.tencent.mm.plugin.webview.modelcache.k.bUI();
        r1 = r8.appId;
        r2 = r8.cfx;
        r3 = r8.cfy;
        r4 = r0.fAQ;
        if (r4 != 0) goto L_0x0419;
    L_0x03bd:
        r0 = 0;
    L_0x03be:
        r1 = com.tencent.mm.sdk.platformtools.bi.cX(r0);
        if (r1 != 0) goto L_0x0004;
    L_0x03c4:
        r2 = 1;
        r3 = r0.iterator();
    L_0x03c9:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x0496;
    L_0x03cf:
        r0 = r3.next();
        r0 = (com.tencent.mm.plugin.webview.modelcache.f) r0;
        if (r0 != 0) goto L_0x0461;
    L_0x03d7:
        r1 = 0;
    L_0x03d8:
        if (r1 != 0) goto L_0x03c9;
    L_0x03da:
        r0 = 0;
    L_0x03db:
        if (r0 == 0) goto L_0x0004;
    L_0x03dd:
        r0 = com.tencent.mm.sdk.platformtools.bi.cX(r9);
        if (r0 != 0) goto L_0x0004;
    L_0x03e3:
        r6 = r9.iterator();
    L_0x03e7:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x0004;
    L_0x03ed:
        r0 = r6.next();
        r1 = r0;
        r1 = (com.tencent.mm.plugin.webview.modelcache.e.c) r1;
        r0 = r1.pSV;
        r0 = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bh(r0);
        r2 = r1.pSW;
        r3 = "cache";
        r4 = "ok";
        r0.A(r2, r3, r4);
        r0 = com.tencent.mm.plugin.webview.modelcache.q.a.bUL();
        r0 = r0.pTp;
        r1 = r1.pSV;
        r2 = r8.appId;
        r3 = r8.cfx;
        r4 = r8.cfy;
        r5 = r8.cfz;
        r0.b(r1, r2, r3, r4, r5);
        goto L_0x03e7;
    L_0x0419:
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r4 != 0) goto L_0x042b;
    L_0x041f:
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r4 != 0) goto L_0x042b;
    L_0x0425:
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r3);
        if (r4 == 0) goto L_0x042d;
    L_0x042b:
        r0 = 0;
        goto L_0x03be;
    L_0x042d:
        r4 = "select * from %s where %s=? and %s=? and %s=?";
        r5 = 4;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = "WebViewResourceCache";
        r5[r6] = r7;
        r6 = 1;
        r7 = "appId";
        r5[r6] = r7;
        r6 = 2;
        r7 = "domain";
        r5[r6] = r7;
        r6 = 3;
        r7 = "packageId";
        r5[r6] = r7;
        r4 = java.lang.String.format(r4, r5);
        r5 = 3;
        r5 = new java.lang.String[r5];
        r6 = 0;
        r5[r6] = r1;
        r1 = 1;
        r5[r1] = r2;
        r1 = 2;
        r5[r1] = r3;
        r0 = r0.n(r4, r5);
        goto L_0x03be;
    L_0x0461:
        r1 = r0.field_contentMd5;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r1 != 0) goto L_0x0494;
    L_0x0469:
        r1 = r0.field_localPath;
        r1 = com.tencent.mm.plugin.webview.modelcache.p.QH(r1);
        r1 = com.tencent.mm.sdk.platformtools.bi.oV(r1);
        r4 = r0.field_contentMd5;
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x0494;
    L_0x047b:
        r1 = 1;
    L_0x047c:
        r4 = "MicroMsg.WebViewCacheUtils";
        r5 = "isCacheResValid, cacheRes = %s, ret = %b";
        r6 = 2;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r6[r7] = r0;
        r0 = 1;
        r7 = java.lang.Boolean.valueOf(r1);
        r6[r0] = r7;
        com.tencent.mm.sdk.platformtools.x.d(r4, r5, r6);
        goto L_0x03d8;
    L_0x0494:
        r1 = 0;
        goto L_0x047c;
    L_0x0496:
        r0 = r2;
        goto L_0x03db;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.modelcache.q$1$1.run():void");
    }
}
