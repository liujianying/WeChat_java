package com.tencent.mm.plugin.ext;

import android.content.SharedPreferences;
import com.tencent.mm.g.a.fb;
import com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi;
import com.tencent.mm.plugin.ext.provider.ExtControlProviderEntry;
import com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg;
import com.tencent.mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public class b$a extends c<fb> {
    public b$a() {
        this.sFo = fb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fb fbVar = (fb) bVar;
        if (!(fbVar instanceof fb)) {
            x.f("MicroMsg.SubCoreExt", "mismatched event");
            return false;
        } else if (fbVar.bNg == null) {
            x.e("MicroMsg.SubCoreExt", "revent.data is null");
            return false;
        } else {
            if (fbVar.bNg.bMB == 9 || fbVar.bNg.bMB == 13) {
                ExtControlProviderMsg extControlProviderMsg = new ExtControlProviderMsg(fbVar.bNg.bGj, fbVar.bNg.bMB, fbVar.bNg.context);
                fbVar.bNh.bMC = extControlProviderMsg.query(fbVar.bNg.uri, null, null, fbVar.bNg.selectionArgs, null);
            } else if (fbVar.bNg.bMB == 3) {
                ExtControlProviderEntry extControlProviderEntry = new ExtControlProviderEntry(fbVar.bNg.bGj, fbVar.bNg.bMB, fbVar.bNg.context);
                fbVar.bNh.bMC = extControlProviderEntry.query(fbVar.bNg.uri, null, null, fbVar.bNg.selectionArgs, null);
            } else if (fbVar.bNg.bMB == 29) {
                ExtControlProviderVoiceControl extControlProviderVoiceControl = new ExtControlProviderVoiceControl(fbVar.bNg.bGj, fbVar.bNg.bMB, fbVar.bNg.context);
                fbVar.bNh.bMC = extControlProviderVoiceControl.query(fbVar.bNg.uri, null, null, fbVar.bNg.selectionArgs, null);
                SharedPreferences chZ = ad.chZ();
                if (!b.yT()) {
                    chZ.edit().putBoolean("hasCallVoiceControlApi", true).commit();
                    b.Ju();
                }
            } else {
                ExtControlProviderOpenApi extControlProviderOpenApi = new ExtControlProviderOpenApi(fbVar.bNg.bGj, fbVar.bNg.bMB, fbVar.bNg.context);
                fbVar.bNh.bMC = extControlProviderOpenApi.query(fbVar.bNg.uri, null, null, fbVar.bNg.selectionArgs, null);
            }
            return true;
        }
    }
}
