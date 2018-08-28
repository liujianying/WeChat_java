package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.b.b.ag;
import com.tencent.mm.ui.chatting.b.b.m;
import com.tencent.mm.ui.chatting.b.b.o;
import com.tencent.mm.ui.chatting.b.b.q;
import com.tencent.mm.ui.chatting.b.b.z;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.t;
import java.util.TreeSet;

@SuppressLint({"ValidFragment"})
public class y extends e {
    public static String tMb;
    private int if = 0;
    private MMPullDownView lbd;
    public s tMc;
    ListView tMd;
    public boolean tMe = false;
    private boolean tMf = true;
    protected boolean tMg = true;
    private boolean tMh = false;
    private boolean tMi = false;
    private boolean tMj = false;
    private int tMk = 0;
    private final int tMl = 10;
    private p tipDialog = null;

    @SuppressLint({"ValidFragment"})
    public y(byte b) {
        super((byte) 0);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (this.bAG.eaR) {
            super.onCreateOptionsMenu(menu, menuInflater);
        }
    }

    protected void dealContentView(View view) {
        super.dealContentView(view);
        ((o) this.bAG.O(o.class)).dt(view);
    }

    public void setMMTitle(int i) {
        setMMTitle(getMMString(i));
    }

    public void setMMTitle(String str) {
        ((o) this.bAG.O(o.class)).setMMTitle(str);
    }

    public void setMMSubTitle(String str) {
        ((o) this.bAG.O(o.class)).setMMSubTitle(str);
    }

    public void setMMSubTitle(int i) {
        setMMSubTitle(getMMString(i));
    }

    public void setBackBtn(OnMenuItemClickListener onMenuItemClickListener) {
        ((o) this.bAG.O(o.class)).setBackBtn(onMenuItemClickListener);
    }

    public final void avj() {
        if (this.tMc != null) {
            this.tMc.notifyDataSetChanged();
        }
    }

    public final void lT(boolean z) {
        Y(z, Looper.myLooper() != Looper.getMainLooper());
    }

    @Deprecated
    public final void Y(boolean z, boolean z2) {
        if (z2) {
            a.cwt().postDelayed(new 1(this, z), 10);
        } else {
            lU(z);
        }
    }

    private void lU(boolean z) {
        int count = this.tMd.getCount() - 1;
        x.i("MicroMsg.ChattingUIFragment", "[scrollToLastImpl] is FirstScroll:%s, last visible:count=[%s:%s] force:%s", new Object[]{Boolean.valueOf(this.tMf), Integer.valueOf(this.tMd.getLastVisiblePosition()), Integer.valueOf(count), Boolean.valueOf(z)});
        this.tMf = false;
        if (this.tMd.getLastVisiblePosition() >= count - 1 || z) {
            int count2 = this.tMc.getCount();
            if (count2 <= 1 || !((bd) this.tMc.getItem(count2 - 2)).isSystem()) {
                j.a(this.tMd, count, 0, true);
                return;
            }
            j.a(this.tMd, count - 1, 0, false);
        }
    }

    public final void bg(int i) {
        this.tMd.post(new 9(this, i));
    }

    public final void ctY() {
        x.i("MicroMsg.ChattingUIFragment", "[smoothScrollBy] dis:%d duration:%d", new Object[]{Integer.valueOf(0), Integer.valueOf(0)});
        this.tMd.smoothScrollBy(0, 0);
    }

    public final void EV(int i) {
        x.i("MicroMsg.ChattingUIFragment", "[setSelection] pos:%d isSmooth:%s", new Object[]{Integer.valueOf(i), Boolean.valueOf(false)});
        ListView listView = this.tMd;
        if (listView != null) {
            x.i("MicroMsg.ChattingUI.ScrollController", "setSelection position %s smooth %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(false)});
            listView.setItemChecked(i, true);
            listView.setSelection(i);
        }
    }

    public final void eX(int i, int i2) {
        x.i("MicroMsg.ChattingUIFragment", "[setSelectionFromTop] pos:%d offset:%s isSmooth:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(false)});
        j.a(this.tMd, i, i2, false);
    }

    public boolean hideVKB() {
        ChatFooter cvb = ((m) this.bAG.O(m.class)).cvb();
        if (cvb != null) {
            return bi.hideVKB(cvb);
        }
        return super.hideVKB();
    }

    public final void c(Context context, String str, OnCancelListener onCancelListener) {
        dismissDialog();
        this.tipDialog = h.a(context, str, true, onCancelListener);
    }

    public final void dismissDialog() {
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
    }

    public final void setKeepScreenOn(boolean z) {
        this.tMd.setKeepScreenOn(z);
    }

    public final void setBottomViewVisible(boolean z) {
        this.lbd.setBottomViewVisible(z);
    }

    public final void ctZ() {
        this.lbd.setTopViewVisible(true);
    }

    public final void cua() {
        this.lbd.setIsTopShowAll(false);
    }

    public final void setIsBottomShowAll(boolean z) {
        this.lbd.setIsBottomShowAll(z);
    }

    public final void lK(boolean z) {
        this.lbd.lK(z);
    }

    public final void cub() {
        this.lbd.lJ(false);
    }

    public final int getBottomHeight() {
        return this.lbd.getBottomHeight();
    }

    public final int getTopHeight() {
        return this.lbd.getTopHeight();
    }

    public final void EW(int i) {
        this.tMd.setVisibility(i);
        x.i("MicroMsg.ChattingUIFragment", "[setListViewVisibility] visibility:" + i + " stack:" + bi.cjd().toString());
    }

    public final void cuc() {
        this.tMd.setTranscriptMode(0);
    }

    public final int getFirstVisiblePosition() {
        return this.tMd.getFirstVisiblePosition();
    }

    public boolean getUserVisibleHint() {
        return this.bAG.eaR;
    }

    protected int getLayoutId() {
        return R.i.chatting;
    }

    public final t csU() {
        if (this.bAG.O(o.class) == null) {
            return null;
        }
        return ((o) this.bAG.O(o.class)).csU();
    }

    public boolean isSupportCustomActionBar() {
        return isSupportNavigationSwipeBack();
    }

    protected final void W(ab abVar) {
        super.W(abVar);
        tMb = abVar.field_username;
    }

    public final void gK(Context context) {
        super.gK(context);
        x.i("MicroMsg.ChattingUIFragment", "[doAttach]:%s#0x%x task:%s hc:%d", new Object[]{thisActivity().getClass().getSimpleName(), Integer.valueOf(thisActivity().hashCode()), bi.fV(thisActivity()), Integer.valueOf(hashCode())});
        if (this.mController != null) {
            this.mController.ak(3, true);
        }
    }

    public void csH() {
        int i;
        String str;
        ab Yg;
        this.tMi = false;
        this.tMj = false;
        this.tMf = true;
        this.tMg = true;
        this.tMe = true;
        x.d("MicroMsg.ChattingUIFragment", "isFromSearch  " + getBooleanExtra("finish_direct", false));
        boolean z = this.bAG.oLT == null;
        x.i("MicroMsg.ChattingUIFragment", "[doCreate] rawUserName from :%s to :%s ", new Object[]{this.bAG.getTalkerUserName(), getStringExtra("Chat_User")});
        String stringExtra = getStringExtra("Chat_User");
        au.HU();
        ab Yg2 = c.FR().Yg(stringExtra);
        String str2 = "MicroMsg.ChattingUIFragment";
        String str3 = "protectContactNotExist raw:%s contact:%d username:%s";
        Object[] objArr = new Object[3];
        objArr[0] = stringExtra;
        if (Yg2 == null) {
            i = -1;
        } else {
            i = (int) Yg2.dhP;
        }
        objArr[1] = Integer.valueOf(i);
        if (Yg2 == null) {
            str = "null";
        } else {
            str = Yg2.field_username;
        }
        objArr[2] = str;
        x.w(str2, str3, objArr);
        if (Yg2 == null || ((int) Yg2.dhP) == 0 || bi.oW(Yg2.field_username)) {
            Yg2 = new ab();
            Yg2.setUsername(stringExtra);
            Yg2.taj = stringExtra;
            Yg2.Bc();
            Yg2.eI(3);
            au.HU();
            c.FR().S(Yg2);
            au.HU();
            Yg = c.FR().Yg(stringExtra);
            if (Yg == null) {
                x.e("MicroMsg.ChattingUIFragment", "protectContactNotExist contact get from db is null!");
                Yg2.setUsername(this.bAG.cwp());
                finish();
                Yg = Yg2;
            }
            if (ab.gY(stringExtra)) {
                x.i("MicroMsg.ChattingUIFragment", "[protectContactNotExist] isBottleContact userName:" + stringExtra);
                Yg.taj = stringExtra;
                Yg.setUsername(stringExtra);
            }
        } else {
            Yg = Yg2;
            if (ab.gY(stringExtra)) {
                x.i("MicroMsg.ChattingUIFragment", "[protectContactNotExist] isBottleContact userName:" + stringExtra);
                Yg.taj = stringExtra;
                Yg.setUsername(stringExtra);
            }
        }
        W(Yg);
        super.csH();
        if (isSupportNavigationSwipeBack()) {
            getSwipeBackLayout().setEnableGesture(true);
            getSwipeBackLayout().init();
        }
        if (z) {
            a.cwt().post(new Runnable() {
                public final void run() {
                    ((o) y.this.bAG.O(o.class)).cvo();
                    ((o) y.this.bAG.O(o.class)).cvn();
                }
            });
        }
        csJ();
        s sVar = this.tMc;
        String talkerUserName = this.bAG.getTalkerUserName();
        String cwp = this.bAG.cwp();
        sVar.tKk = new TreeSet();
        sVar.tJM = talkerUserName;
        if (ab.gY(talkerUserName)) {
            sVar.dIc = ab.XV(cwp);
        } else {
            sVar.dIc = cwp;
        }
        sVar.tJL = ((ag) sVar.bAG.O(ag.class)).cwl();
        iy iyVar = new iy();
        iyVar.bSB.bSv = 0;
        iyVar.bSB.aem = w.chP();
        if (s.fq(talkerUserName)) {
            iyVar.bSB.bSD = true;
        } else {
            iyVar.bSB.bSD = false;
        }
        com.tencent.mm.sdk.b.a.sFg.m(iyVar);
        sVar.talker = talkerUserName;
        sVar.hpD = ((com.tencent.mm.ui.chatting.b.b.c) sVar.tJh.O(com.tencent.mm.ui.chatting.b.b.c.class)).cuC();
        sVar.ctA();
    }

    public void csI() {
        boolean isShown;
        boolean z;
        super.csI();
        if (getWindow() != null) {
            getWindow().setBackgroundDrawableResource(R.e.room_info_comment_layout_bg);
        }
        boolean isShown2 = getContentView() != null ? getContentView().isShown() : false;
        if (getView() != null) {
            isShown = getView().isShown();
        } else {
            isShown = false;
        }
        if (this.tMd.getVisibility() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!this.bAG.eaR) {
            x.i("MicroMsg.ChattingUIFragment", "onResume fragment not foreground, return,  chatting contentview is show %b, viewShow %b listviewShow:%b", new Object[]{Boolean.valueOf(isShown2), Boolean.valueOf(isShown), Boolean.valueOf(z)});
        } else if (au.HX()) {
            x.i("MicroMsg.ChattingUIFragment", "ashutest::onResume %d,  chatting is show %b, viewShow %b listviewShow:%b", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(isShown2), Boolean.valueOf(isShown), Boolean.valueOf(z)});
            long currentTimeMillis = System.currentTimeMillis();
            int i = (!EH(256) || EH(MapRouteSectionWithName.kMaxRoadNameLength)) ? 0 : 1;
            if (i == 0) {
                this.tMc.resume();
                cud();
            }
            x.v("Test", "KEVIN Chatting OnResume: diff:%d  rawUserName:%s ", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), this.bAG.getTalkerUserName()});
        } else {
            x.w("MicroMsg.ChattingUIFragment", "account not ready, mabey not call onDestroy!!!");
            finish();
        }
    }

    public void csK() {
        super.csK();
        q.dismiss();
        x.i("MicroMsg.ChattingUIFragment", "on chatting ui pause  rawuser:%s", new Object[]{this.bAG.getTalkerUserName()});
        if (this.bAG.getTalkerUserName() != null) {
            this.tMc.pause();
            hideVKB();
            x.d("MicroMsg.ChattingUIFragment", "chattingui cancel pause auto download logic");
        }
    }

    public final void csT() {
        super.csT();
        if (this.bAG.getTalkerUserName() != null) {
            this.tMc.aYc();
            this.tMc.tlG = null;
        }
    }

    public void cpM() {
        super.cpM();
        this.tMc.resume();
        cud();
        lV(true);
    }

    public final void cpN() {
        super.cpN();
        lV(false);
    }

    public final void cpO() {
        super.cpO();
        lV(true);
    }

    public final void cpP() {
        super.cpP();
        dismissDialog();
        if (this.tMc != null) {
            this.tMc.ctA();
            x.i("MicroMsg.ChattingUIFragment", "ChattingUI resetAdapter");
        }
    }

    private void cud() {
        com.tencent.mm.ui.chatting.b.b.w wVar = (com.tencent.mm.ui.chatting.b.b.w) this.bAG.O(com.tencent.mm.ui.chatting.b.b.w.class);
        x.i("MicroMsg.ChattingUIFragment", "From Show Search ChatResult %b, From Gloabl Search %b", new Object[]{Boolean.valueOf(wVar.cvQ()), Boolean.valueOf(wVar.cvS())});
        wVar = (com.tencent.mm.ui.chatting.b.b.w) this.bAG.O(com.tencent.mm.ui.chatting.b.b.w.class);
        boolean z = (this.tMi || wVar.cvQ() || wVar.cvS()) ? false : true;
        if (z) {
            this.tMi = true;
            this.tMj = true;
            this.tMh = false;
            this.tMd.getViewTreeObserver().addOnGlobalLayoutListener(new 11(this));
        }
    }

    public final void cue() {
        com.tencent.mm.ui.chatting.b.b.w wVar = (com.tencent.mm.ui.chatting.b.b.w) this.bAG.O(com.tencent.mm.ui.chatting.b.b.w.class);
        if (!(wVar.cvQ() || wVar.cvS())) {
            int i = this.tMk;
            this.tMk = i + 1;
            if (i < 10 && ((thisActivity() instanceof ChattingUI) || (thisActivity() instanceof AppBrandServiceChattingUI))) {
                int i2;
                ListView listView = this.tMd;
                12 12 = new 12(this);
                if (this.tMk == 1) {
                    i2 = 10;
                } else {
                    i2 = 100;
                }
                listView.postDelayed(12, (long) i2);
                return;
            }
        }
        x.d("MicroMsg.ChattingUIFragment", "scrollToLastProtect:%s, %s ,%s", new Object[]{Boolean.valueOf(wVar.cvQ()), Boolean.valueOf(wVar.cvS()), Integer.valueOf(this.tMk)});
    }

    public void onKeyboardStateChanged() {
        if (keyboardState() == 1) {
            this.tMd.post(new 13(this));
        }
    }

    public final boolean csV() {
        if (isScreenEnable()) {
            7 7 = new 7(this);
            if (hideVKB()) {
                ah.i(7, 300);
            } else {
                7.run();
            }
        } else {
            x.w("MicroMsg.ChattingUIFragment", "Actionbar customView onclick screen not enable");
        }
        return true;
    }

    private void lV(boolean z) {
        if (this.tMc != null) {
            this.tMc.lS(z);
        }
    }

    protected void csJ() {
        this.tMd = (ListView) findViewById(R.h.chatting_history_lv);
        this.tMd.setVisibility(0);
        this.if = 0;
        this.lbd = (MMPullDownView) findViewById(R.h.chatting_pull_down_view);
        this.lbd.setCanOverScrool(false);
        this.lbd.lJ(false);
        this.lbd.setOnTopLoadDataListener(new 16(this));
        this.lbd.setOnBottomLoadDataListener(new 2(this));
        this.lbd.setTopViewVisible(true);
        this.lbd.setAtBottomCallBack(new 3(this));
        this.lbd.setAtTopCallBack(new 4(this));
        this.lbd.setOnScrollChangedListener(new 5(this));
        this.lbd.setIsBottomShowAll(true);
        this.lbd.setBottomViewVisible(((com.tencent.mm.ui.chatting.b.b.w) this.bAG.O(com.tencent.mm.ui.chatting.b.b.w.class)).cvQ());
        this.lbd.lK(false);
        this.tMd.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                y.this.tHz.onScrollStateChanged(absListView, i);
                y.this.if = i;
                if (i == 0) {
                    int i2;
                    View childAt = y.this.tMd.getChildAt(0);
                    String str = "MicroMsg.ChattingUIFragment";
                    String str2 = "[onScrollStateChanged] firstPos:%d childTop:%s pullDownView [scrollY:%s top:%s] chatHistoryListTop:%s TranscriptMode:%s OverScrollMode:%s";
                    Object[] objArr = new Object[7];
                    objArr[0] = Integer.valueOf(y.this.tMd.getFirstVisiblePosition());
                    if (childAt == null) {
                        i2 = -1;
                    } else {
                        i2 = childAt.getTop();
                    }
                    objArr[1] = Integer.valueOf(i2);
                    objArr[2] = Integer.valueOf(y.this.lbd.getScrollY());
                    objArr[3] = Integer.valueOf(y.this.lbd.getTop());
                    objArr[4] = Integer.valueOf(y.this.tMd.getTop());
                    objArr[5] = Integer.valueOf(y.this.tMd.getTranscriptMode());
                    objArr[6] = Integer.valueOf(y.this.tMd.getOverScrollMode());
                    x.i(str, str2, objArr);
                    if (y.this.tMd.getFirstVisiblePosition() == 0 && childAt != null && childAt.getTop() >= 0) {
                        y.this.lbd.lJ(true);
                    }
                }
            }

            public final synchronized void onScroll(AbsListView absListView, int i, int i2, int i3) {
                y.this.tHz.onScroll(absListView, i, i2, i3);
                if (y.this.tMj) {
                    if (y.this.tMd.getLastVisiblePosition() == i3 - 1) {
                        y.this.tMj = false;
                    }
                }
                ((z) y.this.bAG.O(z.class)).eY(i3, i);
                ((com.tencent.mm.ui.chatting.b.b.p) y.this.bAG.O(com.tencent.mm.ui.chatting.b.b.p.class)).eY(i3, i);
            }
        });
        if (this.tMc == null) {
            a aVar = this.bAG;
            bd bdVar = new bd();
            String talkerUserName = this.bAG.getTalkerUserName();
            this.bAG.cwp();
            this.tMc = new s(aVar, bdVar, talkerUserName);
        }
        this.tMc.lB(true);
        this.tMc.ioW = a.cwt();
        this.tMc.tlG = new 14(this);
        ((o) this.bAG.O(o.class)).cvm();
        if (this.tMd.getAdapter() == null) {
            this.tMd.setAdapter(this.tMc);
            x.i("MicroMsg.ChattingUIFragment", "chatHistoryList.setAdapter");
        }
        if (((com.tencent.mm.ui.chatting.b.b.w) this.bAG.O(com.tencent.mm.ui.chatting.b.b.w.class)).cvQ()) {
            this.tMd.setTranscriptMode(0);
        } else {
            this.tMd.setTranscriptMode(1);
            this.tMd.setOverScrollMode(2);
        }
        this.tMd.setOnTouchListener(new 15(this));
        registerForContextMenu(this.tMd);
    }

    public void onSwipeBack() {
        cuf();
        if (isSupportNavigationSwipeBack()) {
            getSwipeBackLayout().setEnableGesture(false);
            if (this.tMc != null) {
                this.tMc.lS(false);
            }
        }
    }

    public void onDragBegin() {
        if (isSupportNavigationSwipeBack() && this.tMc != null) {
            this.tMc.lS(true);
            this.tMg = false;
        }
    }

    public void onCancelDrag() {
        if (isSupportNavigationSwipeBack() && this.tMc != null) {
            this.tMc.lS(false);
            this.tMg = true;
        }
    }

    protected final void cuf() {
        String str = "MicroMsg.ChattingUIFragment";
        String str2 = "[goBackImpl] context is null? %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.bAG == null);
        x.i(str, str2, objArr);
        com.tencent.mm.ui.chatting.b.b.h hVar = (com.tencent.mm.ui.chatting.b.b.h) this.bAG.O(com.tencent.mm.ui.chatting.b.b.h.class);
        com.tencent.mm.ui.chatting.b.b.w wVar = (com.tencent.mm.ui.chatting.b.b.w) this.bAG.O(com.tencent.mm.ui.chatting.b.b.w.class);
        if (hVar.cuS()) {
            if (wVar.cvO()) {
                wVar.cvN();
                hVar.cuT();
            } else {
                hVar.cuQ();
            }
        }
        com.tencent.mm.ui.chatting.b.b.c cVar = (com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class);
        Intent intent;
        if (ab.XO(this.bAG.getTalkerUserName())) {
            intent = new Intent();
            intent.addFlags(67108864);
            d.b(getContext(), "tmessage", ".ui.TConversationUI", intent);
        } else if (getIntExtra("chat_from_scene", 0) == 4) {
            finish();
            return;
        } else if ((getIntExtra("chat_from_scene", 0) == 1 || getIntExtra("chat_from_scene", 0) == 3) && this.bAG.oLT != null && this.bAG.oLT.ckW() && cVar.cuo() != null && cVar.cuo().LZ() && cVar.cuo().bG(false) != null && cVar.cuo().bG(false).MB() != null && !bi.oW(cVar.cuo().Mg())) {
            finish();
            return;
        } else if (((q) this.bAG.O(q.class)).cvD()) {
            finish();
        } else if (!getBooleanExtra("finish_direct", false).booleanValue()) {
            if (this.isCurrentActivity) {
                intent = new Intent(getContext(), LauncherUI.class);
                intent.addFlags(67108864);
                startActivity(intent);
                overridePendingTransition(MMFragmentActivity.a.tnE, MMFragmentActivity.a.tnF);
                finish();
                return;
            }
            finish();
            return;
        }
        finish();
    }

    public void finish() {
        int i = 100;
        if (!hideVKB()) {
            i = 0;
        }
        ah.i(new 8(this), (long) i);
    }

    public final ListView getListView() {
        return this.tMd;
    }
}
