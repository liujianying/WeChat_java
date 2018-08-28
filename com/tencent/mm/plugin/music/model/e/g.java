package com.tencent.mm.plugin.music.model.e;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.an.d;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.music.c.a.b;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import java.net.URL;
import java.util.ArrayList;

public final class g extends a {
    int aBN = 0;
    AudioType audioType = AudioType.UNSUPPORT;
    protected com.tencent.mm.an.a bTF;
    int dGs = 0;
    public CommonPlayer lwZ;
    boolean lxb;
    private IMediaHTTPService lxe;
    String lxf = "";
    private long lxh = 0;
    private boolean lxi = false;
    private PlayerListenerCallback lxk = new 1(this);
    private d lyL;
    public boolean lyX = false;
    a lzT;

    private class a implements Runnable {
        boolean isStop;

        private a() {
            this.isStop = true;
        }

        /* synthetic */ a(g gVar, byte b) {
            this();
        }

        public final void run() {
            x.i("MicroMsg.Music.QQMusicPlayer", "start run play progress task");
            while (!this.isStop) {
                try {
                    if (g.this.lwZ != null && g.this.PY()) {
                        g.this.bhG();
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.Music.QQMusicPlayer", "PlayProgressTask run exception:" + e.getMessage());
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e2) {
                }
            }
        }
    }

    static /* synthetic */ void a(g gVar) {
        if (gVar.audioType != null) {
            x.i("MicroMsg.Music.QQMusicPlayer", "idKeyReportMusicMimeType audioType:%d, isStatMineType:%b", Integer.valueOf(gVar.audioType.getValue()), Boolean.valueOf(gVar.lxi));
            if (!gVar.lxi) {
                x.i("MicroMsg.Music.QQMusicPlayer", "idKeyReportMusicMimeType OK");
                gVar.lxi = true;
                IDKey iDKey = new IDKey();
                iDKey.SetID(558);
                int value = gVar.audioType.getValue();
                value = value == 2 ? 92 : value == 3 ? 93 : value == 4 ? 94 : value == 5 ? 95 : value == 6 ? 96 : value == 7 ? 97 : value == 8 ? 98 : value == 9 ? 99 : 100;
                iDKey.SetKey(value);
                iDKey.SetValue(1);
                ArrayList arrayList = new ArrayList();
                arrayList.add(iDKey);
                h.mEJ.b(arrayList, true);
                Object Il = e.Il(gVar.lxf);
                x.i("MicroMsg.Music.QQMusicPlayer", "mineTypeStr:%s", Il);
                if (gVar.bTF == null || TextUtils.isEmpty(Il)) {
                    x.e("MicroMsg.Music.QQMusicPlayer", "music is null or mineTypeStr is empty");
                    return;
                }
                int IB = d.IB(Il);
                h.mEJ.h(14486, Integer.valueOf(1), Integer.valueOf(gVar.bTF.field_musicType), Integer.valueOf(IB), Il);
            }
        }
    }

    public g() {
        bir();
        com.tencent.mm.plugin.music.b.a.a.biz();
    }

    public final void j(com.tencent.mm.an.a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.lxh;
        if (this.bTF != null && this.bTF.a(aVar) && j <= 3000) {
            this.bTF = aVar;
            x.e("MicroMsg.Music.QQMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", this.lxf, Long.valueOf(j));
        } else if (aVar == null) {
            x.e("MicroMsg.Music.QQMusicPlayer", "music is null");
        } else {
            URL url;
            f.a(aVar, false);
            this.lxh = currentTimeMillis;
            this.bTF = aVar;
            x.i("MicroMsg.Music.QQMusicPlayer", "startPlay, currentTime:%d, startTime:%d", Long.valueOf(currentTimeMillis), Integer.valueOf(aVar.field_startTime));
            if (this.lwZ != null && PY()) {
                this.lwZ.stop();
            }
            this.aBN = 0;
            this.dGs = aVar.field_startTime;
            this.audioType = null;
            this.lxi = false;
            x.i("MicroMsg.Music.QQMusicPlayer", "initPlayer");
            this.lxf = this.bTF.playUrl;
            x.i("MicroMsg.Music.QQMusicPlayer", "mSrc:%s", this.lxf);
            x.i("MicroMsg.Music.QQMusicPlayer", "field_songWifiUrl:%s", this.bTF.field_songWifiUrl);
            if (this.lxf != null) {
                e.Ii(this.lxf);
                e.bL(this.lxf, 0);
                e.bM(this.lxf, 0);
            }
            try {
                url = new URL(this.lxf);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "initPlayer", new Object[0]);
                x.e("MicroMsg.Music.QQMusicPlayer", "new URL exception:" + e.getMessage());
                url = null;
            }
            if (url == null) {
                x.e("MicroMsg.Music.QQMusicPlayer", "initPlayer url is null");
                a(this.bTF.PV(), 500);
                a(this.bTF, 500);
                return;
            }
            if (this.lwZ == null) {
                this.lwZ = new CommonPlayer(this.lxk);
            }
            this.lwZ.reset();
            if (this.lxe == null) {
                this.lxe = new b();
            }
            try {
                this.lwZ.setDataSource(this.lxe, Uri.parse(url.toString()));
                this.lwZ.prepare();
            } catch (Throwable e2) {
                x.e("MicroMsg.Music.QQMusicPlayer", "initPlayer exception:" + e2.getMessage());
                x.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e2, "initPlayer", new Object[0]);
                a(this.bTF.PV(), HardCoderJNI.SCENE_DB);
                a(this.bTF, HardCoderJNI.SCENE_DB);
            }
        }
    }

    public final void pause() {
        this.lyX = false;
        x.i("MicroMsg.Music.QQMusicPlayer", "pause");
        if (this.lwZ != null && PY()) {
            try {
                this.lwZ.pause();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "pause", new Object[0]);
                a(this.bTF.PV(), 503);
                a(this.bTF, 503);
            }
        }
    }

    public final void bhB() {
        x.i("MicroMsg.Music.QQMusicPlayer", "pauseAndAbandonFocus");
        pause();
        com.tencent.mm.plugin.music.model.h.big().bhO();
    }

    public final boolean bho() {
        return this.lxb && this.lyX;
    }

    public final void bhn() {
        this.lyX = true;
        x.i("MicroMsg.Music.QQMusicPlayer", "passivePause");
        if (this.lwZ != null && PY()) {
            try {
                this.lwZ.pause();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "passivePause", new Object[0]);
                a(this.bTF.PV(), 503);
                a(this.bTF, 503);
            }
        }
    }

    public final void resume() {
        this.aBN = 0;
        x.i("MicroMsg.Music.QQMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", Boolean.valueOf(bhC()), Boolean.valueOf(PY()));
        if (this.lwZ != null && !r0 && !r1) {
            if (com.tencent.mm.plugin.music.model.h.big().requestFocus()) {
                try {
                    this.lwZ.start();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "resume", new Object[0]);
                    a(this.bTF.PV(), 502);
                    a(this.bTF, 502);
                }
                p(com.tencent.mm.plugin.music.model.h.bic().bhS());
            } else {
                x.e("MicroMsg.Music.QQMusicPlayer", "request focus error");
            }
            this.lxb = true;
        }
    }

    public final boolean PY() {
        if (this.lwZ == null || this.lwZ.getPlayerState() != 4) {
            return false;
        }
        return true;
    }

    private boolean bhC() {
        if (this.lwZ == null || this.lwZ.getPlayerState() != 3) {
            return false;
        }
        return true;
    }

    public final boolean PZ() {
        return this.lxb && !bhC();
    }

    public final void stopPlay() {
        x.i("MicroMsg.Music.QQMusicPlayer", "stopPlay");
        try {
            if (this.lwZ != null) {
                this.lwZ.stop();
            }
            if (this.lzT != null) {
                this.lzT.isStop = true;
                this.lzT = null;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "stopPlay", new Object[0]);
            a(this.bTF.PV(), 504);
            a(this.bTF, 504);
        }
        com.tencent.mm.plugin.music.model.h.big().bhO();
        this.lxb = false;
        this.lyX = false;
    }

    public final int getDuration() {
        if (this.lwZ != null) {
            return this.lwZ.getDuration();
        }
        return -1;
    }

    public final boolean if(int i) {
        int duration = getDuration();
        x.i("MicroMsg.Music.QQMusicPlayer", "seekToMusic pos:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(duration));
        if (duration < 0 || i > duration) {
            x.e("MicroMsg.Music.QQMusicPlayer", "position is invalid, position:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(duration));
            stopPlay();
            return false;
        } else if (this.lwZ == null) {
            return true;
        } else {
            t(this.bTF.PV());
            this.lwZ.seekTo(i);
            return true;
        }
    }

    public final d bhq() {
        int bufferedPercentage;
        int i = 0;
        int duration = getDuration();
        int currentPosition = this.lwZ != null ? (int) this.lwZ.getCurrentPosition() : -1;
        boolean PY = PY();
        if (this.lwZ != null) {
            bufferedPercentage = this.lwZ.getBufferedPercentage();
        } else {
            bufferedPercentage = 0;
        }
        if (bufferedPercentage < 0 || bufferedPercentage > 100) {
            bufferedPercentage = 0;
        }
        if (bufferedPercentage < 0) {
            bufferedPercentage = 0;
        }
        if (this.lyL != null) {
            d dVar = this.lyL;
            if (PY) {
                i = 1;
            }
            dVar.j(duration, currentPosition, i, bufferedPercentage);
        } else {
            if (PY) {
                i = 1;
            }
            this.lyL = new d(duration, currentPosition, i, bufferedPercentage);
        }
        this.lyL.bTG = true;
        this.lyL.ebh = this.lzq;
        return this.lyL;
    }

    private void a(com.tencent.mm.an.a aVar, int i) {
        IDKey iDKey = new IDKey();
        iDKey.SetID(558);
        iDKey.SetKey(4);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(558);
        int i2 = aVar.field_musicType;
        x.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerErrIdKeyByMusicType, musicType:" + i2);
        switch (i2) {
            case 0:
                i2 = 49;
                break;
            case 1:
                i2 = 50;
                break;
            case 4:
                i2 = 51;
                break;
            case 5:
                i2 = 52;
                break;
            case 6:
                i2 = 53;
                break;
            case 7:
                i2 = 54;
                break;
            case 8:
                i2 = 55;
                break;
            case 9:
                i2 = 56;
                break;
            case 10:
                i2 = 7;
                break;
            case 11:
                i2 = 8;
                break;
            default:
                i2 = 9;
                break;
        }
        iDKey2.SetKey(i2);
        iDKey2.SetValue(1);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(558);
        iDKey3.SetKey(d.tG(i));
        iDKey3.SetValue(1);
        IDKey iDKey4 = new IDKey();
        iDKey4.SetID(558);
        iDKey4.SetValue(1);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        if (i == 80) {
            i2 = aVar.field_musicType;
            x.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerNetworkErrIdKeyByMusicType, musicType:" + i2);
            switch (i2) {
                case 0:
                    i2 = 167;
                    break;
                case 1:
                    i2 = 168;
                    break;
                case 4:
                    i2 = 169;
                    break;
                case 6:
                    i2 = 170;
                    break;
                case 7:
                    i2 = 171;
                    break;
                case 8:
                    i2 = 172;
                    break;
                case 9:
                    i2 = 173;
                    break;
                case 10:
                    i2 = 174;
                    break;
                case 11:
                    i2 = 175;
                    break;
                default:
                    i2 = 188;
                    break;
            }
            iDKey4.SetKey(i2);
            arrayList.add(iDKey4);
            i3 = 1;
            int Ip = e.Ip(this.lxf);
            i2 = e.Iq(this.lxf);
            if (e.Ip(this.lxf) == 403) {
                IDKey iDKey5 = new IDKey();
                iDKey5.SetID(558);
                iDKey5.SetValue(1);
                iDKey5.SetKey(d.tG(700));
                arrayList.add(iDKey5);
                i4 = Ip;
            } else {
                i4 = Ip;
            }
        } else if (e.Il(this.lxf) == null || !e.Il(this.lxf).contains("text/html")) {
            if (i != 70) {
                Object obj;
                switch (i) {
                    case 62:
                    case 63:
                    case 64:
                    case 67:
                    case 74:
                        obj = 1;
                        break;
                    default:
                        obj = null;
                        break;
                }
                if (obj != null) {
                    IDKey iDKey6 = new IDKey();
                    iDKey6.SetID(558);
                    iDKey6.SetValue(1);
                    i2 = aVar.field_musicType;
                    x.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerDecodeErrIdKeyByMusicType, musicType:" + i2);
                    switch (i2) {
                        case 0:
                            i2 = HardCoderJNI.SCENE_SEND_MSG;
                            break;
                        case 1:
                            i2 = HardCoderJNI.SCENE_SEND_PIC_MSG;
                            break;
                        case 4:
                            i2 = 204;
                            break;
                        case 6:
                            i2 = 205;
                            break;
                        case 7:
                            i2 = 206;
                            break;
                        case 8:
                            i2 = 207;
                            break;
                        case 9:
                            i2 = 208;
                            break;
                        case 10:
                            i2 = 209;
                            break;
                        case 11:
                            i2 = 210;
                            break;
                        default:
                            i2 = 188;
                            break;
                    }
                    iDKey6.SetKey(i2);
                    arrayList.add(iDKey6);
                }
                i2 = aVar.field_musicType;
                x.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerPlayErrIdKeyByMusicType, musicType:" + i2);
                switch (i2) {
                    case 0:
                        i2 = 178;
                        break;
                    case 1:
                        i2 = 179;
                        break;
                    case 4:
                        i2 = 180;
                        break;
                    case 6:
                        i2 = 181;
                        break;
                    case 7:
                        i2 = 182;
                        break;
                    case 8:
                        i2 = 183;
                        break;
                    case 9:
                        i2 = 184;
                        break;
                    case 10:
                        i2 = 185;
                        break;
                    case 11:
                        i2 = 186;
                        break;
                    default:
                        i2 = 188;
                        break;
                }
                iDKey4.SetKey(i2);
                arrayList.add(iDKey4);
            }
            i2 = 0;
        } else {
            i4 = HardCoderJNI.SCENE_SNS_SCROLL;
            IDKey iDKey7 = new IDKey();
            iDKey7.SetID(558);
            iDKey7.SetValue(1);
            iDKey7.SetKey(d.tG(HardCoderJNI.SCENE_SNS_SCROLL));
            arrayList.add(iDKey7);
            i2 = 0;
        }
        h.mEJ.h(14777, Integer.valueOf(1), Integer.valueOf(this.bTF.field_musicType), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i2));
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        arrayList.add(iDKey3);
        h.mEJ.b(arrayList, true);
    }

    public final void bhG() {
        com.tencent.mm.an.a bhR = com.tencent.mm.plugin.music.model.h.bic().bhR();
        if (bhR != null && bhR.a(this.bTF) && this.lwZ != null && PY()) {
            int currentPosition = (int) this.lwZ.getCurrentPosition();
            int duration = this.lwZ.getDuration();
            if (currentPosition > 0 && duration > 0 && this.lwX != null) {
                this.lwX.co(currentPosition, duration);
            }
        }
    }

    public final boolean bhp() {
        return true;
    }
}
