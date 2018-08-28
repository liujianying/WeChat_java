package com.tencent.mm.plugin.ipcall.ui;

import android.graphics.Paint;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.protocal.c.ccg;
import java.util.Iterator;

class b$2 implements TextWatcher {
    final /* synthetic */ b ktn;

    b$2(b bVar) {
        this.ktn = bVar;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int measureText;
        if (this.ktn.ksY.getLayoutParams() != null) {
            int i4;
            Paint paint = this.ktn.ksU.getPaint();
            if ("+".equals(this.ktn.ksU.getText().toString())) {
                measureText = (int) paint.measureText(this.ktn.ksU.getText().toString());
                this.ktn.ksW.setVisibility(8);
                this.ktn.ksZ.setVisibility(8);
                i4 = measureText;
            } else {
                measureText = (int) paint.measureText(this.ktn.ksU.getText() + "+");
                this.ktn.ksW.setVisibility(0);
                this.ktn.ksZ.setVisibility(0);
                i4 = measureText;
            }
            LayoutParams layoutParams = (LayoutParams) this.ktn.ksY.getLayoutParams();
            layoutParams.width = i4;
            this.ktn.ksY.setLayoutParams(layoutParams);
        }
        String replace = this.ktn.ksU.getText().toString().replace("+", "");
        if (a.Fq(replace)) {
            this.ktn.ksZ.setText(a.Fn(replace));
            if (this.ktn.ktf != null && this.ktn.ktf.size() > 0) {
                String Fo = a.Fo(replace);
                Iterator it = this.ktn.ktf.iterator();
                while (it.hasNext()) {
                    ccg ccg = (ccg) it.next();
                    if (ccg != null && ccg.eJQ.equals(Fo)) {
                        measureText = 1;
                        break;
                    }
                }
                measureText = 0;
            }
            measureText = 0;
        } else {
            this.ktn.ksZ.setText(this.ktn.bGc.getString(R.l.ip_call_dial_country_unknown));
            measureText = 0;
        }
        if (measureText != 0) {
            this.ktn.kta.setVisibility(0);
        } else {
            this.ktn.kta.setVisibility(8);
        }
        if (this.ktn.ksS != null) {
            this.ktn.ksS.EX(replace);
        }
    }

    public final void afterTextChanged(Editable editable) {
        String replace = this.ktn.ksU.getText().toString().replace("+", "");
        if (replace.startsWith("0") || replace.startsWith("*") || replace.startsWith("#")) {
            this.ktn.ksU.setText("+");
            this.ktn.ktc = "+";
        }
    }
}
