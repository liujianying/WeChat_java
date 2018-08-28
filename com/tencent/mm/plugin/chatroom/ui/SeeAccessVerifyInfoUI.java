package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.pc;
import com.tencent.mm.l.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;

public class SeeAccessVerifyInfoUI extends MMActivity {
    private long dTE;
    private String eHp;
    private u hLB;
    private c hOk;
    private b hOl;
    private String hOm;
    private String hOn;
    private String hOo;
    private String hOp;
    private String hOq;
    private String hOr;
    private String hOs;
    private TextView hOt;
    private TextView hOu;
    private ImageView hOv;
    private TextView hOw;
    private TextView hOx;
    private GridView hOy;
    private p tipDialog;

    static /* synthetic */ void a(SeeAccessVerifyInfoUI seeAccessVerifyInfoUI, String str, String str2, String str3, boolean z) {
        if (bi.oW(str2)) {
            au.HU();
            bq Hh = c.FS().Hh(str);
            if (!(Hh == null || bi.oW(Hh.field_encryptUsername))) {
                str2 = Hh.field_conRemark;
            }
        }
        if (!bi.oW(str)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra("Contact_RemarkName", str2);
            x.i("MicroMsg.SeeAccessVerifyInfoUI", "mTicket:%s", new Object[]{seeAccessVerifyInfoUI.eHp});
            intent.putExtra("key_add_contact_verify_ticket", seeAccessVerifyInfoUI.eHp);
            if (seeAccessVerifyInfoUI.hLB != null) {
                intent.putExtra("Contact_RoomNickname", seeAccessVerifyInfoUI.hLB.gT(str));
            }
            intent.putExtra("Contact_Nick", str3);
            intent.putExtra("Contact_RoomMember", true);
            intent.putExtra("room_name", seeAccessVerifyInfoUI.hOr);
            au.HU();
            ab Yg = c.FR().Yg(str);
            if (Yg != null && ((int) Yg.dhP) > 0 && a.gd(Yg.field_type)) {
                pc pcVar = new pc();
                pcVar.bZW.intent = intent;
                pcVar.bZW.username = str;
                com.tencent.mm.sdk.b.a.sFg.m(pcVar);
            }
            if (Yg != null && Yg.ckW()) {
                h.mEJ.k(10298, Yg.field_username + ",14");
            }
            if (z) {
                intent.putExtra("Contact_Scene", 96);
            } else {
                intent.putExtra("Contact_Scene", 14);
            }
            intent.putExtra("Is_RoomOwner", true);
            intent.putExtra("Contact_ChatRoomId", seeAccessVerifyInfoUI.hOr);
            com.tencent.mm.plugin.chatroom.a.ezn.d(intent, (Context) seeAccessVerifyInfoUI);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.SeeAccessVerifyInfoUI", "[onCreate]");
        setMMTitle(getString(R.l.access_invite_ui_title));
        this.dTE = getIntent().getLongExtra("msgLocalId", 0);
        this.hOp = getIntent().getStringExtra("invitertitle");
        this.hOq = getIntent().getStringExtra("inviterusername");
        this.hOr = getIntent().getStringExtra("chatroom");
        this.hOs = getIntent().getStringExtra("invitationreason");
        this.eHp = getIntent().getStringExtra("ticket");
        this.hOn = getIntent().getStringExtra("username");
        this.hOm = getIntent().getStringExtra("nickname");
        this.hOo = getIntent().getStringExtra("headimgurl");
        this.hOk = au.HU();
        this.hLB = c.Ga().ih(bi.oV(this.hOr));
        this.hOl = new b(this, this);
        initView();
        setBackBtn(new 1(this));
    }

    protected void onResume() {
        x.i("MicroMsg.SeeAccessVerifyInfoUI", "[onResume]");
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.see_accessverify_info_ui;
    }

    protected final void initView() {
        CharSequence charSequence = null;
        this.hOt = (TextView) findViewById(R.h.invite_title);
        this.hOu = (TextView) findViewById(R.h.invite_reason);
        this.hOw = (TextView) findViewById(R.h.roominfo_contact_name_for_span);
        this.hOv = (ImageView) findViewById(R.h.roominfo_img);
        this.hOx = (TextView) findViewById(R.h.access_btn);
        this.hOy = (GridView) findViewById(R.h.be_invitor_gridview);
        this.hOy.setAdapter(this.hOl);
        if (this.hOv != null) {
            this.hOv.setOnClickListener(new 2(this));
        }
        this.hOy.setOnTouchListener(new 3(this));
        this.hOy.postDelayed(new 4(this), 100);
        if (this.hOv != null) {
            b.a(this.hOv, bi.oV(this.hOq));
        }
        if (this.hOw != null) {
            TextView textView = this.hOw;
            String oV = bi.oV(this.hOq);
            TextView textView2 = this.hOw;
            if (textView2 != null) {
                ab Yg = c.FR().Yg(bi.oV(oV));
                if (Yg == null) {
                    x.w("MicroMsg.SeeAccessVerifyInfoUI", "ct == null");
                } else {
                    oV = !bi.oW(Yg.field_conRemark) ? Yg.field_conRemark : this.hLB != null ? this.hLB.gT(oV) : null;
                    if (bi.oW(oV)) {
                        oV = Yg.field_conRemark;
                    }
                    if (bi.oW(oV)) {
                        oV = Yg.BK();
                    }
                    charSequence = j.a(this, bi.oV(oV), textView2.getTextSize());
                }
            }
            textView.setText(charSequence);
        }
        if (this.hOt != null) {
            this.hOt.setText(j.a(this, bi.oV(this.hOp)));
        }
        if (!(this.hOu == null || bi.oW(this.hOs))) {
            this.hOu.setText(j.a(this, "\"" + bi.oV(this.hOs) + "\""));
        }
        if (this.hOx != null) {
            this.hOx.setOnClickListener(new 5(this));
        }
        if (this.hOx != null) {
            au.HU();
            if (c.FT().dW(this.dTE).cmC()) {
                this.hOx.setBackgroundResource(R.g.btn_solid_grey);
                this.hOx.setTextColor(getResources().getColor(R.e.grey_btn_stroke_color_normal));
                this.hOx.setText(getString(R.l.has_approve_info));
                this.hOx.setEnabled(false);
            }
        }
    }

    protected final c cp(View view) {
        c cVar = new c(this);
        cVar.eCl = (ImageView) view.findViewById(R.h.roominfo_img);
        cVar.hOE = (TextView) view.findViewById(R.h.roominfo_contact_name_for_span);
        return cVar;
    }
}
