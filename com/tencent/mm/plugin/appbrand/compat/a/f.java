package com.tencent.mm.plugin.appbrand.compat.a;

import android.content.Intent;
import com.tencent.mm.kernel.c.a;
import java.io.File;
import java.util.Map;
import java.util.Properties;

public interface f extends a {
    Properties A(File file);

    String adP();

    int adQ();

    Intent adR();

    Map<String, String> adS();

    boolean bc(String str, String str2);

    String v(Map<String, String> map);
}
