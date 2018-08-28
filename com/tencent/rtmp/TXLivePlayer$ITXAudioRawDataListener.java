package com.tencent.rtmp;

public interface TXLivePlayer$ITXAudioRawDataListener {
    void onAudioInfoChanged(int i, int i2, int i3);

    void onPcmDataAvailable(byte[] bArr, long j);
}
