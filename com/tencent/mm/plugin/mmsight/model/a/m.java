package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

public final class m implements e {
    private int audioSampleRate;
    private int bitrate;
    private int jdD;
    private int lhM;
    private float liV;
    private String lje;

    public m(int i, String str, float f, int i2, int i3, int i4) {
        this.lhM = i;
        this.lje = str;
        this.liV = f;
        this.bitrate = i2;
        this.jdD = i3;
        this.audioSampleRate = i4;
        x.d("MicroMsg.MMSightMP4Muxer", "create MMSightMP4Muxer, bufId: %s, recordPath: %s, fps: %s, bitrate: %s, videoDuration: %s, audioSampleRate%s", new Object[]{Integer.valueOf(i), str, Float.valueOf(f), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
    }

    public final boolean bev() {
        String str;
        long VG = bi.VG();
        String Lm = d.Lm(this.lje);
        try {
            if (!FileOp.cn(Lm)) {
                Lm = null;
            }
            str = Lm;
        } catch (Exception e) {
            str = null;
        }
        x.i("MicroMsg.MMSightMP4Muxer", "start mux, bufId: %s, aacFile: %s", new Object[]{Integer.valueOf(this.lhM), str});
        x.i("MicroMsg.MMSightMP4Muxer", "mux sight end, duration %ds, used %sms", new Object[]{Integer.valueOf(SightVideoJNI.muxing(this.lhM, str, this.audioSampleRate, 1024, 2, 1, 0, this.lje, this.liV, Math.max(BaseReportManager.MAX_READ_COUNT, this.jdD), this.bitrate, b.nbT, 8, 2, 23.0f, null, 0, false)), Long.valueOf(bi.bI(VG))});
        if (!bi.oW(str)) {
            try {
                FileOp.deleteFile(str);
            } catch (Exception e2) {
            }
        }
        if (r2 >= 0) {
            return true;
        }
        return false;
    }
}
