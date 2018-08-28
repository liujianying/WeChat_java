package com.google.android.gms.tagmanager;

final class ae extends ad {
    private static final Object bcq = new Object();
    private static ae bcz;
    private j bcr;
    private volatile i bcs;
    private int bct = 1800000;
    private boolean bcu = true;
    private boolean bcv = false;
    private boolean bcw = true;
    private k bcx = new 1(this);
    private boolean bcy = false;
    private boolean connected = true;

    private ae() {
    }

    public static ae rA() {
        if (bcz == null) {
            bcz = new ae();
        }
        return bcz;
    }

    public final synchronized void rz() {
        if (this.bcv) {
            i iVar = this.bcs;
            2 2 = new 2(this);
        } else {
            m.rf();
            this.bcu = true;
        }
    }
}
