package com.tencent.mm.ui.bizchat;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.ac.a.c;
import com.tencent.mm.ac.a.j;
import com.tencent.mm.ac.z;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.o;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BizChatAtSomeoneUI extends MMActivity {
    private static boolean tDW = false;
    private String cZH;
    private o eMS;
    private ListView eVT;
    private String hOG;
    private String hOH;
    private long hpD;
    private a tDU;
    private c tDV;
    private String talker;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hOG = getIntent().getStringExtra("Block_list");
        this.hOH = getIntent().getStringExtra("Chatroom_member_list");
        this.talker = getIntent().getStringExtra("Chat_User");
        this.cZH = getIntent().getStringExtra("Add_address_titile");
        this.hpD = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.tDV = z.Na().ak(this.hpD);
        if (this.tDV == null) {
            x.w("MicroMsg.AtSomeoneUI", "bizChatInfo is null");
            finish();
            return;
        }
        if (this.tDV != null && this.tDV.field_ownerUserId.equals(q.GF())) {
            tDW = true;
        }
        initView();
    }

    protected final void initView() {
        setMMTitle(this.cZH);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BizChatAtSomeoneUI.this.setResult(0);
                BizChatAtSomeoneUI.this.finish();
                return true;
            }
        });
        this.eMS = new o((byte) 0);
        this.eMS.uBw = new 2(this);
        a(this.eMS);
        this.eVT = (ListView) findViewById(R.h.chatroom_member_lv);
        j jVar = new j();
        c cVar = this.tDV;
        String[] strArr = null;
        if (!ai.oW(this.hOH)) {
            strArr = this.hOH.split(";");
            x.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", new Object[]{Arrays.toString(strArr)});
        }
        List linkedList = new LinkedList();
        if (!ai.oW(this.hOG)) {
            linkedList = ai.h(this.hOG.split(";"));
        }
        this.tDU = new a(this, jVar, cVar, strArr, linkedList);
        this.eVT.setOnItemClickListener(new 3(this));
        this.eVT.setAdapter(this.tDU);
        this.eVT.setOnScrollListener(new 4(this));
    }

    protected void onPause() {
        super.onPause();
        if (this.eMS != null) {
            this.eMS.czQ();
        }
    }

    protected void onDestroy() {
        this.tDU.aYc();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.at_someone_ui;
    }

    protected static String a(c cVar, String str) {
        if (cVar == null) {
            return null;
        }
        return cVar.gT(str);
    }
}
