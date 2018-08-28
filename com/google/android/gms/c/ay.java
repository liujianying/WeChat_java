package com.google.android.gms.c;

public abstract class ay<M extends ay<M>> extends be {
    protected ba aZY;

    private M qG() {
        ay ayVar = (ay) super.qH();
        bc.a(this, ayVar);
        return ayVar;
    }

    public void a(ax axVar) {
        if (this.aZY != null) {
            for (int i = 0; i < this.aZY.size(); i++) {
                this.aZY.dM(i).a(axVar);
            }
        }
    }

    protected final boolean a(aw awVar, int i) {
        int position = awVar.getPosition();
        if (!awVar.dA(i)) {
            return false;
        }
        byte[] bArr;
        bb bbVar;
        int dP = bh.dP(i);
        int position2 = awVar.getPosition() - position;
        if (position2 == 0) {
            bArr = bh.bas;
        } else {
            bArr = new byte[position2];
            System.arraycopy(awVar.buffer, position + awVar.aZO, bArr, 0, position2);
        }
        bg bgVar = new bg(i, bArr);
        if (this.aZY == null) {
            this.aZY = new ba();
            bbVar = null;
        } else {
            ba baVar = this.aZY;
            position2 = baVar.dN(dP);
            bbVar = (position2 < 0 || baVar.bae[position2] == ba.bab) ? null : baVar.bae[position2];
        }
        if (bbVar == null) {
            bb bbVar2 = new bb();
            ba baVar2 = this.aZY;
            int dN = baVar2.dN(dP);
            if (dN >= 0) {
                baVar2.bae[dN] = bbVar2;
                bbVar = bbVar2;
            } else {
                dN ^= -1;
                if (dN >= baVar2.fi || baVar2.bae[dN] != ba.bab) {
                    if (baVar2.bac && baVar2.fi >= baVar2.bad.length) {
                        baVar2.gc();
                        dN = baVar2.dN(dP) ^ -1;
                    }
                    if (baVar2.fi >= baVar2.bad.length) {
                        int ad = ba.ad(baVar2.fi + 1);
                        Object obj = new int[ad];
                        Object obj2 = new bb[ad];
                        System.arraycopy(baVar2.bad, 0, obj, 0, baVar2.bad.length);
                        System.arraycopy(baVar2.bae, 0, obj2, 0, baVar2.bae.length);
                        baVar2.bad = obj;
                        baVar2.bae = obj2;
                    }
                    if (baVar2.fi - dN != 0) {
                        System.arraycopy(baVar2.bad, dN, baVar2.bad, dN + 1, baVar2.fi - dN);
                        System.arraycopy(baVar2.bae, dN, baVar2.bae, dN + 1, baVar2.fi - dN);
                    }
                    baVar2.bad[dN] = dP;
                    baVar2.bae[dN] = bbVar2;
                    baVar2.fi++;
                    bbVar = bbVar2;
                } else {
                    baVar2.bad[dN] = dP;
                    baVar2.bae[dN] = bbVar2;
                    bbVar = bbVar2;
                }
            }
        }
        bbVar.bah.add(bgVar);
        return true;
    }

    protected final boolean a(M m) {
        return (this.aZY == null || this.aZY.isEmpty()) ? m.aZY == null || m.aZY.isEmpty() : this.aZY.equals(m.aZY);
    }

    protected int pU() {
        int i = 0;
        if (this.aZY == null) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 >= this.aZY.size()) {
                return i3;
            }
            i = this.aZY.dM(i2).pU() + i3;
            i2++;
        }
    }

    protected final int qF() {
        return (this.aZY == null || this.aZY.isEmpty()) ? 0 : this.aZY.hashCode();
    }
}
