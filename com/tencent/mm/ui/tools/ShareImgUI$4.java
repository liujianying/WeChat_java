package com.tencent.mm.ui.tools;

import android.os.Bundle;

class ShareImgUI$4 implements Runnable {
    final /* synthetic */ Bundle fZl;
    final /* synthetic */ ShareImgUI uBN;
    final /* synthetic */ ShareImgUI$b uBO;
    final /* synthetic */ long uBP;

    ShareImgUI$4(ShareImgUI shareImgUI, Bundle bundle, ShareImgUI$b shareImgUI$b, long j) {
        this.uBN = shareImgUI;
        this.fZl = bundle;
        this.uBO = shareImgUI$b;
        this.uBP = j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r11 = this;
        r9 = 1;
        r6 = 0;
        r10 = 0;
        r0 = r11.fZl;
        r1 = "android.intent.extra.STREAM";
        r0 = r0.getParcelableArrayList(r1);
        if (r0 == 0) goto L_0x00a4;
    L_0x000e:
        r1 = r0.size();
        if (r1 <= 0) goto L_0x00a4;
    L_0x0014:
        r2 = new java.util.ArrayList;
        r2.<init>();
        r5 = new java.util.concurrent.CountDownLatch;
        r1 = r0.size();
        r5.<init>(r1);
        r4 = new boolean[r9];
        r4[r10] = r10;
        r7 = r0.iterator();
    L_0x002a:
        r0 = r7.hasNext();
        if (r0 == 0) goto L_0x0054;
    L_0x0030:
        r3 = r7.next();
        r3 = (android.os.Parcelable) r3;
        r0 = new com.tencent.mm.ui.tools.ShareImgUI$4$1;
        r1 = r11;
        r0.<init>(r1, r2, r3, r4, r5);
        r1 = new java.lang.StringBuilder;
        r8 = "getMultiSendFilePathListItem";
        r1.<init>(r8);
        r3 = r3.toString();
        r1 = r1.append(r3);
        r1 = r1.toString();
        com.tencent.mm.sdk.f.e.post(r0, r1);
        goto L_0x002a;
    L_0x0054:
        r5.await();	 Catch:{ InterruptedException -> 0x006d }
    L_0x0057:
        r0 = r4[r10];
        if (r0 == 0) goto L_0x0081;
    L_0x005b:
        r0 = "MicroMsg.ShareImgUI";
        r1 = "hy: has non path img";
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r1 = r11.uBN;
        r0 = r11.uBO;
    L_0x0068:
        r2 = r6;
    L_0x0069:
        com.tencent.mm.ui.tools.ShareImgUI.a(r1, r0, r2);
    L_0x006c:
        return;
    L_0x006d:
        r0 = move-exception;
        r1 = "MicroMsg.ShareImgUI";
        r3 = "hy: timeout when getmulti";
        r5 = new java.lang.Object[r10];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r3, r5);
        r0 = r11.uBN;
        r1 = r11.uBO;
        com.tencent.mm.ui.tools.ShareImgUI.a(r0, r1, r6);
        goto L_0x0057;
    L_0x0081:
        r0 = "MicroMsg.ShareImgUI";
        r1 = "hy: getMultiSendFilePathList done. using: %d ms";
        r3 = new java.lang.Object[r9];
        r4 = java.lang.System.currentTimeMillis();
        r8 = r11.uBP;
        r4 = r4 - r8;
        r4 = java.lang.Long.valueOf(r4);
        r3[r10] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r3);
        r1 = r11.uBN;
        r0 = r11.uBO;
        r3 = r2.size();
        if (r3 <= 0) goto L_0x0068;
    L_0x00a3:
        goto L_0x0069;
    L_0x00a4:
        r0 = "MicroMsg.ShareImgUI";
        r1 = "getParcelableArrayList failed";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = r11.uBN;
        r1 = r11.uBO;
        com.tencent.mm.ui.tools.ShareImgUI.a(r0, r1, r6);
        goto L_0x006c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.tools.ShareImgUI$4.run():void");
    }
}
