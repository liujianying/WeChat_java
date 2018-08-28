package com.tencent.mm.plugin.appbrand.s;

import com.tencent.mm.plugin.appbrand.s.b.a;
import com.tencent.mm.plugin.appbrand.s.b.b;
import com.tencent.mm.plugin.appbrand.s.d.d;
import com.tencent.mm.plugin.appbrand.s.e.f;
import com.tencent.mm.plugin.appbrand.s.e.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class c implements a {
    public static boolean DEBUG = false;
    public static int gCJ = 16384;
    public static final List<a> gCK;
    public SelectionKey gCL;
    public ByteChannel gCM;
    public final BlockingQueue<ByteBuffer> gCN;
    public final BlockingQueue<ByteBuffer> gCO;
    private volatile boolean gCP = false;
    private int gCQ = a.a.gCz;
    public final d gCR;
    private List<a> gCS;
    public a gCT = null;
    public int gCU;
    private d.a gCV = null;
    private ByteBuffer gCW = ByteBuffer.allocate(0);
    public com.tencent.mm.plugin.appbrand.s.e.a gCX = null;
    private String gCY = null;
    private Integer gCZ = null;
    private Boolean gDa = null;
    public String gDb = null;

    static {
        List arrayList = new ArrayList(4);
        gCK = arrayList;
        arrayList.add(new com.tencent.mm.plugin.appbrand.s.b.c());
        gCK.add(new b());
        gCK.add(new com.tencent.mm.plugin.appbrand.s.b.d());
    }

    public c(d dVar, a aVar) {
        if (dVar == null || (aVar == null && this.gCU == a.b.gCG)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.gCN = new LinkedBlockingQueue();
        this.gCO = new LinkedBlockingQueue();
        this.gCR = dVar;
        this.gCU = a.b.gCF;
        if (aVar != null) {
            this.gCT = aVar.aoI();
        }
    }

    public final void l(ByteBuffer byteBuffer) {
        if (DEBUG) {
            x.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "\"process(\" + socketBuffer.remaining() + \"): {\" + ( socketBuffer.remaining() > 1000 ? \"too big to display\" : new String( socketBuffer.array(), socketBuffer.position(), socketBuffer.remaining() ) ) + \"}\"");
        }
        if (this.gCQ != a.a.gCz) {
            if (this.gCQ == a.a.gCB) {
                n(byteBuffer);
            }
        } else if (m(byteBuffer) && !aoF() && !isClosed()) {
            if (byteBuffer.hasRemaining()) {
                n(byteBuffer);
            } else if (this.gCW.hasRemaining()) {
                n(this.gCW);
            }
        }
    }

    private boolean m(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        if (this.gCW.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.gCW.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.gCW.capacity() + byteBuffer.remaining());
                this.gCW.flip();
                allocate.put(this.gCW);
                this.gCW = allocate;
            }
            this.gCW.put(byteBuffer);
            this.gCW.flip();
            byteBuffer2 = this.gCW;
        }
        byteBuffer2.mark();
        try {
            f t;
            com.tencent.mm.plugin.appbrand.s.e.a aVar;
            if (this.gCU != a.b.gCG) {
                if (this.gCU == a.b.gCF) {
                    this.gCT.lS(this.gCU);
                    t = this.gCT.t(byteBuffer2);
                    if (t instanceof h) {
                        h hVar = (h) t;
                        if (this.gCT.a(this.gCX, hVar) == a.b.gDw) {
                            c(hVar);
                            return true;
                        }
                        d(TXLiveConstants.PUSH_EVT_PUSH_BEGIN, "draft refuses handshake" + hVar.aoP(), false);
                    } else {
                        e(TXLiveConstants.PUSH_EVT_PUSH_BEGIN, "wrong http function", false);
                        return false;
                    }
                }
                return false;
            } else if (this.gCT == null) {
                for (a aoI : this.gCS) {
                    a aoI2 = aoI.aoI();
                    try {
                        aoI2.lS(this.gCU);
                        byteBuffer2.reset();
                        t = aoI2.t(byteBuffer2);
                        if (t instanceof com.tencent.mm.plugin.appbrand.s.e.a) {
                            aVar = (com.tencent.mm.plugin.appbrand.s.e.a) t;
                            if (aoI2.c(aVar) == a.b.gDw) {
                                this.gDb = aVar.aoO();
                                try {
                                    ar(a.e(aoI2.a(aVar, this.gCR.aoD())));
                                    this.gCT = aoI2;
                                    c(aVar);
                                    return true;
                                } catch (com.tencent.mm.plugin.appbrand.s.c.b e) {
                                    e(e.gDF, e.getMessage(), false);
                                    return false;
                                } catch (Exception e2) {
                                    this.gCR.f(e2);
                                    e(-1, e2.getMessage(), false);
                                    return false;
                                }
                            }
                            continue;
                        } else {
                            e(TXLiveConstants.PUSH_EVT_PUSH_BEGIN, "wrong http function", false);
                            return false;
                        }
                    } catch (com.tencent.mm.plugin.appbrand.s.c.d e3) {
                        x.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "InvalidHandshakeException e: " + e3.toString());
                    }
                }
                if (this.gCT == null) {
                    d(TXLiveConstants.PUSH_EVT_PUSH_BEGIN, "no draft matches", false);
                }
                return false;
            } else {
                t = this.gCT.t(byteBuffer2);
                if (t instanceof com.tencent.mm.plugin.appbrand.s.e.a) {
                    aVar = (com.tencent.mm.plugin.appbrand.s.e.a) t;
                    if (this.gCT.c(aVar) == a.b.gDw) {
                        c(aVar);
                        return true;
                    }
                    d(TXLiveConstants.PUSH_EVT_PUSH_BEGIN, "the handshake did finaly not match", false);
                    return false;
                }
                e(TXLiveConstants.PUSH_EVT_PUSH_BEGIN, "wrong http function", false);
                return false;
            }
        } catch (com.tencent.mm.plugin.appbrand.s.c.d e32) {
            try {
                x.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeHandshake: " + e32.toString());
                a(e32);
            } catch (com.tencent.mm.plugin.appbrand.s.c.a e4) {
                x.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeHandshake: " + e4.toString());
                if (this.gCW.capacity() == 0) {
                    byteBuffer2.reset();
                    int i = e4.gDE;
                    if (i == 0) {
                        i = byteBuffer2.capacity() + 16;
                    }
                    this.gCW = ByteBuffer.allocate(i);
                    this.gCW.put(byteBuffer);
                } else {
                    this.gCW.position(this.gCW.limit());
                    this.gCW.limit(this.gCW.capacity());
                }
            }
        }
    }

    private void n(ByteBuffer byteBuffer) {
        try {
            for (d dVar : this.gCT.s(byteBuffer)) {
                if (DEBUG) {
                    x.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "matched frame: " + dVar);
                }
                d.a aoN = dVar.aoN();
                boolean aoL = dVar.aoL();
                if (aoN == d.a.gDN) {
                    String message;
                    int i = TXLiveConstants.PUSH_EVT_CHANGE_RESOLUTION;
                    String str = "";
                    if (dVar instanceof com.tencent.mm.plugin.appbrand.s.d.a) {
                        com.tencent.mm.plugin.appbrand.s.d.a aVar = (com.tencent.mm.plugin.appbrand.s.d.a) dVar;
                        int aoJ = aVar.aoJ();
                        message = aVar.getMessage();
                        i = aoJ;
                    } else {
                        message = str;
                    }
                    if (this.gCQ == a.a.gCC) {
                        Q(i, message);
                    } else if (this.gCT.aoH() == a.a.gDu) {
                        d(i, message, true);
                    } else {
                        e(i, message, false);
                    }
                } else if (aoN == d.a.gDL) {
                    this.gCR.a(this, dVar);
                } else if (aoN == d.a.gDM) {
                    continue;
                } else if (!aoL || aoN == d.a.gDI) {
                    if (aoN != d.a.gDI) {
                        if (this.gCV != null) {
                            throw new com.tencent.mm.plugin.appbrand.s.c.b("Previous continuous frame sequence not completed.");
                        }
                        this.gCV = aoN;
                    } else if (aoL) {
                        if (this.gCV == null) {
                            throw new com.tencent.mm.plugin.appbrand.s.c.b("Continuous frame sequence was not started.");
                        }
                        this.gCV = null;
                    } else if (this.gCV == null) {
                        throw new com.tencent.mm.plugin.appbrand.s.c.b("Continuous frame sequence was not started.");
                    }
                    try {
                        this.gCR.c(dVar);
                    } catch (Exception e) {
                        this.gCR.f(e);
                    }
                } else if (this.gCV != null) {
                    throw new com.tencent.mm.plugin.appbrand.s.c.b("Continuous frame sequence not completed.");
                } else if (aoN == d.a.gDJ) {
                    try {
                        this.gCR.vV(com.tencent.mm.plugin.appbrand.s.f.b.w(dVar.aoK()));
                    } catch (Exception e2) {
                        this.gCR.f(e2);
                    }
                } else if (aoN == d.a.gDK) {
                    try {
                        this.gCR.p(dVar.aoK());
                    } catch (Exception e22) {
                        this.gCR.f(e22);
                    }
                } else {
                    throw new com.tencent.mm.plugin.appbrand.s.c.b("non control or continious frame expected");
                }
            }
        } catch (Exception e222) {
            x.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeFrames: " + e222.toString());
            this.gCR.f(e222);
            a(e222);
        }
    }

    public final void d(int i, String str, boolean z) {
        if (this.gCQ != a.a.gCC && this.gCQ != a.a.gCD) {
            if (this.gCQ == a.a.gCB) {
                if (i == TXLiveConstants.PUSH_EVT_CHANGE_BITRATE) {
                    this.gCQ = a.a.gCC;
                    e(i, str, false);
                    return;
                }
                if (this.gCT.aoH() != a.a.gDs) {
                    try {
                        b(new com.tencent.mm.plugin.appbrand.s.d.b(i, str));
                    } catch (Exception e) {
                        x.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "close: " + e.toString());
                        this.gCR.f(e);
                        e(TXLiveConstants.PUSH_EVT_CHANGE_BITRATE, "generated frame is invalid", false);
                    }
                }
                e(i, str, z);
            } else if (i == -3) {
                e(-3, str, true);
            } else {
                e(-1, str, false);
            }
            if (i == TXLiveConstants.PUSH_EVT_PUSH_BEGIN) {
                e(i, str, z);
            }
            this.gCQ = a.a.gCC;
            this.gCW = null;
        }
    }

    public final synchronized void Q(int i, String str) {
        if (this.gCQ != a.a.gCD) {
            if (this.gCL != null) {
                this.gCL.cancel();
            }
            if (this.gCM != null) {
                try {
                    this.gCM.close();
                } catch (Exception e) {
                    this.gCR.f(e);
                }
            }
            try {
                this.gCR.R(i, str);
            } catch (Exception e2) {
                this.gCR.f(e2);
            }
            if (this.gCT != null) {
                this.gCT.reset();
            }
            this.gCX = null;
            this.gCQ = a.a.gCD;
            this.gCN.clear();
        }
    }

    private synchronized void e(int i, String str, boolean z) {
        if (!this.gCP) {
            this.gCZ = Integer.valueOf(i);
            this.gCY = str;
            this.gDa = Boolean.valueOf(z);
            this.gCP = true;
            if (this.gCT != null) {
                this.gCT.reset();
            }
            this.gCX = null;
        }
    }

    public final void aoE() {
        if (this.gCQ == a.a.gCz) {
            Q(-1, "");
        } else if (this.gCP) {
            int intValue = this.gCZ.intValue();
            String str = this.gCY;
            this.gDa.booleanValue();
            Q(intValue, str);
        } else if (this.gCT.aoH() == a.a.gDs) {
            Q(1000, "");
        } else if (this.gCT.aoH() != a.a.gDt || this.gCU == a.b.gCG) {
            Q(TXLiveConstants.PUSH_EVT_CHANGE_BITRATE, "");
        } else {
            Q(1000, "");
        }
    }

    private void a(com.tencent.mm.plugin.appbrand.s.c.b bVar) {
        d(bVar.gDF, bVar.getMessage(), false);
    }

    public final void d(Collection<d> collection) {
        if (isOpen()) {
            for (d b : collection) {
                b(b);
            }
            return;
        }
        throw new com.tencent.mm.plugin.appbrand.s.c.f();
    }

    public final void b(d dVar) {
        if (DEBUG) {
            x.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "\"send frame: \" + framedata ");
        }
        o(this.gCT.d(dVar));
    }

    private void o(ByteBuffer byteBuffer) {
        if (DEBUG) {
            x.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "write(\" + buf.remaining() + \"): {\" + ( buf.remaining() > 1000 ? \"too big to display\" : new String( buf.array() ) ) + \"}");
        }
        this.gCN.add(byteBuffer);
    }

    public final void ar(List<ByteBuffer> list) {
        for (ByteBuffer o : list) {
            o(o);
        }
    }

    private void c(f fVar) {
        if (DEBUG) {
            x.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "open using draft: " + this.gCT.getClass().getSimpleName());
        }
        this.gCQ = a.a.gCB;
        try {
            this.gCR.d(fVar);
        } catch (Exception e) {
            this.gCR.f(e);
        }
    }

    public final boolean isOpen() {
        return this.gCQ == a.a.gCB;
    }

    public final boolean aoF() {
        return this.gCQ == a.a.gCC;
    }

    public final boolean isClosed() {
        return this.gCQ == a.a.gCD;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final String toString() {
        return super.toString();
    }
}
