package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.platformtools.x;

final class m$a implements a<IPCInteger, IPCVoid> {
    private m$a() {
    }

    public final /* synthetic */ void a(Object obj, c cVar) {
        x.i("MicroMsg.WebViewBagService", "ipc invoke:%d", Integer.valueOf(((IPCInteger) obj).value));
        m.Bj(r0);
    }
}
