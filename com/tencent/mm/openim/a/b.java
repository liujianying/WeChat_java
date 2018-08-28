package com.tencent.mm.openim.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import com.tencent.mm.ab.e;
import com.tencent.mm.kernel.c.a;

public interface b extends e, a {
    CharSequence a(Context context, String str, String str2, float f);

    void aD(String str, String str2);

    String aE(String str, String str2);

    SpannableString d(Context context, String str, int i);

    String g(String str, String str2, int i);

    String h(String str, String str2, int i);

    String i(String str, String str2, int i);

    Bitmap oC(String str);

    int oD(String str);
}
