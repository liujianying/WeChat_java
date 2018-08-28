package com.tencent.mm.plugin.appbrand.s.d;

import com.tencent.mm.plugin.appbrand.s.c.c;
import com.tencent.mm.plugin.appbrand.s.d.d.a;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.nio.ByteBuffer;

public final class b extends e implements a {
    static final ByteBuffer gDG = ByteBuffer.allocate(0);
    private int code;
    private String gDH;

    public b() {
        super(a.gDN);
        dg(true);
    }

    public b(int i, String str) {
        String str2;
        super(a.gDN);
        dg(true);
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        if (i == 1015) {
            str2 = "";
            i = 1005;
        }
        if (i != 1005) {
            byte[] wc = com.tencent.mm.plugin.appbrand.s.f.b.wc(str2);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.putInt(i);
            allocate.position(2);
            ByteBuffer allocate2 = ByteBuffer.allocate(wc.length + 2);
            allocate2.put(allocate);
            allocate2.put(wc);
            allocate2.rewind();
            v(allocate2);
        } else if (str2.length() > 0) {
            throw new com.tencent.mm.plugin.appbrand.s.c.b("A close frame must have a closecode if it has a reason");
        }
    }

    public final int aoJ() {
        return this.code;
    }

    public final String getMessage() {
        return this.gDH;
    }

    public final String toString() {
        return super.toString() + "code: " + this.code;
    }

    public final void v(ByteBuffer byteBuffer) {
        ByteBuffer allocate;
        super.v(byteBuffer);
        this.code = 1005;
        ByteBuffer aoK = super.aoK();
        aoK.mark();
        if (aoK.remaining() >= 2) {
            allocate = ByteBuffer.allocate(4);
            allocate.position(2);
            allocate.putShort(aoK.getShort());
            allocate.position(0);
            this.code = allocate.getInt();
            if (this.code == 1006 || this.code == 1015 || this.code == 1005 || this.code > 4999 || this.code < BaseReportManager.MAX_READ_COUNT || this.code == 1004) {
                throw new c("closecode must not be sent over the wire: " + this.code);
            }
        }
        aoK.reset();
        if (this.code == 1005) {
            this.gDH = com.tencent.mm.plugin.appbrand.s.f.b.w(super.aoK());
            return;
        }
        allocate = super.aoK();
        int position = allocate.position();
        try {
            allocate.position(allocate.position() + 2);
            this.gDH = com.tencent.mm.plugin.appbrand.s.f.b.w(allocate);
            allocate.position(position);
        } catch (Throwable e) {
            throw new c(e);
        } catch (Throwable th) {
            allocate.position(position);
        }
    }

    public final ByteBuffer aoK() {
        if (this.code == 1005) {
            return gDG;
        }
        return super.aoK();
    }
}
