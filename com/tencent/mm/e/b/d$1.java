package com.tencent.mm.e.b;

import android.media.AudioRecord;
import android.media.AudioRecord.OnRecordPositionUpdateListener;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Arrays;

class d$1 implements OnRecordPositionUpdateListener {
    final /* synthetic */ d bEo;

    d$1(d dVar) {
        this.bEo = dVar;
    }

    public final void onMarkerReached(AudioRecord audioRecord) {
    }

    public final void onPeriodicNotification(AudioRecord audioRecord) {
        if (!this.bEo.mIsPause && this.bEo.bEa != null) {
            if (this.bEo.bDM || this.bEo.bEk == null) {
                this.bEo.bEk = new byte[this.bEo.bEm];
            }
            int read = this.bEo.bEa.read(this.bEo.bEk, 0, this.bEo.bEm);
            x.d("MicroMsg.RecordModeAsyncCallback", "OnRecordPositionUpdateListener, read ret: " + read);
            if (this.bEo.bEi != null) {
                this.bEo.bEi.d(read, this.bEo.bEk);
            }
            if (read > this.bEo.bEk.length) {
                read = this.bEo.bEk.length;
            }
            if (this.bEo.mIsMute && read > 0) {
                Arrays.fill(this.bEo.bEk, 0, read, (byte) 0);
            }
            if (this.bEo.bEb != null && read > 0) {
                this.bEo.bEb.s(this.bEo.bEk, read);
            }
        }
    }
}
