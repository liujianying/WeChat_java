package com.tencent.mm.ui.conversation;

import android.content.res.Configuration;
import android.os.Looper;
import android.os.PowerManager;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.ax.g;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.qt;
import com.tencent.mm.g.a.rh;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.13;
import com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.5;
import com.tencent.mm.ui.conversation.k.2;
import com.tencent.mm.ui.conversation.m.1;
import com.tencent.mm.ui.conversation.m.3;
import com.tencent.mm.ui.conversation.m.4;
import com.tencent.mm.ui.conversation.m.6;
import com.tencent.mm.ui.conversation.m.7;
import com.tencent.mm.ui.conversation.m.9;
import java.io.File;

public class j extends com.tencent.mm.ui.AbstractTabChildActivity.a implements i$a {
    private int[] nYg = new int[2];
    private g unL;
    private a uqM = new a();
    private ConversationWithAppBrandListView uqX;
    private TextView uqY;
    private i uqZ = new i();
    private c ura = new c();
    private m urb = new m();
    private k urc = new k();
    private a urd;

    class a {
        boolean bIq;
        boolean urg;
        boolean urh;

        public a(boolean z, boolean z2, boolean z3) {
            this.bIq = z;
            this.urg = z2;
            this.urh = z3;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.ui.conversation.j r8, int r9) {
        /*
        r7 = 8;
        r0 = 1;
        r1 = 0;
        r2 = "MicroMsg.MainUI";
        r3 = "summerinit setShowView count[%d], stack[%s]";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = java.lang.Integer.valueOf(r9);
        r4[r1] = r5;
        r5 = com.tencent.mm.platformtools.ai.VI();
        r4[r0] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        if (r9 > 0) goto L_0x0065;
    L_0x001e:
        r2 = r8.uqM;
        r3 = r2.context;
        if (r3 == 0) goto L_0x0070;
    L_0x0024:
        r3 = "MicroMsg.BannerHelper";
        r4 = "checkBannerEmpyt %d";
        r5 = new java.lang.Object[r0];
        r6 = r2.hashCode();
        r6 = java.lang.Integer.valueOf(r6);
        r5[r1] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);
        r3 = r2.una;
        r3 = r2.j(r3, r1);
        if (r3 != 0) goto L_0x0070;
    L_0x0041:
        r3 = r2.unb;
        r3 = r2.j(r3, r1);
        if (r3 != 0) goto L_0x0070;
    L_0x0049:
        r3 = r2.unc;
        r3 = r2.j(r3, r1);
        if (r3 != 0) goto L_0x0070;
    L_0x0051:
        r3 = r2.und;
        r2 = r2.j(r3, r1);
        if (r2 != 0) goto L_0x0070;
    L_0x0059:
        if (r0 == 0) goto L_0x0065;
    L_0x005b:
        r0 = r8.uqY;
        r0.setVisibility(r1);
        r0 = r8.uqX;
        r0.setVisibility(r7);
    L_0x0065:
        r0 = r8.uqX;
        r0.setVisibility(r1);
        r0 = r8.uqY;
        r0.setVisibility(r7);
        return;
    L_0x0070:
        r0 = r1;
        goto L_0x0059;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.conversation.j.a(com.tencent.mm.ui.conversation.j, int):void");
    }

    protected int getLayoutId() {
        return R.i.main;
    }

    protected View getLayoutView() {
        return b.EY().a(getContext(), "R.layout.main", R.i.main);
    }

    public boolean supportNavigationSwipeBack() {
        return false;
    }

    public boolean noActionBar() {
        return true;
    }

    public void onResume() {
        int i = 0;
        x.i("MicroMsg.MainUI", "onResume");
        super.onResume();
        if (this.uqX != null) {
            ConversationWithAppBrandListView conversationWithAppBrandListView = this.uqX;
            x.i("MicroMsg.ConversationWithAppBrandListView", "[onResume]");
            conversationWithAppBrandListView.bPd = false;
            if (conversationWithAppBrandListView.uoY != null) {
                conversationWithAppBrandListView.uoY.setLayoutFrozen(false);
            }
            if (conversationWithAppBrandListView.getAdapter() != null) {
                i = conversationWithAppBrandListView.getAdapter().getCount();
            }
            if (conversationWithAppBrandListView.FS(i) > 0.0f) {
                conversationWithAppBrandListView.postDelayed(new 13(conversationWithAppBrandListView), 300);
            }
        }
    }

    public void onPause() {
        x.i("MicroMsg.MainUI", "onPause");
        super.onPause();
        if (this.uqX != null) {
            ConversationWithAppBrandListView conversationWithAppBrandListView = this.uqX;
            x.i("MicroMsg.ConversationWithAppBrandListView", "[onPause]");
            conversationWithAppBrandListView.bPd = true;
        }
    }

    public final void i(boolean z, boolean z2, boolean z3) {
        if (this.uqX instanceof ConversationWithAppBrandListView) {
            ConversationWithAppBrandListView conversationWithAppBrandListView = this.uqX;
            if (conversationWithAppBrandListView.mr(false)) {
                x.i("MicroMsg.ConversationWithAppBrandListView", "[showAppBrandHeader] isShow:%s isScrollFirst:%s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z3)});
                conversationWithAppBrandListView.mn(true);
                if (conversationWithAppBrandListView.uoX != null && !z) {
                    conversationWithAppBrandListView.uoX.setVisibility(8);
                } else if (!(conversationWithAppBrandListView.uoX == null || conversationWithAppBrandListView.uoY == null || conversationWithAppBrandListView.uoY.getAdapter().getItemCount() <= 1)) {
                    conversationWithAppBrandListView.uoX.setVisibility(0);
                    if (z3) {
                        conversationWithAppBrandListView.uoY.smoothScrollToPosition(0);
                    }
                }
                conversationWithAppBrandListView.post(new 5(conversationWithAppBrandListView, z2));
                return;
            }
            x.w("MicroMsg.ConversationWithAppBrandListView", "[showAppBrandHeader] AppBrandHeader is disable! ");
            return;
        }
        this.urd = new a(z, z2, z3);
    }

    public final void cxZ() {
        if (this.unL != null) {
            this.unL.cxZ();
        }
    }

    public final void B(long j, int i) {
        if (this.uqX != null) {
            this.uqX.B(j, i);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.uqM.cyF();
    }

    protected final void coy() {
        a aVar;
        x.i("MicroMsg.MainUI", "onTabCreate, %d", new Object[]{Integer.valueOf(hashCode())});
        if (this.mController != null) {
            this.mController.ak(4, false);
        }
        x.i("MicroMsg.MainUI", "mainUIOnCreate");
        long currentTimeMillis = System.currentTimeMillis();
        setMenuVisibility(true);
        au.Em().cik();
        x.i("MicroMsg.MainUI", "main ui init view");
        if (this.uqX != null) {
            aVar = this.uqM;
            if (aVar.unh != null) {
                aVar.dX(aVar.una);
                aVar.dX(aVar.unb);
                aVar.dX(aVar.unc);
                aVar.dX(aVar.und);
                for (com.tencent.mm.pluginsdk.ui.b.b bVar : aVar.une) {
                    if (!(bVar == null || bVar.getView() == null)) {
                        aVar.unh.removeFooterView(bVar.getView());
                    }
                }
            }
        }
        this.uqY = (TextView) findViewById(R.h.empty_conversation_tv);
        this.uqX = (ConversationWithAppBrandListView) findViewById(R.h.main_chatting_lv);
        this.uqX.setDrawingCacheEnabled(false);
        this.uqX.setScrollingCacheEnabled(false);
        this.unL = new g(getContext(), new 3(this));
        this.unL.setGetViewPositionCallback(new 4(this));
        this.unL.setPerformItemClickListener(new 5(this));
        if (d.fT(18)) {
            com.tencent.mm.blink.b.xi().g(new Runnable() {
                public final void run() {
                    j.this.uqM.a(j.this.getContext(), j.this.uqX, j.this.uqY);
                }
            });
        } else {
            this.uqM.a(getContext(), this.uqX, this.uqY);
        }
        k kVar = this.urc;
        ConversationWithAppBrandListView conversationWithAppBrandListView = this.uqX;
        g gVar = this.unL;
        kVar.unh = conversationWithAppBrandListView;
        kVar.unL = gVar;
        conversationWithAppBrandListView.setOnScrollListener(kVar.hLH);
        gVar.unW = kVar.hLH;
        ah.A(new 2(kVar));
        this.ura.Z(getActivity());
        this.uqX.setAdapter(this.unL);
        this.uqX.setOnItemClickListener(new e(this.unL, this.uqX, getActivity()));
        this.uqX.setOnItemLongClickListener(new f(this.unL, this.uqX, getActivity(), this.nYg));
        this.uqX.setOnTouchListener(new 7(this));
        if (this.urd != null) {
            i(this.urd.bIq, this.urd.urg, this.urd.urh);
        }
        this.uqX.setSelection(0);
        i iVar = this.uqZ;
        FragmentActivity activity = getActivity();
        aVar = this.uqM;
        iVar.bOb = activity;
        iVar.uqM = aVar;
        iVar.uqN = this;
        iVar.wakeLock = ((PowerManager) activity.getSystemService("power")).newWakeLock(26, "NetSceneInit Lock");
        au.DF().a(-1, iVar);
        iVar.uqJ = false;
        com.tencent.mm.sdk.b.a.sFg.b(iVar.uqO);
        com.tencent.mm.sdk.b.a.sFg.b(iVar.uqP);
        File file = new File(ad.getContext().getFilesDir(), "DBRecoverStarted");
        if (file.exists()) {
            f.mDy.c("DBRepair", "Last recovery interrupted.", null);
            file.delete();
        }
        iVar.uqQ = new FLock(new File(ad.getContext().getFilesDir(), "MMStarted"));
        if (iVar.uqQ.chz()) {
            iVar.uqQ.unlock();
            x.i("MicroMsg.DuplicateDetect", "No data multiple instance detected.");
        } else {
            x.w("MicroMsg.DuplicateDetect", "Data multiple instance detected.");
            f.mDy.a(579, 0, 1, true);
        }
        iVar.uqQ.chy();
        c cVar = this.ura;
        g gVar2 = this.unL;
        ConversationWithAppBrandListView conversationWithAppBrandListView2 = this.uqX;
        FragmentActivity activity2 = getActivity();
        cVar.unL = gVar2;
        cVar.unh = conversationWithAppBrandListView2;
        cVar.activity = activity2;
        com.tencent.mm.sdk.b.a.sFg.b(cVar.unO);
        com.tencent.mm.sdk.b.a.sFg.b(cVar.unM);
        com.tencent.mm.sdk.b.a.sFg.b(cVar.unN);
        m mVar = this.urb;
        gVar2 = this.unL;
        conversationWithAppBrandListView2 = this.uqX;
        activity2 = getActivity();
        mVar.unL = gVar2;
        mVar.bOb = activity2;
        mVar.uqX = conversationWithAppBrandListView2;
        if (mVar.ifd == null) {
            mVar.ifd = new 3(mVar, new 1(mVar));
        }
        if (mVar.uru == null) {
            mVar.uru = new 4(mVar);
        }
        if (mVar.urv == null) {
            mVar.urv = new m.5(mVar, conversationWithAppBrandListView2);
        }
        com.tencent.mm.sdk.b.a.sFg.b(mVar.ifd);
        com.tencent.mm.sdk.b.a.sFg.b(mVar.uru);
        com.tencent.mm.sdk.b.a.sFg.b(mVar.urv);
        mVar.tjO = new 6(mVar);
        Looper.myQueue().addIdleHandler(mVar.tjO);
        conversationWithAppBrandListView2.post(new 7(mVar));
        com.tencent.mm.ak.b Ph = o.Ph();
        int i = R.g.chat_img_template;
        x.d("MicroMsg.AutoGetBigImgLogic", "chattingMaskResId change from " + Ph.dTi + " to " + i);
        Ph.dTi = i;
        o.Ph().start();
        au.HP();
        au.HU();
        c.FW().a(this.unL);
        au.HU();
        c.FR().a(this.unL);
        g gVar3 = this.unL;
        if (gVar3.uoc == null) {
            gVar3.uoc = new g.2(gVar3);
        }
        com.tencent.mm.sdk.b.a.sFg.b(gVar3.uoc);
        this.unL.upL = new 1(this);
        r2 = new Object[3];
        au.HU();
        r2[1] = Integer.valueOf(c.Df());
        r2[2] = Integer.valueOf(com.tencent.mm.protocal.d.qVN);
        x.i("MicroMsg.MainUI", "kevin mainUIOnCreate time:%d uin:%d ver:%x", r2);
        this.uqX.postDelayed(new 8(this), 200);
    }

    public final void cyZ() {
        if (this.unL != null) {
            this.unL.onResume();
        }
    }

    public final void cza() {
        if (this.unL != null) {
            this.unL.onPause();
        }
    }

    protected final void coz() {
        x.i("MicroMsg.MainUI", "onTabResume");
        long VF = ai.VF();
        c cVar = this.ura;
        if (cVar.unK < 0) {
            x.d("MicroMsg.ConvUnreadHelper", "onTabResume totalUnReadCount %d", new Object[]{Integer.valueOf(cVar.unK)});
            if (cVar.unL != null) {
                cVar.unL.cyP();
            }
        }
        cyZ();
        com.tencent.mm.blink.b.xi().g(new 9(this));
        x.d("MicroMsg.MainUI", "start time check dkinit KEVIN mainui TestTimeLayoutTime onTabResume:%d", new Object[]{Long.valueOf(ai.bH(VF))});
        m mVar = this.urb;
        if (g.elf != null) {
            g.elf.a(mVar);
        }
        ah.A(new m$8(mVar));
        l.gS(mVar.bOb);
        if (!(mVar.bOb == null || mVar.bOb.getIntent() == null || !mVar.bOb.getIntent().getBooleanExtra("resend_fail_messages", false))) {
            ah.i(new 9(mVar), 500);
            mVar.bOb.getIntent().putExtra("resend_fail_messages", false);
        }
        LauncherUI launcherUI = (LauncherUI) mVar.bOb;
        if (launcherUI != null) {
            launcherUI.tkn.setTitleBarDoubleClickListener(mVar.uhD);
        }
        if (s.a(mVar.bOb.getIntent(), "Main_ListToTop", false) && mVar.uqX != null) {
            mVar.uqX.post(new m.2(mVar));
        }
        s.b(mVar.bOb.getIntent(), "Main_ListToTop", false);
        i iVar = this.uqZ;
        String str = "MicroMsg.InitHelper";
        String str2 = "onTabResume tip:%d initscene:%d";
        Object[] objArr = new Object[2];
        int i = iVar.eHw == null ? -1 : iVar.eHw.isShowing() ? 1 : 0;
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(iVar.cyV());
        x.i(str, str2, objArr);
        iVar.cyU();
        ah.i(new i$6(iVar), 100);
        if (au.HX() && !this.uqZ.cyW()) {
            com.tencent.mm.sdk.b.a.sFg.a(new rh(), Looper.getMainLooper());
            qt qtVar = new qt();
            qtVar.cbp.action = 4;
            com.tencent.mm.sdk.b.a.sFg.a(qtVar, Looper.getMainLooper());
        }
    }

    protected final void coA() {
        x.i("MicroMsg.MainUI", "onTabStart");
    }

    protected final void coB() {
        x.i("MicroMsg.MainUI", "onTabPause");
        com.tencent.mm.blink.b.xi().g(new 10(this));
        i iVar = this.uqZ;
        if (iVar.wakeLock.isHeld()) {
            x.w("MicroMsg.InitHelper", "onTabPause wakelock.release!");
            iVar.wakeLock.release();
        }
        hideVKB();
        m mVar = this.urb;
        if (g.elf != null) {
            g.elf.b(mVar);
        }
        l.czc();
        LauncherUI launcherUI = (LauncherUI) mVar.bOb;
        if (launcherUI != null) {
            launcherUI.tkn.ac(mVar.uhD);
        }
        cza();
    }

    protected final void coC() {
        x.i("MicroMsg.MainUI", "onTabStop");
    }

    protected final void coD() {
        x.i("MicroMsg.MainUI", "onTabDestroy  acc:%b", new Object[]{Boolean.valueOf(au.HX())});
        com.tencent.mm.blink.b.xi().g(new 2(this));
        i iVar = this.uqZ;
        iVar.uqQ.unlock();
        au.DF().b(-1, iVar);
        if (iVar.eHw != null) {
            iVar.eHw.dismiss();
            iVar.eHw = null;
        }
        com.tencent.mm.sdk.b.a.sFg.c(iVar.uqO);
        com.tencent.mm.sdk.b.a.sFg.c(iVar.uqP);
        m mVar = this.urb;
        if (mVar.ifd != null) {
            com.tencent.mm.sdk.b.a.sFg.c(mVar.ifd);
            mVar.ifd = null;
        }
        com.tencent.mm.sdk.b.a.sFg.c(mVar.uru);
        com.tencent.mm.sdk.b.a.sFg.c(mVar.urv);
        if (g.elf != null) {
            g.elf.b(mVar);
        }
        if (au.HX()) {
            ai.VH();
        }
        c cVar = this.ura;
        com.tencent.mm.sdk.b.a.sFg.c(cVar.unO);
        com.tencent.mm.sdk.b.a.sFg.c(cVar.unM);
        com.tencent.mm.sdk.b.a.sFg.c(cVar.unN);
        cVar.activity = null;
        if (au.HX() && this.unL != null) {
            au.HU();
            c.FW().b(this.unL);
            au.HU();
            c.FR().b(this.unL);
        }
        if (this.unL != null) {
            g gVar = this.unL;
            if (gVar.uoc != null) {
                com.tencent.mm.sdk.b.a.sFg.c(gVar.uoc);
                gVar.uoc = null;
            }
            this.unL.upL = null;
            gVar = this.unL;
            gVar.upL = null;
            if (gVar.tEl != null) {
                gVar.tEl.clear();
                gVar.tEl = null;
            }
            gVar.lv(true);
            gVar.coT();
            gVar.upO.clear();
            x.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
        }
    }

    public final void coF() {
        x.i("MicroMsg.MainUI", "turn to bg");
    }

    public final void coG() {
        x.i("MicroMsg.MainUI", "turn to fg");
    }

    public final void coE() {
        if (this.uqX != null) {
            this.uqX.coE();
        }
    }

    public final void cpr() {
        x.i("MicroMsg.MainUI", "dkinit onTabSwitchIn");
        i iVar = this.uqZ;
        String str = "MicroMsg.InitHelper";
        String str2 = "onTabSwitchIn tip:%d initscene:%d";
        Object[] objArr = new Object[2];
        int i = iVar.eHw == null ? -1 : iVar.eHw.isShowing() ? 1 : 0;
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(iVar.cyV());
        x.i(str, str2, objArr);
        if (iVar.wakeLock != null) {
            iVar.cyU();
        }
        if (this.mController != null) {
            this.mController.onResume();
        }
    }

    public final void cps() {
        x.i("MicroMsg.MainUI", "onTabSwitchOut");
        B(0, 8);
    }

    public void onDestroy() {
        x.i("MicroMsg.MainUI", "onDestroy");
        this.urc.czb();
        if (this.uqX != null) {
            ConversationWithAppBrandListView conversationWithAppBrandListView = this.uqX;
            if (conversationWithAppBrandListView.uoY != null) {
                conversationWithAppBrandListView.uoY.release();
            }
            conversationWithAppBrandListView.uph.dead();
        }
        super.onDestroy();
    }

    public final void cyX() {
        if (this.unL != null) {
            this.unL.kGt = true;
        }
    }

    public final void cyY() {
        if (this.unL != null) {
            this.unL.kGt = false;
            this.unL.cyP();
            if (thisActivity() != null) {
                this.ura.Z(getActivity());
            }
        }
    }
}
