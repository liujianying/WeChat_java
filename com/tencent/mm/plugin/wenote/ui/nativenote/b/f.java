package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.util.SparseArray;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.ugc.TXRecordCommon;

public final class f {
    public static final int qvk = R.i.note_editor_text_item;
    public static final int qvl = R.i.note_editor_other_item;
    public static final int qvm = R.i.note_editor_header_item;
    public SparseArray<Integer> qvn = new SparseArray();

    public f() {
        this.qvn.put(1, Integer.valueOf(qvk));
        this.qvn.put(2, Integer.valueOf(qvl));
        this.qvn.put(4, Integer.valueOf(qvl));
        this.qvn.put(3, Integer.valueOf(qvl));
        this.qvn.put(5, Integer.valueOf(qvl));
        this.qvn.put(6, Integer.valueOf(qvl));
        this.qvn.put(0, Integer.valueOf(qvl));
        this.qvn.put(-1, Integer.valueOf(qvl));
        this.qvn.put(-3, Integer.valueOf(qvm));
        this.qvn.put(-2, Integer.valueOf(qvl));
        this.qvn.put(-4, Integer.valueOf(qvl));
    }

    public static a a(int i, View view, k kVar) {
        switch (i) {
            case TXRecordCommon.START_RECORD_ERR_NOT_INIT /*-4*/:
                return new i(view, kVar);
            case -3:
                return new d(view, kVar);
            case -2:
                return new b(view, kVar);
            case -1:
                return new j(view, kVar);
            case 0:
                return new l(view, kVar);
            case 1:
                return new k(view, kVar);
            case 2:
                return new e(view, kVar);
            case 3:
                return new g(view, kVar);
            case 4:
                return new n(view, kVar);
            case 5:
                return new c(view, kVar);
            case 6:
                return new m(view, kVar);
            default:
                return null;
        }
    }
}
