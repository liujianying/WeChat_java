package com.tencent.matrix.a.b;

import android.app.AlarmManager.OnAlarmListener;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Environment;
import android.os.Parcel;
import android.os.SystemClock;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends com.tencent.matrix.c.c {
    private final int bpb;
    private final int bpc;
    private final f bpj = new f();
    final b bpk;
    List<a> bpl;
    private long bpm;

    private static final class a {
        final long bpn;
        final long bpo;
        final e bpp;
        final OnAlarmListener bpq;
        long bpr;
        final String stackTrace;
        final int type;

        a(int i, long j, long j2, PendingIntent pendingIntent, OnAlarmListener onAlarmListener, String str) {
            this.type = i;
            long elapsedRealtime = (i == 2 || i == 3) ? SystemClock.elapsedRealtime() : System.currentTimeMillis();
            elapsedRealtime += 5000;
            if (j < elapsedRealtime) {
                j = elapsedRealtime;
            }
            this.bpn = j;
            if (j2 > 0 && j2 < 60000) {
                j2 = 60000;
            }
            this.bpo = j2;
            this.bpp = new e(pendingIntent);
            this.bpq = onAlarmListener;
            this.stackTrace = str;
            this.bpr = Long.MAX_VALUE;
        }

        a(int i, long j, long j2, e eVar, String str, long j3) {
            this.type = i;
            this.bpn = j;
            this.bpo = j2;
            this.bpp = eVar;
            this.bpq = null;
            this.stackTrace = str;
            this.bpr = j3;
        }

        public final void tj() {
            if (this.bpr == Long.MAX_VALUE) {
                this.bpr = System.currentTimeMillis();
            }
        }
    }

    private static final class b {
        private final String bps;

        b() {
            String h = com.tencent.matrix.d.c.h("yyyy-MM-dd", System.currentTimeMillis());
            this.bps = String.format("%s/com.tencent.matrix/alarm-detector-record/%s/alarm-info-record-%s", new Object[]{Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.matrix.a.c.a.getPackageName(), h});
            com.tencent.matrix.d.b.i("MicroMsg.AlarmDetector", "AlarmInfoRecorder path:%s", this.bps);
        }

        final void bX(String str) {
            FileNotFoundException e;
            Throwable th;
            IOException e2;
            BufferedWriter bufferedWriter = null;
            try {
                File file = new File(this.bps);
                if (file.getParentFile().mkdirs() || file.getParentFile().exists()) {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
                    try {
                        bufferedWriter2.write(str, 0, str.length());
                        bufferedWriter2.flush();
                        try {
                            bufferedWriter2.close();
                            return;
                        } catch (IOException e3) {
                            return;
                        }
                    } catch (FileNotFoundException e4) {
                        e = e4;
                        bufferedWriter = bufferedWriter2;
                        try {
                            com.tencent.matrix.d.b.w("MicroMsg.AlarmDetector", "doRecord exp:%s", e.getLocalizedMessage());
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e5) {
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e6) {
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e7) {
                        e2 = e7;
                        bufferedWriter = bufferedWriter2;
                        com.tencent.matrix.d.b.w("MicroMsg.AlarmDetector", "doRecord exp:%s", e2.getLocalizedMessage());
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e8) {
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e62) {
                            }
                        }
                        throw th;
                    }
                }
                com.tencent.matrix.d.b.e("MicroMsg.AlarmDetector", "doRecord mkdirs failed", new Object[0]);
            } catch (FileNotFoundException e9) {
                e = e9;
                com.tencent.matrix.d.b.w("MicroMsg.AlarmDetector", "doRecord exp:%s", e.getLocalizedMessage());
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e52) {
                    }
                }
            } catch (IOException e10) {
                e2 = e10;
                com.tencent.matrix.d.b.w("MicroMsg.AlarmDetector", "doRecord exp:%s", e2.getLocalizedMessage());
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e82) {
                    }
                }
            }
        }
    }

    private static final class c implements Serializable {
        static final /* synthetic */ boolean $assertionsDisabled = (!a.class.desiredAssertionStatus());
        final long bpn;
        final long bpo;
        long bpr;
        final int bpt;
        final byte[] bpu;
        final String bpv;
        final String stackTrace;
        final int type;

        c(a aVar) {
            if ($assertionsDisabled || aVar != null) {
                this.type = aVar.type;
                this.bpn = aVar.bpn;
                this.bpo = aVar.bpo;
                this.bpt = aVar.bpp.bpt;
                this.bpu = a.j(aVar.bpp.bpz);
                this.bpv = aVar.bpp.bpv;
                this.stackTrace = aVar.stackTrace;
                this.bpr = aVar.bpr;
                return;
            }
            throw new AssertionError();
        }
    }

    private static final class d implements Serializable {
        private final List<c> bpl = new ArrayList();
        private final long bpm;

        d(List<a> list, long j) {
            if (list != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    }
                    this.bpl.add(new c((a) list.get(i2)));
                    i = i2 + 1;
                }
            }
            this.bpm = j;
        }

        public final List<a> tk() {
            List<a> arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.bpl.size()) {
                    return arrayList;
                }
                c cVar = (c) this.bpl.get(i2);
                arrayList.add(new a(cVar.type, cVar.bpn, cVar.bpo, new e(cVar.bpt, a.s(cVar.bpu), cVar.bpv), cVar.stackTrace, cVar.bpr));
                i = i2 + 1;
            }
        }
    }

    private static final class e {
        private static Method bpw;
        private static Method bpx;
        final int bpt;
        final String bpv;
        final PendingIntent bpy;
        final Intent bpz;

        e(PendingIntent pendingIntent) {
            this.bpy = pendingIntent;
            if (this.bpy != null) {
                this.bpt = pendingIntent.hashCode();
                this.bpz = a(pendingIntent);
                this.bpv = b(pendingIntent);
                return;
            }
            this.bpt = -1;
            this.bpz = null;
            this.bpv = null;
        }

        e(int i, Intent intent, String str) {
            this.bpy = null;
            this.bpt = i;
            this.bpz = intent;
            this.bpv = str;
        }

        private static Intent a(PendingIntent pendingIntent) {
            if (pendingIntent == null) {
                return null;
            }
            if (bpw == null) {
                try {
                    Method declaredMethod = PendingIntent.class.getDeclaredMethod("getIntent", new Class[0]);
                    bpw = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    com.tencent.matrix.d.b.w("MicroMsg.AlarmDetector", "getOperationIntent e:%s", e);
                    return null;
                }
            }
            try {
                Object invoke = bpw.invoke(pendingIntent, new Object[0]);
                if (invoke instanceof Intent) {
                    return (Intent) invoke;
                }
                return null;
            } catch (IllegalAccessException e2) {
                com.tencent.matrix.d.b.w("MicroMsg.AlarmDetector", "getOperationIntent e:%s", e2);
            } catch (InvocationTargetException e3) {
                com.tencent.matrix.d.b.w("MicroMsg.AlarmDetector", "getOperationIntent e:%s cause:%s", e3, e3.getCause());
            } catch (SecurityException e4) {
                com.tencent.matrix.d.b.w("MicroMsg.AlarmDetector", "getOperationIntent e:%s", e4);
            }
            return null;
        }

        private static String b(PendingIntent pendingIntent) {
            if (pendingIntent == null) {
                return null;
            }
            if (bpx == null) {
                try {
                    Method declaredMethod = PendingIntent.class.getDeclaredMethod("getTag", new Class[]{String.class});
                    bpx = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    com.tencent.matrix.d.b.w("MicroMsg.AlarmDetector", "getOperationIntentTag e:%s", e);
                    return null;
                }
            }
            try {
                Object invoke = bpx.invoke(pendingIntent, new Object[]{""});
                if (invoke instanceof String) {
                    return (String) invoke;
                }
                return null;
            } catch (IllegalAccessException e2) {
                com.tencent.matrix.d.b.w("MicroMsg.AlarmDetector", "getOperationIntentTag e:%s", e2);
            } catch (InvocationTargetException e3) {
                com.tencent.matrix.d.b.w("MicroMsg.AlarmDetector", "getOperationIntentTag e:%s", e3);
            }
            return null;
        }
    }

    private final class f {
        final String bpA = String.format("%s/com.tencent.matrix/alarm-detector-record/%s/current-alarm-info-%s", new Object[]{Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.matrix.a.c.a.getPackageName(), com.tencent.matrix.a.c.a.getProcessName()});

        f() {
            com.tencent.matrix.d.b.i("MicroMsg.AlarmDetector", "PersistenceHelper mSaveFileName :%s", this.bpA);
        }
    }

    static /* synthetic */ byte[] j(Intent intent) {
        if (intent == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        intent.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    static /* synthetic */ Intent s(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        Intent intent = (Intent) Intent.CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return intent;
    }

    public a(com.tencent.matrix.c.c.a aVar, com.tencent.matrix.a.a.a aVar2) {
        IOException e;
        Throwable th;
        ClassNotFoundException e2;
        super(aVar);
        this.bpb = aVar2.bpb;
        this.bpc = aVar2.bpc;
        f fVar = this.bpj;
        File file = new File(fVar.bpA);
        if (file.exists()) {
            ObjectInputStream objectInputStream;
            try {
                objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
                try {
                    d dVar = (d) objectInputStream.readObject();
                    if (dVar != null) {
                        fVar.bpB.bpl = dVar.tk();
                        fVar.bpB.bpm = dVar.bpm;
                    }
                    try {
                        objectInputStream.close();
                    } catch (IOException e3) {
                        com.tencent.matrix.d.b.w("MicroMsg.AlarmDetector", "save : exp:%s", e3);
                    }
                } catch (IOException e4) {
                    e3 = e4;
                    try {
                        com.tencent.matrix.d.b.w("MicroMsg.AlarmDetector", "load : exp:%s", e3);
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e32) {
                                com.tencent.matrix.d.b.w("MicroMsg.AlarmDetector", "save : exp:%s", e32);
                            }
                        }
                        if (fVar.bpB.bpl == null) {
                            fVar.bpB.bpl = new ArrayList();
                            fVar.bpB.bpm = -1;
                        }
                        com.tencent.matrix.d.b.i("MicroMsg.AlarmDetector", "load mCurrentCountPeriodFrom:%d, mCurrentRunningAlarms size:%d", Long.valueOf(fVar.bpB.bpm), Integer.valueOf(fVar.bpB.bpl.size()));
                        if (aVar2.el(8)) {
                            this.bpk = null;
                        } else {
                            this.bpk = new b();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e5) {
                                com.tencent.matrix.d.b.w("MicroMsg.AlarmDetector", "save : exp:%s", e5);
                            }
                        }
                        throw th;
                    }
                } catch (ClassNotFoundException e6) {
                    e2 = e6;
                    com.tencent.matrix.d.b.w("MicroMsg.AlarmDetector", "load : exp:%s", e2);
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e322) {
                            com.tencent.matrix.d.b.w("MicroMsg.AlarmDetector", "save : exp:%s", e322);
                        }
                    }
                    if (fVar.bpB.bpl == null) {
                        fVar.bpB.bpl = new ArrayList();
                        fVar.bpB.bpm = -1;
                    }
                    com.tencent.matrix.d.b.i("MicroMsg.AlarmDetector", "load mCurrentCountPeriodFrom:%d, mCurrentRunningAlarms size:%d", Long.valueOf(fVar.bpB.bpm), Integer.valueOf(fVar.bpB.bpl.size()));
                    if (aVar2.el(8)) {
                        this.bpk = new b();
                    } else {
                        this.bpk = null;
                    }
                }
            } catch (IOException e7) {
                e322 = e7;
                objectInputStream = null;
                com.tencent.matrix.d.b.w("MicroMsg.AlarmDetector", "load : exp:%s", e322);
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e3222) {
                        com.tencent.matrix.d.b.w("MicroMsg.AlarmDetector", "save : exp:%s", e3222);
                    }
                }
                if (fVar.bpB.bpl == null) {
                    fVar.bpB.bpl = new ArrayList();
                    fVar.bpB.bpm = -1;
                }
                com.tencent.matrix.d.b.i("MicroMsg.AlarmDetector", "load mCurrentCountPeriodFrom:%d, mCurrentRunningAlarms size:%d", Long.valueOf(fVar.bpB.bpm), Integer.valueOf(fVar.bpB.bpl.size()));
                if (aVar2.el(8)) {
                    this.bpk = null;
                } else {
                    this.bpk = new b();
                }
            } catch (ClassNotFoundException e8) {
                e2 = e8;
                objectInputStream = null;
                com.tencent.matrix.d.b.w("MicroMsg.AlarmDetector", "load : exp:%s", e2);
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e32222) {
                        com.tencent.matrix.d.b.w("MicroMsg.AlarmDetector", "save : exp:%s", e32222);
                    }
                }
                if (fVar.bpB.bpl == null) {
                    fVar.bpB.bpl = new ArrayList();
                    fVar.bpB.bpm = -1;
                }
                com.tencent.matrix.d.b.i("MicroMsg.AlarmDetector", "load mCurrentCountPeriodFrom:%d, mCurrentRunningAlarms size:%d", Long.valueOf(fVar.bpB.bpm), Integer.valueOf(fVar.bpB.bpl.size()));
                if (aVar2.el(8)) {
                    this.bpk = new b();
                } else {
                    this.bpk = null;
                }
            } catch (Throwable th3) {
                th = th3;
                objectInputStream = null;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e52) {
                        com.tencent.matrix.d.b.w("MicroMsg.AlarmDetector", "save : exp:%s", e52);
                    }
                }
                throw th;
            }
            if (fVar.bpB.bpl == null) {
                fVar.bpB.bpl = new ArrayList();
                fVar.bpB.bpm = -1;
            }
            com.tencent.matrix.d.b.i("MicroMsg.AlarmDetector", "load mCurrentCountPeriodFrom:%d, mCurrentRunningAlarms size:%d", Long.valueOf(fVar.bpB.bpm), Integer.valueOf(fVar.bpB.bpl.size()));
        } else {
            fVar.bpB.bpl = new ArrayList();
            fVar.bpB.bpm = -1;
        }
        if (aVar2.el(8)) {
            this.bpk = new b();
        } else {
            this.bpk = null;
        }
    }

    final void ti() {
        IOException e;
        Throwable th;
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.matrix.d.b.i("MicroMsg.AlarmDetector", "countAndDetect now:%d mCurrentCountPeriodFrom:%d", Long.valueOf(currentTimeMillis), Long.valueOf(this.bpm));
        if (this.bpm <= 0) {
            this.bpm = currentTimeMillis;
        }
        if (currentTimeMillis - this.bpm >= 345600000) {
            this.bpm = currentTimeMillis - 172800000;
        } else if (currentTimeMillis - this.bpm >= 172800000) {
            this.bpm += 172800000;
        }
        while (this.bpm + 3600000 <= currentTimeMillis) {
            if (this.bpl == null || this.bpl.isEmpty()) {
                com.tencent.matrix.d.b.i("MicroMsg.AlarmDetector", "doCountAndDetect no alarms", new Object[0]);
            } else {
                Object obj;
                StringBuilder stringBuilder = new StringBuilder();
                StringBuilder stringBuilder2 = new StringBuilder();
                int i = 0;
                long j = this.bpm + 3600000;
                Iterator it = this.bpl.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    long currentTimeMillis2 = (aVar.type == 1 || aVar.type == 0) ? aVar.bpn : (aVar.bpn + System.currentTimeMillis()) - SystemClock.elapsedRealtime();
                    if (currentTimeMillis2 < this.bpm && aVar.bpo <= 0) {
                        it.remove();
                    } else if (aVar.bpr < this.bpm || aVar.bpr <= currentTimeMillis2) {
                        it.remove();
                    } else if (currentTimeMillis2 < j) {
                        if (aVar.bpo > 0) {
                            long j2 = aVar.bpr < j ? aVar.bpr : j;
                            currentTimeMillis2 = this.bpm <= currentTimeMillis2 ? (((j2 - currentTimeMillis2) - 1) / aVar.bpo) + 1 : ((j2 - (this.bpm - ((this.bpm - currentTimeMillis2) % aVar.bpo))) - 1) / aVar.bpo;
                        } else {
                            currentTimeMillis2 = 1;
                        }
                        i = (int) (((long) i) + currentTimeMillis2);
                        stringBuilder.append(aVar.stackTrace).append("\t\t");
                        obj = (aVar.type == 0 || aVar.type == 2) ? 1 : null;
                        if (obj != null) {
                            i2 = (int) (currentTimeMillis2 + ((long) i2));
                            stringBuilder2.append(aVar.stackTrace).append("\t\t");
                        }
                    }
                }
                int i3 = -1;
                obj = null;
                if (i >= this.bpb) {
                    obj = stringBuilder.toString();
                    i3 = 4;
                } else if (i2 >= this.bpc) {
                    i3 = 5;
                    i = i2;
                    String stringBuilder3 = stringBuilder2.toString();
                } else {
                    i = 0;
                }
                if (i3 > 0) {
                    String ce = com.tencent.matrix.d.c.ce(String.format("%d%s", new Object[]{Integer.valueOf(i3), obj}));
                    if (cb(ce)) {
                        com.tencent.matrix.d.b.v("MicroMsg.AlarmDetector", "doCountAndDetect issue already published", new Object[0]);
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("alarmSetStacks", obj);
                            jSONObject.put("alarmTriggeredNum1H", i);
                            jSONObject.put("subTag", "alarm");
                        } catch (JSONException e2) {
                            com.tencent.matrix.d.b.e("MicroMsg.AlarmDetector", "doCountAndDetect json content error: %s", e2);
                        }
                        com.tencent.matrix.c.b bVar = new com.tencent.matrix.c.b(i3);
                        bVar.aAL = ce;
                        bVar.brm = jSONObject;
                        c(bVar);
                        ca(ce);
                    }
                }
            }
            this.bpm += 3600000;
        }
        f fVar = this.bpj;
        File file = new File(fVar.bpA);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            try {
                objectOutputStream.writeObject(new d(fVar.bpB.bpl, fVar.bpB.bpm));
                objectOutputStream.flush();
                com.tencent.matrix.d.b.i("MicroMsg.AlarmDetector", "save mCurrentCountPeriodFrom:%d, mCurrentRunningAlarms size:%d", Long.valueOf(fVar.bpB.bpm), Integer.valueOf(fVar.bpB.bpl.size()));
                try {
                    objectOutputStream.close();
                } catch (IOException e3) {
                    com.tencent.matrix.d.b.i("MicroMsg.AlarmDetector", "save close: exp:%s", e3);
                }
            } catch (IOException e4) {
                e3 = e4;
                try {
                    com.tencent.matrix.d.b.w("MicroMsg.AlarmDetector", "save : exp:%s", e3);
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e32) {
                            com.tencent.matrix.d.b.i("MicroMsg.AlarmDetector", "save close: exp:%s", e32);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e5) {
                            com.tencent.matrix.d.b.i("MicroMsg.AlarmDetector", "save close: exp:%s", e5);
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e6) {
            e32 = e6;
            objectOutputStream = null;
            com.tencent.matrix.d.b.w("MicroMsg.AlarmDetector", "save : exp:%s", e32);
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e322) {
                    com.tencent.matrix.d.b.i("MicroMsg.AlarmDetector", "save close: exp:%s", e322);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            objectOutputStream = null;
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e52) {
                    com.tencent.matrix.d.b.i("MicroMsg.AlarmDetector", "save close: exp:%s", e52);
                }
            }
            throw th;
        }
    }

    final void a(OnAlarmListener onAlarmListener, e eVar) {
        for (int i = 0; i < this.bpl.size(); i++) {
            a aVar = (a) this.bpl.get(i);
            if (aVar.bpq == null || !aVar.bpq.equals(onAlarmListener)) {
                if (aVar.bpp != null) {
                    Object obj;
                    e eVar2 = aVar.bpp;
                    int obj2;
                    if (eVar2.bpy != null && eVar2.bpy.equals(eVar.bpy)) {
                        obj2 = 1;
                    } else if (eVar2.bpt == eVar.bpt) {
                        obj2 = 1;
                    } else if (eVar2.bpz != null && eVar2.bpz.filterEquals(eVar.bpz)) {
                        obj2 = 1;
                    } else if (eVar2.bpv == null || !eVar2.bpv.equals(eVar.bpv)) {
                        obj2 = null;
                    } else {
                        obj2 = 1;
                    }
                    if (obj2 != null) {
                        aVar.tj();
                    }
                }
                if (aVar.bpp == null && aVar.bpq == null) {
                    aVar.tj();
                }
            } else {
                aVar.tj();
            }
        }
    }
}
