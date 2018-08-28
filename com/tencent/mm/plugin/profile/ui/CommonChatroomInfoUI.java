package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.profile.ui.a.a;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.o;

public class CommonChatroomInfoUI extends MMBaseSelectContactUI {
    private ab guS;
    private a lUx;
    private b lUy;

    protected final void Wj() {
        super.Wj();
        String stringExtra = getIntent().getStringExtra("Select_Talker_Name");
        au.HU();
        this.guS = c.FR().Yg(stringExtra);
    }

    protected final void initView() {
        super.initView();
        a aVar = this.lUx;
        i iVar = new i();
        iVar.bWm = aVar.guS.field_username;
        iVar.jsv = aVar;
        iVar.handler = aVar.handler;
        iVar.jsn = 6;
        iVar.jsu = new a(aVar, (byte) 0);
        ((n) g.n(n.class)).search(2, iVar);
    }

    protected final boolean Wk() {
        return true;
    }

    protected final boolean Wl() {
        return false;
    }

    protected final String Wm() {
        if (this.guS.sex == 1) {
            return getString(R.l.contact_info_common_chatroom_male);
        }
        if (this.guS.sex == 2) {
            return getString(R.l.contact_info_common_chatroom_female);
        }
        return getString(R.l.contact_info_common_chatroom_unknow);
    }

    protected final o Wn() {
        if (this.lUx == null) {
            this.lUx = new a(this, this.scene, this.guS);
        }
        return this.lUx;
    }

    protected final m Wo() {
        if (this.lUy == null) {
            this.lUy = new b(this, this.scene, this.guS);
        }
        return this.lUy;
    }

    public final void iV(int i) {
        e eVar = (e) getContentLV().getAdapter().getItem(i);
        if (eVar != null) {
            d.e(this, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", eVar.guS.field_username).putExtra("finish_direct", true));
        }
    }
}
