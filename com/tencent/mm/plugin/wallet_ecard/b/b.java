package com.tencent.mm.plugin.wallet_ecard.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wallet_ecard.a.a;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardCheckOtherCardUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardElementInputUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardFinishUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenECardProxyUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenLqbProxyUI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class b extends c {
    static /* synthetic */ String b(b bVar) {
        String string = bVar.jfZ.getString(a.pBD);
        return bi.oW(string) ? "WEB_DEBIT" : string;
    }

    public final c a(Activity activity, Bundle bundle) {
        c(activity, WalletOpenECardProxyUI.class, bundle);
        x.i("MicroMsg.OpenECardProcess", "start open ecard: %s", new Object[]{Integer.valueOf(bRa())});
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletCheckPwdUI) {
            if (bundle.getBoolean(a.pBQ, false)) {
                x.i("MicroMsg.OpenECardProcess", "forward, is reuse exist card");
                this.jfZ.putBoolean(a.pBQ, true);
                c(activity, WalletOpenECardProxyUI.class, bundle);
                activity.finish();
                return;
            }
            c(activity, WalletECardBindCardListUI.class, null);
        } else if (!(activity instanceof WalletECardBindCardListUI)) {
            if (!(activity instanceof WalletVerifyCodeUI)) {
                if (activity instanceof WalletECardCheckOtherCardUI) {
                    x.i("MicroMsg.OpenECardProcess", "input card elem: %s, verify sms: %s", new Object[]{Boolean.valueOf(bundle.getBoolean(a.pBO, false)), Boolean.valueOf(bundle.getBoolean(a.pBN))});
                    if (bundle.getBoolean(a.pBO, false)) {
                        c(activity, WalletECardElementInputUI.class, null);
                        return;
                    } else if (r1) {
                        bundle.putBoolean("key_need_confirm_finish", true);
                        b(activity, WalletVerifyCodeUI.class, bundle);
                        return;
                    }
                } else if (activity instanceof WalletECardElementInputUI) {
                    if (bundle.getBoolean(a.pBN)) {
                        bundle.putBoolean("key_need_confirm_finish", true);
                        b(activity, WalletVerifyCodeUI.class, bundle);
                        return;
                    }
                    g(activity, bundle);
                    return;
                } else if (activity instanceof WalletOpenECardProxyUI) {
                    boolean z = bundle.getBoolean(a.pBB, false);
                    this.jfZ.putBoolean(a.pBB, z);
                    String string = this.jfZ.getString(a.pBz);
                    x.i("MicroMsg.OpenECardProcess", "forward openScene: %s, token==null: %s, isTokenInvalid: %s, action: %s", new Object[]{Integer.valueOf(bRa()), Boolean.valueOf(bi.oW(string)), Boolean.valueOf(z), Integer.valueOf(bundle.getInt("key_ecard_proxy_action", 1))});
                    if (bundle.getInt("key_ecard_proxy_action", 1) == 1) {
                        if (bi.oW(string)) {
                            a(activity, WalletCheckPwdUI.class, bundle, 1);
                            return;
                        } else if (z) {
                            c(activity, WalletCheckPwdUI.class, bundle);
                            return;
                        } else if (r2 == 3) {
                            c(activity, WalletECardBindCardListUI.class, null);
                            return;
                        } else {
                            return;
                        }
                    } else if (bundle.getBoolean(a.pBN)) {
                        bundle.putBoolean("key_need_confirm_finish", true);
                        b(activity, WalletVerifyCodeUI.class, bundle);
                        return;
                    }
                } else {
                    return;
                }
            }
            g(activity, bundle);
        } else if (this.jfZ.getInt(a.pBC, a.pBS) != a.pBS) {
            c(activity, WalletECardCheckOtherCardUI.class, null);
        } else if (bundle.getBoolean(a.pBN)) {
            bundle.putBoolean("key_need_confirm_finish", true);
            b(activity, WalletVerifyCodeUI.class, bundle);
        } else {
            g(activity, bundle);
        }
    }

    private void g(Activity activity, Bundle bundle) {
        x.l("MicroMsg.OpenECardProcess", "gotoFinishUI, openScene: %s", new Object[]{Integer.valueOf(bRa())});
        if (bRa() == 3) {
            bundle.putInt(a.pBy, 3);
            bundle.putString(a.pBE, this.jfZ.getString(a.pBE, ""));
            c(activity, WalletOpenLqbProxyUI.class, bundle);
            return;
        }
        c(activity, WalletECardFinishUI.class, null);
    }

    public final void c(Activity activity, int i) {
        if (i == 100) {
            x.i("MicroMsg.OpenECardProcess", "back to card list");
            int bRa = bRa();
            String bQZ = bQZ();
            String str = (String) this.jfZ.get("key_pwd1");
            this.jfZ.clear();
            this.jfZ.putInt(a.pBy, bRa);
            this.jfZ.putString(a.pBA, bQZ);
            this.jfZ.putString("key_pwd1", str);
            a(activity, WalletECardBindCardListUI.class, 0);
        } else if (!(activity instanceof WalletVerifyCodeUI)) {
        } else {
            if (this.jfZ.getInt(a.pBC) == a.pBS) {
                a(activity, WalletECardBindCardListUI.class, 0);
            } else {
                a(activity, WalletECardCheckOtherCardUI.class, 0);
            }
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        x.i("MicroMsg.OpenECardProcess", "end process: %s", new Object[]{activity});
        if (bundle == null) {
            bundle = new Bundle();
        }
        Intent intent = new Intent(activity, WalletOpenECardProxyUI.class);
        intent.putExtras(bundle);
        Activity activity2 = activity;
        a(activity2, WalletOpenECardProxyUI.class, bundle.getInt("key_process_result_code", -1), intent, true);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String aNK() {
        return "OpenECardProcess";
    }

    public final boolean h(Activity activity, Bundle bundle) {
        x.d("MicroMsg.OpenECardProcess", "intercept");
        bundle.putInt("key_process_result_code", 0);
        return super.h(activity, bundle);
    }

    private String bQZ() {
        return this.jfZ.getString(a.pBA);
    }

    private int bRa() {
        return this.jfZ.getInt(a.pBy);
    }

    public final g a(MMActivity mMActivity, i iVar) {
        if (mMActivity instanceof WalletCheckPwdUI) {
            return new b(this, mMActivity, iVar);
        }
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new g(this, mMActivity, iVar);
        }
        if (mMActivity instanceof WalletECardBindCardListUI) {
            return new d(this, mMActivity, iVar);
        }
        if (mMActivity instanceof WalletECardCheckOtherCardUI) {
            return new a(this, mMActivity, iVar);
        }
        if (mMActivity instanceof WalletECardElementInputUI) {
            return new e(this, mMActivity, iVar);
        }
        if (mMActivity instanceof WalletOpenECardProxyUI) {
            return new c(this, mMActivity, iVar);
        }
        if (mMActivity instanceof WalletOpenLqbProxyUI) {
            return new f(this, mMActivity, iVar);
        }
        return super.a(mMActivity, iVar);
    }
}
