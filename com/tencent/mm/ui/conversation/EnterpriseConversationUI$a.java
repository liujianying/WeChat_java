package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ac.c.a;
import com.tencent.mm.ac.f;
import com.tencent.mm.ac.z;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.i;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.atx;
import com.tencent.mm.protocal.c.brs;
import com.tencent.mm.protocal.c.brt;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.conversation.BaseConversationUI.b;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.y;

public class EnterpriseConversationUI$a extends b implements e, m.b {
    private long cYb = 0;
    private k contextMenuHelper;
    private String dKF;
    long eiC = 0;
    private TextView emptyTipTv;
    private int fromScene;
    private long gRK = 0;
    private String hpu = "";
    private d hqV;
    private boolean isDeleteCancel = false;
    private a tEB = new 10(this);
    private LinearLayout tEv = null;
    private int tEy = 0;
    private p tipDialog;
    private ListView unw;
    private String uny;
    private l uqt;
    private View uqu = null;
    private h uqv;
    private String uqw = null;
    private ag uqx;
    private int uqy = -2;
    private String uqz = null;

    static /* synthetic */ void aaS(String str) {
        au.HU();
        if (c.FR().Yg(str) == null) {
            x.e("MicroMsg.EnterpriseConversationUI", "changed biz stick status failed, contact is null, talker = " + str);
            return;
        }
        au.HU();
        if (c.FW().Yx(str)) {
            s.u(str, true);
        } else {
            i.gy(str);
        }
    }

    static /* synthetic */ void b(EnterpriseConversationUI$a enterpriseConversationUI$a) {
        if (enterpriseConversationUI$a.uqu != null) {
            com.tencent.mm.ac.b kn = z.Nh().kn(enterpriseConversationUI$a.dKF);
            if (kn != null && !kn.field_chatOpen && !kn.field_use_preset_banner_tips) {
                TextView textView = (TextView) enterpriseConversationUI$a.uqu.findViewById(R.h.title_tv);
                z.Nh();
                z.Nh();
                CharSequence ht = com.tencent.mm.ac.c.ht(0);
                if (textView != null && ht != null && !textView.getText().equals(ht)) {
                    textView.setText(ht);
                }
            }
        }
    }

    static /* synthetic */ String p(EnterpriseConversationUI$a enterpriseConversationUI$a) {
        if (enterpriseConversationUI$a.uqw == null) {
            z.MY();
            String kD = com.tencent.mm.ac.e.kD(enterpriseConversationUI$a.dKF);
            if (bi.oW(kD)) {
                kD = "";
            }
            enterpriseConversationUI$a.uqw = kD;
        }
        return bi.oW(enterpriseConversationUI$a.uqw) ? null : enterpriseConversationUI$a.uqw;
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dKF = thisActivity().getIntent().getStringExtra("enterprise_biz_name");
        this.uny = thisActivity().getIntent().getStringExtra("enterprise_biz_display_name");
        this.fromScene = thisActivity().getIntent().getIntExtra("enterprise_from_scene", 5);
        setMMTitle(this.uny);
        this.unw = (ListView) findViewById(R.h.tmessage_lv);
        this.emptyTipTv = (TextView) findViewById(R.h.empty_msg_tip_tv);
        this.emptyTipTv.setText(R.l.enterprise_empty_msg_tip);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                EnterpriseConversationUI$a.this.finish();
                return true;
            }
        });
        setToTop(new 11(this));
        if (f.kH(this.dKF) != null) {
            csp();
            if (this.dKF != null) {
                12 12 = new 12(this);
                z.Nh();
                com.tencent.mm.ac.c.a(this.dKF, 12);
                x.e("MicroMsg.EnterpriseConversationUI", "update father attr from svr bizName:%s", new Object[]{this.dKF});
            } else {
                x.e("MicroMsg.EnterpriseConversationUI", "bizName is null!!!");
            }
            addIconOptionMenu(1, R.l.top_item_desc_search, R.k.actionbar_icon_dark_search, new 14(this));
            addIconOptionMenu(2, R.l.actionbar_title_new_group_chat, R.k.actionbar_icon_dark_add, new 15(this));
            this.uqv = new h(thisActivity(), this.dKF, new 16(this));
            this.uqv.setGetViewPositionCallback(new 17(this));
            this.uqv.setPerformItemClickListener(new 18(this));
            this.uqv.a(new MMSlideDelView.f() {
                public final void bv(Object obj) {
                    if (obj == null) {
                        x.e("MicroMsg.EnterpriseConversationUI", "onItemDel object null");
                        return;
                    }
                    EnterpriseConversationUI$a.a(EnterpriseConversationUI$a.this, obj.toString());
                }
            });
            this.unw.setAdapter(this.uqv);
            this.unw.setOnItemClickListener(new 3(this));
            this.contextMenuHelper = new k(thisActivity());
            this.hqV = new 4(this);
            this.unw.setOnItemLongClickListener(new 5(this));
        }
        this.cYb = System.currentTimeMillis() / 1000;
        au.HU();
        ai Yq = c.FW().Yq(this.dKF);
        if (Yq != null) {
            this.uqy = Yq.field_unReadCount;
            if (this.uqy == 0 && Yq.field_unReadMuteCount > 0) {
                this.uqy = -1;
            }
            this.gRK = Yq.field_conversationTime / 1000;
            this.uqz = Yq.field_isSend == 1 ? null : Yq.field_digestUser;
        }
        z.Nh().a(this.tEB, thisActivity().getMainLooper());
        au.HU();
        c.FW().a(this);
        au.HU();
        c.FR().a(this);
        if (this.uqv != null) {
            if (this.uqx == null) {
                this.uqx = new 9(this);
            } else {
                this.uqx.removeMessages(1);
            }
            this.uqx.sendEmptyMessageDelayed(1, 500);
        }
    }

    protected final int getLayoutId() {
        return R.i.enterprise_conversation;
    }

    public final String getUserName() {
        return this.dKF;
    }

    public final void onDestroy() {
        z.Nh().a(this.tEB);
        if (au.HX()) {
            au.HU();
            c.FW().b(this);
            au.HU();
            c.FR().b(this);
        }
        if (this.uqv != null) {
            h hVar = this.uqv;
            hVar.uol.SO();
            if (hVar.tEl != null) {
                hVar.tEl.clear();
                hVar.tEl = null;
            }
            hVar.aYc();
            hVar.tlG = null;
            au.HU();
            c.FW().b(hVar);
        }
        au.DF().b(1394, this);
        if (this.cYb > 0 && this.eiC > 0) {
            long j = this.eiC - this.cYb;
            com.tencent.mm.ac.b kn = z.Nh().kn(this.dKF);
            int i = kn != null ? kn.field_qyUin : 0;
            int i2 = kn != null ? kn.field_userUin : 0;
            h.mEJ.h(13465, new Object[]{"", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(j)});
            x.d("MicroMsg.EnterpriseConversationUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", new Object[]{Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(j)});
        }
        super.onDestroy();
    }

    public final void onResume() {
        x.v("MicroMsg.EnterpriseConversationUI", "on resume");
        if (this.uqv != null) {
            this.uqv.onResume();
        }
        super.onResume();
        if (!s.he(this.dKF)) {
            finish();
        }
    }

    public final void onPause() {
        x.v("MicroMsg.EnterpriseConversationUI", "on pause");
        au.HU();
        c.FW().Ys(this.dKF);
        if (this.uqv != null) {
            this.uqv.onPause();
        }
        super.onPause();
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("be_send_card_name");
                    String stringExtra2 = intent.getStringExtra("received_card_name");
                    boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                    String stringExtra3 = intent.getStringExtra("custom_send_text");
                    g.bcT().l(stringExtra, stringExtra2, booleanExtra);
                    g.bcT().dF(stringExtra3, stringExtra2);
                    com.tencent.mm.ui.widget.snackbar.b.h(thisActivity(), getContext().getString(R.l.finish_sent));
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void csp() {
        this.tEy = com.tencent.mm.ui.g.bu(getContext(), this.dKF);
        if (this.tEy == 2 && this.tEv == null) {
            this.tEv = (LinearLayout) findViewById(R.h.bottom_bar);
            LayoutParams layoutParams = this.tEv.getLayoutParams();
            layoutParams.height = com.tencent.mm.bp.a.ad(getContext(), R.f.DefaultTabbarHeight);
            this.tEv.setLayoutParams(layoutParams);
            this.uqu = y.gq(getContext()).inflate(R.i.enterprise_wework_view, this.tEv, false);
            float fe = com.tencent.mm.bp.a.fe(getContext());
            ImageView imageView = (ImageView) this.uqu.findViewById(R.h.icon_iv);
            int i = imageView.getLayoutParams().height;
            imageView.getLayoutParams().height = (int) (((float) i) * fe);
            imageView.getLayoutParams().width = (int) (fe * ((float) i));
            imageView.requestLayout();
            TextView textView = (TextView) this.uqu.findViewById(R.h.title_tv);
            com.tencent.mm.ac.b kn = z.Nh().kn(this.dKF);
            z.Nh();
            z.Nh();
            CharSequence ht = com.tencent.mm.ac.c.ht(0);
            if (kn == null || kn.field_chatOpen || kn.field_use_preset_banner_tips || ht == null) {
                textView.setText(R.l.enterprise_wework_open);
            } else {
                textView.setText(ht);
            }
            com.tencent.mm.ui.g.am(this.dKF, 1, 2);
            this.tEv.addView(this.uqu);
            this.uqu.setOnClickListener(new 13(this));
            com.tencent.mm.ui.g.n(getContext(), this.dKF, 3);
            com.tencent.mm.ui.g.bv(getContext(), this.dKF);
        }
        if (this.tEv == null) {
            return;
        }
        if (this.tEy == 2) {
            this.tEv.setVisibility(0);
            com.tencent.mm.ac.b kn2 = z.Nh().kn(this.dKF);
            int i2 = kn2 != null ? kn2.field_qyUin : 0;
            int i3 = kn2 != null ? kn2.field_userUin : 0;
            long j = kn2 != null ? kn2.field_wwCorpId : 0;
            long j2 = kn2 != null ? kn2.field_wwUserVid : 0;
            h.mEJ.h(13656, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(j), Long.valueOf(j2)});
            x.d("MicroMsg.EnterpriseConversationUI", "expose wework btn on session list  report: %s,%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(j), Long.valueOf(j2)});
            return;
        }
        this.tEv.setVisibility(8);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (i == 0 && i2 == 0 && lVar.getType() == 1394) {
            brs bnl = ((com.tencent.mm.plugin.profile.a.c) lVar).bnl();
            brt bnk = ((com.tencent.mm.plugin.profile.a.c) lVar).bnk();
            if (bnk == null || bnk.riQ == null || bnk.riQ.ret != 0) {
                if (bnk == null || bnk.riQ == null) {
                    x.w("MicroMsg.EnterpriseConversationUI", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[]{Integer.valueOf(lVar.getType())});
                    return;
                }
                x.w("MicroMsg.EnterpriseConversationUI", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(bnk.riQ.ret)});
            } else if (bnl.spC) {
                com.tencent.mm.ac.d kH = f.kH(bnl.riK);
                kH.field_brandFlag |= 1;
                atx atx = new atx();
                atx.eJV = kH.field_brandFlag;
                atx.hbL = bnl.riK;
                au.HU();
                c.FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(47, atx));
                z.MY().c(kH, new String[0]);
                au.HU();
                c.FW().Yp(kH.field_username);
                au.HU();
                if (c.FW().YC(kH.field_enterpriseFather) <= 0) {
                    au.HU();
                    c.FW().Yp(kH.field_enterpriseFather);
                    return;
                }
                au.HU();
                c.FV().XJ(kH.field_enterpriseFather);
            }
        }
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        au.HU();
        ab Yg = c.FR().Yg(this.hpu);
        if (Yg == null) {
            x.e("MicroMsg.EnterpriseConversationUI", "onCreateContextMenu, contact is null, talker = " + this.hpu);
            return;
        }
        CharSequence BL = Yg.BL();
        if (BL.toLowerCase().endsWith("@chatroom") && bi.oW(Yg.field_nickname)) {
            BL = getString(R.l.chatting_roominfo_noname);
        }
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        contextMenu.setHeaderTitle(j.a(thisActivity(), BL));
        if (Yg.BG()) {
            contextMenu.add(adapterContextMenuInfo.position, 3, 0, R.l.main_conversation_longclick_unplacedtop);
        } else {
            contextMenu.add(adapterContextMenuInfo.position, 3, 0, R.l.enterprise_sub_placetop);
        }
        contextMenu.add(adapterContextMenuInfo.position, 2, 1, R.l.enterprise_longclick_disable_sub);
        contextMenu.add(adapterContextMenuInfo.position, 1, 2, R.l.main_delete);
    }

    public final void a(int i, m mVar, Object obj) {
    }
}
