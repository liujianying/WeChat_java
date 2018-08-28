package com.tencent.mm.console;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.f.e;
import java.util.ArrayList;

class b$3 implements OnClickListener {
    final /* synthetic */ int dgZ;
    final /* synthetic */ ArrayList dha;
    final /* synthetic */ Context val$context;

    b$3(int i, ArrayList arrayList, Context context) {
        this.dgZ = i;
        this.dha = arrayList;
        this.val$context = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        e.post(new 1(this), "copypackage");
    }
}
