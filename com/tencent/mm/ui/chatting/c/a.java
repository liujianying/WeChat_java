package com.tencent.mm.ui.chatting.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.bg.d$a;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.chatting.b.b.c;
import com.tencent.mm.ui.chatting.b.u;
import com.tencent.mm.ui.chatting.b.v;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.e.b;

public final class a {
    private static ag tTm = new ag();
    public boolean eaR = false;
    public ab oLT;
    public com.tencent.mm.ui.chatting.e.a tTn = new com.tencent.mm.ui.chatting.e.a(this);
    public b tTo = new b(this);
    public String tTp;
    public e tTq;
    public af tTr;
    public com.tencent.mm.ui.chatting.ag tTs;

    public a(e eVar, af afVar, com.tencent.mm.ui.chatting.ag agVar) {
        this.tTq = eVar;
        this.tTr = afVar;
        this.tTs = agVar;
    }

    public final String getTalkerUserName() {
        if (this.oLT == null) {
            return "";
        }
        return bi.aG(this.oLT.field_username, "");
    }

    public final String cwp() {
        if (this.tTp == null) {
            this.tTp = q.GF();
            this.tTp = ab.gY(getTalkerUserName()) ? ab.XV(this.tTp) : this.tTp;
        }
        return this.tTp;
    }

    public final String cuz() {
        return bi.aG(((c) O(c.class)).cuz(), this.oLT.field_nickname);
    }

    public final View findViewById(int i) {
        return this.tTq.findViewById(i);
    }

    public final boolean cwq() {
        String talkerUserName = getTalkerUserName();
        return ab.gY(talkerUserName) || ab.XQ(talkerUserName) || ab.XO(talkerUserName) || s.hu(talkerUserName);
    }

    public final boolean cwr() {
        return s.fq(getTalkerUserName()) || ((c) O(c.class)).cus();
    }

    public final boolean cws() {
        if (!this.oLT.ckW() && !s.hL(getTalkerUserName()) && !ab.XO(getTalkerUserName())) {
            return true;
        }
        if (((c) O(c.class)).cur()) {
            return true;
        }
        return false;
    }

    public static ag cwt() {
        return tTm;
    }

    public final void startActivity(Intent intent) {
        this.tTq.startActivity(intent);
    }

    public final void a(Intent intent, int i, d$a d_a) {
        this.tTo.a(intent, i, d_a);
    }

    @Deprecated
    public final ListView getListView() {
        return this.tTr.getListView();
    }

    public final void EW(int i) {
        this.tTr.EW(i);
    }

    public final int getFirstVisiblePosition() {
        return this.tTr.getFirstVisiblePosition();
    }

    public final int getLastVisiblePosition() {
        return this.tTr.getLastVisiblePosition();
    }

    public final int getHeaderViewsCount() {
        return this.tTr.getHeaderViewsCount();
    }

    public final View getChildAt(int i) {
        return this.tTr.getChildAt(i);
    }

    public final void d(Context context, String str, OnCancelListener onCancelListener) {
        x.i("MicroMsg.ChattingContext", "[showDialog]");
        this.tTr.c(context, str, onCancelListener);
    }

    public final void dismissDialog() {
        x.i("MicroMsg.ChattingContext", "[dismissDialog]");
        this.tTr.dismissDialog();
    }

    public final void YC() {
        x.i("MicroMsg.ChattingContext", "[hideVKB]");
        this.tTr.hideVKB();
    }

    public final void avj() {
        x.i("MicroMsg.ChattingContext", "[notifyDataSetChange]");
        this.tTr.avj();
    }

    public final void EV(int i) {
        x.i("MicroMsg.ChattingContext", "[setSelection] pos:%s isSmooth:%s", new Object[]{Integer.valueOf(i), Boolean.valueOf(false)});
        this.tTr.EV(i);
    }

    public final void eX(int i, int i2) {
        x.i("MicroMsg.ChattingContext", "[setSelectionFromTop] pos:%s offset:%s isSmooth:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(false)});
        this.tTr.eX(i, i2);
    }

    public final void lT(boolean z) {
        x.i("MicroMsg.ChattingContext", "[scrollToLast] force:%b", new Object[]{Boolean.valueOf(z)});
        this.tTr.lT(z);
    }

    public final void setKeepScreenOn(boolean z) {
        x.i("MicroMsg.ChattingContext", "[setKeepScreenOn] force:%b", new Object[]{Boolean.valueOf(z)});
        this.tTr.setKeepScreenOn(z);
    }

    public final void lZ(boolean z) {
        x.i("MicroMsg.ChattingContext", "[showOptionMenu] menuID:%d show:%s", new Object[]{Integer.valueOf(2), Boolean.valueOf(z)});
        this.tTr.showOptionMenu(2, z);
    }

    public final void showOptionMenu(boolean z) {
        x.i("MicroMsg.ChattingContext", "[showOptionMenu] show:%s", new Object[]{Boolean.valueOf(z)});
        this.tTr.showOptionMenu(z);
    }

    public final void Fh(int i) {
        x.i("MicroMsg.ChattingContext", "[updateOptionMenuIcon] menuID:%d iconID:%s", new Object[]{Integer.valueOf(2), Integer.valueOf(i)});
        this.tTr.updateOptionMenuIcon(2, i);
    }

    public final <T extends u, V extends Class<T>> T O(V v) {
        com.tencent.mm.ui.chatting.e.a aVar = this.tTn;
        if (!v.isInterface()) {
            throw new RuntimeException("[get] " + v + " is not a interface!");
        } else if (aVar.tXO.containsKey(v)) {
            return (u) aVar.tXO.get(v);
        } else {
            x.e("MicroMsg.ChattingComponentManager", "[get] " + v + " is never register! activity:%s", new Object[]{aVar.bAG.tTq.getContext().getClass().getSimpleName()});
            return null;
        }
    }

    public final void a(Class<? extends u> cls, u uVar) {
        com.tencent.mm.ui.chatting.e.a aVar = this.tTn;
        if (aVar.tXO.put(cls, uVar) != null) {
            x.w("MicroMsg.ChattingComponentManager", "[register] %s has register", new Object[]{cls});
        }
        if (uVar instanceof v) {
            long currentTimeMillis = System.currentTimeMillis();
            ((v) uVar).a(aVar.bAG);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            x.i("MicroMsg.ChattingComponentManager", "[install] listener:%s cost:%sms", new Object[]{uVar.getClass().getName(), Long.valueOf(currentTimeMillis2)});
        }
    }
}
