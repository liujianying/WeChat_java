package com.tencent.mm.graphics.b;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import com.tencent.smtt.utils.TbsLog;
import java.util.concurrent.TimeUnit;

public enum c implements FrameCallback {
    ;
    
    public Choreographer aDX;
    public long dji;
    public int djj;
    double djk;
    private int djl;
    public boolean djm;

    private c(String str) {
        this.dji = 0;
        this.djj = 0;
        this.djk = 0.0d;
        this.djl = TbsListener$ErrorCode.INFO_CODE_MINIQB;
        this.djm = false;
        this.aDX = Choreographer.getInstance();
    }

    public final void doFrame(long j) {
        long toMillis = TimeUnit.NANOSECONDS.toMillis(j);
        if (this.dji > 0) {
            long j2 = toMillis - this.dji;
            this.djj++;
            if (j2 > ((long) this.djl)) {
                this.djk = ((double) (this.djj * TbsLog.TBSLOG_CODE_SDK_BASE)) / ((double) j2);
                this.dji = toMillis;
                this.djj = 0;
            }
        } else {
            this.dji = toMillis;
        }
        this.aDX.postFrameCallback(this);
    }
}
