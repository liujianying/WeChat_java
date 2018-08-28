package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.a.g;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.f;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.backup.bakoldlogic.c.c;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class d implements f {
    private boolean bPd = false;
    private boolean dJO = false;
    private Random dlF = new Random();
    List<String> gZA = new LinkedList();
    HashSet<String> gZB = new HashSet();
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d gZC;
    e gZD;
    boolean gZE = false;
    private long gZF;
    private long gZG;
    int gZH;
    int gZI = 0;
    Object lock = new Object();

    public final void pause() {
        x.i("MicroMsg.BakPCServer", "pause");
        this.bPd = true;
    }

    public final void resume() {
        x.i("MicroMsg.BakPCServer", "resume");
        this.bPd = false;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
    }

    public final void cancel() {
        x.i("MicroMsg.BakPCServer", "cancel");
        this.dJO = true;
        b.b(5, this.gZD);
        this.gZC = null;
        this.gZE = false;
        this.gZH = 0;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean o(java.lang.String r19, java.lang.String r20, int r21) {
        /*
        r18 = this;
        r12 = new com.tencent.mm.pointers.PLong;
        r12.<init>();
        r2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl();
        r2 = r2.atm();
        r2 = r2.FT();
        r0 = r19;
        r13 = r2.GN(r0);
        r5 = new java.util.LinkedList;
        r5.<init>();
        r14 = new java.util.LinkedList;
        r14.<init>();
        r2 = r13.moveToFirst();	 Catch:{ all -> 0x0081 }
        if (r2 == 0) goto L_0x0297;
    L_0x0027:
        r10 = r5;
        r4 = r21;
    L_0x002a:
        r2 = r13.isAfterLast();	 Catch:{ all -> 0x0081 }
        if (r2 != 0) goto L_0x0296;
    L_0x0030:
        r0 = r18;
        r3 = r0.lock;	 Catch:{ all -> 0x0081 }
        monitor-enter(r3);	 Catch:{ all -> 0x0081 }
        r0 = r18;
        r2 = r0.gZB;	 Catch:{ all -> 0x007e }
        r2 = r2.size();	 Catch:{ all -> 0x007e }
        r5 = 10;
        if (r2 <= r5) goto L_0x0048;
    L_0x0041:
        r0 = r18;
        r2 = r0.lock;	 Catch:{ InterruptedException -> 0x02f5 }
        r2.wait();	 Catch:{ InterruptedException -> 0x02f5 }
    L_0x0048:
        r0 = r18;
        r2 = r0.bPd;	 Catch:{ all -> 0x007e }
        if (r2 == 0) goto L_0x005b;
    L_0x004e:
        r0 = r18;
        r2 = r0.dJO;	 Catch:{ all -> 0x007e }
        if (r2 != 0) goto L_0x005b;
    L_0x0054:
        r0 = r18;
        r2 = r0.lock;	 Catch:{ InterruptedException -> 0x0070 }
        r2.wait();	 Catch:{ InterruptedException -> 0x0070 }
    L_0x005b:
        r0 = r18;
        r2 = r0.dJO;	 Catch:{ all -> 0x007e }
        if (r2 == 0) goto L_0x0086;
    L_0x0061:
        r2 = "MicroMsg.BakPCServer";
        r4 = "backupImp cancel";
        com.tencent.mm.sdk.platformtools.x.i(r2, r4);	 Catch:{ all -> 0x007e }
        monitor-exit(r3);	 Catch:{ all -> 0x007e }
        r13.close();
        r2 = 0;
    L_0x006f:
        return r2;
    L_0x0070:
        r2 = move-exception;
        r5 = "MicroMsg.BakPCServer";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x007e }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r2, r6, r7);	 Catch:{ all -> 0x007e }
        goto L_0x005b;
    L_0x007e:
        r2 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x007e }
        throw r2;	 Catch:{ all -> 0x0081 }
    L_0x0081:
        r2 = move-exception;
        r13.close();
        throw r2;
    L_0x0086:
        monitor-exit(r3);	 Catch:{ all -> 0x007e }
        r7 = new com.tencent.mm.storage.bd;	 Catch:{ all -> 0x0081 }
        r7.<init>();	 Catch:{ all -> 0x0081 }
        r7.d(r13);	 Catch:{ all -> 0x0081 }
        r3 = 0;
        if (r4 <= 0) goto L_0x0117;
    L_0x0092:
        r2 = 1;
        r5 = r2;
    L_0x0094:
        r8 = r7.field_msgSvrId;	 Catch:{ Exception -> 0x01f4 }
        r16 = 0;
        r2 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1));
        if (r2 != 0) goto L_0x011b;
    L_0x009c:
        r2 = "MicroMsg.BackupPackMsgLogic";
        r5 = "packedMsg msgSvrId is 0, talker[%s], type[%d]";
        r6 = 2;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x01f4 }
        r8 = 0;
        r9 = r7.field_talker;	 Catch:{ Exception -> 0x01f4 }
        r6[r8] = r9;	 Catch:{ Exception -> 0x01f4 }
        r8 = 1;
        r7 = r7.getType();	 Catch:{ Exception -> 0x01f4 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x01f4 }
        r6[r8] = r7;	 Catch:{ Exception -> 0x01f4 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r5, r6);	 Catch:{ Exception -> 0x01f4 }
        r2 = 0;
    L_0x00b9:
        r3 = r4 + -1;
        r11 = r3;
    L_0x00bc:
        if (r2 == 0) goto L_0x00c1;
    L_0x00be:
        r10.add(r2);	 Catch:{ all -> 0x0081 }
    L_0x00c1:
        r15 = r14.iterator();	 Catch:{ all -> 0x0081 }
    L_0x00c5:
        r2 = r15.hasNext();	 Catch:{ all -> 0x0081 }
        if (r2 == 0) goto L_0x021b;
    L_0x00cb:
        r2 = r15.next();	 Catch:{ all -> 0x0081 }
        r0 = r2;
        r0 = (com.tencent.mm.plugin.backup.h.u) r0;	 Catch:{ all -> 0x0081 }
        r9 = r0;
        r2 = new com.tencent.mm.plugin.backup.bakoldlogic.c.c;	 Catch:{ all -> 0x0081 }
        r3 = r9.mediaId;	 Catch:{ all -> 0x0081 }
        r4 = 2;
        r5 = 0;
        r6 = r9.path;	 Catch:{ all -> 0x0081 }
        r7 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.asN();	 Catch:{ all -> 0x0081 }
        r8 = r7.gRA;	 Catch:{ all -> 0x0081 }
        r7 = r18;
        r2.<init>(r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0081 }
        r0 = r18;
        r3 = r0.lock;	 Catch:{ all -> 0x0081 }
        monitor-enter(r3);	 Catch:{ all -> 0x0081 }
        r2.ass();	 Catch:{ all -> 0x0114 }
        r0 = r18;
        r2 = r0.gZB;	 Catch:{ all -> 0x0114 }
        r4 = r9.mediaId;	 Catch:{ all -> 0x0114 }
        r2.add(r4);	 Catch:{ all -> 0x0114 }
        r2 = "MicroMsg.BakPCServer";
        r4 = "backupChatMsg now: size:%d";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0114 }
        r6 = 0;
        r0 = r18;
        r7 = r0.gZB;	 Catch:{ all -> 0x0114 }
        r7 = r7.size();	 Catch:{ all -> 0x0114 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x0114 }
        r5[r6] = r7;	 Catch:{ all -> 0x0114 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r4, r5);	 Catch:{ all -> 0x0114 }
        monitor-exit(r3);	 Catch:{ all -> 0x0114 }
        goto L_0x00c5;
    L_0x0114:
        r2 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0114 }
        throw r2;	 Catch:{ all -> 0x0081 }
    L_0x0117:
        r2 = 0;
        r5 = r2;
        goto L_0x0094;
    L_0x011b:
        r2 = new com.tencent.mm.protocal.c.ey;	 Catch:{ Exception -> 0x01f4 }
        r2.<init>();	 Catch:{ Exception -> 0x01f4 }
        r8 = r7.field_msgSvrId;	 Catch:{ Exception -> 0x01f4 }
        r2.rcq = r8;	 Catch:{ Exception -> 0x01f4 }
        r6 = r7.field_isSend;	 Catch:{ Exception -> 0x01f4 }
        r8 = 1;
        if (r6 != r8) goto L_0x01b8;
    L_0x0129:
        r5 = new com.tencent.mm.protocal.c.bhz;	 Catch:{ Exception -> 0x01f4 }
        r5.<init>();	 Catch:{ Exception -> 0x01f4 }
        r0 = r20;
        r5 = r5.VO(r0);	 Catch:{ Exception -> 0x01f4 }
        r2.rcj = r5;	 Catch:{ Exception -> 0x01f4 }
        r5 = new com.tencent.mm.protocal.c.bhz;	 Catch:{ Exception -> 0x01f4 }
        r5.<init>();	 Catch:{ Exception -> 0x01f4 }
        r6 = r7.field_talker;	 Catch:{ Exception -> 0x01f4 }
        r5 = r5.VO(r6);	 Catch:{ Exception -> 0x01f4 }
        r2.rck = r5;	 Catch:{ Exception -> 0x01f4 }
        r5 = 2;
        r6 = r2;
    L_0x0145:
        r6.rft = r5;	 Catch:{ Exception -> 0x01f4 }
        r5 = new com.tencent.mm.protocal.c.bhy;	 Catch:{ Exception -> 0x01f4 }
        r5.<init>();	 Catch:{ Exception -> 0x01f4 }
        r2.rfy = r5;	 Catch:{ Exception -> 0x01f4 }
        r5 = 0;
        r2.rfz = r5;	 Catch:{ Exception -> 0x01f4 }
        r5 = 0;
        r2.rfA = r5;	 Catch:{ Exception -> 0x01f4 }
        r5 = "";
        r2.rco = r5;	 Catch:{ Exception -> 0x01f4 }
        r5 = r7.getType();	 Catch:{ Exception -> 0x01f4 }
        r5 = com.tencent.mm.pluginsdk.model.app.l.BJ(r5);	 Catch:{ Exception -> 0x01f4 }
        r2.hcE = r5;	 Catch:{ Exception -> 0x01f4 }
        r8 = r7.field_createTime;	 Catch:{ Exception -> 0x01f4 }
        r16 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r8 = r8 / r16;
        r5 = (int) r8;	 Catch:{ Exception -> 0x01f4 }
        r2.rfu = r5;	 Catch:{ Exception -> 0x01f4 }
        r8 = r7.field_createTime;	 Catch:{ Exception -> 0x01f4 }
        r2.rfC = r8;	 Catch:{ Exception -> 0x01f4 }
        r8 = r7.field_msgSeq;	 Catch:{ Exception -> 0x01f4 }
        r5 = (int) r8;	 Catch:{ Exception -> 0x01f4 }
        r2.rfB = r5;	 Catch:{ Exception -> 0x01f4 }
        r5 = r7.field_flag;	 Catch:{ Exception -> 0x01f4 }
        r2.rfD = r5;	 Catch:{ Exception -> 0x01f4 }
        r5 = new com.tencent.mm.protocal.c.bhz;	 Catch:{ Exception -> 0x01f4 }
        r5.<init>();	 Catch:{ Exception -> 0x01f4 }
        r6 = r7.field_content;	 Catch:{ Exception -> 0x01f4 }
        r8 = "";
        r6 = com.tencent.mm.sdk.platformtools.bi.aG(r6, r8);	 Catch:{ Exception -> 0x01f4 }
        r5.VO(r6);	 Catch:{ Exception -> 0x01f4 }
        r2.rcl = r5;	 Catch:{ Exception -> 0x01f4 }
        r5 = com.tencent.mm.plugin.backup.bakoldlogic.b.d.asM();	 Catch:{ Exception -> 0x01f4 }
        r6 = r7.getType();	 Catch:{ Exception -> 0x01f4 }
        r6 = com.tencent.mm.pluginsdk.model.app.l.BJ(r6);	 Catch:{ Exception -> 0x01f4 }
        r5 = r5.mN(r6);	 Catch:{ Exception -> 0x01f4 }
        if (r5 != 0) goto L_0x01dc;
    L_0x019e:
        r2 = "MicroMsg.BackupPackMsgLogic";
        r5 = "packedMsg unknow type[%d]";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x01f4 }
        r8 = 0;
        r7 = r7.getType();	 Catch:{ Exception -> 0x01f4 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x01f4 }
        r6[r8] = r7;	 Catch:{ Exception -> 0x01f4 }
        com.tencent.mm.sdk.platformtools.x.d(r2, r5, r6);	 Catch:{ Exception -> 0x01f4 }
        r2 = 0;
        goto L_0x00b9;
    L_0x01b8:
        r6 = new com.tencent.mm.protocal.c.bhz;	 Catch:{ Exception -> 0x01f4 }
        r6.<init>();	 Catch:{ Exception -> 0x01f4 }
        r8 = r7.field_talker;	 Catch:{ Exception -> 0x01f4 }
        r6 = r6.VO(r8);	 Catch:{ Exception -> 0x01f4 }
        r2.rcj = r6;	 Catch:{ Exception -> 0x01f4 }
        r6 = new com.tencent.mm.protocal.c.bhz;	 Catch:{ Exception -> 0x01f4 }
        r6.<init>();	 Catch:{ Exception -> 0x01f4 }
        r0 = r20;
        r6 = r6.VO(r0);	 Catch:{ Exception -> 0x01f4 }
        r2.rck = r6;	 Catch:{ Exception -> 0x01f4 }
        if (r5 == 0) goto L_0x01d8;
    L_0x01d4:
        r5 = 3;
        r6 = r2;
        goto L_0x0145;
    L_0x01d8:
        r5 = 4;
        r6 = r2;
        goto L_0x0145;
    L_0x01dc:
        r5 = r5.a(r2, r7, r14);	 Catch:{ Exception -> 0x01f4 }
        if (r5 >= 0) goto L_0x01e5;
    L_0x01e2:
        r2 = 0;
        goto L_0x00b9;
    L_0x01e5:
        r6 = r12.value;	 Catch:{ Exception -> 0x01f4 }
        r8 = (long) r5;	 Catch:{ Exception -> 0x01f4 }
        r6 = r6 + r8;
        r12.value = r6;	 Catch:{ Exception -> 0x01f4 }
        r6 = r12.value;	 Catch:{ Exception -> 0x01f4 }
        r8 = 60;
        r6 = r6 + r8;
        r12.value = r6;	 Catch:{ Exception -> 0x01f4 }
        goto L_0x00b9;
    L_0x01f4:
        r2 = move-exception;
        r5 = "MicroMsg.BakPCServer";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0081 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r2, r6, r7);	 Catch:{ all -> 0x0081 }
        r5 = "MicroMsg.BakPCServer";
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0081 }
        r7 = "backupChatMsg %s";
        r6.<init>(r7);	 Catch:{ all -> 0x0081 }
        r2 = r6.append(r2);	 Catch:{ all -> 0x0081 }
        r2 = r2.toString();	 Catch:{ all -> 0x0081 }
        com.tencent.mm.sdk.platformtools.x.f(r5, r2);	 Catch:{ all -> 0x0081 }
        r2 = r3;
        r11 = r4;
        goto L_0x00bc;
    L_0x021b:
        r14.clear();	 Catch:{ all -> 0x0081 }
        r2 = r12.value;	 Catch:{ all -> 0x0081 }
        r4 = 262144; // 0x40000 float:3.67342E-40 double:1.295163E-318;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x028d;
    L_0x0227:
        r2 = "MicroMsg.BakPCServer";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0081 }
        r4 = "limitSize ";
        r3.<init>(r4);	 Catch:{ all -> 0x0081 }
        r4 = r12.value;	 Catch:{ all -> 0x0081 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0081 }
        r3 = r3.toString();	 Catch:{ all -> 0x0081 }
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);	 Catch:{ all -> 0x0081 }
        r0 = r18;
        r2 = r0.dlF;	 Catch:{ all -> 0x0081 }
        r3 = a(r2);	 Catch:{ all -> 0x0081 }
        r2 = new com.tencent.mm.plugin.backup.bakoldlogic.c.c;	 Catch:{ all -> 0x0081 }
        r4 = 1;
        r6 = "";
        r5 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.asN();	 Catch:{ all -> 0x0081 }
        r8 = r5.gRA;	 Catch:{ all -> 0x0081 }
        r5 = r10;
        r7 = r18;
        r2.<init>(r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0081 }
        r0 = r18;
        r4 = r0.lock;	 Catch:{ all -> 0x0081 }
        monitor-enter(r4);	 Catch:{ all -> 0x0081 }
        r2.ass();	 Catch:{ all -> 0x0293 }
        r0 = r18;
        r2 = r0.gZB;	 Catch:{ all -> 0x0293 }
        r2.add(r3);	 Catch:{ all -> 0x0293 }
        r2 = "MicroMsg.BakPCServer";
        r3 = "backupChatMsg now: size:%d";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0293 }
        r6 = 0;
        r0 = r18;
        r7 = r0.gZB;	 Catch:{ all -> 0x0293 }
        r7 = r7.size();	 Catch:{ all -> 0x0293 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x0293 }
        r5[r6] = r7;	 Catch:{ all -> 0x0293 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r5);	 Catch:{ all -> 0x0293 }
        monitor-exit(r4);	 Catch:{ all -> 0x0293 }
        r10 = new java.util.LinkedList;	 Catch:{ all -> 0x0081 }
        r10.<init>();	 Catch:{ all -> 0x0081 }
        r2 = 0;
        r12.value = r2;	 Catch:{ all -> 0x0081 }
    L_0x028d:
        r13.moveToNext();	 Catch:{ all -> 0x0081 }
        r4 = r11;
        goto L_0x002a;
    L_0x0293:
        r2 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0293 }
        throw r2;	 Catch:{ all -> 0x0081 }
    L_0x0296:
        r5 = r10;
    L_0x0297:
        r2 = r12.value;	 Catch:{ all -> 0x0081 }
        r6 = 0;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 <= 0) goto L_0x02ec;
    L_0x029f:
        r0 = r18;
        r2 = r0.dlF;	 Catch:{ all -> 0x0081 }
        r3 = a(r2);	 Catch:{ all -> 0x0081 }
        r2 = new com.tencent.mm.plugin.backup.bakoldlogic.c.c;	 Catch:{ all -> 0x0081 }
        r4 = 1;
        r6 = "";
        r7 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.asN();	 Catch:{ all -> 0x0081 }
        r8 = r7.gRA;	 Catch:{ all -> 0x0081 }
        r7 = r18;
        r2.<init>(r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0081 }
        r0 = r18;
        r4 = r0.lock;	 Catch:{ all -> 0x0081 }
        monitor-enter(r4);	 Catch:{ all -> 0x0081 }
        r2.ass();	 Catch:{ all -> 0x02f2 }
        r0 = r18;
        r2 = r0.gZB;	 Catch:{ all -> 0x02f2 }
        r2.add(r3);	 Catch:{ all -> 0x02f2 }
        r2 = "MicroMsg.BakPCServer";
        r3 = "backupChatMsg now: size:%d";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x02f2 }
        r6 = 0;
        r0 = r18;
        r7 = r0.gZB;	 Catch:{ all -> 0x02f2 }
        r7 = r7.size();	 Catch:{ all -> 0x02f2 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x02f2 }
        r5[r6] = r7;	 Catch:{ all -> 0x02f2 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r5);	 Catch:{ all -> 0x02f2 }
        monitor-exit(r4);	 Catch:{ all -> 0x02f2 }
        r2 = 0;
        r12.value = r2;	 Catch:{ all -> 0x0081 }
        r2 = new java.util.LinkedList;	 Catch:{ all -> 0x0081 }
        r2.<init>();	 Catch:{ all -> 0x0081 }
    L_0x02ec:
        r13.close();
        r2 = 1;
        goto L_0x006f;
    L_0x02f2:
        r2 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x02f2 }
        throw r2;	 Catch:{ all -> 0x0081 }
    L_0x02f5:
        r2 = move-exception;
        goto L_0x0048;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d.o(java.lang.String, java.lang.String, int):boolean");
    }

    final void asU() {
        if (this.gZE && !this.dJO) {
            synchronized (this.lock) {
                if (this.gZB.isEmpty()) {
                    a.asN().asO().gZU = 4;
                    a.asN().asO().gZV = 3;
                    b.b(5, this.gZD);
                    new com.tencent.mm.plugin.backup.bakoldlogic.c.b(5).ass();
                    c asP = a.asN().asP();
                    asP.gZw++;
                    if (this.gZC != null) {
                        this.gZC.atb();
                    } else {
                        x.i("MicroMsg.BakPCServer", "operatorCallback is null");
                    }
                    cancel();
                    x.i("MicroMsg.BakPCServer", "send backup finish cmd");
                }
            }
        }
    }

    private static String a(Random random) {
        return g.u((bi.VG() + random.nextDouble()).getBytes());
    }

    public final void a(int i, int i2, l lVar) {
        this.gZG += (long) i;
        int i3 = this.gZF == 0 ? 0 : (int) ((this.gZG * 100) / this.gZF);
        if (i3 > this.gZH) {
            this.gZH = i3;
            c.setProgress(this.gZH);
            if (!this.bPd && !this.dJO && this.gZC != null && this.gZH >= 0 && this.gZH <= 100) {
                this.gZC.mT(this.gZH);
            }
        }
    }
}
