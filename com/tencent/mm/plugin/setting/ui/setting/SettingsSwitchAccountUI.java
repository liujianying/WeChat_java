package com.tencent.mm.plugin.setting.ui.setting;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.ja;
import com.tencent.mm.g.a.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.k;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bt;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.modelsimple.p;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.plugin.account.ui.LoginPasswordUI;
import com.tencent.mm.plugin.account.ui.LoginVoiceUI;
import com.tencent.mm.plugin.account.ui.MobileInputUI;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.a.c;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.4;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.5;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.6;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.b;
import com.tencent.mm.protocal.c.arm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@a(19)
public class SettingsSwitchAccountUI extends MMActivity implements e {
    private TextView eFH;
    private String eSe;
    private SwitchAccountGridView mPR;
    private Map<String, SwitchAccountModel> mPV = new HashMap();
    private boolean mSv;
    private TextView mTW;
    private View mTX;
    private View mTY;
    private TextView mTZ;
    private ValueAnimator mUa;
    private al mUb;
    private boolean mUc;
    private boolean mUd;
    private int scene;
    private TextView titleView;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        Intent intent;
        setMMTitle("");
        cqi();
        getSupportActionBar().hide();
        if (d.fR(23)) {
            getWindow().setStatusBarColor(getResources().getColor(c.navpage));
            cqc();
        }
        this.scene = getIntent().getIntExtra("key_scene", 0);
        this.mTX = findViewById(f.switch_account_title_container);
        this.mTY = findViewById(f.switch_account_icon);
        this.titleView = (TextView) findViewById(f.switch_account_title);
        this.mTZ = (TextView) findViewById(f.switch_account_del_tip);
        this.mTW = (TextView) findViewById(f.switch_account_delete_btn);
        this.eFH = (TextView) findViewById(f.switch_account_cancel_btn);
        this.mPR = (SwitchAccountGridView) findViewById(f.switch_account_grid);
        this.mPR.setRowCount(1);
        this.mPR.setOnClickAvatarListener(new b() {
            public final void KY(String str) {
                if (bi.oW(str)) {
                    ad.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putString("last_switch_account_to_wx_username", "").commit();
                    if (SettingsSwitchAccountUI.this.scene == 0) {
                        SettingsSwitchAccountUI.logout();
                        return;
                    }
                    Intent intent = new Intent(SettingsSwitchAccountUI.this, MobileInputUI.class);
                    intent.putExtra("mobile_input_purpose", 1);
                    intent.putExtra("from_switch_account", true);
                    SettingsSwitchAccountUI.this.startActivity(intent);
                    com.tencent.mm.ui.base.b.gD(SettingsSwitchAccountUI.this);
                } else if (SettingsSwitchAccountUI.this.scene == 0) {
                    SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, str);
                } else {
                    SettingsSwitchAccountUI.this.KX(str);
                }
            }
        });
        if (this.scene == 0) {
            this.eFH.setOnClickListener(new 3(this));
        } else {
            this.eFH.setVisibility(8);
        }
        Set<String> IH = bt.dDs.IH();
        g.Eg();
        if (com.tencent.mm.kernel.a.Dw()) {
            this.eSe = (String) g.Ei().DT().get(2, null);
        } else {
            this.eSe = at.dBv.I("login_weixin_username", "");
        }
        x.i("MicroMsg.SettingsSwitchAccountUI", "scene %d， lastLoginWxUsername %s", new Object[]{Integer.valueOf(this.scene), this.eSe});
        if (bi.oW(this.eSe) || IH.contains(this.eSe)) {
            if (!IH.isEmpty()) {
                for (String str : IH) {
                    this.mPV.put(str, new SwitchAccountModel(str, bt.dDs.getString(str, "login_user_name"), bt.dDs.getString(str, "last_avatar_path"), bt.dDs.getString(str, "last_logout_no_pwd_ticket"), bi.WU(bt.dDs.getString(str, "last_login_use_voice"))));
                }
            }
        } else if (this.scene != 2 || bt.dDs.iN(this.eSe)) {
            this.mPV.put(this.eSe, new SwitchAccountModel(this.eSe, at.dBv.I("login_user_name", ""), at.dBv.HL(), "", bi.WU(at.dBv.I("last_login_use_voice", ""))));
        }
        if (this.mPV.size() == 0) {
            intent = new Intent(this, MobileInputUI.class);
            intent.putExtra("mobile_input_purpose", 1);
            intent.putExtra("can_finish", true);
            startActivity(intent);
            finish();
            com.tencent.mm.ui.base.b.gG(this);
        }
        K(this.mPV);
        this.mPR.L(this.mPV);
        if (this.scene == 1) {
            String string = ad.getContext().getSharedPreferences("switch_account_preferences", 0).getString("last_switch_account_to_wx_username", "");
            x.i("MicroMsg.SettingsSwitchAccountUI", "switch to %s", new Object[]{string});
            if (bi.oW(string)) {
                this.mUc = false;
                intent = new Intent(this, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 1);
                intent.putExtra("from_switch_account", true);
                startActivity(intent);
                com.tencent.mm.ui.base.b.gD(this);
            } else {
                g.Eg();
                if (com.tencent.mm.kernel.a.Dw()) {
                    x.w("MicroMsg.SettingsSwitchAccountUI", "already login ,quit");
                    finish();
                } else {
                    KX(string);
                }
            }
        } else if (this.scene == 0) {
            this.mPR.setLastLoginWxUsername(this.eSe);
        }
        this.mPR.bum();
        btV();
        this.mPR.setOnDeleteAvatarListener(new 4(this));
        this.mUa = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.mUa.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SettingsSwitchAccountUI.this.mPR.setTranslationY((-((Float) valueAnimator.getAnimatedValue()).floatValue()) * ((float) SettingsSwitchAccountUI.this.mPR.getHeight()));
            }
        });
        this.mUa.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                x.i("MicroMsg.SettingsSwitchAccountUI", "up animation end");
                Intent be = com.tencent.mm.plugin.account.a.a.ezn.be(SettingsSwitchAccountUI.this);
                be.addFlags(67108864);
                SettingsSwitchAccountUI.this.startActivity(be);
                SettingsSwitchAccountUI.this.finish();
                com.tencent.mm.ui.base.b.gF(SettingsSwitchAccountUI.this);
            }
        });
        this.mUa.setDuration(500);
    }

    private static void K(Map<String, SwitchAccountModel> map) {
        if (map.size() == 2) {
            String[] strArr = new String[2];
            int i = 0;
            for (SwitchAccountModel switchAccountModel : map.values()) {
                int i2 = i + 1;
                strArr[i] = switchAccountModel.username;
                i = i2;
            }
            if (!bi.G(new String[]{strArr[0], strArr[1]}) && strArr[0].equals(strArr[1])) {
                for (String iL : map.keySet()) {
                    bt.dDs.iL(iL);
                }
                throw new NullPointerException(String.format("tow accounts have the same username!!! , %s, %s", new Object[]{strArr[0], strArr[1]}));
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void KX(String str) {
        SwitchAccountModel switchAccountModel = (SwitchAccountModel) this.mPV.get(str);
        if (switchAccountModel != null && !this.mUc) {
            this.mUc = true;
            g.DF().a(new q(str, switchAccountModel.username, switchAccountModel.mOQ, ""), 0);
            this.mPR.setSwitchToWxUsername(str);
            this.mPR.bum();
            btV();
        }
    }

    private void btV() {
        if (this.mUc) {
            this.mTW.setVisibility(8);
        } else if (this.mPV.size() <= 1 && this.scene == 0) {
            this.mTW.setVisibility(8);
            this.mSv = false;
            this.mPR.setDeleteState(false);
        } else if (this.mSv) {
            this.titleView.setText(i.settings_switch_account_delete_title);
            this.mTZ.setVisibility(0);
            if (this.mUd) {
                this.mTW.setText(getString(i.app_finish));
                this.mTW.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        SettingsSwitchAccountUI.this.mSv = false;
                        SettingsSwitchAccountUI.this.mUd = false;
                        SettingsSwitchAccountUI.this.mPR.setDeleteState(false);
                        SettingsSwitchAccountUI.this.mPR.bum();
                        SettingsSwitchAccountUI.this.btV();
                        if (SettingsSwitchAccountUI.this.mPR.getAccountCount() == 0) {
                            if (bt.dDs.IH().size() > 1) {
                                h.mEJ.h(14978, new Object[]{Integer.valueOf(1), Integer.valueOf(11), bt.dDs.II()});
                            } else {
                                h.mEJ.h(14978, new Object[]{Integer.valueOf(0), Integer.valueOf(11), bt.dDs.II()});
                            }
                            Intent be = com.tencent.mm.plugin.account.a.a.ezn.be(SettingsSwitchAccountUI.this);
                            be.addFlags(67108864);
                            SettingsSwitchAccountUI.this.startActivity(be);
                            SettingsSwitchAccountUI.this.finish();
                            com.tencent.mm.ui.base.b.gF(SettingsSwitchAccountUI.this);
                            SettingsSwitchAccountUI.this.mUc = false;
                        }
                    }
                });
                return;
            }
            this.mTW.setText(getString(i.app_cancel));
            this.mTW.setOnClickListener(new 9(this));
        } else {
            this.titleView.setText(i.settings_switch_account_login_title);
            this.mTZ.setVisibility(8);
            this.mTW.setText(getString(i.settings_switch_account_delete_title));
            this.mTW.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (!SettingsSwitchAccountUI.this.mSv) {
                        SettingsSwitchAccountUI.this.mSv = true;
                        SettingsSwitchAccountUI.this.mPR.setDeleteState(SettingsSwitchAccountUI.this.mSv);
                        SettingsSwitchAccountUI.this.mPR.bum();
                        SettingsSwitchAccountUI.this.btV();
                        if (bt.dDs.IH().size() > 1) {
                            h.mEJ.h(14978, new Object[]{Integer.valueOf(1), Integer.valueOf(3), bt.dDs.II()});
                            return;
                        }
                        h.mEJ.h(14978, new Object[]{Integer.valueOf(0), Integer.valueOf(3), bt.dDs.II()});
                    }
                }
            });
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.scene == 1 || this.scene == 2) {
            g.DF().a(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_RESPONSE_IS_NULL, this);
        }
        if (this.scene == 0) {
            g.DF().a(281, this);
            g.DF().a(282, this);
            g.DF().a(255, this);
        }
        this.mPR.bum();
        btV();
        if (this.scene == 1 || this.scene == 2) {
            g.Eg();
            if (com.tencent.mm.kernel.a.Dw()) {
                this.mUc = true;
                Intent be = com.tencent.mm.plugin.account.a.a.ezn.be(this);
                be.addFlags(67108864);
                startActivity(be);
                finish();
                com.tencent.mm.ui.base.b.gF(this);
            }
        }
    }

    protected void onStop() {
        super.onStop();
        if (this.scene == 1) {
            SwitchAccountGridView switchAccountGridView = this.mPR;
            if (switchAccountGridView.mWa) {
                switchAccountGridView.mWa = false;
                if (switchAccountGridView.mWb != null) {
                    switchAccountGridView.mWb.end();
                }
            }
        }
        g.DF().b(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_RESPONSE_IS_NULL, this);
        g.DF().b(281, this);
        g.DF().b(282, this);
        g.DF().b(255, this);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.SettingsSwitchAccountUI", "errCode %d, errMsg %s, scene %s, this %s", new Object[]{Integer.valueOf(i2), str, lVar, this});
        if (lVar.getType() == TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_RESPONSE_IS_NULL) {
            if (i == 0 && i2 == 0) {
                this.mTX.setVisibility(4);
                this.mTY.setVisibility(4);
                SwitchAccountGridView switchAccountGridView = this.mPR;
                if (!switchAccountGridView.mWa) {
                    if (switchAccountGridView.mWb == null && !bi.oW(switchAccountGridView.mVZ)) {
                        int min = Math.min(2, switchAccountGridView.mWc.size());
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                        ofFloat.addUpdateListener(new 4(switchAccountGridView, min));
                        ofFloat.setDuration(200);
                        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                        ofFloat.addUpdateListener(new 5(switchAccountGridView, min));
                        ofFloat2.setDuration(300);
                        switchAccountGridView.mWb = new AnimatorSet();
                        switchAccountGridView.mWb.addListener(new 6(switchAccountGridView));
                        switchAccountGridView.mWb.playSequentially(new Animator[]{ofFloat, ofFloat2});
                    }
                    if (switchAccountGridView.mWb != null) {
                        switchAccountGridView.mWa = true;
                        switchAccountGridView.mWb.start();
                    }
                }
                com.tencent.mm.kernel.a.unhold();
                com.tencent.mm.platformtools.x.bZ(this);
                if (bt.dDs.IH().size() > 1) {
                    h.mEJ.h(14978, new Object[]{Integer.valueOf(1), Integer.valueOf(0), bt.dDs.II()});
                } else {
                    h.mEJ.h(14978, new Object[]{Integer.valueOf(0), Integer.valueOf(0), bt.dDs.II()});
                }
                this.mPR.setOnAnimatorEndListener(new SwitchAccountGridView.a() {
                    public final void btZ() {
                        SettingsSwitchAccountUI.this.mPR.setLastLoginWxUsername(at.dBv.I("login_weixin_username", ""));
                        SettingsSwitchAccountUI.this.mPR.setSwitchToWxUsername("");
                        SettingsSwitchAccountUI.this.mPR.bum();
                        SettingsSwitchAccountUI.this.mUa.start();
                    }
                });
            } else {
                this.mPR.setSwitchToWxUsername("");
                this.mUc = false;
                com.tencent.mm.ui.base.h.bA(this, getString(i.settings_switch_account_error_tip));
                String str2 = ((q) lVar).efQ;
                if (!bi.oW(str2) && this.mPV.containsKey(str2)) {
                    Intent intent = new Intent();
                    x.i("MicroMsg.SettingsSwitchAccountUI", "wxID %s, plugSwitch: %d", new Object[]{str2, Integer.valueOf(((SwitchAccountModel) this.mPV.get(str2)).mOR)});
                    if ((((SwitchAccountModel) this.mPV.get(str2)).mOR & 131072) != 0) {
                        intent.setClass(this, LoginVoiceUI.class);
                    } else {
                        intent.setClass(this, LoginPasswordUI.class);
                    }
                    intent.putExtra("switch_login_wx_id", str2);
                    startActivity(intent);
                    finish();
                    com.tencent.mm.ui.base.b.gG(this);
                }
                if (bt.dDs.IH().size() > 1) {
                    h.mEJ.h(14978, new Object[]{Integer.valueOf(1), Integer.valueOf(1), bt.dDs.II()});
                } else {
                    h.mEJ.h(14978, new Object[]{Integer.valueOf(0), Integer.valueOf(1), bt.dDs.II()});
                }
            }
        }
        if (lVar.getType() == 255) {
            if (((r) lVar).efY != 2) {
                return;
            }
            if (i == 0 && i2 == 0) {
                btW();
            } else if (i2 == -3 && i == 4) {
                if (bt.dDs.IH().size() > 1) {
                    h.mEJ.h(14978, new Object[]{Integer.valueOf(1), Integer.valueOf(7), bt.dDs.II()});
                } else {
                    h.mEJ.h(14978, new Object[]{Integer.valueOf(0), Integer.valueOf(7), bt.dDs.II()});
                }
                Intent intent2 = new Intent(this.mController.tml, RegByMobileSetPwdUI.class);
                intent2.putExtra("kintent_hint", getString(i.regbymobile_reg_setpwd_tip_when_logout));
                startActivityForResult(intent2, TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_RESPONSE_IS_NULL);
            } else if (!com.tencent.mm.plugin.setting.b.ezo.a((Context) this, i, i2, str)) {
            }
        } else if (lVar.getType() == 282) {
            g.Eg();
            if (com.tencent.mm.kernel.a.Dw()) {
                String str3 = ((arm) ((p) lVar).diG.dIE.dIL).rTP;
                x.i("MicroMsg.SettingsSwitchAccountUI", "logout return");
                if (bi.oW(str3)) {
                    x.i("MicroMsg.SettingsSwitchAccountUI", "no pwd ticket is null!");
                }
                bt.dDs.l(at.dBv.I("login_weixin_username", ""), "last_logout_no_pwd_ticket", str3);
                if (this.mUb != null && !this.mUb.ciq()) {
                    this.mUb.SO();
                    btX();
                }
            }
        }
    }

    private void goBack() {
        if (this.scene == 2 || this.scene == 1) {
            Intent be = com.tencent.mm.plugin.account.a.a.ezn.be(this);
            be.addFlags(67108864);
            be.putExtra("can_finish", true);
            startActivity(be);
            finish();
            com.tencent.mm.ui.base.b.gF(this);
            this.mUc = false;
            return;
        }
        finish();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.setting.a.g.settings_switch_account;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_RESPONSE_IS_NULL && i2 == -1) {
            btW();
        }
    }

    private static void logout() {
        if (!(g.DF() == null || g.DF().dJs == null)) {
            g.DF().dJs.bD(false);
        }
        Object[] objArr = new Object[1];
        g.Eg();
        objArr[0] = Integer.valueOf(com.tencent.mm.kernel.a.Df());
        x.w("MicroMsg.SettingsSwitchAccountUI", "dklogout User LOGOUT Now uin:%d , clear cookie", objArr);
        com.tencent.mm.modelstat.c.RT().commitNow();
        r rVar = new r(2);
        rVar.efX = 1;
        g.DF().a(rVar, 0);
    }

    private void btW() {
        if (com.tencent.mm.kernel.a.gI(g.Eg().dpx)) {
            g.DF().a(new ac(2), 0);
        }
        g.DF().a(new p(), 0);
        this.mPR.setLogoutState(true);
        this.mPR.bum();
        if (this.mUb == null) {
            this.mUb = new al(Looper.getMainLooper(), new 2(this), false);
            this.mUb.J(8000, 8000);
        }
    }

    private void btX() {
        x.i("MicroMsg.SettingsSwitchAccountUI", "switch account logout");
        x.i("MicroMsg.SettingsSwitchAccountUI", "just keep class %s", new Object[]{com.tencent.mm.plugin.setting.modelsimple.SwitchAccountModel.class.toString()});
        com.tencent.mm.plugin.setting.b.ezo.vr();
        ja jaVar = new ja();
        jaVar.bSG.status = 0;
        jaVar.bSG.aAk = 0;
        com.tencent.mm.sdk.b.a.sFg.m(jaVar);
        y yVar = new y();
        yVar.bHg.bHh = true;
        com.tencent.mm.sdk.b.a.sFg.m(yVar);
        af.Wq("show_whatsnew");
        k.j(this, true);
        com.tencent.mm.platformtools.x.H(this, null);
        if (g.Eg().Dx()) {
            String A = com.tencent.mm.aa.c.A(com.tencent.mm.model.q.GF(), false);
            at.dBv.iy(A);
            g.Ei().DT().a(aa.a.sZO, A);
        }
        x.i("MicroMsg.SettingsSwitchAccountUI", "last login username in sp %s", new Object[]{at.dBv.I("login_user_name", "")});
        Map Ho = com.tencent.mm.model.q.Ho();
        if (bi.oW((String) Ho.get("login_user_name"))) {
            Ho.put("login_user_name", at.dBv.I("login_user_name", ""));
        }
        bt.dDs.d(com.tencent.mm.model.q.GF(), Ho);
        ad.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", true).commit();
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("Intro_Switch", true);
        intent.putExtra("key_transit_to_switch_account", true);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mPV.values());
        intent.putParcelableArrayListExtra("key_switch_account_users", arrayList);
        com.tencent.mm.plugin.setting.b.ezn.q(intent, this);
        finish();
        com.tencent.mm.ui.base.b.gG(this);
    }
}
