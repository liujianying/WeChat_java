package com.tencent.mm.plugin.voip.model;

import android.os.Process;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements Runnable {
    final /* synthetic */ b oHI;

    b$1(b bVar) {
        this.oHI = bVar;
    }

    public final void run() {
        Process.setThreadPriority(-19);
        x.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter  to start....");
        int i = 0;
        while (this.oHI.oGX && this.oHI.aga != null) {
            int playbackHeadPosition;
            int m;
            try {
                playbackHeadPosition = this.oHI.aga.getPlaybackHeadPosition();
            } catch (Exception e) {
                x.w("MicroMsg.Voip.AudioPlayer", "getPlaybackHeadPosition: ", new Object[]{e});
                b.i(this.oHI);
                playbackHeadPosition = 0;
            }
            long currentTimeMillis = System.currentTimeMillis();
            b.d(this.oHI, b.j(this.oHI) - playbackHeadPosition);
            if (b.k(this.oHI) == 1) {
                b.e(this.oHI, playbackHeadPosition);
                b.a(this.oHI, currentTimeMillis);
                b.b(this.oHI, currentTimeMillis);
                b.l(this.oHI);
                b.c(this.oHI, currentTimeMillis);
            } else {
                m = playbackHeadPosition - b.m(this.oHI);
                if (m > b.n(this.oHI)) {
                    b.f(this.oHI, m);
                } else {
                    b.f(this.oHI, (int) (((((float) b.n(this.oHI)) * 49999.0f) / 50000.0f) + (((float) m) / 50000.0f)));
                }
                b.c(this.oHI, currentTimeMillis);
                if (b.o(this.oHI) == 0) {
                    b.g(this.oHI, b.p(this.oHI) + b.q(this.oHI));
                } else if (currentTimeMillis > b.r(this.oHI) + 5000) {
                    b.b(this.oHI, currentTimeMillis);
                    if (b.n(this.oHI) < (b.p(this.oHI) >> 1)) {
                        b.g(this.oHI, b.p(this.oHI) - (b.q(this.oHI) >> 2));
                    }
                    if (b.n(this.oHI) > b.p(this.oHI)) {
                        b.g(this.oHI, b.n(this.oHI));
                    }
                }
                if (b.p(this.oHI) < b.s(this.oHI)) {
                    b.g(this.oHI, b.s(this.oHI));
                }
                if (b.p(this.oHI) < b.q(this.oHI)) {
                    b.g(this.oHI, b.q(this.oHI));
                }
                if (m > 0) {
                    b.e(this.oHI, playbackHeadPosition);
                }
            }
            if (playbackHeadPosition != 0 && this.oHI.oGZ) {
                b.t(this.oHI);
            }
            if (this.oHI.oHi != null) {
                b.h(this.oHI, b.u(this.oHI) + this.oHI.eps);
                if (b.a(this.oHI) == 0) {
                    playbackHeadPosition = this.oHI.oHi.P(b.v(this.oHI), this.oHI.eps);
                } else {
                    System.currentTimeMillis();
                    if (b.b(this.oHI) >= this.oHI.eps) {
                        synchronized (b.f(this.oHI)) {
                            System.arraycopy(b.g(this.oHI), 0, b.v(this.oHI), 0, this.oHI.eps);
                            m = b.b(this.oHI) - this.oHI.eps;
                            System.arraycopy(b.g(this.oHI), this.oHI.eps, b.w(this.oHI), 0, m);
                            System.arraycopy(b.w(this.oHI), 0, b.g(this.oHI), 0, m);
                            b.b(this.oHI, b.b(this.oHI) - this.oHI.eps);
                        }
                        playbackHeadPosition = 0;
                    } else if (b.o(this.oHI) >= (b.x(this.oHI) * 5) / 1000 || b.y(this.oHI) != 0) {
                        a.yP(2);
                    } else {
                        b.i(this.oHI, 1);
                        playbackHeadPosition = this.oHI.oHi.P(b.v(this.oHI), this.oHI.eps);
                        b.i(this.oHI, 0);
                    }
                }
                if (playbackHeadPosition < 0) {
                    a.yP(5);
                    x.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :" + playbackHeadPosition);
                } else if (b.z(this.oHI)) {
                    x.d("MicroMsg.Voip.AudioPlayer", "isSwitching " + b.z(this.oHI));
                    a.yP(10);
                } else {
                    b.a(this.oHI, currentTimeMillis);
                    if (b.A(this.oHI) < this.oHI.eps) {
                        System.arraycopy(b.v(this.oHI), 0, b.B(this.oHI), i, b.A(this.oHI) - i);
                        playbackHeadPosition = this.oHI.aga.write(b.B(this.oHI), 0, b.B(this.oHI).length);
                        if (playbackHeadPosition < 0) {
                            b.j(this.oHI, playbackHeadPosition);
                            x.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :" + playbackHeadPosition);
                        }
                        b.k(this.oHI, b.j(this.oHI) + (b.B(this.oHI).length >> 1));
                        playbackHeadPosition = b.A(this.oHI) - i;
                        i = this.oHI.eps - playbackHeadPosition;
                        while (i >= b.A(this.oHI)) {
                            this.oHI.aga.write(b.v(this.oHI), playbackHeadPosition, b.A(this.oHI));
                            playbackHeadPosition += b.A(this.oHI);
                            i -= b.A(this.oHI);
                            b.k(this.oHI, b.j(this.oHI) + (b.A(this.oHI) >> 1));
                        }
                        System.arraycopy(b.v(this.oHI), playbackHeadPosition, b.B(this.oHI), 0, i);
                    } else if (!b.z(this.oHI)) {
                        playbackHeadPosition = this.oHI.aga.write(b.v(this.oHI), 0, this.oHI.eps);
                        if (playbackHeadPosition < 0) {
                            b.j(this.oHI, playbackHeadPosition);
                            x.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :" + playbackHeadPosition);
                        }
                        b.k(this.oHI, b.j(this.oHI) + (this.oHI.eps >> 1));
                    }
                }
            } else {
                a.yP(10);
            }
        }
    }
}
