package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.l;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

class o$1 implements Runnable {
    final /* synthetic */ String bAj;
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ String fQh;
    final /* synthetic */ String fQi;
    final /* synthetic */ o fQj;

    o$1(o oVar, String str, String str2, l lVar, int i, String str3) {
        this.fQj = oVar;
        this.bAj = str;
        this.fQh = str2;
        this.fCl = lVar;
        this.doP = i;
        this.fQi = str3;
    }

    public final void run() {
        AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(this.bAj, this.fQh);
        if (itemByLocalId == null) {
            this.fCl.E(this.doP, this.fQj.f("fail:file doesn't exist", null));
            return;
        }
        File file = new File(itemByLocalId.dDG);
        String str = this.fQi;
        Object obj = -1;
        switch (str.hashCode()) {
            case 107902:
                if (str.equals("md5")) {
                    obj = null;
                    break;
                }
                break;
            case 3528965:
                if (str.equals("sha1")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                obj = g.m(file);
                break;
            case 1:
                obj = o.B(file);
                break;
            default:
                obj = "";
                break;
        }
        Map hashMap = new HashMap(2);
        hashMap.put("size", Long.valueOf(file.length()));
        hashMap.put("digest", obj);
        this.fCl.E(this.doP, this.fQj.f("ok", hashMap));
    }
}
