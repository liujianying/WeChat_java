package com.tencent.mm.ui.base;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.l;

public final class k extends AlertDialog {
    private ListView CU;
    public BaseAdapter hAv;
    private View hyK;
    private Context mContext;
    public OnItemClickListener qRL;
    private CharSequence sn;

    public k(Context context) {
        super(context, l.mmalertdialog);
        this.mContext = context;
        if (a.fi(this.mContext)) {
            this.hyK = View.inflate(this.mContext, h.mm_list_dialog_large, null);
        } else {
            this.hyK = View.inflate(this.mContext, h.mm_list_dialog, null);
        }
        this.CU = (ListView) this.hyK.findViewById(g.list);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.hyK);
    }

    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.sn = charSequence;
        } else {
            this.sn = null;
        }
    }

    public final void show() {
        if (this.sn != null) {
            this.sn.length();
        }
        if (this.qRL != null) {
            this.CU.setOnItemClickListener(this.qRL);
        }
        if (this.hAv != null) {
            this.CU.setAdapter(this.hAv);
        }
        super.show();
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.MMListDialog", "dismiss exception, e = " + e.getMessage());
        }
    }
}
