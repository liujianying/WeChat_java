package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;

class b$6 implements OnClickListener {
    final /* synthetic */ b ktn;

    b$6(b bVar) {
        this.ktn = bVar;
    }

    public final void onClick(View view) {
        h.mEJ.h(12061, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0)});
        String replace = this.ktn.ksU.getText().toString().replace("+", "");
        Intent intent = new Intent(this.ktn.bGc, IPCallCountryCodeSelectUI.class);
        intent.putExtra("couttry_code", replace);
        intent.putExtra("CountryCodeUI_isShowCountryCode", true);
        this.ktn.bGc.startActivityForResult(intent, 100);
        this.ktn.bGc.overridePendingTransition(R.a.push_up_in, -1);
    }
}
