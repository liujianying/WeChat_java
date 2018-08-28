package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.az.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.account.b;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a$k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.d;

abstract class NormalUserFooterPreference$a implements e {
    boolean isDeleteCancel = false;
    final /* synthetic */ NormalUserFooterPreference lXw;
    private d lXx = null;

    protected abstract void bnA();

    static /* synthetic */ void a(NormalUserFooterPreference$a normalUserFooterPreference$a) {
        s.i(NormalUserFooterPreference.a(normalUserFooterPreference$a.lXw));
        NormalUserFooterPreference.a(normalUserFooterPreference$a.lXw).Be();
        if (NormalUserFooterPreference.p(normalUserFooterPreference$a.lXw)) {
            NormalUserFooterPreference.q(normalUserFooterPreference$a.lXw).setVisibility(8);
            normalUserFooterPreference$a.bnA();
        }
    }

    static /* synthetic */ void b(NormalUserFooterPreference$a normalUserFooterPreference$a) {
        s.h(NormalUserFooterPreference.a(normalUserFooterPreference$a.lXw));
        NormalUserFooterPreference.a(normalUserFooterPreference$a.lXw).Bd();
        if (NormalUserFooterPreference.p(normalUserFooterPreference$a.lXw)) {
            NormalUserFooterPreference.q(normalUserFooterPreference$a.lXw).setVisibility(0);
            normalUserFooterPreference$a.bnA();
        }
    }

    static /* synthetic */ void c(NormalUserFooterPreference$a normalUserFooterPreference$a) {
        int i = 7;
        Intent intent = new Intent();
        switch (NormalUserFooterPreference.l(normalUserFooterPreference$a.lXw)) {
            case 1:
            case 2:
            case 3:
            case 12:
            case 13:
            case a$k.AppCompatTheme_toolbarStyle /*58*/:
            case 59:
            case a$k.AppCompatTheme_popupMenuStyle /*60*/:
                intent.putExtra("k_outside_expose_proof_item_list", a.v(45, NormalUserFooterPreference.a(normalUserFooterPreference$a.lXw).field_username));
                i = 45;
                break;
            case 9:
            case 14:
                i = 35;
                break;
            case 18:
                i = NormalUserFooterPreference.m(normalUserFooterPreference$a.lXw) ? 2 : 1;
                intent.putStringArrayListExtra("k_outside_expose_proof_item_list", a.nv(NormalUserFooterPreference.a(normalUserFooterPreference$a.lXw).field_username));
                break;
            case 22:
            case 23:
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
                i = NormalUserFooterPreference.m(normalUserFooterPreference$a.lXw) ? 4 : 3;
                intent.putStringArrayListExtra("k_outside_expose_proof_item_list", a.nw(NormalUserFooterPreference.a(normalUserFooterPreference$a.lXw).field_username));
                break;
            case 25:
                i = NormalUserFooterPreference.m(normalUserFooterPreference$a.lXw) ? 6 : 5;
                if (!NormalUserFooterPreference.m(normalUserFooterPreference$a.lXw)) {
                    intent.putExtra("k_outside_expose_proof_item_list", a.nx(!bi.oW(NormalUserFooterPreference.a(normalUserFooterPreference$a.lXw).taj) ? NormalUserFooterPreference.a(normalUserFooterPreference$a.lXw).taj : NormalUserFooterPreference.a(normalUserFooterPreference$a.lXw).field_username));
                    break;
                } else {
                    intent.putExtra("k_outside_expose_proof_item_list", a.v(i, NormalUserFooterPreference.a(normalUserFooterPreference$a.lXw).field_username));
                    break;
                }
            case a$k.AppCompatTheme_actionModeSplitBackground /*30*/:
                intent.putStringArrayListExtra("k_outside_expose_proof_item_list", a.v(7, NormalUserFooterPreference.a(normalUserFooterPreference$a.lXw).field_username));
                break;
            default:
                i = 999;
                break;
        }
        intent.putExtra("k_username", NormalUserFooterPreference.a(normalUserFooterPreference$a.lXw).field_username);
        intent.putExtra("showShare", false);
        intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(i)}));
        com.tencent.mm.bg.d.b(NormalUserFooterPreference.b(normalUserFooterPreference$a.lXw), "webview", ".ui.tools.WebViewUI", intent);
    }

    public NormalUserFooterPreference$a(NormalUserFooterPreference normalUserFooterPreference) {
        this.lXw = normalUserFooterPreference;
    }

    protected void FC() {
        bnA();
        bnC();
        NormalUserFooterPreference.f(this.lXw).setOnClickListener(new 12(this));
        NormalUserFooterPreference.g(this.lXw).setOnClickListener(new 13(this));
        NormalUserFooterPreference.h(this.lXw).setOnClickListener(new 14(this));
        NormalUserFooterPreference.i(this.lXw).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                NormalUserFooterPreference$a.c(NormalUserFooterPreference$a.this);
            }
        });
        NormalUserFooterPreference.j(this.lXw).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                NormalUserFooterPreference$a.c(NormalUserFooterPreference$a.this);
            }
        });
        NormalUserFooterPreference.k(this.lXw).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                NormalUserFooterPreference$a.c(NormalUserFooterPreference$a.this);
            }
        });
    }

    protected void onDetach() {
    }

    public void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.NormalUserFooterPreference", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " " + lVar.getType());
    }

    protected final void bnB() {
        NormalUserFooterPreference.b(this.lXw).addIconOptionMenu(0, R.g.mm_title_btn_menu, new 1(this));
    }

    protected final void z(boolean z, boolean z2) {
        if (!z || !z2) {
            NormalUserFooterPreference.b(this.lXw).addIconOptionMenu(0, R.g.mm_title_btn_menu, new 11(this, z, z2));
        }
    }

    protected void bnC() {
        if (NormalUserFooterPreference.d(this.lXw)) {
            NormalUserFooterPreference.b(this.lXw).showOptionMenu(false);
        } else if (!q.GF().equals(NormalUserFooterPreference.a(this.lXw).field_username)) {
            if (!com.tencent.mm.l.a.gd(NormalUserFooterPreference.a(this.lXw).field_type)) {
                z(false, false);
            } else if (!s.hH(NormalUserFooterPreference.a(this.lXw).field_username)) {
                bnB();
            }
        }
    }

    final void bnD() {
        this.lXx = new d(NormalUserFooterPreference.b(this.lXw), 1, false);
        this.lXx.ofp = new 4(this);
        this.lXx.ofq = new n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1:
                        NormalUserFooterPreference$a.this.lXw.bny();
                        return;
                    case 2:
                        NormalUserFooterPreference$a.this.lXw.bnz();
                        return;
                    default:
                        return;
                }
            }
        };
        this.lXx.bXO();
    }

    final void JH(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.NormalUserFooterPreference", "mod stranger remark, username is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_Scene", NormalUserFooterPreference.l(this.lXw));
        intent.putExtra("Contact_mode_name_type", 0);
        intent.putExtra("Contact_ModStrangerRemark", true);
        intent.putExtra("Contact_User", NormalUserFooterPreference.a(this.lXw).field_username);
        intent.putExtra("Contact_Nick", NormalUserFooterPreference.a(this.lXw).field_nickname);
        intent.putExtra("Contact_RemarkName", NormalUserFooterPreference.a(this.lXw).field_conRemark);
        com.tencent.mm.plugin.profile.a.ezn.o(intent, this.lXw.mContext);
    }

    protected final void bnE() {
        h.mEJ.h(14553, new Object[]{Integer.valueOf(2), Integer.valueOf(2), NormalUserFooterPreference.a(this.lXw).field_username});
        String str = NormalUserFooterPreference.a(this.lXw).field_username;
        if (s.hc(str)) {
            NormalUserFooterPreference.a(this.lXw).Bc();
            au.HU();
            c.FQ().b(new com.tencent.mm.aq.c(str));
            au.HU();
            c.FR().Ym(str);
            au.HU();
            c.Ga().in(str);
            return;
        }
        String str2;
        this.isDeleteCancel = false;
        Context context = this.lXw.mContext;
        this.lXw.mContext.getString(R.l.app_tip);
        p a = com.tencent.mm.ui.base.h.a(context, this.lXw.mContext.getString(R.l.app_waiting), true, new 6(this));
        if (this.isDeleteCancel) {
            str2 = null;
        } else {
            str2 = com.tencent.mm.pluginsdk.wallet.e.Uk(NormalUserFooterPreference.a(this.lXw).field_username);
        }
        if (bi.oW(str2)) {
            sa(str);
            return;
        }
        a.dismiss();
        com.tencent.mm.ui.base.h.a(this.lXw.mContext, false, this.lXw.mContext.getString(R.l.wallet_delete_contact_note, new Object[]{str2}), null, this.lXw.mContext.getString(R.l.goto_conversation), this.lXw.mContext.getString(R.l.delete_contact), new 7(this), new 8(this, a, str), -1, R.e.alert_btn_color_warn);
    }

    final void sa(String str) {
        g gVar = null;
        NormalUserFooterPreference.a(this.lXw).Bc();
        if (ab.XR(str)) {
            ((com.tencent.mm.openim.a.a) com.tencent.mm.kernel.g.l(com.tencent.mm.openim.a.a.class)).oB(str);
        } else {
            au.HU();
            c.FQ().b(new com.tencent.mm.aq.c(str));
        }
        bd.a(str, new bd.a() {
            public final boolean Ip() {
                return NormalUserFooterPreference$a.this.isDeleteCancel;
            }

            public final void Io() {
                if (NormalUserFooterPreference$a.this.lXw.eHw != null) {
                    NormalUserFooterPreference$a.this.lXw.eHw.dismiss();
                }
            }
        });
        au.HU();
        c.FR().a(str, NormalUserFooterPreference.a(this.lXw));
        au.HU();
        c.FW().Yp(str);
        com.tencent.mm.az.c.d(0, str);
        com.tencent.mm.az.c.d(0, NormalUserFooterPreference.a(this.lXw).field_encryptUsername);
        switch (NormalUserFooterPreference.l(this.lXw)) {
            case 10:
                com.tencent.mm.platformtools.x.I(this.lXw.mContext, str);
                break;
            case 12:
                ao pA = b.getQQListStg().pA(str);
                if (pA != null) {
                    pA.eLx = 1;
                    b.getQQListStg().a(pA.eLw, pA);
                    break;
                }
                break;
            case 13:
                com.tencent.mm.plugin.account.friend.a.a pp = b.getAddrUploadStg().pp(str);
                if (!(pp == null || bi.oW(pp.eJG))) {
                    pp.status = 1;
                    b.getAddrUploadStg().a(pp.Xh(), pp);
                }
                com.tencent.mm.platformtools.x.I(this.lXw.mContext, str);
                break;
            case 31:
                com.tencent.mm.plugin.account.friend.a.h facebookFrdStg = b.getFacebookFrdStg();
                Cursor b = facebookFrdStg.dCZ.b("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend   where facebookfriend.username = \"" + str + "\"", null, 2);
                if (b != null) {
                    g gVar2;
                    if (b.moveToFirst()) {
                        gVar2 = new g();
                        gVar2.d(b);
                    } else {
                        gVar2 = null;
                    }
                    b.close();
                    gVar = gVar2;
                }
                if (gVar != null) {
                    gVar.status = 100;
                    b.getFacebookFrdStg().a(gVar);
                    break;
                }
                break;
            case a$k.AppCompatTheme_toolbarStyle /*58*/:
            case 59:
            case a$k.AppCompatTheme_popupMenuStyle /*60*/:
                b.getGoogleFriendStorage().ab(str, 2);
                break;
        }
        if (NormalUserFooterPreference.l(this.lXw) == 9) {
            x.i("MicroMsg.NormalUserFooterPreference", "add scene unkown, check the contact getsource: " + NormalUserFooterPreference.a(this.lXw).getSource());
            switch (NormalUserFooterPreference.a(this.lXw).getSource()) {
                case 10:
                case 13:
                    x.i("MicroMsg.NormalUserFooterPreference", "delete the system contact info added by wechat");
                    com.tencent.mm.platformtools.x.I(this.lXw.mContext, str);
                    break;
            }
        }
        if (NormalUserFooterPreference.o(this.lXw) == 0) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            com.tencent.mm.plugin.profile.a.ezn.q(intent, this.lXw.mContext);
            return;
        }
        NormalUserFooterPreference.b(this.lXw).setResult(-1, NormalUserFooterPreference.b(this.lXw).getIntent().putExtra("_delete_ok_", true));
        ((Activity) this.lXw.mContext).finish();
    }
}
