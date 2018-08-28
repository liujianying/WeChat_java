package com.tencent.mm.plugin.appbrand.media.record.record_imp;

import com.tencent.mm.e.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public int aeg = 0;
    public int bDP = -1;
    public c bDp = null;
    public RecordParam gjd;
    public long gje = 0;
    public a gjf;
    public com.tencent.mm.e.b.c.a gjg = new 1(this);
    public int sampleRate = 0;

    public a(RecordParam recordParam) {
        if (recordParam == null) {
            recordParam = new RecordParam();
        }
        this.sampleRate = recordParam.sampleRate;
        this.aeg = recordParam.gji;
        this.bDP = recordParam.scene;
        this.gjd = recordParam;
    }

    public final boolean we() {
        boolean we;
        x.i("MicroMsg.Record.AppBrandRecorder", "stopRecord");
        if (this.bDp != null) {
            we = this.bDp.we();
        } else {
            we = false;
        }
        this.gje -= System.currentTimeMillis();
        x.i("MicroMsg.Record.AppBrandRecorder", "stop time ticket:%d, costTimeInMs:%d", new Object[]{Long.valueOf(r2), Long.valueOf(this.gje)});
        return we;
    }
}
