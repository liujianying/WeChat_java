package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public class SnsLuckyMoneyFreePwdSetting extends WalletPreferenceUI {
    protected f gua;
    protected CheckBoxPreference kTl;

    private static void sh(int i) {
        qd qdVar = new qd();
        qdVar.caN.key = i;
        qdVar.caN.value = 1;
        qdVar.caN.caO = true;
        a.sFg.m(qdVar);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        sh(116);
    }

    protected final void initView() {
        this.gua = this.tCL;
        setBackBtn(new 1(this));
        setMMTitle(i.lucky_money_free_pwd_setting_title);
        this.kTl = (CheckBoxPreference) this.gua.ZZ("open_sns_pay_pref");
        bbg();
    }

    protected void onResume() {
        bbg();
        super.onResume();
    }

    private void bbg() {
        boolean z = true;
        if (com.tencent.mm.plugin.luckymoney.sns.b.a.bbi() != 1) {
            z = false;
        }
        this.kTl.qpJ = z;
        this.duR.edit().putBoolean("open_sns_pay_pref", z).commit();
        if (TextUtils.isEmpty(com.tencent.mm.plugin.luckymoney.sns.b.a.bbj())) {
            x.i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle is empty");
            this.kTl.setTitle(i.lucky_money_free_pwd_key_title);
        } else {
            x.i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle:" + com.tencent.mm.plugin.luckymoney.sns.b.a.bbj());
            this.kTl.setTitle(com.tencent.mm.plugin.luckymoney.sns.b.a.bbj());
        }
        if (TextUtils.isEmpty(com.tencent.mm.plugin.luckymoney.sns.b.a.bbk())) {
            x.i("MicroMsg.mmui.MMPreference", "getSetSnsPayWording is empty");
            this.kTl.setSummary(i.lucky_money_free_pwd_key_decs);
        } else {
            x.i("MicroMsg.mmui.MMPreference", "SetSnsPayWording:" + com.tencent.mm.plugin.luckymoney.sns.b.a.bbk());
            this.kTl.setSummary(com.tencent.mm.plugin.luckymoney.sns.b.a.bbk());
        }
        this.gua.notifyDataSetChanged();
    }

    private void gn(boolean z) {
        this.duR.edit().putBoolean("open_sns_pay_pref", z).commit();
        this.kTl.qpJ = z;
        this.gua.notifyDataSetChanged();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final boolean h(int i, int i2, String str, l lVar) {
        if (lVar instanceof com.tencent.mm.plugin.luckymoney.sns.a.a) {
            x.i("MicroMsg.mmui.MMPreference", "free pwd setting onWalletSceneEnd, errType:" + i + " errCode:" + i2 + " errMsg:" + str);
            if (i != 0 || i2 != 0) {
                sh(119);
                x.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is failed, do nothing");
                bbg();
            } else if (((com.tencent.mm.plugin.luckymoney.sns.a.a) lVar).kTD == 1) {
                x.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 1");
                sh(119);
                gn(true);
            } else {
                gn(false);
                sh(118);
                x.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 0");
            }
        }
        return false;
    }

    public final int Ys() {
        return com.tencent.mm.plugin.wxpay.a.l.sns_lucky_money_free_pwd_pref;
    }

    public final boolean a(f fVar, Preference preference) {
        if ("open_sns_pay_pref".equals(preference.mKey)) {
            if (this.kTl.isChecked() || com.tencent.mm.plugin.luckymoney.sns.b.a.bbi() != 1) {
                sh(TbsListener$ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR);
                com.tencent.mm.wallet_core.a.a((Activity) this, a.class, null, null);
            } else {
                cDP().a(new com.tencent.mm.plugin.luckymoney.sns.a.a(0, "", ""), true, 1);
                sh(117);
            }
        }
        return false;
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}
