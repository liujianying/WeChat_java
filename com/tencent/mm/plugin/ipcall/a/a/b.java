package com.tencent.mm.plugin.ipcall.a.a;

import android.os.Looper;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.ipcall.a.a.a.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public abstract class b extends a implements a {
    protected boolean kpl = false;
    public a kpm = null;
    private ag mHandler = new ag(Looper.getMainLooper());

    public abstract int aXD();

    public abstract void aXE();

    public abstract void aXF();

    public abstract void b(c cVar);

    public abstract void onStop();

    public final void init() {
        this.kpk = this;
        super.init();
    }

    public final void destroy() {
        super.destroy();
    }

    public final void a(c cVar) {
        super.a(cVar);
        this.kpl = true;
        x.d("MicroMsg.BaseIPCallTimerService", "start service, type: %d", new Object[]{Integer.valueOf(Mw())});
    }

    public final void stop() {
        this.kpl = false;
        onStop();
        x.d("MicroMsg.BaseIPCallTimerService", "stop service, type: %d", new Object[]{Integer.valueOf(Mw())});
    }

    public final void a(int i, Object obj, int i2, int i3) {
        x.i("MicroMsg.BaseIPCallTimerService", "timer request success!, type: %d, isLoop: %b, interval: %d", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.kpl), Integer.valueOf(aXD())});
        aXE();
        if (this.kpm != null) {
            this.kpm.a(i, (l) obj, i2, i3);
        }
        if (this.kpl) {
            this.mHandler.postDelayed(new 1(this), (long) aXD());
        }
    }

    public final void b(int i, Object obj, int i2, int i3) {
        x.i("MicroMsg.BaseIPCallTimerService", "timer request failed, type: %d, isLoop: %b, interval: %d", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.kpl), Integer.valueOf(aXD())});
        aXF();
        if (this.kpm != null) {
            this.kpm.b(i, (l) obj, i2, i3);
        }
        if (this.kpl) {
            this.mHandler.postDelayed(new 2(this), (long) aXD());
        }
    }
}
