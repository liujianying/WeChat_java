package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.f.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.module.a;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.mm.plugin.appbrand.s$l;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public class TXCStreamUploader extends a implements b {
    public static final int RTMPSENDSTRATEGY_LIVE = 1;
    public static final int RTMPSENDSTRATEGY_REALTIME_QUIC = 3;
    public static final int RTMPSENDSTRATEGY_REALTIME_TCP = 2;
    static final String TAG = "TXCStreamUploader";
    public static final int TXE_UPLOAD_ERROR_ALLADDRESS_FAILED = 11011;
    public static final int TXE_UPLOAD_ERROR_NET_DISCONNECT = 11012;
    public static final int TXE_UPLOAD_ERROR_NET_RECONNECT = 11016;
    public static final int TXE_UPLOAD_ERROR_NO_DATA = 11013;
    public static final int TXE_UPLOAD_ERROR_NO_NETWORK = 11015;
    public static final int TXE_UPLOAD_ERROR_READ_FAILED = 11017;
    public static final int TXE_UPLOAD_ERROR_WRITE_FAILED = 11018;
    public static final int TXE_UPLOAD_INFO_CONNECT_FAILED = 11006;
    public static final int TXE_UPLOAD_INFO_CONNECT_SUCCESS = 11001;
    public static final int TXE_UPLOAD_INFO_HANDSHAKE_FAIL = 11005;
    public static final int TXE_UPLOAD_INFO_NET_BUSY = 11003;
    public static final int TXE_UPLOAD_INFO_PUBLISH_START = 11008;
    public static final int TXE_UPLOAD_INFO_PUSH_BEGIN = 11002;
    public static final int TXE_UPLOAD_INFO_ROOM_IN = 11021;
    public static final int TXE_UPLOAD_INFO_ROOM_NEED_REENTER = 11024;
    public static final int TXE_UPLOAD_INFO_ROOM_OUT = 11022;
    public static final int TXE_UPLOAD_INFO_ROOM_USERLIST = 11023;
    public static final int TXE_UPLOAD_INFO_SERVER_REFUSE = 11007;
    public static final int TXE_UPLOAD_MODE_AUDIO_ONLY = 1;
    public static final int TXE_UPLOAD_MODE_LINK_MIC = 2;
    public static final int TXE_UPLOAD_MODE_REAL_TIME = 0;
    public static final int TXE_UPLOAD_PROTOCOL_AV = 1;
    public static final int TXE_UPLOAD_PROTOCOL_RTMP = 0;
    private final int MSG_EVENT = s$l.AppCompatTheme_checkboxStyle;
    private final int MSG_RECONNECT = s$l.AppCompatTheme_buttonStyleSmall;
    private final int MSG_REPORT_STATUS = s$l.AppCompatTheme_checkedTextViewStyle;
    private final int MSG_RTMPPROXY_HEARTBEAT = 104;
    private int mChannelType = 0;
    private int mConnectCountQuic = 0;
    private int mConnectCountTcp = 0;
    private long mConnectSuccessTimeStamps = 0;
    private Context mContext = null;
    private int mCurrentRecordIdx = 0;
    private boolean mEnableNearestIP = true;
    private long mGoodPushTime = 30000;
    private Handler mHandler = null;
    private HandlerThread mHandlerThread = null;
    private c mIntelligentRoute = null;
    private ArrayList<a> mIpList = null;
    private boolean mIsPushing = false;
    private int mLastNetworkType = 255;
    private long mLastTimeStamp = 0;
    private UploadStats mLastUploadStats = null;
    private WeakReference<com.tencent.liteav.basic.c.a> mNotifyListener = null;
    private g mParam = null;
    private long mPushStartTS = 0;
    private boolean mQuicChannel = false;
    private int mRetryCount = 0;
    private long mRtmpMsgRecvThreadInstance = 0;
    private Object mRtmpMsgRecvThreadLock = new Object();
    private boolean mRtmpProxyEnable = false;
    private int mRtmpProxyIPIndex = 0;
    private Vector<String> mRtmpProxyIPList = new Vector();
    private long mRtmpProxyInstance = 0;
    private Object mRtmpProxyLock = new Object();
    private a mRtmpProxyParam = new a(this);
    private String mRtmpUrl = "";
    private Thread mThread = null;
    private Object mThreadLock = null;
    private long mUploaderInstance = 0;
    private Vector<b> mVecPendingNAL = new Vector();

    private native void nativeCacheJNIParams();

    private native void nativeEnableDrop(long j, boolean z);

    private native UploadStats nativeGetStats(long j);

    private native long nativeInitRtmpMsgRecvThreadInstance(long j, long j2);

    private native long nativeInitRtmpProxyInstance(long j, long j2, String str, long j3, String str2, long j4, long j5, String str3, boolean z);

    private native long nativeInitUploader(String str, String str2, boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    private native void nativeOnThreadRun(long j);

    private native void nativePushAAC(long j, byte[] bArr, long j2);

    private native void nativePushNAL(long j, byte[] bArr, int i, long j2, long j3, long j4);

    private native void nativeReleaseJNIParams();

    private native void nativeRtmpMsgRecvThreadStart(long j);

    private native void nativeRtmpMsgRecvThreadStop(long j);

    private native void nativeRtmpProxyEnterRoom(long j);

    private native void nativeRtmpProxyLeaveRoom(long j);

    private native void nativeRtmpProxySendHeartBeat(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11);

    private native void nativeSendRtmpProxyMsg(long j, byte[] bArr);

    private native void nativeSetSendStrategy(long j, int i);

    private native void nativeSetVideoDropParams(long j, boolean z, int i, int i2);

    private native void nativeStopPush(long j);

    private native void nativeUninitRtmpMsgRecvThreadInstance(long j);

    private native void nativeUninitRtmpProxyInstance(long j);

    private native void nativeUninitUploader(long j);

    static {
        com.tencent.liteav.basic.util.a.d();
    }

    public void setNotifyListener(com.tencent.liteav.basic.c.a aVar) {
        this.mNotifyListener = new WeakReference(aVar);
    }

    public TXCStreamUploader(Context context, g gVar) {
        this.mContext = context;
        if (gVar == null) {
            gVar = new g();
            gVar.a = 0;
            gVar.g = 3;
            gVar.f = 3;
            gVar.h = 40;
            gVar.i = 1000;
            gVar.j = true;
        }
        this.mParam = gVar;
        this.mThreadLock = new Object();
        this.mIntelligentRoute = new c();
        this.mIntelligentRoute.a = this;
        this.mUploaderInstance = 0;
        this.mRetryCount = 0;
        this.mCurrentRecordIdx = 0;
        this.mIpList = null;
        this.mIsPushing = false;
        this.mThread = null;
        this.mRtmpUrl = null;
        this.mLastNetworkType = 255;
        this.mHandlerThread = null;
    }

    public void setRetryInterval(int i) {
        if (this.mParam != null) {
            this.mParam.g = i;
        }
    }

    public void setAudioInfo(int i, int i2) {
        if (this.mParam != null) {
            this.mParam.d = i2;
            this.mParam.e = i;
        }
    }

    public void setRetryTimes(int i) {
        if (this.mParam != null) {
            this.mParam.f = i;
        }
    }

    public void setMode(int i) {
        if (this.mParam != null) {
            this.mParam.a = i;
        }
    }

    private void postReconnectMsg(String str, boolean z, int i) {
        Message message = new Message();
        message.what = s$l.AppCompatTheme_buttonStyleSmall;
        message.obj = str;
        message.arg1 = z ? 2 : 1;
        if (this.mHandler != null) {
            this.mHandler.sendMessageDelayed(message, (long) i);
        }
    }

    public void onFetchDone(int i, ArrayList<a> arrayList) {
        if (this.mIsPushing) {
            if (arrayList != null) {
                TXCLog.e(TAG, "onFetchDone: code = " + i + " ip count = " + arrayList.size());
                if (i == 0) {
                    this.mIpList = arrayList;
                    this.mCurrentRecordIdx = 0;
                }
            }
            if (this.mIpList == null || this.mIpList.size() <= 0) {
                this.mParam.m = false;
            } else {
                Iterator it = this.mIpList.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar != null && aVar.c && aVar.a != null && aVar.a.length() > 0) {
                        i2++;
                    }
                    i2 = i2;
                }
                setStatusValue(7016, Long.valueOf((long) i2));
            }
            b rtmpRealConnectInfo = getRtmpRealConnectInfo();
            postReconnectMsg(rtmpRealConnectInfo.a, rtmpRealConnectInfo.b, 0);
        }
    }

    public int init() {
        return 0;
    }

    public String start(String str, boolean z, int i) {
        if (this.mIsPushing) {
            return this.mRtmpUrl;
        }
        this.mIsPushing = true;
        this.mConnectSuccessTimeStamps = 0;
        this.mRetryCount = 0;
        this.mRtmpUrl = str;
        this.mChannelType = i;
        this.mPushStartTS = 0;
        this.mConnectCountQuic = 0;
        this.mConnectCountTcp = 0;
        this.mRtmpProxyEnable = false;
        this.mRtmpProxyParam.a();
        this.mRtmpProxyIPList.clear();
        this.mRtmpProxyIPIndex = 0;
        this.mRtmpProxyInstance = 0;
        this.mRtmpMsgRecvThreadInstance = 0;
        setStatusValue(7016, Long.valueOf(0));
        setStatusValue(7017, Long.valueOf(0));
        setStatusValue(7018, Long.valueOf(0));
        TXCLog.d(TAG, "start push with url:" + this.mRtmpUrl + " enable nearest ip:" + (z ? "yes" : "no") + "channel type:" + i);
        if (com.tencent.liteav.basic.util.a.c(this.mContext) == 255) {
            sendNotifyEvent(TXE_UPLOAD_ERROR_NO_NETWORK);
            return this.mRtmpUrl;
        }
        this.mEnableNearestIP = z;
        if (this.mHandlerThread == null) {
            this.mHandlerThread = new HandlerThread("RTMP_PUSH");
            this.mHandlerThread.start();
        }
        this.mHandler = new 1(this, this.mHandlerThread.getLooper());
        parseProxyInfo(str);
        if (this.mRtmpProxyEnable) {
            this.mLastNetworkType = com.tencent.liteav.basic.util.a.c(this.mContext);
            nativeCacheJNIParams();
        } else if (this.mEnableNearestIP && this.mLastNetworkType != com.tencent.liteav.basic.util.a.c(this.mContext)) {
            TXCLog.d(TAG, "fetching nearest ip list");
            this.mIntelligentRoute.a(str, i);
            this.mHandler.sendEmptyMessageDelayed(s$l.AppCompatTheme_checkedTextViewStyle, 2000);
            return this.mRtmpUrl;
        }
        startPushTask(this.mRtmpUrl, this.mQuicChannel, 0);
        this.mHandler.sendEmptyMessageDelayed(s$l.AppCompatTheme_checkedTextViewStyle, 2000);
        return this.mRtmpUrl;
    }

    public void stop() {
        if (this.mIsPushing) {
            this.mIsPushing = false;
            TXCLog.d(TAG, "stop push");
            if (this.mRtmpProxyEnable) {
                synchronized (this.mRtmpProxyLock) {
                    nativeRtmpProxyLeaveRoom(this.mRtmpProxyInstance);
                }
            }
            synchronized (this.mThreadLock) {
                nativeStopPush(this.mUploaderInstance);
                this.mPushStartTS = 0;
            }
            if (this.mHandlerThread != null) {
                this.mHandlerThread.getLooper().quit();
                this.mHandlerThread = null;
            }
            if (this.mHandler != null) {
                this.mHandler = null;
            }
            if (this.mRtmpProxyEnable) {
                nativeReleaseJNIParams();
            }
        }
    }

    private void tryResetRetryCount() {
        if (this.mConnectSuccessTimeStamps != 0 && TXCTimeUtil.getTimeTick() - this.mConnectSuccessTimeStamps > ((long) ((this.mParam.f * (this.mParam.g + 13)) * 1000))) {
            this.mRetryCount = 0;
            this.mConnectSuccessTimeStamps = 0;
            TXCLog.d(TAG, "reset retry count");
        }
    }

    public void pushAAC(byte[] bArr, long j) {
        tryResetRetryCount();
        synchronized (this.mThreadLock) {
            if (this.mPushStartTS == 0) {
                this.mPushStartTS = j - 3600000;
            }
            nativePushAAC(this.mUploaderInstance, bArr, j - this.mPushStartTS);
        }
    }

    public void pushNAL(b bVar) {
        tryResetRetryCount();
        synchronized (this.mThreadLock) {
            if (this.mUploaderInstance != 0) {
                if (this.mPushStartTS == 0) {
                    this.mPushStartTS = bVar.h - 3600000;
                }
                if (!(bVar == null || bVar.a == null || bVar.a.length <= 0)) {
                    nativePushNAL(this.mUploaderInstance, bVar.a, bVar.b, bVar.e, bVar.g - this.mPushStartTS, bVar.h - this.mPushStartTS);
                }
            } else {
                if (bVar.b == 0) {
                    this.mVecPendingNAL.removeAllElements();
                }
                this.mVecPendingNAL.add(bVar);
            }
        }
    }

    public void setDropEanble(boolean z) {
        TXCLog.d(TAG, "drop enable " + (z ? "yes" : "no"));
        synchronized (this.mThreadLock) {
            nativeEnableDrop(this.mUploaderInstance, z);
        }
    }

    public void setVideoDropParams(boolean z, int i, int i2) {
        TXCLog.d(TAG, "drop params wait i frame:" + (z ? "yes" : "no") + " max video count:" + i + " max video cache time: " + i2 + " ms");
        synchronized (this.mThreadLock) {
            this.mParam.j = z;
            this.mParam.h = i;
            this.mParam.i = i2;
            if (this.mUploaderInstance != 0) {
                nativeSetVideoDropParams(this.mUploaderInstance, this.mParam.j, this.mParam.h, this.mParam.i);
            }
        }
    }

    public void setSendStrategy(boolean z) {
        if (this.mParam.m != z) {
            synchronized (this.mThreadLock) {
                if (this.mUploaderInstance != 0 && (this.mIpList == null || this.mIpList.size() == 0)) {
                    z = false;
                }
                long j = this.mUploaderInstance;
                int i = z ? this.mQuicChannel ? 3 : 2 : 1;
                nativeSetSendStrategy(j, i);
            }
        }
        this.mParam.m = z;
    }

    public UploadStats getUploadStats() {
        UploadStats nativeGetStats;
        synchronized (this.mThreadLock) {
            nativeGetStats = nativeGetStats(this.mUploaderInstance);
            if (nativeGetStats != null) {
                nativeGetStats.channelType = this.mQuicChannel ? 2 : 1;
            }
        }
        return nativeGetStats;
    }

    private void startPushTask(String str, boolean z, int i) {
        TXCLog.d(TAG, "start push task");
        if (this.mQuicChannel != z && this.mQuicChannel) {
            TXCDRApi.reportEvent40003(this.mRtmpUrl, com.tencent.liteav.basic.datareport.a.M, "switch video push channel from quic to tcp", "limits:" + this.mParam.f + " current:" + this.mRetryCount);
        }
        int i2;
        if (z) {
            i2 = this.mConnectCountQuic + 1;
            this.mConnectCountQuic = i2;
            setStatusValue(7017, Long.valueOf((long) i2));
        } else {
            i2 = this.mConnectCountTcp + 1;
            this.mConnectCountTcp = i2;
            setStatusValue(7018, Long.valueOf((long) i2));
        }
        this.mThread = new 2(this, "RTMPUpload", z, str);
        this.mThread.start();
    }

    private void stopPushTask() {
        TXCLog.d(TAG, "stop push task");
        synchronized (this.mThreadLock) {
            this.mVecPendingNAL.removeAllElements();
            nativeStopPush(this.mUploaderInstance);
        }
    }

    private b getRtmpRealConnectInfo() {
        int i = 1;
        if (!this.mEnableNearestIP) {
            return new b(this, this.mRtmpUrl, false);
        }
        if (this.mIpList == null) {
            return new b(this, this.mRtmpUrl, false);
        }
        if (this.mCurrentRecordIdx >= this.mIpList.size() || this.mCurrentRecordIdx < 0) {
            return new b(this, this.mRtmpUrl, false);
        }
        a aVar = (a) this.mIpList.get(this.mCurrentRecordIdx);
        String[] split = this.mRtmpUrl.split("://");
        if (split.length < 2) {
            return new b(this, this.mRtmpUrl, false);
        }
        String[] split2 = split[1].split("/");
        split2[0] = aVar.a + ":" + aVar.b;
        StringBuilder stringBuilder = new StringBuilder(split2[0]);
        while (i < split2.length) {
            stringBuilder.append("/");
            stringBuilder.append(split2[i]);
            i++;
        }
        return new b(this, split[0] + "://" + stringBuilder.toString(), aVar.c);
    }

    private boolean nextRecordIdx(boolean z) {
        if (this.mIpList == null || this.mIpList.size() == 0) {
            return false;
        }
        if (z) {
            a aVar = (a) this.mIpList.get(this.mCurrentRecordIdx);
            aVar.d++;
        }
        if (this.mCurrentRecordIdx >= this.mIpList.size()) {
            return false;
        }
        this.mCurrentRecordIdx++;
        if (this.mCurrentRecordIdx != this.mIpList.size()) {
            return true;
        }
        this.mCurrentRecordIdx = 0;
        return false;
    }

    private void reconnect(boolean z) {
        stopPushTask();
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new 3(this, z), (long) (this.mParam.g * 1000));
        }
    }

    private void internalReconnect(boolean z) {
        if (!this.mIsPushing) {
            return;
        }
        if (this.mRtmpProxyEnable) {
            if (this.mLastNetworkType != com.tencent.liteav.basic.util.a.c(this.mContext)) {
                TXCLog.e(TAG, "reconnect network switch from " + this.mLastNetworkType + " to " + com.tencent.liteav.basic.util.a.c(this.mContext));
                this.mLastNetworkType = com.tencent.liteav.basic.util.a.c(this.mContext);
                this.mRetryCount = 0;
                sendNotifyEvent(TXE_UPLOAD_INFO_ROOM_NEED_REENTER, String.format("网络类型发生变化，需要重新进房", new Object[0]));
            } else if (this.mRetryCount < this.mParam.f) {
                this.mRetryCount++;
                TXCDRApi.reportEvent40003(this.mRtmpUrl, com.tencent.liteav.basic.datareport.a.F, "reconnect rtmp-proxy server", "reconnect retry count:" + this.mRetryCount + " retry limit:" + this.mParam.f);
                sendNotifyEvent(TXE_UPLOAD_ERROR_NET_RECONNECT);
                startPushTask(this.mRtmpUrl, this.mQuicChannel, 0);
            } else if (getNextRtmpProxyIP()) {
                this.mRetryCount = 0;
                TXCDRApi.reportEvent40003(this.mRtmpUrl, com.tencent.liteav.basic.datareport.a.F, "reconnect rtmp-proxy server", "reconnect retry count:" + this.mRetryCount + " retry limit:" + this.mParam.f);
                sendNotifyEvent(TXE_UPLOAD_ERROR_NET_RECONNECT);
                startPushTask(this.mRtmpUrl, this.mQuicChannel, 0);
            } else {
                TXCDRApi.reportEvent40003(this.mRtmpUrl, com.tencent.liteav.basic.datareport.a.E, "connect rtmp-proxy server failed", "try all addresses");
                sendNotifyEvent(TXE_UPLOAD_ERROR_ALLADDRESS_FAILED);
            }
        } else if (!this.mEnableNearestIP || this.mLastNetworkType == com.tencent.liteav.basic.util.a.c(this.mContext)) {
            if (!this.mEnableNearestIP) {
                z = false;
            }
            if (this.mQuicChannel) {
                z = true;
            }
            TXCLog.e(TAG, "reconnect change ip: " + z + " enableNearestIP: " + this.mEnableNearestIP + " last channel type: " + (this.mQuicChannel ? "Q Channel" : "TCP"));
            if (!z || nextRecordIdx(true)) {
                b rtmpRealConnectInfo = getRtmpRealConnectInfo();
                if (this.mQuicChannel) {
                    TXCLog.e(TAG, "reconnect last channel type is Q Channel");
                    TXCDRApi.reportEvent40003(this.mRtmpUrl, com.tencent.liteav.basic.datareport.a.F, "reconnect upload server", "reconnect last channel type is Q Channel");
                    startPushTask(rtmpRealConnectInfo.a, rtmpRealConnectInfo.b, 0);
                    sendNotifyEvent(TXE_UPLOAD_ERROR_NET_RECONNECT);
                    return;
                }
                TXCLog.e(TAG, "reconnect retry count:" + this.mRetryCount + " retry limit:" + this.mParam.f);
                if (this.mRetryCount < this.mParam.f) {
                    this.mRetryCount++;
                    TXCDRApi.reportEvent40003(this.mRtmpUrl, com.tencent.liteav.basic.datareport.a.F, "reconnect upload server", "reconnect retry count:" + this.mRetryCount + " retry limit:" + this.mParam.f);
                    startPushTask(rtmpRealConnectInfo.a, rtmpRealConnectInfo.b, 0);
                    sendNotifyEvent(TXE_UPLOAD_ERROR_NET_RECONNECT);
                    return;
                }
                TXCDRApi.reportEvent40003(this.mRtmpUrl, com.tencent.liteav.basic.datareport.a.E, "connect upload server failed", "try all times");
                sendNotifyEvent(TXE_UPLOAD_ERROR_NET_DISCONNECT);
                return;
            }
            TXCDRApi.reportEvent40003(this.mRtmpUrl, com.tencent.liteav.basic.datareport.a.E, "connect upload server failed", "try all addresses");
            sendNotifyEvent(TXE_UPLOAD_ERROR_ALLADDRESS_FAILED);
        } else {
            TXCLog.e(TAG, "reconnect network switch from " + this.mLastNetworkType + " to " + com.tencent.liteav.basic.util.a.c(this.mContext));
            this.mLastNetworkType = com.tencent.liteav.basic.util.a.c(this.mContext);
            this.mIntelligentRoute.a(this.mRtmpUrl, this.mChannelType);
            this.mRetryCount = 0;
        }
    }

    private void sendNotifyEvent(int i, String str) {
        if (str == null || str.isEmpty()) {
            sendNotifyEvent(i);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("EVT_MSG", str);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        switch (i) {
            case TXE_UPLOAD_INFO_CONNECT_FAILED /*11006*/:
                i = 3002;
                break;
            case TXE_UPLOAD_ERROR_READ_FAILED /*11017*/:
                i = 3005;
                break;
            case TXE_UPLOAD_ERROR_WRITE_FAILED /*11018*/:
                i = 3005;
                break;
            case TXE_UPLOAD_INFO_ROOM_IN /*11021*/:
                i = 1018;
                break;
            case TXE_UPLOAD_INFO_ROOM_OUT /*11022*/:
                i = 1019;
                break;
            case TXE_UPLOAD_INFO_ROOM_USERLIST /*11023*/:
                i = 1020;
                break;
            case TXE_UPLOAD_INFO_ROOM_NEED_REENTER /*11024*/:
                i = 1021;
                break;
        }
        com.tencent.liteav.basic.util.a.a(this.mNotifyListener, i, bundle);
    }

    private void sendNotifyEvent(int i) {
        if (i == 0) {
            reconnect(false);
        } else if (i == 1) {
            reconnect(true);
        } else {
            if (i == TXE_UPLOAD_INFO_CONNECT_SUCCESS) {
                this.mConnectSuccessTimeStamps = TXCTimeUtil.getTimeTick();
            }
            if (this.mNotifyListener != null) {
                Bundle bundle = new Bundle();
                switch (i) {
                    case TXE_UPLOAD_INFO_CONNECT_SUCCESS /*11001*/:
                        i = 1001;
                        bundle.putString("EVT_MSG", "已经连接rtmp服务器");
                        break;
                    case TXE_UPLOAD_INFO_PUSH_BEGIN /*11002*/:
                        i = 1002;
                        bundle.putString("EVT_MSG", "rtmp开始推流");
                        break;
                    case TXE_UPLOAD_INFO_NET_BUSY /*11003*/:
                        bundle.putString("EVT_MSG", "上行带宽不足，数据发送不及时");
                        i = 1101;
                        break;
                    case TXE_UPLOAD_INFO_HANDSHAKE_FAIL /*11005*/:
                        i = 3003;
                        bundle.putString("EVT_MSG", "RTMP服务器握手失败");
                        break;
                    case TXE_UPLOAD_INFO_CONNECT_FAILED /*11006*/:
                        bundle.putString("EVT_MSG", "连接服务器失败");
                        i = 3002;
                        break;
                    case TXE_UPLOAD_INFO_SERVER_REFUSE /*11007*/:
                        i = 3004;
                        bundle.putString("EVT_MSG", "服务器拒绝连接请求，可能是该推流地址已经被占用");
                        break;
                    case TXE_UPLOAD_INFO_PUBLISH_START /*11008*/:
                        if (this.mRtmpProxyEnable) {
                            synchronized (this.mRtmpMsgRecvThreadLock) {
                                nativeRtmpMsgRecvThreadStart(this.mRtmpMsgRecvThreadInstance);
                            }
                            synchronized (this.mRtmpProxyLock) {
                                nativeRtmpProxyEnterRoom(this.mRtmpProxyInstance);
                            }
                            if (this.mHandler != null) {
                                this.mHandler.sendEmptyMessageDelayed(104, 2000);
                                return;
                            }
                            return;
                        }
                        return;
                    case TXE_UPLOAD_ERROR_ALLADDRESS_FAILED /*11011*/:
                        bundle.putString("EVT_MSG", "所有IP都已经尝试失败,可以放弃治疗");
                        i = -1307;
                        break;
                    case TXE_UPLOAD_ERROR_NET_DISCONNECT /*11012*/:
                        bundle.putString("EVT_MSG", "经连续多次重连失败，放弃重连");
                        i = -1307;
                        break;
                    case TXE_UPLOAD_ERROR_NO_DATA /*11013*/:
                        bundle.putString("EVT_MSG", "超过30s没有数据发送，主动断开连接");
                        i = -1307;
                        break;
                    case TXE_UPLOAD_ERROR_NO_NETWORK /*11015*/:
                        bundle.putString("EVT_MSG", "没有网络，请检测WiFi或移动数据是否开启");
                        i = -1307;
                        break;
                    case TXE_UPLOAD_ERROR_NET_RECONNECT /*11016*/:
                        i = 1102;
                        bundle.putString("EVT_MSG", "启动网络重连");
                        break;
                    default:
                        bundle.putString("EVT_MSG", "UNKNOWN");
                        break;
                }
                bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                com.tencent.liteav.basic.util.a.a(this.mNotifyListener, i, bundle);
            }
        }
    }

    private void reportNetStatus() {
        long timeTick = TXCTimeUtil.getTimeTick();
        long j = timeTick - this.mLastTimeStamp;
        UploadStats uploadStats = getUploadStats();
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        if (uploadStats != null) {
            if (this.mLastUploadStats != null) {
                long longValue = getSpeed(this.mLastUploadStats.inVideoBytes, uploadStats.inVideoBytes, j).longValue();
                long longValue2 = getSpeed(this.mLastUploadStats.inAudioBytes, uploadStats.inAudioBytes, j).longValue();
                long longValue3 = getSpeed(this.mLastUploadStats.outVideoBytes, uploadStats.outVideoBytes, j).longValue();
                j4 = getSpeed(this.mLastUploadStats.outAudioBytes, uploadStats.outAudioBytes, j).longValue();
                j3 = longValue3;
                j2 = longValue2;
                j = longValue;
            } else {
                j = 0;
            }
            setStatusValue(7001, Long.valueOf(j));
            setStatusValue(7002, Long.valueOf(j2));
            setStatusValue(7003, Long.valueOf(j3));
            setStatusValue(7004, Long.valueOf(j4));
            setStatusValue(7005, Long.valueOf(uploadStats.videoCacheLen));
            setStatusValue(7006, Long.valueOf(uploadStats.audioCacheLen));
            setStatusValue(7007, Long.valueOf(uploadStats.videoDropCount));
            setStatusValue(7008, Long.valueOf(uploadStats.audioDropCount));
            setStatusValue(7009, Long.valueOf(uploadStats.startTS));
            setStatusValue(7010, Long.valueOf(uploadStats.dnsTS));
            setStatusValue(7011, Long.valueOf(uploadStats.connTS));
            setStatusValue(7012, String.valueOf(uploadStats.serverIP));
            setStatusValue(7013, Long.valueOf(this.mQuicChannel ? 2 : 1));
            setStatusValue(7014, uploadStats.connectionID);
            setStatusValue(7015, uploadStats.connectionStats);
        }
        this.mLastTimeStamp = timeTick;
        this.mLastUploadStats = uploadStats;
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(s$l.AppCompatTheme_checkedTextViewStyle, 2000);
        }
    }

    private Long getSpeed(long j, long j2, long j3) {
        long j4 = 0;
        if (j <= j2) {
            j2 -= j;
        }
        if (j3 > 0) {
            j4 = ((8 * j2) * 1000) / (1024 * j3);
        }
        return Long.valueOf(j4);
    }

    private boolean isQCloudStreamUrl(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        String str2 = "://";
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return false;
        }
        str2 = str.substring(str2.length() + indexOf);
        if (str2 == null || !str2.startsWith("cloud.tencent.com")) {
            return false;
        }
        return true;
    }

    private void parseProxyInfo(String str) {
        if (str != null && str.length() != 0 && str.startsWith("room")) {
            this.mRtmpProxyParam.i = isQCloudStreamUrl(str);
            HashMap paramsFromUrl = getParamsFromUrl(str);
            if (paramsFromUrl != null) {
                if (paramsFromUrl.containsKey("sdkappid")) {
                    this.mRtmpProxyParam.a = Long.valueOf((String) paramsFromUrl.get("sdkappid")).longValue();
                }
                if (paramsFromUrl.containsKey("roomid") && paramsFromUrl.containsKey("userid") && paramsFromUrl.containsKey("roomsig")) {
                    this.mRtmpProxyParam.d = Long.valueOf((String) paramsFromUrl.get("roomid")).longValue();
                    this.mRtmpProxyParam.c = (String) paramsFromUrl.get("userid");
                    try {
                        JSONObject jSONObject = new JSONObject(URLDecoder.decode((String) paramsFromUrl.get("roomsig"), "UTF-8"));
                        this.mRtmpProxyParam.b = 0;
                        if (jSONObject.has("Key")) {
                            this.mRtmpProxyParam.e = jSONObject.optString("Key");
                            JSONObject optJSONObject = jSONObject.optJSONObject("RtmpProxy");
                            if (optJSONObject == null || (optJSONObject.has("Ip") && optJSONObject.has("Port") && optJSONObject.has("Type"))) {
                                JSONArray optJSONArray = jSONObject.optJSONArray("AccessList");
                                if (optJSONArray != null && optJSONArray.length() > 0) {
                                    for (int i = 0; i < optJSONArray.length(); i++) {
                                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                                        if (jSONObject2 != null && jSONObject2.has("Ip") && jSONObject2.has("Port") && jSONObject2.has("Type")) {
                                            String optString = jSONObject2.optString("Ip");
                                            long optLong = jSONObject2.optLong("Port");
                                            if (jSONObject2.optLong("Type") == 2) {
                                                this.mRtmpProxyIPList.add(optString + ":" + optLong);
                                            }
                                        }
                                    }
                                }
                                if (!this.mRtmpProxyParam.i) {
                                    this.mRtmpUrl = str;
                                    this.mQuicChannel = false;
                                } else if (optJSONObject != null) {
                                    String substring = str.substring(0, str.indexOf("?"));
                                    this.mRtmpUrl = substring + "/webrtc/" + (this.mRtmpProxyParam.a + "_" + this.mRtmpProxyParam.d + "_" + this.mRtmpProxyParam.c) + "?real_rtmp_ip=" + optJSONObject.optString("Ip") + "&real_rtmp_port=" + optJSONObject.optLong("Port") + "&tinyid=" + this.mRtmpProxyParam.b + "&srctinyid=0";
                                    getNextRtmpProxyIP();
                                } else {
                                    return;
                                }
                                this.mRtmpProxyEnable = true;
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
    }

    private HashMap getParamsFromUrl(String str) {
        HashMap hashMap = new HashMap();
        String[] split = str.split("[?]");
        if (!(split == null || split.length < 2 || split[1] == null || split[1].length() == 0)) {
            for (String str2 : split[1].split("[&]")) {
                if (str2.indexOf("=") != -1) {
                    String[] split2 = str2.split("[=]");
                    if (split2.length == 2) {
                        hashMap.put(split2[0], split2[1]);
                    }
                }
            }
        }
        return hashMap;
    }

    private boolean getNextRtmpProxyIP() {
        this.mRtmpProxyParam.f = 234;
        this.mRtmpProxyParam.g = 80;
        if (this.mRtmpProxyIPList == null || this.mRtmpProxyIPList.size() <= 0) {
            return false;
        }
        if (this.mRtmpProxyIPIndex >= this.mRtmpProxyIPList.size()) {
            this.mRtmpProxyIPIndex = 0;
            return false;
        }
        String[] split = this.mRtmpUrl.split("://");
        if (split.length < 2) {
            return false;
        }
        String substring = split[1].substring(split[1].indexOf("/"));
        String str = (String) this.mRtmpProxyIPList.get(this.mRtmpProxyIPIndex);
        this.mRtmpProxyParam.h = str;
        this.mRtmpUrl = "room://" + str + substring;
        this.mQuicChannel = true;
        this.mRtmpProxyIPIndex++;
        return true;
    }

    private void rtmpProxySendHeartBeat() {
        int[] a = com.tencent.liteav.basic.util.a.a();
        long j = (long) (a[0] / 10);
        long j2 = (long) (a[1] / 10);
        long d = (long) TXCStatus.d(getID(), 7004);
        long d2 = (long) TXCStatus.d(getID(), 7003);
        long d3 = (long) TXCStatus.d(getID(), 1001);
        long d4 = (long) TXCStatus.d(getID(), 4001);
        long d5 = (long) TXCStatus.d(getID(), 7006);
        long d6 = (long) TXCStatus.d(getID(), 7005);
        long d7 = (long) TXCStatus.d(getID(), 7008);
        long d8 = (long) TXCStatus.d(getID(), 7007);
        synchronized (this.mRtmpProxyLock) {
            nativeRtmpProxySendHeartBeat(this.mRtmpProxyInstance, j, j2, d, d2, d3, d4, d5, d6, d7, d8);
        }
    }

    private void onSendRtmpProxyMsg(byte[] bArr) {
        synchronized (this.mThreadLock) {
            if (this.mUploaderInstance != 0) {
                nativeSendRtmpProxyMsg(this.mUploaderInstance, bArr);
            }
        }
    }

    private void onRtmpProxyUserListPushed(RtmpProxyUserInfo[] rtmpProxyUserInfoArr) {
        if (rtmpProxyUserInfoArr != null && this.mIsPushing && this.mRtmpProxyEnable && this.mRtmpProxyParam != null) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < rtmpProxyUserInfoArr.length; i++) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("userid", rtmpProxyUserInfoArr[i].account);
                    jSONObject.put("playurl", rtmpProxyUserInfoArr[i].playUrl);
                    jSONArray.put(i, jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("userlist", jSONArray);
                sendNotifyEvent(TXE_UPLOAD_INFO_ROOM_USERLIST, jSONObject2.toString());
            } catch (Exception e) {
            }
        }
    }

    private void onRtmpProxyRoomEvent(int i, int i2) {
        if (i == 1) {
            sendNotifyEvent(TXE_UPLOAD_INFO_ROOM_IN, String.format("已在房间中，[%d]", new Object[]{Integer.valueOf(i2)}));
        } else if (i == 2) {
            sendNotifyEvent(TXE_UPLOAD_INFO_ROOM_OUT, String.format("不在房间中，[%d]", new Object[]{Integer.valueOf(i2)}));
        }
    }
}
