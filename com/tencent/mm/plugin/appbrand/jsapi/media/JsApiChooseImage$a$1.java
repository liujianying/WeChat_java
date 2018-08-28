package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.a;

class JsApiChooseImage$a$1 implements OnCancelListener {
    final /* synthetic */ a fUq;

    JsApiChooseImage$a$1(a aVar) {
        this.fUq = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.fUq.fUm.bjW = 0;
        a.a(this.fUq, this.fUq.fUm);
    }
}
