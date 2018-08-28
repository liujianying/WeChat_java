package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.chatting.f.c;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.x;

final class f$d implements c {
    f$d() {
    }

    public final boolean a(String str, Context context, x xVar, String str2) {
        Intent intent;
        if (bi.oW(str)) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BizNativeUrlDispatcher", "nativeUrl is null.");
            return false;
        } else if (str.startsWith("weixin://wesport/recommend") && xVar != null) {
            intent = new Intent(context, SelectConversationUI.class);
            intent.putExtra("Select_Talker_Name", str2);
            intent.putExtra("Select_block_List", str2);
            intent.putExtra("Select_Conv_Type", 3);
            intent.putExtra("Select_Send_Card", true);
            xVar.startActivityForResult(intent, 224);
            return true;
        } else if (str.startsWith("weixin://openNativeUrl/rankMyHomepage")) {
            String GF = q.GF();
            if (bi.oW(GF)) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BizNativeUrlDispatcher", "Get username from UserInfo return null or nil.");
                return false;
            }
            intent = new Intent();
            intent.putExtra("username", GF);
            d.b(context, "exdevice", ".ui.ExdeviceProfileUI", intent);
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BizNativeUrlDispatcher", "Jump to ExdeviceProfileUI.");
            return true;
        } else if (!str.startsWith("weixin://openNativeUrl/rankSetting")) {
            return false;
        } else {
            d.A(context, "exdevice", ".ui.ExdeviceSettingUI");
            return true;
        }
    }
}
