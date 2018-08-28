package com.tencent.mm.aj;

import android.os.HandlerThread;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public class a implements ar {
    private static HandlerThread dTd = null;
    private static ag dTe = null;

    public static boolean c(Runnable runnable, long j) {
        boolean z = false;
        if (runnable == null) {
            return false;
        }
        if (dTe == null || dTd == null) {
            String str = "MicroMsg.GIF.SubCoreGIF";
            String str2 = "check decoder thread available fail, handler[%B] thread[%B] stack[%s]";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(dTe != null);
            if (dTd != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = bi.cjd();
            x.w(str, str2, objArr);
            if (dTe != null) {
                dTe.removeCallbacksAndMessages(null);
            }
            if (dTd != null) {
                dTd.quit();
            }
            HandlerThread Xs = e.Xs("GIF-Decoder");
            dTd = Xs;
            Xs.start();
            dTe = new ag(dTd.getLooper());
        }
        if (j > 0) {
            dTe.postDelayed(runnable, j);
        } else {
            dTe.post(runnable);
        }
        return true;
    }

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        if (dTe != null) {
            dTe.removeCallbacksAndMessages(null);
        }
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        if (dTe != null) {
            dTe.removeCallbacksAndMessages(null);
        }
    }
}
