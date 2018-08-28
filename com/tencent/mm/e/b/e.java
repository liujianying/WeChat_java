package com.tencent.mm.e.b;

import android.media.AudioRecord;
import com.tencent.mm.compatible.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Timer;
import java.util.concurrent.locks.ReentrantLock;

public final class e extends f {
    boolean bDM;
    AudioRecord bEa;
    int bEm;
    private int bEp = 12800;
    private b bEq = new b(this);
    a bEr = null;
    c.a bEs;
    private final Object bEt = new Object();
    final byte[] bEu = new byte[0];
    final Object bEv = new Object();
    private Timer bEw = null;
    private boolean bEx = false;
    private boolean bEy = false;
    boolean mIsMute = false;
    int mStatus = 0;

    public e(AudioRecord audioRecord, boolean z, int i, c.a aVar, boolean z2) {
        this.bEa = audioRecord;
        this.bDM = z;
        this.bEm = i;
        this.bEs = aVar;
        this.bEy = z2;
    }

    public final boolean wn() {
        boolean z = true;
        x.i("MicroMsg.RecordModeAsyncRead", "startRecord");
        synchronized (this.bEv) {
            this.mStatus = 1;
        }
        com.tencent.mm.sdk.f.e.b(this.bEq, "RecordModeAsyncRead_record", 10);
        if (true == this.bEy) {
            boolean z2;
            this.bEr = new a();
            if (this.bEr == null) {
                x.e("MicroMsg.RecordModeAsyncRead", "new m_audioBuffer error ");
                z2 = false;
            } else {
                this.bEp = this.bEm * 20;
                x.i("MicroMsg.RecordModeAsyncRead", "audioBuffer init mAudioBufferSize: " + this.bEp);
                a aVar = this.bEr;
                int i = this.bEp;
                if (i <= 0) {
                    z2 = true;
                } else {
                    aVar.daG = new byte[i];
                    if (aVar.daG == null) {
                        z2 = true;
                    } else {
                        aVar.daE = i;
                        if (aVar.daJ) {
                            aVar.daK = new ReentrantLock();
                        }
                        z2 = false;
                    }
                }
                if (z2) {
                    x.e("MicroMsg.RecordModeAsyncRead", "audioBuffer init failed, error code = -1");
                    z2 = false;
                } else {
                    z2 = true;
                }
            }
            if (z2) {
                if (this.bEx || this.bEw != null) {
                    x.w("MicroMsg.RecordModeAsyncRead", "Timer has been created or, timer has been started, " + this.bEx);
                } else {
                    this.bEw = new Timer();
                    if (this.bEw != null) {
                        z = false;
                    }
                }
                if (z) {
                    x.e("MicroMsg.RecordModeAsyncRead", "InitAudioRecTimer failed, error code = -1");
                    return false;
                }
                this.bEw.scheduleAtFixedRate(new a(this), 60, 20);
                this.bEx = true;
            } else {
                x.e("MicroMsg.RecordModeAsyncRead", "initAudioBuffer failed");
                return false;
            }
        }
        return true;
    }

    public final void stopRecord() {
        x.i("MicroMsg.RecordModeAsyncRead", "stopRecord");
        synchronized (this.bEv) {
            this.mStatus = 3;
        }
        synchronized (this.bEu) {
            this.bEu.notify();
        }
        com.tencent.mm.sdk.f.e.S(this.bEq);
        try {
            com.tencent.mm.sdk.f.e.U(this.bEq);
        } catch (InterruptedException e) {
        }
        if (this.bEr != null) {
            if (this.bEw != null) {
                this.bEw.cancel();
                this.bEw = null;
            }
            a aVar = this.bEr;
            aVar.daE = 0;
            aVar.daF = 0;
            aVar.daH = 0;
            aVar.daI = 0;
            aVar.daG = null;
            synchronized (this.bEt) {
                this.bEr = null;
                this.bEs = null;
            }
            this.bEx = false;
            this.bEr = null;
        }
    }

    public final int wq() {
        synchronized (this.bEt) {
            if (this.bEr != null) {
                int i = this.bEr.daE;
                return i;
            }
            return -1;
        }
    }

    public final int wr() {
        synchronized (this.bEt) {
            if (this.bEr != null) {
                int yx = this.bEr.yx();
                return yx;
            }
            return -1;
        }
    }

    public final int v(byte[] bArr, int i) {
        int i2 = -1;
        synchronized (this.bEt) {
            if (this.bEr != null) {
                a aVar = this.bEr;
                if (i > 0 && i <= aVar.yx() && bArr != null && aVar.daH != aVar.daI) {
                    if (aVar.daJ) {
                        aVar.daK.lock();
                    }
                    if (aVar.daH < aVar.daI) {
                        System.arraycopy(aVar.daG, aVar.daH, bArr, 0, i);
                        aVar.daH += i;
                    } else if (i <= aVar.daE - aVar.daH) {
                        System.arraycopy(aVar.daG, aVar.daH, bArr, 0, i);
                        aVar.daH += i;
                    } else {
                        System.arraycopy(aVar.daG, aVar.daH, bArr, 0, aVar.daE - aVar.daH);
                        System.arraycopy(aVar.daG, 0, bArr, aVar.daE - aVar.daH, i - (aVar.daE - aVar.daH));
                        aVar.daH = i - (aVar.daE - aVar.daH);
                    }
                    if (aVar.daJ) {
                        aVar.daK.unlock();
                    }
                    i2 = 0;
                }
            }
        }
        return i2;
    }

    public final void aO(boolean z) {
        this.mIsMute = z;
    }
}
