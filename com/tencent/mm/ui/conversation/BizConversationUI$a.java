package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.bgl;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.conversation.BaseConversationUI.b;
import com.tencent.mm.ui.widget.b.a;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.LinkedList;
import java.util.Map.Entry;

public class BizConversationUI$a extends b {
    private ai conversation;
    private String dKF;
    private TextView emptyTipTv;
    private int fromScene = 0;
    private int hpr = 0;
    private int hps = 0;
    private d hqV = new 8(this);
    private a hql;
    private long hsq = 0;
    private c hss = new 9(this);
    private boolean isDeleteCancel = false;
    private String talker = "";
    private p tipDialog = null;
    private ListView unw;
    private a unx;
    private String uny;

    static /* synthetic */ void a(BizConversationUI$a bizConversationUI$a) {
        if (au.HX() && "officialaccounts".equals(bizConversationUI$a.dKF)) {
            long currentTimeMillis = System.currentTimeMillis();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            long j = 0;
            int i4 = 0;
            StringBuilder stringBuilder = new StringBuilder("");
            au.HU();
            Cursor b = com.tencent.mm.model.c.FW().b(s.dAN, null, bizConversationUI$a.dKF);
            if (b != null) {
                int columnIndex = b.getColumnIndex("unReadCount");
                int columnIndex2 = b.getColumnIndex("conversationTime");
                int columnIndex3 = b.getColumnIndex("flag");
                int count = b.getCount();
                ai aiVar = new ai();
                while (b.moveToNext()) {
                    aiVar.at(b.getLong(columnIndex3));
                    i4 = b.getInt(columnIndex);
                    if (i4 > 0) {
                        j = b.getLong(columnIndex2);
                        i2++;
                        i += i4;
                    } else {
                        i4 = 0;
                    }
                    stringBuilder.append(b.isFirst() ? "" : ".").append(i4);
                    au.HU();
                    if (com.tencent.mm.model.c.FW().g(aiVar)) {
                        i3++;
                    }
                }
                b.close();
                i4 = count;
            }
            h.mEJ.h(13771, new Object[]{Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(j / 1000), Integer.valueOf(i3), stringBuilder.toString()});
            x.v("MicroMsg.BizConversationUI", "report use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        }
    }

    static /* synthetic */ void b(BizConversationUI$a bizConversationUI$a) {
        if (bizConversationUI$a.hsq != 0 && "officialaccounts".equals(bizConversationUI$a.dKF)) {
            h.mEJ.h(13932, new Object[]{Integer.valueOf(((int) (System.currentTimeMillis() - bizConversationUI$a.hsq)) / BaseReportManager.MAX_READ_COUNT), Integer.valueOf(bizConversationUI$a.fromScene)});
        }
    }

    static /* synthetic */ void c(BizConversationUI$a bizConversationUI$a) {
        if (bizConversationUI$a.unx != null) {
            LinkedList linkedList = new LinkedList();
            for (Entry entry : bizConversationUI$a.unx.hsb.entrySet()) {
                b bVar = (b) entry.getValue();
                bgl bgl = new bgl();
                bgl.riA = (String) entry.getKey();
                bgl.shs = bVar.shs;
                bgl.sht = bVar.sht;
                bgl.jTf = bVar.jTf;
                bgl.shv = bVar.unB > 0;
                bgl.shx = bVar.shx;
                bgl.shu = bVar.shu;
                bgl.shw = bVar.shw;
                linkedList.add(bgl);
            }
            g.Eh().dpP.a(new com.tencent.mm.ac.x(linkedList), 0);
            x.d("MicroMsg.BizConversationUI", "reportExpose size:%d", new Object[]{Integer.valueOf(linkedList.size())});
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dKF = thisActivity().getIntent().getStringExtra("enterprise_biz_name");
        this.fromScene = thisActivity().getIntent().getIntExtra("biz_from_scene", 0);
        if (bi.oW(this.dKF)) {
            this.dKF = "officialaccounts";
        }
        if (bi.oV(this.dKF).equals("officialaccounts")) {
            h.mEJ.h(11404, new Object[]{Integer.valueOf(0)});
        }
        this.uny = thisActivity().getIntent().getStringExtra("enterprise_biz_display_name");
        if (bi.oW(this.uny)) {
            this.uny = getString(R.l.biz_conversation_title);
        }
        setMMTitle(this.uny);
        this.unw = (ListView) findViewById(R.h.tmessage_lv);
        this.emptyTipTv = (TextView) findViewById(R.h.empty_msg_tip_tv);
        this.emptyTipTv.setText(R.l.empty_biz_msg_tip);
        setBackBtn(new 11(this));
        setToTop(new 12(this));
        this.unx = new a(thisActivity(), this.dKF, new 13(this));
        this.unx.setGetViewPositionCallback(new 14(this));
        this.unx.setPerformItemClickListener(new 15(this));
        this.unw.setAdapter(this.unx);
        this.hql = new a(thisActivity());
        this.unw.setOnItemClickListener(new 16(this));
        this.unw.setOnTouchListener(new 17(this));
        this.unw.setOnItemLongClickListener(new 2(this));
        this.unx.setGetViewPositionCallback(new 3(this));
        this.unx.setPerformItemClickListener(new 4(this));
        this.unx.a(new 5(this));
        if ("officialaccounts".equals(this.dKF)) {
            com.tencent.mm.storage.c fJ = com.tencent.mm.model.c.c.Jx().fJ("100045");
            boolean z = fJ.isValid() && "1".equals(fJ.ckq().get("isOpenSearch"));
            x.d("MicroMsg.BizConversationUI", "open search entrance:%b", new Object[]{Boolean.valueOf(z)});
            if (z) {
                addIconOptionMenu(1, R.l.top_item_desc_search, R.k.actionbar_icon_dark_search, new 1(this));
            }
        }
        au.HU();
        com.tencent.mm.model.c.FW().a(this.unx);
        this.hsq = System.currentTimeMillis();
        com.tencent.mm.sdk.b.a.sFg.b(this.hss);
    }

    protected final int getLayoutId() {
        return R.i.tmessage;
    }

    public final String getUserName() {
        return this.dKF;
    }

    public final void onDestroy() {
        au.Em().H(new 10(this));
        com.tencent.mm.sdk.b.a.sFg.c(this.hss);
        if (au.HX()) {
            au.HU();
            com.tencent.mm.model.c.FW().b(this.unx);
        }
        if (this.unx != null) {
            this.unx.onDestroy();
        }
        super.onDestroy();
    }

    public final void onResume() {
        x.v("MicroMsg.BizConversationUI", "on resume");
        if (this.unx != null) {
            this.unx.onResume();
        }
        super.onResume();
    }

    public final void onPause() {
        x.i("MicroMsg.BizConversationUI", "on pause");
        if (!(s.hE(this.dKF) && com.tencent.mm.storage.s.auK())) {
            au.HU();
            com.tencent.mm.model.c.FW().Ys(this.dKF);
        }
        if (this.unx != null) {
            this.unx.onPause();
        }
        super.onPause();
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (!(this.talker == null || this.talker.isEmpty())) {
            this.talker = "";
        }
        if (i2 == -1) {
        }
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        au.HU();
        ab Yg = com.tencent.mm.model.c.FR().Yg(this.talker);
        if (Yg == null) {
            x.e("MicroMsg.BizConversationUI", "onCreateContextMenu, contact is null, talker = " + this.talker);
            return;
        }
        CharSequence BL = Yg.BL();
        if (BL.toLowerCase().endsWith("@chatroom") && bi.oW(Yg.field_nickname)) {
            BL = getString(R.l.chatting_roominfo_noname);
        }
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        contextMenu.setHeaderTitle(j.a(thisActivity(), BL));
        if (com.tencent.mm.l.a.gd(Yg.field_type)) {
            if (Yg.BG()) {
                contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.l.main_conversation_longclick_unplacedtop);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.l.contact_info_stick_biz);
            }
            contextMenu.add(adapterContextMenuInfo.position, 2, 0, R.l.main_conversation_longclick_delete_biz_service);
        }
        contextMenu.add(adapterContextMenuInfo.position, 3, 0, R.l.main_delete);
    }
}
