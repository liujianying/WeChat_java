package com.tencent.tencentmap.mapsdk.a;

class ef$a implements Runnable {
    private /* synthetic */ ef a;

    private ef$a(ef efVar) {
        this.a = efVar;
    }

    /* synthetic */ ef$a(ef efVar, byte b) {
        this(efVar);
    }

    public final void run() {
        try {
            this.a.b();
            fx.b("AccessSchedulerTrigger", "TimeTrigger");
        } catch (Exception e) {
        }
    }
}
