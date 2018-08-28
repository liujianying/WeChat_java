package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import android.os.Looper;
import com.tencent.mm.g.a.tu;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

public final class WebViewCacheDownloadHelper {
    private static final byte[] pTB = new byte[0];
    private static volatile WebViewCacheDownloadHelper pTC = null;

    private WebViewCacheDownloadHelper() {
    }

    public static WebViewCacheDownloadHelper bUM() {
        if (pTC == null) {
            synchronized (pTB) {
                if (pTC == null) {
                    pTC = new WebViewCacheDownloadHelper();
                }
            }
        }
        return pTC;
    }

    public static void bUN() {
        FileOp.I(a.pTA, false);
    }

    static void a(f fVar) {
        b tuVar = new tu();
        tuVar.cfw.url = fVar.url;
        tuVar.cfw.filePath = fVar.filePath;
        tuVar.cfw.version = fVar.version;
        tuVar.cfw.appId = fVar.appId;
        tuVar.cfw.cfx = fVar.cfx;
        tuVar.cfw.cfy = fVar.cfy;
        tuVar.cfw.cfz = fVar.cfz;
        tuVar.cfw.aBC = fVar.aBC;
        tuVar.cfw.exception = fVar.exception;
        tuVar.cfw.cfA = fVar.cfA;
        a.sFg.a(tuVar, Looper.getMainLooper());
    }
}
