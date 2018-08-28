package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.AutomaticGainControl;
import com.tencent.mm.compatible.b.g.a;
import com.tencent.mm.sdk.platformtools.x;

public final class h implements a {
    private AutomaticGainControl dbr = null;

    @TargetApi(16)
    public h(AudioRecord audioRecord) {
        boolean isAvailable = AutomaticGainControl.isAvailable();
        x.d("MicroMsg.MMAutomaticGainControl", "available  " + isAvailable);
        if (isAvailable) {
            this.dbr = AutomaticGainControl.create(audioRecord.getAudioSessionId());
        }
    }

    @TargetApi(16)
    public final boolean isAvailable() {
        return AutomaticGainControl.isAvailable();
    }

    @TargetApi(16)
    public final boolean yy() {
        if (this.dbr != null) {
            try {
                int enabled = this.dbr.setEnabled(true);
                if (enabled == 0) {
                    return true;
                }
                x.d("MicroMsg.MMAutomaticGainControl", "setEnabled failed " + enabled);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMAutomaticGainControl", e, "", new Object[0]);
            }
        }
        return false;
    }
}
