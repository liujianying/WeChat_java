package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.a;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.l;

class b$1 implements a {
    final /* synthetic */ l fCl;
    final /* synthetic */ b fHv;

    b$1(b bVar, l lVar) {
        this.fHv = bVar;
        this.fCl = lVar;
    }

    public final void bj(Object obj) {
        if (obj instanceof AppbrandDownloadState) {
            AppbrandDownloadState appbrandDownloadState = (AppbrandDownloadState) obj;
            if (this.fCl != null) {
                h a = this.fHv.a(this.fCl);
                a.mData = appbrandDownloadState.ahS().toString();
                a.ahM();
            }
        }
    }
}
