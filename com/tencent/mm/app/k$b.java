package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class k$b implements Runnable {
    final /* synthetic */ k byU;

    private k$b(k kVar) {
        this.byU = kVar;
    }

    /* synthetic */ k$b(k kVar, byte b) {
        this(kVar);
    }

    private static ProcessErrorStateInfo vb() {
        List<ProcessErrorStateInfo> processesInErrorState = ((ActivityManager) ad.getContext().getSystemService("activity")).getProcessesInErrorState();
        if (processesInErrorState == null) {
            return null;
        }
        for (ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
            if (processErrorStateInfo.uid == Process.myUid() && processErrorStateInfo.condition == 2) {
                return processErrorStateInfo;
            }
        }
        return null;
    }

    public final void run() {
        ArrayList arrayList;
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.MMCrashReporter", "ANR Parser started.");
        ProcessErrorStateInfo processErrorStateInfo = null;
        while (this.byU.byM.block(10000)) {
            this.byU.byM.close();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
            processErrorStateInfo = vb();
            if (processErrorStateInfo != null) {
                break;
            }
        }
        if (processErrorStateInfo == null) {
            processErrorStateInfo = vb();
            if (processErrorStateInfo == null) {
                x.w("MicroMsg.MMCrashReporter", "ANR process not found, exit thread.");
                this.byU.byS = null;
                return;
            }
        }
        ProcessErrorStateInfo processErrorStateInfo2 = processErrorStateInfo;
        x.i("MicroMsg.MMCrashReporter", "Got ANR process: " + processErrorStateInfo2.processName + " @ " + processErrorStateInfo2.pid);
        synchronized (this.byU.byJ) {
            arrayList = new ArrayList(this.byU.byJ.size());
            int lastIndexOf = this.byU.byL.lastIndexOf(46);
            if (lastIndexOf != -1) {
                str = this.byU.byL.substring(0, lastIndexOf) + '_' + processErrorStateInfo2.processName + this.byU.byL.substring(lastIndexOf);
                if (this.byU.byJ.remove(str)) {
                    arrayList.add(str);
                }
            }
            if (this.byU.byJ.remove(this.byU.byL)) {
                arrayList.add(this.byU.byL);
            }
            arrayList.addAll(this.byU.byJ);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            str = k.a(this.byU.byK + '/' + ((String) it.next()), processErrorStateInfo2.pid, currentTimeMillis, processErrorStateInfo2);
            if (str != null) {
                x.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': OK.", new Object[]{r0});
                this.byU.r(str, processErrorStateInfo2.pid);
                break;
            }
            x.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': Not found.", new Object[]{r0});
        }
        x.i("MicroMsg.MMCrashReporter", "ANR Parser ended.");
        this.byU.byS = null;
    }
}
