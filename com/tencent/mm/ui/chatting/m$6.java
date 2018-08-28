package com.tencent.mm.ui.chatting;

import android.content.Intent;
import com.tencent.mm.bg.d.a;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

class m$6 implements a {
    final /* synthetic */ com.tencent.mm.ui.chatting.c.a tIQ;

    m$6(com.tencent.mm.ui.chatting.c.a aVar) {
        this.tIQ = aVar;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        if (i == TbsListener$ErrorCode.CREATE_TEMP_CONF_ERROR) {
            m.a(this.tIQ, intent.getStringExtra("enterprise_biz_name"), intent.getLongExtra("key_biz_chat_id", -1));
        }
    }
}
