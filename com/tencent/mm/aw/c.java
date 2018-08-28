package com.tencent.mm.aw;

import com.tencent.mm.e.b.g;
import com.tencent.mm.e.c.d;
import com.tencent.mm.sdk.platformtools.at.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class c implements a {
    public BlockingQueue<g.a> ehl = new ArrayBlockingQueue(1024);
    public String mFileName = null;

    public final boolean Kr() {
        x.d("MicroMsg.SpeexEncoderWorker", "doEncode");
        d dVar = new d();
        String RH = b.RH();
        try {
            x.i("MicroMsg.SpeexEncoderWorker", "path " + RH);
            File file = new File(RH);
            if (!file.exists()) {
                file.mkdir();
            }
            dVar.df(RH + this.mFileName + ".temp");
            while (this.ehl.size() > 0) {
                g.a aVar = (g.a) this.ehl.poll();
                if (aVar.buf != null && aVar.bEG > 0) {
                    dVar.a(aVar, 0, false);
                }
            }
            dVar.wA();
            try {
                new File(RH + this.mFileName + ".temp").renameTo(new File(RH + this.mFileName + ".spx"));
            } catch (Throwable e) {
                x.e("MicroMsg.SpeexEncoderWorker", "exception:%s", new Object[]{bi.i(e)});
            }
            e.RQ().start();
        } catch (Exception e2) {
            x.e("MicroMsg.SpeexEncoderWorker", "filename open failed, ", new Object[]{e2});
        }
        return true;
    }

    public final boolean Ks() {
        return false;
    }
}
