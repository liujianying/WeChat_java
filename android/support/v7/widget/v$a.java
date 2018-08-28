package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.t;

class v$a {
    public t Ok;
    public t Ol;
    public int Om;
    public int On;
    public int Oo;
    public int Op;

    /* synthetic */ v$a(t tVar, t tVar2, int i, int i2, int i3, int i4, byte b) {
        this(tVar, tVar2, i, i2, i3, i4);
    }

    private v$a(t tVar, t tVar2) {
        this.Ok = tVar;
        this.Ol = tVar2;
    }

    private v$a(t tVar, t tVar2, int i, int i2, int i3, int i4) {
        this(tVar, tVar2);
        this.Om = i;
        this.On = i2;
        this.Oo = i3;
        this.Op = i4;
    }

    public final String toString() {
        return "ChangeInfo{oldHolder=" + this.Ok + ", newHolder=" + this.Ol + ", fromX=" + this.Om + ", fromY=" + this.On + ", toX=" + this.Oo + ", toY=" + this.Op + '}';
    }
}
