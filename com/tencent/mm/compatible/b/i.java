package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.NoiseSuppressor;
import com.tencent.mm.compatible.b.g.a;
import com.tencent.mm.sdk.platformtools.x;

public final class i implements a {
    private NoiseSuppressor dbs = null;

    @TargetApi(16)
    public i(AudioRecord audioRecord) {
        boolean isAvailable = NoiseSuppressor.isAvailable();
        x.d("MicroMsg.MMNoiseSuppressor", "available  " + isAvailable);
        if (isAvailable) {
            this.dbs = NoiseSuppressor.create(audioRecord.getAudioSessionId());
        }
    }

    @TargetApi(16)
    public final boolean isAvailable() {
        return NoiseSuppressor.isAvailable();
    }

    @TargetApi(16)
    public final boolean yy() {
        if (this.dbs != null) {
            try {
                int enabled = this.dbs.setEnabled(true);
                if (enabled == 0) {
                    return true;
                }
                x.d("MicroMsg.MMNoiseSuppressor", "setEnabled failed " + enabled);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMNoiseSuppressor", e, "", new Object[0]);
            }
        }
        return false;
    }
}
