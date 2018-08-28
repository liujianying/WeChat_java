package com.tencent.mm.plugin.wallet_ecard.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bbc;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.smtt.utils.TbsLog;

public final class b {
    public static boolean a(WalletBaseUI walletBaseUI, bbc bbc) {
        if (bbc == null) {
            x.i("MicroMsg.ECardUtil", "no popItem");
            return false;
        } else if (bi.oW(bbc.sdq)) {
            return false;
        } else {
            if (!bi.oW(bbc.peY) && !bi.oW(bbc.sdr)) {
                x.i("MicroMsg.ECardUtil", "show guide info 1");
                h.a(walletBaseUI, bbc.sdq, "", bbc.peY, bbc.sdr, false, new 1(bbc, walletBaseUI), new 2(bbc, walletBaseUI));
                return true;
            } else if (bi.oW(bbc.sdr)) {
                return false;
            } else {
                x.i("MicroMsg.ECardUtil", "show guide info 2");
                h.a(walletBaseUI, bbc.sdq, "", bbc.sdr, false, new 3(bbc, walletBaseUI));
                return true;
            }
        }
    }

    public static String d(Context context, String... strArr) {
        String string = context.getString(i.wallet_unknown_err);
        if (strArr.length > 0) {
            for (String str : strArr) {
                if (!bi.oW(str)) {
                    return str;
                }
            }
        }
        return string;
    }

    public static boolean a(WalletBaseUI walletBaseUI, l lVar, int i, String str, int i2, String str2) {
        if (i2 != 0) {
            i = i2;
            str = str2;
        }
        x.i("MicroMsg.ECardUtil", "finalRetCode: %s, finalRetMsg: %s", new Object[]{Integer.valueOf(i), str});
        return com.tencent.mm.wallet_core.d.h.a(walletBaseUI, lVar, TbsLog.TBSLOG_CODE_SDK_BASE, i, str);
    }

    public static void a(int i, String str, String str2, String str3, Context context, a aVar) {
        x.i("MicroMsg.ECardUtil", "start open ecard process, scene: %s, token==null%s, eCardType: %s, extraData: %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(bi.oW(str)), str2, str3});
        Bundle bundle = new Bundle();
        bundle.putInt(a.pBy, i);
        bundle.putString(a.pBz, str);
        bundle.putString(a.pBD, str2);
        bundle.putString(a.pBE, str3);
        com.tencent.mm.wallet_core.a.a((Activity) context, com.tencent.mm.plugin.wallet_ecard.b.b.class, bundle, aVar);
    }
}
