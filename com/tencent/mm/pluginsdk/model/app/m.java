package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ac.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public final class m implements t {
    private List<String> qzB = new ArrayList();
    public Vector<String> qzY = new Vector();
    private volatile boolean qzZ = false;

    public m() {
        a.bmi().a(1, this);
    }

    public final void pS(String str) {
        x.d("MicroMsg.AppSettingService", "appId = " + str);
        if (bi.oW(str)) {
            x.e("MicroMsg.AppSettingService", "add appId is null");
            return;
        }
        if (!this.qzY.contains(str)) {
            this.qzY.add(str);
        }
        aUz();
    }

    public final void cS(List<String> list) {
        if (list == null || list.size() == 0) {
            x.e("MicroMsg.AppSettingService", "addAll list is null");
            return;
        }
        for (String str : list) {
            if (!(bi.oW(str) || this.qzY.contains(str))) {
                this.qzY.add(str);
            }
        }
        aUz();
    }

    private void aUz() {
        int i = 20;
        if (this.qzZ) {
            x.d("MicroMsg.AppSettingService", "tryDoScene fail, doing Scene");
        } else if (this.qzY.size() <= 0) {
            x.d("MicroMsg.AppSettingService", "tryDoScene fail, appIdList is empty");
        } else {
            x.d("MicroMsg.AppSettingService", "tryDoScene, appid list size = " + this.qzY.size());
            int size = this.qzY.size();
            if (size <= 20) {
                i = size;
            }
            this.qzZ = true;
            this.qzB.addAll(this.qzY.subList(0, i));
            g.Eh().dpP.a(new y(1, new af(this.qzB)), 0);
        }
    }

    public final void a(int i, int i2, String str, x xVar) {
        if (xVar.getType() == 1) {
            this.qzZ = false;
            x.d("MicroMsg.AppSettingService", "onSceneEnd, list size = " + ((af) xVar).qAq.size());
            this.qzY.removeAll(this.qzB);
            this.qzB.clear();
            aUz();
        }
    }
}
