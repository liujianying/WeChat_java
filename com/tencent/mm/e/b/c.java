package com.tencent.mm.e.b;

import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.b.i;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.e.c.b;
import com.tencent.mm.g.a.jm;
import com.tencent.mm.g.a.lq;
import com.tencent.mm.g.a.lr;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class c {
    public int bDF = 0;
    int bDG = 0;
    int bDH = 0;
    int bDI = 0;
    public int bDJ = 1;
    private int bDK = 1;
    public int bDL = 120;
    private boolean bDM = false;
    boolean bDN = false;
    public int bDO = 10;
    private int bDP = -1;
    public int bDQ = -123456789;
    private boolean bDR = false;
    long bDS = -1;
    int bDT;
    boolean bDU = false;
    int bDV;
    private boolean bDW = false;
    int bDX = 0;
    boolean bDY = false;
    boolean bDZ = false;
    private AudioRecord bEa;
    public a bEb;
    private f bEc;
    private g bEd;
    b bEe;
    public int bEf = 2;
    public int bEg = 1;
    public int bEh = 0;
    private f$a bEi = new 1(this);
    public int mSampleRate = 8000;

    public c(int i, int i2, int i3) {
        this.bDK = i2;
        this.mSampleRate = i;
        this.bDP = i3;
        if (this.bDK == 2) {
            this.bEf = 3;
        } else {
            this.bEf = 2;
        }
        if (this.bDP == 0 && q.deW.ddF > 0) {
            this.bDL = q.deW.ddF;
        }
        if (q.deW.ddQ > 0) {
            this.bEf = q.deW.ddQ;
        }
        if (q.deW.ddA > 0) {
            this.bDO = q.deW.ddA;
        }
        if (q.deN.dcd) {
            this.bEe = new b(g.bEE, this.bDK, this.mSampleRate);
        }
        this.bDZ = 1 == g.t("EnableRecorderCheckUnreasonableData", 1);
        x.i("MicroMsg.MMPcmRecorder", "MMPcmRecorder sampleRate:%d channelCnt:%d durationPreFrame:%d newBufPreFrame:%b Biz:%d", new Object[]{Integer.valueOf(this.mSampleRate), Integer.valueOf(this.bDK), Integer.valueOf(this.bDL), Boolean.valueOf(this.bDM), Integer.valueOf(this.bDP)});
    }

    public final void ey(int i) {
        this.bDL = i;
        x.i("MicroMsg.MMPcmRecorder", "mDurationPreFrame: " + this.bDL);
    }

    public final void aM(boolean z) {
        this.bDM = z;
        x.i("MicroMsg.MMPcmRecorder", "mNewBufPreFrame: " + this.bDM);
    }

    public final void wm() {
        this.bDN = true;
        x.i("MicroMsg.MMPcmRecorder", "mCheckAudioQuality: " + this.bDN);
    }

    public final void t(int i, boolean z) {
        if (10 == this.bDO || z) {
            this.bDO = i;
            x.i("MicroMsg.MMPcmRecorder", "mMultipleOfMinBuffer: " + this.bDO);
        }
    }

    public final void aN(boolean z) {
        this.bDR = z;
        x.i("MicroMsg.MMPcmRecorder", "mUsePreProcess: " + this.bDR);
    }

    private boolean init() {
        Object obj;
        this.bEg = 1;
        boolean z = q.deW.ddB != 2;
        int zj = m.zj();
        int i = q.deN.dcq;
        if ((zj & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            if (i <= 0) {
                i = 0;
            }
            x.i("MicroMsg.MMPcmRecorder", "CPU ARMv7, enableRecTimerMode: " + i);
        } else {
            i = 1;
        }
        if (i == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        x.d("MicroMsg.MMPcmRecorder", "init, start getMinBufferSize");
        int minBufferSize = AudioRecord.getMinBufferSize(this.mSampleRate, this.bEf, 2);
        if (minBufferSize == -2 || minBufferSize == -1) {
            this.bEg = 3;
            this.bDF = 1;
            x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_MINBUFFER_ERROR " + minBufferSize);
            wo();
            return false;
        }
        int i2;
        x.d("MicroMsg.MMPcmRecorder", "finish getMinBufferSize, minBufSize: %d", new Object[]{Integer.valueOf(minBufferSize)});
        this.bDT = (((this.mSampleRate * 20) * this.bDK) * 2) / 1000;
        int i3 = ((this.mSampleRate * this.bDL) * this.bDK) / 1000;
        int i4 = i3 * 2;
        x.i("MicroMsg.MMPcmRecorder", "Construct AudioRecord, minBufSize:%d, sampleRate:%d, sampleCntPreFrame:%d, sizePreFrame:%d, timesOfMinBuffer:%d, readMode:%b", new Object[]{Integer.valueOf(minBufferSize), Integer.valueOf(this.mSampleRate), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(this.bDO), Boolean.valueOf(z)});
        zj = this.bDP;
        i = this.bDJ;
        if (1 == zj || 6 == zj || 7 == zj) {
            i = VERSION.SDK_INT < 11 ? 1 : 7;
            if (q.deN.dby) {
                i = 1;
            }
            if (q.deN.dbX >= 0) {
                i = q.deN.dbX;
            }
            if (6 == zj && q.deN.dcA >= 0) {
                i2 = q.deN.dcA;
                this.bEa = new com.tencent.mm.compatible.b.c(i2, this.mSampleRate, this.bEf, this.bDO * minBufferSize);
                if (this.bEa.getState() == 0) {
                    h.mEJ.a(151, 0, 1, false);
                    h.mEJ.a(151, 2, 1, false);
                    this.bEa.release();
                    this.bDF = 2;
                    x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEWAUDIORECORD_ERROR");
                    if (7 == i2) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    this.bEa = new com.tencent.mm.compatible.b.c(i, this.mSampleRate, this.bEf, this.bDO * minBufferSize);
                }
                if (this.bEa.getState() != 0) {
                    h.mEJ.a(151, 0, 1, false);
                    h.mEJ.a(151, 2, 1, false);
                    this.bEa.release();
                    this.bEa = null;
                    this.bEg = 2;
                    this.bDF = 3;
                    x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_SECNEWAUDIORECORD_ERROR");
                    wo();
                    return false;
                }
                AudioRecord audioRecord;
                if (z) {
                    audioRecord = this.bEa;
                    boolean z2 = this.bDM;
                    a aVar = this.bEb;
                    boolean z3 = (this.bDP == 1 || this.bDP == 6) && obj != null;
                    this.bEc = new e(audioRecord, z2, i4, aVar, z3);
                } else {
                    this.bEc = new d(this.bEa, this.bEb, this.bDM, i3, i4);
                }
                this.bEc.a(this.bEi);
                if (-123456789 != this.bDQ) {
                    this.bEc.ez(this.bDQ);
                }
                if (this.bDR) {
                    this.bEd = new g();
                    g gVar = this.bEd;
                    audioRecord = this.bEa;
                    zj = this.bDP;
                    x.d("MicroMsg.MMAudioPreProcess", "api " + VERSION.SDK_INT);
                    if (!d.fS(16)) {
                        if (audioRecord == null) {
                            x.d("MicroMsg.MMAudioPreProcess", "audio is null");
                        } else if (1 == zj) {
                            if (q.deW.ddX != 1) {
                                x.d("MicroMsg.MMAudioPreProcess", "disable by config");
                            } else {
                                if (q.deW.ddY != 2) {
                                    gVar.dbo = new i(audioRecord);
                                    if (gVar.dbo != null && gVar.dbo.isAvailable()) {
                                        gVar.dbo.yy();
                                    }
                                }
                                if (q.deW.ddZ != 2) {
                                    gVar.dbp = new e(audioRecord);
                                    if (gVar.dbp != null && gVar.dbp.isAvailable()) {
                                        gVar.dbp.yy();
                                    }
                                }
                                if (q.deW.dea != 2) {
                                    gVar.dbq = new com.tencent.mm.compatible.b.h(audioRecord);
                                    if (gVar.dbq != null && gVar.dbq.isAvailable()) {
                                        gVar.dbq.yy();
                                    }
                                }
                            }
                        } else if (q.deW.ddE != 1) {
                            x.d("MicroMsg.MMAudioPreProcess", "disable by config");
                        } else {
                            gVar.dbo = new i(audioRecord);
                            if (gVar.dbo != null && gVar.dbo.isAvailable()) {
                                gVar.dbo.yy();
                            }
                            gVar.dbp = new e(audioRecord);
                            if (gVar.dbp != null && gVar.dbp.isAvailable()) {
                                gVar.dbp.yy();
                            }
                            gVar.dbq = new com.tencent.mm.compatible.b.h(audioRecord);
                            if (gVar.dbq != null && gVar.dbq.isAvailable()) {
                                gVar.dbq.yy();
                            }
                        }
                    }
                }
                return true;
            }
        }
        i2 = i;
        try {
            this.bEa = new com.tencent.mm.compatible.b.c(i2, this.mSampleRate, this.bEf, this.bDO * minBufferSize);
            if (this.bEa.getState() == 0) {
                h.mEJ.a(151, 0, 1, false);
                h.mEJ.a(151, 2, 1, false);
                this.bEa.release();
                this.bDF = 2;
                x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEWAUDIORECORD_ERROR");
                if (7 == i2) {
                    i = 1;
                } else {
                    i = 0;
                }
                this.bEa = new com.tencent.mm.compatible.b.c(i, this.mSampleRate, this.bEf, this.bDO * minBufferSize);
            }
            if (this.bEa.getState() != 0) {
                AudioRecord audioRecord2;
                if (z) {
                    audioRecord2 = this.bEa;
                    boolean z22 = this.bDM;
                    a aVar2 = this.bEb;
                    boolean z32 = (this.bDP == 1 || this.bDP == 6) && obj != null;
                    this.bEc = new e(audioRecord2, z22, i4, aVar2, z32);
                } else {
                    this.bEc = new d(this.bEa, this.bEb, this.bDM, i3, i4);
                }
                this.bEc.a(this.bEi);
                if (-123456789 != this.bDQ) {
                    this.bEc.ez(this.bDQ);
                }
                if (this.bDR) {
                    this.bEd = new g();
                    g gVar2 = this.bEd;
                    audioRecord2 = this.bEa;
                    zj = this.bDP;
                    x.d("MicroMsg.MMAudioPreProcess", "api " + VERSION.SDK_INT);
                    if (!d.fS(16)) {
                        if (audioRecord2 == null) {
                            x.d("MicroMsg.MMAudioPreProcess", "audio is null");
                        } else if (1 == zj) {
                            if (q.deW.ddX != 1) {
                                x.d("MicroMsg.MMAudioPreProcess", "disable by config");
                            } else {
                                if (q.deW.ddY != 2) {
                                    gVar2.dbo = new i(audioRecord2);
                                    if (gVar2.dbo != null && gVar2.dbo.isAvailable()) {
                                        gVar2.dbo.yy();
                                    }
                                }
                                if (q.deW.ddZ != 2) {
                                    gVar2.dbp = new e(audioRecord2);
                                    if (gVar2.dbp != null && gVar2.dbp.isAvailable()) {
                                        gVar2.dbp.yy();
                                    }
                                }
                                if (q.deW.dea != 2) {
                                    gVar2.dbq = new com.tencent.mm.compatible.b.h(audioRecord2);
                                    if (gVar2.dbq != null && gVar2.dbq.isAvailable()) {
                                        gVar2.dbq.yy();
                                    }
                                }
                            }
                        } else if (q.deW.ddE != 1) {
                            x.d("MicroMsg.MMAudioPreProcess", "disable by config");
                        } else {
                            gVar2.dbo = new i(audioRecord2);
                            if (gVar2.dbo != null && gVar2.dbo.isAvailable()) {
                                gVar2.dbo.yy();
                            }
                            gVar2.dbp = new e(audioRecord2);
                            if (gVar2.dbp != null && gVar2.dbp.isAvailable()) {
                                gVar2.dbp.yy();
                            }
                            gVar2.dbq = new com.tencent.mm.compatible.b.h(audioRecord2);
                            if (gVar2.dbq != null && gVar2.dbq.isAvailable()) {
                                gVar2.dbq.yy();
                            }
                        }
                    }
                }
                return true;
            }
            h.mEJ.a(151, 0, 1, false);
            h.mEJ.a(151, 2, 1, false);
            this.bEa.release();
            this.bEa = null;
            this.bEg = 2;
            this.bDF = 3;
            x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_SECNEWAUDIORECORD_ERROR");
            wo();
            return false;
        } catch (Exception e) {
            x.e("MicroMsg.MMPcmRecorder", "new AudioRecord failed");
            this.bDF = 12;
            x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEW_AUDIORECORD_EXCEPTION");
            h.mEJ.a(151, 0, 1, false);
            h.mEJ.a(151, 1, 1, false);
            return false;
        }
    }

    public final void aO(boolean z) {
        x.i("MicroMsg.MMPcmRecorder", "switchMute mute:" + z);
        if (this.bEc != null) {
            this.bEc.aO(z);
        }
    }

    public final boolean wn() {
        boolean z = false;
        x.d("MicroMsg.MMPcmRecorder", "startRecord");
        lq lqVar = new lq();
        lqVar.bWa.type = 1;
        lqVar.bWa.bWc = true;
        a.sFg.m(lqVar);
        this.bDS = System.currentTimeMillis();
        this.bDU = false;
        if (lqVar.bWb.bWe) {
            x.e("MicroMsg.MMPcmRecorder", "can't start record due to permission tips policy");
            this.bDF = 13;
        } else {
            AudioManager audioManager = (AudioManager) ad.getContext().getSystemService("audio");
            if (audioManager == null || !audioManager.isMicrophoneMute()) {
                this.bDW = false;
                com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
                x.i("MicroMsg.MMPcmRecorder", "startRecord, " + Thread.currentThread().getStackTrace()[2].getMethodName());
                if (this.bEa != null) {
                    x.e("MicroMsg.MMPcmRecorder", "start error ,is recording ");
                } else {
                    aVar.dgA = SystemClock.elapsedRealtime();
                    x.d("MicroMsg.MMPcmRecorder", "startRecordInternal, start init");
                    if (init()) {
                        x.i("MicroMsg.MMPcmRecorder", "init cost: " + aVar.Ad() + "ms");
                        aVar.dgA = SystemClock.elapsedRealtime();
                        this.bEa.startRecording();
                        x.i("MicroMsg.MMPcmRecorder", "startRecording cost: " + aVar.Ad());
                        if (this.bEa.getRecordingState() != 3) {
                            h.mEJ.a(151, 0, 1, false);
                            h.mEJ.a(151, 3, 1, false);
                            this.bEg = 2;
                            this.bDF = 4;
                            x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_STARTRECORDING_ERROR");
                            wo();
                        } else if (this.bEc != null) {
                            z = this.bEc.wn();
                        } else {
                            x.e("MicroMsg.MMPcmRecorder", "mRecordMode is null");
                        }
                    } else {
                        x.e("MicroMsg.MMPcmRecorder", "startRecord init error");
                    }
                }
                if (!z) {
                    we();
                    lr lrVar = new lr();
                    lrVar.bWf.type = 1;
                    a.sFg.m(lrVar);
                }
            } else {
                x.e("MicroMsg.MMPcmRecorder", "microphone is mute");
                this.bDF = 14;
                a.sFg.m(new jm());
                h.mEJ.a(151, 0, 1, false);
                h.mEJ.a(151, 8, 1, false);
            }
        }
        return z;
    }

    public final synchronized boolean we() {
        boolean z = true;
        synchronized (this) {
            if (true == this.bDW) {
                x.i("MicroMsg.MMPcmRecorder", "already have stopped");
            } else {
                boolean z2;
                this.bDW = true;
                com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
                if (this.bEe != null) {
                    this.bEe.wC();
                    this.bEe = null;
                }
                aVar.dgA = SystemClock.elapsedRealtime();
                if (this.bEc != null) {
                    this.bEc.stopRecord();
                    this.bEc = null;
                }
                x.i("MicroMsg.MMPcmRecorder", "cost " + aVar.Ad() + "ms to call stopRecord");
                x.i("MicroMsg.MMPcmRecorder", "stopRecord, " + Thread.currentThread().getStackTrace()[2].getMethodName());
                if (this.bEa == null) {
                    x.e("MicroMsg.MMPcmRecorder", "audioRecord is null");
                    z2 = false;
                } else if (this.bEa.getState() != 1) {
                    x.e("MicroMsg.MMPcmRecorder", "audioRecord sate error " + this.bEa.getState());
                    z2 = false;
                } else {
                    aVar.dgA = SystemClock.elapsedRealtime();
                    this.bEa.stop();
                    this.bEa.release();
                    this.bEa = null;
                    x.i("MicroMsg.MMPcmRecorder", "cost " + aVar.Ad() + "ms to call stop and release");
                    z2 = true;
                }
                if (!(this.bDU || -1 == this.bDS || System.currentTimeMillis() - this.bDS < 2000) || this.bDY) {
                    x.i("MicroMsg.MMPcmRecorder", "stopRecord publish PermissionShowDlgEvent");
                    lr lrVar = new lr();
                    lrVar.bWf.type = 1;
                    a.sFg.m(lrVar);
                    z = false;
                }
                lq lqVar = new lq();
                lqVar.bWa.type = 1;
                lqVar.bWa.bWc = false;
                lqVar.bWa.bWd = z;
                a.sFg.m(lqVar);
                x.i("MicroMsg.MMPcmRecorder", "doNewIDKeyStatOnStopRecord, mRecordDetailState: %d", new Object[]{Integer.valueOf(this.bDF)});
                ArrayList arrayList = new ArrayList();
                arrayList.add(new IDKey(357, 0, 1));
                if (this.bDF != 0) {
                    arrayList.add(new IDKey(357, 1, 1));
                }
                switch (this.bDF) {
                    case 1:
                        arrayList.add(new IDKey(357, 2, 1));
                        break;
                    case 2:
                        arrayList.add(new IDKey(357, 3, 1));
                        break;
                    case 3:
                        arrayList.add(new IDKey(357, 4, 1));
                        break;
                    case 4:
                        arrayList.add(new IDKey(357, 5, 1));
                        break;
                    case 5:
                        arrayList.add(new IDKey(357, 6, 1));
                        break;
                    case 6:
                        arrayList.add(new IDKey(357, 7, 1));
                        break;
                    case 7:
                        arrayList.add(new IDKey(357, 8, 1));
                        break;
                    case 8:
                        arrayList.add(new IDKey(357, 9, 1));
                        break;
                    case 9:
                        arrayList.add(new IDKey(357, 10, 1));
                        break;
                    case 10:
                        arrayList.add(new IDKey(357, 11, 1));
                        break;
                    case 11:
                        arrayList.add(new IDKey(357, 12, 1));
                        break;
                    case 12:
                        arrayList.add(new IDKey(357, 13, 1));
                        break;
                }
                x.i("MicroMsg.MMPcmRecorder", "do idkey, infolist size: %d", new Object[]{Integer.valueOf(arrayList.size())});
                h.mEJ.b(arrayList, false);
                z = z2;
            }
        }
        return z;
    }

    final void wo() {
        if (this.bEb != null) {
            this.bEb.aN(this.bEg, this.bDF);
        }
    }

    public final int wp() {
        if (this.bEc != null) {
            return this.bEc.wp();
        }
        return -1;
    }
}
