package com.tencent.matrix.resource.analyzer.model;

import com.tencent.matrix.resource.a.a.b;
import java.io.File;
import java.io.Serializable;

public final class a implements Serializable {
    public final File brs;
    public final String brt;
    public final String mActivityName;

    public a(File file, String str, String str2) {
        this.brs = (File) b.e(file, "hprofFile");
        this.brt = (String) b.e(str, "refKey");
        this.mActivityName = (String) b.e(str2, "activityName");
    }
}
