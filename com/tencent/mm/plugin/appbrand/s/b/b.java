package com.tencent.mm.plugin.appbrand.s.b;

import com.tencent.mm.plugin.appbrand.s.d.d;
import com.tencent.mm.plugin.appbrand.s.d.e;
import com.tencent.mm.plugin.appbrand.s.e.a;
import com.tencent.mm.plugin.appbrand.s.e.c;
import com.tencent.mm.plugin.appbrand.s.e.f;
import com.tencent.mm.plugin.appbrand.s.e.h;
import com.tencent.mm.plugin.appbrand.s.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class b extends a {
    private d gDA = null;
    private final Random gDB = new Random();
    private ByteBuffer gDz;

    public static int f(f fVar) {
        int i = -1;
        String wa = fVar.wa("Sec-WebSocket-Version");
        if (wa.length() <= 0) {
            return i;
        }
        try {
            return new Integer(wa.trim()).intValue();
        } catch (NumberFormatException e) {
            return i;
        }
    }

    public final int a(a aVar, h hVar) {
        int i = 1;
        String wa = aVar.wa("Sec-WebSocket-Protocol");
        String wa2 = hVar.wa("Sec-WebSocket-Protocol");
        if (!(bi.oW(wa) || bi.oW(wa2))) {
            x.d("MicroMsg.AppBrandNetWork.Draft_10", "respProtocol is %s", new Object[]{wa2});
            for (Object equals : wa.split(", ")) {
                if (wa2.equals(equals)) {
                    break;
                }
            }
            i = 0;
            if (i == 0) {
                return com.tencent.mm.plugin.appbrand.s.b.a.b.gDx;
            }
        }
        if (!aVar.wb("Sec-WebSocket-Key") || !hVar.wb("Sec-WebSocket-Accept")) {
            return com.tencent.mm.plugin.appbrand.s.b.a.b.gDx;
        }
        if (vX(aVar.wa("Sec-WebSocket-Key")).equals(hVar.wa("Sec-WebSocket-Accept"))) {
            return com.tencent.mm.plugin.appbrand.s.b.a.b.gDw;
        }
        return com.tencent.mm.plugin.appbrand.s.b.a.b.gDx;
    }

    public int c(a aVar) {
        int f = f(aVar);
        if (f != 7 && f != 8) {
            return com.tencent.mm.plugin.appbrand.s.b.a.b.gDx;
        }
        Object obj = (aVar.wa("Upgrade").equalsIgnoreCase("websocket") && aVar.wa("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade")) ? 1 : null;
        return obj != null ? com.tencent.mm.plugin.appbrand.s.b.a.b.gDw : com.tencent.mm.plugin.appbrand.s.b.a.b.gDx;
    }

    public final ByteBuffer d(d dVar) {
        int i;
        int i2;
        int i3 = -128;
        int i4 = 0;
        ByteBuffer aoK = dVar.aoK();
        int i5 = this.gCU == com.tencent.mm.plugin.appbrand.s.a.b.gCF ? 1 : 0;
        int i6 = aoK.remaining() <= 125 ? 1 : aoK.remaining() <= 65535 ? 2 : 8;
        if (i6 > 1) {
            i = i6 + 1;
        } else {
            i = i6;
        }
        ByteBuffer allocate = ByteBuffer.allocate(((i5 != 0 ? 4 : 0) + (i + 1)) + aoK.remaining());
        d.a aoN = dVar.aoN();
        if (aoN == d.a.gDI) {
            i = 0;
        } else if (aoN == d.a.gDJ) {
            i = 1;
        } else if (aoN == d.a.gDK) {
            i = 2;
        } else if (aoN == d.a.gDN) {
            i = 8;
        } else if (aoN == d.a.gDL) {
            i = 9;
        } else if (aoN == d.a.gDM) {
            i = 10;
        } else {
            x.e("MicroMsg.AppBrandNetWork.Draft_10", "Don't know how to handle force close" + aoN.toString());
            i = 8;
        }
        if (dVar.aoL()) {
            i2 = -128;
        } else {
            i2 = 0;
        }
        allocate.put((byte) (i | ((byte) i2)));
        byte[] i7 = i((long) aoK.remaining(), i6);
        if (i6 == 1) {
            byte b = i7[0];
            if (i5 == 0) {
                i3 = 0;
            }
            allocate.put((byte) (b | i3));
        } else if (i6 == 2) {
            if (i5 == 0) {
                i3 = 0;
            }
            allocate.put((byte) (i3 | 126));
            allocate.put(i7);
        } else if (i6 == 8) {
            if (i5 == 0) {
                i3 = 0;
            }
            allocate.put((byte) (i3 | 127));
            allocate.put(i7);
        } else {
            x.e("MicroMsg.AppBrandNetWork.Draft_10", "Size representation not supported/specified");
        }
        if (i5 != 0) {
            ByteBuffer allocate2 = ByteBuffer.allocate(4);
            allocate2.putInt(this.gDB.nextInt());
            allocate.put(allocate2.array());
            while (aoK.hasRemaining()) {
                allocate.put((byte) (aoK.get() ^ allocate2.get(i4 % 4)));
                i4++;
            }
        } else {
            allocate.put(aoK);
        }
        allocate.flip();
        return allocate;
    }

    public final List<d> a(ByteBuffer byteBuffer, boolean z) {
        e eVar = new e();
        try {
            eVar.v(byteBuffer);
        } catch (com.tencent.mm.plugin.appbrand.s.c.b e) {
            x.e("MicroMsg.AppBrandNetWork.Draft_10", "createFrames setPayload exception" + e.toString());
        }
        eVar.dg(true);
        eVar.a(d.a.gDK);
        eVar.dh(z);
        return Collections.singletonList(eVar);
    }

    public final List<d> ae(String str, boolean z) {
        e eVar = new e();
        try {
            eVar.v(ByteBuffer.wrap(com.tencent.mm.plugin.appbrand.s.f.b.wc(str)));
        } catch (com.tencent.mm.plugin.appbrand.s.c.b e) {
            x.e("MicroMsg.AppBrandNetWork.Draft_10", "createFrames setPayload exception" + e.toString());
        }
        eVar.dg(true);
        eVar.a(d.a.gDJ);
        eVar.dh(z);
        return Collections.singletonList(eVar);
    }

    private static String vX(String str) {
        String str2 = str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
        try {
            return com.tencent.mm.plugin.appbrand.s.f.a.W(MessageDigest.getInstance("SHA1").digest(str2.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            x.e("MicroMsg.AppBrandNetWork.Draft_10", "not such algorithm " + e.toString());
            return "";
        }
    }

    public com.tencent.mm.plugin.appbrand.s.e.b a(com.tencent.mm.plugin.appbrand.s.e.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put("Connection", "Upgrade");
        bVar.put("Sec-WebSocket-Version", "8");
        byte[] bArr = new byte[16];
        this.gDB.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", com.tencent.mm.plugin.appbrand.s.f.a.W(bArr));
        return bVar;
    }

    public c a(a aVar, i iVar) {
        iVar.put("Upgrade", "websocket");
        iVar.put("Connection", aVar.wa("Connection"));
        iVar.vZ("Switching Protocols");
        String wa = aVar.wa("Sec-WebSocket-Key");
        if (wa == null) {
            throw new com.tencent.mm.plugin.appbrand.s.c.d("missing Sec-WebSocket-Key");
        }
        iVar.put("Sec-WebSocket-Accept", vX(wa));
        return iVar;
    }

    private static byte[] i(long j, int i) {
        byte[] bArr = new byte[i];
        int i2 = (i * 8) - 8;
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) ((int) (j >>> (i2 - (i3 * 8))));
        }
        return bArr;
    }

    public final List<d> s(ByteBuffer byteBuffer) {
        List<d> linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.gDz == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.gDz.remaining();
                if (remaining2 > remaining) {
                    this.gDz.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.gDz.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(u((ByteBuffer) this.gDz.duplicate().position(0)));
                this.gDz = null;
            } catch (a e) {
                this.gDz.limit();
                ByteBuffer allocate = ByteBuffer.allocate(a.lR(e.gDC));
                this.gDz.rewind();
                allocate.put(this.gDz);
                this.gDz = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(u(byteBuffer));
            } catch (a e2) {
                byteBuffer.reset();
                this.gDz = ByteBuffer.allocate(a.lR(e2.gDC));
                this.gDz.put(byteBuffer);
            }
        }
        return linkedList;
    }

    private d u(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        int i = 2;
        if (remaining < 2) {
            throw new a(this, 2);
        }
        byte b = byteBuffer.get();
        boolean z = (b >> 8) != 0;
        byte b2 = (byte) ((b & 127) >> 4);
        if (b2 != (byte) 0) {
            throw new com.tencent.mm.plugin.appbrand.s.c.c("bad rsv " + b2);
        }
        d.a aVar;
        byte b3 = byteBuffer.get();
        Object obj = (b3 & -128) != 0 ? 1 : null;
        b2 = (byte) (b3 & 127);
        b = (byte) (b & 15);
        switch (b) {
            case (byte) 0:
                aVar = d.a.gDI;
                break;
            case (byte) 1:
                aVar = d.a.gDJ;
                break;
            case (byte) 2:
                aVar = d.a.gDK;
                break;
            case (byte) 8:
                aVar = d.a.gDN;
                break;
            case (byte) 9:
                aVar = d.a.gDL;
                break;
            case (byte) 10:
                aVar = d.a.gDM;
                break;
            default:
                throw new com.tencent.mm.plugin.appbrand.s.c.c("unknow optcode " + ((short) b));
        }
        if (z || !(aVar == d.a.gDL || aVar == d.a.gDM || aVar == d.a.gDN)) {
            int intValue;
            if (b2 >= (byte) 0 && b2 <= (byte) 125) {
                b = b2;
            } else if (aVar == d.a.gDL || aVar == d.a.gDM || aVar == d.a.gDN) {
                throw new com.tencent.mm.plugin.appbrand.s.c.c("more than 125 octets");
            } else if (b2 == (byte) 126) {
                i = 4;
                if (remaining < 4) {
                    throw new a(this, 4);
                }
                byte[] bArr = new byte[3];
                bArr[1] = byteBuffer.get();
                bArr[2] = byteBuffer.get();
                intValue = new BigInteger(bArr).intValue();
            } else {
                i = 10;
                if (remaining < 10) {
                    throw new a(this, 10);
                }
                byte[] bArr2 = new byte[8];
                for (intValue = 0; intValue < 8; intValue++) {
                    bArr2[intValue] = byteBuffer.get();
                }
                long longValue = new BigInteger(bArr2).longValue();
                if (longValue > 2147483647L) {
                    x.e("MicroMsg.AppBrandNetWork.Draft_10", "Payloadsize is to big...");
                    b = b2;
                } else {
                    intValue = (int) longValue;
                }
            }
            int i2 = ((obj != null ? 4 : 0) + i) + intValue;
            if (remaining < i2) {
                throw new a(this, i2);
            }
            com.tencent.mm.plugin.appbrand.s.d.c bVar;
            ByteBuffer allocate = ByteBuffer.allocate(a.lR(intValue));
            if (obj != null) {
                byte[] bArr3 = new byte[4];
                byteBuffer.get(bArr3);
                for (i2 = 0; i2 < intValue; i2++) {
                    allocate.put((byte) (byteBuffer.get() ^ bArr3[i2 % 4]));
                }
            } else {
                allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
                byteBuffer.position(byteBuffer.position() + allocate.limit());
            }
            if (aVar == d.a.gDN) {
                bVar = new com.tencent.mm.plugin.appbrand.s.d.b();
            } else {
                bVar = new e();
                bVar.dg(z);
                bVar.a(aVar);
            }
            allocate.flip();
            bVar.v(allocate);
            return bVar;
        }
        throw new com.tencent.mm.plugin.appbrand.s.c.c("control frames may no be fragmented");
    }

    public final void reset() {
        this.gDz = null;
    }

    public a aoI() {
        return new b();
    }

    public final int aoH() {
        return a.a.gDu;
    }
}
