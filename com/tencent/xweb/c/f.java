package com.tencent.xweb.c;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.xweb.e;

public interface f {
    boolean a(String str, String str2, com.tencent.xweb.f fVar);

    boolean a(String str, String str2, String str3, e eVar);

    boolean b(String str, String str2, com.tencent.xweb.f fVar);

    void onHideCustomView();

    void onShowCustomView(View view, CustomViewCallback customViewCallback);

    void w(String str, Bitmap bitmap);
}
