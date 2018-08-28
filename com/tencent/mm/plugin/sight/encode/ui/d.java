package com.tencent.mm.plugin.sight.encode.ui;

import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class d implements TextWatcher, OnClickListener, OnFocusChangeListener, l {
    private ag handler = new ag(Looper.getMainLooper());
    public EditText nfV;
    public TextView nfW;
    public View nfX;
    private a nfY;
    InputMethodManager nfZ;
    public int nga = b.ngd;
    public a ngb;

    public final boolean bwr() {
        return this.nga == b.ngc;
    }

    public final void onFocusChange(View view, boolean z) {
        if (!z) {
            this.nfV.clearFocus();
            bi.hideVKB(this.nfV);
        }
    }

    public final void onClick(View view) {
        if (view.getId() == R.h.search_cancel_tv && bwr()) {
            bws();
        }
    }

    public final void bws() {
        if (bwr()) {
            bwt();
        } else if (!bwr()) {
            this.nga = b.ngc;
            this.nfX.setVisibility(0);
            if (this.ngb != null) {
                this.ngb.bwu();
            }
            this.nfV.requestFocus();
            this.nfZ.showSoftInput(this.nfV, 0);
        }
    }

    public final void bwt() {
        if (bwr()) {
            this.nfV.setText("");
            this.nfV.clearFocus();
            bi.hideVKB(this.nfV);
            this.nga = b.ngd;
            this.nfX.setVisibility(8);
            if (this.ngb != null) {
                this.ngb.bwv();
            }
        }
    }

    public final void b(j jVar) {
        if (jVar.bjW == 0 && jVar.jsx != null && this.ngb != null) {
            List arrayList = new ArrayList();
            for (com.tencent.mm.plugin.fts.a.a.l lVar : jVar.jsx) {
                arrayList.add(lVar.jrv);
            }
            this.ngb.ce(arrayList);
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (!bi.oW(editable.toString())) {
            x.i("MicroMsg.MainSightSelectContactSearchHelper", "doSearch: query=%s", new Object[]{editable.toString()});
            if (this.nfY != null) {
                ((n) g.n(n.class)).cancelSearchTask(this.nfY);
                this.nfY = null;
            }
            this.nfY = ((n) g.n(n.class)).search(2, i.a(r0, new int[]{131072, 131075}, null, 3, new HashSet(), b.jsU, this, this.handler));
        }
    }
}
