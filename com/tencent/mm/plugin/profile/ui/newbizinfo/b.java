package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.aa.q;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.z;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.ng;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes$WxaEntryInfo;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.c;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.protocal.c.ig;
import com.tencent.mm.protocal.c.ih;
import com.tencent.mm.protocal.c.qt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class b implements e, a {
    public long cYb;
    private List<d.a> dKO;
    private com.tencent.mm.ac.d.b dKP;
    private String dKY;
    public int eLK;
    f eOE;
    public long endTime;
    public ab guS;
    public String juZ;
    private boolean lUD;
    private String lUI;
    public d lUs;
    public List<WxaAttributes$WxaEntryInfo> lVH;
    private qt lVI;
    private int lVM = 0;
    private Bundle lVQ;
    SnsAdClick lVR = null;
    private String lVS = null;
    ContactInfoUI lYs;
    public c lYt;
    private p tipDialog = null;

    public b(ContactInfoUI contactInfoUI, String str, qt qtVar) {
        this.lYs = contactInfoUI;
        this.lUI = str;
        this.lVI = qtVar;
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
        this.lVR = (SnsAdClick) this.lYs.getIntent().getParcelableExtra("KSnsAdTag");
        this.lVS = this.lYs.getIntent().getStringExtra("key_add_contact_report_info");
        this.lVM = this.lYs.getIntent().getIntExtra("add_more_friend_search_scene", 0);
        this.lVQ = this.lYs.getIntent().getBundleExtra("Contact_Ext_Args");
        this.lYs.setMMTitle("");
        this.lYs.nS(-16777216);
        s.cqp();
        this.lYs.lC(false);
        this.lYs.lF(-1);
        if (VERSION.SDK_INT >= 21) {
            com.tencent.mm.ui.statusbar.a.c(this.lYs.mController.tlX, this.lYs.getWindow().getStatusBarColor(), com.tencent.mm.ui.statusbar.d.c(this.lYs.getWindow()));
        }
        this.lYs.cqh();
        this.lYs.setBackBtn(new 1(this), R.k.actionbar_icon_dark_back);
        Drawable drawable = this.lYs.getResources().getDrawable(R.g.mm_title_btn_menu);
        drawable.setColorFilter(-16777216, Mode.SRC_ATOP);
        this.lYs.a(0, "", drawable, new 2(this));
        com.tencent.mm.plugin.profile.ui.newbizinfo.d.a bni = com.tencent.mm.plugin.profile.b.bni();
        String str = this.guS.field_username;
        c cVar = new c();
        cVar.field_username = str;
        if (bni.b(cVar, new String[]{"username"})) {
            x.i("MicroMsg.ProfileInfoStorage", "get username:%s", new Object[]{cVar.field_username});
        } else {
            x.e("MicroMsg.ProfileInfoStorage", "profileInfo is null");
            cVar = null;
        }
        this.lYt = cVar;
        bnp();
        String str2 = abVar.field_username;
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIF = 2656;
        aVar.uri = "/cgi-bin/mmbiz-bin/bizattr/bizprofile";
        aVar.dII = 0;
        aVar.dIJ = 0;
        ig igVar = new ig();
        igVar.riA = str2;
        aVar.dIG = igVar;
        aVar.dIH = new ih();
        v.a(aVar.KT(), new 4(this));
        str2 = this.lYs.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
        if (!bi.oW(str2)) {
            this.lYs.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
            h.a(this.lYs, str2, "", this.lYs.getString(R.l.app_ok), null);
        }
        if (abVar != null) {
            z.Nk().km(abVar.field_username);
        }
        if (this.guS == null || this.lUs == null || this.lYt == null) {
            x.w("MicroMsg.ContactWidgetNewBizInfo", "reportEnd fail, err");
        } else {
            this.cYb = System.currentTimeMillis();
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(this.guS.field_username, this.eLK, this.lUs.field_type, this.cYb);
        }
        return true;
    }

    final void bnp() {
        c cVar;
        auw();
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
            kH.field_type = kH.bG(false).Mw();
        }
        if (kH != null && kH.field_brandInfo == null && kH.field_extInfo == null && this.lVI != null) {
            kH.field_username = this.guS.field_username;
            kH.field_brandFlag = this.lVI.eJV;
            kH.field_brandIconURL = this.lVI.eJY;
            kH.field_brandInfo = this.lVI.eJX;
            kH.field_extInfo = this.lVI.eJW;
            kH.field_type = kH.bG(false).Mw();
        }
        if (kH != null) {
            this.lUs = kH;
            this.dKO = kH.Mh();
            this.dKP = kH.bG(false);
            this.lVH = this.dKP.getWxaEntryInfoList();
            if (this.dKP.Ml() != null && this.dKP.Ml().length() > 0) {
                this.dKY = this.dKP.Ml();
            }
        }
        this.eOE.removeAll();
        this.eOE.addPreferencesFromResource(R.o.contact_info_pref_newbizinfo);
        NewBizInfoHeaderPreference newBizInfoHeaderPreference = (NewBizInfoHeaderPreference) this.eOE.ZZ("contact_info_header_newbizinfo");
        if (newBizInfoHeaderPreference == null || bi.oW(this.guS.field_username)) {
            x.w("MicroMsg.ContactWidgetNewBizInfo", "head pref is null");
            this.eOE.bw("contact_info_header_bizinfo", true);
        } else {
            ab abVar = this.guS;
            String str = this.lUI;
            d dVar = this.lUs;
            newBizInfoHeaderPreference.onDetach();
            newBizInfoHeaderPreference.lUr = str;
            newBizInfoHeaderPreference.lUs = dVar;
            newBizInfoHeaderPreference.guS = abVar;
            au.HU();
            com.tencent.mm.model.c.FR().a(newBizInfoHeaderPreference);
            q.Kp().d(newBizInfoHeaderPreference);
            z.Ni().a(newBizInfoHeaderPreference);
            newBizInfoHeaderPreference.initView();
        }
        ((NewBizInfoDescPreference) this.eOE.ZZ("contact_info_desc_newbizinfo")).lYt = this.lYt;
        if (com.tencent.mm.l.a.gd(this.guS.field_type)) {
            this.eOE.bw("contact_info_biz_add", true);
            this.eOE.bw("contact_info_biz_go_chatting", false);
            if (com.tencent.mm.model.s.hr(this.guS.field_username)) {
                this.eOE.ZZ("contact_info_biz_go_chatting").setTitle(R.l.contact_info_send);
            }
        } else {
            this.eOE.bw("contact_info_biz_add", false);
            this.eOE.bw("contact_info_biz_go_chatting", true);
        }
        if (this.lYt == null || !awi()) {
            this.eOE.bw("contact_info_biz_loading", false);
            NewBizInfoLoadingPreference newBizInfoLoadingPreference = (NewBizInfoLoadingPreference) this.eOE.ZZ("contact_info_biz_loading");
            cVar = this.lYt;
            boolean bnJ = bnJ();
            newBizInfoLoadingPreference.lYt = cVar;
            newBizInfoLoadingPreference.lYG = bnJ;
            if (newBizInfoLoadingPreference.lYt != null && !newBizInfoLoadingPreference.lYt.awi()) {
                newBizInfoLoadingPreference.state = 2;
            } else if (newBizInfoLoadingPreference.lYG) {
                newBizInfoLoadingPreference.state = 3;
            } else if (newBizInfoLoadingPreference.lYt != null) {
                newBizInfoLoadingPreference.state = 0;
            } else {
                newBizInfoLoadingPreference.state = 1;
            }
            newBizInfoLoadingPreference.initView();
        } else {
            this.eOE.bw("contact_info_biz_loading", true);
        }
        if (!(this.lYt == null || awi() || com.tencent.mm.l.a.gd(this.guS.field_type))) {
            this.lYs.showOptionMenu(false);
        }
        if (this.lYt == null || !this.lYt.bnQ()) {
            this.eOE.bw("contact_info_service_newbizinfo", true);
        } else {
            this.eOE.bw("contact_info_service_newbizinfo", false);
            if (this.lYt != null) {
                NewBizInfoServicePreference newBizInfoServicePreference = (NewBizInfoServicePreference) this.eOE.ZZ("contact_info_service_newbizinfo");
                cVar = this.lYt;
                ab abVar2 = this.guS;
                if (cVar != null) {
                    newBizInfoServicePreference.guS = abVar2;
                    newBizInfoServicePreference.lYt = cVar;
                    newBizInfoServicePreference.lYV = NewBizInfoServicePreference.bI(cVar.bnN());
                    newBizInfoServicePreference.lYU = new NewBizInfoServicePreference.a(newBizInfoServicePreference.bGc, newBizInfoServicePreference.lYV, abVar2);
                    if (newBizInfoServicePreference.lYt != null && !newBizInfoServicePreference.lYt.awi()) {
                        newBizInfoServicePreference.state = 4;
                    } else if (!newBizInfoServicePreference.lYt.bnQ()) {
                        newBizInfoServicePreference.state = 0;
                    } else if (newBizInfoServicePreference.lYt != null && newBizInfoServicePreference.lYV != null && newBizInfoServicePreference.lYV.size() <= 0) {
                        newBizInfoServicePreference.state = 2;
                    } else if (!(newBizInfoServicePreference.lYt == null || newBizInfoServicePreference.lYV == null || newBizInfoServicePreference.lYt.bnN().size() <= 0)) {
                        newBizInfoServicePreference.state = 3;
                    }
                    newBizInfoServicePreference.initView();
                }
            }
        }
        if (this.lYt == null || !this.lYt.bnP()) {
            this.eOE.bw("contact_info_message_newbizinfo", true);
        } else {
            this.eOE.bw("contact_info_message_newbizinfo", false);
            NewBizInfoMessagePreference newBizInfoMessagePreference = (NewBizInfoMessagePreference) this.eOE.ZZ("contact_info_message_newbizinfo");
            cVar = this.lYt;
            if (cVar != null) {
                newBizInfoMessagePreference.lYt = cVar;
                newBizInfoMessagePreference.lYH = new NewBizInfoMessagePreference$a(newBizInfoMessagePreference.bGc, cVar.bnM());
                if (newBizInfoMessagePreference.lYt != null && !newBizInfoMessagePreference.lYt.awi()) {
                    newBizInfoMessagePreference.state = 4;
                } else if (!newBizInfoMessagePreference.lYt.bnP()) {
                    newBizInfoMessagePreference.state = 0;
                } else if (newBizInfoMessagePreference.lYt != null && newBizInfoMessagePreference.lYt.bnM().size() <= 0) {
                    newBizInfoMessagePreference.state = 2;
                } else if (newBizInfoMessagePreference.lYt != null && newBizInfoMessagePreference.lYt.bnM().size() > 0) {
                    newBizInfoMessagePreference.state = 3;
                }
                newBizInfoMessagePreference.initView();
            }
        }
        if (this.lYt == null || !this.lYt.bnO() || bnK() == null) {
            this.eOE.bw("contact_info_all_message_newbizinfo", true);
        } else {
            this.eOE.bw("contact_info_all_message_newbizinfo", false);
            ((NewBizInfoAllMessagePreference) this.eOE.ZZ("contact_info_all_message_newbizinfo")).lYt = this.lYt;
        }
        if (this.lYt == null || !awi() || this.lVH == null || this.lVH.size() <= 0) {
            this.eOE.bw("contact_info_new_bindwxainfo", true);
        } else {
            this.eOE.bw("contact_info_new_bindwxainfo", false);
            NewBizBindWxaInfoPreference newBizBindWxaInfoPreference = (NewBizBindWxaInfoPreference) this.eOE.ZZ("contact_info_new_bindwxainfo");
            d dVar2 = this.lUs;
            Collection collection = this.lVH;
            newBizBindWxaInfoPreference.lUs = dVar2;
            if (newBizBindWxaInfoPreference.gEP == null) {
                newBizBindWxaInfoPreference.gEP = new LinkedList();
            } else {
                newBizBindWxaInfoPreference.gEP.clear();
            }
            if (!(collection == null || collection.isEmpty())) {
                newBizBindWxaInfoPreference.gEP.addAll(collection);
            }
            newBizBindWxaInfoPreference.hy();
        }
        x.d("MicroMsg.ContactWidgetNewBizInfo", "KIsardDevice(%b)", new Object[]{Boolean.valueOf(this.lYs.getIntent().getBooleanExtra("KIsHardDevice", false))});
        if (this.lYs.getIntent() == null || !this.lYs.getIntent().getBooleanExtra("KIsHardDevice", false)) {
            if (com.tencent.mm.l.a.gd(this.guS.field_type)) {
                this.eOE.bw("contact_info_biz_add", true);
                if (com.tencent.mm.model.s.hr(this.guS.field_username)) {
                    this.eOE.ZZ("contact_info_biz_go_chatting").setTitle(R.l.contact_info_send);
                }
            } else {
                x.w("MicroMsg.ContactWidgetNewBizInfo", "%s is not my contact", new Object[]{this.guS.field_username});
                bnq();
                Preference ZZ = this.eOE.ZZ("contact_info_biz_add");
                if (ZZ != null) {
                    ZZ.setTitle(R.l.contact_info_biz_join);
                }
            }
            if (bnJ()) {
                this.eOE.bw("contact_info_biz_loading", false);
                this.eOE.bw("contact_info_biz_add", true);
                this.eOE.bw("contact_info_biz_go_chatting", true);
                this.eOE.bw("contact_info_message_newbizinfo", true);
                this.eOE.bw("contact_info_service_newbizinfo", true);
                this.eOE.bw("contact_info_all_message_newbizinfo", true);
                this.eOE.bw("contact_info_new_bindwxainfo", true);
                return;
            }
            return;
        }
        x.d("MicroMsg.ContactWidgetNewBizInfo", "Hard device biz...");
        boolean bns = bns();
        x.d("MicroMsg.ContactWidgetNewBizInfo", "contact.isContact()(%b), isHardDeviceBound(%b)", new Object[]{Boolean.valueOf(com.tencent.mm.l.a.gd(this.guS.field_type)), Boolean.valueOf(bns)});
        if (!com.tencent.mm.l.a.gd(this.guS.field_type) || !bns) {
            x.w("MicroMsg.ContactWidgetNewBizInfo", "%s is not my hard biz contact", new Object[]{this.guS.field_username});
            bnq();
            Preference ZZ2 = this.eOE.ZZ("contact_info_biz_add");
            this.eOE.bw("contact_info_biz_add", false);
            if (ZZ2 == null) {
                return;
            }
            if (bns) {
                ZZ2.setTitle(R.l.contact_info_biz_join);
            } else {
                ZZ2.setTitle(R.l.contact_info_biz_bind_exdevice);
            }
        }
    }

    final boolean awi() {
        return (this.lYt == null || !this.lYt.awi() || bnJ()) ? false : true;
    }

    private boolean bnJ() {
        boolean z = true;
        try {
            String Mo = this.dKP.Mo();
            if (bi.oW(Mo)) {
                return false;
            }
            long j = bi.getLong(Mo, 0);
            if (j <= 0 || j - (System.currentTimeMillis() / 1000) >= 0) {
                z = false;
            }
            x.d("MicroMsg.ContactWidgetNewBizInfo", "isBizAccountTimeExpired:%b", new Object[]{Boolean.valueOf(z)});
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    private void bnq() {
        if (this.guS == null || !((com.tencent.mm.model.s.hM(this.guS.field_username) || com.tencent.mm.model.s.hW(this.guS.field_username)) && com.tencent.mm.l.a.gd(this.guS.field_type))) {
            this.eOE.bw("contact_info_biz_go_chatting", true);
        } else {
            this.eOE.bw("contact_info_biz_go_chatting", false);
        }
    }

    private d.a bnK() {
        if (this.dKO == null || this.dKO.size() < 0) {
            x.w("MicroMsg.ContactWidgetNewBizInfo", "brandInfoList is null not show all message");
            return null;
        }
        for (d.a aVar : this.dKO) {
            if (aVar.dKS.equals("__mp_wording__brandinfo_history_massmsg")) {
                return aVar;
            }
        }
        x.w("MicroMsg.ContactWidgetNewBizInfo", "brandInfoList is null not show all message");
        return null;
    }

    public final boolean auw() {
        NewBizInfoHeaderPreference newBizInfoHeaderPreference = (NewBizInfoHeaderPreference) this.eOE.ZZ("contact_info_header_newbizinfo");
        if (newBizInfoHeaderPreference != null) {
            newBizInfoHeaderPreference.onDetach();
        }
        if (this.lYt != null) {
            boolean z;
            com.tencent.mm.plugin.profile.ui.newbizinfo.d.a bni = com.tencent.mm.plugin.profile.b.bni();
            c cVar = this.lYt;
            if (cVar == null) {
                x.e("MicroMsg.ProfileInfoStorage", "profileInfo is null, err");
                z = false;
            } else {
                c cVar2 = new c();
                cVar2.field_username = cVar.field_username;
                boolean b = bni.b(cVar2, new String[0]);
                x.i("MicroMsg.ProfileInfoStorage", "insertOrUpdate username:%s", new Object[]{cVar.field_username});
                z = b ? bni.c(cVar, new String[0]) : bni.b(cVar);
            }
            x.i("MicroMsg.ContactWidgetNewBizInfo", "username:%s insert db :%b", new Object[]{this.lYt.field_username, Boolean.valueOf(z)});
        }
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        if (this.lYs == null) {
            x.e("MicroMsg.ContactWidgetNewBizInfo", "null == context");
            return;
        }
        x.i("MicroMsg.ContactWidgetNewBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("be_send_card_name");
                    String stringExtra2 = intent.getStringExtra("received_card_name");
                    boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                    String stringExtra3 = intent.getStringExtra("custom_send_text");
                    g.bcT().l(stringExtra, stringExtra2, booleanExtra);
                    g.bcT().dF(stringExtra3, stringExtra2);
                    com.tencent.mm.ui.widget.snackbar.b.h(this.lYs, this.lYs.getString(R.l.finish_sent));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final boolean wX(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.ContactWidgetNewBizInfo", "handleEvent key is null, return");
            return false;
        }
        x.i("MicroMsg.ContactWidgetNewBizInfo", "handleEvent key:%s", new Object[]{str});
        if ("contact_info_biz_go_chatting".endsWith(str)) {
            if (this.lVR != null) {
                ng ngVar = new ng();
                this.lVR.egJ = 5;
                ngVar.bYk.bYl = this.lVR;
                com.tencent.mm.sdk.b.a.sFg.m(ngVar);
            }
            Intent intent;
            if (this.lUs == null || !(this.lUs.LY() || this.lUs.Ma())) {
                intent = new Intent();
                if (this.lYs.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
                    intent.setFlags(268435456);
                }
                if (this.lUD) {
                    intent.putExtra("Chat_User", this.guS.field_username);
                    intent.putExtra("Chat_Mode", 1);
                    this.lYs.setResult(-1, intent);
                } else {
                    intent.putExtra("Chat_User", this.guS.field_username);
                    intent.putExtra("Chat_Mode", 1);
                    intent.putExtra("finish_direct", true);
                    com.tencent.mm.plugin.profile.a.ezn.e(intent, this.lYs);
                }
            } else {
                intent = new Intent();
                if (this.lUs.Ma()) {
                    String Mg = this.lUs.Mg();
                    if (bi.oW(Mg)) {
                        x.w("MicroMsg.ContactWidgetNewBizInfo", "contact_info_biz_go_chatting fatherUserName is empty");
                        return false;
                    }
                    intent.putExtra("enterprise_biz_name", Mg);
                    intent.putExtra("enterprise_biz_display_name", r.gT(Mg));
                } else {
                    intent.putExtra("enterprise_biz_name", this.guS.field_username);
                    intent.putExtra("enterprise_biz_display_name", r.gT(this.guS.field_username));
                }
                intent.addFlags(67108864);
                com.tencent.mm.bg.d.e(this.lYs, ".ui.conversation.EnterpriseConversationUI", intent);
                this.lYs.finish();
            }
            ay(5, null);
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bT(this.guS.field_username, TbsListener$ErrorCode.ERROR_CODE_LOAD_BASE);
            return true;
        } else if ("contact_info_biz_add".endsWith(str)) {
            if (com.tencent.mm.model.gdpr.c.Jm()) {
                com.tencent.mm.model.gdpr.c.a(this.lYs, com.tencent.mm.model.gdpr.a.dEc, this.guS.field_username, new 5(this));
            } else {
                bnr();
            }
            if (this.lVM != 0) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(11263, new Object[]{Integer.valueOf(this.lVM), this.guS.field_username});
            }
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bT(this.guS.field_username, 200);
            return true;
        } else if (!"contact_info_all_message_newbizinfo".endsWith(str)) {
            return true;
        } else {
            d.a bnK = bnK();
            String str2 = bnK.url;
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", str2);
            intent2.putExtra("useJs", true);
            intent2.putExtra("vertical_scroll", true);
            intent2.putExtra("geta8key_scene", 3);
            intent2.putExtra("KPublisherId", "brand_profile");
            intent2.putExtra("prePublishId", "brand_profile");
            if ((this.lVQ != null && (this.eLK == 39 || this.eLK == 56 || this.eLK == 35)) || this.eLK == 87 || this.eLK == 89 || this.eLK == 85 || this.eLK == 88) {
                x.d("MicroMsg.ContactWidgetNewBizInfo", "from biz search.");
                Bundle bundle = new Bundle();
                bundle.putBoolean("KFromBizSearch", true);
                bundle.putBundle("KBizSearchExtArgs", this.lVQ);
                intent2.putExtra("jsapiargs", bundle);
                int i = com.tencent.mm.l.a.gd(this.guS.field_type) ? 7 : 6;
                int identifier = this.lYs.getResources().getIdentifier(bnK.dKS, "string", this.lYs.getPackageName());
                String str3 = bnK.title;
                if (identifier > 0) {
                    str3 = this.lYs.getString(identifier);
                }
                ay(i, str3);
            }
            com.tencent.mm.bg.d.b(this.lYs, "webview", ".ui.tools.WebViewUI", intent2);
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bT(this.guS.field_username, TbsListener$ErrorCode.INFO_CODE_BASE);
            return true;
        }
    }

    final void bnr() {
        if (this.lYs.getIntent() != null && this.lYs.getIntent().getBooleanExtra("KIsHardDevice", false)) {
            String stringExtra = this.lYs.getIntent().getStringExtra("KHardDeviceBindTicket");
            if (bi.oW(stringExtra)) {
                x.i("MicroMsg.ContactWidgetNewBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
            } else if (!bns()) {
                x.d("MicroMsg.ContactWidgetNewBizInfo", "IsHardDevice, bindTicket = %s", new Object[]{stringExtra});
                au.DF().a(536, this);
                cv cvVar = new cv();
                cvVar.bKm.bKo = stringExtra;
                cvVar.bKm.opType = 1;
                com.tencent.mm.sdk.b.a.sFg.m(cvVar);
                l lVar = cvVar.bKn.bKq;
                ContactInfoUI contactInfoUI = this.lYs;
                this.lYs.getString(R.l.app_tip);
                this.tipDialog = h.a(contactInfoUI, this.lYs.getString(R.l.app_waiting), true, new 6(this, lVar));
                return;
            }
        }
        com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.lYs, new 7(this));
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

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.ContactWidgetNewBizInfo", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (lVar == null) {
            x.e("MicroMsg.ContactWidgetNewBizInfo", "scene == null");
            return;
        }
        au.DF().b(lVar.getType(), this);
        if (i == 0 && i2 == 0) {
            x.d("MicroMsg.ContactWidgetNewBizInfo", "scene.getType() = %s", new Object[]{Integer.valueOf(lVar.getType())});
            if (lVar.getType() == 536) {
                au.DF().b(536, this);
                bnp();
                return;
            }
            return;
        }
        x.e("MicroMsg.ContactWidgetNewBizInfo", "scene.getType() = %s", new Object[]{Integer.valueOf(lVar.getType())});
    }

    private boolean bns() {
        if (this.lYs.getIntent() == null) {
            return false;
        }
        String stringExtra = this.lYs.getIntent().getStringExtra("device_id");
        String stringExtra2 = this.lYs.getIntent().getStringExtra("device_type");
        cz czVar = new cz();
        czVar.bKx.byN = stringExtra;
        czVar.bKx.bKv = stringExtra2;
        com.tencent.mm.sdk.b.a.sFg.m(czVar);
        return czVar.bKy.bKz;
    }

    final void ay(int i, String str) {
        if (this.lVQ == null || !(this.eLK == 39 || this.eLK == 56 || this.eLK == 35 || this.eLK == 87 || this.eLK == 88 || this.eLK == 89 || this.eLK == 85)) {
            x.d("MicroMsg.ContactWidgetNewBizInfo", "mExtArgs is null or the add contact action is not from biz search.");
        } else if (this.guS == null) {
            x.i("MicroMsg.ContactWidgetNewBizInfo", "contact is null.");
        } else {
            int i2;
            String string = this.lVQ.getString("Contact_Ext_Args_Search_Id");
            String oV = bi.oV(this.lVQ.getString("Contact_Ext_Args_Query_String"));
            int i3 = this.lVQ.getInt("Contact_Ext_Args_Index");
            switch (this.eLK) {
                case 35:
                    i2 = 1;
                    break;
                case 85:
                    i2 = 5;
                    break;
                case 87:
                    i2 = 2;
                    break;
                case 88:
                    i2 = 3;
                    break;
                case 89:
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
            x.v("MicroMsg.ContactWidgetNewBizInfo", "report 10866: %s", new Object[]{str2});
            com.tencent.mm.plugin.report.service.h.mEJ.k(10866, str2);
        }
    }
}
