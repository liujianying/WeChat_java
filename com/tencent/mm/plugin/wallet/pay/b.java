package com.tencent.mm.plugin.wallet.pay;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.te;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI;
import com.tencent.mm.plugin.wallet.bind.ui.WalletResetInfoUI;
import com.tencent.mm.plugin.wallet.pay.a.d.e;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI;
import com.tencent.mm.plugin.wallet_core.b.a;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSwitchVerifyPhoneUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyIdCardUI;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;

public class b extends a {
    public final c a(Activity activity, Bundle bundle) {
        PayInfo payInfo = (PayInfo) bundle.getParcelable("key_pay_info");
        bundle.putInt("key_pay_scene", payInfo.bVY);
        bundle.putInt("key_pay_channel", payInfo.bVU);
        if (!e(activity, bundle)) {
            int i = bundle.getInt("key_pay_flag", 0);
            if ((i == 2 || i == 1) && payInfo.bVY == 11) {
                p.GZ(13);
            }
            x.i("MicroMsg.PayProcess", "start pay_flag : " + bundle.getInt("key_pay_flag", 0));
            switch (bundle.getInt("key_pay_flag", 0)) {
                case 1:
                    x.i("MicroMsg.PayProcess", "start Process : PayRegBindProcess");
                    c(activity, WalletBankcardIdUI.class, bundle);
                    break;
                case 2:
                    x.i("MicroMsg.PayProcess", "start Process : PayBindProcess");
                    c(activity, WalletCheckPwdUI.class, bundle);
                    break;
                case 3:
                    if (bundle.getBoolean("key_need_verify_sms", false) && !bQH()) {
                        x.i("MicroMsg.PayProcess", "domestic and verify sms!");
                        c(activity, WalletVerifyCodeUI.class, bundle);
                        break;
                    }
                    x.i("MicroMsg.PayProcess", "jump to result ui!");
                    f(activity, bundle);
                    break;
            }
        }
        x.w("MicroMsg.PayProcess", "hy: has err. return");
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (e(activity, bundle)) {
            x.i("MicroMsg.PayProcess", "deal with the err!");
            return;
        }
        if (activity instanceof WalletSwitchVerifyPhoneUI) {
            if (this.jfZ.getBoolean("key_forward_to_id_verify", false)) {
                x.i("MicroMsg.PayProcess", "go to verify id tail");
                c(activity, WalletVerifyIdCardUI.class, this.jfZ);
                return;
            }
        } else if (activity instanceof WalletVerifyIdCardUI) {
            f(activity, bundle);
        }
        int i2 = bundle.containsKey("key_pay_flag") ? bundle.getInt("key_pay_flag", 0) : this.jfZ.getInt("key_pay_flag", 0);
        x.i("MicroMsg.PayProcess", "forward pay_flag : " + i2);
        switch (i2) {
            case 1:
                x.i("MicroMsg.PayProcess", "forwardUnreg()");
                if (activity instanceof WalletSetPasswordUI) {
                    c(activity, WalletPwdConfirmUI.class, bundle);
                    return;
                } else if (activity instanceof WalletPwdConfirmUI) {
                    f(activity, bundle);
                    return;
                } else if (activity instanceof WalletCardElementUI) {
                    if (bQH()) {
                        x.i("MicroMsg.PayProcess", "oversea, set pwd");
                        c(activity, WalletSetPasswordUI.class, bundle);
                        return;
                    }
                    x.i("MicroMsg.PayProcess", "domestic, verify code");
                    c(activity, WalletVerifyCodeUI.class, bundle);
                    return;
                } else if (activity instanceof WalletBalanceResultUI) {
                    a(activity, WalletBalanceManagerUI.class, -1, null, true);
                    return;
                } else {
                    super.a(activity, 0, bundle);
                    return;
                }
            case 2:
                x.i("MicroMsg.PayProcess", "forwardBind()");
                if ((activity instanceof WalletCheckPwdUI) || (activity instanceof WalletSelectBankcardUI) || (activity instanceof WalletSwitchVerifyPhoneUI)) {
                    c(activity, WalletBankcardIdUI.class, bundle);
                    return;
                } else if (activity instanceof WalletVerifyCodeUI) {
                    f(activity, bundle);
                    return;
                } else if (activity instanceof WalletCardElementUI) {
                    if (bQH()) {
                        x.i("MicroMsg.PayProcess", "oversea, jump to result ui!");
                        f(activity, bundle);
                        return;
                    }
                    x.i("MicroMsg.PayProcess", "domestic, verify code!");
                    c(activity, WalletVerifyCodeUI.class, bundle);
                    return;
                } else if (activity instanceof WalletBalanceResultUI) {
                    a(activity, WalletBalanceManagerUI.class, -1, null, true);
                    return;
                } else {
                    super.a(activity, 0, bundle);
                    return;
                }
            case 3:
                x.i("MicroMsg.PayProcess", "forwardBound()");
                if (activity instanceof WalletVerifyCodeUI) {
                    f(activity, bundle);
                    return;
                } else if ((activity instanceof WalletResetInfoUI) || (activity instanceof WalletChangeBankcardUI)) {
                    if ((!bundle.getBoolean("key_need_verify_sms", false) || bQH()) && !bundle.getBoolean("key_is_changing_balance_phone_num")) {
                        x.i("MicroMsg.PayProcess", "jump to result ui!");
                        f(activity, bundle);
                        return;
                    }
                    x.i("MicroMsg.PayProcess", "need verify code after reset info or change bank card info!");
                    c(activity, WalletVerifyCodeUI.class, bundle);
                    return;
                } else if (activity instanceof WalletBalanceResultUI) {
                    a(activity, WalletBalanceManagerUI.class, -1, null, true);
                    return;
                } else if ((activity instanceof WalletSelectBankcardUI) || (activity instanceof WalletSwitchVerifyPhoneUI)) {
                    x.i("MicroMsg.PayProcess", "need verify code after select bank card!");
                    c(activity, WalletVerifyCodeUI.class, bundle);
                    return;
                } else {
                    super.a(activity, 0, bundle);
                    return;
                }
            default:
                return;
        }
    }

    public final void c(Activity activity, int i) {
        x.i("MicroMsg.PayProcess", "back pay_flag : " + this.jfZ.getInt("key_pay_flag", 0));
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
            return;
        }
        p.cDe();
        z(activity);
    }

    public final void b(Activity activity, Bundle bundle) {
        PayInfo payInfo;
        int i = -1;
        x.i("MicroMsg.PayProcess", "end pay_flag : " + this.jfZ.getInt("key_pay_flag", 0));
        p.cDe();
        int i2 = this.jfZ.getBoolean("intent_pay_end", false) ? -1 : 0;
        Intent intent = new Intent();
        if (bundle != null) {
            payInfo = (PayInfo) this.jfZ.getParcelable("key_pay_info");
            Bundle bundle2 = new Bundle();
            bundle2.putInt("intent_pay_end_errcode", this.jfZ.getInt("intent_pay_end_errcode"));
            bundle2.putString("intent_pay_app_url", this.jfZ.getString("intent_pay_app_url"));
            bundle2.putBoolean("intent_pay_end", this.jfZ.getBoolean("intent_pay_end"));
            bundle2.putString("intent_wap_pay_jump_url", this.jfZ.getString("intent_wap_pay_jump_url"));
            bundle2.putParcelable("key_realname_guide_helper", this.jfZ.getParcelable("key_realname_guide_helper"));
            if (payInfo != null) {
                bundle2.putInt("pay_channel", payInfo.bVU);
            }
            intent.putExtras(bundle2);
        }
        intent.putExtra("key_orders", this.jfZ.getParcelable("key_orders"));
        te teVar = new te();
        teVar.ceH.intent = intent;
        teVar.ceH.bOd = bNs();
        te.a aVar = teVar.ceH;
        if (!this.jfZ.getBoolean("intent_pay_end", false)) {
            i = 0;
        }
        aVar.result = i;
        if (teVar.ceH.result == 0 && bundle != null) {
            payInfo = (PayInfo) bundle.getParcelable("key_pay_info");
            if (payInfo != null) {
                com.tencent.mm.plugin.wallet.pay.a.b.b.ae(payInfo.bOd, payInfo.bVY, payInfo.bVU);
            }
        }
        com.tencent.mm.sdk.b.a.sFg.m(teVar);
        a(activity, "wallet", ".pay.ui.WalletPayUI", i2, intent, false);
    }

    private boolean e(Activity activity, Bundle bundle) {
        x.i("MicroMsg.PayProcess", "dealwithErr(), errCode %d", new Object[]{Integer.valueOf(bundle.getInt("key_err_code", 0))});
        switch (bundle.getInt("key_err_code", 0)) {
            case -1004:
                bundle.putInt("key_pay_flag", 3);
                bundle.putInt("key_err_code", 0);
                c(activity, WalletChangeBankcardUI.class, bundle);
                return true;
            case -1003:
                com.tencent.mm.plugin.wallet.a.p.bNp();
                if (com.tencent.mm.plugin.wallet.a.p.bNq().bPs()) {
                    bundle.putInt("key_pay_flag", 2);
                    bundle.putInt("key_err_code", 0);
                    c(activity, WalletCheckPwdUI.class, bundle);
                } else {
                    bundle.putInt("key_pay_flag", 1);
                    bundle.putInt("key_err_code", 0);
                    c(activity, WalletBankcardIdUI.class, bundle);
                }
                return true;
            case 402:
            case 403:
            case 408:
                Bankcard bankcard = (Bankcard) this.jfZ.get("key_bankcard");
                if (bankcard == null || !bankcard.bOs()) {
                    c(activity, WalletResetInfoUI.class, bundle);
                } else if (o.bOW().bPD() == null || o.bOW().bPD().size() <= 0) {
                    c(activity, WalletBankcardIdUI.class, bundle);
                } else {
                    x.i("MicroMsg.PayProcess", "hy: go to select bankcard ui");
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean("key_is_show_new_bankcard", true);
                    bundle2.putInt("key_scene", 0);
                    bundle2.putParcelableArrayList("key_showing_bankcards", o.bOW().bPD());
                    bundle2.putString("key_top_tips", activity.getString(a$i.wallet_select_bankcard_bcp_top_tips));
                    c(activity, WalletSelectBankcardUI.class, bundle2);
                }
                return true;
            case 417:
                bundle.putInt("key_err_code", 0);
                c(activity, WalletSwitchVerifyPhoneUI.class, bundle);
                return true;
            case 418:
                bundle.putInt("key_err_code", 0);
                c(activity, WalletResetInfoUI.class, bundle);
                return true;
            default:
                return false;
        }
    }

    private void f(Activity activity, Bundle bundle) {
        if (this.jfZ != null && this.jfZ.containsKey("key_realname_guide_helper")) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putParcelable("key_realname_guide_helper", this.jfZ.getParcelable("key_realname_guide_helper"));
        }
        int i = bundle.getInt("key_pay_scene", 6);
        x.i("MicroMsg.PayProcess", "jumpToResultUI() payScene:%d", new Object[]{Integer.valueOf(i)});
        if (i == 11 || i == 21) {
            c(activity, WalletBalanceResultUI.class, bundle);
        } else if (i == 5 || i == 31 || i == 32 || i == 33 || i == 48) {
            PayInfo payInfo = (PayInfo) bundle.getParcelable("key_pay_info");
            if (payInfo == null || payInfo.myh != 1) {
                a(activity, "remittance", ".ui.RemittanceResultUI", bundle);
                return;
            }
            x.i("MicroMsg.PayProcess", "is busi f2f");
            b(activity, bundle);
        } else if (i == 37 || i == 39 || i == 42 || i == 45 || i == 52 || i == 49) {
            b(activity, bundle);
        } else {
            c(activity, WalletOrderInfoUI.class, bundle);
        }
    }

    public final boolean c(Activity activity, Bundle bundle) {
        x.d("MicroMsg.PayProcess", "pay_flag : " + this.jfZ.getInt("key_pay_flag", 0));
        switch (this.jfZ.getInt("key_pay_flag", 0)) {
            case 1:
                return activity instanceof WalletOrderInfoUI;
            case 2:
                return activity instanceof WalletOrderInfoUI;
            default:
                return false;
        }
    }

    public final g a(MMActivity mMActivity, i iVar) {
        if (mMActivity instanceof WalletPayUI) {
            return new 1(this, (WalletBaseUI) mMActivity, iVar);
        }
        if (mMActivity instanceof WalletCheckPwdUI) {
            return new a((WalletBaseUI) mMActivity, iVar) {
                public final boolean d(int i, int i2, String str, l lVar) {
                    if (super.d(i, i2, str, lVar)) {
                        return true;
                    }
                    return false;
                }

                public final boolean m(Object... objArr) {
                    this.uXK.a(new r((String) objArr[0], 4, (String) objArr[1]), true, 1);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletBankcardIdUI) {
            return new 11(this, (WalletBaseUI) mMActivity, iVar);
        }
        if (mMActivity instanceof WalletCardElementUI) {
            return new a((WalletBaseUI) mMActivity, iVar) {
                public final boolean d(int i, int i2, String str, l lVar) {
                    if (super.d(i, i2, str, lVar)) {
                        return true;
                    }
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (lVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                        com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) lVar;
                        b.this.jfZ.putString("kreq_token", bVar.token);
                        if (bVar.pgm) {
                            b.this.jfZ.putParcelable("key_orders", bVar.pfb);
                        }
                        RealnameGuideHelper realnameGuideHelper = bVar.lJN;
                        if (realnameGuideHelper != null) {
                            b.this.jfZ.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                        }
                    } else if (lVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.c) {
                        com.tencent.mm.plugin.wallet.pay.a.a.c cVar = (com.tencent.mm.plugin.wallet.pay.a.a.c) lVar;
                        b.this.jfZ.putString("kreq_token", cVar.token);
                        if (cVar.pgm) {
                            b.this.jfZ.putParcelable("key_orders", cVar.pfb);
                        }
                    }
                    if (b.this.c(this.fEY, null)) {
                        this.uXK.a(new y(b.this.bNs(), 13), true, 1);
                        return true;
                    }
                    b.this.a(this.fEY, 0, b.this.jfZ);
                    return true;
                }

                public final boolean m(Object... objArr) {
                    Authen authen = (Authen) objArr[0];
                    Orders orders = (Orders) objArr[1];
                    x.i("MicroMsg.PayProcess", "WalletCardElementUI onNext pay_flag : " + b.this.jfZ.getInt("key_pay_flag", 0));
                    switch (b.this.jfZ.getInt("key_pay_flag", 0)) {
                        case 1:
                            if (b.this.bQH()) {
                                authen.bWA = 4;
                            } else {
                                authen.bWA = 1;
                            }
                            this.uXK.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders), true, 1);
                            return true;
                        case 2:
                            if (b.this.bQH()) {
                                authen.bWA = 5;
                            } else {
                                authen.bWA = 2;
                            }
                            if (b.this.jfZ.getBoolean("key_is_changing_balance_phone_num", false)) {
                                this.uXK.a(new com.tencent.mm.plugin.wallet.pay.a.a.c(authen, orders, b.this.jfZ.getBoolean("key_isbalance", false)), true, 1);
                            } else {
                                this.uXK.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders), true, 1);
                            }
                            return true;
                        case 3:
                            if (b.this.bQH()) {
                                authen.bWA = 6;
                            } else {
                                authen.bWA = 3;
                            }
                            this.uXK.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders), true, 1);
                            return true;
                        default:
                            return false;
                    }
                }
            };
        }
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new 13(this, (WalletBaseUI) mMActivity, iVar);
        }
        if (mMActivity instanceof WalletBalanceResultUI) {
            return new 14(this, (WalletBaseUI) mMActivity, iVar);
        }
        if (mMActivity instanceof WalletPwdConfirmUI) {
            return new 15(this, (WalletBaseUI) mMActivity, iVar);
        }
        if (mMActivity instanceof WalletChangeBankcardUI) {
            return new c((WalletBaseUI) mMActivity, iVar) {
                public final boolean m(Object... objArr) {
                    return false;
                }

                public final boolean d(int i, int i2, String str, l lVar) {
                    if (super.d(i, i2, str, lVar)) {
                        return true;
                    }
                    return false;
                }
            };
        }
        if (mMActivity instanceof WalletSelectBankcardUI) {
            return new 17(this, mMActivity, iVar);
        }
        if (mMActivity instanceof WalletResetInfoUI) {
            return new a((WalletBaseUI) mMActivity, iVar) {
                public final boolean r(Object... objArr) {
                    return false;
                }

                public final boolean d(int i, int i2, String str, l lVar) {
                    if (super.d(i, i2, str, lVar)) {
                        return true;
                    }
                    return false;
                }

                public final boolean m(Object... objArr) {
                    return false;
                }
            };
        }
        if (mMActivity instanceof WalletSwitchVerifyPhoneUI) {
            return new 3(this, (WalletBaseUI) mMActivity, iVar);
        }
        return mMActivity instanceof WalletVerifyIdCardUI ? new a((WalletBaseUI) mMActivity, iVar) {
            public final boolean m(Object... objArr) {
                if (objArr.length > 0) {
                    this.uXK.a(com.tencent.mm.plugin.wallet.pay.a.a.a((com.tencent.mm.plugin.wallet_core.model.p) objArr[0], (Orders) b.this.jfZ.getParcelable("key_orders")), true, 1);
                }
                return false;
            }

            public final boolean d(int i, int i2, String str, l lVar) {
                if (super.d(i, i2, str, lVar) || !(lVar instanceof e)) {
                    return false;
                }
                e eVar = (e) lVar;
                if (i != 0 || i2 != 0) {
                    return false;
                }
                if (eVar.pgm) {
                    b.this.jfZ.putParcelable("key_orders", eVar.pfb);
                }
                RealnameGuideHelper realnameGuideHelper = eVar.lJN;
                if (realnameGuideHelper != null) {
                    b.this.jfZ.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                }
                b.this.a(this.fEY, 0, b.this.jfZ);
                this.fEY.finish();
                return true;
            }
        } : super.a(mMActivity, iVar);
    }

    public final boolean a(final WalletBaseUI walletBaseUI, int i, String str) {
        x.i("MicroMsg.PayProcess", "onReceiveErr(), errCode %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 402:
            case 403:
            case 408:
                if (cCU() && this.jfZ.getParcelable("key_bankcard") != null) {
                    String string;
                    Bankcard bankcard = (Bankcard) this.jfZ.getParcelable("key_bankcard");
                    if (bi.oW(str)) {
                        string = walletBaseUI.getString(a$i.wallet_pay_reset_info_tips, new Object[]{bankcard.field_desc, bankcard.field_mobile});
                    } else {
                        string = str;
                    }
                    h.a(walletBaseUI, string, "", walletBaseUI.getString(a$i.wallet_pay_reset_info), walletBaseUI.getString(a$i.app_cancel), new 5(this, i, walletBaseUI), null);
                    return true;
                }
            case 404:
                x.i("MicroMsg.PayProcess", "404 pay error, cancel pay or change!");
                com.tencent.mm.plugin.wallet.a.p.bNp();
                ArrayList bPD = com.tencent.mm.plugin.wallet.a.p.bNq().bPD();
                if (bPD == null || bPD.isEmpty()) {
                    h.a(walletBaseUI, str, "", walletBaseUI.getString(a$i.wallet_pay_bankcard_add), walletBaseUI.getString(a$i.wallet_cancel_pay), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            b.this.jfZ.putInt("key_err_code", -1003);
                            b.this.a(walletBaseUI, 0, b.this.jfZ);
                            if (walletBaseUI.bbR()) {
                                walletBaseUI.finish();
                            }
                        }
                    }, new 7(this, walletBaseUI));
                } else {
                    h.a(walletBaseUI, str, "", walletBaseUI.getString(a$i.wallet_pay_bankcard_select), walletBaseUI.getString(a$i.wallet_cancel_pay), new 8(this, walletBaseUI), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            b.this.b(walletBaseUI, b.this.jfZ);
                            if (walletBaseUI.bbR()) {
                                walletBaseUI.finish();
                            }
                        }
                    });
                }
                return true;
        }
        return false;
    }

    private String bNs() {
        if (this.jfZ == null) {
            return "";
        }
        PayInfo payInfo = (PayInfo) this.jfZ.getParcelable("key_pay_info");
        if (payInfo != null) {
            return payInfo.bOd;
        }
        return "";
    }

    public final int a(MMActivity mMActivity, int i) {
        return a$i.wallet_pay_finish_confirm;
    }

    public final String aNK() {
        return "PayProcess";
    }
}
