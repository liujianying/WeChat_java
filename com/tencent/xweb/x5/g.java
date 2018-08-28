package com.tencent.xweb.x5;

import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.xweb.m;

@JgClassChecked(author = 30, fComment = "checked", lastDate = "20171020", reviewer = 30, vComment = {EType.JSEXECUTECHECK})
public final class g {
    public static m a(WebResourceResponse webResourceResponse) {
        if (webResourceResponse == null) {
            return null;
        }
        return new m(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase(), webResourceResponse.getResponseHeaders(), webResourceResponse.getData());
    }
}
