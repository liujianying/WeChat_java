package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import com.tencent.mm.bg.d;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.appbrand.jsapi.p.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.chatting.b.b.f;
import com.tencent.mm.ui.chatting.b.b.j;
import com.tencent.mm.ui.chatting.b.g;
import com.tencent.mm.ui.chatting.b.h;
import com.tencent.mm.ui.chatting.b.l;
import com.tencent.mm.ui.chatting.b.v;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.x;
import java.util.Map.Entry;

public abstract class e extends x implements af, ag {
    public a bAG = new a(this, this, this);
    public boolean tHA = false;
    private int tHB = 0;
    int tHC;
    int tHD;
    protected String tHw;
    protected String tHx;
    private h tHy = new h();
    l tHz = new l();

    public abstract t csU();

    public abstract boolean csV();

    public abstract ListView getListView();

    public e() {
        csS();
    }

    public e(byte b) {
        super(true);
        csS();
    }

    private void csS() {
        Bundle bundle = new Bundle();
        if (!bundle.containsKey(getClass().getName())) {
            bundle.putInt(getClass().getName(), Integer.MAX_VALUE);
        }
        setArguments(bundle);
    }

    public final void onAttach(Context context) {
        super.onAttach(context);
        this.tHw = getActivity().getClass().getName() + "@" + hashCode() + " @talker:%s";
        gK(context);
        this.bAG.a(f.class, this.tHy);
        this.bAG.a(j.class, this.tHz);
        for (g.a aVar : g.cuN()) {
            this.bAG.a(aVar.Yw, aVar.cuO());
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        LayoutParams layoutParams = onCreateView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -1);
        }
        onCreateView.setLayoutParams(layoutParams);
        return onCreateView;
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        csH();
        if (this.isCurrentActivity || this.tHA) {
            cpM();
        }
    }

    public final void onStart() {
        super.onStart();
        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStart] activity:%s isForeground:%s isFinishing:%s", new Object[]{this.tHx, Boolean.valueOf(this.bAG.eaR), Boolean.valueOf(isFinishing())});
        if (this.bAG.eaR) {
            d(4, new 3(this));
        }
    }

    public final void onResume() {
        super.onResume();
        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.BaseChattingUIFragment.Sys", "[onResume] activity:%s isForeground:%s isFinishing:%s", new Object[]{this.tHx, Boolean.valueOf(this.bAG.eaR), Boolean.valueOf(isFinishing())});
        if (this.bAG.eaR) {
            csI();
            if (this.isCurrentActivity || this.tHA) {
                cpN();
            }
        }
    }

    public final void onPause() {
        int i = 1;
        super.onPause();
        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.BaseChattingUIFragment.Sys", "[onPause] activity:%s isForeground:%s isFinishing:%s", new Object[]{this.tHx, Boolean.valueOf(this.bAG.eaR), Boolean.valueOf(isFinishing())});
        if (this.bAG.eaR || isFinishing()) {
            if (EH(8) && !isFinishing()) {
                if (!EH(1024) || EH(512)) {
                    i = 0;
                }
                if (i == 0) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.BaseChattingUIFragment", "[onPause] is never doResume before doPause! Because while entering ChattingUI, the app back to background.");
                    csI();
                    cpN();
                }
            }
            csK();
        }
    }

    public final void onStop() {
        super.onStop();
        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStop] activity:%s isForeground:%s isFinishing:%s", new Object[]{this.tHx, Boolean.valueOf(this.bAG.eaR), Boolean.valueOf(isFinishing())});
        if (this.bAG.eaR || isFinishing()) {
            if (EH(16)) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStop] activity:%s is never pause when stop coming!", new Object[]{this.tHx});
                csK();
            }
            d(32, new 6(this));
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.BaseChattingUIFragment.Sys", "[onDestroy] activity:%s isForeground:%s isFinishing:%s", new Object[]{this.tHx, Boolean.valueOf(this.bAG.eaR), Boolean.valueOf(isFinishing())});
        bw();
        cpO();
        cpP();
    }

    public final void onDetach() {
        super.onDetach();
        csT();
    }

    protected void gK(Context context) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BaseChattingUIFragment", "[doAttach] activity:%s isPreLoaded:%b", new Object[]{this.tHx, Boolean.valueOf(this.tHA)});
    }

    public void csH() {
        d(2, new 1(this));
    }

    public void csI() {
        d(8, new 4(this));
    }

    public void csK() {
        d(16, new 5(this));
    }

    public void bw() {
        d(64, new 7(this));
    }

    public void csT() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BaseChattingUIFragment", "[doDetach] activity:%s isPreLoaded:%b", new Object[]{this.tHx, Boolean.valueOf(this.tHA)});
        for (Entry entry : this.bAG.tTn.tXO.entrySet()) {
            if (entry.getValue() instanceof v) {
                ((v) entry.getValue()).cun();
            }
        }
    }

    public void cpM() {
        d(128, new Runnable() {
            public final void run() {
                int i = 0;
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BaseChattingUIFragment", "[onEnterBegin] activity:%s isPreLoaded:%b", new Object[]{e.this.tHx, Boolean.valueOf(e.this.tHA)});
                e eVar = e.this;
                boolean z = HardCoderJNI.hcEnterChattingEnable;
                int i2 = HardCoderJNI.hcEnterChattingDelay;
                int i3 = HardCoderJNI.hcEnterChattingCPU;
                int i4 = HardCoderJNI.hcEnterChattingIO;
                if (HardCoderJNI.hcEnterChattingThr) {
                    i = com.tencent.mm.kernel.g.Em().cij();
                }
                eVar.tHC = HardCoderJNI.startPerformance(z, i2, i3, i4, i, HardCoderJNI.hcEnterChattingTimeout, b.CTRL_INDEX, HardCoderJNI.hcEnterChattingAction, "ChattingUIFragment");
                e.this.bAG.eaR = true;
                e.this.tHy.cpG();
            }
        });
    }

    public void cpN() {
        d(256, new 9(this));
    }

    public void cpO() {
        d(512, new 10(this));
    }

    public void cpP() {
        d(1024, new 2(this));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.BaseChattingUIFragment";
        String str2 = "onActivityResult return, requestCode:%d resultCode:%s data is null? %s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        com.tencent.mm.sdk.platformtools.x.i(str, str2, objArr);
        if (this.bAG.eaR) {
            Fragment cxF = this.bAG.tTo.cxF();
            if (cxF != null) {
                d.a b = com.tencent.mm.ui.chatting.e.b.b(cxF, i);
                if (b != null) {
                    b.onActivityResult(i, i2, intent);
                }
            }
            this.tHz.onActivityResult(i, i2, intent);
            return;
        }
        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.BaseChattingUIFragment", "[onActivityResult] not foreground, return, requestCode:%d", new Object[]{Integer.valueOf(i)});
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.tHz.onKeyDown(i, keyEvent);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.tHz.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.bAG.eaR) {
            this.tHz.onConfigurationChanged(configuration);
        }
    }

    protected void W(ab abVar) {
        this.tHx = String.format(this.tHw, new Object[]{abVar.field_username});
        this.bAG.oLT = abVar;
    }

    public final void addHeaderView(View view) {
        getListView().addHeaderView(view);
    }

    public int getFirstVisiblePosition() {
        return getListView().getFirstVisiblePosition();
    }

    public final int getHeaderViewsCount() {
        return getListView().getHeaderViewsCount();
    }

    public final int getLastVisiblePosition() {
        return getListView().getLastVisiblePosition();
    }

    public final View getChildAt(int i) {
        return getListView().getChildAt(i);
    }

    public boolean supportNavigationSwipeBack() {
        if (this.isCurrentActivity) {
            return false;
        }
        com.tencent.mm.kernel.g.Ek();
        if (!com.tencent.mm.compatible.f.b.bt(((com.tencent.mm.kernel.b.h) com.tencent.mm.kernel.g.Ef().DM()).dsQ)) {
            return true;
        }
        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.BaseChattingUIFragment", "Running on a Chromebook, so we not support swipeback and so on");
        return false;
    }

    public String getIdentityString() {
        ab abVar = this.bAG.oLT;
        if (abVar == null || ((int) abVar.dhP) == 0 || bi.oW(abVar.field_username)) {
            return "";
        }
        if (com.tencent.mm.kernel.g.Eg().Dx()) {
            if (com.tencent.mm.ac.f.eZ(abVar.field_username)) {
                return "_EnterpriseChat";
            }
            if (com.tencent.mm.ac.f.kM(abVar.field_username)) {
                return "_EnterpriseFatherBiz";
            }
            if (com.tencent.mm.ac.f.kL(abVar.field_username)) {
                return "_EnterpriseChildBiz";
            }
        }
        if (abVar.ckW()) {
            return "_bizContact";
        }
        if (s.fq(abVar.field_username)) {
            return "_chatroom";
        }
        if (s.gY(abVar.field_username)) {
            return "_bottle";
        }
        if (s.gZ(abVar.field_username)) {
            return "_QQ";
        }
        return "";
    }

    public final boolean EH(int i) {
        return (this.tHB & i) == 0;
    }

    private void EI(int i) {
        this.tHB &= i ^ -1;
    }

    private void d(int i, Runnable runnable) {
        boolean z = (4 == i && EH(2)) ? false : (8 == i && EH(4)) ? false : (16 == i && EH(8)) ? false : (32 == i && EH(4)) ? false : (64 == i && EH(2)) ? false : (512 == i && EH(256)) ? false : true;
        if (EH(i) && z) {
            this.tHB |= i;
            if (2 == i) {
                EI(64);
            } else if (64 == i) {
                EI(2);
            } else if (4 == i) {
                EI(32);
            } else if (32 == i) {
                EI(4);
            } else if (8 == i) {
                EI(16);
            } else if (16 == i) {
                EI(8);
            } else if (128 == i) {
                EI(256);
            } else if (256 == i) {
                EI(128);
            } else if (512 == i) {
                EI(1024);
            } else if (1024 == i) {
                EI(512);
            }
            runnable.run();
            return;
        }
        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.BaseChattingUIFragment", "catch! [check] %s flag:%x isNever:%s isStrict:%s", new Object[]{this.tHx, Integer.valueOf(i), Boolean.valueOf(r2), Boolean.valueOf(z)});
    }
}
