package com.tencent.mm.plugin.wear.model.e;

import com.tencent.liteav.network.TXCStreamUploader;
import java.util.ArrayList;
import java.util.List;

public final class g extends a {
    public final List<Integer> bSy() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_HANDSHAKE_FAIL));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_FAILED));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_SERVER_REFUSE));
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final byte[] p(int r10, byte[] r11) {
        /*
        r9 = this;
        r8 = -1;
        r1 = 0;
        r6 = 1;
        r7 = 0;
        r0 = 11005; // 0x2afd float:1.5421E-41 double:5.437E-320;
        if (r10 != r0) goto L_0x006c;
    L_0x0008:
        r0 = new com.tencent.mm.protocal.c.cdp;
        r0.<init>();
        r0.aG(r11);	 Catch:{ IOException -> 0x0042 }
    L_0x0010:
        r2 = new com.tencent.mm.protocal.c.cdq;
        r2.<init>();
        r3 = r0.rdS;
        r3 = com.tencent.mm.plugin.wear.model.h.PO(r3);
        if (r3 == 0) goto L_0x005c;
    L_0x001d:
        r4 = java.lang.System.currentTimeMillis();
        r2.sza = r4;
        r3 = com.tencent.mm.plugin.wear.model.h.N(r3);
        r4 = "MicroMsg.Wear.HttpImageServer";
        r5 = "return avatar data username=%s";
        r6 = new java.lang.Object[r6];
        r0 = r0.rdS;
        r6[r7] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);
        r0 = new com.tencent.mm.bk.b;
        r0.<init>(r3);
        r2.hbs = r0;
        r1 = r2.toByteArray();	 Catch:{ IOException -> 0x004f }
    L_0x0041:
        return r1;
    L_0x0042:
        r2 = move-exception;
        r3 = "MicroMsg.Wear.HttpImageServer";
        r4 = "";
        r5 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0010;
    L_0x004f:
        r0 = move-exception;
        r2 = "MicroMsg.Wear.HttpImageServer";
        r3 = "";
        r4 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r0, r3, r4);
        goto L_0x0041;
    L_0x005c:
        r2 = "MicroMsg.Wear.HttpImageServer";
        r3 = "get avatar fail, %s";
        r4 = new java.lang.Object[r6];
        r0 = r0.rdS;
        r4[r7] = r0;
        com.tencent.mm.sdk.platformtools.x.w(r2, r3, r4);
        goto L_0x0041;
    L_0x006c:
        r0 = 11006; // 0x2afe float:1.5423E-41 double:5.4377E-320;
        if (r10 != r0) goto L_0x00f7;
    L_0x0070:
        r2 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x009d }
        r0 = "utf8";
        r2.<init>(r11, r0);	 Catch:{ UnsupportedEncodingException -> 0x009d }
        r0 = com.tencent.mm.plugin.emoji.b.c.class;
        r0 = com.tencent.mm.kernel.g.n(r0);
        r0 = (com.tencent.mm.plugin.emoji.b.c) r0;
        r0 = r0.getEmojiMgr();
        r2 = r0.zi(r2);
        if (r2 == 0) goto L_0x0041;
    L_0x008a:
        r0 = r2.aaq();
        if (r0 == 0) goto L_0x00aa;
    L_0x0090:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r0 = r2.gj(r0);
        r1 = com.tencent.mm.plugin.wear.model.h.N(r0);
        goto L_0x0041;
    L_0x009d:
        r0 = move-exception;
        r2 = "MicroMsg.Wear.HttpImageServer";
        r3 = "";
        r4 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r0, r3, r4);
        goto L_0x0041;
    L_0x00aa:
        r0 = r2.field_catalog;
        r3 = com.tencent.mm.storage.emotion.EmojiGroupInfo.tcy;
        if (r0 != r3) goto L_0x00e5;
    L_0x00b0:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ Exception -> 0x00c5, all -> 0x00df }
        r2 = r2.getName();	 Catch:{ Exception -> 0x00c5, all -> 0x00df }
        r2 = com.tencent.mm.storage.emotion.EmojiInfo.bt(r0, r2);	 Catch:{ Exception -> 0x00c5, all -> 0x00df }
        r1 = com.tencent.mm.a.e.g(r2);	 Catch:{ Exception -> 0x020a }
        com.tencent.mm.a.e.f(r2);
        goto L_0x0041;
    L_0x00c5:
        r0 = move-exception;
        r2 = r1;
    L_0x00c7:
        r3 = "MicroMsg.Wear.HttpImageServer";
        r4 = "exception:%s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0207 }
        r6 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);	 Catch:{ all -> 0x0207 }
        r5[r6] = r0;	 Catch:{ all -> 0x0207 }
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);	 Catch:{ all -> 0x0207 }
        com.tencent.mm.a.e.f(r2);
        goto L_0x0041;
    L_0x00df:
        r0 = move-exception;
        r2 = r1;
    L_0x00e1:
        com.tencent.mm.a.e.f(r2);
        throw r0;
    L_0x00e5:
        r0 = com.tencent.mm.plugin.emoji.b.c.class;
        r0 = com.tencent.mm.kernel.g.n(r0);
        r0 = (com.tencent.mm.plugin.emoji.b.c) r0;
        r0 = r0.getEmojiMgr();
        r1 = r0.a(r2);
        goto L_0x0041;
    L_0x00f7:
        r0 = 11007; // 0x2aff float:1.5424E-41 double:5.438E-320;
        if (r10 != r0) goto L_0x0041;
    L_0x00fb:
        r0 = new com.tencent.mm.protocal.c.ceh;
        r0.<init>();
        r0.aG(r11);	 Catch:{ IOException -> 0x0140 }
    L_0x0103:
        com.tencent.mm.model.au.HU();
        r2 = com.tencent.mm.model.c.FT();
        r4 = r0.szl;
        r2 = r2.dW(r4);
        r0 = r0.szp;
        if (r0 != 0) goto L_0x014d;
    L_0x0114:
        r0 = com.tencent.mm.ak.o.Pf();
        r2 = r2.field_imgPath;
        r0 = r0.lN(r2);
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r2 != 0) goto L_0x0041;
    L_0x0124:
        r2 = new com.tencent.mm.protocal.c.cei;
        r2.<init>();
        r4 = java.lang.System.currentTimeMillis();
        r2.sza = r4;
        r3 = new com.tencent.mm.bk.b;
        r0 = com.tencent.mm.modelsfs.FileOp.e(r0, r7, r8);
        r3.<init>(r0);
        r2.hbs = r3;
        r1 = r2.toByteArray();	 Catch:{ IOException -> 0x0201 }
        goto L_0x0041;
    L_0x0140:
        r2 = move-exception;
        r3 = "MicroMsg.Wear.HttpImageServer";
        r4 = "";
        r5 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0103;
    L_0x014d:
        r3 = new com.tencent.mm.protocal.c.cei;
        r3.<init>();
        r4 = java.lang.System.currentTimeMillis();
        r3.sza = r4;
        r0 = r2.field_isSend;
        if (r0 != r6) goto L_0x01b1;
    L_0x015c:
        r0 = com.tencent.mm.ak.o.Pf();
        r4 = r2.field_msgId;
        r2 = r0.br(r4);
        r0 = com.tencent.mm.ak.o.Pf();
        r4 = com.tencent.mm.ak.o.Pf();
        r4 = r4.d(r2);
        r5 = "";
        r6 = "";
        r0 = r0.o(r4, r5, r6);
        r4 = com.tencent.mm.modelsfs.FileOp.cn(r0);
        if (r4 == 0) goto L_0x0199;
    L_0x0182:
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r2 != 0) goto L_0x0041;
    L_0x0188:
        r2 = new com.tencent.mm.bk.b;
        r0 = com.tencent.mm.modelsfs.FileOp.e(r0, r7, r8);
        r2.<init>(r0);
        r3.hbs = r2;
        r1 = r3.toByteArray();	 Catch:{ IOException -> 0x0204 }
        goto L_0x0041;
    L_0x0199:
        r0 = com.tencent.mm.ak.o.Pf();
        r2 = r2.dTL;
        r4 = "";
        r5 = "";
        r0 = r0.o(r2, r4, r5);
        r2 = com.tencent.mm.modelsfs.FileOp.cn(r0);
        if (r2 != 0) goto L_0x0182;
    L_0x01af:
        r0 = r1;
        goto L_0x0182;
    L_0x01b1:
        r0 = com.tencent.mm.ak.o.Pf();
        r4 = r2.field_msgSvrId;
        r2 = r0.bq(r4);
        r0 = r2.OM();
        if (r0 == 0) goto L_0x01af;
    L_0x01c1:
        r0 = r2.ON();
        if (r0 == 0) goto L_0x020d;
    L_0x01c7:
        r0 = com.tencent.mm.ak.o.Pf();
        r4 = com.tencent.mm.ak.o.Pf();
        r4 = r4.d(r2);
        r5 = "";
        r6 = "";
        r0 = r0.o(r4, r5, r6);
        r4 = com.tencent.mm.modelsfs.FileOp.cn(r0);
        if (r4 == 0) goto L_0x020d;
    L_0x01e3:
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r4 == 0) goto L_0x0182;
    L_0x01e9:
        r4 = com.tencent.mm.ak.o.Pf();
        r2 = r2.dTL;
        r5 = "";
        r6 = "";
        r2 = r4.o(r2, r5, r6);
        r4 = com.tencent.mm.modelsfs.FileOp.cn(r2);
        if (r4 == 0) goto L_0x0182;
    L_0x01ff:
        r0 = r2;
        goto L_0x0182;
    L_0x0201:
        r0 = move-exception;
        goto L_0x0041;
    L_0x0204:
        r0 = move-exception;
        goto L_0x0041;
    L_0x0207:
        r0 = move-exception;
        goto L_0x00e1;
    L_0x020a:
        r0 = move-exception;
        goto L_0x00c7;
    L_0x020d:
        r0 = r1;
        goto L_0x01e3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wear.model.e.g.p(int, byte[]):byte[]");
    }
}
