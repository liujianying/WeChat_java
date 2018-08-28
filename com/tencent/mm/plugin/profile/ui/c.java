package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aa.k;
import com.tencent.mm.aa.q;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.a.j;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.d.b;
import com.tencent.mm.ac.g;
import com.tencent.mm.ac.h.a;
import com.tencent.mm.ac.n;
import com.tencent.mm.ac.y;
import com.tencent.mm.ac.z;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.ng;
import com.tencent.mm.model.am;
import com.tencent.mm.model.au;
import com.tencent.mm.model.i;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a$k;
import com.tencent.mm.protocal.c.atx;
import com.tencent.mm.protocal.c.bls;
import com.tencent.mm.protocal.c.blt;
import com.tencent.mm.protocal.c.brs;
import com.tencent.mm.protocal.c.brt;
import com.tencent.mm.protocal.c.cgc;
import com.tencent.mm.protocal.c.qt;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class c implements e, a, n, com.tencent.mm.pluginsdk.b.a {
    MMActivity bGc;
    private List<d.a> dKO;
    private b dKP;
    private boolean dKW;
    private String dKY;
    private SharedPreferences duR;
    private int eLK;
    f eOE;
    ab guS;
    private boolean hEj;
    private CheckBoxPreference hLs;
    boolean isDeleteCancel;
    String juZ;
    private boolean lUD;
    private String lUI;
    d lUs;
    private j lVG;
    private List<WxaEntryInfo> lVH;
    private qt lVI;
    private boolean lVJ;
    private boolean lVK;
    boolean lVL;
    private int lVM;
    private String lVN;
    private boolean lVO;
    com.tencent.mm.ui.widget.a.c lVP;
    private Bundle lVQ;
    SnsAdClick lVR;
    private String lVS;
    p tipDialog;

    static /* synthetic */ void a(c cVar) {
        com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(cVar.bGc, 1, false);
        dVar.ofp = new 19(cVar);
        dVar.ofq = new 2(cVar);
        dVar.bXO();
    }

    private c(MMActivity mMActivity) {
        this.lVI = null;
        this.lVJ = false;
        this.lVK = false;
        this.dKW = false;
        this.lVL = false;
        this.lVM = 0;
        this.lVP = null;
        this.duR = null;
        this.lVR = null;
        this.lVS = null;
        this.tipDialog = null;
        this.isDeleteCancel = false;
        this.bGc = mMActivity;
    }

    public c(MMActivity mMActivity, String str, qt qtVar) {
        this(mMActivity);
        this.lUI = str;
        this.lVI = qtVar;
    }

    public final boolean wX(String str) {
        int i = 4;
        if (str == null) {
            return false;
        }
        Intent intent;
        String Mg;
        if (str.equals("contact_info_verifyuser_weibo")) {
            new com.tencent.mm.plugin.profile.ui.a.a(this.bGc).ef(this.guS.csO, this.guS.field_username);
            return true;
        } else if ("contact_info_biz_go_chatting".endsWith(str)) {
            if (this.lVR != null) {
                ng ngVar = new ng();
                this.lVR.egJ = 5;
                ngVar.bYk.bYl = this.lVR;
                com.tencent.mm.sdk.b.a.sFg.m(ngVar);
            }
            if (this.lUs == null || !(this.lUs.LY() || this.lUs.Ma())) {
                intent = new Intent();
                if (this.bGc.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
                    intent.setFlags(268435456);
                }
                if (this.lUD) {
                    intent.putExtra("Chat_User", this.guS.field_username);
                    intent.putExtra("Chat_Mode", 1);
                    this.bGc.setResult(-1, intent);
                } else {
                    intent.putExtra("Chat_User", this.guS.field_username);
                    intent.putExtra("Chat_Mode", 1);
                    intent.putExtra("finish_direct", true);
                    com.tencent.mm.plugin.profile.a.ezn.e(intent, this.bGc);
                }
            } else {
                intent = new Intent();
                if (this.lUs.Ma()) {
                    Mg = this.lUs.Mg();
                    if (bi.oW(Mg)) {
                        x.w("MicroMsg.ContactWidgetBizInfo", "contact_info_biz_go_chatting fatherUserName is empty");
                        return false;
                    }
                    intent.putExtra("enterprise_biz_name", Mg);
                    intent.putExtra("enterprise_biz_display_name", r.gT(Mg));
                } else {
                    intent.putExtra("enterprise_biz_name", this.guS.field_username);
                    intent.putExtra("enterprise_biz_display_name", r.gT(this.guS.field_username));
                }
                intent.addFlags(67108864);
                com.tencent.mm.bg.d.e(this.bGc, ".ui.conversation.EnterpriseConversationUI", intent);
                this.bGc.finish();
            }
            ay(5, null);
            return true;
        } else if ("contact_info_biz_add".endsWith(str)) {
            if (com.tencent.mm.model.gdpr.c.Jm()) {
                com.tencent.mm.model.gdpr.c.a(this.bGc, com.tencent.mm.model.gdpr.a.dEc, this.guS.field_username, new 4(this));
            } else {
                bnr();
            }
            if (this.lVM == 0) {
                return true;
            }
            h.mEJ.h(11263, new Object[]{Integer.valueOf(this.lVM), this.guS.field_username});
            return true;
        } else if ("contact_info_biz_read_msg_online".endsWith(str)) {
            return true;
        } else {
            if (!"contact_info_stick_biz".equals(str)) {
                int i2;
                String str2;
                if (!(!"contact_info_guarantee_info".equals(str) || this.dKP.Mr() == null || bi.oW(this.dKP.Mr().dLQ))) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", this.dKP.Mr().dLQ);
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    intent.putExtra("geta8key_scene", 3);
                    com.tencent.mm.bg.d.b(this.bGc, "webview", ".ui.tools.WebViewUI", intent);
                }
                if (str.startsWith("contact_info_bizinfo_external#")) {
                    i2 = bi.getInt(str.replace("contact_info_bizinfo_external#", ""), -1);
                    if (i2 >= 0 && i2 < this.dKO.size()) {
                        d.a aVar = (d.a) this.dKO.get(i2);
                        Mg = aVar.url;
                        Intent intent2 = new Intent();
                        intent2.putExtra("rawUrl", Mg);
                        intent2.putExtra("useJs", true);
                        intent2.putExtra("vertical_scroll", true);
                        intent2.putExtra("geta8key_scene", 3);
                        intent2.putExtra("KPublisherId", "brand_profile");
                        intent2.putExtra("prePublishId", "brand_profile");
                        if ((this.lVQ != null && (this.eLK == 39 || this.eLK == 56 || this.eLK == 35)) || this.eLK == 87 || this.eLK == 89 || this.eLK == 85 || this.eLK == 88) {
                            x.d("MicroMsg.ContactWidgetBizInfo", "from biz search.");
                            Bundle bundle = new Bundle();
                            bundle.putBoolean("KFromBizSearch", true);
                            bundle.putBundle("KBizSearchExtArgs", this.lVQ);
                            intent2.putExtra("jsapiargs", bundle);
                            i = com.tencent.mm.l.a.gd(this.guS.field_type) ? 7 : 6;
                            int identifier = this.bGc.getResources().getIdentifier(aVar.dKS, "string", this.bGc.getPackageName());
                            str2 = aVar.title;
                            if (identifier > 0) {
                                str2 = this.bGc.getString(identifier);
                            }
                            ay(i, str2);
                        }
                        com.tencent.mm.bg.d.b(this.bGc, "webview", ".ui.tools.WebViewUI", intent2);
                        return true;
                    }
                }
                d dVar;
                Intent intent3;
                if ("contact_info_subscribe_bizinfo".endsWith(str) || "contact_info_show_brand".endsWith(str) || "contact_info_locate".endsWith(str)) {
                    d dVar2 = this.lUs;
                    if (dVar2 == null) {
                        return true;
                    }
                    if ("contact_info_subscribe_bizinfo".endsWith(str)) {
                        if (!dVar2.LX()) {
                            if (dVar2.LQ()) {
                                dVar2.field_brandFlag |= 1;
                                if (this.dKP == null && dVar2 != null) {
                                    this.dKP = dVar2.bG(false);
                                }
                                if (this.dKP != null && this.dKP.Mk() && com.tencent.mm.bg.d.QS("brandservice")) {
                                    this.eOE.bw("contact_info_template_recv", false);
                                } else {
                                    this.eOE.bw("contact_info_template_recv", true);
                                }
                            } else {
                                dVar2.field_brandFlag &= -2;
                                this.eOE.bw("contact_info_template_recv", true);
                            }
                            h hVar = h.mEJ;
                            Object[] objArr = new Object[4];
                            objArr[0] = dVar2.field_username;
                            objArr[1] = Integer.valueOf(1);
                            if (dVar2.LQ()) {
                                i = 3;
                            }
                            objArr[2] = Integer.valueOf(i);
                            objArr[3] = Integer.valueOf(0);
                            hVar.h(13307, objArr);
                        } else if (dVar2 != null) {
                            if (dVar2.Ma()) {
                                au.DF().a(1363, this);
                                if (((CheckBoxPreference) this.eOE.ZZ("contact_info_subscribe_bizinfo")).isChecked()) {
                                    i2 = 0;
                                } else {
                                    i2 = 4;
                                }
                                final com.tencent.mm.plugin.profile.a.b bVar = new com.tencent.mm.plugin.profile.a.b(dVar2.field_username, i2);
                                au.DF().a(bVar, 0);
                                MMActivity mMActivity = this.bGc;
                                this.bGc.getString(R.l.app_tip);
                                this.tipDialog = com.tencent.mm.ui.base.h.a(mMActivity, this.bGc.getString(R.l.app_waiting), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        au.DF().c(bVar);
                                        au.DF().b(1363, c.this);
                                    }
                                });
                            } else if (dVar2.LY()) {
                                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("contact_info_subscribe_bizinfo");
                                z.Nh();
                                y a = com.tencent.mm.ac.c.a(dVar2.field_username, !checkBoxPreference.isChecked(), this);
                                MMActivity mMActivity2 = this.bGc;
                                this.bGc.getString(R.l.app_tip);
                                this.tipDialog = com.tencent.mm.ui.base.h.a(mMActivity2, this.bGc.getString(R.l.app_waiting), true, new 16(this, a));
                            }
                        }
                    } else if ("contact_info_show_brand".endsWith(str)) {
                        boolean z;
                        if ((dVar2.field_brandFlag & 2) == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            dVar2.field_brandFlag |= 2;
                        } else {
                            dVar2.field_brandFlag &= -3;
                        }
                    } else if ("contact_info_locate".endsWith(str)) {
                        if (dVar2.LR()) {
                            dVar2.field_brandFlag &= -5;
                        } else {
                            this.lVP = com.tencent.mm.ui.base.h.a(this.bGc, this.bGc.getString(R.l.chatting_biz_report_location_confirm, new Object[]{this.guS.BL()}), this.bGc.getString(R.l.app_tip), new 1(this, dVar2), new 12(this, dVar2));
                        }
                    }
                    if (dVar2.Ma() || dVar2.LY()) {
                        return true;
                    }
                    a(dVar2, false);
                    return true;
                } else if ("contact_info_verifyuser".endsWith(str)) {
                    dVar = this.lUs;
                    if (dVar == null) {
                        return true;
                    }
                    b bG = dVar.bG(false);
                    if (bG == null) {
                        return true;
                    }
                    str2 = null;
                    if (bG.Mt() != null && !bi.oW(bG.Mt().dLL)) {
                        str2 = bG.Mt().dLL;
                    } else if (!(bG.Mu() == null || bi.oW(bG.Mu().dLT))) {
                        str2 = bG.Mu().dLT;
                    }
                    if (bi.oW(str2)) {
                        return true;
                    }
                    intent3 = new Intent();
                    intent3.putExtra("rawUrl", str2);
                    intent3.putExtra("useJs", true);
                    intent3.putExtra("vertical_scroll", true);
                    intent3.putExtra("geta8key_scene", 3);
                    com.tencent.mm.bg.d.b(this.bGc, "webview", ".ui.tools.WebViewUI", intent3);
                    return true;
                } else if ("contact_info_trademark".endsWith(str)) {
                    dVar = this.lUs;
                    if (dVar == null || dVar.bG(false) == null || bi.oW(dVar.bG(false).Mm())) {
                        return true;
                    }
                    intent3 = new Intent();
                    intent3.putExtra("rawUrl", dVar.bG(false).Mm());
                    intent3.putExtra("useJs", true);
                    intent3.putExtra("vertical_scroll", true);
                    intent3.putExtra("geta8key_scene", 3);
                    com.tencent.mm.bg.d.b(this.bGc, "webview", ".ui.tools.WebViewUI", intent3);
                    return true;
                } else {
                    if ("contact_is_mute".endsWith(str)) {
                        this.hEj = !this.hEj;
                        if (this.hEj) {
                            s.n(this.guS);
                        } else {
                            s.o(this.guS);
                        }
                        ha(this.hEj);
                    }
                    if ("enterprise_contact_info_enter".equals(str)) {
                        if (this.bGc == null) {
                            x.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise context is null");
                        } else if (this.lUs == null) {
                            x.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise bizInfo is null");
                        } else {
                            intent = new Intent();
                            intent.putExtra("enterprise_biz_name", this.lUs.field_username);
                            intent.addFlags(67108864);
                            com.tencent.mm.bg.d.b(this.bGc, "brandservice", ".ui.EnterpriseBizContactListUI", intent);
                        }
                    }
                    if ("contact_info_biz_disable".equals(str)) {
                        com.tencent.mm.ui.base.h.a(this.bGc, this.bGc.getString(R.l.enterprise_contact_info_disable_sub_confirm), "", this.bGc.getString(R.l.enterprise_contact_info_disable_sub), this.bGc.getString(R.l.app_cancel), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                c.this.gZ(false);
                            }
                        }, null);
                    }
                    if ("contact_info_biz_enable".equals(str)) {
                        gZ(true);
                    }
                    if ("contact_info_template_recv".equals(str)) {
                        intent = new Intent();
                        intent.putExtra("enterprise_biz_name", this.lUs.field_username);
                        com.tencent.mm.bg.d.b(this.bGc, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", intent);
                    }
                    if ("contact_info_service_phone".equals(str)) {
                        Preference ZZ = this.eOE.ZZ("contact_info_service_phone");
                        if (!(ZZ == null || ZZ.getSummary() == null || bi.oW(ZZ.getSummary().toString()))) {
                            String charSequence = ZZ.getSummary().toString();
                            com.tencent.mm.ui.base.h.a(this.bGc, true, charSequence, "", this.bGc.getString(R.l.contact_info_dial), this.bGc.getString(R.l.app_cancel), new 7(this, charSequence), null);
                        }
                    }
                    if ("contact_info_expose_btn".equals(str)) {
                        bnt();
                    }
                    if (!str.equals("biz_placed_to_the_top")) {
                        return true;
                    }
                    x.d("MicroMsg.ContactWidgetBizInfo", "changePlacedTop");
                    if (this.duR == null) {
                        this.duR = this.bGc.getSharedPreferences(this.bGc.getPackageName() + "_preferences", 0);
                    }
                    if (this.guS == null) {
                        return true;
                    }
                    if (this.guS.BG()) {
                        x.d("MicroMsg.ContactWidgetBizInfo", "unSetPlaceTop:%s", new Object[]{this.guS.field_username});
                        s.u(this.guS.field_username, true);
                        this.duR.edit().putBoolean("biz_placed_to_the_top", false).commit();
                        return true;
                    }
                    i.gy(this.guS.field_username);
                    x.d("MicroMsg.ContactWidgetBizInfo", "setPlaceTop:%s", new Object[]{this.guS.field_username});
                    this.duR.edit().putBoolean("biz_placed_to_the_top", true).commit();
                    return true;
                }
            } else if (((CheckBoxPreference) this.eOE.ZZ("contact_info_stick_biz")).isChecked()) {
                h.mEJ.h(13307, new Object[]{this.guS.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0)});
                i.gy(this.guS.field_username);
                return true;
            } else {
                s.u(this.guS.field_username, true);
                h.mEJ.h(13307, new Object[]{this.guS.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0)});
                return true;
            }
        }
    }

    final void gZ(boolean z) {
        com.tencent.mm.plugin.profile.a.c cVar = new com.tencent.mm.plugin.profile.a.c(this.lUs.field_username, !z);
        au.DF().a(1394, this);
        au.DF().a(cVar, 0);
        MMActivity mMActivity = this.bGc;
        this.bGc.getString(R.l.app_tip);
        this.tipDialog = com.tencent.mm.ui.base.h.a(mMActivity, this.bGc.getString(R.l.app_waiting), true, new 14(this, cVar));
    }

    final void a(d dVar, boolean z) {
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("contact_info_subscribe_bizinfo");
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.eOE.ZZ("contact_info_locate");
        atx atx = new atx();
        atx.eJV = dVar.field_brandFlag;
        atx.hbL = this.guS.field_username;
        if (uK(this.eLK)) {
            au.HU();
            com.tencent.mm.model.c.FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(58, atx));
        } else {
            au.HU();
            com.tencent.mm.model.c.FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(47, atx));
        }
        z.MY().c(dVar, new String[0]);
        checkBoxPreference.qpJ = dVar.LQ();
        if (checkBoxPreference2 != null) {
            checkBoxPreference2.qpJ = dVar.LR();
        }
        if (z) {
            bnp();
        }
    }

    public final boolean a(f fVar, ab abVar, boolean z, int i) {
        boolean z2;
        Assert.assertTrue(abVar != null);
        if (bi.oV(abVar.field_username).length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        if (fVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        this.eOE = fVar;
        this.guS = abVar;
        this.lUD = z;
        this.eLK = i;
        this.lVM = this.bGc.getIntent().getIntExtra("add_more_friend_search_scene", 0);
        this.lVR = (SnsAdClick) this.bGc.getIntent().getParcelableExtra("KSnsAdTag");
        this.lVQ = this.bGc.getIntent().getBundleExtra("Contact_Ext_Args");
        this.lVS = this.bGc.getIntent().getStringExtra("key_add_contact_report_info");
        bnp();
        String stringExtra = this.bGc.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
        if (!bi.oW(stringExtra)) {
            this.bGc.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
            com.tencent.mm.ui.base.h.a(this.bGc, stringExtra, "", this.bGc.getString(R.l.app_ok), null);
        }
        if (abVar != null) {
            z.Nk().km(abVar.field_username);
            if (com.tencent.mm.ac.f.kK(abVar.field_username)) {
                stringExtra = abVar.field_username;
                if (com.tencent.mm.ac.f.eZ(stringExtra)) {
                    z.Ng();
                    com.tencent.mm.ac.a.h.a(stringExtra, this);
                    stringExtra = com.tencent.mm.ac.f.kH(stringExtra).Mg();
                    if (stringExtra != null) {
                        z.Nk().km(stringExtra);
                    }
                } else if (com.tencent.mm.ac.f.kM(stringExtra)) {
                    z.Nh();
                    com.tencent.mm.ac.c.a(stringExtra, this);
                    z.MY();
                    stringExtra = com.tencent.mm.ac.e.kD(stringExtra);
                    if (stringExtra != null) {
                        z.Nk().km(stringExtra);
                    }
                }
            }
        }
        return true;
    }

    private void bnp() {
        d dVar;
        CheckBoxPreference checkBoxPreference;
        boolean z;
        Preference ZZ;
        KeyValuePreference keyValuePreference;
        Bitmap e;
        String str;
        String str2;
        Object[] objArr;
        boolean z2;
        Drawable bitmapDrawable;
        String string;
        Bitmap e2;
        CharSequence charSequence;
        IndexOutOfBoundsException e3;
        int indexOf;
        CheckBoxPreference checkBoxPreference2;
        String BL;
        int identifier;
        auw();
        this.eOE.removeAll();
        this.eOE.addPreferencesFromResource(R.o.contact_info_pref_bizinfo);
        if (this.lVL) {
            this.eOE.bw("contact_info_time_expired", true);
        }
        d kH = com.tencent.mm.ac.f.kH(this.guS.field_username);
        this.dKO = null;
        this.dKP = null;
        this.lVH = null;
        if ((kH == null || kH.bG(false) == null) && this.lVI != null) {
            kH = new d();
            kH.field_username = this.guS.field_username;
            kH.field_brandFlag = this.lVI.eJV;
            kH.field_brandIconURL = this.lVI.eJY;
            kH.field_brandInfo = this.lVI.eJX;
            kH.field_extInfo = this.lVI.eJW;
            dVar = kH;
        } else {
            dVar = kH;
        }
        if (dVar != null && dVar.field_brandInfo == null && dVar.field_extInfo == null && this.lVI != null) {
            dVar.field_username = this.guS.field_username;
            dVar.field_brandFlag = this.lVI.eJV;
            dVar.field_brandIconURL = this.lVI.eJY;
            dVar.field_brandInfo = this.lVI.eJX;
            dVar.field_extInfo = this.lVI.eJW;
        }
        BizInfoHeaderPreference bizInfoHeaderPreference = (BizInfoHeaderPreference) this.eOE.ZZ("contact_info_header_bizinfo");
        if (bizInfoHeaderPreference == null || bi.oW(this.guS.field_username)) {
            x.w("MicroMsg.ContactWidgetBizInfo", "head pref is null");
            this.eOE.bw("contact_info_header_bizinfo", true);
        } else {
            ab abVar = this.guS;
            bizInfoHeaderPreference.lUr = this.lUI;
            bizInfoHeaderPreference.lUs = dVar;
            bizInfoHeaderPreference.onDetach();
            au.HU();
            com.tencent.mm.model.c.FR().a(bizInfoHeaderPreference);
            q.Kp().d(bizInfoHeaderPreference);
            z.Ni().a(bizInfoHeaderPreference);
            bizInfoHeaderPreference.guS = abVar;
            Assert.assertTrue("initView: contact username is null", bi.oV(abVar.field_username).length() > 0);
            bizInfoHeaderPreference.initView();
        }
        this.eOE.bw("biz_placed_to_the_top", true);
        this.eOE.bw("contact_info_biz_enable", true);
        this.eOE.bw("contact_info_biz_disable", true);
        this.eOE.bw("contact_info_stick_biz", true);
        if (dVar != null) {
            if (dVar.LZ()) {
                this.eOE.bw("contact_info_biz_add", true);
                this.eOE.bw("contact_info_expose_btn", true);
                this.eOE.bw("contact_is_mute", false);
                this.hEj = this.guS.BD();
                if (dVar.Ma()) {
                    this.eOE.bw("contact_info_biz_go_chatting", true);
                    this.eOE.bw("contact_info_stick_biz", !com.tencent.mm.l.a.gd(this.guS.field_type));
                    checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("contact_info_stick_biz");
                    checkBoxPreference.qpJ = this.guS.BG();
                    checkBoxPreference.setTitle(R.l.enterprise_chat_placetop);
                    bnu();
                } else {
                    this.eOE.bw("contact_info_subscribe_bizinfo", true);
                    this.eOE.bw("contact_info_biz_go_chatting", true);
                    if (dVar.LQ()) {
                        this.eOE.bw("contact_info_biz_enable", true);
                        this.eOE.bw("contact_info_biz_disable", false);
                        this.eOE.ZZ("contact_info_biz_disable").setTitle(R.l.enterprise_contact_info_disable_sub);
                        this.eOE.bw("contact_is_mute", false);
                        this.eOE.bw("biz_placed_to_the_top", false);
                        this.hLs = (CheckBoxPreference) this.eOE.ZZ("biz_placed_to_the_top");
                        this.hLs.setTitle(R.l.enterprise_sub_placetop);
                        bnu();
                        if (dVar.Mb()) {
                            this.eOE.bw("contact_info_locate", true);
                        }
                    } else {
                        this.eOE.bw("contact_info_biz_enable", false);
                        this.eOE.bw("contact_info_biz_disable", true);
                        this.eOE.ZZ("contact_info_biz_enable").setTitle(R.l.enterprise_contact_info_enable_sub);
                        this.eOE.bw("contact_is_mute", true);
                        this.eOE.bw("biz_placed_to_the_top", true);
                        this.eOE.bw("contact_info_locate", true);
                    }
                }
                ha(this.hEj);
            } else if (dVar.LY()) {
                this.eOE.bw("contact_info_locate", true);
                this.eOE.bw("contact_info_subscribe_bizinfo", false);
                this.eOE.bw("enterprise_contact_info_enter", false);
                this.eOE.ZZ("contact_info_biz_go_chatting").setTitle(R.l.enterprise_contact_info_enter);
                this.eOE.bw("contact_info_stick_biz", !com.tencent.mm.l.a.gd(this.guS.field_type));
                checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("contact_info_stick_biz");
                checkBoxPreference.qpJ = this.guS.BG();
                checkBoxPreference.setTitle(R.l.enterprise_father_placetop);
                bnu();
                this.eOE.bw("contact_is_mute", true);
                this.hEj = this.guS.BD();
                ha(this.hEj);
                this.eOE.ZZ("contact_is_mute").setSummary(R.l.contact_info_enterprise_father_mute_tips);
            } else {
                f fVar = this.eOE;
                String str3 = "contact_info_stick_biz";
                z = s.hr(this.guS.field_username) || !com.tencent.mm.l.a.gd(this.guS.field_type);
                fVar.bw(str3, z);
                ((CheckBoxPreference) this.eOE.ZZ("contact_info_stick_biz")).qpJ = this.guS.BG();
                this.eOE.bw("contact_is_mute", true);
                this.hEj = false;
            }
            this.lUs = dVar;
            this.dKO = dVar.Mh();
            this.dKP = dVar.bG(false);
            this.lVH = this.dKP.getWxaEntryInfoList();
            if (this.dKP.Mi()) {
                this.eOE.ZZ("near_field_service").setSummary(R.l.weixin_connect_wifi);
            } else {
                this.eOE.bw("near_field_service", true);
            }
            if (this.dKP.Mo() != null) {
                this.lVK = true;
                if (JE(this.dKP.Mo())) {
                    this.lVJ = true;
                    if (!com.tencent.mm.l.a.gd(this.guS.field_type)) {
                        x.w("MicroMsg.ContactWidgetBizInfo", "expireTime not null, and %s is not my contact", new Object[]{this.guS.field_username});
                        bnq();
                        if (s.hM(this.guS.field_username) || s.hW(this.guS.field_username)) {
                            bnq();
                        }
                    }
                }
                this.eOE.bw("contact_info_time_expired", true);
                bnq();
            } else {
                this.eOE.bw("contact_info_time_expired", true);
            }
            if (this.dKP.Ml() != null && this.dKP.Ml().length() > 0) {
                this.dKY = this.dKP.Ml();
            }
            this.dKW = this.dKP.Mj();
            if (bi.oW(this.dKP.Mz())) {
                this.eOE.bw("contact_info_service_phone", true);
            } else {
                this.eOE.bw("contact_info_service_phone", false);
                ZZ = this.eOE.ZZ("contact_info_service_phone");
                if (ZZ != null) {
                    ZZ.setSummary(this.dKP.Mz());
                    ZZ.hIZ = this.bGc.getResources().getColor(R.e.link_color);
                }
            }
        } else {
            this.eOE.bw("contact_info_time_expired", true);
            x.e("MicroMsg.ContactWidgetBizInfo", "get biz info from storage, but return null");
        }
        if (bi.oW(this.guS.signature)) {
            x.w("MicroMsg.ContactWidgetBizInfo", "has not desc info");
            this.eOE.bw("contact_info_user_desc", true);
            if (!this.lVJ) {
                this.eOE.bw("contact_info_time_expired", true);
            }
        } else {
            keyValuePreference = (KeyValuePreference) this.eOE.ZZ("contact_info_user_desc");
            if (keyValuePreference != null) {
                if (bi.oV(this.guS.signature).trim().length() <= 0) {
                    this.eOE.bw("contact_info_user_desc", true);
                } else {
                    keyValuePreference.csl();
                    keyValuePreference.tCA = false;
                    keyValuePreference.tmc = this.bGc.getString(R.l.contact_info_isnot_verify_user_title);
                    keyValuePreference.setSummary(com.tencent.mm.pluginsdk.ui.d.j.a(this.bGc, this.guS.signature));
                    keyValuePreference.lO(false);
                    if (am.a.dBt != null) {
                        e = BackwardSupportUtil.b.e(am.a.dBt.gX(this.guS.field_verifyFlag), 2.0f);
                    } else {
                        e = null;
                    }
                    str = "MicroMsg.ContactWidgetBizInfo";
                    str2 = "verify bmp is null ? %B";
                    objArr = new Object[1];
                    if (e == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objArr[0] = Boolean.valueOf(z2);
                    x.i(str, str2, objArr);
                    if (e != null) {
                        bitmapDrawable = new BitmapDrawable(this.bGc.getResources(), e);
                    } else {
                        bitmapDrawable = null;
                    }
                    keyValuePreference.tCI = bitmapDrawable;
                    keyValuePreference.tCG = 8;
                }
            }
        }
        if (this.dKP != null && this.dKP.Mt() != null && !bi.oW(this.dKP.Mt().dLJ)) {
            b.d Mt = this.dKP.Mt();
            keyValuePreference = (KeyValuePreference) this.eOE.ZZ("contact_info_verifyuser");
            if (keyValuePreference != null) {
                keyValuePreference.csl();
                keyValuePreference.tCA = false;
                if (bi.oW(Mt.dLK)) {
                    switch (Mt.dLI) {
                        case 0:
                            string = this.bGc.getResources().getString(R.l.contact_info_verify_user_title);
                            break;
                        case 1:
                            string = this.bGc.getResources().getString(R.l.brandservice_sweibo_verify);
                            break;
                        case 2:
                            string = this.bGc.getResources().getString(R.l.brandservice_tweibo_verify);
                            break;
                        default:
                            x.w("MicroMsg.ContactWidgetBizInfo", "getVerifyStr, error type %d", new Object[]{Integer.valueOf(Mt.dLI)});
                            string = this.bGc.getResources().getString(R.l.contact_info_isnot_verify_user_title);
                            break;
                    }
                    keyValuePreference.tmc = string;
                } else {
                    keyValuePreference.tmc = Mt.dLK;
                }
                if (am.a.dBt != null) {
                    e2 = BackwardSupportUtil.b.e(am.a.dBt.gX(this.guS.field_verifyFlag), 2.0f);
                } else {
                    e2 = null;
                }
                if (e2 != null) {
                    bitmapDrawable = new BitmapDrawable(this.bGc.getResources(), e2);
                } else {
                    bitmapDrawable = null;
                }
                str2 = "MicroMsg.ContactWidgetBizInfo";
                String str4 = "verify bmp is null ? %B";
                Object[] objArr2 = new Object[1];
                if (e2 == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr2[0] = Boolean.valueOf(z2);
                x.i(str2, str4, objArr2);
                keyValuePreference.tCI = bitmapDrawable;
                if (Mt.dLJ != null) {
                    str2 = Mt.dLM;
                    CharSequence a = com.tencent.mm.pluginsdk.ui.d.j.a(this.bGc, Mt.dLJ.trim());
                    if (bi.oW(str2)) {
                        charSequence = a;
                    } else {
                        try {
                            charSequence = new SpannableString(str2 + " " + a);
                            try {
                                charSequence.setSpan(new ForegroundColorSpan(-36352), 0, str2.length(), 17);
                            } catch (IndexOutOfBoundsException e4) {
                                e3 = e4;
                                x.e("MicroMsg.ContactWidgetBizInfo", "verifySummary setSpan error: %s", new Object[]{e3.getMessage()});
                                keyValuePreference.setSummary(charSequence);
                                if (this.dKP != null) {
                                }
                                x.w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
                                this.eOE.bw("contact_info_trademark", true);
                                if (this.dKP != null) {
                                }
                                this.eOE.bw("contact_info_privilege", true);
                                indexOf = this.eOE.indexOf("contact_info_category2");
                                if (indexOf >= 0) {
                                }
                                x.d("MicroMsg.ContactWidgetBizInfo", "pos no more");
                                if (!this.lVJ) {
                                }
                                this.eOE.bw("contact_info_verifyuser_weibo", true);
                                if (this.dKP != null) {
                                }
                                this.eOE.bw("contact_info_reputation", true);
                                this.eOE.bw("contact_info_guarantee_info", true);
                                this.eOE.bw("contact_info_scope_of_business", true);
                                if (this.lVH != null) {
                                }
                                this.eOE.bw("contact_info_bindwxainfo", true);
                                string = this.bGc.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID");
                                x.d("MicroMsg.ContactWidgetBizInfo", "updateKF %s, %b", new Object[]{string, Boolean.valueOf(this.lVO)});
                                if (!this.lVO) {
                                    this.lVN = string;
                                    g kR;
                                    IconWidgetPreference iconWidgetPreference;
                                    if (this.dKP == null || !this.dKP.MA() || this.guS == null) {
                                        this.eOE.bw("contact_info_kf_worker", true);
                                    } else if (bi.oW(string)) {
                                        kR = z.MX().kR(this.guS.field_username);
                                        if (kR == null) {
                                            this.eOE.bw("contact_info_kf_worker", true);
                                            z.MZ().a(this);
                                            z.MZ().ag(this.guS.field_username, com.tencent.mm.model.q.GF());
                                            this.lVO = true;
                                        } else {
                                            x.d("MicroMsg.ContactWidgetBizInfo", "has default kf %s", new Object[]{kR.field_openId});
                                            this.eOE.bw("contact_info_kf_worker", false);
                                            iconWidgetPreference = (IconWidgetPreference) this.eOE.ZZ("contact_info_kf_worker");
                                            iconWidgetPreference.setSummary(kR.field_nickname);
                                            e2 = com.tencent.mm.aa.c.a(kR.field_openId, false, -1);
                                            if (e2 == null) {
                                                c(kR);
                                                JF(kR.field_openId);
                                            } else {
                                                iconWidgetPreference.C(e2);
                                            }
                                        }
                                    } else {
                                        com.tencent.mm.ac.i MX = z.MX();
                                        g kQ = MX.kQ(string);
                                        if (kQ == null || com.tencent.mm.ac.i.a(kQ)) {
                                            z.MZ().a(this);
                                            z.MZ().ah(this.guS.field_username, string);
                                            this.lVO = true;
                                        }
                                        if (kQ == null) {
                                            x.d("MicroMsg.ContactWidgetBizInfo", "no such kf, get default kf");
                                            kR = MX.kR(this.guS.field_username);
                                        } else {
                                            kR = kQ;
                                        }
                                        if (kR == null) {
                                            this.eOE.bw("contact_info_kf_worker", true);
                                        } else {
                                            this.eOE.bw("contact_info_kf_worker", false);
                                            iconWidgetPreference = (IconWidgetPreference) this.eOE.ZZ("contact_info_kf_worker");
                                            iconWidgetPreference.setSummary(kR.field_nickname);
                                            e2 = com.tencent.mm.aa.c.a(kR.field_openId, false, -1);
                                            if (e2 == null) {
                                                c(kR);
                                                JF(kR.field_openId);
                                            } else {
                                                iconWidgetPreference.C(e2);
                                            }
                                            x.d("MicroMsg.ContactWidgetBizInfo", "kf worker %s, %s", new Object[]{kR.field_openId, kR.field_nickname});
                                        }
                                    }
                                }
                                x.d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", new Object[]{Boolean.valueOf(this.bGc.getIntent().getBooleanExtra("KIsHardDevice", false))});
                                if (this.bGc.getIntent() == null) {
                                }
                                if (com.tencent.mm.l.a.gd(this.guS.field_type)) {
                                    if (dVar != null) {
                                        checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("contact_info_subscribe_bizinfo");
                                        checkBoxPreference2 = (CheckBoxPreference) this.eOE.ZZ("contact_info_locate");
                                        if (dVar.Ma()) {
                                            checkBoxPreference.setTitle(R.l.enterprise_chat_receive_msg);
                                            this.lVG = z.Nc().cz(z.Nc().cA(dVar.field_username));
                                            if (this.lVG != null) {
                                                if (this.lVG.hu(4)) {
                                                    z2 = false;
                                                } else {
                                                    z2 = true;
                                                }
                                                checkBoxPreference.qpJ = z2;
                                            } else {
                                                x.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
                                            }
                                        } else if (dVar.LY()) {
                                            checkBoxPreference.setTitle(R.l.enterprise_brand_receive_msg);
                                            checkBoxPreference.qpJ = !z.Nh().kr(dVar.field_username);
                                        } else {
                                            checkBoxPreference.qpJ = dVar.LQ();
                                        }
                                        if (dVar.LQ()) {
                                            if (this.dKP == null && dVar != null) {
                                                this.dKP = dVar.bG(false);
                                            }
                                            if (this.dKP != null && this.dKP.Mk() && com.tencent.mm.bg.d.QS("brandservice")) {
                                                this.eOE.bw("contact_info_template_recv", false);
                                            } else {
                                                this.eOE.bw("contact_info_template_recv", true);
                                            }
                                        } else {
                                            this.eOE.bw("contact_info_template_recv", true);
                                        }
                                        if (dVar.bG(false).LU()) {
                                            checkBoxPreference2.qpJ = dVar.LR();
                                        } else {
                                            this.eOE.bw("contact_info_locate", true);
                                            checkBoxPreference2.qpJ = dVar.LR();
                                        }
                                    } else {
                                        this.eOE.bw("contact_info_subscribe_bizinfo", true);
                                        this.eOE.bw("contact_info_locate", true);
                                        this.eOE.bw("contact_info_template_recv", true);
                                    }
                                    this.eOE.bw("contact_info_biz_read_msg_online", true);
                                    this.eOE.bw("contact_info_biz_add", true);
                                    BL = this.guS.BL();
                                    if (BL != null) {
                                        this.bGc.setMMTitle(BL);
                                    }
                                    if (s.hr(this.guS.field_username)) {
                                        this.eOE.ZZ("contact_info_biz_go_chatting").setTitle(R.l.contact_info_send);
                                        this.bGc.setMMTitle(R.l.contact_info_title);
                                    }
                                    if (!s.hM(this.guS.field_username) && this.lUs != null) {
                                        this.bGc.addIconOptionMenu(0, R.g.mm_title_btn_menu, new 18(this));
                                    }
                                }
                                x.w("MicroMsg.ContactWidgetBizInfo", "%s is not my contact", new Object[]{this.guS.field_username});
                                bnq();
                                ZZ = this.eOE.ZZ("contact_info_biz_add");
                                if (ZZ != null && this.lVK) {
                                    ZZ.setTitle(R.l.contact_info_biz_join);
                                }
                                if (uK(this.eLK)) {
                                    if (dVar == null) {
                                        x.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
                                    } else {
                                        ((CheckBoxPreference) this.eOE.ZZ("contact_info_subscribe_bizinfo")).qpJ = dVar.LQ();
                                        this.eOE.bw("contact_info_subscribe_bizinfo", false);
                                    }
                                }
                                this.bGc.showOptionMenu(false);
                            }
                        } catch (IndexOutOfBoundsException e5) {
                            e3 = e5;
                            charSequence = a;
                            x.e("MicroMsg.ContactWidgetBizInfo", "verifySummary setSpan error: %s", new Object[]{e3.getMessage()});
                            keyValuePreference.setSummary(charSequence);
                            if (this.dKP != null) {
                            }
                            x.w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
                            this.eOE.bw("contact_info_trademark", true);
                            if (this.dKP != null) {
                            }
                            this.eOE.bw("contact_info_privilege", true);
                            indexOf = this.eOE.indexOf("contact_info_category2");
                            if (indexOf >= 0) {
                            }
                            x.d("MicroMsg.ContactWidgetBizInfo", "pos no more");
                            if (this.lVJ) {
                            }
                            this.eOE.bw("contact_info_verifyuser_weibo", true);
                            if (this.dKP != null) {
                            }
                            this.eOE.bw("contact_info_reputation", true);
                            this.eOE.bw("contact_info_guarantee_info", true);
                            this.eOE.bw("contact_info_scope_of_business", true);
                            if (this.lVH != null) {
                            }
                            this.eOE.bw("contact_info_bindwxainfo", true);
                            string = this.bGc.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID");
                            x.d("MicroMsg.ContactWidgetBizInfo", "updateKF %s, %b", new Object[]{string, Boolean.valueOf(this.lVO)});
                            if (this.lVO) {
                                this.lVN = string;
                                g kR2;
                                IconWidgetPreference iconWidgetPreference2;
                                if (this.dKP == null || !this.dKP.MA() || this.guS == null) {
                                    this.eOE.bw("contact_info_kf_worker", true);
                                } else if (bi.oW(string)) {
                                    kR2 = z.MX().kR(this.guS.field_username);
                                    if (kR2 == null) {
                                        this.eOE.bw("contact_info_kf_worker", true);
                                        z.MZ().a(this);
                                        z.MZ().ag(this.guS.field_username, com.tencent.mm.model.q.GF());
                                        this.lVO = true;
                                    } else {
                                        x.d("MicroMsg.ContactWidgetBizInfo", "has default kf %s", new Object[]{kR2.field_openId});
                                        this.eOE.bw("contact_info_kf_worker", false);
                                        iconWidgetPreference2 = (IconWidgetPreference) this.eOE.ZZ("contact_info_kf_worker");
                                        iconWidgetPreference2.setSummary(kR2.field_nickname);
                                        e2 = com.tencent.mm.aa.c.a(kR2.field_openId, false, -1);
                                        if (e2 == null) {
                                            c(kR2);
                                            JF(kR2.field_openId);
                                        } else {
                                            iconWidgetPreference2.C(e2);
                                        }
                                    }
                                } else {
                                    com.tencent.mm.ac.i MX2 = z.MX();
                                    g kQ2 = MX2.kQ(string);
                                    if (kQ2 == null || com.tencent.mm.ac.i.a(kQ2)) {
                                        z.MZ().a(this);
                                        z.MZ().ah(this.guS.field_username, string);
                                        this.lVO = true;
                                    }
                                    if (kQ2 == null) {
                                        x.d("MicroMsg.ContactWidgetBizInfo", "no such kf, get default kf");
                                        kR2 = MX2.kR(this.guS.field_username);
                                    } else {
                                        kR2 = kQ2;
                                    }
                                    if (kR2 == null) {
                                        this.eOE.bw("contact_info_kf_worker", true);
                                    } else {
                                        this.eOE.bw("contact_info_kf_worker", false);
                                        iconWidgetPreference2 = (IconWidgetPreference) this.eOE.ZZ("contact_info_kf_worker");
                                        iconWidgetPreference2.setSummary(kR2.field_nickname);
                                        e2 = com.tencent.mm.aa.c.a(kR2.field_openId, false, -1);
                                        if (e2 == null) {
                                            c(kR2);
                                            JF(kR2.field_openId);
                                        } else {
                                            iconWidgetPreference2.C(e2);
                                        }
                                        x.d("MicroMsg.ContactWidgetBizInfo", "kf worker %s, %s", new Object[]{kR2.field_openId, kR2.field_nickname});
                                    }
                                }
                            }
                            x.d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", new Object[]{Boolean.valueOf(this.bGc.getIntent().getBooleanExtra("KIsHardDevice", false))});
                            if (this.bGc.getIntent() == null) {
                            }
                            if (com.tencent.mm.l.a.gd(this.guS.field_type)) {
                                x.w("MicroMsg.ContactWidgetBizInfo", "%s is not my contact", new Object[]{this.guS.field_username});
                                bnq();
                                ZZ = this.eOE.ZZ("contact_info_biz_add");
                                if (ZZ != null && this.lVK) {
                                    ZZ.setTitle(R.l.contact_info_biz_join);
                                }
                                if (uK(this.eLK)) {
                                    if (dVar == null) {
                                        x.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
                                    } else {
                                        ((CheckBoxPreference) this.eOE.ZZ("contact_info_subscribe_bizinfo")).qpJ = dVar.LQ();
                                        this.eOE.bw("contact_info_subscribe_bizinfo", false);
                                    }
                                }
                                this.bGc.showOptionMenu(false);
                            }
                            if (dVar != null) {
                                checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("contact_info_subscribe_bizinfo");
                                checkBoxPreference2 = (CheckBoxPreference) this.eOE.ZZ("contact_info_locate");
                                if (dVar.Ma()) {
                                    checkBoxPreference.setTitle(R.l.enterprise_chat_receive_msg);
                                    this.lVG = z.Nc().cz(z.Nc().cA(dVar.field_username));
                                    if (this.lVG != null) {
                                        if (this.lVG.hu(4)) {
                                            z2 = false;
                                        } else {
                                            z2 = true;
                                        }
                                        checkBoxPreference.qpJ = z2;
                                    } else {
                                        x.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
                                    }
                                } else if (dVar.LY()) {
                                    checkBoxPreference.setTitle(R.l.enterprise_brand_receive_msg);
                                    checkBoxPreference.qpJ = !z.Nh().kr(dVar.field_username);
                                } else {
                                    checkBoxPreference.qpJ = dVar.LQ();
                                }
                                if (dVar.LQ()) {
                                    if (this.dKP == null && dVar != null) {
                                        this.dKP = dVar.bG(false);
                                    }
                                    if (this.dKP != null && this.dKP.Mk() && com.tencent.mm.bg.d.QS("brandservice")) {
                                        this.eOE.bw("contact_info_template_recv", false);
                                    } else {
                                        this.eOE.bw("contact_info_template_recv", true);
                                    }
                                } else {
                                    this.eOE.bw("contact_info_template_recv", true);
                                }
                                if (dVar.bG(false).LU()) {
                                    checkBoxPreference2.qpJ = dVar.LR();
                                } else {
                                    this.eOE.bw("contact_info_locate", true);
                                    checkBoxPreference2.qpJ = dVar.LR();
                                }
                            } else {
                                this.eOE.bw("contact_info_subscribe_bizinfo", true);
                                this.eOE.bw("contact_info_locate", true);
                                this.eOE.bw("contact_info_template_recv", true);
                            }
                            this.eOE.bw("contact_info_biz_read_msg_online", true);
                            this.eOE.bw("contact_info_biz_add", true);
                            BL = this.guS.BL();
                            if (BL != null) {
                                this.bGc.setMMTitle(BL);
                            }
                            if (s.hr(this.guS.field_username)) {
                                this.eOE.ZZ("contact_info_biz_go_chatting").setTitle(R.l.contact_info_send);
                                this.bGc.setMMTitle(R.l.contact_info_title);
                            }
                            if (!s.hM(this.guS.field_username) && this.lUs != null) {
                                this.bGc.addIconOptionMenu(0, R.g.mm_title_btn_menu, new 18(this));
                            }
                        }
                    }
                    keyValuePreference.setSummary(charSequence);
                } else {
                    x.e("MicroMsg.ContactWidgetBizInfo", "[arthurdan.emojiSpan] Notice!!!! extInfo.verifyInfo.verifySourceDescription is null");
                }
            } else {
                this.eOE.bw("contact_info_verifyuser", true);
            }
        } else if (this.dKP == null || this.dKP.Mu() == null || bi.oW(this.dKP.Mu().dLS)) {
            x.w("MicroMsg.ContactWidgetBizInfo", "has not verify info");
            this.eOE.bw("contact_info_verifyuser", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.eOE.ZZ("contact_info_verifyuser");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(this.dKP.Mu().dLS);
            }
        }
        if (this.dKP != null || bi.oW(this.dKP.Mn())) {
            x.w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
            this.eOE.bw("contact_info_trademark", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.eOE.ZZ("contact_info_trademark");
            if (keyValuePreference != null) {
                keyValuePreference.csl();
                keyValuePreference.tCA = false;
                if (am.a.dBt != null) {
                    e = com.tencent.mm.sdk.platformtools.c.CV(R.k.biz_info_trademark_protection);
                } else {
                    e = null;
                }
                str = "MicroMsg.ContactWidgetBizInfo";
                str2 = "trademark bmp is null ? %B";
                objArr = new Object[1];
                if (e == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[0] = Boolean.valueOf(z2);
                x.i(str, str2, objArr);
                if (e != null) {
                    bitmapDrawable = new BitmapDrawable(this.bGc.getResources(), e);
                } else {
                    bitmapDrawable = null;
                }
                keyValuePreference.tCI = bitmapDrawable;
                keyValuePreference.setSummary(this.dKP.Mn());
                x.d("MicroMsg.ContactWidgetBizInfo", "trademark name : %s, url : %s.", new Object[]{this.dKP.Mn(), this.dKP.Mm()});
            }
        }
        if (this.dKP != null || this.dKP.Mp() == null || this.dKP.Mp().size() <= 0) {
            this.eOE.bw("contact_info_privilege", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.eOE.ZZ("contact_info_privilege");
            keyValuePreference.csl();
            keyValuePreference.lO(false);
            keyValuePreference.csk();
            for (b.f fVar2 : this.dKP.Mp()) {
                LinearLayout linearLayout = (LinearLayout) View.inflate(this.bGc, R.i.keyvalue_pref_item, null);
                ((ImageView) linearLayout.findViewById(R.h.image_iv)).setImageDrawable(new com.tencent.mm.plugin.profile.ui.b.a(this.bGc.getResources(), fVar2.iconUrl));
                CharSequence charSequence2 = fVar2.description;
                identifier = this.bGc.getResources().getIdentifier(fVar2.dLR, "string", this.bGc.getPackageName());
                if (identifier > 0) {
                    charSequence2 = this.bGc.getString(identifier);
                }
                ((TextView) linearLayout.findViewById(R.h.summary)).setText(charSequence2);
                keyValuePreference.dp(linearLayout);
            }
        }
        indexOf = this.eOE.indexOf("contact_info_category2");
        if (indexOf >= 0 || this.dKO == null || this.dKO.size() <= 0) {
            x.d("MicroMsg.ContactWidgetBizInfo", "pos no more");
        } else {
            int size = this.dKO.size() - 1;
            while (size >= 0) {
                if (this.dKO.get(size) != null && ((!this.bGc.getString(R.l.contact_info_biz_participants).equals(((d.a) this.dKO.get(size)).title) || this.dKW) && !(bi.oW(((d.a) this.dKO.get(size)).title) && bi.oW(((d.a) this.dKO.get(size)).dKS)))) {
                    Preference preference = new Preference(this.bGc);
                    preference.setKey("contact_info_bizinfo_external#" + size);
                    charSequence = ((d.a) this.dKO.get(size)).title;
                    int identifier2 = this.bGc.getResources().getIdentifier(((d.a) this.dKO.get(size)).dKS, "string", this.bGc.getPackageName());
                    if (identifier2 > 0) {
                        charSequence = this.bGc.getString(identifier2);
                    }
                    if (this.lUs.LX() && ("__mp_wording__brandinfo_history_massmsg".equals(((d.a) this.dKO.get(size)).dKS) || r1.equals(this.bGc.getString(R.l.__mp_wording__brandinfo_history_massmsg)))) {
                        charSequence = this.bGc.getString(R.l.enterprise_brand_history);
                    }
                    preference.setTitle(charSequence);
                    if (!bi.oW(((d.a) this.dKO.get(size)).description)) {
                        preference.setSummary(((d.a) this.dKO.get(size)).description);
                    }
                    if (bi.oV(((d.a) this.dKO.get(size)).dKS).equals("__mp_wording__brandinfo_feedback")) {
                        identifier2 = this.eOE.indexOf("contact_info_scope_of_business");
                        if (identifier2 > 0) {
                            identifier = identifier2 + 1;
                            this.eOE.a(preference, identifier);
                            if (bi.oV(((d.a) this.dKO.get(size)).dKS).equals("__mp_wording__brandinfo_biz_detail")) {
                                this.eOE.a(new PreferenceSmallCategory(this.bGc), identifier);
                            }
                        }
                    }
                    identifier = indexOf;
                    this.eOE.a(preference, identifier);
                    if (bi.oV(((d.a) this.dKO.get(size)).dKS).equals("__mp_wording__brandinfo_biz_detail")) {
                        this.eOE.a(new PreferenceSmallCategory(this.bGc), identifier);
                    }
                }
                size--;
            }
        }
        if (this.lVJ || !s.v(this.guS) || this.guS.csO == null || this.guS.csO.equals("")) {
            this.eOE.bw("contact_info_verifyuser_weibo", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.eOE.ZZ("contact_info_verifyuser_weibo");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(bi.aG(this.guS.field_weiboNickname, "") + this.bGc.getString(R.l.settings_show_weibo_field, new Object[]{s.hV(this.guS.csO)}));
                keyValuePreference.hIZ = com.tencent.mm.bp.a.g(this.bGc, R.e.link_color);
                keyValuePreference.lO(false);
            }
        }
        if (this.dKP != null || this.dKP.Mr() == null) {
            this.eOE.bw("contact_info_reputation", true);
            this.eOE.bw("contact_info_guarantee_info", true);
            this.eOE.bw("contact_info_scope_of_business", true);
        } else {
            BizInfoPayInfoIconPreference bizInfoPayInfoIconPreference = (BizInfoPayInfoIconPreference) this.eOE.ZZ("contact_info_reputation");
            if (this.dKP.Mr().dLN > 0) {
                bizInfoPayInfoIconPreference.uD(this.dKP.Mr().dLN);
            } else {
                this.eOE.bw("contact_info_reputation", true);
            }
            bizInfoPayInfoIconPreference = (BizInfoPayInfoIconPreference) this.eOE.ZZ("contact_info_guarantee_info");
            if (this.dKP.Mr().dLP == null || this.dKP.Mr().dLP.size() <= 0) {
                this.eOE.bw("contact_info_guarantee_info", true);
            } else {
                bizInfoPayInfoIconPreference.bH(this.dKP.Mr().dLP);
            }
            keyValuePreference = (KeyValuePreference) this.eOE.ZZ("contact_info_scope_of_business");
            if (bi.oW(this.dKP.Mr().dLO)) {
                this.eOE.bw("contact_info_scope_of_business", true);
            } else {
                keyValuePreference.setSummary(this.dKP.Mr().dLO);
                keyValuePreference.tCG = 4;
                keyValuePreference.lO(false);
            }
        }
        if (this.lVH != null || this.lVH.size() <= 0) {
            this.eOE.bw("contact_info_bindwxainfo", true);
        } else {
            this.eOE.bw("contact_info_bindwxainfo", false);
            BizBindWxaInfoPreference bizBindWxaInfoPreference = (BizBindWxaInfoPreference) this.eOE.ZZ("contact_info_bindwxainfo");
            d dVar2 = this.lUs;
            Collection collection = this.lVH;
            bizBindWxaInfoPreference.lUg = true;
            bizBindWxaInfoPreference.eXL = dVar2;
            if (bizBindWxaInfoPreference.gEP == null) {
                bizBindWxaInfoPreference.gEP = new LinkedList();
            } else {
                bizBindWxaInfoPreference.gEP.clear();
            }
            if (!(collection == null || collection.isEmpty())) {
                bizBindWxaInfoPreference.gEP.addAll(collection);
            }
            bizBindWxaInfoPreference.aeP();
        }
        string = this.bGc.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID");
        x.d("MicroMsg.ContactWidgetBizInfo", "updateKF %s, %b", new Object[]{string, Boolean.valueOf(this.lVO)});
        if (this.lVO) {
            this.lVN = string;
            g kR22;
            IconWidgetPreference iconWidgetPreference22;
            if (this.dKP == null || !this.dKP.MA() || this.guS == null) {
                this.eOE.bw("contact_info_kf_worker", true);
            } else if (bi.oW(string)) {
                kR22 = z.MX().kR(this.guS.field_username);
                if (kR22 == null) {
                    this.eOE.bw("contact_info_kf_worker", true);
                    z.MZ().a(this);
                    z.MZ().ag(this.guS.field_username, com.tencent.mm.model.q.GF());
                    this.lVO = true;
                } else {
                    x.d("MicroMsg.ContactWidgetBizInfo", "has default kf %s", new Object[]{kR22.field_openId});
                    this.eOE.bw("contact_info_kf_worker", false);
                    iconWidgetPreference22 = (IconWidgetPreference) this.eOE.ZZ("contact_info_kf_worker");
                    iconWidgetPreference22.setSummary(kR22.field_nickname);
                    e2 = com.tencent.mm.aa.c.a(kR22.field_openId, false, -1);
                    if (e2 == null) {
                        c(kR22);
                        JF(kR22.field_openId);
                    } else {
                        iconWidgetPreference22.C(e2);
                    }
                }
            } else {
                com.tencent.mm.ac.i MX22 = z.MX();
                g kQ22 = MX22.kQ(string);
                if (kQ22 == null || com.tencent.mm.ac.i.a(kQ22)) {
                    z.MZ().a(this);
                    z.MZ().ah(this.guS.field_username, string);
                    this.lVO = true;
                }
                if (kQ22 == null) {
                    x.d("MicroMsg.ContactWidgetBizInfo", "no such kf, get default kf");
                    kR22 = MX22.kR(this.guS.field_username);
                } else {
                    kR22 = kQ22;
                }
                if (kR22 == null) {
                    this.eOE.bw("contact_info_kf_worker", true);
                } else {
                    this.eOE.bw("contact_info_kf_worker", false);
                    iconWidgetPreference22 = (IconWidgetPreference) this.eOE.ZZ("contact_info_kf_worker");
                    iconWidgetPreference22.setSummary(kR22.field_nickname);
                    e2 = com.tencent.mm.aa.c.a(kR22.field_openId, false, -1);
                    if (e2 == null) {
                        c(kR22);
                        JF(kR22.field_openId);
                    } else {
                        iconWidgetPreference22.C(e2);
                    }
                    x.d("MicroMsg.ContactWidgetBizInfo", "kf worker %s, %s", new Object[]{kR22.field_openId, kR22.field_nickname});
                }
            }
        }
        x.d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", new Object[]{Boolean.valueOf(this.bGc.getIntent().getBooleanExtra("KIsHardDevice", false))});
        if (this.bGc.getIntent() == null && this.bGc.getIntent().getBooleanExtra("KIsHardDevice", false)) {
            x.d("MicroMsg.ContactWidgetBizInfo", "Hard device biz...");
            z = bns();
            x.d("MicroMsg.ContactWidgetBizInfo", "contact.isContact()(%b), isHardDeviceBound(%b)", new Object[]{Boolean.valueOf(com.tencent.mm.l.a.gd(this.guS.field_type)), Boolean.valueOf(z)});
            if (com.tencent.mm.l.a.gd(this.guS.field_type) && z) {
                if (dVar != null) {
                    checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("contact_info_subscribe_bizinfo");
                    checkBoxPreference2 = (CheckBoxPreference) this.eOE.ZZ("contact_info_locate");
                    if (dVar.Ma()) {
                        this.lVG = z.Nc().cz(z.Nc().cA(dVar.field_username));
                        if (this.lVG != null) {
                            checkBoxPreference.qpJ = !this.lVG.hu(4);
                        } else {
                            x.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
                        }
                    } else {
                        checkBoxPreference.qpJ = dVar.LQ();
                    }
                    if (dVar.LQ()) {
                        if (this.dKP == null && dVar != null) {
                            this.dKP = dVar.bG(false);
                        }
                        if (this.dKP != null && this.dKP.Mk() && com.tencent.mm.bg.d.QS("brandservice")) {
                            this.eOE.bw("contact_info_template_recv", false);
                        } else {
                            this.eOE.bw("contact_info_template_recv", true);
                        }
                    } else {
                        this.eOE.bw("contact_info_template_recv", true);
                    }
                    if (dVar.bG(false).LU()) {
                        checkBoxPreference2.qpJ = dVar.LR();
                    } else {
                        this.eOE.bw("contact_info_locate", true);
                        checkBoxPreference2.qpJ = dVar.LR();
                    }
                } else {
                    this.eOE.bw("contact_info_subscribe_bizinfo", true);
                    this.eOE.bw("contact_info_locate", true);
                    this.eOE.bw("contact_info_template_recv", true);
                }
                this.eOE.bw("contact_info_biz_read_msg_online", true);
                this.eOE.bw("contact_info_biz_add", true);
                BL = this.guS.BL();
                if (BL != null) {
                    this.bGc.setMMTitle(BL);
                }
                if (s.hr(this.guS.field_username)) {
                    this.eOE.ZZ("contact_info_biz_go_chatting").setTitle(R.l.contact_info_send);
                    this.bGc.setMMTitle(R.l.contact_info_title);
                }
                if (!s.hM(this.guS.field_username) && this.lUs != null && !this.lUs.LZ()) {
                    this.bGc.addIconOptionMenu(0, R.g.mm_title_btn_menu, new 17(this));
                    return;
                }
                return;
            }
            x.w("MicroMsg.ContactWidgetBizInfo", "%s is not my hard biz contact", new Object[]{this.guS.field_username});
            bnq();
            Preference ZZ2 = this.eOE.ZZ("contact_info_biz_add");
            x.d("MicroMsg.ContactWidgetBizInfo", "isBizConferenceAccount(%b)", new Object[]{Boolean.valueOf(this.lVK)});
            if (ZZ2 != null) {
                if (z) {
                    ZZ2.setTitle(R.l.contact_info_biz_join);
                } else {
                    ZZ2.setTitle(R.l.contact_info_biz_bind_exdevice);
                }
            }
            if (uK(this.eLK)) {
                if (dVar == null) {
                    x.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
                } else {
                    ((CheckBoxPreference) this.eOE.ZZ("contact_info_subscribe_bizinfo")).qpJ = dVar.LQ();
                    this.eOE.bw("contact_info_subscribe_bizinfo", false);
                }
            }
            this.bGc.showOptionMenu(false);
        } else if (com.tencent.mm.l.a.gd(this.guS.field_type)) {
            if (dVar != null) {
                checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("contact_info_subscribe_bizinfo");
                checkBoxPreference2 = (CheckBoxPreference) this.eOE.ZZ("contact_info_locate");
                if (dVar.Ma()) {
                    checkBoxPreference.setTitle(R.l.enterprise_chat_receive_msg);
                    this.lVG = z.Nc().cz(z.Nc().cA(dVar.field_username));
                    if (this.lVG != null) {
                        if (this.lVG.hu(4)) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        checkBoxPreference.qpJ = z2;
                    } else {
                        x.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
                    }
                } else if (dVar.LY()) {
                    checkBoxPreference.setTitle(R.l.enterprise_brand_receive_msg);
                    checkBoxPreference.qpJ = !z.Nh().kr(dVar.field_username);
                } else {
                    checkBoxPreference.qpJ = dVar.LQ();
                }
                if (dVar.LQ()) {
                    if (this.dKP == null && dVar != null) {
                        this.dKP = dVar.bG(false);
                    }
                    if (this.dKP != null && this.dKP.Mk() && com.tencent.mm.bg.d.QS("brandservice")) {
                        this.eOE.bw("contact_info_template_recv", false);
                    } else {
                        this.eOE.bw("contact_info_template_recv", true);
                    }
                } else {
                    this.eOE.bw("contact_info_template_recv", true);
                }
                if (dVar.bG(false).LU()) {
                    checkBoxPreference2.qpJ = dVar.LR();
                } else {
                    this.eOE.bw("contact_info_locate", true);
                    checkBoxPreference2.qpJ = dVar.LR();
                }
            } else {
                this.eOE.bw("contact_info_subscribe_bizinfo", true);
                this.eOE.bw("contact_info_locate", true);
                this.eOE.bw("contact_info_template_recv", true);
            }
            this.eOE.bw("contact_info_biz_read_msg_online", true);
            this.eOE.bw("contact_info_biz_add", true);
            BL = this.guS.BL();
            if (BL != null) {
                this.bGc.setMMTitle(BL);
            }
            if (s.hr(this.guS.field_username)) {
                this.eOE.ZZ("contact_info_biz_go_chatting").setTitle(R.l.contact_info_send);
                this.bGc.setMMTitle(R.l.contact_info_title);
            }
            if (!s.hM(this.guS.field_username) && this.lUs != null) {
                this.bGc.addIconOptionMenu(0, R.g.mm_title_btn_menu, new 18(this));
            }
        } else {
            x.w("MicroMsg.ContactWidgetBizInfo", "%s is not my contact", new Object[]{this.guS.field_username});
            bnq();
            ZZ = this.eOE.ZZ("contact_info_biz_add");
            if (ZZ != null && this.lVK) {
                ZZ.setTitle(R.l.contact_info_biz_join);
            }
            if (uK(this.eLK)) {
                if (dVar == null) {
                    x.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
                } else {
                    ((CheckBoxPreference) this.eOE.ZZ("contact_info_subscribe_bizinfo")).qpJ = dVar.LQ();
                    this.eOE.bw("contact_info_subscribe_bizinfo", false);
                }
            }
            this.bGc.showOptionMenu(false);
        }
    }

    private void bnq() {
        if (this.guS == null || !com.tencent.mm.l.a.gd(this.guS.field_type) || s.hr(this.guS.field_username) || s.hW(this.guS.field_username)) {
            this.eOE.bw("contact_is_mute", true);
            if (this.guS == null || com.tencent.mm.l.a.gd(this.guS.field_type) || !uK(this.eLK)) {
                this.eOE.bw("contact_info_expose_btn", true);
            } else {
                this.eOE.bw("contact_info_expose_btn", false);
            }
        } else {
            this.eOE.bw("contact_is_mute", false);
        }
        this.eOE.bw("contact_info_verifyuser_weibo", true);
        this.eOE.bw("contact_info_subscribe_bizinfo", true);
        this.eOE.bw("contact_info_template_recv", true);
        this.eOE.bw("contact_info_locate", true);
        if (this.lVJ) {
            this.eOE.bw("contact_info_biz_add", true);
        } else {
            this.eOE.bw("contact_info_time_expired", true);
        }
        if (this.guS == null || !((s.hM(this.guS.field_username) || s.hW(this.guS.field_username)) && com.tencent.mm.l.a.gd(this.guS.field_type))) {
            this.eOE.bw("contact_info_biz_go_chatting", true);
        } else {
            this.eOE.bw("contact_info_biz_go_chatting", false);
        }
        if (s.hW(this.guS.field_username)) {
            this.eOE.bw("contact_info_user_desc", true);
        }
    }

    public final boolean auw() {
        BizInfoHeaderPreference bizInfoHeaderPreference = (BizInfoHeaderPreference) this.eOE.ZZ("contact_info_header_bizinfo");
        if (bizInfoHeaderPreference != null) {
            bizInfoHeaderPreference.onDetach();
        }
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        if (this.bGc == null) {
            x.e("MicroMsg.ContactWidgetBizInfo", "null == context");
            return;
        }
        x.i("MicroMsg.ContactWidgetBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("be_send_card_name");
                    String stringExtra2 = intent.getStringExtra("received_card_name");
                    boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                    String stringExtra3 = intent.getStringExtra("custom_send_text");
                    com.tencent.mm.plugin.messenger.a.g.bcT().l(stringExtra, stringExtra2, booleanExtra);
                    com.tencent.mm.plugin.messenger.a.g.bcT().dF(stringExtra3, stringExtra2);
                    com.tencent.mm.ui.widget.snackbar.b.h(this.bGc, this.bGc.getString(R.l.finish_sent));
                    return;
                }
                return;
            default:
                return;
        }
    }

    private static boolean JE(String str) {
        try {
            long j = bi.getLong(str, 0);
            if (j <= 0 || j - (System.currentTimeMillis() / 1000) >= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    final void ay(int i, String str) {
        if (this.lVQ == null || !(this.eLK == 39 || this.eLK == 56 || this.eLK == 35 || this.eLK == 87 || this.eLK == 88 || this.eLK == 89 || this.eLK == 85)) {
            x.d("MicroMsg.ContactWidgetBizInfo", "mExtArgs is null or the add contact action is not from biz search.");
        } else if (this.guS == null) {
            x.i("MicroMsg.ContactWidgetBizInfo", "contact is null.");
        } else {
            int i2;
            String string = this.lVQ.getString("Contact_Ext_Args_Search_Id");
            String oV = bi.oV(this.lVQ.getString("Contact_Ext_Args_Query_String"));
            int i3 = this.lVQ.getInt("Contact_Ext_Args_Index");
            switch (this.eLK) {
                case a$k.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                    i2 = 1;
                    break;
                case a$k.AppCompatTheme_colorControlNormal /*85*/:
                    i2 = 5;
                    break;
                case a$k.AppCompatTheme_colorControlHighlight /*87*/:
                    i2 = 2;
                    break;
                case a$k.AppCompatTheme_colorButtonNormal /*88*/:
                    i2 = 3;
                    break;
                case a$k.AppCompatTheme_colorSwitchThumbNormal /*89*/:
                    i2 = 4;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            String oV2 = bi.oV(this.lVQ.getString("Contact_Ext_Extra_Params"));
            String str2 = oV + "," + i + "," + bi.oV(this.guS.field_username) + "," + i3 + "," + (System.currentTimeMillis() / 1000) + "," + string + "," + i2;
            if (bi.oW(str)) {
                str2 = str2 + ",," + oV2;
            } else {
                str2 = str2 + "," + str + "," + oV2;
            }
            x.v("MicroMsg.ContactWidgetBizInfo", "report 10866: %s", new Object[]{str2});
            h.mEJ.k(10866, str2);
        }
    }

    final void bnr() {
        if (this.bGc.getIntent() != null && this.bGc.getIntent().getBooleanExtra("KIsHardDevice", false)) {
            String stringExtra = this.bGc.getIntent().getStringExtra("KHardDeviceBindTicket");
            if (bi.oW(stringExtra)) {
                x.i("MicroMsg.ContactWidgetBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
            } else if (!bns()) {
                x.d("MicroMsg.ContactWidgetBizInfo", "IsHardDevice, bindTicket = %s", new Object[]{stringExtra});
                au.DF().a(536, this);
                cv cvVar = new cv();
                cvVar.bKm.bKo = stringExtra;
                cvVar.bKm.opType = 1;
                com.tencent.mm.sdk.b.a.sFg.m(cvVar);
                l lVar = cvVar.bKn.bKq;
                MMActivity mMActivity = this.bGc;
                this.bGc.getString(R.l.app_tip);
                this.tipDialog = com.tencent.mm.ui.base.h.a(mMActivity, this.bGc.getString(R.l.app_waiting), true, new 5(this, lVar));
                return;
            }
        }
        com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.bGc, new 6(this));
        LinkedList linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(this.eLK));
        if (this.dKY != null) {
            aVar.qHZ = this.dKY;
        }
        if (!bi.oW(this.juZ)) {
            aVar.juZ = this.juZ;
        }
        aVar.qIf = true;
        aVar.a(this.guS.field_username, linkedList, this.lVS);
    }

    private boolean bns() {
        if (this.bGc.getIntent() == null) {
            return false;
        }
        String stringExtra = this.bGc.getIntent().getStringExtra("device_id");
        String stringExtra2 = this.bGc.getIntent().getStringExtra("device_type");
        cz czVar = new cz();
        czVar.bKx.byN = stringExtra;
        czVar.bKx.bKv = stringExtra2;
        com.tencent.mm.sdk.b.a.sFg.m(czVar);
        return czVar.bKy.bKz;
    }

    final void bnt() {
        if (this.guS != null && !bi.oW(this.guS.field_username)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect", new Object[]{this.guS.field_username}));
            intent.putExtra("showShare", false);
            com.tencent.mm.bg.d.b(this.bGc, "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    private void ha(boolean z) {
        if (this.guS != null) {
            if (this.bGc != null) {
                if (!z || com.tencent.mm.ac.f.eZ(this.guS.field_username)) {
                    this.bGc.setTitleMuteIconVisibility(8);
                } else {
                    this.bGc.setTitleMuteIconVisibility(0);
                }
            }
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("contact_is_mute");
            if (checkBoxPreference != null) {
                checkBoxPreference.qpJ = z;
            }
        }
    }

    private void JF(final String str) {
        ah.i(new Runnable() {
            public final void run() {
                if (c.this.eOE == null) {
                    x.w("MicroMsg.ContactWidgetBizInfo", "LazyGetAvatar screen is null");
                    return;
                }
                IconWidgetPreference iconWidgetPreference = (IconWidgetPreference) c.this.eOE.ZZ("contact_info_kf_worker");
                if (iconWidgetPreference != null && c.this.eOE != null) {
                    Bitmap a = com.tencent.mm.aa.c.a(str, false, -1);
                    if (a != null) {
                        x.d("MicroMsg.ContactWidgetBizInfo", "LazyGetAvatar success %s, update screen", new Object[]{str});
                        iconWidgetPreference.C(a);
                        c.this.eOE.notifyDataSetChanged();
                    }
                }
            }
        }, 2000);
    }

    private static void c(g gVar) {
        long currentTimeMillis = System.currentTimeMillis();
        k KH = q.KH();
        if (KH.kc(gVar.field_openId) == null) {
            com.tencent.mm.aa.j jVar = new com.tencent.mm.aa.j();
            jVar.username = gVar.field_openId;
            jVar.dHQ = gVar.field_headImgUrl;
            jVar.by(false);
            jVar.csA = 3;
            KH.a(jVar);
        }
        q.KJ().jP(gVar.field_openId);
        x.d("MicroMsg.ContactWidgetBizInfo", "downloadKFAvatar, %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public final void a(int i, int i2, String str, l lVar) {
        bls bls = null;
        x.d("MicroMsg.ContactWidgetBizInfo", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
        this.lVO = false;
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (lVar == null) {
            x.e("MicroMsg.ContactWidgetBizInfo", "scene == null");
            return;
        }
        au.DF().b(lVar.getType(), this);
        if (i == 0 && i2 == 0) {
            x.d("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", new Object[]{Integer.valueOf(lVar.getType())});
            if (lVar.getType() == 536) {
                au.DF().b(536, this);
                bnp();
                return;
            } else if (lVar.getType() == 1363) {
                blt blt;
                com.tencent.mm.plugin.profile.a.b bVar = (com.tencent.mm.plugin.profile.a.b) lVar;
                if (bVar.diG == null || bVar.diG.dIE.dIL == null) {
                    blt = null;
                } else {
                    blt = (blt) bVar.diG.dIE.dIL;
                }
                com.tencent.mm.plugin.profile.a.b bVar2 = (com.tencent.mm.plugin.profile.a.b) lVar;
                if (!(bVar2.diG == null || bVar2.diG.dID.dIL == null)) {
                    bls = (bls) bVar2.diG.dID.dIL;
                }
                if (blt == null || blt.riQ == null || blt.riQ.ret != 0 || blt.riN == null || bi.oW(blt.riN.riL)) {
                    if (blt == null || blt.riQ == null) {
                        x.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:resp == null");
                        return;
                    }
                    x.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:code:%s", new Object[]{Integer.valueOf(blt.riQ.ret)});
                    return;
                } else if (blt.riN == null) {
                    x.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd resp.user == null");
                    return;
                } else {
                    j cz = z.Nc().cz(blt.riN.riL);
                    if (cz == null) {
                        cz = new j();
                        cz.field_userId = blt.riN.riL;
                    }
                    cz.field_userName = blt.riN.hyG;
                    cz.field_brandUserName = bls.riK;
                    cz.field_UserVersion = blt.riN.ver;
                    cz.field_headImageUrl = blt.riN.riF;
                    cz.field_profileUrl = blt.riN.riT;
                    cz.field_bitFlag = blt.riN.riG;
                    cz.field_addMemberUrl = blt.riN.riJ;
                    cz.field_needToUpdate = false;
                    if (!z.Nc().b(cz)) {
                        z.Nc().a(cz);
                        return;
                    }
                    return;
                }
            } else if (lVar.getType() == 1394) {
                brs bnl = ((com.tencent.mm.plugin.profile.a.c) lVar).bnl();
                brt bnk = ((com.tencent.mm.plugin.profile.a.c) lVar).bnk();
                if (bnk != null && bnk.riQ != null && bnk.riQ.ret == 0) {
                    boolean z;
                    if (bnl.spC) {
                        z = false;
                    } else {
                        z = true;
                    }
                    d dVar;
                    if (z) {
                        ai aiVar;
                        dVar = this.lUs;
                        dVar.field_brandFlag &= -2;
                        a(dVar, true);
                        au.HU();
                        if (com.tencent.mm.model.c.FW().Yq(dVar.field_username) == null) {
                            aiVar = new ai(dVar.field_username);
                            aiVar.ef(bi.oV(this.lUs.Mg()));
                            au.HU();
                            bd GE = com.tencent.mm.model.c.FT().GE(dVar.field_username);
                            if (GE != null) {
                                au.HU();
                                com.tencent.mm.model.c.FW().d(aiVar);
                                au.HU();
                                com.tencent.mm.model.c.FW().ak(GE);
                            } else {
                                aiVar.clx();
                                au.HU();
                                com.tencent.mm.model.c.FW().d(aiVar);
                            }
                        }
                        au.HU();
                        if (com.tencent.mm.model.c.FW().Yq(dVar.field_enterpriseFather) == null) {
                            aiVar = new ai(dVar.field_enterpriseFather);
                            aiVar.clx();
                            au.HU();
                            com.tencent.mm.model.c.FW().d(aiVar);
                            return;
                        }
                        au.HU();
                        com.tencent.mm.model.c.FV().XJ(dVar.field_enterpriseFather);
                        return;
                    }
                    dVar = this.lUs;
                    dVar.field_brandFlag |= 1;
                    a(dVar, true);
                    au.HU();
                    com.tencent.mm.model.c.FW().Yp(dVar.field_username);
                    au.HU();
                    if (com.tencent.mm.model.c.FW().YC(dVar.field_enterpriseFather) <= 0) {
                        au.HU();
                        com.tencent.mm.model.c.FW().Yp(dVar.field_enterpriseFather);
                        return;
                    }
                    au.HU();
                    com.tencent.mm.model.c.FV().XJ(dVar.field_enterpriseFather);
                    return;
                } else if (bnk == null || bnk.riQ == null) {
                    x.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[]{Integer.valueOf(lVar.getType())});
                    return;
                } else {
                    x.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(bnk.riQ.ret)});
                    return;
                }
            } else if (lVar.getType() == 1343) {
                bnp();
                return;
            } else if (lVar.getType() == 1228) {
                bnp();
                return;
            } else {
                return;
            }
        }
        x.e("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", new Object[]{Integer.valueOf(lVar.getType())});
    }

    public final void d(LinkedList<cgc> linkedList) {
        z.MZ().b(this);
        if (this.eOE == null) {
            x.e("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, screen is null");
        } else if (this.guS == null) {
            x.e("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, contact is null");
        } else if (linkedList == null || linkedList.size() <= 0) {
            x.w("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, worker is null");
        } else {
            if (!bi.oW(this.lVN)) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    cgc cgc = (cgc) it.next();
                    if (cgc.sAB != null && cgc.sAB.equals(this.lVN)) {
                        this.eOE.bw("contact_info_kf_worker", false);
                        this.eOE.ZZ("contact_info_kf_worker").setSummary(cgc.rTW);
                        return;
                    }
                }
            }
            this.eOE.bw("contact_info_kf_worker", false);
            this.eOE.ZZ("contact_info_kf_worker").setSummary(((cgc) linkedList.get(0)).rTW);
        }
    }

    public final void a(int i, l lVar) {
        if (this.lUs != null && this.lUs.Ma() && lVar.getType() == 1354) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("contact_info_subscribe_bizinfo");
            this.lVG = z.Nc().cz(z.Nc().cA(this.lUs.field_username));
            if (this.lVG != null) {
                checkBoxPreference.qpJ = !this.lVG.hu(4);
                this.eOE.notifyDataSetChanged();
                return;
            }
            x.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null after GetBizChatMyUserInfo");
        }
    }

    public final String MQ() {
        return "MicroMsg.ContactWidgetBizInfo";
    }

    private void bnu() {
        x.d("MicroMsg.ContactWidgetBizInfo", "updatePlaceTop");
        if (this.duR == null) {
            this.duR = this.bGc.getSharedPreferences(this.bGc.getPackageName() + "_preferences", 0);
        }
        if (this.hLs != null) {
            if (this.guS != null) {
                this.duR.edit().putBoolean("biz_placed_to_the_top", this.guS.BG()).commit();
            } else {
                this.duR.edit().putBoolean("biz_placed_to_the_top", false).commit();
            }
        }
        this.eOE.notifyDataSetChanged();
    }

    private static boolean uK(int i) {
        if (i == 81 || i == 92 || i == 93 || i == 94) {
            return true;
        }
        return false;
    }
}
