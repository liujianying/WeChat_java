package com.tencent.mm.sdk.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;

class d$c extends Handler {
    private static final Object sKe = new Object();
    private boolean gqQ;
    private d sJS;
    private boolean sKd;
    private Message sKf;
    private d$b sKg;
    private boolean sKh;
    private c[] sKi;
    private int sKj;
    private c[] sKk;
    private int sKl;
    private a sKm;
    private b sKn;
    private HashMap<c, c> sKo;
    private c sKp;
    private c sKq;
    private ArrayList<Message> sKr;

    /* synthetic */ d$c(Looper looper, d dVar, byte b) {
        this(looper, dVar);
    }

    static /* synthetic */ void b(d$c d_c, c cVar) {
        if (d_c.sKd) {
            new StringBuilder("setInitialState: initialState=").append(cVar.getName());
        }
        d_c.sKp = cVar;
    }

    static /* synthetic */ void f(d$c d_c) {
        c cVar;
        int i = 0;
        for (c cVar2 : d_c.sKo.values()) {
            int i2 = 0;
            while (cVar2 != null) {
                cVar2 = cVar2.sKu;
                i2++;
            }
            i = i < i2 ? i2 : i;
        }
        d_c.sKi = new c[i];
        d_c.sKk = new c[i];
        if (d_c.sKd) {
            new StringBuilder("setupInitialStateStack: E mInitialState=").append(d_c.sKp.getName());
        }
        cVar2 = (c) d_c.sKo.get(d_c.sKp);
        d_c.sKl = 0;
        while (cVar2 != null) {
            d_c.sKk[d_c.sKl] = cVar2;
            cVar2 = cVar2.sKu;
            d_c.sKl++;
        }
        d_c.sKj = -1;
        d_c.cjq();
        d_c.sendMessageAtFrontOfQueue(d_c.obtainMessage(-2, sKe));
    }

    public final void handleMessage(Message message) {
        if (!this.gqQ) {
            if (this.sKd) {
                new StringBuilder("handleMessage: E msg.what=").append(message.what);
            }
            this.sKf = message;
            c cVar = null;
            if (this.sKh) {
                cVar = r(message);
            } else if (!this.sKh && this.sKf.what == -2 && this.sKf.obj == sKe) {
                this.sKh = true;
                Df(0);
            } else {
                throw new RuntimeException("StateMachine.handleMessage: The start method not called, received msg: " + message);
            }
            a(cVar, message);
        }
    }

    private void a(c cVar, Message message) {
        b bVar;
        c cVar2 = this.sKi[this.sKj].sKt;
        boolean z = this.sJS.h(this.sKf) && message.obj != sKe;
        if (this.sKg.cjo()) {
            if (this.sKq != null) {
                this.sKg.b(this.sJS, this.sKf, "", cVar, cVar2, this.sKq);
            }
        } else if (z) {
            this.sKg.b(this.sJS, this.sKf, "", cVar, cVar2, this.sKq);
        }
        c cVar3 = this.sKq;
        if (cVar3 != null) {
            while (true) {
                bVar = cVar3;
                this.sKl = 0;
                c cVar4 = (c) this.sKo.get(bVar);
                do {
                    c[] cVarArr = this.sKk;
                    int i = this.sKl;
                    this.sKl = i + 1;
                    cVarArr[i] = cVar4;
                    cVar4 = cVar4.sKu;
                    if (cVar4 == null) {
                        break;
                    }
                } while (!cVar4.ahg);
                if (this.sKd) {
                    new StringBuilder("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=").append(this.sKl).append(",curStateInfo: ").append(cVar4);
                }
                a(cVar4);
                Df(cjq());
                cjp();
                if (bVar == this.sKq) {
                    break;
                }
                cVar3 = this.sKq;
            }
            this.sKq = null;
        } else {
            bVar = cVar3;
        }
        if (bVar != null && bVar == this.sKn) {
            this.sJS.abD();
            if (this.sJS.sJR != null) {
                getLooper().quit();
                this.sJS.sJR = null;
            }
            this.sJS.sJQ = null;
            this.sJS = null;
            this.sKf = null;
            this.sKg.cleanup();
            this.sKi = null;
            this.sKk = null;
            this.sKo.clear();
            this.sKp = null;
            this.sKq = null;
            this.sKr.clear();
            this.gqQ = true;
        }
    }

    private final c r(Message message) {
        c cVar = this.sKi[this.sKj];
        if (this.sKd) {
            new StringBuilder("processMsg: ").append(cVar.sKt.getName());
        }
        Object obj = (message.what == -1 && message.obj == sKe) ? 1 : null;
        if (obj != null) {
            b(this.sKn);
        } else {
            while (!cVar.sKt.j(message)) {
                cVar = cVar.sKu;
                if (cVar == null) {
                    this.sJS.i(message);
                    break;
                } else if (this.sKd) {
                    new StringBuilder("processMsg: ").append(cVar.sKt.getName());
                }
            }
        }
        if (cVar != null) {
            return cVar.sKt;
        }
        return null;
    }

    private final void a(c cVar) {
        while (this.sKj >= 0 && this.sKi[this.sKj] != cVar) {
            c cVar2 = this.sKi[this.sKj].sKt;
            if (this.sKd) {
                new StringBuilder("invokeExitMethods: ").append(cVar2.getName());
            }
            cVar2.exit();
            this.sKi[this.sKj].ahg = false;
            this.sKj--;
        }
    }

    private final void Df(int i) {
        while (i <= this.sKj) {
            if (this.sKd) {
                new StringBuilder("invokeEnterMethods: ").append(this.sKi[i].sKt.getName());
            }
            this.sKi[i].sKt.enter();
            this.sKi[i].ahg = true;
            i++;
        }
    }

    private final void cjp() {
        for (int size = this.sKr.size() - 1; size >= 0; size--) {
            Message message = (Message) this.sKr.get(size);
            if (this.sKd) {
                new StringBuilder("moveDeferredMessageAtFrontOfQueue; what=").append(message.what);
            }
            sendMessageAtFrontOfQueue(message);
        }
        this.sKr.clear();
    }

    private final int cjq() {
        int i = this.sKj + 1;
        int i2 = i;
        for (int i3 = this.sKl - 1; i3 >= 0; i3--) {
            if (this.sKd) {
                new StringBuilder("moveTempStackToStateStack: i=").append(i3).append(",j=").append(i2);
            }
            this.sKi[i2] = this.sKk[i3];
            i2++;
        }
        this.sKj = i2 - 1;
        if (this.sKd) {
            new StringBuilder("moveTempStackToStateStack: X mStateStackTop=").append(this.sKj).append(",startingIndex=").append(i).append(",Top=").append(this.sKi[this.sKj].sKt.getName());
        }
        return i;
    }

    private final c c(c cVar) {
        if (this.sKd) {
            new StringBuilder("addStateInternal: E state=").append(cVar.getName()).append(",parent=");
        }
        c cVar2 = (c) this.sKo.get(cVar);
        if (cVar2 == null) {
            cVar2 = new c(this, (byte) 0);
            this.sKo.put(cVar, cVar2);
        }
        if (cVar2.sKu == null || cVar2.sKu == null) {
            cVar2.sKt = cVar;
            cVar2.sKu = null;
            cVar2.ahg = false;
            if (this.sKd) {
                new StringBuilder("addStateInternal: X stateInfo: ").append(cVar2);
            }
            return cVar2;
        }
        throw new RuntimeException("state already added");
    }

    private d$c(Looper looper, d dVar) {
        super(looper);
        this.gqQ = false;
        this.sKd = false;
        this.sKg = new d$b();
        this.sKj = -1;
        this.sKm = new a(this, (byte) 0);
        this.sKn = new b(this, (byte) 0);
        this.sKo = new HashMap();
        this.sKr = new ArrayList();
        this.sJS = dVar;
        c(this.sKm);
        c(this.sKn);
    }

    private final void b(a aVar) {
        this.sKq = (c) aVar;
        if (this.sKd) {
            new StringBuilder("transitionTo: destState=").append(this.sKq.getName());
        }
    }
}
