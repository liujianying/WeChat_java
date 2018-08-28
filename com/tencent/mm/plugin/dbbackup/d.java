package com.tencent.mm.plugin.dbbackup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.mm.ak.o;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.f;
import com.tencent.mm.vfs.g;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.repair.BackupKit;
import com.tencent.wcdb.repair.RecoverKit;
import com.tencent.wcdb.repair.RepairKit;
import com.tencent.wcdb.repair.RepairKit.MasterInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public final class d implements ar {
    private static final SQLiteCipherSpec hZZ = new SQLiteCipherSpec().setPageSize(1024).setSQLCipherVersion(1);
    private volatile BackupKit hZL;
    private volatile RecoverKit hZM;
    private volatile RepairKit hZN;
    private volatile boolean hZO = false;
    private boolean hZP = false;
    private boolean hZQ = false;
    private long hZR = 0;
    private long hZS = 600000;
    private long hZT = 0;
    private int hZU = 10;
    private boolean hZV = false;
    final SimpleDateFormat hZW = new SimpleDateFormat("HH:mm:ss.SSS");
    private a hZX;
    private c hZY;
    private boolean hsR = false;
    private boolean hsS = true;
    private BroadcastReceiver hsT;
    private Runnable hsU;

    private static long[] yG(String str) {
        Throwable e;
        long j = 0;
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new f(str + ".bcur"));
            try {
                long parseLong;
                long parseLong2;
                long parseLong3;
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    parseLong = Long.parseLong(readLine);
                } else {
                    parseLong = 0;
                }
                readLine = bufferedReader.readLine();
                if (readLine != null) {
                    parseLong2 = Long.parseLong(readLine);
                } else {
                    parseLong2 = 0;
                }
                readLine = bufferedReader.readLine();
                if (readLine != null) {
                    parseLong3 = Long.parseLong(readLine);
                } else {
                    parseLong3 = 0;
                }
                readLine = bufferedReader.readLine();
                if (readLine != null) {
                    j = Long.parseLong(readLine);
                }
                long[] jArr = new long[]{parseLong, parseLong2, parseLong3, j};
                try {
                    bufferedReader.close();
                    return jArr;
                } catch (IOException e2) {
                    return jArr;
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    x.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to read previous cursor '%s'", new Object[]{str});
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw e;
                }
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
            x.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to read previous cursor '%s'", new Object[]{str});
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e42) {
                }
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e52) {
                }
            }
            throw e;
        }
    }

    private static boolean a(String str, long[] jArr) {
        Throwable e;
        g gVar;
        try {
            gVar = new g(str + ".bcur");
            try {
                for (long l : jArr) {
                    gVar.write(Long.toString(l) + "\n");
                }
                try {
                    gVar.close();
                    return true;
                } catch (IOException e2) {
                    return true;
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    x.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to write previous cursor '%s'", new Object[]{str});
                    if (gVar != null) {
                        try {
                            gVar.close();
                        } catch (IOException e4) {
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    e = th;
                    if (gVar != null) {
                        try {
                            gVar.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw e;
                }
            }
        } catch (IOException e6) {
            e = e6;
            gVar = null;
            x.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to write previous cursor '%s'", new Object[]{str});
            if (gVar != null) {
                try {
                    gVar.close();
                } catch (IOException e42) {
                }
            }
            return false;
        } catch (Throwable th2) {
            e = th2;
            gVar = null;
            if (gVar != null) {
                try {
                    gVar.close();
                } catch (IOException e52) {
                }
            }
            throw e;
        }
    }

    public final boolean a(boolean z, b bVar) {
        if (this.hZO) {
            x.i("MicroMsg.SubCoreDBBackup", "Backup or recover task is in progress, %s canceled", new Object[]{"backup"});
            return false;
        }
        long j;
        String[] strArr;
        boolean z2;
        int i;
        com.tencent.mm.model.c HU = au.HU();
        String DR = com.tencent.mm.model.c.DR();
        SQLiteDatabase coa = com.tencent.mm.model.c.FO().coa();
        String str = DR + ".bak";
        String str2 = str + ".tmp";
        String str3 = DR + ".sm";
        String str4 = str3 + ".tmp";
        int i2 = 8;
        if (z) {
            if (com.tencent.mm.vfs.d.cn(str)) {
                i2 = 24;
                com.tencent.mm.vfs.d.y(str, str2);
            } else {
                z = false;
            }
        }
        long j2 = -1;
        long j3 = -1;
        long j4 = -1;
        Cursor rawQueryWithFactory = coa.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(msgId) FROM message;", null, null);
        if (rawQueryWithFactory.moveToFirst()) {
            j = rawQueryWithFactory.getLong(0);
        } else {
            j = -1;
        }
        rawQueryWithFactory.close();
        rawQueryWithFactory = coa.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(id) FROM ImgInfo2;", null, null);
        if (rawQueryWithFactory.moveToFirst()) {
            j2 = rawQueryWithFactory.getLong(0);
        }
        rawQueryWithFactory.close();
        rawQueryWithFactory = coa.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(rowid) FROM videoinfo2;", null, null);
        if (rawQueryWithFactory.moveToFirst()) {
            j3 = rawQueryWithFactory.getLong(0);
        }
        rawQueryWithFactory.close();
        rawQueryWithFactory = coa.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(rowid) FROM EmojiInfo;", null, null);
        if (rawQueryWithFactory.moveToFirst()) {
            j4 = rawQueryWithFactory.getLong(0);
        }
        rawQueryWithFactory.close();
        long[] jArr = new long[]{j, j2, j3, j4};
        long[] yG = z ? yG(DR) : null;
        if (yG == null || yG.length < 4) {
            strArr = new String[]{"message", "msgId <= " + jArr[0], "ImgInfo2", "id <= " + jArr[1], "videoinfo2", "rowid <= " + jArr[2], "EmojiInfo", "rowid <= " + jArr[3], "conversation", null, "rconversation", null};
        } else {
            strArr = new String[12];
            strArr[0] = "message";
            strArr[1] = String.format("msgId > %d AND msgId <= %d", new Object[]{Long.valueOf(yG[0]), Long.valueOf(jArr[0])});
            strArr[2] = "ImgInfo2";
            strArr[3] = String.format("id > %d AND id <= %d", new Object[]{Long.valueOf(yG[1]), Long.valueOf(jArr[1])});
            strArr[4] = "videoinfo2";
            strArr[5] = String.format("rowid > %d AND rowid <= %d", new Object[]{Long.valueOf(yG[2]), Long.valueOf(jArr[2])});
            strArr[6] = "EmojiInfo";
            strArr[7] = String.format("rowid > %d AND rowid <= %d", new Object[]{Long.valueOf(yG[3]), Long.valueOf(jArr[3])});
            strArr[8] = "conversation";
            strArr[9] = null;
            strArr[10] = "rconversation";
            strArr[11] = null;
        }
        if (yG == null) {
            z2 = false;
        } else {
            z2 = z;
        }
        if (this.hZV) {
            i = i2 | 3;
        } else {
            i = i2;
        }
        1 1 = new 1(this, bVar, HU, str3, z2, coa, str4, DR, str2, yG, jArr, i, strArr, str);
        this.hZO = true;
        e.post(1, "DB Backup");
        return true;
    }

    public final synchronized boolean aCD() {
        boolean z = false;
        synchronized (this) {
            this.hZO = false;
            if (this.hZL != null) {
                this.hZL.onCancel();
                z = true;
            }
        }
        return z;
    }

    @Deprecated
    public final synchronized int a(String str, b bVar) {
        2 2 = new 2(this, au.HU(), str, bi.cja(), bVar);
        this.hZO = true;
        au.Em().uW();
        au.Em().L(2);
        return 0;
    }

    @Deprecated
    public final synchronized int b(String str, b bVar) {
        int i = 0;
        synchronized (this) {
            com.tencent.mm.model.c HU = au.HU();
            if (str == null) {
                str = com.tencent.mm.model.c.DP();
            }
            long cja = bi.cja();
            b bVar2 = str == null ? null : new b(str);
            if (bVar2 == null || !bVar2.canRead()) {
                i = -3;
            } else {
                x.i("MicroMsg.SubCoreDBBackup", "[Repair] inFileSize: %d, diskFreeSpace: %d", new Object[]{Long.valueOf(bVar2.length()), Long.valueOf(cja)});
                if (((float) cja) < ((float) bVar2.length()) * 1.5f) {
                    i = -2;
                } else {
                    3 3 = new 3(this, HU, str, bVar);
                    this.hZO = true;
                    au.Em().uW();
                    au.Em().L(3);
                }
            }
        }
        return i;
    }

    @Deprecated
    public final int a(b bVar) {
        au.HU();
        String DP = com.tencent.mm.model.c.DP();
        if (DP == null || DP.isEmpty()) {
            return -3;
        }
        b bVar2 = new b(DP);
        if (!bVar2.canRead()) {
            return -3;
        }
        StringBuilder append = new StringBuilder().append(q.zy());
        au.HU();
        String substring = com.tencent.mm.a.g.u(append.append(com.tencent.mm.model.c.Df()).toString().getBytes()).substring(0, 7);
        x.i("MicroMsg.SubCoreDBBackup", "db recover needSize : %d blockSize:%d", new Object[]{Long.valueOf(bVar2.length() * 2), Long.valueOf(bi.cja())});
        if (bi.cja() < bVar2.length() * 2) {
            return -2;
        }
        au.Em().uW();
        au.Em().L(new 4(this, bVar2, substring, bVar));
        return 0;
    }

    public final HashMap<Integer, com.tencent.mm.bt.h.d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        boolean z2;
        au.HU();
        com.tencent.mm.storage.x DT = com.tencent.mm.model.c.DT();
        SQLiteDatabase coa = com.tencent.mm.model.c.FO().coa();
        this.hZT = DT.Dj(237569);
        this.hZU = DT.getInt(237570, 10);
        this.hZV = DT.getInt(237571, 0) != 0;
        Context context = ad.getContext();
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            z2 = intExtra == 2 || intExtra == 5;
            this.hsR = z2;
        } else {
            this.hsR = false;
        }
        this.hsS = ((PowerManager) context.getSystemService("power")).isScreenOn();
        this.hZX = new 7(this);
        com.tencent.mm.model.c.c.Jx().c(this.hZX);
        aCE();
        this.hZY = new 8(this);
        com.tencent.mm.sdk.b.a.sFg.b(this.hZY);
        this.hsT = new 9(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        context.registerReceiver(this.hsT, intentFilter);
        com.tencent.mm.pluginsdk.cmd.b.a(new c(this), new String[]{"//recover-old", "//recover", "//post-recover", "//backupdb", "//recoverdb", "//repairdb", "//corruptdb", "//iotracedb", "//recover-status"});
        String str = "MicroMsg.SubCoreDBBackup";
        String str2 = "Auto database backup %s. Device status:%s interactive,%s charging.";
        Object[] objArr = new Object[3];
        objArr[0] = this.hZQ ? "enabled" : "disabled";
        objArr[1] = this.hsS ? "" : " not";
        objArr[2] = this.hsR ? "" : " not";
        x.i(str, str2, objArr);
        String str3 = coa.getPath() + ".sm";
        str = str3 + ".tmp";
        com.tencent.mm.storage.x DT2 = com.tencent.mm.kernel.g.Ei().DT();
        long Dj = DT2.Dj(237569);
        long currentTimeMillis = System.currentTimeMillis();
        b bVar = new b(str3);
        if (!bVar.isFile() || currentTimeMillis - Dj <= 86400000) {
            Dj = System.nanoTime();
            StringBuilder append = new StringBuilder().append(q.zy());
            au.HU();
            z2 = MasterInfo.save(coa, str, com.tencent.mm.a.g.v(append.append(com.tencent.mm.model.c.Df()).toString().getBytes()));
            b bVar2 = new b(str);
            if (z2) {
                bVar.delete();
                z2 = bVar2.a(bVar);
                DT2.setLong(237569, currentTimeMillis);
                DT2.lm(false);
            } else {
                bVar2.delete();
            }
            long nanoTime = System.nanoTime() - Dj;
            String str4 = "MicroMsg.SubCoreDBBackup";
            String str5 = "Master table backup %s, elapsed %.3f";
            Object[] objArr2 = new Object[2];
            objArr2[0] = z2 ? "SUCCEEDED" : "FAILED";
            objArr2[1] = Float.valueOf(((float) nanoTime) / 1.0E9f);
            x.i(str4, str5, objArr2);
            h.mEJ.a(181, z2 ? 24 : 25, 1, false);
        }
        com.tencent.mm.vfs.d.deleteFile(com.tencent.mm.kernel.g.Ei().dqp + "dbback/EnMicroMsg.db.bak");
        com.tencent.mm.vfs.d.deleteFile(com.tencent.mm.kernel.g.Ei().dqp + "dbback/corrupted/EnMicroMsg.db.bak");
        com.tencent.mm.vfs.d.deleteFile(com.tencent.mm.kernel.g.Ei().cachePath + "EnMicroMsg.db.bak");
        com.tencent.mm.vfs.d.deleteFile(com.tencent.mm.kernel.g.Ei().cachePath + "corrupted/EnMicroMsg.db.bak");
        au.Em().h(new 6(this, com.tencent.mm.model.c.Gp()), 60000);
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        aCD();
        this.hZP = false;
        if (this.hsU != null) {
            au.Em().cil().removeCallbacks(this.hsU);
            this.hsU = null;
        }
        if (this.hZY != null) {
            com.tencent.mm.sdk.b.a.sFg.c(this.hZY);
            this.hZY = null;
        }
        if (this.hsT != null) {
            ad.getContext().unregisterReceiver(this.hsT);
            this.hsT = null;
        }
        com.tencent.mm.pluginsdk.cmd.b.D(new String[]{"//recover-old", "//recover", "//post-recover", "//backupdb", "//recoverdb", "//repairdb", "//corruptdb", "//iotracedb", "//recover-status"});
    }

    private static void aCE() {
        com.tencent.mm.storage.c fJ = com.tencent.mm.model.c.c.Jx().fJ("100274");
        if (fJ.isValid()) {
            Map ckq = fJ.ckq();
            Map hashMap = new HashMap();
            hashMap.put("flags", Integer.valueOf(bi.getInt((String) ckq.get("flags"), 0)));
            hashMap.put("acp", Integer.valueOf(bi.getInt((String) ckq.get("acp"), 100)));
            com.tencent.mm.bt.f.ax(hashMap);
        }
    }

    static void aCF() {
        com.tencent.mm.plugin.messenger.foundation.a.a.f FT = com.tencent.mm.model.c.FT();
        FT.bdd();
        FT.bdf();
        FT.bde();
        com.tencent.mm.model.c.FW().clB();
        o.Pf().OP();
        com.tencent.mm.storage.x DT = com.tencent.mm.model.c.DT();
        DT.a(aa.a.sPi, Integer.valueOf(0));
        DT.a(aa.a.sPj, Integer.valueOf(0));
        DT.a(aa.a.sPk, Integer.valueOf(0));
    }

    public static void cY(Context context) {
        MMAppMgr.h(context, true);
    }

    public static void aCG() {
        MMAppMgr.lE(true);
    }
}
