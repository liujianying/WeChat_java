package com.tencent.mm.wallet_core.ui;

import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.d.h;
import com.tencent.mm.wallet_core.e.a.b;
import com.tencent.mm.wallet_core.tenpay.model.m;

public final class f {
    private static String fGO = null;
    private static int isA = 0;
    private static int isM = 0;

    static /* synthetic */ void c(WalletBaseUI walletBaseUI) {
        if (isM == 1000) {
            switch (isA) {
                case 1:
                    if (!walletBaseUI.aWj()) {
                        walletBaseUI.ux(0);
                    }
                    walletBaseUI.rj(0);
                    break;
                case 3:
                    a.c(walletBaseUI.mController.tml, walletBaseUI.sy, isA);
                    break;
                default:
                    if (!walletBaseUI.bbR() && walletBaseUI.mController.contentView.getVisibility() == 0) {
                        walletBaseUI.rj(0);
                        break;
                    } else {
                        walletBaseUI.finish();
                        break;
                    }
                    break;
            }
        }
        a.m(walletBaseUI.mController.tml, isA);
        isM = 0;
        isA = 0;
        fGO = null;
    }

    public static void a(WalletBaseUI walletBaseUI, int i, int i2, String str, l lVar, boolean z) {
        boolean bkU;
        boolean z2;
        boolean z3 = true;
        if (bi.oW(str)) {
            str = walletBaseUI.getString(a$i.wallet_unknown_err);
        }
        if (lVar instanceof i) {
            bkU = ((i) lVar).bkU();
        } else {
            bkU = true;
        }
        if (lVar instanceof g) {
            z2 = ((g) lVar).caB;
        } else {
            z2 = bkU;
        }
        x.i("MicroMsg.WalletDispatcher", "dispatch errType:%d errCode %s ,errMsg: %s, isBlock %s scene: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z2), lVar});
        if (!((lVar instanceof m) || (lVar instanceof b))) {
            if (lVar instanceof i) {
                i iVar = (i) lVar;
                Bundle bundle;
                if (iVar.uXh == null ? false : "1".equals(iVar.uXh.trim())) {
                    x.d("MicroMsg.WalletDispatcher", "order pay end!!!");
                    bundle = walletBaseUI.sy;
                    bundle.putInt("intent_pay_end_errcode", i2);
                    bundle.putString("intent_pay_app_url", iVar.uXi);
                    bundle.putString("intent_wap_pay_jump_url", iVar.uXj);
                    bundle.putBoolean("intent_pay_end", true);
                    a.k(walletBaseUI, bundle);
                } else if ((lVar instanceof com.tencent.mm.wallet_core.tenpay.model.l) && ((com.tencent.mm.wallet_core.tenpay.model.l) lVar).pgm) {
                    x.i("MicroMsg.WalletDispatcher", "delay order pay end");
                    bundle = walletBaseUI.sy;
                    bundle.putInt("intent_pay_end_errcode", i2);
                    bundle.putString("intent_pay_app_url", iVar.uXi);
                    bundle.putString("intent_wap_pay_jump_url", iVar.uXj);
                    bundle.putBoolean("intent_pay_end", true);
                    a.k(walletBaseUI, bundle);
                }
                if (z2 && h.a(walletBaseUI, lVar, i, i2, str) && !iVar.bOn()) {
                    bkU = false;
                } else {
                    bkU = true;
                }
                if (!bkU) {
                    x.d("MicroMsg.WalletDispatcher", "wallet base consume this response before subclass!");
                } else if ((walletBaseUI.cDK() == null || !walletBaseUI.cDL().d(i, i2, str, lVar)) && !walletBaseUI.d(i, i2, str, (i) lVar) && z2) {
                    if (i == 0 && i2 == 0) {
                        x.d("MicroMsg.WalletDispatcher", "wallet this response havn't error!");
                    } else {
                        isM = i;
                        isA = i2;
                        fGO = str;
                        x.d("MicroMsg.WalletDispatcher", "wallet base consume this response in the end!");
                    }
                }
            } else if ((walletBaseUI.cDK() == null || !walletBaseUI.cDL().d(i, i2, str, lVar)) && !walletBaseUI.d(i, i2, str, lVar) && z2) {
                if (i == 0 && i2 == 0) {
                    x.d("MicroMsg.WalletDispatcher", "wallet other scene this response havn't error!");
                } else {
                    isM = i;
                    isA = i2;
                    fGO = str;
                    x.d("MicroMsg.WalletDispatcher", "wallet base consume this response in the end!");
                }
            }
        }
        if (z) {
            x.d("MicroMsg.WalletDispatcher", "scenes & forcescenes isEmpty! %s", new Object[]{Boolean.valueOf(z2)});
            if (isA != 0) {
                x.e("MicroMsg.WalletDispatcher", "showAlert! mErrCode : " + isA);
                if (lVar instanceof i) {
                    String cCY = ((i) lVar).cCY();
                    if (!bi.oW(cCY)) {
                        x.i("MicroMsg.WalletDispatcher", "error_detail_url is not null ");
                        com.tencent.mm.ui.base.h.a(walletBaseUI.mController.tml, fGO, null, walletBaseUI.getResources().getString(a$i.wallet_err_alert_btn_err_detail_text), walletBaseUI.getResources().getString(a$i.app_ok), true, new 2(walletBaseUI, cCY), new 3(walletBaseUI));
                        cDI();
                        e.He(4);
                        if (z3) {
                            x.i("MicroMsg.WalletDispatcher", "error_detail_url is null ");
                            com.tencent.mm.ui.base.h.a(walletBaseUI.mController.tml, fGO, null, false, new 1(walletBaseUI));
                        }
                    }
                }
                z3 = false;
                if (z3) {
                    x.i("MicroMsg.WalletDispatcher", "error_detail_url is null ");
                    com.tencent.mm.ui.base.h.a(walletBaseUI.mController.tml, fGO, null, false, new 1(walletBaseUI));
                }
            } else if (!walletBaseUI.aWj()) {
                walletBaseUI.ux(0);
            }
        }
    }

    public static void cDI() {
        isM = 0;
        isA = 0;
        fGO = null;
    }
}
