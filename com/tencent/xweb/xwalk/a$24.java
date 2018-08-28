package com.tencent.xweb.xwalk;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.k;
import org.xwalk.core.Log;
import org.xwalk.core.R;
import org.xwalk.core.R$array;

class a$24 implements OnCheckedChangeListener {
    final /* synthetic */ a vEm;

    a$24(a aVar) {
        this.vEm = aVar;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (!this.vEm.vEk) {
            d dVar = d.vAO;
            if (i == R.id.WV_AUTO) {
                dVar = d.vAO;
            } else if (i == R.id.WV_XWALK) {
                dVar = d.vAP;
            } else if (i == R.id.WV_X5) {
                dVar = d.vAQ;
            } else if (i == R.id.WV_SYS) {
                dVar = d.vAR;
            }
            if (this.vEm.vEl.equals("all")) {
                String[] stringArray = this.vEm.vAp.getResources().getStringArray(R$array.webviewmodules);
                for (int i2 = 0; i2 < stringArray.length; i2++) {
                    k.cIn().a(stringArray[i2], dVar);
                    Log.d("WebDebugPage", "webview " + stringArray[i2] + " change to=" + dVar);
                }
                return;
            }
            k.cIn().a(this.vEm.vEl, dVar);
            Log.d("WebDebugPage", "webview change to=" + dVar);
        }
    }
}
