package com.tencent.mm.p;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.g.a.jr;
import com.tencent.mm.g.a.st;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    private static ad bzA;

    public static boolean bw(Context context) {
        if (!BQ()) {
            return false;
        }
        x.i("MicroMsg.DeviceOccupy", "isMultiTalking");
        Toast.makeText(context, h.multitalk_in_toast, 0).show();
        return true;
    }

    public static boolean BQ() {
        jr jrVar = new jr();
        jrVar.bTt.action = 1;
        com.tencent.mm.sdk.b.a.sFg.m(jrVar);
        return jrVar.bTu.bTv;
    }

    public static boolean bx(Context context) {
        st stVar = new st();
        com.tencent.mm.sdk.b.a.sFg.m(stVar);
        if (stVar.cdA.cdC) {
            x.i("MicroMsg.DeviceOccupy", "isCameraUsing");
            Toast.makeText(context, i(context, stVar.cdA.cdB), 0).show();
        }
        return stVar.cdA.cdC;
    }

    public static boolean by(Context context) {
        st stVar = new st();
        com.tencent.mm.sdk.b.a.sFg.m(stVar);
        if (stVar.cdA.cdD) {
            x.i("MicroMsg.DeviceOccupy", "isVoiceUsing");
            Toast.makeText(context, i(context, stVar.cdA.cdB), 0).show();
        }
        return stVar.cdA.cdD;
    }

    private static String i(Context context, boolean z) {
        if (z) {
            return context.getString(h.cannot_use_feature_bcz_camera_using);
        }
        return context.getString(h.cannot_use_feature_bcz_voice_using);
    }

    public static ad vv() {
        if (bzA == null) {
            bzA = com.tencent.mm.booter.a.xt();
        }
        return bzA;
    }
}
