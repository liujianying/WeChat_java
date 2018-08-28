package com.google.android.exoplayer2.f;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.a;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.k;
import java.util.Collections;
import java.util.List;

public final class j extends a implements Callback {
    private boolean apY;
    private boolean apZ;
    private final k apy;
    private final Handler aqu;
    private final a awe;
    private final g awf;
    private int awg;
    private Format awh;
    private e awi;
    private h awj;
    private i awk;
    private i awl;
    private int awm;

    public j(a aVar, Looper looper) {
        this(aVar, looper, g.awc);
    }

    private j(a aVar, Looper looper, g gVar) {
        super(3);
        this.awe = (a) com.google.android.exoplayer2.i.a.Z(aVar);
        this.aqu = looper == null ? null : new Handler(looper, this);
        this.awf = gVar;
        this.apy = new k();
    }

    public final int b(Format format) {
        if (this.awf.g(format)) {
            return 4;
        }
        return g.av(format.adW) ? 1 : 0;
    }

    protected final void a(Format[] formatArr, long j) {
        this.awh = formatArr[0];
        if (this.awi != null) {
            this.awg = 1;
        } else {
            this.awi = this.awf.k(this.awh);
        }
    }

    protected final void b(long j, boolean z) {
        o(Collections.emptyList());
        this.apY = false;
        this.apZ = false;
        if (this.awg != 0) {
            lm();
            return;
        }
        lk();
        this.awi.flush();
    }

    public final void c(long j, long j2) {
        if (!this.apZ) {
            if (this.awl == null) {
                this.awi.O(j);
                try {
                    this.awl = (i) this.awi.jB();
                } catch (f e) {
                    throw e.a(e, this.index);
                }
            }
            if (this.state == 2) {
                boolean z;
                if (this.awk != null) {
                    long ln = ln();
                    z = false;
                    while (ln <= j) {
                        this.awm++;
                        ln = ln();
                        z = true;
                    }
                } else {
                    z = false;
                }
                if (this.awl != null) {
                    if (this.awl.jy()) {
                        if (!z && ln() == Long.MAX_VALUE) {
                            if (this.awg == 2) {
                                lm();
                            } else {
                                lk();
                                this.apZ = true;
                            }
                        }
                    } else if (this.awl.aih <= j) {
                        if (this.awk != null) {
                            this.awk.release();
                        }
                        this.awk = this.awl;
                        this.awl = null;
                        this.awm = this.awk.P(j);
                        z = true;
                    }
                }
                if (z) {
                    o(this.awk.Q(j));
                }
                if (this.awg != 2) {
                    while (!this.apY) {
                        try {
                            if (this.awj == null) {
                                this.awj = (h) this.awi.jA();
                                if (this.awj == null) {
                                    return;
                                }
                            }
                            if (this.awg == 1) {
                                this.awj.flags = 4;
                                this.awi.W(this.awj);
                                this.awj = null;
                                this.awg = 2;
                                return;
                            }
                            int a = a(this.apy, (com.google.android.exoplayer2.b.e) this.awj, false);
                            if (a == -4) {
                                if (this.awj.jy()) {
                                    this.apY = true;
                                } else {
                                    this.awj.aek = this.apy.aep.aek;
                                    this.awj.jE();
                                }
                                this.awi.W(this.awj);
                                this.awj = null;
                            } else if (a == -3) {
                                return;
                            }
                        } catch (f e2) {
                            throw e.a(e2, this.index);
                        }
                    }
                }
            }
        }
    }

    protected final void ix() {
        this.awh = null;
        o(Collections.emptyList());
        ll();
    }

    public final boolean iT() {
        return this.apZ;
    }

    public final boolean hv() {
        return true;
    }

    private void lk() {
        this.awj = null;
        this.awm = -1;
        if (this.awk != null) {
            this.awk.release();
            this.awk = null;
        }
        if (this.awl != null) {
            this.awl.release();
            this.awl = null;
        }
    }

    private void ll() {
        lk();
        this.awi.release();
        this.awi = null;
        this.awg = 0;
    }

    private void lm() {
        ll();
        this.awi = this.awf.k(this.awh);
    }

    private long ln() {
        if (this.awm == -1 || this.awm >= this.awk.lj()) {
            return Long.MAX_VALUE;
        }
        return this.awk.cM(this.awm);
    }

    private void o(List<a> list) {
        if (this.aqu != null) {
            this.aqu.obtainMessage(0, list).sendToTarget();
        } else {
            p(list);
        }
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                p((List) message.obj);
                return true;
            default:
                throw new IllegalStateException();
        }
    }

    private void p(List<a> list) {
        this.awe.k(list);
    }
}
