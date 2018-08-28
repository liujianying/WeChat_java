package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.bg.d;
import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.b;
import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.smtt.sdk.WebView;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;
import org.json.JSONObject;

public class ContactSocialInfoUI extends MMPreference {
    private String bWJ;
    private f gua;
    private ab ipd;
    private String lVA;
    private String lVB;
    private JSONObject lVC;
    private long lVl;
    private String lVm;
    private a lVu;
    private String lVv;
    private String lVw;
    private String lVx;
    private String lVy;
    private String lVz;

    public final int Ys() {
        return R.o.contact_social_infos;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bWJ = bi.oV(getIntent().getStringExtra("Contact_User"));
        au.HU();
        this.ipd = c.FR().Yg(this.bWJ);
        initView();
    }

    protected final void initView() {
        setMMTitle(R.l.contact_info_social_title);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ContactSocialInfoUI.this.finish();
                return true;
            }
        });
        this.gua = this.tCL;
        String stringExtra = getIntent().getStringExtra("Contact_Mobile_MD5");
        String stringExtra2 = getIntent().getStringExtra("Contact_full_Mobile_MD5");
        if (bi.oW(stringExtra) && bi.oW(stringExtra2)) {
            if (bi.oW(this.ipd.field_username)) {
                this.lVu = b.getAddrUploadStg().pp(this.bWJ);
            } else {
                this.lVu = b.getAddrUploadStg().pp(this.ipd.field_username);
            }
        } else if ((stringExtra != null && stringExtra.length() > 0) || (stringExtra2 != null && stringExtra2.length() > 0)) {
            this.lVu = b.getAddrUploadStg().pq(stringExtra);
            if (this.lVu == null || this.lVu.Xh() == null || this.lVu.Xh().length() <= 0) {
                this.lVu = b.getAddrUploadStg().pq(stringExtra2);
                if (!(this.lVu == null || this.lVu.Xh() == null)) {
                    this.lVu.Xh().length();
                }
            }
        }
        if (this.lVu == null || this.lVu.Xh() == null || this.lVu.Xh().length() <= 0) {
            x.e("MicroMsg.ContactSocialInfoUI", "error : this is not the mobile contact, MD5 = " + this.lVv);
        } else {
            this.lVw = bi.oV(this.lVu.Xj()) + " " + bi.oV(this.lVu.Xp()).replace(" ", "");
        }
        m("contact_info_social_mobile", this.lVw, true);
        au.HU();
        int f = bi.f((Integer) c.DT().get(9, null));
        this.lVl = getIntent().getLongExtra("Contact_Uin", 0);
        this.lVm = getIntent().getStringExtra("Contact_QQNick");
        if (!(this.lVl == 0 || f == 0)) {
            if (this.lVm == null || this.lVm.length() == 0) {
                ao bK = b.getQQListStg().bK(this.lVl);
                if (bK == null) {
                    bK = null;
                }
                if (bK != null) {
                    this.lVm = bK.getDisplayName();
                }
            }
            this.lVx = bi.oV(this.lVm);
            this.lVx += " " + new o(this.lVl).longValue();
        }
        m("contact_info_social_qq", this.lVx, true);
        stringExtra = g.AT().getValue("LinkedinPluginClose");
        boolean z = bi.oW(stringExtra) || Integer.valueOf(stringExtra).intValue() == 0;
        if (!z || bi.oW(this.ipd.csV)) {
            this.lVy = "";
        } else {
            this.lVy = this.ipd.csW;
        }
        m("contact_info_social_linkedin", this.lVy, true);
        m("contact_info_social_facebook", this.lVz, false);
        this.lVB = bi.aG(getIntent().getStringExtra("verify_gmail"), "");
        this.lVA = bi.aG(getIntent().getStringExtra("profileName"), bi.Xe(this.lVB));
        if (bi.oW(this.lVB) || bi.oW(this.lVA)) {
            m("contact_info_social_googlecontacts", "", false);
        } else {
            m("contact_info_social_googlecontacts", this.lVA + 10 + this.lVB, false);
        }
        if (q.GF().equals(this.ipd.field_username)) {
            au.HU();
            stringExtra = (String) c.DT().get(aa.a.sRy, null);
            x.i("MicroMsg.ContactSocialInfoUI", "in self social info page, weishop info:%s", new Object[]{stringExtra});
        } else {
            stringExtra = this.ipd.csY;
            x.i("MicroMsg.ContactSocialInfoUI", "weiShopInfo:%s", new Object[]{stringExtra});
        }
        if (!bi.oW(stringExtra)) {
            try {
                this.lVC = new JSONObject(stringExtra);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ContactSocialInfoUI", e, "", new Object[0]);
                this.lVC = null;
            }
        }
        if (this.lVC != null) {
            m("contact_info_social_weishop", this.lVC.optString("ShopName"), true);
        } else {
            m("contact_info_social_weishop", "", false);
        }
    }

    private void m(String str, String str2, boolean z) {
        if (bi.oW(str2) || bi.oW(str)) {
            this.gua.aaa(str);
            return;
        }
        KeyValuePreference keyValuePreference = (KeyValuePreference) this.gua.ZZ(str);
        if (keyValuePreference != null) {
            keyValuePreference.tCD = true;
            keyValuePreference.tCF = 5;
            if (z) {
                keyValuePreference.hIZ = getResources().getColor(R.e.link_color);
            }
            keyValuePreference.setSummary(str2);
            keyValuePreference.lO(false);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.mKey;
        x.i("MicroMsg.ContactSocialInfoUI", str + " item has been clicked!");
        if (str.equals("contact_info_social_mobile")) {
            if (!(this.lVu == null || this.ipd == null)) {
                au.HU();
                if (c.FR().Yc(this.lVu.getUsername())) {
                    String[] stringArray = (this.lVu == null || bi.oW(this.lVu.dHL)) ? getResources().getStringArray(R.c.profile_alert_short) : getResources().getStringArray(R.c.profile_alert_all);
                    if (com.tencent.mm.plugin.profile.a.ezo.vq()) {
                        List F = bi.F(stringArray);
                        F.add(getResources().getString(R.l.chatting_phone_download_wxpb));
                        stringArray = (String[]) F.toArray(new String[F.size()]);
                        h.mEJ.h(11621, new Object[]{Integer.valueOf(2), Integer.valueOf(3)});
                    }
                    com.tencent.mm.ui.base.h.a((Context) this, null, stringArray, null, new 2(this, stringArray));
                } else if (!(this.lVw == null || this.lVw.length() == 0)) {
                    int lastIndexOf = this.lVw.lastIndexOf(32) + 1;
                    if (lastIndexOf > 0) {
                        JD(this.lVw.substring(lastIndexOf));
                    }
                }
            }
        } else if (!str.equals("contact_info_social_qq")) {
            if (str.equals("contact_info_social_linkedin")) {
                str = this.ipd.csX;
                if (bi.oW(str)) {
                    x.e("MicroMsg.ContactSocialInfoUI", "this liurl is null!");
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("geta8key_username", q.GF());
                    d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                }
            } else if (!(str.equals("contact_info_social_facebook") || str.equals("contact_info_social_googlecontacts") || !str.equals("contact_info_social_weishop") || this.lVC == null)) {
                au.HU();
                if (c.DT().get(aa.a.sRZ, null) == null) {
                    com.tencent.mm.ui.base.h.a((Context) this, R.l.contact_info_social_weishop_jump_alert, R.l.app_tip, new 4(this), null);
                } else {
                    bno();
                }
            }
        }
        return false;
    }

    private boolean q(String str, Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return l.a(str, this.mController.tml, byteArrayOutputStream.toByteArray());
    }

    private void JD(String str) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(268435456);
        intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
        startActivity(intent);
    }

    private void bno() {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.lVC.optString("ShopUrl"));
        intent.putExtra("geta8key_username", q.GF());
        d.b(this.mController.tml, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }
}
