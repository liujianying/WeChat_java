package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.g.a.su;
import com.tencent.mm.plugin.wear.model.f.l;
import com.tencent.mm.protocal.c.caa;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

class e$6 extends c<su> {
    final /* synthetic */ e pJo;

    e$6(e eVar) {
        this.pJo = eVar;
        this.sFo = su.class.getName().hashCode();
    }

    private static boolean a(su suVar) {
        switch (suVar.cdE.bOh) {
            case 3:
                Object obj = suVar.cdE.cdy;
                if (obj != null && obj.length >= 10 && obj[0] == (byte) 1) {
                    caa caa;
                    Object obj2 = new byte[(obj.length - 1)];
                    System.arraycopy(obj, 1, obj2, 0, obj2.length);
                    try {
                        caa = (caa) new caa().aG(obj2);
                    } catch (IOException e) {
                        caa = null;
                    }
                    if (caa != null) {
                        String str = caa.svS;
                        int i = caa.svK;
                        x.i("MicroMsg.Wear.WearLogic", "voip invite talker=%s | type=%s", new Object[]{str, Integer.valueOf(i)});
                        a.bSl().pIS.a(new l(20010, str));
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
