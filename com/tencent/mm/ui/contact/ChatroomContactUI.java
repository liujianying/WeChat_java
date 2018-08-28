package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n$d;
import com.tencent.mm.ui.voicesearch.b;

public class ChatroomContactUI extends MMActivity implements e, a {
    private d hLH = new d(new OnScrollListener() {
        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    });
    private int hpr = 0;
    private int hps = 0;
    private com.tencent.mm.ui.widget.b.a hql;
    private n$d iEm = new 1(this);
    private TextView iYb;
    private ListView kBy;
    private b uhh;
    private String uhj;
    private ContactCountView uhu;
    private VoiceSearchLayout uis;
    private com.tencent.mm.modelvoiceaddr.ui.b uit;
    private d uiu;

    static /* synthetic */ void aaK(String str) {
        au.HU();
        ab Yg = c.FR().Yg(str);
        Yg.Bc();
        s.t(Yg);
        if (s.fq(str)) {
            au.HU();
            c.FR().Ym(str);
            au.HU();
            c.Ga().in(str);
            return;
        }
        au.HU();
        c.FR().a(str, Yg);
    }

    protected final int getLayoutId() {
        return R.i.chatroom_address;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.address_chatroom_contact_nick);
        initView();
        au.DF().a(138, this);
        au.HU();
        c.FR().a(this.uiu);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        au.HU();
        if (c.FR().Yg(this.uhj) == null) {
            x.e("MicroMsg.ChatroomContactUI", "onCreateContextMenu, contact is null, username = " + this.uhj);
        } else if (s.hc(this.uhj)) {
            contextMenu.setHeaderTitle(j.a(view.getContext(), r.gT(this.uhj)));
            contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.l.address_delgroupcard);
        }
    }

    public final void initView() {
        ((TextView) findViewById(R.h.empty_voicesearch_tip_tv)).setVisibility(8);
        this.kBy = (ListView) findViewById(R.h.address_contactlist);
        this.kBy.setAdapter(null);
        this.iYb = (TextView) findViewById(R.h.empty_voicesearch_tip_tv);
        this.iYb.setText(R.l.address_empty_chatroom_tip);
        String str = "@all.chatroom.contact";
        this.uiu = new d(this, str);
        this.uiu.lB(true);
        this.uhh = new b(this.mController.tml, 1);
        this.uhh.ugF = str;
        this.uit = new com.tencent.mm.modelvoiceaddr.ui.b((byte) 0);
        this.uit.a(new 7(this));
        a(this.uit);
        this.uiu.setGetViewPositionCallback(new 8(this));
        this.uiu.setPerformItemClickListener(new 9(this));
        this.uiu.a(new 10(this));
        this.kBy.setOnScrollListener(this.hLH);
        this.uiu.qJh = this.hLH;
        this.hql = new com.tencent.mm.ui.widget.b.a(this.mController.tml);
        this.kBy.setOnItemClickListener(new 11(this));
        this.kBy.setOnItemLongClickListener(new 12(this));
        this.kBy.setOnTouchListener(new 13(this));
        ListView listView = this.kBy;
        ContactCountView contactCountView = new ContactCountView(this);
        this.uhu = contactCountView;
        listView.addFooterView(contactCountView, null, false);
        setBackBtn(new 2(this));
        addIconOptionMenu(0, R.l.actionbar_title_new_group_chat, R.k.actionbar_icon_dark_add, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(ChatroomContactUI.this, SelectContactUI.class);
                intent.putExtra("titile", ChatroomContactUI.this.getString(R.l.address_title_launch_chatting));
                intent.putExtra("list_type", 0);
                intent.putExtra("list_attr", s.s(new int[]{s.ukG, 256, 512}));
                ChatroomContactUI.this.mController.tml.startActivity(intent);
                return false;
            }
        });
        AnonymousClass4 anonymousClass4 = new OnClickListener() {
            public final void onClick(View view) {
                BackwardSupportUtil.c.a(ChatroomContactUI.this.kBy);
            }
        };
        this.kBy.setAdapter(this.uiu);
        this.uhh.mz(false);
        this.kBy.setVisibility(0);
        this.uis = new VoiceSearchLayout(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14);
        this.uis.setLayoutParams(layoutParams);
        this.uis.setTopMargin(BackwardSupportUtil.b.b(this, 100.0f));
        this.uis.setVisibility(8);
        ((ViewGroup) findViewById(R.h.voicesearch_view)).addView(this.uis);
        if (this.uis != null) {
            this.uis.setOnVisibleChangeListener(new 5(this));
        }
        if (this.uiu.getCount() == 0) {
            this.iYb.setSingleLine(false);
            this.iYb.setPadding(40, 0, 40, 0);
            this.iYb.setVisibility(0);
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.uhu != null) {
            this.uhu.setContactType(2);
            this.uhu.cyd();
        }
        au.HU();
        c.Ga().c(this);
        if (!(this.uit == null || this.uis == null)) {
            com.tencent.mm.bg.d.cfH();
            if (com.tencent.mm.al.b.PD() || !w.chP().equals("zh_CN")) {
                this.uit.erG = false;
            } else {
                this.uit.erG = true;
                this.uit.o(this.uis);
            }
        }
        if (this.uhh != null) {
            this.uhh.onResume();
        }
    }

    protected void onPause() {
        super.onPause();
        au.HU();
        c.Ga().d(this);
        if (this.uit != null) {
            com.tencent.mm.modelvoiceaddr.ui.b bVar = this.uit;
            bVar.czQ();
            bVar.cancel();
        }
        if (this.uhh != null) {
            this.uhh.onPause();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        au.DF().b(138, this);
        au.HU();
        c.FR().b(this.uiu);
        d dVar = this.uiu;
        if (dVar.eKg != null) {
            dVar.eKg.detach();
            dVar.eKg = null;
        }
        this.uiu.aYc();
        this.uiu.tlG = null;
        this.uhh.detach();
        this.uhh.aYc();
    }

    private void aYT() {
        if (this.uiu != null) {
            this.uiu.a(null, null);
        }
        if (this.uhh != null) {
            this.uhh.a(null, null);
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (ai.ci(this) && !com.tencent.mm.ui.w.a.a(this, i, i2, str, 4) && i == 0 && i2 == 0) {
            switch (lVar.getType()) {
                case 138:
                    aYT();
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        if (this.uhu != null) {
            this.uhu.setContactType(2);
            this.uhu.cyd();
        }
    }
}
