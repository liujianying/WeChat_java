package com.tencent.mm.ab;

import android.os.Looper;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.l.a;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class r extends a {
    private final l bKq;
    private final e dIX;
    private final long dJL = 330000;
    private q dJM;
    private k dJN;
    private boolean dJO = false;
    private boolean dJP = false;
    Runnable dJQ = new Runnable() {
        public final void run() {
            int i = 0;
            if (r.this.dJO || r.this.dJP) {
                int i2;
                String str = "MicroMsg.RemoteOnGYNetEnd";
                String str2 = "time exceed But removeCallbacks failed hash:%d type:%d";
                Object[] objArr = new Object[2];
                if (r.this.bKq == null) {
                    i2 = 0;
                } else {
                    i2 = r.this.bKq.hashCode();
                }
                objArr[0] = Integer.valueOf(i2);
                if (r.this.bKq != null) {
                    i = r.this.bKq.getType();
                }
                objArr[1] = Integer.valueOf(i);
                x.e(str, str2, objArr);
                return;
            }
            final boolean a = r.this.dJO;
            final boolean b = r.this.dJP;
            String str3 = "MicroMsg.RemoteOnGYNetEnd";
            String str4 = "time exceed, force to callback hash:%d type:%d";
            Object[] objArr2 = new Object[2];
            objArr2[0] = Integer.valueOf(r.this.bKq == null ? 0 : r.this.bKq.hashCode());
            if (r.this.bKq != null) {
                i = r.this.bKq.getType();
            }
            objArr2[1] = Integer.valueOf(i);
            x.w(str3, str4, objArr2);
            r.this.dJO = true;
            com.tencent.mm.sdk.f.e.post(new Runnable() {
                public final void run() {
                    int i = 0;
                    r.this.dIX.kh("push process's network haven't callback in 5.5min!!!! cancelStatus:" + a + " hasCallbackStatus:" + b);
                    String str = "MicroMsg.RemoteOnGYNetEnd";
                    String str2 = "time exceed, force to callback . kill push fin. hash:%d type:%d";
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(r.this.bKq == null ? 0 : r.this.bKq.hashCode());
                    if (r.this.bKq != null) {
                        i = r.this.bKq.getType();
                    }
                    objArr[1] = Integer.valueOf(i);
                    x.w(str, str2, objArr);
                }
            }, "RemoteOnGYNetEnd_killPush");
            r.this.dJN.a(-1, 3, -1, "time exceed, force to callback", r.this.dJM, null);
        }
    };
    private final e dJb;
    final ag handler;

    public r(q qVar, k kVar, l lVar, e eVar, e eVar2) {
        this.dJM = qVar;
        this.dJN = kVar;
        this.bKq = lVar;
        this.dJb = eVar;
        this.handler = Looper.myLooper() == null ? new ag(Looper.getMainLooper()) : new ag();
        this.dIX = eVar2;
    }

    public final void cancel() {
        this.dJO = true;
        this.handler.removeCallbacks(this.dJQ);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.r rVar, byte[] bArr) {
        x.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd netId:%d, errType:%d, errCode:%d, isCancel:%b, hash[%d,%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(this.dJO), Integer.valueOf(this.bKq.hashCode()), Integer.valueOf(this.dJM.hashCode()));
        this.bKq.dIZ = -1;
        if (!this.dJO && !this.dJP) {
            this.dJP = true;
            this.handler.removeCallbacks(this.dJQ);
            final int i4 = i;
            final int i5 = i2;
            final int i6 = i3;
            final String str2 = str;
            final byte[] bArr2 = bArr;
            this.handler.post(new Runnable() {
                public final void run() {
                    if (r.this.dJO) {
                        x.w("MicroMsg.RemoteOnGYNetEnd", "netId:%d has been canceled", Integer.valueOf(i4));
                        return;
                    }
                    int i = i5;
                    int i2 = i6;
                    if (10016 == af.exm && !bi.oW(af.exo)) {
                        x.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET : %s ", af.exo);
                        String[] split = af.exo.split(",");
                        if (split != null && split.length == 3 && bi.getInt(split[0], -1) == r.this.bKq.getType()) {
                            i = bi.getInt(split[1], 0);
                            i2 = bi.getInt(split[2], 0);
                            if (i == 999) {
                                x.w("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET syncservice : %s  NOT  CALLBACK !!!", af.exo);
                                return;
                            }
                        }
                    }
                    x.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd after post to worker netId:%d, errType:%d, errCode:%d, isCancel:%b, hashcode:%d", Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(r.this.dJO), Integer.valueOf(r.this.bKq.hashCode()));
                    r.this.dJN.a(i4, i, i2, str2, r.this.dJM, bArr2);
                    if (r.this.bKq.La() && !r.this.bKq.dJc) {
                        x.e("MicroMsg.RemoteOnGYNetEnd", "the netscene hasn't call callback to onSceneEnd, type:%d", Integer.valueOf(r.this.bKq.getType()));
                        x.chR();
                    }
                }
            });
        }
    }
}
