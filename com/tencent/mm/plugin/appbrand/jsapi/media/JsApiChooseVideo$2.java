package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.ChooseResult;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class JsApiChooseVideo$2 implements b<ChooseResult> {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ JsApiChooseVideo fUP;

    JsApiChooseVideo$2(JsApiChooseVideo jsApiChooseVideo, l lVar, int i) {
        this.fUP = jsApiChooseVideo;
        this.fCl = lVar;
        this.doP = i;
    }

    public final /* synthetic */ void c(ProcessResult processResult) {
        ChooseResult chooseResult = (ChooseResult) processResult;
        if (chooseResult != null) {
            switch (chooseResult.bjW) {
                case -1:
                    AppBrandLocalVideoObject appBrandLocalVideoObject = chooseResult.fUR;
                    if (appBrandLocalVideoObject == null) {
                        x.e("MicroMsg.JsApiChooseVideo", "choose result code is OK but videoObj null");
                        break;
                    }
                    Map hashMap = new HashMap();
                    hashMap.put("tempFilePath", appBrandLocalVideoObject.bNH);
                    hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(appBrandLocalVideoObject.duration));
                    hashMap.put("size", Integer.valueOf(appBrandLocalVideoObject.size));
                    hashMap.put("height", Integer.valueOf(appBrandLocalVideoObject.height));
                    hashMap.put("width", Integer.valueOf(appBrandLocalVideoObject.width));
                    this.fCl.E(this.doP, this.fUP.f("ok", hashMap));
                    return;
                case 0:
                    this.fCl.E(this.doP, this.fUP.f("cancel", null));
                    return;
            }
        }
        this.fCl.E(this.doP, this.fUP.f("fail", null));
    }
}
