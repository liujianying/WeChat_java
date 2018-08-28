package com.tencent.mm.plugin.multitalk.a;

import android.os.SystemClock;
import com.tencent.mm.compatible.b.f.a;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class b implements a, HeadsetPlugReceiver.a {
    boolean bTv = false;
    com.tencent.mm.compatible.util.b epT = new com.tencent.mm.compatible.util.b(ad.getContext());
    com.tencent.mm.plugin.voip.model.b kpV = null;
    private final Object kpW = new Object();
    HeadsetPlugReceiver kqe = new HeadsetPlugReceiver();
    private boolean kqi = false;
    private boolean kqj = false;
    final Object lsX = new Object();
    private int lsY;
    g.a lsZ = new g.a();

    public final int a(com.tencent.mm.plugin.voip.model.a aVar, int i, int i2) {
        int i3;
        synchronized (this.lsX) {
            if (this.bTv) {
                x.d("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay, already start");
                i3 = -1;
            } else {
                x.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay %s", new Object[]{Integer.valueOf(hashCode())});
                if (this.kpV == null) {
                    this.kpV = new com.tencent.mm.plugin.voip.model.b();
                    this.kpV.X(i, i2, 0);
                }
                this.kpV.r(ad.getContext(), false);
                this.kpV.oHi = aVar;
                au.HV().a(this);
                this.kqj = au.HV().yK();
                this.kqi = au.HV().yE();
                x.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b %s", new Object[]{Boolean.valueOf(this.kqj), Boolean.valueOf(this.kqi), Integer.valueOf(hashCode())});
                x.i("MicroMsg.MT.MultiTalkAudioPlayer", "set start play");
                this.bTv = true;
                this.lsZ.dgA = SystemClock.elapsedRealtime();
                i3 = this.kpV.bJt();
                x.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlaying cost: " + this.lsZ.Ad());
                this.epT.requestFocus();
                this.kqe.a(ad.getContext(), this);
                if (this.kqj || this.kqi) {
                    o.bgN().gF(false);
                    if (this.kqi) {
                        au.HV().yB();
                    }
                }
                x.i("MicroMsg.MT.MultiTalkAudioPlayer", "finish start play: %s", new Object[]{Integer.valueOf(i3)});
            }
        }
        return i3;
    }

    public final void fT(boolean z) {
        x.i("MicroMsg.MT.MultiTalkAudioPlayer", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", new Object[]{Boolean.valueOf(z)});
        au.HV().aY(z);
        if (this.kpV != null && this.kpV.oGX) {
            this.kpV.iJ(z);
        }
    }

    public final void fV(boolean z) {
        boolean z2 = false;
        if (this.kqj != z) {
            this.kqj = z;
            x.i("MicroMsg.MT.MultiTalkAudioPlayer", "onHeadsetState: isHeadsetPlugged: %s, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s", new Object[]{Boolean.valueOf(this.kqj), Boolean.valueOf(o.bgN().ltn), Boolean.valueOf(o.bgN().lto), Boolean.valueOf(o.bgN().koX.alf()), Boolean.valueOf(this.kqi)});
            boolean z3 = o.bgN().koX.alf() && !this.kqj;
            if (z) {
                o.bgN().gF(false);
            }
            if (o.bgN().koX.alf() && !this.kqj) {
                z3 = o.bgN().lto;
            }
            if (!this.kqi) {
                z2 = z3;
            }
            fT(z2);
            o.bgN().gK(z2);
            if (!z) {
                o.bgN().gF(true);
            }
        }
    }

    public final void ew(int i) {
        x.i("MicroMsg.MT.MultiTalkAudioPlayer", "onBluetoothHeadsetStateChange, status: %d, isStart: %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.bTv)});
        boolean bfM;
        switch (i) {
            case 1:
                if (i != this.lsY) {
                    this.kqi = true;
                    o.bgN().gF(false);
                    fT(false);
                    o.bgN().gK(false);
                    break;
                }
                break;
            case 2:
                if (i != this.lsY) {
                    this.kqi = false;
                    bfM = bfM();
                    fT(bfM);
                    o.bgN().gK(bfM);
                    o.bgN().gF(true);
                    break;
                }
                break;
            case 3:
                this.kqi = true;
                au.HV().yB();
                break;
            case 4:
                if (i != this.lsY) {
                    this.kqi = false;
                    au.HV().yC();
                    bfM = bfM();
                    fT(bfM);
                    o.bgN().gK(bfM);
                    o.bgN().gF(true);
                    break;
                }
                break;
        }
        this.lsY = i;
    }

    private boolean bfM() {
        boolean z = o.bgN().koX.alf() && !this.kqj;
        if (o.bgN().koX.alf() && !this.kqj) {
            z = o.bgN().lto;
        }
        x.i("MicroMsg.MT.MultiTalkAudioPlayer", "isSpeakerAfterBluetoothDisconnected: isHeadsetPlugged: %s, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s, isSpeaker: %s", new Object[]{Boolean.valueOf(this.kqj), Boolean.valueOf(o.bgN().ltn), Boolean.valueOf(o.bgN().lto), Boolean.valueOf(o.bgN().koX.alf()), Boolean.valueOf(this.kqi), Boolean.valueOf(z)});
        return z;
    }
}
