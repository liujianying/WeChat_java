package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowInsets;
import android.view.animation.AnimationUtils;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings.RenderPriority;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bc.a;
import com.tencent.mm.bc.a.b;
import com.tencent.mm.g.a.pb;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToH5FromMiniProgramEvent;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.plugin.webview.model.ak;
import com.tencent.mm.plugin.webview.model.b.1;
import com.tencent.mm.plugin.webview.model.z;
import com.tencent.mm.plugin.webview.model.z.c.2;
import com.tencent.mm.plugin.webview.model.z.c.3;
import com.tencent.mm.plugin.webview.model.z.c.4;
import com.tencent.mm.plugin.webview.model.z.c.5;
import com.tencent.mm.plugin.webview.modelcache.o;
import com.tencent.mm.plugin.webview.modeltools.WebViewClipBoardHelper;
import com.tencent.mm.plugin.webview.modeltools.c;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.bag.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.18;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.60;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.7;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.d;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.qqvideo.proxy.api.IUtils;
import com.tencent.xweb.WebView;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebViewUI extends MMActivity implements OnCreateContextMenuListener, d {
    private static final Pattern jJL = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    private static final Pattern jJM = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    private static final Set<String> pRH;
    private static final ArrayList<ab> pYh = new ArrayList();
    private static RenderPriority pYn = RenderPriority.NORMAL;
    private static int pZb = 0;
    private static IUtils pZg = null;
    private String bJK = "";
    protected String bZM;
    public volatile String cbP = null;
    private int cfR;
    protected a fYl;
    private b fYm = new 3(this);
    private int fromScene;
    public com.tencent.mm.plugin.webview.stub.d gcO = null;
    public e gcP = null;
    k gcQ;
    String gcR;
    int gcS;
    int gcT;
    f gcU;
    WebView.b gcV;
    WebView.b gcW;
    private final c gcX = new c();
    private f.c gda = new 28(this);
    private String goF = "";
    private long grN = 0;
    private String gsE;
    private int gwO;
    private ServiceConnection hKe = new ServiceConnection() {
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            x.i("MicroMsg.WebViewUI", "edw onServiceConnected");
            if (WebViewUI.this.mhH == null) {
                x.e("MicroMsg.WebViewUI", "onServiceConnected, activity destroyed");
                return;
            }
            boolean z;
            WebViewUI.this.gcO = com.tencent.mm.plugin.webview.stub.d.a.Y(iBinder);
            try {
                WebViewUI.this.gcO.a(WebViewUI.this.pRY, WebViewUI.this.hashCode());
            } catch (Exception e) {
                x.e("MicroMsg.WebViewUI", "addCallback fail, ex = %s", new Object[]{e.getMessage()});
            }
            String str = "MicroMsg.WebViewUI";
            String str2 = "onServiceConnected, invoker == null ? %b";
            Object[] objArr = new Object[1];
            if (WebViewUI.this.gcO == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
            g.pXv.gcO = WebViewUI.this.gcO;
            if (!bi.oW(WebViewUI.this.getIntent().getStringExtra("ad_info"))) {
                g gVar = g.pXv;
                String stringExtra = WebViewUI.this.getIntent().getStringExtra("ad_info");
                String str3 = "";
                if (gVar.gcO != null) {
                    try {
                        str3 = gVar.gcO.g(23, null).getString("config_info_username");
                    } catch (RemoteException e2) {
                        x.e("MicroMsg.WebViewReportUtil", "setTraceId getConfigInfo exp:%s", new Object[]{e2});
                    }
                }
                gVar.fr(stringExtra, str3);
            }
            if (WebViewUI.this.gcO == null) {
                x.f("MicroMsg.WebViewUI", "service connect success, while invoker is null");
                WebViewUI.this.finish();
                return;
            }
            WebViewUI.this.ant();
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            x.i("MicroMsg.WebViewUI", "edw onServiceDisconnected");
            if ((WebViewUI.this.pZc && WebViewUI.pZb <= 0) || (!WebViewUI.this.pZc && WebViewUI.pZb <= 1)) {
                com.tencent.mm.plugin.webview.modeltools.b.d(WebViewUI.this.gcO);
                o bUK = o.a.bUK();
                for (int i = 0; i < bUK.pTh.size(); i++) {
                    bUK.pTh.valueAt(i);
                }
                bUK.pTh.clear();
                bUK.pTi.clear();
            }
            if (WebViewUI.this.pZc || WebViewUI.this.pZd || WebViewUI.this.isFinishing()) {
                WebViewUI.this.gcO = null;
                return;
            }
            x.i("MicroMsg.WebViewUI", "maybe mm process crash, try rebind service");
            WebViewUI.this.bVW();
        }
    };
    public ag handler;
    private int height;
    private long hmf = 0;
    public boolean jJB = true;
    private int jJE = 0;
    private List<com.tencent.mm.plugin.webview.ui.tools.jsapi.b> jKW = new ArrayList();
    private long jKX = 0;
    private Map<String, Integer> jKs = new HashMap();
    protected com.tencent.mm.ui.widget.snackbar.a.b jKu = new 67(this);
    protected View jUX;
    private View jUY;
    public int jUZ = 0;
    public String jVa = null;
    public String jkH;
    public MMWebView mhH;
    private boolean nTs = true;
    private int networkType;
    public com.tencent.mm.plugin.webview.ui.tools.jsapi.d pNV = null;
    public ak pQY = new ak();
    public e pRY = new 23(this);
    private volatile String pSD;
    protected boolean pVV = true;
    private final com.tencent.mm.plugin.webview.modeltools.a pWN = new com.tencent.mm.plugin.webview.modeltools.a();
    protected boolean pXA = false;
    public MMFalseProgressBar pXB;
    public ProgressBar pXC;
    private ImageButton pXD;
    private ImageButton pXE;
    private View pXF;
    public FrameLayout pXG;
    public FrameLayout pXH;
    public MovingImageButton pXI;
    public boolean pXJ = false;
    private boolean pXK = false;
    private WebViewInputFooter pXL;
    public WebViewSearchContentInputFooter pXM;
    private boolean pXN;
    private boolean pXO;
    public String pXP = null;
    private boolean pXQ = false;
    public boolean pXR = false;
    private boolean pXS = false;
    private boolean pXT = false;
    private boolean pXU = true;
    private boolean pXV = false;
    private boolean pXW = false;
    private boolean pXX = false;
    private boolean pXY = false;
    private boolean pXZ = true;
    private boolean pYA = false;
    private String pYB = "";
    private String pYC;
    private HashMap<String, Boolean> pYD = new HashMap();
    private HashMap<String, String> pYE = new HashMap();
    private HashMap<String, ArrayList<com.tencent.mm.k.d.b>> pYF = new HashMap();
    private HashMap<String, Boolean> pYG = new HashMap();
    private HashMap<String, Integer> pYH = new HashMap();
    private d pYI;
    private com.tencent.mm.ui.widget.a.c pYJ = null;
    private View pYK;
    protected View pYL = null;
    private String pYM = null;
    private boolean pYN = false;
    private volatile boolean pYO = false;
    private final boolean pYP = true;
    private volatile boolean pYQ = false;
    private final Set<String> pYR = new HashSet();
    private boolean pYS = false;
    private boolean pYT = false;
    private final Map<String, Map<String, String>> pYU = new ConcurrentHashMap();
    private Map<String, String> pYV;
    private Map pYW;
    private String pYX = "";
    private boolean pYY = false;
    private final Map<String, String> pYZ = new HashMap();
    private int pYa;
    private String pYb = null;
    private byte[] pYc = new byte[0];
    private boolean pYd = false;
    private boolean pYe = false;
    View pYf;
    al pYg;
    private boolean pYi = false;
    private CustomViewCallback pYj;
    private View pYk;
    public com.tencent.xweb.j pYl;
    private ProgressBar pYm;
    public m pYo = new m(null);
    protected n pYp = new n();
    protected p pYq = new p(this);
    protected r pYr = new r(this);
    private final com.tencent.mm.sdk.b.c<SendDataToH5FromMiniProgramEvent> pYs = new com.tencent.mm.sdk.b.c<SendDataToH5FromMiniProgramEvent>() {
        {
            this.sFo = SendDataToH5FromMiniProgramEvent.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            SendDataToH5FromMiniProgramEvent sendDataToH5FromMiniProgramEvent = (SendDataToH5FromMiniProgramEvent) bVar;
            if (WebViewUI.this.hashCode() == sendDataToH5FromMiniProgramEvent.fQr && WebViewUI.this.pNV != null) {
                Map hashMap = new HashMap(2);
                hashMap.put("miniprogramAppID", sendDataToH5FromMiniProgramEvent.fQq);
                hashMap.put("data", sendDataToH5FromMiniProgramEvent.data);
                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = WebViewUI.this.pNV;
                ah.A(new 60(dVar, i.a.a("onMiniProgramData", hashMap, dVar.qhs, dVar.qht)));
            }
            return false;
        }
    };
    private boolean pYt = false;
    private aa<String, Bitmap> pYu = new aa(12);
    private HashMap<String, String> pYv = new HashMap();
    private b pYw;
    private int pYx = 0;
    private com.tencent.mm.plugin.webview.ui.tools.jsapi.f pYy;
    protected volatile boolean pYz = false;
    private volatile String pZA = "";
    private volatile String pZB = "";
    private long pZC = 0;
    private p pZD;
    private z.d pZE = new 59(this);
    private z.b pZF = new 60(this);
    private com.tencent.mm.ui.base.i pZG;
    private String[] pZH = null;
    public int pZI = -1;
    private final Set<String> pZa = new HashSet();
    public boolean pZc = false;
    private boolean pZd = false;
    private com.tencent.mm.plugin.webview.model.b pZe = new com.tencent.mm.plugin.webview.model.b(this.pQY);
    private com.tencent.mm.plugin.webview.modeltools.i pZf = new com.tencent.mm.plugin.webview.modeltools.i();
    private WebViewClipBoardHelper pZh;
    private volatile String pZi;
    private volatile long pZj;
    private h pZk;
    private com.tencent.mm.plugin.webview.model.ah pZl = new com.tencent.mm.plugin.webview.model.ah();
    protected com.tencent.xweb.o pZm = new com.tencent.xweb.o() {
        public final boolean z(MotionEvent motionEvent) {
            if (WebViewUI.this.mhH == null) {
                return false;
            }
            return WebViewUI.this.mhH.N(motionEvent);
        }

        public final boolean b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            if (WebViewUI.this.mhH == null) {
                return false;
            }
            return WebViewUI.this.mhH.c(i, i2, i3, i4, i5, i6, i7, i8, z);
        }

        public final void akr() {
            if (WebViewUI.this.mhH != null) {
                WebViewUI.this.mhH.cAz();
            }
        }

        @TargetApi(9)
        public final void c(int i, int i2, boolean z, boolean z2) {
            if (WebViewUI.this.mhH != null) {
                WebViewUI.this.mhH.d(i, i2, z, z2);
                if (z2 && WebViewUI.this.pQY != null) {
                    WebViewUI.this.pQY.u("mm_scroll_bottom", Boolean.valueOf(true));
                }
            }
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            if (WebViewUI.this.mhH != null) {
                WebViewUI.this.mhH.A(i, i2, i3, i4);
                WebViewUI.this.onWebViewScrollChanged(i, i2, i3, i4);
            }
        }

        public final boolean A(MotionEvent motionEvent) {
            if (WebViewUI.this.mhH == null) {
                return false;
            }
            return WebViewUI.this.mhH.O(motionEvent);
        }

        public final boolean B(MotionEvent motionEvent) {
            if (WebViewUI.this.mhH == null) {
                return false;
            }
            return WebViewUI.this.mhH.P(motionEvent);
        }
    };
    private com.tencent.mm.sdk.b.c<pb> pZn = new 34(this);
    private boolean pZo = true;
    private int pZp = 0;
    private boolean pZq = false;
    public final f pZr = new f();
    protected g pZs;
    private boolean pZt;
    private OnLongClickListener pZu = new 25(this);
    String[] pZv;
    private Map<String, SparseBooleanArray> pZw = new HashMap();
    private String pZx = "";
    private volatile String pZy = "";
    private volatile String pZz = null;
    public int screenOrientation = -1;
    private int width;

    private class j implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private final String qaK;

        private j() {
            this.qaK = "weixin://feedback/";
        }

        /* synthetic */ j(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean Dt(String str) {
            if (bi.oW(str)) {
                return false;
            }
            return s.fj(str, "weixin://feedback/");
        }

        public final boolean Du(String str) {
            Bundle bundle = new Bundle();
            bundle.putInt("MMActivity.OverrideEnterAnimation", 0);
            bundle.putInt("MMActivity.OverrideExitAnimation", R.a.push_down_out);
            try {
                WebViewUI.this.gcO.a(7, bundle, WebViewUI.this.hashCode());
            } catch (Exception e) {
                x.w("MicroMsg.WebViewUI", "FeedbackJumpHandler, ex = " + e.getMessage());
            }
            return true;
        }
    }

    private class l implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private l() {
        }

        /* synthetic */ l(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean Dt(String str) {
            if (bi.oW(str)) {
                return false;
            }
            return s.fj(str, "weixin://connectToFreeWifi/");
        }

        public final boolean Du(String str) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("apKey");
            x.i("MicroMsg.WebViewUI", "apKey value = %s", new Object[]{queryParameter});
            String queryParameter2 = parse.getQueryParameter("ticket");
            if (!bi.oW(queryParameter)) {
                Intent intent = new Intent();
                intent.putExtra("free_wifi_schema_uri", parse.toString());
                intent.putExtra("free_wifi_ap_key", queryParameter);
                intent.putExtra("free_wifi_source", 5);
                if (!bi.oW(queryParameter2)) {
                    intent.putExtra("free_wifi_schema_ticket", queryParameter2);
                }
                intent.addFlags(67108864);
                com.tencent.mm.bg.d.b(ad.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent);
            }
            return true;
        }
    }

    protected class n {
        private int qaM = 0;

        protected n() {
        }

        public final void bWJ() {
            x.d("MicroMsg.WebViewUI", "addGetA8KeySceneEndListener, before inc count=%d", new Object[]{Integer.valueOf(this.qaM)});
            if (this.qaM == 0) {
                WebViewUI.this.AJ(233);
            }
            this.qaM++;
        }

        public final void bWK() {
            x.d("MicroMsg.WebViewUI", "removeGetA8KeySceneEndListener, before dec count=%d", new Object[]{Integer.valueOf(this.qaM)});
            this.qaM--;
            if (this.qaM <= 0) {
                WebViewUI.this.AK(233);
            }
        }

        public final boolean bWL() {
            x.d("MicroMsg.WebViewUI", "GetA8KeySceneEndController.hasAddListener count=%d", new Object[]{Integer.valueOf(this.qaM)});
            if (this.qaM > 0) {
                return true;
            }
            return false;
        }
    }

    private class q implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private q() {
        }

        /* synthetic */ q(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean Dt(String str) {
            if (bi.oW(str)) {
                return false;
            }
            return s.fj(str, "weixin://profile/");
        }

        public final boolean Du(String str) {
            String substring = str.substring(17);
            if (substring == null || substring.length() == 0) {
                x.e("MicroMsg.WebViewUI", "handleUrl fail, username is null");
            } else if (!(WebViewUI.this.gcP == null || WebViewUI.this.gcP.bVR() == null || !WebViewUI.this.gcP.bVR().gu(2))) {
                WebViewUI.this.pNV.RF(substring);
            }
            return true;
        }
    }

    static /* synthetic */ void H(WebViewUI webViewUI) {
        View view = webViewUI.mhH.getView();
        view.scrollTo(view.getScrollX(), 0);
        ak.g bUy = webViewUI.pQY.bUy();
        bUy.pSr = new Object[]{webViewUI.cbP, Integer.valueOf(7)};
        bUy.c(webViewUI.gcO);
    }

    static /* synthetic */ void O(WebViewUI webViewUI) {
        CharSequence url = webViewUI.mhH.getUrl();
        if (url == null || url.length() == 0) {
            x.e("MicroMsg.WebViewUI", "copyLink fail, url is null");
            return;
        }
        CharSequence Dp;
        try {
            Dp = webViewUI.gcO.Dp(url);
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "copy link failed");
            Dp = url;
        }
        ClipboardManager clipboardManager = (ClipboardManager) webViewUI.getSystemService("clipboard");
        if (clipboardManager != null) {
            try {
                clipboardManager.setText(Dp);
                Toast.makeText(webViewUI, webViewUI.getString(R.l.wv_alert_copy_link_toast), 0).show();
                return;
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.WebViewUI", e2, "clip.setText error", new Object[0]);
                return;
            }
        }
        x.e("MicroMsg.WebViewUI", "clipboard manager is null");
    }

    static /* synthetic */ void P(WebViewUI webViewUI) {
        com.tencent.mm.plugin.webview.stub.d dVar = webViewUI.gcO;
        if (webViewUI != null && !webViewUI.isFinishing()) {
            String currentURL = webViewUI.getCurrentURL();
            if (bi.oW(currentURL)) {
                x.e("MicroMsg.BrowserChooserHelper", "open in browser fail, url is null");
                return;
            }
            if (dVar != null) {
                try {
                    currentURL = dVar.Dp(currentURL);
                } catch (Exception e) {
                    x.e("MicroMsg.BrowserChooserHelper", "showAndOpenInBrowser, getShareUrl, exception = %s", new Object[]{e});
                }
            }
            if (!(currentURL.startsWith("http://") || currentURL.startsWith("https://"))) {
                currentURL = "http://" + currentURL;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(currentURL));
            try {
                if (bi.fU(webViewUI) || com.tencent.mm.sdk.platformtools.e.chv()) {
                    webViewUI.startActivity(intent);
                } else {
                    webViewUI.startActivityForResult(com.tencent.mm.plugin.webview.modeltools.a.a(webViewUI, intent, currentURL), 2);
                }
            } catch (Exception e2) {
                x.e("MicroMsg.BrowserChooserHelper", "open in browser failed : %s", new Object[]{e2.getMessage()});
            }
        }
    }

    static /* synthetic */ void Q(WebViewUI webViewUI) {
        webViewUI.pNV.bf("sendEmail", true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.pNV;
        if (dVar.qhq) {
            dVar.qhk.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.a("menu:share:email", new HashMap(), dVar.qhs, dVar.qht) + ")", null);
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSendMail fail, not ready");
    }

    static /* synthetic */ String Ru(String str) {
        if (bi.oW(str)) {
            return "";
        }
        return str.length() > 1024 ? str.substring(0, 1024) : str;
    }

    static /* synthetic */ void W(WebViewUI webViewUI) {
        webViewUI.pNV.bf("sendAppMessage", true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.pNV;
        if (dVar.qhq) {
            dVar.qhk.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.a("menu:share:appmessage", new HashMap(), dVar.qhs, dVar.qht) + ")", null);
            try {
                dVar.gcO.H("scene", "wework", dVar.pUz);
                return;
            } catch (Exception e) {
                x.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                return;
            }
        }
        x.e("MicroMsg.JsApiHandler", "onShareWeWork fail, not ready");
    }

    static /* synthetic */ void X(WebViewUI webViewUI) {
        String str = null;
        try {
            str = webViewUI.gcO.Dp(webViewUI.mhH.getUrl());
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "getShareUrl failed : %s", new Object[]{e.getMessage()});
        }
        if (bi.oW(str)) {
            str = webViewUI.cbP;
        }
        try {
            str = "weread://mp?url=" + com.tencent.mm.compatible.util.p.encode(str, "utf-8");
        } catch (Exception e2) {
            x.e("MicroMsg.WebViewUI", "encode url failed ; %s", new Object[]{e2.getMessage()});
        }
        x.i("MicroMsg.WebViewUI", "now url = %s", new Object[]{str});
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        if (bi.k(webViewUI.mController.tml, intent)) {
            webViewUI.startActivity(intent);
        } else {
            x.e("MicroMsg.WebViewUI", "not availble app match this intent");
        }
    }

    static /* synthetic */ void Y(WebViewUI webViewUI) {
        webViewUI.pNV.bf("shareQQ", true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.pNV;
        if (dVar.qhq) {
            dVar.qhk.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.a("menu:share:qq", new HashMap(), dVar.qhs, dVar.qht) + ")", null);
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onShareQQ fail, not ready");
    }

    static /* synthetic */ void Z(WebViewUI webViewUI) {
        webViewUI.pNV.bf("shareWeiboApp", true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.pNV;
        if (dVar.qhq) {
            dVar.qhk.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.a("menu:share:weiboApp", new HashMap(), dVar.qhs, dVar.qht) + ")", null);
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onShareWeiboApp fail, not ready");
    }

    static /* synthetic */ void a(WebViewUI webViewUI, String str, String str2, int i, int i2) {
        if (webViewUI.gcP == null) {
            x.e("MicroMsg.WebViewUI", "startGetReadingModeInfo fail, after onDestroy");
            return;
        }
        p pVar = webViewUI.pYq;
        if (pVar.qaN == 0) {
            pVar.pZJ.AJ(673);
        }
        pVar.qaN++;
        webViewUI.pYB = str;
        webViewUI.pYA = true;
        Bundle bundle = new Bundle();
        bundle.putString("reading_mode_data_url", str);
        bundle.putString("reading_mode_data_useragent", str2);
        bundle.putInt("reading_mode_data_width", i);
        bundle.putInt("reading_mode_data_height", i2);
        bundle.putInt("webview_binder_id", webViewUI.hashCode());
        boolean z = false;
        try {
            z = webViewUI.gcO.s(673, bundle);
        } catch (Exception e) {
            x.w("MicroMsg.WebViewUI", "startGetReadingModeInfo, ex = " + e.getMessage());
        }
        x.d("MicroMsg.WebViewUI", "startGetReadingModeInfo, doScene ret = " + z);
    }

    static /* synthetic */ void aa(WebViewUI webViewUI) {
        webViewUI.pNV.bf("shareQZone", true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.pNV;
        if (dVar.qhq) {
            dVar.qhk.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.a("menu:share:QZone", new HashMap(), dVar.qhs, dVar.qht) + ")", null);
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onShareQzone fail, not ready");
    }

    static /* synthetic */ void ab(WebViewUI webViewUI) {
        webViewUI.pNV.bf("sendAppMessage", true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.pNV;
        if (dVar.qhq) {
            dVar.qhk.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.a("menu:share:appmessage", new HashMap(), dVar.qhs, dVar.qht) + ")", null);
            try {
                dVar.gcO.H("scene", "facebook", dVar.pUz);
                return;
            } catch (Exception e) {
                x.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                return;
            }
        }
        x.e("MicroMsg.JsApiHandler", "onShareFaceBook fail, not ready");
    }

    static /* synthetic */ void ac(WebViewUI webViewUI) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("enterprise_action", "enterprise_connectors");
            Object stringArrayList = webViewUI.gcO.g(71, bundle).getStringArrayList("enterprise_connectors");
            if (stringArrayList != null && stringArrayList.size() > 0) {
                if (stringArrayList.size() == 1) {
                    webViewUI.Rn((String) stringArrayList.get(0));
                    return;
                }
                webViewUI.cO(stringArrayList);
                k kVar = new k(webViewUI.mController.tml);
                kVar.a(webViewUI.mhH, webViewUI, null);
                kVar.uAx = new 50(webViewUI);
                kVar.uAy = new com.tencent.mm.ui.base.n.b() {
                    public final void a(TextView textView, MenuItem menuItem) {
                        String str = menuItem.getTitle();
                        if (textView != null) {
                            String str2 = (String) WebViewUI.this.pYv.get(str);
                            if (bi.oW(str2)) {
                                textView.setText(str);
                            } else {
                                textView.setText(com.tencent.mm.pluginsdk.ui.d.j.a(WebViewUI.this.mController.tml, str2, textView.getTextSize()));
                            }
                        }
                    }
                };
                kVar.b(webViewUI.mhH, new 52(webViewUI, stringArrayList), new 53(webViewUI));
                kVar.bEo();
            }
        } catch (Exception e) {
            x.w("MicroMsg.WebViewUI", "builder add, ex = " + e.getMessage());
        }
    }

    static /* synthetic */ void ad(WebViewUI webViewUI) {
        x.i("MicroMsg.WebViewUI", "JumpToReadArticle");
        if (webViewUI.pNV != null) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.pNV;
            if (dVar.qhq) {
                x.i("MicroMsg.JsApiHandler", "onArticleReadBtnClicked");
                ah.A(new 18(dVar, i.a.a("onArticleReadingBtnClicked", new HashMap(), dVar.qhs, dVar.qht)));
                return;
            }
            x.e("MicroMsg.JsApiHandler", "onArticleReadBtnClicked fail, not ready");
        }
    }

    static /* synthetic */ void h(WebViewUI webViewUI, String str) {
        if (webViewUI.pNV != null) {
            Bundle bundle = new Bundle();
            bundle.putInt(str, 43);
            com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.pNV;
            try {
                dVar.gcO.a(21, bundle, dVar.pUz);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
                x.w("MicroMsg.JsApiHandler", "updateJsapiArgsBundleKV, ex = " + e);
            }
        }
    }

    static /* synthetic */ void i(WebViewUI webViewUI, String str) {
        webViewUI.pNV.bf("profile", true);
        webViewUI.pNV.RF(str);
    }

    static /* synthetic */ void l(WebViewUI webViewUI, String str) {
        webViewUI.pNV.bf("sendAppMessage", false);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.pNV;
        if (dVar.qhq) {
            Map hashMap = new HashMap();
            hashMap.put("scene", "connector");
            dVar.qhk.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.a("menu:share:appmessage", hashMap, dVar.qhs, dVar.qht) + ")", null);
            try {
                dVar.gcO.H("connector_local_send", str, dVar.pUz);
                dVar.gcO.H("scene", "connector", dVar.pUz);
                return;
            } catch (Exception e) {
                x.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                return;
            }
        }
        x.e("MicroMsg.JsApiHandler", "onSendToConnector fail, not ready");
    }

    static /* synthetic */ void o(WebViewUI webViewUI) {
        webViewUI.pZr.pXe = new 4(webViewUI);
        f fVar = webViewUI.pZr;
        fVar.fpo = true;
        if (fVar.pXg != null) {
            fVar.pXg.setVisibility(0);
            fVar.pXg.setMMOverScrollOffsetListener(fVar);
            fVar.pXg.setFastScrollBack(true);
            fVar.pXg.jY(false);
            fVar.pXg.setReleaseTargetHeight(fVar.pXh);
        }
        if (fVar.pXf != null) {
            fVar.pXf.setWillNotDraw(true);
            fVar.pXf.setImageResource(f.pXi);
            fVar.pXf.setVisibility(0);
            fVar.pXf.setAlpha(0.0f);
            fVar.pXf.setWillNotDraw(false);
            fVar.pXf.invalidate();
        }
        if (fVar.pXq != null) {
            fVar.pXq.setVisibility(8);
        }
    }

    static /* synthetic */ void p(WebViewUI webViewUI) {
        if (webViewUI.mhH != null) {
            webViewUI.mhH.evaluateJavascript("javascript:(function(){return window.getComputedStyle(document.body,null).backgroundColor})()", new 5(webViewUI));
        }
    }

    static /* synthetic */ void q(WebViewUI webViewUI, String str) {
        SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) webViewUI.pZw.get(str);
        if (sparseBooleanArray == null) {
            sparseBooleanArray = new SparseBooleanArray();
            webViewUI.pZw.put(str, sparseBooleanArray);
        }
        if (sparseBooleanArray != null) {
            sparseBooleanArray.put(34, true);
        }
    }

    static {
        Set hashSet = new HashSet();
        pRH = hashSet;
        hashSet.add("file:///android_asset/");
        String str = com.tencent.mm.compatible.util.e.duO;
        if (!bi.oW(str)) {
            str = com.tencent.mm.compatible.util.e.duO.replace("/data/user/0", "/data/data");
        }
        pRH.add("file://" + new File(com.tencent.mm.plugin.websearch.api.p.zT(0)).getAbsolutePath());
        pRH.add("file://" + new File(com.tencent.mm.compatible.util.e.bnE, "fts/res").getAbsolutePath());
        pRH.add("file://" + new File(str, "wenote/res").getAbsolutePath());
        pRH.add("file://" + new File(com.tencent.mm.compatible.util.e.bnE, "wenote/res").getAbsolutePath());
        pRH.add("file://" + new File(str, "wxa_fts/res").getAbsolutePath());
        x.i("MicroMsg.WebViewUI", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s, wxapp : %s", new Object[]{r1.getAbsolutePath(), r2.getAbsolutePath(), r3.getAbsolutePath()});
        pRH.add("file://" + new File(str, "emoji/res").getAbsolutePath());
        pRH.add("file://" + new File(com.tencent.mm.compatible.util.e.bnE, "emoji/res").getAbsolutePath());
        x.i("MicroMsg.WebViewUI", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[]{r1.getAbsolutePath(), r0.getAbsolutePath()});
        pRH.add("file://" + new File(com.tencent.mm.plugin.websearch.api.p.zT(1)).getAbsolutePath());
        pRH.add("file://" + new File(com.tencent.mm.compatible.util.e.bnE, "fts_browse/res").getAbsolutePath());
        x.i("MicroMsg.WebViewUI", "add browse UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[]{r0.getAbsolutePath(), r1.getAbsolutePath()});
        Iterator it = pRH.iterator();
        while (it.hasNext()) {
            x.i("MicroMsg.WebViewUI", "albie: WebViewUI white list path : %s", new Object[]{(String) it.next()});
        }
    }

    public void setGamePageReportData(Bundle bundle) {
    }

    public boolean anv() {
        return false;
    }

    public void U(Bundle bundle) {
        int color;
        int i;
        if (bundle.getBoolean("set_navigation_bar_color_reset", false)) {
            color = this.pZk == null ? getResources().getColor(R.e.webview_actionbar_color) : this.pZk.bWN();
            i = com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.CTRL_BYTE;
        } else {
            color = bundle.getInt("set_navigation_bar_color_color");
            i = bundle.getInt("set_navigation_bar_color_alpha");
        }
        lF((color & 16777215) | (i << 24));
    }

    public final void lF(int i) {
        super.lF(i);
        if (VERSION.SDK_INT >= 21 && getWindow() != null) {
            com.tencent.mm.ui.statusbar.a.c(this.jUX, getWindow().getStatusBarColor(), com.tencent.mm.ui.statusbar.d.c(getWindow()));
        }
    }

    protected void initSwipeBack() {
        super.initSwipeBack();
        if (getSwipeBackLayout() != null && this.pYP) {
            View childAt = getSwipeBackLayout().getChildAt(0);
            getSwipeBackLayout().removeView(childAt);
            com.tencent.mm.ui.statusbar.b bVar = new com.tencent.mm.ui.statusbar.b(this);
            if (childAt instanceof FrameLayout) {
                View childAt2 = ((FrameLayout) childAt).getChildAt(0);
                LayoutParams layoutParams = childAt2.getLayoutParams();
                ((FrameLayout) childAt).removeView(childAt2);
                bVar.addView(childAt2, layoutParams);
            } else {
                bVar.addView(childAt);
            }
            getSwipeBackLayout().addView(bVar);
            getSwipeBackLayout().setContentView(bVar);
        }
    }

    private void Dm(String str) {
        if (this.mhH != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.mhH, new Object[0]);
            } catch (NoSuchMethodException e) {
                x.e("MicroMsg.WebViewUI", "No such method: " + str + ", " + e.toString());
            } catch (IllegalAccessException e2) {
                x.e("MicroMsg.WebViewUI", "Illegal Access: " + str + ", " + e2.toString());
            } catch (InvocationTargetException e3) {
                x.e("MicroMsg.WebViewUI", "Invocation Target Exception: " + str + ", " + e3.toString());
            } catch (Exception e4) {
                x.e("MicroMsg.WebViewUI", "Exception : " + str + ", " + e4.toString());
            }
        }
    }

    private void jZ(boolean z) {
        if (!z) {
            this.pYi = true;
        }
    }

    public void onResume() {
        Bundle bundle;
        super.onResume();
        this.pQY.bUv().pSG = bi.VG();
        g gVar = g.pXv;
        x.v("MicroMsg.WebViewReportUtil", "onResume traceid %s", new Object[]{gVar.nyj});
        if (!bi.oW(gVar.nyj)) {
            gVar.kB(7);
        }
        if (!this.pZo) {
            int hashCode = hashCode();
            for (int size = pYh.size() - 1; size >= 0; size--) {
                if (((ab) pYh.get(size)).id == hashCode) {
                    pYh.remove(size);
                    break;
                }
            }
            pYh.add(new ab(this));
        }
        this.pZo = false;
        if (this.pYi) {
            jZ(true);
            this.pYi = false;
        }
        bWe();
        if (this.gcO != null) {
            try {
                bundle = new Bundle();
                bundle.putInt("screen_orientation", this.screenOrientation);
                this.gcO.g(83, bundle);
            } catch (Exception e) {
                x.e("MicroMsg.WebViewUI", "ac_set_screen_orientation : " + e.getMessage());
            }
        }
        if (getIntent().getBooleanExtra("disable_swipe_back", false) && getSwipeBackLayout() != null) {
            getSwipeBackLayout().setEnableGesture(false);
        }
        Dm("onResume");
        Dl("onResume");
        try {
            if (this.gcO != null) {
                bundle = this.gcO.g(19, null);
                if (bundle != null) {
                    x.i("MicroMsg.WebViewUI", "onResume, has init = %b", new Object[]{Boolean.valueOf(bundle.getBoolean("webview_video_proxy_init"))});
                    if (bundle.getBoolean("webview_video_proxy_init")) {
                        FactoryProxyManager.getPlayManager().appToFront();
                    }
                }
            }
        } catch (Exception e2) {
            x.e("MicroMsg.WebViewUI", "notify app tofront failed : %s", new Object[]{e2.getMessage()});
        }
        this.hmf = bi.VE();
        com.tencent.mm.modelstat.d.b(3, "WebViewUI_" + Rq(bi.oV(this.pYM)), hashCode());
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.modelstat.d.b(4, "WebViewUI_" + Rq(bi.oV(this.pYM)), hashCode());
        com.tencent.mm.modelstat.d.h("WebViewUI_" + Rq(bi.oV(this.pYM)), this.hmf, bi.VE());
        com.tencent.mm.plugin.webview.model.ak.j bUv = this.pQY.bUv();
        if (bUv.pSG != -1) {
            bUv.grJ += bi.bI(bUv.pSG) / 1000;
        }
        g gVar = g.pXv;
        x.v("MicroMsg.WebViewReportUtil", "onPause traceid %s", new Object[]{gVar.nyj});
        if (gVar.dDR) {
            x.i("MicroMsg.WebViewReportUtil", "isFinish is true");
        } else if (!bi.oW(gVar.nyj)) {
            gVar.kB(6);
        }
        try {
            if (this.gcO != null) {
                Bundle g = this.gcO.g(19, null);
                if (g != null) {
                    x.i("MicroMsg.WebViewUI", "onPause, has init = %b", new Object[]{Boolean.valueOf(g.getBoolean("webview_video_proxy_init"))});
                    if (g.getBoolean("webview_video_proxy_init")) {
                        FactoryProxyManager.getPlayManager().appToBack();
                    }
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "notify app toback failed : %s", new Object[]{e.getMessage()});
        }
        bWo();
        Dm("onPause");
        Dl("onPause");
        if (this.pYl != null) {
            x.i("MicroMsg.WebViewUI", "onPause, now try to hide customview");
            try {
                this.pYl.onHideCustomView();
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.WebViewUI", e2, "onPause", new Object[0]);
            }
        }
    }

    public void finish() {
        if (this.pXT) {
            setResult(-1);
        }
        try {
            if (this.gcO != null) {
                this.gcO.Av(hashCode());
                this.gcO.Ar(hashCode());
            }
            x.w("MicroMsg.WebViewUI", "invoke onWebViewUIDestroy");
        } catch (Exception e) {
            x.w("MicroMsg.WebViewUI", "onDestroy, remove callback and invoke event on webview destroy, ex = " + e);
        }
        this.pZd = true;
        super.finish();
    }

    public int getLayoutId() {
        return R.i.webview;
    }

    protected boolean convertActivityFromTranslucent() {
        return getIntent().getBooleanExtra("convertActivityFromTranslucent", true);
    }

    public void setMMTitle(String str) {
        super.setMMTitle(str);
    }

    private void Dl(String str) {
        if (this.pNV != null) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.pNV;
            if (dVar.qhq) {
                x.i("MicroMsg.JsApiHandler", "onActivityStateChanged, state = " + str);
                Map hashMap = new HashMap();
                hashMap.put("state", str);
                String a = i.a.a("activity:state_change", hashMap, dVar.qhs, dVar.qht);
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    try {
                        dVar.qhk.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", new Object[]{e.getMessage()});
                    }
                } else {
                    ah.A(new 7(dVar, a));
                }
            } else {
                x.e("MicroMsg.JsApiHandler", "onActivityStateChanged fail, not ready");
            }
            try {
                if (str.equals("onPause")) {
                    this.gcO.Ax(hashCode());
                } else if (str.equals("onResume")) {
                    this.gcO.Aw(hashCode());
                }
            } catch (Exception e2) {
                x.w("MicroMsg.WebViewUI", "onResume, ex = " + e2.getMessage());
            }
        }
    }

    public boolean bVH() {
        return false;
    }

    private void bVW() {
        x.i("MicroMsg.WebViewUI", "edw tryBindService");
        bindService(new Intent(this, WebViewStubService.class), this.hKe, 1);
    }

    protected final void onCreateBeforeSetContentView() {
        supportRequestWindowFeature(5);
        supportRequestWindowFeature(9);
        setProgressBarIndeterminateVisibility(false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.TargetApi(11)
    public void onCreate(android.os.Bundle r14) {
        /*
        r13 = this;
        r12 = 3;
        r11 = 2;
        r4 = 0;
        r2 = 0;
        r3 = 1;
        super.onCreate(r14);
        r0 = "MicroMsg.WebViewUI";
        r1 = new java.lang.StringBuilder;
        r5 = "onCreate";
        r1.<init>(r5);
        r5 = r13.hashCode();
        r1 = r1.append(r5);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = new com.tencent.mm.plugin.webview.ui.tools.h;
        r0.<init>(r13);
        r13.pZk = r0;
        r1 = r13.pZk;
        r0 = r1.qaX;
        if (r0 == 0) goto L_0x0053;
    L_0x002f:
        r0 = r1.qaX;
        r0 = r0.anv();
        if (r0 == 0) goto L_0x074d;
    L_0x0037:
        r0 = r3;
    L_0x0038:
        if (r0 == 0) goto L_0x07b9;
    L_0x003a:
        r1.qaV = r3;
    L_0x003c:
        r0 = "MicroMsg.WebViewUIStyleHelper";
        r5 = "initNewWebViewUIStyleParams, webViewUI#%s, disableLightActionbarStyle:%b";
        r6 = new java.lang.Object[r11];
        r7 = r1.qaX;
        r6[r2] = r7;
        r1 = r1.qaV;
        r1 = java.lang.Boolean.valueOf(r1);
        r6[r3] = r1;
        com.tencent.mm.sdk.platformtools.x.d(r0, r5, r6);
    L_0x0053:
        r0 = r13.getIntent();
        r1 = "geta8key_session_id";
        r6 = java.lang.System.currentTimeMillis();
        r5 = (int) r6;
        r0 = r0.getIntExtra(r1, r5);
        r13.pYa = r0;
        r0 = r13.getIntent();
        r1 = "geta8key_cookie";
        r0 = r0.getByteArrayExtra(r1);
        r13.pYc = r0;
        r0 = r13.getRawUrl();
        r13.pXP = r0;
        r0 = r13.getIntent();
        r1 = "screen_orientation";
        r5 = -1;
        r0 = r0.getIntExtra(r1, r5);
        r13.screenOrientation = r0;
        r0 = r13.getIntent();
        r1 = "from_shortcut";
        r0 = r0.getBooleanExtra(r1, r2);
        r13.pXY = r0;
        r0 = r13.getIntent();
        r1 = "status_bar_style";
        r0 = r0.getStringExtra(r1);
        r13.jVa = r0;
        r0 = r13.getIntent();
        r1 = "customize_status_bar_color";
        r0 = r0.getIntExtra(r1, r2);
        r13.jUZ = r0;
        r0 = r13.getIntent();
        if (r0 != 0) goto L_0x07bd;
    L_0x00b3:
        r0 = "";
    L_0x00b6:
        r1 = r13.getIntent();
        if (r1 != 0) goto L_0x07ca;
    L_0x00bc:
        r1 = r2;
    L_0x00bd:
        r5 = "MicroMsg.WebViewUI";
        r6 = "initCustomActionBarColorIfNeed isNativeStyle is %b";
        r7 = new java.lang.Object[r3];
        r8 = java.lang.Boolean.valueOf(r1);
        r7[r2] = r8;
        com.tencent.mm.sdk.platformtools.x.i(r5, r6, r7);
        if (r1 == 0) goto L_0x07d7;
    L_0x00d0:
        r0 = "white";
        r1 = -16777216; // 0xffffffffff000000 float:-1.7014118E38 double:NaN;
        r13.AL(r1);
    L_0x00d8:
        r0 = android.graphics.Color.parseColor(r0);	 Catch:{ Exception -> 0x07df }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x07df }
    L_0x00e0:
        if (r0 == 0) goto L_0x010f;
    L_0x00e2:
        r1 = new android.os.Bundle;
        r1.<init>(r3);
        r5 = "set_navigation_bar_color_color";
        r6 = r0.intValue();
        r1.putInt(r5, r6);
        r5 = "set_navigation_bar_color_alpha";
        r6 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r1.putInt(r5, r6);
        r13.U(r1);
        r1 = r13.getIntent();
        r5 = "customize_status_bar_color";
        r1 = r1.hasExtra(r5);
        if (r1 != 0) goto L_0x010f;
    L_0x0109:
        r0 = r0.intValue();
        r13.jUZ = r0;
    L_0x010f:
        r0 = r13.getRawUrl();
        r13.cbP = r0;
        r0 = r13.getIntent();
        r1 = "show_native_web_view";
        r0 = r0.getBooleanExtra(r1, r2);
        r13.pYS = r0;
        r0 = r13.getIntent();
        r1 = "key_trust_url";
        r0 = r0.getBooleanExtra(r1, r2);
        r13.pXO = r0;
        r0 = "MicroMsg.WebViewUI";
        r1 = "albie: trustUrl : %b.";
        r5 = new java.lang.Object[r3];
        r6 = r13.pXO;
        r6 = java.lang.Boolean.valueOf(r6);
        r5[r2] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r5);
        r0 = pZb;
        r0 = r0 + 1;
        pZb = r0;
        r0 = pYh;
        r1 = new com.tencent.mm.plugin.webview.ui.tools.WebViewUI$ab;
        r1.<init>(r13);
        r0.add(r1);
        r0 = pYh;
        r0 = r0.size();
        if (r0 <= r3) goto L_0x0181;
    L_0x015a:
        r0 = pYh;
        r1 = pYh;
        r1 = r1.size();
        r1 = r1 + -2;
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.plugin.webview.ui.tools.WebViewUI.ab) r0;
        r1 = r0.oos;
        if (r1 == 0) goto L_0x0181;
    L_0x016e:
        r1 = r0.oos;
        r1 = r1.get();
        if (r1 == 0) goto L_0x0181;
    L_0x0176:
        r0 = r0.oos;
        r0 = r0.get();
        r0 = (com.tencent.mm.plugin.webview.ui.tools.WebViewUI) r0;
        r0.jZ(r2);
    L_0x0181:
        r0 = "MicroMsg.WebViewUI";
        r1 = "initView , rawUrl = %s ";
        r5 = new java.lang.Object[r3];
        r6 = r13.cbP;
        r5[r2] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r5);
        r0 = r13.getIntent();
        r1 = "KPublisherId";
        r0 = r0.getStringExtra(r1);
        r0 = com.tencent.mm.sdk.platformtools.bi.oV(r0);
        r13.bZM = r0;
        r0 = r13.getIntent();
        r1 = "geta8key_username";
        r0 = r0.getStringExtra(r1);
        r0 = r13.Rq(r0);
        r13.cfR = r0;
        r0 = r13.pQY;
        r0 = r0.bUr();
        r1 = r13.cfR;
        r5 = r13.bZM;
        r0.cfR = r1;
        r0.pSv = r5;
        r0 = new com.tencent.mm.sdk.platformtools.ag;
        r0.<init>();
        r13.handler = r0;
        r0 = r13.pQY;
        if (r0 == 0) goto L_0x07e6;
    L_0x01cb:
        r0 = r13.pQY;
        r1 = r13.getIntent();
        r5 = "mm_report_bundle";
        r1 = r1.getBundleExtra(r5);
        if (r1 == 0) goto L_0x07e3;
    L_0x01da:
        r5 = r0.pSl;
        if (r5 == 0) goto L_0x01e2;
    L_0x01de:
        r5 = r0.pSl;
        r5.jfZ = r4;
    L_0x01e2:
        r4 = new com.tencent.mm.plugin.webview.model.ak$a;
        r4.<init>(r0, r1);
        r0.pSl = r4;
        r0 = r3;
    L_0x01ea:
        r13.pXQ = r0;
        r0 = r13.getIntent();
        r1 = "close_window_confirm_info";
        r0 = r0.getBundleExtra(r1);
        if (r0 == 0) goto L_0x01ff;
    L_0x01f9:
        r0 = com.tencent.mm.plugin.webview.ui.tools.WebViewUI.d.W(r0);
        r13.pYI = r0;
    L_0x01ff:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 < r1) goto L_0x0210;
    L_0x0205:
        r0 = r13.getWindow();
        r1 = 16777216; // 0x1000000 float:2.3509887E-38 double:8.289046E-317;
        r4 = 16777216; // 0x1000000 float:2.3509887E-38 double:8.289046E-317;
        r0.setFlags(r1, r4);
    L_0x0210:
        r0 = r13.getWindow();
        r1 = -3;
        r0.setFormat(r1);
        r0 = r13.mhH;
        r1 = r13.bWA();
        r0 = com.tencent.mm.plugin.webview.ui.tools.bag.m.a(r13, r0, r1);
        r13.pZs = r0;
        r0 = r13.pZs;
        r1 = r13.cbP;
        r0.Rx(r1);
        r0 = r13.jKs;
        r0.clear();
        r0 = r13.jKs;
        r1 = "menuItem:share:brand";
        r4 = java.lang.Integer.valueOf(r2);
        r0.put(r1, r4);
        r0 = r13.jKs;
        r1 = "menuItem:share:appMessage";
        r4 = java.lang.Integer.valueOf(r3);
        r0.put(r1, r4);
        r0 = r13.jKs;
        r1 = "menuItem:share:dataMessage";
        r4 = 23;
        r4 = java.lang.Integer.valueOf(r4);
        r0.put(r1, r4);
        r0 = r13.jKs;
        r1 = "menuItem:share:timeline";
        r4 = java.lang.Integer.valueOf(r11);
        r0.put(r1, r4);
        r0 = r13.jKs;
        r1 = "menuItem:favorite";
        r4 = java.lang.Integer.valueOf(r12);
        r0.put(r1, r4);
        r0 = r13.jKs;
        r1 = "menuItem:profile";
        r4 = 5;
        r4 = java.lang.Integer.valueOf(r4);
        r0.put(r1, r4);
        r0 = r13.jKs;
        r1 = "menuItem:addContact";
        r4 = 5;
        r4 = java.lang.Integer.valueOf(r4);
        r0.put(r1, r4);
        r0 = r13.jKs;
        r1 = "menuItem:copyUrl";
        r4 = 6;
        r4 = java.lang.Integer.valueOf(r4);
        r0.put(r1, r4);
        r0 = r13.jKs;
        r1 = "menuItem:openWithSafari";
        r4 = 7;
        r4 = java.lang.Integer.valueOf(r4);
        r0.put(r1, r4);
        r0 = r13.jKs;
        r1 = "menuItem:share:email";
        r4 = 8;
        r4 = java.lang.Integer.valueOf(r4);
        r0.put(r1, r4);
        r0 = r13.jKs;
        r1 = "menuItem:delete";
        r4 = 9;
        r4 = java.lang.Integer.valueOf(r4);
        r0.put(r1, r4);
        r0 = r13.jKs;
        r1 = "menuItem:exposeArticle";
        r4 = 10;
        r4 = java.lang.Integer.valueOf(r4);
        r0.put(r1, r4);
        r0 = r13.jKs;
        r1 = "menuItem:setFont";
        r4 = 11;
        r4 = java.lang.Integer.valueOf(r4);
        r0.put(r1, r4);
        r0 = r13.jKs;
        r1 = "menuItem:editTag";
        r4 = 12;
        r4 = java.lang.Integer.valueOf(r4);
        r0.put(r1, r4);
        r0 = r13.jKs;
        r1 = "menuItem:readMode";
        r4 = 14;
        r4 = java.lang.Integer.valueOf(r4);
        r0.put(r1, r4);
        r0 = r13.jKs;
        r1 = "menuItem:originPage";
        r4 = 14;
        r4 = java.lang.Integer.valueOf(r4);
        r0.put(r1, r4);
        r0 = r13.jKs;
        r1 = "menuItem:share:qq";
        r4 = 20;
        r4 = java.lang.Integer.valueOf(r4);
        r0.put(r1, r4);
        r0 = r13.jKs;
        r1 = "menuItem:share:weiboApp";
        r4 = 21;
        r4 = java.lang.Integer.valueOf(r4);
        r0.put(r1, r4);
        r0 = r13.jKs;
        r1 = "menuItem:share:QZone";
        r4 = 22;
        r4 = java.lang.Integer.valueOf(r4);
        r0.put(r1, r4);
        r0 = r13.jKs;
        r1 = "menuItem:share:Facebook";
        r4 = 33;
        r4 = java.lang.Integer.valueOf(r4);
        r0.put(r1, r4);
        r0 = r13.jKs;
        r1 = "menuItem:share:enterprise";
        r4 = 24;
        r4 = java.lang.Integer.valueOf(r4);
        r0.put(r1, r4);
        r0 = r13.jKs;
        r1 = "menuItem:refresh";
        r4 = 28;
        r4 = java.lang.Integer.valueOf(r4);
        r0.put(r1, r4);
        r0 = r13.jKs;
        r1 = "menuItem:share:wework";
        r4 = 25;
        r4 = java.lang.Integer.valueOf(r4);
        r0.put(r1, r4);
        r0 = r13.jKs;
        r1 = "menuItem:share:weread";
        r4 = 26;
        r4 = java.lang.Integer.valueOf(r4);
        r0.put(r1, r4);
        r0 = r13.jKs;
        r1 = "menuItem:addShortcut";
        r4 = 29;
        r4 = java.lang.Integer.valueOf(r4);
        r0.put(r1, r4);
        r0 = r13.jKs;
        r1 = "menuItem:search";
        r4 = 31;
        r4 = java.lang.Integer.valueOf(r4);
        r0.put(r1, r4);
        r0 = r13.jKs;
        r1 = "menuItem:readArticle";
        r4 = 34;
        r4 = java.lang.Integer.valueOf(r4);
        r0.put(r1, r4);
        r0 = r13.jKs;
        r1 = "menuItem:minimize";
        r4 = 35;
        r4 = java.lang.Integer.valueOf(r4);
        r0.put(r1, r4);
        r0 = r13.jKs;
        r1 = "menuItem:cancelMinimize";
        r4 = 36;
        r4 = java.lang.Integer.valueOf(r4);
        r0.put(r1, r4);
        r0 = java.lang.System.currentTimeMillis();
        com.tencent.mm.pluginsdk.model.u.a.eP(r13);
        r4 = "MicroMsg.WebViewUI";
        r5 = "initWebView, check Tbs time consumed = %d(ms)";
        r6 = new java.lang.Object[r3];
        r8 = java.lang.System.currentTimeMillis();
        r0 = r8 - r0;
        r0 = java.lang.Long.valueOf(r0);
        r6[r2] = r0;
        com.tencent.mm.sdk.platformtools.x.d(r4, r5, r6);
        r0 = r13.getIntent();
        r1 = "usePlugin";
        r1 = r0.getBooleanExtra(r1, r3);
        r0 = r13.getIntent();
        r4 = "zoom";
        r4 = r0.getBooleanExtra(r4, r3);
        r0 = r13.getIntent();
        r5 = "useJs";
        r5 = r0.getBooleanExtra(r5, r3);
        r0 = r13.bTf();
        r13.mhH = r0;
        r0 = r13.mhH;
        r0.uHs = r13;
        r0 = r13.mhH;
        if (r0 == 0) goto L_0x04e5;
    L_0x0407:
        r0 = r13.mhH;
        r0 = r0.getIsX5Kernel();
        if (r0 != 0) goto L_0x04e5;
    L_0x040f:
        r0 = 19;
        r0 = com.tencent.mm.compatible.util.d.fR(r0);
        if (r0 != 0) goto L_0x04e5;
    L_0x0417:
        r0 = new com.tencent.mm.compatible.loader.c;	 Catch:{ Exception -> 0x07e9 }
        r6 = r13.mhH;	 Catch:{ Exception -> 0x07e9 }
        r7 = "mSysWebView";
        r8 = 0;
        r0.<init>(r6, r7, r8);	 Catch:{ Exception -> 0x07e9 }
        r0 = r0.get();	 Catch:{ Exception -> 0x07e9 }
        r6 = "MicroMsg.WebViewUI";
        r7 = "tryInterruptAwaitingWebCoreThread, mSysWebView = %s";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x07e9 }
        r9 = 0;
        r8[r9] = r0;	 Catch:{ Exception -> 0x07e9 }
        com.tencent.mm.sdk.platformtools.x.d(r6, r7, r8);	 Catch:{ Exception -> 0x07e9 }
        r6 = new com.tencent.mm.compatible.loader.c;	 Catch:{ Exception -> 0x07e9 }
        r7 = "mProvider";
        r8 = 0;
        r6.<init>(r0, r7, r8);	 Catch:{ Exception -> 0x07e9 }
        r0 = r6.get();	 Catch:{ Exception -> 0x07e9 }
        r6 = "MicroMsg.WebViewUI";
        r7 = "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x07e9 }
        r9 = 0;
        r8[r9] = r0;	 Catch:{ Exception -> 0x07e9 }
        com.tencent.mm.sdk.platformtools.x.d(r6, r7, r8);	 Catch:{ Exception -> 0x07e9 }
        r6 = new com.tencent.mm.compatible.loader.c;	 Catch:{ Exception -> 0x07e9 }
        r7 = "mWebViewCore";
        r8 = 0;
        r6.<init>(r0, r7, r8);	 Catch:{ Exception -> 0x07e9 }
        r0 = r6.get();	 Catch:{ Exception -> 0x07e9 }
        r6 = "MicroMsg.WebViewUI";
        r7 = "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x07e9 }
        r9 = 0;
        r8[r9] = r0;	 Catch:{ Exception -> 0x07e9 }
        com.tencent.mm.sdk.platformtools.x.d(r6, r7, r8);	 Catch:{ Exception -> 0x07e9 }
        r6 = new com.tencent.mm.compatible.loader.c;	 Catch:{ Exception -> 0x07e9 }
        r7 = "sWebCoreHandler";
        r8 = 0;
        r6.<init>(r0, r7, r8);	 Catch:{ Exception -> 0x07e9 }
        r0 = r6.get();	 Catch:{ Exception -> 0x07e9 }
        r6 = "MicroMsg.WebViewUI";
        r7 = "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x07e9 }
        r9 = 0;
        r8[r9] = r0;	 Catch:{ Exception -> 0x07e9 }
        com.tencent.mm.sdk.platformtools.x.d(r6, r7, r8);	 Catch:{ Exception -> 0x07e9 }
        r6 = new com.tencent.mm.compatible.loader.c;	 Catch:{ Exception -> 0x07e9 }
        r7 = "mLooper";
        r8 = 0;
        r6.<init>(r0, r7, r8);	 Catch:{ Exception -> 0x07e9 }
        r0 = r6.get();	 Catch:{ Exception -> 0x07e9 }
        r6 = "MicroMsg.WebViewUI";
        r7 = "tryInterruptAwaitingWebCoreThread, mLooper = %s";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x07e9 }
        r9 = 0;
        r8[r9] = r0;	 Catch:{ Exception -> 0x07e9 }
        com.tencent.mm.sdk.platformtools.x.d(r6, r7, r8);	 Catch:{ Exception -> 0x07e9 }
        r6 = new com.tencent.mm.compatible.loader.c;	 Catch:{ Exception -> 0x07e9 }
        r7 = "mThread";
        r8 = 0;
        r6.<init>(r0, r7, r8);	 Catch:{ Exception -> 0x07e9 }
        r0 = r6.get();	 Catch:{ Exception -> 0x07e9 }
        r6 = "MicroMsg.WebViewUI";
        r7 = "tryInterruptAwaitingWebCoreThread, mThread = %s";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x07e9 }
        r9 = 0;
        r8[r9] = r0;	 Catch:{ Exception -> 0x07e9 }
        com.tencent.mm.sdk.platformtools.x.d(r6, r7, r8);	 Catch:{ Exception -> 0x07e9 }
        r6 = r0 instanceof java.lang.Thread;	 Catch:{ Exception -> 0x07e9 }
        if (r6 == 0) goto L_0x04e5;
    L_0x04c5:
        r0 = (java.lang.Thread) r0;	 Catch:{ Exception -> 0x07e9 }
        r6 = "MicroMsg.WebViewUI";
        r7 = "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x07e9 }
        r9 = 0;
        r10 = r0.getState();	 Catch:{ Exception -> 0x07e9 }
        r8[r9] = r10;	 Catch:{ Exception -> 0x07e9 }
        com.tencent.mm.sdk.platformtools.x.i(r6, r7, r8);	 Catch:{ Exception -> 0x07e9 }
        r6 = r0.getState();	 Catch:{ Exception -> 0x07e9 }
        r7 = java.lang.Thread.State.WAITING;	 Catch:{ Exception -> 0x07e9 }
        if (r6 != r7) goto L_0x04e5;
    L_0x04e2:
        r0.interrupt();	 Catch:{ Exception -> 0x07e9 }
    L_0x04e5:
        r0 = r13.mhH;
        r0 = r0.getSettings();
        r0.setJavaScriptEnabled(r5);
        r0 = r13.mhH;
        r0 = r0.getSettings();
        r0.setPluginsEnabled(r1);
        r0 = r13.mhH;
        r0 = r0.getSettings();
        r0.cIv();
        r0 = r13.mhH;
        r0 = r0.getSettings();
        r0.setBuiltInZoomControls(r4);
        r0 = r13.mhH;
        r0 = r0.getSettings();
        r0.setUseWideViewPort(r3);
        r0 = r13.mhH;
        r0 = r0.getSettings();
        r0.setLoadWithOverviewMode(r3);
        r0 = r13.mhH;
        r0 = r0.getSettings();
        r0.cIq();
        r0 = r13.mhH;
        r0 = r0.getSettings();
        r0.cIp();
        r0 = r13.mhH;
        r0 = r0.getSettings();
        r0.setGeolocationEnabled(r3);
        r0 = r13.mhH;
        r0 = r0.getSettings();
        r0.setJavaScriptCanOpenWindowsAutomatically(r3);
        r0 = r13.mhH;
        r0 = r0.getSettings();
        r0.cIx();
        r0 = r13.mhH;
        r0 = r0.getSettings();
        r0.cIt();
        r0 = r13.mhH;
        r0 = r0.getSettings();
        r1 = "webviewcache";
        r1 = r13.getDir(r1, r2);
        r1 = r1.getAbsolutePath();
        r0.setAppCachePath(r1);
        r0 = r13.mhH;
        r0 = r0.getSettings();
        r0.cIs();
        r0 = r13.mhH;
        r0 = r0.getSettings();
        r0.cIu();
        r0 = r13.mhH;
        r0 = r0.getSettings();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r4 = com.tencent.mm.compatible.util.e.duM;
        r1 = r1.append(r4);
        r4 = "databases/";
        r1 = r1.append(r4);
        r1 = r1.toString();
        r0.setDatabasePath(r1);
        r0 = com.tencent.xweb.b.cIi();
        r0.cIj();
        r0 = com.tencent.xweb.b.cIi();
        r1 = r13.mhH;
        r0.c(r1);
        r0 = r13.getApplicationContext();
        r1 = "window";
        r0 = r0.getSystemService(r1);
        r0 = (android.view.WindowManager) r0;
        r1 = com.tencent.xweb.WebView.class;
        r4 = "mWebViewCore";
        r1 = r1.getDeclaredField(r4);	 Catch:{ Exception -> 0x080d }
        r1 = r1.getType();	 Catch:{ Exception -> 0x080d }
        r4 = "mBrowserFrame";
        r1 = r1.getDeclaredField(r4);	 Catch:{ Exception -> 0x080d }
        r1 = r1.getType();	 Catch:{ Exception -> 0x080d }
        r4 = "sConfigCallback";
        r1 = r1.getDeclaredField(r4);	 Catch:{ Exception -> 0x080d }
        r4 = 1;
        r1.setAccessible(r4);	 Catch:{ Exception -> 0x080d }
        r4 = 0;
        r4 = r1.get(r4);	 Catch:{ Exception -> 0x080d }
        if (r4 != 0) goto L_0x07f9;
    L_0x05dd:
        r13.bVW();
        r0 = new com.tencent.mm.plugin.webview.ui.tools.e;
        r1 = r13.mhH;
        r0.<init>(r13, r1);
        r13.gcP = r0;
        r13.initView();
        r0 = "onCreate";
        r13.Dl(r0);
        r0 = r13.mhH;
        r0 = r0.getSettings();
        r0 = r0.getUserAgentString();
        r13.goF = r0;
        r0 = r13.getIntent();
        r1 = "from_scence";
        r0 = r0.getIntExtra(r1, r2);
        r13.fromScene = r0;
        r0 = "MicroMsg.WebViewUI";
        r1 = " onCreate fromScene %d";
        r4 = new java.lang.Object[r3];
        r5 = r13.fromScene;
        r5 = java.lang.Integer.valueOf(r5);
        r4[r2] = r5;
        com.tencent.mm.sdk.platformtools.x.d(r0, r1, r4);
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r13.hashCode();
        r0 = r0.append(r1);
        r0 = r0.toString();
        r0 = com.tencent.mm.sdk.platformtools.bi.oV(r0);
        r0 = com.tencent.mm.model.u.ic(r0);
        r13.bJK = r0;
        r0 = "MicroMsg.WebViewUI";
        r1 = " onCreate sessionId %s";
        r4 = new java.lang.Object[r3];
        r5 = r13.bJK;
        r4[r2] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r4);
        r0 = com.tencent.mm.sdk.platformtools.ao.isConnected(r13);
        if (r0 == 0) goto L_0x0669;
    L_0x064e:
        r0 = com.tencent.mm.sdk.platformtools.ao.isWifi(r13);
        if (r0 == 0) goto L_0x0810;
    L_0x0654:
        r13.networkType = r3;
    L_0x0656:
        r0 = "MicroMsg.WebViewUI";
        r1 = "get networkType %d";
        r4 = new java.lang.Object[r3];
        r5 = r13.networkType;
        r5 = java.lang.Integer.valueOf(r5);
        r4[r2] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r4);
    L_0x0669:
        r0 = r13.getResources();
        r0 = r0.getDisplayMetrics();
        r0 = r0.widthPixels;
        r13.width = r0;
        r0 = r13.getResources();
        r0 = r0.getDisplayMetrics();
        r0 = r0.heightPixels;
        r13.height = r0;
        r0 = r13.pQY;
        r0 = r0.bUw();
        r1 = r13.cfR;
        r4 = r13.bZM;
        r0.cfR = r1;
        r0.pSv = r4;
        r1 = r13.cbP;
        r0.url = r1;
        r0 = r13.pQY;
        r0 = r0.bUC();
        r1 = r13.cbP;
        r4 = "MicroMsg.WebviewReporter.DomainReporter";
        r5 = "setRawUrl, value = %s";
        r6 = new java.lang.Object[r3];
        r6[r2] = r1;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);
        r4 = android.net.Uri.parse(r1);	 Catch:{ Exception -> 0x0853 }
        r5 = r4.getScheme();	 Catch:{ Exception -> 0x0853 }
        if (r5 == 0) goto L_0x082f;
    L_0x06b2:
        r5 = r4.getScheme();	 Catch:{ Exception -> 0x0853 }
        r5 = r5.toLowerCase();	 Catch:{ Exception -> 0x0853 }
        r6 = "http";
        r5 = r5.startsWith(r6);	 Catch:{ Exception -> 0x0853 }
        if (r5 != 0) goto L_0x082f;
    L_0x06c3:
        r0 = "MicroMsg.WebviewReporter.DomainReporter";
        r5 = "rawUrl scheme is not http/https, skip, scheme = %s";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0853 }
        r7 = 0;
        r4 = r4.getScheme();	 Catch:{ Exception -> 0x0853 }
        r6[r7] = r4;	 Catch:{ Exception -> 0x0853 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r5, r6);	 Catch:{ Exception -> 0x0853 }
    L_0x06d6:
        r0 = r13.mController;	 Catch:{ Exception -> 0x0868 }
        r0 = r0.contentView;	 Catch:{ Exception -> 0x0868 }
        r13.jUX = r0;	 Catch:{ Exception -> 0x0868 }
        r0 = r13.jUX;	 Catch:{ Exception -> 0x0868 }
        if (r0 == 0) goto L_0x06fc;
    L_0x06e0:
        r13.aUQ();	 Catch:{ Exception -> 0x0868 }
        r0 = r13.getWindow();	 Catch:{ Exception -> 0x0868 }
        r0 = r0.getDecorView();	 Catch:{ Exception -> 0x0868 }
        r0 = (android.view.ViewGroup) r0;	 Catch:{ Exception -> 0x0868 }
        r1 = 0;
        r0 = r0.getChildAt(r1);	 Catch:{ Exception -> 0x0868 }
        r0 = (android.view.ViewGroup) r0;	 Catch:{ Exception -> 0x0868 }
        r1 = new com.tencent.mm.plugin.webview.ui.tools.WebViewUI$64;	 Catch:{ Exception -> 0x0868 }
        r1.<init>(r13);	 Catch:{ Exception -> 0x0868 }
        r0.addOnLayoutChangeListener(r1);	 Catch:{ Exception -> 0x0868 }
    L_0x06fc:
        r0 = r13.pYP;	 Catch:{ Exception -> 0x089f }
        if (r0 == 0) goto L_0x087c;
    L_0x0700:
        r0 = r13.bVZ();	 Catch:{ Exception -> 0x089f }
        if (r0 == 0) goto L_0x0709;
    L_0x0706:
        r13.bWa();	 Catch:{ Exception -> 0x089f }
    L_0x0709:
        r0 = new com.tencent.mm.bc.a;
        r1 = r13.mController;
        r1 = r1.tml;
        r2 = r13.fYm;
        r0.<init>(r1, r2);
        r13.fYl = r0;
        r0 = r13.pZe;
        r0 = r0.Em();
        r1 = new com.tencent.mm.plugin.webview.ui.tools.WebViewUI$56;
        r1.<init>(r13);
        r0.H(r1);
        r0 = new com.tencent.mm.plugin.webview.modeltools.WebViewClipBoardHelper;
        r0.<init>(r13);
        r13.pZh = r0;
        r0 = r13.pZn;
        r0.cht();
        r0 = r13.pYs;
        r0.cht();
        r0 = r13.pZk;
        if (r0 == 0) goto L_0x074c;
    L_0x0739:
        r0 = r13.pZk;
        r1 = r0.qaX;
        if (r1 == 0) goto L_0x074c;
    L_0x073f:
        r1 = r0.qaV;
        if (r1 == 0) goto L_0x08c3;
    L_0x0743:
        r0 = "MicroMsg.WebViewUIStyleHelper";
        r1 = "initNewWebViewUIStyleIfNeed, disableLightActionbarStyle true";
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
    L_0x074c:
        return;
    L_0x074d:
        r0 = r1.qaX;
        r0 = r0.getIntent();
        if (r0 == 0) goto L_0x07b6;
    L_0x0755:
        r5 = "disable_light_actionbar_style";
        r5 = r0.getBooleanExtra(r5, r2);
        if (r5 == 0) goto L_0x076a;
    L_0x075e:
        r0 = "MicroMsg.WebViewUIStyleHelper";
        r5 = "checkDisableLightActionbarStyle, KDisableLightActionbarStyle is true";
        com.tencent.mm.sdk.platformtools.x.d(r0, r5);
        r0 = r3;
        goto L_0x0038;
    L_0x076a:
        r5 = "status_bar_style";
        r5 = r0.getStringExtra(r5);
        r6 = com.tencent.mm.sdk.platformtools.bi.oW(r5);
        if (r6 != 0) goto L_0x078c;
    L_0x0777:
        r6 = "black";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x078c;
    L_0x0780:
        r0 = "MicroMsg.WebViewUIStyleHelper";
        r5 = "checkDisableLightActionbarStyle, customized by KStatusBarStyle";
        com.tencent.mm.sdk.platformtools.x.d(r0, r5);
        r0 = r3;
        goto L_0x0038;
    L_0x078c:
        r5 = "customize_status_bar_color";
        r5 = r0.getIntExtra(r5, r2);
        if (r5 == 0) goto L_0x07a1;
    L_0x0795:
        r0 = "MicroMsg.WebViewUIStyleHelper";
        r5 = "checkDisableLightActionbarStyle, customized by KCustomizeStatusBarColor";
        com.tencent.mm.sdk.platformtools.x.d(r0, r5);
        r0 = r3;
        goto L_0x0038;
    L_0x07a1:
        r5 = "open_custom_style_url";
        r0 = r0.getBooleanExtra(r5, r2);
        if (r0 == 0) goto L_0x07b6;
    L_0x07aa:
        r0 = "MicroMsg.WebViewUIStyleHelper";
        r5 = "checkDisableLightActionbarStyle, customized by KOpenCustomStyleUrl";
        com.tencent.mm.sdk.platformtools.x.d(r0, r5);
        r0 = r3;
        goto L_0x0038;
    L_0x07b6:
        r0 = r2;
        goto L_0x0038;
    L_0x07b9:
        r1.qaV = r2;
        goto L_0x003c;
    L_0x07bd:
        r0 = r13.getIntent();
        r1 = "custom_action_bar_color";
        r0 = r0.getStringExtra(r1);
        goto L_0x00b6;
    L_0x07ca:
        r1 = r13.getIntent();
        r5 = "open_custom_style_url";
        r1 = r1.getBooleanExtra(r5, r2);
        goto L_0x00bd;
    L_0x07d7:
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r1 != 0) goto L_0x010f;
    L_0x07dd:
        goto L_0x00d8;
    L_0x07df:
        r0 = move-exception;
        r0 = r4;
        goto L_0x00e0;
    L_0x07e3:
        r0 = r2;
        goto L_0x01ea;
    L_0x07e6:
        r0 = r2;
        goto L_0x01ea;
    L_0x07e9:
        r0 = move-exception;
        r6 = "MicroMsg.WebViewUI";
        r7 = "tryInterruptAwaitingWebCoreThread, exception = %s";
        r8 = new java.lang.Object[r3];
        r8[r2] = r0;
        com.tencent.mm.sdk.platformtools.x.e(r6, r7, r8);
        goto L_0x04e5;
    L_0x07f9:
        r1 = r1.getType();	 Catch:{ Exception -> 0x080d }
        r5 = "mWindowManager";
        r1 = r1.getDeclaredField(r5);	 Catch:{ Exception -> 0x080d }
        r5 = 1;
        r1.setAccessible(r5);	 Catch:{ Exception -> 0x080d }
        r1.set(r4, r0);	 Catch:{ Exception -> 0x080d }
        goto L_0x05dd;
    L_0x080d:
        r0 = move-exception;
        goto L_0x05dd;
    L_0x0810:
        r0 = com.tencent.mm.sdk.platformtools.ao.is4G(r13);
        if (r0 == 0) goto L_0x081b;
    L_0x0816:
        r0 = 4;
        r13.networkType = r0;
        goto L_0x0656;
    L_0x081b:
        r0 = com.tencent.mm.sdk.platformtools.ao.is3G(r13);
        if (r0 == 0) goto L_0x0825;
    L_0x0821:
        r13.networkType = r12;
        goto L_0x0656;
    L_0x0825:
        r0 = com.tencent.mm.sdk.platformtools.ao.is2G(r13);
        if (r0 == 0) goto L_0x0656;
    L_0x082b:
        r13.networkType = r11;
        goto L_0x0656;
    L_0x082f:
        r4 = r4.getHost();	 Catch:{ Exception -> 0x0853 }
        if (r4 == 0) goto L_0x0842;
    L_0x0835:
        r5 = r4.toLowerCase();	 Catch:{ Exception -> 0x0853 }
        r6 = ".qq.com";
        r5 = r5.endsWith(r6);	 Catch:{ Exception -> 0x0853 }
        if (r5 == 0) goto L_0x0863;
    L_0x0842:
        r0 = "MicroMsg.WebviewReporter.DomainReporter";
        r5 = "rawUrl, host is .qq.com, skip, host = %s";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0853 }
        r7 = 0;
        r6[r7] = r4;	 Catch:{ Exception -> 0x0853 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r5, r6);	 Catch:{ Exception -> 0x0853 }
        goto L_0x06d6;
    L_0x0853:
        r0 = move-exception;
        r0 = "MicroMsg.WebviewReporter.DomainReporter";
        r4 = "parse rawUrl fail, rawUrl = %s";
        r5 = new java.lang.Object[r3];
        r5[r2] = r1;
        com.tencent.mm.sdk.platformtools.x.e(r0, r4, r5);
        goto L_0x06d6;
    L_0x0863:
        r4 = 1;
        r0.jcc = r4;	 Catch:{ Exception -> 0x0853 }
        goto L_0x06d6;
    L_0x0868:
        r0 = move-exception;
        r1 = "MicroMsg.WebViewUI";
        r4 = "fixContentMargin error : %s";
        r5 = new java.lang.Object[r3];
        r0 = r0.getMessage();
        r5[r2] = r0;
        com.tencent.mm.sdk.platformtools.x.e(r1, r4, r5);
        goto L_0x06fc;
    L_0x087c:
        r0 = 21;
        r0 = com.tencent.mm.compatible.util.d.fR(r0);	 Catch:{ Exception -> 0x089f }
        if (r0 == 0) goto L_0x08b3;
    L_0x0884:
        r0 = r13.getWindow();	 Catch:{ Exception -> 0x089f }
        r0 = r0.getDecorView();	 Catch:{ Exception -> 0x089f }
        r0 = (android.view.ViewGroup) r0;	 Catch:{ Exception -> 0x089f }
        r1 = 0;
        r0 = r0.getChildAt(r1);	 Catch:{ Exception -> 0x089f }
        r0 = (android.view.ViewGroup) r0;	 Catch:{ Exception -> 0x089f }
        r1 = new com.tencent.mm.plugin.webview.ui.tools.WebViewUI$68;	 Catch:{ Exception -> 0x089f }
        r1.<init>(r13, r0);	 Catch:{ Exception -> 0x089f }
        r0.setOnApplyWindowInsetsListener(r1);	 Catch:{ Exception -> 0x089f }
        goto L_0x0709;
    L_0x089f:
        r0 = move-exception;
        r1 = "MicroMsg.WebViewUI";
        r4 = "tryToExpandToStatusBar error : %s";
        r3 = new java.lang.Object[r3];
        r0 = r0.getMessage();
        r3[r2] = r0;
        com.tencent.mm.sdk.platformtools.x.e(r1, r4, r3);
        goto L_0x0709;
    L_0x08b3:
        r0 = r13.getWindow();	 Catch:{ Exception -> 0x089f }
        r0 = r0.getDecorView();	 Catch:{ Exception -> 0x089f }
        r0 = (android.view.ViewGroup) r0;	 Catch:{ Exception -> 0x089f }
        r1 = 1;
        r0.setFitsSystemWindows(r1);	 Catch:{ Exception -> 0x089f }
        goto L_0x0709;
    L_0x08c3:
        r1 = "MicroMsg.WebViewUIStyleHelper";
        r2 = "initNewWebViewUIStyleIfNeed, disableLightActionbarStyle false";
        com.tencent.mm.sdk.platformtools.x.d(r1, r2);
        r1 = r0.qaX;
        r1 = r1.getActionBarHeight();
        r0.qaY = r1;
        r1 = r0.qaY;
        if (r1 != 0) goto L_0x08e2;
    L_0x08d8:
        r1 = r0.qaX;
        r2 = 48;
        r1 = com.tencent.mm.bp.a.fromDPToPix(r1, r2);
        r0.qaY = r1;
    L_0x08e2:
        r1 = r0.qaX;
        r1 = r1.mhH;
        r0.qaW = r1;
        r0.bWM();
        goto L_0x074c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.onCreate(android.os.Bundle):void");
    }

    protected static boolean bVX() {
        return true;
    }

    public final int getActionBarHeight() {
        if (getResources().getDimensionPixelSize(R.f.wechat_abc_action_bar_default_height) > com.tencent.mm.bp.a.fromDPToPix(this, 48)) {
            return getResources().getDimensionPixelSize(R.f.wechat_abc_action_bar_default_height);
        }
        if (com.tencent.mm.compatible.util.j.fC(this)) {
            return getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort);
        }
        return getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightLand);
    }

    protected final void aUQ() {
        if (this.jUX != null) {
            Object obj = (this.pXJ || this.pXK) ? 1 : null;
            if (obj == null) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.jUX.getLayoutParams();
                int bVY = bVY();
                if (bVY != marginLayoutParams.topMargin) {
                    marginLayoutParams.topMargin = bVY;
                    this.jUX.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }

    private int bVY() {
        int i = this.pYP ? 0 : this.gwO;
        return (getSupportActionBar() == null || !getSupportActionBar().isShowing()) ? i : i + getActionBarHeight();
    }

    @TargetApi(21)
    protected final void a(ViewGroup viewGroup, WindowInsets windowInsets) {
        if (this.gwO != windowInsets.getSystemWindowInsetTop()) {
            View viewGroup2;
            this.gwO = windowInsets.getSystemWindowInsetTop();
            aUQ();
            if (viewGroup2 instanceof SwipeBackLayout) {
                viewGroup2 = viewGroup2.getChildAt(0);
            }
            int i = R.h.action_bar_container;
            if (i > 0) {
                View findViewById = viewGroup2.findViewById(i);
                if (findViewById != null) {
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) findViewById.getLayoutParams();
                    marginLayoutParams.topMargin = windowInsets.getSystemWindowInsetTop();
                    findViewById.setLayoutParams(marginLayoutParams);
                    findViewById.requestLayout();
                }
            }
            if (bVZ()) {
                bWa();
            }
        }
    }

    public boolean bVZ() {
        return true;
    }

    public int anu() {
        return this.mController.cqm();
    }

    final boolean aUR() {
        if (bi.oW(this.jVa) || !this.jVa.equals("black")) {
            return false;
        }
        return true;
    }

    public final void bWa() {
        if (!com.tencent.mm.compatible.util.d.fR(21) || this.jUZ == 0) {
            setStatusBarColor(anu());
            return;
        }
        lF(this.jUZ);
        if (aUR()) {
            cqf();
            nS(-16777216);
        }
        Z(this.jUZ, aUR());
    }

    public final void Z(int i, boolean z) {
        if (VERSION.SDK_INT >= 23 && !com.tencent.mm.ui.statusbar.d.Af()) {
            setStatusBarColor(i);
            Window window = getWindow();
            int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
            if (z) {
                systemUiVisibility |= 8192;
            } else {
                systemUiVisibility &= -8193;
            }
            window.getDecorView().setSystemUiVisibility(systemUiVisibility);
        } else if (VERSION.SDK_INT >= 21) {
            if (z) {
                i = d.AD(i);
            }
            setStatusBarColor(i);
        }
    }

    @TargetApi(21)
    public final void setStatusBarColor(int i) {
        if (this.pYP) {
            com.tencent.mm.ui.statusbar.a.c(this.jUX, i, com.tencent.mm.ui.statusbar.d.c(getWindow()));
        } else if (this.gwO > 0 && !com.tencent.mm.compatible.util.d.fS(21)) {
            getWindow().setStatusBarColor(0);
            if (this.jUY == null) {
                this.jUY = new View(this);
                ((ViewGroup) findViewById(16908290)).addView(this.jUY, new LayoutParams(-1, this.gwO));
            } else {
                LayoutParams layoutParams = this.jUY.getLayoutParams();
                if (layoutParams.height != this.gwO) {
                    layoutParams.height = this.gwO;
                    this.jUY.setLayoutParams(layoutParams);
                }
            }
            this.jUY.setBackgroundColor(i);
        }
    }

    public final String getCurrentURL() {
        if (this.handler == null) {
            return this.pZz;
        }
        if (Thread.currentThread().getId() == this.handler.getLooper().getThread().getId()) {
            return this.mhH == null ? "" : this.mhH.getUrl();
        } else {
            if (!bi.oW(this.pZz)) {
                return this.pZz;
            }
            this.pZz = (String) new 2(this, "").a(this.handler);
            return this.pZz;
        }
    }

    public MMWebView bTf() {
        return MMWebView.a.cS(this);
    }

    public void onWebViewScrollChanged(int i, int i2, int i3, int i4) {
        x.v("MicroMsg.WebViewUI", "l=%d t=%d oldl=%d oldt=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
    }

    public void ahy() {
        if (VERSION.SDK_INT <= 10) {
            super.ahy();
        } else if (this.screenOrientation == -1) {
            this.tlM = getSharedPreferences(ad.chY(), 4).getBoolean("settings_landscape_mode", false);
            if (this.tlM) {
                setRequestedOrientation(-1);
            } else {
                setRequestedOrientation(1);
            }
        } else {
            setRequestedOrientation(this.screenOrientation);
        }
    }

    public final int getForceOrientation() {
        return this.screenOrientation;
    }

    private View bWb() {
        int identifier;
        View view = null;
        if (com.tencent.mm.compatible.util.d.fR(11)) {
            try {
                identifier = Resources.getSystem().getIdentifier("action_bar_container", "id", "android");
            } catch (Exception e) {
                x.e("MicroMsg.WebViewUI", "get resId action_bar_container, exp = %s", new Object[]{e});
            }
            if (identifier > 0) {
                view = findViewById(identifier);
            }
            x.i("MicroMsg.WebViewUI", "getActionBarContainer, viewResId = %d, get view = %s", new Object[]{Integer.valueOf(identifier), view});
            return view;
        }
        identifier = -1;
        if (identifier > 0) {
            view = findViewById(identifier);
        }
        x.i("MicroMsg.WebViewUI", "getActionBarContainer, viewResId = %d, get view = %s", new Object[]{Integer.valueOf(identifier), view});
        return view;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.pZp != configuration.orientation) {
            View bWb = bWb();
            bWb = bWb == null ? null : (View) bWb.getParent();
            if (bWb != null) {
                bWb.dispatchConfigurationChanged(configuration);
                bWb.requestLayout();
                this.pZp = configuration.orientation;
            }
        }
    }

    public void onStart() {
        super.onStart();
        x.i("MicroMsg.WebViewUI", "edw onStart");
    }

    protected void onStop() {
        x.i("MicroMsg.WebViewUI", "edw onStop");
        M(true, true);
        super.onStop();
    }

    private void AJ(int i) {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("scene_end_type", i);
            bundle.putInt("scene_end_listener_hash_code", hashCode());
            this.gcO.a(5, bundle, hashCode());
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "addSceneEnd, ex = " + e.getMessage());
        }
    }

    private void AK(int i) {
        try {
            if (this.gcO != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("scene_end_type", i);
                bundle.putInt("scene_end_listener_hash_code", hashCode());
                this.gcO.a(6, bundle, hashCode());
            }
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "removeSceneEnd, ex = " + e.getMessage());
        }
    }

    @TargetApi(11)
    public void onDestroy() {
        Bundle bundle;
        x.i("MicroMsg.WebViewUI", "onDestroy " + hashCode());
        super.onDestroy();
        this.pZs.bWR();
        if (this.fYl != null) {
            this.fYl.disable();
        }
        this.pZc = true;
        pZb--;
        int hashCode = hashCode();
        for (int size = pYh.size() - 1; size >= 0; size--) {
            if (((ab) pYh.get(size)).id == hashCode) {
                pYh.remove(size);
                break;
            }
        }
        f("", bi.VE(), 0);
        o bUK = o.a.bUK();
        bUK.pTi.put(hashCode(), Boolean.valueOf(false));
        ak.g bUy = this.pQY.bUy();
        bUy.pSr = new Object[]{this.cbP, Integer.valueOf(2)};
        bUy.c(this.gcO);
        this.pQY.c(this.gcO);
        ak akVar = this.pQY;
        akVar.pSc = null;
        akVar.pSa = null;
        akVar.pSb = null;
        akVar.pRZ = null;
        akVar.pSd = null;
        akVar.pSe = null;
        akVar.pSf = null;
        akVar.pSg = null;
        if (akVar.pSl != null) {
            akVar.pSl.jfZ = null;
            akVar.pSl = null;
        }
        Dl("onDestroy");
        this.pYD.clear();
        for (SparseBooleanArray sparseBooleanArray : this.pZw.values()) {
            if (sparseBooleanArray != null) {
                sparseBooleanArray.clear();
            }
        }
        this.pZw.clear();
        com.tencent.mm.plugin.webview.model.b bVar = this.pZe;
        if (!(bVar.pQX == null || bVar.pQX.lnJ.getLooper() == null)) {
            bVar.pQX.lnJ.getLooper().quit();
        }
        bVar.pQX = null;
        com.tencent.mm.plugin.webview.model.ah ahVar = this.pZl;
        ahVar.pRT.clear();
        ahVar.pRU.clear();
        ahVar.pRV.clear();
        ahVar.pRR.clear();
        ahVar.pRS.clear();
        if (this.pZG != null) {
            this.pZG.dismiss();
            this.pZG = null;
        }
        if (this.pZD != null) {
            this.pZD.dismiss();
            this.pZD = null;
        }
        if (this.pYp.bWL()) {
            AK(233);
        }
        if (this.pYq.bWL()) {
            AK(673);
        }
        if (this.pYr.bWL()) {
            AK(666);
        }
        this.pYE.clear();
        this.pYH.clear();
        this.pZn.dead();
        this.pYs.dead();
        if (com.tencent.xweb.c.ij(ad.getContext()) != null) {
            x.i("MicroMsg.WebViewUI", "now force sync the cookie between ram and db");
            com.tencent.xweb.c.sync();
        }
        if (bWn()) {
            try {
                if (this.gcO != null) {
                    bundle = new Bundle();
                    bundle.putString("srcUsername", getIntent().getStringExtra("srcUsername"));
                    this.gcO.a(30, bundle, hashCode());
                }
            } catch (Exception e) {
            }
        }
        x.v("MicroMsg.WebViewUI", "on destroy isNeedCallbackMMRpt[%b]", new Object[]{Boolean.valueOf(this.pXQ)});
        if (this.pXQ) {
            try {
                bundle = getIntent().getBundleExtra("mm_report_bundle");
                if (bi.oW(bundle.getString("mm_event_class"))) {
                    x.w("MicroMsg.WebViewUI", "webview on destroy callback mm but eventclass is null");
                } else if (this.gcO != null) {
                    bundle.putLong("key_activity_browse_time", cql());
                    this.gcO.g(250, bundle);
                }
            } catch (Exception e2) {
                x.e("MicroMsg.WebViewUI", "webview on destroy callback mm exception [%s]", new Object[]{e2.toString()});
            }
        }
        try {
            if (this.gcO != null) {
                bundle = new Bundle();
                bundle.putLong("key_activity_browse_time", cql());
                this.gcO.g(251, bundle);
            }
        } catch (Exception e22) {
            x.e("MicroMsg.WebViewUI", "webview on destroy callback mm exception [%s]", new Object[]{e22.toString()});
        }
        try {
            if (this.gcO != null) {
                bundle = this.gcO.g(19, null);
                if (bundle != null) {
                    x.i("MicroMsg.WebViewUI", "onDestroy, has init = %b, webviewHoldingCounter = %d", new Object[]{Boolean.valueOf(bundle.getBoolean("webview_video_proxy_init")), Integer.valueOf(pZb)});
                    if (bundle.getBoolean("webview_video_proxy_init") && pZb <= 0) {
                        FactoryProxyManager.getPlayManager().deinit();
                        this.gcO.g(75, null);
                    }
                }
            }
        } catch (Exception e222) {
            x.e("MicroMsg.WebViewUI", "deinit video player failed : %s", new Object[]{e222.getMessage()});
        }
        if (this.hKe != null) {
            try {
                unbindService(this.hKe);
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.WebViewUI", e3, "unbindService", new Object[0]);
            }
        }
        if (this.pNV != null) {
            this.pNV.detach();
        }
        this.jKW.clear();
        if (this.pYw != null) {
            b bVar2 = this.pYw;
            x.i("MicroMsg.WebView.MMSslErrorHandler", "detach");
            bVar2.context = null;
            bVar2.pVK = null;
            bVar2.pVL.clear();
            bVar2.pVM.clear();
        }
        if (this.pYy != null) {
            this.pYy.detach();
        }
        if (VERSION.SDK_INT >= 11) {
            this.mhH.removeJavascriptInterface("MicroMsg");
            this.mhH.removeJavascriptInterface("JsApi");
        }
        try {
            this.mhH.setWebChromeClient(null);
            this.mhH.setWebViewClient(null);
            this.mhH.setOnTouchListener(null);
            this.mhH.setOnLongClickListener(null);
            this.mhH.setVisibility(8);
            this.mhH.removeAllViews();
            this.mhH.clearView();
        } catch (Exception e2222) {
            x.e("MicroMsg.WebViewUI", "onDestroy, set web infos to null,  ex = %s", new Object[]{e2222.getMessage()});
        }
        this.pZf.bVf();
        if (this.gcP != null) {
            this.gcP.detach();
            this.gcP = null;
        }
        try {
            this.pZr.release();
        } catch (Exception e22222) {
            x.e("MicroMsg.WebViewUI", "onDestroy, remove view,  ex = " + e22222.getMessage());
        }
        try {
            this.mhH.destroy();
        } catch (Exception e222222) {
            x.w("MicroMsg.WebViewUI", "onDestroy, viewWV destroy, ex = %s", new Object[]{e222222.getMessage()});
        }
        WebViewClipBoardHelper webViewClipBoardHelper = this.pZh;
        try {
            webViewClipBoardHelper.pUv.removePrimaryClipChangedListener(webViewClipBoardHelper);
            webViewClipBoardHelper.pUv = null;
        } catch (Exception e4) {
        }
        this.mhH = null;
        System.gc();
    }

    private void aSN() {
        try {
            this.pZr.release();
            this.mhH.stopLoading();
            this.mhH.removeAllViews();
            this.mhH.clearView();
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "forceQuit, ex = " + e.getMessage());
        }
        if (this.pNV != null) {
            this.pNV.detach();
        }
        try {
            this.mhH.destroy();
        } catch (Exception e2) {
            x.w("MicroMsg.WebViewUI", "forceQuit, viewWV destroy, ex = %s", new Object[]{e2.getMessage()});
        }
        this.mhH = null;
        finish();
        x.chR();
        Process.killProcess(Process.myPid());
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 82 || this.pZq) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        ak.g bUy;
        if (i == 4 && this.mhH.hasEnteredFullscreen()) {
            this.mhH.leaveFullscreen();
            return true;
        } else if (i != 4 || this.pYk == null || this.pYj == null || this.pYl == null) {
            if (i == 4) {
                boolean z;
                if (this.pXL == null || !this.pXL.isShown()) {
                    z = false;
                } else {
                    this.pXL.hide();
                    bWo();
                    z = true;
                }
                if (z) {
                    return true;
                }
            }
            if (i == 4) {
                if (this.mhH.canGoBack() && this.jJB) {
                    bWc();
                    bUy = this.pQY.bUy();
                    bUy.pSr = new Object[]{this.cbP, Integer.valueOf(1)};
                    bUy.c(this.gcO);
                    return true;
                }
                g.pXv.close();
            }
            if (i == 4 && bWv() && aST()) {
                return true;
            }
            if (i == 4 && this.pZs.AQ(22)) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        } else {
            try {
                this.pYl.onHideCustomView();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WebViewUI", e, "onkeydown", new Object[0]);
            }
            bUy = this.pQY.bUy();
            bUy.pSr = new Object[]{this.cbP, Integer.valueOf(1)};
            bUy.c(this.gcO);
            return true;
        }
    }

    public void bWc() {
        this.mhH.goBack();
        this.pYb = null;
        if (this.pYA) {
            this.pYA = false;
        }
        g gVar = g.pXv;
        x.v("MicroMsg.WebViewReportUtil", "goBack traceid %s", new Object[]{gVar.nyj});
        if (!bi.oW(gVar.nyj)) {
            gVar.kB(5);
        }
    }

    public void cz(String str, int i) {
        if (this.pXL != null) {
            this.pXL.show();
            if (!bi.oW(str)) {
                this.pXL.setText(str);
            }
            if (i >= 0) {
                this.pXL.setMaxCount(i);
            }
        }
    }

    public int bWd() {
        if (this.pXL == null) {
            return 0;
        }
        return this.pXL.bYA();
    }

    protected void bVP() {
        int intExtra = getIntent().getIntExtra("webview_bg_color_rsID", -1);
        if (intExtra == -1 || this.mController.contentView == null) {
            this.mhH.setBackgroundColor(getResources().getColor(R.e.BW_95));
            return;
        }
        setBackGroundColorResource(intExtra);
        this.mController.contentView.setBackgroundResource(intExtra);
        this.mhH.setBackgroundResource(17170445);
        findViewById(R.h.webview_keyboard_ll).setBackgroundResource(17170445);
    }

    public void bWe() {
        if (getIntent() != null && getIntent().hasExtra("show_full_screen")) {
            L(getIntent().getBooleanExtra("show_full_screen", false), true);
        }
    }

    private void L(boolean z, boolean z2) {
        this.pXJ = z;
        MarginLayoutParams marginLayoutParams;
        final View decorView;
        if (z) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().hide();
            }
            if (this.jUX != null) {
                marginLayoutParams = (MarginLayoutParams) this.jUX.getLayoutParams();
                marginLayoutParams.topMargin = 0;
                this.jUX.setLayoutParams(marginLayoutParams);
            }
            if (this.pYP) {
                com.tencent.mm.ui.statusbar.a.u(this.jUX, true);
            } else if (this.jUY != null) {
                this.jUY.setVisibility(8);
            }
            getWindow().addFlags(1024);
            decorView = getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new OnSystemUiVisibilityChangeListener() {
                public final void onSystemUiVisibilityChange(int i) {
                    if ((i & 4) == 0 && WebViewUI.this.pXJ) {
                        WebViewUI.db(decorView);
                    }
                }
            });
            db(decorView);
            if (z2) {
                this.pXI.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        WebViewUI.this.aTe();
                    }
                });
                this.pXI.setVisibility(0);
                return;
            }
            this.pXI.setVisibility(8);
            return;
        }
        this.pXI.setVisibility(8);
        getWindow().clearFlags(1024);
        decorView = getWindow().getDecorView();
        if (decorView != null) {
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & -5895);
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().show();
            if (this.jUX != null) {
                marginLayoutParams = (MarginLayoutParams) this.jUX.getLayoutParams();
                marginLayoutParams.topMargin = bVY();
                this.jUX.setLayoutParams(marginLayoutParams);
            }
        }
        if (this.pYP) {
            com.tencent.mm.ui.statusbar.a.u(this.jUX, false);
        } else if (this.jUY != null) {
            this.jUY.setVisibility(0);
        }
    }

    private static void db(View view) {
        if (view != null) {
            view.setSystemUiVisibility(view.getSystemUiVisibility() | 5894);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && this.pXJ) {
            db(getWindow().getDecorView());
        }
    }

    public void initView() {
        boolean booleanExtra = getIntent().getBooleanExtra("vertical_scroll", true);
        this.pXX = getIntent().getBooleanExtra("finishviewifloadfailed", false);
        this.pXU = getIntent().getBooleanExtra("is_favorite_item", false);
        this.nTs = getIntent().getBooleanExtra("isWebwx", true);
        this.pXS = getIntent().getBooleanExtra("neverGetA8Key", false);
        this.pYO = getIntent().getBooleanExtra("neverBlockLocalRequest", false);
        this.pXW = getIntent().getBooleanExtra("KFromLoginHistory", false);
        this.pYK = LayoutInflater.from(this.mController.tml).inflate(R.i.sub_menu_prompt_view, null);
        boolean booleanExtra2 = getIntent().getBooleanExtra("show_feedback", false);
        this.pYM = bi.oV(getIntent().getStringExtra("sentUsername"));
        if (booleanExtra2) {
            addTextOptionMenu(1, getString(R.l.settings_feedbackui_title), new 8(this));
        }
        this.pXC = (ProgressBar) findViewById(R.h.create_progress_bar);
        this.pYL = findViewById(R.h.refresh_mask);
        this.pYL.setOnClickListener(new 9(this));
        if (this.nTs) {
            CharSequence oV = bi.oV(getIntent().getStringExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE));
            if (oV.length() > 0) {
                this.pXA = true;
            }
            super.M(oV);
        } else {
            setMMTitle("");
        }
        kb(false);
        kc(false);
        if (pYn == RenderPriority.NORMAL) {
            x.i("MicroMsg.WebViewUI", "initView, set render priority to HIGH");
            this.mhH.getSettings().setRenderPriority(RenderPriority.HIGH);
            pYn = RenderPriority.HIGH;
        }
        this.pZr.da(this.mController.contentView);
        this.pZr.b(this.mhH);
        bVP();
        this.pXG = (FrameLayout) findViewById(R.h.root_container);
        this.pXH = (FrameLayout) findViewById(R.h.container);
        x.i("MicroMsg.WebViewUI", "Is the current broswer kernel X5, " + this.mhH.getIsX5Kernel());
        if (this.mhH.getIsX5Kernel()) {
            this.mhH.setWebViewCallbackClient(this.pZm);
            this.mhH.setWebViewClientExtension(new g(this));
            f fVar = this.pZr;
            10 10 = new 10(this);
            if (fVar.pXg != null) {
                fVar.pXg.setMMOverScrollListener(10);
            }
        }
        this.pXL = (WebViewInputFooter) findViewById(R.h.webview_input_footer);
        if (this.pXL != null) {
            this.pXL.hide();
            this.pXL.setOnTextSendListener(new 11(this));
            this.pXL.setOnSmileyChosenListener(new 13(this));
            this.pXL.setOnSmileyPanelVisibilityChangedListener(new 14(this));
        }
        this.pXM = (WebViewSearchContentInputFooter) findViewById(R.h.search_content_input_footer);
        if (this.pXM != null) {
            this.pXM.setActionDelegate(new 15(this));
            this.mhH.setFindListener(new 16(this));
        }
        this.pXI = (MovingImageButton) findViewById(R.h.full_screen_menu);
        this.pYf = findViewById(R.h.webview_input_alert_toast);
        if (this.pYf != null) {
            this.pYf.setVisibility(8);
        }
        if (!booleanExtra) {
            this.mhH.setVerticalScrollBarEnabled(false);
        }
        this.mhH.setWebChromeClient(bWf());
        this.mhH.setWebViewClient(new i(this));
        this.mhH.setDownloadListener(new 17(this));
        this.mhH.requestFocus(130);
        this.mhH.setOnTouchListener(new 18(this));
        this.mhH.getSettings().setUserAgentString(s.aV(this, this.mhH.getSettings().getUserAgentString()));
        this.mhH.cAx();
        this.gcQ = new k(this.mController.tml);
        this.gcQ.a(this.mhH, this, null);
        this.gcQ.d(new 19(this));
        setBackBtn(new 20(this), bWg());
        if (bWh()) {
            WebViewKeyboardLinearLayout webViewKeyboardLinearLayout = (WebViewKeyboardLinearLayout) findViewById(R.h.webview_keyboard_ll);
            webViewKeyboardLinearLayout.setOnkbdStateListener(new 44(this, webViewKeyboardLinearLayout));
        }
        this.pXB = (MMFalseProgressBar) findViewById(R.h.web_falseprogress);
        super.setTitleBarDoubleClickListener(new 21(this));
    }

    public synchronized com.tencent.xweb.j bWf() {
        if (this.pYl == null) {
            this.pYl = new h(this);
        }
        return this.pYl;
    }

    public int bWg() {
        return this.pYS ? 0 : R.k.actionbar_icon_dark_close;
    }

    public final void AL(int i) {
        Drawable mutate = getResources().getDrawable(R.k.actionbar_icon_dark_close).mutate();
        mutate.setColorFilter(i, Mode.SRC_IN);
        com.tencent.mm.ui.s sVar = this.mController;
        if (sVar.mActionBar != null && sVar.tmt != null && mutate != null) {
            sVar.tmt.setImageDrawable(mutate);
            mutate.invalidateSelf();
        }
    }

    public boolean bWh() {
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (!this.gcX.b(this, i, i2, intent) && !com.tencent.mm.plugin.webview.modeltools.a.b(this, i, i2, intent) && i == 777) {
            Bundle bundle = null;
            if (intent != null) {
                bundle = intent.getBundleExtra("result_data");
            }
            if (bundle == null || !bundle.getString("go_next", "").equals("gdpr_confirm_continue")) {
                x.i("MicroMsg.WebViewUI", "gdpr continue:false");
                Intent intent2 = new Intent();
                Bundle bundle2 = new Bundle();
                bundle2.putString("go_next", "gdpr_confirm_logout");
                intent2.putExtra("result_data", bundle2);
                this.pZc = true;
                g.pXv.close();
                setResult(-1, intent2);
                finish();
                return;
            }
            x.i("MicroMsg.WebViewUI", "gdpr continue:true");
        }
    }

    public void onSwipeBack() {
        if (this.mhH != null) {
            if (this.pZt) {
                this.mhH.setOnLongClickListener(this.pZu);
            } else {
                this.mhH.setOnLongClickListener(null);
            }
        }
        YC();
        super.onSwipeBack();
    }

    public void onCancel() {
        if (this.mhH != null) {
            if (this.pZt) {
                this.mhH.setOnLongClickListener(this.pZu);
            } else {
                this.mhH.setOnLongClickListener(null);
            }
        }
        super.onCancel();
    }

    public void onDrag() {
        if (this.mhH != null) {
            this.mhH.setOnLongClickListener(new 24(this));
        }
        super.onDrag();
    }

    public final boolean Xf() {
        ak.g bUy = this.pQY.bUy();
        Object[] objArr = new Object[2];
        objArr[0] = this.mhH != null ? this.mhH.getUrl() : this.cbP;
        objArr[1] = Integer.valueOf(15);
        bUy.pSr = objArr;
        bUy.c(this.gcO);
        return super.Xf();
    }

    private static boolean a(com.tencent.mm.plugin.webview.ui.tools.jsapi.b bVar, String str) {
        if (bi.oW(str) || bVar == null) {
            return false;
        }
        return bVar.Dt(str);
    }

    public void ant() {
        String QT;
        boolean z;
        int bVC;
        Map hashMap;
        x.i("MicroMsg.WebViewUI", "edw postBinded");
        this.pZs.e(this.gcO);
        bWu();
        com.tencent.mm.plugin.webview.model.b bVar = this.pZe;
        com.tencent.mm.plugin.webview.stub.d dVar = this.gcO;
        try {
            QT = dVar.QT("DNSAdvanceOpen");
            x.i("MicroMsg.DNSPreGetOptimize", "switch open value : %s", new Object[]{QT});
            if (bi.oW(QT)) {
                x.e("MicroMsg.DNSPreGetOptimize", "get switch value is null or nil");
                z = false;
            } else {
                z = QT.equalsIgnoreCase("1");
            }
            if (z) {
                try {
                    QT = dVar.QT("DNSAdvanceRelateDomain");
                    if (bi.oW(QT)) {
                        x.e("MicroMsg.DNSPreGetOptimize", "domain list is null, just return");
                    } else {
                        bVar.Em().H(new 1(bVar, QT, dVar));
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.DNSPreGetOptimize", e, "", new Object[0]);
                }
            } else {
                x.i("MicroMsg.DNSPreGetOptimize", "server closed the switch");
            }
        } catch (Exception e2) {
            x.e("MicroMsg.DNSPreGetOptimize", "get dns pre get switch failed");
        }
        if (bWj()) {
            ah.A(new 26(this));
        }
        Bundle bundle = new Bundle();
        Bundle bundleExtra = getIntent().getBundleExtra("jsapiargs");
        if (bundleExtra == null) {
            bundleExtra = new Bundle();
        }
        bundleExtra.putInt("key_download_restrict", getIntent().getIntExtra("key_download_restrict", 0));
        bundleExtra.putString("key_function_id", getIntent().getStringExtra("key_function_id"));
        x.i("MicroMsg.WebViewUI", "KDownloadRestrict = %d, KFunctionID = %s", new Object[]{Integer.valueOf(bundleExtra.getInt("key_download_restrict", 0)), bundleExtra.getString("key_function_id", "")});
        bundle.putBundle("jsapiargs", bundleExtra);
        bundle.putCharSequence("bizofstartfrom", getIntent().getStringExtra("bizofstartfrom"));
        bundle.putBundle("startwebviewparams", getIntent().getBundleExtra("startwebviewparams"));
        bundle.putInt("screen_orientation", this.screenOrientation);
        try {
            this.gcO.a(20, bundle, hashCode());
        } catch (RemoteException e3) {
            x.e("MicroMsg.WebViewUI", "postBinded, invoke AC_SET_INITIAL_ARGS, ex = " + e3.getMessage());
        }
        String stringExtra = getIntent().getStringExtra("geta8key_username");
        int intExtra = getIntent().getIntExtra("preChatTYPE", 0);
        String stringExtra2 = getIntent().getStringExtra("srcUsername");
        long longExtra = getIntent().getLongExtra("message_id", 0);
        int intExtra2 = getIntent().getIntExtra("message_index", 0);
        String stringExtra3 = getIntent().getStringExtra("KsnsViewId");
        String stringExtra4 = getIntent().getStringExtra("KPublisherId");
        String stringExtra5 = getIntent().getStringExtra("KAppId");
        String stringExtra6 = getIntent().getStringExtra("pre_username");
        String stringExtra7 = getIntent().getStringExtra("expid_str");
        String string = bundleExtra.getString("key_snsad_statextstr");
        QT = null;
        if (this.mhH != null) {
            QT = this.mhH.getTitle();
        }
        if (bi.oW(QT)) {
            QT = getIntent().getStringExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE);
        }
        if (bi.oW(QT)) {
            QT = getIntent().getStringExtra("webpageTitle");
        }
        com.tencent.mm.plugin.webview.model.ak.j bUv = this.pQY.bUv();
        bUv.username = stringExtra;
        bUv.pSE = intExtra;
        bUv.cbP = this.cbP;
        bUv.pSA = intExtra2;
        bUv.scene = Rq(stringExtra);
        bUv.pSz = longExtra;
        bUv.pSB = new com.tencent.mm.a.o(longExtra).toString();
        bUv.pSx = stringExtra2;
        bUv.pSy = stringExtra3;
        bUv.jHv = stringExtra4;
        bUv.appId = stringExtra5;
        bUv.pSC = stringExtra6;
        bUv.pSD = this.pSD;
        bUv.nNV = string;
        bUv.title = bi.aG(QT, "");
        bUv.cGK = stringExtra7;
        this.pQY.bUx().cbP = this.cbP;
        if (bWn()) {
            try {
                bundleExtra = new Bundle();
                bundleExtra.putString("srcUsername", getIntent().getStringExtra("srcUsername"));
                this.gcO.a(29, bundleExtra, hashCode());
            } catch (Exception e4) {
            }
        }
        if (!bi.oW(stringExtra2)) {
            try {
                this.gcO.QU(stringExtra2);
            } catch (Exception e5) {
                x.e("MicroMsg.WebViewUI", "postBinded, fail triggerGetContact, ex = " + e5.getMessage());
            }
        }
        try {
            if (getIntent().getIntExtra("pay_channel", -1) != -1) {
                x.i("MicroMsg.WebViewUI", "hy: found channel in intent. pay channel: %d", new Object[]{Integer.valueOf(getIntent().getIntExtra("pay_channel", -1))});
            } else {
                bVC = this.gcO.bVC();
                if (bVC != -1) {
                    x.i("MicroMsg.WebViewUI", "hy: found channel in channel helper. pay channel: %d", new Object[]{Integer.valueOf(bVC)});
                    getIntent().putExtra("pay_channel", bVC);
                }
            }
        } catch (Exception e6) {
            x.e("MicroMsg.WebViewUI", "hy: init pay channel failed");
        }
        this.jKW.clear();
        MMWebView mMWebView = this.mhH;
        e eVar = this.gcP;
        Map hashMap2 = new HashMap();
        hashMap2.put("webview_type", "1");
        hashMap2.put("init_url", this.cbP);
        hashMap2.put("init_font_size", "1");
        hashMap2.put("short_url", bi.oV(getIntent().getStringExtra("shortUrl")));
        this.pNV = new com.tencent.mm.plugin.webview.ui.tools.jsapi.d(mMWebView, eVar, hashMap2, this.gcO, hashCode());
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar2 = this.pNV;
        stringExtra = getIntent().getStringExtra("geta8key_username");
        if (!bi.oW(getIntent().getStringExtra("srcUsername"))) {
            hashMap = new HashMap();
            hashMap.put("srcUsername", getIntent().getStringExtra("srcUsername"));
            hashMap.put("srcDisplayname", getIntent().getStringExtra("srcDisplayname"));
        } else if (bi.oW(stringExtra)) {
            hashMap = new HashMap();
        } else {
            hashMap = new HashMap();
            hashMap.put("srcUsername", stringExtra);
        }
        hashMap.put("message_id", Long.valueOf(getIntent().getLongExtra("message_id", 0)));
        hashMap.put("message_index", Integer.valueOf(getIntent().getIntExtra("message_index", 0)));
        hashMap.put("scene", Integer.valueOf(Rq(stringExtra)));
        hashMap.put("pay_channel", Integer.valueOf(getIntent().getIntExtra("pay_channel", 0)));
        hashMap.put("stastic_scene", Integer.valueOf(getIntent().getIntExtra("stastic_scene", 0)));
        hashMap.put("from_scence", Integer.valueOf(getIntent().getIntExtra("from_scence", 0)));
        if (!bi.oW(getIntent().getStringExtra("KTemplateId"))) {
            hashMap.put("KTemplateId", getIntent().getStringExtra("KTemplateId"));
        }
        int intExtra3 = getIntent().getIntExtra("pay_scene", -1);
        if (intExtra3 != -1) {
            x.i("MicroMsg.WebViewUI", "get pay scene from extra: %s", new Object[]{Integer.valueOf(intExtra3)});
        } else {
            intExtra3 = 3;
            x.i("MicroMsg.WebViewUI", "default pay scene to: %s", new Object[]{Integer.valueOf(3)});
        }
        hashMap.put("pay_scene", Integer.valueOf(intExtra3));
        dVar2.qhp = hashMap;
        if (bWi() != null) {
            bWi().pLO = this.pNV;
        }
        this.mhH.addJavascriptInterface(this.pNV, "__wx");
        this.jKW.add(this.pNV);
        this.jKW.add(new t(this, (byte) 0));
        this.jKW.add(new q(this, (byte) 0));
        this.jKW.add(new e(this, (byte) 0));
        this.jKW.add(new s(this, (byte) 0));
        this.jKW.add(new v(this, (byte) 0));
        this.jKW.add(new a(this, (byte) 0));
        this.jKW.add(new aa(this, (byte) 0));
        this.jKW.add(new u(this, (byte) 0));
        this.jKW.add(new j(this, (byte) 0));
        this.jKW.add(new b(this, (byte) 0));
        this.jKW.add(new c(this, (byte) 0));
        this.jKW.add(new com.tencent.mm.plugin.webview.ui.tools.jsapi.e(this.mhH, this.pNV));
        this.jKW.add(new z(this, (byte) 0));
        this.jKW.add(new w(this, (byte) 0));
        this.jKW.add(new o(this, (byte) 0));
        if (getIntent().getBooleanExtra("allow_wx_schema_url", false)) {
            this.jKW.add(new l(this, (byte) 0));
        }
        this.jKW.add(new f(this, (byte) 0));
        try {
            bVC = bi.getInt(this.gcO.QT("WebviewDisableX5Logo"), 0);
        } catch (Exception e52) {
            x.w("MicroMsg.WebViewUI", "getting flag of x5 logo state failed, ex = " + e52.getMessage());
            bVC = 0;
        }
        x.i("MicroMsg.WebViewUI", "getting flag of x5 logo state, disableX5Logo = %d, disableBounceScroll = %b", new Object[]{Integer.valueOf(bVC), Boolean.valueOf(getIntent().getBooleanExtra("disable_bounce_scroll", false))});
        if (bVC == 1 || r1) {
            this.pZr.jY(true);
        }
        if (getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_disable_over_scroll", false)) {
            this.pZr.jY(true);
        }
        try {
            this.pYx = bi.getInt(this.gcO.QT("OpenJSReadySpeedy"), 0);
        } catch (Exception e522) {
            x.w("MicroMsg.WebViewUI", "postBinded, openJSReadySpeedy, ex = " + e522.getMessage());
        }
        x.i("MicroMsg.WebViewUI", "postBinded, openJSReadySpeedy = %d", new Object[]{Integer.valueOf(this.pYx)});
        ak.K(this.mhH.getIsX5Kernel(), bi.oV(this.cbP).startsWith("https://"));
        if (this.mhH.getIsX5Kernel()) {
            com.tencent.mm.pluginsdk.ui.tools.k.kB(7);
            h.mEJ.a(64, 64, 1, 0, 1, 1, false);
        } else {
            h.mEJ.a(64, 0, 1, false);
        }
        this.pYy = new com.tencent.mm.plugin.webview.ui.tools.jsapi.f(this.mhH, this.gcO, this.pNV, new 27(this), getIntent().getBooleanExtra("key_load_js_without_delay", false), bWj());
        try {
            bVC = bi.getInt(this.gcO.QT("WebviewDisableDigestVerify"), 0);
        } catch (Exception e5222) {
            x.w("MicroMsg.WebViewUI", "getting js digest verification config fails, ex = " + e5222.getMessage());
            bVC = 0;
        }
        x.i("MicroMsg.WebViewUI", "js digest verification config = %d", new Object[]{Integer.valueOf(bVC)});
        if (bVC == 0 && getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("wvsha1", true) && bWx()) {
            this.pNV.bXQ();
            this.pZl.pRW = this.pNV.qht;
        }
        if (getIntent().getBooleanExtra("forceHideShare", false)) {
            ka(false);
            x.d("MicroMsg.WebViewUI", "[hakon] postBinded :%d: force hide", new Object[]{Long.valueOf(System.currentTimeMillis())});
        } else {
            ka(getIntent().getBooleanExtra("showShare", true));
            x.d("MicroMsg.WebViewUI", "[cpan] postBinded :%d: show:%b", new Object[]{Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(z)});
        }
        this.pXF = LayoutInflater.from(this).inflate(R.i.web_view_font_chooser, null);
        FontChooserView fontChooserView = (FontChooserView) this.pXF.findViewById(R.h.font_chooser_view);
        View findViewById = this.pXF.findViewById(R.h.font_chooser_close);
        if (!this.mhH.getIsX5Kernel()) {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new 61(this));
        }
        fontChooserView.setOnChangeListener(new k(this, (byte) 0));
        this.pXF.setLayoutParams(new FrameLayout.LayoutParams(-1, -2, 80));
        this.pXH.addView(this.pXF);
        this.pXF.setVisibility(8);
        bVC = 2;
        try {
            if (this.gcO.aSn()) {
                bVC = (bWr() || bWs()) ? bWt() : (bi.oW(this.cbP) || !com.tencent.mm.plugin.webview.a.pNp.matcher(this.cbP).matches()) ? this.gcO.ej(16384, 0) : this.gcO.ej(16388, 0);
            }
        } catch (Exception e7) {
            x.w("MicroMsg.WebViewUI", "initFontChooserView, ex = " + e7.getMessage());
        }
        if (bVC <= 0 || bVC > 4) {
            bVC = 2;
        }
        AO(bVC);
        AP(bVC);
        try {
            this.gcO.a(this.cbP, true, null);
        } catch (Exception e52222) {
            x.w("MicroMsg.WebViewUI", "postBinded, jumpToActivity, ex = " + e52222.getMessage());
        }
        for (com.tencent.mm.plugin.webview.ui.tools.jsapi.b bVar2 : this.jKW) {
            if (a(bVar2, this.cbP)) {
                x.i("MicroMsg.WebViewUI", "initView, url handled, result = " + bVar2.Du(this.cbP) + ", url = " + this.cbP);
                return;
            }
        }
        if (bVH()) {
            x.w("MicroMsg.WebViewUI", "needDelayLoadUrl is true, do nothing");
            return;
        }
        String stringExtra8 = getIntent().getStringExtra("data");
        if (stringExtra8 != null) {
            x.i("MicroMsg.WebViewUI", stringExtra8);
            if (getIntent().getBooleanExtra("QRDataFlag", true)) {
                try {
                    stringExtra8 = this.gcO.QP(stringExtra8);
                } catch (Exception e522222) {
                    x.w("MicroMsg.WebViewUI", "postBinded, formatQRString, ex = " + e522222.getMessage());
                }
            }
            this.mhH.setOnLongClickListener(this.pZu);
            this.pZt = true;
            this.mhH.getSettings().setUseWideViewPort(false);
            this.mhH.getSettings().setLoadWithOverviewMode(false);
            if (Rs(null)) {
                this.mhH.getSettings().setJavaScriptEnabled(false);
                this.mhH.loadDataWithBaseURL(null, stringExtra8, "text/html", "utf-8", null);
                x.i("MicroMsg.WebViewUI", "loadDataWithBaseUrl, data = " + stringExtra8);
                return;
            }
            x.f("MicroMsg.WebViewUI", "postBinded baseUrl, canLoadUrl fail, url = " + null);
            aSN();
            return;
        }
        if (bi.oW(this.cbP)) {
            gU(false);
        }
        if (this.cbP == null || this.cbP.length() == 0) {
            x.e("MicroMsg.WebViewUI", "initView, rawUrl is null, no data or getStringExtra(\"data\") is null");
            return;
        }
        Uri parse = Uri.parse(this.cbP);
        if (parse == null) {
            x.e("MicroMsg.WebViewUI", "initView uri is null");
            return;
        }
        if (parse.getScheme() == null) {
            this.cbP = "http://" + this.cbP;
        } else if (!parse.getScheme().startsWith("http")) {
            x.i("MicroMsg.WebViewUI", "uri scheme not startwith http, scheme = " + parse.getScheme());
            if (!Rs(this.cbP)) {
                x.f("MicroMsg.WebViewUI", "postBinded, canLoadUrl fail, url = " + this.cbP);
                aSN();
                return;
            } else if (bWj()) {
                x.i("MicroMsg.WebViewUI", "webview ispreloaded , do not reload url");
                return;
            } else {
                this.mhH.loadUrl(this.cbP);
                return;
            }
        }
        this.pYo = new m(this.cbP);
        try {
            bundleExtra = this.gcO.g(100000, null);
            if (!(bundleExtra == null || bundleExtra.getString("force_geta8key_host_path") == null)) {
                this.pZv = bundleExtra.getString("force_geta8key_host_path").split(";");
                this.pYo.pZv = this.pZv;
            }
        } catch (Exception e5222222) {
            x.e("MicroMsg.WebViewUI", "get force geta8key paths failed : %s", new Object[]{e5222222.getMessage()});
        }
        if (this.pXS || this.gcP.has(this.cbP)) {
            x.i("MicroMsg.WebViewUI", "initView, no need to geta8key, loadUrl directly, neverGetA8Key = " + this.pXS);
            if (!Rs(this.cbP)) {
                x.f("MicroMsg.WebViewUI", "postBinded 2, canLoadUrl fail, url = " + this.cbP);
                aSN();
                return;
            } else if (Rm(this.cbP)) {
                this.pYQ = true;
                this.pXB.finish();
                this.pXB.setVisibility(8);
                Do(this.cbP);
                return;
            } else {
                this.mhH.loadUrl(this.cbP);
                return;
            }
        }
        if (Rm(this.cbP)) {
            Do(this.cbP);
            this.pZz = this.cbP;
            this.pYQ = true;
            this.pXB.finish();
            this.pXB.setVisibility(8);
        }
        if (!this.pZc && !this.pZd && !isFinishing()) {
            x.i("MicroMsg.WebViewUI", "not call onDestory, try to geta8key again");
            a(this.cbP, false, -1);
            x.i("MicroMsg.WebViewUI", "before geta8key, rawUrl = " + this.cbP);
        }
    }

    public boolean Rm(String str) {
        hashCode();
        return o.QA(str);
    }

    public void Do(String str) {
        Map hashMap = new HashMap(2);
        hashMap.put("Pragma", "no-cache");
        hashMap.put("Cache-Control", "no-cache");
        if (this.mhH != null) {
            this.mhH.loadUrl(str, hashMap);
        }
    }

    public final boolean needShowIdcError() {
        return false;
    }

    private boolean aTg() {
        try {
            if (this.gcO != null) {
                return this.gcO.bVz();
            }
            x.w("MicroMsg.WebViewUI", "invoker is null");
            return false;
        } catch (RemoteException e) {
            x.e("MicroMsg.WebViewUI", "unable get config for Scan QRCode" + e.getMessage());
            return false;
        }
    }

    private boolean bVD() {
        try {
            if (this.gcO != null) {
                return this.gcO.bVD();
            }
            x.w("MicroMsg.WebViewUI", "invoker is null");
            return false;
        } catch (RemoteException e) {
            x.e("MicroMsg.WebViewUI", "unable get config for WebViewDownLoadFile" + e.getMessage());
            return false;
        }
    }

    private static String Dc(String str) {
        try {
            Matcher matcher = Pattern.compile("(?i)^.*filename=\"?([^\"]+)\"?.*$").matcher(str);
            if (matcher.find() && matcher.groupCount() == 1) {
                return matcher.group(1);
            }
            return null;
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "getFileNameFromContentDisposition error " + e.getMessage());
            return null;
        }
    }

    private boolean a(ContextMenu contextMenu, final String str) {
        boolean isSDCardAvailable;
        try {
            isSDCardAvailable = this.gcO.isSDCardAvailable();
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "onCreateContextMenu fail, ex = " + e.getMessage());
            isSDCardAvailable = false;
        }
        if (!isSDCardAvailable) {
            return true;
        }
        contextMenu.setHeaderTitle(R.l.wv_image);
        try {
            isSDCardAvailable = this.gcO.aSn();
        } catch (Exception e2) {
            x.e("MicroMsg.WebViewUI", "get has setuin failed : %s", new Object[]{e2.getMessage()});
            isSDCardAvailable = false;
        }
        x.i("MicroMsg.WebViewUI", "hasSetAcc = %b, canShareImage = %b, canFavImage = %b", new Object[]{Boolean.valueOf(isSDCardAvailable), Boolean.valueOf(this.gcP.bVS().cgj()), Boolean.valueOf(this.gcP.bVS().cgk())});
        if (isSDCardAvailable && r3) {
            contextMenu.add(0, 0, 0, getString(R.l.readerapp_alert_retransmit)).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    try {
                        s.a(WebViewUI.this, str, com.tencent.xweb.b.cIi().getCookie(str), WebViewUI.this.gcO.isSDCardAvailable(), new 1(this));
                    } catch (Exception e) {
                        x.e("MicroMsg.WebViewUI", "onMenuItemClick fail, ex = " + e.getMessage());
                    }
                    return true;
                }
            });
        }
        contextMenu.add(0, 0, 0, getString(R.l.save_to_local)).setOnMenuItemClickListener(new 30(this, str));
        if (isSDCardAvailable && r4) {
            contextMenu.add(0, 0, 0, getString(R.l.plugin_favorite_opt)).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    try {
                        boolean isSDCardAvailable = WebViewUI.this.gcO.isSDCardAvailable();
                        String replaceAll = str.replaceAll("tp=webp", "");
                        s.a(WebViewUI.this, replaceAll, com.tencent.xweb.b.cIi().getCookie(replaceAll), isSDCardAvailable, new 1(this));
                    } catch (Exception e) {
                        x.e("MicroMsg.WebViewUI", "onMenuItemClick fail, ex = " + e.getMessage());
                    }
                    return true;
                }
            });
        }
        if (this.gcR == null) {
            return false;
        }
        contextMenu.add(0, 0, 0, com.tencent.mm.plugin.scanner.a.aB(this.gcS, this.gcR) ? getString(R.l.recog_wxcode_of_image_file) : getString(R.l.recog_qbar_of_image_file)).setOnMenuItemClickListener(new 32(this, this.gcR, str));
        this.gcR = null;
        return true;
    }

    private void a(ContextMenu contextMenu, WebView.b bVar) {
        if (!a(contextMenu, bVar.mExtra) && this.gcP.bVS().cgh() && aTg()) {
            this.gcW = bVar;
            this.gcU = new f();
            this.gcU.a(this.mhH, this.gda);
        }
    }

    private void b(ContextMenu contextMenu, WebView.b bVar) {
        if (!a(contextMenu, bVar.mExtra) && this.gcP.bVS().cgh() && aTg()) {
            this.gcV = bVar;
            this.gcU = new f();
            this.gcU.a(this.mhH, this.gda);
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        WebView.b hitTestResult;
        if (view instanceof android.webkit.WebView) {
            hitTestResult = this.mhH.getHitTestResult();
            if (hitTestResult != null) {
                if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                    b(contextMenu, hitTestResult);
                }
            }
        } else if (view instanceof MMWebView) {
            hitTestResult = ((MMWebView) view).getHitTestResult();
            if (hitTestResult == null) {
                return;
            }
            if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                a(contextMenu, hitTestResult);
            }
        }
    }

    public final String getRawUrl() {
        String str = null;
        try {
            str = getIntent().getStringExtra("rawUrl");
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "getRawUrl exception:%s", new Object[]{e.getMessage()});
            if (e instanceof ClassNotFoundException) {
                finish();
                return str;
            }
        }
        if (str != null && str.length() > 0) {
            return str;
        }
        Uri data = getIntent().getData();
        if (data == null) {
            return "";
        }
        return data.toString();
    }

    public w bWi() {
        return null;
    }

    public boolean bWj() {
        return false;
    }

    public void bWk() {
    }

    private boolean bWl() {
        boolean z = false;
        try {
            return this.gcO.QS("favorite");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[z]);
            return z;
        }
    }

    private void cO(List<String> list) {
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                if (this.pYu.get(str) != null) {
                    x.i("MicroMsg.WebViewUI", "find %s icon from cache ok", new Object[]{str});
                } else {
                    x.w("MicroMsg.WebViewUI", "not found %s icon from cache, try to load", new Object[]{str});
                    try {
                        String QO = this.gcO.QO(str);
                        if (!bi.oW(QO)) {
                            Bitmap Rf = d.Rf(QO);
                            if (Rf != null) {
                                x.i("MicroMsg.WebViewUI", "load ok, and cache it");
                                this.pYu.put(str, Rf);
                            }
                        }
                    } catch (Exception e) {
                        x.w("MicroMsg.WebViewUI", "getheadimg, ex = " + e.getMessage());
                    }
                }
                if (this.pYv.containsKey(str)) {
                    x.i("MicroMsg.WebViewUI", "find %s nick from cache ok", new Object[]{str});
                } else {
                    x.w("MicroMsg.WebViewUI", "not found %s nick from cache, try to load", new Object[]{str});
                    Object obj = null;
                    try {
                        obj = this.gcO.gT(str);
                        x.i("MicroMsg.WebViewUI", "load nick ok");
                    } catch (Exception e2) {
                        x.w("MicroMsg.WebViewUI", "onAttach, ex = " + e2.getMessage());
                    }
                    this.pYv.put(str, obj);
                }
            }
        }
    }

    protected final boolean AM(int i) {
        SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) this.pZw.get(this.mhH.getUrl());
        if (sparseBooleanArray == null || !sparseBooleanArray.get(i, false)) {
            return true;
        }
        return false;
    }

    protected static boolean a(JsapiPermissionWrapper jsapiPermissionWrapper, int i) {
        if (jsapiPermissionWrapper == null) {
            return false;
        }
        int CB = jsapiPermissionWrapper.CB(i);
        if (CB == 1 || CB == 10) {
            return true;
        }
        return false;
    }

    protected static boolean b(JsapiPermissionWrapper jsapiPermissionWrapper, int i) {
        if (jsapiPermissionWrapper != null && jsapiPermissionWrapper.CB(i) == 10) {
            return true;
        }
        return false;
    }

    public final void aTo() {
        String Rp = Rp(this.pZz);
        String stringExtra = getIntent().getStringExtra("shortcut_user_name");
        if (bi.oW(Rp) || bi.oW(stringExtra)) {
            x.e("MicroMsg.WebViewUI", "addShortcut, appid or username is null");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("KAppId", Rp);
        bundle.putString("shortcut_user_name", stringExtra);
        bundle.putInt("webviewui_binder_id", hashCode());
        try {
            this.gcO.g(80, bundle);
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "addShortcut, e = " + e.getMessage());
        }
    }

    public void aTe() {
        boolean z;
        com.tencent.mm.ui.widget.a.d dVar;
        String url = this.mhH.getUrl();
        ArrayList arrayList = this.pYF.containsKey(url) ? (ArrayList) this.pYF.get(url) : null;
        if (arrayList == null || arrayList.size() <= 0) {
            z = false;
        } else {
            z = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        if (valueOf.booleanValue()) {
            dVar = new com.tencent.mm.ui.widget.a.d(this.mController.tml, 1, false);
        } else {
            dVar = new com.tencent.mm.ui.widget.a.d(this.mController.tml, 0, true);
        }
        dVar.uAx = new 35(this);
        dVar.uAy = new 36(this);
        dVar.ofq = new 37(this);
        dVar.ofp = new 38(this, valueOf, arrayList);
        url = this.mhH != null ? this.mhH.getUrl() : null;
        if (!bi.oW(url)) {
            String host = Uri.parse(url).getHost();
            url = getString(R.l.webview_logo_url, new Object[]{host});
            if (!bi.oW(host) && com.tencent.mm.sdk.a.b.chp()) {
                CharSequence charSequence;
                try {
                    if (this.gcO.g(98, null) != null) {
                        url = url + "_NewBridge";
                    }
                    charSequence = url;
                } catch (Exception e) {
                }
                if (bi.oW(this.pYC)) {
                    View inflate = LayoutInflater.from(this).inflate(R.i.mm_webview_ui_bottom_sheet_title_text, null);
                    TextView textView = (TextView) inflate.findViewById(R.h.title_text);
                    TextView textView2 = (TextView) inflate.findViewById(R.h.desc_text);
                    dVar.dS(inflate);
                    textView.setText(charSequence);
                    textView2.setText(bi.oV(this.pYC));
                } else if (!bi.oW(host)) {
                    dVar.i(charSequence, 1);
                }
            }
            Object charSequence2 = url;
            if (bi.oW(this.pYC)) {
                View inflate2 = LayoutInflater.from(this).inflate(R.i.mm_webview_ui_bottom_sheet_title_text, null);
                TextView textView3 = (TextView) inflate2.findViewById(R.h.title_text);
                TextView textView22 = (TextView) inflate2.findViewById(R.h.desc_text);
                dVar.dS(inflate2);
                textView3.setText(charSequence2);
                textView22.setText(bi.oV(this.pYC));
            } else if (!bi.oW(host)) {
                dVar.i(charSequence2, 1);
            }
        }
        if (this.pXJ) {
            dVar.qgK = true;
            dVar.qgL = true;
        } else {
            dVar.qgK = false;
            dVar.qgL = false;
        }
        if (this.pXM == null || !this.pXM.isShown()) {
            YC();
            ah.i(new 40(this, dVar), 100);
            return;
        }
        this.pXM.hide();
        ah.i(new 39(this, dVar), 100);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.LinkedList<com.tencent.mm.k.d.a> bWm() {
        /*
        r12 = this;
        r0 = 0;
        r2 = 1;
        r3 = 0;
        r1 = r12.mhH;
        if (r1 != 0) goto L_0x0011;
    L_0x0007:
        r1 = "MicroMsg.WebViewUI";
        r2 = "viewwv is null, maybe has destroyed";
        com.tencent.mm.sdk.platformtools.x.e(r1, r2);
    L_0x0010:
        return r0;
    L_0x0011:
        r4 = r12.cbP;
        r1 = r12.mhH;
        if (r1 == 0) goto L_0x00cc;
    L_0x0017:
        r1 = r12.mhH;
        r1 = r1.getUrl();
        r5 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r5 != 0) goto L_0x00cc;
    L_0x0023:
        if (r1 == 0) goto L_0x0010;
    L_0x0025:
        r4 = new java.net.URL;	 Catch:{ Exception -> 0x00b8 }
        r4.<init>(r1);	 Catch:{ Exception -> 0x00b8 }
        r1 = ".*(\\.wanggou\\.com|\\.jd\\.com)";
        r5 = java.util.regex.Pattern.compile(r1);	 Catch:{ Exception -> 0x00b8 }
        r1 = r4.getHost();	 Catch:{ Exception -> 0x00b8 }
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r1);	 Catch:{ Exception -> 0x00b8 }
        if (r4 != 0) goto L_0x0010;
    L_0x003b:
        r4 = ".";
        r4 = r1.startsWith(r4);	 Catch:{ Exception -> 0x00b8 }
        if (r4 != 0) goto L_0x0054;
    L_0x0044:
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00b8 }
        r6 = ".";
        r4.<init>(r6);	 Catch:{ Exception -> 0x00b8 }
        r1 = r4.append(r1);	 Catch:{ Exception -> 0x00b8 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00b8 }
    L_0x0054:
        r4 = "MicroMsg.WebViewUI";
        r6 = "host = %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x00b8 }
        r8 = 0;
        r7[r8] = r1;	 Catch:{ Exception -> 0x00b8 }
        com.tencent.mm.sdk.platformtools.x.d(r4, r6, r7);	 Catch:{ Exception -> 0x00b8 }
        r1 = r5.matcher(r1);	 Catch:{ Exception -> 0x00b8 }
        r1 = r1.matches();	 Catch:{ Exception -> 0x00b8 }
        if (r1 == 0) goto L_0x0010;
    L_0x006d:
        r1 = r12.pYW;	 Catch:{ Exception -> 0x00b8 }
        if (r1 != 0) goto L_0x00a2;
    L_0x0071:
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00b8 }
        r1 = r12.gcO;	 Catch:{ Exception -> 0x00b8 }
        r1 = r1.bVt();	 Catch:{ Exception -> 0x00b8 }
        r12.pYW = r1;	 Catch:{ Exception -> 0x00b8 }
        r6 = "MicroMsg.WebViewUI";
        r7 = "[hakon] getConfigListMap %b, cost %d";
        r1 = 2;
        r8 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x00b8 }
        r9 = 0;
        r1 = r12.pYW;	 Catch:{ Exception -> 0x00b8 }
        if (r1 == 0) goto L_0x00b6;
    L_0x008b:
        r1 = r2;
    L_0x008c:
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x00b8 }
        r8[r9] = r1;	 Catch:{ Exception -> 0x00b8 }
        r1 = 1;
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00b8 }
        r4 = r10 - r4;
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x00b8 }
        r8[r1] = r4;	 Catch:{ Exception -> 0x00b8 }
        com.tencent.mm.sdk.platformtools.x.d(r6, r7, r8);	 Catch:{ Exception -> 0x00b8 }
    L_0x00a2:
        r1 = r12.pYW;	 Catch:{ Exception -> 0x00b8 }
        if (r1 == 0) goto L_0x0010;
    L_0x00a6:
        r1 = r12.pYW;	 Catch:{ Exception -> 0x00b8 }
        r1 = r1.size();	 Catch:{ Exception -> 0x00b8 }
        if (r1 <= 0) goto L_0x0010;
    L_0x00ae:
        r1 = r12.pYW;	 Catch:{ Exception -> 0x00b8 }
        r0 = com.tencent.mm.k.d.j(r1);	 Catch:{ Exception -> 0x00b8 }
        goto L_0x0010;
    L_0x00b6:
        r1 = r3;
        goto L_0x008c;
    L_0x00b8:
        r1 = move-exception;
        r4 = "MicroMsg.WebViewUI";
        r5 = "[hakon] getJDMenuItems, ex = ";
        r2 = new java.lang.Object[r2];
        r1 = r1.getMessage();
        r2[r3] = r1;
        com.tencent.mm.sdk.platformtools.x.d(r4, r5, r2);
        goto L_0x0010;
    L_0x00cc:
        r1 = r4;
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.bWm():java.util.LinkedList<com.tencent.mm.k.d$a>");
    }

    protected final boolean bWn() {
        String stringExtra = getIntent().getStringExtra("srcUsername");
        String stringExtra2 = getIntent().getStringExtra("bizofstartfrom");
        return (stringExtra == null || stringExtra2 == null || !"enterpriseHomeSubBrand".equals(stringExtra2)) ? false : true;
    }

    protected final void b(String str, Drawable drawable) {
        a(0, str, drawable, new 41(this, bWn(), getIntent().getStringExtra("srcUsername")));
    }

    public void ka(boolean z) {
        boolean z2 = true;
        this.pZq = z;
        if (this.mhH == null) {
            x.e("MicroMsg.WebViewUI", "viewwv is null, maybe has destroyed");
            return;
        }
        enableOptionMenu(z);
        showOptionMenu(z);
        boolean booleanExtra = getIntent().getBooleanExtra("show_feedback", false);
        if (booleanExtra) {
            showOptionMenu(booleanExtra);
        }
        int i = R.g.mm_title_btn_menu;
        if (bWm() != null) {
            i = R.k.mm_title_btn_jd;
        }
        getIntent().getStringExtra("srcUsername");
        bWn();
        x.i("MicroMsg.WebViewUI", "banRightBtn:%b, showFixToolsBtn:%b", new Object[]{Boolean.valueOf(getIntent().getBooleanExtra("KRightBtn", false)), Boolean.valueOf(getIntent().getBooleanExtra("KShowFixToolsBtn", false))});
        if (!getIntent().getBooleanExtra("KRightBtn", false)) {
            int i2;
            if (r4) {
                addIconOptionMenu(0, R.k.fix_tools_entry, new 42(this));
                i2 = 1;
            } else {
                i2 = 0;
            }
            addIconOptionMenu(i2, i, new 43(this));
        }
        if (z) {
            z2 = false;
        }
        kd(z2);
    }

    public void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        if (com.tencent.mm.compatible.util.d.fR(21)) {
            Drawable f = android.support.v4.content.a.f(this, i2);
            if (f != null) {
                if (aUR()) {
                    f.setColorFilter(-16777216, Mode.SRC_ATOP);
                } else if (this.pZk == null || this.pZk.qaV) {
                    f.clearColorFilter();
                } else {
                    f.setColorFilter(-16777216, Mode.SRC_ATOP);
                }
                a(i, getString(com.tencent.mm.w.a.k.app_more), f, onMenuItemClickListener);
                return;
            }
            return;
        }
        super.addIconOptionMenu(i, i2, onMenuItemClickListener);
    }

    private void bWo() {
        if (this.pYf != null) {
            this.pYf.setVisibility(8);
        }
        if (this.pYg != null) {
            this.pYg.SO();
        }
    }

    public final void aTi() {
        this.pNV.bf("sendAppMessage", true);
        this.pNV.bXV();
        this.pQY.Qy("mm_send_friend_count");
    }

    private void Rn(String str) {
        this.pNV.bf("sendAppMessage", false);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.pNV;
        if (dVar.qhq) {
            Map hashMap = new HashMap();
            hashMap.put("scene", "enterprise");
            dVar.qhk.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.a("menu:share:appmessage", hashMap, dVar.qhs, dVar.qht) + ")", null);
            try {
                dVar.gcO.H("connector_local_send", str, dVar.pUz);
                dVar.gcO.H("scene", "enterprise", dVar.pUz);
                return;
            } catch (Exception e) {
                x.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                return;
            }
        }
        x.e("MicroMsg.JsApiHandler", "onSendToEnterprise fail, not ready");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bWp() {
        /*
        r14 = this;
        r13 = 3;
        r12 = 2;
        r11 = 4;
        r10 = 1;
        r9 = 0;
        r0 = r14.getIntent();
        r1 = "geta8key_username";
        r0 = r0.getStringExtra(r1);
        r1 = r14.getIntent();
        r2 = "k_username";
        r1.putExtra(r2, r0);
        r0 = r14.getIntent();
        r1 = "k_expose_url";
        r2 = r14.mhH;
        r2 = r2.getUrl();
        r0.putExtra(r1, r2);
        r0 = r14.getIntent();
        r1 = "showShare";
        r0.putExtra(r1, r9);
        r0 = r14.mhH;
        r2 = r0.getUrl();
        r0 = 0;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r1 != 0) goto L_0x0049;
    L_0x0041:
        r0 = android.net.Uri.parse(r2);
        r0 = r0.getHost();
    L_0x0049:
        r1 = 0;
        r3 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r3 != 0) goto L_0x0148;
    L_0x0050:
        r3 = "mp.weixin.qq.com";
        r0 = r0.startsWith(r3);
        if (r0 == 0) goto L_0x0148;
    L_0x0059:
        r0 = "https://mp.weixin.qq.com/mp/infringement?url=%s#wechat_redirect";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ UnsupportedEncodingException -> 0x013a }
        r4 = 0;
        r5 = r14.mhH;	 Catch:{ UnsupportedEncodingException -> 0x013a }
        r5 = r5.getUrl();	 Catch:{ UnsupportedEncodingException -> 0x013a }
        r6 = "utf-8";
        r5 = com.tencent.mm.compatible.util.p.encode(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x013a }
        r3[r4] = r5;	 Catch:{ UnsupportedEncodingException -> 0x013a }
        r0 = java.lang.String.format(r0, r3);	 Catch:{ UnsupportedEncodingException -> 0x013a }
    L_0x0073:
        if (r0 == 0) goto L_0x0156;
    L_0x0075:
        r1 = r14.mhH;
        r1 = r1.getUrl();
        r3 = r14.Rp(r1);
        r1 = r14.gcP;
        r1 = r1.bVS();
        r1 = r1.cgi();
        r2 = "MicroMsg.WebViewUI";
        r4 = "doExpose enableReportPageEvent %s";
        r5 = new java.lang.Object[r10];
        r6 = java.lang.Boolean.valueOf(r1);
        r5[r9] = r6;
        com.tencent.mm.sdk.platformtools.x.d(r2, r4, r5);
        r2 = android.text.TextUtils.isEmpty(r3);
        if (r2 != 0) goto L_0x011d;
    L_0x00a0:
        if (r1 == 0) goto L_0x011d;
    L_0x00a2:
        r1 = r14.mhH;
        r1 = r1.getUrl();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x011d;
    L_0x00ae:
        r4 = com.tencent.mm.sdk.platformtools.bi.VE();
        r1 = "MicroMsg.WebViewUI";
        r2 = "report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d";
        r6 = 7;
        r6 = new java.lang.Object[r6];
        r7 = 13377; // 0x3441 float:1.8745E-41 double:6.609E-320;
        r7 = java.lang.Integer.valueOf(r7);
        r6[r9] = r7;
        r7 = java.lang.Long.valueOf(r4);
        r6[r10] = r7;
        r6[r12] = r3;
        r7 = r14.mhH;
        r7 = r7.getUrl();
        r6[r13] = r7;
        r7 = r14.bJK;
        r6[r11] = r7;
        r7 = 5;
        r8 = java.lang.Integer.valueOf(r11);
        r6[r7] = r8;
        r7 = 6;
        r8 = java.lang.Integer.valueOf(r10);
        r6[r7] = r8;
        com.tencent.mm.sdk.platformtools.x.d(r1, r2, r6);
        r1 = "";
        r2 = r14.mhH;	 Catch:{ UnsupportedEncodingException -> 0x0159 }
        r2 = r2.getUrl();	 Catch:{ UnsupportedEncodingException -> 0x0159 }
        r6 = "UTF-8";
        r1 = com.tencent.mm.compatible.util.p.encode(r2, r6);	 Catch:{ UnsupportedEncodingException -> 0x0159 }
    L_0x00f8:
        r2 = com.tencent.mm.plugin.report.service.h.mEJ;
        r6 = 13377; // 0x3441 float:1.8745E-41 double:6.609E-320;
        r7 = 6;
        r7 = new java.lang.Object[r7];
        r4 = java.lang.Long.valueOf(r4);
        r7[r9] = r4;
        r7[r10] = r3;
        r7[r12] = r1;
        r1 = r14.bJK;
        r7[r13] = r1;
        r1 = java.lang.Integer.valueOf(r11);
        r7[r11] = r1;
        r1 = 5;
        r3 = java.lang.Integer.valueOf(r10);
        r7[r1] = r3;
        r2.h(r6, r7);
    L_0x011d:
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r1 == 0) goto L_0x0134;
    L_0x0123:
        r0 = "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect";
        r1 = new java.lang.Object[r10];
        r2 = 34;
        r2 = java.lang.Integer.valueOf(r2);
        r1[r9] = r2;
        r0 = java.lang.String.format(r0, r1);
    L_0x0134:
        r1 = r14.mhH;
        r1.loadUrl(r0);
        return;
    L_0x013a:
        r0 = move-exception;
        r3 = "MicroMsg.WebViewUI";
        r0 = r0.getMessage();
        com.tencent.mm.sdk.platformtools.x.e(r3, r0);
        r0 = r2;
        goto L_0x0073;
    L_0x0148:
        r0 = r14.getIntent();
        r2 = "k_expose_current_url";
        r3 = r14.getCurrentURL();
        r0.putExtra(r2, r3);
    L_0x0156:
        r0 = r1;
        goto L_0x0075;
    L_0x0159:
        r2 = move-exception;
        r6 = "MicroMsg.WebViewUI";
        r7 = "";
        r8 = new java.lang.Object[r9];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r6, r2, r7, r8);
        goto L_0x00f8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.bWp():void");
    }

    private void AN(int i) {
        CharSequence Rp = Rp(this.pZB);
        if (TextUtils.isEmpty(this.pZB) || TextUtils.isEmpty(Rp)) {
            x.i("MicroMsg.WebViewUI", "stev appId is null or empty");
            return;
        }
        x.i("MicroMsg.WebViewUI", "stev appId %s", new Object[]{Rp});
        long VE = bi.VE();
        x.d("MicroMsg.WebViewUI", "stev report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13377), Long.valueOf(VE), Rp, this.pZB, this.bJK, Integer.valueOf(3), Integer.valueOf(i)});
        String str = "";
        try {
            str = com.tencent.mm.compatible.util.p.encode(this.pZB, "UTF-8");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[0]);
        }
        h.mEJ.h(13377, new Object[]{Long.valueOf(VE), Rp, str, this.bJK, Integer.valueOf(3), Integer.valueOf(i)});
    }

    public final void aTp() {
        Bundle bundle = new Bundle();
        bundle.putLong("msg_id", getIntent().getLongExtra("msg_id", Long.MIN_VALUE));
        bundle.putString("sns_local_id", getIntent().getStringExtra("sns_local_id"));
        bundle.putInt("news_svr_id", getIntent().getIntExtra("news_svr_id", 0));
        bundle.putString("news_svr_tweetid", getIntent().getStringExtra("news_svr_tweetid"));
        bundle.putInt("message_index", getIntent().getIntExtra("message_index", 0));
        bundle.putString("rawUrl", this.cbP);
        if (!bi.oW(this.cbP) && this.cbP.endsWith("#rd")) {
            String substring = this.cbP.substring(0, this.cbP.length() - 3);
            if (!(bi.oW(this.pZB) || this.pZB.startsWith(substring))) {
                bundle.putString("rawUrl", this.pZB);
                bundle.putLong("msg_id", Long.MIN_VALUE);
            }
        } else if (!(bi.oW(this.pZB) || this.pZB.startsWith(this.cbP))) {
            bundle.putString("rawUrl", this.pZB);
            bundle.putLong("msg_id", Long.MIN_VALUE);
        }
        Intent intent = getIntent();
        if (intent != null) {
            bundle.putString("preChatName", intent.getStringExtra("preChatName"));
            bundle.putInt("preMsgIndex", intent.getIntExtra("preMsgIndex", 0));
            bundle.putString("prePublishId", intent.getStringExtra("prePublishId"));
            bundle.putString("preUsername", intent.getStringExtra("preUsername"));
        }
        try {
            com.tencent.mm.plugin.webview.stub.b S = this.gcO.S(bundle);
            if (S.bVi()) {
                this.pNV.bf("sendAppMessage", false);
                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.pNV;
                if (dVar.qhq) {
                    Map hashMap = new HashMap();
                    hashMap.put("scene", "favorite");
                    dVar.qhk.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.a("menu:share:appmessage", hashMap, dVar.qhs, dVar.qht) + ")", null);
                    try {
                        dVar.gcO.H("scene", "favorite", dVar.pUz);
                    } catch (Exception e) {
                        x.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                    }
                } else {
                    x.e("MicroMsg.JsApiHandler", "onFavorite fail, not ready");
                }
                x.i("MicroMsg.WebViewUI", "on favorite simple url");
                return;
            }
            com.tencent.mm.plugin.fav.ui.c.a(S.getRet(), this, this.jKu);
            if (S.getRet() == 0) {
                AN(1);
            } else {
                AN(2);
            }
        } catch (Exception e2) {
            x.e("MicroMsg.WebViewUI", "edw, favoriteUrl fail, ex = " + e2.getMessage());
        }
    }

    private void kb(boolean z) {
        if (findViewById(R.h.web_navigator) != null) {
            if ((findViewById(R.h.web_navigator).getVisibility() == 0) != z) {
                findViewById(R.h.web_navigator).startAnimation(AnimationUtils.loadAnimation(this.mController.tml, z ? R.a.alpha_in : R.a.alpha_out));
            }
            if (z) {
                findViewById(R.h.web_navigator).setVisibility(0);
                this.pXD = (ImageButton) findViewById(R.h.web_back);
                ImageButton imageButton = this.pXD;
                boolean z2 = this.mhH != null && this.mhH.canGoBack();
                imageButton.setEnabled(z2);
                this.pXD.setOnClickListener(new 55(this));
                this.pXE = (ImageButton) findViewById(R.h.web_refresh);
                this.pXE.setOnClickListener(new 57(this));
                return;
            }
            findViewById(R.h.web_navigator).setVisibility(8);
        }
    }

    private void kc(boolean z) {
        if (this.pXE != null) {
            this.pXE.setEnabled(z);
        }
    }

    protected final void M(boolean z, boolean z2) {
        enableOptionMenu(z);
        x.d("MicroMsg.WebViewUI", "[cpan] set title enable:%b", new Object[]{Boolean.valueOf(z)});
        setProgressBarIndeterminateVisibility(false);
        if (z2) {
            this.pXB.finish();
        } else if (!this.pYQ && !this.pYS) {
            this.pXB.start();
        }
    }

    public void Ro(String str) {
        if (this.gcP.bVS().cgg()) {
            Bundle bundle = new Bundle();
            bundle.putInt("fromScene", 100);
            if (this.gcO.a(str, this.gcP.bVR().gu(7), bundle)) {
                x.i("MicroMsg.WebViewUI", "shouldOverride, built in url handled, url = " + str);
                return;
            }
            return;
        }
        x.w("MicroMsg.WebViewUI", "shouldOverride, allow inner open url, not allow");
    }

    public boolean Du(String str) {
        for (com.tencent.mm.plugin.webview.ui.tools.jsapi.b bVar : this.jKW) {
            if (a(bVar, str)) {
                x.i("MicroMsg.WebViewUI", "url handled, url = " + str);
                if (this.pZx.equals(str)) {
                    x.i("MicroMsg.WebViewUI", "url " + str + " has been handle");
                    return true;
                }
                x.i("MicroMsg.WebViewUI", "url handled, ret = " + bVar.Du(str) + ", url = " + str);
                return true;
            }
        }
        return false;
    }

    public final String Rp(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str) || this.gcO == null) {
            return str2;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("webview_binder_id", hashCode());
        bundle.putString("rawUrl", str);
        try {
            str2 = bi.oV(this.gcO.g(76, bundle).getString("appId"));
            x.i("MicroMsg.WebViewUI", "stev cachedAppId %s", new Object[]{str2});
            return str2;
        } catch (RemoteException e) {
            x.w("MicroMsg.WebViewUI", "get cachedAppId error ", new Object[]{e.getMessage()});
            return str2;
        }
    }

    public final void f(String str, long j, int i) {
        CharSequence Rp = Rp(this.pZB);
        if (this.fromScene != 0) {
            this.pZA = " ";
        }
        GeneralControlWrapper bVS = this.gcP.bVS();
        x.d("MicroMsg.WebViewUI", "webpageVisitInfoReport enableReportPageEvent %s", new Object[]{Boolean.valueOf(bVS != null ? bVS.cgi() : false)});
        if (this.grN > 0 && this.pZC > this.grN && j > this.pZC && !TextUtils.isEmpty(Rp) && r4) {
            long j2 = this.pZC - this.grN;
            long j3 = j - this.pZC;
            x.d("MicroMsg.WebViewUI", "report(%s), clickTimestamp : %d, appID : %s, usedTime : %s, stayTime : %s, networkType : %s, userAgent : %s, url : %s, sessionID : %s, targetAction : %s, targetUrl : %s,scene : %s, refererUrl : %s", new Object[]{Integer.valueOf(13376), Long.valueOf(this.grN), Rp, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(this.networkType), this.goF, this.pZB, this.bJK, Integer.valueOf(i), str, Integer.valueOf(this.fromScene), this.pZA});
            String str2 = "";
            String str3 = "";
            String str4 = "";
            String str5 = "";
            try {
                str2 = com.tencent.mm.compatible.util.p.encode(bi.oV(this.goF), "UTF-8");
                str3 = com.tencent.mm.compatible.util.p.encode(bi.oV(this.pZB), "UTF-8");
                str4 = com.tencent.mm.compatible.util.p.encode(bi.oV(str), "UTF-8");
                str5 = com.tencent.mm.compatible.util.p.encode(bi.oV(this.pZA), "UTF-8");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[0]);
            }
            h.mEJ.h(13376, new Object[]{Long.valueOf(this.grN), Rp, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(this.networkType), str2, str3, this.bJK, Integer.valueOf(i), str4, Integer.valueOf(this.fromScene), str5});
            this.fromScene = 0;
        }
        if (i == 1) {
            this.pZA = this.pZB;
            this.pZB = str;
            this.grN = j;
        }
    }

    /* renamed from: j */
    public final x a(String str, boolean z, int i) {
        if (this.pZc || this.pZd || isFinishing()) {
            return x.qaT;
        }
        if (this.pYL != null) {
            this.pYL.setVisibility(8);
        }
        if (this.gcP == null) {
            x.e("MicroMsg.WebViewUI", "startGetA8Key fail, after onDestroy");
            return x.qaT;
        } else if (this.pXS) {
            x.i("MicroMsg.WebViewUI", "edw startGetA8Key, nevergeta8key");
            this.gcP.b(str, null, null);
            return x.qaR;
        } else {
            Object obj = (this.gcO != null && this.pYR.contains(str) && Rm(str)) ? 1 : null;
            if ((this.gcP.has(str) || obj != null) && !z) {
                x.i("MicroMsg.WebViewUI", "edw startGetA8Key no need, wvPerm already has value, url = " + str);
                this.pYt = this.gcP.bVR().gu(24);
                return x.qaR;
            }
            int Di;
            String stringExtra = getIntent().getStringExtra("geta8key_username");
            int Rq = Rq(stringExtra);
            if (i == -1) {
                Di = this.pYo.Di(str);
            } else {
                Di = i;
            }
            x.i("MicroMsg.WebViewUI", "edw startGetA8Key, url = %s, scene = %d, username = %s, reason = %d, force = %b, functionid = %s, walletRegion = %d", new Object[]{str, Integer.valueOf(Rq), stringExtra, Integer.valueOf(Di), Boolean.valueOf(z), getIntent().getStringExtra("key_function_id"), Integer.valueOf(getIntent().getIntExtra("key_wallet_region", 0))});
            if (i != 5) {
                M(false, false);
            }
            x.i("MicroMsg.WebViewUI", "edw startGetA8Key, begin, set a default permission");
            this.pYR.add(str);
            this.gcP.b(str, null, null);
            this.pYt = this.gcP.bVR().gu(24);
            this.pYT = true;
            this.pYp.bWJ();
            Bundle bundle = new Bundle();
            bundle.putString("geta8key_data_req_url", str);
            bundle.putString("geta8key_data_username", stringExtra);
            bundle.putInt("geta8key_data_scene", Rq);
            bundle.putInt("geta8key_data_reason", Di);
            if (this.mhH.getIsX5Kernel()) {
                bundle.putInt("geta8key_data_flag", 1);
            } else {
                bundle.putInt("geta8key_data_flag", 0);
            }
            bundle.putString("geta8key_data_net_type", ak.bUq());
            bundle.putInt("geta8key_session_id", this.pYa);
            if (!bi.oW(getIntent().getStringExtra("k_share_url"))) {
                bundle.putString("k_share_url", getIntent().getStringExtra("k_share_url"));
                getIntent().putExtra("k_share_url", "");
            }
            bundle.putInt("key_wallet_region", r4);
            bundle.putString("key_function_id", r3);
            bundle.putInt("webview_binder_id", hashCode());
            bundle.putByteArray("k_a8key_cookie", this.pYc);
            bundle.putString("geta8key_data_appid", getIntent().getStringExtra("geta8key_open_webview_appid"));
            this.pYb = str;
            boolean z2 = false;
            try {
                z2 = this.gcO.s(233, bundle);
            } catch (Exception e) {
                x.w("MicroMsg.WebViewUI", "startGetA8Key, ex = " + e.getMessage());
            }
            x.i("MicroMsg.WebViewUI", "startGetA8Key, doScene ret = " + z2);
            ak.k bUs = this.pQY.bUs();
            int i2 = this.cfR;
            String str2 = this.bZM;
            bUs.cfR = i2;
            bUs.pSv = str2;
            if (bi.oW(str)) {
                x.e("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.startGetA8Key failed, url is null");
            } else if (!bUs.pSH.containsKey(str)) {
                bUs.pSH.put(str, Long.valueOf(bi.VF()));
            }
            h.mEJ.a(154, 11, 1, false);
            return x.qaS;
        }
    }

    private int Rq(String str) {
        int intExtra = getIntent().getIntExtra("geta8key_scene", 0);
        if (intExtra == 0) {
            if (str == null || str.length() <= 0) {
                intExtra = 0;
            } else if (this.gcO == null) {
                intExtra = 1;
            } else {
                try {
                    if (this.gcO.hO(str)) {
                        intExtra = 8;
                    } else if (this.gcO.hf(str)) {
                        intExtra = 7;
                        Bundle bundle = new Bundle();
                        bundle.putString("enterprise_biz_username", str);
                        try {
                            bundle = this.gcO.g(102, bundle);
                            if (bundle != null && bundle.getBoolean("is_enterprise_username")) {
                                intExtra = 51;
                            }
                        } catch (RemoteException e) {
                            x.e("MicroMsg.WebViewUI", "invoke the check enterprise failed");
                        }
                    } else {
                        intExtra = 1;
                    }
                } catch (Exception e2) {
                    x.e("MicroMsg.WebViewUI", "getScene fail, ex = " + e2.getMessage());
                    intExtra = 1;
                }
            }
        }
        x.i("MicroMsg.WebViewUI", "KGetA8KeyScene = %s", new Object[]{Integer.valueOf(intExtra)});
        return intExtra;
    }

    private boolean Rr(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.WebViewUI", "search contact err: null or nill url");
            return false;
        }
        AJ(106);
        Bundle bundle = new Bundle();
        bundle.putString("search_contact_data_url", str);
        bundle.putInt("webview_binder_id", hashCode());
        try {
            this.gcO.s(106, bundle);
        } catch (Exception e) {
            x.w("MicroMsg.WebViewUI", "startSearchContact, ex = " + e.getMessage());
        }
        return true;
    }

    private boolean Dn(String str) {
        x.i("MicroMsg.WebViewUI", "dealCustomScheme, url = " + str);
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            if (this.gcO.da(str)) {
                x.i("MicroMsg.WebViewUI", "dealCustomScheme, url is handled by QrCodeURLHelper, url = " + str);
                this.gcO.cw(str, hashCode());
                return true;
            }
        } catch (Exception e) {
            x.w("MicroMsg.WebViewUI", "dealCustomScheme, tryHandleEvents, ex = " + e.getMessage());
        }
        Uri parse = Uri.parse(str);
        if (!(parse == null || str.startsWith("weixin://") || str.startsWith("http"))) {
            String replace;
            Intent intent;
            if (str.startsWith("tel:")) {
                replace = str.replace("tel:", "");
                if (!bi.oW(replace)) {
                    try {
                        this.gcO.cy(replace, hashCode());
                    } catch (Exception e2) {
                        x.w("MicroMsg.WebViewUI", "showPhoneSpanDialog, ex = %s", new Object[]{e2.getMessage()});
                    }
                }
                return true;
            } else if (str.startsWith("sms:") || str.startsWith("smsto:")) {
                intent = new Intent("android.intent.action.SENDTO", parse);
                intent.addFlags(268435456);
                try {
                    startActivity(intent);
                } catch (Exception e22) {
                    x.e("MicroMsg.WebViewUI", "start sms app failed:[%s]", new Object[]{e22.getMessage()});
                }
                return true;
            } else {
                try {
                    if (this.gcP.bVS().cgf() || this.gcO == null || !this.gcO.aSn()) {
                        int intExtra = getIntent().getIntExtra("key_download_restrict", 0);
                        if (!bi.oW(getIntent().getStringExtra("key_function_id"))) {
                            h.mEJ.h(14596, new Object[]{r4, Integer.valueOf(intExtra), Integer.valueOf(1)});
                        }
                        if (intExtra == 1) {
                            x.e("MicroMsg.WebViewUI", "not allow launch app by custom scheme : %s", new Object[]{str});
                            return true;
                        }
                        x.i("MicroMsg.WebViewUI", "scheme launch interval ; %d", new Object[]{Long.valueOf(bi.VE() - this.pZC)});
                        if (bi.VE() - this.pZC <= 2) {
                            replace = getCurrentURL();
                            try {
                                replace = com.tencent.mm.compatible.util.p.encode(replace, "UTF-8");
                                str = com.tencent.mm.compatible.util.p.encode(str, "UTF-8");
                            } catch (Exception e3) {
                                x.i("MicroMsg.WebViewUI", "formate url failed");
                            }
                            h.mEJ.h(13983, new Object[]{Integer.valueOf(4), replace, str});
                        }
                        if (getIntent().getBooleanExtra("show_openapp_dialog", true)) {
                            return com.tencent.mm.bu.a.post(new 58(this, parse));
                        }
                        intent = new Intent("android.intent.action.VIEW", parse);
                        intent.addFlags(268435456);
                        if (bi.k(this, intent)) {
                            startActivity(intent);
                            return true;
                        }
                    }
                    x.e("MicroMsg.WebViewUI", "dealCustomScheme, not allow outer open url");
                    return true;
                } catch (Throwable e4) {
                    x.printErrStackTrace("MicroMsg.WebViewUI", e4, "", new Object[0]);
                }
            }
        }
        return false;
    }

    private void a(String str, String str2, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        if (!bi.oW(str2)) {
            this.gcP.b(str2, jsapiPermissionWrapper, generalControlWrapper);
            this.pYR.remove(str2);
            this.pYT = false;
            this.jkH = str2;
        }
        if (fs(str, str2)) {
            this.gcP.b(str, jsapiPermissionWrapper, generalControlWrapper);
            this.pYR.remove(str);
        } else if (this.gcO != null && !bi.oW(str) && Rm(str)) {
            this.gcP.b(str, jsapiPermissionWrapper, generalControlWrapper);
            this.pYR.remove(str);
        }
    }

    public void bWq() {
    }

    protected void b(com.tencent.mm.plugin.webview.stub.c cVar) {
        int i;
        int i2;
        int type;
        Bundle data;
        Exception e;
        x.i("MicroMsg.WebViewUI", "onSceneEnd, instance hashcode = " + hashCode());
        if (this.mhH == null) {
            x.w("MicroMsg.WebViewUI", "onSceneEnd, viewWV is null, do nothing");
            return;
        } else if (isFinishing() || this.gcP == null) {
            x.w("MicroMsg.WebViewUI", "onSceneEnd, isFinishing, do nothing");
            return;
        } else {
            i = -1;
            i2 = -1;
            String str = null;
            try {
                type = cVar.getType();
                try {
                    i = cVar.bVj();
                    i2 = cVar.bVk();
                    str = cVar.LG();
                    data = cVar.getData();
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                type = 0;
            }
            if (data == null) {
                data = new Bundle();
            }
            x.i("MicroMsg.WebViewUI", "get hash code = %d, self hash code = %d", new Object[]{Integer.valueOf(data.getInt("scene_end_listener_hash_code")), Integer.valueOf(hashCode())});
            x.i("MicroMsg.WebViewUI", "edw onSceneEnd, type = " + type + ", errCode = " + i2 + ", errType = " + i);
            if (data.getInt("scene_end_listener_hash_code") != hashCode()) {
                x.e("MicroMsg.WebViewUI", "hash code not equal");
            } else if (type == 233 || type == 131 || type == 106 || type == 673 || type == 666 || type == 1254 || type == 1373) {
                String str2;
                boolean z;
                switch (type) {
                    case 106:
                        finish();
                        return;
                    case 233:
                        this.pYp.bWK();
                        JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper(data.getByteArray("geta8key_result_jsapi_perm_control_bytes"));
                        GeneralControlWrapper generalControlWrapper = new GeneralControlWrapper(data.getInt("geta8key_result_general_ctrl_b1"));
                        this.jKX = data.getLong("geta8key_result_deep_link_bit_set", 0);
                        this.pYC = data.getString("geta8key_result_menu_wording");
                        int i3 = data.getInt("geta8key_result_reason");
                        x.i("MicroMsg.WebViewUI", "edw geta8key onSceneEnd, req reason = " + i3);
                        str2 = null;
                        switch (i3) {
                            case 0:
                            case 2:
                            case 8:
                            case 9:
                                if ((i != 0 || i2 != 0) && (i != 4 || i2 != -2005)) {
                                    g.pXv.AI(i);
                                    str = data.getString("geta8key_result_req_url");
                                    if (!(this.pYL == null || Rm(str))) {
                                        this.pYL.setVisibility(0);
                                        M(true, true);
                                    }
                                    this.pQY.bUx().pSp = false;
                                    this.pQY.bUs().bd(str, false);
                                    h.mEJ.a(154, 12, 1, false);
                                    int AA = a.AA(i3);
                                    if (-1 != AA) {
                                        h.mEJ.a(154, (long) AA, 1, false);
                                    }
                                    if (this.pXX) {
                                        finish();
                                        break;
                                    }
                                }
                                str2 = data.getString("geta8key_result_full_url");
                                a(data.getString("geta8key_result_req_url"), str2, jsapiPermissionWrapper, generalControlWrapper);
                                V(data);
                                this.pYt = jsapiPermissionWrapper.gu(24);
                                this.pQY.bUx().pSp = true;
                                this.pYc = data.getByteArray("geta8key_result_cookie");
                                x.d("MicroMsg.WebViewUI", "processGetA8Key, getA8Key = %s", new Object[]{bi.bE(this.pYc)});
                                break;
                                break;
                            case 1:
                            case 5:
                                if (i != 0 || i2 != 0) {
                                    if (i != 4 || i2 != -2005) {
                                        if (i == 0 || i2 != -3300) {
                                            h.mEJ.a(154, 12, 1, false);
                                            h.mEJ.a(154, (long) a.AA(i3), 1, false);
                                            M(true, true);
                                            break;
                                        }
                                        x.e("MicroMsg.WebViewUI", "onSceneEnd errType:%d, errCode:%d, disable iframe getA8Key", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                                        this.pYd = true;
                                        break;
                                    }
                                    this.mhH.stopLoading();
                                    str2 = data.getString("geta8key_result_full_url");
                                    a(data.getString("geta8key_result_req_url"), str2, jsapiPermissionWrapper, generalControlWrapper);
                                    V(data);
                                    this.pYc = data.getByteArray("geta8key_result_cookie");
                                    x.d("MicroMsg.WebViewUI", "processGetA8Key, getA8Key = %s", new Object[]{bi.bE(this.pYc)});
                                    break;
                                }
                                str2 = data.getString("geta8key_result_req_url");
                                this.gcP.b(str2, jsapiPermissionWrapper, generalControlWrapper);
                                this.pYR.remove(str2);
                                if (this.pYY) {
                                    M(true, true);
                                    this.pYY = false;
                                }
                                if (i3 != 5) {
                                    this.pYt = jsapiPermissionWrapper.gu(24);
                                }
                                this.pYc = data.getByteArray("geta8key_result_cookie");
                                x.d("MicroMsg.WebViewUI", "processGetA8Key, getA8Key = %s", new Object[]{bi.bE(this.pYc)});
                                break;
                                break;
                        }
                        N(this.gcP.Rl(str2).gu(34), this.gcP.Rl(str2).gu(75));
                        bWq();
                        return;
                    case 666:
                        r rVar = this.pYr;
                        rVar.qaO--;
                        if (rVar.qaO <= 0) {
                            rVar.pZJ.AK(666);
                        }
                        finish();
                        return;
                    case 673:
                        p pVar = this.pYq;
                        pVar.qaN--;
                        if (pVar.qaN <= 0) {
                            pVar.pZJ.AK(673);
                        }
                        if (i == 0 && i2 == 0) {
                            str2 = data != null ? data.getString("reading_mode_result_url") : null;
                            x.i("MicroMsg.WebViewUI", "[cpan] onsceneend url:%s", new Object[]{str2});
                            if (bi.oW(str2)) {
                                x.i("MicroMsg.WebViewUI", "[cpan] onsceneend failed");
                                return;
                            } else {
                                this.mhH.loadUrl(str2);
                                return;
                            }
                        }
                        x.i("MicroMsg.WebViewUI", "[cpan] onsceneend failed");
                        return;
                    case 1254:
                        z = i == 0 && i2 == 0;
                        com.tencent.mm.plugin.webview.stub.d dVar = this.gcO;
                        z.d dVar2 = this.pZE;
                        z.b bVar = this.pZF;
                        int hashCode = hashCode();
                        x.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd suc: %b", new Object[]{Boolean.valueOf(z)});
                        dVar2.aFs();
                        bVar.remove(1254);
                        if (!z) {
                            com.tencent.mm.ui.base.h.a(this, str, ad.getContext().getString(R.l.wechat_auth_failed), new 2(dVar2));
                            return;
                        } else if (data == null) {
                            x.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd_Tools resp null");
                            return;
                        } else {
                            z = data.getBoolean("is_recent_has_auth");
                            boolean z2 = data.getBoolean("is_silence_auth");
                            String Qj = z.c.Qj(data.getString("oauth_url"));
                            x.i("MicroMsg.OauthAuthorizeLogic", "parse appID:%s", new Object[]{Qj});
                            if (z || z2) {
                                String string = data.getString("redirect_url");
                                if (bi.oW(string)) {
                                    x.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd redirect null");
                                    return;
                                }
                                x.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd isRecentHasAuth:%b isSilenceAuth:%b redirectUrl:%s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), string});
                                com.tencent.mm.model.gdpr.c.a(this, com.tencent.mm.model.gdpr.a.dEd, Qj, new 3(dVar2, string));
                                return;
                            }
                            4 4 = new 4(this, Qj, dVar2, data, dVar, bVar, hashCode);
                            if ((this instanceof WebViewUI) && isFinishing()) {
                                x.i("MicroMsg.OauthAuthorizeLogic", "showWebAuthorizeDialog isFinishing");
                                return;
                            } else {
                                new com.tencent.mm.plugin.webview.ui.tools.widget.l(this).a(z.T((ArrayList) data.getSerializable("scope_list")), data.getString("appname"), data.getString("appicon_url"), getString(R.l.wechat_login_title), 4);
                                return;
                            }
                        }
                    case 1373:
                        z = i == 0 && i2 == 0;
                        z.d dVar3 = this.pZE;
                        z.b bVar2 = this.pZF;
                        x.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd suc: %b", new Object[]{Boolean.valueOf(z)});
                        bVar2.remove(1373);
                        if (!z) {
                            com.tencent.mm.ui.base.h.a(this, str, ad.getContext().getString(R.l.wechat_auth_failed), new 5(dVar3));
                            return;
                        } else if (data == null) {
                            x.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd resp null");
                            return;
                        } else {
                            str2 = data.getString("redirect_url");
                            if (bi.oW(str2)) {
                                x.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirect null");
                                return;
                            }
                            dVar3.Qk(str2);
                            x.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirectUrl: %s", new Object[]{str2});
                            return;
                        }
                    default:
                        return;
                }
            }
        }
        x.e("MicroMsg.WebViewUI", "onSceneEnd, ex = " + e.getMessage());
        data = null;
        if (data == null) {
            data = new Bundle();
        }
        x.i("MicroMsg.WebViewUI", "get hash code = %d, self hash code = %d", new Object[]{Integer.valueOf(data.getInt("scene_end_listener_hash_code")), Integer.valueOf(hashCode())});
        x.i("MicroMsg.WebViewUI", "edw onSceneEnd, type = " + type + ", errCode = " + i2 + ", errType = " + i);
        if (data.getInt("scene_end_listener_hash_code") != hashCode()) {
            x.e("MicroMsg.WebViewUI", "hash code not equal");
        } else if (type == 233 || type == 131 || type == 106 || type == 673 || type == 666 || type == 1254 || type == 1373) {
            String str22;
            boolean z3;
            switch (type) {
                case 106:
                    finish();
                    return;
                case 233:
                    this.pYp.bWK();
                    JsapiPermissionWrapper jsapiPermissionWrapper2 = new JsapiPermissionWrapper(data.getByteArray("geta8key_result_jsapi_perm_control_bytes"));
                    GeneralControlWrapper generalControlWrapper2 = new GeneralControlWrapper(data.getInt("geta8key_result_general_ctrl_b1"));
                    this.jKX = data.getLong("geta8key_result_deep_link_bit_set", 0);
                    this.pYC = data.getString("geta8key_result_menu_wording");
                    int i32 = data.getInt("geta8key_result_reason");
                    x.i("MicroMsg.WebViewUI", "edw geta8key onSceneEnd, req reason = " + i32);
                    str22 = null;
                    switch (i32) {
                        case 0:
                        case 2:
                        case 8:
                        case 9:
                            if ((i != 0 || i2 != 0) && (i != 4 || i2 != -2005)) {
                                g.pXv.AI(i);
                                str = data.getString("geta8key_result_req_url");
                                if (!(this.pYL == null || Rm(str))) {
                                    this.pYL.setVisibility(0);
                                    M(true, true);
                                }
                                this.pQY.bUx().pSp = false;
                                this.pQY.bUs().bd(str, false);
                                h.mEJ.a(154, 12, 1, false);
                                int AA2 = a.AA(i32);
                                if (-1 != AA2) {
                                    h.mEJ.a(154, (long) AA2, 1, false);
                                }
                                if (this.pXX) {
                                    finish();
                                    break;
                                }
                            }
                            str22 = data.getString("geta8key_result_full_url");
                            a(data.getString("geta8key_result_req_url"), str22, jsapiPermissionWrapper2, generalControlWrapper2);
                            V(data);
                            this.pYt = jsapiPermissionWrapper2.gu(24);
                            this.pQY.bUx().pSp = true;
                            this.pYc = data.getByteArray("geta8key_result_cookie");
                            x.d("MicroMsg.WebViewUI", "processGetA8Key, getA8Key = %s", new Object[]{bi.bE(this.pYc)});
                            break;
                            break;
                        case 1:
                        case 5:
                            if (i != 0 || i2 != 0) {
                                if (i != 4 || i2 != -2005) {
                                    if (i == 0 || i2 != -3300) {
                                        h.mEJ.a(154, 12, 1, false);
                                        h.mEJ.a(154, (long) a.AA(i32), 1, false);
                                        M(true, true);
                                        break;
                                    }
                                    x.e("MicroMsg.WebViewUI", "onSceneEnd errType:%d, errCode:%d, disable iframe getA8Key", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                                    this.pYd = true;
                                    break;
                                }
                                this.mhH.stopLoading();
                                str22 = data.getString("geta8key_result_full_url");
                                a(data.getString("geta8key_result_req_url"), str22, jsapiPermissionWrapper2, generalControlWrapper2);
                                V(data);
                                this.pYc = data.getByteArray("geta8key_result_cookie");
                                x.d("MicroMsg.WebViewUI", "processGetA8Key, getA8Key = %s", new Object[]{bi.bE(this.pYc)});
                                break;
                            }
                            str22 = data.getString("geta8key_result_req_url");
                            this.gcP.b(str22, jsapiPermissionWrapper2, generalControlWrapper2);
                            this.pYR.remove(str22);
                            if (this.pYY) {
                                M(true, true);
                                this.pYY = false;
                            }
                            if (i32 != 5) {
                                this.pYt = jsapiPermissionWrapper2.gu(24);
                            }
                            this.pYc = data.getByteArray("geta8key_result_cookie");
                            x.d("MicroMsg.WebViewUI", "processGetA8Key, getA8Key = %s", new Object[]{bi.bE(this.pYc)});
                            break;
                            break;
                    }
                    N(this.gcP.Rl(str22).gu(34), this.gcP.Rl(str22).gu(75));
                    bWq();
                    return;
                case 666:
                    r rVar2 = this.pYr;
                    rVar2.qaO--;
                    if (rVar2.qaO <= 0) {
                        rVar2.pZJ.AK(666);
                    }
                    finish();
                    return;
                case 673:
                    p pVar2 = this.pYq;
                    pVar2.qaN--;
                    if (pVar2.qaN <= 0) {
                        pVar2.pZJ.AK(673);
                    }
                    if (i == 0 && i2 == 0) {
                        str22 = data != null ? data.getString("reading_mode_result_url") : null;
                        x.i("MicroMsg.WebViewUI", "[cpan] onsceneend url:%s", new Object[]{str22});
                        if (bi.oW(str22)) {
                            x.i("MicroMsg.WebViewUI", "[cpan] onsceneend failed");
                            return;
                        } else {
                            this.mhH.loadUrl(str22);
                            return;
                        }
                    }
                    x.i("MicroMsg.WebViewUI", "[cpan] onsceneend failed");
                    return;
                case 1254:
                    z3 = i == 0 && i2 == 0;
                    com.tencent.mm.plugin.webview.stub.d dVar4 = this.gcO;
                    z.d dVar22 = this.pZE;
                    z.b bVar3 = this.pZF;
                    int hashCode2 = hashCode();
                    x.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd suc: %b", new Object[]{Boolean.valueOf(z3)});
                    dVar22.aFs();
                    bVar3.remove(1254);
                    if (!z3) {
                        com.tencent.mm.ui.base.h.a(this, str, ad.getContext().getString(R.l.wechat_auth_failed), new 2(dVar22));
                        return;
                    } else if (data == null) {
                        x.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd_Tools resp null");
                        return;
                    } else {
                        z3 = data.getBoolean("is_recent_has_auth");
                        boolean z22 = data.getBoolean("is_silence_auth");
                        String Qj2 = z.c.Qj(data.getString("oauth_url"));
                        x.i("MicroMsg.OauthAuthorizeLogic", "parse appID:%s", new Object[]{Qj2});
                        if (z3 || z22) {
                            String string2 = data.getString("redirect_url");
                            if (bi.oW(string2)) {
                                x.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd redirect null");
                                return;
                            }
                            x.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd isRecentHasAuth:%b isSilenceAuth:%b redirectUrl:%s", new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z22), string2});
                            com.tencent.mm.model.gdpr.c.a(this, com.tencent.mm.model.gdpr.a.dEd, Qj2, new 3(dVar22, string2));
                            return;
                        }
                        4 42 = new 4(this, Qj2, dVar22, data, dVar4, bVar3, hashCode2);
                        if ((this instanceof WebViewUI) && isFinishing()) {
                            x.i("MicroMsg.OauthAuthorizeLogic", "showWebAuthorizeDialog isFinishing");
                            return;
                        } else {
                            new com.tencent.mm.plugin.webview.ui.tools.widget.l(this).a(z.T((ArrayList) data.getSerializable("scope_list")), data.getString("appname"), data.getString("appicon_url"), getString(R.l.wechat_login_title), 42);
                            return;
                        }
                    }
                case 1373:
                    z3 = i == 0 && i2 == 0;
                    z.d dVar32 = this.pZE;
                    z.b bVar22 = this.pZF;
                    x.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd suc: %b", new Object[]{Boolean.valueOf(z3)});
                    bVar22.remove(1373);
                    if (!z3) {
                        com.tencent.mm.ui.base.h.a(this, str, ad.getContext().getString(R.l.wechat_auth_failed), new 5(dVar32));
                        return;
                    } else if (data == null) {
                        x.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd resp null");
                        return;
                    } else {
                        str22 = data.getString("redirect_url");
                        if (bi.oW(str22)) {
                            x.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirect null");
                            return;
                        }
                        dVar32.Qk(str22);
                        x.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirectUrl: %s", new Object[]{str22});
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private void N(boolean z, boolean z2) {
        if (z) {
            setMMSubTitle(R.l.wechat_authenticate_safely);
            if (!this.pXV) {
                this.pXV = true;
            }
        } else if (z2) {
            setMMSubTitle(R.l.wechat_wx_safe_login);
        } else {
            setMMSubTitle(null);
        }
    }

    private void p(String str, Map<String, String> map) {
        String aG = bi.aG(getCurrentURL(), this.cbP);
        if (bi.oW(aG)) {
            x.e("MicroMsg.WebViewUI", "after getA8Key, currentURL is null or nil, wtf");
            this.mhH.loadUrl(str);
        } else if (this.pNV == null) {
            if (map.size() > 0) {
                this.mhH.loadUrl(str, map);
            } else {
                this.mhH.loadUrl(str);
            }
        } else if (!bi.oV(str).contains("#wechat_redirect")) {
            if (!fs(aG, str)) {
                String QF = com.tencent.mm.plugin.webview.modelcache.p.QF(aG);
                String QF2 = com.tencent.mm.plugin.webview.modelcache.p.QF(str);
                Object obj = (bi.oW(QF2) || bi.oW(QF) || !QF2.equals(QF) || this.gcO == null || !Rm(aG)) ? null : 1;
                if (obj == null) {
                    if (map.size() > 0) {
                        this.mhH.loadUrl(str, map);
                        return;
                    } else {
                        this.mhH.loadUrl(str);
                        return;
                    }
                }
            }
            this.pYZ.put(aG, str);
            this.pYU.put(aG, map);
            this.pNV.q(str, map);
        } else if (map.size() > 0) {
            this.mhH.loadUrl(str, map);
        } else {
            this.mhH.loadUrl(str);
        }
    }

    private boolean fs(String str, String str2) {
        if (bi.oW(str) || bi.oW(str2)) {
            return false;
        }
        if (com.tencent.mm.plugin.webview.a.pNp.matcher(str).matches() && com.tencent.mm.plugin.webview.a.pNp.matcher(str2).matches()) {
            String replaceFirst = str.replaceFirst("http://", "").replaceFirst("https://", "");
            int indexOf = replaceFirst.indexOf(35);
            if (indexOf > 0) {
                replaceFirst = replaceFirst.substring(0, indexOf);
            }
            if (str2.replaceFirst("http://", "").replaceFirst("https://", "").startsWith(replaceFirst) && this.gcO != null && Rm(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean V(Bundle bundle) {
        String str;
        x.d("MicroMsg.WebViewUI", "[cpan] process a8 key:%d", new Object[]{Long.valueOf(System.currentTimeMillis())});
        int i = bundle.getInt("geta8key_result_action_code");
        String string = bundle.getString("geta8key_result_title");
        String string2 = bundle.getString("geta8key_result_full_url");
        String string3 = bundle.getString("geta8key_result_content");
        String string4 = bundle.getString("geta8key_result_req_url");
        String[] stringArray = bundle.getStringArray("geta8key_result_http_header_key_list");
        String[] stringArray2 = bundle.getStringArray("geta8key_result_http_header_value_list");
        if (getIntent().getBooleanExtra("k_has_http_header", false) && (stringArray == null || stringArray.length == 0 || stringArray2 == null || stringArray2.length == 0)) {
            x.i("MicroMsg.WebViewUI", "use intent httpheader info");
            getIntent().putExtra("k_has_http_header", false);
            stringArray = getIntent().getStringArrayExtra("geta8key_result_http_header_key_list");
            stringArray2 = getIntent().getStringArrayExtra("geta8key_result_http_header_value_list");
            getIntent().putStringArrayListExtra("geta8key_result_http_header_key_list", null);
            getIntent().putStringArrayListExtra("geta8key_result_http_header_value_list", null);
        }
        x.i("MicroMsg.WebViewUI", "processGetA8Key, actionCode = %d, title = %s, fullUrl = %s, content = %s", new Object[]{Integer.valueOf(i), string, string2, string3});
        Map hashMap = new HashMap();
        if (stringArray != null && stringArray2 != null && stringArray.length > 0 && stringArray2.length > 0 && stringArray.length == stringArray2.length) {
            for (int i2 = 0; i2 < stringArray.length; i2++) {
                hashMap.put(stringArray[i2], stringArray2[i2]);
            }
        }
        this.pYV = hashMap;
        if (bi.oW(string2)) {
            str = string4;
        } else {
            str = string2;
        }
        ak.K(this.mhH.getIsX5Kernel(), bi.oV(str).startsWith("https://"));
        this.pQY.bUs().bd(string4, true);
        ak.e bUu = this.pQY.bUu();
        int i3 = this.cfR;
        String str2 = this.bZM;
        bUu.cfR = i3;
        bUu.pSv = str2;
        if (bi.oW(string2)) {
            x.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageStart failed, url is null");
        } else {
            bUu.gsE = string2;
            bUu.pSu = true;
            if (!bUu.pSs.containsKey(string2)) {
                bUu.pSs.put(string2, Long.valueOf(bi.VF()));
            }
            if (!bUu.pSt.containsKey(string2)) {
                bUu.pSt.put(string2, Long.valueOf(bi.VF()));
            }
        }
        switch (i) {
            case 1:
                x.i("MicroMsg.WebViewUI", "getA8key-text: " + string3);
                if (string3 == null || string3.length() == 0) {
                    x.e("MicroMsg.WebViewUI", "getA8key-text fail, invalid content");
                    return false;
                }
                this.mhH.getSettings().setJavaScriptEnabled(false);
                this.mhH.loadData(string3, "text/html", "utf-8");
                return true;
            case 2:
                x.i("MicroMsg.WebViewUI", "getA8key-webview: title = " + string + ", fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    x.e("MicroMsg.WebViewUI", "getA8key-webview fail, invalid fullUrl");
                    return false;
                }
                if (string != null && string.length() > 0) {
                    setMMTitle(string);
                }
                if (Rs(string2)) {
                    p(string2, hashMap);
                    return true;
                }
                x.f("MicroMsg.WebViewUI", "processGetA8Key qrcode, canLoadUrl fail, url = " + string2);
                aSN();
                return true;
            case 3:
                x.i("MicroMsg.WebViewUI", "getA8key-app: " + string2);
                if (string2 != null && string2.length() != 0) {
                    return Dn(string2);
                }
                x.e("MicroMsg.WebViewUI", "getA8key-app, fullUrl is null");
                return false;
            case 4:
                return Rr(string2);
            case 6:
                x.i("MicroMsg.WebViewUI", "getA8key-special_webview: fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    x.e("MicroMsg.WebViewUI", "getA8key-special_webview fail, invalid fullUrl");
                    return false;
                } else if (Rs(string2)) {
                    this.mhH.loadUrl(string2);
                    ka(false);
                    return true;
                } else {
                    x.f("MicroMsg.WebViewUI", "processGetA8Key special, canLoadUrl fail, url = " + string2);
                    aSN();
                    return true;
                }
            case 7:
                x.i("MicroMsg.WebViewUI", "getA8key-webview_no_notice: title = " + string + ", fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    x.e("MicroMsg.WebViewUI", "getA8key-webview_no_notice fail, invalid fullUrl");
                    return false;
                }
                if (string != null && string.length() > 0) {
                    setMMTitle(string);
                }
                if (Rs(string2)) {
                    p(string2, hashMap);
                    return true;
                }
                x.f("MicroMsg.WebViewUI", "processGetA8Key qrcode no notice, canLoadUrl fail, url = " + string2);
                aSN();
                return true;
            case 20:
                if (bi.oW(string2)) {
                    x.e("MicroMsg.WebViewUI", "doJumpEmotionDetailUrlScene err: null or nill url");
                } else {
                    r rVar = this.pYr;
                    if (rVar.qaO == 0) {
                        rVar.pZJ.AJ(666);
                    }
                    rVar.qaO++;
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("emoji_store_jump_url", string2);
                    bundle2.putInt("webview_binder_id", hashCode());
                    try {
                        this.gcO.s(666, bundle2);
                    } catch (Exception e) {
                        x.w("MicroMsg.WebViewUI", "startSearchContact, ex = " + e.getMessage());
                    }
                }
                return true;
            default:
                x.i("MicroMsg.WebViewUI", "qrcode-getA8key-not_catch: action code = " + i);
                return false;
        }
    }

    public boolean bWr() {
        return false;
    }

    public boolean bWs() {
        return false;
    }

    private int bWt() {
        float f = this.mController.tml.getSharedPreferences(ad.chY(), 0).getFloat("current_text_size_scale_key", 1.0f);
        if (f == 0.875f) {
            return 1;
        }
        if (f == 1.125f) {
            return 3;
        }
        if (f == 1.25f || f == 1.375f || f == 1.625f) {
            return 4;
        }
        return 2;
    }

    private void AO(int i) {
        if (i <= 0 || i > 4) {
            i = 2;
        }
        if (this.pNV != null) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.pNV;
            if (dVar.qhq) {
                Map hashMap = new HashMap();
                hashMap.put("fontSize", String.valueOf(i));
                dVar.qhk.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.a("menu:setfont", hashMap, dVar.qhs, dVar.qht) + ")", null);
            } else {
                x.e("MicroMsg.JsApiHandler", "onFontSizeChanged fail, not ready");
            }
        }
        FontChooserView fontChooserView = (FontChooserView) this.pXF.findViewById(R.h.font_chooser_view);
        if (fontChooserView != null) {
            fontChooserView.setSliderIndex(i - 1);
        }
    }

    private void AP(int i) {
        if (this.mhH != null && this.mhH.getSettings() != null) {
            x.i("MicroMsg.WebViewUI", "localSetFontSize, fontSize = " + i);
            switch (i) {
                case 1:
                    this.mhH.getSettings().a(com.tencent.xweb.n.a.vAy);
                    return;
                case 3:
                    this.mhH.getSettings().a(com.tencent.xweb.n.a.vAA);
                    return;
                case 4:
                    this.mhH.getSettings().a(com.tencent.xweb.n.a.vAB);
                    return;
                default:
                    this.mhH.getSettings().a(com.tencent.xweb.n.a.vAz);
                    return;
            }
        }
    }

    private final boolean Rs(String str) {
        if (af.exj) {
            x.w("MicroMsg.WebViewUI", "skipLoadUrlCheck");
            return true;
        } else if (bi.oW(str)) {
            return true;
        } else {
            if (this.pXO) {
                x.i("MicroMsg.WebViewUI", "albie: trust this url(%s)", new Object[]{str});
                return true;
            }
            String toLowerCase = str.toLowerCase();
            if (!toLowerCase.startsWith("file://")) {
                return true;
            }
            for (String fj : pRH) {
                if (s.fj(toLowerCase, fj)) {
                    return true;
                }
            }
            return false;
        }
    }

    @TargetApi(11)
    private void bWu() {
        if (com.tencent.mm.compatible.util.d.fS(11)) {
            x.i("MicroMsg.WebViewUI", "removeConfigJsInterface, api level too low");
        } else if (this.mhH == null || this.gcO == null) {
            x.i("MicroMsg.WebViewUI", "viewwv is null or invoker is null");
        } else {
            int i;
            try {
                this.mhH.removeJavascriptInterface("searchBoxJavaBridge_");
            } catch (Exception e) {
                x.e("MicroMsg.WebViewUI", "removeConfigJsInterface, ex = %s", new Object[]{e.getMessage()});
            }
            if (this.pZH == null) {
                try {
                    if (this.gcO.aSn()) {
                        this.pZH = this.gcO.bVp();
                    }
                } catch (Exception e2) {
                    x.e("MicroMsg.WebViewUI", "getRemoveJsInterfaceList, ex = %s", new Object[]{e2.getMessage()});
                }
            }
            String str = "MicroMsg.WebViewUI";
            String str2 = "removeConfigJsInterface, to remove list size = %d";
            Object[] objArr = new Object[1];
            if (this.pZH == null) {
                i = 0;
            } else {
                i = this.pZH.length;
            }
            objArr[0] = Integer.valueOf(i);
            x.i(str, str2, objArr);
            if (this.pZH != null && this.pZH.length != 0) {
                try {
                    for (String str3 : this.pZH) {
                        x.i("MicroMsg.WebViewUI", "removeConfigJsInterface, js interface name = %s", new Object[]{str3});
                        this.mhH.removeJavascriptInterface(str3);
                    }
                } catch (Exception e22) {
                    x.e("MicroMsg.WebViewUI", "removeConfigJsInterface, ex = %s", new Object[]{e22.getMessage()});
                }
            }
        }
    }

    public final boolean aST() {
        if (this.pYI != null) {
            boolean z;
            d dVar = this.pYI;
            if (bi.oW(dVar.qaF)) {
                z = false;
            } else {
                z = dVar.qaF.equals("true");
            }
            if (!(!z || bi.oW(this.pYI.bWI()) || bi.oW(this.pYI.aSD()) || bi.oW(this.pYI.aSE()))) {
                x.i("MicroMsg.WebViewUI", "use js api close window confirm info : %s, %s, %s", new Object[]{this.pYI.bWI(), this.pYI.aSD(), this.pYI.aSE()});
                View inflate = View.inflate(this.mController.tml, R.i.mm_alert_checkbox, null);
                CheckBox checkBox = (CheckBox) inflate.findViewById(R.h.mm_alert_dialog_cb);
                checkBox.setChecked(false);
                checkBox.setVisibility(8);
                TextView textView = (TextView) inflate.findViewById(R.h.mm_alert_dialog_info);
                textView.setText(r6);
                textView.setTextColor(getResources().getColor(R.e.normal_text_color));
                textView = (TextView) inflate.findViewById(R.h.mm_alert_dialog_cb_txt);
                textView.setTextColor(getResources().getColor(R.e.normal_text_color));
                textView.setVisibility(8);
                this.pYJ = com.tencent.mm.ui.base.h.a(this.mController.tml, true, "", inflate, r4, r5, new 62(this, checkBox), new 63(this));
                return true;
            }
        }
        return false;
    }

    private boolean bWv() {
        int intExtra = getIntent().getIntExtra("key_close_action", 0);
        Bundle bundleExtra = getIntent().getBundleExtra("key_close_data");
        x.i("MicroMsg.WebViewUI", "close action %s", new Object[]{Integer.valueOf(intExtra)});
        switch (intExtra) {
            case 1:
                if (bundleExtra != null) {
                    String string = bundleExtra.getString("close_dialog_title");
                    String string2 = bundleExtra.getString("close_dialog_msg");
                    String string3 = bundleExtra.getString("close_dialog_ok");
                    String string4 = bundleExtra.getString("close_dialog_cancel");
                    boolean z = bundleExtra.getBoolean("close_dialog_ok_close", true);
                    if (!bi.G(new String[]{string2, string3, string4})) {
                        if (z) {
                            com.tencent.mm.ui.base.h.a(this, string, string2, string3, string4, false, new 65(this), null);
                        } else {
                            com.tencent.mm.ui.base.h.a(this, string, string2, string3, string4, false, null, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    WebViewUI.this.pZc = true;
                                    g.pXv.close();
                                    WebViewUI.this.finish();
                                }
                            });
                        }
                        return true;
                    }
                }
                break;
            case 2:
                if (bundleExtra != null) {
                    String string5 = bundleExtra.getString("close_jump_url");
                    int i = bundleExtra.getInt("close_jump_url_request_code", 0);
                    if (!bi.oW(string5)) {
                        Intent intent = new Intent(this, WebViewUI.class);
                        intent.putExtra("rawUrl", string5);
                        intent.putExtra("showShare", false);
                        intent.putExtra("show_bottom", false);
                        intent.putExtra("needRedirect", false);
                        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.qWa);
                        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.qVX);
                        startActivityForResult(intent, i);
                        com.tencent.mm.ui.base.b.gG(this);
                        return true;
                    }
                }
                break;
        }
        return false;
    }

    public void bWw() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra("webview_invoke_launch_app_when_back", false);
        String stringExtra = intent.getStringExtra("KAppId");
        String stringExtra2 = intent.getStringExtra("webview_invoke_launch_app_ext_info_when_back");
        if (booleanExtra && stringExtra != null && stringExtra.length() > 0 && stringExtra2 != null && stringExtra2.length() > 0) {
            Parcelable bundle = new Bundle();
            bundle.putString("appId", stringExtra);
            bundle.putString("extInfo", stringExtra2);
            com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", bundle, u.class, null);
        }
        if (!bWv() && !aST()) {
            this.pZc = true;
            g.pXv.close();
            if (!this.pZs.AQ(20)) {
                finish();
            }
        }
    }

    public void gU(boolean z) {
    }

    public void j(int i, Bundle bundle) {
    }

    public boolean bWx() {
        return true;
    }

    public void t(int i, Bundle bundle) {
        x.i("MicroMsg.WebViewUI", "handleEmojiStoreAction");
    }

    protected static void bWy() {
    }

    public final void kd(boolean z) {
        String url = this.mhH.getUrl();
        if (z) {
            showOptionMenu(0, false);
            this.pYG.put(url, Boolean.valueOf(true));
            return;
        }
        showOptionMenu(0, true);
        if (this.pYG.containsKey(url)) {
            this.pYG.remove(url);
        }
    }

    public final boolean bWz() {
        if (this.pZI == -3) {
            return false;
        }
        showVKB();
        return true;
    }

    public final void YC() {
        super.YC();
        this.pZI = -2;
    }

    public final void showVKB() {
        super.showVKB();
        if (this.pZI == -3) {
            this.pZI = -2;
        } else {
            this.pZI = -3;
        }
    }

    public final void setBackBtn(OnMenuItemClickListener onMenuItemClickListener, int i) {
        super.setBackBtn(onMenuItemClickListener, i);
        if (com.tencent.mm.compatible.util.d.fR(21) && aUR()) {
            cqf();
        }
    }

    private boolean bWA() {
        x.i("MicroMsg.WebViewUI", "forceHideShare:%b showShareBtn:%b enableMinimize:%b", new Object[]{Boolean.valueOf(getIntent().getBooleanExtra("forceHideShare", false)), Boolean.valueOf(getIntent().getBooleanExtra("showShare", true)), Boolean.valueOf(bVQ())});
        if (!getIntent().getBooleanExtra("forceHideShare", false) && r3 && bVQ()) {
            return true;
        }
        return false;
    }

    public boolean bVQ() {
        boolean z;
        if (!getClass().equals(WebViewUI.class) || getIntent().getBooleanExtra("disable_minimize", false)) {
            z = false;
        } else {
            z = true;
        }
        x.i("MicroMsg.WebViewUI", "enableMinimize class:%s enable:%b", new Object[]{getClass(), Boolean.valueOf(z)});
        return z;
    }

    public void bWB() {
    }
}
