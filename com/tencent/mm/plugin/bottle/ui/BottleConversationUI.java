package com.tencent.mm.plugin.bottle.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.r.a;

public class BottleConversationUI extends MMActivity {
    private TextView emptyTipTv;
    private ListView hkY;
    private a hkZ;
    private String hla;
    private d hlb = new 2(this);
    private boolean isDeleteCancel = false;
    private String talker;
    private p tipDialog = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final int getLayoutId() {
        return R.i.tmessage;
    }

    public void onDestroy() {
        this.hkZ.aYc();
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        au.HU();
        c.FR().a(this.hkZ);
        au.HU();
        c.FW().a(this.hkZ);
        this.hkZ.a(null, null);
    }

    public void onPause() {
        au.HU();
        c.FR().b(this.hkZ);
        au.HU();
        c.FW().b(this.hkZ);
        au.HU();
        bd sx = c.FT().sx(8);
        if (sx != null && sx.field_msgId > 0) {
            x.d("MicroMsg.Bottle.BottleConversationUI", "resetUnread: lastReadTime = " + sx.field_createTime);
            au.HU();
            c.DT().set(12306, Long.valueOf(sx.field_createTime));
        }
        au.HU();
        ai Yq = c.FW().Yq("floatbottle");
        if (Yq == null || bi.oV(Yq.field_username).length() <= 0) {
            x.e("MicroMsg.Bottle.BottleConversationUI", "resetUnread: can not find bottle");
        } else {
            Yq.eV(0);
            au.HU();
            if (c.FW().a(Yq, Yq.field_username) == -1) {
                x.e("MicroMsg.Bottle.BottleConversationUI", "reset bottle unread failed");
            }
        }
        this.hkZ.onPause();
        super.onPause();
    }

    protected final void initView() {
        int GJ = q.GJ() | 4096;
        int GQ = q.GQ() & -65;
        au.HU();
        c.DT().set(7, Integer.valueOf(GJ));
        au.HU();
        c.DT().set(34, Integer.valueOf(GQ));
        this.hkY = (ListView) findViewById(R.h.tmessage_lv);
        this.emptyTipTv = (TextView) findViewById(R.h.empty_msg_tip_tv);
        this.emptyTipTv.setText(R.l.bottle_empty_msg_tip);
        this.hkZ = new a(this, new a() {
            public final void Xb() {
                BottleConversationUI bottleConversationUI = BottleConversationUI.this;
                String string = BottleConversationUI.this.getString(R.l.bottle_opt_list);
                int GB = k.GB();
                if (GB <= 0) {
                    bottleConversationUI.setMMTitle(string);
                } else {
                    bottleConversationUI.setMMTitle(string + "(" + GB + ")");
                }
                if (BottleConversationUI.this.hkZ.getCount() <= 0) {
                    BottleConversationUI.this.emptyTipTv.setVisibility(0);
                    BottleConversationUI.this.hkY.setVisibility(8);
                    return;
                }
                BottleConversationUI.this.emptyTipTv.setVisibility(8);
                BottleConversationUI.this.hkY.setVisibility(0);
            }

            public final void Xa() {
            }
        });
        this.hkZ.setGetViewPositionCallback(new 4(this));
        this.hkZ.setPerformItemClickListener(new g() {
            public final void t(View view, int i) {
                BottleConversationUI.this.hkY.performItemClick(view, i, 0);
            }
        });
        this.hkZ.a(new 6(this));
        this.hkY.setAdapter(this.hkZ);
        this.hkY.setOnItemLongClickListener(new 7(this, new com.tencent.mm.ui.tools.k(this)));
        this.hkY.setOnItemClickListener(new 8(this));
        com.tencent.mm.plugin.bottle.a.ezo.vl();
        setBackBtn(new 9(this));
        String stringExtra = getIntent().getStringExtra("conversation_from");
        if (bi.oW(stringExtra) && bi.oW(this.hla)) {
            addTextOptionMenu(0, getString(R.l.contact_into_goto_floatbottle_str_btn), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent();
                    intent.setClass(BottleConversationUI.this, BottleBeachUI.class);
                    BottleConversationUI.this.startActivity(intent);
                    BottleConversationUI.this.finish();
                    return true;
                }
            });
        } else if (!bi.oW(stringExtra)) {
            this.hla = stringExtra;
        }
        11 11 = new 11(this);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.talker = ((ai) this.hkZ.getItem(adapterContextMenuInfo.position)).field_username;
        int i = R.l.bottle_chatting_from_city;
        Object[] objArr = new Object[1];
        a aVar = this.hkZ;
        au.HU();
        objArr[0] = aVar.B(c.FR().Yg(this.talker));
        contextMenu.setHeaderTitle(getString(i, objArr));
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.l.bottle_conversation_delete);
    }
}
