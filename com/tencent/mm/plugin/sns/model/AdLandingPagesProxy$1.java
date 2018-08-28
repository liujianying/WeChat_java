package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c;
import com.tencent.mm.protocal.c.mv;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class AdLandingPagesProxy$1 implements e {
    final /* synthetic */ AdLandingPagesProxy nmu;

    AdLandingPagesProxy$1(AdLandingPagesProxy adLandingPagesProxy) {
        this.nmu = adLandingPagesProxy;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("AdLandingPagesProxy", "errType %d,errCode %d,errMsg %s,scene %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, lVar.toString()});
        long longValue;
        if (lVar instanceof c) {
            Object obj;
            String str2 = "";
            if (i == 0 && i2 == 0) {
                str2 = ((c) lVar).bVc;
                x.i("AdLandingPagesProxy", "the dynamic string is " + str2 + ", sceneType is " + lVar.getType());
                obj = str2;
            } else {
                x.e("AdLandingPagesProxy", "the netscene is error ,error type is " + i + " error msg is " + str + " sceneType is " + lVar.getType());
                String obj2 = str2;
            }
            if (AdLandingPagesProxy.a(this.nmu).containsKey(lVar)) {
                longValue = ((Long) AdLandingPagesProxy.a(this.nmu).remove(lVar)).longValue();
                this.nmu.CLIENT_CALL("onDynamicUpdateEnd", new Object[]{Long.valueOf(longValue), obj2});
            }
        } else if (lVar instanceof a) {
            if (AdLandingPagesProxy.a(this.nmu).containsKey(lVar)) {
                byte[] toByteArray;
                longValue = ((Long) AdLandingPagesProxy.a(this.nmu).remove(lVar)).longValue();
                mv mvVar = (mv) ((b) lVar.dJd).dIE.dIL;
                if (i == 0 && i2 == 0 && mvVar != null) {
                    try {
                        toByteArray = mvVar.toByteArray();
                    } catch (Throwable e) {
                        x.e("AdLandingPagesProxy", bi.i(e));
                        return;
                    }
                }
                toByteArray = null;
                this.nmu.CLIENT_CALL("onAdChannelEnd", new Object[]{Long.valueOf(longValue), Integer.valueOf(i), Integer.valueOf(i2), toByteArray});
            }
        } else if (lVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b) {
            if (AdLandingPagesProxy.a(this.nmu).containsKey(lVar)) {
                long longValue2 = ((Long) AdLandingPagesProxy.a(this.nmu).remove(lVar)).longValue();
                AdLandingPagesProxy adLandingPagesProxy = this.nmu;
                String str3 = "onFavOfficialItemEnd";
                Object[] objArr = new Object[4];
                objArr[0] = Long.valueOf(longValue2);
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b bVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b) lVar;
                objArr[1] = bVar.nHM != null ? bVar.nHM : "";
                objArr[2] = Integer.valueOf(i);
                objArr[3] = Integer.valueOf(i2);
                adLandingPagesProxy.CLIENT_CALL(str3, objArr);
            }
        } else if (lVar instanceof com.tencent.mm.plugin.sns.a.b.e) {
            x.i("AdLandingPagesProxy", "real time report done.");
        }
    }
}
