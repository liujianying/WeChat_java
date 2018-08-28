package com.tencent.tinker.lib.b;

import android.content.Context;
import com.tencent.tinker.lib.e.d;
import com.tencent.tinker.lib.f.b;
import com.tencent.tinker.lib.f.c;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public class a implements b {
    public final Context context;

    public a(Context context) {
        this.context = context;
    }

    public final int acN(String str) {
        int dp = dp(str, SharePatchFileUtil.ak(new File(str)));
        if (dp == 0) {
            TinkerPatchService.bM(this.context, str);
        } else {
            com.tencent.tinker.lib.e.a.hL(this.context).vsy.c(new File(str), dp);
        }
        return dp;
    }

    public int dp(String str, String str2) {
        com.tencent.tinker.lib.e.a hL = com.tencent.tinker.lib.e.a.hL(this.context);
        if (!ShareTinkerInternals.In(hL.tinkerFlags) || !ShareTinkerInternals.ib(this.context)) {
            return -1;
        }
        if (!SharePatchFileUtil.ah(new File(str))) {
            return -2;
        }
        if (hL.vsC) {
            return -4;
        }
        if (b.hN(this.context)) {
            return -3;
        }
        if (ShareTinkerInternals.cHf()) {
            return -5;
        }
        hL = com.tencent.tinker.lib.e.a.hL(this.context);
        if (hL.vsE) {
            d dVar = hL.vsD;
            if (!(dVar == null || dVar.vsL || !str2.equals(dVar.vsI))) {
                return -6;
            }
        }
        if (c.hQ(this.context).acP(str2)) {
            return 0;
        }
        return -7;
    }
}
