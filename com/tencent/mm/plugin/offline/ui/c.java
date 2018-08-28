package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Vibrator;
import android.text.TextUtils;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.offline.a.e;
import com.tencent.mm.plugin.offline.a.s.b;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.25;
import com.tencent.mm.plugin.offline.ui.b.2;
import com.tencent.mm.plugin.offline.ui.b.3;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class c {
    Vibrator hni;
    a lKZ;
    o lLa;
    float lLb = 0.0f;
    int lLc = 20000;
    Activity mActivity;

    public c(Activity activity, a aVar) {
        this.mActivity = activity;
        this.lKZ = aVar;
    }

    public final void a(l lVar, int i, String str) {
        a(lVar, i, str, null);
    }

    public final void a(l lVar, int i, String str, String str2) {
        x.i("MicroMsg.OfflineLogicMgr", "handleErrorEvent errCode :" + i + " msg:" + str);
        bld();
        if (i == 409) {
            x.i("MicroMsg.OfflineLogicMgr", "goLimitChangeUI msg:" + str);
            h.a(this.mActivity, str, "", getString(i.wallet_wx_offline_promote_coin_purse_limit_fee), getString(i.app_cancel), new 18(this), new 2(this));
        } else if (i == 410) {
            x.i("MicroMsg.OfflineLogicMgr", "showBindNewBankcardDialog msg:" + str);
            h.a(this.mActivity, str, "", getString(i.wallet_pay_bankcard_add), getString(i.app_cancel), new 16(this), new 17(this));
        } else if (i == 413) {
            x.i("MicroMsg.OfflineLogicMgr", "goChangeBankcard msg:" + str);
            h.a(this.mActivity, str, "", getString(i.wallet_wx_offline_change_pay_method), getString(i.app_cancel), new 3(this), new 4(this));
        } else if (i == 411) {
            if (com.tencent.mm.plugin.wallet_core.model.o.bOW().bPp() || com.tencent.mm.plugin.wallet_core.model.o.bOW().bPt()) {
                x.i("MicroMsg.OfflineLogicMgr", "is unreg or simplereg");
                return;
            }
            if (k.lJx && (this.mActivity instanceof WalletOfflineCoinPurseUI)) {
                WalletOfflineCoinPurseUI walletOfflineCoinPurseUI = (WalletOfflineCoinPurseUI) this.mActivity;
                walletOfflineCoinPurseUI.lLB.setVisibility(4);
                walletOfflineCoinPurseUI.lLQ.a(walletOfflineCoinPurseUI.lLt, new 25(walletOfflineCoinPurseUI), 6);
            } else {
                a.c(this.mActivity, str);
            }
            com.tencent.mm.plugin.report.service.h.mEJ.a(135, 1, 1, true);
        } else if (!(this.mActivity instanceof WalletBaseUI)) {
            b.b(this.mActivity, str);
        } else if (!com.tencent.mm.wallet_core.d.h.a((WalletBaseUI) this.mActivity, lVar, 1000, i, str)) {
            String string;
            Context context = this.mActivity;
            if (TextUtils.isEmpty(str)) {
                string = context.getString(i.wallet_unknown_err);
            } else {
                string = str;
            }
            if (bi.oW(str2)) {
                b.b(context, string);
                return;
            }
            x.i("MicroMsg.OfflineErrorHelper", "error_detail_url is not null ");
            h.a(context, string, null, context.getResources().getString(i.wallet_err_alert_btn_err_detail_text), context.getResources().getString(i.app_ok), true, new 2(str2, context), new 3());
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.OfflineLogicMgr", "errType:" + i + "  errCode" + i2 + " errMsg:" + str + " cgi type:" + lVar.getType());
        e eVar;
        if (i == 0 && i2 == 0) {
            if (!(lVar instanceof e)) {
                return false;
            }
            eVar = (e) lVar;
            Object obj = eVar.lJJ;
            bld();
            if (eVar.lJK != 0 || TextUtils.isEmpty(obj)) {
                if (!(eVar.lJK == 0 || eVar.hUm == 0 || eVar.lJM != 1)) {
                    x.i("MicroMsg.OfflineLogicMgr", "input pwd, but respon exist error!");
                    a(eVar, eVar.lJK, eVar.lJL);
                }
                return true;
            }
            a.a(this.mActivity, obj, lVar);
            this.mActivity.setResult(-1);
            this.mActivity.finish();
            return true;
        } else if (!(lVar instanceof e)) {
            return false;
        } else {
            eVar = (e) lVar;
            bld();
            if (eVar.lJM == 1) {
                x.i("MicroMsg.OfflineLogicMgr", "input pwd, but respon exist error!");
                a(lVar, i2, str);
            }
            return true;
        }
    }

    public final void bld() {
        if (this.lLa != null) {
            this.lLa.dismiss();
            this.lLa = null;
        }
    }

    public final void a(b bVar) {
        if (bVar != null) {
            x.i("MicroMsg.OfflineLogicMgr", "showFreeMsg");
            if ("1".equals(bVar.lKA)) {
                h.a(this.mActivity, false, bVar.lKC, "", getString(i.wallet_wx_offline_freeze_btn_text), getString(i.app_cancel), new 5(this), new 6(this));
            }
        }
    }

    public static boolean ble() {
        k.bkO();
        if (k.bkP().lKw != null) {
            return true;
        }
        return false;
    }

    final String getString(int i) {
        return this.mActivity.getString(i);
    }
}
