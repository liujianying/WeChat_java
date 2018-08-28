package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.mm.pluginsdk.g.a.c.f.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class l implements b {
    private final String filePath;
    protected volatile int gDm = 15000;
    private final String groupId;
    private final String method;
    final int networkType;
    final int priority;
    final int qBI;
    public final String qBy;
    private final String qCR;
    protected final Map<String, String> qDh = new HashMap();
    protected volatile int qDi = 20000;
    protected volatile int qDj = 15000;
    public final String url;

    public l(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, int i3) {
        this.qBy = str;
        this.filePath = str2;
        this.qCR = str3;
        this.groupId = str4;
        this.url = str5;
        this.method = str6;
        this.qBI = i;
        this.networkType = i2;
        this.priority = Math.max(i3, 0);
    }

    public boolean ccs() {
        return false;
    }

    public String aca() {
        return this.groupId;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public final String cco() {
        return this.qBy;
    }

    public final Map<String, String> getRequestHeaders() {
        if (this.qDh.size() == 0) {
            return null;
        }
        return Collections.unmodifiableMap(this.qDh);
    }

    public final void setConnectTimeout(int i) {
        this.gDm = i;
    }

    public final int getConnectTimeout() {
        return this.gDm;
    }

    public final void setReadTimeout(int i) {
        this.qDi = i;
    }

    public final int getReadTimeout() {
        return this.qDi;
    }

    public final int ccD() {
        return this.qDj;
    }
}
