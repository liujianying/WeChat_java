package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.b.b.f;
import com.tencent.mm.ui.m;
import java.util.HashSet;
import java.util.Iterator;

public final class h implements f, m {
    private HashSet<m> tOO = new HashSet();

    public final void a(m mVar) {
        if (!this.tOO.contains(mVar)) {
            this.tOO.add(mVar);
        }
    }

    public final void b(m mVar) {
        this.tOO.remove(mVar);
    }

    public final void cpF() {
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = new HashSet(this.tOO).iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            mVar.cpF();
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
            x.v("MicroMsg.ChattingLifecycleObserver", "[onChattingInit] listener:%s cost:%sms", new Object[]{mVar.getClass().getSimpleName(), Long.valueOf(currentTimeMillis2)});
        }
        x.i("MicroMsg.ChattingLifecycleObserver", "[onChattingInit]cost:%sms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public final void cpG() {
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = new HashSet(this.tOO).iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            mVar.cpG();
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
            x.v("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimStart] listener:%s cost:%sms", new Object[]{mVar.getClass().getSimpleName(), Long.valueOf(currentTimeMillis2)});
        }
        x.i("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimStart]cost:%sms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public final void cpH() {
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = new HashSet(this.tOO).iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            mVar.cpH();
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
            x.v("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimEnd] listener:%s cost:%sms", new Object[]{mVar.getClass().getSimpleName(), Long.valueOf(currentTimeMillis2)});
        }
        x.i("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimEnd]cost:%sms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public final void cpI() {
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = new HashSet(this.tOO).iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            mVar.cpI();
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
            x.v("MicroMsg.ChattingLifecycleObserver", "[onChattingResume] listener:%s cost:%sms", new Object[]{mVar.getClass().getSimpleName(), Long.valueOf(currentTimeMillis2)});
        }
        x.i("MicroMsg.ChattingLifecycleObserver", "[onChattingResume]cost:%sms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public final void cpJ() {
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = new HashSet(this.tOO).iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            mVar.cpJ();
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
            x.v("MicroMsg.ChattingLifecycleObserver", "[onChattingPause] listener:%s cost:%sms", new Object[]{mVar.getClass().getSimpleName(), Long.valueOf(currentTimeMillis2)});
        }
        x.i("MicroMsg.ChattingLifecycleObserver", "[onChattingPause]cost:%sms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public final void cpK() {
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = new HashSet(this.tOO).iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            mVar.cpK();
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
            x.v("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimStart] listener:%s cost:%sms", new Object[]{mVar.getClass().getSimpleName(), Long.valueOf(currentTimeMillis2)});
        }
        x.i("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimStart]cost:%sms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public final void cpL() {
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = new HashSet(this.tOO).iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            mVar.cpL();
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
            x.v("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimEnd] listener:%s cost:%sms", new Object[]{mVar.getClass().getSimpleName(), Long.valueOf(currentTimeMillis2)});
        }
        x.i("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimEnd]cost:%sms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }
}
