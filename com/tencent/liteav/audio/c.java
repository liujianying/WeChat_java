package com.tencent.liteav.audio;

import android.content.Context;
import com.tencent.liteav.audio.impl.Record.TXCAudioSysRecordController;
import com.tencent.liteav.audio.impl.Record.f;
import com.tencent.liteav.audio.impl.Record.g;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.audio.impl.e;
import com.tencent.liteav.basic.a.a;
import com.tencent.liteav.basic.e.b;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;

public class c implements e {
    public static final int a = a.e;
    public static final int b = a.f;
    public static final int c = a.h;
    public static final int d = TXEAudioDef.TXE_REVERB_TYPE_0;
    public static final int e = TXEAudioDef.TXE_AEC_NONE;
    public static final int f = TXEAudioDef.TXE_AUDIO_TYPE_AAC;
    static c g = new c();
    private static final String h = ("AudioCenter:" + c.class.getSimpleName());
    private WeakReference<e> i;
    private int j = a;
    private int k = b;
    private int l = a.h;
    private int m = d;
    private boolean n = false;
    private int o = e;
    private boolean p = false;
    private boolean q = false;
    private Context r;
    private float s = 1.0f;
    private int t = -1;
    private int u = -1;
    private com.tencent.liteav.audio.impl.Record.c v = null;

    private c() {
    }

    public static c a() {
        return g;
    }

    public int a(Context context) {
        if (context == null) {
            TXCLog.e(h, "invalid param, start record failed!");
            return TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
        }
        this.r = context.getApplicationContext();
        com.tencent.liteav.audio.impl.c.a().a(this.r);
        com.tencent.liteav.audio.impl.c.a().a(this);
        if (com.tencent.liteav.audio.impl.a.b(this.o) != TXEAudioDef.TXE_AUDIO_RECORD_ERR_OK) {
            TXCLog.w(h, "start recorder failed, with aec type " + this.o + ", invalid aec player has started!");
        }
        if (this.v == null || !this.v.isRecording()) {
            if (this.v == null) {
                if (this.o == TXEAudioDef.TXE_AEC_TRAE) {
                    this.v = new g();
                } else {
                    this.v = new TXCAudioSysRecordController();
                }
            }
            if (this.v != null) {
                g();
                return this.v.startRecord(this.r);
            }
            TXCLog.e(h, "start Record failed! controller is null!");
            return TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
        }
        TXCLog.e(h, "record has started, can not start again!");
        return TXEAudioDef.TXE_AUDIO_RECORD_ERR_REPEAT_OPTION;
    }

    public int b() {
        int i = TXEAudioDef.TXE_AUDIO_RECORD_ERR_OK;
        if (this.v != null) {
            i = this.v.stopRecord();
            this.v = null;
        }
        this.i = null;
        this.j = a;
        this.k = b;
        this.l = a.h;
        this.m = d;
        this.n = false;
        this.o = e;
        this.p = false;
        this.q = false;
        this.r = null;
        this.s = 1.0f;
        this.t = -1;
        this.u = -1;
        g();
        com.tencent.liteav.audio.impl.c.a().b(this);
        return i;
    }

    public boolean c() {
        if (this.v != null) {
            return this.v.isRecording();
        }
        return false;
    }

    public void a(boolean z) {
        this.q = z;
        if (this.v != null) {
            this.v.setIsCustomRecord(z);
        }
    }

    public void a(e eVar) {
        this.i = new WeakReference(eVar);
        if (this.v != null) {
            this.v.setListener(eVar);
        }
    }

    public int d() {
        return this.k;
    }

    public int e() {
        return this.j;
    }

    public void a(int i) {
        TXCLog.i(h, "setSampleRate: " + i);
        this.j = i;
        if (this.v != null) {
            this.v.setSamplerate(i);
        }
    }

    public void c(int i) {
        TXCLog.i(h, "setChannels: " + i);
        this.k = i;
        if (this.v != null) {
            this.v.setChannels(i);
        }
    }

    public void d(int i) {
        TXCLog.i(h, "setReverbType: " + i);
        this.m = i;
        if (this.v != null) {
            this.v.setReverbType(i);
        }
    }

    public void a(boolean z, Context context) {
        if (!z) {
            a(TXEAudioDef.TXE_AEC_NONE, context);
        } else if (b.a().g()) {
            a(TXEAudioDef.TXE_AEC_SYSTEM, context);
        } else {
            a.a(b.a().b());
            a(TXEAudioDef.TXE_AEC_TRAE, context);
        }
    }

    private void a(int i, Context context) {
        if (i != TXEAudioDef.TXE_AEC_TRAE || TXCTraeJNI.nativeCheckTraeEngine(context)) {
            if (this.o != i) {
                if (this.v != null && this.v.isRecording()) {
                    this.v.stopRecord();
                    this.v = null;
                    this.o = i;
                    a(this.r);
                }
                this.o = i;
            }
            if (this.v != null) {
                this.v.setAECType(i);
                return;
            }
            return;
        }
        TXCLog.e(h, "set aec type failed, check trae library failed!!");
    }

    public void b(boolean z) {
    }

    public void c(boolean z) {
        TXCLog.i(h, "setMute: " + z);
        this.n = z;
        if (this.v != null) {
            this.v.setMute(z);
        }
    }

    public void a(float f) {
        TXCLog.i(h, "setVolume: " + f);
        this.s = f;
        if (this.v != null) {
            this.v.setVolume(f);
        }
    }

    public void a(int i, int i2) {
        TXCLog.i(h, "setChangerType: " + i + " " + i2);
        this.t = i;
        this.u = i2;
        if (this.v != null) {
            this.v.setChangerType(i, i2);
        }
    }

    public void a(byte[] bArr) {
        if (this.v != null) {
            this.v.sendCustomPCMData(bArr);
        }
    }

    public int f() {
        if (f.a().c()) {
            if (this.o != TXEAudioDef.TXE_AEC_TRAE) {
                return this.o;
            }
            TXCLog.e(h, "audio mic has start, but aec type is trae!!" + this.o);
            return TXEAudioDef.TXE_AEC_NONE;
        } else if (!TXCTraeJNI.nativeTraeIsRecording()) {
            return TXEAudioDef.TXE_AEC_NONE;
        } else {
            if (this.o == TXEAudioDef.TXE_AEC_TRAE) {
                return this.o;
            }
            TXCLog.e(h, "trae engine has start, but aec type is not trae!!" + this.o);
            return TXEAudioDef.TXE_AEC_TRAE;
        }
    }

    private void g() {
        if (this.i != null) {
            a((e) this.i.get());
        }
        a(this.q);
        a(this.j);
        c(this.k);
        d(this.m);
        a(this.o, this.r);
        b(this.p);
        c(this.n);
        a(this.s);
        a(this.t, this.u);
    }

    public void b(int i) {
        switch (i) {
            case 0:
                if (this.v != null) {
                    this.v.setMute(this.n);
                    return;
                }
                return;
            case 1:
                if (this.v != null) {
                    this.v.setMute(true);
                    return;
                }
                return;
            case 2:
                if (this.v != null) {
                    this.v.setMute(true);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
