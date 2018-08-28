package com.tencent.xweb.xwalk;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.RadioButton;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.k;
import org.xwalk.core.R;
import org.xwalk.core.R$array;

class a$23 implements OnItemSelectedListener {
    final /* synthetic */ a vEm;

    a$23(a aVar) {
        this.vEm = aVar;
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = 1;
        String[] stringArray = this.vEm.vAp.getResources().getStringArray(R$array.webviewuimodules);
        this.vEm.vEl = stringArray[i];
        a aVar = this.vEm;
        aVar.vEk = true;
        if (aVar.vEl.equals("all")) {
            String[] stringArray2 = aVar.vAp.getResources().getStringArray(R$array.webviewmodules);
            d adC = k.cIn().adC(stringArray2[0]);
            while (i2 < stringArray2.length) {
                if (k.cIn().adC(stringArray2[i2]) != adC) {
                    ((RadioButton) aVar.vEj.findViewById(R.id.WV_AUTO)).setChecked(false);
                    ((RadioButton) aVar.vEj.findViewById(R.id.WV_XWALK)).setChecked(false);
                    ((RadioButton) aVar.vEj.findViewById(R.id.WV_X5)).setChecked(false);
                    ((RadioButton) aVar.vEj.findViewById(R.id.WV_SYS)).setChecked(false);
                    break;
                }
                i2++;
            }
            aVar.f(adC);
        } else {
            aVar.f(k.cIn().adC(aVar.vEl));
        }
        aVar.vEk = false;
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}
