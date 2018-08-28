package com.tencent.mm.plugin.offline;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiBatchGetContact;
import com.tencent.mm.plugin.offline.a.k;
import com.tencent.mm.plugin.offline.a.n;
import com.tencent.mm.plugin.offline.a.p;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class h$1 extends g {
    final /* synthetic */ h lJb;

    h$1(h hVar, MMActivity mMActivity, i iVar) {
        this.lJb = hVar;
        super(mMActivity, iVar);
    }

    public final /* synthetic */ CharSequence ui(int i) {
        switch (i) {
            case 0:
                return this.fEY.getString(a.i.wallet_check_pwd_tip);
            case 1:
                return this.fEY.getString(a.i.wallet_check_pwd_open_offline);
            default:
                return "";
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0) {
            if (lVar instanceof k) {
                x.i("MicroMsg.OfflineProcess", "Offline is Create ");
                bkM();
                h.a(this.lJb).putBoolean("is_offline_create", true);
            } else if (lVar instanceof n) {
                x.i("MicroMsg.OfflineProcess", "OfflineQueryUser is ok ");
                i iVar = this.uXK;
                if (iVar.eXG == null || !(iVar.eXG == null || iVar.eXG.isShowing())) {
                    if (iVar.eXG != null) {
                        iVar.eXG.dismiss();
                    }
                    if (iVar.mContext == null) {
                        x.w("MicroMsg.WalletNetSceneMgr", "activity has destroyed!!!");
                    } else {
                        iVar.eXG = com.tencent.mm.wallet_core.ui.g.a(iVar.mContext, false, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                i.this.baT();
                            }
                        });
                    }
                }
                sz szVar = new sz();
                szVar.cdR.scene = 8;
                szVar.cdS.cdN = new 1(this);
                com.tencent.mm.sdk.b.a.sFg.m(szVar);
            } else if (lVar instanceof com.tencent.mm.plugin.offline.a.i) {
                com.tencent.mm.plugin.offline.a.i iVar2 = (com.tencent.mm.plugin.offline.a.i) lVar;
                if ("1".equals(iVar2.lJT)) {
                    MMActivity mMActivity = this.fEY;
                    String str2 = iVar2.bTi;
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("key_authen", new Authen());
                    bundle.putString("key_pwd1", h.j(this.lJb).getString("key_pwd1"));
                    bundle.putString("key_mobile", str2);
                    bundle.putInt("verify_scene", 1);
                    bundle.putInt("offline_add_fee", h.k(this.lJb).getInt("offline_chg_fee", 0));
                    com.tencent.mm.wallet_core.a.a(mMActivity, l.class, bundle);
                    this.lJb.a(mMActivity, 0, h.l(this.lJb));
                } else {
                    h.c(this.lJb).putBoolean("back_to_coin_purse_ui", true);
                    bkM();
                }
            } else if (lVar instanceof p) {
                com.tencent.mm.plugin.offline.c.a.IZ("");
                k.bkO();
                k.bkP().lKw = null;
                this.lJb.a(this.fEY, 0, h.d(this.lJb));
            }
            return true;
        } else if (!(lVar instanceof k)) {
            return false;
        } else {
            x.i("MicroMsg.OfflineProcess", "Offline Create is failed!");
            k kVar = (k) lVar;
            if (i2 != JsApiBatchGetContact.CTRL_INDEX) {
                return false;
            }
            MMActivity mMActivity2 = this.fEY;
            String str3 = str;
            h.a(mMActivity2, str3, "", mMActivity2.getString(a.i.wallet_pay_bankcard_add), mMActivity2.getString(a.i.app_cancel), new 2(this, mMActivity2, kVar.lKh), new 3(this, mMActivity2));
            return true;
        }
    }

    public final boolean m(Object... objArr) {
        String str = (String) objArr[0];
        h.e(this.lJb).putString("key_pwd1", str);
        Bankcard blB = com.tencent.mm.plugin.offline.c.a.blB();
        if (blB == null) {
            x.e("MicroMsg.OfflineProcess", "no support bank car for offline");
            blB = com.tencent.mm.plugin.offline.c.a.blC();
        }
        if (blB == null) {
            x.e("MicroMsg.OfflineProcess", "no any bank car for offline");
            return false;
        }
        String string = h.f(this.lJb).getString("oper");
        if (!com.tencent.mm.plugin.offline.c.a.bly()) {
            x.i("MicroMsg.OfflineProcess", "Offline is not Create ");
            this.uXK.a(new k(blB, (String) objArr[0], h.g(this.lJb).getInt("offline_chg_fee", 0)), true, 1);
        } else if (string != null) {
            x.i("MicroMsg.OfflineProcess", "oper == " + string);
            if (string.equals("create")) {
                this.uXK.a(new k(blB, (String) objArr[0], h.h(this.lJb).getInt("offline_chg_fee", 0)), true, 1);
            } else if (string.equals("clr")) {
                this.uXK.a(new com.tencent.mm.plugin.offline.a.i(blB, str, "clr", 0, ""), true, 1);
            } else if (string.equals("changeto")) {
                this.uXK.a(new com.tencent.mm.plugin.offline.a.i(blB, str, "changeto", h.i(this.lJb).getInt("offline_chg_fee"), ""), true, 1);
            } else if (!string.equals("freeze")) {
                return false;
            } else {
                this.uXK.a(new p(str), true, 1);
            }
        }
        return true;
    }

    private void bkM() {
        this.uXK.a(new n(System.currentTimeMillis(), com.tencent.mm.plugin.offline.c.a.lMM), false, 1);
    }
}
