package com.tencent.liteav.a;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.audio.e;
import com.tencent.liteav.basic.f.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.muxer.c;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.liteav.videoencoder.d;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.microedition.khronos.egl.EGLContext;

public class a implements e, d {
    private com.tencent.liteav.audio.impl.Record.e a = new com.tencent.liteav.audio.impl.Record.e();
    private com.tencent.liteav.videoencoder.a b = new com.tencent.liteav.videoencoder.a();
    private c c;
    private a d;
    private b e;
    private long f = 0;
    private long g = -1;
    private boolean h = false;
    private Handler i = new 1(this, Looper.getMainLooper());

    public static class a {
        public int a = 544;
        public int b = 960;
        public int c = 20;
        public int d = 1000;
        public EGLContext e;
        public String f;
        public String g;
        public int h = 0;
        public int i = 0;
        public int j = 16;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TXCStreamRecordParams: [width=" + this.a);
            stringBuilder.append("; height=" + this.b);
            stringBuilder.append("; fps=" + this.c);
            stringBuilder.append("; bitrate=" + this.d);
            stringBuilder.append("; channels=" + this.h);
            stringBuilder.append("; samplerate=" + this.i);
            stringBuilder.append("; bits=" + this.j);
            stringBuilder.append("; EGLContext=" + this.e);
            stringBuilder.append("; coveriamge=" + this.g);
            stringBuilder.append("; outputpath=" + this.f + "]");
            return stringBuilder.toString();
        }
    }

    public a(Context context) {
        this.c = new c(context, 1);
    }

    public void a(b bVar) {
        this.e = bVar;
    }

    public void a(a aVar) {
        this.d = aVar;
        this.f = 0;
        this.g = -1;
        this.c.a(this.d.f);
        if (aVar.h > 0 && aVar.i > 0 && aVar.j > 0) {
            this.a.a(com.tencent.liteav.audio.c.f, aVar.i, aVar.h, aVar.j, new WeakReference(this));
            this.c.b(com.tencent.liteav.basic.util.a.a(this.d.i, this.d.h, 2));
            this.h = true;
        }
        this.b.setListener(this);
        TXSVideoEncoderParam tXSVideoEncoderParam = new TXSVideoEncoderParam();
        tXSVideoEncoderParam.width = this.d.a;
        tXSVideoEncoderParam.height = this.d.b;
        tXSVideoEncoderParam.fps = this.d.c;
        tXSVideoEncoderParam.glContext = this.d.e;
        tXSVideoEncoderParam.annexb = true;
        tXSVideoEncoderParam.appendSpsPps = false;
        this.b.setBitrate(this.d.d);
        this.b.start(tXSVideoEncoderParam);
    }

    public void a() {
        this.h = false;
        this.a.a();
        this.b.stop();
        if (this.c.b() < 0) {
            this.i.sendMessage(Message.obtain(this.i, 2, 1, 0, "mp4合成失败"));
        } else {
            this.i.sendMessage(Message.obtain(this.i, 2, 0, 0, ""));
        }
    }

    public void a(int i, long j) {
        this.b.pushVideoFrame(i, this.d.a, this.d.b, j);
    }

    public void a(byte[] bArr, long j) {
        if (this.h) {
            this.a.a(bArr, j);
        } else {
            TXCLog.e("TXCStreamRecord", "drainAudio fail because of not init yet!");
        }
    }

    public static String a(Context context, String str) {
        String str2 = null;
        if (context == null) {
            return str2;
        }
        try {
            String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(Long.valueOf(String.valueOf(System.currentTimeMillis() / 1000) + "000").longValue()));
            return new File(a(context), String.format("TXUGC_%s" + str, new Object[]{format})).getAbsolutePath();
        } catch (Exception e) {
            return str2;
        }
    }

    private static String a(Context context) {
        if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            return context.getExternalFilesDir(Environment.DIRECTORY_MOVIES).getPath();
        }
        return context.getFilesDir().getPath();
    }

    private String a(int i) {
        String str;
        switch (i) {
            case 10000002:
                str = "未启动视频编码器";
                break;
            case 10000003:
                str = "非法视频输入参数";
                break;
            case 10000004:
                str = "视频编码初始化失败";
                break;
            case 10000005:
                str = "视频编码失败";
                break;
            default:
                str = "";
                break;
        }
        this.i.sendMessage(Message.obtain(this.i, 2, 1, 0, str));
        return str;
    }

    public void a(byte[] bArr, long j, int i, int i2, int i3) {
    }

    public void b(byte[] bArr, long j, int i, int i2, int i3) {
        this.c.a(bArr, 0, bArr.length, 1000 * j, 1);
    }

    public void a(int i, String str) {
    }

    public void a(b bVar, int i) {
        if (i == 0) {
            this.c.b(bVar.a, 0, bVar.a.length, bVar.g * 1000, bVar.k.flags);
            if (this.g < 0) {
                this.g = bVar.g;
            }
            if (bVar.g > this.f + 500) {
                this.i.sendMessage(Message.obtain(this.i, 1, new Long(bVar.g - this.g)));
                this.f = bVar.g;
                return;
            }
            return;
        }
        TXCLog.e("TXCStreamRecord", "video encode error! errmsg: " + a(i));
    }

    public void a(MediaFormat mediaFormat) {
        this.c.a(mediaFormat);
        if (this.c.c() && this.c.a() < 0) {
            this.i.sendMessage(Message.obtain(this.i, 2, 1, 0, "mp4封装器启动失败"));
        }
    }
}
