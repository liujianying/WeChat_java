package com.tencent.xweb.xwalk;

import android.content.Context;
import com.tencent.xweb.WebView;
import com.tencent.xweb.c.b;
import com.tencent.xweb.c.g;
import com.tencent.xweb.c.h;
import com.tencent.xweb.c.i.a;
import com.tencent.xweb.xwalk.a.c;
import com.tencent.xweb.xwalk.a.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.xwalk.core.WebViewExtension;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater;

public class XWalkWebFactory implements a {
    static XWalkWebFactory sInstance;
    private boolean mIsDebugMode = false;
    private boolean mIsDebugModeReplase = false;

    public static XWalkWebFactory getInstance() {
        if (sInstance == null) {
            sInstance = new XWalkWebFactory();
        }
        return sInstance;
    }

    private XWalkWebFactory() {
    }

    public Object excute(String str, Object[] objArr) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (str.equals("STR_CMD_GET_DEBUG_VIEW")) {
            return new a((WebView) objArr[0]);
        }
        if (str.equals("STR_CMD_GET_UPDATER")) {
            return new l.a();
        }
        if (str.equals("STR_CMD_CLEAR_SCHEDULER")) {
            c.a(null);
            return null;
        }
        if (str.equals("STR_CMD_SET_DEBUG_MODE_REPLACE")) {
            this.mIsDebugMode = true;
            this.mIsDebugModeReplase = true;
        } else if (str.equals("STR_CMD_SET_DEBUG_MODE_NO_REPLACE")) {
            this.mIsDebugMode = true;
            this.mIsDebugModeReplase = false;
        } else if (str.equals("STR_CMD_SET_DEBUG_MODE_REPLACE_NOW")) {
            tryLoadLocalAssetRuntime((Context) objArr[0], true);
            a.im((Context) objArr[0]);
        }
        return null;
    }

    public h createWebView(WebView webView) {
        try {
            if (h.eM(webView.getContext())) {
                WebViewExtension.updateExtension(false);
                return new h(webView);
            }
        } catch (Exception e) {
            XWalkInitializer.addXWalkInitializeLog("init xwalk crashed:" + e.getMessage());
        }
        return null;
    }

    public void initInterface() {
    }

    public void initEnviroment(Context context) {
        if (this.mIsDebugMode) {
            tryLoadLocalAssetRuntime(context, this.mIsDebugModeReplase);
        }
    }

    public static synchronized boolean tryLoadLocalAssetRuntime(Context context, boolean z) {
        boolean z2 = false;
        synchronized (XWalkWebFactory.class) {
            XWalkEnvironment.init(context);
            if (z && XWalkEnvironment.getAvailableVersion() == 999) {
                XWalkEnvironment.delApiVersion(999);
            }
            if (XWalkEnvironment.getAvailableVersion() == -1 || z) {
                try {
                    InputStream open = context.getAssets().open("runtime_package.zip");
                    File file = new File(XWalkEnvironment.getDownloadZipDir(999));
                    if (file.exists()) {
                        file.delete();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[1048576];
                    while (true) {
                        int read = open.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    open.close();
                    fileOutputStream.close();
                    XWalkUpdater.updateLocalXWalkRuntime();
                    z2 = true;
                } catch (IOException e) {
                }
            }
        }
        return z2;
    }

    public g getJsCore(com.tencent.xweb.g.a aVar, Context context) {
        initWebviewCore(context, null);
        switch (1.vAb[aVar.ordinal()]) {
            case 1:
            case 2:
                if (!d.isXWalkReady()) {
                    return null;
                }
                g gVar;
                if (aVar == com.tencent.xweb.g.a.vAi) {
                    gVar = new g();
                    gVar.init(0);
                    return gVar;
                } else if (aVar != com.tencent.xweb.g.a.vAj) {
                    return null;
                } else {
                    gVar = new g();
                    gVar.init(1);
                    return gVar;
                }
            default:
                return null;
        }
    }

    public boolean initWebviewCore(Context context, WebView.c cVar) {
        boolean io = a.io(context);
        if (cVar != null) {
            if (io) {
                cVar.onCoreInitFinished();
            } else {
                cVar.uL();
            }
        }
        return io;
    }

    public void initCallback(WebViewExtensionListener webViewExtensionListener) {
        a.initCallback(webViewExtensionListener);
    }

    public boolean hasInited() {
        return a.hasInited();
    }

    public boolean hasInitedCallback() {
        return a.hasInitedCallback();
    }

    public boolean isCoreReady() {
        return a.isCoreReady();
    }

    public b.a getCookieManager() {
        return new c();
    }

    public b.b getCookieSyncManager() {
        return new d();
    }
}
