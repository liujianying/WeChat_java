package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.g;
import com.tencent.liteav.m;
import com.tencent.liteav.o;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;

public class TXLivePlayer implements a {
    public static final int PLAY_TYPE_LIVE_FLV = 1;
    public static final int PLAY_TYPE_LIVE_RTMP = 0;
    public static final int PLAY_TYPE_LIVE_RTMP_ACC = 5;
    public static final int PLAY_TYPE_LOCAL_VIDEO = 6;
    public static final int PLAY_TYPE_VOD_FLV = 2;
    public static final int PLAY_TYPE_VOD_HLS = 3;
    public static final int PLAY_TYPE_VOD_MP4 = 4;
    public static final String TAG = "TXLivePlayer";
    private ITXAudioRawDataListener mAudioRawDataListener;
    private int mAudioRoute = 0;
    private boolean mAutoPlay = true;
    private TXLivePlayConfig mConfig;
    private Context mContext;
    private boolean mEnableHWDec = false;
    private boolean mIsNeedClearLastImg = true;
    private ITXLivePlayListener mListener;
    private boolean mMute = false;
    private String mPlayUrl = "";
    private m mPlayer;
    private float mRate = 1.0f;
    private int mRenderMode;
    private int mRenderRotation;
    private boolean mSnapshotRunning = false;
    private Surface mSurface;
    private TXCloudVideoView mTXCloudVideoView;
    private ITXVideoRawDataListener mVideoRawDataListener = null;

    public TXLivePlayer(Context context) {
        TXCLog.init();
        this.mListener = null;
        this.mContext = context.getApplicationContext();
    }

    public void setConfig(TXLivePlayConfig tXLivePlayConfig) {
        TXCLog.d(TAG, "liteav_api setConfig");
        this.mConfig = tXLivePlayConfig;
        if (this.mConfig == null) {
            this.mConfig = new TXLivePlayConfig();
        }
        if (this.mPlayer != null) {
            g f = this.mPlayer.f();
            if (f == null) {
                f = new g();
            }
            f.a = this.mConfig.mCacheTime;
            f.f = this.mConfig.mAutoAdjustCacheTime;
            f.c = this.mConfig.mMinAutoAdjustCacheTime;
            f.b = this.mConfig.mMaxAutoAdjustCacheTime;
            f.d = this.mConfig.mConnectRetryCount;
            f.e = this.mConfig.mConnectRetryInterval;
            f.g = this.mConfig.mEnableAec;
            f.i = this.mConfig.mEnableNearestIP;
            f.k = this.mConfig.mRtmpChannelType;
            f.h = this.mEnableHWDec;
            f.l = this.mConfig.mCacheFolderPath;
            f.m = this.mConfig.mMaxCacheItems;
            f.j = this.mConfig.mEnableMessage;
            f.n = this.mConfig.mHeaders;
            this.mPlayer.a(f);
        }
    }

    public void setPlayerView(TXCloudVideoView tXCloudVideoView) {
        TXCLog.d(TAG, "liteav_api setPlayerView old view : " + this.mTXCloudVideoView + ", new view : " + tXCloudVideoView);
        this.mTXCloudVideoView = tXCloudVideoView;
        if (this.mPlayer != null) {
            this.mPlayer.a(tXCloudVideoView);
        }
    }

    public void setSurface(Surface surface) {
        TXCLog.d(TAG, "liteav_api setSurface old : " + this.mSurface + ", new : " + surface);
        this.mSurface = surface;
        if (this.mSurface != null) {
            enableHardwareDecode(true);
        }
        if (this.mPlayer != null) {
            this.mPlayer.a(this.mSurface);
        }
    }

    public int startPlay(String str, int i) {
        TXCLog.d(TAG, "liteav_api startPlay");
        if (str == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        TXCDRApi.initCrashReport(this.mContext);
        stopPlay(this.mIsNeedClearLastImg);
        this.mPlayUrl = checkPlayUrl(str, i);
        TXCLog.d(TAG, "===========================================================================================================================================================");
        TXCLog.d(TAG, "===========================================================================================================================================================");
        TXCLog.d(TAG, "=====  StartPlay url = " + this.mPlayUrl + " playType = " + i + " SDKVersion = " + TXCCommonUtil.getSDKID() + " , " + TXCCommonUtil.getSDKVersionStr() + "    ======");
        TXCLog.d(TAG, "===========================================================================================================================================================");
        TXCLog.d(TAG, "===========================================================================================================================================================");
        this.mPlayer = o.a(this.mContext, i);
        if (this.mPlayer == null) {
            return -2;
        }
        setConfig(this.mConfig);
        if (this.mTXCloudVideoView != null) {
            this.mTXCloudVideoView.clearLog();
            this.mTXCloudVideoView.setVisibility(0);
        }
        this.mPlayer.a(this.mTXCloudVideoView);
        this.mPlayer.a(this);
        this.mPlayer.c(this.mAutoPlay);
        if (this.mSurface != null) {
            this.mPlayer.a(this.mSurface);
        }
        this.mPlayer.a(this.mPlayUrl, i);
        this.mPlayer.b(this.mMute);
        this.mPlayer.a(this.mRate);
        this.mPlayer.b(this.mRenderRotation);
        this.mPlayer.a(this.mRenderMode);
        setAudioRoute(this.mAudioRoute);
        this.mPlayer.a(this.mAudioRawDataListener);
        setVideoRawDataListener(this.mVideoRawDataListener);
        return 0;
    }

    public int stopPlay(boolean z) {
        TXCLog.d(TAG, "liteav_api stopPlay " + z);
        if (z && this.mTXCloudVideoView != null) {
            this.mTXCloudVideoView.setVisibility(8);
        }
        if (this.mPlayer != null) {
            this.mPlayer.a(z);
        }
        this.mPlayUrl = "";
        return 0;
    }

    public boolean isPlaying() {
        if (this.mPlayer != null) {
            return this.mPlayer.c();
        }
        return false;
    }

    public void pause() {
        TXCLog.d(TAG, "liteav_api pause");
        if (this.mPlayer != null) {
            TXCLog.w(TAG, "pause play");
            this.mPlayer.a();
        }
    }

    public void resume() {
        TXCLog.d(TAG, "liteav_api resume");
        if (this.mPlayer != null) {
            TXCLog.w(TAG, "resume play");
            this.mPlayer.b();
            setAudioRoute(this.mAudioRoute);
        }
    }

    public void seek(int i) {
        TXCLog.d(TAG, "liteav_api ");
        if (this.mPlayer != null) {
            this.mPlayer.e(i);
        }
    }

    public void setPlayListener(ITXLivePlayListener iTXLivePlayListener) {
        TXCLog.d(TAG, "liteav_api setPlayListener");
        this.mListener = iTXLivePlayListener;
    }

    public void setVideoRecordListener(ITXVideoRecordListener iTXVideoRecordListener) {
        TXCLog.d(TAG, "liteav_api setVideoRecordListener");
        if (this.mPlayer != null) {
            this.mPlayer.a(iTXVideoRecordListener);
        }
    }

    public int startRecord(int i) {
        TXCLog.d(TAG, "liteav_api startRecord");
        if (VERSION.SDK_INT < 18) {
            TXCLog.e(TAG, "API levl is too low (record need 18, current is" + VERSION.SDK_INT + ")");
            return -3;
        } else if (!isPlaying()) {
            TXCLog.e(TAG, "startRecord: there is no playing stream");
            return -1;
        } else if (this.mPlayer != null) {
            return this.mPlayer.c(i);
        } else {
            return -1;
        }
    }

    public int stopRecord() {
        TXCLog.d(TAG, "liteav_api stopRecord");
        if (this.mPlayer != null) {
            return this.mPlayer.e();
        }
        return -1;
    }

    public void setRenderMode(int i) {
        TXCLog.d(TAG, "liteav_api setRenderMode " + i);
        this.mRenderMode = i;
        if (this.mPlayer != null) {
            this.mPlayer.a(i);
        }
    }

    public void setRenderRotation(int i) {
        TXCLog.d(TAG, "liteav_api setRenderRotation " + i);
        this.mRenderRotation = i;
        if (this.mPlayer != null) {
            this.mPlayer.b(i);
        }
    }

    public boolean enableHardwareDecode(boolean z) {
        TXCLog.d(TAG, "liteav_api enableHardwareDecode " + z);
        if (!z && this.mSurface != null) {
            return false;
        }
        if (z) {
            if (VERSION.SDK_INT < 18) {
                TXCLog.e("HardwareDecode", "enableHardwareDecode failed, android system build.version = " + VERSION.SDK_INT + ", the minimum build.version should be 18(android 4.3 or later)");
                return false;
            } else if (isAVCDecBlacklistDevices()) {
                TXCLog.e("HardwareDecode", "enableHardwareDecode failed, MANUFACTURER = " + Build.MANUFACTURER + ", MODEL" + Build.MODEL);
                return false;
            }
        }
        this.mEnableHWDec = z;
        if (this.mPlayer != null) {
            g f = this.mPlayer.f();
            if (f == null) {
                f = new g();
            }
            f.h = this.mEnableHWDec;
            this.mPlayer.a(f);
        }
        return true;
    }

    public void setMute(boolean z) {
        TXCLog.d(TAG, "liteav_api setMute " + z);
        this.mMute = z;
        if (this.mPlayer != null) {
            this.mPlayer.b(z);
        }
    }

    public void setAutoPlay(boolean z) {
        TXCLog.d(TAG, "liteav_api setAutoPlay " + z);
        this.mAutoPlay = z;
    }

    public void setRate(float f) {
        TXCLog.d(TAG, "liteav_api setRate " + f);
        this.mRate = f;
        if (this.mPlayer != null) {
            this.mPlayer.a(f);
        }
    }

    public void setAudioRoute(int i) {
        TXCLog.d(TAG, "liteav_api setAudioRoute " + i);
        this.mAudioRoute = i;
        if (this.mPlayer != null) {
            this.mPlayer.a(this.mContext, this.mAudioRoute);
        }
    }

    public void onNotifyEvent(int i, Bundle bundle) {
        if (i == 15001) {
            if (this.mTXCloudVideoView != null) {
                this.mTXCloudVideoView.setLogText(bundle, null, 0);
            }
            if (this.mListener != null) {
                this.mListener.onNetStatus(bundle);
                return;
            }
            return;
        }
        if (this.mTXCloudVideoView != null) {
            this.mTXCloudVideoView.setLogText(null, bundle, i);
        }
        if (this.mListener != null) {
            this.mListener.onPlayEvent(i, bundle);
        }
    }

    public boolean addVideoRawData(byte[] bArr) {
        TXCLog.d(TAG, "liteav_api addVideoRawData " + bArr);
        if (this.mPlayUrl == null || this.mPlayUrl.isEmpty()) {
            return false;
        }
        if (this.mEnableHWDec) {
            TXLog.e(TAG, "can not addVideoRawData because of hw decode has set!");
            return false;
        } else if (this.mPlayer == null) {
            TXCLog.e(TAG, "player hasn't created or not instanceof live player");
            return false;
        } else {
            this.mPlayer.a(bArr);
            return true;
        }
    }

    public void setVideoRawDataListener(ITXVideoRawDataListener iTXVideoRawDataListener) {
        TXCLog.d(TAG, "liteav_api setVideoRawDataListener " + iTXVideoRawDataListener);
        this.mVideoRawDataListener = iTXVideoRawDataListener;
        if (this.mPlayer != null) {
            if (iTXVideoRawDataListener != null) {
                this.mPlayer.a(new 1(this, iTXVideoRawDataListener));
            } else {
                this.mPlayer.a(null);
            }
        }
    }

    public void snapshot(ITXSnapshotListener iTXSnapshotListener) {
        TXCLog.d(TAG, "liteav_api snapshot " + iTXSnapshotListener);
        if (!this.mSnapshotRunning && iTXSnapshotListener != null) {
            TextureView d;
            this.mSnapshotRunning = true;
            if (this.mPlayer != null) {
                d = this.mPlayer.d();
            } else {
                d = null;
            }
            if (d != null) {
                Bitmap bitmap;
                try {
                    bitmap = d.getBitmap();
                } catch (OutOfMemoryError e) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    int i = 0;
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, i, bitmap.getWidth(), bitmap.getHeight(), d.getTransform(null), true);
                    bitmap.recycle();
                    bitmap = createBitmap;
                }
                postBitmapToMainThread(iTXSnapshotListener, bitmap);
                return;
            }
            this.mSnapshotRunning = false;
        }
    }

    public void setAudioRawDataListener(ITXAudioRawDataListener iTXAudioRawDataListener) {
        TXCLog.d(TAG, "liteav_api setAudioRawDataListener " + iTXAudioRawDataListener);
        this.mAudioRawDataListener = iTXAudioRawDataListener;
        if (this.mPlayer != null) {
            this.mPlayer.a(iTXAudioRawDataListener);
        }
    }

    private boolean isAVCDecBlacklistDevices() {
        if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI") && Build.MODEL.equalsIgnoreCase("Che2-TL00")) {
            return true;
        }
        return false;
    }

    private String checkPlayUrl(String str, int i) {
        int i2 = 0;
        if (i != 6) {
            try {
                byte[] bytes = str.getBytes("UTF-8");
                StringBuilder stringBuilder = new StringBuilder(bytes.length);
                while (true) {
                    int i3 = i2;
                    if (i3 >= bytes.length) {
                        break;
                    }
                    i2 = bytes[i3] < (byte) 0 ? bytes[i3] + 256 : bytes[i3];
                    if (i2 <= 32 || i2 >= 127 || i2 == 34 || i2 == 37 || i2 == 60 || i2 == 62 || i2 == 91 || i2 == 125 || i2 == 92 || i2 == 93 || i2 == 94 || i2 == 96 || i2 == 123 || i2 == 124) {
                        stringBuilder.append(String.format("%%%02X", new Object[]{Integer.valueOf(i2)}));
                    } else {
                        stringBuilder.append((char) i2);
                    }
                    i2 = i3 + 1;
                }
                str = stringBuilder.toString();
            } catch (Exception e) {
            }
        }
        return str.trim();
    }

    private void postBitmapToMainThread(ITXSnapshotListener iTXSnapshotListener, Bitmap bitmap) {
        if (iTXSnapshotListener != null) {
            new Handler(Looper.getMainLooper()).post(new 2(this, iTXSnapshotListener, bitmap));
        }
    }
}
