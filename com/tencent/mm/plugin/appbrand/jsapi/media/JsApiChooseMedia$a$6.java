package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class JsApiChooseMedia$a$6 implements Runnable {
    final /* synthetic */ String ewx;
    final /* synthetic */ a fUI;
    final /* synthetic */ boolean fUt;

    JsApiChooseMedia$a$6(a aVar, boolean z, String str) {
        this.fUI = aVar;
        this.fUt = z;
        this.ewx = str;
    }

    public final void run() {
        String access$1500 = this.fUt ? a.access$1500(this.ewx) : this.ewx;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        AppBrandLocalMediaObject attach = AppBrandLocalMediaObjectManager.attach(a.h(this.fUI).appId, access$1500, this.fUt | 1);
        if (attach != null) {
            arrayList.add(Long.valueOf(attach.eyz));
            arrayList2.add(attach.bNH);
            ah.A(new 1(this, arrayList2, arrayList));
            return;
        }
        x.e("MicroMsg.JsApiChooseMedia", "handle image from mm-sight camera, get null obj from path: %s", new Object[]{this.ewx});
        a.e(this.fUI).bjW = -2;
        a.h(this.fUI, a.e(this.fUI));
    }
}
