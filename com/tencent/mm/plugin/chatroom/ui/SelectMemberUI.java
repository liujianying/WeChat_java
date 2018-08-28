package com.tencent.mm.plugin.chatroom.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.chatroom.d.n;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.MMEditText;

public class SelectMemberUI extends MMActivity implements e {
    private ListView CU;
    private String cZH;
    private p fUo;
    private View gPU;
    private u hLB;
    private String hMQ;
    private String hOG;
    private MMEditText hOJ;
    private View hPj;
    SelectMemberScrollBar hPr;
    private b hPs;
    private boolean hPt;
    private boolean hPu;
    private int hop;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.SelectMemberUI", "[onCreate]");
        this.hMQ = getIntent().getStringExtra("RoomInfo_Id");
        x.i("MicroMsg.SelectMemberUI", "[getIntentParams] roomId:%s", new Object[]{this.hMQ});
        au.HU();
        this.hLB = c.Ga().ii(this.hMQ);
        this.hOG = getIntent().getStringExtra("Block_list");
        this.hop = getIntent().getIntExtra("frome_scene", 0);
        this.cZH = getIntent().getStringExtra("title");
        this.hPt = getIntent().getBooleanExtra("quit_room", false);
        this.hPu = getIntent().getBooleanExtra("is_show_owner", true);
        initView();
        if (this.hop == 2) {
            au.DF().a(990, this);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.hop == 2) {
            au.DF().b(990, this);
        }
        if (this.fUo != null && this.fUo.isShowing()) {
            this.fUo.dismiss();
        }
    }

    protected final void initView() {
        setMMTitle(bi.oV(this.cZH));
        this.CU = (ListView) findViewById(R.h.member_list);
        this.hPj = findViewById(R.h.select_member_ui_hint_ll);
        this.gPU = findViewById(R.h.select_member_ui_loading);
        this.hPs = new b(this, this, this.hLB, this.hMQ, this.hLB.field_roomowner);
        this.CU.setAdapter(this.hPs);
        this.hPr = (SelectMemberScrollBar) findViewById(R.h.member_scrollbar);
        this.hPr.setVisibility(0);
        this.hPr.setOnScrollBarTouchListener(new 1(this));
        this.hOJ = (MMEditText) findViewById(R.h.select_member_et);
        this.hOJ.addTextChangedListener(new TextWatcher() {
            private al hPw = new al(au.Em().lnJ.getLooper(), new 1(this), false);

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.hPw.SO();
                this.hPw.J(500, 500);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.CU.setOnItemClickListener(new 3(this));
        b bVar = this.hPs;
        bVar.hPv.gPU.setVisibility(0);
        au.Em().H(new 1(bVar));
        setBackBtn(new 4(this));
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (this.fUo != null && this.fUo.isShowing()) {
            this.fUo.dismiss();
        }
        if (lVar.getType() != 990) {
            return;
        }
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.SelectMemberUI", "dz[onSceneEnd transfer successfully],owner_username:%s", new Object[]{((n) lVar).username});
            s.makeText(this, R.l.room_transfer_owner_successfully, 1).show();
            Intent intent = new Intent();
            intent.putExtra("RoomInfo_Id", this.hMQ);
            intent.putExtra("Chat_User", this.hMQ);
            intent.putExtra("Is_Chatroom", true);
            intent.setFlags(67108864);
            d.b(this.mController.tml, "chatroom", ".ui.ChatroomInfoUI", intent);
            finish();
            return;
        }
        s.makeText(this, R.l.room_transfer_owner_failed, 1).show();
        x.w("MicroMsg.SelectMemberUI", "dz[onSceneEnd transfer failed: %d %d %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
    }

    protected static String a(u uVar, String str) {
        if (uVar == null) {
            return null;
        }
        return uVar.gT(str);
    }

    protected final int getLayoutId() {
        return R.i.select_member_ui;
    }
}
