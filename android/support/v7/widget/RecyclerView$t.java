package android.support.v7.widget;

import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.m;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class RecyclerView$t {
    private static final List<Object> Tb = Collections.EMPTY_LIST;
    public final View SU;
    int SV = -1;
    public long SW = -1;
    public int SX = -1;
    int SY = -1;
    RecyclerView$t SZ = null;
    RecyclerView$t Ta = null;
    List<Object> Tc = null;
    List<Object> Td = null;
    private int Te = 0;
    private m Tf = null;
    private boolean Tg = false;
    private int Th = 0;
    RecyclerView Ti;
    int mPosition = -1;
    private int rJ;

    static /* synthetic */ void q(RecyclerView$t recyclerView$t) {
        recyclerView$t.Th = z.F(recyclerView$t.SU);
        z.i(recyclerView$t.SU, 4);
    }

    static /* synthetic */ void r(RecyclerView$t recyclerView$t) {
        z.i(recyclerView$t.SU, recyclerView$t.Th);
        recyclerView$t.Th = 0;
    }

    static /* synthetic */ boolean s(RecyclerView$t recyclerView$t) {
        return (recyclerView$t.rJ & 16) == 0 && z.D(recyclerView$t.SU);
    }

    static /* synthetic */ boolean w(RecyclerView$t recyclerView$t) {
        return (recyclerView$t.rJ & 16) != 0;
    }

    public RecyclerView$t(View view) {
        if (view == null) {
            throw new IllegalArgumentException("itemView may not be null");
        }
        this.SU = view;
    }

    final void o(int i, boolean z) {
        if (this.SV == -1) {
            this.SV = this.mPosition;
        }
        if (this.SY == -1) {
            this.SY = this.mPosition;
        }
        if (z) {
            this.SY += i;
        }
        this.mPosition += i;
        if (this.SU.getLayoutParams() != null) {
            ((LayoutParams) this.SU.getLayoutParams()).Si = true;
        }
    }

    final void gj() {
        this.SV = -1;
        this.SY = -1;
    }

    final boolean gk() {
        return (this.rJ & 128) != 0;
    }

    @Deprecated
    public final int getPosition() {
        return this.SY == -1 ? this.mPosition : this.SY;
    }

    public final int gl() {
        return this.SY == -1 ? this.mPosition : this.SY;
    }

    public final int gm() {
        if (this.Ti == null) {
            return -1;
        }
        return RecyclerView.b(this.Ti, this);
    }

    final boolean gn() {
        return this.Tf != null;
    }

    final void go() {
        this.Tf.p(this);
    }

    final boolean gp() {
        return (this.rJ & 32) != 0;
    }

    final void gq() {
        this.rJ &= -33;
    }

    final void gr() {
        this.rJ &= -257;
    }

    final void a(m mVar, boolean z) {
        this.Tf = mVar;
        this.Tg = z;
    }

    final boolean gs() {
        return (this.rJ & 4) != 0;
    }

    final boolean gt() {
        return (this.rJ & 2) != 0;
    }

    final boolean isBound() {
        return (this.rJ & 1) != 0;
    }

    final boolean isRemoved() {
        return (this.rJ & 8) != 0;
    }

    final boolean by(int i) {
        return (this.rJ & i) != 0;
    }

    final boolean gu() {
        return (this.rJ & 256) != 0;
    }

    final void setFlags(int i, int i2) {
        this.rJ = (this.rJ & (i2 ^ -1)) | (i & i2);
    }

    final void addFlags(int i) {
        this.rJ |= i;
    }

    final void T(Object obj) {
        if (obj == null) {
            addFlags(1024);
        } else if ((this.rJ & 1024) == 0) {
            if (this.Tc == null) {
                this.Tc = new ArrayList();
                this.Td = Collections.unmodifiableList(this.Tc);
            }
            this.Tc.add(obj);
        }
    }

    final void gv() {
        if (this.Tc != null) {
            this.Tc.clear();
        }
        this.rJ &= -1025;
    }

    final List<Object> gw() {
        if ((this.rJ & 1024) != 0) {
            return Tb;
        }
        if (this.Tc == null || this.Tc.size() == 0) {
            return Tb;
        }
        return this.Td;
    }

    final void gx() {
        this.rJ = 0;
        this.mPosition = -1;
        this.SV = -1;
        this.SW = -1;
        this.SY = -1;
        this.Te = 0;
        this.SZ = null;
        this.Ta = null;
        gv();
        this.Th = 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.SW + ", oldPos=" + this.SV + ", pLpos:" + this.SY);
        if (gn()) {
            stringBuilder.append(" scrap ").append(this.Tg ? "[changeScrap]" : "[attachedScrap]");
        }
        if (gs()) {
            stringBuilder.append(" invalid");
        }
        if (!isBound()) {
            stringBuilder.append(" unbound");
        }
        if (gt()) {
            stringBuilder.append(" update");
        }
        if (isRemoved()) {
            stringBuilder.append(" removed");
        }
        if (gk()) {
            stringBuilder.append(" ignored");
        }
        if (gu()) {
            stringBuilder.append(" tmpDetached");
        }
        if (!gy()) {
            stringBuilder.append(" not recyclable(" + this.Te + ")");
        }
        Object obj = ((this.rJ & 512) != 0 || gs()) ? 1 : null;
        if (obj != null) {
            stringBuilder.append(" undefined adapter position");
        }
        if (this.SU.getParent() == null) {
            stringBuilder.append(" no parent");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void T(boolean z) {
        this.Te = z ? this.Te - 1 : this.Te + 1;
        if (this.Te < 0) {
            this.Te = 0;
            new StringBuilder("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ").append(this);
        } else if (!z && this.Te == 1) {
            this.rJ |= 16;
        } else if (z && this.Te == 0) {
            this.rJ &= -17;
        }
    }

    public final boolean gy() {
        return (this.rJ & 16) == 0 && !z.D(this.SU);
    }

    final boolean gz() {
        return (this.rJ & 2) != 0;
    }
}
