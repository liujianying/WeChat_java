package com.tencent.matrix.a.b;

import android.os.Environment;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

public final class f extends com.tencent.matrix.c.c {
    private final int boZ;
    private final int bpa;
    final Map<String, d> bqg = new HashMap();
    final Map<String, c> bqh = new HashMap();
    final int bqi;
    final a bqj;
    final Runnable bqk;
    final e bql;

    public interface a {
        void b(Runnable runnable, long j);

        boolean isScreenOn();
    }

    private static final class b {
        final Vector<String> bqn = new Vector();

        b() {
        }

        final void bY(String str) {
            this.bqn.add(str);
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.bqn.size()) {
                    return stringBuilder.toString();
                }
                stringBuilder.append((String) this.bqn.get(i2)).append("\t\t");
                i = i2 + 1;
            }
        }
    }

    private static final class c {
        final long bqo = System.currentTimeMillis();
        long bqp = 0;
        int bqq = 0;
        int bqr = 0;
        b bqs = new b();
        final Map<String, Boolean> bqt = new HashMap();
        long bqu = -1;
        final String tag;

        c(String str) {
            this.tag = str;
        }

        final void tp() {
            if (this.bqu >= 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.bqp += currentTimeMillis - this.bqu;
                this.bqu = currentTimeMillis;
            }
        }
    }

    private static final class d {
        b bqs = new b();
        final String bqv;
        final long bqw;
        final int flags;
        final String tag;

        d(String str, String str2, int i, long j) {
            this.bqv = str;
            this.tag = str2;
            this.flags = i;
            this.bqw = j;
        }
    }

    private static final class e {
        private final String bps;
        int bqx;
        final StringBuilder bqy = new StringBuilder();

        e() {
            String h = com.tencent.matrix.d.c.h("yyyy-MM-dd", System.currentTimeMillis());
            this.bps = String.format("%s/com.tencent.matrix/wakelock-detector-record/%s/wakelocks-%s", new Object[]{Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.matrix.a.c.a.getPackageName(), h});
            com.tencent.matrix.d.b.i("Matrix.WakeLockDetector", "WakeLockInfoRecorder path:%s", this.bps);
        }

        final void tq() {
            FileNotFoundException e;
            Throwable th;
            IOException e2;
            if (this.bqx >= 10) {
                BufferedWriter bufferedWriter = null;
                try {
                    File file = new File(this.bps);
                    if (file.getParentFile().mkdirs() || file.getParentFile().exists()) {
                        BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
                        try {
                            String stringBuilder = this.bqy.toString();
                            bufferedWriter2.write(stringBuilder, 0, stringBuilder.length());
                            bufferedWriter2.flush();
                            try {
                                bufferedWriter2.close();
                            } catch (IOException e3) {
                            }
                        } catch (FileNotFoundException e4) {
                            e = e4;
                            bufferedWriter = bufferedWriter2;
                            try {
                                com.tencent.matrix.d.b.w("Matrix.WakeLockDetector", "dumpCache exp:%s", e.getLocalizedMessage());
                                if (bufferedWriter != null) {
                                    try {
                                        bufferedWriter.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                this.bqx = 0;
                                this.bqy.delete(0, this.bqy.length());
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
                            com.tencent.matrix.d.b.w("Matrix.WakeLockDetector", "dumpCache exp:%s", e2.getLocalizedMessage());
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e8) {
                                }
                            }
                            this.bqx = 0;
                            this.bqy.delete(0, this.bqy.length());
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
                        this.bqx = 0;
                        this.bqy.delete(0, this.bqy.length());
                    }
                    com.tencent.matrix.d.b.e("Matrix.WakeLockDetector", "doRecord mkdirs failed", new Object[0]);
                    this.bqx = 0;
                    this.bqy.delete(0, this.bqy.length());
                } catch (FileNotFoundException e9) {
                    e = e9;
                    com.tencent.matrix.d.b.w("Matrix.WakeLockDetector", "dumpCache exp:%s", e.getLocalizedMessage());
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e52) {
                        }
                    }
                    this.bqx = 0;
                    this.bqy.delete(0, this.bqy.length());
                } catch (IOException e10) {
                    e2 = e10;
                    com.tencent.matrix.d.b.w("Matrix.WakeLockDetector", "dumpCache exp:%s", e2.getLocalizedMessage());
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e82) {
                        }
                    }
                    this.bqx = 0;
                    this.bqy.delete(0, this.bqy.length());
                }
            }
        }
    }

    public f(com.tencent.matrix.c.c.a aVar, com.tencent.matrix.a.a.a aVar2, a aVar3) {
        super(aVar);
        this.bqi = aVar2.boY;
        this.bpa = aVar2.bpa;
        this.boZ = aVar2.boZ;
        this.bqj = aVar3;
        this.bqk = new Runnable() {
            public final void run() {
                for (Entry value : f.this.bqh.entrySet()) {
                    ((c) value.getValue()).tp();
                }
                f.this.tn();
            }
        };
        if (aVar2.el(2)) {
            this.bql = new e();
        } else {
            this.bql = null;
        }
    }

    final void tn() {
        long currentTimeMillis = System.currentTimeMillis();
        for (Entry value : this.bqg.entrySet()) {
            d dVar = (d) value.getValue();
            if (currentTimeMillis - dVar.bqw >= ((long) this.bqi)) {
                String format = String.format("%s:%d", new Object[]{dVar.tag, Integer.valueOf(1)});
                if (cb(format)) {
                    com.tencent.matrix.d.b.v("Matrix.WakeLockDetector", "detectWakeLockOnceHoldTime issue already published: %s", format);
                } else {
                    com.tencent.matrix.c.b bVar = new com.tencent.matrix.c.b(1);
                    bVar.aAL = format;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("subTag", "wakeLock");
                        jSONObject.put("wakeLockTag", dVar.tag);
                        jSONObject.put("flags", dVar.flags);
                        jSONObject.put("holdTime", currentTimeMillis - dVar.bqw);
                        jSONObject.put("stackHistory", dVar.bqs);
                    } catch (JSONException e) {
                        com.tencent.matrix.d.b.e("Matrix.WakeLockDetector", "json content error: %s", e);
                    }
                    bVar.brm = jSONObject;
                    c(bVar);
                    ca(format);
                }
            }
        }
        to();
    }

    private void to() {
        long currentTimeMillis = System.currentTimeMillis();
        for (Entry entry : this.bqh.entrySet()) {
            String str = (String) entry.getKey();
            c cVar = (c) entry.getValue();
            long j = currentTimeMillis - cVar.bqo;
            int i = ((int) (j / 3600000)) + 1;
            int i2 = cVar.bqr / i;
            long j2 = cVar.bqp / ((long) i);
            if (cVar.bqq / i >= this.boZ || i2 > this.boZ / 2) {
                String format = String.format("%s:%d", new Object[]{str, Integer.valueOf(2)});
                if (cb(format)) {
                    com.tencent.matrix.d.b.v("Matrix.WakeLockDetector", "detectWakeLockAggregation issue already published: %s", format);
                } else {
                    com.tencent.matrix.c.b bVar = new com.tencent.matrix.c.b(2);
                    bVar.aAL = format;
                    bVar.brm = a(cVar, j);
                    c(bVar);
                    ca(format);
                }
            }
            if (j2 >= ((long) this.bpa)) {
                str = String.format("%s:%d", new Object[]{str, Integer.valueOf(3)});
                if (cb(str)) {
                    com.tencent.matrix.d.b.v("Matrix.WakeLockDetector", "detectWakeLockAggregation issue already published: %s", str);
                } else {
                    com.tencent.matrix.c.b bVar2 = new com.tencent.matrix.c.b(3);
                    bVar2.aAL = str;
                    bVar2.brm = a(cVar, j);
                    c(bVar2);
                    ca(str);
                }
            }
        }
    }

    private static JSONObject a(c cVar, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wakeLockTag", cVar.tag);
            jSONObject.put("subTag", "wakeLock");
            jSONObject.put("timeFrame", j);
            jSONObject.put("acquireCnt", cVar.bqq);
            jSONObject.put("acquireCntWhenScreenOff", cVar.bqr);
            jSONObject.put("statisticalHoldTime", cVar.bqp);
            jSONObject.put("stackHistory", cVar.bqs);
        } catch (JSONException e) {
            com.tencent.matrix.d.b.e("Matrix.WakeLockDetector", "json content error: %s", e);
        }
        return jSONObject;
    }
}
