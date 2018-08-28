package com.google.android.exoplayer2;

import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.source.i;

public abstract class a implements r, s {
    private final int aci;
    public t acj;
    public i ack;
    public long acl;
    public boolean acm = true;
    public boolean acn;
    public int index;
    public int state;

    public a(int i) {
        this.aci = i;
    }

    public final int getTrackType() {
        return this.aci;
    }

    public final s ip() {
        return this;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public f iq() {
        return null;
    }

    public final int getState() {
        return this.state;
    }

    public final void a(t tVar, Format[] formatArr, i iVar, long j, boolean z, long j2) {
        com.google.android.exoplayer2.i.a.ap(this.state == 0);
        this.acj = tVar;
        this.state = 1;
        ae(z);
        a(formatArr, iVar, j2);
        b(j, z);
    }

    public final void start() {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        com.google.android.exoplayer2.i.a.ap(z);
        this.state = 2;
        onStarted();
    }

    public final void a(Format[] formatArr, i iVar, long j) {
        com.google.android.exoplayer2.i.a.ap(!this.acn);
        this.ack = iVar;
        this.acm = false;
        this.acl = j;
        a(formatArr, j);
    }

    public final i ir() {
        return this.ack;
    }

    public final boolean is() {
        return this.acm;
    }

    public final void it() {
        this.acn = true;
    }

    public final boolean iu() {
        return this.acn;
    }

    public final void iv() {
        this.ack.kC();
    }

    public final void m(long j) {
        this.acn = false;
        this.acm = false;
        b(j, false);
    }

    public final void stop() {
        com.google.android.exoplayer2.i.a.ap(this.state == 2);
        this.state = 1;
        onStopped();
    }

    public final void disable() {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        com.google.android.exoplayer2.i.a.ap(z);
        this.state = 0;
        this.ack = null;
        this.acn = false;
        ix();
    }

    public int iw() {
        return 0;
    }

    public void d(int i, Object obj) {
    }

    public void ae(boolean z) {
    }

    public void a(Format[] formatArr, long j) {
    }

    public void b(long j, boolean z) {
    }

    public void onStarted() {
    }

    public void onStopped() {
    }

    public void ix() {
    }

    public final int a(k kVar, e eVar, boolean z) {
        int b = this.ack.b(kVar, eVar, z);
        if (b == -4) {
            if (eVar.jy()) {
                this.acm = true;
                if (this.acn) {
                    return -4;
                }
                return -3;
            }
            eVar.aih += this.acl;
        } else if (b == -5) {
            Format format = kVar.aep;
            if (format.aek != Long.MAX_VALUE) {
                kVar.aep = format.u(format.aek + this.acl);
            }
        }
        return b;
    }
}
