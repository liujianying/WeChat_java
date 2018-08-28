package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.a;
import java.util.ArrayList;

class JsApiChooseImage$a$3 implements Runnable {
    final /* synthetic */ String ewx;
    final /* synthetic */ a fUq;

    JsApiChooseImage$a$3(a aVar, String str) {
        this.fUq = aVar;
        this.ewx = str;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.putExtra("key_send_raw_image", !this.fUq.fUl.fUi);
        intent.putExtra("max_select_count", this.fUq.fUl.count);
        intent.putExtra("query_source_type", this.fUq.fUn);
        intent.putExtra("isPreviewPhoto", true);
        intent.putExtra("max_select_count", 1);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this.ewx);
        intent.putStringArrayListExtra("preview_image_list", arrayList);
        intent.putExtra("preview_image", true);
        intent.addFlags(67108864);
        a.a(this.fUq, "gallery", ".ui.GalleryEntryUI", intent);
    }
}
