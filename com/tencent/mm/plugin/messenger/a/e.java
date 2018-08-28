package com.tencent.mm.plugin.messenger.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.kernel.c.a;
import java.lang.ref.WeakReference;

public interface e extends a {
    void Gs(String str);

    void Gt(String str);

    CharSequence Gu(String str);

    CharSequence a(String str, Bundle bundle, WeakReference<Context> weakReference);

    void a(String str, a aVar);

    void a(String str, b bVar);
}
