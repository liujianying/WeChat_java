package com.tencent.mm.jni.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.g.a.nm;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

public final class a {
    private static SparseArray<b> dok = new SparseArray();
    private static final byte[] dol = new byte[0];
    private static ag mHandler = new ag(Looper.getMainLooper());

    private static class a implements Runnable {
        private WakerLock dom = null;

        public a(WakerLock wakerLock) {
            this.dom = wakerLock;
        }

        public final void run() {
            synchronized (a.dol) {
                b bVar = (b) a.dok.get(this.dom.hashCode());
                if (bVar != null) {
                    String str = "MicroMsg.WakeLockManager";
                    String str2 = "wakerlock held too long: [%d,%d] @[%s] force to unlock it. state: %s";
                    Object[] objArr = new Object[4];
                    objArr[0] = Integer.valueOf(this.dom.hashCode());
                    objArr[1] = Integer.valueOf(this.dom.innerWakeLockHashCode());
                    objArr[2] = this.dom.getCreatePosStackLine();
                    Collection<a> values = bVar.dop.values();
                    StringBuilder stringBuilder = new StringBuilder();
                    Object obj = 1;
                    for (a aVar : values) {
                        if (obj != null) {
                            obj = null;
                        } else {
                            stringBuilder.append(',');
                        }
                        if (aVar.dor != 0) {
                            stringBuilder.append('{').append(aVar.doq).append(',').append(SystemClock.elapsedRealtime() - aVar.dor).append('}');
                        }
                    }
                    if (stringBuilder.length() == 0) {
                        stringBuilder.append("<empty>");
                    }
                    objArr[3] = stringBuilder.toString();
                    x.w(str, str2, objArr);
                } else {
                    x.w("MicroMsg.WakeLockManager", "wakerlock held too long: [%d,%d] @[%s] force to unlock it. state: %s", Integer.valueOf(this.dom.hashCode()), Integer.valueOf(this.dom.innerWakeLockHashCode()), this.dom.getCreatePosStackLine(), "#lost-trace-state#");
                }
                this.dom.unLock();
            }
        }
    }

    private static class b {
        volatile boolean don = false;
        a doo = null;
        Map<String, a> dop = new HashMap();

        private static class a {
            public String doq = null;
            public long dor = 0;

            public a(String str, long j) {
                this.doq = str;
                this.dor = j;
            }
        }

        public b(WakerLock wakerLock) {
            this.doo = new a(wakerLock);
        }
    }

    private static class c {
        private static long bzV = 0;
        private static int dos = 0;
        private static long dot = 0;
        private static HashMap<String, a> dou = null;
        private static final byte[] dov = new byte[0];
        private static BroadcastReceiver dow = null;

        private static class a implements Externalizable {
            public int doA;
            public int doB;
            public long doC;
            public long doD;
            public AtomicInteger doE;
            public String doq;
            public String dox;
            public String doy;
            public boolean doz;

            private a() {
                this.dox = "";
                this.doq = "";
                this.doy = "";
                this.doz = false;
                this.doA = 0;
                this.doB = 0;
                this.doC = 0;
                this.doD = 0;
                this.doE = new AtomicInteger(0);
            }

            /* synthetic */ a(byte b) {
                this();
            }

            public final void readExternal(ObjectInput objectInput) {
                synchronized (c.dov) {
                    this.dox = objectInput.readUTF();
                    this.doq = objectInput.readUTF();
                    this.doA = objectInput.readInt();
                    this.doB = objectInput.readInt();
                    this.doC = objectInput.readLong();
                    this.doy = "";
                    this.doz = false;
                    this.doD = 0;
                    this.doE = new AtomicInteger(0);
                }
            }

            public final void writeExternal(ObjectOutput objectOutput) {
                synchronized (c.dov) {
                    objectOutput.writeUTF(this.dox);
                    objectOutput.writeUTF(this.doq);
                    objectOutput.writeInt(this.doA);
                    objectOutput.writeInt(this.doB);
                    objectOutput.writeLong(this.doC);
                }
            }
        }

        public static void CQ() {
            ObjectInputStream objectInputStream;
            IntentFilter intentFilter;
            Throwable th;
            ObjectInputStream objectInputStream2 = null;
            if (dos == 0) {
                dos = Process.myPid();
                dow = new BroadcastReceiver() {
                    public final void onReceive(Context context, Intent intent) {
                        String action = intent.getAction();
                        if (!bi.oW(action)) {
                            int intExtra = intent.getIntExtra("pid", 0);
                            if (intExtra != 0) {
                                String stringExtra = intent.getStringExtra("processName");
                                if (!bi.oW(stringExtra) && stringExtra.equals(bi.an(ad.getContext(), intExtra))) {
                                    String stringExtra2 = intent.getStringExtra("traceMsg");
                                    long longExtra = intent.getLongExtra("tick", 0);
                                    if ("com.tencent.mm.ACTION.note_tracemsg_lock".equals(action)) {
                                        c.b(stringExtra, stringExtra2, longExtra);
                                    } else if ("com.tencent.mm.ACTION.note_tracemsg_unlock".equals(action)) {
                                        c.c(stringExtra, stringExtra2, longExtra);
                                    }
                                }
                            }
                        }
                    }
                };
                synchronized (dov) {
                    try {
                        ObjectInputStream objectInputStream3 = new ObjectInputStream(new FileInputStream(new File(ad.getContext().getCacheDir(), "wakelock/wakelock_stats.bin")));
                        try {
                            bzV = objectInputStream3.readLong();
                            dou = (HashMap) objectInputStream3.readObject();
                            try {
                                objectInputStream3.close();
                            } catch (Exception e) {
                            }
                        } catch (Exception e2) {
                            objectInputStream = objectInputStream3;
                            try {
                                x.e("MicroMsg.WakeLockStatsManager", "failed to load stats from storage, use default value for last stats info.");
                                bzV = SystemClock.elapsedRealtime();
                                dou = new HashMap();
                                if (objectInputStream != null) {
                                    try {
                                        objectInputStream.close();
                                    } catch (Exception e3) {
                                    }
                                }
                                intentFilter = new IntentFilter();
                                intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_lock");
                                intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_unlock");
                                ad.getContext().registerReceiver(dow, intentFilter, "com.tencent.mm.permission.MM_MESSAGE", null);
                                x.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is attached to process [%s]", ad.getProcessName());
                            } catch (Throwable th2) {
                                th = th2;
                                objectInputStream2 = objectInputStream;
                                if (objectInputStream2 != null) {
                                    try {
                                        objectInputStream2.close();
                                    } catch (Exception e4) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            objectInputStream2 = objectInputStream3;
                            if (objectInputStream2 != null) {
                                try {
                                    objectInputStream2.close();
                                } catch (Exception e42) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e5) {
                        objectInputStream = null;
                        x.e("MicroMsg.WakeLockStatsManager", "failed to load stats from storage, use default value for last stats info.");
                        bzV = SystemClock.elapsedRealtime();
                        dou = new HashMap();
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (Exception e32) {
                            }
                        }
                        intentFilter = new IntentFilter();
                        intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_lock");
                        intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_unlock");
                        ad.getContext().registerReceiver(dow, intentFilter, "com.tencent.mm.permission.MM_MESSAGE", null);
                        x.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is attached to process [%s]", ad.getProcessName());
                    } catch (Throwable th32) {
                        th = th32;
                        if (objectInputStream2 != null) {
                            try {
                                objectInputStream2.close();
                            } catch (Exception e422) {
                            }
                        }
                        throw th;
                    }
                }
                intentFilter = new IntentFilter();
                intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_lock");
                intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_unlock");
                ad.getContext().registerReceiver(dow, intentFilter, "com.tencent.mm.permission.MM_MESSAGE", null);
                x.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is attached to process [%s]", ad.getProcessName());
            }
        }

        public static void detach() {
            if (dos > 0) {
                ad.getContext().unregisterReceiver(dow);
                CS();
                dos = 0;
                x.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is detached from process [%s]", ad.getProcessName());
            }
        }

        public static void fK(String str) {
            o(str, true);
        }

        public static void fL(String str) {
            o(str, false);
        }

        private static void o(String str, boolean z) {
            int myPid = Process.myPid();
            String processName = ad.getProcessName();
            Intent intent;
            if (myPid == dos) {
                if (z) {
                    b(processName, str, SystemClock.elapsedRealtime());
                } else {
                    c(processName, str, SystemClock.elapsedRealtime());
                }
            } else if (z) {
                intent = new Intent("com.tencent.mm.ACTION.note_tracemsg_lock");
                intent.putExtra("pid", myPid);
                intent.putExtra("processName", processName);
                intent.putExtra("traceMsg", str);
                intent.putExtra("tick", SystemClock.elapsedRealtime());
                ad.getContext().sendBroadcast(intent, "com.tencent.mm.permission.MM_MESSAGE");
            } else {
                intent = new Intent("com.tencent.mm.ACTION.note_tracemsg_unlock");
                intent.putExtra("pid", myPid);
                intent.putExtra("processName", processName);
                intent.putExtra("traceMsg", str);
                intent.putExtra("tick", SystemClock.elapsedRealtime());
                ad.getContext().sendBroadcast(intent, "com.tencent.mm.permission.MM_MESSAGE");
            }
        }

        private static void b(String str, String str2, long j) {
            String str3 = str + "_" + str2;
            synchronized (dov) {
                a aVar = (a) dou.get(str3);
                if (aVar == null) {
                    aVar = new a();
                    aVar.dox = str;
                    aVar.doq = str2;
                    aVar.doC = 0;
                    aVar.doA = 0;
                    aVar.doB = 0;
                    dou.put(str3, aVar);
                }
                if (aVar.doE.getAndIncrement() == 0) {
                    aVar.doD = j;
                    aVar.doy = ao.getNetTypeString(ad.getContext());
                    aVar.doz = com.tencent.mm.sdk.a.b.foreground;
                }
            }
        }

        private static void c(String str, String str2, long j) {
            long j2;
            String str3 = str + "_" + str2;
            long j3 = 0;
            synchronized (dov) {
                a aVar = (a) dou.get(str3);
                if (aVar != null && aVar.doE.get() > 0) {
                    aVar.doA++;
                    if (aVar.doE.decrementAndGet() == 0) {
                        j3 = j - aVar.doD;
                        aVar.doC += j3;
                        aVar.doB++;
                    }
                }
                j2 = j3;
            }
            CR();
            j3 = SystemClock.elapsedRealtime();
            if (j2 >= 14000 || j3 - dot >= 3600000) {
                x.d("MicroMsg.WakeLockStatsManager", "saveStatsToStorage triggered.");
                CS();
                dot = j3;
            }
        }

        private static void CR() {
            synchronized (dov) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime - bzV >= 21600000) {
                    if (!dou.isEmpty()) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (Entry value : dou.entrySet()) {
                            a aVar = (a) value.getValue();
                            if (aVar.doB > 0) {
                                stringBuilder.setLength(0);
                                stringBuilder.append(aVar.dox).append(',').append(aVar.doq.replace(",", "##")).append(',').append(aVar.doB).append(',').append(aVar.doA).append(',').append(aVar.doC).append(',').append(aVar.doz ? 1 : 0).append(',').append(aVar.doy);
                                String stringBuilder2 = stringBuilder.toString();
                                com.tencent.mm.sdk.b.b nmVar = new nm();
                                nmVar.bYy.bYz = stringBuilder2;
                                com.tencent.mm.sdk.b.a.sFg.m(nmVar);
                                x.d("MicroMsg.WakeLockStatsManager", "kvstat-str: %s", stringBuilder.toString());
                            }
                        }
                        dou.clear();
                    }
                    bzV = elapsedRealtime;
                }
            }
        }

        private static void CS() {
            Throwable e;
            synchronized (dov) {
                ObjectOutputStream objectOutputStream = null;
                try {
                    File file = new File(ad.getContext().getCacheDir(), "wakelock");
                    if (FileOp.mL(file.getAbsolutePath())) {
                        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(new File(file, "wakelock_stats.bin")));
                        try {
                            objectOutputStream2.writeLong(bzV);
                            objectOutputStream2.writeObject(dou);
                            try {
                                objectOutputStream2.close();
                            } catch (Exception e2) {
                            }
                        } catch (IOException e3) {
                            e = e3;
                            objectOutputStream = objectOutputStream2;
                            try {
                                x.printErrStackTrace("MicroMsg.WakeLockStatsManager", e, "failed to save stats to storage.", new Object[0]);
                                if (objectOutputStream != null) {
                                    try {
                                        objectOutputStream.close();
                                    } catch (Exception e4) {
                                    }
                                }
                            } catch (Throwable th) {
                                e = th;
                                if (objectOutputStream != null) {
                                    try {
                                        objectOutputStream.close();
                                    } catch (Exception e5) {
                                    }
                                }
                                throw e;
                            }
                        } catch (Throwable th2) {
                            e = th2;
                            objectOutputStream = objectOutputStream2;
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (Exception e52) {
                                }
                            }
                            throw e;
                        }
                    } else {
                        throw new IOException("failed to call FileOp.mkdirs(" + file.getAbsolutePath() + ")");
                    }
                } catch (IOException e6) {
                    e = e6;
                    x.printErrStackTrace("MicroMsg.WakeLockStatsManager", e, "failed to save stats to storage.", new Object[0]);
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (Exception e42) {
                        }
                    }
                }
            }
        }
    }

    public static void CM() {
        c.CQ();
    }

    public static void CN() {
        c.detach();
    }

    public static void a(WakerLock wakerLock, String str) {
        synchronized (dol) {
            b bVar = (b) dok.get(wakerLock.hashCode());
            if (bVar == null) {
                bVar = new b(wakerLock);
                dok.put(wakerLock.hashCode(), bVar);
            }
            if (!bVar.dop.containsKey(str)) {
                bVar.dop.put(str, new a(str, SystemClock.elapsedRealtime()));
            }
            c.fK(str);
            ag agVar = mHandler;
            if (!bVar.don) {
                bVar.don = true;
                agVar.postDelayed(bVar.doo, 60000);
            }
        }
    }

    public static void c(WakerLock wakerLock) {
        synchronized (dol) {
            b bVar = (b) dok.get(wakerLock.hashCode());
            if (bVar != null) {
                ag agVar = mHandler;
                if (bVar.don) {
                    bVar.don = false;
                    agVar.removeCallbacks(bVar.doo);
                }
                for (a aVar : bVar.dop.values()) {
                    c.fL(aVar.doq);
                }
                bVar.dop.clear();
            }
        }
    }
}
