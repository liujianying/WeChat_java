package com.tencent.mm.plugin.zero;

import android.app.Service;
import com.tencent.mm.by.a;

public final class PluginZero$a extends a<com.tencent.mm.plugin.zero.a.a> implements com.tencent.mm.plugin.zero.a.a {
    public final void a(Service service) {
        a(new 1(this, service));
    }

    public final void b(final Service service) {
        a(new a.a<com.tencent.mm.plugin.zero.a.a>() {
            public final /* synthetic */ void aD(Object obj) {
                ((com.tencent.mm.plugin.zero.a.a) obj).b(service);
            }
        });
    }
}
