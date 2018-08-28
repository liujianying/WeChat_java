package com.tencent.mm.sdk.platformtools;

import android.os.Debug;
import android.os.Handler;
import android.os.Process;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class am implements Runnable {
    private static final String sHl;
    private static final String sHm;
    long dFc;
    long endTime;
    final Handler handler;
    final String jGC;
    int priority;
    final Runnable sHb;
    final Object sHc;
    long sHd;
    final a sHe;
    long sHf;
    long sHg;
    long sHh;
    long sHi;
    long sHj;
    float sHk = -1.0f;
    boolean started = false;
    final Thread thread;
    String threadName;

    public interface a {
        void a(Runnable runnable, am amVar);

        void a(Runnable runnable, Thread thread, long j, long j2, float f);
    }

    am(Thread thread, Handler handler, Runnable runnable, Object obj, a aVar) {
        this.thread = thread;
        if (thread != null) {
            this.threadName = thread.getName();
            this.sHd = thread.getId();
            this.priority = thread.getPriority();
        }
        this.handler = handler;
        this.sHb = runnable;
        String name = runnable.getClass().getName();
        String obj2 = runnable.toString();
        if (!bi.oW(obj2)) {
            int indexOf = obj2.indexOf(124);
            if (indexOf > 0) {
                name = name + "_" + obj2.substring(indexOf + 1);
            }
        }
        this.jGC = name;
        this.sHc = obj;
        this.sHe = aVar;
        this.sHf = System.currentTimeMillis();
    }

    public final void run() {
        new StringBuilder("/proc/self/task/").append(Process.myTid()).append("/stat");
        this.dFc = System.currentTimeMillis();
        this.sHh = Debug.threadCpuTimeNanos();
        this.sHi = -1;
        this.sHj = -1;
        this.started = true;
        this.sHb.run();
        this.sHi = -1 - this.sHi;
        this.sHj = -1 - this.sHj;
        this.endTime = System.currentTimeMillis();
        this.dFc = this.endTime - this.dFc;
        this.sHh = (Debug.threadCpuTimeNanos() - this.sHh) / 1000000;
        if (this.sHj != 0) {
            this.sHk = ((float) (100 * this.sHi)) / ((float) this.sHj);
        }
        if (this.sHe != null) {
            this.sHe.a(this.sHb, this);
            this.sHe.a(this, this.thread, this.dFc, this.sHh, this.sHk);
        }
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("taskName = %s");
        stringBuilder.append("|token = %s");
        stringBuilder.append("|handler = %s");
        stringBuilder.append("|threadName = %s");
        stringBuilder.append("|threadId = %d");
        stringBuilder.append("|priority = %d");
        stringBuilder.append("|addTime = %d");
        stringBuilder.append("|delayTime = %d");
        stringBuilder.append("|usedTime = %d");
        stringBuilder.append("|cpuTime = %d");
        stringBuilder.append("|started = %b");
        sHl = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("taskName = %s");
        stringBuilder.append(" | addTime = %s");
        stringBuilder.append(" | endTime = %s");
        stringBuilder.append(" | usedTime = %d");
        stringBuilder.append(" | cpuTime = %d");
        stringBuilder.append(" | threadCpuTime = %d");
        stringBuilder.append(" | totalCpuTime = %d");
        stringBuilder.append(" | threadCpuRate = %.1f");
        sHm = stringBuilder.toString();
    }

    public final String dump(boolean z) {
        if (z) {
            return String.format(sHl, new Object[]{this.jGC, this.sHc, this.handler, this.threadName, Long.valueOf(this.sHd), Integer.valueOf(this.priority), Long.valueOf(this.sHf), Long.valueOf(this.sHg), Long.valueOf(this.dFc), Long.valueOf(this.sHh), Boolean.valueOf(this.started)});
        }
        return String.format(sHm, new Object[]{this.jGC, new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.sHf)), new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.endTime)), Long.valueOf(this.dFc), Long.valueOf(this.sHh), Long.valueOf(this.sHi), Long.valueOf(this.sHj), Float.valueOf(this.sHk)});
    }
}
