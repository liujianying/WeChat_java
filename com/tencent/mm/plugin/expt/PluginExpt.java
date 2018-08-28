package com.tencent.mm.plugin.expt;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.expt.roomexpt.b;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public class PluginExpt extends f implements c, a {
    private static HashMap<Integer, d> hsC;
    private a hsE;

    static {
        HashMap hashMap = new HashMap();
        hsC = hashMap;
        hashMap.put(Integer.valueOf("EXPT_TABLE".hashCode()), new 1());
        hsC.put(Integer.valueOf("EXPT_KEY_MAP_ID_TABLE".hashCode()), new 2());
        hsC.put(Integer.valueOf("CHATROOM_MUTE_EXPT_TABLE".hashCode()), new 3());
    }

    public void installed() {
        alias(a.class);
    }

    public void dependency() {
        dependsOn(o.class);
    }

    public void execute(g gVar) {
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.expt.a.a.class, com.tencent.mm.plugin.expt.b.a.aIu());
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.expt.roomexpt.d.class, com.tencent.mm.plugin.expt.roomexpt.a.aIx());
    }

    public String toString() {
        return "plugin-expt";
    }

    public void onAccountInitialized(e.c cVar) {
        boolean z = false;
        x.i("MicroMsg.PluginExpt", "Plugin expt onAccountInitialized [%d] [%d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(com.tencent.mm.plugin.expt.b.a.aIu().hashCode())});
        initDB();
        com.tencent.mm.plugin.expt.b.a aIu = com.tencent.mm.plugin.expt.b.a.aIu();
        a aVar = this.hsE;
        String str = "MicroMsg.ExptService";
        String str2 = "reset DB [%d] dataDB[%b]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(aIu.hashCode());
        if (aVar != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (aVar != null) {
            aIu.iHQ = new com.tencent.mm.plugin.expt.c.d(aVar);
            aIu.iHR = new com.tencent.mm.plugin.expt.c.c(aVar);
        }
        com.tencent.mm.plugin.expt.roomexpt.a.aIx().iIl = new b(this.hsE);
    }

    public void onAccountRelease() {
        x.i("MicroMsg.PluginExpt", "Plugin expt onAccountRelease [%d] [%d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(com.tencent.mm.plugin.expt.b.a.aIu().hashCode())});
        closeDB();
    }

    private void initDB() {
        if (this.hsE != null) {
            closeDB();
        }
        this.hsE = u.a(hashCode(), com.tencent.mm.kernel.g.Ei().cachePath + "WxExpt.db", hsC, true);
    }

    private void closeDB() {
        if (this.hsE != null) {
            this.hsE.iQ(hashCode());
        }
        this.hsE = null;
    }
}
