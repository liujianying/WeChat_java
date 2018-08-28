package com.tencent.mm.plugin.game.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.v;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2$Args;
import com.tencent.mm.opensdk.modelbiz.CreateChatroom.Resp;
import com.tencent.mm.opensdk.modelbiz.JoinChatroom;
import com.tencent.mm.plugin.game.d.an;
import com.tencent.mm.plugin.game.d.ao;
import com.tencent.mm.plugin.game.d.y;
import com.tencent.mm.plugin.game.d.z;
import com.tencent.mm.plugin.game.f.i;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.p$a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(7)
public class CreateOrJoinChatroomUI extends MMBaseActivity {
    private ProgressDialog dId = null;
    private String eWQ;
    private String jTW;
    private String jTX;
    private String jTY;
    private String jTZ;
    private int jUa = 1;
    private String mAppId;
    private String mPackageName;
    private String sS;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        x.i("MicroMsg.CreateOrJoinChatroomUI", "onCreate");
        Intent intent = getIntent();
        this.sS = intent.getStringExtra("action");
        this.mPackageName = intent.getStringExtra("package_name");
        this.mAppId = intent.getStringExtra("key_app_id");
        this.jTW = intent.getStringExtra("key_transaction");
        this.jTX = intent.getStringExtra("group_id");
        this.jTY = intent.getStringExtra("chatroom_name");
        this.eWQ = intent.getStringExtra("chatroom_nickname");
        this.jTZ = intent.getStringExtra("ext_msg");
        if (bi.oW(this.sS) || bi.oW(this.mAppId) || bi.oW(this.jTX)) {
            x.e("MicroMsg.CreateOrJoinChatroomUI", "Invalid args");
            finish();
            return;
        }
        this.dId = h.a(this, getBaseContext().getString(i.game_verify_authority_tips_jumping), true, null);
        b.a aVar;
        b KT;
        if (this.sS.equals("action_create")) {
            x.i("MicroMsg.CreateOrJoinChatroomUI", "createChatroom, appid = %s, groupId = %s, ChatRoomName = %s", new Object[]{this.mAppId, this.jTX, this.jTY});
            aVar = new b.a();
            aVar.dIG = new y();
            aVar.dIH = new z();
            aVar.uri = "/cgi-bin/mmgame-bin/gamecreatechatroom";
            aVar.dIF = 1205;
            KT = aVar.KT();
            y yVar = (y) KT.dID.dIL;
            yVar.jPc = this.mAppId;
            yVar.jQk = this.jTX;
            yVar.jQl = new com.tencent.mm.bk.b(this.jTY == null ? new byte[0] : this.jTY.getBytes());
            yVar.jQm = new com.tencent.mm.bk.b(this.eWQ == null ? new byte[0] : this.eWQ.getBytes());
            v.a(KT, new 1(this));
        } else if (this.sS.equals("action_join")) {
            aVar = new b.a();
            aVar.dIG = new an();
            aVar.dIH = new ao();
            aVar.uri = "/cgi-bin/mmgame-bin/gamejoinchatroom";
            aVar.dIF = 1206;
            KT = aVar.KT();
            an anVar = (an) KT.dID.dIL;
            anVar.jPc = this.mAppId;
            anVar.jQk = this.jTX;
            anVar.jQm = new com.tencent.mm.bk.b(this.eWQ == null ? new byte[0] : this.eWQ.getBytes());
            v.a(KT, new 2(this));
        }
    }

    protected void onDestroy() {
        aUK();
        super.onDestroy();
    }

    private void aUK() {
        if (this.dId != null && this.dId.isShowing()) {
            this.dId.cancel();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 5) {
            if (i2 == 4) {
                qR(0);
            } else if (i2 == 5) {
                if (intent != null) {
                    p$a.qyl.b(this, intent.getStringExtra("rawUrl"), true, null);
                }
            } else if (i2 == 0) {
                qR(-2);
            }
        }
        finish();
    }

    private void qR(int i) {
        f bl = g.bl(this.mAppId, true);
        Bundle bundle = new Bundle();
        if (this.sS.equals("action_create")) {
            Resp resp = new Resp();
            if (bl != null) {
                resp.openId = bl.field_openId;
            }
            resp.transaction = this.jTW;
            resp.extMsg = this.jTZ;
            resp.errCode = i;
            resp.toBundle(bundle);
        } else if (this.sS.equals("action_join")) {
            JoinChatroom.Resp resp2 = new JoinChatroom.Resp();
            if (bl != null) {
                resp2.openId = bl.field_openId;
            }
            resp2.transaction = this.jTW;
            resp2.extMsg = this.jTZ;
            resp2.errCode = i;
            resp2.toBundle(bundle);
        }
        MMessageActV2$Args mMessageActV2$Args = new MMessageActV2$Args();
        mMessageActV2$Args.targetPkgName = this.mPackageName;
        mMessageActV2$Args.bundle = bundle;
        p.ae(bundle);
        p.af(bundle);
        MMessageActV2.send(ad.getContext(), mMessageActV2$Args);
    }
}
