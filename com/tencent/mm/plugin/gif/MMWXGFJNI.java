package com.tencent.mm.plugin.gif;

import android.graphics.Bitmap;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public class MMWXGFJNI {
    private static final String TAG = "MicroMsg.JNI.MMWXGF";
    static int mECode;
    static boolean mIsInit;

    public static native int nativeAV2Gif(String str, String str2);

    public static native int nativeAV2Gif(byte[] bArr, byte[] bArr2);

    public static native int nativeDecodeBufferFrame(long j, byte[] bArr, int i, Bitmap bitmap, int[] iArr);

    public static native int nativeDecodeBufferHeader(long j, byte[] bArr, int i);

    public static native int nativeGetOption(long j, byte[] bArr, int i, int[] iArr);

    public static native int nativeInit(String str);

    public static native long nativeInitWxAMDecoder();

    public static native boolean nativeIsWXGF(byte[] bArr, int i);

    public static native int nativeRewindBuffer(long j);

    public static native int nativeUninit(long j);

    static {
        mIsInit = false;
        mECode = -1;
        x.i(TAG, "static MMWXGFJNI");
        if (mIsInit) {
            x.d(TAG, "MMWXGF has init.");
            return;
        }
        boolean z;
        int zj = m.zj();
        x.i(TAG, "loadVoipCodecLib cpuFlag:" + zj);
        if ((zj & 1024) != 0) {
            d.y(ad.getContext(), "libvoipCodec_v7a.so");
        } else if ((zj & 512) != 0) {
            d.y(ad.getContext(), "libvoipCodec.so");
        } else {
            d.y(ad.getContext(), "libvoipCodec_v5.so");
        }
        zj = nativeInit(new File(ad.getContext().getDir("lib", 0), "libvoipCodec_v7a.so").getAbsolutePath());
        mECode = zj;
        if (zj >= 0) {
            z = true;
        } else {
            z = false;
        }
        mIsInit = z;
        x.i(TAG, "native init MMWXGF mECode:%d result:%b :%s", new Object[]{Integer.valueOf(mECode), Boolean.valueOf(mIsInit), r3});
    }

    public static int getErrorCode() {
        return mECode;
    }
}
