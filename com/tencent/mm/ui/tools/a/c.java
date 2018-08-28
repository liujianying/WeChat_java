package com.tencent.mm.ui.tools.a;

import android.text.InputFilter;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class c extends a {
    private String gEw;
    public int gHz;
    public boolean uCR = true;
    public WeakReference<EditText> uCS;
    private int uCT;
    private int uCU;
    private ArrayList<InputFilter> uCV;
    public a uCW;

    public interface a {
        void YX();

        void YY();

        void pO(String str);
    }

    public c(WeakReference<EditText> weakReference) {
        this.uCS = weakReference;
        this.gHz = com.tencent.mm.ui.tools.g.a.uzZ;
        this.uCR = false;
    }

    public static c d(EditText editText) {
        return new c(new WeakReference(editText));
    }

    public final c fj(int i, int i2) {
        this.uCU = i;
        this.uCT = i2;
        return this;
    }

    public final c Gi(int i) {
        this.uCU = 0;
        this.uCT = i;
        return this;
    }

    public final void a(a aVar) {
        this.uCW = aVar;
        cfb();
    }

    protected final int afr() {
        Object obj;
        if (bi.oW(this.gEw)) {
            if (this.uCS == null) {
                return 1;
            }
            this.gEw = ((EditText) this.uCS.get()).getText().toString().trim();
        }
        int du = g.du(this.gEw, this.gHz);
        if (du < 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            x.w("MicroMsg.InputTextBoundaryCheck", "you are crazy =.=!that is 2 GB character!");
            return 2;
        } else if (du < this.uCU) {
            return 1;
        } else {
            if (du > this.uCT) {
                return 2;
            }
            return 0;
        }
    }

    protected final void cfb() {
        if (!this.uCR) {
            if (this.uCS == null) {
                x.w("MicroMsg.InputTextBoundaryCheck", "edit text view is null");
                return;
            } else if (bi.cX(this.uCV)) {
                ((EditText) this.uCS.get()).setFilters(new InputFilter[]{bY(this.uCT, this.gHz)});
            } else {
                this.uCV.add(bY(this.uCT, this.gHz));
                ((EditText) this.uCS.get()).setFilters((InputFilter[]) this.uCV.toArray(new InputFilter[this.uCV.size()]));
            }
        }
        if (this.uCW != null) {
            switch (afr()) {
                case 0:
                    this.uCW.pO(this.gEw);
                    return;
                case 1:
                    this.uCW.YX();
                    return;
                case 2:
                    this.uCW.YY();
                    return;
                default:
                    return;
            }
        }
    }

    public g bY(int i, int i2) {
        return new g(i, i2);
    }
}
