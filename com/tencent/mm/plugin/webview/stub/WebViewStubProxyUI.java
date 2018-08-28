package com.tencent.mm.plugin.webview.stub;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.pluginsdk.f.e;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.d.b;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

@a(7)
@b
public class WebViewStubProxyUI extends MMActivity {
    private al bAZ = new al(new 7(this), true);
    private int jgc = 0;
    private e pRY = null;
    private final e pUA = new 5(this);
    private OnDismissListener pUB = new 6(this);
    private al pUC = new al(new 8(this), true);
    public boolean pUx = false;
    private boolean pUy = false;
    private int pUz;

    static /* synthetic */ boolean QL(String str) {
        if (str == null) {
            return false;
        }
        String[] split = str.split(":");
        return split.length > 0 && split[0].equals("startMonitoringBeacons");
    }

    static /* synthetic */ int d(WebViewStubProxyUI webViewStubProxyUI) {
        int i = webViewStubProxyUI.jgc + 1;
        webViewStubProxyUI.jgc = i;
        return i;
    }

    static /* synthetic */ void e(WebViewStubProxyUI webViewStubProxyUI) {
        Intent intent = webViewStubProxyUI.getIntent();
        int intExtra = intent.getIntExtra("proxyui_action_code_key", 0);
        x.i("MicroMsg.WebViewStubProxyUI", "onCreate, dealAfterWindowTokenInited = " + intExtra);
        JsapiPermissionWrapper jsapiPermissionWrapper;
        switch (intExtra) {
            case 1:
                i iVar = new i();
                iVar.type = intent.getStringExtra("proxyui_type_key");
                iVar.qkl = intent.getStringExtra("proxyui_function_key");
                iVar.qkj = intent.getStringExtra("proxyui_callback_key");
                iVar.mcy = i.ac(intent.getExtras());
                jsapiPermissionWrapper = (JsapiPermissionWrapper) intent.getExtras().getParcelable("proxyui_perm_key");
                if (jsapiPermissionWrapper == null) {
                    jsapiPermissionWrapper = new JsapiPermissionWrapper(2);
                }
                g Bh = h.Bh(webViewStubProxyUI.pUz);
                Bh.km(false);
                Bh.a((Context) webViewStubProxyUI, webViewStubProxyUI.pUA, webViewStubProxyUI.pRY);
                if (!Bh.a(iVar, jsapiPermissionWrapper)) {
                    try {
                        webViewStubProxyUI.pUA.a(null, null, null, true);
                        return;
                    } catch (Exception e) {
                        x.w("MicroMsg.WebViewStubProxyUI", "onHandleEnd, ex = " + e.getMessage());
                        return;
                    }
                }
                return;
            case 4:
                if (((JsapiPermissionWrapper) intent.getExtras().getParcelable("proxyui_perm_key")) == null) {
                    jsapiPermissionWrapper = new JsapiPermissionWrapper(2);
                }
                h.Bh(webViewStubProxyUI.pUz).a((Context) webViewStubProxyUI, webViewStubProxyUI.pUA);
                if (!h.Bh(webViewStubProxyUI.pUz).RO(intent.getStringExtra("proxyui_username_key"))) {
                    x.w("MicroMsg.WebViewStubProxyUI", "doProfile fail, finish");
                    webViewStubProxyUI.finish();
                    return;
                }
                return;
            default:
                x.e("MicroMsg.WebViewStubProxyUI", "dealAfterWindowTokenInited unknown actionCode = " + intExtra);
                webViewStubProxyUI.finish();
                return;
        }
    }

    @TargetApi(21)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (d.fR(21)) {
            getWindow().setStatusBarColor(0);
        }
        WebViewStubCallbackWrapper webViewStubCallbackWrapper = (WebViewStubCallbackWrapper) getIntent().getParcelableExtra("webview_stub_callbacker_key");
        if (webViewStubCallbackWrapper != null) {
            this.pRY = webViewStubCallbackWrapper.pXx;
        }
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("proxyui_action_code_key", 0);
        this.pUz = intent.getIntExtra("webview_binder_id", 0);
        x.i("MicroMsg.WebViewStubProxyUI", "onCreate, actionCode = %d, binderID = %d", new Object[]{Integer.valueOf(intExtra), Integer.valueOf(this.pUz)});
        if ("startMonitoringBeacons".equals(intent.getStringExtra("proxyui_function_key"))) {
            this.pUx = true;
        }
        String stringExtra;
        switch (intExtra) {
            case 1:
                if (!this.pUy) {
                    this.bAZ.J(100, 100);
                }
                if (this.pUx) {
                    this.pUC.J(5000, 5000);
                    return;
                }
                return;
            case 2:
                final sk skVar = new sk();
                skVar.bJX = new Runnable() {
                    public final void run() {
                        if (skVar.cdj.cdk) {
                            if (WebViewStubProxyUI.this.pRY != null) {
                                try {
                                    WebViewStubProxyUI.this.pRY.c(1001, null);
                                } catch (RemoteException e) {
                                    x.w("MicroMsg.WebViewStubProxyUI", "dealUpdate fail, ex = " + e.getMessage());
                                }
                            }
                            WebViewStubProxyUI.this.finish();
                            e.a aVar = e.qBn;
                            if (aVar != null) {
                                aVar.bc(WebViewStubProxyUI.this);
                                return;
                            }
                            return;
                        }
                        WebViewStubProxyUI.this.finish();
                    }
                };
                skVar.cdi.context = this;
                skVar.cdi.type = intent.getIntExtra("update_type_key", 0);
                if (skVar.cdi.type <= 0) {
                    x.e("MicroMsg.WebViewStubProxyUI", "doUpdate fail, invalid type = " + skVar.cdi.type);
                    finish();
                    return;
                }
                com.tencent.mm.sdk.b.a.sFg.a(skVar, Looper.myLooper());
                return;
            case 3:
                Dialog a;
                au.HU();
                bl Hg = c.FZ().Hg("@t.qq.com");
                if (!q.Hm()) {
                    a = com.tencent.mm.ui.base.h.a(this, R.l.contact_info_medianote_sync_to_qqmail_alert_tip, R.l.app_tip, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.plugin.webview.a.a.ezn.h(new Intent(), WebViewStubProxyUI.this);
                        }
                    }, null);
                } else if (Hg == null || bi.oW(Hg.name)) {
                    a = com.tencent.mm.ui.base.h.i(this, R.l.settings_tweibo_notfind, R.l.app_tip);
                } else {
                    au.DF().a(new w(getIntent().getIntExtra(DownloadSettingTable$Columns.TYPE, 0), bi.oV(getIntent().getStringExtra("shortUrl"))), 0);
                    try {
                        this.pRY.As(0);
                        a = null;
                    } catch (Exception e) {
                        x.w("MicroMsg.WebViewStubProxyUI", "setTitlePbVisibility, ex = " + e.getMessage());
                        a = null;
                    }
                }
                if (a == null) {
                    finish();
                    return;
                } else {
                    a.setOnDismissListener(this.pUB);
                    return;
                }
            case 4:
                this.bAZ.J(100, 100);
                return;
            case 5:
                if (o.a.qyj != null) {
                    o.a.qyj.a(this, intent.getStringExtra("proxyui_handle_event_url"), this.pUB);
                    return;
                }
                return;
            case 6:
                int intExtra2 = getIntent().getIntExtra("proxyui_expired_errtype", 0);
                int intExtra3 = getIntent().getIntExtra("proxyui_expired_errcode", 0);
                if (intExtra2 == 0 && intExtra3 == 0) {
                    x.e("MicroMsg.WebViewStubProxyUI", "PROXY_AC_VALUE_ACCOUNT_EXPIRED, errType & errCode should not both be 0");
                    return;
                }
                com.tencent.mm.g.a.c cVar = new com.tencent.mm.g.a.c();
                cVar.bGb.bGc = this;
                cVar.bGb.errType = intExtra2;
                cVar.bGb.errCode = intExtra3;
                com.tencent.mm.sdk.b.a.sFg.m(cVar);
                return;
            case 8:
                stringExtra = getIntent().getStringExtra("proxyui_phone");
                if (bi.oW(stringExtra)) {
                    x.e("MicroMsg.WebViewStubProxyUI", "show phone span dialog, phone is empty");
                    finish();
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putInt("fromScene", 3);
                l.a(this, stringExtra, this.pUB, bundle2);
                return;
            case 9:
                intent = (Intent) getIntent().getExtras().getParcelable("proxyui_next_intent_key");
                intent.setFlags(603979776);
                Intent intent2 = new Intent();
                intent2.setClass(this, SimpleLoginUI.class);
                MMWizardActivity.b(this, intent2, intent);
                finish();
                return;
            case 10:
                stringExtra = getIntent().getStringExtra("KAppId");
                String stringExtra2 = getIntent().getStringExtra("shortcut_user_name");
                if (!bi.oW(stringExtra) && !bi.oW(stringExtra2)) {
                    getString(R.l.app_tip);
                    p a2 = com.tencent.mm.ui.base.h.a(this, getString(R.l.app_waiting), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            x.i("MicroMsg.WebViewStubProxyUI", "addshortcut, user cancel");
                            WebViewStubProxyUI.this.finish();
                        }
                    });
                    a2.show();
                    com.tencent.mm.plugin.base.model.d.a(ad.getContext(), stringExtra2, stringExtra, new 4(this, a2));
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected final int getForceOrientation() {
        return getIntent().getIntExtra("screen_orientation", -1);
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (!this.pUx) {
            this.pRY = null;
        }
        x.i("MicroMsg.WebViewStubProxyUI", "onDestroy proxyui");
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        switch (i) {
            case f$k.AppCompatTheme_listPreferredItemPaddingLeft /*72*/:
            case 113:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
                if (iArr[0] == 0) {
                    h.Bh(this.pUz).b(i, -1, null);
                    return;
                } else {
                    h.Bh(this.pUz).b(i, 0, null);
                    return;
                }
            default:
                return;
        }
    }
}
