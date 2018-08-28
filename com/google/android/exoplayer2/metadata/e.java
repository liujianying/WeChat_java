package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.k;
import java.util.Arrays;

public final class e extends com.google.android.exoplayer2.a implements Callback {
    private boolean apY;
    private final k apy;
    private a aqA;
    private final c aqs;
    private final a aqt;
    private final Handler aqu;
    private final d aqv;
    private final Metadata[] aqw;
    private final long[] aqx;
    private int aqy;
    private int aqz;

    public interface a {
        void a(Metadata metadata);
    }

    public e(a aVar, Looper looper) {
        this(aVar, looper, c.aqr);
    }

    private e(a aVar, Looper looper, c cVar) {
        super(4);
        this.aqt = (a) com.google.android.exoplayer2.i.a.Z(aVar);
        this.aqu = looper == null ? null : new Handler(looper, this);
        this.aqs = (c) com.google.android.exoplayer2.i.a.Z(cVar);
        this.apy = new k();
        this.aqv = new d();
        this.aqw = new Metadata[5];
        this.aqx = new long[5];
    }

    public final int b(Format format) {
        return this.aqs.g(format) ? 4 : 0;
    }

    protected final void a(Format[] formatArr, long j) {
        this.aqA = this.aqs.h(formatArr[0]);
    }

    protected final void b(long j, boolean z) {
        kt();
        this.apY = false;
    }

    public final void c(long j, long j2) {
        if (!this.apY && this.aqz < 5) {
            this.aqv.clear();
            if (a(this.apy, this.aqv, false) == -4) {
                if (this.aqv.jy()) {
                    this.apY = true;
                } else if (!this.aqv.jx()) {
                    this.aqv.aek = this.apy.aep.aek;
                    this.aqv.jE();
                    try {
                        int i = (this.aqy + this.aqz) % 5;
                        this.aqw[i] = this.aqA.a(this.aqv);
                        this.aqx[i] = this.aqv.aih;
                        this.aqz++;
                    } catch (b e) {
                        throw com.google.android.exoplayer2.e.a(e, this.index);
                    }
                }
            }
        }
        if (this.aqz > 0 && this.aqx[this.aqy] <= j) {
            Metadata metadata = this.aqw[this.aqy];
            if (this.aqu != null) {
                this.aqu.obtainMessage(0, metadata).sendToTarget();
            } else {
                b(metadata);
            }
            this.aqw[this.aqy] = null;
            this.aqy = (this.aqy + 1) % 5;
            this.aqz--;
        }
    }

    protected final void ix() {
        kt();
        this.aqA = null;
    }

    public final boolean iT() {
        return this.apY;
    }

    public final boolean hv() {
        return true;
    }

    private void kt() {
        Arrays.fill(this.aqw, null);
        this.aqy = 0;
        this.aqz = 0;
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                b((Metadata) message.obj);
                return true;
            default:
                throw new IllegalStateException();
        }
    }

    private void b(Metadata metadata) {
        this.aqt.a(metadata);
    }
}
