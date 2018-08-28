package com.tencent.magicbrush.engine;

import android.os.Handler;
import android.support.annotation.Keep;
import com.tencent.magicbrush.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;

public class AppBrandContext extends b {
    private Timer bno = new Timer();
    private int bnp = 0;
    private HashMap<Integer, a> bnq = new HashMap();
    private long bnr = nativeCreated(this.bnA);
    private boolean bns = false;
    private ArrayList<Integer> bnt = new ArrayList();
    private Handler mHandler = new Handler();

    public static native void notifyClearTimer(long j, int i);

    public static native boolean notifyRunTimer(long j, long j2, int i);

    public native long nativeCreated(long j);

    public native void nativeFinalize(long j);

    @Keep
    public int setTimer(int i, boolean z) {
        int i2 = this.bnp + 1;
        this.bnp = i2;
        a aVar = new a(this, i2, z);
        this.bnq.put(Integer.valueOf(i2), aVar);
        if (z) {
            this.bno.schedule(aVar, (long) i, (long) i);
        } else {
            this.bno.schedule(aVar, (long) i);
        }
        return i2;
    }

    @Keep
    public void clearTimer(int i) {
        if (this.bnq.containsKey(Integer.valueOf(i))) {
            ((a) this.bnq.get(Integer.valueOf(i))).cancel();
            this.bnq.remove(Integer.valueOf(i));
        }
    }

    @Keep
    public void onLog(int i, String str) {
        String[] strArr = new String[]{"debug", "log", "info", "warn", "error"};
    }

    public final void dispose() {
        nativeFinalize(this.bnr);
    }

    static {
        b.loadLibrary("mmv8");
        b.loadLibrary("magicbrush");
    }
}
