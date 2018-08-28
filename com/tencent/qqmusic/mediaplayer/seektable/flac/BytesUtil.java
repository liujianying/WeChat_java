package com.tencent.qqmusic.mediaplayer.seektable.flac;

import com.tencent.smtt.sdk.WebView;

public class BytesUtil {
    public static int from(byte[] bArr) {
        if (bArr.length > 4) {
            throw new RuntimeException("bytes can't be greater than 32 bit!");
        } else if (bArr.length == 3) {
            return (((bArr[0] & WebView.NORMAL_MODE_ALPHA) << 16) | ((bArr[1] & WebView.NORMAL_MODE_ALPHA) << 8)) | (bArr[2] & WebView.NORMAL_MODE_ALPHA);
        } else {
            if (bArr.length == 2) {
                return ((bArr[0] & WebView.NORMAL_MODE_ALPHA) << 8) | (bArr[1] & 15);
            }
            if (bArr.length == 1) {
                return bArr[0] & WebView.NORMAL_MODE_ALPHA;
            }
            throw new RuntimeException("bytes must be greater than 8 bit!");
        }
    }
}
