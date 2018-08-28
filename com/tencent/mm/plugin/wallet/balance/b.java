package com.tencent.mm.plugin.wallet.balance;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchPwdInputUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.e;
import java.text.SimpleDateFormat;
import java.util.Date;

public class b extends c {
    static /* synthetic */ String n(b bVar) {
        if (bVar.jfZ != null) {
            PayInfo payInfo = (PayInfo) bVar.jfZ.getParcelable("key_pay_info");
            if (payInfo != null) {
                return payInfo.bOd;
            }
        }
        return "";
    }

    public final c a(Activity activity, Bundle bundle) {
        p.GZ(14);
        if (activity instanceof WalletBalanceFetchUI) {
            com.tencent.mm.plugin.wallet.a.p.bNp();
            if (!com.tencent.mm.plugin.wallet.a.p.bNq().bPs()) {
                this.jfZ.putInt("key_pay_flag", 1);
                c(activity, WalletBankcardIdUI.class, bundle);
            } else if (((Bankcard) this.jfZ.getParcelable("key_bankcard")) != null) {
                this.jfZ.putInt("key_pay_flag", 3);
                this.jfZ.putString("key_pwd_cash_title", activity.getString(a$i.wallet_balance_fetch_title));
                Orders orders = (Orders) this.jfZ.getParcelable("key_orders");
                if (orders != null) {
                    this.jfZ.putString("key_pwd_cash_money", e.B(orders.mBj));
                }
                c(activity, WalletBalanceFetchPwdInputUI.class, bundle);
            } else {
                this.jfZ.putInt("key_pay_flag", 2);
                c(activity, WalletCheckPwdUI.class, bundle);
            }
        } else {
            c(activity, WalletBalanceFetchUI.class, bundle);
        }
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletBalanceFetchUI) {
            com.tencent.mm.plugin.wallet.a.p.bNp();
            if (!com.tencent.mm.plugin.wallet.a.p.bNq().bPs()) {
                this.jfZ.putInt("key_pay_flag", 1);
                c(activity, WalletBankcardIdUI.class, bundle);
            } else if (((Bankcard) this.jfZ.getParcelable("key_bankcard")) != null) {
                this.jfZ.putInt("key_pay_flag", 3);
                this.jfZ.putString("key_pwd_cash_title", activity.getString(a$i.wallet_balance_fetch_title));
                Orders orders = (Orders) this.jfZ.getParcelable("key_orders");
                if (orders != null) {
                    this.jfZ.putString("key_pwd_cash_money", e.B(orders.mBj));
                }
                c(activity, WalletBalanceFetchPwdInputUI.class, bundle);
            } else {
                this.jfZ.putInt("key_pay_flag", 2);
                c(activity, WalletCheckPwdUI.class, bundle);
            }
        } else if (activity instanceof WalletBalanceFetchPwdInputUI) {
            if (bundle.getBoolean("key_need_verify_sms", false)) {
                c(activity, WalletVerifyCodeUI.class, bundle);
            } else {
                c(activity, WalletBalanceFetchResultUI.class, bundle);
            }
        } else if (activity instanceof WalletCheckPwdUI) {
            c(activity, WalletBankcardIdUI.class, bundle);
        } else if ((activity instanceof WalletBankcardIdUI) || (activity instanceof WalletConfirmCardIDUI)) {
            c(activity, WalletCardElementUI.class, bundle);
        } else if (activity instanceof WalletCardElementUI) {
            c(activity, WalletVerifyCodeUI.class, bundle);
        } else if (activity instanceof WalletVerifyCodeUI) {
            com.tencent.mm.plugin.wallet.a.p.bNp();
            if (com.tencent.mm.plugin.wallet.a.p.bNq().bPs()) {
                c(activity, WalletBalanceFetchResultUI.class, bundle);
            } else {
                c(activity, WalletSetPasswordUI.class, bundle);
            }
        } else if (activity instanceof WalletSetPasswordUI) {
            c(activity, WalletPwdConfirmUI.class, bundle);
        } else if (activity instanceof WalletPwdConfirmUI) {
            c(activity, WalletBalanceFetchResultUI.class, bundle);
        } else if (activity instanceof WalletBalanceFetchResultUI) {
            b(activity, bundle);
        }
    }

    public final void c(Activity activity, int i) {
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
        } else if (activity instanceof WalletBalanceResultUI) {
            p.cDe();
            b(activity, this.jfZ);
        } else {
            p.cDe();
            z(activity);
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        a(activity, WalletBalanceManagerUI.class, -1, true);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final g a(MMActivity mMActivity, i iVar) {
        if (mMActivity instanceof WalletBalanceFetchUI) {
            return new 1(this, mMActivity, iVar);
        }
        if (mMActivity instanceof WalletBalanceFetchPwdInputUI) {
            return new g(mMActivity, iVar) {
                public final boolean d(int i, int i2, String str, l lVar) {
                    boolean z = false;
                    if (i != 0 || i2 != 0 || !(lVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b)) {
                        return false;
                    }
                    com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) lVar;
                    b.this.jfZ.putString("kreq_token", bVar.token);
                    b.this.jfZ.putParcelable("key_authen", bVar.pfc);
                    Bundle d = b.this.jfZ;
                    String str2 = "key_need_verify_sms";
                    if (!bVar.pfa) {
                        z = true;
                    }
                    d.putBoolean(str2, z);
                    RealnameGuideHelper realnameGuideHelper = bVar.lJN;
                    if (realnameGuideHelper != null) {
                        b.this.jfZ.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                    }
                    a.j(this.fEY, b.this.jfZ);
                    this.fEY.finish();
                    return true;
                }

                public final boolean m(Object... objArr) {
                    Bankcard bankcard = (Bankcard) b.this.jfZ.getParcelable("key_bankcard");
                    b.this.jfZ.putString("key_pwd1", (String) objArr[0]);
                    b.this.jfZ.putString("key_mobile", bankcard.field_mobile);
                    Authen authen = new Authen();
                    authen.bWA = 3;
                    authen.pli = (String) objArr[0];
                    authen.lMW = bankcard.field_bindSerial;
                    authen.lMV = bankcard.field_bankcardType;
                    authen.mpb = (PayInfo) b.this.jfZ.getParcelable("key_pay_info");
                    authen.plq = bankcard.field_arrive_type;
                    this.uXK.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, (Orders) b.this.jfZ.getParcelable("key_orders")), true, 1);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletCardElementUI) {
            return new g(mMActivity, iVar) {
                public final boolean d(int i, int i2, String str, l lVar) {
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (lVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                        com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) lVar;
                        b.this.jfZ.putString("kreq_token", bVar.token);
                        if (bVar.pgm) {
                            b.this.jfZ.putParcelable("key_orders", bVar.pfb);
                        }
                    }
                    if (b.this.c(this.fEY, null)) {
                        this.uXK.a(new y(b.n(b.this), 13), true, 1);
                        return true;
                    }
                    b.this.a(this.fEY, 0, b.this.jfZ);
                    return true;
                }

                public final boolean m(Object... objArr) {
                    Authen authen = (Authen) objArr[0];
                    Orders orders = (Orders) objArr[1];
                    switch (b.this.jfZ.getInt("key_pay_flag", 0)) {
                        case 1:
                            if (!b.this.bQH()) {
                                authen.bWA = 1;
                                break;
                            }
                            authen.bWA = 4;
                            break;
                        case 2:
                            if (!b.this.bQH()) {
                                authen.bWA = 2;
                                break;
                            }
                            authen.bWA = 5;
                            break;
                        case 3:
                            if (!b.this.bQH()) {
                                authen.bWA = 3;
                                break;
                            }
                            authen.bWA = 6;
                            break;
                        default:
                            return false;
                    }
                    b.this.jfZ.putParcelable("key_authen", authen);
                    this.uXK.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders), true, 1);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new 4(this, mMActivity, iVar);
        }
        if (mMActivity instanceof WalletBalanceFetchResultUI) {
            return new g(mMActivity, iVar) {
                public final boolean r(Object... objArr) {
                    Orders orders = (Orders) b.this.jfZ.getParcelable("key_orders");
                    Bankcard bankcard = o.bOW().paw;
                    bankcard.plV -= orders.mBj;
                    b.this.jfZ.putInt("key_balance_result_logo", h.remittance_wait);
                    return super.r(objArr);
                }

                public final boolean d(int i, int i2, String str, l lVar) {
                    return false;
                }

                public final boolean m(Object... objArr) {
                    return false;
                }

                public final CharSequence ui(int i) {
                    Orders orders;
                    switch (i) {
                        case 0:
                            return this.fEY.getString(a$i.wallet_balance_result_fetch_title);
                        case 1:
                            orders = (Orders) b.this.jfZ.getParcelable("key_orders");
                            if (orders == null || bi.oW(orders.ppa)) {
                                return this.fEY.getString(a$i.wallet_balance_result_fetch_request_title);
                            }
                            return orders.ppa;
                        case 2:
                            orders = (Orders) b.this.jfZ.getParcelable("key_orders");
                            if (orders != null && orders.poZ > 0) {
                                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(orders.poZ));
                            }
                    }
                    return super.ui(i);
                }
            };
        }
        return mMActivity instanceof WalletPwdConfirmUI ? new 6(this, mMActivity, iVar) : super.a(mMActivity, iVar);
    }

    public final int a(MMActivity mMActivity, int i) {
        return a$i.wallet_balance_fetch_finish_confirm;
    }

    public final String aNK() {
        return "BalanceFetchProcess";
    }
}
