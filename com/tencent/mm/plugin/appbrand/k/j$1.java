package com.tencent.mm.plugin.appbrand.k;

import com.tencent.mm.plugin.appbrand.s.a.a;
import com.tencent.mm.plugin.appbrand.s.d.d;
import com.tencent.mm.plugin.appbrand.s.e.h;
import com.tencent.mm.plugin.appbrand.s.f.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;

class j$1 extends a {
    private d ftF = null;
    final /* synthetic */ j.a glq;
    final /* synthetic */ j glr;
    final /* synthetic */ String val$url;

    j$1(j jVar, URI uri, com.tencent.mm.plugin.appbrand.s.b.a aVar, Map map, int i, String str, j.a aVar2) {
        this.glr = jVar;
        this.val$url = str;
        this.glq = aVar2;
        super(uri, aVar, map, i);
    }

    public final void b(h hVar) {
        x.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,state: opened", new Object[]{this.val$url});
        j.c(this);
        this.glq.a(hVar);
    }

    public final void b(com.tencent.mm.plugin.appbrand.s.e.a aVar) {
        this.glq.a(aVar);
    }

    public final void sq(String str) {
        String str2 = "MicroMsg.AppBrandNetworkWebSocket";
        String str3 = "url is %s ,socket onmessage length :%d";
        Object[] objArr = new Object[2];
        objArr[0] = this.val$url;
        objArr[1] = Integer.valueOf(str != null ? str.length() : -1);
        x.i(str2, str3, objArr);
        this.glq.sm(str);
    }

    public final void F(int i, String str) {
        x.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,state: closed ,reason: %s, errCode = %d", new Object[]{this.val$url, str, Integer.valueOf(i)});
        j.c(this);
        if (i == -1 || i == -2 || i == -3) {
            j.a aVar;
            String str2;
            if (ao.isConnected(ad.getContext())) {
                aVar = this.glq;
                str2 = bi.oW(str) ? "abnormal closure" : str;
            } else {
                aVar = this.glq;
                str2 = "network is down";
            }
            aVar.sl(str2);
            this.glq.C(TXLiveConstants.PUSH_EVT_CHANGE_BITRATE, str);
        } else {
            this.glq.C(i, str);
        }
        this.glr.b(this);
    }

    public final void c(Exception exception) {
        x.e("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,error is %s", new Object[]{this.val$url, exception.toString()});
        this.glq.sl("exception " + exception.getMessage());
        this.glr.b(this);
    }

    public final void g(ByteBuffer byteBuffer) {
        String str = "MicroMsg.AppBrandNetworkWebSocket";
        String str2 = "url is %s , socket onMessage buffer length : %d";
        Object[] objArr = new Object[2];
        objArr[0] = this.val$url;
        objArr[1] = Integer.valueOf(byteBuffer != null ? byteBuffer.capacity() : -1);
        x.i(str, str2, objArr);
        this.glq.f(byteBuffer);
    }

    public final void a(d dVar) {
        if (dVar.aoN() != d.a.gDI && !dVar.aoL()) {
            this.ftF = dVar;
        } else if (dVar.aoN() == d.a.gDI && this.ftF != null) {
            if (this.ftF.aoK().position() > 10485760) {
                x.e("MicroMsg.AppBrandNetworkWebSocket", "Pending Frame exploded");
                this.ftF = null;
                return;
            }
            try {
                this.ftF.e(dVar);
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandNetworkWebSocket", e.getMessage());
            }
            if (dVar.aoL()) {
                if (this.ftF.aoN() == d.a.gDK) {
                    g(this.ftF.aoK());
                } else if (this.ftF.aoN() == d.a.gDJ) {
                    try {
                        sq(bi.oV(b.w(this.ftF.aoK())));
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", e2, "Charsetfunctions.stringUtf8", new Object[0]);
                    }
                }
                this.ftF = null;
            }
        }
    }
}
