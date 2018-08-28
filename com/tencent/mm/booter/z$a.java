package com.tencent.mm.booter;

import java.util.Locale;

class z$a {
    public int bGz;
    final /* synthetic */ z cXX;
    public String cXY;
    public int cXZ;
    public int cYa;
    public long cYb;
    public int cYc;
    public int cYd = 0;
    int cYe = 0;
    int cYf = 0;
    public long time;
    public int type;

    public z$a(z zVar) {
        this.cXX = zVar;
    }

    public final String toString() {
        return String.format(Locale.US, "%d#%d#%d#%d#%d#%d#%d#%s#%d#%d#%d|", new Object[]{Integer.valueOf(this.type), Long.valueOf(this.time), Integer.valueOf(this.cXZ), Integer.valueOf(this.bGz), Integer.valueOf(this.cYa), Long.valueOf(this.cYb), Integer.valueOf(this.cYc), this.cXY, Integer.valueOf(this.cYd), Integer.valueOf(this.cYe), Integer.valueOf(this.cYf)});
    }
}
