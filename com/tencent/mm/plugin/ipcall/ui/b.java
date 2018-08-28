package com.tencent.mm.plugin.ipcall.ui;

import android.graphics.Typeface;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.c.ccg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;

public final class b {
    MMActivity bGc;
    String dCw;
    TextView eCM;
    private ap eVd;
    a ksS;
    private DialPad ksT;
    TextView ksU;
    EditText ksV;
    View ksW;
    private ImageButton ksX;
    View ksY;
    TextView ksZ;
    TextView kta;
    String ktb;
    String ktc;
    String ktd = "";
    String kte;
    LinkedList<ccg> ktf;
    long ktg = 0;
    boolean kth = false;
    private Runnable kti = new 1(this);
    private ah ktj = new ah("IPCallDialQueryPhoneNumber");
    boolean ktk = false;
    private TextWatcher ktl = new 2(this);
    String ktm = "";

    public b(MMActivity mMActivity, EditText editText, TextView textView, View view, DialPad dialPad, ImageButton imageButton, TextView textView2, View view2, TextView textView3, TextView textView4) {
        this.bGc = mMActivity;
        this.ksV = editText;
        this.ksU = textView;
        this.ksW = view;
        this.ksT = dialPad;
        this.ksX = imageButton;
        this.eCM = textView2;
        this.ksY = view2;
        this.ksZ = textView3;
        this.kta = textView4;
        this.eVd = new ap();
        this.ktc = c.aYB();
        String string = ad.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryName", "");
        if (bi.oW(string)) {
            string = a.Fn(a.aYy());
        }
        this.ktb = string;
        this.ksU.addTextChangedListener(this.ktl);
        this.ksU.setText("+" + this.ktc);
        this.ksT.setDialButtonClickListener(new 3(this));
        this.ksW.setOnClickListener(new 4(this));
        this.ksW.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                if (b.this.kth) {
                    b.this.ktc = "+";
                    b.this.ksU.setText(b.this.ktc);
                } else {
                    b.this.eCM.setText("");
                    b.this.ktd = "";
                    b.this.bx("", -1);
                }
                return true;
            }
        });
        this.ksU.setOnClickListener(new 6(this));
        this.ksX.setOnClickListener(new 7(this));
        this.ksV.setHorizontallyScrolling(true);
        this.ksV.setOnClickListener(new 8(this));
        this.ksV.addTextChangedListener(new 9(this));
        if (d.fR(16)) {
            this.ksU.setTypeface(Typeface.create("sans-serif-light", 0));
            this.ksV.setTypeface(Typeface.create("sans-serif-light", 0));
            this.eCM.setTypeface(Typeface.create("sans-serif-light", 0));
        }
    }

    public final void EW(String str) {
        this.ktc = str;
        if (this.ksU != null) {
            this.ksU.setText("+" + str);
        }
    }

    public final void U(LinkedList<ccg> linkedList) {
        int i;
        this.ktf = linkedList;
        String replace = this.ksU.getText().toString().replace("+", "");
        if (a.Fq(replace) && this.ktf != null && this.ktf.size() > 0) {
            String Fo = a.Fo(replace);
            Iterator it = this.ktf.iterator();
            while (it.hasNext()) {
                ccg ccg = (ccg) it.next();
                if (ccg != null && ccg.eJQ.equals(Fo)) {
                    i = 1;
                    break;
                }
            }
        }
        i = 0;
        if (i != 0) {
            this.kta.setVisibility(0);
        } else {
            this.kta.setVisibility(8);
        }
    }

    static String dr(String str, String str2) {
        String formatNumber = ap.formatNumber(str, c.Fx(str2));
        return bi.oW(formatNumber) ? str2 : formatNumber;
    }

    public final void bx(String str, int i) {
        this.ksV.setText(str);
        if (!bi.oW(str)) {
            if (i != -1) {
                if (this.ktk) {
                    if (i > 0 && i <= this.ksV.getText().length()) {
                        this.ksV.setSelection(i);
                    }
                }
            }
            this.ksV.setSelection(this.ksV.getText().length());
        }
        this.ktd = str;
    }

    public final void aYa() {
        this.ktj.cil().removeCallbacks(this.kti);
        this.ktj.h(this.kti, 500);
    }
}
