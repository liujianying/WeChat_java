package com.tencent.mm.plugin.webview.ui.tools.bag;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class m implements InvocationHandler {
    private boolean mEnable;
    private l qcI;
    private g qcJ = new 1(this);

    public static g a(MMActivity mMActivity, MMWebView mMWebView, boolean z) {
        InvocationHandler mVar = new m(mMActivity, mMWebView, z);
        return (g) Proxy.newProxyInstance(m.class.getClassLoader(), new Class[]{g.class}, mVar);
    }

    private m() {
    }

    private m(MMActivity mMActivity, MMWebView mMWebView, boolean z) {
        this.mEnable = z;
        if (z) {
            this.qcI = new l(mMActivity, mMWebView);
        }
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        if (this.mEnable) {
            try {
                return method.invoke(this.qcI, objArr);
            } catch (InvocationTargetException e) {
                x.i("MicroMsg.WebViewUIBagHelperProxy", "mWebViewUIBagHelper invoke e:%s", new Object[]{e});
                throw e.getCause();
            }
        }
        try {
            return method.invoke(this.qcJ, objArr);
        } catch (InvocationTargetException e2) {
            x.i("MicroMsg.WebViewUIBagHelperProxy", "not enable mEmptyHelper invoke e:%s", new Object[]{e2});
            throw e2.getCause();
        }
    }
}
