package com.tencent.pb.common.b;

import android.os.Handler;
import android.os.Looper;
import com.google.a.a.e;
import com.tencent.pb.common.c.c;

public abstract class d implements c {
    public final String TAG2 = getClass().getSimpleName();
    private final long dJL = 60000;
    Runnable dJQ = new 1(this);
    boolean hiW = false;
    public int jIm = 2;
    private int mErrorCode = -999;
    Handler mHandler = new Handler(Looper.getMainLooper());
    public boolean vbX = false;
    b vbY = null;
    public byte[] vbZ = null;
    public Object vca = null;
    public int vcb;
    public int vcc = 0;

    public abstract Object bI(byte[] bArr);

    public abstract String cEm();

    public abstract int getType();

    public final void r(int i, byte[] bArr) {
        int i2 = 2;
        c.d("MicroMsg.Voip", this.TAG2, "onResp errcode", Integer.valueOf(i));
        this.mHandler.removeCallbacks(this.dJQ);
        c.d("MicroMsg.Voip", "NETTASK_RECV onResp:cmd= ", cEm(), Integer.valueOf(i), Boolean.valueOf(this.hiW));
        if (i != 0) {
            c.x("MicroMsg.Voip", this.TAG2, "getNetworkErrType errcode:" + i);
            if (i != -1) {
                i2 = i == 6801 ? 10 : 4;
            } else if (h.isNetworkConnected()) {
                i2 = 1;
            }
        } else {
            i2 = 0;
        }
        if (this.hiW) {
            c.d("MicroMsg.Voip", "onResp netscene already canceled, cmd:" + this.vcb);
            return;
        }
        this.mErrorCode = i;
        this.vca = bI(bArr);
        this.mHandler.post(new 2(this, i2, i));
    }

    public final void c(int i, e eVar) {
        this.vcb = i;
        byte[] bArr = null;
        try {
            bArr = e.b(eVar);
        } catch (Exception e) {
        }
        this.vbZ = bArr;
    }
}
