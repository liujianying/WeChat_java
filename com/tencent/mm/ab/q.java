package com.tencent.mm.ab;

import com.tencent.mm.network.a.b;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.f;
import com.tencent.mm.network.h;
import com.tencent.mm.network.i;
import com.tencent.mm.network.l;
import com.tencent.mm.network.o;
import com.tencent.mm.network.r;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class q implements e {
    public final f dJJ;
    private p dJK;

    public q(f fVar) {
        this.dJJ = fVar;
    }

    public final int a(r rVar, l lVar) {
        try {
            return this.dJJ.a(rVar, lVar);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "remote dispatcher lost, send failed, %s", new Object[]{e});
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
            return -1;
        }
    }

    public final String getNetworkServerIp() {
        try {
            return this.dJJ.getNetworkServerIp();
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "query remote network server ip failed, %s", new Object[]{e});
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
            return null;
        }
    }

    public final String[] getIPsString(boolean z) {
        try {
            return this.dJJ.getIPsString(z);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "query remote network server ip failed, %s", new Object[]{e});
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
            return null;
        }
    }

    public final void cancel(int i) {
        try {
            this.dJJ.cancel(i);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "cancel remote rr failed, netid=%d, %s", new Object[]{Integer.valueOf(i), e});
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public final void reset() {
        try {
            this.dJJ.reset();
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "reset failed, core service down, %s", new Object[]{e});
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public final void a(boolean z, String str, String str2, int[] iArr, int[] iArr2, int i, int i2, String str3, String str4) {
        try {
            this.dJJ.a(z, str, str2, iArr, iArr2, i, i2, str3, str4);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "dkidc setIDCHostInfo ip failed, core service down, %s", new Object[]{e});
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public final c Lr() {
        try {
            if (this.dJK == null) {
                this.dJK = new p(this.dJJ.Ux());
            }
            return this.dJK;
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "getAccInfo failed, core service down, %s", new Object[]{e});
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
            return null;
        }
    }

    public final void a(b bVar) {
        try {
            this.dJJ.a(bVar);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public final void bC(boolean z) {
        try {
            this.dJJ.bC(z);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "change active status failed, core service down, %s", new Object[]{e});
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public final boolean Lh() {
        boolean z = true;
        try {
            return this.dJJ.Lh();
        } catch (Throwable e) {
            Object[] objArr = new Object[z];
            objArr[0] = e;
            x.e("MicroMsg.RDispatcher", "core service down, guess network stable, %s", objArr);
            objArr = new Object[z];
            objArr[0] = bi.i(e);
            x.e("MicroMsg.RDispatcher", "exception:%s", objArr);
            return z;
        }
    }

    public final i Ls() {
        try {
            return this.dJJ.Uz();
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
            return null;
        }
    }

    public final void a(com.tencent.mm.protocal.x xVar) {
        try {
            this.dJJ.a(xVar);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public final void kg(String str) {
        try {
            this.dJJ.kg(str);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "ipxxStatistics remote call error, %s", new Object[]{e});
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public final int getHostByName(String str, List<String> list) {
        try {
            return this.dJJ.getHostByName(str, list);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
            return -1;
        }
    }

    public final int a(String str, boolean z, List<String> list) {
        try {
            return this.dJJ.a(str, z, list);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
            return -1;
        }
    }

    public final void setHostInfo(String[] strArr, String[] strArr2, int[] iArr) {
        try {
            this.dJJ.setHostInfo(strArr, strArr2, iArr);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public final void a(int i, String str, int i2, boolean z) {
        try {
            this.dJJ.a(i, str, i2, z);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public final String getIspId() {
        try {
            return this.dJJ.getIspId();
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
            return null;
        }
    }

    public final void setSignallingStrategy(long j, long j2) {
        try {
            this.dJJ.setSignallingStrategy(j, j2);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public final void keepSignalling() {
        try {
            this.dJJ.keepSignalling();
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public final void stopSignalling() {
        try {
            this.dJJ.stopSignalling();
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public final void a(o oVar) {
        try {
            this.dJJ.a(oVar);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public final void reportFailIp(String str) {
        try {
            this.dJJ.reportFailIp(str);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public final void kh(String str) {
        try {
            this.dJJ.kh(str);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public final void bD(boolean z) {
        try {
            this.dJJ.bD(z);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public final void bE(boolean z) {
        try {
            this.dJJ.bE(z);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public final void bF(boolean z) {
        try {
            this.dJJ.bF(z);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public final void Lt() {
        try {
            this.dJJ.Lt();
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public final void a(h hVar) {
        try {
            this.dJJ.a(hVar);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
        }
    }

    public final void Lu() {
        try {
            this.dJJ.Lu();
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
        }
    }
}
