package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.g.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.nio.charset.Charset;

public final class k {
    public static i h(a aVar) {
        Exception exception;
        i iVar;
        i iVar2 = new i();
        g.Ek();
        String str = (String) g.Ei().DT().get(aVar, null);
        if (str == null) {
            x.i("MicroMsg.RedDotUtil", "load: redDotList data empty");
            return iVar2;
        }
        i iVar3;
        try {
            iVar3 = (i) new i().aG(str.getBytes(Charset.forName("ISO-8859-1")));
            if (iVar3 == null) {
                try {
                    iVar3 = new i();
                } catch (Exception e) {
                    exception = e;
                    iVar = iVar3;
                    x.e("MicroMsg.RedDotUtil", "getRedDotList " + exception.getMessage());
                    iVar3 = iVar;
                    if (iVar3 == null) {
                        return new i();
                    }
                    return iVar3;
                }
            }
        } catch (Exception e2) {
            exception = e2;
            iVar = iVar2;
            x.e("MicroMsg.RedDotUtil", "getRedDotList " + exception.getMessage());
            iVar3 = iVar;
            if (iVar3 == null) {
                return iVar3;
            }
            return new i();
        }
        if (iVar3 == null) {
            return new i();
        }
        return iVar3;
    }
}
