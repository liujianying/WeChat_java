package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.at;
import java.util.HashMap;
import java.util.LinkedList;

public final class f {
    private at dMA = new at(1, "chatting-image-gallery-preload-loader");
    private int if = 0;
    protected com.tencent.mm.a.f<String, Bitmap> jDs = new com.tencent.mm.a.f(4, new 1(this));
    private boolean jDv = false;
    public LinkedList<String> qD = new LinkedList();
    protected HashMap<String, Long> tVp = new HashMap();

    public final void aRU() {
        this.jDs.a(new 2(this));
    }
}
