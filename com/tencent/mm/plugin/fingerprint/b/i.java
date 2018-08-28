package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.g.a.lg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.a;
import com.tencent.mm.pluginsdk.wallet.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends c<lg> {
    private String bOd;
    private a jgK;
    lg jgL;
    private k jgM;
    private Runnable jgN;
    boolean jgq;

    public i() {
        this.jgM = null;
        this.jgN = null;
        this.jgq = false;
        this.bOd = "";
        this.sFo = lg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        lg lgVar = (lg) bVar;
        if (g.Eg().Dx()) {
            this.jgq = false;
            if (lgVar instanceof lg) {
                x.i("MicroMsg.OpenFingerPrintAuthEventListener", "handle OpenFingerPrintAuthEventListener");
                if (e.aNm()) {
                    this.jgL = lgVar;
                    if (this.jgL == null) {
                        x.e("MicroMsg.OpenFingerPrintAuthEventListener", null, new Object[]{"mEvent is null !!!"});
                    } else {
                        this.jgN = this.jgL.bVz.bVD;
                        this.bOd = lgVar.bVz.bQa;
                        a.aMW();
                        if (a.aMX() == null) {
                            return true;
                        }
                        a.aMW();
                        a.aMX();
                        boolean aNf = c.aNf();
                        if (this.jgK == null) {
                            this.jgK = new a(this);
                        }
                        a.aMW();
                        a.aMX();
                        this.jgM = ((com.tencent.mm.pluginsdk.k) g.l(com.tencent.mm.pluginsdk.k.class)).aNr();
                        if (this.jgM == null) {
                            return fd(false);
                        }
                        this.jgM.a(new com.tencent.mm.pluginsdk.wallet.a() {
                            public final void af(int i, String str) {
                                x.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: pre processing done. errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
                                if (i == 0) {
                                    i.this.fd(false);
                                } else {
                                    i.this.U(1, "");
                                }
                            }
                        });
                        return aNf;
                    }
                }
                x.e("MicroMsg.OpenFingerPrintAuthEventListener", "device is not support FingerPrintAuth");
                this.jgq = true;
                U(1, "");
                return true;
            }
        }
        x.e("MicroMsg.OpenFingerPrintAuthEventListener", "OpenFingerPrintAuthEvent account is not ready");
        return false;
    }

    public final void release() {
        a.aMW();
        if (a.aMX() != null) {
            a.aMW();
            a.aMX();
            c.release();
        }
        this.jgL = null;
    }

    public static void aND() {
        a.aMW();
        if (a.aMX() != null) {
            boolean z;
            a.aMW();
            a.aMX();
            c.abort();
            a.aMW();
            a.aMX();
            c.release();
            String str = "MicroMsg.OpenFingerPrintAuthEventListener";
            String str2 = "stopIdentify() isSoter: %b";
            Object[] objArr = new Object[1];
            a.aMW();
            a.aMX();
            if (((com.tencent.mm.pluginsdk.k) g.l(com.tencent.mm.pluginsdk.k.class)).type() == 2) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
        }
    }

    final boolean fd(boolean z) {
        aND();
        a.aMW();
        a.aMX();
        if (c.aNf()) {
            a.aMW();
            a.aMX();
            if (c.a(this.jgK, z) != 0) {
                x.e("MicroMsg.OpenFingerPrintAuthEventListener", "failed to start identify");
                release();
                this.jgq = true;
                U(1, "");
                return false;
            }
            x.i("MicroMsg.OpenFingerPrintAuthEventListener", "startIdentify()");
            return true;
        }
        x.e("MicroMsg.OpenFingerPrintAuthEventListener", "no fingerprints enrolled, use settings to enroll fingerprints first");
        release();
        this.jgq = true;
        U(1, "");
        return false;
    }

    final void U(int i, String str) {
        x.i("MicroMsg.OpenFingerPrintAuthEventListener", "onFail()");
        a.aMW();
        a.aMX();
        ((com.tencent.mm.pluginsdk.k) g.l(com.tencent.mm.pluginsdk.k.class)).a(this.jgL, i, str);
        if (this.jgq) {
            this.jgL = null;
        }
        x.i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onFail()");
    }
}
