package com.tencent.tencentmap.mapsdk.a;

import com.qq.navi.Session;
import com.qq.sim.Millis100TimeProvider;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

public class bf {
    volatile Session a = new Session();
    private Semaphore b;
    private bb c;
    private String d;
    private be e;
    private by<Integer, ao> f;
    private AtomicBoolean g;

    public bf(be beVar, bb bbVar, by<Integer, ao> byVar) {
        this.e = beVar;
        this.c = bbVar;
        this.d = this.c.a();
        if (beVar.g.d() > 0) {
            this.b = new Semaphore(beVar.g.d());
        }
        this.g = new AtomicBoolean(false);
        this.f = byVar;
    }

    protected void a() {
        b();
        if (this.a.isOpen()) {
            this.e.b(this);
        } else {
            this.e.a(this);
        }
    }

    protected Session b() {
        if (this.a.isOpen()) {
            return this.a;
        }
        if (this.g.compareAndSet(false, true)) {
            this.e.c.a(this.c, this);
            ax.a(this + " getNextEndPoint wait 500");
            synchronized (this.g) {
                try {
                    this.g.wait(500);
                } catch (InterruptedException e) {
                    ax.b(this + " getNextEndPoint wait was Interrupted in " + this);
                }
            }
            return this.a;
        } else if (this.a.isOpen()) {
            return this.a;
        } else {
            ax.a(this + " getNextEndPoint wait 500 for others is connecting");
            synchronized (this.g) {
                try {
                    this.g.wait(500);
                } catch (InterruptedException e2) {
                    ax.b(this + " getNextEndPoint wait was Interrupted in " + this);
                }
            }
            return this.a;
        }
    }

    protected Session a(am amVar) {
        Session b = b();
        if (b != null && b.isOpen()) {
            return b;
        }
        throw new bk(this.c, amVar, b);
    }

    protected void b(am amVar) {
        amVar.e().c(this.c.b);
        amVar.e().a(this.c.b());
        amVar.e().d(d().a());
        lb a = bw.a(this.e.b, amVar.d().e, amVar.d().f, "", this.c.b, this.c.b(), 0, this.e.g.h(), this.e.g.g(), this.e.g.h(), this.c.h());
        ak.a().a(this.e.e);
        ak.a().a(this.e.e, this.c.b, this.e.b, amVar);
        try {
            Session a2 = a(amVar);
            me meVar = new me(0);
            amVar.d().writeTo(meVar);
            az a3 = az.a(true, amVar.e().h(), mg.a(meVar.a()));
            if (amVar.f()) {
                bc.a(amVar.e().h(), amVar.e(), this.f);
            }
            amVar.e().a((long) a2.getID());
            a2.write(a3);
            if (!amVar.f()) {
                a(a, 0, Millis100TimeProvider.INSTANCE.currentTimeMillis() - amVar.e().i(), "sendMsg", true);
            }
        } catch (bk e) {
            a(a, 3, Millis100TimeProvider.INSTANCE.currentTimeMillis() - amVar.e().i(), "sendMsg", true);
            throw e;
        }
    }

    public void c() {
        try {
            ax.a(this + " call close all, try to close conn ");
            if (this.a.isOpen()) {
                this.a.close(true);
            }
        } catch (Throwable e) {
            ax.b(this + " closeAll session error", e);
        }
    }

    public bb d() {
        return this.c;
    }

    public void a(lb lbVar, int i, long j, String str, boolean z) {
        if (!z) {
            ak.a().b(this.e.e).a(lbVar, j, i);
        }
        bg.a(this.e, this.c, i);
    }

    public String toString() {
        return "EndPoint(ID=" + this.a.getID() + " " + this.c + ") ";
    }

    public String e() {
        return this.d;
    }
}
