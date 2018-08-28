package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import java.util.Map;

public interface f extends a {
    void a(Context context, int i, String str, String str2, Map<String, String> map, String str3);

    void a(Context context, String str, String str2, Map<String, String> map);

    void b(Context context, int i, String str, String str2);

    void b(Context context, String str, String str2, Map<String, String> map);
}
