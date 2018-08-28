package com.tencent.mm.modelappbrand;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.kernel.c.a;

public interface e extends a {
    d JM();

    j JN();

    String a(String str, View view, Bundle bundle, u uVar);

    void a(String str, View view);

    void bB(View view);

    l bC(View view);

    View bH(Context context);

    void initialize();

    void jl(String str);

    void shutdown();
}
