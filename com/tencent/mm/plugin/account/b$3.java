package com.tencent.mm.plugin.account;

import android.content.Intent;
import com.tencent.mm.g.a.pc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class b$3 extends c<pc> {
    final /* synthetic */ b eEO;

    b$3(b bVar) {
        this.eEO = bVar;
        this.sFo = pc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        pc pcVar = (pc) bVar;
        Intent intent = pcVar.bZW.intent;
        String str = pcVar.bZW.username;
        if (intent == null || str == null || str.length() == 0) {
            x.e("MicroMsg.AccountSyncUtil", "setLocalQQMobile fail, intent = " + intent + ", username = " + str);
        } else {
            ao pA = ((ap) ((a) g.n(a.class)).getQQListStg()).pA(str);
            if (pA != null) {
                intent.putExtra("Contact_Uin", pA.eLw);
                intent.putExtra("Contact_QQNick", pA.getDisplayName());
            }
            com.tencent.mm.plugin.account.friend.a.a pp = ((com.tencent.mm.plugin.account.friend.a.b) ((a) g.n(a.class)).getAddrUploadStg()).pp(str);
            if (pp != null) {
                intent.putExtra("Contact_Mobile_MD5", pp.Xh());
            }
        }
        return false;
    }
}
