package com.tencent.mm.plugin.voiceprint.model;

import android.os.Looper;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;

public final class o {
    public k oFs;
    public al oFt;
    int oFu;
    int oFv;

    public o() {
        this.oFs = null;
        this.oFt = null;
        this.oFu = 0;
        this.oFv = 0;
        this.oFs = new k();
        this.oFt = new al(Looper.getMainLooper(), new 1(this), true);
    }

    public final void reset() {
        this.oFs.we();
        x.d("MicroMsg.VoicePrintNoiseDetector", "stop record");
        this.oFt.SO();
        this.oFu = 0;
        this.oFv = 0;
    }
}
