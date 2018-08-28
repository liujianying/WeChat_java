package com.tencent.mm.plugin.welab.a;

import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.welab.a.a.a;
import com.tencent.mm.plugin.welab.e;
import com.tencent.mm.protocal.c.aqg;
import com.tencent.mm.protocal.c.aqh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.HashMap;
import java.util.Map;

public final class b implements a {
    private Map<String, Integer> qmR = new HashMap();
    private String tag = "";

    public b() {
        bYM();
    }

    private void bYM() {
        this.tag = (String) g.Ei().DT().get(aa.a.sXj, null);
        x.i("LabAppLifeService", "load red tag " + this.tag);
        if (!TextUtils.isEmpty(this.tag)) {
            for (Object obj : this.tag.split("&")) {
                if (!TextUtils.isEmpty(obj)) {
                    String[] split = obj.split("=");
                    if (split != null && split.length == 2) {
                        this.qmR.put(split[0], Integer.valueOf(bi.WU(split[1])));
                    }
                }
            }
        }
    }

    public final boolean RX(String str) {
        if (com.tencent.mm.plugin.welab.b.bYI().RT(str).field_Switch == 2) {
            x.i("LabAppLifeService", "appid %s is open ", new Object[]{str});
            return true;
        }
        x.i("LabAppLifeService", "appid %s is close", new Object[]{str});
        return false;
    }

    public final boolean RY(String str) {
        return this.qmR.get(str) == null || ((Integer) this.qmR.get(str)).intValue() == 0;
    }

    public final void open(String str) {
        this.qmR.put(str, Integer.valueOf(1));
        this.tag += "&" + str + "=1";
        g.Ei().DT().a(aa.a.sXj, this.tag);
        com.tencent.mm.plugin.welab.c.a.a RT = com.tencent.mm.plugin.welab.b.bYI().RT(str);
        e.a aVar = new e.a();
        aVar.bPS = str;
        aVar.qmP = RT.field_expId;
        aVar.timeStamp = System.currentTimeMillis();
        aVar.action = 3;
        e.a(aVar);
    }

    public final boolean RZ(String str) {
        boolean z;
        com.tencent.mm.plugin.welab.c.a.a RT = com.tencent.mm.plugin.welab.b.bYI().RT(str);
        String str2 = "LabAppLifeService";
        StringBuilder append = new StringBuilder("hitExp ").append(str).append(", ");
        if (RT.isRunning()) {
            z = true;
        } else {
            z = false;
        }
        x.i(str2, append.append(z).toString());
        if (RT.isRunning()) {
            return true;
        }
        return false;
    }

    public final void bh(String str, boolean z) {
        int i = 1;
        x.i("LabAppLifeService", "switchEntry " + str + "," + z);
        com.tencent.mm.plugin.welab.c.a.a RT = com.tencent.mm.plugin.welab.b.bYI().RT(str);
        int i2 = z ? 2 : 1;
        if (RT.field_Switch != i2) {
            RT.field_Switch = i2;
            com.tencent.mm.plugin.welab.b.bYI().qmM.c(RT, new String[0]);
            aqh aqh = new aqh();
            aqg aqg = new aqg();
            aqg.rSI = bi.WU(RT.field_expId);
            aqg.rSJ = RT.field_LabsAppId;
            if (RT.field_Switch != 2) {
                i = 2;
            }
            aqg.rDF = i;
            aqh.dav.add(aqg);
            ((i) g.l(i.class)).FQ().b(new h.a(207, aqh));
            e.n(str, RT.field_Switch == 2 ? 4 : 5, false);
        }
    }
}
