package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.k;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.plugin.y.d;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.aiv;
import com.tencent.mm.s.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSummaryPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.y;

public class SettingsAboutMicroMsgUI extends MMPreference implements e {
    private f eOE;
    private boolean mQU = false;
    private aiv mQV;
    private int mQW = 0;
    Intent mQX = null;
    private ProgressDialog mQY;
    private al mQZ;
    private e mRa = null;

    static /* synthetic */ void b(SettingsAboutMicroMsgUI settingsAboutMicroMsgUI) {
        o DF = g.DF();
        3 3 = new 3(settingsAboutMicroMsgUI);
        settingsAboutMicroMsgUI.mRa = 3;
        DF.a(255, 3);
        r rVar = new r(2);
        rVar.efX = 1;
        g.DF().a(rVar, 0);
        settingsAboutMicroMsgUI.mQZ = new al(Looper.getMainLooper(), new 4(settingsAboutMicroMsgUI, rVar), false);
        settingsAboutMicroMsgUI.mQZ.J(3000, 3000);
        ActionBarActivity actionBarActivity = settingsAboutMicroMsgUI.mController.tml;
        settingsAboutMicroMsgUI.getString(i.app_tip);
        settingsAboutMicroMsgUI.mQY = h.a(actionBarActivity, settingsAboutMicroMsgUI.getString(i.wx_exit_processing_txt), false, new 5(settingsAboutMicroMsgUI, rVar));
    }

    static /* synthetic */ void g(SettingsAboutMicroMsgUI settingsAboutMicroMsgUI) {
        af.Wq("welcome_page_show");
        k.j(settingsAboutMicroMsgUI, true);
        b.ezo.vo();
        ((a) g.n(a.class)).getNotification().xR();
        com.tencent.mm.pluginsdk.f.e.qBn.bc(settingsAboutMicroMsgUI.mController.tml);
        settingsAboutMicroMsgUI.finish();
    }

    public final int Ys() {
        return com.tencent.mm.plugin.setting.a.k.settings_pref_about_micromsg;
    }

    public final View btw() {
        LinearLayout linearLayout = (LinearLayout) y.gq(this.mController.tml).inflate(com.tencent.mm.plugin.setting.a.g.settings_about_micromsg_footer, null);
        TextView textView = (TextView) linearLayout.findViewById(com.tencent.mm.plugin.setting.a.f.terms_of_service);
        TextView textView2 = (TextView) linearLayout.findViewById(com.tencent.mm.plugin.setting.a.f.terms_of_privacy);
        String obj = g.Ei().DT().get(274436, "").toString();
        if (bi.oW(obj)) {
            obj = w.chO();
        }
        obj = getString(i.license_read_url, new Object[]{w.chP(), obj, "setting", Integer.valueOf(0), Integer.valueOf(0)});
        textView.setText(String.format("<a href='%s'>%s</a>", new Object[]{getString(i.url_agreement), getString(i.license_detail)}));
        textView2.setText(String.format("<a href='%s'>%s</a>", new Object[]{obj, getString(i.privacy_detail)}));
        j.g(textView, 1);
        j.g(textView2, 1);
        ((TextView) linearLayout.findViewById(com.tencent.mm.plugin.setting.a.f.copyright_desc_tv)).setText(linearLayout.getResources().getString(i.app_copyright, new Object[]{Integer.valueOf(2018)}));
        return linearLayout;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cqh();
        initView();
        g.DF().a(11, this);
        if (d.bfB() != null) {
            g.DF().a((l) d.bfB().bfA(), 0);
            com.tencent.mm.plugin.report.service.h.mEJ.a(405, 15, 1, true);
        }
    }

    public void onResume() {
        super.onResume();
        btx();
    }

    public void onDestroy() {
        g.DF().b(11, this);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(i.settings_what_new);
        setBackBtn(new 1(this));
        btx();
    }

    private void btx() {
        IconPreference iconPreference;
        boolean z;
        this.eOE = this.tCL;
        this.eOE.removeAll();
        this.eOE.addPreferencesFromResource(com.tencent.mm.plugin.setting.a.k.settings_pref_about_micromsg);
        SettingsAboutMMHeaderPreference settingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference) this.eOE.ZZ("settings_about_mm_header");
        String aj = com.tencent.mm.sdk.platformtools.e.aj(this.mController.tml, com.tencent.mm.protocal.d.qVN);
        if (com.tencent.mm.protocal.d.qVQ) {
            aj = aj + " " + getString(i.alpha_version_alpha);
        }
        settingsAboutMMHeaderPreference.mQR = aj;
        if (w.chM()) {
            int f = bi.f((Integer) g.Ei().DT().get(12304, null));
            iconPreference = (IconPreference) this.eOE.ZZ("settings_update");
            if (f > 0) {
                iconPreference.Er(0);
                iconPreference.dk(String.valueOf(f), com.tencent.mm.ui.tools.r.hd(this.mController.tml));
            } else {
                iconPreference.Er(8);
                iconPreference.dk("", -1);
            }
        }
        if ((com.tencent.mm.sdk.platformtools.e.bxm & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        IconSummaryPreference iconSummaryPreference;
        if (this.mQU && !com.tencent.mm.sdk.platformtools.e.sFF) {
            iconSummaryPreference = (IconSummaryPreference) this.eOE.ZZ("funtion_update");
            iconSummaryPreference.mQk = 0;
            CharSequence aj2 = com.tencent.mm.sdk.platformtools.e.aj(null, this.mQW);
            iconSummaryPreference.dk(getString(i.app_new), com.tencent.mm.plugin.setting.a.e.new_tips_bg);
            iconSummaryPreference.setSummary(aj2);
            iconSummaryPreference.tCq = 0;
            if (iconSummaryPreference.tCr != null) {
                iconSummaryPreference.tCr.setVisibility(iconSummaryPreference.tCq);
            }
            this.eOE.aaa("funtion_check_update");
        } else if (z || this.mQV == null || this.mQV.rLD == 0 || bi.oW(this.mQV.rLE) || com.tencent.mm.sdk.platformtools.e.sFF) {
            this.eOE.aaa("funtion_update");
        } else {
            x.i("MicroMsg.SettingsAboutMicroMsgUI", "show alpha update. url:%s, hint:%d", new Object[]{this.mQV.rLE, Integer.valueOf(this.mQV.rLF)});
            if (this.mQV.rLF != 0) {
                iconSummaryPreference = (IconSummaryPreference) this.eOE.ZZ("funtion_update");
                iconSummaryPreference.mQk = 0;
                iconSummaryPreference.dk(getString(i.app_new), com.tencent.mm.plugin.setting.a.e.new_tips_bg);
                this.eOE.aaa("funtion_check_update");
            } else {
                this.eOE.aaa("funtion_update");
            }
        }
        if (!w.chM()) {
            this.eOE.bw("settings_report", true);
        }
        com.tencent.mm.pluginsdk.f.e.qBn.vx();
        this.eOE.bw("funtion_about_wechat", true);
        if (bi.oW((String) g.Ei().DT().get(aa.a.sXa, null))) {
            this.eOE.aaa("funtion_crowdtest_update");
        } else {
            iconPreference = (IconPreference) this.eOE.ZZ("funtion_crowdtest_update");
            if (c.Cp().aU(262157, 266263)) {
                iconPreference.Et(0);
            }
        }
        this.eOE.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.mKey;
        x.i("MicroMsg.SettingsAboutMicroMsgUI", str + " item has been clicked!");
        Intent intent;
        if (str.equals("settings_update")) {
            if (w.chM()) {
                g.Eg();
                int Df = com.tencent.mm.kernel.a.Df();
                int f = bi.f((Integer) g.Ei().DT().get(12304, null));
                str = getString(i.settings_system_notice_url, new Object[]{Integer.valueOf(Df), Integer.valueOf(f)});
                if (str == null) {
                    return true;
                }
                g.Ei().DT().set(12304, Integer.valueOf(0));
                intent = new Intent();
                intent.putExtra("title", getString(i.settings_system_notice));
                intent.putExtra("rawUrl", str);
                intent.putExtra("showShare", false);
                com.tencent.mm.bg.d.b(this.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
                return true;
            }
            if (w.chM()) {
                str = getString(i.settings_funtion_update_cv_url, new Object[]{w.chP(), Integer.valueOf(com.tencent.mm.protocal.d.qVN)});
            } else {
                str = "http://blog.wechat.com/";
            }
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            com.tencent.mm.bg.d.b(this.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
            return true;
        } else if (str.equals("funtion_update")) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(405, 16, 1, true);
            str = "";
            if (this.mQU) {
                str = getString(i.settings_funtion_update_nv_url, new Object[]{w.chP(), Integer.valueOf(this.mQW)});
            } else if (!(this.mQV == null || this.mQV.rLD == 0 || bi.oW(this.mQV.rLE))) {
                str = this.mQV.rLE;
            }
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", true);
            intent.putExtra("show_bottom", false);
            com.tencent.mm.bg.d.b(this.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
            return true;
        } else if (str.equals("funtion_check_update")) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(405, 17, 1, true);
            if (d.bfB() != null) {
                d.bfB().bfz();
                if ((com.tencent.mm.sdk.platformtools.e.bxm & 1) != 0) {
                    x.e("MicroMsg.SettingsAboutMicroMsgUI", "package has set external update mode");
                    Uri parse = Uri.parse(com.tencent.mm.sdk.platformtools.e.sFB);
                    intent = new Intent("android.intent.action.VIEW", parse).addFlags(268435456);
                    if (parse == null || intent == null || !bi.k(this.mController.tml, intent)) {
                        x.e("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri failed, jump to weixin.qq.com");
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(268435456));
                        com.tencent.mm.plugin.report.service.h.mEJ.a(405, 18, 1, true);
                        return true;
                    }
                    x.i("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri ok");
                    startActivity(intent);
                    com.tencent.mm.plugin.report.service.h.mEJ.a(405, 19, 1, true);
                    return true;
                } else if (this.mQV == null || this.mQV.rLD == 0 || bi.oW(this.mQV.rLE)) {
                    ad.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bi.VE()).commit();
                    com.tencent.mm.plugin.y.a a = d.bfB().a(this, new 6(this));
                    if (a == null) {
                        com.tencent.mm.plugin.report.service.h.mEJ.a(405, 21, 1, true);
                    } else {
                        com.tencent.mm.plugin.report.service.h.mEJ.a(405, 22, 1, true);
                        a.update(3);
                        return true;
                    }
                } else {
                    str = this.mQV.rLE;
                    intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    com.tencent.mm.bg.d.b(this.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
                    com.tencent.mm.plugin.report.service.h.mEJ.a(405, 20, 1, true);
                    return true;
                }
            }
            return false;
        } else if (str.equals("funtion_about_wechat")) {
            return true;
        } else {
            if (str.equals("settings_report")) {
                intent = new Intent();
                intent.putExtra("showShare", false);
                intent.putExtra("show_feedback", false);
                intent.putExtra("rawUrl", "https://support.weixin.qq.com/security/readtemplate?t=complaints/index");
                com.tencent.mm.bg.d.b(this.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
                return true;
            } else if (str.equals("settings_quit_wechat")) {
                h.a(this.mController.tml, i.main_exit_warning, i.main_exit_title, i.app_yes, i.app_no, new 2(this), null);
                return true;
            } else if (!str.equals("funtion_crowdtest_update")) {
                return false;
            } else {
                c.Cp().aV(262157, 266263);
                str = (String) g.Ei().DT().get(aa.a.sXa, null);
                intent = new Intent();
                intent.putExtra("rawUrl", str);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.bg.d.b(this.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
                return true;
            }
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.SettingsAboutMicroMsgUI", "onSceneEnd " + i2 + " errType " + i);
        com.tencent.mm.plugin.y.b bVar = (com.tencent.mm.plugin.y.b) lVar;
        x.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.getDownloadUrls() " + bVar.bfx());
        x.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.getPackVersion() " + bVar.bfw());
        x.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.now getPackVersion() " + com.tencent.mm.protocal.d.qVN);
        if (d.lrA || (i == 0 && i2 == 0)) {
            this.mQW = bVar.bfw();
            if (this.mQW <= 0 || this.mQW <= com.tencent.mm.protocal.d.qVN) {
                this.mQU = false;
                if (g.Eg().Dx()) {
                    c.Cp().u(262145, false);
                } else {
                    x.e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBadge() uin not ready!");
                }
            } else {
                this.mQU = true;
                if (g.Eg().Dx()) {
                    c.Cp().u(262145, true);
                } else {
                    x.e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBadge() uin not ready!");
                }
            }
            this.mQV = bVar.bfy();
        }
        btx();
    }
}
