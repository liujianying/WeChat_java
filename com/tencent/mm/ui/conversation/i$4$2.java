package com.tencent.mm.ui.conversation;

import android.content.Intent;
import com.tencent.mm.c.i;
import com.tencent.mm.c.i.a;
import com.tencent.mm.model.au;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.conversation.i.4;

class i$4$2 implements Runnable {
    final /* synthetic */ 4 uqT;

    i$4$2(4 4) {
        this.uqT = 4;
    }

    public final void run() {
        x.i("MicroMsg.InitHelper", "path:%s,apkMd5:%s", new Object[]{this.uqT.uqS.sqp, this.uqT.uqS.knk});
        String substring = this.uqT.uqS.knh.substring(0, this.uqT.uqS.knh.lastIndexOf(47) + 1);
        String substring2 = this.uqT.uqS.knh.substring(this.uqT.uqS.knh.lastIndexOf(47) + 1);
        i iVar = new i(substring, this.uqT.uqS.versionCode);
        iVar.a(new a(this.uqT.uqS.knl, this.uqT.uqS.knk, this.uqT.uqS.bxD, substring2, this.uqT.uqS.gsu));
        Intent intent = new Intent();
        intent.putExtra("intent_short_ips", com.tencent.mm.pluginsdk.f.i.getShortIps());
        intent.putExtra("intent_client_version", d.qVN);
        intent.putExtra("intent_extra_session", au.DF().dJs.Lr().DE());
        intent.putExtra("intent_extra_cookie", au.DF().dJs.Lr().Lm());
        intent.putExtra("intent_extra_ecdhkey", au.DF().dJs.Lr().Lo());
        intent.putExtra("intent_extra_uin", au.DF().dJs.Lr().Df());
        intent.putExtra("intent_update_type", 3);
        intent.putExtra("intent_extra_desc", this.uqT.uqS.bIr);
        intent.putExtra("intent_extra_md5", this.uqT.uqS.bxD);
        intent.putExtra("intent_extra_size", this.uqT.uqS.gsu);
        intent.putExtra("intent_extra_download_url", new String[]{this.uqT.uqS.knh});
        intent.putExtra("intent_extra_patchInfo", iVar.uv());
        intent.putExtra("intent_extra_updateMode", e.bxm);
        intent.putExtra("intent_extra_marketUrl", e.sFB);
        intent.putExtra("intent_extra_extinfo", "<extinfo></extinfo>");
        intent.putExtra("intent_extra_tinker_patch", true);
        intent.putExtra("intent_extra_download_mode", 1);
        com.tencent.mm.plugin.y.d.bfB().u(i.a(this.uqT.uqR), intent);
        com.tencent.mm.pluginsdk.f.i.cck();
    }
}
