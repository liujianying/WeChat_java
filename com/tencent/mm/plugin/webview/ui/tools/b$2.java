package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.h;
import java.util.List;

class b$2 implements OnClickListener {
    final /* synthetic */ String pVN;
    final /* synthetic */ b pVO;

    b$2(b bVar, String str) {
        this.pVO = bVar;
        this.pVN = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        List<h> list = (List) this.pVO.pVL.get(this.pVN);
        if (list == null) {
            x.e("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, cancel selected, list should not be null");
            return;
        }
        this.pVO.pVM.put(this.pVN, Boolean.valueOf(false));
        x.i("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, cancel selected, list size = %d", new Object[]{Integer.valueOf(list.size())});
        for (h cancel : list) {
            cancel.cancel();
        }
        list.clear();
        this.pVO.pVK.clearSslPreferences();
    }
}
