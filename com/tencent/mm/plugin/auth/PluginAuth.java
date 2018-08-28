package com.tencent.mm.plugin.auth;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.model.av;
import com.tencent.mm.plugin.auth.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.u;

public class PluginAuth extends f implements b {
    private final a gQW = new a();

    private static final class a extends com.tencent.mm.by.a<com.tencent.mm.plugin.auth.a.a> implements com.tencent.mm.plugin.auth.a.a {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void a(i.f fVar, g gVar, boolean z) {
            a(new 1(this, fVar, gVar, z));
        }

        public final void a(u.b bVar, String str, int i, String str2, String str3, int i2) {
            a(new 2(this, bVar, str, i, str2, str3, i2));
        }
    }

    public void installed() {
        alias(b.class);
    }

    public void dependency() {
        dependsOn(o.class);
    }

    public void configure(com.tencent.mm.kernel.b.g gVar) {
        av.a(new 1(this));
    }

    public void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    public String toString() {
        return "plugin-auth";
    }

    public com.tencent.mm.vending.b.b addHandleAuthResponse(com.tencent.mm.plugin.auth.a.a aVar) {
        return this.gQW.aI(aVar);
    }

    public com.tencent.mm.plugin.auth.a.a getHandleAuthResponseCallbacks() {
        return this.gQW;
    }
}
