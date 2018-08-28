package com.tencent.mm.plugin.multi;

public interface talk$a {
    void keep_OnError(int i);

    void keep_OnNotify(int i);

    void keep_OnOpenSuccess();

    void keep_OnReportChannel(String str);

    void keep_OnReportEngineRecv(String str, int i);

    void keep_OnReportEngineSend(String str);
}
