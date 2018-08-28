package com.tencent.rtmp;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaFormat;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.audio.TXCAudioUGCRecorder;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.f.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.c;
import com.tencent.liteav.d;
import com.tencent.liteav.f;
import com.tencent.liteav.l;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.liteav.network.g;
import com.tencent.liteav.qos.TXCQoS;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ao;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public class TXLivePusher implements a, c.a, l, com.tencent.liteav.qos.a {
    public static final int RGB_BGRA = 4;
    public static final int RGB_RGBA = 5;
    private static final String TAG = TXLivePusher.class.getSimpleName();
    public static final int YUV_420P = 3;
    public static final int YUV_420SP = 1;
    public static final int YUV_420YpCbCr = 2;
    private AudioCustomProcessListener mAudioProcessListener;
    private c mCaptureAndEnc = null;
    private TXLivePushConfig mConfig = null;
    private Context mContext = null;
    private d mDataReport = null;
    private String mID = "";
    private boolean mIsRecording = false;
    private ITXLivePushListener mListener = null;
    private com.tencent.liteav.muxer.c mMP4Muxer = null;
    private Handler mMainHandler = null;
    private ArrayList<MsgInfo> mMsgArray = new ArrayList();
    private f mNewConfig = null;
    private boolean mNotifyStatus = false;
    private VideoCustomProcessListener mPreprocessListener;
    private String mPushUrl = "";
    private TXCQoS mQos = null;
    private ITXVideoRecordListener mRecordListener;
    private long mRecordStartTime = 0;
    private Runnable mSnapShotTimeOutRunnable = new 2(this);
    private boolean mSnapshotRunning = false;
    private boolean mStartMuxer = false;
    private TXCStreamUploader mStreamUploader = null;
    private TXCloudVideoView mTXCloudVideoView;
    private String mVideoFilePath = "";
    private int mVideoQuality = -1;
    private int mVoiceEnvironment = -1;
    private int mVoiceKind = -1;

    public TXLivePusher(Context context) {
        TXCLog.init();
        this.mNewConfig = new f();
        this.mContext = context.getApplicationContext();
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mCaptureAndEnc = new c(this.mContext);
        this.mCaptureAndEnc.a(this);
    }

    public void setConfig(TXLivePushConfig tXLivePushConfig) {
        TXCLog.d(TAG, "liteav_api setConfig " + tXLivePushConfig);
        if (tXLivePushConfig == null) {
            tXLivePushConfig = new TXLivePushConfig();
        }
        this.mConfig = tXLivePushConfig;
        transferConfig(tXLivePushConfig);
        applyConfig();
    }

    public TXLivePushConfig getConfig() {
        return this.mConfig;
    }

    public void setPushListener(ITXLivePushListener iTXLivePushListener) {
        TXCLog.d(TAG, "liteav_api setPushListener " + iTXLivePushListener);
        this.mListener = iTXLivePushListener;
    }

    public int startPusher(String str) {
        TXCLog.d(TAG, "liteav_api startPusher ");
        TXCLog.d(TAG, "================================================================================================================================================");
        TXCLog.d(TAG, "================================================================================================================================================");
        TXCLog.d(TAG, "============= startPush pushUrl = " + str + " SDKVersion = " + TXCCommonUtil.getSDKID() + " , " + TXCCommonUtil.getSDKVersionStr() + "=============");
        TXCLog.d(TAG, "================================================================================================================================================");
        TXCLog.d(TAG, "================================================================================================================================================");
        this.mPushUrl = str;
        updateId(this.mPushUrl);
        startNetworkModule();
        startEncoder();
        startQosModule();
        startDataReportModule();
        startStatusNotify();
        if (this.mTXCloudVideoView != null) {
            this.mTXCloudVideoView.clearLog();
        }
        return 0;
    }

    public void stopPusher() {
        TXCLog.d(TAG, "liteav_api stopPusher ");
        stopRecord();
        stopStatusNotify();
        stopDataReportModule();
        stopQosModule();
        stopEncoder();
        this.mNewConfig.I = false;
        stopNetworkModule();
    }

    public void pausePusher() {
        TXCLog.d(TAG, "liteav_api pausePusher ");
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.g();
        }
    }

    public void resumePusher() {
        TXCLog.d(TAG, "liteav_api resumePusher ");
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.h();
        }
    }

    public boolean isPushing() {
        if (this.mCaptureAndEnc != null) {
            return this.mCaptureAndEnc.i();
        }
        return false;
    }

    public void startCameraPreview(TXCloudVideoView tXCloudVideoView) {
        TXCLog.d(TAG, "liteav_api startCameraPreview " + tXCloudVideoView);
        if (tXCloudVideoView != null) {
            setConfig(this.mConfig);
            if (this.mNewConfig.F) {
                TXCLog.e(TAG, "enable pure audio push , so can not start preview!");
                return;
            }
            if (!(this.mTXCloudVideoView == tXCloudVideoView || this.mTXCloudVideoView == null)) {
                this.mTXCloudVideoView.removeVideoView();
            }
            this.mTXCloudVideoView = tXCloudVideoView;
            if (this.mCaptureAndEnc == null) {
                this.mCaptureAndEnc = new c(this.mContext);
            }
            this.mCaptureAndEnc.a(this);
            this.mCaptureAndEnc.a(this);
            this.mCaptureAndEnc.a(tXCloudVideoView);
            this.mCaptureAndEnc.b(this.mConfig.mBeautyLevel, this.mConfig.mWhiteningLevel, this.mConfig.mRuddyLevel);
        }
    }

    public void stopCameraPreview(boolean z) {
        TXCLog.d(TAG, "liteav_api stopCameraPreview " + z);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a(z);
        }
    }

    public void switchCamera() {
        TXCLog.d(TAG, "liteav_api switchCamera ");
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.j();
        }
    }

    public boolean turnOnFlashLight(boolean z) {
        TXCLog.d(TAG, "liteav_api turnOnFlashLight " + z);
        if (this.mCaptureAndEnc == null) {
            return false;
        }
        return this.mCaptureAndEnc.b(z);
    }

    public void setMute(boolean z) {
        TXCLog.d(TAG, "liteav_api setMute " + z);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.c(z);
        }
    }

    public void onLogRecord(String str) {
        TXCLog.d("User", str);
    }

    public int sendCustomVideoData(byte[] bArr, int i, int i2, int i3) {
        if (this.mCaptureAndEnc == null) {
            return -1000;
        }
        int i4;
        switch (i) {
            case 3:
                i4 = 1;
                break;
            case 5:
                i4 = 2;
                break;
            default:
                return -1000;
        }
        return this.mCaptureAndEnc.a(bArr, i4, i2, i3);
    }

    public void sendCustomPCMData(byte[] bArr) {
        this.mCaptureAndEnc.a(bArr);
    }

    public int getMaxZoom() {
        if (this.mCaptureAndEnc == null) {
            return 0;
        }
        return this.mCaptureAndEnc.m();
    }

    public boolean setZoom(int i) {
        TXCLog.d(TAG, "liteav_api setZoom " + i);
        if (this.mCaptureAndEnc == null) {
            return false;
        }
        return this.mCaptureAndEnc.i(i);
    }

    public boolean setMirror(boolean z) {
        TXCLog.d(TAG, "liteav_api setMirror " + z);
        if (this.mConfig != null) {
            this.mConfig.setVideoEncoderXMirror(z);
        }
        if (this.mCaptureAndEnc == null) {
            return false;
        }
        this.mCaptureAndEnc.d(z);
        return true;
    }

    public void setExposureCompensation(float f) {
        TXCLog.d(TAG, "liteav_api setExposureCompensation " + f);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.b(f);
        }
    }

    public void setBGMNofify(OnBGMNotify onBGMNotify) {
        TXCLog.d(TAG, "liteav_api setBGMNofify " + onBGMNotify);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a(onBGMNotify);
        }
    }

    public boolean playBGM(String str) {
        TXCLog.d(TAG, "liteav_api playBGM " + str);
        return this.mCaptureAndEnc.c(str);
    }

    public boolean stopBGM() {
        TXCLog.d(TAG, "liteav_api stopBGM ");
        return this.mCaptureAndEnc.n();
    }

    public boolean pauseBGM() {
        TXCLog.d(TAG, "liteav_api pauseBGM ");
        return this.mCaptureAndEnc.o();
    }

    public boolean resumeBGM() {
        TXCLog.d(TAG, "liteav_api resumeBGM ");
        return this.mCaptureAndEnc.p();
    }

    public boolean setMicVolume(float f) {
        TXCLog.d(TAG, "liteav_api setMicVolume " + f);
        return this.mCaptureAndEnc.c(f);
    }

    public boolean setBGMVolume(float f) {
        TXCLog.d(TAG, "liteav_api setBGMVolume " + f);
        return this.mCaptureAndEnc.d(f);
    }

    public int getMusicDuration(String str) {
        return this.mCaptureAndEnc.d(str);
    }

    public void startScreenCapture() {
        TXCLog.d(TAG, "liteav_api startScreenCapture ");
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.k();
        }
    }

    public void stopScreenCapture() {
        TXCLog.d(TAG, "liteav_api stopScreenCapture ");
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.l();
        }
    }

    public void setRenderRotation(int i) {
        TXCLog.d(TAG, "liteav_api setRenderRotation ");
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a(i);
        }
    }

    public void setVideoProcessListener(VideoCustomProcessListener videoCustomProcessListener) {
        TXCLog.d(TAG, "liteav_api setVideoProcessListener " + videoCustomProcessListener);
        this.mPreprocessListener = videoCustomProcessListener;
        if (this.mPreprocessListener == null) {
            if (this.mCaptureAndEnc != null) {
                this.mCaptureAndEnc.a(null);
            }
        } else if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a(this);
        }
    }

    public void setAudioProcessListener(AudioCustomProcessListener audioCustomProcessListener) {
        TXCLog.d(TAG, "liteav_api setAudioProcessListener " + audioCustomProcessListener);
        this.mAudioProcessListener = audioCustomProcessListener;
    }

    public void snapshot(ITXSnapshotListener iTXSnapshotListener) {
        TXCLog.d(TAG, "liteav_api snapshot " + iTXSnapshotListener);
        if (!this.mSnapshotRunning && iTXSnapshotListener != null) {
            com.tencent.liteav.renderer.d dVar = null;
            if (this.mTXCloudVideoView != null) {
                dVar = this.mTXCloudVideoView.getGLSurfaceView();
            }
            if (dVar != null) {
                this.mSnapshotRunning = true;
                dVar.a(new 1(this, iTXSnapshotListener));
                this.mMainHandler.postDelayed(this.mSnapShotTimeOutRunnable, 2000);
                return;
            }
            this.mSnapshotRunning = false;
        }
    }

    public int startRecord(String str) {
        TXCLog.d(TAG, "liteav_api startRecord " + str);
        if (VERSION.SDK_INT < 18) {
            TXCLog.e(TAG, "API levl is too low (record need 18, current is" + VERSION.SDK_INT + ")");
            return -3;
        } else if (this.mIsRecording) {
            TXCLog.w(TAG, "ignore start record when recording");
            return -1;
        } else if (this.mCaptureAndEnc == null || !this.mCaptureAndEnc.i()) {
            TXCLog.w(TAG, "ignore start record when not pushing");
            return -2;
        } else {
            TXCLog.w(TAG, "start record ");
            this.mIsRecording = true;
            this.mVideoFilePath = str;
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            this.mMP4Muxer = new com.tencent.liteav.muxer.c(this.mContext, 1);
            this.mStartMuxer = false;
            this.mMP4Muxer.a(this.mVideoFilePath);
            addAudioTrack();
            TXCDRApi.txReportDAU(this.mContext.getApplicationContext(), com.tencent.liteav.basic.datareport.a.aG);
            if (this.mCaptureAndEnc == null) {
                return 0;
            }
            this.mCaptureAndEnc.r();
            return 0;
        }
    }

    public void stopRecord() {
        TXCLog.d(TAG, "liteav_api stopRecord ");
        if (this.mIsRecording && this.mMP4Muxer != null) {
            int b = this.mMP4Muxer.b();
            TXCLog.w(TAG, "start record ");
            this.mIsRecording = false;
            if (b == 0) {
                AsyncTask.execute(new 3(this, this.mVideoFilePath));
            } else {
                callbackRecordFail();
            }
        }
    }

    public void setVideoRecordListener(ITXVideoRecordListener iTXVideoRecordListener) {
        TXCLog.d(TAG, "liteav_api setVideoRecordListener " + iTXVideoRecordListener);
        this.mRecordListener = iTXVideoRecordListener;
    }

    public boolean setBeautyFilter(int i, int i2, int i3, int i4) {
        TXCLog.d(TAG, "liteav_api setBeautyFilter " + i + ", " + i2 + ", " + i3 + ", " + i4);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.b(i);
            this.mCaptureAndEnc.b(i2, i3, i4);
        }
        if (this.mConfig != null) {
            this.mConfig.mBeautyLevel = i2;
            this.mConfig.mWhiteningLevel = i3;
            this.mConfig.mRuddyLevel = i4;
        }
        return true;
    }

    public void setFilter(Bitmap bitmap) {
        TXCLog.d(TAG, "liteav_api setFilter " + bitmap);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a(bitmap);
        }
    }

    public void setMotionTmpl(String str) {
        TXCLog.d(TAG, "liteav_api motionPath " + str);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a(str);
        }
    }

    @TargetApi(18)
    public boolean setGreenScreenFile(String str) {
        TXCLog.d(TAG, "liteav_api setGreenScreenFile " + str);
        if (this.mCaptureAndEnc != null) {
            return this.mCaptureAndEnc.b(str);
        }
        return false;
    }

    public void setEyeScaleLevel(int i) {
        TXCLog.d(TAG, "liteav_api setEyeScaleLevel " + i);
        if (this.mConfig != null) {
            this.mConfig.setEyeScaleLevel(i);
        }
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.c(i);
        }
    }

    public void setFaceSlimLevel(int i) {
        TXCLog.d(TAG, "liteav_api setFaceSlimLevel " + i);
        if (this.mConfig != null) {
            this.mConfig.setFaceSlimLevel(i);
        }
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.d(i);
        }
    }

    public void setFaceVLevel(int i) {
        TXCLog.d(TAG, "liteav_api setFaceVLevel " + i);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.e(i);
        }
    }

    public void setSpecialRatio(float f) {
        TXCLog.d(TAG, "liteav_api setSpecialRatio " + f);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a(f);
        }
    }

    public void setFaceShortLevel(int i) {
        TXCLog.d(TAG, "liteav_api setFaceShortLevel " + i);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.f(i);
        }
    }

    public void setChinLevel(int i) {
        TXCLog.d(TAG, "liteav_api setChinLevel " + i);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.g(i);
        }
    }

    public void setNoseSlimLevel(int i) {
        TXCLog.d(TAG, "liteav_api setNoseSlimLevel " + i);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.h(i);
        }
    }

    public void setVideoQuality(int i, boolean z, boolean z2) {
        boolean z3;
        boolean z4 = false;
        int i2 = 1;
        TXCLog.d(TAG, "liteav_api setVideoQuality " + i + ", " + z + ", " + z2);
        if (VERSION.SDK_INT < 18 && (i == 2 || i == 3)) {
            i = 1;
        }
        if (this.mConfig == null) {
            this.mConfig = new TXLivePushConfig();
        }
        this.mConfig.setVideoFPS(18);
        switch (i) {
            case 1:
                this.mConfig.enableAEC(false);
                this.mConfig.setHardwareAcceleration(2);
                this.mConfig.setVideoResolution(0);
                this.mConfig.setAudioSampleRate(48000);
                setAdjustStrategy(z, z2);
                this.mConfig.setMinVideoBitrate(ao.CTRL_BYTE);
                this.mConfig.setVideoBitrate(800);
                this.mConfig.setMaxVideoBitrate(800);
                z3 = false;
                break;
            case 2:
                this.mConfig.enableAEC(false);
                this.mConfig.setHardwareAcceleration(2);
                this.mConfig.setVideoResolution(1);
                this.mConfig.setAudioSampleRate(48000);
                setAdjustStrategy(z, z2);
                this.mConfig.setMinVideoBitrate(Downloads.DOWNLOAD_ERR_INTERRUPTED);
                this.mConfig.setVideoBitrate(1200);
                this.mConfig.setMaxVideoBitrate(1500);
                z3 = false;
                break;
            case 3:
                this.mConfig.enableAEC(false);
                this.mConfig.setHardwareAcceleration(1);
                this.mConfig.setVideoResolution(2);
                this.mConfig.setAudioSampleRate(48000);
                setAdjustStrategy(z, z2);
                this.mConfig.setMinVideoBitrate(Downloads.DOWNLOAD_ERR_INTERRUPTED);
                this.mConfig.setVideoBitrate(1800);
                this.mConfig.setMaxVideoBitrate(1800);
                z3 = false;
                break;
            case 4:
                if (VERSION.SDK_INT < 18) {
                    this.mConfig.enableAEC(true);
                    this.mConfig.setHardwareAcceleration(0);
                    this.mConfig.setVideoResolution(0);
                    this.mConfig.setAutoAdjustBitrate(true);
                    this.mConfig.setAutoAdjustStrategy(4);
                    this.mConfig.setMinVideoBitrate(ao.CTRL_BYTE);
                    this.mConfig.setVideoBitrate(800);
                    this.mConfig.setMaxVideoBitrate(800);
                } else if (this.mVideoQuality == 1) {
                    this.mConfig.enableAEC(true);
                    this.mConfig.setHardwareAcceleration(1);
                    this.mConfig.setVideoResolution(0);
                    this.mConfig.setAutoAdjustBitrate(true);
                    this.mConfig.setAutoAdjustStrategy(4);
                    this.mConfig.setMinVideoBitrate(ao.CTRL_BYTE);
                    this.mConfig.setVideoBitrate(800);
                    this.mConfig.setMaxVideoBitrate(800);
                } else if (this.mVideoQuality == 3) {
                    this.mConfig.enableAEC(true);
                    this.mConfig.setHardwareAcceleration(1);
                    this.mConfig.setVideoResolution(2);
                    this.mConfig.setAutoAdjustBitrate(true);
                    this.mConfig.setAutoAdjustStrategy(4);
                    this.mConfig.setMinVideoBitrate(Downloads.DOWNLOAD_ERR_INTERRUPTED);
                    this.mConfig.setVideoBitrate(1800);
                    this.mConfig.setMaxVideoBitrate(1800);
                } else {
                    this.mConfig.enableAEC(true);
                    this.mConfig.setHardwareAcceleration(1);
                    this.mConfig.setVideoResolution(1);
                    this.mConfig.setAutoAdjustBitrate(true);
                    this.mConfig.setAutoAdjustStrategy(4);
                    this.mConfig.setMinVideoBitrate(Downloads.DOWNLOAD_ERR_INTERRUPTED);
                    this.mConfig.setVideoBitrate(1200);
                    this.mConfig.setMaxVideoBitrate(1200);
                }
                this.mConfig.setAudioSampleRate(48000);
                z3 = true;
                break;
            case 5:
                this.mConfig.enableAEC(true);
                this.mConfig.setHardwareAcceleration(1);
                this.mConfig.setVideoResolution(6);
                this.mConfig.setAutoAdjustBitrate(false);
                this.mConfig.setVideoBitrate(350);
                this.mConfig.setAudioSampleRate(48000);
                z3 = true;
                break;
            case 6:
                this.mConfig.enableAEC(true);
                this.mConfig.setHardwareAcceleration(1);
                this.mConfig.setVideoResolution(0);
                this.mConfig.setAudioSampleRate(48000);
                this.mConfig.setAutoAdjustBitrate(true);
                this.mConfig.setAutoAdjustStrategy(5);
                this.mConfig.setMinVideoBitrate(190);
                this.mConfig.setVideoBitrate(TbsListener$ErrorCode.INFO_CODE_BASE);
                this.mConfig.setMaxVideoBitrate(810);
                z3 = true;
                break;
            default:
                this.mConfig.setHardwareAcceleration(2);
                TXCLog.e(TAG, "setVideoPushQuality: invalid quality " + i);
                return;
        }
        this.mVideoQuality = i;
        TXLivePushConfig tXLivePushConfig = this.mConfig;
        if (!z3) {
            z4 = true;
        }
        tXLivePushConfig.enableVideoHardEncoderMainProfile(z4);
        TXLivePushConfig tXLivePushConfig2 = this.mConfig;
        if (!z3) {
            i2 = 3;
        }
        tXLivePushConfig2.setVideoEncodeGop(i2);
        if (this.mNewConfig != null) {
            this.mNewConfig.I = z3;
        }
        setConfig(this.mConfig);
    }

    public void setReverb(int i) {
        TXCLog.d(TAG, "liteav_api setReverb " + i);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.j(i);
        }
    }

    public void setVoiceChangerType(int i) {
        switch (i) {
            case 1:
                this.mVoiceKind = 6;
                this.mVoiceEnvironment = -1;
                break;
            case 2:
                this.mVoiceKind = 4;
                this.mVoiceEnvironment = -1;
                break;
            case 3:
                this.mVoiceKind = 5;
                this.mVoiceEnvironment = -1;
                break;
            case 4:
                this.mVoiceKind = -1;
                this.mVoiceEnvironment = 9;
                break;
            case 5:
                this.mVoiceKind = 536936433;
                this.mVoiceEnvironment = 50;
                break;
            case 6:
                this.mVoiceKind = -1;
                this.mVoiceEnvironment = 5;
                break;
            case 7:
                this.mVoiceKind = 13;
                this.mVoiceEnvironment = 1;
                break;
            case 8:
                this.mVoiceKind = 13;
                this.mVoiceEnvironment = -1;
                break;
            case 9:
                this.mVoiceKind = 10;
                this.mVoiceEnvironment = 4;
                break;
            case 10:
                this.mVoiceKind = 10;
                this.mVoiceEnvironment = 20;
                break;
            case 11:
                this.mVoiceKind = -1;
                this.mVoiceEnvironment = 2;
                break;
            default:
                this.mVoiceKind = -1;
                this.mVoiceEnvironment = -1;
                break;
        }
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a(this.mVoiceKind, this.mVoiceEnvironment);
        }
    }

    public void onNotifyEvent(int i, Bundle bundle) {
        if (this.mMainHandler != null) {
            this.mMainHandler.post(new 4(this, bundle, i));
        }
        transferPushEvent(i, bundle);
    }

    public int onTextureCustomProcess(int i, int i2, int i3) {
        if (this.mPreprocessListener != null) {
            return this.mPreprocessListener.onTextureCustomProcess(i, i2, i3);
        }
        return 0;
    }

    public void onDetectFacePoints(float[] fArr) {
        if (this.mPreprocessListener != null) {
            this.mPreprocessListener.onDetectFacePoints(fArr);
        }
    }

    public void onTextureDestoryed() {
        if (this.mPreprocessListener != null) {
            this.mPreprocessListener.onTextureDestoryed();
        }
    }

    public int onGetEncoderRealBitrate() {
        return TXCStatus.d(this.mID, 4002);
    }

    public int onGetQueueInputSize() {
        int d = TXCStatus.d(this.mID, 7002);
        if (this.mNewConfig.I) {
            return d + TXCStatus.d(this.mID, 7001);
        }
        return d + TXCStatus.d(this.mID, 4002);
    }

    public int onGetQueueOutputSize() {
        if (this.mStreamUploader == null) {
            return 0;
        }
        return TXCStatus.d(this.mID, 7004) + TXCStatus.d(this.mID, 7003);
    }

    public int onGetVideoQueueMaxCount() {
        return 5;
    }

    public int onGetVideoQueueCurrentCount() {
        return TXCStatus.d(this.mID, 7005);
    }

    public int onGetVideoDropCount() {
        return TXCStatus.d(this.mID, 7007);
    }

    public void onEncoderParamsChanged(int i, int i2, int i3) {
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a(i, i2, i3);
        }
        if (!(i2 == 0 || i3 == 0)) {
            this.mNewConfig.a = i2;
            this.mNewConfig.b = i3;
        }
        if (i != 0) {
            this.mNewConfig.c = i;
            TXCDRApi.reportEvent40003(this.mPushUrl, com.tencent.liteav.basic.datareport.a.N, "Qos Result", "mode:" + this.mNewConfig.f + " bitrate:" + i + " videosize:" + this.mNewConfig.a + " * " + this.mNewConfig.b);
        }
    }

    public void onEnableDropStatusChanged(boolean z) {
        if (this.mStreamUploader != null) {
            this.mStreamUploader.setDropEanble(z);
        }
    }

    public void onEncAudio(byte[] bArr, long j, int i, int i2) {
        if (!(this.mStreamUploader == null || bArr == null)) {
            this.mStreamUploader.pushAAC(bArr, j);
        }
        if (this.mIsRecording && this.mMP4Muxer != null && this.mStartMuxer && bArr != null) {
            this.mMP4Muxer.a(bArr, 0, bArr.length, 1000 * j, 0);
        }
    }

    public void onEncVideo(b bVar) {
        if (this.mQos != null) {
            this.mQos.setHasVideo(true);
        }
        if (!(this.mStreamUploader == null || bVar == null || bVar.a == null)) {
            synchronized (this) {
                if (!(this.mMsgArray == null || this.mMsgArray.isEmpty())) {
                    int i;
                    MsgInfo msgInfo;
                    int i2 = 0;
                    Iterator it = this.mMsgArray.iterator();
                    while (true) {
                        i = i2;
                        if (!it.hasNext()) {
                            break;
                        }
                        msgInfo = (MsgInfo) it.next();
                        if (msgInfo.ts > bVar.g) {
                            break;
                        }
                        i2 = ((msgInfo.msg.length <= 10240 ? msgInfo.msg.length : 10240) + 5) + i;
                    }
                    if (i != 0) {
                        Object obj = new byte[(bVar.a.length + i)];
                        Object obj2 = new byte[5];
                        Iterator it2 = this.mMsgArray.iterator();
                        i = 0;
                        int i3 = 0;
                        while (it2.hasNext()) {
                            msgInfo = (MsgInfo) it2.next();
                            if (msgInfo.ts > bVar.g) {
                                break;
                            }
                            int i4 = i + 1;
                            i = msgInfo.msg.length <= 10240 ? msgInfo.msg.length : 10240;
                            int i5 = i + 1;
                            obj2[0] = (byte) ((i5 >> 24) & 255);
                            obj2[1] = (byte) ((i5 >> 16) & 255);
                            obj2[2] = (byte) ((i5 >> 8) & 255);
                            obj2[3] = (byte) (i5 & 255);
                            obj2[4] = (byte) 6;
                            System.arraycopy(obj2, 0, obj, i3, 5);
                            i3 += 5;
                            System.arraycopy(msgInfo.msg, 0, obj, i3, i);
                            i2 = i3 + i;
                            i = i4;
                            i3 = i2;
                        }
                        for (i2 = 0; i2 < i; i2++) {
                            this.mMsgArray.remove(0);
                        }
                        System.arraycopy(bVar.a, 0, obj, i3, bVar.a.length);
                        bVar.a = obj;
                    }
                }
            }
            this.mStreamUploader.pushNAL(bVar);
        }
        if (this.mIsRecording && this.mMP4Muxer != null && bVar != null && bVar.a != null) {
            byte[] transferAvccToAnnexb = transferAvccToAnnexb(bVar.a);
            if (!this.mStartMuxer) {
                if (bVar.b == 0) {
                    MediaFormat parseMediaFormat = parseMediaFormat(transferAvccToAnnexb, this.mCaptureAndEnc.b(), this.mCaptureAndEnc.c());
                    if (parseMediaFormat != null) {
                        this.mMP4Muxer.a(parseMediaFormat);
                        this.mMP4Muxer.a();
                        this.mStartMuxer = true;
                        this.mRecordStartTime = 0;
                    }
                } else {
                    return;
                }
            }
            recordVideoData(bVar, transferAvccToAnnexb);
        }
    }

    public void onRecordPcm(byte[] bArr, long j, int i, int i2, int i3) {
        AudioCustomProcessListener audioCustomProcessListener = this.mAudioProcessListener;
        if (audioCustomProcessListener != null) {
            audioCustomProcessListener.onRecordPcmData(bArr, j, i, i2, i3);
        }
    }

    public void onEncVideoFormat(MediaFormat mediaFormat) {
        if (this.mIsRecording && this.mMP4Muxer != null) {
            this.mMP4Muxer.a(mediaFormat);
            if (!this.mStartMuxer) {
                this.mMP4Muxer.a();
                this.mStartMuxer = true;
                this.mRecordStartTime = 0;
            }
        }
    }

    private void callbackRecordFail() {
        this.mMainHandler.post(new 5(this));
    }

    private void callbackRecordSuccess(String str, String str2) {
        this.mMainHandler.post(new 6(this, str, str2));
    }

    @TargetApi(16)
    private void addAudioTrack() {
        MediaFormat a = com.tencent.liteav.basic.util.a.a(TXCAudioUGCRecorder.getInstance().getSampleRate(), TXCAudioUGCRecorder.getInstance().getChannels(), 2);
        if (this.mMP4Muxer != null) {
            this.mMP4Muxer.b(a);
        }
    }

    @TargetApi(16)
    private MediaFormat parseMediaFormat(byte[] bArr, int i, int i2) {
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i3 + 3 < bArr.length) {
            if (bArr[i3] == (byte) 0 && bArr[i3 + 1] == (byte) 0 && bArr[i3 + 2] == (byte) 1) {
                i4 = 3;
            }
            if (bArr[i3] == (byte) 0 && bArr[i3 + 1] == (byte) 0 && bArr[i3 + 2] == (byte) 0 && bArr[i3 + 3] == (byte) 1) {
                i4 = 4;
            }
            if (i4 <= 0 || i5 + i4 >= i3) {
                i4 = 0;
            } else {
                int i8;
                i5 += i4;
                int i9 = bArr[i5] & 31;
                if (i7 == 0 && i9 == 7) {
                    ByteBuffer allocate = ByteBuffer.allocate(i3 - i5);
                    allocate.put(bArr, i5, i3 - i5);
                    allocate.position(0);
                    createVideoFormat.setByteBuffer("csd-0", allocate);
                    i8 = i3 + i4;
                    i4 = 0;
                    i5 = i3;
                    i7 = 1;
                } else {
                    i8 = i3;
                }
                if (i6 == 0 && i9 == 8) {
                    ByteBuffer allocate2 = ByteBuffer.allocate(i8 - i5);
                    allocate2.put(bArr, i5, i8 - i5);
                    allocate2.position(0);
                    createVideoFormat.setByteBuffer("csd-1", allocate2);
                    i3 = i8 + i4;
                    i4 = 0;
                    i5 = i8;
                    i6 = 1;
                } else {
                    i3 = i8;
                }
                if (!(i7 == 0 || i6 == 0)) {
                    return createVideoFormat;
                }
            }
            i3++;
        }
        return null;
    }

    private void recordVideoData(b bVar, byte[] bArr) {
        if (this.mRecordStartTime == 0) {
            this.mRecordStartTime = bVar.g;
        }
        final long j = bVar.g - this.mRecordStartTime;
        int i = bVar.k == null ? bVar.b == 0 ? 1 : 0 : bVar.k.flags;
        this.mMP4Muxer.b(bArr, 0, bArr.length, bVar.g * 1000, i);
        this.mMainHandler.post(new Runnable() {
            public void run() {
                if (TXLivePusher.this.mRecordListener != null) {
                    TXLivePusher.this.mRecordListener.onRecordProgress(j);
                }
            }
        });
    }

    private void postBitmapToMainThread(ITXSnapshotListener iTXSnapshotListener, Bitmap bitmap) {
        if (iTXSnapshotListener != null) {
            new Handler(Looper.getMainLooper()).post(new 8(this, iTXSnapshotListener, bitmap));
        }
    }

    private void setAdjustStrategy(boolean z, boolean z2) {
        int adjustStrategy = getAdjustStrategy(z, z2);
        if (adjustStrategy == -1) {
            this.mConfig.setAutoAdjustBitrate(false);
            this.mConfig.setAutoAdjustStrategy(-1);
            return;
        }
        this.mConfig.setAutoAdjustBitrate(true);
        this.mConfig.setAutoAdjustStrategy(adjustStrategy);
    }

    private int getAdjustStrategy(boolean z, boolean z2) {
        if (!z) {
            return -1;
        }
        if (z2) {
            return 1;
        }
        return 0;
    }

    private void updateId(String str) {
        String format = String.format("%s-%d", new Object[]{str, Long.valueOf(TXCTimeUtil.getTimeTick() % 10000)});
        if (this.mStreamUploader != null) {
            this.mStreamUploader.setID(format);
        }
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.setID(format);
        }
        if (this.mDataReport != null) {
            this.mDataReport.b(format);
        }
        this.mID = format;
    }

    private void startStatusNotify() {
        this.mNotifyStatus = true;
        if (this.mMainHandler != null) {
            this.mMainHandler.postDelayed(new 9(this), 2000);
        }
    }

    private void stopStatusNotify() {
        this.mNotifyStatus = false;
    }

    private void statusNotify() {
        int[] a = com.tencent.liteav.basic.util.a.a();
        int i = a[0] / 10;
        CharSequence charSequence = i + "/" + (a[1] / 10) + "%";
        int d = TXCStatus.d(this.mID, 7004);
        int d2 = TXCStatus.d(this.mID, 7003);
        int d3 = TXCStatus.d(this.mID, 7007);
        int d4 = TXCStatus.d(this.mID, 7005);
        int d5 = TXCStatus.d(this.mID, 7006);
        CharSequence c = TXCStatus.c(this.mID, 7012);
        double e = TXCStatus.e(this.mID, 4001);
        int d6 = TXCStatus.d(this.mID, 4003);
        Bundle bundle = new Bundle();
        bundle.putInt("NET_SPEED", d2 + d);
        bundle.putInt("VIDEO_FPS", (int) e);
        if (e < 1.0d) {
            e = 15.0d;
        }
        bundle.putInt("VIDEO_GOP", (int) (((double) (((float) ((d6 * 10) / ((int) e))) / 10.0f)) + 0.5d));
        bundle.putInt("DROP_SIZE", d3);
        bundle.putInt("VIDEO_BITRATE", d2);
        bundle.putInt("AUDIO_BITRATE", d);
        bundle.putInt("CODEC_CACHE", d5);
        bundle.putInt("CACHE_SIZE", d4);
        bundle.putCharSequence("SERVER_IP", c);
        bundle.putCharSequence("CPU_USAGE", charSequence);
        if (this.mCaptureAndEnc != null) {
            bundle.putString("AUDIO_PLAY_INFO", this.mCaptureAndEnc.d());
            bundle.putInt("VIDEO_WIDTH", this.mCaptureAndEnc.b());
            bundle.putInt("VIDEO_HEIGHT", this.mCaptureAndEnc.c());
        }
        if (this.mTXCloudVideoView != null) {
            this.mTXCloudVideoView.setLogText(bundle, null, 0);
        }
        if (this.mListener != null) {
            this.mListener.onNetStatus(bundle);
        }
        if (this.mDataReport != null) {
            this.mDataReport.d();
        }
        if (this.mMainHandler != null && this.mNotifyStatus) {
            this.mMainHandler.postDelayed(new 10(this), 2000);
        }
    }

    private void startNetworkModule() {
        int i = 5;
        g gVar = new g();
        gVar.d = com.tencent.liteav.audio.c.a().d();
        gVar.e = com.tencent.liteav.audio.c.a().e();
        gVar.a = 0;
        gVar.c = 20;
        gVar.b = 0;
        gVar.f = 3;
        gVar.j = true;
        gVar.l = true;
        gVar.k = false;
        gVar.h = 40;
        gVar.i = Downloads.MIN_RETYR_AFTER;
        gVar.m = this.mNewConfig.I;
        this.mStreamUploader = new TXCStreamUploader(this.mContext, gVar);
        this.mStreamUploader.setID(this.mID);
        if ((this.mNewConfig.J & 1) != 0) {
            if (this.mStreamUploader != null) {
                this.mStreamUploader.setAudioInfo(this.mNewConfig.q, this.mNewConfig.r);
            }
        } else if (this.mStreamUploader != null) {
            this.mStreamUploader.setAudioInfo(this.mNewConfig.q, 1);
        }
        this.mStreamUploader.setNotifyListener(this);
        this.mPushUrl = this.mStreamUploader.start(this.mPushUrl, this.mNewConfig.G, this.mNewConfig.H);
        if (this.mNewConfig.F) {
            this.mStreamUploader.setMode(1);
        }
        if (this.mNewConfig.I) {
            int i2 = this.mNewConfig.o;
            int i3 = this.mNewConfig.p;
            if (i2 >= 5) {
                i = i2;
            }
            if (i3 > 1) {
                i3 = 1;
            }
            this.mStreamUploader.setRetryInterval(i3);
            this.mStreamUploader.setRetryTimes(i);
            this.mStreamUploader.setVideoDropParams(false, this.mNewConfig.h, TbsLog.TBSLOG_CODE_SDK_BASE);
            this.mStreamUploader.setSendStrategy(true);
            return;
        }
        this.mStreamUploader.setRetryInterval(this.mNewConfig.p);
        this.mStreamUploader.setRetryTimes(this.mNewConfig.o);
        this.mStreamUploader.setVideoDropParams(true, 40, 3000);
        this.mStreamUploader.setSendStrategy(false);
    }

    private void stopNetworkModule() {
        if (this.mStreamUploader != null) {
            this.mStreamUploader.stop();
            this.mStreamUploader.setNotifyListener(null);
            this.mStreamUploader = null;
        }
    }

    private void startQosModule() {
        this.mQos = new TXCQoS(true);
        this.mQos.setListener(this);
        this.mQos.setNotifyListener(this);
        this.mQos.setAutoAdjustBitrate(this.mNewConfig.g);
        this.mQos.setAutoAdjustStrategy(this.mNewConfig.f);
        this.mQos.setDefaultVideoResolution(this.mNewConfig.k);
        this.mQos.setVideoEncBitrate(this.mNewConfig.e, this.mNewConfig.d, this.mNewConfig.c);
        if (this.mNewConfig.g) {
            this.mQos.start(2000);
        }
    }

    private void stopQosModule() {
        if (this.mQos != null) {
            this.mQos.stop();
            this.mQos.setListener(null);
            this.mQos.setNotifyListener(null);
            this.mQos = null;
        }
    }

    private void startDataReportModule() {
        this.mDataReport = new d(this.mContext);
        this.mDataReport.b(this.mID);
        this.mDataReport.a(this.mNewConfig.c);
        this.mDataReport.b(this.mNewConfig.q);
        this.mDataReport.a(this.mNewConfig.a, this.mNewConfig.b);
        this.mDataReport.a(this.mPushUrl);
        this.mDataReport.a();
    }

    private void stopDataReportModule() {
        if (this.mDataReport != null) {
            this.mDataReport.b();
            this.mDataReport = null;
        }
    }

    private void startEncoder() {
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.setID(this.mID);
            this.mCaptureAndEnc.a(this);
            this.mCaptureAndEnc.a(this.mVoiceKind, this.mVoiceEnvironment);
            this.mCaptureAndEnc.e();
        }
    }

    private void stopEncoder() {
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a(null);
            this.mCaptureAndEnc.f();
            this.mCaptureAndEnc.a(null);
        }
    }

    private void transferConfig(TXLivePushConfig tXLivePushConfig) {
        f fVar = this.mNewConfig;
        fVar.c = tXLivePushConfig.mVideoBitrate;
        fVar.e = tXLivePushConfig.mMinVideoBitrate;
        fVar.d = tXLivePushConfig.mMaxVideoBitrate;
        fVar.f = tXLivePushConfig.mAutoAdjustStrategy;
        fVar.g = tXLivePushConfig.mAutoAdjustBitrate;
        fVar.h = tXLivePushConfig.mVideoFPS;
        fVar.i = tXLivePushConfig.mVideoEncodeGop;
        fVar.j = tXLivePushConfig.mHardwareAccel;
        fVar.k = tXLivePushConfig.mVideoResolution;
        fVar.n = tXLivePushConfig.mEnableVideoHardEncoderMainProfile;
        fVar.q = tXLivePushConfig.mAudioSample;
        fVar.r = tXLivePushConfig.mAudioChannels;
        fVar.s = tXLivePushConfig.mEnableAec;
        fVar.w = tXLivePushConfig.mPauseFlag;
        fVar.v = tXLivePushConfig.mPauseFps;
        fVar.t = tXLivePushConfig.mPauseImg;
        fVar.u = tXLivePushConfig.mPauseTime;
        fVar.F = tXLivePushConfig.mEnablePureAudioPush;
        fVar.D = tXLivePushConfig.mTouchFocus;
        fVar.E = tXLivePushConfig.mEnableZoom;
        fVar.x = tXLivePushConfig.mWatermark;
        fVar.y = tXLivePushConfig.mWatermarkX;
        fVar.z = tXLivePushConfig.mWatermarkY;
        fVar.A = tXLivePushConfig.mWatermarkXF;
        fVar.B = tXLivePushConfig.mWatermarkYF;
        fVar.C = tXLivePushConfig.mWatermarkWidth;
        fVar.l = tXLivePushConfig.mHomeOrientation;
        fVar.G = tXLivePushConfig.mEnableNearestIP;
        fVar.H = tXLivePushConfig.mRtmpChannelType;
        fVar.o = tXLivePushConfig.mConnectRetryCount;
        fVar.p = tXLivePushConfig.mConnectRetryInterval;
        fVar.m = tXLivePushConfig.mFrontCamera;
        fVar.J = tXLivePushConfig.mCustomModeType;
        fVar.K = tXLivePushConfig.mVideoEncoderXMirror;
        fVar.L = tXLivePushConfig.mEnableHighResolutionCapture;
        fVar.a();
    }

    private void applyConfig() {
        int i = 5;
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a(this.mNewConfig);
            if (this.mCaptureAndEnc.i()) {
                if (this.mStreamUploader != null) {
                    if (this.mNewConfig.I) {
                        int i2 = this.mNewConfig.o;
                        int i3 = this.mNewConfig.p;
                        if (i2 >= 5) {
                            i = i2;
                        }
                        if (i3 > 1) {
                            i3 = 1;
                        }
                        this.mStreamUploader.setRetryInterval(i3);
                        this.mStreamUploader.setRetryTimes(i);
                        this.mStreamUploader.setVideoDropParams(false, this.mNewConfig.h, TbsLog.TBSLOG_CODE_SDK_BASE);
                        this.mStreamUploader.setSendStrategy(true);
                    } else {
                        this.mStreamUploader.setRetryInterval(this.mNewConfig.p);
                        this.mStreamUploader.setRetryTimes(this.mNewConfig.o);
                        this.mStreamUploader.setVideoDropParams(true, 40, 3000);
                        this.mStreamUploader.setSendStrategy(false);
                    }
                }
                if (this.mQos != null) {
                    this.mQos.stop();
                    this.mQos.setAutoAdjustBitrate(this.mNewConfig.g);
                    this.mQos.setAutoAdjustStrategy(this.mNewConfig.f);
                    this.mQos.setDefaultVideoResolution(this.mNewConfig.k);
                    this.mQos.setVideoEncBitrate(this.mNewConfig.e, this.mNewConfig.d, this.mNewConfig.c);
                    if (this.mNewConfig.g) {
                        this.mQos.start(2000);
                    }
                }
            } else if ((this.mNewConfig.J & 1) != 0) {
                if (this.mStreamUploader != null) {
                    this.mStreamUploader.setAudioInfo(this.mNewConfig.q, this.mNewConfig.r);
                }
            } else if (this.mStreamUploader != null) {
                this.mStreamUploader.setAudioInfo(this.mNewConfig.q, 1);
            }
        }
    }

    private void transferPushEvent(int i, Bundle bundle) {
        int i2;
        switch (i) {
            case -1309:
                i2 = -1309;
                break;
            case -1308:
                i2 = -1308;
                break;
            case -1307:
                i2 = -1307;
                break;
            case -1303:
                i2 = -1303;
                break;
            case -1302:
                i2 = -1302;
                break;
            case -1301:
                i2 = -1301;
                break;
            case 1001:
                i2 = 1001;
                break;
            case 1002:
                i2 = 1002;
                break;
            case 1003:
                i2 = 1003;
                break;
            case 1004:
                i2 = 1004;
                break;
            case 1005:
                i2 = 1005;
                break;
            case 1006:
                i2 = 1006;
                break;
            case 1007:
                i2 = 1007;
                break;
            case 1008:
                i2 = 1008;
                break;
            case 1018:
                i2 = 1018;
                break;
            case 1019:
                i2 = 1019;
                break;
            case 1020:
                i2 = 1020;
                break;
            case 1021:
                i2 = 1021;
                break;
            case 1101:
                i2 = 1101;
                break;
            case 1102:
                i2 = 1102;
                break;
            case 1103:
                i2 = 1103;
                break;
            case 1107:
                i2 = 1107;
                break;
            case 3002:
                i2 = 3002;
                break;
            case 3003:
                i2 = 3003;
                break;
            case 3004:
                i2 = 3004;
                break;
            case 3005:
                i2 = 3005;
                break;
            default:
                TXCLog.w(TAG, "unhandled event : " + i);
                return;
        }
        if (this.mMainHandler != null) {
            this.mMainHandler.post(new 11(this, i2, bundle));
        }
    }

    private byte[] transferAvccToAnnexb(byte[] bArr) {
        int length = bArr.length;
        Object obj = new byte[length];
        System.arraycopy(bArr, 0, obj, 0, length);
        int i = 0;
        while (i + 4 < length) {
            int i2 = ByteBuffer.wrap(bArr, i, 4).getInt();
            if ((i + 4) + i2 <= length) {
                obj[i] = null;
                obj[i + 1] = null;
                obj[i + 2] = null;
                obj[i + 3] = (byte) 1;
            }
            i = (i + i2) + 4;
        }
        return obj;
    }

    private byte[] add_emulation_prevention_three_byte(byte[] bArr) {
        int length = ((bArr.length * 4) / 3) + 2;
        Object obj = new byte[length];
        int i = 0;
        int i2 = 0;
        while (i < bArr.length && i2 < length) {
            if (i + 3 < bArr.length && bArr[i] == (byte) 0 && bArr[i + 1] == (byte) 0 && bArr[i + 2] >= (byte) 0 && bArr[i + 2] <= (byte) 3) {
                int i3 = i2 + 1;
                int i4 = i + 1;
                obj[i2] = bArr[i];
                int i5 = i3 + 1;
                i = i4 + 1;
                obj[i3] = bArr[i4];
                i2 = i5 + 1;
                obj[i5] = 3;
            }
            obj[i2] = bArr[i];
            i++;
            i2++;
        }
        Object obj2 = new byte[i2];
        System.arraycopy(obj, 0, obj2, 0, i2);
        return obj2;
    }

    public void sendMessage(byte[] bArr) {
        synchronized (this) {
            if (this.mMsgArray != null) {
                MsgInfo msgInfo = new MsgInfo(this, null);
                msgInfo.ts = TXCTimeUtil.getTimeTick();
                msgInfo.msg = add_emulation_prevention_three_byte(bArr);
                this.mMsgArray.add(msgInfo);
            }
        }
    }
}
