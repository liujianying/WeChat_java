package com.tencent.mm.app;

import com.tencent.mm.app.WorkerProfile.21;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.Statistics;
import com.tencent.mm.modelsfs.SFSContext.Statistics.BlockType;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.TreeMap;

class WorkerProfile$21$1 implements Runnable {
    int bzU;
    long bzV;
    Map<String, Statistics> bzW;
    final /* synthetic */ 21 bzX;

    WorkerProfile$21$1(21 21) {
        this.bzX = 21;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r18 = this;
        r0 = r18;
        r2 = r0.bzV;
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x0017;
    L_0x000a:
        r0 = r18;
        r2 = r0.bzU;
        com.tencent.mm.model.au.HU();
        r3 = com.tencent.mm.model.c.Df();
        if (r2 == r3) goto L_0x0025;
    L_0x0017:
        r18.load();
        com.tencent.mm.model.au.HU();
        r2 = com.tencent.mm.model.c.Df();
        r0 = r18;
        r0.bzU = r2;
    L_0x0025:
        r2 = java.lang.System.currentTimeMillis();
        r0 = r18;
        r4 = r0.bzV;
        r2 = r2 - r4;
        r4 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 >= 0) goto L_0x0036;
    L_0x0035:
        return;
    L_0x0036:
        r7 = com.tencent.mm.modelsfs.FileOp.QH();
        r0 = r18;
        r2 = r0.bzW;
        if (r2 == 0) goto L_0x020d;
    L_0x0040:
        r2 = r7.entrySet();
        r8 = r2.iterator();
    L_0x0048:
        r2 = r8.hasNext();
        if (r2 == 0) goto L_0x01a8;
    L_0x004e:
        r2 = r8.next();
        r2 = (java.util.Map.Entry) r2;
        r3 = r2.getValue();
        r3 = (com.tencent.mm.modelsfs.SFSContext.Statistics) r3;
        r0 = r18;
        r4 = r0.bzW;
        r5 = r2.getKey();
        r4 = r4.get(r5);
        r4 = (com.tencent.mm.modelsfs.SFSContext.Statistics) r4;
        if (r4 == 0) goto L_0x0048;
    L_0x006a:
        if (r3 == 0) goto L_0x0048;
    L_0x006c:
        r5 = 1;
        r5 = a(r3, r5);
        r6 = 0;
        r6 = a(r3, r6);
        r9 = com.tencent.mm.plugin.report.service.h.mEJ;
        r10 = 12671; // 0x317f float:1.7756E-41 double:6.2603E-320;
        r11 = 15;
        r11 = new java.lang.Object[r11];
        r12 = 0;
        r13 = r2.getKey();
        r11[r12] = r13;
        r12 = 1;
        r14 = r3.totalActualSize;
        r13 = java.lang.Long.valueOf(r14);
        r11[r12] = r13;
        r12 = 2;
        r14 = r3.blockSizeUsed;
        r13 = java.lang.Long.valueOf(r14);
        r11[r12] = r13;
        r12 = 3;
        r14 = r3.blockSizeEmpty;
        r13 = java.lang.Long.valueOf(r14);
        r11[r12] = r13;
        r12 = 4;
        r14 = r3.overflowActualSize;
        r13 = java.lang.Long.valueOf(r14);
        r11[r12] = r13;
        r12 = 5;
        r13 = java.lang.Integer.valueOf(r5);
        r11[r12] = r13;
        r12 = 6;
        r13 = java.lang.Integer.valueOf(r6);
        r11[r12] = r13;
        r12 = 7;
        r14 = r3.totalActualSize;
        r0 = r4.totalActualSize;
        r16 = r0;
        r14 = r14 - r16;
        r13 = java.lang.Long.valueOf(r14);
        r11[r12] = r13;
        r12 = 8;
        r14 = r3.blockSizeUsed;
        r0 = r4.blockSizeUsed;
        r16 = r0;
        r14 = r14 - r16;
        r13 = java.lang.Long.valueOf(r14);
        r11[r12] = r13;
        r12 = 9;
        r14 = r3.blockSizeEmpty;
        r0 = r4.blockSizeEmpty;
        r16 = r0;
        r14 = r14 - r16;
        r13 = java.lang.Long.valueOf(r14);
        r11[r12] = r13;
        r12 = 10;
        r14 = r3.overflowActualSize;
        r0 = r4.overflowActualSize;
        r16 = r0;
        r14 = r14 - r16;
        r13 = java.lang.Long.valueOf(r14);
        r11[r12] = r13;
        r12 = 11;
        r13 = 1;
        r13 = a(r4, r13);
        r5 = r5 - r13;
        r5 = java.lang.Integer.valueOf(r5);
        r11[r12] = r5;
        r5 = 12;
        r12 = 0;
        r12 = a(r4, r12);
        r6 = r6 - r12;
        r6 = java.lang.Integer.valueOf(r6);
        r11[r5] = r6;
        r5 = 13;
        r6 = r3.blockFiles;
        r6 = r6.length;
        r6 = java.lang.Integer.valueOf(r6);
        r11[r5] = r6;
        r12 = 14;
        r5 = 0;
        r13 = r3.blockFiles;
        r14 = r13.length;
        r6 = 0;
    L_0x0124:
        if (r6 >= r14) goto L_0x0131;
    L_0x0126:
        r15 = r13[r6];
        r15 = r15.deleted;
        if (r15 == 0) goto L_0x012e;
    L_0x012c:
        r5 = r5 + 1;
    L_0x012e:
        r6 = r6 + 1;
        goto L_0x0124;
    L_0x0131:
        r5 = java.lang.Integer.valueOf(r5);
        r11[r12] = r5;
        r9.h(r10, r11);
        r5 = 0;
    L_0x013b:
        r6 = r3.blockTypes;
        r6 = r6.length;
        if (r5 >= r6) goto L_0x0048;
    L_0x0140:
        r6 = r3.blockTypes;
        r6 = r6[r5];
        r9 = r4.blockTypes;
        r9 = r9[r5];
        r10 = com.tencent.mm.plugin.report.service.h.mEJ;
        r11 = 12672; // 0x3180 float:1.7757E-41 double:6.261E-320;
        r12 = 8;
        r12 = new java.lang.Object[r12];
        r13 = 0;
        r14 = r2.getKey();
        r12[r13] = r14;
        r13 = 1;
        r14 = r6.blockSize;
        r14 = java.lang.Integer.valueOf(r14);
        r12[r13] = r14;
        r13 = 2;
        r14 = r6.usedCount;
        r14 = java.lang.Integer.valueOf(r14);
        r12[r13] = r14;
        r13 = 3;
        r14 = r6.emptyCount;
        r14 = java.lang.Integer.valueOf(r14);
        r12[r13] = r14;
        r13 = 4;
        r14 = r6.actualSize;
        r14 = java.lang.Long.valueOf(r14);
        r12[r13] = r14;
        r13 = 5;
        r14 = r6.usedCount;
        r15 = r9.usedCount;
        r14 = r14 - r15;
        r14 = java.lang.Integer.valueOf(r14);
        r12[r13] = r14;
        r13 = 6;
        r14 = r6.emptyCount;
        r15 = r9.emptyCount;
        r14 = r14 - r15;
        r14 = java.lang.Integer.valueOf(r14);
        r12[r13] = r14;
        r13 = 7;
        r14 = r6.actualSize;
        r0 = r9.actualSize;
        r16 = r0;
        r14 = r14 - r16;
        r6 = java.lang.Long.valueOf(r14);
        r12[r13] = r6;
        r10.h(r11, r12);
        r5 = r5 + 1;
        goto L_0x013b;
    L_0x01a8:
        r0 = r18;
        r0.bzW = r7;
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0200 }
        r2 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r4.<init>(r2);	 Catch:{ Exception -> 0x0200 }
        r2 = "Reported SFS statistics:\n";
        r4.append(r2);	 Catch:{ Exception -> 0x0200 }
        r0 = r18;
        r2 = r0.bzW;	 Catch:{ Exception -> 0x0200 }
        r2 = r2.entrySet();	 Catch:{ Exception -> 0x0200 }
        r5 = r2.iterator();	 Catch:{ Exception -> 0x0200 }
    L_0x01c5:
        r2 = r5.hasNext();	 Catch:{ Exception -> 0x0200 }
        if (r2 == 0) goto L_0x021e;
    L_0x01cb:
        r2 = r5.next();	 Catch:{ Exception -> 0x0200 }
        r0 = r2;
        r0 = (java.util.Map.Entry) r0;	 Catch:{ Exception -> 0x0200 }
        r3 = r0;
        r2 = "===== ";
        r6 = r4.append(r2);	 Catch:{ Exception -> 0x0200 }
        r2 = r3.getKey();	 Catch:{ Exception -> 0x0200 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0200 }
        r2 = r6.append(r2);	 Catch:{ Exception -> 0x0200 }
        r6 = " =====\n";
        r6 = r2.append(r6);	 Catch:{ Exception -> 0x0200 }
        r2 = r3.getValue();	 Catch:{ Exception -> 0x0200 }
        r2 = (com.tencent.mm.modelsfs.SFSContext.Statistics) r2;	 Catch:{ Exception -> 0x0200 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0200 }
        r2 = r6.append(r2);	 Catch:{ Exception -> 0x0200 }
        r3 = "\n\n";
        r2.append(r3);	 Catch:{ Exception -> 0x0200 }
        goto L_0x01c5;
    L_0x0200:
        r2 = move-exception;
        r3 = "MicroMsg.WorkerProfile";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
    L_0x020d:
        r2 = java.lang.System.currentTimeMillis();
        r0 = r18;
        r0.bzV = r2;
        r0 = r18;
        r0.bzW = r7;
        r18.save();
        goto L_0x0035;
    L_0x021e:
        r2 = "MicroMsg.WorkerProfile";
        r3 = r4.toString();	 Catch:{ Exception -> 0x0200 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);	 Catch:{ Exception -> 0x0200 }
        goto L_0x020d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.app.WorkerProfile$21$1.run():void");
    }

    private boolean load() {
        Throwable th;
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2 = null;
        x.i("MicroMsg.WorkerProfile", "Load previous SFS statistics.");
        try {
            StringBuilder stringBuilder = new StringBuilder();
            au.HU();
            ObjectInputStream objectInputStream3 = new ObjectInputStream(new FileInputStream(stringBuilder.append(c.Gp()).append("sfs/sfs_stats.bin").toString()));
            try {
                this.bzV = objectInputStream3.readLong();
                this.bzW = (TreeMap) objectInputStream3.readObject();
                try {
                    objectInputStream3.close();
                } catch (IOException e) {
                }
                return true;
            } catch (Exception e2) {
                objectInputStream2 = objectInputStream3;
                try {
                    x.e("MicroMsg.WorkerProfile", "Can't read previous SFS statistics, use default.");
                    this.bzV = System.currentTimeMillis();
                    this.bzW = null;
                    if (objectInputStream2 != null) {
                        try {
                            objectInputStream2.close();
                        } catch (IOException e3) {
                        }
                    }
                    return save();
                } catch (Throwable th2) {
                    th = th2;
                    objectInputStream = objectInputStream2;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                objectInputStream = objectInputStream3;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e42) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            x.e("MicroMsg.WorkerProfile", "Can't read previous SFS statistics, use default.");
            this.bzV = System.currentTimeMillis();
            this.bzW = null;
            if (objectInputStream2 != null) {
                try {
                    objectInputStream2.close();
                } catch (IOException e32) {
                }
            }
            return save();
        } catch (Throwable th22) {
            th = th22;
            objectInputStream = null;
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e422) {
                }
            }
            throw th;
        }
    }

    private boolean save() {
        Throwable e;
        Throwable th;
        ObjectOutputStream objectOutputStream = null;
        x.i("MicroMsg.WorkerProfile", "Save previous SFS statistics.");
        ObjectOutputStream objectOutputStream2;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            au.HU();
            String stringBuilder2 = stringBuilder.append(c.Gp()).append("sfs").toString();
            FileOp.mL(stringBuilder2);
            objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(stringBuilder2 + "/sfs_stats.bin"));
            try {
                Object treeMap;
                if (this.bzW != null) {
                    treeMap = new TreeMap(this.bzW);
                }
                objectOutputStream2.writeLong(this.bzV);
                objectOutputStream2.writeObject(treeMap);
                try {
                    objectOutputStream2.close();
                } catch (IOException e2) {
                }
                return true;
            } catch (IOException e3) {
                e = e3;
            }
        } catch (IOException e4) {
            e = e4;
            objectOutputStream2 = null;
            try {
                x.printErrStackTrace("MicroMsg.WorkerProfile", e, "Can't read previous SFS statistics, use default.", new Object[0]);
                if (objectOutputStream2 == null) {
                    return false;
                }
                try {
                    objectOutputStream2.close();
                    return false;
                } catch (IOException e5) {
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream = objectOutputStream2;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e6) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e62) {
                }
            }
            throw th;
        }
    }

    private static int a(Statistics statistics, boolean z) {
        int i = 0;
        for (BlockType blockType : statistics.blockTypes) {
            i += z ? blockType.usedCount : blockType.emptyCount;
        }
        return i;
    }
}
