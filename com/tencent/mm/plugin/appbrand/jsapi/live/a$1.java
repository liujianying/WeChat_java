package com.tencent.mm.plugin.appbrand.jsapi.live;

import java.util.ArrayList;
import java.util.List;

class a$1 implements Runnable {
    final /* synthetic */ a$a fRx;
    final /* synthetic */ String val$url;

    a$1(String str, a$a a_a) {
        this.val$url = str;
        this.fRx = a_a;
    }

    public final void run() {
        if (!a.ajb().containsKey(this.val$url)) {
            a.ajb().put(this.val$url, new ArrayList());
        }
        ((List) a.ajb().get(this.val$url)).add(this.fRx);
    }
}
