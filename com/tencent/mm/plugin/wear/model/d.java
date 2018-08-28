package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.wear.model.a.a;
import com.tencent.mm.plugin.wear.model.a.b;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.plugin.wear.model.e.j;
import com.tencent.mm.plugin.wear.model.e.p;
import com.tencent.mm.sdk.platformtools.x;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class d {
    b pJb = new a();
    com.tencent.mm.plugin.wear.model.e.b pJc = new com.tencent.mm.plugin.wear.model.e.b();
    public i pJd = new i();
    j pJe = new j();
    p pJf = new p();

    public final boolean bSq() {
        return bSr() != null && bSr().bSv().size() > 0;
    }

    public final b bSr() {
        if (this.pJb.isAvailable() && this.pJb.bSw()) {
            return this.pJb;
        }
        return null;
    }

    public final boolean ba(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (!bSq()) {
            return false;
        }
        String format = String.format("/wechat/%s/%d", new Object[]{"phone", Long.valueOf(System.currentTimeMillis())});
        b bSr = bSr();
        if (bSr == null) {
            return false;
        }
        b.a u;
        if (bArr.length > 92160) {
            u = bSr.u(format, bArr);
        } else {
            u = bSr.t(format, bArr);
        }
        if (u.code == 0) {
            return true;
        }
        return false;
    }

    public final byte[] bb(byte[] bArr) {
        byte[] bArr2 = null;
        byte[] DE = this.pJc.DE();
        if (bArr == null || DE == null) {
            return bArr2;
        }
        try {
            x.d("MicroMsg.Wear.WearConnectLogic", "sessionKey is not null %s", new Object[]{g.u(DE)});
            Key secretKeySpec = new SecretKeySpec(DE, "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(2, secretKeySpec);
            return instance.doFinal(bArr);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Wear.WearConnectLogic", e, "", new Object[0]);
            return bArr2;
        }
    }

    public final byte[] bc(byte[] bArr) {
        byte[] bArr2 = null;
        byte[] DE = this.pJc.DE();
        if (bArr == null || DE == null) {
            return bArr2;
        }
        try {
            x.d("MicroMsg.Wear.WearConnectLogic", "sessionKey is not null %s", new Object[]{g.u(DE)});
            return com.tencent.mm.plugin.wear.a.a.f(bArr, DE);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Wear.WearConnectLogic", e, "", new Object[0]);
            return bArr2;
        }
    }
}
