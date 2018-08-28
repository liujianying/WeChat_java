package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.la;
import com.tencent.mm.sdk.b.c;

class OnlineVideoView$5 extends c<la> {
    final /* synthetic */ OnlineVideoView nPH;

    OnlineVideoView$5(OnlineVideoView onlineVideoView) {
        this.nPH = onlineVideoView;
        this.sFo = la.class.getName().hashCode();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(com.tencent.mm.g.a.la r14) {
        /*
        r13 = this;
        r3 = 2;
        r2 = 1;
        r12 = 0;
        r0 = r13.nPH;
        r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.k(r0);
        if (r0 != 0) goto L_0x0023;
    L_0x000b:
        r0 = "MicroMsg.OnlineVideoView";
        r1 = "%d online video helper is null.";
        r2 = new java.lang.Object[r2];
        r3 = r13.nPH;
        r3 = r3.hashCode();
        r3 = java.lang.Integer.valueOf(r3);
        r2[r12] = r3;
        com.tencent.mm.sdk.platformtools.x.w(r0, r1, r2);
    L_0x0022:
        return r12;
    L_0x0023:
        r0 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.k(r0);	 Catch:{ Exception -> 0x0054 }
        r1 = r14.bVm;	 Catch:{ Exception -> 0x0054 }
        r1 = r1.mediaId;	 Catch:{ Exception -> 0x0054 }
        r0 = r0.NS(r1);	 Catch:{ Exception -> 0x0054 }
        if (r0 == 0) goto L_0x0022;
    L_0x0033:
        r0 = r14.bVm;	 Catch:{ Exception -> 0x0054 }
        r0 = r0.retCode;	 Catch:{ Exception -> 0x0054 }
        r1 = -21112; // 0xffffffffffffad88 float:NaN double:NaN;
        if (r0 != r1) goto L_0x0070;
    L_0x003b:
        r0 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        r1 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ Exception -> 0x0054 }
        r2 = 354; // 0x162 float:4.96E-43 double:1.75E-321;
        r4 = 218; // 0xda float:3.05E-43 double:1.077E-321;
        r6 = 1;
        r8 = 0;
        r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x0054 }
        r1 = r0.hDf;	 Catch:{ Exception -> 0x0054 }
        r2 = new com.tencent.mm.plugin.sns.ui.OnlineVideoView$9;	 Catch:{ Exception -> 0x0054 }
        r2.<init>(r0);	 Catch:{ Exception -> 0x0054 }
        r1.post(r2);	 Catch:{ Exception -> 0x0054 }
        goto L_0x0022;
    L_0x0054:
        r0 = move-exception;
        r1 = "MicroMsg.OnlineVideoView";
        r2 = new java.lang.StringBuilder;
        r3 = "online video callback error: ";
        r2.<init>(r3);
        r0 = r0.toString();
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.x.e(r1, r0);
        goto L_0x0022;
    L_0x0070:
        r0 = r14.bVm;	 Catch:{ Exception -> 0x0054 }
        r0 = r0.retCode;	 Catch:{ Exception -> 0x0054 }
        if (r0 == 0) goto L_0x00a3;
    L_0x0076:
        r0 = r14.bVm;	 Catch:{ Exception -> 0x0054 }
        r0 = r0.retCode;	 Catch:{ Exception -> 0x0054 }
        r1 = -21006; // 0xffffffffffffadf2 float:NaN double:NaN;
        if (r0 == r1) goto L_0x00a3;
    L_0x007e:
        r0 = "MicroMsg.OnlineVideoView";
        r1 = "%d stream download online video error. retCode %d ";
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0054 }
        r3 = 0;
        r4 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        r4 = r4.hashCode();	 Catch:{ Exception -> 0x0054 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0054 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0054 }
        r3 = 1;
        r4 = r14.bVm;	 Catch:{ Exception -> 0x0054 }
        r4 = r4.retCode;	 Catch:{ Exception -> 0x0054 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0054 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0054 }
        com.tencent.mm.sdk.platformtools.x.w(r0, r1, r2);	 Catch:{ Exception -> 0x0054 }
        goto L_0x0022;
    L_0x00a3:
        r0 = r14.bVm;	 Catch:{ Exception -> 0x0054 }
        r0 = r0.bOh;	 Catch:{ Exception -> 0x0054 }
        switch(r0) {
            case 1: goto L_0x00d0;
            case 2: goto L_0x0205;
            case 3: goto L_0x02c9;
            case 4: goto L_0x02d1;
            case 5: goto L_0x03c4;
            case 6: goto L_0x043f;
            default: goto L_0x00aa;
        };	 Catch:{ Exception -> 0x0054 }
    L_0x00aa:
        r0 = "MicroMsg.OnlineVideoView";
        r1 = "%d unknown event opcode %d";
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0054 }
        r3 = 0;
        r4 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        r4 = r4.hashCode();	 Catch:{ Exception -> 0x0054 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0054 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0054 }
        r3 = 1;
        r4 = r14.bVm;	 Catch:{ Exception -> 0x0054 }
        r4 = r4.bOh;	 Catch:{ Exception -> 0x0054 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0054 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0054 }
        com.tencent.mm.sdk.platformtools.x.w(r0, r1, r2);	 Catch:{ Exception -> 0x0054 }
        goto L_0x0022;
    L_0x00d0:
        r0 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        r2 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.k(r0);	 Catch:{ Exception -> 0x0054 }
        r0 = r14.bVm;	 Catch:{ Exception -> 0x0054 }
        r0 = r0.offset;	 Catch:{ Exception -> 0x0054 }
        r4 = (long) r0;	 Catch:{ Exception -> 0x0054 }
        r0 = r14.bVm;	 Catch:{ Exception -> 0x0054 }
        r0 = r0.bVn;	 Catch:{ Exception -> 0x0054 }
        r3 = r14.bVm;	 Catch:{ Exception -> 0x0054 }
        r3 = r3.bVo;	 Catch:{ Exception -> 0x0054 }
        r6 = "MicroMsg.OnlineVideoViewHelper";
        r7 = "deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s startDownload[%d %d]";
        r8 = 5;
        r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x0054 }
        r9 = 0;
        r10 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x0054 }
        r8[r9] = r10;	 Catch:{ Exception -> 0x0054 }
        r9 = 1;
        r10 = r2.elF;	 Catch:{ Exception -> 0x0054 }
        r10 = java.lang.Integer.valueOf(r10);	 Catch:{ Exception -> 0x0054 }
        r8[r9] = r10;	 Catch:{ Exception -> 0x0054 }
        r9 = 2;
        r10 = r2.elz;	 Catch:{ Exception -> 0x0054 }
        r8[r9] = r10;	 Catch:{ Exception -> 0x0054 }
        r9 = 3;
        r10 = java.lang.Long.valueOf(r0);	 Catch:{ Exception -> 0x0054 }
        r8[r9] = r10;	 Catch:{ Exception -> 0x0054 }
        r9 = 4;
        r10 = r2.dQj;	 Catch:{ Exception -> 0x0054 }
        r10 = java.lang.Long.valueOf(r10);	 Catch:{ Exception -> 0x0054 }
        r8[r9] = r10;	 Catch:{ Exception -> 0x0054 }
        com.tencent.mm.sdk.platformtools.x.i(r6, r7, r8);	 Catch:{ Exception -> 0x0054 }
        r6 = r2.elF;	 Catch:{ Exception -> 0x0054 }
        if (r6 == 0) goto L_0x0128;
    L_0x0118:
        r0 = "MicroMsg.OnlineVideoViewHelper";
        r1 = "moov had callback, do nothing.";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);	 Catch:{ Exception -> 0x0054 }
    L_0x0121:
        r0 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        com.tencent.mm.plugin.sns.ui.OnlineVideoView.r(r0);	 Catch:{ Exception -> 0x0054 }
        goto L_0x0022;
    L_0x0128:
        r6 = r2.dQj;	 Catch:{ Exception -> 0x0054 }
        r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r6 <= 0) goto L_0x0160;
    L_0x012e:
        r2.dQj = r0;	 Catch:{ Exception -> 0x0054 }
        r0 = com.tencent.mm.sdk.platformtools.bi.VF();	 Catch:{ Exception -> 0x0054 }
        r2.nPP = r0;	 Catch:{ Exception -> 0x0054 }
        r0 = r2.elE;	 Catch:{ Exception -> 0x0144 }
        if (r0 != 0) goto L_0x0163;
    L_0x013a:
        r0 = "MicroMsg.OnlineVideoViewHelper";
        r1 = "parser is null, thread is error.";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);	 Catch:{ Exception -> 0x0144 }
        goto L_0x0121;
    L_0x0144:
        r0 = move-exception;
        r1 = "MicroMsg.OnlineVideoViewHelper";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0054 }
        r3 = "deal moov ready error: ";
        r2.<init>(r3);	 Catch:{ Exception -> 0x0054 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0054 }
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x0054 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0054 }
        com.tencent.mm.sdk.platformtools.x.e(r1, r0);	 Catch:{ Exception -> 0x0054 }
        goto L_0x0121;
    L_0x0160:
        r0 = r2.dQj;	 Catch:{ Exception -> 0x0054 }
        goto L_0x012e;
    L_0x0163:
        r0 = r2.elE;	 Catch:{ Exception -> 0x0144 }
        r1 = r2.elA;	 Catch:{ Exception -> 0x0144 }
        r0 = r0.s(r1, r4);	 Catch:{ Exception -> 0x0144 }
        if (r0 == 0) goto L_0x01b8;
    L_0x016d:
        r0 = r2.elE;	 Catch:{ Exception -> 0x0144 }
        r0 = r0.eyV;	 Catch:{ Exception -> 0x0144 }
        r2.elF = r0;	 Catch:{ Exception -> 0x0144 }
        r0 = "MicroMsg.OnlineVideoViewHelper";
        r1 = "mp4 parse moov success. duration %d cdnMediaId %s isFastStart %b";
        r4 = 3;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0144 }
        r5 = 0;
        r6 = r2.elF;	 Catch:{ Exception -> 0x0144 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x0144 }
        r4[r5] = r6;	 Catch:{ Exception -> 0x0144 }
        r5 = 1;
        r6 = r2.elz;	 Catch:{ Exception -> 0x0144 }
        r4[r5] = r6;	 Catch:{ Exception -> 0x0144 }
        r5 = 2;
        r6 = java.lang.Boolean.valueOf(r3);	 Catch:{ Exception -> 0x0144 }
        r4[r5] = r6;	 Catch:{ Exception -> 0x0144 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r4);	 Catch:{ Exception -> 0x0144 }
        if (r3 != 0) goto L_0x019e;
    L_0x0196:
        r0 = new com.tencent.mm.plugin.sns.ui.af$1;	 Catch:{ Exception -> 0x0144 }
        r0.<init>(r2);	 Catch:{ Exception -> 0x0144 }
        com.tencent.mm.sdk.platformtools.ah.A(r0);	 Catch:{ Exception -> 0x0144 }
    L_0x019e:
        r0 = r2.elG;	 Catch:{ Exception -> 0x0144 }
        r1 = -1;
        if (r0 != r1) goto L_0x01b4;
    L_0x01a3:
        r0 = 1;
        r2.elD = r0;	 Catch:{ Exception -> 0x0144 }
    L_0x01a6:
        r1 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ Exception -> 0x0144 }
        r2 = 354; // 0x162 float:4.96E-43 double:1.75E-321;
        r4 = 204; // 0xcc float:2.86E-43 double:1.01E-321;
        r6 = 1;
        r8 = 0;
        r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x0144 }
        goto L_0x0121;
    L_0x01b4:
        r0 = 2;
        r2.elD = r0;	 Catch:{ Exception -> 0x0144 }
        goto L_0x01a6;
    L_0x01b8:
        r0 = "MicroMsg.OnlineVideoViewHelper";
        r1 = "mp4 parse moov error. cdnMediaId %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0144 }
        r4 = 0;
        r5 = r2.elz;	 Catch:{ Exception -> 0x0144 }
        r3[r4] = r5;	 Catch:{ Exception -> 0x0144 }
        com.tencent.mm.sdk.platformtools.x.w(r0, r1, r3);	 Catch:{ Exception -> 0x0144 }
        com.tencent.mm.modelvideo.o.Tb();	 Catch:{ Exception -> 0x0144 }
        r0 = r2.elz;	 Catch:{ Exception -> 0x0144 }
        r1 = 0;
        r2 = -1;
        com.tencent.mm.modelcdntran.f.g(r0, r1, r2);	 Catch:{ Exception -> 0x0144 }
        r1 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ Exception -> 0x0144 }
        r2 = 354; // 0x162 float:4.96E-43 double:1.75E-321;
        r4 = 205; // 0xcd float:2.87E-43 double:1.013E-321;
        r6 = 1;
        r8 = 0;
        r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x0144 }
        r0 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ Exception -> 0x0144 }
        r1 = 13836; // 0x360c float:1.9388E-41 double:6.836E-320;
        r2 = 3;
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0144 }
        r3 = 0;
        r4 = 402; // 0x192 float:5.63E-43 double:1.986E-321;
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0144 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0144 }
        r3 = 1;
        r4 = com.tencent.mm.sdk.platformtools.bi.VE();	 Catch:{ Exception -> 0x0144 }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x0144 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0144 }
        r3 = 2;
        r4 = "";
        r2[r3] = r4;	 Catch:{ Exception -> 0x0144 }
        r0.h(r1, r2);	 Catch:{ Exception -> 0x0144 }
        goto L_0x0121;
    L_0x0205:
        r0 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        r1 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.k(r0);	 Catch:{ Exception -> 0x0054 }
        r0 = r14.bVm;	 Catch:{ Exception -> 0x0054 }
        r0 = r0.mediaId;	 Catch:{ Exception -> 0x0054 }
        r2 = r14.bVm;	 Catch:{ Exception -> 0x0054 }
        r2 = r2.offset;	 Catch:{ Exception -> 0x0054 }
        r3 = r14.bVm;	 Catch:{ Exception -> 0x0054 }
        r3 = r3.length;	 Catch:{ Exception -> 0x0054 }
        r4 = 0;
        r1.elM = r4;	 Catch:{ Exception -> 0x0054 }
        if (r2 < 0) goto L_0x021e;
    L_0x021c:
        if (r3 >= 0) goto L_0x0246;
    L_0x021e:
        r0 = "MicroMsg.OnlineVideoViewHelper";
        r1 = "deal data available error offset[%d], length[%d]";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0054 }
        r5 = 0;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x0054 }
        r4[r5] = r2;	 Catch:{ Exception -> 0x0054 }
        r2 = 1;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x0054 }
        r4[r2] = r3;	 Catch:{ Exception -> 0x0054 }
        com.tencent.mm.sdk.platformtools.x.w(r0, r1, r4);	 Catch:{ Exception -> 0x0054 }
    L_0x0238:
        r0 = r14.bVm;	 Catch:{ Exception -> 0x0054 }
        r0 = r0.length;	 Catch:{ Exception -> 0x0054 }
        if (r0 <= 0) goto L_0x0022;
    L_0x023e:
        r0 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        r1 = 1;
        r0.bS(r1);	 Catch:{ Exception -> 0x0054 }
        goto L_0x0022;
    L_0x0246:
        r0 = r1.NS(r0);	 Catch:{ Exception -> 0x0054 }
        if (r0 == 0) goto L_0x0238;
    L_0x024c:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0054 }
        r0.<init>();	 Catch:{ Exception -> 0x0054 }
        r4 = r1.elz;	 Catch:{ Exception -> 0x0054 }
        r0 = r0.append(r4);	 Catch:{ Exception -> 0x0054 }
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x0054 }
        r4 = "_";
        r0 = r0.append(r4);	 Catch:{ Exception -> 0x0054 }
        r0 = r0.append(r3);	 Catch:{ Exception -> 0x0054 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0054 }
        r4 = r1.nPL;	 Catch:{ Exception -> 0x0054 }
        r0 = r4.get(r0);	 Catch:{ Exception -> 0x0054 }
        r0 = (java.lang.Integer) r0;	 Catch:{ Exception -> 0x0054 }
        if (r0 == 0) goto L_0x02a4;
    L_0x0274:
        r4 = r0.intValue();	 Catch:{ Exception -> 0x0054 }
        if (r4 <= 0) goto L_0x02a4;
    L_0x027a:
        r0 = r0.intValue();	 Catch:{ Exception -> 0x0054 }
        r1.elJ = r0;	 Catch:{ Exception -> 0x0054 }
    L_0x0280:
        r0 = "MicroMsg.OnlineVideoViewHelper";
        r4 = "deal data available. offset[%d] length[%d] cachePlayTime[%d]";
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0054 }
        r6 = 0;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x0054 }
        r5[r6] = r2;	 Catch:{ Exception -> 0x0054 }
        r2 = 1;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x0054 }
        r5[r2] = r3;	 Catch:{ Exception -> 0x0054 }
        r2 = 2;
        r1 = r1.elJ;	 Catch:{ Exception -> 0x0054 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x0054 }
        r5[r2] = r1;	 Catch:{ Exception -> 0x0054 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r4, r5);	 Catch:{ Exception -> 0x0054 }
        goto L_0x0238;
    L_0x02a4:
        r0 = r1.elE;	 Catch:{ Exception -> 0x02ad }
        r0 = r0.bw(r2, r3);	 Catch:{ Exception -> 0x02ad }
        r1.elJ = r0;	 Catch:{ Exception -> 0x02ad }
        goto L_0x0280;
    L_0x02ad:
        r0 = move-exception;
        r4 = "MicroMsg.OnlineVideoViewHelper";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0054 }
        r6 = "deal data available file pos to video time error: ";
        r5.<init>(r6);	 Catch:{ Exception -> 0x0054 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0054 }
        r0 = r5.append(r0);	 Catch:{ Exception -> 0x0054 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0054 }
        com.tencent.mm.sdk.platformtools.x.e(r4, r0);	 Catch:{ Exception -> 0x0054 }
        goto L_0x0280;
    L_0x02c9:
        r0 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        r1 = 1;
        r0.bS(r1);	 Catch:{ Exception -> 0x0054 }
        goto L_0x0022;
    L_0x02d1:
        r0 = "MicroMsg.OnlineVideoView";
        r1 = "%d download finish. cdnMediaId %s sendReqCode %d favFromScene %d";
        r2 = 4;
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0054 }
        r3 = 0;
        r4 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        r4 = r4.hashCode();	 Catch:{ Exception -> 0x0054 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0054 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0054 }
        r3 = 1;
        r4 = r14.bVm;	 Catch:{ Exception -> 0x0054 }
        r4 = r4.mediaId;	 Catch:{ Exception -> 0x0054 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0054 }
        r3 = 2;
        r4 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        r4 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.s(r4);	 Catch:{ Exception -> 0x0054 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0054 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0054 }
        r3 = 3;
        r4 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        r4 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.t(r4);	 Catch:{ Exception -> 0x0054 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0054 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0054 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);	 Catch:{ Exception -> 0x0054 }
        r0 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.k(r0);	 Catch:{ Exception -> 0x0054 }
        r1 = "MicroMsg.OnlineVideoViewHelper";
        r2 = "deal stream finish. playStatus %d cdnMediaId %s";
        r3 = 2;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0054 }
        r4 = 0;
        r5 = r0.elD;	 Catch:{ Exception -> 0x0054 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0054 }
        r3[r4] = r5;	 Catch:{ Exception -> 0x0054 }
        r4 = 1;
        r5 = r0.elz;	 Catch:{ Exception -> 0x0054 }
        r3[r4] = r5;	 Catch:{ Exception -> 0x0054 }
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);	 Catch:{ Exception -> 0x0054 }
        r1 = 0;
        r0.elM = r1;	 Catch:{ Exception -> 0x0054 }
        r1 = 3;
        r0.elC = r1;	 Catch:{ Exception -> 0x0054 }
        r1 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ Exception -> 0x0054 }
        r2 = 354; // 0x162 float:4.96E-43 double:1.75E-321;
        r4 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        r6 = 1;
        r8 = 0;
        r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x0054 }
        r1 = r0.elD;	 Catch:{ Exception -> 0x0054 }
        if (r1 != 0) goto L_0x0367;
    L_0x0341:
        r1 = "MicroMsg.OnlineVideoViewHelper";
        r2 = "it had not moov callback and download finish start to play video.";
        com.tencent.mm.sdk.platformtools.x.w(r1, r2);	 Catch:{ Exception -> 0x0054 }
        r0.bCx();	 Catch:{ Exception -> 0x0054 }
    L_0x034d:
        r0 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.s(r0);	 Catch:{ Exception -> 0x0054 }
        if (r0 <= 0) goto L_0x0388;
    L_0x0355:
        r0 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        com.tencent.mm.plugin.sns.ui.OnlineVideoView.n(r0);	 Catch:{ Exception -> 0x0054 }
        r0 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        r1 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        r1 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.s(r1);	 Catch:{ Exception -> 0x0054 }
        com.tencent.mm.plugin.sns.ui.OnlineVideoView.b(r0, r1);	 Catch:{ Exception -> 0x0054 }
        goto L_0x0022;
    L_0x0367:
        r1 = r0.elD;	 Catch:{ Exception -> 0x0054 }
        r2 = 5;
        if (r1 != r2) goto L_0x034d;
    L_0x036c:
        r1 = "MicroMsg.OnlineVideoViewHelper";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0054 }
        r3 = "it had play error, it request all video data finish, start to play.";
        r2.<init>(r3);	 Catch:{ Exception -> 0x0054 }
        r3 = r0.elz;	 Catch:{ Exception -> 0x0054 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0054 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0054 }
        com.tencent.mm.sdk.platformtools.x.w(r1, r2);	 Catch:{ Exception -> 0x0054 }
        r0.bCx();	 Catch:{ Exception -> 0x0054 }
        goto L_0x034d;
    L_0x0388:
        r0 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.t(r0);	 Catch:{ Exception -> 0x0054 }
        if (r0 <= 0) goto L_0x03a8;
    L_0x0390:
        r0 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        com.tencent.mm.plugin.sns.ui.OnlineVideoView.n(r0);	 Catch:{ Exception -> 0x0054 }
        r0 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        r1 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        r1 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.t(r1);	 Catch:{ Exception -> 0x0054 }
        r2 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        r2 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.u(r2);	 Catch:{ Exception -> 0x0054 }
        com.tencent.mm.plugin.sns.ui.OnlineVideoView.b(r0, r1, r2);	 Catch:{ Exception -> 0x0054 }
        goto L_0x0022;
    L_0x03a8:
        r0 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.v(r0);	 Catch:{ Exception -> 0x0054 }
        if (r0 == 0) goto L_0x03bc;
    L_0x03b0:
        r0 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        com.tencent.mm.plugin.sns.ui.OnlineVideoView.n(r0);	 Catch:{ Exception -> 0x0054 }
        r0 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        com.tencent.mm.plugin.sns.ui.OnlineVideoView.w(r0);	 Catch:{ Exception -> 0x0054 }
        goto L_0x0022;
    L_0x03bc:
        r0 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        r1 = 1;
        r0.bS(r1);	 Catch:{ Exception -> 0x0054 }
        goto L_0x0022;
    L_0x03c4:
        r0 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.j(r0);	 Catch:{ Exception -> 0x0054 }
        if (r0 != r2) goto L_0x0428;
    L_0x03cc:
        r0 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.k(r0);	 Catch:{ Exception -> 0x0054 }
        r1 = r14.bVm;	 Catch:{ Exception -> 0x0054 }
        r1 = r1.mediaId;	 Catch:{ Exception -> 0x0054 }
        r2 = r14.bVm;	 Catch:{ Exception -> 0x0054 }
        r2 = r2.offset;	 Catch:{ Exception -> 0x0054 }
        r3 = r14.bVm;	 Catch:{ Exception -> 0x0054 }
        r3 = r3.length;	 Catch:{ Exception -> 0x0054 }
        r1 = r0.NS(r1);	 Catch:{ Exception -> 0x0054 }
        if (r1 == 0) goto L_0x041d;
    L_0x03e4:
        r0.progress = r2;	 Catch:{ Exception -> 0x0054 }
        r0.total = r3;	 Catch:{ Exception -> 0x0054 }
        r1 = r0.progress;	 Catch:{ Exception -> 0x0054 }
        r1 = r1 * 100;
        r2 = r0.total;	 Catch:{ Exception -> 0x0054 }
        r1 = r1 / r2;
        r0.nPN = r1;	 Catch:{ Exception -> 0x0054 }
        r1 = "MicroMsg.OnlineVideoViewHelper";
        r2 = "deal video[%s] progress callback[%d, %d]. downloadedPercent[%d]";
        r3 = 4;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0054 }
        r4 = 0;
        r5 = r0.elz;	 Catch:{ Exception -> 0x0054 }
        r3[r4] = r5;	 Catch:{ Exception -> 0x0054 }
        r4 = 1;
        r5 = r0.progress;	 Catch:{ Exception -> 0x0054 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0054 }
        r3[r4] = r5;	 Catch:{ Exception -> 0x0054 }
        r4 = 2;
        r5 = r0.total;	 Catch:{ Exception -> 0x0054 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0054 }
        r3[r4] = r5;	 Catch:{ Exception -> 0x0054 }
        r4 = 3;
        r5 = r0.nPN;	 Catch:{ Exception -> 0x0054 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0054 }
        r3[r4] = r5;	 Catch:{ Exception -> 0x0054 }
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);	 Catch:{ Exception -> 0x0054 }
    L_0x041d:
        r1 = r0.nPN;	 Catch:{ Exception -> 0x0054 }
        r2 = 100;
        if (r1 < r2) goto L_0x0022;
    L_0x0423:
        r1 = 3;
        r0.elC = r1;	 Catch:{ Exception -> 0x0054 }
        goto L_0x0022;
    L_0x0428:
        r0 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.j(r0);	 Catch:{ Exception -> 0x0054 }
        if (r0 != r3) goto L_0x0022;
    L_0x0430:
        r0 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        r1 = r14.bVm;	 Catch:{ Exception -> 0x0054 }
        r1 = r1.offset;	 Catch:{ Exception -> 0x0054 }
        r2 = r14.bVm;	 Catch:{ Exception -> 0x0054 }
        r2 = r2.length;	 Catch:{ Exception -> 0x0054 }
        com.tencent.mm.plugin.sns.ui.OnlineVideoView.a(r0, r1, r2);	 Catch:{ Exception -> 0x0054 }
        goto L_0x0022;
    L_0x043f:
        r0 = r13.nPH;	 Catch:{ Exception -> 0x0054 }
        r0 = com.tencent.mm.plugin.sns.ui.OnlineVideoView.k(r0);	 Catch:{ Exception -> 0x0054 }
        r1 = "MicroMsg.OnlineVideoViewHelper";
        r2 = "deal had dup video. cdnMediaId %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0054 }
        r4 = 0;
        r5 = r0.elz;	 Catch:{ Exception -> 0x0054 }
        r3[r4] = r5;	 Catch:{ Exception -> 0x0054 }
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);	 Catch:{ Exception -> 0x0054 }
        r0.bCx();	 Catch:{ Exception -> 0x0054 }
        goto L_0x0022;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.OnlineVideoView$5.a(com.tencent.mm.g.a.la):boolean");
    }
}
