package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.g.a.bc;
import com.tencent.mm.sdk.b.c;

public final class l extends c<bc> {
    public l() {
        this.sFo = bc.class.getName().hashCode();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b r9) {
        /*
        r8 = this;
        r7 = -1;
        r1 = 0;
        r2 = 1;
        r9 = (com.tencent.mm.g.a.bc) r9;
        r0 = r9.bIB;
        r0 = r0.bIC;
        r3 = 42;
        if (r0 != r3) goto L_0x0067;
    L_0x000d:
        r0 = "MicroMsg.FaceModuleResUpdateListener";
        r3 = "hy: new face file update coming. subtype: %d, file path: %s, file version: %d";
        r4 = 3;
        r4 = new java.lang.Object[r4];
        r5 = r9.bIB;
        r5 = r5.bID;
        r5 = java.lang.Integer.valueOf(r5);
        r4[r1] = r5;
        r5 = r9.bIB;
        r5 = r5.filePath;
        r4[r2] = r5;
        r5 = 2;
        r6 = r9.bIB;
        r6 = r6.bIE;
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r0, r3, r4);
        r0 = r9.bIB;
        r3 = r0.bID;
        r0 = r9.bIB;
        r4 = r0.bIE;
        switch(r3) {
            case 0: goto L_0x0068;
            case 1: goto L_0x007f;
            default: goto L_0x003f;
        };
    L_0x003f:
        r0 = "MicroMsg.FaceModuleResUpdateListener";
        r3 = "hy: error subtype";
        com.tencent.mm.sdk.platformtools.x.e(r0, r3);
    L_0x0048:
        r0 = r1;
    L_0x0049:
        if (r0 != 0) goto L_0x00aa;
    L_0x004b:
        r0 = "MicroMsg.FaceModuleResUpdateListener";
        r2 = "hy: get lower version";
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);
        r0 = com.tencent.mm.pluginsdk.g.a.a.b.c.ccr();
        r2 = r9.bIB;
        r2 = r2.bIC;
        r3 = r9.bIB;
        r3 = r3.bID;
        r4 = r9.bIB;
        r4 = r4.bIE;
        r0.ae(r2, r3, r4);
    L_0x0067:
        return r1;
    L_0x0068:
        r0 = com.tencent.mm.model.at.dBv;
        r5 = "LAST_LOGIN_FACE_MODEL_DETECT_VERSION";
        r6 = "-1";
        r0 = r0.I(r5, r6);
        r0 = com.tencent.mm.sdk.platformtools.bi.getInt(r0, r7);
    L_0x0078:
        if (r4 <= r0) goto L_0x0048;
    L_0x007a:
        switch(r3) {
            case 0: goto L_0x0090;
            case 1: goto L_0x009d;
            default: goto L_0x007d;
        };
    L_0x007d:
        r0 = r2;
        goto L_0x0049;
    L_0x007f:
        r0 = com.tencent.mm.model.at.dBv;
        r5 = "LAST_LOGIN_FACE_MODEL_ALIGNMENT_VERSION";
        r6 = "-1";
        r0 = r0.I(r5, r6);
        r0 = com.tencent.mm.sdk.platformtools.bi.getInt(r0, r7);
        goto L_0x0078;
    L_0x0090:
        r0 = com.tencent.mm.model.at.dBv;
        r3 = "LAST_LOGIN_FACE_MODEL_DETECT_VERSION";
        r4 = java.lang.String.valueOf(r4);
        r0.T(r3, r4);
        goto L_0x007d;
    L_0x009d:
        r0 = com.tencent.mm.model.at.dBv;
        r3 = "LAST_LOGIN_FACE_MODEL_ALIGNMENT_VERSION";
        r4 = java.lang.String.valueOf(r4);
        r0.T(r3, r4);
        goto L_0x007d;
    L_0x00aa:
        r0 = r9.bIB;
        r0 = r0.bID;
        if (r0 != 0) goto L_0x00ee;
    L_0x00b0:
        r0 = com.tencent.mm.model.at.dBv;
        r3 = "LAST_LOGIN_FACE_MODEL_SDCARD_PATH_DETECT";
        r4 = r9.bIB;
        r4 = r4.filePath;
        r0.T(r3, r4);
    L_0x00bc:
        r0 = r9.bIB;
        r0 = r0.bID;
        r0 = com.tencent.mm.plugin.facedetect.model.o.pz(r0);
        if (r0 != 0) goto L_0x0135;
    L_0x00c6:
        r0 = "MicroMsg.FaceModuleResUpdateListener";
        r3 = "hy: copy failed. reset version code and path";
        com.tencent.mm.sdk.platformtools.x.w(r0, r3);
        r0 = r9.bIB;
        r0 = r0.bID;
        if (r0 != 0) goto L_0x010b;
    L_0x00d5:
        r0 = com.tencent.mm.model.at.dBv;
        r2 = "LAST_LOGIN_FACE_MODEL_SDCARD_PATH_DETECT";
        r3 = r9.bIB;
        r3 = r3.filePath;
        r0.T(r2, r3);
        r0 = com.tencent.mm.model.at.dBv;
        r2 = "LAST_LOGIN_FACE_MODEL_DETECT_VERSION";
        r3 = "-1";
        r0.T(r2, r3);
        goto L_0x0067;
    L_0x00ee:
        r0 = r9.bIB;
        r0 = r0.bID;
        if (r0 != r2) goto L_0x0101;
    L_0x00f4:
        r0 = com.tencent.mm.model.at.dBv;
        r3 = "LAST_LOGIN_FACE_MODEL_SDCARD_PATH_ALIGNMENT";
        r4 = r9.bIB;
        r4 = r4.filePath;
        r0.T(r3, r4);
        goto L_0x00bc;
    L_0x0101:
        r0 = "MicroMsg.FaceModuleResUpdateListener";
        r3 = "hy: invalid subtype";
        com.tencent.mm.sdk.platformtools.x.e(r0, r3);
        goto L_0x00bc;
    L_0x010b:
        r0 = r9.bIB;
        r0 = r0.bID;
        if (r0 != r2) goto L_0x012a;
    L_0x0111:
        r0 = com.tencent.mm.model.at.dBv;
        r2 = "LAST_LOGIN_FACE_MODEL_SDCARD_PATH_ALIGNMENT";
        r3 = r9.bIB;
        r3 = r3.filePath;
        r0.T(r2, r3);
        r0 = com.tencent.mm.model.at.dBv;
        r2 = "LAST_LOGIN_FACE_MODEL_ALIGNMENT_VERSION";
        r3 = "-1";
        r0.T(r2, r3);
        goto L_0x0067;
    L_0x012a:
        r0 = "MicroMsg.FaceModuleResUpdateListener";
        r2 = "hy: invalid subtype";
        com.tencent.mm.sdk.platformtools.x.e(r0, r2);
        goto L_0x0067;
    L_0x0135:
        r0 = "MicroMsg.FaceModuleResUpdateListener";
        r2 = "hy: load success. mark as not retry";
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);
        r0 = com.tencent.mm.pluginsdk.g.a.a.b.c.ccr();
        r2 = r9.bIB;
        r2 = r2.bIC;
        r3 = r9.bIB;
        r3 = r3.bID;
        r4 = r9.bIB;
        r4 = r4.bIE;
        r0.ae(r2, r3, r4);
        goto L_0x0067;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.facedetect.model.l.a(com.tencent.mm.sdk.b.b):boolean");
    }
}
