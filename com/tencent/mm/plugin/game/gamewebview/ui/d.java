package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.game.d.db;
import com.tencent.mm.plugin.game.gamewebview.d.a;
import com.tencent.mm.plugin.game.gamewebview.e.b;
import com.tencent.mm.plugin.game.gamewebview.ipc.CommonLogicTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameMMToClientEvent;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.ab;
import com.tencent.mm.plugin.webview.model.ak;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.plugin.webview.ui.tools.f;
import com.tencent.mm.plugin.webview.ui.tools.game.c;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.amu;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.y;
import com.tencent.xweb.WebView;
import com.tencent.xweb.j;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class d extends FrameLayout {
    private static final Pattern jJL = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    private static final Pattern jJM = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    private String cYO;
    private MMFalseProgressBar dEm;
    private LinearLayout gmr;
    boolean gnu = false;
    public int gnw;
    public String gny = "";
    j goJ;
    private View hZ;
    boolean ief = false;
    public GameWebViewUI jIJ;
    a jIS;
    public b jIT;
    e jIU;
    private WebViewKeyboardLinearLayout jIV;
    private FrameLayout jIW;
    f jIX;
    com.tencent.mm.plugin.game.gamewebview.jsapi.d jIY;
    public b jIZ;
    String jIl;
    private b.a jJA;
    private boolean jJB = true;
    private int jJC;
    private String jJD;
    private int jJE = 0;
    com.tencent.xweb.f jJF;
    private boolean jJG;
    private String jJH;
    c jJI = new 1(this);
    public final HashMap<String, String> jJJ = new HashMap();
    public final HashMap<String, com.tencent.mm.plugin.webview.ui.tools.jsapi.c.d> jJK = new HashMap();
    private boolean jJN = false;
    public WebViewInputFooter jJa;
    WebViewSearchContentInputFooter jJb;
    private FrameLayout jJc;
    private MovingImageButton jJd;
    ProgressBar jJe;
    private GameMenuImageButton jJf;
    private CustomViewCallback jJg;
    private ProgressBar jJh;
    e jJi;
    private long jJj = 0;
    private com.tencent.mm.plugin.webview.ui.tools.b jJk;
    com.tencent.mm.plugin.game.wepkg.a jJl;
    private com.tencent.mm.plugin.game.gamewebview.model.f jJm;
    private Set<String> jJn;
    private boolean jJo;
    private String jJp;
    private String jJq;
    final com.tencent.mm.plugin.webview.modeltools.c jJr = new com.tencent.mm.plugin.webview.modeltools.c();
    public int jJs;
    public boolean jJt;
    private String jJu;
    private boolean jJv = true;
    private boolean jJw = false;
    private Map<String, String> jJx = new HashMap();
    public h jJy;
    public boolean jJz;
    public ag mHandler;
    private int scene = 0;
    private Bundle sy;

    static /* synthetic */ boolean aSU() {
        CommonLogicTask commonLogicTask = new CommonLogicTask();
        commonLogicTask.type = 4;
        GameWebViewMainProcessService.b(commonLogicTask);
        return commonLogicTask.jfZ.getBoolean("allowDownloadFile", true);
    }

    static /* synthetic */ void d(d dVar, String str) {
        if (dVar.jJs != 0) {
            Map hashMap = new HashMap();
            hashMap.put("text", str);
            dVar.E(dVar.jJs, com.tencent.mm.plugin.game.gamewebview.a.d.f("showKeyboard:ok", hashMap));
        }
    }

    public d(b bVar) {
        super(bVar.getContext());
        x.i("MicroMsg.GameWebPageView", "onCreate");
        this.jIT = bVar;
        this.mHandler = new ag();
        this.jIJ = (GameWebViewUI) bVar.getContext();
        this.gmr = new LinearLayout(getContext());
        this.gmr.setLayoutParams(new LayoutParams(-1, -1));
        this.gmr.setOrientation(1);
        addView(this.gmr);
        this.jIU = new e(this.jIT);
        this.gmr.addView(this.jIU);
        View inflate = y.gq(getContext()).inflate(R.i.game_web_page, this, false);
        this.gmr.addView(inflate, new LayoutParams(-1, -1));
        this.jIV = (WebViewKeyboardLinearLayout) inflate.findViewById(R.h.game_webview_keyboard_ll);
        this.jIX = new f();
        this.jIX.da(inflate);
        this.jIY = new com.tencent.mm.plugin.game.gamewebview.jsapi.d(this);
        com.tencent.mm.plugin.game.gamewebview.jsapi.d dVar = this.jIY;
        u.a.eP(this.jIJ);
        this.jIZ = new b(this.jIJ, this);
        this.jIZ.addJavascriptInterface(dVar, "WXGameJsCore");
        this.jIZ.setWebViewClient(new 33(this));
        this.goJ = new 34(this);
        this.jIZ.setWebChromeClient(this.goJ);
        this.jIZ.setOnTouchListener(new 35(this));
        if (this.jIZ.getIsX5Kernel()) {
            this.jIZ.setWebViewCallbackClient(new f() {
                public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
                }
            });
            this.jIZ.setProxyWebViewClientExtension(new 3(this));
        }
        this.jIZ.setDownloadListener(new DownloadListener() {
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                int i = 1;
                x.i("MicroMsg.GameWebPageView", "onDownloadStart called, url = %s, mimeType = %s, userAgent = %s", new Object[]{str, str4, str2});
                if (d.this.jJi != null) {
                    JsapiPermissionWrapper Rl = d.this.jJi.Rl(d.this.getCurrentURL());
                    if (Rl != null) {
                        if (str4 != null) {
                            x.i("MicroMsg.GameWebPageView", "onDownloadStart configOpen:%s", new Object[]{Boolean.valueOf(d.aSU())});
                            CharSequence Dc = com.tencent.mm.plugin.game.gamewebview.a.d.Dc(str3);
                            int i2 = (Dc == null || !Pattern.matches("(?i).*\\.(doc|ppt|xls|docx|pptx|xlsx|wps|dps|et|txt|pdf)$", Dc)) ? 0 : 1;
                            boolean contains = com.tencent.mm.plugin.webview.ui.tools.jsapi.a.qgW.contains(str4.toLowerCase());
                            if (!r4 || (i2 == 0 && !contains)) {
                                i = 0;
                            }
                        } else {
                            i = 0;
                        }
                        if (i != 0 || Rl.gu(24)) {
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                            intent.addFlags(268435456);
                            try {
                                d.this.jIJ.startActivity(intent);
                                return;
                            } catch (Exception e) {
                                x.e("MicroMsg.GameWebPageView", "startActivity fail, e = " + e.getMessage());
                                return;
                            }
                        }
                        x.e("MicroMsg.GameWebPageView", "onDownloadStart permission fail");
                        return;
                    }
                }
                x.e("MicroMsg.GameWebPageView", "onDownloadStart fail, mWebViewPermission is null");
            }
        });
        this.jIX.b(this.jIZ);
        this.jIW = (FrameLayout) inflate.findViewById(R.h.container);
        this.jJa = (WebViewInputFooter) inflate.findViewById(R.h.webview_input_footer);
        this.jJa.hide();
        this.jJa.setOnTextSendListener(new WebViewInputFooter.c() {
            public final void Ds(String str) {
                d.d(d.this, str);
                if (d.this.jJa != null) {
                    d.this.jJa.hide();
                }
            }
        });
        this.jJa.setOnSmileyChosenListener(new WebViewInputFooter.a() {
            public final boolean wi(String str) {
                d dVar = d.this;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("smiley", str);
                    dVar.cW("onGetSmiley", jSONObject.toString());
                } catch (Exception e) {
                    x.e("MicroMsg.GameWebviewJsLoader", "onGetA8Key, e:" + e.getMessage());
                }
                return true;
            }
        });
        this.jJa.setOnSmileyPanelVisibilityChangedListener(new 8(this));
        this.jJb = (WebViewSearchContentInputFooter) inflate.findViewById(R.h.search_content_input_footer);
        this.jJb.setActionDelegate(new WebViewSearchContentInputFooter.a() {
            public final void aSZ() {
                d.this.jIZ.setPadding(d.this.jIZ.getPaddingLeft(), d.this.jIZ.getPaddingTop(), d.this.jIZ.getPaddingRight(), 0);
                d.this.jIZ.clearMatches();
                d.this.jJb.bYy();
            }

            public final void a(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
                if (webViewSearchContentInputFooter.getVisibility() == 0) {
                    b(webViewSearchContentInputFooter);
                }
            }

            public final void aTa() {
                h.mEJ.a(608, 5, 1, false);
                d.this.jIZ.findNext(false);
            }

            public final void aTb() {
                h.mEJ.a(608, 4, 1, false);
                d.this.jIZ.findNext(true);
            }

            public final void b(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
                d.this.jIZ.clearMatches();
                webViewSearchContentInputFooter.reset();
                d.this.jJb.q(0, 0, true);
                d.this.jJo = false;
                d.this.jIZ.findAllAsync(webViewSearchContentInputFooter.getSearchContent());
            }

            public final boolean c(int i, KeyEvent keyEvent) {
                if (i == 67 && keyEvent.getAction() == 0) {
                    h.mEJ.a(608, 6, 1, false);
                }
                return false;
            }

            public final void onShow() {
                d.this.jIZ.setPadding(d.this.jIZ.getPaddingLeft(), d.this.jIZ.getPaddingTop(), d.this.jIZ.getPaddingRight(), d.this.jJb.getHeight());
            }
        });
        this.jIZ.setFindListener(new 10(this));
        this.jJc = (FrameLayout) inflate.findViewById(R.h.refresh_mask);
        if (this.jJc != null) {
            this.jJc.setOnClickListener(new 31(this));
        }
        this.dEm = (MMFalseProgressBar) inflate.findViewById(R.h.web_falseprogress);
        this.jJd = (MovingImageButton) inflate.findViewById(R.h.full_screen_menu);
        this.jJd.setOnClickListener(new 32(this));
        this.jJe = (ProgressBar) inflate.findViewById(R.h.create_progress_bar);
        this.jIV.setOnkbdStateListener(new 11(this));
        com.tencent.mm.plugin.game.gamewebview.model.a.a(this);
        GameMMToClientEvent.qI(hashCode());
        this.jJi = new e(this.jIJ, this.jIZ);
        this.jJn = new HashSet();
        this.jJy = new h(this.jIJ, this.jIZ, this.jJi);
        this.jIS = new a(this);
    }

    private void getA8Key() {
        f(this.jIl, false, -1);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        x.d("MicroMsg.GameWebPageView", "onLayout, changed = %b, left = %d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i)});
        super.onLayout(z, i, i2, i3, i4);
    }

    public final void setBundle(Bundle bundle) {
        this.sy = bundle;
        this.jIY.jGx = aSM();
        this.cYO = this.sy.getString("geta8key_username");
        this.jJD = this.sy.getString("KPublisherId");
        this.scene = this.sy.getInt("geta8key_scene", 0);
        this.jJC = com.tencent.mm.plugin.game.gamewebview.a.d.am(this.scene, this.cYO);
        this.jJw = this.sy.getBoolean("neverGetA8Key", false);
        this.jJH = this.sy.getString("game_hv_menu_appid");
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z;
        if (i == 4) {
            try {
                if (this.hZ == null || this.jJg == null || this.goJ == null) {
                    z = false;
                } else {
                    this.goJ.onHideCustomView();
                    z = true;
                }
                if (z) {
                    return true;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.GameWebPageView", e, "onkeydown", new Object[0]);
                return true;
            }
        }
        if (i == 4) {
            if (this.jJa == null || !this.jJa.isShown()) {
                z = false;
            } else {
                this.jJa.hide();
                z = true;
            }
            if (z) {
                return true;
            }
        }
        if (i != 4 || !this.jIZ.canGoBack() || !this.jJB) {
            return false;
        }
        this.jJu = "";
        this.jIZ.goBack();
        return true;
    }

    private void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            this.mHandler.post(runnable);
        }
    }

    final void Dl(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("state", str);
            cW("activity:state_change", jSONObject.toString());
        } catch (Exception e) {
            x.e("MicroMsg.GameWebviewJsLoader", "onActivityStateChanged, e:" + e.getMessage());
        }
    }

    final void Dm(String str) {
        if (this.jIZ != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.jIZ, new Object[0]);
            } catch (NoSuchMethodException e) {
                x.e("MicroMsg.GameWebPageView", "No such method: " + str + ", " + e.toString());
            } catch (IllegalAccessException e2) {
                x.e("MicroMsg.GameWebPageView", "Illegal Access: " + str + ", " + e2.toString());
            } catch (InvocationTargetException e3) {
                x.e("MicroMsg.GameWebPageView", "Invocation Target Exception: " + str + ", " + e3.toString());
            } catch (Exception e4) {
                x.e("MicroMsg.GameWebPageView", "Exception : " + str + ", " + e4.toString());
            }
        }
    }

    public final void setFullScreen(boolean z) {
        x.d("MicroMsg.GameWebPageView", "setFullScreen, rawUrl = %s, fullscreen = %b, mHVGameAppId = %s", new Object[]{this.jIl, Boolean.valueOf(z), this.jJH});
        this.gnu = z;
        if (z) {
            setActionBarVisibility(8);
            if (bi.oW(this.jJH)) {
                this.jJd.setVisibility(0);
                return;
            }
            if (this.jJf == null) {
                this.jJf = new GameMenuImageButton(this.jIJ);
                this.jJf.a(this, new 30(this));
            }
            this.jJd.setVisibility(8);
            return;
        }
        setActionBarVisibility(0);
        this.jJd.setVisibility(8);
    }

    public final void setHandler(ag agVar) {
        this.mHandler = agVar;
    }

    final void aSL() {
        Uri parse = Uri.parse(this.jIl);
        if (parse == null) {
            x.e("MicroMsg.GameWebPageView", "uri is null");
            return;
        }
        if (parse.getScheme() == null) {
            this.jIl = "http://" + this.jIl;
        } else if (!parse.getScheme().startsWith("http")) {
            x.i("MicroMsg.GameWebPageView", "uri scheme not startwith http, scheme = " + parse.getScheme());
            if (ab.Ql(this.jIl)) {
                this.jIZ.loadUrl(this.jIl);
                return;
            }
            x.f("MicroMsg.GameWebPageView", "canLoadUrl fail, url = " + this.jIl);
            aSN();
            return;
        }
        if (this.jJw) {
            x.i("MicroMsg.GameWebPageView", "initView, no need to geta8key, loadUrl directly, neverGetA8Key = " + this.jJw);
            if (!ab.Ql(this.jIl)) {
                x.f("MicroMsg.GameWebPageView", "postBinded 2, canLoadUrl fail, url = " + this.jIl);
                aSN();
                return;
            } else if (aSO()) {
                aSP();
                Do(this.jIl);
                return;
            } else {
                this.jIZ.loadUrl(this.jIl);
                return;
            }
        }
        if (aSO()) {
            Do(this.jIl);
            this.jJp = this.jIl;
            aSP();
        }
        if (!(this.jIJ.isFinishing())) {
            x.i("MicroMsg.GameWebPageView", "not call onDestory, try to geta8key again");
            f(this.jIl, false, -1);
            x.i("MicroMsg.GameWebPageView", "before geta8key, rawUrl = " + this.jIl);
        }
    }

    private JSONObject aSM() {
        JSONObject jSONObject = new JSONObject();
        try {
            String string = this.sy.getString("geta8key_username");
            if (!bi.oW(this.sy.getString("srcUsername"))) {
                jSONObject.put("srcUsername", this.sy.getString("srcUsername"));
                jSONObject.put("srcDisplayname", this.sy.getString("srcDisplayname"));
            } else if (!bi.oW(string)) {
                jSONObject.put("srcUsername", string);
            }
            jSONObject.put("message_id", this.sy.getLong("message_id", 0));
            jSONObject.put("message_index", this.sy.getInt("message_index", 0));
            jSONObject.put("scene", com.tencent.mm.plugin.game.gamewebview.a.d.am(this.scene, string));
            jSONObject.put("pay_channel", this.sy.getInt("pay_channel", 0));
            jSONObject.put("stastic_scene", this.sy.getInt("stastic_scene", 0));
            jSONObject.put("from_scence", this.sy.getInt("from_scence", 0));
            if (!bi.oW(this.sy.getString("KTemplateId"))) {
                jSONObject.put("KTemplateId", this.sy.getString("KTemplateId"));
            }
        } catch (Exception e) {
            x.e("MicroMsg.GameWebPageView", e.getMessage());
        }
        return jSONObject;
    }

    public final void setActionBarVisibility(int i) {
        this.jIU.setVisibility(i);
    }

    private boolean Dn(String str) {
        x.i("MicroMsg.GameWebPageView", "dealCustomScheme, url = " + str);
        if (str == null || str.length() == 0) {
            return false;
        }
        Uri parse = Uri.parse(str);
        if (!(parse == null || str.startsWith("weixin://") || str.startsWith("http"))) {
            if (str.startsWith(com.tencent.smtt.sdk.WebView.SCHEME_TEL)) {
                return true;
            }
            Intent intent;
            if (str.startsWith("sms:") || str.startsWith("smsto:")) {
                intent = new Intent("android.intent.action.SENDTO", parse);
                intent.addFlags(268435456);
                try {
                    this.jIJ.startActivity(intent);
                    return true;
                } catch (Exception e) {
                    x.e("MicroMsg.GameWebPageView", "start sms app failed:[%s]", new Object[]{e.getMessage()});
                    return true;
                }
            } else if (this.jJi == null || !this.jJi.bVS().cgf()) {
                return true;
            } else {
                if (this.jIJ.getIntent().getBooleanExtra("show_openapp_dialog", true)) {
                    return com.tencent.mm.bu.a.post(new 5(this, parse));
                }
                intent = new Intent("android.intent.action.VIEW", parse);
                intent.addFlags(268435456);
                if (bi.k(this.jIJ, intent)) {
                    this.jIJ.startActivity(intent);
                    return true;
                }
            }
        }
        return false;
    }

    protected final void Do(String str) {
        Map hashMap = new HashMap(2);
        hashMap.put("Pragma", "no-cache");
        hashMap.put("Cache-Control", "no-cache");
        this.jIZ.loadUrl(str, hashMap);
    }

    public final void qM(int i) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.jJa.getLayoutParams();
        if (marginLayoutParams.bottomMargin != i) {
            marginLayoutParams.bottomMargin = i;
            this.jJa.setLayoutParams(marginLayoutParams);
        }
    }

    private void f(String str, boolean z, int i) {
        if (this.jIJ.isFinishing()) {
            x.e("MicroMsg.GameWebPageView", "activity is finished");
        } else if (this.jJi == null) {
            x.e("MicroMsg.GameWebPageView", "mWebViewPermission is null");
        } else if ((this.jJi.has(str) || this.jJn.contains(str)) && !z) {
            x.i("MicroMsg.GameWebPageView", "startGetA8Key no need, has url");
        } else {
            if (this.jJm == null) {
                this.jJm = new com.tencent.mm.plugin.game.gamewebview.model.f(this.jIl, new 14(this));
            }
            x.i("MicroMsg.GameWebPageView", "startGetA8Key, url = %s", new Object[]{str});
            this.jJn.add(str);
            a(str, null, null);
            this.jJt = true;
            this.jJu = str;
            com.tencent.mm.plugin.game.gamewebview.model.f fVar = this.jJm;
            String str2 = this.cYO;
            int i2 = this.jJC;
            int i3 = this.jIZ.getX5WebViewExtension() != null ? 1 : 0;
            String bUq = ak.bUq();
            int i4 = this.sy.getInt("geta8key_session_id", (int) System.currentTimeMillis());
            if (i == -1) {
                i = fVar.jIa.Di(str);
            }
            Bundle bundle = new Bundle();
            bundle.putString("geta8key_data_req_url", str);
            bundle.putString("geta8key_data_username", str2);
            bundle.putInt("geta8key_data_scene", i2);
            bundle.putInt("geta8key_data_reason", i);
            bundle.putInt("geta8key_data_flag", i3);
            bundle.putString("geta8key_data_net_type", bUq);
            bundle.putInt("geta8key_session_id", i4);
            XIPCInvoker.a("com.tencent.mm", bundle, com.tencent.mm.plugin.game.gamewebview.model.f.a.class, new f$1(fVar));
            x.d("MicroMsg.GameWebViewGetA8KeyHelp", "runCgi, url = %s, id = %d", new Object[]{str, Integer.valueOf(fVar.hashCode())});
            if (this.jJc != null) {
                this.jJc.setVisibility(8);
            }
            setTitleBtnEnable$25decb5(false);
            this.jIS.jIt = System.currentTimeMillis();
        }
    }

    private void a(String str, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        if (this.jJi != null) {
            this.jJi.b(str, jsapiPermissionWrapper, generalControlWrapper);
        }
    }

    private void a(String str, String str2, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        if (this.jJi == null) {
            x.e("MicroMsg.GameWebPageView", "mWebViewPermission is null");
            return;
        }
        if (!bi.oW(str2)) {
            a(str2, jsapiPermissionWrapper, generalControlWrapper);
            this.jJq = str2;
        }
        if (aSO()) {
            a(str, jsapiPermissionWrapper, generalControlWrapper);
        }
    }

    private void a(yp ypVar) {
        if (!this.jIJ.isFinishing() && this.jIZ != null) {
            Map hashMap = new HashMap();
            List<amu> list = ypVar.rEN;
            if (!bi.cX(list)) {
                for (amu amu : list) {
                    if (!(bi.oW(amu.riD) || bi.oW(amu.mEl))) {
                        hashMap.put(amu.riD, amu.mEl);
                    }
                }
            }
            com.tencent.mm.plugin.game.gamewebview.c.a.k(ypVar.rEC, list);
            String str = ypVar.bHD;
            int i = ypVar.qZk;
            String str2 = ypVar.rEC;
            switch (i) {
                case 6:
                    x.i("MicroMsg.GameWebPageView", "getA8key-special_webview: fullUrl = " + str2);
                    if (str2 == null || str2.length() == 0) {
                        x.e("MicroMsg.GameWebPageView", "getA8key-special_webview fail, invalid fullUrl");
                        return;
                    } else if (ab.Ql(str2)) {
                        this.jIZ.loadUrl(str2);
                        this.jIJ.showOptionMenu(false);
                        return;
                    } else {
                        x.f("MicroMsg.GameWebPageView", "processGetA8Key special, canLoadUrl fail, url = " + str2);
                        aSN();
                        return;
                    }
                case 7:
                    x.i("MicroMsg.GameWebPageView", "getA8key-webview_no_notice: title = " + str + ", fullUrl = " + str2);
                    if (str2 == null || str2.length() == 0) {
                        x.e("MicroMsg.GameWebPageView", "getA8key-webview_no_notice fail, invalid fullUrl");
                        return;
                    }
                    if (str != null && str.length() > 0) {
                        this.jIU.setTitleText(str);
                    }
                    if (ab.Ql(str2)) {
                        this.jJq = str2;
                        if (aSO()) {
                            this.mHandler.post(new 15(this, hashMap, str2));
                            return;
                        } else if (hashMap.size() > 0) {
                            this.jIZ.loadUrl(str2, hashMap);
                            return;
                        } else {
                            this.jIZ.loadUrl(str2);
                            return;
                        }
                    }
                    x.f("MicroMsg.GameWebPageView", "processGetA8Key qrcode no notice, canLoadUrl fail, url = " + str2);
                    aSN();
                    return;
                default:
                    return;
            }
        }
    }

    private void aSN() {
        x.d("MicroMsg.GameWebPageView", "forceQuit");
        if (this.jJv) {
            fr(false);
        }
    }

    private void setTitleBtnEnable$25decb5(boolean z) {
        this.jIJ.setProgressBarIndeterminateVisibility(false);
        if (z) {
            aSP();
        } else if (!aSO()) {
            aSQ();
        }
    }

    public final boolean aSO() {
        if (this.jJl != null) {
            return this.jJl.DS(this.jIl);
        }
        return false;
    }

    public final GameWebViewUI getPageActivity() {
        if (this.jIJ.isFinishing() || this.jIJ.tlP) {
            return null;
        }
        return this.jIJ;
    }

    public final String getShareUrl() {
        String currentURL = getCurrentURL();
        if (bi.oW(currentURL)) {
            return "";
        }
        String str = (String) this.jJx.get(currentURL);
        if (bi.oW(str)) {
            str = (String) this.jJx.get(Dq(currentURL));
        }
        return bi.oV(str);
    }

    public final String Dp(String str) {
        if (bi.oW(str)) {
            return "";
        }
        String str2 = (String) this.jJx.get(str);
        if (bi.oW(str2)) {
            str2 = (String) this.jJx.get(Dq(str));
        }
        return !bi.oW(str2) ? str2 : str;
    }

    public static String Dq(String str) {
        if (bi.oW(str)) {
            return str;
        }
        int indexOf = str.indexOf("#");
        return indexOf >= 0 ? str.substring(0, indexOf) : str;
    }

    public final b getWebView() {
        return this.jIZ;
    }

    public final e getActionBar() {
        return this.jIU;
    }

    public final void aSP() {
        this.dEm.finish();
        this.dEm.setVisibility(8);
    }

    public final void aSQ() {
        this.dEm.start();
        this.dEm.setVisibility(0);
    }

    public final void E(int i, String str) {
        if (i != -1) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                this.mHandler.post(new 16(this, i, str));
            } else if (this.jIZ != null) {
                this.jIZ.E(i, str);
            }
        }
    }

    public final void cW(String str, String str2) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.mHandler.post(new 17(this, str, str2));
        } else if (this.jIZ != null) {
            this.jIZ.cY(str, str2);
        }
    }

    public final void cX(String str, String str2) {
        this.jIY.invokeHandler(str, str2, -1, System.currentTimeMillis());
    }

    public final String getCurrentURL() {
        if (this.mHandler == null) {
            return this.jJp;
        }
        if (Thread.currentThread().getId() == this.mHandler.getLooper().getThread().getId()) {
            return this.jIZ == null ? "" : this.jIZ.getUrl();
        } else {
            return (String) new bd<String>("") {
                protected final /* synthetic */ Object run() {
                    return d.this.jIZ == null ? "" : d.this.jIZ.getUrl();
                }
            }.a(this.mHandler);
        }
    }

    public final String getRawUrl() {
        return bi.oV(this.jIl);
    }

    public final String getLoadUrl() {
        return this.jJp;
    }

    public final void setFullUrl(String str) {
        this.jJq = str;
    }

    public final String getFullUrl() {
        return this.jJq;
    }

    public final String getCacheAppId() {
        String currentURL = getCurrentURL();
        if (bi.oW(currentURL)) {
            return null;
        }
        return (String) this.jJJ.get(Dq(currentURL));
    }

    public final com.tencent.mm.plugin.webview.ui.tools.jsapi.c.d getPreVerifyExtInfo() {
        return (com.tencent.mm.plugin.webview.ui.tools.jsapi.c.d) this.jJK.get(getCurrentURL());
    }

    public final String getTitle() {
        if (Thread.currentThread().getId() == this.mHandler.getLooper().getThread().getId()) {
            return this.jIZ == null ? "" : this.jIZ.getTitle();
        } else {
            return (String) new 19(this, "").a(this.mHandler);
        }
    }

    public final void Dr(String str) {
        if (this.jIY != null) {
            this.jIY.jGy.add(str);
        }
    }

    public final void fq(boolean z) {
        if (!z) {
            this.jJb.hide();
        } else if (!this.jJb.isShown()) {
            this.jJb.reset();
            this.jJb.bYy();
            this.jJb.show();
        }
    }

    public final Bundle getPublishId() {
        Bundle bundle = new Bundle();
        bundle.putString("KPublisherId", bi.oV(this.sy.getString("KPublisherId")));
        int am = com.tencent.mm.plugin.game.gamewebview.a.d.am(this.scene, this.sy.getString("geta8key_username"));
        bundle.putString("preChatName", this.sy.getString("preChatName"));
        bundle.putInt("preMsgIndex", this.sy.getInt("preMsgIndex", 0));
        bundle.putString("prePublishId", this.sy.getString("prePublishId"));
        bundle.putString("preUsername", this.sy.getString("preUsername"));
        bundle.putInt("getA8KeyScene", am);
        bundle.putString("referUrl", this.jJp);
        return bundle;
    }

    public final boolean bs(String str, int i) {
        JsapiPermissionWrapper Rl = this.jJi.Rl(getCurrentURL());
        if (Rl == null) {
            return false;
        }
        switch (Rl.CB(i)) {
            case 1:
                return true;
            case 2:
                if (str.equals("preVerifyJSAPI")) {
                    return true;
                }
                return false;
            case 4:
                if (com.tencent.mm.plugin.game.gamewebview.e.a.bI(str, getCurrentURL())) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    public final boolean gu(int i) {
        if (this.jJi == null) {
            return false;
        }
        JsapiPermissionWrapper Rl = this.jJi.Rl(getCurrentURL());
        if (Rl != null) {
            return Rl.gu(i);
        }
        return false;
    }

    public final JsapiPermissionWrapper getJsapiPermissionWrapper() {
        return this.jJi != null ? this.jJi.Rl(getCurrentURL()) : null;
    }

    public final e getWebViewPermission() {
        return this.jJi;
    }

    public final long getDeepLinkPermission() {
        return this.jJj;
    }

    public final void setBounceBackground(String str) {
        runOnUiThread(new 26(this, str));
    }

    public final void aSR() {
        if (!this.jJN) {
            this.gnw = this.sy.getInt("customize_status_bar_color");
            if (this.gnw != 0) {
                this.gny = this.sy.getString("status_bar_style");
            } else {
                db dbVar;
                GameWebViewUI gameWebViewUI = this.jIJ;
                x.i("MicroMsg.GameWebViewUI", "getDefaultStatusBarStyle");
                if (gameWebViewUI.jKD != null) {
                    x.i("MicroMsg.GameWebViewUI", "color = %s, style = %s", new Object[]{gameWebViewUI.jKD.bQE, gameWebViewUI.jKD.bQF});
                    dbVar = new db();
                    dbVar.dxh = gameWebViewUI.jKD.bQE;
                    dbVar.jOk = gameWebViewUI.jKD.bQF;
                } else {
                    dbVar = null;
                }
                if (dbVar != null) {
                    this.gnw = com.tencent.mm.plugin.game.e.c.parseColor(dbVar.dxh);
                }
                if (this.gnw == 0) {
                    this.gnw = android.support.v4.content.a.g(this.jIJ, R.e.action_bar_color);
                } else {
                    this.gny = dbVar.jOk;
                }
            }
        }
        aSS();
        runOnUiThread(new 28(this));
    }

    public final void setStatusBarColor(int i) {
        this.jJN = true;
        this.gnw = i;
        aSS();
    }

    public final void aSS() {
        runOnUiThread(new Runnable() {
            public final void run() {
                com.tencent.mm.plugin.game.gamewebview.a.d.b(d.this.jIJ, d.this.gnw, d.this.gny);
            }
        });
    }

    public final int getGetA8KeyScene() {
        return this.jJC;
    }

    public final boolean aST() {
        if (this.jIU != null) {
            return this.jIU.aST();
        }
        return false;
    }

    public final void fr(boolean z) {
        runOnUiThread(new 29(this, z));
    }

    public final void setPageCallBack(b.a aVar) {
        this.jJA = aVar;
    }

    public final b getWebPage() {
        return this.jIT;
    }

    public final void setGamePageReportData(Bundle bundle) {
        this.jJI.qfW.ab(bundle);
    }
}
