package com.tencent.mm.console;

import android.os.Debug;
import android.os.Debug.MemoryInfo;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.console.b.10;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.Thread.State;

class b$10$1 implements a {
    final /* synthetic */ 10 dhn;

    b$10$1(10 10) {
        this.dhn = 10;
    }

    public final boolean vD() {
        Exception e;
        Throwable th;
        if (d.fR(23)) {
            x.i("MicroMsg.CommandProcessor", "gcCount: %s", Debug.getRuntimeStats());
        } else {
            int globalGcInvocationCount = Debug.getGlobalGcInvocationCount();
            int threadGcInvocationCount = Debug.getThreadGcInvocationCount();
            x.i("MicroMsg.CommandProcessor", "gcCount: %d %d", Integer.valueOf(globalGcInvocationCount), Integer.valueOf(threadGcInvocationCount));
        }
        long pss = Debug.getPss();
        Debug.getMemoryInfo(new MemoryInfo());
        if (d.fR(23)) {
            x.i("MicroMsg.CommandProcessor", "pss: %d, memoryInfo:%s", Long.valueOf(pss), r2.getMemoryStats());
        } else {
            x.i("MicroMsg.CommandProcessor", "pss: %d, memoryInfo:%d", Long.valueOf(pss), Integer.valueOf(r2.nativePss));
        }
        LineNumberReader lineNumberReader;
        try {
            Process exec = Runtime.getRuntime().exec("top -m 5 -n 1");
            lineNumberReader = new LineNumberReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                try {
                    String readLine = lineNumberReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (readLine.length() > 0) {
                        x.i("MicroMsg.CommandProcessor", readLine);
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.CommandProcessor", "getRunningAppProcessesByPs fail, ex = %s", e.getMessage());
                        if (lineNumberReader != null) {
                            try {
                                lineNumberReader.close();
                            } catch (Exception e3) {
                                x.e("MicroMsg.CommandProcessor", "getRunningProcessesByPs finally got ex = %s", e3.getMessage());
                            }
                        }
                        x.i("MicroMsg.CommandProcessor", "thread count:%d", Integer.valueOf(Thread.activeCount()));
                        for (Thread thread : Thread.getAllStackTraces().keySet()) {
                            if (thread.getState() == State.RUNNABLE) {
                                x.i("MicroMsg.CommandProcessor", "Running thread: %s\n %s", thread.getName(), aj.b((StackTraceElement[]) r1.get(thread)));
                            }
                        }
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                        if (lineNumberReader != null) {
                            try {
                                lineNumberReader.close();
                            } catch (Exception e4) {
                                x.e("MicroMsg.CommandProcessor", "getRunningProcessesByPs finally got ex = %s", e4.getMessage());
                            }
                        }
                        throw th;
                    }
                }
            }
            exec.waitFor();
            exec.destroy();
            try {
                lineNumberReader.close();
            } catch (Exception e32) {
                x.e("MicroMsg.CommandProcessor", "getRunningProcessesByPs finally got ex = %s", e32.getMessage());
            }
        } catch (Exception e5) {
            e32 = e5;
            lineNumberReader = null;
            x.e("MicroMsg.CommandProcessor", "getRunningAppProcessesByPs fail, ex = %s", e32.getMessage());
            if (lineNumberReader != null) {
                try {
                    lineNumberReader.close();
                } catch (Exception e322) {
                    x.e("MicroMsg.CommandProcessor", "getRunningProcessesByPs finally got ex = %s", e322.getMessage());
                }
            }
            x.i("MicroMsg.CommandProcessor", "thread count:%d", Integer.valueOf(Thread.activeCount()));
            for (Thread thread2 : Thread.getAllStackTraces().keySet()) {
                if (thread2.getState() == State.RUNNABLE) {
                    x.i("MicroMsg.CommandProcessor", "Running thread: %s\n %s", thread2.getName(), aj.b((StackTraceElement[]) r1.get(thread2)));
                }
            }
            return true;
        } catch (Throwable th3) {
            th = th3;
            lineNumberReader = null;
            if (lineNumberReader != null) {
                try {
                    lineNumberReader.close();
                } catch (Exception e42) {
                    x.e("MicroMsg.CommandProcessor", "getRunningProcessesByPs finally got ex = %s", e42.getMessage());
                }
            }
            throw th;
        }
        x.i("MicroMsg.CommandProcessor", "thread count:%d", Integer.valueOf(Thread.activeCount()));
        for (Thread thread22 : Thread.getAllStackTraces().keySet()) {
            if (thread22.getState() == State.RUNNABLE) {
                x.i("MicroMsg.CommandProcessor", "Running thread: %s\n %s", thread22.getName(), aj.b((StackTraceElement[]) r1.get(thread22)));
            }
        }
        return true;
    }
}
