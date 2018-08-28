package com.tencent.mm.plugin.account.model;

import android.os.Bundle;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.v;
import com.tencent.mm.plugin.account.model.g.a;
import com.tencent.mm.sdk.platformtools.x;

public class h implements e, a {
    public void m(Bundle bundle) {
        String string = bundle.getString("access_token");
        String string2 = bundle.getString("expires");
        x.i("MicroMsg.RefreshTokenListener", "onComplete : newToken = " + string + ", expires = " + string2);
        if (string2 != null) {
            g.Ei().DT().set(65832, string2);
        }
        g.Ei().DT().set(65830, string);
        g.Ei().DT().set(65831, Long.valueOf(System.currentTimeMillis()));
        g.DF().a(183, this);
        g.DF().a(new v(2, string), 0);
    }

    public void onError(int i, String str) {
        x.e("MicroMsg.RefreshTokenListener", "onError : errType = " + i + ", errMsg = " + str);
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() == 183) {
            g.DF().b(183, this);
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.RefreshTokenListener", "update token success");
            } else {
                x.e("MicroMsg.RefreshTokenListener", "update token fail");
            }
        }
    }
}
