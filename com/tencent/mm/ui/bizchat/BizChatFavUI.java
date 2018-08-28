package com.tencent.mm.ui.bizchat;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.a.b;
import com.tencent.mm.ac.a.d.a;
import com.tencent.mm.ac.a.s;
import com.tencent.mm.ac.n;
import com.tencent.mm.ac.z;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.tools.k;

public class BizChatFavUI extends MMActivity implements n {
    private TextView emptyTipTv;
    private p guT;
    private ListView hkY;
    private d hlb;
    private long hpD;
    private String hpJ;
    private boolean isCurrentActivity;
    private a tEA;
    private c tEF;
    private b.a tEz;

    static /* synthetic */ void b(BizChatFavUI bizChatFavUI, long j) {
        Intent intent = new Intent(bizChatFavUI, ChattingUI.class);
        intent.addFlags(67108864);
        intent.putExtra("Chat_User", bizChatFavUI.hpJ);
        intent.putExtra("key_biz_chat_id", j);
        intent.putExtra("finish_direct", true);
        intent.putExtra("key_need_send_video", false);
        intent.putExtra("key_is_biz_chat", true);
        bizChatFavUI.startActivity(intent);
        ah.i(new 5(bizChatFavUI), 500);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hpJ = getIntent().getStringExtra("Contact_User");
        x.i("MicroMsg.BizChatFavUI", "[registerListener]");
        this.tEz = new 1(this);
        this.tEA = new 6(this);
        z.Nb().a(this.tEz, getMainLooper());
        z.Na().a(this.tEA, getMainLooper());
        initView();
        z.Ng();
        g.Eh().dpP.a(new s(this.hpJ), 0);
    }

    protected final int getLayoutId() {
        return R.i.enterprise_bizchat_fav;
    }

    public void onDestroy() {
        x.i("MicroMsg.BizChatFavUI", "[unRegitListener]");
        z.Nb().a(this.tEz);
        z.Na().a(this.tEA);
        this.tEF.aYc();
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        au.HU();
        ai Yg = c.FR().Yg(this.hpJ);
        if (Yg == null || !com.tencent.mm.l.a.gd(Yg.field_type)) {
            a();
            return;
        }
        setTitleMuteIconVisibility(8);
        this.isCurrentActivity = true;
        this.tEF.a(null, null);
        au.getNotification().eJ(this.hpJ);
    }

    public void onPause() {
        this.tEF.onPause();
        this.isCurrentActivity = false;
        au.getNotification().eJ("");
        super.onPause();
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.hpD = ((com.tencent.mm.ac.a.c) this.tEF.getItem(adapterContextMenuInfo.position)).field_bizChatLocalId;
        contextMenu.add(adapterContextMenuInfo.position, 0, 1, R.l.bizchat_remove_fav);
    }

    public final void a(int i, l lVar) {
        if (this.guT != null) {
            this.guT.dismiss();
        }
    }

    protected final void initView() {
        this.hkY = (ListView) findViewById(R.h.tmessage_lv);
        this.emptyTipTv = (TextView) findViewById(R.h.empty_msg_tip_tv);
        this.emptyTipTv.setText(R.l.bizchat_no_fav_conversation);
        this.hkY.setOnScrollListener(new 8(this));
        this.tEF = new c(this, new 9(this), this.hpJ);
        this.tEF.setGetViewPositionCallback(new MMSlideDelView.c() {
            public final int cl(View view) {
                return BizChatFavUI.this.hkY.getPositionForView(view);
            }
        });
        this.tEF.setPerformItemClickListener(new MMSlideDelView.g() {
            public final void t(View view, int i) {
                BizChatFavUI.this.hkY.performItemClick(view, i, 0);
            }
        });
        this.tEF.a(new f() {
            public final void bv(Object obj) {
                if (obj == null) {
                    x.e("MicroMsg.BizChatFavUI", "onItemDel object null");
                }
            }
        });
        this.hkY.setAdapter(this.tEF);
        this.hlb = new 13(this);
        this.hkY.setOnItemLongClickListener(new 2(this, new k(this)));
        this.hkY.setOnItemClickListener(new 3(this));
        setBackBtn(new 7(this));
    }
}
