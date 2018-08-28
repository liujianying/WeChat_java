package com.tencent.mm.plugin.base.stub;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX$Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.ac.a.a$a;
import com.tencent.mm.plugin.appbrand.n.c;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.c.bua;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.w;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class WXEntryActivity extends AutoLoginActivity implements e {
    private String appId;
    private String authority;
    private String content;
    private ProgressDialog eHw;
    private int hdG;
    private String rU;
    private Uri uri;

    public void onCreate(Bundle bundle) {
        s.b(getIntent(), "key_auto_login_wizard_exit", true);
        super.onCreate(bundle);
        setBackBtn(new 1(this));
    }

    private boolean B(Intent intent) {
        this.hdG = s.a(intent, "_mmessage_sdkVersion", 0);
        this.content = s.j(intent, "_mmessage_content");
        if (this.content == null) {
            return false;
        }
        this.uri = Uri.parse(this.content);
        this.authority = this.uri.getAuthority();
        try {
            this.appId = this.uri.getQueryParameter("appid");
            this.rU = s.j(intent, "_mmessage_appPackage");
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.WXEntryActivity", "init: %s", new Object[]{e.toString()});
            return false;
        }
    }

    protected final boolean A(Intent intent) {
        if (B(intent)) {
            if (!au.HX() || au.Dr()) {
                x.w("MicroMsg.WXEntryActivity", "preLogin not login, save the appid : %s", new Object[]{this.appId});
                p.Tc(this.appId);
            }
            if (!mW(this.hdG)) {
                x.e("MicroMsg.WXEntryActivity", "sdk version is not supported, sdkVersion = " + this.hdG);
                finish();
                return false;
            } else if (this.uri == null) {
                x.e("MicroMsg.WXEntryActivity", "check appid failed, null content");
                finish();
                return false;
            } else {
                x.i("MicroMsg.WXEntryActivity", "preLogin, appId = " + this.appId);
                if (ai.oW(this.appId)) {
                    x.e("MicroMsg.WXEntryActivity", "invalid appid, ignore");
                    finish();
                    return false;
                }
                x.i("MicroMsg.WXEntryActivity", "preLogin, pkg = " + this.rU);
                if (ai.oW(this.rU)) {
                    x.e("MicroMsg.WXEntryActivity", "unknown package, ignore");
                    finish();
                    return false;
                } else if (checkSumConsistent(s.k(intent, "_mmessage_checksum"), r(this.content, this.hdG, this.rU))) {
                    return true;
                } else {
                    x.e("MicroMsg.WXEntryActivity", "checksum fail");
                    finish();
                    return false;
                }
            }
        }
        x.e("MicroMsg.WXEntryActivity", "Init failed");
        finish();
        return false;
    }

    protected final void a(a aVar, Intent intent) {
        x.d("MicroMsg.WXEntryActivity", "postLogin, loginResult = " + aVar);
        B(intent);
        switch (4.hdM[aVar.ordinal()]) {
            case 1:
                if (getIntent() == null || getIntent().getExtras() == null) {
                    x.e("MicroMsg.WXEntryActivity", "checkCanShare fail, invalid intent/extras");
                    finish();
                    return;
                }
                x.i("MicroMsg.WXEntryActivity", "checkCanShare, cmd = %d", new Object[]{Integer.valueOf(s.h(getIntent().getExtras(), "_wxapi_command_type"))});
                if (s.h(getIntent().getExtras(), "_wxapi_command_type") == 1) {
                    x.i("MicroMsg.WXEntryActivity", "it is auth, just dealrequest");
                    h(null);
                    finish();
                    return;
                }
                SendMessageToWX$Req sendMessageToWX$Req = new SendMessageToWX$Req(getIntent().getExtras());
                WXMediaMessage wXMediaMessage = sendMessageToWX$Req.message;
                if (wXMediaMessage == null) {
                    x.e("MicroMsg.WXEntryActivity", "wxmsg is null, how could it be?, directly deal request");
                    h(null);
                    finish();
                    return;
                }
                String format;
                if (wXMediaMessage.getType() == 36) {
                    sendMessageToWX$Req.scene = 0;
                }
                int i = sendMessageToWX$Req.scene == 2 ? 3 : sendMessageToWX$Req.scene == 1 ? 2 : sendMessageToWX$Req.scene == 0 ? 1 : 0;
                if (wXMediaMessage.getType() == 1) {
                    WXTextObject wXTextObject = (WXTextObject) wXMediaMessage.mediaObject;
                    format = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s", new Object[]{this.appId, Integer.valueOf(i), wQ(wXTextObject.text), "", wXMediaMessage.getType()});
                } else if (wXMediaMessage.getType() == 5) {
                    WXWebpageObject wXWebpageObject = (WXWebpageObject) wXMediaMessage.mediaObject;
                    format = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s", new Object[]{this.appId, Integer.valueOf(i), wQ(wXMediaMessage.description), wQ(wXWebpageObject.webpageUrl), wXMediaMessage.getType()});
                } else if (wXMediaMessage.getType() == 36) {
                    ((c) g.l(c.class)).a(((WXMiniProgramObject) wXMediaMessage.mediaObject).userName, null);
                    format = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s&appbrandusername=%s&appbrandpath=%s", new Object[]{this.appId, Integer.valueOf(i), wQ(wXMediaMessage.description), wQ(r0.webpageUrl), wXMediaMessage.getType(), r0.userName, wQ(r0.path)});
                } else {
                    format = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s", new Object[]{this.appId, Integer.valueOf(i), wQ(wXMediaMessage.description), "", wXMediaMessage.getType()});
                }
                this.eHw = h.a(this.mController.tml, getString(R.l.app_waiting), true, new 2(this));
                au.DF().a(1200, this);
                au.DF().a(new aa(format, 1, new LinkedList()), 0);
                return;
            case 2:
                atD();
                x.e("MicroMsg.WXEntryActivity", "postLogin fail, loginResult = " + aVar);
                break;
            case 3:
                ReportUtil.a(this, ReportUtil.c(s.aq(getIntent()), -1));
                finish();
                x.e("MicroMsg.WXEntryActivity", "postLogin fail, loginResult = " + aVar);
                break;
            default:
                x.e("MicroMsg.WXEntryActivity", "postLogin, unknown login result = " + aVar);
                break;
        }
        finish();
    }

    private static String wQ(String str) {
        if (ai.oW(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str);
        } catch (Exception e) {
            x.e("MicroMsg.WXEntryActivity", "urlEncode fail, str = %s, ex = %s", new Object[]{str, e.getMessage()});
            return str;
        }
    }

    private boolean h(l lVar) {
        Intent intent = getIntent();
        x.i("MicroMsg.WXEntryActivity", "dealRequest, cmd = %d, authority = %s", new Object[]{Integer.valueOf(s.h(getIntent().getExtras(), "_wxapi_command_type")), this.authority});
        if (!"sendreq".equals(this.authority) && !"sendresp".equals(this.authority)) {
            x.e("MicroMsg.WXEntryActivity", "unknown authority, should never reached, authority=" + this.authority);
            return false;
        } else if (au.HX()) {
            f bl = com.tencent.mm.pluginsdk.model.app.g.bl(this.appId, true);
            if (bl == null) {
                x.w("MicroMsg.WXEntryActivity", "app not reg, do nothing");
                return false;
            } else if (p.c(this, bl, this.rU)) {
                SendMessageToWX$Req sendMessageToWX$Req = new SendMessageToWX$Req(intent.getExtras());
                if (sendMessageToWX$Req.scene == 2) {
                    Intent intent2 = new Intent();
                    intent2.addFlags(268435456).addFlags(67108864);
                    intent2.putExtras(intent.getExtras());
                    if (sendMessageToWX$Req.message != null && sendMessageToWX$Req.message.getType() == 5) {
                        x.d("MicroMsg.WXEntryActivity", "report(11954), appId : %s", new Object[]{bl.field_appId});
                        String ic = u.ic("app_" + bl.field_appId);
                        u.Hx().v(ic, true).p("prePublishId", "app_" + bl.field_appId);
                        intent2.putExtra("reportSessionId", ic);
                    }
                    d.b(this, "favorite", ".ui.FavOpenApiEntry", intent2);
                    return true;
                }
                if (!(lVar == null || sendMessageToWX$Req.message == null)) {
                    bua Rw = ((aa) lVar).Rw();
                    if (sendMessageToWX$Req.message.getType() == 7) {
                        if (!(Rw == null || Rw.sru == null || ai.oW(Rw.sru.url))) {
                            x.i("MicroMsg.WXEntryActivity", "change appextend to Webpage,url :%s", new Object[]{Rw.sru.url});
                            sendMessageToWX$Req.message.mediaObject = new WXWebpageObject(Rw.sru.url);
                            Bundle bundle = new Bundle();
                            sendMessageToWX$Req.toBundle(bundle);
                            intent.putExtras(bundle);
                        }
                    } else if (!(sendMessageToWX$Req.message.getType() != 38 || Rw == null || Rw.sru == null)) {
                        intent.putExtra("SendAppMessageWrapper_VideoTime", Rw.sru.slp);
                        intent.putExtra("SendAppMessageWrapper_ShouldCompressVideo", Rw.sru.slq);
                    }
                }
                startActivity(new Intent(this, UIEntryStub.class).addFlags(268435456).addFlags(67108864).putExtras(intent.getExtras()));
                return true;
            } else {
                x.e("MicroMsg.WXEntryActivity", "send fail, check app fail, force to get app info from server again : %s", new Object[]{this.appId});
                ao.bme().SU(this.appId);
                atE();
                String str = this.rU;
                Signature[] bh = p.bh(this, str);
                Object obj = "";
                if (bh != null && bh.length > 0) {
                    for (Signature toByteArray : bh) {
                        obj = obj + p.Tb(com.tencent.mm.a.g.u(toByteArray.toByteArray())) + "|";
                    }
                }
                if (obj.length() > 1) {
                    obj = obj.substring(0, obj.length() - 1);
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("raw_package_name", bi.aG(str, ""));
                    jSONObject.put("package_name", bi.aG(bl.field_packageName, ""));
                    jSONObject.put("raw_signature", obj);
                    jSONObject.put("signature", bi.aG(bl.field_signature, ""));
                    jSONObject.put("scene", r4);
                } catch (Exception e) {
                    x.i("MicroMsg.WXEntryActivity", "doIfAppInValid, jsonException = " + e.getMessage());
                }
                gt gtVar = new gt();
                gtVar.bPU.appId = bl.field_appId;
                gtVar.bPU.opType = 3;
                gtVar.bPU.bJv = jSONObject.toString();
                com.tencent.mm.sdk.b.a.sFg.m(gtVar);
                return false;
            }
        } else {
            x.w("MicroMsg.WXEntryActivity", "accHasReady not ready, do nothing");
            return false;
        }
    }

    protected final int getLayoutId() {
        return R.i.sdk_share_check;
    }

    private static boolean mW(int i) {
        return i >= 553713665;
    }

    private static byte[] r(String str, int i, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        return com.tencent.mm.a.g.u(stringBuffer.toString().substring(1, 9).getBytes()).getBytes();
    }

    private static boolean checkSumConsistent(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
            x.e("MicroMsg.WXEntryActivity", "checkSumConsistent fail, invalid arguments");
            return false;
        } else if (bArr.length != bArr2.length) {
            x.e("MicroMsg.WXEntryActivity", "checkSumConsistent fail, length is different");
            return false;
        } else {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.WXEntryActivity", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        au.DF().b(1200, this);
        if (this.eHw != null && this.eHw.isShowing()) {
            this.eHw.dismiss();
        }
        if (i == 0 && i2 == 0) {
            int i3;
            aa aaVar = (aa) lVar;
            if (aaVar.Rw() != null) {
                i3 = aaVar.Rw().version;
            } else {
                i3 = 0;
            }
            x.i("MicroMsg.WXEntryActivity", "server appversion = %d", new Object[]{Integer.valueOf(i3)});
            f bl = com.tencent.mm.pluginsdk.model.app.g.bl(this.appId, false);
            if (bl == null) {
                x.e("MicroMsg.WXEntryActivity", "null appinfo");
                a$a.bmm().Jp(this.appId);
            } else {
                x.i("MicroMsg.WXEntryActivity", "local appversion = %d", new Object[]{Integer.valueOf(bl.field_appVersion)});
                if (bl.field_appVersion < i3) {
                    a$a.bmm().Jp(this.appId);
                }
            }
            h(lVar);
            finish();
        } else if (w.a.a(this, i, i2, null, 4)) {
            x.i("MicroMsg.WXEntryActivity", "mm error processor process this errcode");
            finish();
        } else if (com.tencent.mm.kernel.a.Dr()) {
            x.w("MicroMsg.WXEntryActivity", "account is hold, do finish");
            finish();
        } else {
            findViewById(R.h.sdk_share_body).setVisibility(0);
            setMMTitle(R.l.share_to_wechat_spam);
            TextView textView = (TextView) findViewById(R.h.share_to_wecaht_spam_tips_text);
            if (!ai.oW(str)) {
                if (str.startsWith("autoauth_errmsg_")) {
                    str = str.substring(16);
                }
                if (str.startsWith("<e>")) {
                    Map z = bl.z(str, "e");
                    if (!(z == null || ai.oW((String) z.get(".e.Content")))) {
                        str = (String) z.get(".e.Content");
                    }
                }
                textView.setText(getString(R.l.share_to_wechat_spam_tips, new Object[]{str}));
            }
            Button button = (Button) findViewById(R.h.back_to_app);
            String q = com.tencent.mm.pluginsdk.model.app.g.q(this, this.appId);
            x.i("MicroMsg.WXEntryActivity", "appName = %s", new Object[]{q});
            if (ai.oW(q)) {
                button.setText(R.l.share_spam_back);
            } else {
                button.setText(getString(R.l.share_spam_back) + q);
            }
            button.setOnClickListener(new 3(this));
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0 || keyEvent.getKeyCode() != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        x.i("MicroMsg.WXEntryActivity", "user click back button");
        goBack();
        return true;
    }

    private void goBack() {
        View findViewById = findViewById(R.h.sdk_share_body);
        if (findViewById == null || findViewById.getVisibility() == 8) {
            atD();
        } else {
            atE();
        }
    }

    private void atD() {
        ReportUtil.a(this, ReportUtil.c(s.aq(getIntent()), -2));
        finish();
    }

    private void atE() {
        ReportUtil.a(this, ReportUtil.c(s.aq(getIntent()), -6));
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
        au.DF().b(1200, this);
    }
}
