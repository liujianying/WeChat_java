package com.tencent.mm.plugin.h.a.b;

import android.annotation.TargetApi;
import android.content.Context;
import com.tencent.mm.plugin.h.a.b.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(18)
public final class e {
    public final HashMap<Long, f> hfF;
    public c hfH;
    public a hfK;
    a hgn;
    public HashSet<Long> hgo;
    final HashMap<Long, Boolean> hgp;
    public f$a hgq;
    public ag mHandler;
    private ReentrantLock mLock;
    public Runnable mRunnable;
    public Context rc;

    public e(a aVar) {
        this.rc = null;
        this.mLock = new ReentrantLock();
        this.mHandler = null;
        this.mRunnable = null;
        this.hfK = new 1(this);
        this.hgo = new HashSet();
        this.hfF = new HashMap();
        this.hgp = new HashMap();
        this.hgq = new 2(this);
        this.rc = ad.getContext();
        this.hgn = aVar;
        this.hfH = c.atP();
        this.mRunnable = new 3(this);
        this.mHandler = new ag(new ah("BluetoothLESimpleManagerThread").lnJ.getLooper());
    }

    public final void v(Runnable runnable) {
        this.mLock.lock();
        runnable.run();
        this.mLock.unlock();
    }

    @TargetApi(18)
    public final boolean atN() {
        return this.rc.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }
}
