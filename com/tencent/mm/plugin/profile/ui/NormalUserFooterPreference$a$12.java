package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a;
import com.tencent.mm.sdk.platformtools.x;

class NormalUserFooterPreference$a$12 implements OnClickListener {
    final /* synthetic */ a lXy;

    NormalUserFooterPreference$a$12(a aVar) {
        this.lXy = aVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.NormalUserFooterPreference", "sendButton onClick %s", new Object[]{NormalUserFooterPreference.a(this.lXy.lXw).field_username});
        a aVar;
        if (NormalUserFooterPreference.e(this.lXy.lXw)) {
            aVar = this.lXy;
            String str = NormalUserFooterPreference.a(aVar.lXw).field_username;
            Intent intent = new Intent();
            intent.addFlags(67108864);
            if (NormalUserFooterPreference.n(aVar.lXw)) {
                intent.putExtra("Chat_User", str);
                intent.putExtra("Chat_Mode", 1);
                ((Activity) aVar.lXw.mContext).setResult(-1, intent);
                return;
            }
            intent.putExtra("Chat_User", str);
            intent.putExtra("Chat_Mode", 1);
            com.tencent.mm.plugin.profile.a.ezn.e(intent, aVar.lXw.mContext);
            return;
        }
        aVar = this.lXy;
        Intent intent2 = new Intent();
        intent2.addFlags(67108864);
        if (NormalUserFooterPreference.n(aVar.lXw)) {
            intent2.putExtra("Chat_User", NormalUserFooterPreference.a(aVar.lXw).field_username);
            intent2.putExtra("Chat_Mode", 1);
            ((Activity) aVar.lXw.mContext).setResult(-1, intent2);
            return;
        }
        intent2.putExtra("Chat_User", NormalUserFooterPreference.a(aVar.lXw).field_username);
        intent2.putExtra("Chat_Mode", 1);
        com.tencent.mm.plugin.profile.a.ezn.e(intent2, aVar.lXw.mContext);
    }
}
