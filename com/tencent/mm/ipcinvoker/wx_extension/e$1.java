package com.tencent.mm.ipcinvoker.wx_extension;

import com.tencent.mm.ipcinvoker.a.a;
import com.tencent.mm.ipcinvoker.a.d;
import com.tencent.mm.ipcinvoker.a.e;
import com.tencent.mm.ipcinvoker.wx_extension.e.b;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;

class e$1 extends a {
    final /* synthetic */ e dnn;

    e$1(e eVar) {
        this.dnn = eVar;
    }

    public final void a(d dVar) {
        super.a(dVar);
        dVar.a(b.dnj);
    }

    public final void a(e eVar) {
        super.a(eVar);
        eVar.a(new c());
        eVar.a(new a());
        eVar.a(new d());
    }

    public final void b(d dVar) {
        dVar.c("com.tencent.mm", MainProcessIPCService.class);
        dVar.c("com.tencent.mm:tools", ToolsProcessIPCService.class);
        dVar.c("com.tencent.mm:support", SupportProcessIPCService.class);
    }
}
