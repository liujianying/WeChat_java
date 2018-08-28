package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.basic.a.a;
import com.tencent.liteav.basic.log.TXCLog;

public class d {
    static d a = new d();
    private static final String b = ("AudioCenter:" + d.class.getSimpleName());
    private a c;
    private boolean d = false;
    private volatile boolean e = false;
    private Context f = null;
    private int g = TXEAudioDef.TXE_AUDIO_MODE_SPEAKER;
    private volatile boolean h = false;
    private int i = a.e;
    private int j = a.f;
    private int k = a.h;

    private d() {
    }

    public static d a() {
        return a;
    }

    public void b() {
        TXCLog.w(b, "mult-track-player start!");
        if (this.e) {
            TXCLog.e(b, "mult-track-player can not start because of has started!");
        } else if (this.i == 0 || this.j == 0) {
            TXCLog.e(b, "strat mult-track-player failed with invalid audio info , samplerate:" + this.i + ", channels:" + this.j);
        } else {
            this.e = true;
            if (this.c == null) {
                this.c = new 1(this, "AUDIO_TRACK");
                this.c.start();
            }
            TXCLog.w(b, "mult-track-player thread start finish!");
        }
    }

    public void c() {
        TXCLog.w(b, "mult-track-player stop!");
        if (this.e) {
            if (this.c != null) {
                this.c.b();
                this.c = null;
            }
            this.g = TXEAudioDef.TXE_AUDIO_MODE_SPEAKER;
            this.f = null;
            this.h = false;
            this.e = false;
            TXCLog.w(b, "mult-track-player stop finish!");
            return;
        }
        TXCLog.w(b, "mult-track-player can not stop because of not started yet!");
    }

    public synchronized void a(Context context, int i) {
        this.f = context;
        this.g = i;
        if (this.h) {
            com.tencent.liteav.audio.a.a(context, i);
        }
    }

    public boolean d() {
        return this.e;
    }
}
