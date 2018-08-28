package com.tencent.mm.ipcinvoker.wx_extension.a;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;

class a$a implements i<IPCString, Bundle> {
    private a$a() {
    }

    public final /* synthetic */ Object av(Object obj) {
        IPCString iPCString = (IPCString) obj;
        if (g.Ek().dqL.drf && g.Eg().dpD) {
            c fJ = com.tencent.mm.model.c.c.Jx().fJ(iPCString.value);
            Object bundle = new Bundle();
            bundle.putString("layerId", fJ.field_layerId);
            bundle.putString("business", fJ.field_business);
            bundle.putString("expId", fJ.field_expId);
            bundle.putString("rawXML", fJ.field_rawXML);
            bundle.putLong("startTime", fJ.field_startTime);
            bundle.putLong("endTime", fJ.field_endTime);
            bundle.putLong("sequence", fJ.field_sequence);
            bundle.putInt("prioritylevel", fJ.field_prioritylevel);
            bundle.putBoolean("needReport", fJ.field_needReport);
            return bundle;
        }
        x.e("MicroMsg.IPCInvokeTask_GetABTestItem", "kernel or account not ready.");
        return null;
    }
}
