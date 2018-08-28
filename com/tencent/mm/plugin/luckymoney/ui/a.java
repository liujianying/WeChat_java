package com.tencent.mm.plugin.luckymoney.ui;

import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;
import java.util.List;

public final class a {
    private List<b> kVu = new LinkedList();
    private boolean kVv = false;
    private boolean kVw = false;
    private TextView kVx;

    public final void a(b bVar) {
        if (bVar != null) {
            this.kVu.add(bVar);
        }
    }

    public final void f(TextView textView) {
        if (textView != null) {
            this.kVx = textView;
        }
    }

    public final void clear() {
        this.kVu.clear();
        this.kVx = null;
    }

    public final boolean bbv() {
        this.kVw = false;
        this.kVv = false;
        for (int i = 0; i < this.kVu.size(); i++) {
            b bVar = (b) this.kVu.get(i);
            int baC = bVar.baC();
            if (baC != 0) {
                bVar.onError();
                CharSequence rV = bVar.rV(baC);
                if (!(this.kVx == null || bi.oW(rV))) {
                    if (!this.kVv) {
                        this.kVx.setText(rV);
                    }
                    this.kVx.setVisibility(0);
                    this.kVv = true;
                }
                this.kVw = true;
            } else {
                bVar.restore();
            }
        }
        if (!(this.kVw || this.kVx == null)) {
            this.kVx.setVisibility(8);
            this.kVv = false;
        }
        return this.kVw;
    }

    public final boolean bbw() {
        for (int i = 0; i < this.kVu.size(); i++) {
            if (((b) this.kVu.get(i)).baC() != 0) {
                return true;
            }
        }
        return false;
    }

    public final void tn(String str) {
        if (this.kVx != null && !bi.oW(str)) {
            this.kVx.setText(str);
            this.kVx.setVisibility(0);
            this.kVv = true;
        } else if (this.kVx != null) {
            this.kVx.setVisibility(8);
            this.kVv = false;
        }
    }
}
