package com.tencent.mm.app;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class e$5 implements Runnable {
    final /* synthetic */ e byl;
    private int byo = 0;

    e$5(e eVar) {
        this.byl = eVar;
    }

    public final void run() {
        int i = 0;
        try {
            e.b(this.byl).lock();
            boolean z = e.c(this.byl) != null && e.c(this.byl).isBinderAlive();
            x.i("MicroMsg.CoreServiceConnection", "mZombieWaker run serviceBinder: %s, binderAlive: %b", new Object[]{e.c(this.byl), Boolean.valueOf(z)});
            if (z) {
                x.w("MicroMsg.CoreServiceConnection", "mZombieWaker run binderAlive return directly.");
                return;
            }
            e.b(this.byl).unlock();
            x.e("MicroMsg.CoreServiceConnection", String.format("CoreService started but not responding, possibly zombie. Use step %d to restart CoreService.", new Object[]{Integer.valueOf(this.byo)}));
            if (this.byo == 1) {
                int cM = e.cM("com.tencent.mm:push");
                if (cM != -1) {
                    x.i("MicroMsg.CoreServiceConnection", String.format("Push Process %d killed.", new Object[]{Integer.valueOf(cM)}));
                    x.chR();
                    Process.killProcess(cM);
                } else {
                    x.i("MicroMsg.CoreServiceConnection", "Push Process not found.");
                }
            }
            Context context = ad.getContext();
            Intent intent = new Intent(context, CoreService.class);
            try {
                x.i("MicroMsg.CoreServiceConnection", "unbinding CoreService...");
                context.unbindService(this.byl);
            } catch (Exception e) {
            } finally {
                context.stopService(intent);
                i = this.byl;
                context.bindService(intent, i, 1);
                context.startService(intent);
            }
            if (this.byo == 1) {
                this.byo = i;
            } else {
                this.byo++;
            }
            ah.i(this, 10000);
            x.i("MicroMsg.CoreServiceConnection", String.format("ZombieWaker posted again with step %d", new Object[]{Integer.valueOf(this.byo)}));
        } finally {
            e.b(this.byl).unlock();
        }
    }
}
