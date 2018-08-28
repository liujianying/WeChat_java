package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aa.k;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.d$a;
import com.tencent.mm.ac.d$b;
import com.tencent.mm.ac.g;
import com.tencent.mm.ac.h.a;
import com.tencent.mm.ac.i;
import com.tencent.mm.ac.z;
import com.tencent.mm.model.am;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.plugin.profile.ui.BizInfoPayInfoIconPreference;
import com.tencent.mm.plugin.profile.ui.IconWidgetPreference;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.cgc;
import com.tencent.mm.protocal.c.qt;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.statusbar.DrawStatusBarPreference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NewBizInfoMoreInofUI extends DrawStatusBarPreference implements a {
    private List<d$a> dKO;
    private d$b dKP;
    private boolean dKW = false;
    private int eLK;
    private f eOE;
    private ab guS;
    private d lUs;
    private qt lVI;
    private String lVN;
    private boolean lVO;
    private Bundle lVQ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eOE = this.tCL;
        lF(a.lYr);
        if (VERSION.SDK_INT >= 21) {
            com.tencent.mm.ui.statusbar.a.c(this.mController.contentView, getWindow().getStatusBarColor(), com.tencent.mm.ui.statusbar.d.c(getWindow()));
        }
        setMMTitle(R.l.contact_info_biz_more);
        nS(-16777216);
        s.cqp();
        cqh();
        lC(false);
        setBackBtn(new 1(this), R.k.actionbar_icon_dark_back);
        String oV = bi.oV(getIntent().getStringExtra("Contact_User"));
        String oV2 = bi.oV(getIntent().getStringExtra("Contact_Alias"));
        int intExtra = getIntent().getIntExtra("Contact_VUser_Info_Flag", 0);
        int intExtra2 = getIntent().getIntExtra("Contact_KWeibo_flag", 0);
        String stringExtra = getIntent().getStringExtra("Contact_KWeibo");
        String stringExtra2 = getIntent().getStringExtra("Contact_KWeiboNick");
        au.HU();
        this.guS = c.FR().Yg(oV);
        if (this.guS == null || ((int) this.guS.dhP) == 0 || bi.oV(this.guS.field_username).length() <= 0) {
            this.guS = new ab();
            this.guS.setUsername(oV);
            this.guS.du(oV2);
            this.guS.eF(intExtra);
            this.guS.dQ(stringExtra);
            this.guS.eE(intExtra2);
            this.guS.dA(stringExtra2);
        } else if (intExtra != 0) {
            this.guS.eF(intExtra);
        }
        this.lUs = com.tencent.mm.ac.f.kH(this.guS.field_username);
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("Contact_customInfo");
        try {
            this.lVI = byteArrayExtra == null ? null : (qt) new qt().aG(byteArrayExtra);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NewBizInfoMoreInofUI", e, "", new Object[0]);
        }
        this.eLK = getIntent().getIntExtra("Contact_Scene", 9);
        this.lVQ = getIntent().getBundleExtra("Contact_Ext_Args");
        initView();
    }

    protected final void initView() {
        String string;
        IndexOutOfBoundsException e;
        int indexOf;
        this.eOE.bw("biz_placed_to_the_top", true);
        d kH = com.tencent.mm.ac.f.kH(this.guS.field_username);
        this.dKO = null;
        this.dKP = null;
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
            this.dKW = this.dKP.Mj();
        }
        if (com.tencent.mm.l.a.gd(this.guS.field_type)) {
            if (this.lUs == null ? true : this.lUs.Me()) {
                Bitmap e2;
                Drawable bitmapDrawable;
                String str;
                boolean z;
                CharSequence charSequence;
                KeyValuePreference keyValuePreference = (KeyValuePreference) this.eOE.ZZ("contact_info_wechat_account");
                if (!bi.oW(this.guS.wM())) {
                    this.eOE.bw("contact_info_wechat_account", false);
                    keyValuePreference.setSummary(j.a(this, this.guS.wM()));
                } else if (ab.XT(this.guS.field_username) || com.tencent.mm.model.s.hd(this.guS.field_username)) {
                    this.eOE.bw("contact_info_wechat_account", true);
                } else {
                    this.eOE.bw("contact_info_wechat_account", false);
                    keyValuePreference.setSummary(this.mController.tml.getString(R.l.app_field_username) + bi.oV(this.guS.BM()));
                }
                if (this.dKP == null && this.dKP.Mt() != null && !bi.oW(this.dKP.Mt().dLJ)) {
                    d$b.d Mt = this.dKP.Mt();
                    keyValuePreference = (KeyValuePreference) this.eOE.ZZ("contact_info_verifyuser");
                    if (keyValuePreference != null) {
                        keyValuePreference.csl();
                        keyValuePreference.tCA = false;
                        if (bi.oW(Mt.dLK)) {
                            switch (Mt.dLI) {
                                case 0:
                                    string = getResources().getString(R.l.contact_info_verify_user_title);
                                    break;
                                case 1:
                                    string = getResources().getString(R.l.contact_info_biz_new_sweibo_verify);
                                    break;
                                case 2:
                                    string = getResources().getString(R.l.contact_info_biz_new_tweibo_verify);
                                    break;
                                default:
                                    x.w("MicroMsg.NewBizInfoMoreInofUI", "getVerifyStr, error type %d", new Object[]{Integer.valueOf(Mt.dLI)});
                                    string = getResources().getString(R.l.contact_info_isnot_verify_user_title);
                                    break;
                            }
                            keyValuePreference.tmc = string;
                        } else {
                            keyValuePreference.tmc = Mt.dLK;
                        }
                        if (am.a.dBt != null) {
                            e2 = b.e(am.a.dBt.gX(this.guS.field_verifyFlag), 2.0f);
                        } else {
                            Object e22 = null;
                        }
                        if (e22 != null) {
                            bitmapDrawable = new BitmapDrawable(getResources(), com.tencent.mm.sdk.platformtools.c.CV(R.k.new_biz_certified));
                        } else {
                            bitmapDrawable = null;
                        }
                        str = "MicroMsg.NewBizInfoMoreInofUI";
                        String str2 = "verify bmp is null ? %B";
                        Object[] objArr = new Object[1];
                        if (e22 == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objArr[0] = Boolean.valueOf(z);
                        x.i(str, str2, objArr);
                        keyValuePreference.tCI = bitmapDrawable;
                        if (Mt.dLJ != null) {
                            str = Mt.dLM;
                            CharSequence a = j.a(this, Mt.dLJ.trim());
                            if (bi.oW(str)) {
                                charSequence = a;
                            } else {
                                try {
                                    charSequence = new SpannableString(str + " " + a);
                                    try {
                                        charSequence.setSpan(new ForegroundColorSpan(-36352), 0, str.length(), 17);
                                    } catch (IndexOutOfBoundsException e3) {
                                        e = e3;
                                        x.e("MicroMsg.NewBizInfoMoreInofUI", "verifySummary setSpan error: %s", new Object[]{e.getMessage()});
                                        keyValuePreference.setSummary(charSequence);
                                        if (this.dKP != null) {
                                        }
                                        x.w("MicroMsg.NewBizInfoMoreInofUI", "has not trademark info");
                                        this.eOE.bw("contact_info_trademark", true);
                                        if (this.dKP != null) {
                                        }
                                        this.eOE.bw("contact_info_privilege", true);
                                        string = getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID");
                                        x.d("MicroMsg.NewBizInfoMoreInofUI", "updateKF %s, %b", new Object[]{string, Boolean.valueOf(this.lVO)});
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
                                                    z.MZ().ag(this.guS.field_username, q.GF());
                                                    this.lVO = true;
                                                } else {
                                                    x.d("MicroMsg.NewBizInfoMoreInofUI", "has default kf %s", new Object[]{kR.field_openId});
                                                    this.eOE.bw("contact_info_kf_worker", false);
                                                    iconWidgetPreference = (IconWidgetPreference) this.eOE.ZZ("contact_info_kf_worker");
                                                    iconWidgetPreference.setSummary(kR.field_nickname);
                                                    e22 = com.tencent.mm.aa.c.a(kR.field_openId, false, -1);
                                                    if (e22 == null) {
                                                        c(kR);
                                                        JF(kR.field_openId);
                                                    } else {
                                                        iconWidgetPreference.C(e22);
                                                    }
                                                }
                                            } else {
                                                i MX = z.MX();
                                                g kQ = MX.kQ(string);
                                                if (kQ == null || i.a(kQ)) {
                                                    z.MZ().a(this);
                                                    z.MZ().ah(this.guS.field_username, string);
                                                    this.lVO = true;
                                                }
                                                if (kQ == null) {
                                                    x.d("MicroMsg.NewBizInfoMoreInofUI", "no such kf, get default kf");
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
                                                    e22 = com.tencent.mm.aa.c.a(kR.field_openId, false, -1);
                                                    if (e22 == null) {
                                                        c(kR);
                                                        JF(kR.field_openId);
                                                    } else {
                                                        iconWidgetPreference.C(e22);
                                                    }
                                                    x.d("MicroMsg.NewBizInfoMoreInofUI", "kf worker %s, %s", new Object[]{kR.field_openId, kR.field_nickname});
                                                }
                                            }
                                        }
                                        if (this.dKP != null) {
                                        }
                                        this.eOE.bw("contact_info_service_phone", true);
                                        if (this.dKP != null) {
                                        }
                                        this.eOE.bw("contact_info_reputation", true);
                                        this.eOE.bw("contact_info_guarantee_info", true);
                                        this.eOE.bw("contact_info_scope_of_business", true);
                                        if (com.tencent.mm.model.s.v(this.guS)) {
                                        }
                                        this.eOE.bw("contact_info_verifyuser_weibo", true);
                                        if (this.dKP == null) {
                                        }
                                        this.eOE.bw("near_field_service", true);
                                        if (bnL() == null) {
                                            this.eOE.bw("contact_info_see_locate", false);
                                        } else {
                                            this.eOE.bw("contact_info_see_locate", true);
                                        }
                                        indexOf = this.eOE.indexOf("contact_info_category2");
                                        if (indexOf >= 0) {
                                        }
                                        x.d("MicroMsg.NewBizInfoMoreInofUI", "pos no more");
                                    }
                                } catch (IndexOutOfBoundsException e4) {
                                    e = e4;
                                    charSequence = a;
                                    x.e("MicroMsg.NewBizInfoMoreInofUI", "verifySummary setSpan error: %s", new Object[]{e.getMessage()});
                                    keyValuePreference.setSummary(charSequence);
                                    if (this.dKP != null) {
                                    }
                                    x.w("MicroMsg.NewBizInfoMoreInofUI", "has not trademark info");
                                    this.eOE.bw("contact_info_trademark", true);
                                    if (this.dKP != null) {
                                    }
                                    this.eOE.bw("contact_info_privilege", true);
                                    string = getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID");
                                    x.d("MicroMsg.NewBizInfoMoreInofUI", "updateKF %s, %b", new Object[]{string, Boolean.valueOf(this.lVO)});
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
                                                z.MZ().ag(this.guS.field_username, q.GF());
                                                this.lVO = true;
                                            } else {
                                                x.d("MicroMsg.NewBizInfoMoreInofUI", "has default kf %s", new Object[]{kR2.field_openId});
                                                this.eOE.bw("contact_info_kf_worker", false);
                                                iconWidgetPreference2 = (IconWidgetPreference) this.eOE.ZZ("contact_info_kf_worker");
                                                iconWidgetPreference2.setSummary(kR2.field_nickname);
                                                e22 = com.tencent.mm.aa.c.a(kR2.field_openId, false, -1);
                                                if (e22 == null) {
                                                    c(kR2);
                                                    JF(kR2.field_openId);
                                                } else {
                                                    iconWidgetPreference2.C(e22);
                                                }
                                            }
                                        } else {
                                            i MX2 = z.MX();
                                            g kQ2 = MX2.kQ(string);
                                            if (kQ2 == null || i.a(kQ2)) {
                                                z.MZ().a(this);
                                                z.MZ().ah(this.guS.field_username, string);
                                                this.lVO = true;
                                            }
                                            if (kQ2 == null) {
                                                x.d("MicroMsg.NewBizInfoMoreInofUI", "no such kf, get default kf");
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
                                                e22 = com.tencent.mm.aa.c.a(kR2.field_openId, false, -1);
                                                if (e22 == null) {
                                                    c(kR2);
                                                    JF(kR2.field_openId);
                                                } else {
                                                    iconWidgetPreference2.C(e22);
                                                }
                                                x.d("MicroMsg.NewBizInfoMoreInofUI", "kf worker %s, %s", new Object[]{kR2.field_openId, kR2.field_nickname});
                                            }
                                        }
                                    }
                                    if (this.dKP != null) {
                                    }
                                    this.eOE.bw("contact_info_service_phone", true);
                                    if (this.dKP != null) {
                                    }
                                    this.eOE.bw("contact_info_reputation", true);
                                    this.eOE.bw("contact_info_guarantee_info", true);
                                    this.eOE.bw("contact_info_scope_of_business", true);
                                    if (com.tencent.mm.model.s.v(this.guS)) {
                                    }
                                    this.eOE.bw("contact_info_verifyuser_weibo", true);
                                    if (this.dKP == null) {
                                    }
                                    this.eOE.bw("near_field_service", true);
                                    if (bnL() == null) {
                                        this.eOE.bw("contact_info_see_locate", true);
                                    } else {
                                        this.eOE.bw("contact_info_see_locate", false);
                                    }
                                    indexOf = this.eOE.indexOf("contact_info_category2");
                                    if (indexOf >= 0) {
                                    }
                                    x.d("MicroMsg.NewBizInfoMoreInofUI", "pos no more");
                                }
                            }
                            keyValuePreference.setSummary(charSequence);
                        } else {
                            x.e("MicroMsg.NewBizInfoMoreInofUI", "[arthurdan.emojiSpan] Notice!!!! extInfo.verifyInfo.verifySourceDescription is null");
                        }
                    } else {
                        this.eOE.bw("contact_info_verifyuser", true);
                    }
                } else if (this.dKP != null || this.dKP.Mu() == null || bi.oW(this.dKP.Mu().dLS)) {
                    x.w("MicroMsg.NewBizInfoMoreInofUI", "has not verify info");
                    this.eOE.bw("contact_info_verifyuser", true);
                } else {
                    keyValuePreference = (KeyValuePreference) this.eOE.ZZ("contact_info_verifyuser");
                    if (keyValuePreference != null) {
                        keyValuePreference.setSummary(this.dKP.Mu().dLS);
                    }
                }
                if (this.dKP != null || bi.oW(this.dKP.Mn())) {
                    x.w("MicroMsg.NewBizInfoMoreInofUI", "has not trademark info");
                    this.eOE.bw("contact_info_trademark", true);
                } else {
                    keyValuePreference = (KeyValuePreference) this.eOE.ZZ("contact_info_trademark");
                    if (keyValuePreference != null) {
                        Bitmap CV;
                        keyValuePreference.csl();
                        keyValuePreference.tCA = false;
                        if (am.a.dBt != null) {
                            CV = com.tencent.mm.sdk.platformtools.c.CV(R.k.new_biz_trademark_protection);
                        } else {
                            CV = null;
                        }
                        String str3 = "MicroMsg.NewBizInfoMoreInofUI";
                        str = "trademark bmp is null ? %B";
                        Object[] objArr2 = new Object[1];
                        if (CV == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objArr2[0] = Boolean.valueOf(z);
                        x.i(str3, str, objArr2);
                        if (CV != null) {
                            bitmapDrawable = new BitmapDrawable(getResources(), CV);
                        } else {
                            bitmapDrawable = null;
                        }
                        keyValuePreference.tCI = bitmapDrawable;
                        keyValuePreference.setSummary(this.dKP.Mn());
                        x.d("MicroMsg.NewBizInfoMoreInofUI", "trademark name : %s, url : %s.", new Object[]{this.dKP.Mn(), this.dKP.Mm()});
                    }
                }
                if (this.dKP != null || this.dKP.Mp() == null || this.dKP.Mp().size() <= 0) {
                    this.eOE.bw("contact_info_privilege", true);
                } else {
                    keyValuePreference = (KeyValuePreference) this.eOE.ZZ("contact_info_privilege");
                    keyValuePreference.csl();
                    keyValuePreference.lO(false);
                    keyValuePreference.csk();
                    for (d$b.f fVar : this.dKP.Mp()) {
                        LinearLayout linearLayout = (LinearLayout) View.inflate(this, R.i.keyvalue_pref_item, null);
                        ((ImageView) linearLayout.findViewById(R.h.image_iv)).setImageDrawable(new com.tencent.mm.plugin.profile.ui.b.a(getResources(), fVar.iconUrl));
                        CharSequence charSequence2 = fVar.description;
                        getResources().getIdentifier(fVar.dLR, "string", getPackageName());
                        ((TextView) linearLayout.findViewById(R.h.summary)).setText(charSequence2);
                        keyValuePreference.dp(linearLayout);
                    }
                }
                string = getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID");
                x.d("MicroMsg.NewBizInfoMoreInofUI", "updateKF %s, %b", new Object[]{string, Boolean.valueOf(this.lVO)});
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
                            z.MZ().ag(this.guS.field_username, q.GF());
                            this.lVO = true;
                        } else {
                            x.d("MicroMsg.NewBizInfoMoreInofUI", "has default kf %s", new Object[]{kR22.field_openId});
                            this.eOE.bw("contact_info_kf_worker", false);
                            iconWidgetPreference22 = (IconWidgetPreference) this.eOE.ZZ("contact_info_kf_worker");
                            iconWidgetPreference22.setSummary(kR22.field_nickname);
                            e22 = com.tencent.mm.aa.c.a(kR22.field_openId, false, -1);
                            if (e22 == null) {
                                c(kR22);
                                JF(kR22.field_openId);
                            } else {
                                iconWidgetPreference22.C(e22);
                            }
                        }
                    } else {
                        i MX22 = z.MX();
                        g kQ22 = MX22.kQ(string);
                        if (kQ22 == null || i.a(kQ22)) {
                            z.MZ().a(this);
                            z.MZ().ah(this.guS.field_username, string);
                            this.lVO = true;
                        }
                        if (kQ22 == null) {
                            x.d("MicroMsg.NewBizInfoMoreInofUI", "no such kf, get default kf");
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
                            e22 = com.tencent.mm.aa.c.a(kR22.field_openId, false, -1);
                            if (e22 == null) {
                                c(kR22);
                                JF(kR22.field_openId);
                            } else {
                                iconWidgetPreference22.C(e22);
                            }
                            x.d("MicroMsg.NewBizInfoMoreInofUI", "kf worker %s, %s", new Object[]{kR22.field_openId, kR22.field_nickname});
                        }
                    }
                }
                if (this.dKP != null || bi.oW(this.dKP.Mz())) {
                    this.eOE.bw("contact_info_service_phone", true);
                } else {
                    this.eOE.bw("contact_info_service_phone", false);
                    Preference ZZ = this.eOE.ZZ("contact_info_service_phone");
                    if (ZZ != null) {
                        ZZ.setSummary(this.dKP.Mz());
                        ZZ.hIZ = getResources().getColor(R.e.link_color);
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
                if (com.tencent.mm.model.s.v(this.guS) || this.guS.csO == null || this.guS.csO.equals("")) {
                    this.eOE.bw("contact_info_verifyuser_weibo", true);
                } else {
                    keyValuePreference = (KeyValuePreference) this.eOE.ZZ("contact_info_verifyuser_weibo");
                    if (keyValuePreference != null) {
                        keyValuePreference.setSummary(bi.aG(this.guS.field_weiboNickname, "") + getString(R.l.settings_show_weibo_field, new Object[]{com.tencent.mm.model.s.hV(this.guS.csO)}));
                        keyValuePreference.hIZ = com.tencent.mm.bp.a.g(this, R.e.link_color);
                        keyValuePreference.lO(false);
                    }
                }
                if (this.dKP == null && this.dKP.Mi()) {
                    this.eOE.ZZ("near_field_service").setSummary(R.l.weixin_connect_wifi);
                } else {
                    this.eOE.bw("near_field_service", true);
                }
                if (bnL() == null) {
                    this.eOE.bw("contact_info_see_locate", false);
                } else {
                    this.eOE.bw("contact_info_see_locate", true);
                }
                indexOf = this.eOE.indexOf("contact_info_category2");
                if (indexOf >= 0 || this.dKO == null || this.dKO.size() <= 0) {
                    x.d("MicroMsg.NewBizInfoMoreInofUI", "pos no more");
                }
                int size = this.dKO.size() - 1;
                while (size >= 0) {
                    if (this.dKO.get(size) != null && ((!getString(R.l.contact_info_biz_participants).equals(((d$a) this.dKO.get(size)).title) || this.dKW) && !((bi.oW(((d$a) this.dKO.get(size)).title) && bi.oW(((d$a) this.dKO.get(size)).dKS)) || ((d$a) this.dKO.get(size)).dKS.equals("__mp_wording__brandinfo_location") || getString(R.l.contact_info_biz_see_location).equals(((d$a) this.dKO.get(size)).title) || ((d$a) this.dKO.get(size)).dKS.equals("__mp_wording__brandinfo_history_massmsg")))) {
                        int i;
                        Preference preference = new Preference(this);
                        preference.setKey("contact_info_bizinfo_external#" + size);
                        charSequence = ((d$a) this.dKO.get(size)).title;
                        int identifier = getResources().getIdentifier(((d$a) this.dKO.get(size)).dKS, "string", getPackageName());
                        if (identifier > 0) {
                            charSequence = getString(identifier);
                        }
                        if (this.lUs.LX() && ("__mp_wording__brandinfo_history_massmsg".equals(((d$a) this.dKO.get(size)).dKS) || r1.equals(getString(R.l.__mp_wording__brandinfo_history_massmsg)))) {
                            charSequence = getString(R.l.enterprise_brand_history);
                        }
                        preference.setTitle(charSequence);
                        if (!bi.oW(((d$a) this.dKO.get(size)).description)) {
                            preference.setSummary(((d$a) this.dKO.get(size)).description);
                        }
                        if (bi.oV(((d$a) this.dKO.get(size)).dKS).equals("__mp_wording__brandinfo_feedback")) {
                            identifier = this.eOE.indexOf("contact_info_scope_of_business");
                            if (identifier > 0) {
                                i = identifier + 1;
                                this.eOE.a(preference, i);
                                if (bi.oV(((d$a) this.dKO.get(size)).dKS).equals("__mp_wording__brandinfo_biz_detail")) {
                                    this.eOE.a(new PreferenceSmallCategory(this), i);
                                }
                            }
                        }
                        i = indexOf;
                        this.eOE.a(preference, i);
                        if (bi.oV(((d$a) this.dKO.get(size)).dKS).equals("__mp_wording__brandinfo_biz_detail")) {
                            this.eOE.a(new PreferenceSmallCategory(this), i);
                        }
                    }
                    size--;
                }
                return;
            }
        }
        this.eOE.bw("contact_info_wechat_account", true);
        if (this.dKP == null) {
        }
        if (this.dKP != null) {
        }
        x.w("MicroMsg.NewBizInfoMoreInofUI", "has not verify info");
        this.eOE.bw("contact_info_verifyuser", true);
        if (this.dKP != null) {
        }
        x.w("MicroMsg.NewBizInfoMoreInofUI", "has not trademark info");
        this.eOE.bw("contact_info_trademark", true);
        if (this.dKP != null) {
        }
        this.eOE.bw("contact_info_privilege", true);
        string = getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID");
        x.d("MicroMsg.NewBizInfoMoreInofUI", "updateKF %s, %b", new Object[]{string, Boolean.valueOf(this.lVO)});
        if (this.lVO) {
            this.lVN = string;
            g kR222;
            IconWidgetPreference iconWidgetPreference222;
            if (this.dKP == null || !this.dKP.MA() || this.guS == null) {
                this.eOE.bw("contact_info_kf_worker", true);
            } else if (bi.oW(string)) {
                kR222 = z.MX().kR(this.guS.field_username);
                if (kR222 == null) {
                    this.eOE.bw("contact_info_kf_worker", true);
                    z.MZ().a(this);
                    z.MZ().ag(this.guS.field_username, q.GF());
                    this.lVO = true;
                } else {
                    x.d("MicroMsg.NewBizInfoMoreInofUI", "has default kf %s", new Object[]{kR222.field_openId});
                    this.eOE.bw("contact_info_kf_worker", false);
                    iconWidgetPreference222 = (IconWidgetPreference) this.eOE.ZZ("contact_info_kf_worker");
                    iconWidgetPreference222.setSummary(kR222.field_nickname);
                    e22 = com.tencent.mm.aa.c.a(kR222.field_openId, false, -1);
                    if (e22 == null) {
                        c(kR222);
                        JF(kR222.field_openId);
                    } else {
                        iconWidgetPreference222.C(e22);
                    }
                }
            } else {
                i MX222 = z.MX();
                g kQ222 = MX222.kQ(string);
                if (kQ222 == null || i.a(kQ222)) {
                    z.MZ().a(this);
                    z.MZ().ah(this.guS.field_username, string);
                    this.lVO = true;
                }
                if (kQ222 == null) {
                    x.d("MicroMsg.NewBizInfoMoreInofUI", "no such kf, get default kf");
                    kR222 = MX222.kR(this.guS.field_username);
                } else {
                    kR222 = kQ222;
                }
                if (kR222 == null) {
                    this.eOE.bw("contact_info_kf_worker", true);
                } else {
                    this.eOE.bw("contact_info_kf_worker", false);
                    iconWidgetPreference222 = (IconWidgetPreference) this.eOE.ZZ("contact_info_kf_worker");
                    iconWidgetPreference222.setSummary(kR222.field_nickname);
                    e22 = com.tencent.mm.aa.c.a(kR222.field_openId, false, -1);
                    if (e22 == null) {
                        c(kR222);
                        JF(kR222.field_openId);
                    } else {
                        iconWidgetPreference222.C(e22);
                    }
                    x.d("MicroMsg.NewBizInfoMoreInofUI", "kf worker %s, %s", new Object[]{kR222.field_openId, kR222.field_nickname});
                }
            }
        }
        if (this.dKP != null) {
        }
        this.eOE.bw("contact_info_service_phone", true);
        if (this.dKP != null) {
        }
        this.eOE.bw("contact_info_reputation", true);
        this.eOE.bw("contact_info_guarantee_info", true);
        this.eOE.bw("contact_info_scope_of_business", true);
        if (com.tencent.mm.model.s.v(this.guS)) {
        }
        this.eOE.bw("contact_info_verifyuser_weibo", true);
        if (this.dKP == null) {
        }
        this.eOE.bw("near_field_service", true);
        if (bnL() == null) {
            this.eOE.bw("contact_info_see_locate", true);
        } else {
            this.eOE.bw("contact_info_see_locate", false);
        }
        indexOf = this.eOE.indexOf("contact_info_category2");
        if (indexOf >= 0) {
        }
        x.d("MicroMsg.NewBizInfoMoreInofUI", "pos no more");
    }

    private d$a bnL() {
        if (this.dKO == null || this.dKO.size() < 0) {
            x.w("MicroMsg.NewBizInfoMoreInofUI", "brandInfoList is null not show location");
            return null;
        }
        for (d$a d_a : this.dKO) {
            if (d_a.dKS.equals("__mp_wording__brandinfo_location")) {
                return d_a;
            }
            if (getString(R.l.contact_info_biz_see_location).equals(d_a.title)) {
                return d_a;
            }
        }
        x.w("MicroMsg.NewBizInfoMoreInofUI", "brandInfoList is null not show location");
        return null;
    }

    private static void c(g gVar) {
        long currentTimeMillis = System.currentTimeMillis();
        k KH = com.tencent.mm.aa.q.KH();
        if (KH.kc(gVar.field_openId) == null) {
            com.tencent.mm.aa.j jVar = new com.tencent.mm.aa.j();
            jVar.username = gVar.field_openId;
            jVar.dHQ = gVar.field_headImgUrl;
            jVar.by(false);
            jVar.csA = 3;
            KH.a(jVar);
        }
        com.tencent.mm.aa.q.KJ().jP(gVar.field_openId);
        x.d("MicroMsg.NewBizInfoMoreInofUI", "downloadKFAvatar, %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    private void JF(String str) {
        ah.i(new 2(this, str), 2000);
    }

    public final String MQ() {
        return "MicroMsg.NewBizInfoMoreInofUI";
    }

    public final void d(LinkedList<cgc> linkedList) {
        z.MZ().b(this);
        if (this.eOE == null) {
            x.e("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, screen is null");
        } else if (this.guS == null) {
            x.e("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, contact is null");
        } else if (linkedList == null || linkedList.size() <= 0) {
            x.w("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, worker is null");
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

    public final int Ys() {
        return R.o.newbizinfo_more_info_pref;
    }

    public final boolean a(f fVar, Preference preference) {
        int i = 7;
        String str = preference.mKey;
        x.i("MicroMsg.NewBizInfoMoreInofUI", str + " item has been clicked!");
        String str2;
        Intent intent;
        int i2;
        String str3;
        d dVar;
        Intent intent2;
        if ("contact_info_see_locate".endsWith(str)) {
            d$a bnL = bnL();
            str2 = bnL.url;
            intent = new Intent();
            intent.putExtra("rawUrl", str2);
            intent.putExtra("useJs", true);
            intent.putExtra("vertical_scroll", true);
            intent.putExtra("geta8key_scene", 3);
            intent.putExtra("KPublisherId", "brand_profile");
            intent.putExtra("prePublishId", "brand_profile");
            if ((this.lVQ != null && (this.eLK == 39 || this.eLK == 56 || this.eLK == 35)) || this.eLK == 87 || this.eLK == 89 || this.eLK == 85 || this.eLK == 88) {
                x.d("MicroMsg.NewBizInfoMoreInofUI", "from biz search.");
                Bundle bundle = new Bundle();
                bundle.putBoolean("KFromBizSearch", true);
                bundle.putBundle("KBizSearchExtArgs", this.lVQ);
                intent.putExtra("jsapiargs", bundle);
                i2 = com.tencent.mm.l.a.gd(this.guS.field_type) ? 7 : 6;
                int identifier = getResources().getIdentifier(bnL.dKS, "string", getPackageName());
                str3 = bnL.title;
                if (identifier > 0) {
                    str3 = getString(identifier);
                }
                ay(i2, str3);
            }
            com.tencent.mm.bg.d.b(this, "webview", ".ui.tools.WebViewUI", intent);
            return true;
        } else if ("contact_info_verifyuser".endsWith(str)) {
            dVar = this.lUs;
            if (dVar == null) {
                return true;
            }
            d$b bG = dVar.bG(false);
            if (bG == null) {
                return true;
            }
            str2 = null;
            if (bG.Mt() != null && !bi.oW(bG.Mt().dLL)) {
                str2 = bG.Mt().dLL;
            } else if (!(bG.Mu() == null || bi.oW(bG.Mu().dLT))) {
                str2 = bG.Mu().dLT;
            }
            if (!bi.oW(str2)) {
                intent2 = new Intent();
                intent2.putExtra("rawUrl", str2);
                intent2.putExtra("useJs", true);
                intent2.putExtra("vertical_scroll", true);
                intent2.putExtra("geta8key_scene", 3);
                com.tencent.mm.bg.d.b(this, "webview", ".ui.tools.WebViewUI", intent2);
            }
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bT(this.guS.field_username, 1200);
            return true;
        } else if ("contact_info_trademark".endsWith(str)) {
            dVar = this.lUs;
            if (dVar == null || dVar.bG(false) == null || bi.oW(dVar.bG(false).Mm())) {
                return true;
            }
            intent2 = new Intent();
            intent2.putExtra("rawUrl", dVar.bG(false).Mm());
            intent2.putExtra("useJs", true);
            intent2.putExtra("vertical_scroll", true);
            intent2.putExtra("geta8key_scene", 3);
            com.tencent.mm.bg.d.b(this, "webview", ".ui.tools.WebViewUI", intent2);
            return true;
        } else {
            if ("contact_info_service_phone".equals(str)) {
                Preference ZZ = fVar.ZZ("contact_info_service_phone");
                if (!(ZZ == null || ZZ.getSummary() == null || bi.oW(ZZ.getSummary().toString()))) {
                    str3 = ZZ.getSummary().toString();
                    h.a(this, true, str3, "", getString(R.l.contact_info_dial), getString(R.l.app_cancel), new 3(this, str3), null);
                }
            }
            if (str.startsWith("contact_info_bizinfo_external#")) {
                i2 = bi.getInt(str.replace("contact_info_bizinfo_external#", ""), -1);
                if (i2 >= 0 && i2 < this.dKO.size()) {
                    d$a d_a = (d$a) this.dKO.get(i2);
                    str3 = d_a.url;
                    intent = new Intent();
                    intent.putExtra("rawUrl", str3);
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    intent.putExtra("geta8key_scene", 3);
                    intent.putExtra("KPublisherId", "brand_profile");
                    intent.putExtra("prePublishId", "brand_profile");
                    if ((this.lVQ != null && (this.eLK == 39 || this.eLK == 56 || this.eLK == 35)) || this.eLK == 87 || this.eLK == 89 || this.eLK == 85 || this.eLK == 88) {
                        x.d("MicroMsg.NewBizInfoMoreInofUI", "from biz search.");
                        Bundle bundle2 = new Bundle();
                        bundle2.putBoolean("KFromBizSearch", true);
                        bundle2.putBundle("KBizSearchExtArgs", this.lVQ);
                        intent.putExtra("jsapiargs", bundle2);
                        if (!com.tencent.mm.l.a.gd(this.guS.field_type)) {
                            i = 6;
                        }
                        int identifier2 = getResources().getIdentifier(d_a.dKS, "string", getPackageName());
                        str2 = d_a.title;
                        if (identifier2 > 0) {
                            str2 = getString(identifier2);
                        }
                        ay(i, str2);
                    }
                    com.tencent.mm.bg.d.b(this, "webview", ".ui.tools.WebViewUI", intent);
                    return true;
                }
            }
            if (str.equals("contact_info_verifyuser_weibo")) {
                new com.tencent.mm.plugin.profile.ui.a.a(this).ef(this.guS.csO, this.guS.field_username);
                return true;
            }
            Intent intent3;
            if (!(!"contact_info_guarantee_info".equals(str) || this.dKP.Mr() == null || bi.oW(this.dKP.Mr().dLQ))) {
                intent3 = new Intent();
                intent3.putExtra("rawUrl", this.dKP.Mr().dLQ);
                intent3.putExtra("useJs", true);
                intent3.putExtra("vertical_scroll", true);
                intent3.putExtra("geta8key_scene", 3);
                com.tencent.mm.bg.d.b(this, "webview", ".ui.tools.WebViewUI", intent3);
            }
            if (!(!"contact_info_expose_btn".equals(str) || this.guS == null || bi.oW(this.guS.field_username))) {
                intent3 = new Intent();
                intent3.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect", new Object[]{this.guS.field_username}));
                intent3.putExtra("showShare", false);
                com.tencent.mm.bg.d.b(this, "webview", ".ui.tools.WebViewUI", intent3);
            }
            return false;
        }
    }

    private void ay(int i, String str) {
        if (this.lVQ == null || !(this.eLK == 39 || this.eLK == 56 || this.eLK == 35 || this.eLK == 87 || this.eLK == 88 || this.eLK == 89 || this.eLK == 85)) {
            x.d("MicroMsg.NewBizInfoMoreInofUI", "mExtArgs is null or the add contact action is not from biz search.");
        } else if (this.guS == null) {
            x.i("MicroMsg.NewBizInfoMoreInofUI", "contact is null.");
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
                case f$k.AppCompatTheme_colorControlHighlight /*87*/:
                    i2 = 2;
                    break;
                case f$k.AppCompatTheme_colorButtonNormal /*88*/:
                    i2 = 3;
                    break;
                case f$k.AppCompatTheme_colorSwitchThumbNormal /*89*/:
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
            x.v("MicroMsg.NewBizInfoMoreInofUI", "report 10866: %s", new Object[]{str2});
            com.tencent.mm.plugin.report.service.h.mEJ.k(10866, str2);
        }
    }
}
