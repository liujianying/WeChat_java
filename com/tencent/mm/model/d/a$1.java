package com.tencent.mm.model.d;

import android.os.Message;
import com.tencent.mm.model.au;
import com.tencent.mm.model.d.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ag.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Date;

class a$1 implements b {
    final /* synthetic */ a dFa;

    public a$1(a aVar) {
        this.dFa = aVar;
    }

    public final void onLog(Message message, Runnable runnable, Thread thread, long j, long j2, float f) {
        if (thread != null) {
            long id = thread.getId();
            String str = null;
            if (j > a.a(this.dFa)) {
                if (message != null) {
                    str = "|HMonitor dispatch|msg = " + message + "|handler = " + message.getTarget() + "|threadName = " + thread.getName() + "|threadId = " + thread.getId() + "|priority = " + thread.getPriority() + "|usedTime = " + j + "|cpuTime = " + j2;
                } else if (runnable != null) {
                    str = "|HMonitor run task|" + ag.dump(runnable, true);
                }
            } else if (j > a.b(this.dFa) && id == a.JD()) {
                if (message != null) {
                    str = "|HMonitor dispatch|msg = " + message + "|handler = " + message.getTarget() + "|threadName = " + thread.getName() + "|threadId = " + thread.getId() + "|priority = " + thread.getPriority() + "|usedTime = " + j + "|cpuTime = " + j2;
                } else if (runnable != null) {
                    str = "|HMonitor run task|" + ag.dump(runnable, true);
                }
            }
            if (au.Em().lnJ.getLooper() == null) {
                x.w("MicroMsg.HandlerTraceManager", "worker thread's looper is dead");
                return;
            }
            long id2 = au.Em().lnJ.getLooper().getThread().getId();
            if (runnable != null && j > a.c(this.dFa) && id == id2) {
                a aVar = new a();
                aVar.dFc = j;
                aVar.info = ag.dump(runnable, false);
                if (a.d(this.dFa).size() >= a.e(this.dFa)) {
                    a.d(this.dFa).pop();
                }
                a.d(this.dFa).add(aVar);
            }
            if (runnable != null && id == id2 && f > 0.0f && f <= 100.0f) {
                Long[] f2;
                if (f < 30.0f) {
                    f2 = a.f(this.dFa);
                    int i = (int) (f / 2.0f);
                    f2[i] = Long.valueOf(f2[i].longValue() + 1);
                } else if (f < 40.0f) {
                    f2 = a.f(this.dFa);
                    f2[15] = Long.valueOf(f2[15].longValue() + 1);
                } else if (f < 50.0f) {
                    f2 = a.f(this.dFa);
                    f2[16] = Long.valueOf(f2[16].longValue() + 1);
                } else {
                    f2 = a.f(this.dFa);
                    f2[17] = Long.valueOf(f2[17].longValue() + 1);
                }
            }
            if (System.currentTimeMillis() - a.g(this.dFa) > ((long) a.h(this.dFa))) {
                a.a(this.dFa, System.currentTimeMillis());
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= 18) {
                        break;
                    }
                    if (a.f(this.dFa)[i3].longValue() > 0) {
                        h.mEJ.a(230, (long) i3, a.f(this.dFa)[i3].longValue(), false);
                    }
                    i2 = i3 + 1;
                }
            }
            if (str != null) {
                if (!com.tencent.mm.sdk.a.b.foreground) {
                    x.i("MicroMsg.HandlerTraceManager", str);
                }
                if (!a.i(this.dFa)) {
                    a.a(this.dFa, a.JE().format(new Date()) + str + "\n");
                }
            }
        }
    }
}
