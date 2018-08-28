package com.tencent.mm.e.b;

import android.media.AudioRecord;
import android.media.AudioRecord.OnRecordPositionUpdateListener;
import android.os.HandlerThread;
import com.tencent.mm.e.b.c.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends f {
    boolean bDM;
    AudioRecord bEa;
    a bEb;
    byte[] bEk = null;
    private int bEl;
    int bEm;
    private OnRecordPositionUpdateListener bEn = new 1(this);
    private HandlerThread mHandlerThread = null;
    boolean mIsMute;

    public d(AudioRecord audioRecord, a aVar, boolean z, int i, int i2) {
        this.bEa = audioRecord;
        this.bEb = aVar;
        this.bDM = z;
        this.bEl = i;
        this.bEm = i2;
    }

    public final boolean wn() {
        if (this.mHandlerThread != null) {
            x.e("MicroMsg.RecordModeAsyncCallback", "alreay started record");
            return false;
        }
        this.mHandlerThread = e.cZ("RecordModeAsyncCallback_handlerThread", 10);
        this.mHandlerThread.start();
        this.bEa.setRecordPositionUpdateListener(this.bEn, ag.fetchFreeHandler(this.mHandlerThread.getLooper()));
        this.bEa.setPositionNotificationPeriod(this.bEl);
        if (this.bDM || this.bEk == null) {
            this.bEk = new byte[this.bEm];
        }
        int read = this.bEa.read(this.bEk, 0, this.bEm);
        x.d("MicroMsg.RecordModeAsyncCallback", "startRecord, read ret: " + read);
        if (this.bEb != null && read > 0) {
            this.bEb.s(this.bEk, read);
        }
        return true;
    }

    public final void stopRecord() {
        this.bEa.setRecordPositionUpdateListener(null);
        this.bEa = null;
        this.mHandlerThread.quit();
        this.mHandlerThread = null;
    }

    public final void aO(boolean z) {
        this.mIsMute = z;
    }
}
