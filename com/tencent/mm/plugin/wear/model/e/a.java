package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.List;

public abstract class a {
    public abstract List<Integer> bSy();

    protected abstract byte[] p(int i, byte[] bArr);

    public final void b(int i, int i2, int i3, byte[] bArr) {
        if (zE(i3) && bArr != null) {
            bArr = com.tencent.mm.plugin.wear.model.a.bSl().pIM.bb(bArr);
            if (bArr == null) {
                x.e("MicroMsg.Wear.BaseHttpServer", "request data decrypt error");
                return;
            }
        }
        byte[] p = p(i3, bArr);
        if (bSz()) {
            if (zD(i3)) {
                p = com.tencent.mm.plugin.wear.model.a.bSl().pIM.bc(p);
            }
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeInt(i);
                dataOutputStream.writeInt(i2);
                dataOutputStream.writeInt(i3);
                if (p == null || p.length <= 0) {
                    dataOutputStream.writeInt(0);
                } else {
                    dataOutputStream.writeInt(p.length);
                    dataOutputStream.write(p);
                }
                p = byteArrayOutputStream.toByteArray();
                x.i("MicroMsg.Wear.BaseHttpServer", "send data funId=%d length=%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(p.length)});
                if (zF(i3)) {
                    e.post(new 1(this, p), "WearSendResponseTask");
                } else {
                    com.tencent.mm.plugin.wear.model.a.bSl().pIM.ba(p);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Wear.BaseHttpServer", e, "gen response data error connectType=%d, sessionId=%d, funId=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    protected boolean zD(int i) {
        return false;
    }

    protected boolean zE(int i) {
        return false;
    }

    public boolean zF(int i) {
        return false;
    }

    public boolean bSz() {
        return true;
    }
}
