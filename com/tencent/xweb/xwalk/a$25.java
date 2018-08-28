package com.tencent.xweb.xwalk;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.xweb.g.a;
import com.tencent.xweb.k;
import org.xwalk.core.Log;
import org.xwalk.core.R;

class a$25 implements OnCheckedChangeListener {
    final /* synthetic */ a vEm;

    a$25(a aVar) {
        this.vEm = aVar;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        a aVar = a.vAc;
        if (i == R.id.v8_auto) {
            aVar = a.vAc;
        } else if (i == R.id.v8_sys) {
            aVar = a.vAd;
        } else if (i == R.id.v8_x5) {
            aVar = a.vAh;
        } else if (i == R.id.v8_nativescript) {
            aVar = a.vAj;
        } else if (i == R.id.v8_mmv8) {
            aVar = a.vAk;
        }
        k.cIn().a(aVar);
        Log.d("WebDebugPage", "v8 type change to=" + aVar);
    }
}
