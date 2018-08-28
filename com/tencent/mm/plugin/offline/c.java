package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.kr;
import com.tencent.mm.plugin.offline.a.k;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.c.q;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class c extends b {
    static /* synthetic */ void g(MMActivity mMActivity) {
        String string = ((WalletBaseUI) mMActivity).sy.getString("key_pwd1");
        int i = ((WalletBaseUI) mMActivity).sy.getInt("offline_add_fee", 0);
        Bankcard blB = a.blB();
        if (blB != null) {
            ((WalletBaseUI) mMActivity).a(new k(blB, string, i), true, false);
        }
    }

    public final com.tencent.mm.wallet_core.c a(Activity activity, Bundle bundle) {
        return super.a(activity, bundle);
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        super.a(activity, i, bundle);
    }

    public final void b(Activity activity, Bundle bundle) {
        com.tencent.mm.sdk.b.a.sFg.m(new kr());
        if (a.bly()) {
            c(activity, WalletOfflineEntranceUI.class);
        } else if (bundle.getInt("key_entry_scene", -1) == 2) {
            e(activity, "offline", "ui.WalletOfflineEntranceUI");
        } else {
            e(activity, "mall", ".ui.MallIndexUI");
        }
        if (activity != null) {
            activity.finish();
        }
    }

    public final g a(MMActivity mMActivity, i iVar) {
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new g(mMActivity, iVar) {
                public final boolean m(Object... objArr) {
                    p pVar = (p) objArr[1];
                    pVar.flag = "2";
                    this.uXK.a(new q(pVar), true, 1);
                    return true;
                }

                public final boolean d(int i, int i2, String str, l lVar) {
                    if (i == 0 && i2 == 0) {
                        if (lVar instanceof y) {
                            if (!(((WalletBaseUI) this.fEY).sy == null || ((WalletBaseUI) this.fEY).sy.getInt("key_bind_scene", -1) != 5 || a.bly())) {
                                c.g(this.fEY);
                                return true;
                            }
                        } else if (lVar instanceof k) {
                            com.tencent.mm.wallet_core.a.j(this.fEY, ((WalletBaseUI) this.fEY).sy);
                            a.C(this.fEY);
                            return true;
                        }
                    }
                    return false;
                }
            };
        }
        return mMActivity instanceof WalletPwdConfirmUI ? new 2(this, mMActivity, iVar) : super.a(mMActivity, iVar);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return super.c(activity, bundle);
    }

    public final String aNK() {
        return "OfflineBindCardProcess";
    }
}
