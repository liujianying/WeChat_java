package com.tencent.mm.plugin.mmsight.model.a;

import android.os.HandlerThread;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class a {
    private static int lhc = 4;
    static int lhd = 4;
    ag handler;
    HandlerThread[] lhe;
    int lhf = 0;
    private int lhg = 0;
    private LinkedList<b> lhh = new LinkedList();
    private a lhi;
    boolean lhj = false;
    com.tencent.mm.plugin.mmsight.model.a.b.a lhk = new 1(this);

    static /* synthetic */ void a(a aVar, b bVar) {
        x.i("MicroMsg.ForwardMgr", "receive buf bufIndex: %d receiveIndex: %d", new Object[]{Integer.valueOf(bVar.lhr), Integer.valueOf(aVar.lhg)});
        if (aVar.lhg == bVar.lhr) {
            aVar.lhg++;
            aVar.lhi.output(bVar.lhp);
            aVar.bed();
            return;
        }
        aVar.lhh.add(bVar);
        aVar.bed();
    }

    public a(a aVar) {
        this.lhi = aVar;
        lhd = -1;
        if (CaptureMMProxy.getInstance() != null) {
            lhd = CaptureMMProxy.getInstance().getInt(com.tencent.mm.storage.aa.a.sUF, -1);
        }
        if (lhd == -1) {
            lhd = Runtime.getRuntime().availableProcessors();
            lhd = Math.min(lhc, lhd);
            x.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from runtime %d, availableProcessors: %s", new Object[]{Integer.valueOf(lhd), Integer.valueOf(Runtime.getRuntime().availableProcessors())});
        } else {
            x.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from config %d", new Object[]{Integer.valueOf(lhd)});
        }
        this.lhe = new HandlerThread[lhd];
        SightVideoJNI.initScaleAndRoateBuffer(lhd);
        for (int i = 0; i < this.lhe.length; i++) {
            this.lhe[i] = e.cZ("BigSightMediaCodecMP4MuxRecorder_FrameBufProcessMgr_" + i, -1);
            this.lhe[i].start();
        }
        this.lhj = false;
    }

    private void bed() {
        x.i("MicroMsg.ForwardMgr", "processBufList %d %d", new Object[]{Integer.valueOf(this.lhh.size()), Integer.valueOf(this.lhg)});
        while (this.lhh.size() != 0) {
            int i;
            x.i("MicroMsg.ForwardMgr", "loop processBufList %d %d", new Object[]{Integer.valueOf(this.lhh.size()), Integer.valueOf(this.lhg)});
            Iterator it = this.lhh.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (this.lhg == bVar.lhr) {
                    this.lhg++;
                    this.lhi.output(bVar.lhp);
                    this.lhh.remove(bVar);
                    i = 1;
                    continue;
                    break;
                }
            }
            i = 0;
            continue;
            if (i == 0) {
                return;
            }
        }
    }

    public final boolean bee() {
        return this.lhg == this.lhf;
    }

    public final void stop() {
        int i = 0;
        x.i("MicroMsg.ForwardMgr", "stop FrameBufProcessMgr %s", new Object[]{bi.cjd().toString()});
        while (i < this.lhe.length) {
            if (this.lhe[i] != null) {
                this.lhe[i].quit();
                this.lhe[i] = null;
            }
            i++;
        }
        SightVideoJNI.releaseScaleAndRoateBuffer(lhd);
        this.lhj = true;
    }

    protected final void finalize() {
        try {
            stop();
        } catch (Throwable th) {
        }
        super.finalize();
    }
}
