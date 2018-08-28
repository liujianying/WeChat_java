package com.tencent.mm.ab;

import com.tencent.mm.network.c;
import com.tencent.mm.network.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class p implements c {
    private final d dJI;

    public p(d dVar) {
        this.dJI = dVar;
    }

    public final byte[] Lm() {
        try {
            return this.dJI.Lm();
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", new Object[]{bi.i(e)});
            return null;
        }
    }

    public final byte[] DE() {
        try {
            return this.dJI.DE();
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", new Object[]{bi.i(e)});
            return null;
        }
    }

    public final int Df() {
        int i = 0;
        try {
            return this.dJI.Df();
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", new Object[]{bi.i(e)});
            return i;
        }
    }

    private String getUsername() {
        try {
            return this.dJI.getUsername();
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", new Object[]{bi.i(e)});
            return null;
        }
    }

    public final boolean Ln() {
        boolean z = false;
        try {
            return this.dJI.Ln();
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", new Object[]{bi.i(e)});
            return z;
        }
    }

    public final void setUsername(String str) {
        try {
            this.dJI.setUsername(str);
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public final void x(byte[] bArr, int i) {
        try {
            this.dJI.x(bArr, i);
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public final void reset() {
        try {
            this.dJI.reset();
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public final String toString() {
        return (((("RAccInfo:\n" + "|-uin     =" + Df() + "\n") + "|-user    =" + getUsername() + "\n") + "|-session =" + DE() + "\n") + "|-ecdhkey =" + bi.bB(Lo()) + "\n") + "`-cookie  =" + bi.bB(Lm());
    }

    public final void h(String str, byte[] bArr) {
        try {
            this.dJI.h(str, bArr);
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public final byte[] kf(String str) {
        try {
            return this.dJI.kf(str);
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", new Object[]{bi.i(e)});
            return null;
        }
    }

    public final byte[] Lo() {
        try {
            return this.dJI.Lo();
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", new Object[]{bi.i(e)});
            return null;
        }
    }

    public final void bB(boolean z) {
        try {
            this.dJI.bB(z);
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public final boolean Lp() {
        boolean z = true;
        try {
            return this.dJI.Lp();
        } catch (Throwable e) {
            Object[] objArr = new Object[z];
            objArr[0] = bi.i(e);
            x.e("MicroMsg.RAccInfo", "exception:%s", objArr);
            return z;
        }
    }

    public final byte[] Lq() {
        try {
            return this.dJI.Lq();
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", new Object[]{bi.i(e)});
            return null;
        }
    }

    public final int I(byte[] bArr) {
        try {
            return this.dJI.I(bArr);
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[]{bi.i(e)});
            return -6;
        }
    }

    public final void eK(int i) {
        try {
            this.dJI.eK(i);
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", new Object[]{bi.i(e)});
        }
    }
}
