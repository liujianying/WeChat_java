package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.b.j;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.2;
import com.tencent.mm.plugin.backup.h.ab;
import com.tencent.mm.plugin.backup.h.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.protocal.c.ez;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bd;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class f implements com.tencent.mm.ab.f {
    boolean bPd = false;
    boolean dJO = false;
    boolean gSS = false;
    HashSet<String> gZB = new HashSet();
    d gZC;
    private e gZD;
    boolean gZE = false;
    int gZI = 0;
    List<t> hac;
    List<t> had;
    int hae = 0;
    public boolean haf = false;
    long hag;
    long hah;
    int hai;
    Object lock = new Object();

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ int hal;

        AnonymousClass5(int i) {
            this.hal = i;
        }

        public final void run() {
            Throwable e;
            com.tencent.mm.plugin.backup.b.e.reset();
            com.tencent.mm.plugin.backup.b.e.arp();
            c cVar = new c();
            cVar.begin();
            HashMap hashMap = new HashMap();
            HashSet hashSet = new HashSet();
            int i = 0;
            for (t tVar : f.this.hac) {
                int a;
                try {
                    a = f.this.a(a.asK() + "backupItem/" + a.wv(tVar.ID) + tVar.ID, hashMap, cVar, hashSet);
                    if (a < 0) {
                        cVar.end();
                        x.w("MicroMsg.RecoverPCServer", "Thread has been canceled");
                        return;
                    }
                    a += i;
                    try {
                        f.this.cg(a, this.hal);
                        x.i("MicroMsg.RecoverPCServer", "recover has done: %d", new Object[]{Integer.valueOf(a)});
                        i = a;
                    } catch (Throwable e2) {
                        e = e2;
                        x.e("MicroMsg.RecoverPCServer", "Thread.run err:" + e.toString());
                        x.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
                        x.f("MicroMsg.RecoverPCServer", "recoverFromSdcard MMThread.run() " + e.toString());
                        i = a;
                    }
                } catch (Exception e3) {
                    e = e3;
                    a = i;
                    x.e("MicroMsg.RecoverPCServer", "Thread.run err:" + e.toString());
                    x.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
                    x.f("MicroMsg.RecoverPCServer", "recoverFromSdcard MMThread.run() " + e.toString());
                    i = a;
                }
            }
            com.tencent.mm.plugin.backup.bakoldlogic.d.d.l(hashMap);
            cVar.end();
            f.this.cg(100, 100);
            x.i("MicroMsg.RecoverPCServer", "build temDB finish!");
            x.chR();
            b atl = b.atl();
            atl.a(new 2(atl, new 1(this)), 10);
        }
    }

    static /* synthetic */ void a(f fVar) {
        com.tencent.mm.plugin.backup.bakoldlogic.c.d dVar;
        com.tencent.mm.a.e.k(new File(a.asK()));
        fVar.gZD = new e() {
            public final void a(int i, int i2, String str, l lVar) {
                x.i("MicroMsg.RecoverPCServer", "onSceneEnd %s, %d, %d", new Object[]{((com.tencent.mm.plugin.backup.bakoldlogic.c.d) lVar).id, Integer.valueOf(i), Integer.valueOf(i2)});
                synchronized (f.this.lock) {
                    f.this.gZB.remove(r10.id);
                    x.i("MicroMsg.RecoverPCServer", "onSceneEnd left: size:%d", new Object[]{Integer.valueOf(f.this.gZB.size())});
                    if (f.this.gZB.size() <= 10) {
                        f.this.lock.notifyAll();
                    }
                }
                f fVar = f.this;
                fVar.gZI++;
                if (f.this.gZI % 300 == 0) {
                    f.this.atf();
                }
                f.this.ate();
            }
        };
        com.tencent.mm.plugin.backup.f.b.a(7, fVar.gZD);
        for (t tVar : fVar.had) {
            if (fVar.bPd && !fVar.dJO) {
                x.i("MicroMsg.RecoverPCServer", "hit pause");
                synchronized (fVar.lock) {
                    try {
                        fVar.lock.wait();
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
                    }
                }
            }
            if (fVar.dJO) {
                x.i("MicroMsg.RecoverPCServer", "backupImp canceled");
                return;
            }
            dVar = new com.tencent.mm.plugin.backup.bakoldlogic.c.d(a.asK(), tVar.ID, 2, tVar.hcy, fVar, a.asN().gRA);
            synchronized (fVar.lock) {
                dVar.ass();
                fVar.gZB.add(tVar.ID);
                x.i("MicroMsg.RecoverPCServer", "media recoverImp now: size:%d", new Object[]{Integer.valueOf(fVar.gZB.size())});
                if (fVar.gZB.size() > 10) {
                    try {
                        fVar.lock.wait();
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.RecoverPCServer", e2, "", new Object[0]);
                    }
                }
            }
        }
        for (t tVar2 : fVar.hac) {
            if (fVar.bPd && !fVar.dJO) {
                x.i("MicroMsg.RecoverPCServer", "hit pause");
                synchronized (fVar.lock) {
                    try {
                        fVar.lock.wait();
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.RecoverPCServer", e22, "", new Object[0]);
                    }
                }
            }
            if (fVar.dJO) {
                x.i("MicroMsg.RecoverPCServer", "backupImp canceled");
                return;
            }
            dVar = new com.tencent.mm.plugin.backup.bakoldlogic.c.d(a.asK(), tVar2.ID, 1, tVar2.hcy, fVar, a.asN().gRA);
            synchronized (fVar.lock) {
                dVar.ass();
                fVar.gZB.add(tVar2.ID);
                x.i("MicroMsg.RecoverPCServer", "digest recoverImp now: size:%d", new Object[]{Integer.valueOf(fVar.gZB.size())});
                if (fVar.gZB.size() > 10) {
                    try {
                        fVar.lock.wait();
                    } catch (Throwable e222) {
                        x.printErrStackTrace("MicroMsg.RecoverPCServer", e222, "", new Object[0]);
                    }
                }
            }
        }
        fVar.gZE = true;
        x.i("MicroMsg.RecoverPCServer", "send RestoreData req finish");
        fVar.ate();
    }

    public final void pause() {
        x.i("MicroMsg.RecoverPCServer", "pause");
        this.bPd = true;
    }

    public final void resume() {
        x.i("MicroMsg.RecoverPCServer", "resume");
        this.bPd = false;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
    }

    public final void cancel() {
        x.i("MicroMsg.RecoverPCServer", "cancel");
        this.dJO = true;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
        com.tencent.mm.plugin.backup.f.b.b(7, this.gZD);
        this.gZC = null;
        this.haf = false;
        this.gSS = false;
        this.hae = 0;
        this.hai = 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void ate() {
        /*
        r3 = this;
        r0 = r3.gZE;
        if (r0 == 0) goto L_0x0008;
    L_0x0004:
        r0 = r3.dJO;
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r1 = r3.lock;
        monitor-enter(r1);
        r0 = r3.gZB;	 Catch:{ all -> 0x001a }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x001a }
        if (r0 == 0) goto L_0x0059;
    L_0x0014:
        r0 = r3.dJO;	 Catch:{ all -> 0x001a }
        if (r0 == 0) goto L_0x001d;
    L_0x0018:
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
        goto L_0x0008;
    L_0x001a:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
        throw r0;
    L_0x001d:
        r0 = 1;
        r3.haf = r0;	 Catch:{ all -> 0x001a }
        r0 = 0;
        r3.hai = r0;	 Catch:{ all -> 0x001a }
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.asN();	 Catch:{ all -> 0x001a }
        r0 = r0.asO();	 Catch:{ all -> 0x001a }
        r2 = 6;
        r0.gZU = r2;	 Catch:{ all -> 0x001a }
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.asN();	 Catch:{ all -> 0x001a }
        r0 = r0.asO();	 Catch:{ all -> 0x001a }
        r2 = 5;
        r0.gZV = r2;	 Catch:{ all -> 0x001a }
        r0 = r3.gZC;	 Catch:{ all -> 0x001a }
        if (r0 == 0) goto L_0x005b;
    L_0x003d:
        r0 = r3.gZC;	 Catch:{ all -> 0x001a }
        r0.atb();	 Catch:{ all -> 0x001a }
    L_0x0042:
        r0 = 7;
        r2 = r3.gZD;	 Catch:{ all -> 0x001a }
        com.tencent.mm.plugin.backup.f.b.b(r0, r2);	 Catch:{ all -> 0x001a }
        r0 = 0;
        r2 = 0;
        r3.cg(r0, r2);	 Catch:{ all -> 0x001a }
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.asZ();	 Catch:{ all -> 0x001a }
        r0 = "MicroMsg.RecoverPCServer";
        r2 = "checkRecover publicRestAccUinEven";
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ all -> 0x001a }
    L_0x0059:
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
        goto L_0x0008;
    L_0x005b:
        r0 = "MicroMsg.RecoverPCServer";
        r2 = "operatorCallback is null";
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ all -> 0x001a }
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.ate():void");
    }

    public static int au(List<t> list) {
        int i = 0;
        for (t tVar : list) {
            try {
                i = ((ez) new ez().aG(com.tencent.mm.a.e.f(a.asK() + "backupItem/" + a.wv(tVar.ID) + tVar.ID, 0, -1))).hbG.size() + i;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
            }
        }
        return i;
    }

    final void cg(int i, int i2) {
        int i3 = (int) (i == 0 ? 0 : (((long) i) * 100) / ((long) i2));
        if ((i == 0 && i2 == 0) || i3 > this.hae) {
            this.hae = i3;
            if (!(this.bPd || this.dJO || this.gZC == null || this.hae < 0 || this.hae > 100)) {
                this.gZC.mU(this.hae);
            }
            ab abVar = new ab();
            abVar.hbr = 13;
            abVar.hcT = 0;
            abVar.hcU = this.hae;
            try {
                x.i("MicroMsg.RecoverPCServer", "send progress cmd, progress :%d", new Object[]{Integer.valueOf(i3)});
                com.tencent.mm.plugin.backup.f.b.J(abVar.toByteArray(), 3);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
                x.e("MicroMsg.RecoverPCServer", "buf to PacketCommandRequest err");
            }
        }
    }

    final int a(String str, HashMap<String, Integer> hashMap, c cVar, HashSet<String> hashSet) {
        Throwable e;
        long currentTimeMillis = System.currentTimeMillis();
        byte[] f = com.tencent.mm.a.e.f(str, 0, -1);
        String str2;
        try {
            ez ezVar = (ez) new ez().aG(f);
            Iterator it = ezVar.hbG.iterator();
            while (it.hasNext()) {
                ey eyVar = (ey) it.next();
                if (this.bPd && !this.dJO) {
                    synchronized (this.lock) {
                        try {
                            this.lock.wait();
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.RecoverPCServer", e2, "", new Object[0]);
                        }
                    }
                }
                if (this.dJO) {
                    x.i("MicroMsg.RecoverPCServer", "backupImp canceled");
                    return -1;
                }
                try {
                    String str3 = (String) b.atl().atm().DT().get(2, null);
                    com.tencent.mm.plugin.messenger.foundation.a.a.f FT = b.atl().atm().FT();
                    str2 = eyVar.rcj.siM;
                    String str4 = eyVar.rck.siM;
                    String str5;
                    if (bi.oW(str2) || bi.oW(str4)) {
                        str3 = "MicroMsg.BackupPackMsgLogic";
                        str5 = "recoverMsg fromUserName or toUserName is null, fromUserName[%s], toUserName[%s]";
                        Object[] objArr = new Object[2];
                        if (str2 == null) {
                            str2 = "null";
                        }
                        objArr[0] = str2;
                        if (str4 == null) {
                            str4 = "null";
                        }
                        objArr[1] = str4;
                        x.w(str3, str5, objArr);
                    } else {
                        x.i("MicroMsg.BackupPackMsgLogic", "recoverMsg, type[%d], from[%s], to[%s]", new Object[]{Integer.valueOf(eyVar.hcE), str2, str4});
                        com.tencent.mm.plugin.backup.bakoldlogic.d.c atm = b.atl().atm();
                        if (atm.uin == 0) {
                            throw new com.tencent.mm.model.b();
                        }
                        i iVar = atm.gYI;
                        ay FR = b.atl().atm().FR();
                        Object obj = (iVar.has(str2) || str3.equals(str2)) ? 1 : null;
                        str5 = obj != null ? str4 : str2;
                        long j = eyVar.rfC != 0 ? eyVar.rfC : ((long) eyVar.rfu) * 1000;
                        hashSet.add(str5);
                        List arb = a.arb();
                        if (arb.contains(str2) || arb.contains(str4)) {
                            x.w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: " + str2 + " " + str4);
                        } else {
                            if (eyVar.rcq == 0 && eyVar.rci != 0) {
                                eyVar.rcq = (long) eyVar.rci;
                            }
                            if (eyVar.rcq != 0) {
                                if (!str3.equals(str2)) {
                                    str4 = str2;
                                }
                                bd I = FT.I(str4, eyVar.rcq);
                                if (I.field_msgId != 0) {
                                    x.i("MicroMsg.BackupPackMsgLogic", "recoverMsg msg exist");
                                } else {
                                    if (eyVar.rcq != 0) {
                                        I.ax(eyVar.rcq);
                                    }
                                    I.aA((long) eyVar.rfB);
                                    I.ay(j);
                                    I.fg(eyVar.rfD);
                                    I.setType(eyVar.hcE);
                                    com.tencent.mm.storage.ab Yg = FR.Yg(str5);
                                    if (Yg == null || bi.oW(Yg.field_username) || !Yg.ckW()) {
                                        I.eX(obj != null ? 1 : 0);
                                        I.ep(str5);
                                        I.setStatus(obj != null ? eyVar.rft : 4);
                                        if (hashMap.get(str5) == null) {
                                            hashMap.put(str5, Integer.valueOf(0));
                                        }
                                        if (obj == null && eyVar.rft == 3) {
                                            hashMap.put(str5, Integer.valueOf(bi.a((Integer) hashMap.get(str5), 0) + 1));
                                        }
                                        j mN = com.tencent.mm.plugin.backup.bakoldlogic.b.d.asM().mN(eyVar.hcE);
                                        if (mN == null) {
                                            x.i("MicroMsg.BackupPackMsgLogic", "recoverMsg unknown type");
                                        } else {
                                            mN.a(str3, eyVar, I);
                                        }
                                    } else {
                                        x.w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: " + str5);
                                    }
                                }
                            } else {
                                x.w("MicroMsg.BackupPackMsgLogic", "recoverMsg drop the item server id < 0");
                            }
                        }
                    }
                    this.gZI++;
                    if (this.gZI % 100 == 0) {
                        atf();
                    }
                } catch (Throwable e22) {
                    x.e("MicroMsg.RecoverPCServer", "readFromSdcard err:" + e22.toString());
                    x.printErrStackTrace("MicroMsg.RecoverPCServer", e22, "", new Object[0]);
                }
                com.tencent.mm.plugin.backup.b.e.mz(eyVar.hcE);
                long VF = bi.VF();
                if (VF - cVar.dDj > 10000) {
                    cVar.end();
                    cVar.begin();
                    cVar.dDj = VF;
                }
            }
            com.tencent.mm.plugin.backup.b.e.aro();
            x.d("MicroMsg.RecoverPCServer", "read item time " + (System.currentTimeMillis() - currentTimeMillis));
            return ezVar.hbG.size();
        } catch (Throwable e3) {
            e22 = e3;
            String str6 = "MicroMsg.RecoverPCServer";
            str2 = "read mmPath errr %s, %s, len:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = str;
            objArr2[1] = e22;
            objArr2[2] = Integer.valueOf(f == null ? 0 : f.length);
            x.e(str6, str2, objArr2);
            x.printErrStackTrace("MicroMsg.RecoverPCServer", e22, "", new Object[0]);
            return 0;
        }
    }

    public final void atf() {
        System.gc();
        long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
        long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
        x.i("MicroMsg.RecoverPCServer", "memoryInfo avail/total, dalvik[%dk, %dk, user:%dk], recoverCnt:%d", new Object[]{Long.valueOf(freeMemory), Long.valueOf(totalMemory), Long.valueOf(totalMemory - freeMemory), Integer.valueOf(this.gZI)});
    }

    public final void a(int i, int i2, l lVar) {
        this.hah += (long) i;
        int i3 = this.hag == 0 ? 0 : (int) ((this.hah * 100) / this.hag);
        if (i3 > this.hai) {
            this.hai = i3;
            com.tencent.mm.plugin.backup.bakoldlogic.c.d.setProgress(this.hai);
        }
        if (this.bPd || this.dJO || this.gZC == null || this.hai < 0 || this.hai > 100) {
            x.d("MicroMsg.RecoverPCServer", "failed to call operatorCallback.onNetProgress:%d", new Object[]{Integer.valueOf(this.hai)});
        } else {
            this.gZC.mT(this.hai);
        }
    }
}
