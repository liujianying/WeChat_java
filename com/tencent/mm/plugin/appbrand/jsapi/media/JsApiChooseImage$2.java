package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.ChooseResult;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class JsApiChooseImage$2 implements b<ChooseResult> {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ JsApiChooseImage fUf;

    JsApiChooseImage$2(JsApiChooseImage jsApiChooseImage, l lVar, int i) {
        this.fUf = jsApiChooseImage;
        this.fCl = lVar;
        this.doP = i;
    }

    public final /* synthetic */ void c(ProcessResult processResult) {
        ChooseResult chooseResult = (ChooseResult) processResult;
        if (chooseResult != null) {
            switch (chooseResult.bjW) {
                case -1:
                    ArrayList arrayList = chooseResult.fUk;
                    if (bi.cX(arrayList)) {
                        x.e("MicroMsg.JsApiChooseImage", "onActivityResult, result list is null or nil");
                        break;
                    }
                    ArrayList arrayList2 = new ArrayList(arrayList.size());
                    ArrayList arrayList3 = new ArrayList(arrayList.size());
                    ArrayList arrayList4 = new ArrayList(arrayList.size());
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        AppBrandLocalMediaObject appBrandLocalMediaObject = (AppBrandLocalMediaObject) it.next();
                        if (!(appBrandLocalMediaObject == null || bi.oW(appBrandLocalMediaObject.bNH))) {
                            arrayList2.add(appBrandLocalMediaObject.bNH);
                            arrayList3.add(Long.valueOf(appBrandLocalMediaObject.eyz));
                            arrayList4.add(appBrandLocalMediaObject.dDG);
                        }
                    }
                    x.i("MicroMsg.JsApiChooseImage", "onActivityResult, localIds json list string = %s", new Object[]{JsApiChooseImage.i(arrayList2)});
                    Map hashMap = new HashMap(1);
                    hashMap.put("tempFilePaths", JsApiChooseImage.j(arrayList2));
                    hashMap.put("tempFileSizes", JsApiChooseImage.j(arrayList3));
                    if (com.tencent.mm.sdk.a.b.chp()) {
                        hashMap.put("__realPaths", JsApiChooseImage.j(arrayList4));
                    }
                    this.fCl.E(this.doP, this.fUf.f("ok", hashMap));
                    return;
                case 0:
                    this.fCl.E(this.doP, this.fUf.f("cancel", null));
                    return;
            }
        }
        this.fCl.E(this.doP, this.fUf.f("fail", null));
    }
}
