package com.tencent.mm.plugin.u;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag.a;
import com.tencent.mm.sdk.platformtools.x;

class j$1 implements a {
    final /* synthetic */ j ldN;

    j$1(j jVar) {
        this.ldN = jVar;
    }

    public final boolean handleMessage(Message message) {
        x.i("MicroMsg.VideoPlayerImpl", "%s inner callback %d %d [%d]", this.ldN.ldg.avA(), Integer.valueOf(message.what), Integer.valueOf(this.ldN.state), Integer.valueOf(this.ldN.ldH.state));
        boolean z;
        switch (message.what) {
            case 0:
                if (this.ldN.ldG && (this.ldN.hEj || this.ldN.ldI)) {
                    this.ldN.ldh.obtainMessage(6).sendToTarget();
                    break;
                }
            case 2:
                int z2;
                if (this.ldN.state < 2) {
                    z2 = 1;
                } else {
                    z2 = false;
                }
                if (z2 != 0) {
                    z2 = d.sy(this.ldN.ldH.state);
                    if (this.ldN.ldJ != null) {
                        z2 &= d.sy(this.ldN.ldJ.state);
                    }
                    if (z2) {
                        this.ldN.setState(2);
                        this.ldN.ldh.obtainMessage(1).sendToTarget();
                        break;
                    }
                }
                break;
            case 7:
                j.a(this.ldN);
                break;
            case 9:
                if (!d.sB(this.ldN.state)) {
                    if (!d.sC(this.ldN.state) && !d.sA(this.ldN.state)) {
                        z2 = d.sB(this.ldN.ldH.state);
                        if (this.ldN.ldJ != null) {
                            z2 &= d.sB(this.ldN.ldJ.state);
                        }
                        if (z2) {
                            this.ldN.setState(9);
                            this.ldN.ldh.obtainMessage(2).sendToTarget();
                            break;
                        }
                    }
                    this.ldN.setState(9);
                    this.ldN.ldh.obtainMessage(2).sendToTarget();
                    break;
                }
                break;
        }
        return false;
    }
}
