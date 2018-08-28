package com.tencent.mm.plugin.ext.openapi.provider;

import android.database.MatrixCursor;
import com.tencent.mm.g.a.ez;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.x;

class ExtControlProviderOpenApi$1 extends bd<MatrixCursor> {
    final /* synthetic */ String[] dhB;
    final /* synthetic */ ExtControlProviderOpenApi iJG;

    ExtControlProviderOpenApi$1(ExtControlProviderOpenApi extControlProviderOpenApi, String[] strArr) {
        this.iJG = extControlProviderOpenApi;
        this.dhB = strArr;
        super(20000, null);
    }

    private MatrixCursor aIU() {
        try {
            x.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
            ez ezVar = new ez();
            ezVar.bMZ.bNb = this.dhB;
            ezVar.bJX = new 1(this, ezVar);
            if (!a.sFg.m(ezVar)) {
                x.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList publish getWifiListEvent fail");
                cf(com.tencent.mm.pluginsdk.d.a.a.BA(8));
            }
        } catch (Exception e) {
            x.e("MicroMsg.ExtControlProviderOpenApi", "exception in getWifiList syncTaskCur.", new Object[]{e});
            cf(com.tencent.mm.pluginsdk.d.a.a.BA(12));
        }
        return null;
    }
}
