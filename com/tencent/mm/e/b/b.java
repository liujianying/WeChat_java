package com.tencent.mm.e.b;

import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.os.Looper;
import com.tencent.mm.aw.c.1;
import com.tencent.mm.aw.d;
import com.tencent.mm.aw.d.a;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.e.c.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    private static Object bDl = new Object();
    private int bDa = 0;
    private String bDb = null;
    private int bDc;
    private final Object bDd = new Object();
    private c bDe = null;
    private a bDf;
    private com.tencent.mm.aw.c bDg = null;
    private a bDh = null;
    private long bDi = 0;
    private long bDj = 0;
    private int bDk = 0;
    private int bDm = 16000;
    private boolean bDn = false;
    public MediaRecorder bDo;
    public c bDp = null;
    public com.tencent.mm.compatible.b.b.a bDq;
    public b bDr;
    private volatile boolean bDs = false;
    private g.a bDt = new g.a();
    private int bDu = 0;
    private int bDv = 0;
    private c$a bDw = new 2(this);
    private int mSampleRate = 8000;

    public b(com.tencent.mm.compatible.b.b.a aVar) {
        x.i("MicroMsg.MMAudioRecorder", "MMAudioRecorder recMode: " + aVar);
        this.bDq = aVar;
        if (!com.tencent.mm.e.b.g.b.ws()) {
            x.i("MicroMsg.MMAudioRecorder", "can't use silk encode, force to use amr mode now");
            this.bDq = com.tencent.mm.compatible.b.b.a.daM;
        }
        if (this.bDq == com.tencent.mm.compatible.b.b.a.daM) {
            this.bDc = 7;
            this.bDo = new MediaRecorder();
        } else {
            wj();
            this.bDc = 1;
        }
        this.bDs = false;
    }

    public final void a(a aVar) {
        if (this.bDq == com.tencent.mm.compatible.b.b.a.daM) {
            if (this.bDo != null) {
                this.bDf = aVar;
                this.bDo.setOnErrorListener(new OnErrorListener() {
                    public final void onError(MediaRecorder mediaRecorder, int i, int i2) {
                        if (b.this.bDf != null) {
                            b.this.bDf.onError();
                        }
                        try {
                            b.this.bDo.release();
                        } catch (Exception e) {
                            x.e("MicroMsg.MMAudioRecorder", e.getMessage());
                        }
                        b.this.bDr = b.bDC;
                    }
                });
            }
        } else if (this.bDr == b.bDz) {
            this.bDf = aVar;
        } else {
            x.e("MicroMsg.MMAudioRecorder", "setOnErrorListener on wrong state");
        }
    }

    public final void setOutputFile(String str) {
        if (this.bDq == com.tencent.mm.compatible.b.b.a.daM) {
            if (this.bDo != null) {
                this.bDo.setOutputFile(str);
                this.bDb = str;
            }
        } else if (this.bDr == b.bDz) {
            this.bDb = str;
        } else {
            x.e("MicroMsg.MMAudioRecorder", "set output path on wrong state");
            this.bDr = b.bDC;
        }
    }

    public final void setMaxDuration(int i) {
        if (this.bDq != com.tencent.mm.compatible.b.b.a.daM) {
            this.bDi = (long) i;
        } else if (this.bDo != null) {
            this.bDo.setMaxDuration(i);
        }
    }

    public final void wg() {
        if (this.bDq == com.tencent.mm.compatible.b.b.a.daM && this.bDo != null) {
            this.bDo.setAudioEncoder(1);
        }
    }

    public final void wh() {
        if (this.bDq == com.tencent.mm.compatible.b.b.a.daM && this.bDo != null) {
            this.bDo.setAudioSource(1);
        }
    }

    public final void wi() {
        if (this.bDq == com.tencent.mm.compatible.b.b.a.daM && this.bDo != null) {
            this.bDo.setOutputFormat(3);
        }
    }

    public final int getMaxAmplitude() {
        if (this.bDq == com.tencent.mm.compatible.b.b.a.daM) {
            if (this.bDo == null) {
                return 0;
            }
            return this.bDo.getMaxAmplitude();
        } else if (this.bDr != b.bDB) {
            return 0;
        } else {
            int i = this.bDa;
            this.bDa = 0;
            return i;
        }
    }

    public final void wj() {
        int nextInt;
        this.bDh = a.RP();
        if (this.bDh != null) {
            boolean z;
            a aVar = this.bDh;
            if (1 == g.t("EnableSpeexVoiceUpload", 0)) {
                z = true;
            } else {
                x.d("upload", "type " + d.chatType);
                int RO = aVar.RO();
                int RN = aVar.RN();
                com.tencent.mm.kernel.g.Ek();
                Integer valueOf = Integer.valueOf(bi.f((Integer) com.tencent.mm.kernel.g.Ei().DT().get(16646145, null)));
                x.d("upload", "daycount " + aVar.RO() + "  count " + valueOf + " rate " + RN);
                if (valueOf.intValue() <= RO && RN != 0 && ao.isWifi(ad.getContext())) {
                    com.tencent.mm.kernel.g.Ek();
                    z = aVar.sex == 0 ? true : aVar.sex == bi.a((Integer) com.tencent.mm.kernel.g.Ei().DT().get(12290, null), 0);
                    x.d("upload", "fitSex " + aVar.sex + " " + z + " " + aVar.sex);
                    if (z && aVar.RM()) {
                        nextInt = aVar.ehz.nextInt(RN);
                        x.d("upload", "luck " + nextInt);
                        if (nextInt == RN / 2) {
                            z = true;
                        }
                    }
                }
                z = false;
            }
            this.bDn = z;
        }
        if (this.bDq == com.tencent.mm.compatible.b.b.a.daN) {
            this.mSampleRate = bi.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("VoiceSamplingRate"), 16000);
            this.bDm = bi.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("VoiceRate"), 16000);
            x.i("MicroMsg.MMAudioRecorder", "initMediaRecorder dynamicSample: %s sampleRate: %d dynamicEncoding: %s audioEncoding: %d", new Object[]{r3, Integer.valueOf(this.mSampleRate), r0, Integer.valueOf(this.bDm)});
        } else {
            if (this.bDn) {
                this.mSampleRate = 16000;
            } else {
                this.mSampleRate = 8000;
            }
            com.tencent.mm.kernel.g.Ek();
            nextInt = bi.a((Integer) com.tencent.mm.kernel.g.Ei().dqk.get(27), 0);
            x.i("MicroMsg.MMAudioRecorder", "sampleRate: " + this.mSampleRate + " notSupp16K: " + nextInt);
            if (nextInt == 1) {
                this.mSampleRate = 8000;
            }
        }
        this.bDa = 0;
        this.bDb = null;
        synchronized (this.bDd) {
            this.bDg = null;
            this.bDe = null;
        }
        this.bDk = 0;
        try {
            synchronized (bDl) {
                this.bDp = new c(this.mSampleRate, 1, 0);
                this.bDp.aM(true);
                this.bDp.ey(120);
                this.bDp.bEb = this.bDw;
            }
            this.bDr = b.bDz;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                x.e("MicroMsg.MMAudioRecorder", e.getMessage());
            } else {
                x.e("MicroMsg.MMAudioRecorder", "Unknown error occured while initializing recording");
            }
            this.bDr = b.bDC;
        }
    }

    public final void start() {
        if (this.bDq != com.tencent.mm.compatible.b.b.a.daM) {
            x.i("MicroMsg.MMAudioRecorder", "Start record now state: " + this.bDr + " recMode: " + this.bDq);
            if (this.bDr == b.bDA) {
                this.bDj = System.currentTimeMillis();
                this.bDk = 0;
                this.bDr = b.bDB;
                synchronized (bDl) {
                    this.bDp.wn();
                }
            } else {
                com.tencent.mm.kernel.g.Ek();
                com.tencent.mm.kernel.g.Ei().dqk.set(27, Integer.valueOf(1));
                x.e("MicroMsg.MMAudioRecorder", "start() called on illegal state");
                this.bDr = b.bDC;
            }
            this.bDs = false;
        } else if (this.bDo != null) {
            this.bDo.start();
        }
    }

    public final void prepare() {
        if (this.bDq == com.tencent.mm.compatible.b.b.a.daM) {
            if (this.bDo != null) {
                this.bDo.prepare();
            }
        } else if (this.bDr != b.bDz || this.bDb == null) {
            this.bDr = b.bDC;
            release();
        } else {
            this.bDr = b.bDA;
        }
    }

    public final void release() {
        if (this.bDq != com.tencent.mm.compatible.b.b.a.daM) {
            if (this.bDr == b.bDB) {
                wk();
            } else {
                b bVar = b.bDA;
            }
            synchronized (bDl) {
                if (this.bDp != null) {
                    this.bDp.we();
                    this.bDp.bEb = null;
                    this.bDp = null;
                }
            }
        } else if (this.bDo != null) {
            this.bDo.release();
        }
    }

    public final boolean wk() {
        if (this.bDq == com.tencent.mm.compatible.b.b.a.daM) {
            x.i("MicroMsg.MMAudioRecorder", "stop sysMediaRecorder: %s", new Object[]{this.bDo});
            if (this.bDo != null) {
                this.bDo.stop();
                this.bDo.release();
                this.bDo = null;
            }
            return true;
        }
        g.a aVar = new g.a();
        x.i("MicroMsg.MMAudioRecorder", "stop now state: " + this.bDr);
        if (this.bDr != b.bDB) {
            x.e("MicroMsg.MMAudioRecorder", "stop() called on illegal state");
            this.bDr = b.bDC;
            return true;
        }
        synchronized (bDl) {
            if (this.bDp != null) {
                this.bDs = true;
            } else {
                this.bDs = false;
            }
        }
        long Ad = aVar.Ad();
        this.bDr = b.bDD;
        long Ad2 = aVar.Ad();
        if (this.bDs) {
            x.i("MicroMsg.MMAudioRecorder", "start to wait pcmrecorder stop, markStop: %s", new Object[]{Boolean.valueOf(this.bDs)});
            int i = 0;
            while (this.bDs) {
                i++;
                try {
                    Thread.sleep(20);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MMAudioRecorder", e, "", new Object[0]);
                }
                if (i >= 25) {
                    synchronized (bDl) {
                        x.i("MicroMsg.MMAudioRecorder", "wait pcmrecorder stop, reach maximum count!, mPcmRecorder: %s", new Object[]{this.bDp});
                        if (this.bDp != null) {
                            try {
                                this.bDp.we();
                                this.bDp.bEb = null;
                                this.bDp = null;
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.MMAudioRecorder", e2, "", new Object[0]);
                            }
                        }
                    }
                    x.i("MicroMsg.MMAudioRecorder", "finish to wait pcmrecorder stop, markStop: %s, count: %s", new Object[]{Boolean.valueOf(this.bDs), Integer.valueOf(i)});
                }
            }
            x.i("MicroMsg.MMAudioRecorder", "finish to wait pcmrecorder stop, markStop: %s, count: %s", new Object[]{Boolean.valueOf(this.bDs), Integer.valueOf(i)});
        }
        synchronized (this.bDd) {
            if (this.bDe != null) {
                this.bDe.wA();
            }
            if (this.bDg != null) {
                com.tencent.mm.aw.c cVar = this.bDg;
                x.i("MicroMsg.SpeexEncoderWorker", "stop ");
                new ag(Looper.getMainLooper()).post(new 1(cVar));
            }
        }
        long bH = bi.bH(this.bDj);
        x.i("MicroMsg.MMAudioRecorder", "toNow " + bH + " startTickCnt: " + this.bDj + " pcmDataReadedCnt: " + this.bDk);
        if (bH > 2000 && this.bDk == 0) {
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Ei().dqk.set(27, Integer.valueOf(1));
            x.i("MicroMsg.MMAudioRecorder", "16k not suppourt");
        }
        x.i("MicroMsg.MMAudioRecorder", "Wait Stop Time Media:" + Ad + " Read:" + Ad2 + " Thr:" + aVar.Ad());
        return false;
    }
}
