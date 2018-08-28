package com.tencent.mm.plugin.luckymoney.b;

import android.text.TextUtils;
import com.tencent.mm.g.a.ai;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.io.File;
import java.util.ArrayList;

public final class c extends com.tencent.mm.sdk.b.c<ai> {
    private ArrayList<String> kPC;

    public c() {
        this.kPC = new ArrayList();
        this.sFo = ai.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ai aiVar = (ai) bVar;
        if (!g.Eg().Dx()) {
            x.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:callback() acc not ready!");
        } else if (aiVar instanceof ai) {
            x.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:callback() receive C2CNYPredownloadImgEvent event!");
            g.Ek();
            int intValue = ((Integer) g.Ei().DT().get(a.sSS, Integer.valueOf(1))).intValue();
            x.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "prestrainFlag:" + intValue);
            if (intValue == 0) {
                x.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:prestrainFlag is 0, do nothing!");
            } else {
                String str = aiVar.bHG.bHH;
                Object obj = aiVar.bHG.bHI;
                int i = aiVar.bHG.bHJ;
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(obj) || i <= 0) {
                    x.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:c2c new year msg image param is invalid!");
                } else if (!ao.isWifi(ad.getContext())) {
                    x.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:is not wifi network, do nothing!");
                } else if (this.kPC.contains(str)) {
                    x.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:imageid is exist!, do nothing!  imageid:" + str);
                } else {
                    String str2 = o.Ge(str) + ".temp";
                    if (new File(str2).exists()) {
                        x.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:imagePath file is exist! not download it!");
                    } else {
                        x.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:callback() imagePath:" + str2 + " is not exist!");
                        this.kPC.add(str);
                        new k().a(str, obj, i, str2, new 1(this));
                    }
                }
            }
        }
        return false;
    }
}
