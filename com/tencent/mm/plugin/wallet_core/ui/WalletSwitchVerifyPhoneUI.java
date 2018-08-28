package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.text.SpannableString;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.c.e;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView;
import com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.fd;
import com.tencent.mm.protocal.c.qk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.util.Collections;
import java.util.List;

@a(19)
public class WalletSwitchVerifyPhoneUI extends WalletBaseUI {
    private SwitchPhoneItemGroupView pyt;
    private List<fd> pyu;
    public boolean pyv = false;

    static /* synthetic */ void a(WalletSwitchVerifyPhoneUI walletSwitchVerifyPhoneUI) {
        walletSwitchVerifyPhoneUI.sy.putBoolean("key_is_changing_balance_phone_num", true);
        walletSwitchVerifyPhoneUI.sy.putInt("key_pay_flag", 2);
        com.tencent.mm.wallet_core.a.j(walletSwitchVerifyPhoneUI, walletSwitchVerifyPhoneUI.sy);
    }

    static /* synthetic */ void a(WalletSwitchVerifyPhoneUI walletSwitchVerifyPhoneUI, fd fdVar) {
        Bankcard bankcard = new Bankcard();
        bankcard.field_bindSerial = fdVar.lMW;
        bankcard.field_mobile = fdVar.pjw;
        bankcard.field_bankcardType = fdVar.lMV;
        bankcard.field_desc = fdVar.knE;
        x.d("MicroMsg.WalletSwitchVerifyPhoneUI", "serial: %s,mobile: %s, bankcardType: %s, desc: %s", new Object[]{bankcard.field_bindSerial, bankcard.field_mobile, bankcard.field_bankcardType, bankcard.field_bankName});
        walletSwitchVerifyPhoneUI.sy.putParcelable("key_bankcard", bankcard);
        if (o.bPe().OW(bankcard.field_bankcardType) != null) {
            x.i("MicroMsg.WalletSwitchVerifyPhoneUI", "go to reset directly");
            walletSwitchVerifyPhoneUI.bNt();
            return;
        }
        walletSwitchVerifyPhoneUI.a(new t("", "", null), true, false);
    }

    public void onCreate(Bundle bundle) {
        overridePendingTransition(com.tencent.mm.plugin.wxpay.a.a.push_up_in, com.tencent.mm.plugin.wxpay.a.a.anim_not_change);
        super.onCreate(bundle);
        setMMTitle(getString(i.wallet_switch_phone_title_1));
        initView();
        this.pyv = this.sy.getBoolean("key_block_bind_new_card", false);
        if (!this.pyv) {
            SwitchPhoneItemView switchPhoneItemView = new SwitchPhoneItemView(this.mController.tml);
            switchPhoneItemView.setTag(Integer.valueOf(-1));
            switchPhoneItemView.a(getString(i.wallet_switch_phone_bind_new_card), null);
            this.pyt.a(switchPhoneItemView, -1);
        }
        if (cDK() != null && cDK().aNK() == "PayProcess" && this.sy.getInt("key_can_verify_tail", 0) == 1) {
            x.i("MicroMsg.WalletSwitchVerifyPhoneUI", "show verify id card item");
            CharSequence string = getString(i.wallet_idcard_item_text);
            SwitchPhoneItemView switchPhoneItemView2 = new SwitchPhoneItemView(this.mController.tml, g.wallet_switch_verify_phone_idcard_item);
            switchPhoneItemView2.setTag(Integer.valueOf(-2));
            switchPhoneItemView2.a(string, null);
            this.pyt.a(switchPhoneItemView2, -1);
        }
        jr(1667);
        jr(461);
        jr(1505);
        a(new e(bNs()), true, true);
    }

    protected final void initView() {
        this.pyt = (SwitchPhoneItemGroupView) findViewById(f.phone_number_container);
        this.pyt.setOnItemSelectListener(new 1(this));
    }

    public void onDestroy() {
        super.onDestroy();
        js(1667);
        js(461);
        js(1505);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0) {
            if (lVar instanceof e) {
                e eVar = (e) lVar;
                this.pyu = ((e) lVar).pja.rFB;
                Collections.sort(this.pyu, new 2(this));
                if (eVar.pja.rFC != null) {
                    qk qkVar = eVar.pja.rFC;
                    this.sy.putString("key_true_name", qkVar.plj);
                    this.sy.putString("key_cre_name", qkVar.ruP);
                    this.sy.putString("key_cre_type", qkVar.pqP);
                }
                if (this.pyu == null || this.pyu.isEmpty()) {
                    x.i("MicroMsg.WalletSwitchVerifyPhoneUI", "empty mobile info");
                } else {
                    for (int size = this.pyu.size() - 1; size >= 0; size--) {
                        fd fdVar = (fd) this.pyu.get(size);
                        if (fdVar.rfW.equals("cft")) {
                            CharSequence spannableString;
                            SwitchPhoneItemView switchPhoneItemView = new SwitchPhoneItemView(this.mController.tml);
                            String string = fdVar.rfX.equals("1") ? getString(i.wallet_switch_phone_debit_card) : getString(i.wallet_switch_phone_credit_card);
                            Object string2 = getString(i.wallet_switch_phone_card_hint, new Object[]{fdVar.knE, string, fdVar.rfY});
                            if (this.pyv) {
                                spannableString = new SpannableString(string2);
                            } else {
                                String string3 = getString(i.wallet_switch_phone_update);
                                h hVar = new h(this);
                                String str2 = string2 + "，";
                                hVar.pN = getResources().getColor(c.blue_text_color);
                                spannableString = new SpannableString(str2 + string3);
                                spannableString.setSpan(hVar, str2.length(), str2.length() + string3.length(), 33);
                                hVar.pvm = new 3(this, fdVar);
                            }
                            switchPhoneItemView.setTag(Integer.valueOf(size));
                            switchPhoneItemView.a(fdVar.pjw, spannableString);
                            this.pyt.a(switchPhoneItemView, 0);
                        } else {
                            SwitchPhoneItemView switchPhoneItemView2 = new SwitchPhoneItemView(this.mController.tml);
                            switchPhoneItemView2.setTag(Integer.valueOf(size));
                            switchPhoneItemView2.a(fdVar.pjw, getString(i.wallet_switch_phone_wx_bind_phone));
                            this.pyt.a(switchPhoneItemView2, 0);
                        }
                    }
                }
                return true;
            } else if (lVar instanceof t) {
                bNt();
            }
        }
        return false;
    }

    protected final int getLayoutId() {
        return g.wallet_switch_verify_phone_ui;
    }

    protected final boolean bND() {
        return true;
    }

    private void bNt() {
        x.i("MicroMsg.WalletSwitchVerifyPhoneUI", "directToNext()");
        Authen authen = (Authen) this.sy.getParcelable("key_authen");
        Bankcard bankcard = (Bankcard) this.sy.getParcelable("key_bankcard");
        ElementQuery OW = o.bPe().OW(bankcard.field_bankcardType);
        this.sy.putParcelable("elemt_query", OW);
        authen.lMV = bankcard.field_bankcardType;
        authen.lMW = bankcard.field_bindSerial;
        bankcard.field_bankPhone = OW.pnw;
        this.sy.putBoolean("key_balance_change_phone_need_confirm_phone", true);
        this.sy.putBoolean("key_is_changing_balance_phone_num", true);
        this.sy.putInt("key_err_code", TbsListener$ErrorCode.INFO_CORE_EXIST_NOT_LOAD);
        com.tencent.mm.wallet_core.a.j(this, this.sy);
    }
}
