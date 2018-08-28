package com.tencent.mm.plugin.dbbackup.a;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vfs.a.c;
import com.tencent.mm.vfs.d;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteDoneException;
import com.tencent.wcdb.database.SQLiteStatement;
import com.tencent.wcdb.repair.RecoverKit;
import com.tencent.wcdb.repair.RepairKit;
import com.tencent.wcdb.repair.RepairKit.MasterInfo;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.OperationCanceledException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public final class a extends AsyncTask<Void, Integer, Integer> {
    private static final String[] CONFLICT_VALUES = new String[]{"", " OR ROLLBACK", " OR ABORT", " OR FAIL", " OR IGNORE", " OR REPLACE"};
    private static final SQLiteCipherSpec iaz = new SQLiteCipherSpec().setPageSize(1024).setSQLCipherVersion(1);
    private SQLiteDatabase iaA;
    private String iaB;
    private String iaC;
    private String iaD;
    private String iaE;
    private List<String> iaF;
    private List<String> iaG;
    private byte[] iaH;
    private byte[] iaI;
    private boolean iaJ;
    private b iaK;
    private boolean iaL;
    private int iaM;
    private long iaN;
    private long iaO;
    public final CancellationSignal mCancellationSignal;

    public static class a {
        public String iaB;
        public String iaC;
        public String iaD;
        public String iaE;
        public List<String> iaF = new ArrayList();
        public List<String> iaG = new ArrayList();
        public byte[] iaH;
        public byte[] iaI;
        public boolean iaJ;
        public b iaK;

        public final a yI(String str) {
            this.iaF.add(str);
            return this;
        }

        public final a yJ(String str) {
            this.iaG.add(str);
            return this;
        }
    }

    public interface b {
        void G(int i, int i2, int i3);

        void aCB();

        void aid();

        void onSuccess();

        void p(long j, long j2);
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Integer num = (Integer) obj;
        if (this.iaK != null) {
            switch (num.intValue()) {
                case -2:
                    this.iaK.p(this.iaO, this.iaN);
                    return;
                case 0:
                    this.iaK.onSuccess();
                    return;
                case 1:
                    this.iaK.aCB();
                    return;
                default:
                    this.iaK.aid();
                    return;
            }
        }
    }

    protected final /* synthetic */ void onProgressUpdate(Object[] objArr) {
        int i = 0;
        Integer[] numArr = (Integer[]) objArr;
        if (this.iaK != null) {
            int intValue = numArr.length > 0 ? numArr[0].intValue() : 0;
            int intValue2 = numArr.length >= 2 ? numArr[1].intValue() : 0;
            if (numArr.length >= 3) {
                i = numArr[2].intValue();
            }
            this.iaK.G(intValue, intValue2, i);
        }
    }

    private a() {
        this.mCancellationSignal = new CancellationSignal();
    }

    private Integer hx() {
        Integer valueOf;
        long uptimeMillis;
        boolean aCM;
        Throwable th;
        boolean z;
        ow(54);
        boolean z2 = true;
        WakeLock newWakeLock = ((PowerManager) ad.getContext().getSystemService("power")).newWakeLock(1, "DBRecovery");
        long uptimeMillis2 = SystemClock.uptimeMillis();
        newWakeLock.acquire(1800000);
        try {
            publishProgress(new Integer[]{Integer.valueOf(1)});
            z2 = aCJ();
            if (z2) {
                valueOf = Integer.valueOf(z2);
                switch (z2) {
                    case true:
                        ow(58);
                        break;
                    case false:
                        uptimeMillis = SystemClock.uptimeMillis() - uptimeMillis2;
                        ow(55);
                        f.mDy.a(181, 60, (uptimeMillis / 1000) + 1, true);
                        break;
                    case true:
                        ow(56);
                        break;
                    default:
                        ow(57);
                        break;
                }
                newWakeLock.release();
            } else {
                int aCK = aCK();
                try {
                    publishProgress(new Integer[]{Integer.valueOf(2)});
                    z2 = aCL();
                    if (z2) {
                        valueOf = Integer.valueOf(z2);
                        switch (z2) {
                            case true:
                                ow(58);
                                break;
                            case false:
                                uptimeMillis = SystemClock.uptimeMillis() - uptimeMillis2;
                                ow(55);
                                f.mDy.a(181, 60, (uptimeMillis / 1000) + 1, true);
                                break;
                            case true:
                                ow(56);
                                break;
                            default:
                                ow(57);
                                break;
                        }
                        newWakeLock.release();
                    } else {
                        if (z2) {
                            publishProgress(new Integer[]{Integer.valueOf(4)});
                            aCM = aCM();
                        } else {
                            aCM = z2;
                        }
                        if (aCM) {
                            z2 = aCM;
                        } else {
                            publishProgress(new Integer[]{Integer.valueOf(5)});
                            z2 = aCN();
                        }
                        if (z2) {
                            if (!this.iaJ) {
                                valueOf = Integer.valueOf(z2);
                                switch (z2) {
                                    case true:
                                        ow(58);
                                        break;
                                    case false:
                                        uptimeMillis = SystemClock.uptimeMillis() - uptimeMillis2;
                                        ow(55);
                                        f.mDy.a(181, 60, (uptimeMillis / 1000) + 1, true);
                                        break;
                                    case true:
                                        ow(56);
                                        break;
                                    default:
                                        ow(57);
                                        break;
                                }
                                newWakeLock.release();
                            }
                        }
                        publishProgress(new Integer[]{Integer.valueOf(6)});
                        z2 = ee(true);
                        valueOf = Integer.valueOf(z2);
                        switch (z2) {
                            case true:
                                ow(58);
                                break;
                            case false:
                                uptimeMillis = SystemClock.uptimeMillis() - uptimeMillis2;
                                ow(55);
                                f.mDy.a(181, 60, (uptimeMillis / 1000) + 1, true);
                                break;
                            case true:
                                ow(56);
                                break;
                            default:
                                ow(57);
                                break;
                        }
                        newWakeLock.release();
                    }
                } catch (OperationCanceledException e) {
                } catch (Exception e2) {
                    z2 = aCM;
                    try {
                        ee(false);
                        z2 = true;
                        valueOf = Integer.valueOf(-1);
                        ow(57);
                        newWakeLock.release();
                        return valueOf;
                    } catch (Throwable th2) {
                        th = th2;
                        z = z2;
                        switch (z) {
                            case true:
                                ow(58);
                                break;
                            case false:
                                uptimeMillis = SystemClock.uptimeMillis() - uptimeMillis2;
                                ow(55);
                                f.mDy.a(181, 60, (uptimeMillis / 1000) + 1, true);
                                break;
                            case true:
                                ow(56);
                                break;
                            default:
                                ow(57);
                                break;
                        }
                        newWakeLock.release();
                        throw th;
                    }
                }
            }
        } catch (OperationCanceledException e3) {
            aCM = z2;
        } catch (Exception e4) {
            ee(false);
            z2 = true;
            valueOf = Integer.valueOf(-1);
            ow(57);
            newWakeLock.release();
            return valueOf;
        }
        return valueOf;
        try {
            x.i("MicroMsg.DBRecoveryTask", "Recovery cancelled.");
            ee(false);
            try {
                valueOf = Integer.valueOf(1);
                ow(56);
                newWakeLock.release();
                return valueOf;
            } catch (Throwable th22) {
                th = th22;
                z = true;
                switch (z) {
                    case true:
                        ow(58);
                        break;
                    case false:
                        uptimeMillis = SystemClock.uptimeMillis() - uptimeMillis2;
                        ow(55);
                        f.mDy.a(181, 60, (uptimeMillis / 1000) + 1, true);
                        break;
                    case true:
                        ow(56);
                        break;
                    default:
                        ow(57);
                        break;
                }
                newWakeLock.release();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            z = aCM;
            switch (z) {
                case true:
                    ow(58);
                    break;
                case false:
                    uptimeMillis = SystemClock.uptimeMillis() - uptimeMillis2;
                    ow(55);
                    f.mDy.a(181, 60, (uptimeMillis / 1000) + 1, true);
                    break;
                case true:
                    ow(56);
                    break;
                default:
                    ow(57);
                    break;
            }
            newWakeLock.release();
            throw th;
        }
    }

    private int aCJ() {
        long j = 0;
        x.i("MicroMsg.DBRecoveryTask", "Load and check database statistics.");
        if (this.iaB == null || this.iaB.isEmpty()) {
            return -1;
        }
        long j2;
        this.iaL = false;
        this.iaM = 300000;
        if (this.iaE != null) {
            try {
                JSONObject jSONObject = new JSONObject(d.ct(this.iaE));
                this.iaM = jSONObject.getInt("message");
                this.iaL = true;
                j2 = jSONObject.getLong("dbSize");
            } catch (FileNotFoundException e) {
                x.i("MicroMsg.DBRecoveryTask", "Statistics file not found: " + this.iaE);
                j2 = 0;
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.DBRecoveryTask", e2, "Cannot read statistics from file.", new Object[0]);
            }
            if (this.iaD != null) {
                j = d.abQ(this.iaD);
            }
            this.iaN = Math.max(j2, j);
            this.iaN += Math.max(this.iaN / 10, 67108864);
            this.iaO = yH(this.iaB);
            if (this.iaN <= this.iaO) {
                x.e("MicroMsg.DBRecoveryTask", "Space not enough for recovery (%d required, %d available)", new Object[]{Long.valueOf(this.iaN), Long.valueOf(this.iaO)});
                return -2;
            }
            x.i("MicroMsg.DBRecoveryTask", "Statistics check OK, required space: %d, available space %d, message count: %d", new Object[]{Long.valueOf(this.iaN), Long.valueOf(this.iaO), Integer.valueOf(this.iaM)});
            return 0;
        }
        j2 = 0;
        if (this.iaD != null) {
            j = d.abQ(this.iaD);
        }
        this.iaN = Math.max(j2, j);
        this.iaN += Math.max(this.iaN / 10, 67108864);
        this.iaO = yH(this.iaB);
        if (this.iaN <= this.iaO) {
            x.i("MicroMsg.DBRecoveryTask", "Statistics check OK, required space: %d, available space %d, message count: %d", new Object[]{Long.valueOf(this.iaN), Long.valueOf(this.iaO), Integer.valueOf(this.iaM)});
            return 0;
        }
        x.e("MicroMsg.DBRecoveryTask", "Space not enough for recovery (%d required, %d available)", new Object[]{Long.valueOf(this.iaN), Long.valueOf(this.iaO)});
        return -2;
    }

    private int aCK() {
        if (this.iaA != null) {
            if (this.iaA.isOpen()) {
                this.iaA.close();
            }
            this.iaA = null;
        }
        this.mCancellationSignal.throwIfCanceled();
        String str = this.iaB + '-' + bi.Dc(6);
        x.i("MicroMsg.DBRecoveryTask", "Open target database: " + str);
        try {
            this.iaA = SQLiteDatabase.openOrCreateDatabase(str, this.iaI, iaz, null, null, 1);
            DatabaseUtils.stringForQuery(this.iaA, "PRAGMA journal_mode=OFF;", null);
            this.iaA.execSQL("PRAGMA synchronous=OFF;");
            return 0;
        } catch (Throwable e) {
            x.e("MicroMsg.DBRecoveryTask", "Cannot open target database '%s': %s", new Object[]{str, e.getMessage()});
            a(1, "Cannot open target database", e);
            throw e;
        }
    }

    private int ee(boolean z) {
        x.i("MicroMsg.DBRecoveryTask", "Close and rename target database: " + this.iaB);
        if (this.iaA == null) {
            return -1;
        }
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(this.iaA.getPath());
        if (this.iaA.isOpen()) {
            this.iaA.close();
        }
        if (!z) {
            x.i("MicroMsg.DBRecoveryTask", "Delete temporary database file %s", new Object[]{bVar});
            bVar.delete();
        } else if (!bVar.a(new com.tencent.mm.vfs.b(this.iaB))) {
            x.e("MicroMsg.DBRecoveryTask", "Cannot rename %s to %s", new Object[]{bVar, this.iaB});
            return -1;
        }
        return 0;
    }

    private int aCL() {
        MasterInfo masterInfo;
        Exception e;
        boolean z;
        OperationCanceledException e2;
        Throwable e3;
        RepairKit repairKit = null;
        this.mCancellationSignal.throwIfCanceled();
        String[] strArr = new String[]{"message", "ImgInfo2", "videoinfo2", "EmojiInfo", "rconversation"};
        MasterInfo masterInfo2 = null;
        for (String str : this.iaF) {
            try {
                MasterInfo load = MasterInfo.load(str, this.iaH, strArr);
                try {
                    x.i("MicroMsg.DBRecoveryTask", "Loaded saved master: " + str);
                    masterInfo = load;
                    break;
                } catch (Exception e4) {
                    e = e4;
                    masterInfo = load;
                }
            } catch (Exception e5) {
                e = e5;
                masterInfo = masterInfo2;
            }
        }
        masterInfo = masterInfo2;
        if (masterInfo == null) {
            masterInfo = MasterInfo.make(strArr);
            x.w("MicroMsg.DBRecoveryTask", "Saved master not available.");
            z = false;
        } else {
            x.i("MicroMsg.DBRecoveryTask", "Use backup saved master.");
            z = true;
        }
        int[] iArr = new int[]{0};
        RepairKit repairKit2;
        try {
            x.i("MicroMsg.DBRecoveryTask", "Begin repair: " + this.iaD);
            repairKit2 = new RepairKit(this.iaD, this.iaI, iaz, masterInfo);
            try {
                repairKit2.setCallback(new 1(this, iArr));
                int output = repairKit2.output(this.iaA, 0, this.mCancellationSignal);
                if (output == 0) {
                    if (repairKit2.isHeaderCorrupted() && repairKit2.isDataCorrupted()) {
                        throw new RuntimeException("No data is successfully recovered.");
                    }
                    x.i("MicroMsg.DBRecoveryTask", "Repair succeeded.");
                } else if (output == 1) {
                    x.i("MicroMsg.DBRecoveryTask", "Repair cancelled.");
                    this.mCancellationSignal.throwIfCanceled();
                } else {
                    throw new RuntimeException("Repair failed.");
                }
                if (this.iaL && ((float) iArr[0]) / ((float) this.iaM) <= 1.5f) {
                    f.mDy.a(181, 181, 62, 63, this.iaM, iArr[0], true);
                }
                repairKit2.release();
                return output;
            } catch (OperationCanceledException e6) {
                e2 = e6;
                repairKit = repairKit2;
            } catch (RuntimeException e7) {
                e3 = e7;
                try {
                    x.e("MicroMsg.DBRecoveryTask", "Failed to repair database: " + e3.getMessage());
                    a(2, "Failed to repair database => sm: " + z, e3);
                    if (repairKit2 != null) {
                        repairKit2.release();
                    }
                    return -1;
                } catch (Throwable th) {
                    e3 = th;
                    if (repairKit2 != null) {
                        repairKit2.release();
                    }
                    throw e3;
                }
            }
        } catch (OperationCanceledException e8) {
            e2 = e8;
            try {
                throw e2;
            } catch (Throwable th2) {
                e3 = th2;
                repairKit2 = repairKit;
            }
        } catch (RuntimeException e9) {
            e3 = e9;
            repairKit2 = null;
            x.e("MicroMsg.DBRecoveryTask", "Failed to repair database: " + e3.getMessage());
            a(2, "Failed to repair database => sm: " + z, e3);
            if (repairKit2 != null) {
                repairKit2.release();
            }
            return -1;
        } catch (Throwable th3) {
            e3 = th3;
            repairKit2 = null;
            if (repairKit2 != null) {
                repairKit2.release();
            }
            throw e3;
        }
        x.e("MicroMsg.DBRecoveryTask", "Failed to load saved master: " + e.getMessage());
        masterInfo2 = masterInfo;
    }

    private int aCM() {
        Exception exception;
        RecoverKit recoverKit;
        this.mCancellationSignal.throwIfCanceled();
        x.i("MicroMsg.DBRecoveryTask", "Begin backup recovery.");
        RecoverKit recoverKit2 = null;
        for (String str : this.iaG) {
            try {
                RecoverKit recoverKit3 = new RecoverKit(this.iaA, str, this.iaH);
                try {
                    x.i("MicroMsg.DBRecoveryTask", "Loaded backup data: " + str);
                    recoverKit2 = recoverKit3;
                } catch (Exception e) {
                    exception = e;
                    recoverKit = recoverKit3;
                    x.e("MicroMsg.DBRecoveryTask", "Load backup data failed: " + exception.getMessage());
                    recoverKit2 = recoverKit;
                }
            } catch (Exception e2) {
                exception = e2;
                recoverKit = recoverKit2;
                x.e("MicroMsg.DBRecoveryTask", "Load backup data failed: " + exception.getMessage());
                recoverKit2 = recoverKit;
            }
        }
        if (recoverKit2 == null) {
            return -1;
        }
        try {
            int run = recoverKit2.run(false, this.mCancellationSignal);
            if (run == 0) {
                x.i("MicroMsg.DBRecoveryTask", "Backup recovery succeeded.");
            } else if (run == 1) {
                x.i("MicroMsg.DBRecoveryTask", "Backup recovery cancelled.");
                this.mCancellationSignal.throwIfCanceled();
            } else {
                x.e("MicroMsg.DBRecoveryTask", "Backup recovery failed.");
            }
            recoverKit2.release();
            return run;
        } catch (OperationCanceledException e3) {
            throw e3;
        } catch (Throwable e4) {
            x.e("MicroMsg.DBRecoveryTask", "Failed to repair database: " + e4.getMessage());
            a(4, "Failed to recover backup database", e4);
            recoverKit2.release();
            return -1;
        } catch (Throwable th) {
            recoverKit2.release();
        }
    }

    private int aCN() {
        OperationCanceledException e;
        Throwable th;
        if (this.iaC == null || this.iaC.isEmpty()) {
            return 0;
        }
        x.i("MicroMsg.DBRecoveryTask", "Begin merging old database.");
        SQLiteDatabase openDatabase;
        Cursor rawQueryWithFactory;
        try {
            int longForQuery = (int) DatabaseUtils.longForQuery(this.iaA, "SELECT count(*) FROM message;", null);
            long[] jArr = new long[]{DatabaseUtils.longForQuery(this.iaA, "SELECT max(msgId) FROM message;", null) + 1};
            if (jArr[0] > 1000000 && jArr[0] <= 10000000) {
                jArr[0] = 10000001;
            }
            HashMap hashMap = new HashMap(Math.max(longForQuery + (longForQuery / 2), 10240));
            openDatabase = SQLiteDatabase.openDatabase(this.iaC, this.iaI, iaz, null, 1, new 2(this), 1);
            try {
                com.tencent.wcdb.Cursor rawQueryWithFactory2;
                a(openDatabase, "userinfo", 0, false, 0, null);
                this.iaA.beginTransaction();
                Object[] objArr = new Object[]{Integer.valueOf(8197), Integer.valueOf(3), ""};
                this.iaA.execSQL("INSERT OR REPLACE INTO userinfo (id,type,value) VALUES (?,?,?)", objArr);
                objArr[0] = Integer.valueOf(15);
                objArr[1] = Integer.valueOf(1);
                objArr[2] = "0";
                this.iaA.execSQL("INSERT OR REPLACE INTO userinfo (id,type,value) VALUES (?,?,?)", objArr);
                objArr[0] = Integer.valueOf(89);
                objArr[1] = Integer.valueOf(1);
                objArr[2] = "1";
                this.iaA.execSQL("INSERT OR REPLACE INTO userinfo (id,type,value) VALUES (?,?,?)", objArr);
                rawQueryWithFactory = openDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT id,type,value FROM userinfo WHERE id=?", new String[]{"2"}, "userinfo");
                try {
                    if (rawQueryWithFactory.moveToFirst()) {
                        objArr[0] = Integer.valueOf(rawQueryWithFactory.getInt(0));
                        objArr[1] = Integer.valueOf(rawQueryWithFactory.getInt(1));
                        objArr[2] = rawQueryWithFactory.getString(2);
                        this.iaA.execSQL("INSERT OR REPLACE INTO userinfo (id,type,value) VALUES (?,?,?)", objArr);
                    }
                    rawQueryWithFactory.close();
                    com.tencent.wcdb.Cursor rawQueryWithFactory3 = openDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT id,type,value FROM userinfo WHERE id=?", new String[]{"9"}, "userinfo");
                    if (rawQueryWithFactory3.moveToFirst()) {
                        objArr[0] = Integer.valueOf(rawQueryWithFactory3.getInt(0));
                        objArr[1] = Integer.valueOf(rawQueryWithFactory3.getInt(1));
                        objArr[2] = rawQueryWithFactory3.getString(2);
                        this.iaA.execSQL("INSERT OR REPLACE INTO userinfo (id,type,value) VALUES (?,?,?)", objArr);
                    }
                    rawQueryWithFactory3.close();
                    this.iaA.setTransactionSuccessful();
                    this.iaA.endTransaction();
                    rawQueryWithFactory2 = openDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT * FROM message LIMIT 0;", null, "message");
                } catch (OperationCanceledException e2) {
                    e = e2;
                    try {
                        x.i("MicroMsg.DBRecoveryTask", "Message migration cancelled.");
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!(rawQueryWithFactory == null || rawQueryWithFactory.isClosed())) {
                            rawQueryWithFactory.close();
                        }
                        if (this.iaA.inTransaction()) {
                            this.iaA.endTransaction();
                        }
                        if (openDatabase != null) {
                            openDatabase.close();
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    th = e3;
                    x.e("MicroMsg.DBRecoveryTask", "Message migration failed: " + th.getMessage());
                    a(5, "Message migration failed, ignorable: " + this.iaJ, th);
                    rawQueryWithFactory.close();
                    if (this.iaA.inTransaction()) {
                        this.iaA.endTransaction();
                    }
                    if (openDatabase != null) {
                        openDatabase.close();
                    }
                    return -1;
                }
                Cursor rawQueryWithFactory4;
                try {
                    longForQuery = rawQueryWithFactory2.getColumnIndexOrThrow("msgId");
                    rawQueryWithFactory2.close();
                    a(openDatabase, "message", 4, true, 5, new 3(this, longForQuery, jArr, hashMap));
                    a(openDatabase, "rconversation", 5, true, 0, null);
                    rawQueryWithFactory2 = openDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT * FROM ImgInfo2 LIMIT 0;", null, "ImgInfo2");
                    longForQuery = rawQueryWithFactory2.getColumnIndexOrThrow("msglocalid");
                    rawQueryWithFactory2.close();
                    a(openDatabase, "ImgInfo2", 4, true, 0, new 4(this, longForQuery, hashMap));
                    rawQueryWithFactory4 = openDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT * FROM videoinfo2 LIMIT 0;", null, "videoinfo2");
                    longForQuery = rawQueryWithFactory4.getColumnIndexOrThrow("msglocalid");
                    rawQueryWithFactory4.close();
                    a(openDatabase, "videoinfo2", 4, true, 0, new 5(this, longForQuery, hashMap));
                    if (!(rawQueryWithFactory4 == null || rawQueryWithFactory4.isClosed())) {
                        rawQueryWithFactory4.close();
                    }
                    if (this.iaA.inTransaction()) {
                        this.iaA.endTransaction();
                    }
                    if (openDatabase != null) {
                        openDatabase.close();
                    }
                    return 0;
                } catch (OperationCanceledException e4) {
                    e = e4;
                    rawQueryWithFactory = rawQueryWithFactory4;
                    x.i("MicroMsg.DBRecoveryTask", "Message migration cancelled.");
                    throw e;
                } catch (Exception e5) {
                    th = e5;
                    rawQueryWithFactory = rawQueryWithFactory4;
                    x.e("MicroMsg.DBRecoveryTask", "Message migration failed: " + th.getMessage());
                    a(5, "Message migration failed, ignorable: " + this.iaJ, th);
                    if (!(rawQueryWithFactory == null || rawQueryWithFactory.isClosed())) {
                        rawQueryWithFactory.close();
                    }
                    if (this.iaA.inTransaction()) {
                        this.iaA.endTransaction();
                    }
                    if (openDatabase != null) {
                        openDatabase.close();
                    }
                    return -1;
                } catch (Throwable th3) {
                    th = th3;
                    rawQueryWithFactory = rawQueryWithFactory4;
                    rawQueryWithFactory.close();
                    if (this.iaA.inTransaction()) {
                        this.iaA.endTransaction();
                    }
                    if (openDatabase != null) {
                        openDatabase.close();
                    }
                    throw th;
                }
            } catch (OperationCanceledException e6) {
                e = e6;
                rawQueryWithFactory = null;
            } catch (Exception e7) {
                th = e7;
                rawQueryWithFactory = null;
                x.e("MicroMsg.DBRecoveryTask", "Message migration failed: " + th.getMessage());
                a(5, "Message migration failed, ignorable: " + this.iaJ, th);
                rawQueryWithFactory.close();
                if (this.iaA.inTransaction()) {
                    this.iaA.endTransaction();
                }
                if (openDatabase != null) {
                    openDatabase.close();
                }
                return -1;
            } catch (Throwable th4) {
                th = th4;
                rawQueryWithFactory = null;
                rawQueryWithFactory.close();
                if (this.iaA.inTransaction()) {
                    this.iaA.endTransaction();
                }
                if (openDatabase != null) {
                    openDatabase.close();
                }
                throw th;
            }
        } catch (OperationCanceledException e8) {
            e = e8;
            rawQueryWithFactory = null;
            openDatabase = null;
            x.i("MicroMsg.DBRecoveryTask", "Message migration cancelled.");
            throw e;
        } catch (Exception e9) {
            th = e9;
            rawQueryWithFactory = null;
            openDatabase = null;
            x.e("MicroMsg.DBRecoveryTask", "Message migration failed: " + th.getMessage());
            a(5, "Message migration failed, ignorable: " + this.iaJ, th);
            rawQueryWithFactory.close();
            if (this.iaA.inTransaction()) {
                this.iaA.endTransaction();
            }
            if (openDatabase != null) {
                openDatabase.close();
            }
            return -1;
        } catch (Throwable th5) {
            th = th5;
            rawQueryWithFactory = null;
            openDatabase = null;
            rawQueryWithFactory.close();
            if (this.iaA.inTransaction()) {
                this.iaA.endTransaction();
            }
            if (openDatabase != null) {
                openDatabase.close();
            }
            throw th;
        }
    }

    private int a(SQLiteDatabase sQLiteDatabase, String str, int i, boolean z, int i2, c cVar) {
        Throwable th;
        Cursor rawQueryWithFactory;
        SQLiteStatement compileStatement;
        try {
            String stringForQuery = DatabaseUtils.stringForQuery(sQLiteDatabase, "SELECT sql FROM sqlite_master WHERE name = ?", new String[]{str});
            if (stringForQuery == null || stringForQuery.isEmpty()) {
                throw new SQLiteDoneException();
            }
            this.iaA.execSQL(stringForQuery.replaceFirst("(?i)^CREATE TABLE (?!IF NOT EXISTS )", "CREATE TABLE IF NOT EXISTS "), null, this.mCancellationSignal);
            if (z) {
                int longForQuery = (int) DatabaseUtils.longForQuery(sQLiteDatabase, "SELECT count(*) FROM " + str, null);
                rawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT * FROM " + str, null, str, this.mCancellationSignal);
                try {
                    int i3;
                    int i4;
                    String[] columnNames = rawQueryWithFactory.getColumnNames();
                    StringBuilder stringBuilder = new StringBuilder(1024);
                    stringBuilder.append("INSERT").append(CONFLICT_VALUES[i]).append(" INTO ").append(str).append(" (");
                    for (String append : columnNames) {
                        stringBuilder.append(append).append(',');
                    }
                    stringBuilder.setCharAt(stringBuilder.length() - 1, ')');
                    stringBuilder.append(" VALUES (");
                    for (i3 = 0; i3 < columnNames.length; i3++) {
                        stringBuilder.append("?,");
                    }
                    stringBuilder.setCharAt(stringBuilder.length() - 1, ')');
                    compileStatement = this.iaA.compileStatement(stringBuilder.toString());
                    i3 = 0;
                    try {
                        this.iaA.beginTransaction();
                        while (rawQueryWithFactory.moveToNext()) {
                            if (i3 % 1024 == 0 && i2 != 0) {
                                publishProgress(new Integer[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(longForQuery)});
                            }
                            compileStatement.clearBindings();
                            for (i4 = 0; i4 < columnNames.length; i4++) {
                                switch (rawQueryWithFactory.getType(i4)) {
                                    case 0:
                                        compileStatement.bindNull(i4 + 1);
                                        break;
                                    case 1:
                                        compileStatement.bindLong(i4 + 1, rawQueryWithFactory.getLong(i4));
                                        break;
                                    case 2:
                                        compileStatement.bindDouble(i4 + 1, rawQueryWithFactory.getDouble(i4));
                                        break;
                                    case 3:
                                        compileStatement.bindString(i4 + 1, rawQueryWithFactory.getString(i4));
                                        break;
                                    case 4:
                                        compileStatement.bindBlob(i4 + 1, rawQueryWithFactory.getBlob(i4));
                                        break;
                                    default:
                                        break;
                                }
                            }
                            if (cVar != null) {
                                cVar.a(rawQueryWithFactory, compileStatement);
                            }
                            compileStatement.executeInsert(this.mCancellationSignal);
                            i3++;
                        }
                        this.iaA.setTransactionSuccessful();
                        if (!(rawQueryWithFactory == null || rawQueryWithFactory.isClosed())) {
                            rawQueryWithFactory.close();
                        }
                        if (this.iaA.inTransaction()) {
                            this.iaA.endTransaction();
                        }
                        if (compileStatement == null) {
                            return i3;
                        }
                        compileStatement.close();
                        return i3;
                    } catch (Throwable th2) {
                        th = th2;
                        rawQueryWithFactory.close();
                        if (this.iaA.inTransaction()) {
                            this.iaA.endTransaction();
                        }
                        if (compileStatement != null) {
                            compileStatement.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    compileStatement = null;
                    if (!(rawQueryWithFactory == null || rawQueryWithFactory.isClosed())) {
                        rawQueryWithFactory.close();
                    }
                    if (this.iaA.inTransaction()) {
                        this.iaA.endTransaction();
                    }
                    if (compileStatement != null) {
                        compileStatement.close();
                    }
                    throw th;
                }
            }
            if (this.iaA.inTransaction()) {
                this.iaA.endTransaction();
            }
            return 0;
        } catch (SQLiteDoneException e) {
            x.e("MicroMsg.DBRecoveryTask", "There is no table named '%s' to copy.", new Object[]{str});
            if (this.iaA.inTransaction()) {
                this.iaA.endTransaction();
            }
            return -1;
        } catch (Throwable th4) {
            th = th4;
            compileStatement = null;
            rawQueryWithFactory = null;
        }
    }

    private static long yH(String str) {
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
        do {
            c cBU = bVar.cBU();
            long j = !cBU.valid() ? 0 : cBU.uSi.cBQ().uRU;
            if (j > 0) {
                return j;
            }
            bVar = bVar.cBW();
        } while (bVar != null);
        return 0;
    }

    private static void ow(int i) {
        f.mDy.a(181, (long) i, 1, true);
    }

    @SuppressLint({"DefaultLocale"})
    private static void a(int i, String str, Throwable th) {
        f.mDy.c("DBRepairNew", String.format("[Stage: %d] %s%s", new Object[]{Integer.valueOf(i), str, "\n" + bi.i(th)}), null);
    }
}
