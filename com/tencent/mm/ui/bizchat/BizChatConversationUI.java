package com.tencent.mm.ui.bizchat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ac.a.j;
import com.tencent.mm.ac.n;
import com.tencent.mm.ac.z;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.c.xr;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.BaseConversationUI.b;
import com.tencent.mm.ui.g;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.y;

public class BizChatConversationUI extends BaseConversationUI {
    private View contentView;

    public static class a extends b implements n, m.b {
        private String dLD;
        private TextView emptyTipTv;
        private ListView hkY;
        private d hlb;
        private long hpD;
        private String hpJ;
        private l hpi;
        private int hpr = 0;
        private int hps = 0;
        private boolean isCurrentActivity;
        private boolean isDeleteCancel = false;
        private com.tencent.mm.ac.a.d.a tEA = new 13(this);
        private com.tencent.mm.ac.c.a tEB = new 14(this);
        private LinearLayout tEv;
        private b tEw;
        private j tEx;
        private int tEy = 0;
        private com.tencent.mm.ac.a.b.a tEz = new 11(this);
        private p tipDialog;

        static /* synthetic */ void m(a aVar) {
            aVar.tEx = z.Nc().cz(z.Nc().cA(aVar.hpJ));
            if (aVar.tEx == null || bi.oW(aVar.tEx.field_addMemberUrl)) {
                Toast.makeText(aVar.thisActivity(), aVar.getString(R.l.bizchat_new_chat_fail), 0).show();
                aVar.csq();
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", aVar.tEx.field_addMemberUrl);
            x.i("MicroMsg.BizChatConversationFmUI", "KRawUrl :%s", new Object[]{aVar.tEx.field_addMemberUrl});
            intent.putExtra("useJs", true);
            intent.addFlags(67108864);
            com.tencent.mm.bg.d.b(aVar.getContext(), "webview", ".ui.tools.WebViewUI", intent, 1);
        }

        public final void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            this.hpJ = thisActivity().getIntent().getStringExtra("Contact_User");
            x.i("MicroMsg.BizChatConversationFmUI", "[registerListener]");
            z.Nb().a(this.tEz, thisActivity().getMainLooper());
            z.Na().a(this.tEA, thisActivity().getMainLooper());
            z.Nh().a(this.tEB, thisActivity().getMainLooper());
            au.HU();
            c.FW().a(this);
            this.emptyTipTv = (TextView) findViewById(R.h.empty_msg_tip_tv);
            this.emptyTipTv.setText(R.l.main_empty_conversation);
            this.hkY = (ListView) findViewById(R.h.tmessage_lv);
            csp();
            this.tEw = new b(thisActivity(), new 19(this), this.hpJ);
            this.tEw.setGetViewPositionCallback(new 20(this));
            this.tEw.setPerformItemClickListener(new 21(this));
            this.tEw.a(new f() {
                public final void bv(Object obj) {
                    if (obj == null) {
                        x.e("MicroMsg.BizChatConversationFmUI", "onItemDel object null");
                    }
                }
            });
            this.hkY.setAdapter(this.tEw);
            this.hlb = new 15(this);
            com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(thisActivity());
            this.hkY.setOnTouchListener(new 16(this));
            this.hkY.setOnItemLongClickListener(new 17(this, aVar));
            this.hkY.setOnItemClickListener(new 18(this));
            setBackBtn(new 3(this));
            addIconOptionMenu(1, R.l.top_item_desc_search, R.k.actionbar_icon_dark_search, new 4(this));
            addIconOptionMenu(2, R.l.actionbar_title_new_group_chat, R.k.actionbar_icon_dark_add, new 5(this));
            csq();
            au.Em().h(new 10(this), 300);
            String csr = csr();
            if (csr != null) {
                z.Nh();
                com.tencent.mm.ac.c.a(csr, null);
                x.e("MicroMsg.BizChatConversationFmUI", "update father attr from svr mainBizName:%s", new Object[]{csr});
            } else {
                x.e("MicroMsg.BizChatConversationFmUI", "mainBizName is null!!!");
            }
            Looper.myQueue().addIdleHandler(new 1(this));
            Intent intent = thisActivity().getIntent();
            if (s.a(intent, "biz_chat_need_to_jump_to_chatting_ui", false)) {
                long longExtra = intent.getLongExtra("biz_chat_chat_id", -1);
                if (longExtra != -1) {
                    gs(longExtra);
                }
            }
        }

        protected final int getLayoutId() {
            return R.i.enterprise_conversation;
        }

        public final String getUserName() {
            if (bi.oW(this.dLD)) {
                return this.hpJ;
            }
            return this.dLD;
        }

        public final void onDestroy() {
            x.i("MicroMsg.BizChatConversationFmUI", "[unRegitListener]");
            z.Nb().a(this.tEz);
            z.Na().a(this.tEA);
            z.Nh().a(this.tEB);
            if (au.HX()) {
                au.HU();
                c.FW().b(this);
            }
            this.tEw.aYc();
            b bVar = this.tEw;
            if (bVar.tEl != null) {
                bVar.tEl.clear();
                bVar.tEl = null;
            }
            super.onDestroy();
        }

        public final void onResume() {
            super.onResume();
            au.HU();
            ab Yg = c.FR().Yg(this.hpJ);
            if (Yg == null || !com.tencent.mm.l.a.gd(Yg.field_type)) {
                finish();
                return;
            }
            com.tencent.mm.ac.d kH = com.tencent.mm.ac.f.kH(this.hpJ);
            if (kH == null || kH.field_enterpriseFather == null || !com.tencent.mm.model.s.he(kH.field_enterpriseFather)) {
                finish();
                return;
            }
            if (Yg.BD()) {
                setTitleMuteIconVisibility(0);
            } else {
                setTitleMuteIconVisibility(8);
            }
            this.isCurrentActivity = true;
            this.tEw.a(null, null);
            au.getNotification().eJ(this.hpJ);
        }

        public final void onPause() {
            x.i("MicroMsg.BizChatConversationFmUI", "on pause");
            au.HU();
            c.FW().Ys(this.hpJ);
            com.tencent.mm.ac.a.b Nb = z.Nb();
            String str = this.hpJ;
            if (bi.oW(str)) {
                x.e("MicroMsg.BizConversationStorage", "brandUserName is null");
            } else {
                boolean fV = Nb.diF.fV("BizChatConversation", "update BizChatConversation set newUnReadCount = 0 where newUnReadCount != 0 and brandUserName = '" + str + "'");
                x.d("MicroMsg.BizConversationStorage", "resetNewUnreadCount :%s,sql:%s", new Object[]{Boolean.valueOf(fV), str});
            }
            if (this.tEw != null) {
                this.tEw.onPause();
            }
            this.isCurrentActivity = false;
            au.getNotification().eJ("");
            super.onPause();
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            com.tencent.mm.ac.a.a aVar = (com.tencent.mm.ac.a.a) this.tEw.getItem(adapterContextMenuInfo.position);
            this.hpD = aVar.field_bizChatId;
            if (aVar.field_unReadCount <= 0) {
                contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.l.main_conversation_longclick_setUnRead);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 2, 0, R.l.main_conversation_longclick_markRead);
            }
            z.Nb();
            if (com.tencent.mm.ac.a.b.c(aVar)) {
                contextMenu.add(adapterContextMenuInfo.position, 3, 1, R.l.main_conversation_longclick_unplacedtop);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 3, 1, R.l.main_conversation_longclick_placedtop);
            }
            contextMenu.add(adapterContextMenuInfo.position, 0, 2, R.l.main_delete);
        }

        public final void onActivityResult(int i, int i2, Intent intent) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1) {
                switch (i) {
                    case 1:
                        boolean z;
                        Bundle bundleExtra = intent.getBundleExtra("result_data");
                        if (bundleExtra != null) {
                            String str;
                            x.i("MicroMsg.BizChatConversationFmUI", "bundle != null");
                            String string = bundleExtra.getString("enterprise_members");
                            xr xrVar = new xr();
                            com.tencent.mm.ac.a.c cVar = new com.tencent.mm.ac.a.c();
                            if (this.tEx != null) {
                                str = this.tEx.field_addMemberUrl;
                            } else {
                                str = null;
                            }
                            cVar.field_addMemberUrl = str;
                            cVar.field_brandUserName = this.hpJ;
                            if (!e.a(cVar, string, null, xrVar)) {
                                z = false;
                            } else if (cVar.field_bizChatLocalId != -1) {
                                gs(cVar.field_bizChatLocalId);
                                z = true;
                            } else {
                                z.Ng();
                                final com.tencent.mm.ac.a.n a = h.a(this.hpJ, xrVar, this);
                                FragmentActivity thisActivity = thisActivity();
                                getString(R.l.app_tip);
                                this.tipDialog = com.tencent.mm.ui.base.h.a(thisActivity, getString(R.l.app_waiting), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        z.Ng();
                                        h.f(a);
                                    }
                                });
                                z = true;
                            }
                        } else {
                            z = false;
                        }
                        if (!z) {
                            Toast.makeText(thisActivity(), getString(R.l.room_create_fail), 0).show();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        public final void a(int i, com.tencent.mm.ab.l lVar) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (lVar.getType() == 1355) {
                com.tencent.mm.ac.a.c la = z.Na().la(((com.tencent.mm.ac.a.n) lVar).Nt().ruQ.rDx.riE);
                if (la == null) {
                    Toast.makeText(ad.getContext(), getString(R.l.room_create_fail), 0).show();
                } else {
                    gs(la.field_bizChatLocalId);
                }
            }
        }

        private void csp() {
            String csr = csr();
            this.tEy = g.bu(getContext(), csr);
            if (this.tEy == 2 && this.tEv == null) {
                this.tEv = (LinearLayout) findViewById(R.h.bottom_bar);
                LayoutParams layoutParams = this.tEv.getLayoutParams();
                layoutParams.height = com.tencent.mm.bp.a.ad(getContext(), R.f.DefaultTabbarHeight);
                this.tEv.setLayoutParams(layoutParams);
                View inflate = y.gq(getContext()).inflate(R.i.enterprise_wework_view, this.tEv, false);
                float fe = com.tencent.mm.bp.a.fe(getContext());
                ImageView imageView = (ImageView) inflate.findViewById(R.h.icon_iv);
                int i = imageView.getLayoutParams().height;
                imageView.getLayoutParams().height = (int) (((float) i) * fe);
                imageView.getLayoutParams().width = (int) (fe * ((float) i));
                imageView.requestLayout();
                ((TextView) inflate.findViewById(R.h.title_tv)).setText(R.l.enterprise_wework_create_chat);
                this.tEv.addView(inflate);
                inflate.setOnClickListener(new 12(this));
                g.n(getContext(), this.hpJ, 4);
                g.bv(getContext(), csr);
            }
            if (this.tEv == null) {
                return;
            }
            if (this.tEy == 2) {
                this.tEv.setVisibility(0);
            } else {
                this.tEv.setVisibility(8);
            }
        }

        private void csq() {
            boolean z = false;
            String cA = z.Nc().cA(this.hpJ);
            this.tEx = z.Nc().cz(cA);
            String str = "MicroMsg.BizChatConversationFmUI";
            String str2 = "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s";
            Object[] objArr = new Object[3];
            objArr[0] = this.hpJ;
            objArr[1] = cA;
            if (this.tEx == null) {
                z = true;
            }
            objArr[2] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
            if (bi.oW(cA) || this.tEx == null || this.tEx.No() || bi.oW(this.tEx.field_addMemberUrl)) {
                z.Ng();
                h.a(this.hpJ, this);
                FragmentActivity thisActivity = thisActivity();
                getString(R.l.app_tip);
                this.tipDialog = com.tencent.mm.ui.base.h.a(thisActivity, getString(R.l.app_waiting), true, new 9(this));
            }
        }

        private String csr() {
            if (bi.oW(this.dLD)) {
                this.dLD = z.MY().kA(this.hpJ).Mg();
            }
            return this.dLD;
        }

        private void gs(long j) {
            Bundle bundle = new Bundle();
            bundle.putLong("key_biz_chat_id", j);
            bundle.putBoolean("finish_direct", false);
            bundle.putBoolean("key_need_send_video", false);
            bundle.putBoolean("key_is_biz_chat", true);
            this.ui.startChatting(this.hpJ, bundle, true);
        }

        public final void a(int i, m mVar, Object obj) {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.contentView = y.gq(this).inflate(R.i.bizconversation_activity_container, null);
        setContentView(this.contentView);
        this.conversationFm = new a();
        getSupportFragmentManager().bk().a(R.h.mm_root_view, this.conversationFm).commit();
        com.tencent.mm.pluginsdk.e.a(this, this.contentView);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.tencent.mm.pluginsdk.e.a(this, this.contentView);
    }
}
