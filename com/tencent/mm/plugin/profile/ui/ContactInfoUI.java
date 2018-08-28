package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.ab.o;
import com.tencent.mm.ac.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.qt;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.statusbar.DrawStatusBarPreference;

public class ContactInfoUI extends DrawStatusBarPreference implements a, j.a, b {
    private int eLK;
    private f eOE;
    private String fsV = "";
    private ab guS;
    private String juZ;
    private com.tencent.mm.pluginsdk.b.a lUC;
    private boolean lUD;
    private boolean lUE;
    private byte[] lUF;
    private boolean lUG = false;
    String lUH = null;
    private String lUI = "";
    private boolean lUJ = false;

    public final int Ys() {
        return R.o.contact_info_stub;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.ContactInfoUI", "onCreate MMCore.accHasReady[%b]", new Object[]{Boolean.valueOf(au.HX())});
        this.lUH = getIntent().getStringExtra("Contact_Search_Mobile");
        if (g.Eg().Dx()) {
            au.HU();
            c.FR().a(this);
            au.HU();
            c.FS().a(this);
            initView();
            return;
        }
        finish();
    }

    public void onDestroy() {
        int i = 0;
        if (g.Eg().Dx()) {
            au.HU();
            c.FR().b(this);
            au.HU();
            c.FS().b(this);
        }
        if (this.lUC != null) {
            this.lUC.auw();
        }
        if (this.lUC instanceof com.tencent.mm.plugin.profile.ui.newbizinfo.b) {
            com.tencent.mm.plugin.profile.ui.newbizinfo.b bVar = (com.tencent.mm.plugin.profile.ui.newbizinfo.b) this.lUC;
            if (bVar.guS == null || bVar.lUs == null || bVar.lYt == null) {
                x.w("MicroMsg.ContactWidgetNewBizInfo", "reportEnd fail, err");
            } else {
                bVar.endTime = System.currentTimeMillis();
                String str = bVar.guS.field_username;
                int i2 = bVar.eLK;
                int i3 = bVar.lUs.field_type;
                long j = bVar.cYb;
                long j2 = bVar.endTime;
                int i4 = com.tencent.mm.l.a.gd(bVar.guS.field_type) ? 1 : 0;
                int i5 = bVar.lYt.field_originalArticleCount;
                int i6 = bVar.lYt.field_friendSubscribeCount;
                if (bVar.lVH != null) {
                    i = bVar.lVH.size();
                }
                com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(str, i2, i3, j, j2, i4, i5, i6, i, com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.bJ(bVar.lYt.bnM()), com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.bK(bVar.lYt.bnN()));
            }
        }
        if (n.nkx != null) {
            n.nkx.H(this);
        }
        super.onDestroy();
    }

    public void onResume() {
        d.b(3, "ContactInfoUI" + aYS(), hashCode());
        z.MY().c(this);
        super.onResume();
        View focusedChild = ((ViewGroup) this.mController.contentView).getFocusedChild();
        if (focusedChild != null) {
            focusedChild.clearFocus();
            x.i("MicroMsg.ContactInfoUI", "try to clear focus. id:%s", new Object[]{Integer.valueOf(focusedChild.getId())});
        }
    }

    protected void onRestart() {
        super.onRestart();
        this.lUJ = false;
    }

    public void onPause() {
        d.b(4, "ContactInfoUI" + aYS(), hashCode());
        z.MY().d(this);
        super.onPause();
        au.Em().L(new Runnable() {
            public final void run() {
                au.HU();
                c.DT().lm(true);
            }
        });
        if (getIntent().getBooleanExtra("key_from_wesport_right_newtips", false)) {
            com.tencent.mm.plugin.ab.a.bji();
            com.tencent.mm.ao.d.m(com.tencent.mm.ao.b.ebo, cql());
        } else if (getIntent().getBooleanExtra("key_from_wesport_plugin_newtips", false)) {
            com.tencent.mm.plugin.ab.a.bji();
            com.tencent.mm.ao.d.m(com.tencent.mm.ao.b.ebm, cql());
        }
    }

    protected final String aYS() {
        if (this.guS == null || ((int) this.guS.dhP) == 0 || bi.oW(this.guS.field_username)) {
            return "";
        }
        x.i("MicroMsg.ContactInfoUI", "getIdentityString %s", new Object[]{this.guS.field_username});
        if (com.tencent.mm.ac.f.eZ(this.guS.field_username)) {
            return "_EnterpriseChat";
        }
        if (com.tencent.mm.ac.f.kM(this.guS.field_username)) {
            return "_EnterpriseFatherBiz";
        }
        if (com.tencent.mm.ac.f.kL(this.guS.field_username)) {
            return "_EnterpriseChildBiz";
        }
        if (this.guS.ckW()) {
            return "_bizContact";
        }
        if (s.fq(this.guS.field_username)) {
            return "_chatroom";
        }
        if (s.gY(this.guS.field_username)) {
            return "_bottle";
        }
        if (s.gZ(this.guS.field_username)) {
            return "_QQ";
        }
        if (s.hO(this.guS.field_username)) {
            return "_" + this.guS.field_username;
        }
        return "";
    }

    protected final void initView() {
        String oV;
        String str;
        Object obj;
        int a;
        this.eOE = this.tCL;
        this.eOE.removeAll();
        this.eLK = getIntent().getIntExtra("Contact_Scene", 9);
        this.juZ = getIntent().getStringExtra("Verify_ticket");
        this.lUD = getIntent().getBooleanExtra("Chat_Readonly", false);
        this.lUE = getIntent().getBooleanExtra("User_Verify", false);
        this.fsV = getIntent().getStringExtra("Contact_ChatRoomId");
        String oV2 = bi.oV(getIntent().getStringExtra("Contact_User"));
        String oV3 = bi.oV(getIntent().getStringExtra("Contact_Alias"));
        String oV4 = bi.oV(getIntent().getStringExtra("Contact_Encryptusername"));
        if (oV2.endsWith("@stranger")) {
            oV4 = oV2;
        }
        au.HU();
        this.guS = c.FR().Yg(oV2);
        if (this.guS != null) {
            this.guS.taj = oV2;
        }
        com.tencent.mm.plugin.profile.a.ezo.a(this.guS);
        String stringExtra = getIntent().getStringExtra("Contact_Nick");
        int intExtra = getIntent().getIntExtra("Contact_Sex", 0);
        String stringExtra2 = getIntent().getStringExtra("Contact_Province");
        String stringExtra3 = getIntent().getStringExtra("Contact_City");
        String stringExtra4 = getIntent().getStringExtra("Contact_Signature");
        int intExtra2 = getIntent().getIntExtra("Contact_VUser_Info_Flag", 0);
        String stringExtra5 = getIntent().getStringExtra("Contact_VUser_Info");
        String stringExtra6 = getIntent().getStringExtra("Contact_Distance");
        int intExtra3 = getIntent().getIntExtra("Contact_KWeibo_flag", 0);
        String stringExtra7 = getIntent().getStringExtra("Contact_KWeibo");
        String stringExtra8 = getIntent().getStringExtra("Contact_KWeiboNick");
        String stringExtra9 = getIntent().getStringExtra("Contact_KFacebookName");
        long longExtra = getIntent().getLongExtra("Contact_KFacebookId", 0);
        this.lUI = getIntent().getStringExtra("Contact_BrandIconURL");
        String stringExtra10 = getIntent().getStringExtra("Contact_RegionCode");
        this.lUF = getIntent().getByteArrayExtra("Contact_customInfo");
        int intExtra4 = getIntent().getIntExtra("Contact_Ext_Flag", 0);
        boolean booleanExtra = getIntent().getBooleanExtra("force_get_contact", false);
        x.i("MicroMsg.ContactInfoUI", "dkverify forceAddContact:%s  user:%s  roomid:%s ", new Object[]{Boolean.valueOf(booleanExtra), oV2, this.fsV});
        if (booleanExtra) {
            x.d("MicroMsg.ContactInfoUI", "initView, forceAddContact, user = " + oV2);
            if (this.guS == null || !com.tencent.mm.l.a.gd(this.guS.field_type)) {
                am.a.dBr.R(oV2, "");
            } else {
                am.a.dBr.R(oV2, this.fsV);
            }
        }
        if ((this.guS == null || ((int) this.guS.dhP) == 0) && ab.XR(oV2)) {
            oV = bi.oV(getIntent().getStringExtra(e.a.ths));
            if (bi.oW(oV)) {
                oV = this.juZ;
            }
            g.Eh().dpP.a(new com.tencent.mm.openim.b.b(oV2, bi.oV(this.fsV), oV), 0);
        }
        if (this.guS != null && ((int) this.guS.dhP) > 0 && (!s.hP(this.guS.field_username) || (ab.XQ(this.guS.field_username) && !s.hd(this.guS.field_username)))) {
            if (this.guS.ckZ() && ab.XR(this.guS.field_username)) {
                oV = bi.oV(getIntent().getStringExtra(e.a.ths));
                if (bi.oW(oV)) {
                    oV = this.juZ;
                }
                o oVar = g.Eh().dpP;
                String str2 = this.guS.field_username;
                if (com.tencent.mm.l.a.gd(this.guS.field_type)) {
                    str = "";
                } else {
                    str = bi.oV(this.fsV);
                }
                oVar.a(new com.tencent.mm.openim.b.b(str2, str, oV), 0);
            } else {
                com.tencent.mm.ac.d kH = com.tencent.mm.ac.f.kH(this.guS.field_username);
                obj = (this.guS.ckW() && com.tencent.mm.ac.a.LP()) ? 1 : null;
                if (kH == null || (kH.LS() && obj == null)) {
                    x.d("MicroMsg.ContactInfoUI", "update contact, verifyFlag %d.", new Object[]{Integer.valueOf(intExtra2)});
                    am.a.dBr.R(this.guS.field_username, com.tencent.mm.l.a.gd(this.guS.field_type) ? "" : this.fsV);
                    com.tencent.mm.aa.c.jN(this.guS.field_username);
                } else if (this.guS.ckZ() && obj == null) {
                    x.d("MicroMsg.ContactInfoUI", "update contact, last check time=%d", new Object[]{Integer.valueOf(this.guS.csR)});
                    am.b bVar = am.a.dBr;
                    String str3 = this.guS.field_username;
                    if (com.tencent.mm.l.a.gd(this.guS.field_type)) {
                        oV = "";
                    } else {
                        oV = this.fsV;
                    }
                    bVar.R(str3, oV);
                    com.tencent.mm.aa.c.jN(this.guS.field_username);
                }
            }
        }
        int intExtra5 = getIntent().getIntExtra("Contact_verify_Scene", 9);
        getIntent().getIntExtra("key_add_contact_match_type", 0);
        String stringExtra11 = getIntent().getStringExtra("key_add_contact_openim_appid");
        int intExtra6 = getIntent().getIntExtra("key_add_contact_custom_detail_visible", 0);
        String stringExtra12 = getIntent().getStringExtra("key_add_contact_custom_detail");
        getIntent().getStringExtra("key_add_contact_desc_wording_id");
        getIntent().getStringExtra("key_add_contact_desc_icon");
        if (this.guS == null || ((int) this.guS.dhP) == 0 || bi.oV(this.guS.field_username).length() <= 0) {
            this.guS = new ab();
            this.guS.setUsername(oV2);
            this.guS.du(oV3);
            this.guS.dx(stringExtra);
            this.guS.dy(getIntent().getStringExtra("Contact_PyInitial"));
            this.guS.dz(getIntent().getStringExtra("Contact_QuanPin"));
            this.guS.eJ(intExtra);
            this.guS.dN(stringExtra2);
            this.guS.dO(stringExtra3);
            this.guS.dM(stringExtra4);
            this.guS.eF(intExtra2);
            this.guS.dR(stringExtra5);
            this.guS.dP(stringExtra6);
            this.guS.eP(intExtra5);
            this.guS.dQ(stringExtra7);
            this.guS.eE(intExtra3);
            this.guS.dA(stringExtra8);
            this.guS.ar(longExtra);
            this.guS.dH(stringExtra9);
            this.guS.dS(stringExtra10);
            this.guS.eS(intExtra4);
            if (!bi.oW(this.lUH) && this.eLK == 15) {
                au.HU();
                bq Hh = c.FS().Hh(oV2);
                bq bqVar = new bq(oV2);
                bqVar.field_conRemark = Hh.field_conRemark;
                bqVar.field_conDescription = Hh.field_conDescription;
                bqVar.field_contactLabels = Hh.field_contactLabels;
                bqVar.field_conPhone = this.lUH;
                au.HU();
                c.FS().a(bqVar);
                this.lUH = null;
            }
            this.guS.eb(stringExtra12);
            this.guS.eT(intExtra6);
            this.guS.dG(stringExtra11);
        } else {
            if (this.guS.sex == 0) {
                this.guS.eJ(intExtra);
            }
            if (!(stringExtra2 == null || stringExtra2.equals(""))) {
                this.guS.dN(stringExtra2);
            }
            if (!(stringExtra3 == null || stringExtra3.equals(""))) {
                this.guS.dO(stringExtra3);
            }
            if (stringExtra10 != null) {
                if (!stringExtra10.equals("")) {
                    this.guS.dS(stringExtra10);
                }
            }
            if (!(!bi.oW(this.guS.signature) || stringExtra4 == null || stringExtra4.equals(""))) {
                this.guS.dM(stringExtra4);
            }
            if (intExtra2 != 0) {
                this.guS.eF(intExtra2);
            }
            if (!(!bi.oW(this.guS.csP) || stringExtra5 == null || stringExtra5.equals(""))) {
                this.guS.dR(stringExtra5);
            }
            if (!(!bi.oW(this.guS.field_nickname) || stringExtra == null || stringExtra.equals(""))) {
                this.guS.dx(stringExtra);
            }
            x.i("MicroMsg.ContactInfoUI", "searchMobilePhone:%s", new Object[]{bi.oV(this.lUH)});
            if (!bi.oW(this.lUH) && this.eLK == 15) {
                obj = 1;
                oV3 = this.guS.csZ;
                if (oV3 != null) {
                    for (String oV5 : this.guS.csZ.split(",")) {
                        if (oV5.equals(this.lUH)) {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                    }
                }
                if (obj != null) {
                    this.guS.dZ(oV3 + this.lUH + ",");
                    this.lUH = null;
                }
                x.i("MicroMsg.ContactInfoUI", "contact PhoneList:%s", new Object[]{bi.oV(this.guS.csZ)});
                this.guS.setSource(15);
            }
            this.guS.dP(stringExtra6);
            this.guS.eP(intExtra5);
            this.guS.ar(longExtra);
            this.guS.dH(stringExtra9);
            if (!bi.oW(stringExtra12)) {
                this.guS.eb(stringExtra12);
            }
            if (intExtra6 != 0) {
                this.guS.eT(intExtra6);
            }
            if (!bi.oW(stringExtra11)) {
                this.guS.dG(stringExtra11);
            }
        }
        if (ab.XR(this.guS.field_username) && (this.eLK == 30 || this.eLK == 45 || this.eLK == 17)) {
            h hVar = h.mEJ;
            Object[] objArr = new Object[2];
            objArr[0] = this.guS.field_openImAppid;
            objArr[1] = Integer.valueOf(this.eLK == 17 ? 2 : 1);
            hVar.h(15320, objArr);
        }
        if (!bi.oW(oV4)) {
            this.guS.dD(oV4);
        }
        if (this.guS == null) {
            x.e("MicroMsg.ContactInfoUI", "contact = null");
        } else {
            bq Hh2;
            if (!bi.oW(oV4)) {
                au.HU();
                Hh2 = c.FS().Hh(oV4);
                if (!(Hh2 == null || bi.oW(Hh2.field_encryptUsername))) {
                    this.guS.dv(Hh2.field_conRemark);
                }
            }
            if (!bi.oW(oV2)) {
                au.HU();
                Hh2 = c.FS().Hh(oV2);
                if (!(Hh2 == null || bi.oW(Hh2.field_encryptUsername))) {
                    this.guS.dv(Hh2.field_conRemark);
                }
            }
        }
        getIntent().putExtra("Contact_User", this.guS.field_username);
        if (!booleanExtra && ((int) this.guS.dhP) <= 0 && this.guS.ckW() && (this.eLK == 17 || this.eLK == 41)) {
            x.d("MicroMsg.ContactInfoUI", "come from card, getContact %s", new Object[]{this.guS.field_username});
            am.a.dBr.R(this.guS.field_username, "");
            com.tencent.mm.aa.c.jN(this.guS.field_username);
        }
        oV5 = "MicroMsg.ContactInfoUI";
        str = "contact.getRemarkDesc() (%s, %s, %s)";
        Object[] objArr2 = new Object[3];
        objArr2[0] = Boolean.valueOf(this.guS.csT == null);
        objArr2[1] = Integer.valueOf(this.guS.csT == null ? 0 : this.guS.csT.length());
        if (this.guS.csT == null) {
            oV4 = "";
        } else {
            oV4 = bi.Xf(this.guS.csT);
        }
        objArr2[2] = oV4;
        x.i(oV5, str, objArr2);
        if (!booleanExtra && ((int) this.guS.dhP) <= 0 && this.eLK == 96) {
            x.i("MicroMsg.ContactInfoUI", "come from chatroom accessverify, getContact %s", new Object[]{this.guS.field_username});
            am.a.dBr.S(this.guS.field_username, getIntent().getStringExtra("key_add_contact_verify_ticket"));
            com.tencent.mm.aa.c.J(this.guS.field_username, 3);
        }
        if (this.guS.field_username.equals(q.GF())) {
            ab abVar;
            au.HU();
            long j = bi.getLong((String) c.DT().get(65825, null), 0);
            if (j > 0) {
                this.guS.ar(j);
                abVar = this.guS;
                au.HU();
                abVar.dH((String) c.DT().get(65826, null));
            }
            abVar = this.guS;
            au.HU();
            abVar.dV((String) c.DT().get(286721, null));
            abVar = this.guS;
            au.HU();
            abVar.dW((String) c.DT().get(286722, null));
            abVar = this.guS;
            au.HU();
            abVar.dX((String) c.DT().get(286723, null));
        }
        if (this.guS.field_username != null && this.guS.field_username.equals(ab.XV(q.GF()))) {
            bl IC = bl.IC();
            oV5 = bi.oV(IC.getProvince());
            str = bi.oV(IC.getCity());
            if (!bi.oW(oV5)) {
                this.guS.dN(oV5);
            }
            if (!bi.oW(str)) {
                this.guS.dO(str);
            }
            if (!bi.oW(IC.countryCode)) {
                this.guS.dS(RegionCodeDecoder.aq(IC.countryCode, IC.dDf, IC.dDe));
            }
            a = bi.a(Integer.valueOf(IC.sex), 0);
            oV4 = bi.oV(IC.signature);
            this.guS.eJ(a);
            this.guS.dM(oV4);
        }
        if (bi.oW(this.guS.field_username)) {
            x.e("MicroMsg.ContactInfoUI", "username is null %s", new Object[]{oV2});
            finish();
            return;
        }
        setMMTitle(s.hO(this.guS.field_username) ? R.l.settings_plugins_title : R.l.contact_info_title);
        if (s.fq(this.guS.field_username)) {
            setMMTitle(R.l.contact_info_room_title);
        }
        oV5 = this.lUI;
        if (s.hb(this.guS.field_username)) {
            this.lUC = com.tencent.mm.bg.d.Z(this, "sport");
        } else if (s.hi(this.guS.field_username)) {
            this.lUC = com.tencent.mm.bg.d.Z(this, "qqmail");
        } else if (s.hj(this.guS.field_username)) {
            this.lUC = new e(this);
            setMMTitle(R.l.settings_plugins_title);
        } else if (s.hl(this.guS.field_username)) {
            this.lUC = com.tencent.mm.bg.d.Z(this, "bottle");
            setMMTitle(R.l.settings_plugins_title);
        } else if (s.hk(this.guS.field_username)) {
            this.lUC = com.tencent.mm.bg.d.Z(this, "tmessage");
            setMMTitle(R.l.settings_plugins_title);
        } else if (s.hw(this.guS.field_username)) {
            this.lUC = new com.tencent.mm.plugin.topstory.ui.a.a(this);
            setMMTitle(R.l.settings_plugins_title);
        } else if (s.hc(this.guS.field_username)) {
            this.lUC = new h(this);
        } else if (s.hq(this.guS.field_username)) {
            this.lUC = new m(this);
        } else if (ab.gY(this.guS.field_username)) {
            this.lUC = new d(this);
        } else if (s.hs(this.guS.field_username)) {
            this.lUC = com.tencent.mm.bg.d.Z(this, "nearby");
        } else if (s.ht(this.guS.field_username)) {
            this.lUC = com.tencent.mm.bg.d.Z(this, "shake");
        } else if (s.hu(this.guS.field_username)) {
            this.lUC = new j(this);
        } else if (s.hv(this.guS.field_username)) {
            this.lUC = com.tencent.mm.bg.d.B(this, "readerapp", "widget_type_news");
        } else if (s.hD(this.guS.field_username)) {
            this.lUC = com.tencent.mm.bg.d.B(this, "readerapp", "widget_type_weibo");
        } else if (s.hn(this.guS.field_username)) {
            this.lUC = new f(this);
        } else if (s.ho(this.guS.field_username)) {
            this.lUC = com.tencent.mm.bg.d.Z(this, "masssend");
        } else if (s.hp(this.guS.field_username)) {
            this.lUC = new g(this);
        } else if (this.guS.ckW() || getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
            qt qtVar;
            boolean z;
            try {
                qtVar = this.lUF == null ? null : (qt) new qt().aG(this.lUF);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ContactInfoUI", e, "", new Object[0]);
                qtVar = null;
            }
            oV2 = this.guS.field_username;
            if (!(!ad.chZ().getBoolean("use_new_profile", true) || s.hW(oV2) || s.hr(oV2) || s.hC(oV2))) {
                if (com.tencent.mm.ac.f.kI(oV2)) {
                    z = true;
                } else if (com.tencent.mm.ac.f.kJ(oV2)) {
                    z = true;
                } else {
                    if (qtVar != null) {
                        com.tencent.mm.ac.d dVar = new com.tencent.mm.ac.d();
                        dVar.field_extInfo = qtVar.eJW;
                        dVar.field_type = dVar.bG(false).Mw();
                        if (dVar.LW()) {
                            z = true;
                        } else if (dVar.LV()) {
                            z = true;
                        }
                    }
                    if (getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
                        z = true;
                    } else if (!com.tencent.mm.ac.f.kM(this.guS.field_username) && !com.tencent.mm.ac.f.kL(this.guS.field_username) && ((int) this.guS.dhP) <= 0 && this.guS.ckW() && (this.eLK == 17 || this.eLK == 41)) {
                        z = true;
                    }
                }
                x.i("MicroMsg.ContactInfoUI", "username:%s, isUseNewProfileUI:%b", new Object[]{this.guS.field_username, Boolean.valueOf(z)});
                if (z) {
                    c cVar = new c(this, oV5, qtVar);
                    if (!bi.oW(this.juZ)) {
                        cVar.juZ = this.juZ;
                    }
                    this.lUC = cVar;
                } else {
                    com.tencent.mm.plugin.profile.ui.newbizinfo.b bVar2 = new com.tencent.mm.plugin.profile.ui.newbizinfo.b(this, oV5, qtVar);
                    if (!bi.oW(this.juZ)) {
                        bVar2.juZ = this.juZ;
                    }
                    this.lUC = bVar2;
                }
            }
            z = false;
            x.i("MicroMsg.ContactInfoUI", "username:%s, isUseNewProfileUI:%b", new Object[]{this.guS.field_username, Boolean.valueOf(z)});
            if (z) {
                c cVar2 = new c(this, oV5, qtVar);
                if (!bi.oW(this.juZ)) {
                    cVar2.juZ = this.juZ;
                }
                this.lUC = cVar2;
            } else {
                com.tencent.mm.plugin.profile.ui.newbizinfo.b bVar22 = new com.tencent.mm.plugin.profile.ui.newbizinfo.b(this, oV5, qtVar);
                if (!bi.oW(this.juZ)) {
                    bVar22.juZ = this.juZ;
                }
                this.lUC = bVar22;
            }
        } else if (s.hz(this.guS.field_username)) {
            this.lUC = new n(this);
        } else if (s.hA(this.guS.field_username)) {
            this.lUC = new i(this);
        } else {
            this.lUC = new k(this);
        }
        if (this.lUC != null) {
            this.lUC.a(this.eOE, this.guS, this.lUD, this.eLK);
            com.tencent.mm.plugin.account.friend.a.a pp = com.tencent.mm.plugin.account.b.getAddrUploadStg().pp(this.guS.field_username);
            oV4 = "";
            if (pp != null) {
                oV4 = bi.oV(pp.Xp()).replace(" ", "");
            }
            if (!this.lUJ && com.tencent.mm.l.a.gd(this.guS.field_type) && (this.lUC instanceof k)) {
                int i;
                int i2;
                if (bi.oW(this.guS.csZ)) {
                    i = 0;
                } else {
                    i = this.guS.csZ.split(",").length;
                }
                if (bi.oW(oV4)) {
                    a = 0;
                } else {
                    a = 1;
                }
                i += a;
                h hVar2 = h.mEJ;
                objArr2 = new Object[4];
                objArr2[0] = this.guS.field_username;
                objArr2[1] = Integer.valueOf(1);
                if (bi.oW(oV4)) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                objArr2[2] = Integer.valueOf(i2);
                if (i >= 5) {
                    i2 = 5;
                } else {
                    i2 = i;
                }
                objArr2[3] = Integer.valueOf(i2);
                hVar2.h(12040, objArr2);
                this.lUJ = true;
            }
            if (!((this.lUC instanceof k) || (this.lUC instanceof c) || (this.lUC instanceof com.tencent.mm.plugin.profile.ui.newbizinfo.b))) {
                au.HU();
                oV4 = (String) c.DT().get(aa.a.sXd, "");
                if (oV4.contains(this.guS.field_username)) {
                    oV4 = oV4.replaceAll(this.guS.field_username + ",*", "");
                    au.HU();
                    c.DT().a(aa.a.sXd, oV4);
                    x.i("MicroMsg.ContactInfoUI", "mark plugin read, userName:%s, newVal:%s", new Object[]{this.guS.field_username, oV4});
                    if (bi.oW(oV4)) {
                        com.tencent.mm.s.c.Cp().v(262158, false);
                    }
                }
            }
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if ((s.hu(ContactInfoUI.this.guS.field_username) && !q.GZ()) || ((s.hm(ContactInfoUI.this.guS.field_username) && !q.GV()) || ((s.ho(ContactInfoUI.this.guS.field_username) && !q.Hf()) || (s.hi(ContactInfoUI.this.guS.field_username) && !q.Hh())))) {
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    com.tencent.mm.plugin.profile.a.ezn.q(intent, ContactInfoUI.this);
                }
                ContactInfoUI.this.finish();
                return true;
            }
        });
        com.tencent.mm.aa.q.KJ().jP(this.guS.field_username);
        if ((s.hu(this.guS.field_username) && q.GZ()) || ((s.hm(this.guS.field_username) && q.GV()) || ((s.ho(this.guS.field_username) && q.Hf()) || (s.hi(this.guS.field_username) && q.Hh())))) {
            this.lUG = true;
        } else {
            this.lUG = false;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.lUC != null) {
            this.lUC.onActivityResult(i, i2, intent);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.mKey;
        x.i("MicroMsg.ContactInfoUI", str + " item has been clicked!");
        if (this.lUC != null) {
            this.lUC.wX(str);
        }
        return false;
    }

    public final void a(int i, m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            x.i("MicroMsg.ContactInfoUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        a((String) obj, null);
    }

    public final void a(final String str, l lVar) {
        new ag().post(new Runnable() {
            public final void run() {
                x.i("MicroMsg.ContactInfoUI", "onNotifyChange verify:%b, contact.user:%s, notify.user:%s", new Object[]{Boolean.valueOf(ContactInfoUI.this.lUE), ContactInfoUI.this.guS.field_username, str});
                if (ContactInfoUI.this.guS != null && !bi.oW(ContactInfoUI.this.guS.field_username)) {
                    if (ContactInfoUI.this.guS.field_username.equals(str) || ContactInfoUI.this.guS.field_username.equals(ab.XV(str))) {
                        if (ContactInfoUI.this.lUC != null) {
                            ContactInfoUI.this.lUC.auw();
                            ContactInfoUI.this.eOE.removeAll();
                        }
                        ContactInfoUI.this.initView();
                    }
                }
            }
        });
    }

    public final void a(final bq bqVar) {
        ah.A(new Runnable() {
            public final void run() {
                if (ContactInfoUI.this.guS != null && bqVar != null && !bi.oW(ContactInfoUI.this.guS.field_username) && ContactInfoUI.this.guS.field_username.equals(bqVar.field_encryptUsername) && !s.hP(ContactInfoUI.this.guS.field_username)) {
                    ContactInfoUI.this.guS.dv(bqVar.field_conRemark);
                    ContactInfoUI.this.getIntent().putExtra("Contact_User", ContactInfoUI.this.guS.field_username);
                    if (ContactInfoUI.this.lUC != null) {
                        ContactInfoUI.this.lUC.auw();
                        ContactInfoUI.this.eOE.removeAll();
                    }
                    ContactInfoUI.this.initView();
                }
            }
        });
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.ContactInfoUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        NormalUserFooterPreference normalUserFooterPreference;
        switch (i) {
            case 19:
                if (iArr[0] == 0) {
                    normalUserFooterPreference = (NormalUserFooterPreference) this.eOE.ZZ("contact_info_footer_normal");
                    if (normalUserFooterPreference != null) {
                        normalUserFooterPreference.bnz();
                        return;
                    }
                    return;
                }
                int i2 = "android.permission.CAMERA".equals(strArr[0]) ? R.l.permission_camera_request_again_msg : R.l.permission_microphone_request_again_msg;
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a(this, getString(i2), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            ContactInfoUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new 6(this));
                    return;
                }
                return;
            case f$k.AppCompatTheme_colorPrimary /*82*/:
                if (iArr[0] == 0) {
                    normalUserFooterPreference = (NormalUserFooterPreference) this.eOE.ZZ("contact_info_footer_normal");
                    if (normalUserFooterPreference != null) {
                        normalUserFooterPreference.bny();
                        return;
                    }
                    return;
                }
                com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_location_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new 7(this), null);
                return;
            default:
                return;
        }
    }
}
