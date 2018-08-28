package com.tencent.mm.plugin.auth;

import com.tencent.mm.model.av.a;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.i.g;

class PluginAuth$1 implements a {
    final /* synthetic */ PluginAuth gQX;

    PluginAuth$1(PluginAuth pluginAuth) {
        this.gQX = pluginAuth;
    }

    public final void a(f fVar, g gVar) {
        z.a(gVar.qWn, true);
        this.gQX.getHandleAuthResponseCallbacks().a(fVar, gVar, true);
    }
}
