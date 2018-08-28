package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.d;

public class MMWebView$a {
    public static MMWebView hf(Context context) {
        try {
            x.i("MMWebView", "TRACE_ORDER:MMWebView.java");
            WebView.initWebviewCore(context, MMWebView.uHn, "tools", null);
            MMWebView.he(context);
            MMWebView mMWebView = new MMWebView(context, null, 0, d.vAR);
            mMWebView.dfF = true;
            MMWebView.b(mMWebView, mMWebView.getIsX5Kernel());
            return mMWebView;
        } catch (Exception e) {
            return null;
        }
    }

    public static MMWebView cS(Context context) {
        x.i("MMWebView", "TRACE_ORDER:MMWebView.java");
        WebView.initWebviewCore(context, MMWebView.uHn, "tools", null);
        MMWebView.he(context);
        MMWebView mMWebView = new MMWebView(context);
        mMWebView.dfF = true;
        MMWebView.c(mMWebView, mMWebView.getIsX5Kernel());
        return mMWebView;
    }

    public static MMWebView l(Activity activity, int i) {
        boolean z = true;
        MMWebView.he(activity);
        MMWebView mMWebView = (MMWebView) activity.findViewById(i);
        mMWebView.dfF = true;
        if (mMWebView.getX5WebViewExtension() == null) {
            z = false;
        }
        MMWebView.d(mMWebView, z);
        return mMWebView;
    }
}
