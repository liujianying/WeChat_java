package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a$f;
import com.tencent.mm.plugin.account.a$g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.m;
import com.tencent.mm.plugin.account.friend.a.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.b;
import com.tencent.xweb.c;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
public class BindGoogleContactUI extends MMActivity implements e {
    private boolean dJO = false;
    private boolean eEU = false;
    String eEW;
    private ProgressDialog eEX;
    private int eEZ;
    private WebView eFe;
    private TextView eFf;
    private boolean eFg = false;
    private String eFh;
    String eFi;
    String eFj;
    private w eFk;
    private boolean eFl = false;

    protected final int getLayoutId() {
        return a$g.bindgooglecontact;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eEZ = getIntent().getIntExtra("enter_scene", 0);
        this.eFl = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.eEU = m.cl(this);
        this.eEW = (String) g.Ei().DT().get(208903, null);
        initView();
        if (this.eEU) {
            startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), 1005);
        } else {
            aL();
        }
    }

    private void aL() {
        if (this.eEU) {
            this.eFe.setVisibility(8);
            WI();
            startActivityForResult(new Intent("com.tencent.mm.gms.ACTION_CHOOSE_ACCOUNT"), 1003);
            return;
        }
        this.eFf.setVisibility(4);
        this.eFe.setVisibility(0);
        WF();
    }

    protected void onResume() {
        super.onResume();
        g.DF().a(487, this);
        this.eFg = ((Boolean) g.Ei().DT().get(208905, Boolean.valueOf(false))).booleanValue();
        if (this.eFg) {
            WH();
            this.eFg = false;
            g.Ei().DT().set(208905, Boolean.valueOf(false));
        }
    }

    protected void onPause() {
        super.onPause();
        g.DF().b(487, this);
    }

    protected final void initView() {
        setMMTitle(j.gcontact_authorize_title);
        setBackBtn(new 1(this));
        this.eFe = a.l(this, a$f.gcontact_webview);
        this.eFf = (TextView) findViewById(a$f.empty);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.GoogleContact.BindGoogleContactUI", "requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            switch (i) {
                case 1003:
                    x.i("MicroMsg.GoogleContact.BindGoogleContactUI", "errorCode:%d ", new Object[]{Integer.valueOf(intent.getIntExtra("error_code", -1))});
                    if (intent.getIntExtra("error_code", -1) == 0) {
                        this.eEW = intent.getStringExtra("account");
                        if (this.dJO) {
                            c();
                            return;
                        }
                        x.d("MicroMsg.GoogleContact.BindGoogleContactUI", "startAcitivtyForGetToken");
                        Intent intent2 = new Intent("com.tencent.mm.gms.ACTION_GET_TOKEN");
                        intent2.putExtra("gmail", this.eEW);
                        intent2.putExtra("scope", "oauth2:https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds");
                        startActivityForResult(intent2, 1004);
                        return;
                    }
                    c();
                    WG();
                    return;
                case 1004:
                    int intExtra = intent.getIntExtra("error_code", -1);
                    String stringExtra = intent.getStringExtra("error_msg");
                    x.i("MicroMsg.GoogleContact.BindGoogleContactUI", "errorCode:%d errorMsg:%s", new Object[]{Integer.valueOf(intExtra), stringExtra});
                    if (intExtra == 0) {
                        this.eFh = intent.getStringExtra("token");
                        iY(w.eKF);
                        return;
                    }
                    c();
                    WG();
                    return;
                case 1005:
                    this.eEU = intent.getBooleanExtra("gpservices", false);
                    aL();
                    return;
                default:
                    return;
            }
        } else if (i == 1005) {
            this.eEU = intent.getBooleanExtra("gpservices", false);
            aL();
        } else {
            c();
            WG();
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        String str2 = "MicroMsg.GoogleContact.BindGoogleContactUI";
        String str3 = "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        objArr[2] = str;
        x.i(str2, str3, objArr);
        c();
        if (i == 0 && i2 == 0) {
            if (this.eEU) {
                g.Ei().DT().set(208903, this.eEW);
                g.Ei().DT().set(208901, this.eFh);
            } else {
                g.Ei().DT().set(208903, this.eEW);
                g.Ei().DT().set(208902, this.eFi);
                g.Ei().DT().set(208904, this.eFj);
            }
            g.Ei().DT().lm(true);
            Intent intent = new Intent(this, GoogleFriendUI.class);
            intent.putExtra("enter_scene", this.eEZ);
            startActivity(intent);
            finish();
            if (this.eFl) {
                h.mEJ.h(11002, new Object[]{Integer.valueOf(6), Integer.valueOf(6)});
            }
        } else if (i2 == w.eKH) {
            com.tencent.mm.ui.base.h.a(this, getString(j.gcontact_msg_account_has_binded), "", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    BindGoogleContactUI.this.iY(w.eKG);
                }
            }, new 7(this));
        } else {
            WG();
        }
    }

    private void WF() {
        WI();
        this.eFe.getSettings().setJavaScriptEnabled(true);
        this.eFe.setWebViewClient(new 2(this));
        this.eFe.setWebChromeClient(new 3(this));
        x.i("MicroMsg.GoogleContactLogic", "getRequestCodeUrl:%s", new Object[]{"https://accounts.google.com/o/oauth2/auth?scope=https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds&redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=code&client_id=369820936870.apps.googleusercontent.com"});
        this.eFe.loadUrl("https://accounts.google.com/o/oauth2/auth?scope=https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds&redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=code&client_id=369820936870.apps.googleusercontent.com");
    }

    private void iY(int i) {
        this.eFk = new w(w.a.eKM, this.eEW, i);
        g.DF().a(this.eFk, 0);
        x.i("MicroMsg.GoogleContact.BindGoogleContactUI", "doScene mAppToken:%s, mWebToke:%s", new Object[]{this.eFh, this.eFi});
    }

    /* renamed from: Z */
    final void a(String str, int i) {
        this.eEW = str;
        iY(i);
    }

    final void WG() {
        CharSequence string;
        if (this.eFe != null) {
            this.eFe.setVisibility(4);
        }
        if (this.eFf != null) {
            this.eFf.setVisibility(0);
        }
        if (ao.isConnected(this)) {
            string = getString(j.gcontact_default_error_msg);
        } else {
            string = getString(j.gcontact_network_error_msg);
        }
        this.eFf.setText(string);
    }

    private void WH() {
        try {
            c.ij(this);
            b.cIi().removeAllCookie();
        } catch (Exception e) {
            x.d("Google Login", "Clear cookie failed");
        }
    }

    private void WI() {
        if (this.eEX == null || !this.eEX.isShowing()) {
            getString(j.app_tip);
            this.eEX = com.tencent.mm.ui.base.h.a(this, getString(j.app_waiting), true, new 8(this));
        }
    }

    /* renamed from: WJ */
    final void c() {
        if (this.eEX != null && this.eEX.isShowing()) {
            this.eEX.dismiss();
        }
    }
}
