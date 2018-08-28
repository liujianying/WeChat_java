package com.tencent.smtt.sdk;

import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;

class bb implements ReaderCallback {
    final /* synthetic */ TbsReaderView a;

    bb(TbsReaderView tbsReaderView) {
        this.a = tbsReaderView;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCallBackAction(java.lang.Integer r7, java.lang.Object r8, java.lang.Object r9) {
        /*
        r6 = this;
        r5 = 0;
        r1 = 5011; // 0x1393 float:7.022E-42 double:2.476E-320;
        r2 = 4;
        r3 = 0;
        r0 = r7.intValue();
        switch(r0) {
            case 5008: goto L_0x001c;
            case 5009: goto L_0x007d;
            case 5010: goto L_0x00de;
            case 5026: goto L_0x0138;
            case 5030: goto L_0x019a;
            default: goto L_0x000c;
        };
    L_0x000c:
        r0 = r6.a;
        r0 = r0.d;
        if (r0 == 0) goto L_0x001b;
    L_0x0012:
        if (r3 != 0) goto L_0x001b;
    L_0x0014:
        r0 = r6.a;
        r0 = r0.d;
        r0.onCallBackAction(r7, r8, r9);
    L_0x001b:
        return;
    L_0x001c:
        r0 = r6.a;
        r0 = r0.a;
        r0 = com.tencent.smtt.sdk.a.d.c(r0);
        if (r0 != 0) goto L_0x0059;
    L_0x0026:
        r7 = java.lang.Integer.valueOf(r1);
        r0 = r6.a;
        r0 = r0.a;
        r1 = 5023; // 0x139f float:7.039E-42 double:2.4817E-320;
        r0 = com.tencent.smtt.sdk.TbsReaderView.getResString(r0, r1);
        r8 = new android.os.Bundle;
        r8.<init>();
        r1 = "tip";
        r8.putString(r1, r0);
        r0 = "statistics";
        r1 = "AHNG812";
        r8.putString(r0, r1);
        r0 = "channel_id";
        r1 = 10834; // 0x2a52 float:1.5182E-41 double:5.3527E-320;
        r8.putInt(r0, r1);
        r0 = r6.a;
        r1 = "AHNG811";
        r0.userStatistics(r1);
        goto L_0x000c;
    L_0x0059:
        r1 = "";
        if (r8 == 0) goto L_0x0069;
    L_0x005e:
        r0 = r8;
        r0 = (android.os.Bundle) r0;
        r1 = "docpath";
        r1 = r0.getString(r1);
        r5 = r0;
    L_0x0069:
        r0 = r6.a;
        r0 = r0.a;
        r4 = "pdf";
        com.tencent.smtt.sdk.QbSdk.startQBForDoc(r0, r1, r2, r3, r4, r5);
        r0 = r6.a;
        r1 = "AHNG813";
        r0.userStatistics(r1);
    L_0x007b:
        r3 = 1;
        goto L_0x000c;
    L_0x007d:
        r0 = r6.a;
        r0 = r0.a;
        r0 = com.tencent.smtt.sdk.a.d.c(r0);
        if (r0 != 0) goto L_0x00bb;
    L_0x0087:
        r7 = java.lang.Integer.valueOf(r1);
        r0 = r6.a;
        r0 = r0.a;
        r1 = 5021; // 0x139d float:7.036E-42 double:2.4807E-320;
        r0 = com.tencent.smtt.sdk.TbsReaderView.getResString(r0, r1);
        r8 = new android.os.Bundle;
        r8.<init>();
        r1 = "tip";
        r8.putString(r1, r0);
        r0 = "statistics";
        r1 = "AHNG808";
        r8.putString(r0, r1);
        r0 = "channel_id";
        r1 = 10833; // 0x2a51 float:1.518E-41 double:5.352E-320;
        r8.putInt(r0, r1);
        r0 = r6.a;
        r1 = "AHNG807";
        r0.userStatistics(r1);
        goto L_0x000c;
    L_0x00bb:
        r1 = "";
        if (r8 == 0) goto L_0x00cb;
    L_0x00c0:
        r0 = r8;
        r0 = (android.os.Bundle) r0;
        r1 = "docpath";
        r1 = r0.getString(r1);
        r5 = r0;
    L_0x00cb:
        r0 = r6.a;
        r0 = r0.a;
        r4 = "";
        com.tencent.smtt.sdk.QbSdk.startQBForDoc(r0, r1, r2, r3, r4, r5);
        r0 = r6.a;
        r1 = "AHNG809";
        r0.userStatistics(r1);
        goto L_0x007b;
    L_0x00de:
        r0 = r6.a;
        r0 = r0.a;
        r0 = com.tencent.smtt.sdk.a.d.c(r0);
        if (r0 != 0) goto L_0x011c;
    L_0x00e8:
        r7 = java.lang.Integer.valueOf(r1);
        r0 = r6.a;
        r0 = r0.a;
        r1 = 5022; // 0x139e float:7.037E-42 double:2.481E-320;
        r0 = com.tencent.smtt.sdk.TbsReaderView.getResString(r0, r1);
        r8 = new android.os.Bundle;
        r8.<init>();
        r1 = "tip";
        r8.putString(r1, r0);
        r0 = "statistics";
        r1 = "AHNG816";
        r8.putString(r0, r1);
        r0 = "channel_id";
        r1 = 10835; // 0x2a53 float:1.5183E-41 double:5.353E-320;
        r8.putInt(r0, r1);
        r0 = r6.a;
        r1 = "AHNG815";
        r0.userStatistics(r1);
        goto L_0x000c;
    L_0x011c:
        r1 = "";
        if (r8 == 0) goto L_0x012c;
    L_0x0121:
        r0 = r8;
        r0 = (android.os.Bundle) r0;
        r1 = "docpath";
        r1 = r0.getString(r1);
        r5 = r0;
    L_0x012c:
        r0 = r6.a;
        r0 = r0.a;
        r4 = "txt";
        com.tencent.smtt.sdk.QbSdk.startQBForDoc(r0, r1, r2, r3, r4, r5);
        goto L_0x007b;
    L_0x0138:
        r0 = r6.a;
        r0 = r0.a;
        r0 = com.tencent.smtt.sdk.a.d.c(r0);
        if (r0 != 0) goto L_0x0176;
    L_0x0142:
        r7 = java.lang.Integer.valueOf(r1);
        r0 = r6.a;
        r0 = r0.a;
        r1 = 5029; // 0x13a5 float:7.047E-42 double:2.4847E-320;
        r0 = com.tencent.smtt.sdk.TbsReaderView.getResString(r0, r1);
        r8 = new android.os.Bundle;
        r8.<init>();
        r1 = "tip";
        r8.putString(r1, r0);
        r0 = "statistics";
        r1 = "AHNG828";
        r8.putString(r0, r1);
        r0 = "channel_id";
        r1 = 10965; // 0x2ad5 float:1.5365E-41 double:5.4174E-320;
        r8.putInt(r0, r1);
        r0 = r6.a;
        r1 = "AHNG827";
        r0.userStatistics(r1);
        goto L_0x000c;
    L_0x0176:
        r1 = "";
        if (r8 == 0) goto L_0x0186;
    L_0x017b:
        r0 = r8;
        r0 = (android.os.Bundle) r0;
        r1 = "docpath";
        r1 = r0.getString(r1);
        r5 = r0;
    L_0x0186:
        r0 = r6.a;
        r0 = r0.a;
        r4 = "doc";
        com.tencent.smtt.sdk.QbSdk.startQBForDoc(r0, r1, r2, r3, r4, r5);
        r0 = r6.a;
        r1 = "AHNG829";
        r0.userStatistics(r1);
        goto L_0x007b;
    L_0x019a:
        if (r8 == 0) goto L_0x007b;
    L_0x019c:
        r0 = r8;
        r0 = (android.os.Bundle) r0;
        r1 = "name";
        r1 = r0.getString(r1);
        com.tencent.smtt.sdk.TbsReaderView.gReaderPackName = r1;
        r1 = "version";
        r0 = r0.getString(r1);
        com.tencent.smtt.sdk.TbsReaderView.gReaderPackVersion = r0;
        goto L_0x007b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.bb.onCallBackAction(java.lang.Integer, java.lang.Object, java.lang.Object):void");
    }
}
