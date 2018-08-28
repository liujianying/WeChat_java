package com.tencent.mm.booter;

import android.os.Process;
import com.tencent.mm.booter.NotifyReceiver.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.sdk.platformtools.x;

class NotifyReceiver$a$2 implements Runnable {
    final /* synthetic */ a cXe;

    NotifyReceiver$a$2(a aVar) {
        this.cXe = aVar;
    }

    public final void run() {
        x.i("MicroMsg.NotifyReceiver", "checkKillProcess, canKillProcess :%b", new Object[]{Boolean.valueOf(NotifyReceiver.uB())});
        synchronized (NotifyReceiver.xB()) {
            if (NotifyReceiver.xC() != null) {
                NotifyReceiver.xC().unLock();
            }
            NotifyReceiver.a(null);
        }
        if (NotifyReceiver.uB()) {
            PluginZero pluginZero = (PluginZero) g.n(PluginZero.class);
            if (pluginZero.qxH != null) {
                pluginZero.qxH.atF();
            }
            x.chS();
            Process.killProcess(Process.myPid());
        }
    }
}
