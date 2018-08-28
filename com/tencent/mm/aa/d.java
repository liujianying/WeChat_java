package com.tencent.mm.aa;

import android.os.StatFs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteStatement;
import com.tencent.wcdb.support.CancellationSignal;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public final class d implements Runnable {
    private static final long dGF;
    private SQLiteDatabase dGG = new b().getWritableDatabase();
    final Object dGH = new Object();
    HashMap<String, Long> dGI = new HashMap();
    private final Runnable dGJ = new Runnable() {
        public final void run() {
            HashMap b;
            synchronized (d.this.dGH) {
                b = d.this.dGI;
                d.this.dGI = new HashMap();
            }
            x.i("MicroMsg.AvatarMigration", "Flushing access time cache, entries: " + b.size());
            SQLiteStatement compileStatement = d.this.dGG.compileStatement("INSERT OR REPLACE INTO AvatarFile (fileName, accessTime) VALUES (?, ?)");
            d.this.dGG.beginTransaction();
            try {
                for (Entry entry : b.entrySet()) {
                    compileStatement.bindString(1, (String) entry.getKey());
                    compileStatement.bindLong(2, ((Long) entry.getValue()).longValue());
                    compileStatement.execute();
                }
                d.this.dGG.setTransactionSuccessful();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AvatarMigration", e, "Failed to flush file access time cache.", new Object[0]);
            } finally {
                d.this.dGG.endTransaction();
                compileStatement.close();
            }
        }
    };
    final Runnable dGK = new Runnable() {
        public final void run() {
            e.b(d.this.dGJ, "Avatar Access Time Flusher", 4);
        }
    };
    CancellationSignal mCancellationSignal;

    private static class a {
        int dGN;
        int dGO;
        boolean dGP;
        String name;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    private static class b {
        int dGN;
        boolean dGP;
        long dGQ;
        boolean dGR;
        String name;
        long size;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    static /* synthetic */ int aZ(long j) {
        if (j == 0) {
            return 0;
        }
        return j > 0 ? 1 : -1;
    }

    static {
        int blockSize = new StatFs(g.Ei().cachePath).getBlockSize();
        if (((blockSize - 1) & blockSize) == 0) {
            dGF = (long) blockSize;
        } else {
            dGF = 1;
        }
    }

    private void throwIfCanceled() {
        if (this.mCancellationSignal != null) {
            this.mCancellationSignal.throwIfCanceled();
        }
    }

    private HashMap<String, Long> Ko() {
        HashMap<String, Long> hashMap = new HashMap();
        Cursor rawQueryWithFactory = this.dGG.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT * FROM AvatarFile", null, "AvatarFile", this.mCancellationSignal);
        while (rawQueryWithFactory.moveToNext()) {
            try {
                hashMap.put(rawQueryWithFactory.getString(0), Long.valueOf(rawQueryWithFactory.getLong(1)));
            } finally {
                rawQueryWithFactory.close();
            }
        }
        x.i("MicroMsg.AvatarMigration", "Loaded access time from database, entries: " + hashMap.size());
        return hashMap;
    }

    private void i(HashMap<String, Long> hashMap) {
        if (hashMap != null && !hashMap.isEmpty()) {
            SQLiteStatement compileStatement = this.dGG.compileStatement("DELETE FROM AvatarFile WHERE fileName = ?");
            this.dGG.beginTransaction();
            try {
                for (String bindString : hashMap.keySet()) {
                    compileStatement.bindString(1, bindString);
                    compileStatement.execute(this.mCancellationSignal);
                }
                this.dGG.setTransactionSuccessful();
                x.i("MicroMsg.AvatarMigration", "Removed unused access time from database, entries: " + hashMap.size());
            } finally {
                this.dGG.endTransaction();
                compileStatement.close();
            }
        }
    }

    private long a(File file, int i, List<b> list, List<a> list2, boolean z, HashMap<String, Long> hashMap) {
        a aVar;
        int i2;
        throwIfCanceled();
        long j = 0;
        if (i > 0) {
            int size = list2.size() - 1;
            aVar = (a) list2.get(size);
            i2 = size;
        } else {
            aVar = null;
            i2 = -1;
        }
        if (i < 2) {
            File[] listFiles = file.listFiles(new FileFilter() {
                public final boolean accept(File file) {
                    return file.isDirectory() && file.getName().length() == 2;
                }
            });
            if (listFiles == null) {
                return 0;
            }
            long j2 = 0;
            for (File file2 : listFiles) {
                a aVar2 = new a();
                aVar2.dGN = i2;
                aVar2.dGP = z;
                if (aVar != null) {
                    aVar.dGO++;
                    aVar2.name = aVar.name + '/' + file2.getName();
                } else {
                    aVar2.name = file2.getName();
                }
                list2.add(aVar2);
                j2 += a(file2, i + 1, list, list2, z, hashMap);
            }
            return j2;
        }
        File[] listFiles2 = file.listFiles(new FileFilter() {
            public final boolean accept(File file) {
                return file.isFile() && file.getName().startsWith("user_");
            }
        });
        if (listFiles2 == null) {
            return 0;
        }
        for (File file22 : listFiles2) {
            b bVar = new b();
            bVar.name = file22.getName();
            bVar.size = ((file22.length() + dGF) - 1) & ((dGF - 1) ^ -1);
            bVar.dGR = bVar.name.startsWith("user_hd_");
            bVar.dGP = z;
            bVar.dGN = i2;
            if (aVar != null) {
                aVar.dGO++;
            }
            Long l = (Long) hashMap.remove(bVar.name);
            bVar.dGQ = l != null ? l.longValue() : file22.lastModified();
            list.add(bVar);
            j += bVar.size;
        }
        return j;
    }

    private static String a(b bVar) {
        int i = bVar.dGR ? 8 : 5;
        String substring = bVar.name.substring(i, i + 2);
        String substring2 = bVar.name.substring(i + 2, i + 4);
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append(bVar.dGP ? g.Ei().dqp : g.Ei().cachePath);
        stringBuilder.append("avatar/").append(substring).append('/').append(substring2).append('/').append(bVar.name);
        return stringBuilder.toString();
    }

    private static String a(a aVar) {
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append(aVar.dGP ? g.Ei().dqp : g.Ei().cachePath);
        stringBuilder.append("avatar/").append(aVar.name);
        return stringBuilder.toString();
    }

    private static void be(int i, int i2) {
        if (i2 > 0) {
            f.mDy.a(857, (long) i, (long) i2, false);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r28 = this;
        r2 = com.tencent.mm.kernel.g.Ei();
        r2 = r2.DT();
        r3 = com.tencent.mm.storage.aa.a.USERINFO_AVATAR_LAST_MIGRATION_FINISH_LONG;
        r2 = r2.i(r3);
        r4 = java.lang.System.currentTimeMillis();
        r2 = r4 - r2;
        r4 = 259200000; // 0xf731400 float:1.1984677E-29 double:1.280618154E-315;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 >= 0) goto L_0x0025;
    L_0x001b:
        r2 = "MicroMsg.AvatarMigration";
        r3 = "Migration interval not reached, just return";
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
    L_0x0024:
        return;
    L_0x0025:
        r2 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r3 = "power";
        r2 = r2.getSystemService(r3);
        r2 = (android.os.PowerManager) r2;
        r3 = 1;
        r4 = "MicroMsg.AvatarMigration";
        r10 = r2.newWakeLock(r3, r4);
        r12 = android.os.SystemClock.uptimeMillis();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = 600000; // 0x927c0 float:8.40779E-40 double:2.964394E-318;
        r10.acquire(r2);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = "MicroMsg.AvatarMigration";
        r3 = "Avatar migration task started.";
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = 0;
        r3 = 1;
        be(r2, r3);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = com.tencent.mm.kernel.g.Em();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = r2.cil();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r0 = r28;
        r3 = r0.dGK;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2.removeCallbacks(r3);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r0 = r28;
        r2 = r0.dGJ;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2.run();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r28.throwIfCanceled();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r8 = r28.Ko();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r5 = new java.util.ArrayList;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r5.<init>(r2);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r6 = new java.util.ArrayList;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r6.<init>(r2);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r3 = new java.io.File;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = com.tencent.mm.kernel.g.Ei();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = r2.cachePath;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r4 = "avatar";
        r3.<init>(r2, r4);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = r3.isDirectory();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        if (r2 != 0) goto L_0x0097;
    L_0x0091:
        r3.delete();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r3.mkdirs();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
    L_0x0097:
        r4 = 0;
        r7 = 0;
        r2 = r28;
        r14 = r2.a(r3, r4, r5, r6, r7, r8);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r11 = r5.size();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r16 = r6.size();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = "MicroMsg.AvatarMigration";
        r3 = "Listed all files in DATA, count: %d, totalSize: %d";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r7 = 0;
        r9 = java.lang.Integer.valueOf(r11);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r4[r7] = r9;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r7 = 1;
        r9 = java.lang.Long.valueOf(r14);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r4[r7] = r9;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r3 = new java.io.File;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = com.tencent.mm.kernel.g.Ei();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = r2.dqp;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r4 = "avatar";
        r3.<init>(r2, r4);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r4 = 0;
        r7 = 1;
        r2 = r28;
        r18 = r2.a(r3, r4, r5, r6, r7, r8);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = r5.size();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r7 = r2 - r11;
        r2 = r6.size();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r17 = r2 - r16;
        r2 = "MicroMsg.AvatarMigration";
        r3 = "Listed all files in STORAGE, count: %d, totalSize: %d";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r9 = 0;
        r20 = java.lang.Integer.valueOf(r7);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r4[r9] = r20;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r9 = 1;
        r20 = java.lang.Long.valueOf(r18);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r4[r9] = r20;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = r14 + r18;
        r20 = dGF;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r4 = r6.size();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r0 = (long) r4;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r22 = r0;
        r20 = r20 * r22;
        r20 = r20 + r2;
        r0 = r28;
        r0.i(r8);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = 0;
        r3 = 0;
        r8 = 536870912; // 0x20000000 float:1.0842022E-19 double:2.652494739E-315;
        r4 = (r20 > r8 ? 1 : (r20 == r8 ? 0 : -1));
        if (r4 <= 0) goto L_0x01d2;
    L_0x011a:
        r4 = 1;
    L_0x011b:
        if (r4 == 0) goto L_0x0385;
    L_0x011d:
        r2 = android.os.Environment.getDataDirectory();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r8 = r2.getTotalSpace();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r22 = r2.getFreeSpace();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r24 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r8 = (double) r8;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r26 = 4585925428558828667; // 0x3fa47ae147ae147b float:89128.96 double:0.04;
        r8 = r8 * r26;
        r8 = (long) r8;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r0 = r24;
        r8 = java.lang.Math.min(r0, r8);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r22 = r22 + r20;
        r8 = r22 - r8;
        r22 = 402653184; // 0x18000000 float:1.6543612E-24 double:1.989371054E-315;
        r2 = (r8 > r22 ? 1 : (r8 == r22 ? 0 : -1));
        if (r2 <= 0) goto L_0x0203;
    L_0x0146:
        r8 = 402653184; // 0x18000000 float:1.6543612E-24 double:1.989371054E-315;
    L_0x0149:
        r8 = r20 - r8;
        r20 = 0;
        r2 = (r8 > r20 ? 1 : (r8 == r20 ? 0 : -1));
        if (r2 <= 0) goto L_0x0212;
    L_0x0151:
        r2 = "MicroMsg.AvatarMigration";
        r4 = "Avatar cleanup threshold reached, size to remove: %.2f MB";
        r20 = 1;
        r0 = r20;
        r0 = new java.lang.Object[r0];	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r20 = r0;
        r21 = 0;
        r0 = (double) r8;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r22 = r0;
        r24 = 4697254411347427328; // 0x4130000000000000 float:0.0 double:1048576.0;
        r22 = r22 / r24;
        r22 = java.lang.Double.valueOf(r22);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r20[r21] = r22;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r0 = r20;
        com.tencent.mm.sdk.platformtools.x.i(r2, r4, r0);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = new com.tencent.mm.aa.d$5;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r0 = r28;
        r2.<init>();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        java.util.Collections.sort(r5, r2);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = r5.size();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = r2 + -1;
    L_0x0183:
        r20 = 0;
        r4 = (r8 > r20 ? 1 : (r8 == r20 ? 0 : -1));
        if (r4 <= 0) goto L_0x0212;
    L_0x0189:
        if (r2 < 0) goto L_0x0212;
    L_0x018b:
        r28.throwIfCanceled();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r4 = r2 + -1;
        r2 = r5.get(r2);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = (com.tencent.mm.aa.d.b) r2;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r20 = a(r2);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r20 = com.tencent.mm.modelsfs.FileOp.deleteFile(r20);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        if (r20 == 0) goto L_0x01a6;
    L_0x01a0:
        r0 = r2.size;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r20 = r0;
        r8 = r8 - r20;
    L_0x01a6:
        r2 = r2.dGN;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
    L_0x01a8:
        if (r2 < 0) goto L_0x020f;
    L_0x01aa:
        r2 = r6.get(r2);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = (com.tencent.mm.aa.d.a) r2;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r0 = r2.dGO;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r20 = r0;
        r20 = r20 + -1;
        r0 = r20;
        r2.dGO = r0;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        if (r20 != 0) goto L_0x020f;
    L_0x01bc:
        r20 = new java.io.File;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r21 = a(r2);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r20.<init>(r21);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r20 = r20.delete();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        if (r20 == 0) goto L_0x020f;
    L_0x01cb:
        r20 = dGF;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r8 = r8 - r20;
        r2 = r2.dGN;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        goto L_0x01a8;
    L_0x01d2:
        r4 = android.os.Environment.getDataDirectory();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r8 = r4.getTotalSpace();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r22 = r4.getFreeSpace();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r24 = 0;
        r4 = (r8 > r24 ? 1 : (r8 == r24 ? 0 : -1));
        if (r4 != 0) goto L_0x01e7;
    L_0x01e4:
        r4 = 1;
        goto L_0x011b;
    L_0x01e7:
        r24 = 786432000; // 0x2ee00000 float:1.0186341E-10 double:3.88549034E-315;
        r8 = (double) r8;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r26 = 4584304132692975288; // 0x3f9eb851eb851eb8 float:-3.218644E26 double:0.03;
        r8 = r8 * r26;
        r8 = (long) r8;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r0 = r24;
        r8 = java.lang.Math.min(r0, r8);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r4 = (r22 > r8 ? 1 : (r22 == r8 ? 0 : -1));
        if (r4 >= 0) goto L_0x0200;
    L_0x01fd:
        r4 = 1;
        goto L_0x011b;
    L_0x0200:
        r4 = 0;
        goto L_0x011b;
    L_0x0203:
        r22 = 25165824; // 0x1800000 float:4.7019774E-38 double:1.2433569E-316;
        r2 = (r8 > r22 ? 1 : (r8 == r22 ? 0 : -1));
        if (r2 >= 0) goto L_0x0149;
    L_0x020a:
        r8 = 25165824; // 0x1800000 float:4.7019774E-38 double:1.2433569E-316;
        goto L_0x0149;
    L_0x020f:
        r2 = r4;
        goto L_0x0183;
    L_0x0212:
        r2 = 1;
        r4 = r2;
    L_0x0214:
        if (r7 <= 0) goto L_0x02b2;
    L_0x0216:
        r2 = "MicroMsg.AvatarMigration";
        r3 = "Migrate from STORAGE to DATA.";
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = com.tencent.mm.kernel.g.Ei();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = r2.dqp;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r8 = r2.length();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = com.tencent.mm.kernel.g.Ei();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r9 = r2.cachePath;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r5 = r5.iterator();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
    L_0x0233:
        r2 = r5.hasNext();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        if (r2 == 0) goto L_0x02b0;
    L_0x0239:
        r2 = r5.next();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = (com.tencent.mm.aa.d.b) r2;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r28.throwIfCanceled();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r3 = r2.dGP;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        if (r3 == 0) goto L_0x0233;
    L_0x0246:
        r20 = a(r2);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r3 = new java.lang.StringBuilder;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r3.<init>();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r3 = r3.append(r9);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r0 = r20;
        r21 = r0.substring(r8);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r0 = r21;
        r3 = r3.append(r0);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r21 = r3.toString();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r3 = 0;
        r22 = com.tencent.mm.modelsfs.FileOp.cn(r21);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        if (r22 != 0) goto L_0x0284;
    L_0x026a:
        r22 = new java.io.File;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r0 = r22;
        r1 = r21;
        r0.<init>(r1);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r22 = r22.getParentFile();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r22.mkdirs();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r22 = com.tencent.mm.modelsfs.FileOp.y(r20, r21);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r24 = 0;
        r21 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1));
        if (r21 < 0) goto L_0x0288;
    L_0x0284:
        r3 = com.tencent.mm.modelsfs.FileOp.deleteFile(r20);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
    L_0x0288:
        if (r3 == 0) goto L_0x0233;
    L_0x028a:
        r2 = r2.dGN;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
    L_0x028c:
        if (r2 < 0) goto L_0x0233;
    L_0x028e:
        r2 = r6.get(r2);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = (com.tencent.mm.aa.d.a) r2;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r3 = r2.dGO;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r3 = r3 + -1;
        r2.dGO = r3;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        if (r3 != 0) goto L_0x0233;
    L_0x029c:
        r3 = new java.io.File;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r20 = a(r2);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r0 = r20;
        r3.<init>(r0);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r3 = r3.delete();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        if (r3 == 0) goto L_0x0233;
    L_0x02ad:
        r2 = r2.dGN;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        goto L_0x028c;
    L_0x02b0:
        r2 = 1;
        r3 = r2;
    L_0x02b2:
        r2 = com.tencent.mm.kernel.g.Ei();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = r2.DT();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r5 = com.tencent.mm.storage.aa.a.USERINFO_AVATAR_LAST_MIGRATION_FINISH_LONG;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r6 = java.lang.Long.valueOf(r8);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2.a(r5, r6);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r8 = android.os.SystemClock.uptimeMillis();	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r8 = r8 - r12;
        r12 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r8 = r8 / r12;
        r2 = "MicroMsg.AvatarMigration";
        r5 = "Avatar migration finished, elapsed %d seconds.";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r12 = 0;
        r13 = java.lang.Long.valueOf(r8);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r6[r12] = r13;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r5, r6);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = 3;
        r5 = 1;
        be(r2, r5);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = 5;
        r5 = (int) r8;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        be(r2, r5);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r5 = 6;
        if (r4 == 0) goto L_0x0332;
    L_0x02ef:
        r2 = 1;
    L_0x02f0:
        be(r5, r2);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r4 = 7;
        if (r3 == 0) goto L_0x0334;
    L_0x02f6:
        r2 = 1;
    L_0x02f7:
        be(r4, r2);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = 9;
        be(r2, r11);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = 11;
        r4 = dGF;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r0 = r16;
        r8 = (long) r0;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r4 = r4 * r8;
        r4 = r4 + r14;
        r8 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;
        r4 = r4 / r8;
        r3 = (int) r4;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        be(r2, r3);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = 13;
        be(r2, r7);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = 15;
        r4 = dGF;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r0 = r17;
        r6 = (long) r0;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r4 = r4 * r6;
        r4 = r4 + r18;
        r6 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;
        r4 = r4 / r6;
        r3 = (int) r4;	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        be(r2, r3);	 Catch:{ OperationCanceledException -> 0x0336, Exception -> 0x0350 }
        r2 = r10.isHeld();
        if (r2 == 0) goto L_0x0024;
    L_0x032d:
        r10.release();
        goto L_0x0024;
    L_0x0332:
        r2 = 0;
        goto L_0x02f0;
    L_0x0334:
        r2 = 0;
        goto L_0x02f7;
    L_0x0336:
        r2 = move-exception;
        r2 = "MicroMsg.AvatarMigration";
        r3 = "Avatar migration task cancelled.";
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);	 Catch:{ all -> 0x037a }
        r2 = 1;
        r3 = 1;
        be(r2, r3);	 Catch:{ all -> 0x037a }
        r2 = r10.isHeld();
        if (r2 == 0) goto L_0x0024;
    L_0x034b:
        r10.release();
        goto L_0x0024;
    L_0x0350:
        r2 = move-exception;
        r3 = "MicroMsg.AvatarMigration";
        r4 = "Avatar migration failed.";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x037a }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);	 Catch:{ all -> 0x037a }
        r3 = 2;
        r4 = 1;
        be(r3, r4);	 Catch:{ all -> 0x037a }
        r3 = com.tencent.mm.plugin.report.f.mDy;	 Catch:{ all -> 0x037a }
        r4 = "MicroMsg.AvatarMigration";
        r2 = com.tencent.mm.sdk.platformtools.bi.i(r2);	 Catch:{ all -> 0x037a }
        r5 = 0;
        r3.c(r4, r2, r5);	 Catch:{ all -> 0x037a }
        r2 = r10.isHeld();
        if (r2 == 0) goto L_0x0024;
    L_0x0375:
        r10.release();
        goto L_0x0024;
    L_0x037a:
        r2 = move-exception;
        r3 = r10.isHeld();
        if (r3 == 0) goto L_0x0384;
    L_0x0381:
        r10.release();
    L_0x0384:
        throw r2;
    L_0x0385:
        r4 = r2;
        goto L_0x0214;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.aa.d.run():void");
    }
}
