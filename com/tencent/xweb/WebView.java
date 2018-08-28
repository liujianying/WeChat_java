package com.tencent.xweb;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebView.FindListener;
import android.widget.FrameLayout;
import com.tencent.xweb.c.e;
import com.tencent.xweb.c.f;
import com.tencent.xweb.c.h;
import com.tencent.xweb.c.i;
import com.tencent.xweb.util.d;
import com.tencent.xweb.x5.a.a.a.a.b;
import com.tencent.xweb.x5.sdk.c;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class WebView extends FrameLayout implements h {
    static d vAD = d.vAO;
    static String vAE = "";
    static c vAI;
    public boolean isX5Kernel;
    OnLongClickListener uGp;
    h vAF;
    d vAG;
    e vAH;

    public enum a {
        NOT_HOOK,
        HOOK_NOT_EVALUTE_JS,
        HOOK_EVALUTE_JS
    }

    static {
        r.initInterface();
    }

    public static d getPreferedWebviewType(Context context, String str) {
        if (vAD != d.vAO) {
            return vAD;
        }
        XWalkEnvironment.init(context);
        k.ik(context);
        d dVar = d.vAQ;
        if (k.cIn().adC(str) != d.vAO) {
            dVar = k.cIn().adC(str);
            XWalkEnvironment.addXWalkInitializeLog("XWeb.getPreferedWebviewType", "use hard code web type = " + dVar);
        } else if (a.adv(str) != d.vAO) {
            dVar = a.adv(str);
            XWalkEnvironment.addXWalkInitializeLog("XWeb.getPreferedWebviewType", "module " + str + "use cmd web type = " + dVar);
        }
        if (dVar != d.vAP || XWalkEnvironment.hasAvailableVersion()) {
            return dVar;
        }
        return d.vAQ;
    }

    public static void initWebviewCore(Context context, d dVar, String str, c cVar) {
        if (vAD == d.vAO) {
            vAE = str;
            com.tencent.xweb.util.e.adF(str);
            if (str == null) {
                str = "";
            }
            XWalkEnvironment.init(context);
            k.ik(context);
            if (k.cIn().adC(str) != d.vAO) {
                dVar = k.cIn().adC(str);
                XWalkEnvironment.addXWalkInitializeLog("XWeb", "use hard code web type = " + dVar);
            } else if (a.adv(str) != d.vAO) {
                dVar = a.adv(str);
                XWalkEnvironment.addXWalkInitializeLog("XWeb", "module " + str + "use cmd web type = " + dVar);
            }
            a(context, dVar, cVar, true);
        } else if (vAD != dVar) {
            Log.e("xweb.WebView", "invalid set webview kind to diffrent type");
        }
    }

    private static synchronized boolean a(Context context, d dVar, c cVar, boolean z) {
        boolean z2 = false;
        synchronized (WebView.class) {
            if (!a(dVar, context, cVar) && z) {
                dVar = d.vAO;
                d[] dVarArr = new d[]{d.vAQ, d.vAP, d.vAR};
                int i = 0;
                while (i < 3) {
                    if (dVarArr[i] != dVar && a(dVarArr[i], context, cVar)) {
                        dVar = dVarArr[i];
                        break;
                    }
                    i++;
                }
            }
            vAD = dVar;
            if (d.vAO == dVar) {
                com.tencent.xweb.util.e.cJf();
                Log.e("xweb.WebView", "_initWebviewCore finally failed type = " + dVar);
            } else {
                XWalkEnvironment.addXWalkInitializeLog("init webview core type = " + dVar + ", sdk:21,xweb apk ver:" + XWalkEnvironment.getAvailableVersion());
                z2 = true;
            }
        }
        return z2;
    }

    private static boolean a(d dVar, Context context, c cVar) {
        Object obj;
        com.tencent.xweb.c.c cVar2 = new com.tencent.xweb.c.c("loadCore", dVar, 5000);
        if (cVar2.vCB == null) {
            obj = null;
        } else {
            long time = new Date().getTime();
            long j = cVar2.vCB.getLong("INIT_START_TIME", 0);
            long j2 = cVar2.vCB.getLong("INIT_END_TIME", 0);
            if (0 == j) {
                obj = null;
            } else if (j2 - j >= 0 || Math.abs(time - j) > 10800000) {
                obj = null;
            } else {
                j2 = cVar2.vCB.getLong("INIT_START_TIME" + cVar2.vCD, 0);
                if (time <= j2 || time - j2 >= ((long) cVar2.vCC)) {
                    XWalkEnvironment.addXWalkInitializeLog("find recent load crash at " + ((time - j) / 60000) + "minutes ago");
                    obj = 1;
                } else {
                    com.tencent.xweb.c.c.vCE = true;
                    obj = null;
                }
            }
        }
        if (obj != null) {
            com.tencent.xweb.util.e.cIY();
            return false;
        }
        cVar2.cIE();
        boolean z = false;
        try {
            com.tencent.xweb.c.i.a b = i.b(dVar);
            z = b.initWebviewCore(context, cVar);
            if (z) {
                b.cIi().vzV = b.getCookieManager();
                c.vzX = b.getCookieSyncManager();
                com.tencent.xweb.util.e.c(dVar);
            } else {
                XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", "init webview failed type = " + dVar);
            }
            cVar2.cIF();
            return z;
        } catch (Exception e) {
            XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", "init webview got exception  type = " + dVar);
            com.tencent.xweb.util.e.d(dVar);
            return z;
        }
    }

    public static boolean hasInited() {
        if (getCurWebType() == d.vAO || i.b(getCurWebType()) == null) {
            return false;
        }
        return i.b(getCurWebType()).hasInited();
    }

    public static d getCurWebType() {
        return vAD;
    }

    public d getWebCoreType() {
        return this.vAG;
    }

    public static String getCurStrModule() {
        return vAE;
    }

    public WebView(Context context) {
        this(context, null);
    }

    public WebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, 0, d.vAO);
    }

    public WebView(Context context, AttributeSet attributeSet, int i, d dVar) {
        super(context, attributeSet, i);
        this.vAG = d.vAO;
        this.isX5Kernel = false;
        a(dVar);
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    private void a(d dVar) {
        if (XWalkEnvironment.getApplicationContext() == null) {
            XWalkEnvironment.init(getContext());
        }
        if (this.vAG == d.vAO) {
            if (getCurWebType() == d.vAO) {
                a(getContext(), d.vAR, null, true);
                Log.e("xweb.Webview", "use xweb without init, force to use sys web");
            }
            if (dVar == d.vAR) {
                this.vAG = dVar;
            } else {
                this.vAG = getCurWebType();
            }
            this.vAF = i.a(this.vAG, this);
            if (this.vAF == null) {
                d[] dVarArr = new d[]{d.vAP, d.vAR, d.vAQ};
                int i = 0;
                while (i < 3) {
                    if (dVarArr[i] != this.vAG && a(getContext(), dVarArr[i], null, false)) {
                        this.vAF = i.a(dVarArr[i], this);
                        if (this.vAF != null) {
                            this.vAG = getCurWebType();
                            break;
                        }
                    }
                    i++;
                }
            }
            if (this.vAF == null) {
                Log.e("xweb.WebView", "init finally failed type = " + this.vAG);
                com.tencent.xweb.util.e.cJg();
                return;
            }
            addView(this.vAF.getWebViewUI());
            if (this.vAG != d.vAQ) {
                Log.i("xweb.WebView", "this webview instance is using :" + this.vAG);
            } else if (this.vAF.getX5WebViewExtension() != null) {
                this.isX5Kernel = true;
                Log.i("xweb.WebView", "this webview instance is using x5-x5kernal");
            } else {
                Log.i("xweb.WebView", "this webview instance is using x5-syskernal ");
            }
            if (this.vAF.getCurWebviewClient() != null) {
                this.vAF.getCurWebviewClient().vAn = this.vAF.getDefalutOpProvider();
            }
            if (this.vAF.getCurWebChromeClient() != null) {
                this.vAF.getCurWebChromeClient().vAn = this.vAF.getDefalutOpProvider();
            }
            this.vAF.getView().setOnLongClickListener(new 1(this));
            try {
                this.vAH = (e) i.b(d.vAP).excute("STR_CMD_GET_DEBUG_VIEW", new Object[]{this});
                this.vAH.cIy();
            } catch (Exception e) {
                Log.e("xweb.WebView", "create IDebugView failed, use dummy one ");
                this.vAH = new 2(this);
            }
        }
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.uGp = onLongClickListener;
    }

    public Object getX5WebViewExtension() {
        return this.vAF.getX5WebViewExtension();
    }

    public void setWebViewClientExtension(b bVar) {
        this.vAF.setWebViewClientExtension(bVar);
    }

    public boolean super_onTouchEvent(MotionEvent motionEvent) {
        return this.vAF.super_onTouchEvent(motionEvent);
    }

    public boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.vAF.super_onInterceptTouchEvent(motionEvent);
    }

    public void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
        this.vAF.super_onOverScrolled(i, i2, z, z2);
    }

    public boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        return this.vAF.super_dispatchTouchEvent(motionEvent);
    }

    public void super_computeScroll() {
        this.vAF.super_computeScroll();
    }

    public void super_onScrollChanged(int i, int i2, int i3, int i4) {
        this.vAF.super_onScrollChanged(i, i2, i3, i4);
    }

    public boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return this.vAF.super_overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    public void onResume() {
        this.vAF.onResume();
    }

    public void onPause() {
        this.vAF.onPause();
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.vAF.getWebViewUI().setOnTouchListener(onTouchListener);
    }

    public boolean isXWalkKernel() {
        return this.vAG == d.vAP;
    }

    public boolean isSysKernel() {
        return this.vAG == d.vAR;
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.vAF != null) {
            this.vAF.getWebViewUI().setBackgroundResource(i);
        }
    }

    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (this.vAF != null) {
            this.vAF.getWebViewUI().setBackgroundColor(i);
        }
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.vAF != null) {
            this.vAF.getView().setVisibility(i);
        }
    }

    public void drawCanvas(Canvas canvas) {
        if (isXWalkKernel()) {
            canvas.drawBitmap(getBitmap(), 0.0f, 0.0f, null);
        } else {
            draw(canvas);
        }
    }

    public Bitmap getBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);
        if (createBitmap != null) {
            createBitmap.eraseColor(-1);
            Canvas canvas = new Canvas(createBitmap);
            if (isXWalkKernel()) {
                try {
                    Paint paint = new Paint();
                    paint.setXfermode(new PorterDuffXfermode(Mode.SRC_OVER));
                    for (TextureView bitmap : dY(this)) {
                        canvas.drawBitmap(bitmap.getBitmap(), 0.0f, 0.0f, paint);
                    }
                    Bitmap createBitmap2 = Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);
                    getTopView().draw(new Canvas(createBitmap2));
                    canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, paint);
                } catch (Exception e) {
                }
            } else {
                draw(canvas);
            }
        }
        return createBitmap;
    }

    private List<TextureView> dY(View view) {
        List<TextureView> arrayList = new ArrayList();
        if (view instanceof TextureView) {
            arrayList.add((TextureView) view);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                arrayList.addAll(dY(viewGroup.getChildAt(i)));
            }
        }
        return arrayList;
    }

    public void setFocusable(boolean z) {
        if (z) {
            setDescendantFocusability(131072);
            super.setFocusable(false);
            return;
        }
        setDescendantFocusability(393216);
        super.setFocusable(false);
    }

    public void setFocusableInTouchMode(boolean z) {
        if (z) {
            setDescendantFocusability(131072);
            super.setFocusableInTouchMode(false);
            return;
        }
        setDescendantFocusability(393216);
        super.setFocusableInTouchMode(false);
    }

    public void onWebViewScrollChanged(int i, int i2, int i3, int i4) {
    }

    public View getView() {
        return this.vAF.getView();
    }

    public ViewGroup getTopView() {
        return this.vAF.getTopView();
    }

    public String getUrl() {
        return this.vAF.getUrl();
    }

    public void removeJavascriptInterface(String str) {
        this.vAF.removeJavascriptInterface(str);
    }

    public void stopLoading() {
        this.vAF.stopLoading();
    }

    public void setWebViewCallbackClient(o oVar) {
        this.vAF.setWebViewCallbackClient(oVar);
    }

    public b getHitTestResult() {
        return this.vAF.getHitTestResult();
    }

    public String getTitle() {
        return this.vAF.getTitle();
    }

    public void clearMatches() {
        this.vAF.clearMatches();
    }

    public void findNext(boolean z) {
        this.vAF.findNext(z);
    }

    public void findAllAsync(String str) {
        this.vAF.findAllAsync(str);
    }

    public String getVersionInfo() {
        return this.vAF.getVersionInfo();
    }

    public String getAbstractInfo() {
        return this.vAF.getAbstractInfo();
    }

    public p getCurWebviewClient() {
        return this.vAF.getCurWebviewClient();
    }

    public j getCurWebChromeClient() {
        return this.vAF.getCurWebChromeClient();
    }

    public static void setX5Interface(c cVar) {
        vAI = cVar;
    }

    public static int getUsingTbsCoreVersion(Context context) {
        if (vAD == d.vAQ) {
            if (vAI != null) {
                return vAI.getTbsCoreVersion(context);
            }
            Log.e("xweb.WebView", "getTbsCoreVersion: sImp is null");
        }
        return 0;
    }

    public static int getInstalledTbsCoreVersion(Context context) {
        if (vAI != null) {
            return vAI.getTbsCoreVersion(context);
        }
        Log.e("xweb.WebView", "getTbsCoreVersion: sImp is null");
        return 0;
    }

    @Deprecated
    public static int getTbsCoreVersion(Context context) {
        if (vAI != null) {
            return vAI.getTbsCoreVersion(context);
        }
        Log.e("xweb.WebView", "getTbsCoreVersion: sImp is null");
        return 0;
    }

    public static int getTbsSDKVersion(Context context) {
        if (vAI != null) {
            return vAI.getTbsSDKVersion(context);
        }
        Log.e("xweb.WebView", "getTbsSDKVersion: sImp is null");
        return 0;
    }

    public static String getCrashExtraMessage(Context context) {
        if (vAI != null) {
            return vAI.getCrashExtraMessage(context);
        }
        Log.e("xweb.WebView", "getCrashExtraMessage: sImp is null");
        return "";
    }

    public static boolean getCanReboot() {
        if (getCurWebType() == d.vAQ) {
            if (vAI != null) {
                return vAI.getCanReboot();
            }
            Log.e("xweb.WebView", "getCanReboot: sImp is null");
        }
        return false;
    }

    public void reload() {
        this.vAF.reload();
    }

    public void clearSslPreferences() {
        this.vAF.clearSslPreferences();
    }

    public void loadData(String str, String str2, String str3) {
        this.vAF.loadData(str, str2, str3);
    }

    public int getContentHeight() {
        return this.vAF.getContentHeight();
    }

    public float getScale() {
        return this.vAF.getScale();
    }

    public int getWebScrollY() {
        return this.vAF.getWebScrollY();
    }

    public int getWebScrollX() {
        return this.vAF.getWebScrollX();
    }

    public boolean isOverScrollStart() {
        return this.vAF.isOverScrollStart();
    }

    public int getVisibleTitleHeight() {
        return this.vAF.getVisibleTitleHeight();
    }

    public boolean overlayHorizontalScrollbar() {
        return this.vAF.overlayHorizontalScrollbar();
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.vAF.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public boolean zoomOut() {
        return this.vAF.zoomOut();
    }

    public boolean zoomIn() {
        return this.vAF.zoomIn();
    }

    @TargetApi(8)
    public void loadUrl(String str, Map<String, String> map) {
        if (this.vAH.adD(str)) {
            this.vAF.loadUrl("http://weixin.qq.com/");
        } else {
            this.vAF.loadUrl(str, map);
        }
    }

    public void addJavascriptInterface(Object obj, String str) {
        this.vAF.addJavascriptInterface(obj, str);
    }

    public void _enablePlatformNotifications() {
    }

    public void _disablePlatformNotifications() {
    }

    @Deprecated
    public static void enablePlatformNotifications() {
        if (getCurWebType() == d.vAR) {
            d.gx("android.webkit.WebView", "enablePlatformNotifications");
        }
    }

    @Deprecated
    public static void disablePlatformNotifications() {
        if (getCurWebType() == d.vAR) {
            d.gx("android.webkit.WebView", "disablePlatformNotifications");
        }
    }

    public n getSettings() {
        return this.vAF.getSettings();
    }

    public View getWebViewUI() {
        return this.vAF.getWebViewUI();
    }

    public void setWebViewClient(p pVar) {
        if (pVar != null) {
            pVar.vAn = this.vAF.getDefalutOpProvider();
        }
        this.vAF.setWebViewClient(pVar);
    }

    public void setWebChromeClient(j jVar) {
        if (jVar != null) {
            jVar.vAn = this.vAF.getDefalutOpProvider();
        }
        this.vAF.setWebChromeClient(jVar);
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        this.vAF.setDownloadListener(downloadListener);
    }

    public void setFindListener(FindListener findListener) {
        this.vAF.setFindListener(findListener);
    }

    public void loadUrl(String str) {
        if (this.vAH.adD(str)) {
            this.vAF.loadUrl("http://weixin.qq.com/");
        } else {
            this.vAF.loadUrl(str);
        }
    }

    public boolean canGoBack() {
        return this.vAF.canGoBack();
    }

    public void goBack() {
        this.vAF.goBack();
    }

    public void clearView() {
        this.vAF.clearView();
    }

    public void destroy() {
        this.vAF.destroy();
    }

    public boolean hasEnteredFullscreen() {
        return this.vAF.hasEnteredFullscreen();
    }

    public void leaveFullscreen() {
        this.vAF.leaveFullscreen();
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.vAF.evaluateJavascript(str, valueCallback);
    }

    public a getFullscreenVideoKind() {
        return this.vAF.getFullscreenVideoKind();
    }

    public com.tencent.xweb.c.b.a getCookieManager() {
        return null;
    }

    public com.tencent.xweb.c.b.b getCookieSyncManager() {
        return null;
    }

    public f getDefalutOpProvider() {
        return null;
    }

    public static boolean isXWalk() {
        return getCurWebType() == d.vAP;
    }

    public static boolean isX5() {
        return getCurWebType() == d.vAQ;
    }

    public static boolean isSys() {
        return getCurWebType() == d.vAR;
    }
}
