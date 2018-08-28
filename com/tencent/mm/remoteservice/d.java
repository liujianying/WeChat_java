package com.tencent.mm.remoteservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.mm.remoteservice.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class d {
    private Context context;
    private ServiceConnection hKe = new ServiceConnection() {
        public final void onServiceDisconnected(ComponentName componentName) {
            d.this.sCo = null;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.sCo = a.ac(iBinder);
            for (Runnable run : (Runnable[]) d.this.sCn.toArray(new Runnable[d.this.sCn.size()])) {
                run.run();
            }
            d.this.sCn.clear();
        }
    };
    List<Runnable> sCn = new LinkedList();
    c sCo;

    public d(Context context) {
        this.context = context;
    }

    public final void K(Runnable runnable) {
        new StringBuilder("RemoteServiceProxy construct, thread id:").append(Thread.currentThread().getId());
        if (isConnected()) {
            runnable.run();
            return;
        }
        this.sCn.add(runnable);
        this.context.bindService(new Intent(this.context, RemoteService.class), this.hKe, 1);
    }

    public final boolean isConnected() {
        return this.sCo != null && this.sCo.asBinder().isBinderAlive();
    }

    public final void release() {
        if (!(this.sCo == null || this.hKe == null)) {
            this.context.unbindService(this.hKe);
            this.sCo = null;
        }
        this.context = null;
    }

    final void a(b bVar, String str, Bundle bundle) {
        if (isConnected()) {
            try {
                this.sCo.a(bVar.getClass().getName(), str, bundle, bVar);
            } catch (Throwable e) {
                x.e("MicroMsg.RemoteServiceProxy", "exception:%s", new Object[]{bi.i(e)});
            }
        }
    }
}
