package com.tencent.mm.plugin.subapp.ui.friend;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.az.c;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.k;

public class FMessageConversationUI extends MMActivity {
    private d hlb = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            c.d(FMessageConversationUI.this.osd, FMessageConversationUI.this.mbU);
        }
    };
    private String mbU;
    private b orL;
    private ListView osa;
    private a osb;
    private TextView osc;
    private long osd;

    class a {
        TextView eGX;
        ImageView gwj;

        public a(View view) {
            this.gwj = (ImageView) view.findViewById(R.h.fmsg_item_icon);
            this.eGX = (TextView) view.findViewById(R.h.fmsg_item_title);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.fmessage_conversation_title);
        try {
            au.getNotification().xR();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FMessageConversationUI", e, "try cancel notification fail", new Object[0]);
        }
        if (au.HX()) {
            initView();
        } else {
            finish();
        }
    }

    protected void onPause() {
        super.onPause();
        au.HU();
        com.tencent.mm.model.c.DT().set(143618, Integer.valueOf(0));
    }

    protected void onResume() {
        super.onResume();
        if (!au.HX()) {
            finish();
        } else if (this.osc != null && bi.fU(this)) {
            this.osc.setText(R.l.fmessage_no_recommend_msg_google);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        f.iU("1");
        com.tencent.mm.az.d.SF().clO();
        if (this.orL != null) {
            com.tencent.mm.az.d.SF().d(this.orL);
        }
    }

    protected final void initView() {
        int i;
        boolean z = true;
        if (g.IW().iP("1") != null) {
            int i2;
            String str = g.IW().iP("1").value;
            boolean i22;
            if (str.equals("0")) {
                i22 = 0;
            } else if (str.equals("1")) {
                i22 = true;
            } else {
                i22 = true;
            }
            f.iT("1");
            i = i22;
        } else {
            boolean i3 = true;
        }
        this.orL = new b(this.mController.tml);
        com.tencent.mm.az.d.SF().c(this.orL);
        this.orL.tlG = new com.tencent.mm.ui.r.a() {
            public final void Xa() {
            }

            public final void Xb() {
                if (FMessageConversationUI.this.orL.getCount() >= 0) {
                    FMessageConversationUI.this.enableOptionMenu(0, true);
                } else {
                    FMessageConversationUI.this.enableOptionMenu(0, false);
                }
            }
        };
        this.osa = (ListView) findViewById(R.h.fmessage_conversation_lv);
        if (i3 != 0) {
            View inflate = LayoutInflater.from(this.mController.tml).inflate(R.i.fmessage_conversation_header, null);
            inflate.findViewById(R.h.fmsg_searchEt).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    Intent putExtra = new Intent().putExtra("Search_Scene", 2).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
                    Bundle bundle = null;
                    if (VERSION.SDK_INT >= 21) {
                        bundle = ActivityOptions.makeSceneTransitionAnimation(FMessageConversationUI.this, new Pair[0]).toBundle();
                    }
                    com.tencent.mm.plugin.fts.a.d.b(FMessageConversationUI.this.mController.tml, ".ui.FTSAddFriendUI", putExtra, bundle);
                }
            });
            this.osa.addHeaderView(inflate);
        }
        this.osa.setAdapter(this.orL);
        this.osa.setOnItemLongClickListener(new 3(this, new k(this)));
        ActionBarActivity actionBarActivity = this.mController.tml;
        b bVar = this.orL;
        if (this.osa.getHeaderViewsCount() <= 0) {
            z = false;
        }
        this.osb = new a(actionBarActivity, bVar, z);
        this.osa.setOnItemClickListener(this.osb);
        View findViewById;
        if (i3 == 0) {
            findViewById = findViewById(R.h.fmessage_conversation_empty_a);
            findViewById.setVisibility(0);
            ((TextView) findViewById(R.h.empty_tip_recommend_bind_tv)).setOnClickListener(new 4(this));
            this.osa.setEmptyView(findViewById);
        } else {
            findViewById = findViewById(R.h.fmessage_conversation_empty_b);
            findViewById.setVisibility(0);
            this.osc = (TextView) findViewById.findViewById(R.h.fmsg_msg_content);
            ListView listView = (ListView) findViewById.findViewById(R.h.fmsg_list);
            listView.setAdapter(new 5(this));
            listView.setOnItemClickListener(new 6(this));
            this.osa.setEmptyView(findViewById);
        }
        addTextOptionMenu(0, getString(R.l.menu_item_add_friend), new 7(this));
        setBackBtn(new 8(this));
    }

    protected final int getLayoutId() {
        return R.i.fmessage_conversation;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        ar arVar = (ar) this.orL.getItem(adapterContextMenuInfo.position);
        if (arVar == null) {
            x.e("MicroMsg.FMessageConversationUI", "onItemLongClick, item is null, pos = " + adapterContextMenuInfo.position);
            return;
        }
        if (!bi.oW(arVar.field_displayName)) {
            contextMenu.setHeaderTitle(j.a(this, arVar.field_displayName));
        }
        contextMenu.add(0, 0, 0, R.l.app_delete);
        this.osd = arVar.field_fmsgSysRowId;
        this.mbU = arVar.field_talker;
    }
}
