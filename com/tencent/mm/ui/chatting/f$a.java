package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.ui.x;

final class f$a implements f$c {
    f$a() {
    }

    public final boolean a(String str, Context context, x xVar, String str2) {
        Intent intent;
        if (str.startsWith("weixin://openNativeUrl/weixinHB/startsendnormalhbrequest")) {
            Intent intent2 = new Intent();
            intent2.putExtra("key_type", 0);
            d.b(context, "luckymoney", ".ui.LuckyMoneyPrepareUI", intent2);
            return true;
        } else if (str.startsWith("weixin://openNativeUrl/weixinHB/startsendrandomhbrequest")) {
            intent = new Intent();
            intent.putExtra("key_type", 1);
            d.b(context, "luckymoney", ".ui.LuckyMoneyPrepareUI", intent);
            return true;
        } else if (str.startsWith("weixin://openNativeUrl/weixinHB/startsendhblistrequest")) {
            intent = new Intent();
            intent.putExtra("key_type", 1);
            d.b(context, "luckymoney", ".ui.LuckyMoneyMyRecordUI", intent);
            return true;
        } else if (str.startsWith("weixin://openNativeUrl/weixinHB/startreceivehblistrequest")) {
            intent = new Intent();
            intent.putExtra("key_type", 2);
            d.b(context, "luckymoney", ".ui.LuckyMoneyMyRecordUI", intent);
            return true;
        } else if (str.startsWith("weixin://openNativeUrl/weixinHB/openDetail")) {
            intent = new Intent();
            intent.putExtra("key_native_url", str);
            d.b(context, "luckymoney", ".ui.LuckyMoneyDetailUI", intent);
            return true;
        } else if (!str.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
            return false;
        } else {
            intent = new Intent();
            intent.putExtra("key_way", 5);
            intent.putExtra("key_native_url", str);
            intent.putExtra("key_static_from_scene", 1);
            d.b(context, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent);
            return true;
        }
    }
}
