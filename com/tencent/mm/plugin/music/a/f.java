package com.tencent.mm.plugin.music.a;

import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.g.a.t;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.music.a.e.1;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.a;
import com.tencent.mm.z.b;
import com.tencent.mm.z.c;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import java.net.URL;
import java.util.ArrayList;

public final class f extends e {
    int aBN;
    AudioType audioType;
    String bGW;
    protected a bGY;
    boolean dGA;
    int dGs;
    long dkh;
    ag giD;
    int isA;
    CommonPlayer lwZ;
    private c lxa;
    boolean lxb;
    boolean lxc;
    a lxd;
    private IMediaHTTPService lxe;
    String lxf;
    boolean lxg;
    private long lxh;
    boolean lxi;
    long lxj;
    private PlayerListenerCallback lxk;

    public f() {
        this.bGW = "";
        this.lxc = false;
        this.dGA = false;
        this.lxf = "";
        this.aBN = 0;
        this.isA = 0;
        this.dGs = 0;
        this.lxg = false;
        this.lxh = 0;
        this.audioType = AudioType.UNSUPPORT;
        this.lxi = false;
        this.lxj = 0;
        this.dkh = 0;
        this.lxk = new 1(this);
        this.bGW = b.Km();
        com.tencent.mm.plugin.music.b.a.a.biz();
        this.lwV = new ar();
        this.lwV.fN(ad.getContext());
        this.lwV.a(new 1(this));
        x.i("MicroMsg.Audio.QQAudioPlayer", "create QQAudioPlayer instance");
        this.giD = new ag(Looper.myLooper());
    }

    public final void Ih(String str) {
        x.i("MicroMsg.Audio.QQAudioPlayer", "setAudioId:%s", new Object[]{str});
        this.bGW = str;
    }

    public final void c(a aVar) {
        this.bGY = aVar;
        this.dGs = aVar.dGs;
        this.lxg = aVar.dGu;
        if (this.lwZ != null && PY()) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "audioId:%s, param.src:%s setVoume %f", new Object[]{this.bGW, this.lxf, Double.valueOf(this.bGY.dGx)});
            this.lwZ.setVolume((float) this.bGY.dGx, (float) this.bGY.dGx);
        }
    }

    public final void d(a aVar) {
        if (aVar == null) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "startPlay fail, play param is null");
            bhz();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.lxh;
        if (this.bGY == null || !this.bGY.a(aVar) || j > 100) {
            b.to(aVar.fromScene);
            this.lxh = currentTimeMillis;
            this.bGY = aVar;
            x.i("MicroMsg.Audio.QQAudioPlayer", "startPlay, fromScene:%d, audioId:%s", new Object[]{Integer.valueOf(this.bGY.fromScene), this.bGW});
            if (this.lwZ != null && PY()) {
                this.lwZ.stop();
            }
            this.aBN = 0;
            this.dGs = aVar.dGs;
            this.lxg = aVar.dGu;
            this.audioType = null;
            this.lxi = false;
            this.dGA = false;
            this.lxc = false;
            bhA();
            return;
        }
        this.bGY = aVar;
        this.dGs = aVar.dGs;
        this.lxg = aVar.dGu;
        x.e("MicroMsg.Audio.QQAudioPlayer", "startPlay, is playing for audio src:%s, don't play again in 3 second, interval:%d", new Object[]{this.lxf, Long.valueOf(j)});
    }

    private void bhA() {
        x.i("MicroMsg.Audio.QQAudioPlayer", "initPlayer");
        if (!TextUtils.isEmpty(this.bGY.filePath) && this.bGY.dGy == null) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "play with local file, filePath:%s", new Object[]{this.bGY.filePath});
            if (this.lwZ == null) {
                this.lwZ = new CommonPlayer(this.lxk);
            }
            this.lwZ.reset();
            try {
                this.lwZ.setDataSource(this.bGY.filePath);
                this.lwZ.prepare();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e, "initPlayer exception", new Object[0]);
                tp(501);
                tq(501);
            }
        } else if (TextUtils.isEmpty(this.bGY.filePath) || this.bGY.dGy == null) {
            boolean z;
            URL url;
            x.i("MicroMsg.Audio.QQAudioPlayer", "play with src url :%s", new Object[]{this.bGY.cfD});
            this.lxf = this.bGY.cfD;
            if (com.tencent.mm.plugin.music.d.b.IG(this.lxf)) {
                x.i("MicroMsg.Audio.QQAudioPlayer", "can match shake music wifi url");
                z = true;
            } else {
                z = false;
            }
            x.i("MicroMsg.Audio.QQAudioPlayer", "mSrc:%s", new Object[]{this.lxf});
            e.Ii(this.lxf);
            e.aH(this.lxf, z);
            try {
                url = new URL(this.lxf);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e2, "initPlayer", new Object[0]);
                url = null;
            }
            if (url == null) {
                x.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer url is null");
                tp(500);
                tq(500);
                return;
            }
            if (this.lwZ == null) {
                this.lwZ = new CommonPlayer(this.lxk);
            }
            this.lwZ.reset();
            if (this.lxe == null) {
                this.lxe = new com.tencent.mm.plugin.music.c.a.b();
            }
            try {
                this.lwZ.setDataSource(this.lxe, Uri.parse(url.toString()));
                this.lwZ.prepare();
            } catch (Throwable e22) {
                x.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + e22.getMessage());
                x.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e22, "initPlayer", new Object[0]);
                tp(501);
                tq(501);
            }
        } else {
            x.i("MicroMsg.Audio.QQAudioPlayer", "play with inputStream, filePath:%s", new Object[]{this.bGY.filePath});
            if (this.lwZ == null) {
                this.lwZ = new CommonPlayer(this.lxk);
            }
            this.lwZ.reset();
            try {
                this.lwZ.setDataSource(new com.tencent.mm.plugin.music.c.b(this.bGY.dGy));
                this.lwZ.prepare();
            } catch (Throwable e222) {
                x.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + e222.getMessage());
                x.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e222, "initPlayer", new Object[0]);
                tp(501);
                tq(501);
            }
        }
    }

    public final void pause() {
        x.i("MicroMsg.Audio.QQAudioPlayer", "pause, audioId:%s", new Object[]{this.bGW});
        this.lxc = true;
        if (this.lwZ != null && PY()) {
            try {
                x.i("MicroMsg.Audio.QQAudioPlayer", "pause success");
                this.lwZ.pause();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e, "pause", new Object[0]);
                tp(503);
                tq(503);
            }
        } else if (this.lwZ != null && isCompleted()) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "pause fail, play complete, set isStartPlaying false");
            this.lxb = false;
        }
    }

    public final void bhB() {
        x.i("MicroMsg.Audio.QQAudioPlayer", "pauseAndAbandonFocus");
        pause();
    }

    public final void resume() {
        this.aBN = 0;
        boolean bhC = bhC();
        boolean PY = PY();
        this.lxc = false;
        x.i("MicroMsg.Audio.QQAudioPlayer", "resume, isPreparing:%b, isPlayingMusic:%b, isStartPlaying:%b, audioId:%s", new Object[]{Boolean.valueOf(bhC), Boolean.valueOf(PY), Boolean.valueOf(this.lxb), this.bGW});
        if (this.lwZ != null && !isPrepared() && !bhC && !PY && !this.lxb) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "audio play is complete, need initPlayer again");
            this.dGs = 0;
            this.lxg = true;
            this.dGA = false;
            bhA();
            b.to(this.bGY.fromScene);
        } else if (this.lwZ == null) {
        } else {
            if ((isPaused() || isPrepared()) && !PY) {
                x.i("MicroMsg.Audio.QQAudioPlayer", "audio play is paused, need start to play");
                try {
                    this.lwZ.setVolume((float) this.bGY.dGx, (float) this.bGY.dGx);
                    this.lwZ.start();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e, "resume", new Object[0]);
                    tp(502);
                    tq(502);
                }
                this.lxb = true;
            }
        }
    }

    public final boolean PY() {
        if (this.lwZ == null || this.lwZ.getPlayerState() != 4) {
            return false;
        }
        return true;
    }

    public final boolean bhC() {
        if (this.lwZ == null || this.lwZ.getPlayerState() != 3) {
            return false;
        }
        return true;
    }

    public final boolean isPrepared() {
        if (this.lwZ == null || this.lwZ.getPlayerState() != 2) {
            return false;
        }
        return true;
    }

    public final boolean isPaused() {
        if (this.lwZ == null || this.lwZ.getPlayerState() != 5) {
            return false;
        }
        return true;
    }

    public final boolean isCompleted() {
        if (this.lwZ == null || this.lwZ.getPlayerState() != 7) {
            return false;
        }
        return true;
    }

    public final boolean isStopped() {
        if (this.lwZ == null || this.lwZ.getPlayerState() != 6) {
            return false;
        }
        return true;
    }

    public final boolean PZ() {
        return this.lxb && !bhC();
    }

    public final void stopPlay() {
        x.i("MicroMsg.Audio.QQAudioPlayer", "stopPlay");
        this.dGA = false;
        bhD();
    }

    final void bhD() {
        try {
            if (this.lwZ != null) {
                this.lwZ.setVolume(0.0f, 0.0f);
                this.lwZ.stop();
            }
            if (this.lxd != null) {
                this.lxd.isStop = true;
                this.lxd = null;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e, "stopPlay", new Object[0]);
            tp(504);
            tq(504);
        }
        this.lxb = false;
        this.lxc = true;
        this.dkh = System.currentTimeMillis();
    }

    public final int bhE() {
        if (this.lwZ != null) {
            return (int) this.lwZ.getCurrentPosition();
        }
        return -1;
    }

    public final int getDuration() {
        if (this.lwZ != null) {
            return this.lwZ.getDuration();
        }
        return -1;
    }

    public final boolean if(int i) {
        int duration = getDuration();
        x.i("MicroMsg.Audio.QQAudioPlayer", "seekToMusic pos:%d, duration:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(duration)});
        if (duration < 0) {
            x.e("MicroMsg.Audio.QQAudioPlayer", "position is invalid, position:%d, duration:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(duration)});
            stopPlay();
            return false;
        } else if (i > duration) {
            x.e("MicroMsg.Audio.QQAudioPlayer", "position is invalid, position:%d, duration:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(duration)});
            return false;
        } else {
            if (this.lwZ != null) {
                x.i("MicroMsg.Audio.BaseAudioPlayer", "onSeekingEvent");
                t tVar = new t();
                tVar.bHb.action = 10;
                tVar.bHb.state = "seeking";
                tVar.bHb.bGW = bhr();
                tVar.bHb.appId = getAppId();
                com.tencent.mm.sdk.b.a.sFg.a(tVar, Looper.getMainLooper());
                this.lwZ.seekTo(i);
            }
            return true;
        }
    }

    public final c bhF() {
        int bufferedPercentage;
        boolean z = false;
        if (this.lxa == null) {
            this.lxa = new c();
        }
        int duration = getDuration();
        int bhE = bhE();
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
        this.lxa.bGX = bhE;
        this.lxa.duration = duration;
        c cVar = this.lxa;
        if (!PY) {
            z = true;
        }
        cVar.dGz = z;
        this.lxa.dGA = this.dGA;
        this.lxa.dGB = (bufferedPercentage * duration) / 100;
        if (this.bGY == null) {
            return null;
        }
        this.lxa.dGs = this.bGY.dGt;
        this.lxa.dGC = this.bGY.cfD;
        return this.lxa;
    }

    public final String bhr() {
        return this.bGW;
    }

    public final String getAppId() {
        if (this.bGY != null) {
            return this.bGY.appId;
        }
        return "";
    }

    private void tq(int i) {
        IDKey iDKey = new IDKey();
        iDKey.SetID(688);
        iDKey.SetKey(1);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(688);
        int i2 = this.bGY.fromScene;
        x.d("MicroMsg.Audio.AudioPlayIdKeyReport", "getQQAudioPlayerErrSceneIdKey, scene:" + i2);
        switch (i2) {
        }
        iDKey2.SetKey(9);
        iDKey2.SetValue(1);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(688);
        x.i("MicroMsg.Audio.AudioPlayIdKeyReport", "getQQAudioPlayerErrIdKey, errCode:" + i);
        switch (i) {
            case s$l.AppCompatTheme_selectableItemBackgroundBorderless /*53*/:
                i2 = 17;
                break;
            case s$l.AppCompatTheme_borderlessButtonStyle /*54*/:
                i2 = 18;
                break;
            case s$l.AppCompatTheme_dividerVertical /*55*/:
                i2 = 19;
                break;
            case s$l.AppCompatTheme_editTextColor /*62*/:
                i2 = 20;
                break;
            case s$l.AppCompatTheme_editTextBackground /*63*/:
                i2 = 21;
                break;
            case s$l.AppCompatTheme_imageButtonStyle /*64*/:
                i2 = 22;
                break;
            case s$l.AppCompatTheme_textAppearanceSearchResultSubtitle /*66*/:
                i2 = 23;
                break;
            case s$l.AppCompatTheme_textColorSearchUrl /*67*/:
                i2 = 24;
                break;
            case s$l.AppCompatTheme_listPreferredItemHeight /*69*/:
                i2 = 25;
                break;
            case 70:
                i2 = 36;
                break;
            case s$l.AppCompatTheme_dropDownListViewStyle /*74*/:
                i2 = 26;
                break;
            case s$l.AppCompatTheme_panelMenuListTheme /*80*/:
                i2 = 27;
                break;
            case s$l.AppCompatTheme_buttonStyleSmall /*101*/:
                i2 = 28;
                break;
            case s$l.AppCompatTheme_checkboxStyle /*102*/:
                i2 = 29;
                break;
            case 500:
                i2 = 31;
                break;
            case 501:
                i2 = 32;
                break;
            case 502:
                i2 = 33;
                break;
            case 503:
                i2 = 34;
                break;
            case 504:
                i2 = 35;
                break;
            default:
                i2 = 30;
                break;
        }
        iDKey3.SetKey(i2);
        iDKey3.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        arrayList.add(iDKey3);
        h.mEJ.b(arrayList, true);
    }

    public final void release() {
        x.i("MicroMsg.Audio.QQAudioPlayer", "release");
        this.lwR = null;
        if (this.lwZ != null) {
            this.lwZ.release();
            this.lwZ = null;
        }
        if (this.lwV != null) {
            this.lwV.end();
            this.lwV.ciy();
        }
    }

    public final void bhG() {
        if (this.bGW.equalsIgnoreCase(this.bGY.bGW) && this.lwZ != null && PY()) {
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
