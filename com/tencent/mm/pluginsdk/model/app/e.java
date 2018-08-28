package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ac.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e {
    public Map<String, Integer> fxF;
    private ag handler;
    public List<r> mTQ;
    public List<r> qzB;
    private al qzC;

    public e() {
        this.qzB = null;
        this.mTQ = null;
        this.fxF = null;
        this.qzC = new al(new 1(this), false);
        this.handler = new 2(this, g.Em().lnJ.getLooper());
        this.qzB = new ArrayList();
        this.mTQ = new ArrayList();
        this.fxF = new HashMap();
        this.qzC.J(600000, 600000);
    }

    public final void cO(String str, int i) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppIconService", "push fail, appId is null");
            return;
        }
        r rVar = new r(str, i);
        if (this.qzB.contains(rVar)) {
            x.i("MicroMsg.AppIconService", "push, appId = " + str + ", iconType = " + i + " already in running list");
        } else if (this.qzB.size() >= 5) {
            x.i("MicroMsg.AppIconService", "running list has reached the max count");
            if (!this.mTQ.contains(rVar)) {
                this.mTQ.add(rVar);
            }
        } else if (a(rVar)) {
            this.qzB.add(rVar);
        }
    }

    final boolean a(r rVar) {
        if (rVar == null) {
            x.e("MicroMsg.AppIconService", "startDownload fail, geticoninfo is null");
            return false;
        }
        int i;
        if (rVar == null) {
            x.e("MicroMsg.AppIconService", "increaseCounter fail, info is null");
            i = 0;
        } else {
            Integer valueOf = Integer.valueOf(bi.a((Integer) this.fxF.get(rVar.toString()), 0));
            if (valueOf.intValue() >= 5) {
                x.e("MicroMsg.AppIconService", "increaseCounter fail, has reached the max try count");
                i = 0;
            } else {
                this.fxF.put(rVar.toString(), Integer.valueOf(valueOf.intValue() + 1));
                i = 1;
            }
        }
        if (i == 0) {
            x.e("MicroMsg.AppIconService", "increaseCounter fail");
            return false;
        }
        f SW = a.bmf().SW(rVar.appId);
        if (SW == null) {
            x.e("MicroMsg.AppIconService", "push, appinfo does not exist, appId = " + rVar.appId);
            return false;
        }
        String str;
        switch (rVar.efG) {
            case 1:
                if (SW.field_appIconUrl != null && SW.field_appIconUrl.length() != 0) {
                    str = SW.field_appIconUrl;
                    break;
                }
                x.e("MicroMsg.AppIconService", "push, appIconUrl is null, appId = " + rVar.appId);
                return false;
            case 2:
                if (SW.field_appWatermarkUrl != null && SW.field_appWatermarkUrl.length() != 0) {
                    str = SW.field_appWatermarkUrl;
                    break;
                }
                x.e("MicroMsg.AppIconService", "push, appWatermarkUrl is null, appId = " + rVar.appId);
                return false;
            case 3:
                if (SW.cmL != null && SW.cmL.length() != 0) {
                    str = SW.cmL;
                    break;
                }
                x.e("MicroMsg.AppIconService", "push, appSuggestionIconUrl is null, appId = " + rVar.appId);
                return false;
                break;
            case 4:
                if (SW.cmW != null && SW.cmW.length() != 0) {
                    str = SW.cmW;
                    break;
                }
                x.e("MicroMsg.AppIconService", "push, servicePanelIconUrl is null, appId = " + rVar.appId);
                return false;
                break;
            case 5:
                if (SW.cmX != null && SW.cmX.length() != 0) {
                    str = SW.cmX;
                    break;
                }
                x.e("MicroMsg.AppIconService", "push, serviceListIconUrl is null, appId = " + rVar.appId);
                return false;
            default:
                x.e("MicroMsg.AppIconService", "push, unknown iconType = " + rVar.efG);
                return false;
        }
        x.i("MicroMsg.AppIconService", "appIconUrl = " + str);
        com.tencent.mm.sdk.f.e.post(new s(this.handler, rVar.appId, rVar.efG, str), "AppIconService_getIcon");
        return true;
    }
}
