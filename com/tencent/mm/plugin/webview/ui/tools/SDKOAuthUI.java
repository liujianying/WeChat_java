package com.tencent.mm.plugin.webview.ui.tools;

import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.gy;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.plugin.webview.model.u;
import com.tencent.mm.plugin.webview.model.v;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.bir;
import com.tencent.mm.protocal.c.bit;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.LinkedList;

public final class SDKOAuthUI extends MMActivity implements e {
    private p fUo;
    private String mAppId;
    private Req pWo;
    private al pWp;
    private a pWq;
    private boolean pWr;

    static /* synthetic */ void a(SDKOAuthUI sDKOAuthUI, String str, String str2, String str3, LinkedList linkedList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < linkedList.size(); i++) {
            stringBuilder.append((String) linkedList.get(i)).append(",");
        }
        x.i("MicroMsg.SdkOAuthUI", "doSDKOauthAuthorizeConfirm selectedScopes: %s", new Object[]{stringBuilder.toString()});
        if (sDKOAuthUI.pWp != null) {
            sDKOAuthUI.pWp.SO();
            sDKOAuthUI.pWp.J(3000, 3000);
        } else {
            sDKOAuthUI.pWp = new al(new 6(sDKOAuthUI), false);
            sDKOAuthUI.pWp.J(3000, 3000);
        }
        au.DF().a(new v(1, str, str2, str3, linkedList), 0);
    }

    static /* synthetic */ void b(SDKOAuthUI sDKOAuthUI, String str) {
        String Rj = Rj(sDKOAuthUI.mAppId);
        if (bi.oW(Rj)) {
            x.e("MicroMsg.SdkOAuthUI", "dealWithError pkg nil");
            return;
        }
        Resp resp = new Resp();
        resp.transaction = sDKOAuthUI.pWo.transaction;
        resp.errCode = -1;
        resp.errStr = str;
        resp.lang = sDKOAuthUI.bVN();
        resp.country = getCountry();
        sDKOAuthUI.a(Rj, resp);
    }

    public final void onCreate(Bundle bundle) {
        String str = null;
        super.onCreate(bundle);
        setMMTitle(getString(R.l.wechat_login_title));
        setMMSubTitle(getString(R.l.sdk_oauth_login_subtitle));
        setBackBtn(new 1(this));
        if (au.HX()) {
            this.pWr = false;
            Bundle extras = getIntent().getExtras();
            String string = extras.getString("_mmessage_content");
            if (bi.oW(string)) {
                x.e("MicroMsg.SdkOAuthUI", "init content is nil");
                return;
            }
            this.mAppId = Uri.parse(string).getQueryParameter("appid");
            if (bi.oW(this.mAppId)) {
                x.i("MicroMsg.SdkOAuthUI", "parseAppId try case not sensitive, content:%s", new Object[]{string});
                this.mAppId = Uri.parse(string.toLowerCase()).getQueryParameter("appid");
            }
            string = this.mAppId;
            f bl = g.bl(string, false);
            if (bl != null && bi.oW(bl.field_openId)) {
                x.i("MicroMsg.SdkOAuthUI", "checkGetAppSetting appId: %s ", new Object[]{string});
                gy gyVar = new gy();
                gyVar.bQi.appId = string;
                a.sFg.m(gyVar);
            }
            this.pWo = new Req(extras);
            string = this.mAppId;
            String str2 = this.pWo.scope;
            String str3 = this.pWo.state;
            String Rj = Rj(this.mAppId);
            x.i("MicroMsg.SdkOAuthUI", "doSDKOauthAuthorize appid: %s", new Object[]{string});
            bVL();
            if (!bi.oW(Rj)) {
                Signature[] bh = com.tencent.mm.pluginsdk.model.app.p.bh(this, Rj);
                if (bh == null || bh.length == 0) {
                    x.e("MicroMsg.SdkOAuthUI", "getSignature signatures failed");
                } else {
                    str = com.tencent.mm.a.g.u(bh[0].toByteArray());
                }
            }
            au.DF().a(new u(string, str2, str3, Rj, str), 0);
            return;
        }
        x.e("MicroMsg.SdkOAuthUI", "start, hasSetUin fail");
        Toast.makeText(this, R.l.account_not_login, 1).show();
    }

    protected final void onResume() {
        super.onResume();
        au.DF().a(1346, this);
        au.DF().a(1388, this);
    }

    protected final void onPause() {
        super.onPause();
        au.DF().b(1388, this);
        au.DF().b(1346, this);
    }

    protected final void onDestroy() {
        super.onDestroy();
        if (this.fUo != null) {
            this.fUo.dismiss();
        }
        if (this.pWp != null) {
            this.pWp.SO();
        }
    }

    protected final int getLayoutId() {
        return R.i.sdk_oauth;
    }

    public final void onSwipeBack() {
        super.onSwipeBack();
        bVK();
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        bVK();
        finish();
        return true;
    }

    private void Rh(String str) {
        String str2 = null;
        x.i("MicroMsg.SdkOAuthUI", "dealWithLoginCallback url : %s", new Object[]{str});
        String Rj = Rj(this.mAppId);
        if (bi.oW(Rj)) {
            x.e("MicroMsg.SdkOAuthUI", "dealWithLoginCallback pkg nil");
            return;
        }
        Uri uri;
        Resp resp = new Resp();
        resp.transaction = this.pWo.transaction;
        resp.lang = bVN();
        resp.country = getCountry();
        if (bi.oW(str)) {
            uri = null;
        } else {
            uri = Uri.parse(str);
        }
        if (uri != null) {
            str2 = uri.getQueryParameter("code");
            resp.state = uri.getQueryParameter(OpenSDKTool4Assistant.EXTRA_STATE);
            resp.errStr = uri.getQueryParameter("reason");
        }
        if (bi.oW(str2)) {
            resp.errCode = -1;
        } else if (str2.toLowerCase().equals("authdeny")) {
            resp.errCode = -4;
        } else {
            resp.errCode = 0;
            resp.code = str2;
        }
        resp.url = str;
        x.i("MicroMsg.SdkOAuthUI", "dealWithLoginCallback, pkg:%s code:%s errCode:%d state:%s", new Object[]{Rj, resp.code, Integer.valueOf(resp.errCode), resp.state});
        a(Rj, resp);
        finish();
    }

    private void bVK() {
        x.i("MicroMsg.SdkOAuthUI", "dealWithCancel");
        if (this.pWo != null) {
            LinkedList linkedList;
            String Rj = Rj(this.mAppId);
            String str = this.mAppId;
            String str2 = this.pWo.state;
            if (this.pWq == null) {
                linkedList = null;
            } else {
                linkedList = this.pWq.bVO();
            }
            au.DF().a(new v(2, str, str2, Rj, linkedList), 0);
            Resp resp = new Resp();
            resp.transaction = this.pWo.transaction;
            resp.errCode = -2;
            resp.lang = bVN();
            resp.country = getCountry();
            a(Rj, resp);
        }
    }

    private void a(String str, Resp resp) {
        if (this.pWr) {
            x.i("MicroMsg.SdkOAuthUI", "doCallback has callback");
        } else if (!bi.oW(str)) {
            this.pWr = true;
            Bundle bundle = new Bundle();
            resp.toBundle(bundle);
            com.tencent.mm.pluginsdk.model.app.p.ae(bundle);
            Args args = new Args();
            args.targetPkgName = str;
            args.bundle = bundle;
            MMessageActV2.send(this, args);
        }
    }

    private void Ri(String str) {
        h.a(this, str, getString(R.l.wechat_auth_failed), new 4(this, str));
    }

    private void bVL() {
        if (this.fUo == null || this.fUo.isShowing()) {
            this.fUo = h.a(this, getString(R.l.oauth_logining), true, new 5(this));
        } else {
            this.fUo.show();
        }
    }

    private void bVM() {
        if (this.fUo != null) {
            this.fUo.dismiss();
        }
    }

    private boolean AE(int i) {
        if (i == 1 || i == 2 || i == 7 || i == 8) {
            x.e("MicroMsg.SdkOAuthUI", "isNetworkAvailable false, errType = " + i);
            return false;
        } else if (ao.isConnected(this)) {
            return true;
        } else {
            x.e("MicroMsg.SdkOAuthUI", "isNetworkAvailable false, not connected");
            return false;
        }
    }

    private String bVN() {
        return w.d(getSharedPreferences(ad.chY(), 0));
    }

    private static String getCountry() {
        au.HU();
        return bi.aG((String) c.DT().get(274436, null), null);
    }

    private static String Rj(String str) {
        f bl = g.bl(str, false);
        if (bl != null) {
            return bl.field_packageName;
        }
        x.w("MicroMsg.SdkOAuthUI", "dealWithCancel getAppInfo null; appid: %s", new Object[]{str});
        return null;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar instanceof u) {
            x.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd errType:%d errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            bVM();
            if (i == 0 && i2 == 0) {
                bit bit = (bit) ((u) lVar).diG.dIE.dIL;
                if (bit.rZL || bit.rZM) {
                    x.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd direct login");
                    com.tencent.mm.model.gdpr.c.a(this, com.tencent.mm.model.gdpr.a.dEd, this.mAppId, new 2(this, bit));
                    return;
                }
                ImageView imageView = (ImageView) findViewById(R.h.app_icon_iv);
                TextView textView = (TextView) findViewById(R.h.app_name_tv);
                ListView listView = (ListView) findViewById(R.h.auth_content_list);
                Button button = (Button) findViewById(R.h.login_btn);
                com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
                aVar.dXN = R.k.native_oauth_default_head_img;
                o.Pj().a(bit.rZK, imageView, aVar.Pt());
                textView.setText(bit.dxK);
                this.pWq = new a(this, bit.rZJ);
                listView.setAdapter(this.pWq);
                button.setOnClickListener(new 3(this, bit));
                findViewById(R.h.root).setVisibility(0);
            } else if (AE(i)) {
                Ri(str);
            } else {
                Ri(getString(R.l.wechat_auth_network_failed));
            }
        } else if (lVar instanceof v) {
            x.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (this.pWp != null) {
                this.pWp.SO();
            }
            bVM();
            if (i == 0 && i2 == 0) {
                Rh(((bir) ((v) lVar).diG.dIE.dIL).rqU);
            } else if (AE(i)) {
                Ri(str);
            } else {
                Ri(getString(R.l.wechat_auth_network_failed));
            }
        }
    }
}
