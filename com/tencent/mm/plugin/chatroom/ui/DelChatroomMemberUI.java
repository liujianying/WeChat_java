package com.tencent.mm.plugin.chatroom.ui;

import android.os.Bundle;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.h.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.chatroom.d.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.LinkedList;
import java.util.List;

public class DelChatroomMemberUI extends MMActivity implements e {
    private ListView CU;
    private String chatroomName;
    private u hLB;
    private a hMy;
    private LinkedList<String> hMz = new LinkedList();
    private int scene;
    private p tipDialog;

    static /* synthetic */ void a(DelChatroomMemberUI delChatroomMemberUI, String str) {
        if (str != null && !str.equals("")) {
            List linkedList = new LinkedList();
            linkedList.add(str);
            g gVar = new g(delChatroomMemberUI.chatroomName, linkedList, delChatroomMemberUI.scene);
            delChatroomMemberUI.getString(R.l.app_tip);
            delChatroomMemberUI.tipDialog = h.a(delChatroomMemberUI, delChatroomMemberUI.getString(R.l.room_del_member), true, new 2(delChatroomMemberUI, gVar));
            au.DF().a(gVar, 0);
        }
    }

    static /* synthetic */ String b(DelChatroomMemberUI delChatroomMemberUI, String str) {
        return delChatroomMemberUI.hLB == null ? null : delChatroomMemberUI.hLB.gT(str);
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        au.DF().a(179, this);
        this.chatroomName = getIntent().getStringExtra("RoomInfo_Id");
        this.scene = getIntent().getIntExtra("scene", 0);
        String[] split = getIntent().getStringExtra("members").split(",");
        int length = split.length;
        while (i < length) {
            this.hMz.add(split[i]);
            i++;
        }
        au.HU();
        this.hLB = c.Ga().ih(this.chatroomName);
        initView();
    }

    public void onDestroy() {
        au.DF().b(179, this);
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
    }

    protected final void initView() {
        setMMTitle(R.l.room_delete_member_title);
        this.CU = (ListView) findViewById(R.h.memberlist);
        this.hMy = new a(this);
        a aVar = this.hMy;
        List<String> list = this.hMz;
        if (list != null) {
            x.i("MicroMsg.DelChatroomMemberAdapter", "initData members.size %d", new Object[]{Integer.valueOf(list.size())});
            aVar.hMB.clear();
            for (String str : list) {
                au.HU();
                ab Yg = c.FR().Yg(str);
                if (!(Yg == null || bi.oW(Yg.field_username) || !Yg.field_username.equals(str))) {
                    aVar.hMB.add(Yg);
                }
            }
        }
        this.CU.setAdapter(this.hMy);
        setBackBtn(new 1(this));
    }

    protected final int getLayoutId() {
        return R.i.chatroom_delete_member;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.DelChatroomMemberUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        if (i == 0 && i2 == 0) {
            if (i == 0 && i2 == 0) {
                h.bA(this, getString(R.l.room_delete_member_remove_it_done));
                this.hMy.aF(((g) lVar).bTR);
                this.CU.post(new 5(this));
            }
        } else if (i2 == -2024) {
            a eV = a.eV(str);
            if (eV != null) {
                eV.a(this, null, null);
            } else {
                h.a(this.mController.tml, getString(R.l.room_delete_member_deleted), null, getString(R.l.room_delete_member_got_it), false, new 3(this));
            }
        } else {
            h.a(this, getString(R.l.room_delete_tips_network_err), null, getString(R.l.app_ok), false, new 4(this));
        }
    }
}
