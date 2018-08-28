package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import android.webkit.WebIconDatabase.IconListener;

class bl implements IconListener {
    final /* synthetic */ WebIconDatabase$a a;
    final /* synthetic */ WebIconDatabase b;

    bl(WebIconDatabase webIconDatabase, WebIconDatabase$a webIconDatabase$a) {
        this.b = webIconDatabase;
        this.a = webIconDatabase$a;
    }

    public void onReceivedIcon(String str, Bitmap bitmap) {
        this.a.a(str, bitmap);
    }
}
