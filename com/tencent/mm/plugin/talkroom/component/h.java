package com.tencent.mm.plugin.talkroom.component;

import android.media.AudioTrack;
import android.os.Looper;
import com.tencent.mm.compatible.b.d;
import com.tencent.mm.plugin.talkroom.component.e.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

public final class h extends a implements Runnable {
    private static final int ovJ = com.tencent.mm.plugin.talkroom.model.a.ovJ;
    private AudioTrack aga;
    private boolean bBa = false;
    private boolean bPd = true;
    private int bufferSize = (((ovJ / BaseReportManager.MAX_READ_COUNT) * 20) * 2);
    private boolean ept = false;
    private boolean erb = true;
    private ag handler = new ag(Looper.getMainLooper());
    private int kDD = 0;
    private final Object lock = new Object();
    private int ovK = ovJ;
    private final c ovL;
    private boolean ovM = false;
    private long ovN = 0;
    private int ovO;
    private long ovP = 0;
    private v2engine ovu;
    private short ovv;
    private short ovw;

    public h(v2engine v2engine, c cVar) {
        this.ovu = v2engine;
        this.ovL = cVar;
        this.ept = true;
        if (this.aga != null && this.aga.getState() == 1) {
            this.aga.stop();
        }
        if (this.aga != null) {
            try {
                this.aga.release();
            } catch (Exception e) {
            }
        }
        v2engine.HV().e(true, false, false);
        int aX = v2engine.HV().aX(true);
        int minBufferSize = AudioTrack.getMinBufferSize(this.ovK, 2, 2);
        if (minBufferSize != -2 && minBufferSize != -1) {
            this.aga = new d(aX, this.ovK, 2, minBufferSize * 8);
            this.ept = false;
        }
    }

    public final void bAf() {
        this.bPd = true;
        if (this.aga != null && this.aga.getState() == 1) {
            this.aga.pause();
        }
    }

    public final void bGR() {
        if (this.aga != null && this.aga.getState() == 1) {
            this.aga.play();
        }
        synchronized (this.lock) {
            this.bPd = false;
            this.lock.notify();
        }
        this.ovw = (short) 0;
        this.ovv = (short) 0;
    }

    public final void release() {
        x.i("MicroMsg.TalkRoomPlayer", "release");
        this.bBa = true;
        if (this.aga != null && this.aga.getState() == 1) {
            this.aga.stop();
        }
        if (this.aga != null) {
            this.aga.release();
        }
        synchronized (this.lock) {
            this.bPd = false;
            this.lock.notify();
        }
    }

    public final void run() {
        while (!this.bBa) {
            if (this.ept) {
                try {
                    Thread.sleep(50);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.TalkRoomPlayer", e, "", new Object[0]);
                }
            } else {
                synchronized (this.lock) {
                    if (this.bPd) {
                        try {
                            this.lock.wait();
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.TalkRoomPlayer", e2, "", new Object[0]);
                        }
                    }
                }
                long j = this.ovP;
                this.ovP = bi.VG();
                j = this.ovP - j;
                if (j < 20 && j > 0) {
                    try {
                        synchronized (this.lock) {
                            this.lock.wait(j);
                        }
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.TalkRoomPlayer", e22, "", new Object[0]);
                    }
                }
                try {
                    int GetAudioData;
                    PByteArray pByteArray = new PByteArray();
                    PInt pInt = new PInt();
                    PInt pInt2 = new PInt();
                    int IsSilenceFrame = this.ovu.IsSilenceFrame();
                    if (IsSilenceFrame == 0) {
                        GetAudioData = this.ovu.GetAudioData(pByteArray, this.bufferSize, pInt, pInt2);
                    } else {
                        GetAudioData = 0;
                    }
                    if (GetAudioData < 0) {
                        this.kDD++;
                        x.e("MicroMsg.TalkRoomPlayer", "GetAudioData err %d,  errcount %d", new Object[]{Integer.valueOf(GetAudioData), Integer.valueOf(this.kDD)});
                        if (this.kDD >= 100) {
                            this.kDD = 0;
                            this.bPd = true;
                        }
                    } else {
                        boolean z;
                        if (IsSilenceFrame == 0) {
                            if (this.aga.getPlayState() != 3) {
                                this.aga.play();
                            }
                            byte[] bArr = pByteArray.value;
                            int length = pByteArray.value.length;
                            for (GetAudioData = 0; GetAudioData < length / 2; GetAudioData++) {
                                short s = (short) ((bArr[GetAudioData * 2] & 255) | (bArr[(GetAudioData * 2) + 1] << 8));
                                if (s > this.ovv) {
                                    this.ovv = s;
                                }
                            }
                            this.aga.write(pByteArray.value, 0, pByteArray.value.length);
                        } else if (this.erb) {
                            this.aga.pause();
                        }
                        if (IsSilenceFrame == 0) {
                            this.ovN = bi.VG();
                            z = false;
                        } else if (bi.bI(this.ovN) < 1000) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if ((!((!this.erb && this.ovO == pInt2.value) || z || pInt.value == 0) || (!this.erb && z)) && !this.ovM) {
                            if (!(z || pInt2.value == 0)) {
                                this.ovO = pInt2.value;
                            }
                            this.handler.postAtFrontOfQueueV2(new 1(this, pInt, pInt2, z));
                            this.erb = z;
                        }
                    }
                } catch (Throwable e222) {
                    x.printErrStackTrace("MicroMsg.TalkRoomPlayer", e222, "", new Object[0]);
                    x.e("MicroMsg.TalkRoomPlayer", e222.toString());
                }
            }
        }
    }

    public final int bGQ() {
        if (this.ovw < this.ovv) {
            this.ovw = this.ovv;
        }
        if (this.ovw == (short) 0) {
            return 0;
        }
        short s = (short) ((this.ovv * 100) / this.ovw);
        this.ovv = (short) 0;
        return s;
    }

    public final void start() {
        e.b(this, "TalkRoomPlayer_start").start();
    }
}
