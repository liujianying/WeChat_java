package com.tencent.mm.plugin.mmsight.model.a;

import android.media.MediaRecorder;
import com.tencent.mm.e.b.c$a;
import com.tencent.mm.plugin.mmsight.model.a.c.a;
import com.tencent.mm.plugin.mmsight.model.a.c.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class i implements c {
    private int audioSampleRate;
    private int dQF;
    a lhY;
    private ag lia = new 1(this);
    private MediaRecorder lik;
    private boolean lil = false;

    public i(int i, int i2) {
        this.audioSampleRate = i;
        this.dQF = i2;
        x.i("MicroMsg.MMSightAACMediaRecorder", "MMSightAACMediaRecorder, sampleRate: %s, bitrate: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final int at(int i, String str) {
        x.i("MicroMsg.MMSightAACMediaRecorder", "MMSightAACMediaRecorder init tempPath[%s], sampleRate[%d]", new Object[]{str, Integer.valueOf(this.audioSampleRate)});
        this.lik = new MediaRecorder();
        this.lik.setAudioSource(1);
        this.lik.setOutputFormat(2);
        this.lik.setAudioEncoder(3);
        this.lik.setAudioChannels(1);
        this.lik.setAudioEncodingBitRate(this.dQF);
        this.lik.setAudioSamplingRate(this.audioSampleRate);
        this.lik.setOutputFile(str);
        try {
            this.lik.prepare();
            return 0;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", e, "mediaRecorder prepare error: %s", new Object[]{e.getMessage()});
            return -1;
        }
    }

    public final int a(a aVar) {
        x.i("MicroMsg.MMSightAACMediaRecorder", "start, onPcmReady: %s", new Object[]{aVar});
        this.lhY = aVar;
        try {
            if (!(this.lik == null || this.lil)) {
                this.lik.start();
            }
            this.lia.sendEmptyMessage(0);
            return 0;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", e, "start record aac.mp4 error:%s", new Object[]{e.getMessage()});
            this.lia.sendEmptyMessage(0);
            return -1;
        } catch (Throwable e2) {
            this.lia.sendEmptyMessage(0);
            throw e2;
        }
    }

    public final int a(b bVar) {
        x.i("MicroMsg.MMSightAACMediaRecorder", "stop, mediaRecorder: %s, callback: %s", new Object[]{this.lik, bVar});
        if (this.lik != null) {
            try {
                if (!this.lil) {
                    this.lik.stop();
                    this.lik.release();
                }
                this.lik = null;
                if (bVar == null) {
                    return 0;
                }
                bVar.bei();
                return 0;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", e, "stop record aac.mp4 error:%s", new Object[]{e.getMessage()});
                return -1;
            }
        } else if (bVar == null) {
            return 0;
        } else {
            bVar.bei();
            return 0;
        }
    }

    public final void clear() {
        try {
            if (this.lik != null) {
                if (!this.lil) {
                    this.lik.stop();
                    this.lik.release();
                }
                this.lik = null;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", e, "clear error: %s", new Object[]{e.getMessage()});
        }
    }

    public final void bef() {
    }

    public final c$a beg() {
        return null;
    }

    public final void gt(boolean z) {
        this.lil = z;
    }
}
