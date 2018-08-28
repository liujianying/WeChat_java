package com.tencent.mm.plugin.mmsight.model.b;

import android.os.Process;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class e$a implements Runnable {
    int liI;
    volatile int liU;
    Object ljb;
    boolean lkx;
    final /* synthetic */ e lky;

    private e$a(e eVar) {
        this.lky = eVar;
        this.ljb = new Object();
    }

    /* synthetic */ e$a(e eVar, byte b) {
        this(eVar);
    }

    public final void run() {
        if (this.liI == -1) {
            this.liI = Process.myTid();
            Process.setThreadPriority(Process.myTid(), -2);
            x.i("MicroMsg.MMSightRemuxX264Encoder", "encodeTid: %s", Integer.valueOf(this.liI));
        }
        this.liU = 0;
        synchronized (this.ljb) {
            long VG;
            while (!this.lkx) {
                VG = bi.VG();
                x.i("MicroMsg.MMSightRemuxX264Encoder", "try trigger encode");
                int triggerEncodeForSegment = MP4MuxerJNI.triggerEncodeForSegment(Math.max(0, this.liU), false);
                x.i("MicroMsg.MMSightRemuxX264Encoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", Long.valueOf(bi.bI(VG)), Integer.valueOf(this.liU), Integer.valueOf(triggerEncodeForSegment), Long.valueOf(Thread.currentThread().getId()));
                if (triggerEncodeForSegment == this.liU) {
                    try {
                        Thread.sleep(20);
                    } catch (Exception e) {
                        x.e("MicroMsg.MMSightRemuxX264Encoder", "thread sleep error");
                    }
                }
                this.liU = triggerEncodeForSegment;
            }
            VG = bi.VG();
            this.liU = MP4MuxerJNI.triggerEncodeForSegment(this.liU, true);
            x.i("MicroMsg.MMSightRemuxX264Encoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", Long.valueOf(bi.bI(VG)), Integer.valueOf(this.liU), Long.valueOf(Thread.currentThread().getId()));
        }
    }
}
