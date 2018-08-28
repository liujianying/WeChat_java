package com.tencent.mm.ak.a.a;

import android.graphics.drawable.Drawable;
import com.tencent.mm.ak.a.c.b;
import com.tencent.mm.ak.a.c.o;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.platformtools.ag;

public final class c {
    public final float alpha;
    public final String bKg;
    public final String bOX;
    public final String dXA;
    public final String dXB;
    public final String dXC;
    public final int dXD;
    public final int dXE;
    public final int dXF;
    public final boolean dXG;
    public final boolean dXH;
    public final boolean dXI;
    public final int dXJ;
    public final boolean dXK;
    public final boolean dXL;
    public final boolean dXM;
    public final int dXN;
    public final Drawable dXO;
    private final int dXP;
    private final Drawable dXQ;
    public final int dXR;
    public final Drawable dXS;
    public final String dXT;
    public final SFSContext dXU;
    public final boolean dXV;
    public final boolean dXW;
    public final float dXX;
    public final boolean dXY;
    public final boolean dXZ;
    public final b dXn;
    public final boolean dXw;
    public final boolean dXx;
    public final boolean dXy;
    public final boolean dXz;
    public final boolean dYa;
    public final o dYb;
    public final Object[] dYc;
    public final int density;
    public final ag handler;

    public static class a {
        float alpha = 0.0f;
        public String bKg = "";
        public String bOX;
        public String dXA = "";
        public String dXB = "";
        String dXC = "";
        public int dXD = 5;
        public int dXE = 0;
        public int dXF = 0;
        public boolean dXG = false;
        public boolean dXH = false;
        public boolean dXI;
        public int dXJ;
        public boolean dXK;
        public boolean dXL = false;
        boolean dXM = false;
        public int dXN = 0;
        public Drawable dXO = null;
        int dXP = 0;
        Drawable dXQ = null;
        public int dXR = 0;
        public Drawable dXS = null;
        public String dXT = null;
        public SFSContext dXU = null;
        public boolean dXV = true;
        public boolean dXW = false;
        public float dXX = 0.0f;
        public boolean dXY = false;
        public boolean dXZ = true;
        public b dXn = null;
        public boolean dXw = true;
        public boolean dXx = false;
        public boolean dXy = false;
        public boolean dXz = true;
        public boolean dYa = false;
        o dYb = null;
        public Object[] dYc = null;
        int density = 0;
        ag handler = null;

        public final a bg(int i, int i2) {
            this.dXE = i;
            this.dXF = i2;
            return this;
        }

        public final c Pt() {
            return new c(this, (byte) 0);
        }
    }

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.dXw = aVar.dXw;
        this.dXy = aVar.dXy;
        this.dXx = aVar.dXx;
        this.dXz = aVar.dXz;
        this.dXA = aVar.dXA;
        this.dXB = aVar.dXB;
        this.dXC = aVar.dXC;
        this.dXD = aVar.dXD;
        this.dXE = aVar.dXE;
        this.dXF = aVar.dXF;
        this.dXG = aVar.dXG;
        this.bKg = aVar.bKg;
        this.density = aVar.density;
        this.alpha = aVar.alpha;
        this.dXH = aVar.dXH;
        this.dXI = aVar.dXI;
        this.dXJ = aVar.dXJ;
        this.bOX = aVar.bOX;
        this.dXK = aVar.dXK;
        this.dXL = aVar.dXL;
        this.dXM = aVar.dXM;
        this.dXN = aVar.dXN;
        this.dXO = aVar.dXO;
        this.dXP = aVar.dXP;
        this.dXQ = aVar.dXQ;
        this.dXR = aVar.dXR;
        this.dXS = aVar.dXS;
        this.dXV = aVar.dXV;
        this.dXW = aVar.dXW;
        this.dXX = aVar.dXX;
        this.dXY = aVar.dXY;
        this.dXZ = aVar.dXZ;
        this.dYa = aVar.dYa;
        this.dXU = aVar.dXU;
        this.handler = aVar.handler;
        this.dYc = aVar.dYc;
        this.dXn = aVar.dXn;
        this.dYb = aVar.dYb;
        this.dXT = aVar.dXT;
    }
}
