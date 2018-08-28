package com.tencent.xweb.x5;

import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.xweb.m;

public final class a {

    public static class d<T> implements ValueCallback<T> {
        android.webkit.ValueCallback<T> vDt;

        public d(android.webkit.ValueCallback<T> valueCallback) {
            this.vDt = valueCallback;
        }

        public final void onReceiveValue(T t) {
            if (this.vDt != null) {
                this.vDt.onReceiveValue(t);
            }
        }
    }

    public static WebResourceResponse b(m mVar) {
        if (mVar == null) {
            return null;
        }
        return new WebResourceResponse(mVar.mMimeType, mVar.mEncoding, mVar.mStatusCode, mVar.mReasonPhrase, mVar.mResponseHeaders, mVar.mInputStream);
    }
}
