package com.tencent.matrix.mrs.core;

public interface MrsCallback {
    String getPublicSharePath();

    void onMrsReportDataReady(byte[] bArr);

    boolean onRequestGetMrsStrategy(byte[] bArr);

    void onStrategyNotify(String str, boolean z);
}
