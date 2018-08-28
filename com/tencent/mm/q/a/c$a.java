package com.tencent.mm.q.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.a.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;

public class c$a extends b {
    final /* synthetic */ c diu;

    public c$a(c cVar) {
        this.diu = cVar;
        super(cVar);
    }

    public final boolean a(Context context, a aVar) {
        c cVar = (c) aVar;
        if (cVar.dir != null) {
            Intent intent;
            if (cVar.dir.status == 1 || cVar.dir.status == 2) {
                x.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin On Or Weixin Friend");
                intent = new Intent();
                intent.putExtra("Contact_User", this.diu.dir.getUsername());
                intent.putExtra("Contact_Nick", this.diu.dir.Xm());
                intent.putExtra("Contact_Mobile_MD5", this.diu.dir.Xh());
                intent.putExtra("Contact_Alias", this.diu.dir.eJM);
                intent.putExtra("Contact_Sex", this.diu.dir.eJH);
                intent.putExtra("Contact_Signature", this.diu.dir.eJK);
                intent.putExtra("Contact_RegionCode", RegionCodeDecoder.aq(this.diu.dir.eJQ, this.diu.dir.eJI, this.diu.dir.eJJ));
                intent.putExtra("Contact_Scene", 13);
                intent.putExtra("Contact_ShowUserName", false);
                if (this.diu.dis) {
                    intent.putExtra("add_more_friend_search_scene", 1);
                }
                com.tencent.mm.plugin.account.a.a.ezn.d(intent, context);
            } else if (this.diu.dir.status == 0) {
                x.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin Off");
                intent = new Intent(context, InviteFriendUI.class);
                intent.putExtra("friend_type", 1);
                intent.putExtra("friend_user_name", this.diu.dir.getUsername());
                intent.putExtra("friend_num", this.diu.dir.Xp());
                intent.putExtra("friend_nick", this.diu.dir.Xj());
                intent.putExtra("friend_weixin_nick", this.diu.dir.Xm());
                intent.putExtra("friend_scene", 13);
                context.startActivity(intent);
            } else {
                x.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin status unknown");
            }
        }
        return true;
    }
}
