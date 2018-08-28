package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.bqd;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.a;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import com.tencent.mm.ui.e.e;
import com.tencent.mm.ui.widget.a.c;
import java.util.HashMap;
import java.util.Map.Entry;

public class SettingsPrivacyUI extends MMPreference {
    private String cXR = "";
    private HashMap<Integer, Integer> eGU = new HashMap();
    private f eOE;
    boolean hLI = false;
    private boolean mRv = false;
    private boolean mTp = true;
    private boolean mTq = false;
    private boolean mTr = false;
    private boolean mTs = false;
    private boolean mTt = true;
    private int mTu = e.thv;
    private int status;

    public final h a(SharedPreferences sharedPreferences) {
        return new a(this, sharedPreferences);
    }

    public final int Ys() {
        return k.settings_about_privacy;
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        this.eOE = this.tCL;
        this.status = q.GJ();
        this.cXR = q.GF();
        this.mTt = bi.a((Boolean) g.Ei().DT().get(68384, null), true);
        this.mTu = getIntent().getIntExtra("enter_scene", e.thv);
        x.d("MicroMsg.SettingPrivacy", "sns Notify " + this.mTt);
        initView();
        com.tencent.mm.plugin.report.service.h.mEJ.h(14098, new Object[]{Integer.valueOf(9)});
        if (this.mTu == e.thw || this.mTu == e.thx) {
            bqd bqd = new bqd();
            if (n.nky != null) {
                bqd = n.nky.Lv(this.cXR);
            }
            if (bqd != null) {
                boolean z2;
                int i = bqd.sod;
                this.mTq = (i & 512) > 0;
                if ((i & 1024) > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.mTr = z2;
                if ((i & 2048) <= 0) {
                    z = false;
                }
                this.mTs = z;
            }
            btT();
        }
    }

    protected void onResume() {
        super.onResume();
        this.status = q.GJ();
        btU();
        if (!this.hLI) {
            String stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
            if (!bi.oW(stringExtra)) {
                int aab = this.eOE.aab(stringExtra);
                setSelection(aab - 3);
                new ag().postDelayed(new 1(this, aab), 10);
            }
            this.hLI = true;
        }
    }

    public void onPause() {
        super.onPause();
        g.Ei().DT().set(7, Integer.valueOf(this.status));
        for (Entry entry : this.eGU.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            xt xtVar = new xt();
            xtVar.rDz = intValue;
            xtVar.rDA = intValue2;
            ((i) g.l(i.class)).FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(23, xtVar));
            x.d("MicroMsg.SettingPrivacy", "switch  " + intValue + " " + intValue2);
        }
        this.eGU.clear();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = true;
        boolean z2 = false;
        String str = preference.mKey;
        x.i("MicroMsg.SettingPrivacy", str + " item has been clicked!");
        if (str.equals("settings_need_verify")) {
            return d(((CheckBoxPreference) fVar.ZZ("settings_need_verify")).isChecked(), 32, 4);
        }
        if (str.equals("settings_recommend_mobilefriends_to_me")) {
            boolean z3;
            if (((CheckBoxPreference) fVar.ZZ("settings_recommend_mobilefriends_to_me")).isChecked()) {
                z3 = false;
            } else {
                z3 = true;
            }
            return d(z3, 256, 7);
        } else if (str.equals("settings_about_blacklist")) {
            com.tencent.mm.model.x xVar = y.if(getString(com.tencent.mm.plugin.setting.a.i.group_blacklist));
            Intent intent = new Intent();
            intent.putExtra("filter_type", xVar.getType());
            intent.putExtra("titile", getString(com.tencent.mm.plugin.setting.a.i.settings_private_blacklist));
            intent.putExtra("list_attr", 32768);
            b.ezn.h(this, intent);
            return true;
        } else {
            Intent intent2;
            if (str.equals("timline_outside_permiss")) {
                intent2 = new Intent();
                intent2.putExtra("k_sns_tag_id", 4);
                intent2.putExtra("k_sns_from_settings_about_sns", 1);
                d.b((Context) this, "sns", ".ui.SnsBlackDetailUI", intent2);
            } else if (str.equals("edit_timeline_group")) {
                d.A(this, "sns", ".ui.SnsTagPartlyUI");
            } else if (str.equals("timeline_black_permiss")) {
                intent2 = new Intent();
                intent2.putExtra("k_sns_tag_id", 5);
                intent2.putExtra("k_sns_from_settings_about_sns", 2);
                intent2.putExtra("k_tag_detail_sns_block_scene", 8);
                d.b((Context) this, "sns", ".ui.SnsTagDetailUI", intent2);
            } else if (str.equals("timeline_stranger_show")) {
                if (this.mRv) {
                    z = false;
                }
                this.mRv = z;
                if (n.nky != null) {
                    n.nky.aQ(this.cXR, this.mRv);
                }
                if (n.nky != null) {
                    bqd aR = n.nky.aR(this.cXR, this.mRv);
                    n.nky.a(this.cXR, aR);
                    if (aR == null) {
                        x.e("MicroMsg.SettingPrivacy", "userinfo in null !");
                        return false;
                    }
                    x.d("MicroMsg.SettingPrivacy", "dancy userinfo " + aR.toString());
                    ((i) g.l(i.class)).FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(51, aR));
                }
            } else if (str.equals("settings_find_google_contact")) {
                if (!((CheckBoxPreference) fVar.ZZ("settings_find_google_contact")).isChecked()) {
                    z2 = true;
                }
                d(z2, 1048576, 29);
                return true;
            } else if (str.equals("settings_add_me_way")) {
                startActivity(new Intent(this, SettingsAddMeUI.class));
                return true;
            } else if (str.equals("timeline_recent_show_select")) {
                btT();
            } else if (str.equals("settings_sns_notify")) {
                this.mTt = !this.mTt;
                if (this.mTt) {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(14098, new Object[]{Integer.valueOf(3)});
                } else {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(14098, new Object[]{Integer.valueOf(4)});
                }
                g.Ei().DT().set(68384, Boolean.valueOf(this.mTt));
                btU();
                return true;
            } else if (str.equals("settings_unfamiliar_contact")) {
                startActivity(new Intent(this, UnfamiliarContactUI.class));
            } else if (str.equals("settings_privacy_agreements")) {
                str = g.Ei().DT().get(274436, "").toString();
                if (bi.oW(str)) {
                    str = w.chO();
                }
                com.tencent.mm.platformtools.a.b(this, getString(j.license_read_url, new Object[]{w.chP(), str, "setting", Integer.valueOf(0), Integer.valueOf(0)}), 0, false);
            } else if (str.equals("settings_auth_manage")) {
                startActivity(new Intent(this, SettingsManageAuthUI.class));
            }
            return false;
        }
    }

    private void btT() {
        bqd Lv;
        bqd bqd = new bqd();
        if (n.nky != null) {
            Lv = n.nky.Lv(this.cXR);
        } else {
            Lv = bqd;
        }
        if (Lv == null) {
            x.e("MicroMsg.SettingPrivacy", "userinfo is null");
            return;
        }
        int intValue = ((Integer) g.Ei().DT().get(aa.a.sWj, Integer.valueOf(0))).intValue();
        if (intValue > ((Integer) g.Ei().DT().get(aa.a.sWk, Integer.valueOf(0))).intValue()) {
            g.Ei().DT().a(aa.a.sWk, Integer.valueOf(intValue));
            btU();
        }
        c.a aVar = new c.a(this.mController.tml);
        aVar.Gu(com.tencent.mm.plugin.setting.a.i.app_cancel);
        aVar.Gq(com.tencent.mm.plugin.setting.a.i.contact_info_feedsapp_recent_select);
        View inflate = View.inflate(this.mController.tml, com.tencent.mm.plugin.setting.a.g.mm_alert_switch, null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(com.tencent.mm.plugin.setting.a.f.switcher_container);
        2 2 = new 2(this, linearLayout);
        int i = Lv.sod;
        a(linearLayout, com.tencent.mm.plugin.setting.a.i.contact_info_feedsapp_recent_select_half_year, 1, this.mTq, 2);
        a(linearLayout, com.tencent.mm.plugin.setting.a.i.contact_info_feedsapp_recent_select_three_day, 0, this.mTr, 2);
        int i2 = com.tencent.mm.plugin.setting.a.i.contact_info_feedsapp_recent_select_all;
        boolean z = (this.mTq || this.mTr) ? false : true;
        a(linearLayout, i2, 2, z, 2);
        aVar.dR(inflate);
        c anj = aVar.anj();
        linearLayout.setTag(anj);
        anj.show();
        addDialog(anj);
    }

    private void a(LinearLayout linearLayout, int i, int i2, boolean z, OnClickListener onClickListener) {
        TextView textView = (TextView) View.inflate(this.mController.tml, com.tencent.mm.plugin.setting.a.g.radio_btn_item, null);
        textView.setText(i);
        textView.setTag(Integer.valueOf(i2));
        linearLayout.addView(textView);
        textView.setOnClickListener(onClickListener);
        if (z) {
            textView.setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.plugin.setting.a.h.radio_on, 0, 0, 0);
        }
    }

    protected final void initView() {
        boolean z = false;
        setMMTitle(com.tencent.mm.plugin.setting.a.i.settings_about_privacy);
        setBackBtn(new 3(this));
        x.v("MicroMsg.SettingPrivacy", "init function status: " + Integer.toBinaryString(this.status));
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("settings_need_verify");
        checkBoxPreference.tDr = false;
        checkBoxPreference.qpJ = uL(32);
        String str = (String) g.Ei().DT().get(6, null);
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.eOE.ZZ("settings_recommend_mobilefriends_to_me");
        checkBoxPreference2.tDr = false;
        if (str == null || str.length() <= 0) {
            this.eOE.c(checkBoxPreference2);
        } else {
            checkBoxPreference2.qpJ = !uL(256);
        }
        checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("settings_find_google_contact");
        checkBoxPreference.tDr = false;
        if (!uL(1048576)) {
            z = true;
        }
        checkBoxPreference.qpJ = z;
        String str2 = (String) g.Ei().DT().get(208903, null);
        if (!bi.fU(this) || TextUtils.isEmpty(str2)) {
            this.eOE.c(checkBoxPreference);
        }
        if (!(((Boolean) g.Ei().DT().get(335873, Boolean.valueOf(true))).booleanValue() && n.nkA.bwW())) {
            this.eOE.bw("edit_timeline_group", true);
        }
        this.eOE.bw("settings_unfamiliar_contact", true);
        Preference ZZ = this.eOE.ZZ("settings_privacy_agreements");
        str2 = getString(com.tencent.mm.plugin.setting.a.i.privacy_detail);
        CharSequence newSpannable = Factory.getInstance().newSpannable(getString(com.tencent.mm.plugin.setting.a.i.privacy_detail_tip) + str2);
        newSpannable.setSpan(new ForegroundColorSpan(getResources().getColor(com.tencent.mm.plugin.setting.a.c.link_color)), newSpannable.length() - str2.length(), newSpannable.length(), 33);
        ZZ.setTitle(newSpannable);
        this.eOE.notifyDataSetChanged();
    }

    private boolean uL(int i) {
        return (this.status & i) != 0;
    }

    private boolean d(boolean z, int i, int i2) {
        x.d("MicroMsg.SettingPrivacy", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.status |= i;
        } else {
            this.status &= i ^ -1;
        }
        this.eGU.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
        return true;
    }

    private void btU() {
        bqd bqd = new bqd();
        if (n.nky != null) {
            bqd = n.nky.Lv(this.cXR);
        }
        if (bqd == null) {
            x.e("MicroMsg.SettingPrivacy", "userinfo is null");
            return;
        }
        boolean z;
        int i = bqd.sod;
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("timeline_stranger_show");
        if (checkBoxPreference != null) {
            checkBoxPreference.tDr = false;
            this.mRv = (i & 1) > 0;
            if (this.mRv) {
                checkBoxPreference.qpJ = false;
            } else {
                checkBoxPreference.qpJ = true;
            }
        }
        IconPreference iconPreference = (IconPreference) this.eOE.ZZ("timeline_recent_show_select");
        if (iconPreference != null) {
            boolean z2;
            iconPreference.tDr = false;
            if ((i & 512) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.mTq = z2;
            if ((i & 1024) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.mTr = z2;
            if ((i & 2048) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.mTs = z2;
            if (this.mTq) {
                iconPreference.setSummary(com.tencent.mm.plugin.setting.a.i.contact_info_feedsapp_recent_select_half_year);
            } else if (this.mTr) {
                iconPreference.setSummary(com.tencent.mm.plugin.setting.a.i.contact_info_feedsapp_recent_select_three_day);
            } else {
                iconPreference.setSummary(com.tencent.mm.plugin.setting.a.i.contact_info_feedsapp_recent_select_all);
            }
            x.i("MicroMsg.SettingPrivacy", "willShowRecentRedCodeId  %d, currentRecentRedCodeId %d", new Object[]{Integer.valueOf(((Integer) g.Ei().DT().get(aa.a.sWj, Integer.valueOf(0))).intValue()), Integer.valueOf(((Integer) g.Ei().DT().get(aa.a.sWk, Integer.valueOf(0))).intValue())});
            if (((Integer) g.Ei().DT().get(aa.a.sWj, Integer.valueOf(0))).intValue() > ((Integer) g.Ei().DT().get(aa.a.sWk, Integer.valueOf(0))).intValue()) {
                iconPreference.Et(0);
            } else {
                iconPreference.Et(8);
            }
        }
        if (d.QS("sns") && (q.GQ() & 32768) == 0) {
            z = true;
        } else {
            z = false;
        }
        this.mTp = z;
        String str = "MicroMsg.SettingPrivacy";
        StringBuilder append = new StringBuilder("isSnsOpenEntrance ").append(this.mTp).append(", install ").append(d.QS("sns")).append(", flag ");
        if ((q.GQ() & 32768) == 0) {
            z = true;
        } else {
            z = false;
        }
        x.i(str, append.append(z).toString());
        if (this.mTp) {
            this.eOE.bw("settings_sns_notify", false);
        } else {
            this.eOE.bw("settings_sns_notify", true);
        }
        if (this.mTp) {
            checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("settings_sns_notify");
            if (checkBoxPreference != null) {
                checkBoxPreference.tDr = false;
                this.mTt = bi.a((Boolean) g.Ei().DT().get(68384, null), true);
                if (this.mTt) {
                    checkBoxPreference.qpJ = true;
                } else {
                    checkBoxPreference.qpJ = false;
                }
            }
        }
        this.eOE.notifyDataSetChanged();
    }
}
