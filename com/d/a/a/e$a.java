package com.d.a.a;

class e$a implements Runnable {
    private boolean bgN;
    final /* synthetic */ e bgO;
    private boolean started;

    private e$a(e eVar) {
        this.bgO = eVar;
    }

    /* synthetic */ e$a(e eVar, byte b) {
        this(eVar);
    }

    public final void run() {
        if (!this.bgN) {
            this.bgO.sv();
            this.bgO.handler.postDelayed(this, this.bgO.bgM);
        }
    }

    static /* synthetic */ void a(e$a e_a, long j) {
        if (!e_a.started && !e_a.bgN) {
            e_a.bgO.handler.postDelayed(e_a, j);
            e_a.started = true;
        }
    }

    static /* synthetic */ void a(e$a e_a) {
        e_a.bgN = true;
        e_a.bgO.handler.removeCallbacks(e_a);
    }
}
