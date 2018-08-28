package com.tencent.mm.plugin.wallet_core.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.b.a.a;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.c.q;
import com.tencent.mm.wallet_core.d.g;

public class b extends a {
    static /* synthetic */ int e(b bVar) {
        return !bVar.bQH() ? o.bOW().bPs() ? 2 : 1 : o.bOW().bPs() ? 5 : 4;
    }

    public c a(Activity activity, Bundle bundle) {
        y(new Object[]{"start", activity, bundle});
        x.d("MicroMsg.BindCardProcess", "start Process : BindCardProcess");
        if (bundle != null) {
            q.fu(6, bundle.getInt("key_bind_scene"));
            p.GZ(bundle.getInt("key_bind_scene"));
        } else {
            q.fu(6, 0);
            p.GZ(0);
        }
        if (o.bOW().bPs()) {
            c(activity, WalletCheckPwdUI.class, bundle);
            return this;
        }
        if (bundle != null) {
            com.tencent.mm.plugin.wallet_core.e.c.ea(bundle.getInt("key_bind_scene", 0), 1);
        }
        if (bundle == null || !bundle.getBoolean("key_is_import_bind", false)) {
            return super.a(activity, bundle);
        }
        c(activity, WalletCardImportUI.class, bundle);
        return this;
    }

    public void a(Activity activity, int i, Bundle bundle) {
        y(new Object[]{"forward", activity, Integer.valueOf(i), bundle});
        x.i("MicroMsg.BindCardProcess", "forward Process : BindCardProcess");
        int i2;
        BindCardOrder bindCardOrder;
        String string;
        String string2;
        String string3;
        if (activity instanceof WalletCheckPwdUI) {
            if (bundle.getBoolean("key_is_import_bind", false)) {
                c(activity, WalletCardImportUI.class, bundle);
            } else {
                c(activity, WalletBankcardIdUI.class, bundle);
            }
        } else if ((activity instanceof WalletCardElementUI) || (activity instanceof WalletCardImportUI)) {
            if (!bQH()) {
                x.i("MicroMsg.BindCardProcess", "is domestic bankcard! need verify code!");
                c(activity, WalletVerifyCodeUI.class, bundle);
            } else if (o.bOW().bPs()) {
                x.i("MicroMsg.BindCardProcess", "bind bank card success!!");
                bundle.putBoolean("intent_bind_end", true);
                h.bA(activity, activity.getString(i.wallet_bank_card_bind_success_tips));
                b(activity, bundle);
            } else {
                x.i("MicroMsg.BindCardProcess", "wallet is not register, start WalletSetPasswordUI!");
                c(activity, WalletSetPasswordUI.class, bundle);
            }
        } else if ((activity instanceof WalletVerifyCodeUI) && o.bOW().bPs()) {
            x.i("MicroMsg.BindCardProcess", "end process after verify!");
            i2 = this.jfZ.getInt("key_bind_scene", -1);
            bindCardOrder = (BindCardOrder) this.jfZ.getParcelable("key_bindcard_value_result");
            if (bindCardOrder == null || i2 != 15) {
                b(activity, bundle);
                return;
            }
            string = this.jfZ.getString("key_bind_card_type");
            string2 = this.jfZ.getString("key_bind_card_show1");
            string3 = this.jfZ.getString("key_bind_card_show2");
            x.i("MicroMsg.BindCardProcess", "order ok bank_type %s  bank_type_show %s scene %s realnameScene %s", new Object[]{string, string2, Integer.valueOf(this.jfZ.getInt("key_bind_scene")), Integer.valueOf(this.jfZ.getInt("realname_scene"))});
            bindCardOrder.lMV = string;
            bindCardOrder.pmH = string2;
            bindCardOrder.pmI = string3;
            bindCardOrder.pmK = r4;
            bindCardOrder.pmL = r5;
            c(activity, WalletBindCardResultUI.class, bundle);
        } else if (activity instanceof WalletPwdConfirmUI) {
            x.i("MicroMsg.BindCardProcess", "end process after confirm pwd!");
            com.tencent.mm.plugin.wallet_core.e.c.ea(this.jfZ.getInt("key_bind_scene", 0), 7);
            bundle.putBoolean("intent_bind_end", true);
            h.bA(activity, activity.getString(i.wallet_bank_card_bind_success_tips));
            bindCardOrder = (BindCardOrder) this.jfZ.getParcelable("key_bindcard_value_result");
            i2 = this.jfZ.getInt("key_bind_scene", -1);
            if (bindCardOrder == null || i2 != 15) {
                b(activity, bundle);
                return;
            }
            string = this.jfZ.getString("key_bind_card_type");
            string2 = this.jfZ.getString("key_bind_card_show1");
            string3 = this.jfZ.getString("key_bind_card_show2");
            x.i("MicroMsg.BindCardProcess", "order ok bank_type %s  bank_type_show %s scene %s realnameScene %s", new Object[]{string, string2, Integer.valueOf(this.jfZ.getInt("key_bind_scene")), Integer.valueOf(this.jfZ.getInt("realname_scene"))});
            bindCardOrder.lMV = string;
            bindCardOrder.pmH = string2;
            bindCardOrder.pmI = string3;
            bindCardOrder.pmK = r4;
            bindCardOrder.pmL = r5;
            c(activity, WalletBindCardResultUI.class, bundle);
        } else if (activity instanceof WalletBindCardResultUI) {
            b(activity, bundle);
        } else {
            x.i("MicroMsg.BindCardProcess", "super forward!");
            super.a(activity, 0, bundle);
        }
    }

    public g a(MMActivity mMActivity, com.tencent.mm.wallet_core.d.i iVar) {
        if (mMActivity instanceof WalletCheckPwdUI) {
            return new 1(this, mMActivity, iVar);
        }
        if ((mMActivity instanceof WalletCardElementUI) || (mMActivity instanceof WalletCardImportUI)) {
            return new 2(this, mMActivity, iVar);
        }
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new g(mMActivity, iVar) {
                public final boolean d(int i, int i2, String str, l lVar) {
                    if (i == 0 && i2 == 0) {
                        if (lVar instanceof a) {
                            x.i("MicroMsg.BindCardProcess", "verify code success!");
                            b.this.jfZ.putString("kreq_token", ((a) lVar).token);
                            return true;
                        } else if (lVar instanceof com.tencent.mm.plugin.wallet_core.c.q) {
                            b.this.a(this.uXK);
                            if (((com.tencent.mm.plugin.wallet_core.c.q) lVar).piW != null) {
                                b.this.jfZ.putParcelable("key_bindcard_value_result", ((com.tencent.mm.plugin.wallet_core.c.q) lVar).piW);
                            }
                        } else if (lVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.h) {
                            return true;
                        }
                    }
                    return false;
                }

                public final boolean m(Object... objArr) {
                    b.this.y(new Object[]{"WalletVerifyCodeUI onNext", objArr});
                    x.i("MicroMsg.BindCardProcess", "onNext, do bind verify!");
                    com.tencent.mm.plugin.wallet_core.model.p pVar = (com.tencent.mm.plugin.wallet_core.model.p) objArr[1];
                    if (o.bOW().bPs()) {
                        pVar.flag = "2";
                    } else {
                        pVar.flag = "1";
                    }
                    if ("realname_verify_process".equals(b.this.aNK())) {
                        this.uXK.a(new com.tencent.mm.plugin.wallet_core.c.q(pVar, b.this.jfZ.getInt("entry_scene", -1)), true, 1);
                    } else {
                        this.uXK.a(new com.tencent.mm.plugin.wallet_core.c.q(pVar), true, 1);
                    }
                    return true;
                }
            };
        }
        return mMActivity instanceof WalletPwdConfirmUI ? new 4(this, mMActivity, iVar) : super.a(mMActivity, iVar);
    }

    public final void a(com.tencent.mm.wallet_core.d.i iVar) {
        x.d("MicroMsg.BindCardProcess", "do set user exinfo");
        iVar.a(new com.tencent.mm.plugin.wallet_core.id_verify.model.h(this.jfZ.getString("key_country_code", ""), this.jfZ.getString("key_province_code", ""), this.jfZ.getString("key_city_code", ""), (Profession) this.jfZ.getParcelable("key_profession")), false, 1);
    }

    public void b(Activity activity, Bundle bundle) {
        y(new Object[]{"end", activity, bundle});
        x.i("MicroMsg.BindCardProcess", "end Process : BindCardProcess");
        p.cDe();
        cCV();
        if (bundle == null || !bundle.getBoolean("key_need_bind_response", false)) {
            e(activity, "mall", ".ui.MallIndexUI");
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        a(activity, "wallet", ".bind.ui.WalletBindUI", -1, intent, false);
    }

    public boolean c(Activity activity, Bundle bundle) {
        if (!o.bOW().bPs()) {
            return activity instanceof WalletPwdConfirmUI;
        }
        if (((activity instanceof WalletCardElementUI) && bQH()) || (activity instanceof WalletVerifyCodeUI)) {
            return true;
        }
        return false;
    }

    public String aNK() {
        return "BindCardProcess";
    }
}
