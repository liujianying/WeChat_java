package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.tools.o;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AtSomeoneUI extends MMActivity {
    private static boolean tDW = false;
    private String cZH;
    private o eMS;
    private ListView eVT;
    private u hLB;
    private String hOG;
    private String hOH;
    private a tHc;
    private String talker;

    private static class b {
        public TextView eMf;
        public MaskLayout hPe;
        public ImageView tEa;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hOG = getIntent().getStringExtra("Block_list");
        this.hOH = getIntent().getStringExtra("Chatroom_member_list");
        this.talker = getIntent().getStringExtra("Chat_User");
        this.cZH = getIntent().getStringExtra("Add_address_titile");
        au.HU();
        this.hLB = c.Ga().ih(this.talker);
        if (this.hLB != null && this.hLB.field_roomowner.equals(q.GF())) {
            tDW = false;
        }
        initView();
    }

    protected final void initView() {
        boolean z = true;
        setMMTitle(this.cZH);
        setBackBtn(new 1(this));
        this.eMS = new o((byte) 0);
        this.eMS.uBw = new 2(this);
        a(this.eMS);
        this.eVT = (ListView) findViewById(R.h.chatroom_member_lv);
        ab abVar = new ab();
        u uVar = this.hLB;
        String[] strArr = null;
        if (!ai.oW(this.hOH)) {
            strArr = this.hOH.split(",");
            x.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", new Object[]{Arrays.toString(strArr)});
        }
        if (strArr == null && this.hLB != null) {
            x.w("MicroMsg.AtSomeoneUI", "[getChatroomMember] chatroomMemberList is null!");
            strArr = ai.c(this.hLB.Nn(), ",").split(",");
        }
        if (strArr == null) {
            String str = "MicroMsg.AtSomeoneUI";
            String str2 = "WTF! member is null? %s";
            Object[] objArr = new Object[1];
            if (this.hLB != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.e(str, str2, objArr);
        }
        List linkedList = new LinkedList();
        if (!ai.oW(this.hOG)) {
            linkedList = ai.h(this.hOG.split(","));
        }
        au.HU();
        bl Hg = c.FZ().Hg("@t.qq.com");
        if (Hg != null) {
            linkedList.add(Hg.name);
        }
        this.tHc = new a(this, abVar, uVar, strArr, linkedList);
        this.eVT.setOnItemClickListener(new 3(this));
        this.eVT.setAdapter(this.tHc);
    }

    protected void onPause() {
        super.onPause();
        if (this.eMS != null) {
            this.eMS.czQ();
        }
    }

    protected void onDestroy() {
        this.tHc.aYc();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.at_someone_ui;
    }

    protected static String a(u uVar, String str) {
        if (uVar == null) {
            return null;
        }
        return uVar.gT(str);
    }
}
