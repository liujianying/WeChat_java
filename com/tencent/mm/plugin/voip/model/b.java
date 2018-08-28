package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.media.AudioTrack;
import com.tencent.mm.compatible.b.d;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.Timer;

public final class b {
    private static float agC = 0.0f;
    AudioTrack aga = null;
    private Timer bEw = null;
    private boolean bEx = false;
    Context context;
    private int dbY = 3;
    int epm = 2;
    private int epn = 0;
    private int epo = 0;
    private Runnable epp;
    private int epr = 0;
    int eps = 20;
    private boolean ept = false;
    public boolean oGX = false;
    boolean oGY = false;
    boolean oGZ = true;
    private int oHA = 1;
    private int oHB = 0;
    private final Object oHC = new Object();
    private int oHD = 0;
    private int oHE = 0;
    private int oHF = 0;
    private int oHG = 0;
    private int oHH = 0;
    j oHa = null;
    private int oHb = 0;
    private byte[] oHc = null;
    private byte[] oHd = null;
    private byte[] oHe = null;
    private byte[] oHf = null;
    private byte[] oHg = null;
    private int oHh = 0;
    public a oHi = null;
    private int oHj = 1;
    private int oHk = 1;
    private int oHl = 0;
    private int oHm = 0;
    private int oHn = 0;
    private int oHo = 0;
    private int oHp = 0;
    private int oHq = 0;
    private int oHr = 1;
    private int oHs = 0;
    private long oHt = 0;
    private long oHu = 0;
    private int oHv = 1;
    private int oHw = 0;
    private int oHx = -1;
    private int oHy = 0;
    private long oHz = 0;

    static /* synthetic */ void j(b bVar, int i) {
        if (bVar.oHE != -1 && i < 0) {
            bVar.oHE++;
            if (bVar.oHE >= 50) {
                bVar.oHD = 5;
                bVar.oHE = -1;
            }
        }
    }

    public final int bJr() {
        return (this.oHB / this.eps) * this.epo;
    }

    public final int r(Context context, boolean z) {
        x.d("MicroMsg.Voip.AudioPlayer", "enter to Init...");
        this.context = context;
        if (this.oHh == 2) {
            this.epm = 3;
        } else {
            this.epm = 2;
        }
        this.epr = AudioTrack.getMinBufferSize(this.epn, this.epm, 2);
        if (this.epr == -2 || this.epr == -1) {
            this.oHD = 1;
            return -1;
        }
        this.oHq = this.epr;
        this.oHw = this.oHq * this.oHv;
        this.epr *= this.oHA;
        float f = ((float) (this.oHq >> 1)) / ((float) this.epn);
        int zj = m.zj();
        int i = q.deN.dcr;
        if ((zj & 1024) != 0) {
            if (i <= 0) {
                i = 0;
            }
            x.i("MicroMsg.Voip.AudioPlayer", "CPU ARMv7, ablePlayTimer: " + i);
        } else {
            i = 0;
        }
        if (1000.0f * f < 60.0f || this.oHF != 0) {
            i = 0;
        }
        this.oGZ = i != 0;
        x.d("MicroMsg.Voip.AudioPlayer", "playBufSize:" + this.epr + "  MinBufSizeInMs:" + f + ",bPlayTimer:" + this.oGZ);
        int iK = iK(z);
        try {
            if (this.aga != null) {
                try {
                    this.aga.release();
                } catch (Exception e) {
                }
            }
            this.aga = new d(iK, this.epn, this.epm, this.epr);
        } catch (Exception e2) {
            x.w("MicroMsg.Voip.AudioPlayer", "new AudioTrack:", new Object[]{e2});
            this.oHD = 6;
        }
        if (this.aga == null || this.aga.getState() == 0) {
            this.oHD = 2;
            x.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer audioTrack.getState() == AudioTrack.STATE_UNINITIALIZED");
            if (this.aga != null) {
                this.aga.release();
            }
            if (iK == 0) {
                this.aga = new d(3, this.epn, this.epm, this.epr);
            } else {
                this.aga = new d(0, this.epn, this.epm, this.epr);
            }
        }
        if (this.aga == null) {
            this.oHD = 3;
            x.e("MicroMsg.Voip.AudioPlayer", "null == audioTrack return");
            return -1;
        } else if (this.aga.getState() == 0) {
            this.oHD = 3;
            x.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer STATE_UNINITIALIZED call AudioTrack.release() and return");
            this.aga.release();
            this.aga = null;
            return -1;
        } else {
            this.oHc = new byte[this.epr];
            if (this.oHc == null) {
                x.e("MicroMsg.Voip.AudioPlayer", "null == playBuffer return");
                return -1;
            }
            this.oHf = new byte[this.eps];
            if (this.oHf == null) {
                x.e("MicroMsg.Voip.AudioPlayer", "null == frmBuffer return");
                return -1;
            }
            if (this.oGZ) {
                this.oHb = this.epr;
                this.oHd = new byte[this.oHb];
                if (this.oHd == null) {
                    x.e("MicroMsg.Voip.AudioPlayer", "null == playTaskBuffer return");
                    return -1;
                }
                this.oHe = new byte[this.oHb];
                if (this.oHe == null) {
                    x.e("MicroMsg.Voip.AudioPlayer", "null == playTaskBufferTmp return");
                    return -1;
                }
                this.oHg = new byte[this.eps];
                if (this.oHg == null) {
                    x.e("MicroMsg.Voip.AudioPlayer", "null == frmTaskBuffer return");
                    return -1;
                }
            }
            this.oGX = false;
            this.oGY = false;
            x.i("MicroMsg.Voip.AudioPlayer", "dkbt AudioTrack init ok, mode:%d issp:%b m:%d size %d,nSamplerate:%d", new Object[]{Integer.valueOf(au.HV().daT.getMode()), Boolean.valueOf(au.HV().daT.isSpeakerphoneOn()), Integer.valueOf(iK), Integer.valueOf(this.epr), Integer.valueOf(this.epn)});
            return (this.epr * BaseReportManager.MAX_READ_COUNT) / (this.epn * 2);
        }
    }

    public final boolean iJ(boolean z) {
        x.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter to switchSpeakerPhone...");
        int iK = iK(z);
        if (au.HV().yE()) {
            iK = 0;
        }
        x.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:speakerOn:" + z + ":streamtype:" + iK);
        if (this.aga == null || iK != this.aga.getStreamType()) {
            bJv();
            this.ept = true;
            if (this.oHh == 2) {
                this.epm = 3;
            } else {
                this.epm = 2;
            }
            this.epr = AudioTrack.getMinBufferSize(this.epn, this.epm, 2);
            if (this.epr == -2 || this.epr == -1) {
                this.ept = false;
                return false;
            }
            this.oHm = 0;
            this.oHp = 0;
            this.oHr = 1;
            this.oHs = 0;
            this.oHt = 0;
            this.oHu = 0;
            this.oHv = 1;
            this.oHx = -1;
            this.oHy = 0;
            this.oHq = this.epr;
            this.oHw = this.oHq * this.oHv;
            this.epr *= this.oHA;
            x.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:playBufSize:" + this.epr + "  MinBufSizeInMs:" + (((float) this.oHq) / 16.0f));
            if (this.aga != null) {
                try {
                    this.aga.stop();
                } catch (Exception e) {
                    x.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone audioTrack.stop Exception:%s", new Object[]{e.getMessage()});
                }
                this.aga.release();
                this.aga = null;
            }
            x.i("MicroMsg.Voip.AudioPlayer", "AudioPlayer dkbt switchSpeakerPhone mode:%d issp:%b m:%d size %d,nSamplerate:%d", new Object[]{Integer.valueOf(au.HV().daT.getMode()), Boolean.valueOf(au.HV().daT.isSpeakerphoneOn()), Integer.valueOf(iK), Integer.valueOf(this.epr), Integer.valueOf(this.epn)});
            this.aga = new d(iK, this.epn, this.epm, this.epr);
            if (this.aga == null || this.aga.getState() != 0) {
                x.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer leave  switchSpeakerPhone...");
                if (this.aga != null) {
                    this.ept = false;
                    bJt();
                    return true;
                }
                this.ept = false;
                return false;
            }
            x.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone STATE_UNINITIALIZED call AudioTrack.release() and return");
            this.aga.release();
            this.aga = null;
            return false;
        }
        x.d("MicroMsg.Voip.AudioPlayer", "switchSpeakerPhone:stream type do not need to  change");
        return false;
    }

    private int iK(boolean z) {
        int i = 0;
        if (q.deN.dbz > 0) {
            i = au.HV().aX(z);
        } else if (q.deN.dca >= 0) {
            i = q.deN.dca;
        }
        if (z && q.deN.dcb >= 0) {
            i = q.deN.dcb;
        } else if (!z && q.deN.dcc >= 0) {
            i = q.deN.dcc;
        }
        if (1 != this.oHF) {
            return i;
        }
        if (q.deN.dcB >= 0) {
            i = q.deN.dcB;
        }
        if (z && q.deN.dcC >= 0) {
            return q.deN.dcC;
        }
        if (z || q.deN.dcD < 0) {
            return i;
        }
        return q.deN.dcD;
    }

    public final int bJs() {
        if (this.aga != null) {
            this.aga.release();
            this.aga = null;
        }
        this.oGX = false;
        this.oGY = false;
        return 1;
    }

    public final int X(int i, int i2, int i3) {
        if (true == this.oGX) {
            return 0;
        }
        this.epn = i;
        this.oHh = 1;
        this.epo = i2;
        this.oHF = i3;
        this.eps = (((this.epn / BaseReportManager.MAX_READ_COUNT) * 1) * this.epo) * 2;
        this.oHy = (this.epn * 60) / BaseReportManager.MAX_READ_COUNT;
        return 1;
    }

    public final int bJt() {
        if (true == this.oGX) {
            return 1;
        }
        if (this.aga == null) {
            x.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: audioTrack is null!!");
            return 0;
        }
        this.oGX = true;
        try {
            this.aga.play();
        } catch (Exception e) {
            x.e("MicroMsg.Voip.AudioPlayer", "audioTrack.play Exception:%s", new Object[]{e.getMessage()});
        }
        if (this.aga.getPlayState() != 3) {
            this.oHD = 4;
            x.e("MicroMsg.Voip.AudioPlayer", "audioTrack play error: AudioTrack.PLAYSTATE_PLAYING, play do not start !");
            return 0;
        } else if (this.aga.getState() == 0) {
            x.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: AudioTrack.STATE_UNINITIALIZED, no more AudioTrack resource!!");
            return 0;
        } else {
            if (this.oGZ) {
                int i;
                if (this.bEx || this.bEw != null) {
                    x.w("MicroMsg.Voip.AudioPlayer", "Timer has been created or, timer has been started, " + this.bEx);
                    i = -1;
                } else {
                    this.bEw = new Timer();
                    i = this.bEw == null ? -1 : 0;
                }
                if (i != 0) {
                    x.e("MicroMsg.Voip.AudioPlayer", "InitAudioRecTimer failed, error code = -1");
                    return 0;
                }
                this.bEw.scheduleAtFixedRate(new a(this), 0, 20);
                this.bEx = true;
            }
            this.epp = new 1(this);
            e.b(this.epp, "AudioPlayer_play", 10);
            return 1;
        }
    }

    public final int bJu() {
        if (this.aga == null) {
            x.d("MicroMsg.Voip.AudioPlayer", "  audioTrack==null,m_iPlayBufSizeOrg:" + this.oHq + ",nSamplerate:" + this.epn);
            return (this.oHq * BaseReportManager.MAX_READ_COUNT) / this.epn;
        } else if (!this.oGX || this.aga.getState() == 0) {
            return (this.oHq * BaseReportManager.MAX_READ_COUNT) / this.epn;
        } else {
            try {
                return ((this.oHm - this.aga.getPlaybackHeadPosition()) * BaseReportManager.MAX_READ_COUNT) / this.epn;
            } catch (Exception e) {
                x.e("MicroMsg.Voip.AudioPlayer", "audioTrack getPlaybackHeadPosition error:%s", new Object[]{e.getMessage()});
                return (this.oHq * BaseReportManager.MAX_READ_COUNT) / this.epn;
            }
        }
    }

    public final int bJv() {
        if (this.bEx && this.bEw != null) {
            this.bEw.cancel();
            this.bEx = false;
        }
        if (this.oGX) {
            this.oGX = false;
            this.oHB = 0;
            try {
                if (this.epp != null) {
                    e.U(this.epp);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Voip.AudioPlayer", e, "", new Object[0]);
            }
            try {
                if (this.aga != null) {
                    this.aga.stop();
                    this.aga.release();
                    x.i("MicroMsg.Voip.AudioPlayer", "StopPlay stop audioTrack");
                }
            } catch (Exception e2) {
                x.e("MicroMsg.Voip.AudioPlayer", "StopPlay audioTrack.stop Exception:%s", new Object[]{e2.getMessage()});
            }
        }
        return 1;
    }

    public final int bJw() {
        x.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer  mAudioPlayErrState:" + this.oHD);
        return this.oHD;
    }

    public final int bJx() {
        if (this.aga != null) {
            return this.aga.getStreamType();
        }
        return iK(true);
    }
}
