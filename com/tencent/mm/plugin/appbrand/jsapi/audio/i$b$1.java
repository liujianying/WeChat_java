package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.mm.g.a.lk;
import com.tencent.mm.plugin.appbrand.jsapi.audio.i.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class i$b$1 extends c<lk> {
    final /* synthetic */ b fIN;

    i$b$1(b bVar) {
        this.fIN = bVar;
        this.sFo = lk.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        lk lkVar = (lk) bVar;
        x.i("MicroMsg.Record.JsApiOperateRecorder", "mListener callback action : %d", new Object[]{Integer.valueOf(lkVar.bVK.action)});
        if (this.fIN.appId.equalsIgnoreCase(lkVar.bVK.appId)) {
            Map hashMap = new HashMap();
            hashMap.put(DownloadInfoColumns.STATE, lkVar.bVK.state);
            b.a(this.fIN, lkVar.bVK.state);
            if (lkVar.bVK.action == 2) {
                b.b(this.fIN, lkVar.bVK.filePath);
                b.a(this.fIN, lkVar.bVK.duration);
                b.b(this.fIN, lkVar.bVK.fileSize);
                com.tencent.mm.plugin.appbrand.media.record.c.uv(this.fIN.appId);
            }
            if (lkVar.bVK.action == 4) {
                hashMap.put("errCode", Integer.valueOf(lkVar.bVK.errCode));
                Object obj = "";
                if (!TextUtils.isEmpty(lkVar.bVK.Yy)) {
                    obj = lkVar.bVK.Yy;
                }
                hashMap.put("errMsg", obj);
            }
            if (lkVar.bVK.action == 5) {
                if (lkVar.bVK.bVL == null || lkVar.bVK.bVL.length <= 819200) {
                    b.a(this.fIN, lkVar.bVK.bVL);
                } else {
                    b.a(this.fIN, lkVar);
                }
                b.c(this.fIN, lkVar.bVK.bVL != null ? lkVar.bVK.bVL.length : 0);
                b.a(this.fIN, lkVar.bVK.bVM);
                x.i("MicroMsg.Record.JsApiOperateRecorder", "frameBufferSize:%d", new Object[]{Integer.valueOf(b.a(this.fIN))});
            }
            this.fIN.fIt = new JSONObject(hashMap).toString();
            this.fIN.action = lkVar.bVK.action;
            this.fIN.En();
            return true;
        }
        x.e("MicroMsg.Record.JsApiOperateRecorder", "appId is diff, don't send event");
        return false;
    }
}
