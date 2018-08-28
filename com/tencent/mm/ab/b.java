package com.tencent.mm.ab;

import com.tencent.mm.protocal.c.bhd;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.protocal.c.bnu;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bi;

public final class b extends j {
    public int cdn;
    public b dID;
    public c dIE;
    public int dIF;
    public String uri;

    public static class a {
        public int dIF = 727;
        public com.tencent.mm.bk.a dIG;
        public com.tencent.mm.bk.a dIH;
        public int dII = 0;
        public int dIJ = 0;
        public boolean dIK = true;
        public String uri;

        public final void a(com.tencent.mm.bk.a aVar) {
            this.dIG = aVar;
        }

        public final void b(com.tencent.mm.bk.a aVar) {
            this.dIH = aVar;
        }

        public final void ke(String str) {
            this.uri = str;
        }

        public final void KQ() {
            this.dIF = 425;
        }

        public final void KR() {
            this.dII = 209;
        }

        public final void KS() {
            this.dIJ = 1000000209;
        }

        public final b KT() {
            if (this.dIG != null && this.dIH != null && !bi.oW(this.uri) && this.dIF > 0 && this.dII != Integer.MIN_VALUE && this.dIJ != Integer.MIN_VALUE) {
                return new b(this.dIG, this.dIH, this.uri, this.dIF, this.dII, this.dIJ, this.dIK, (byte) 0);
            }
            throw new IllegalArgumentException();
        }
    }

    public static final class b extends d implements com.tencent.mm.protocal.k.b {
        public int cmdId;
        private int dIF;
        public com.tencent.mm.bk.a dIL;
        private boolean dIM;

        public b(com.tencent.mm.bk.a aVar, int i, int i2, boolean z) {
            this.dIL = aVar;
            this.dIF = i;
            this.cmdId = i2;
            this.dIM = z;
        }

        public final int getCmdId() {
            return this.cmdId;
        }

        public final int If() {
            return this.dIF;
        }

        public final byte[] Ie() {
            if (this.dIL instanceof bhd) {
                ((bhd) this.dIL).shX = k.a(this);
            }
            return this.dIL.toByteArray();
        }
    }

    public static final class c extends e implements com.tencent.mm.protocal.k.c {
        public int cmdId;
        public com.tencent.mm.bk.a dIL = null;
        private boolean dIM;

        public c(com.tencent.mm.bk.a aVar, int i, boolean z) {
            this.dIL = aVar;
            this.cmdId = i;
            this.dIM = z;
        }

        public final int G(byte[] bArr) {
            this.dIL = this.dIL.aG(bArr);
            if (this.dIL instanceof bnu) {
                return ((bnu) this.dIL).getRet();
            }
            k.a(this, ((bhp) this.dIL).six);
            return ((bhp) this.dIL).six.rfn;
        }

        public final int getCmdId() {
            return this.cmdId;
        }
    }

    /* synthetic */ b(com.tencent.mm.bk.a aVar, com.tencent.mm.bk.a aVar2, String str, int i, int i2, int i3, boolean z, byte b) {
        this(aVar, aVar2, str, i, i2, i3, z);
    }

    protected final /* bridge */ /* synthetic */ d Ic() {
        return this.dID;
    }

    public final /* bridge */ /* synthetic */ e Id() {
        return this.dIE;
    }

    private b(com.tencent.mm.bk.a aVar, com.tencent.mm.bk.a aVar2, String str, int i, int i2, int i3, boolean z) {
        boolean z2 = false;
        this.dID = null;
        this.dIE = null;
        this.cdn = 0;
        if (z && (aVar instanceof bhd)) {
            z2 = true;
        }
        this.dID = new b(aVar, i, i2, z2);
        this.dIE = new c(aVar2, i3, z);
        this.uri = str;
        this.dIF = i;
    }

    public final com.tencent.mm.bk.a KN() {
        return this.dID.dIL;
    }

    public final com.tencent.mm.bk.a KO() {
        return this.dIE.dIL;
    }

    public final int getType() {
        return this.dIF;
    }

    public final String getUri() {
        return this.uri;
    }

    public final void a(y yVar) {
        this.dID.qWA = yVar;
    }

    public final int KP() {
        return this.cdn;
    }
}
