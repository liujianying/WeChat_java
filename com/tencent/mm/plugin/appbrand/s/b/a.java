package com.tencent.mm.plugin.appbrand.s.b;

import com.tencent.mm.plugin.appbrand.s.d.d;
import com.tencent.mm.plugin.appbrand.s.e.c;
import com.tencent.mm.plugin.appbrand.s.e.e;
import com.tencent.mm.plugin.appbrand.s.e.f;
import com.tencent.mm.plugin.appbrand.s.e.h;
import com.tencent.mm.plugin.appbrand.s.e.i;
import com.tencent.mm.plugin.appbrand.s.f.b;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class a {
    public static int gDo = 1000;
    public static int gDp = 64;
    public static final byte[] gDq = b.wc("<policy-file-request/>\u0000");
    protected int gCU = 0;
    protected com.tencent.mm.plugin.appbrand.s.d.d.a gDr = null;

    public abstract int a(com.tencent.mm.plugin.appbrand.s.e.a aVar, h hVar);

    public abstract com.tencent.mm.plugin.appbrand.s.e.b a(com.tencent.mm.plugin.appbrand.s.e.b bVar);

    public abstract c a(com.tencent.mm.plugin.appbrand.s.e.a aVar, i iVar);

    public abstract List<d> a(ByteBuffer byteBuffer, boolean z);

    public abstract List<d> ae(String str, boolean z);

    public abstract int aoH();

    public abstract a aoI();

    public abstract int c(com.tencent.mm.plugin.appbrand.s.e.a aVar);

    public abstract ByteBuffer d(d dVar);

    public abstract void reset();

    public abstract List<d> s(ByteBuffer byteBuffer);

    private static String r(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b = (byte) 48;
        while (byteBuffer.hasRemaining()) {
            byte b2 = byteBuffer.get();
            allocate.put(b2);
            if (b == (byte) 13 && b2 == (byte) 10) {
                allocate.limit(allocate.position() - 2);
                allocate.position(0);
                byteBuffer2 = allocate;
                break;
            }
            b = b2;
        }
        byteBuffer.position(byteBuffer.position() - allocate.position());
        byteBuffer2 = null;
        return byteBuffer2 == null ? null : b.G(byteBuffer2.array(), byteBuffer2.limit());
    }

    public static com.tencent.mm.plugin.appbrand.s.a.b<List> e(f fVar) {
        StringBuilder stringBuilder = new StringBuilder(100);
        if (fVar instanceof com.tencent.mm.plugin.appbrand.s.e.a) {
            stringBuilder.append("GET ");
            stringBuilder.append(((com.tencent.mm.plugin.appbrand.s.e.a) fVar).aoO());
            stringBuilder.append(" HTTP/1.1");
        } else if (fVar instanceof h) {
            stringBuilder.append("HTTP/1.1 101 " + ((h) fVar).aoP());
        } else {
            stringBuilder.append("GET ");
            stringBuilder.append(((com.tencent.mm.plugin.appbrand.s.e.a) fVar).aoO());
            stringBuilder.append(" HTTP/1.1");
            x.e("MicroMsg.AppBrandNetWork.Draft", "unknow role");
        }
        stringBuilder.append("\r\n");
        Iterator aoQ = fVar.aoQ();
        while (aoQ.hasNext()) {
            String str = (String) aoQ.next();
            String wa = fVar.wa(str);
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(wa);
            stringBuilder.append("\r\n");
        }
        stringBuilder.append("\r\n");
        byte[] wd = b.wd(stringBuilder.toString());
        byte[] aoR = fVar.aoR();
        ByteBuffer allocate = ByteBuffer.allocate((aoR == null ? 0 : aoR.length) + wd.length);
        allocate.put(wd);
        if (aoR != null) {
            allocate.put(aoR);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }

    public final f t(ByteBuffer byteBuffer) {
        int i = this.gCU;
        String r = r(byteBuffer);
        if (r == null) {
            throw new com.tencent.mm.plugin.appbrand.s.c.a(byteBuffer.capacity() + 128);
        }
        String[] split = r.split(" ", 3);
        if (split.length != 3) {
            throw new com.tencent.mm.plugin.appbrand.s.c.d();
        }
        c eVar;
        String r2;
        if (i == com.tencent.mm.plugin.appbrand.s.a.b.gCF) {
            eVar = new e();
            i iVar = (i) eVar;
            iVar.a(Short.parseShort(split[1]));
            iVar.vZ(split[2]);
        } else {
            eVar = new com.tencent.mm.plugin.appbrand.s.e.d();
            eVar.vY(split[1]);
        }
        while (true) {
            r2 = r(byteBuffer);
            if (r2 != null && r2.length() > 0) {
                String[] split2 = r2.split(":", 2);
                if (split2.length != 2) {
                    throw new com.tencent.mm.plugin.appbrand.s.c.d("not an http header");
                }
                eVar.put(split2[0], split2[1].replaceFirst("^ +", ""));
            } else if (r2 == null) {
                return eVar;
            } else {
                throw new com.tencent.mm.plugin.appbrand.s.c.a();
            }
        }
        if (r2 == null) {
            return eVar;
        }
        throw new com.tencent.mm.plugin.appbrand.s.c.a();
    }

    public static int lR(int i) {
        if (i >= 0) {
            return i;
        }
        throw new com.tencent.mm.plugin.appbrand.s.c.b("Negative count");
    }

    public final void lS(int i) {
        this.gCU = i;
    }
}
