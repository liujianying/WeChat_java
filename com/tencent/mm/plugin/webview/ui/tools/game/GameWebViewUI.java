package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.wepkg.a;
import com.tencent.mm.plugin.game.wepkg.utils.d;
import com.tencent.mm.plugin.webview.ui.tools.game.a.2;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton;
import com.tencent.mm.protocal.c.atl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.j;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameWebViewUI extends GameBaseWebViewUI {
    private static String qfZ = "wx_fullscreen";
    private Map<Integer, atl> jKi = new HashMap();
    private boolean jMc = false;
    private a qfN;
    private boolean qfY = false;
    private HashMap<String, String> qga = new HashMap();
    private Drawable qgb;
    private Drawable qgc;
    private String qgd = null;
    private String qge;
    private GameMenuImageButton qgf;
    private boolean qgg;
    protected boolean qgh = false;
    private boolean qgi = false;
    private boolean qgj = false;
    private boolean qgk = false;
    private BroadcastReceiver qgl = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent != null && "com.tencent.mm.ACTION_RELOAD".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("hashcode", 0);
                if (intExtra == GameWebViewUI.this.hashCode()) {
                    GameWebViewUI.this.qgk = true;
                    if (GameWebViewUI.this.qgj) {
                        GameWebViewUI.this.bXM();
                        return;
                    }
                    return;
                }
                a aVar = GameWebViewUI.this.qfD;
                if (intExtra == (aVar.dEn != null ? aVar.dEn.hashCode() : -1)) {
                    aVar = GameWebViewUI.this.qfD;
                    if (aVar.qfN == null || !aVar.qfN.DS(aVar.jIl)) {
                        x.i("MicroMsg.GameFloatWebView", "no use wepkg, dont reload");
                        return;
                    }
                    x.i("MicroMsg.GameFloatWebView", "float page, reload url:%s from net", new Object[]{aVar.jIl});
                    aVar.qfN.aVl();
                    if (aVar.dEn != null && aVar.dEn.getParent() != null && aVar.qfO != null && !bi.oW(aVar.jIl)) {
                        aVar.dEn.stopLoading();
                        aVar.qfO.RB(aVar.jIl);
                    }
                }
            }
        }
    };

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI$9 */
    static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] jKl = new int[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.values().length];

        static {
            try {
                jKl[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.qgu.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                jKl[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.qgv.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                jKl[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.qgw.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                jKl[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.qgx.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                jKl[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.qgy.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                jKl[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.qgz.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                jKl[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.qgA.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                jKl[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.qgB.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                jKl[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.qgt.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    private class c extends GameBaseWebViewUI.a {
        private c() {
            super(GameWebViewUI.this);
        }

        /* synthetic */ c(GameWebViewUI gameWebViewUI, byte b) {
            this();
        }

        public final void b(WebView webView, String str, Bitmap bitmap) {
            GameWebViewUI.this.qfN.kdL.b(webView, str, bitmap);
            super.b(webView, str, bitmap);
        }

        public final void a(WebView webView, String str) {
            GameWebViewUI.C(GameWebViewUI.this);
            GameWebViewUI.this.qfN.kdL.a(webView, str);
            super.a(webView, str);
        }

        public final void a(WebView webView, int i, String str, String str2) {
            GameWebViewUI.C(GameWebViewUI.this);
            super.a(webView, i, str, str2);
        }

        public final m c(WebView webView, String str) {
            m c = GameWebViewUI.this.qfN.kdL.c(webView, str);
            return c != null ? c : super.c(webView, str);
        }

        public final m a(WebView webView, l lVar) {
            m a = GameWebViewUI.this.qfN.kdL.a(webView, lVar);
            return a != null ? a : super.a(webView, lVar);
        }

        public final m a(WebView webView, l lVar, Bundle bundle) {
            m a = GameWebViewUI.this.qfN.kdL.a(webView, lVar, bundle);
            return a != null ? a : super.a(webView, lVar, bundle);
        }
    }

    static /* synthetic */ void C(GameWebViewUI gameWebViewUI) {
        if (gameWebViewUI.pXC != null) {
            gameWebViewUI.pXC.setVisibility(8);
        }
    }

    public void onCreate(Bundle bundle) {
        boolean az;
        super.onCreate(bundle);
        x.i("MicroMsg.Wepkg.GameWebViewUI", "GameWebViewUI oncreate");
        x.i("MicroMsg.Wepkg.GameWebViewUI", "rawUrl rid:%s, pkgId:%s", new Object[]{d.Ew(this.cbP), d.Eu(this.cbP)});
        Intent intent = getIntent();
        if (intent != null && intent.getBooleanExtra("disable_progress_bar", false)) {
            this.pXB.tuf = false;
            bXL();
        }
        this.mhH.setWebViewClient(new c(this, (byte) 0));
        if (this.mhH.getIsX5Kernel()) {
            this.mhH.setWebViewClientExtension(new a(this, (byte) 0));
        }
        this.qfN = new a(this, this.mhH);
        this.qfN.kdI = new 1(this);
        if ("game_center_h5_floatlayer".equals(bi.oV(getIntent().getStringExtra("KPublisherId")))) {
            az = this.qfN.az(this.cbP, true);
        } else {
            az = this.qfN.az(this.cbP, false);
        }
        if (az) {
            x.i("MicroMsg.Wepkg.GameWebViewUI", "current page use wepkg");
            this.qgi = true;
            bXL();
        }
        this.qfD = new a(this, this.pXH);
        this.qgf = new GameMenuImageButton(this.mController.tml);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.ACTION_RELOAD");
        registerReceiver(this.qgl, intentFilter, "com.tencent.mm.permission.MM_MESSAGE", null);
    }

    protected final synchronized j bWf() {
        if (this.pYl == null) {
            this.pYl = new b(this);
        }
        return this.pYl;
    }

    private com.tencent.mm.ui.base.l aTf() {
        try {
            List<atl> list = com.tencent.mm.plugin.webview.ui.tools.game.menu.a.qgo;
            new Bundle().putString("game_hv_menu_appid", this.qge);
            this.jKi.clear();
            for (atl atl : list) {
                this.jKi.put(Integer.valueOf(atl.rWO), atl);
            }
            return com.tencent.mm.plugin.webview.ui.tools.game.menu.c.c(this, list);
        } catch (Exception e) {
            x.e("MicroMsg.Wepkg.GameWebViewUI", "get cache hv game menu fail! exception:%s", new Object[]{e.getMessage()});
            return null;
        }
    }

    protected final void aTe() {
        if (this.qgf == null || !this.qgf.qgp) {
            super.aTe();
            return;
        }
        com.tencent.mm.plugin.webview.ui.tools.game.menu.d dVar = new com.tencent.mm.plugin.webview.ui.tools.game.menu.d(this.mController.tml);
        dVar.a(new 2(this));
        dVar.qgF = new 3(this);
        if (this.pXJ) {
            dVar.qgK = true;
            dVar.qgL = true;
        } else {
            dVar.qgK = false;
            dVar.qgL = false;
        }
        if (this.pXM == null || !this.pXM.isShown()) {
            YC();
            ah.i(new 5(this, dVar), 100);
            return;
        }
        this.pXM.hide();
        ah.i(new 4(this, dVar), 100);
    }

    protected final void cz(String str, int i) {
        super.cz(str, i);
    }

    protected final int bWd() {
        return super.bWd();
    }

    protected final void U(Bundle bundle) {
        super.U(bundle);
    }

    protected final void ant() {
        Bundle g;
        super.ant();
        this.qgg = true;
        try {
            boolean z;
            g = this.gcO.g(141, null);
            g.setClassLoader(GameSettingParams.class.getClassLoader());
            GameSettingParams gameSettingParams = (GameSettingParams) g.getParcelable("game_setting_params");
            if (!this.jMc && this.jVa == null && this.jUZ == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (!bi.oW(gameSettingParams.bQE)) {
                    try {
                        this.jUZ = Color.parseColor(gameSettingParams.bQE);
                    } catch (IllegalArgumentException e) {
                        x.e("MicroMsg.Wepkg.GameWebViewUI", "parse color: " + e.getMessage());
                    }
                }
                this.jVa = gameSettingParams.bQF;
                bWa();
                ka(true);
            }
        } catch (Exception e2) {
            x.e("MicroMsg.Wepkg.GameWebViewUI", e2.getMessage());
        }
        Intent intent = getIntent();
        if (intent != null && intent.getBooleanExtra("game_check_float", false)) {
            int intExtra = intent.getIntExtra("game_sourceScene", 0);
            this.qgd = intent.getStringExtra("game_transparent_float_url");
            if (bi.oW(this.qgd)) {
                intent = new Intent();
                intent.putExtra("game_check_float", true);
                intent.putExtra("game_sourceScene", intExtra);
                com.tencent.mm.bg.d.b(this, "game", ".ui.GameCenterUI", intent);
                return;
            }
            try {
                g = new Bundle();
                g.putInt("game_sourceScene", intExtra);
                if (this.gcO != null) {
                    this.gcO.g(91, g);
                }
                a aVar = this.qfD;
                String str = this.qgd;
                aVar.jIl = str;
                aVar.qfN.az(str, true);
                if (aVar.dEn != null && aVar.dEn.getParent() == null) {
                    aVar.CK.addView(aVar.dEn, new LayoutParams(-1, -1));
                }
                if (!(aVar.dEn == null || aVar.qfO == null)) {
                    aVar.dEn.post(new 2(aVar, str));
                }
                this.qgd = null;
            } catch (RemoteException e3) {
            }
        }
    }

    protected final void ka(boolean z) {
        super.ka(z);
        kd(false);
    }

    public final void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        if (this.qgg) {
            super.addIconOptionMenu(i, i2, onMenuItemClickListener);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onDestroy() {
        super.onDestroy();
        this.qfN.onDestroy();
        unregisterReceiver(this.qgl);
    }

    public void initView() {
        super.initView();
        this.qgb = new ColorDrawable(android.support.v4.content.a.g(this, R.e.actionbar_bg_color));
        this.qgc = new ColorDrawable(android.support.v4.content.a.g(this, R.e.actionbar_bg_color));
    }

    protected final void bWe() {
        super.bWe();
        this.qge = getIntent().getStringExtra("game_hv_menu_appid");
        if (this.pXJ && !bi.oW(this.qge)) {
            if (this.pXI != null) {
                this.pXI.setVisibility(8);
            }
            this.qgf.a(this.pXG, new 6(this));
        }
    }

    protected final boolean Rm(String str) {
        return this.qfN.DS(str);
    }

    protected final void Do(String str) {
        if (!this.qfN.aVm()) {
            super.Do(str);
        } else if (this.mhH != null) {
            this.mhH.loadUrl(str);
        }
    }

    protected final void ahy() {
        if (VERSION.SDK_INT <= 10) {
            super.ahy();
        } else if (this.screenOrientation == -1) {
            this.tlM = getSharedPreferences(ad.chY(), 4).getBoolean("settings_landscape_mode", false);
            if (this.tlM) {
                setRequestedOrientation(2);
            } else {
                setRequestedOrientation(1);
            }
        } else {
            setRequestedOrientation(this.screenOrientation);
        }
    }

    protected final void bWq() {
        this.qgj = true;
        if (this.qgk) {
            bXM();
        }
    }

    private void bXL() {
        if (this.pXC != null) {
            this.pXC.setVisibility(0);
        }
    }

    public boolean bVQ() {
        getIntent().putExtra("minimize_secene", 2);
        return true;
    }

    private void bXM() {
        this.qgj = false;
        this.qgk = false;
        if (this.qgi) {
            ah.i(new 8(this), 100);
        } else {
            x.i("MicroMsg.Wepkg.GameWebViewUI", "no use wepkg, dont reload");
        }
    }
}
