package com.tencent.qqmusic.mediaplayer;

import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public class CacheBytesManager {
    private static byte[] mCache1024 = null;
    private static byte[] mCache4096 = null;
    private static byte[] mCache8192 = null;

    private CacheBytesManager(int i) {
    }

    public static CacheBytesManager getInstance() {
        return SingletonHolder.access$000();
    }

    public static synchronized byte[] recycle(byte[] bArr) {
        synchronized (CacheBytesManager.class) {
            if (bArr != null) {
                if (bArr.length == 1024 && mCache1024 == null) {
                    mCache1024 = bArr;
                } else if (bArr.length == GLIcon.LEFT && mCache4096 == null) {
                    mCache4096 = bArr;
                } else if (bArr.length == 8192 && mCache8192 == null) {
                    mCache8192 = bArr;
                }
            }
        }
        return null;
    }

    public static synchronized byte[] getStatic(int i) {
        byte[] bArr;
        synchronized (CacheBytesManager.class) {
            Logger.d("CBM", "cache get:" + i);
            if (i != 1024 || mCache1024 == null) {
                if (i == GLIcon.LEFT) {
                    if (mCache4096 != null) {
                        bArr = mCache4096;
                        mCache4096 = null;
                    }
                }
                if (i == 8192) {
                    if (mCache8192 != null) {
                        bArr = mCache8192;
                        mCache8192 = null;
                    }
                }
                bArr = new byte[i];
            } else {
                bArr = mCache1024;
                mCache1024 = null;
            }
        }
        return bArr;
    }
}
