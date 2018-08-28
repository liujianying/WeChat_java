package com.tencent.mm.ipcinvoker;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.d.c;

class d$a implements a<Bundle, Bundle> {
    private d$a() {
    }

    public final /* synthetic */ void a(Object obj, c cVar) {
        Bundle bundle = (Bundle) obj;
        String string = bundle.getString("Token");
        c.Cy().a(bundle.getString("Event"), new 1(this, string, cVar));
    }
}
