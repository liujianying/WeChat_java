package com.tencent.mm.network;

import android.os.RemoteCallbackList;
import com.tencent.mm.network.i.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class ac extends a {
    private al dHa = new al(new 1(this), false);
    private long etA;
    private int etB = 0;
    private final RemoteCallbackList<n> etC = new RemoteCallbackList();
    private int etz = 4;

    public final int UA() {
        x.i("MicroMsg.NetworkEvent", "getNowStatus = %d", Integer.valueOf(0 > bi.bG(this.etA) ? 5 : this.etz));
        return 0 > bi.bG(this.etA) ? 5 : this.etz;
    }

    public final boolean c(n nVar) {
        try {
            this.etC.register(nVar);
        } catch (Throwable e) {
            x.e("MicroMsg.NetworkEvent", "addListener %s", e);
            x.e("MicroMsg.NetworkEvent", "exception:%s", bi.i(e));
        }
        return true;
    }

    public final boolean d(n nVar) {
        boolean z = false;
        try {
            return this.etC.unregister(nVar);
        } catch (Throwable e) {
            x.e("MicroMsg.NetworkEvent", "removeListener %s", e);
            x.e("MicroMsg.NetworkEvent", "exception:%s", bi.i(e));
            return z;
        }
    }

    public final void UB() {
        this.etC.kill();
    }

    public final void iO(int i) {
        int i2 = 0;
        x.i("MicroMsg.NetworkEvent", "networkChange : %d", Integer.valueOf(i));
        if (i != this.etz) {
            if (3 != i) {
                if (2 == i) {
                    if (!(this.etz == 0 || this.etz == 1)) {
                        this.etB++;
                        if (this.etB > 0) {
                            this.etz = 2;
                            i2 = 1;
                        }
                    }
                } else if (4 == i) {
                    this.etB = 0;
                    this.etz = 4;
                    i2 = 1;
                }
                this.etz = i;
                i2 = 1;
            } else if (this.etz == 2) {
                this.etz = i;
                i2 = 1;
            }
        }
        if (i2 != 0) {
            if (i == 0 || i == 4 || i == 6) {
                this.dHa.J(1000, 1000);
            }
        }
    }

    public final long UC() {
        return this.etA;
    }
}
