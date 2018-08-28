package com.tencent.mm.plugin.soter.d;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.d.a.c.f;
import com.tencent.d.b.b.a;
import com.tencent.d.b.f.i;
import com.tencent.mm.plugin.soter.c.h;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends i {
    public e(Context context, com.tencent.d.b.f.e eVar) {
        super(context, eVar);
    }

    @SuppressLint({"DefaultLocale"})
    protected final void b(String str, int[] iArr) {
        x.v("MicroMsg.SoterTaskInitForWX", "alvinluo generateAuthKeyNames");
        for (int i : iArr) {
            Object bFk;
            if (i == 1) {
                bFk = h.bFk();
            } else {
                bFk = String.format("SoterAuthKey_salt%s_scene%d", new Object[]{f.oV(str), Integer.valueOf(i)});
            }
            x.i("MicroMsg.SoterTaskInitForWX", "alvinluo scene: %d, authKeyName: %s", new Object[]{Integer.valueOf(i), bFk});
            a.cFO().cFQ().put(i, bFk);
        }
    }
}
