package com.tencent.mm.plugin.appbrand.debugger;

import android.util.Log;
import com.tencent.mm.plugin.appbrand.k.i;
import com.tencent.mm.plugin.appbrand.k.j$a;
import com.tencent.mm.plugin.appbrand.s.a.a;
import com.tencent.mm.plugin.appbrand.s.b.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.c.cbd;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public final class o {
    a ftD;
    private SSLSocketFactory ftE;

    public o(String str) {
        SSLContext uP = i.uP(str);
        if (uP != null) {
            this.ftE = uP.getSocketFactory();
        }
    }

    public final void a(String str, j$a j_a) {
        x.i("MicroMsg.RemoteDebugSocket", "connectSocket url is %s", new Object[]{str});
        try {
            URI uri = new URI(str);
            Map hashMap = new HashMap();
            if (str.startsWith("ws://localhost:")) {
                hashMap.put("Sec-WebSocket-Protocol", "client");
            }
            try {
                this.ftD = new 1(this, uri, new d(), hashMap, j_a);
                if (s.fj(str, "ws://")) {
                    this.ftD.a(new Socket(Proxy.NO_PROXY));
                    this.ftD.connect();
                    return;
                }
                SSLSocketFactory sSLSocketFactory;
                if (this.ftE != null) {
                    sSLSocketFactory = this.ftE;
                } else {
                    sSLSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
                }
                this.ftD.a(sSLSocketFactory.createSocket());
                this.ftD.connect();
            } catch (Throwable e) {
                x.e("MicroMsg.RemoteDebugSocket", "onSocketMessage %s", new Object[]{Log.getStackTraceString(e)});
            }
        } catch (Exception e2) {
            x.e("MicroMsg.RemoteDebugSocket", "connect fail : %s ", new Object[]{e2.toString()});
            j_a.sn("url not well format");
        }
    }

    public final boolean isOpen() {
        if (this.ftD == null) {
            return false;
        }
        return this.ftD.gDd.isOpen();
    }

    public final boolean a(cbd cbd) {
        x.d("MicroMsg.RemoteDebugSocket", "sendSocketMsg");
        if (!isOpen()) {
            x.w("MicroMsg.RemoteDebugSocket", "sendSocketMsg fail, not open");
            return false;
        } else if (cbd == null) {
            x.w("MicroMsg.RemoteDebugSocket", "sendSocketMsg fail");
            return false;
        } else {
            this.ftD.q(p.c(cbd));
            return true;
        }
    }

    public final boolean sp(String str) {
        if (this.ftD == null) {
            x.w("MicroMsg.RemoteDebugSocket", "client is null");
            return false;
        }
        this.ftD.S(BaseReportManager.MAX_READ_COUNT, str);
        x.d("MicroMsg.RemoteDebugSocket", "closeSocket code %d, reason %s", new Object[]{Integer.valueOf(BaseReportManager.MAX_READ_COUNT), str});
        return true;
    }
}
