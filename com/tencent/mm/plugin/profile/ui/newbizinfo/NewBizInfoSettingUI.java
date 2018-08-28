package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.d.b;
import com.tencent.mm.ac.z;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.i;
import com.tencent.mm.protocal.c.atx;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.statusbar.DrawStatusBarPreference;
import com.tencent.mm.ui.statusbar.a;
import com.tencent.mm.ui.widget.a.c;

public class NewBizInfoSettingUI extends DrawStatusBarPreference {
    private b dKP;
    private int eLK;
    private f eOE;
    private ab guS;
    private boolean hEj;
    private boolean isDeleteCancel = false;
    private d lUs;
    c lVP = null;
    private p tipDialog = null;

    static /* synthetic */ void b(NewBizInfoSettingUI newBizInfoSettingUI) {
        String str = newBizInfoSettingUI.guS.field_username;
        au.HU();
        cm GD = com.tencent.mm.model.c.FT().GD(str);
        au.HU();
        com.tencent.mm.model.c.FQ().b(new com.tencent.mm.aq.d(str, GD.field_msgSvrId));
        newBizInfoSettingUI.isDeleteCancel = false;
        newBizInfoSettingUI.getString(R.l.app_tip);
        newBizInfoSettingUI.tipDialog = h.a(newBizInfoSettingUI, newBizInfoSettingUI.getString(R.l.app_waiting), true, new 5(newBizInfoSettingUI));
        bd.a(str, new 6(newBizInfoSettingUI));
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        boolean z2 = true;
        super.onCreate(bundle);
        this.eOE = this.tCL;
        lF(a.lYr);
        if (VERSION.SDK_INT >= 21) {
            a.c(this.mController.contentView, getWindow().getStatusBarColor(), com.tencent.mm.ui.statusbar.d.c(getWindow()));
        }
        setMMTitle(R.l.contact_info_biz_setting);
        nS(-16777216);
        s.cqp();
        cqh();
        lC(false);
        setBackBtn(new 1(this), R.k.actionbar_icon_dark_back);
        String oV = bi.oV(getIntent().getStringExtra("Contact_User"));
        au.HU();
        this.guS = com.tencent.mm.model.c.FR().Yg(oV);
        this.lUs = com.tencent.mm.ac.f.kH(this.guS.field_username);
        String str = "MicroMsg.mmui.MMPreference";
        String str2 = "user:%s contact:%b, bizInfo:%b";
        Object[] objArr = new Object[3];
        objArr[0] = oV;
        if (this.guS != null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        if (this.lUs == null) {
            z2 = false;
        }
        objArr[2] = Boolean.valueOf(z2);
        x.i(str, str2, objArr);
        this.eLK = getIntent().getIntExtra("Contact_Scene", 9);
        initView();
    }

    protected final void initView() {
        boolean z;
        this.dKP = this.lUs.bG(false);
        if (this.lUs != null) {
            this.eOE.bw("contact_is_mute", true);
            this.hEj = false;
        }
        this.eOE.bw("contact_info_stick_biz", true);
        if (this.lUs != null) {
            f fVar = this.eOE;
            String str = "contact_info_stick_biz";
            z = com.tencent.mm.model.s.hr(this.guS.field_username) || !com.tencent.mm.l.a.gd(this.guS.field_type);
            fVar.bw(str, z);
            ((CheckBoxPreference) this.eOE.ZZ("contact_info_stick_biz")).qpJ = this.guS.BG();
        }
        x.d("MicroMsg.mmui.MMPreference", "KIsardDevice(%b)", Boolean.valueOf(getIntent().getBooleanExtra("KIsHardDevice", false)));
        CheckBoxPreference checkBoxPreference;
        if (getIntent() != null && getIntent().getBooleanExtra("KIsHardDevice", false)) {
            x.d("MicroMsg.mmui.MMPreference", "Hard device biz...");
            if (getIntent() == null) {
                z = false;
            } else {
                String stringExtra = getIntent().getStringExtra("device_id");
                String stringExtra2 = getIntent().getStringExtra("device_type");
                cz czVar = new cz();
                czVar.bKx.byN = stringExtra;
                czVar.bKx.bKv = stringExtra2;
                com.tencent.mm.sdk.b.a.sFg.m(czVar);
                z = czVar.bKy.bKz;
            }
            x.d("MicroMsg.mmui.MMPreference", "contact.isContact()(%b), isHardDeviceBound(%b)", Boolean.valueOf(com.tencent.mm.l.a.gd(this.guS.field_type)), Boolean.valueOf(z));
            if (!com.tencent.mm.l.a.gd(this.guS.field_type) || !z) {
                x.w("MicroMsg.mmui.MMPreference", "%s is not my hard biz contact", this.guS.field_username);
                bnq();
                if (!uK(this.eLK)) {
                    return;
                }
                if (this.lUs == null) {
                    x.e("MicroMsg.mmui.MMPreference", "bizinfo is null in temp session");
                    return;
                }
                ((CheckBoxPreference) this.eOE.ZZ("contact_info_subscribe_bizinfo")).qpJ = this.lUs.LQ();
                this.eOE.bw("contact_info_subscribe_bizinfo", false);
            } else if (this.lUs != null) {
                ((CheckBoxPreference) this.eOE.ZZ("contact_info_subscribe_bizinfo")).qpJ = this.lUs.LQ();
                checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("contact_info_locate");
                if (this.lUs.bG(false).LU()) {
                    checkBoxPreference.qpJ = this.lUs.LR();
                } else {
                    this.eOE.bw("contact_info_locate", true);
                    checkBoxPreference.qpJ = this.lUs.LR();
                }
                if (this.lUs.LQ()) {
                    if (this.dKP == null && this.lUs != null) {
                        this.dKP = this.lUs.bG(false);
                    }
                    if (this.dKP != null && this.dKP.Mk() && com.tencent.mm.bg.d.QS("brandservice")) {
                        this.eOE.bw("contact_info_template_recv", false);
                        return;
                    } else {
                        this.eOE.bw("contact_info_template_recv", true);
                        return;
                    }
                }
                this.eOE.bw("contact_info_template_recv", true);
            } else {
                this.eOE.bw("contact_info_subscribe_bizinfo", true);
                this.eOE.bw("contact_info_locate", true);
                this.eOE.bw("contact_info_template_recv", true);
            }
        } else if (!com.tencent.mm.l.a.gd(this.guS.field_type)) {
            x.w("MicroMsg.mmui.MMPreference", "%s is not my contact", this.guS.field_username);
            bnq();
            if (!uK(this.eLK)) {
                return;
            }
            if (this.lUs == null) {
                x.e("MicroMsg.mmui.MMPreference", "bizinfo is null in temp session");
                return;
            }
            ((CheckBoxPreference) this.eOE.ZZ("contact_info_subscribe_bizinfo")).qpJ = this.lUs.LQ();
            this.eOE.bw("contact_info_subscribe_bizinfo", false);
        } else if (this.lUs != null) {
            ((CheckBoxPreference) this.eOE.ZZ("contact_info_subscribe_bizinfo")).qpJ = this.lUs.LQ();
            if (this.lUs.LQ()) {
                if (this.dKP == null && this.lUs != null) {
                    this.dKP = this.lUs.bG(false);
                }
                if (this.dKP != null && this.dKP.Mk() && com.tencent.mm.bg.d.QS("brandservice")) {
                    this.eOE.bw("contact_info_template_recv", false);
                } else {
                    this.eOE.bw("contact_info_template_recv", true);
                }
            } else {
                this.eOE.bw("contact_info_template_recv", true);
            }
            checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("contact_info_locate");
            if (this.lUs.bG(false).LU()) {
                checkBoxPreference.qpJ = this.lUs.LR();
                return;
            }
            this.eOE.bw("contact_info_locate", true);
            checkBoxPreference.qpJ = this.lUs.LR();
        }
    }

    private void bnq() {
        if (this.guS == null || !com.tencent.mm.l.a.gd(this.guS.field_type) || com.tencent.mm.model.s.hr(this.guS.field_username) || com.tencent.mm.model.s.hW(this.guS.field_username)) {
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
    }

    private void a(d dVar, boolean z) {
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
            initView();
        }
    }

    private static boolean uK(int i) {
        if (i == 81 || i == 92 || i == 93 || i == 94) {
            return true;
        }
        return false;
    }

    public final int Ys() {
        return R.o.newbizinfo_setting_pref;
    }

    public final boolean a(f fVar, Preference preference) {
        Intent intent;
        String str = preference.mKey;
        x.i("MicroMsg.mmui.MMPreference", str + " item has been clicked!");
        if ("contact_info_locate".endsWith(str)) {
            d dVar = this.lUs;
            if (dVar == null) {
                return true;
            }
            if (dVar.LR()) {
                dVar.field_brandFlag &= -5;
            } else {
                this.lVP = h.a(this, getString(R.l.chatting_biz_report_location_confirm, new Object[]{this.guS.BL()}), getString(R.l.app_tip), new 2(this, dVar), new 3(this, dVar));
            }
            a(dVar, false);
            if (((CheckBoxPreference) fVar.ZZ("contact_info_locate")).isChecked()) {
                com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bT(this.guS.field_username, 905);
            } else {
                com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bT(this.guS.field_username, 907);
            }
        }
        if ("contact_info_expose_btn".equals(str)) {
            if (!(this.guS == null || bi.oW(this.guS.field_username))) {
                intent = new Intent();
                intent.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect", new Object[]{this.guS.field_username}));
                intent.putExtra("showShare", false);
                com.tencent.mm.bg.d.b(this, "webview", ".ui.tools.WebViewUI", intent);
            }
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bT(this.guS.field_username, 908);
        }
        if ("contact_info_add_shortcut_btn".equals(str)) {
            x.d("MicroMsg.mmui.MMPreference", "dealAddShortcut, username = " + this.guS.field_username);
            com.tencent.mm.plugin.base.model.b.V(this, this.guS.field_username);
            ah.i(new 7(this), 1000);
        }
        if ("contact_info_clear_msg".equals(str)) {
            getString(R.l.fmt_delcontactmsg_confirm, new Object[]{this.guS.BL()});
            h.a(this, getString(R.l.contact_info_biz_clear_msg_tips), "", getString(R.l.contact_info_biz_clear_msg), getString(R.l.app_cancel), new 4(this), null);
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bT(this.guS.field_username, 909);
        }
        if ("contact_is_mute".endsWith(str)) {
            this.hEj = !this.hEj;
            if (this.hEj) {
                com.tencent.mm.model.s.n(this.guS);
            } else {
                com.tencent.mm.model.s.o(this.guS);
            }
            boolean z = this.hEj;
            if (this.guS != null) {
                if (!z || com.tencent.mm.ac.f.eZ(this.guS.field_username)) {
                    setTitleMuteIconVisibility(8);
                } else {
                    setTitleMuteIconVisibility(0);
                }
                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("contact_is_mute");
                if (checkBoxPreference != null) {
                    checkBoxPreference.qpJ = z;
                }
            }
        }
        if (!"contact_info_stick_biz".equals(str)) {
            if ("contact_info_template_recv".equals(str)) {
                intent = new Intent();
                intent.putExtra("enterprise_biz_name", this.lUs.field_username);
                com.tencent.mm.bg.d.b(this, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", intent);
            }
            if ("contact_info_subscribe_bizinfo".endsWith(str)) {
                d dVar2 = this.lUs;
                if (dVar2 == null) {
                    return true;
                }
                int i;
                if (dVar2.LQ()) {
                    dVar2.field_brandFlag |= 1;
                    if (this.dKP == null && dVar2 != null) {
                        this.dKP = dVar2.bG(false);
                    }
                    if (this.dKP != null && this.dKP.Mk() && com.tencent.mm.bg.d.QS("brandservice")) {
                        fVar.bw("contact_info_template_recv", false);
                    } else {
                        fVar.bw("contact_info_template_recv", true);
                    }
                } else {
                    dVar2.field_brandFlag &= -2;
                    fVar.bw("contact_info_template_recv", true);
                }
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.mEJ;
                Object[] objArr = new Object[4];
                objArr[0] = dVar2.field_username;
                objArr[1] = Integer.valueOf(1);
                if (dVar2.LQ()) {
                    i = 3;
                } else {
                    i = 4;
                }
                objArr[2] = Integer.valueOf(i);
                objArr[3] = Integer.valueOf(0);
                hVar.h(13307, objArr);
                a(dVar2, false);
                if (((CheckBoxPreference) fVar.ZZ("contact_info_subscribe_bizinfo")).isChecked()) {
                    com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bT(this.guS.field_username, 901);
                } else {
                    com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bT(this.guS.field_username, 902);
                }
            }
            return false;
        } else if (((CheckBoxPreference) fVar.ZZ("contact_info_stick_biz")).isChecked()) {
            com.tencent.mm.plugin.report.service.h.mEJ.h(13307, this.guS.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0));
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bT(this.guS.field_username, 903);
            i.gy(this.guS.field_username);
            return true;
        } else {
            com.tencent.mm.model.s.u(this.guS.field_username, true);
            com.tencent.mm.plugin.report.service.h.mEJ.h(13307, this.guS.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0));
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bT(this.guS.field_username, 904);
            return true;
        }
    }
}
