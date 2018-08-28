package com.tencent.mm.plugin.appbrand.s.a;

import com.tencent.mm.plugin.appbrand.s.b;
import com.tencent.mm.plugin.appbrand.s.c;
import com.tencent.mm.plugin.appbrand.s.e.d;
import com.tencent.mm.plugin.appbrand.s.e.f;
import com.tencent.mm.plugin.appbrand.s.e.h;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.concurrent.CountDownLatch;
import javax.net.ssl.SSLException;

public abstract class a extends b implements com.tencent.mm.plugin.appbrand.s.a, Runnable {
    public Timer bno = null;
    public String fEl;
    private com.tencent.mm.plugin.appbrand.s.b.a gCT;
    protected URI gDc = null;
    public c gDd = null;
    private Socket gDe = null;
    private InputStream gDf;
    OutputStream gDg;
    private Proxy gDh = Proxy.NO_PROXY;
    public Runnable gDi;
    private Map<String, String> gDj;
    private CountDownLatch gDk = new CountDownLatch(1);
    private CountDownLatch gDl = new CountDownLatch(1);
    private int gDm = 0;

    private class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }

        public final void run() {
            while (!Thread.interrupted()) {
                ByteBuffer byteBuffer;
                try {
                    byteBuffer = (ByteBuffer) a.this.gDd.gCN.take();
                    a.this.gDg.write(byteBuffer.array(), 0, byteBuffer.limit());
                    a.this.gDg.flush();
                } catch (InterruptedException e) {
                    try {
                        for (ByteBuffer byteBuffer2 : a.this.gDd.gCN) {
                            a.this.gDg.write(byteBuffer2.array(), 0, byteBuffer2.limit());
                            a.this.gDg.flush();
                        }
                    } catch (Exception e2) {
                        a aVar = a.this;
                        if (e2 instanceof SSLException) {
                            aVar.c(e2);
                        }
                        aVar.gDd.aoE();
                        return;
                    } finally {
                        a.d(a.this);
                    }
                }
            }
            a.d(a.this);
        }
    }

    public abstract void F(int i, String str);

    public abstract void b(h hVar);

    public abstract void c(Exception exception);

    public abstract void sq(String str);

    public a(URI uri, com.tencent.mm.plugin.appbrand.s.b.a aVar, Map<String, String> map, int i) {
        if (uri == null) {
            throw new IllegalArgumentException();
        } else if (aVar == null) {
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        } else {
            this.gDc = uri;
            this.gCT = aVar;
            this.gDj = map;
            this.gDm = i;
            this.gDd = new c(this, aVar);
            this.gCI = false;
        }
    }

    public final void connect() {
        if (this.gDi != null) {
            x.i("MicroMsg.AppBrandNetWork.WebSocketClient", "WebSocketClient objects are not reuseable");
            return;
        }
        this.gDi = this;
        e.post(this.gDi, "WebsocketWriteThread");
    }

    public final void close() {
        if (this.gDi != null) {
            this.gDd.d(1000, "", false);
        }
    }

    public final void vW(String str) {
        c cVar = this.gDd;
        if (str == null) {
            x.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
        } else {
            cVar.d(cVar.gCT.ae(str, cVar.gCU == com.tencent.mm.plugin.appbrand.s.a.b.gCF));
        }
    }

    public void run() {
        try {
            if (this.gDe == null) {
                this.gDe = new Socket(this.gDh);
            } else if (this.gDe.isClosed()) {
                throw new IOException();
            }
            this.gDe.setTcpNoDelay(this.gCI);
            if (!this.gDe.isBound()) {
                this.gDe.connect(new InetSocketAddress(this.gDc.getHost(), getPort()), this.gDm);
            }
            this.gDf = this.gDe.getInputStream();
            this.gDg = this.gDe.getOutputStream();
            aoG();
            this.gDi = new a(this, (byte) 0);
            e.post(this.gDi, "WebsocketWriteThread");
            byte[] bArr = new byte[c.gCJ];
            while (!this.gDd.aoF() && !this.gDd.isClosed()) {
                try {
                    int read = this.gDf.read(bArr);
                    if (read != -1) {
                        this.gDd.l(ByteBuffer.wrap(bArr, 0, read));
                    }
                } catch (IOException e) {
                    this.gDd.aoE();
                    return;
                } catch (Exception e2) {
                    c(e2);
                    this.gDd.Q(1006, e2.getMessage());
                    return;
                }
            }
            this.gDd.aoE();
        } catch (Exception e22) {
            this.gDd.Q(-1, e22.getMessage());
        }
    }

    private int getPort() {
        int port = this.gDc.getPort();
        if (port != -1) {
            return port;
        }
        String scheme = this.gDc.getScheme();
        if (scheme.equals("wss")) {
            return 443;
        }
        if (scheme.equals("ws")) {
            return 80;
        }
        throw new RuntimeException("unkonow scheme" + scheme);
    }

    private void aoG() {
        String path = this.gDc.getPath();
        String query = this.gDc.getQuery();
        if (path == null || path.length() == 0) {
            path = "/";
        }
        if (query != null) {
            path = path + "?" + query;
        }
        int port = getPort();
        query = this.gDc.getHost() + (port != 80 ? ":" + port : "");
        d dVar = new d();
        dVar.vY(path);
        dVar.put("Host", query);
        if (this.gDj != null) {
            for (Entry entry : this.gDj.entrySet()) {
                dVar.put((String) entry.getKey(), (String) entry.getValue());
            }
        }
        c cVar = this.gDd;
        cVar.gCX = cVar.gCT.a(dVar);
        cVar.gDb = dVar.aoO();
        if (cVar.gDb != null) {
            try {
                cVar.gCR.b(cVar.gCX);
                com.tencent.mm.plugin.appbrand.s.b.a aVar = cVar.gCT;
                com.tencent.mm.plugin.appbrand.s.e.a aVar2 = cVar.gCX;
                int i = cVar.gCU;
                cVar.ar(com.tencent.mm.plugin.appbrand.s.b.a.e(aVar2));
            } catch (com.tencent.mm.plugin.appbrand.s.c.b e) {
                throw new com.tencent.mm.plugin.appbrand.s.c.d("Handshake data rejected by client.");
            } catch (Exception e2) {
                cVar.gCR.f(e2);
                throw new com.tencent.mm.plugin.appbrand.s.c.d("rejected because of" + e2);
            }
        }
    }

    public final void vV(String str) {
        sq(str);
    }

    public final void p(ByteBuffer byteBuffer) {
        g(byteBuffer);
    }

    public final void c(com.tencent.mm.plugin.appbrand.s.d.d dVar) {
        a(dVar);
    }

    public final void d(f fVar) {
        this.gDk.countDown();
        b((h) fVar);
    }

    public final void R(int i, String str) {
        this.gDk.countDown();
        this.gDl.countDown();
        if (this.gDi != null) {
            e.S(this.gDi);
        }
        try {
            if (this.gDe != null) {
                this.gDe.close();
            }
        } catch (Exception e) {
            c(e);
        }
        F(i, str);
    }

    public final void f(Exception exception) {
        c(exception);
    }

    public void g(ByteBuffer byteBuffer) {
    }

    public void a(com.tencent.mm.plugin.appbrand.s.d.d dVar) {
    }

    public final void a(Socket socket) {
        if (this.gDe != null) {
            x.i("MicroMsg.AppBrandNetWork.WebSocketClient", "socket has already been set");
        } else {
            this.gDe = socket;
        }
    }

    public final void S(int i, String str) {
        this.gDd.d(i, str, false);
    }

    public final void q(ByteBuffer byteBuffer) {
        c cVar = this.gDd;
        if (byteBuffer == null) {
            x.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
        } else {
            cVar.d(cVar.gCT.a(byteBuffer, cVar.gCU == com.tencent.mm.plugin.appbrand.s.a.b.gCF));
        }
    }

    public final void b(com.tencent.mm.plugin.appbrand.s.d.d dVar) {
        this.gDd.b(dVar);
    }
}
