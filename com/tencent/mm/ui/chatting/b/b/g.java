package com.tencent.mm.ui.chatting.b.b;

import android.view.View.OnClickListener;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.pluginsdk.model.app.j.a;
import com.tencent.mm.pluginsdk.ui.chat.l;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.u;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.t.e;
import java.util.Set;

public interface g extends a, u {
    int EP(int i);

    void EQ(int i);

    void ER(int i);

    bd ES(int i);

    void a(long j, bd bdVar, boolean z);

    void aMw();

    int boX();

    void c(OnClickListener onClickListener);

    long ctC();

    void ctD();

    void ctE();

    f.a ctF();

    void ctG();

    int ctH();

    int ctI();

    boolean ctK();

    Set<Long> ctL();

    void ctM();

    void ctO();

    void ctP();

    s.a ctQ();

    c ctR();

    e ctv();

    t.f ctw();

    com.tencent.mm.ui.chatting.s.a ctx();

    l cty();

    com.tencent.mm.ui.chatting.c ctz();

    int getCount();

    boolean gt(long j);

    void i(long j, int i, int i2);

    boolean isInEditMode();

    void lS(boolean z);

    int t(long j, boolean z);

    void u(long j, boolean z);

    void unlock();
}
