package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import android.content.Intent;
import com.tencent.mm.plugin.luckymoney.appbrand.a.c;
import com.tencent.mm.protocal.c.alo;
import com.tencent.mm.protocal.c.ayk;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public final class d implements a {
    boolean acT = false;
    private String appId;
    b kLY;
    private String kLZ;
    int kMa = 0;
    final List<alo> kMb = new LinkedList();

    static /* synthetic */ void a(d dVar, String str, Intent intent) {
        if (dVar.kLY == null) {
            x.e("MicroMsg.WxaLuckyMoneyLogicDetail", "fail ui == null");
            return;
        }
        dVar.kLY.baB();
        dVar.kLY.Ga(str);
        dVar.kLY.P(intent);
    }

    public final /* synthetic */ void a(Object obj, Intent intent) {
        this.kLY = (b) obj;
        this.kLZ = intent.getStringExtra("key_sendid");
        this.appId = intent.getStringExtra("key_appid");
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_data");
        String stringExtra = intent.getStringExtra("key_from");
        if (stringExtra != null && stringExtra.equalsIgnoreCase("value_open")) {
            ayk aA = aA(byteArrayExtra);
            if (aA == null) {
                x.e("MicroMsg.WxaLuckyMoneyLogicDetail", "parse OpenWxaHBResponse failed.");
            } else {
                this.kMa = aA.sbn;
                this.kMb.addAll(aA.sbi);
                this.kLY.baB();
                this.kLY.a(aA);
                return;
            }
        }
        rY(0);
    }

    private static ayk aA(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            x.e("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom failed. No data found.");
            return null;
        }
        ayk ayk = new ayk();
        try {
            ayk.aG(bArr);
            x.i("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom succeed.");
            return ayk;
        } catch (IOException e) {
            x.e("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom failed. IOException: %s", new Object[]{e});
            return null;
        }
    }

    public final void onDestroy() {
        x.i("MicroMsg.WxaLuckyMoneyLogicDetail", "onDestroy() called");
        this.kLY = null;
    }

    public final void rW(int i) {
        if (this.kLY == null) {
            x.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage ui == null");
        } else if (i < this.kMb.size()) {
            x.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage. offset = [%d], list.size() = [%d], skip load", new Object[]{Integer.valueOf(i), Integer.valueOf(this.kMb.size())});
        } else if (this.acT) {
            x.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage failed. is loading now...");
        } else if (this.kMa == 0) {
            x.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage failed. do not has more...");
        } else {
            x.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage load");
            this.acT = true;
            rY(i);
        }
    }

    private void rY(int i) {
        new c(this.appId, this.kLZ, i).b(new 1(this, i));
    }
}
