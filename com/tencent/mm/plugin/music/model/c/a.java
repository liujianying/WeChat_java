package com.tencent.mm.plugin.music.model.c;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.b;
import com.google.android.exoplayer2.h.k;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.f;
import com.google.android.exoplayer2.v;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.an.d;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tenpay.android.wechat.PayuSecureEncrypt$EncrptType;
import java.util.ArrayList;

public final class a extends com.tencent.mm.plugin.music.model.e.a implements com.google.android.exoplayer2.h.d.a, com.google.android.exoplayer2.metadata.e.a {
    private long aBL;
    int aBN = 0;
    protected String aBr;
    boolean auM = false;
    protected com.tencent.mm.an.a bTF;
    int dGs = 0;
    public Handler fLN = new 1(this, Looper.myLooper());
    boolean lxb;
    private String lxf = "";
    private long lxh = 0;
    avq lyK;
    private d lyL;
    int lyM = 0;
    public v lyN;
    public b lyO;
    private k lyP;
    public com.google.android.exoplayer2.h.f.a lyQ;
    public f lyR;
    f lyS = new f((byte) 0);
    public a lyT = new a(this, (byte) 0);
    e lyU = new e(this, (byte) 0);
    d lyV = new d(this, (byte) 0);
    b lyW = new c();
    public boolean lyX = false;

    public class c implements b {
        public final void bik() {
            x.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
            if (a.this.lyK != null) {
                a.this.n(a.this.lyK);
            }
            if (a.this.dGs > 0) {
                x.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, seekTo startTime:%d,", new Object[]{Integer.valueOf(a.this.dGs)});
                a.this.if(a.this.dGs);
            }
            if (a.this.dGs == 0 && !a.this.lyN.iC()) {
                x.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, set play when ready");
                a.this.lyN.af(true);
            }
        }

        public final void bil() {
            x.i("MicroMsg.Music.ExoMusicPlayer", "onStart");
            if (a.this.lyK != null) {
                a.this.o(a.this.lyK);
            }
        }

        public final void bim() {
            x.i("MicroMsg.Music.ExoMusicPlayer", "onPause");
            if (a.this.lyK != null && !a.this.lyN.iC()) {
                a.this.q(a.this.lyK);
            }
        }

        public final void bin() {
            x.i("MicroMsg.Music.ExoMusicPlayer", "onStop");
            if (a.this.lyK != null) {
                a.this.r(a.this.lyK);
            }
        }

        public final void bio() {
            x.i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete");
            if (a.this.lyK != null) {
                a.this.s(a.this.lyK);
            }
            if (a.this.dGs > 0 && a.this.lyN != null && !a.this.lyN.iC()) {
                x.i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete, stay play hls");
                a.this.dGs = 0;
                a.this.lyN.af(true);
            }
        }

        public final void bip() {
            x.i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
            if (a.this.lyK != null) {
                a.this.u(a.this.lyK);
            }
            a.this.lxb = false;
            a.this.fLN.removeMessages(100);
        }

        public final void tF(int i) {
            x.i("MicroMsg.Music.ExoMusicPlayer", "onBufferingUpdate, percent:%d", new Object[]{Integer.valueOf(i)});
        }

        public final void cZ(int i, int i2) {
            a aVar;
            x.i("MicroMsg.Music.ExoMusicPlayer", "onError what:%d, extra:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (a.this.lyK != null) {
                int i3;
                aVar = a.this;
                avq avq = a.this.lyK;
                x.i("MicroMsg.Music.ExoMusicPlayer", "onErrorEvent with extra:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                aVar.lzq = "error";
                jt jtVar = new jt();
                jtVar.bTE.action = 4;
                jtVar.bTE.bTy = avq;
                jtVar.bTE.state = "error";
                jtVar.bTE.duration = (long) aVar.getDuration();
                jtVar.bTE.bTG = true;
                com.tencent.mm.g.a.jt.a aVar2 = jtVar.bTE;
                x.i("MicroMsg.Music.ExoPlayerErrorHandler", "getErrCodeType, errType: %d", new Object[]{Integer.valueOf(i)});
                switch (i) {
                    case -4999:
                        i3 = -1;
                        break;
                    case -4005:
                    case -4004:
                    case -4003:
                    case -4002:
                        i3 = 10001;
                        break;
                    case -4001:
                        i3 = 10004;
                        break;
                    case -4000:
                        i3 = 10002;
                        break;
                    default:
                        i3 = 0;
                        break;
                }
                aVar2.errCode = i3;
                com.tencent.mm.g.a.jt.a aVar3 = jtVar.bTE;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("errCode:" + i2 + ", err:");
                switch (i2) {
                    case -4004:
                        stringBuilder.append("load error");
                        break;
                    case -4003:
                        stringBuilder.append("MediaCodec decoder init exception");
                        break;
                    case -4002:
                        stringBuilder.append("illegal state exception");
                        break;
                    case -4001:
                        stringBuilder.append("UnrecognizedInputFormatException");
                        break;
                    case -43:
                        stringBuilder.append("error url format");
                        break;
                    case -42:
                        stringBuilder.append("stop error");
                        break;
                    case -41:
                        stringBuilder.append("prepare error");
                        break;
                    case -30:
                        stringBuilder.append(" network error");
                        break;
                    case -13:
                        stringBuilder.append(" network respCode 502");
                        break;
                    case -12:
                        stringBuilder.append(" network respCode 500");
                        break;
                    case -11:
                        stringBuilder.append(" network respCode 404");
                        break;
                    case PayuSecureEncrypt$EncrptType.HASHED_PASSWORD /*-10*/:
                        stringBuilder.append(" network respCode 403");
                        break;
                    case -3:
                        stringBuilder.append("connect fail");
                        break;
                    case -2:
                        stringBuilder.append(" no network");
                        break;
                    case -1:
                        stringBuilder.append("unknow exception");
                        break;
                }
                aVar3.Yy = stringBuilder.toString();
                com.tencent.mm.sdk.b.a.sFg.a(jtVar, Looper.getMainLooper());
            }
            if (a.this.lyN != null) {
                a.this.lyN.af(false);
                a.this.lyN.stop();
            }
            a.this.lxb = false;
            a.this.fLN.removeMessages(100);
            aVar = a.this;
            aVar.aBN++;
            if (a.this.aBN == 1) {
                a.a(a.this.bTF, i, i2);
            }
        }
    }

    private class e implements com.google.android.exoplayer2.a.e {
        private e() {
        }

        /* synthetic */ e(a aVar, byte b) {
            this();
        }

        public final void c(com.google.android.exoplayer2.b.d dVar) {
            x.i("MicroMsg.Music.ExoMusicPlayer", "audioEnabled [" + a.this.bij() + "]");
        }

        public final void cb(int i) {
            x.i("MicroMsg.Music.ExoMusicPlayer", "audioSessionId [" + i + "]");
        }

        public final void b(String str, long j, long j2) {
            x.i("MicroMsg.Music.ExoMusicPlayer", "audioDecoderInitialized [" + a.this.bij() + ", " + str + "]");
        }

        public final void d(Format format) {
            x.i("MicroMsg.Music.ExoMusicPlayer", "audioFormatChanged [" + a.this.bij() + ", " + Format.a(format) + "]");
        }

        public final void d(com.google.android.exoplayer2.b.d dVar) {
            x.i("MicroMsg.Music.ExoMusicPlayer", "audioDisabled [" + a.this.bij() + "]");
        }

        public final void c(int i, long j, long j2) {
            x.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", null, "internalError [" + a.this.bij() + ", " + ("audioTrackUnderrun [" + i + ", " + j + ", " + j2 + "]") + "]", new Object[0]);
        }
    }

    public a() {
        com.tencent.mm.plugin.music.b.b.a.biB();
    }

    public final void j(com.tencent.mm.an.a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.lxh;
        if (this.bTF != null && this.bTF.a(aVar) && j <= 1000) {
            this.bTF = aVar;
            x.e("MicroMsg.Music.ExoMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", new Object[]{this.lxf, Long.valueOf(j)});
        } else if (aVar == null) {
            x.e("MicroMsg.Music.ExoMusicPlayer", "music is null");
        } else {
            com.tencent.mm.plugin.music.model.f.a(aVar, false);
            this.lxh = currentTimeMillis;
            this.bTF = aVar;
            x.i("MicroMsg.Music.ExoMusicPlayer", "startPlay, currentTime:%d, startTime:%d", new Object[]{Long.valueOf(currentTimeMillis), Integer.valueOf(aVar.field_startTime)});
            if (this.lyN != null && PY()) {
                this.lyN.stop();
            }
            this.aBN = 0;
            this.dGs = aVar.field_startTime;
            this.aBL = SystemClock.elapsedRealtime();
            this.lyK = aVar.PV();
            m(this.lyK);
            x.i("MicroMsg.Music.ExoMusicPlayer", "startPlay startTime:%d", new Object[]{Integer.valueOf(this.dGs)});
            ah.A(new 2(this));
        }
    }

    public final void pause() {
        this.lyX = false;
        x.i("MicroMsg.Music.ExoMusicPlayer", "pause");
        if (this.lyN != null) {
            this.lyM = 2;
            this.lyN.af(false);
        }
    }

    public final boolean bho() {
        return this.lxb && this.lyX;
    }

    public final void bhn() {
        this.lyX = true;
        x.i("MicroMsg.Music.ExoMusicPlayer", "passivePause");
        if (this.lyN != null) {
            this.lyM = 2;
            this.lyN.af(false);
        }
    }

    public final void bhB() {
        x.i("MicroMsg.Music.ExoMusicPlayer", "pauseAndAbandonFocus");
        pause();
        h.big().bhO();
    }

    public final void resume() {
        this.aBN = 0;
        boolean bhC = bhC();
        boolean PY = PY();
        x.i("MicroMsg.Music.ExoMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", new Object[]{Boolean.valueOf(bhC), Boolean.valueOf(PY)});
        if (this.lyN != null) {
            if (h.big().requestFocus()) {
                this.lyM = 1;
                this.lyN.af(true);
                p(this.lyK);
            } else {
                x.e("MicroMsg.Music.ExoMusicPlayer", "request focus error");
            }
            this.lxb = true;
        }
    }

    public final boolean PY() {
        if (this.lyN == null) {
            return false;
        }
        switch (this.lyN.iB()) {
            case 1:
            case 3:
                return this.lyN.iC();
            default:
                return false;
        }
    }

    private boolean bhC() {
        if (this.lyN != null) {
            return this.lyN.iD();
        }
        return false;
    }

    public final boolean PZ() {
        return this.lxb && !bhC();
    }

    public final void stopPlay() {
        x.i("MicroMsg.Music.ExoMusicPlayer", "stopPlay");
        try {
            if (this.lyN != null) {
                this.lyM = 3;
                this.lyN.af(false);
                this.lyN.stop();
                r(this.lyK);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", e, "stopPlay", new Object[0]);
            a(this.bTF.PV(), 504);
            a(this.bTF, -4005, -42);
        }
        h.big().bhO();
        this.lxb = false;
        this.lyX = false;
        this.fLN.removeMessages(100);
    }

    public final int getDuration() {
        if (this.lyN != null) {
            return (int) this.lyN.getDuration();
        }
        return 0;
    }

    public final int getDownloadPercent() {
        if (this.lyN != null) {
            return this.lyN.getBufferedPercentage();
        }
        return 0;
    }

    public final boolean if(int i) {
        boolean z = false;
        int duration = getDuration();
        x.i("MicroMsg.Music.ExoMusicPlayer", "seekToMusic pos:%d, duration:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(duration)});
        if (duration < 0 || i > duration) {
            x.e("MicroMsg.Music.ExoMusicPlayer", "position is invalid, position:%d, duration:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(duration)});
            return false;
        } else if (this.lyN == null) {
            return true;
        } else {
            t(this.bTF.PV());
            f fVar = this.lyS;
            if ((this.lyS.lyZ[3] & -268435456) != 0) {
                z = true;
            }
            fVar.p(z, 100);
            this.lyM = 4;
            this.lyN.seekTo((long) i);
            return true;
        }
    }

    public final d bhq() {
        int i = 0;
        int duration = getDuration();
        int currentPosition = this.lyN != null ? (int) this.lyN.getCurrentPosition() : 0;
        boolean PY = PY();
        int downloadPercent = getDownloadPercent();
        if (downloadPercent < 0) {
            downloadPercent = 0;
        }
        if ((this.lyR instanceof com.google.android.exoplayer2.source.b.h) && !this.auM) {
            duration = 0;
        }
        if (this.lyL != null) {
            d dVar = this.lyL;
            if (PY) {
                i = 1;
            }
            dVar.j(duration, currentPosition, i, downloadPercent);
        } else {
            if (PY) {
                i = 1;
            }
            this.lyL = new d(duration, currentPosition, i, downloadPercent);
        }
        this.lyL.bTG = true;
        this.lyL.ebh = this.lzq;
        return this.lyL;
    }

    public final boolean bhp() {
        return true;
    }

    final void cX(int i, int i2) {
        x.i("MicroMsg.Music.ExoMusicPlayer", "notifyOnError what:%d, extra:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.lyW != null) {
            this.lyW.cZ(i, i2);
        }
    }

    final void cY(int i, int i2) {
        x.i("MicroMsg.Music.ExoMusicPlayer", "notifyOnInfo [" + i + "," + i2 + "]");
        if (this.lyW == null) {
            return;
        }
        if (i == 701 || i == 702) {
            this.lyW.tF(i2);
        }
    }

    public final void a(Metadata metadata) {
        x.i("MicroMsg.Music.ExoMusicPlayer", "onMetadata [");
        com.tencent.mm.plugin.music.b.b.a.a(metadata, "  ");
        x.i("MicroMsg.Music.ExoMusicPlayer", "]");
    }

    final String bij() {
        return com.tencent.mm.plugin.music.b.b.a.ee(SystemClock.elapsedRealtime() - this.aBL);
    }

    static void a(com.tencent.mm.an.a aVar, int i, int i2) {
        IDKey iDKey = new IDKey();
        iDKey.SetID(797);
        iDKey.SetKey(2);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(797);
        int i3 = aVar.field_musicType;
        x.i("MicroMsg.Music.ExoPlayIdkeyReport", "getExoMusicPlayerErrIdKeyByMusicType, musicType:" + i3);
        switch (i3) {
            case 0:
                i3 = 62;
                break;
            case 1:
                i3 = 63;
                break;
            case 4:
                i3 = 64;
                break;
            case 6:
                i3 = 65;
                break;
            case 7:
                i3 = 66;
                break;
            case 8:
                i3 = 67;
                break;
            case 9:
                i3 = 68;
                break;
            case 10:
                i3 = 69;
                break;
            case 11:
                i3 = 70;
                break;
            default:
                i3 = 71;
                break;
        }
        iDKey2.SetKey(i3);
        iDKey2.SetValue(1);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(797);
        x.i("MicroMsg.Music.ExoPlayIdkeyReport", "getExoMusicPlayerErrTypeIdKey, errType:" + i);
        switch (i) {
            case -4999:
                i3 = 9;
                break;
            case -4005:
                i3 = 8;
                break;
            case -4004:
                i3 = 7;
                break;
            case -4003:
                i3 = 6;
                break;
            case -4002:
                i3 = 5;
                break;
            case -4001:
                i3 = 4;
                break;
            case -4000:
                i3 = 3;
                break;
            default:
                i3 = 9;
                break;
        }
        iDKey3.SetKey(i3);
        iDKey3.SetValue(1);
        IDKey iDKey4 = new IDKey();
        iDKey4.SetID(797);
        x.i("MicroMsg.Music.ExoPlayIdkeyReport", "getExoMusicPlayerErrIdKey, errCode:" + i2);
        switch (i2) {
            case -43:
                i3 = 25;
                break;
            case -42:
                i3 = 24;
                break;
            case -41:
                i3 = 23;
                break;
            case -40:
                i3 = 22;
                break;
            case -30:
                i3 = 21;
                break;
            case -13:
                i3 = 20;
                break;
            case -12:
                i3 = 19;
                break;
            case -11:
                i3 = 18;
                break;
            case PayuSecureEncrypt$EncrptType.HASHED_PASSWORD /*-10*/:
                i3 = 17;
                break;
            case -3:
                i3 = 16;
                break;
            case -2:
                i3 = 15;
                break;
            case -1:
                i3 = 14;
                break;
            default:
                i3 = 14;
                break;
        }
        iDKey4.SetKey(i3);
        iDKey4.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        arrayList.add(iDKey3);
        arrayList.add(iDKey4);
        com.tencent.mm.plugin.report.service.h.mEJ.b(arrayList, true);
    }
}
