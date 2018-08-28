package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class e$1 implements ITXSnapshotListener {
    final /* synthetic */ p fJO;
    final /* synthetic */ f fPe;
    final /* synthetic */ e fRR;

    e$1(e eVar, f fVar, p pVar) {
        this.fRR = eVar;
        this.fPe = fVar;
        this.fJO = pVar;
    }

    public final void onSnapshot(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            x.e("MicroMsg.JsApiOperateLivePusher", "onSnapshot: bitmap nil");
            this.fPe.tp(this.fRR.f("fail", null));
            return;
        }
        String str = e.dgl + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"});
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        try {
            String str2;
            Object obj;
            c.a(bitmap, 90, CompressFormat.JPEG, str, true);
            AppBrandLocalMediaObject attach = AppBrandLocalMediaObjectManager.attach(this.fJO.mAppId, str, true);
            if (attach != null) {
                str = attach.bNH;
                str2 = attach.dDG;
                obj = str;
            } else {
                str2 = str;
                String obj2 = str;
            }
            x.i("MicroMsg.JsApiOperateLivePusher", "onSnapshot: actualPath:%s path:%s", new Object[]{str2, obj2});
            Map hashMap = new HashMap();
            hashMap.put("tempImagePath", obj2);
            hashMap.put("width", Integer.valueOf(width));
            hashMap.put("height", Integer.valueOf(height));
            this.fPe.tp(this.fRR.f("ok", hashMap));
        } catch (IOException e) {
            x.e("MicroMsg.JsApiOperateLivePusher", "onSnapshot: exception %s", new Object[]{e.getMessage()});
            this.fPe.tp(this.fRR.f("fail", null));
        }
    }
}
