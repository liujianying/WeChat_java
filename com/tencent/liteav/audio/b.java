package com.tencent.liteav.audio;

import android.content.Context;
import com.tencent.liteav.audio.impl.Play.TXAudioJitterBufferReportInfo;
import com.tencent.liteav.audio.impl.Play.TXCAudioBasePlayController;
import com.tencent.liteav.audio.impl.Play.d;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.audio.impl.a;
import com.tencent.liteav.audio.impl.c;
import com.tencent.liteav.audio.impl.e;
import com.tencent.liteav.basic.log.TXCLog;

public class b implements e {
    public static final int a = TXEAudioDef.TXE_AEC_NONE;
    public static float b = 5.0f;
    public static boolean c = true;
    public static float d = 5.0f;
    public static float e = 1.0f;
    public static boolean f = false;
    public static int g = 0;
    private static final String h = ("AudioCenter:" + b.class.getSimpleName());
    private TXCAudioBasePlayController i = null;
    private d j;
    private int k = a;
    private float l = b;
    private boolean m = c;
    private float n = d;
    private float o = e;
    private boolean p = false;
    private boolean q = false;
    private boolean r = f;
    private int s = g;
    private Context t;

    public synchronized int a(Context context) {
        int i;
        if (context == null) {
            TXCLog.e(h, "invalid param, start play failed!");
            i = TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
        } else {
            if (a.c(this.k) != TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK) {
                TXCLog.w(h, "start player failed, with aec type " + this.k + ", invalid aec recorder has started!");
            }
            if (this.i == null || !this.i.isPlaying()) {
                this.t = context;
                c.a().a(this.t);
                c.a().a(this);
                if (this.i == null) {
                    if (this.k == TXEAudioDef.TXE_AEC_TRAE) {
                        this.i = new com.tencent.liteav.audio.impl.Play.c(context.getApplicationContext());
                    } else {
                        this.i = new com.tencent.liteav.audio.impl.Play.b(context.getApplicationContext());
                    }
                }
                if (this.i != null) {
                    a(this.k, this.t);
                    a(this.j);
                    a(this.l);
                    a(this.m);
                    b(this.n);
                    c(this.o);
                    c(this.p);
                    b(this.q);
                    d(this.r);
                    a(this.s);
                    i = this.i.startPlay();
                } else {
                    TXCLog.e(h, "start play failed! controller is null!");
                    i = TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
                }
            } else {
                TXCLog.e(h, "play has started, can not start again!");
                i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_REPEAT_OPTION;
            }
        }
        return i;
    }

    public synchronized int a() {
        int i;
        i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
        this.j = null;
        this.l = b;
        this.m = c;
        this.n = d;
        this.o = e;
        this.p = false;
        this.q = false;
        this.r = f;
        this.t = null;
        if (this.i != null) {
            i = this.i.stopPlay();
            this.i = null;
        }
        c.a().b(this);
        return i;
    }

    public void a(boolean z, Context context) {
        if (!z) {
            a(TXEAudioDef.TXE_AEC_NONE, context);
        } else if (com.tencent.liteav.basic.e.b.a().g()) {
            a(TXEAudioDef.TXE_AEC_SYSTEM, context);
        } else {
            a.a(com.tencent.liteav.basic.e.b.a().b());
            a(TXEAudioDef.TXE_AEC_TRAE, context);
        }
    }

    private void a(int i, Context context) {
        if (i != TXEAudioDef.TXE_AEC_TRAE || TXCTraeJNI.nativeCheckTraeEngine(context)) {
            TXCLog.i(h, "set aec type to " + i + ", cur type " + this.k);
            this.k = i;
            return;
        }
        TXCLog.e(h, "set aec type failed, check trae library failed!!");
    }

    public synchronized int a(com.tencent.liteav.basic.f.a aVar) {
        int i;
        if (this.i == null) {
            TXCLog.e(h, "play audio failed, controller not created yet!");
            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE;
        } else {
            i = this.i.playData(aVar);
        }
        return i;
    }

    public void a(d dVar) {
        this.j = dVar;
        if (this.i != null) {
            this.i.setListener(dVar);
        }
    }

    public void a(float f) {
        this.l = f;
        if (this.i != null) {
            this.i.setCacheTime(f);
        }
    }

    public void a(boolean z) {
        this.m = z;
        if (this.i != null) {
            this.i.enableAutojustCache(z);
        }
    }

    public void b(float f) {
        this.n = f;
        if (this.i != null) {
            this.i.setAutoAdjustMaxCache(f);
        }
    }

    public void c(float f) {
        this.o = f;
        if (this.i != null) {
            this.i.setAutoAdjustMinCache(f);
        }
    }

    public synchronized long b() {
        long cacheDuration;
        if (this.i != null) {
            cacheDuration = this.i.getCacheDuration();
        } else {
            cacheDuration = 0;
        }
        return cacheDuration;
    }

    public synchronized long c() {
        long curPts;
        if (this.i != null) {
            curPts = this.i.getCurPts();
        } else {
            curPts = 0;
        }
        return curPts;
    }

    public synchronized int d() {
        int recvJitter;
        if (this.i != null) {
            recvJitter = this.i.getRecvJitter();
        } else {
            recvJitter = 0;
        }
        return recvJitter;
    }

    public synchronized long e() {
        long curRecvTS;
        if (this.i != null) {
            curRecvTS = this.i.getCurRecvTS();
        } else {
            curRecvTS = 0;
        }
        return curRecvTS;
    }

    public synchronized float f() {
        float cacheThreshold;
        if (this.i != null) {
            cacheThreshold = this.i.getCacheThreshold();
        } else {
            cacheThreshold = 0.0f;
        }
        return cacheThreshold;
    }

    public void b(boolean z) {
        this.q = z;
        if (this.i != null) {
            this.i.enableHWAcceleration(z);
        }
    }

    public void c(boolean z) {
        this.p = z;
        if (this.i != null) {
            this.i.enableRealTimePlay(z);
        }
    }

    public void d(boolean z) {
        this.r = z;
        if (this.i != null) {
            this.i.setMute(z);
        }
    }

    public void a(int i) {
        this.s = i;
        if (this.i != null) {
            this.i.enableSmootheMode(i);
        }
    }

    public static void a(Context context, int i) {
        TXCAudioBasePlayController.setAudioMode(context, i);
    }

    public int g() {
        if (d.a().d()) {
            if (this.k != TXEAudioDef.TXE_AEC_TRAE) {
                return this.k;
            }
            TXCLog.e(h, "audio track has start, but aec type is trae!!" + this.k);
            return TXEAudioDef.TXE_AEC_NONE;
        } else if (!TXCTraeJNI.nativeTraeIsPlaying()) {
            return TXEAudioDef.TXE_AEC_NONE;
        } else {
            if (this.k == TXEAudioDef.TXE_AEC_TRAE) {
                return this.k;
            }
            TXCLog.e(h, "trae engine has start, but aec type is not trae!!" + this.k);
            return TXEAudioDef.TXE_AEC_TRAE;
        }
    }

    public TXAudioJitterBufferReportInfo h() {
        if (this.i != null) {
            return this.i.getReportInfo();
        }
        return null;
    }

    public void b(int i) {
        switch (i) {
            case 0:
                if (this.i != null) {
                    this.i.setMute(this.r);
                    return;
                }
                return;
            case 1:
                if (this.i != null) {
                    this.i.setMute(true);
                    return;
                }
                return;
            case 2:
                if (this.i != null) {
                    this.i.setMute(true);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
