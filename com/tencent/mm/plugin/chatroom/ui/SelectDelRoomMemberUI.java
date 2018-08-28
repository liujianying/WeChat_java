package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.pc;
import com.tencent.mm.l.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SelectDelRoomMemberUI extends MMActivity {
    private ListView CU;
    private boolean bSD;
    public HashSet<String> eCr;
    private u hLB;
    private boolean hLj;
    private String hMQ;
    private String hNf;
    private int hNg;
    private String hNh;
    private boolean hNi;
    private String hOG;
    private String hOH;
    private String hOI;
    private int hOX;
    private a hOY;
    private EditText hOZ;
    private String username;

    static /* synthetic */ ArrayList a(SelectDelRoomMemberUI selectDelRoomMemberUI) {
        ArrayList arrayList = new ArrayList();
        Collection hashSet = new HashSet();
        Iterator it = selectDelRoomMemberUI.eCr.iterator();
        while (it.hasNext()) {
            hashSet.add((String) it.next());
        }
        arrayList.addAll(hashSet);
        return arrayList;
    }

    static /* synthetic */ void a(SelectDelRoomMemberUI selectDelRoomMemberUI, String str, String str2, String str3) {
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
            if (selectDelRoomMemberUI.bSD && selectDelRoomMemberUI.hLB != null) {
                intent.putExtra("Contact_RoomNickname", selectDelRoomMemberUI.hLB.gT(str));
            }
            intent.putExtra("Contact_Nick", str3);
            intent.putExtra("Contact_RoomMember", true);
            intent.putExtra("room_name", selectDelRoomMemberUI.hNf);
            au.HU();
            ab Yg = c.FR().Yg(str);
            if (Yg != null && ((int) Yg.dhP) > 0 && a.gd(Yg.field_type)) {
                pc pcVar = new pc();
                pcVar.bZW.intent = intent;
                pcVar.bZW.username = str;
                com.tencent.mm.sdk.b.a.sFg.m(pcVar);
            }
            if (selectDelRoomMemberUI.bSD) {
                if (Yg != null && Yg.ckW()) {
                    h.mEJ.k(10298, Yg.field_username + ",14");
                }
                intent.putExtra("Contact_Scene", 14);
            } else if (selectDelRoomMemberUI.hLj) {
                intent.putExtra("Contact_Scene", 44);
                if (!q.gQ(Yg.field_username)) {
                    intent.putExtra("Contact_IsLBSFriend", true);
                }
            }
            intent.putExtra("Contact_ChatRoomId", selectDelRoomMemberUI.hMQ);
            com.tencent.mm.plugin.chatroom.a.ezn.d(intent, (Context) selectDelRoomMemberUI);
        }
    }

    protected final int getLayoutId() {
        return R.i.delete_roommember_ui;
    }

    protected final void initView() {
        super.initView();
        this.hMQ = getIntent().getStringExtra("RoomInfo_Id");
        this.hOH = getIntent().getStringExtra("Chatroom_member_list");
        this.bSD = getIntent().getBooleanExtra("Is_Chatroom", true);
        this.hLj = getIntent().getBooleanExtra("Is_Lbsroom", false);
        this.hNi = getIntent().getBooleanExtra("Is_RoomOwner", false);
        this.hNh = getIntent().getStringExtra("room_owner_name");
        au.HU();
        this.hLB = c.Ga().ih(this.hMQ);
        this.hNg = getIntent().getIntExtra("room_member_count", 0);
        this.hOX = getIntent().getIntExtra("list_attr", s.ukE);
        this.hNf = getIntent().getStringExtra("room_name");
        setMMTitle(getString(R.l.room_see_room_member) + "(" + this.hNg + ")");
        a(1, getString(R.l.delete_room_member), new 1(this), b.tmY);
        setBackBtn(new 2(this));
        this.hOZ = (EditText) findViewById(R.h.mutiselectcontact_edittext);
        this.hOZ.addTextChangedListener(new 3(this));
        this.CU = (ListView) findViewById(R.h.chatroom_member_lv);
        ab abVar = new ab();
        u uVar = this.hLB;
        String str = this.hMQ;
        List linkedList = new LinkedList();
        if (!bi.oW(this.hOG)) {
            linkedList = bi.F(this.hOG.split(","));
        }
        au.HU();
        bl Hg = c.FZ().Hg("@t.qq.com");
        if (Hg != null) {
            linkedList.add(Hg.name);
        }
        this.hOY = new a(this, uVar, str, linkedList, this.hNh);
        this.CU.setAdapter(this.hOY);
        this.CU.setOnItemClickListener(new 4(this));
        Wp();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eCr = new HashSet();
        initView();
    }

    public void onResume() {
        super.onResume();
        if (this.hOY != null) {
            au.HU();
            this.hLB = c.Ga().ih(this.hMQ);
            List gI = m.gI(this.hMQ);
            if (this.hOY != null) {
                this.hOY.aG(gI);
            }
        }
    }

    private void Wp() {
        if (!s.fb(this.hOX, 64) || this.eCr.size() <= 0) {
            updateOptionMenuText(1, getString(R.l.delete_room_member));
            enableOptionMenu(1, false);
            return;
        }
        updateOptionMenuText(1, getString(R.l.delete_room_member) + "(" + this.eCr.size() + ")");
        enableOptionMenu(1, true);
    }
}
