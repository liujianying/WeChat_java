package com.tencent.mm.plugin.facedetect.d;

import com.tencent.mm.plugin.facedetect.model.h.a;
import com.tencent.mm.sdk.platformtools.x;

public class b$c {
    private static String TAG = "MicroMsg.IFaceMotion.Factory";

    public static b a(a aVar) {
        if (aVar == null) {
            return null;
        }
        if (aVar.type == 4) {
            x.i(TAG, "hy: is read number");
            return new d(aVar.iNG);
        }
        x.i(TAG, "hy: is normal");
        return new c(aVar.eYF, aVar.iND);
    }
}
