package com.tencent.xweb.extension.video;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.util.Base64;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.util.e;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Timer;
import org.xwalk.core.Log;
import org.xwalk.core.R$id;
import org.xwalk.core.R$layout;
import org.xwalk.core.XWalkEnvironment;

public final class c implements OnGestureListener, OnScaleGestureListener {
    private Window CS;
    private AudioManager dge;
    private WebView eFe;
    Activity mActivity;
    private int mMode = 0;
    private float oUn = 1.0f;
    int tuZ;
    private GestureDetector uG;
    private boolean vBA;
    private long vBB;
    private double vBC;
    private double vBD;
    private double vBE;
    private final int vBF = 0;
    private final int vBG = 1;
    private final int vBH = 2;
    private final int vBI = 3;
    int vBJ = -3;
    private int vBK = 0;
    private double vBL = 0.0d;
    private float vBM = 0.0f;
    private float vBN = 0.0f;
    private a vBO;
    private LayoutParams vBP;
    private String vBQ;
    private Timer vBR;
    private boolean vBS;
    private int vBT = 0;
    private double vBU;
    private int vBV = 200;
    private Drawable vBW;
    private boolean vBX;
    private boolean vBY;
    public boolean vBZ = false;
    private ViewGroup vBj;
    private FrameLayout vBk;
    private SurfaceView vBl;
    View vBm;
    private ViewGroup vBn;
    private VideoStatusLayout vBo;
    private ProgressBar vBp;
    private TextView vBq;
    private TextView vBr;
    private ClickableFrameLayout vBs;
    private LinearLayout vBt;
    private ImageView vBu;
    private ImageView vBv;
    private ImageView vBw;
    private b vBx;
    private CustomViewCallback vBy;
    private ScaleGestureDetector vBz;
    private int vCa;

    public c(Activity activity, WebView webView) {
        this.mActivity = activity;
        this.eFe = webView;
        this.vBk = new FrameLayout(activity);
        this.vBk.setBackgroundColor(-16777216);
        if (webView.isXWalkKernel()) {
            this.vBl = new SurfaceView(activity);
            this.vBl.getHolder().setFormat(-3);
            this.vBl.getHolder().addCallback(new 1(this));
            this.vBl.setZOrderOnTop(false);
            this.vBl.setZOrderMediaOverlay(false);
            this.vBk.addView(this.vBl);
        }
        this.uG = new GestureDetector(activity, this);
        this.vBz = new ScaleGestureDetector(activity, this);
        this.uG.setIsLongpressEnabled(false);
        this.vBn = (ViewGroup) LayoutInflater.from(activity).inflate(R$layout.video_control, null);
        this.vBn.setVisibility(8);
        this.vBx = new b((FrameLayout) this.vBn.findViewById(R$id.player_progress_root), new 12(this));
        this.vBp = (ProgressBar) this.vBn.findViewById(R$id.progressLoading);
        this.vBq = (TextView) this.vBn.findViewById(R$id.tv_current_time);
        this.vBr = (TextView) this.vBn.findViewById(R$id.tv_total_time);
        this.vBu = (ImageView) this.vBn.findViewById(R$id.imageFrame);
        this.vBo = (VideoStatusLayout) this.vBn.findViewById(R$id.layoutStatus);
        this.vBs = (ClickableFrameLayout) this.vBn.findViewById(R$id.layoutBlank);
        this.vBs.setGestureDetector(this.uG);
        this.vBs.setOnTouchListener(new 13(this));
        this.vBv = (ImageView) this.vBn.findViewById(R$id.imageExit);
        this.vBv.setOnClickListener(new 14(this));
        this.vBt = (LinearLayout) this.vBn.findViewById(R$id.layoutVideoControl);
        this.vBt.setVisibility(4);
        this.vBw = (ImageView) this.vBn.findViewById(R$id.imagePlay);
        this.vBw.setOnClickListener(new 15(this));
        ah(activity);
    }

    public final void a(WebView webView, boolean z) {
        if (webView != null && webView.getFullscreenVideoKind() == a.vAM && this.vBQ != null) {
            Log.i("XWebNativeInterface", "evaluteJavascript:" + z);
            String str = this.vBQ;
            if (z) {
                str = "window.addEventListener('DOMContentLoaded', function() {" + this.vBQ + "});this.xwebReturn = function (){return \"1\";};this.xwebReturn()";
            }
            webView.evaluateJavascript(str, new 16(this));
        }
    }

    private void ah(Activity activity) {
        BufferedReader bufferedReader;
        IOException e;
        Throwable th;
        if (this.vBQ == null) {
            Object obj;
            InputStream inputStream;
            File file = new File(XWalkEnvironment.getExtractedCoreFile(XWalkEnvironment.getAvailableVersion(), "xweb_fullscreen_video.js"));
            if (file.isFile() && file.exists()) {
                try {
                    InputStream fileInputStream = new FileInputStream(file);
                    obj = 1;
                    inputStream = fileInputStream;
                } catch (FileNotFoundException e2) {
                    Log.e("XWebNativeInterface", "initJs open jsFile in apk error:" + e2.getMessage());
                }
                if (obj == null) {
                    Log.e("XWebNativeInterface", "initJs try open jsFile in apk error");
                }
                if (obj == null) {
                    InputStreamReader inputStreamReader;
                    try {
                        inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader);
                        } catch (IOException e3) {
                            e = e3;
                            bufferedReader = null;
                            try {
                                Log.e("XWebNativeInterface", "initJs open jsFile in runtime assets error" + e.getMessage());
                                if (inputStreamReader != null) {
                                    try {
                                        inputStreamReader.close();
                                    } catch (Exception e4) {
                                    }
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e5) {
                                    }
                                }
                                if (this.dge == null) {
                                    this.dge = (AudioManager) activity.getSystemService("audio");
                                }
                                this.vBK = this.dge.getStreamMaxVolume(3);
                                this.vBL = (double) this.dge.getStreamVolume(3);
                                if (this.vBO == null) {
                                    this.vBO = new a(activity);
                                }
                                if (this.CS == null) {
                                    this.CS = activity.getWindow();
                                }
                                if (this.vBP == null) {
                                    this.vBP = this.CS.getAttributes();
                                }
                                this.oUn = this.vBP.screenBrightness;
                                if (this.oUn != -1.0f) {
                                    try {
                                        this.oUn = (float) (((double) System.getInt(this.mActivity.getContentResolver(), "screen_brightness")) / 256.0d);
                                    } catch (SettingNotFoundException e6) {
                                        Log.e("XWebNativeInterface", "brightness get error:" + e6.getMessage());
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (inputStreamReader != null) {
                                    try {
                                        inputStreamReader.close();
                                    } catch (Exception e7) {
                                        throw th;
                                    }
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = null;
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (Exception e72) {
                                    throw th;
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            throw th;
                        }
                        try {
                            StringBuffer stringBuffer = new StringBuffer("");
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                stringBuffer.append(readLine);
                                stringBuffer.append("\n");
                            }
                            this.vBQ = stringBuffer.toString();
                            try {
                                inputStreamReader.close();
                                bufferedReader.close();
                            } catch (Exception e8) {
                            }
                        } catch (IOException e9) {
                            e = e9;
                            Log.e("XWebNativeInterface", "initJs open jsFile in runtime assets error" + e.getMessage());
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (Exception e42) {
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e52) {
                                }
                            }
                            if (this.dge == null) {
                                this.dge = (AudioManager) activity.getSystemService("audio");
                            }
                            this.vBK = this.dge.getStreamMaxVolume(3);
                            this.vBL = (double) this.dge.getStreamVolume(3);
                            if (this.vBO == null) {
                                this.vBO = new a(activity);
                            }
                            if (this.CS == null) {
                                this.CS = activity.getWindow();
                            }
                            if (this.vBP == null) {
                                this.vBP = this.CS.getAttributes();
                            }
                            this.oUn = this.vBP.screenBrightness;
                            if (this.oUn != -1.0f) {
                                try {
                                    this.oUn = (float) (((double) System.getInt(this.mActivity.getContentResolver(), "screen_brightness")) / 256.0d);
                                } catch (SettingNotFoundException e62) {
                                    Log.e("XWebNativeInterface", "brightness get error:" + e62.getMessage());
                                }
                            }
                        }
                    } catch (IOException e10) {
                        e = e10;
                        bufferedReader = null;
                        inputStreamReader = null;
                        Log.e("XWebNativeInterface", "initJs open jsFile in runtime assets error" + e.getMessage());
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (Exception e422) {
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e522) {
                            }
                        }
                        if (this.dge == null) {
                            this.dge = (AudioManager) activity.getSystemService("audio");
                        }
                        this.vBK = this.dge.getStreamMaxVolume(3);
                        this.vBL = (double) this.dge.getStreamVolume(3);
                        if (this.vBO == null) {
                            this.vBO = new a(activity);
                        }
                        if (this.CS == null) {
                            this.CS = activity.getWindow();
                        }
                        if (this.vBP == null) {
                            this.vBP = this.CS.getAttributes();
                        }
                        this.oUn = this.vBP.screenBrightness;
                        if (this.oUn != -1.0f) {
                            try {
                                this.oUn = (float) (((double) System.getInt(this.mActivity.getContentResolver(), "screen_brightness")) / 256.0d);
                            } catch (SettingNotFoundException e622) {
                                Log.e("XWebNativeInterface", "brightness get error:" + e622.getMessage());
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedReader = null;
                        inputStreamReader = null;
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (Exception e722) {
                                throw th;
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th;
                    }
                }
                Log.e("XWebNativeInterface", "initJs open jsFile final error");
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e5222) {
                    }
                }
            }
            obj = null;
            inputStream = null;
            if (obj == null) {
                Log.e("XWebNativeInterface", "initJs try open jsFile in apk error");
            }
            if (obj == null) {
                Log.e("XWebNativeInterface", "initJs open jsFile final error");
            } else {
                InputStreamReader inputStreamReader2;
                try {
                    inputStreamReader2 = new InputStreamReader(inputStream, "UTF-8");
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader2);
                    } catch (IOException e32) {
                        e = e32;
                        bufferedReader = null;
                        try {
                            Log.e("XWebNativeInterface", "initJs open jsFile in runtime assets error" + e.getMessage());
                            if (inputStreamReader2 != null) {
                                try {
                                    inputStreamReader2.close();
                                } catch (Exception e4222) {
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e52222) {
                                }
                            }
                            if (this.dge == null) {
                                this.dge = (AudioManager) activity.getSystemService("audio");
                            }
                            this.vBK = this.dge.getStreamMaxVolume(3);
                            this.vBL = (double) this.dge.getStreamVolume(3);
                            if (this.vBO == null) {
                                this.vBO = new a(activity);
                            }
                            if (this.CS == null) {
                                this.CS = activity.getWindow();
                            }
                            if (this.vBP == null) {
                                this.vBP = this.CS.getAttributes();
                            }
                            this.oUn = this.vBP.screenBrightness;
                            if (this.oUn != -1.0f) {
                                try {
                                    this.oUn = (float) (((double) System.getInt(this.mActivity.getContentResolver(), "screen_brightness")) / 256.0d);
                                } catch (SettingNotFoundException e6222) {
                                    Log.e("XWebNativeInterface", "brightness get error:" + e6222.getMessage());
                                }
                            }
                        } catch (Throwable th22) {
                            th = th22;
                            if (inputStreamReader2 != null) {
                                try {
                                    inputStreamReader2.close();
                                } catch (Exception e7222) {
                                    throw th;
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th32) {
                        th = th32;
                        bufferedReader = null;
                        if (inputStreamReader2 != null) {
                            try {
                                inputStreamReader2.close();
                            } catch (Exception e72222) {
                                throw th;
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th;
                    }
                    try {
                        StringBuffer stringBuffer2 = new StringBuffer("");
                        while (true) {
                            String readLine2 = bufferedReader.readLine();
                            if (readLine2 == null) {
                                break;
                            }
                            stringBuffer2.append(readLine2);
                            stringBuffer2.append("\n");
                        }
                        this.vBQ = stringBuffer2.toString();
                        try {
                            inputStreamReader2.close();
                            bufferedReader.close();
                        } catch (Exception e82) {
                        }
                    } catch (IOException e92) {
                        e = e92;
                        Log.e("XWebNativeInterface", "initJs open jsFile in runtime assets error" + e.getMessage());
                        if (inputStreamReader2 != null) {
                            try {
                                inputStreamReader2.close();
                            } catch (Exception e42222) {
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e522222) {
                            }
                        }
                        if (this.dge == null) {
                            this.dge = (AudioManager) activity.getSystemService("audio");
                        }
                        this.vBK = this.dge.getStreamMaxVolume(3);
                        this.vBL = (double) this.dge.getStreamVolume(3);
                        if (this.vBO == null) {
                            this.vBO = new a(activity);
                        }
                        if (this.CS == null) {
                            this.CS = activity.getWindow();
                        }
                        if (this.vBP == null) {
                            this.vBP = this.CS.getAttributes();
                        }
                        this.oUn = this.vBP.screenBrightness;
                        if (this.oUn != -1.0f) {
                            try {
                                this.oUn = (float) (((double) System.getInt(this.mActivity.getContentResolver(), "screen_brightness")) / 256.0d);
                            } catch (SettingNotFoundException e62222) {
                                Log.e("XWebNativeInterface", "brightness get error:" + e62222.getMessage());
                            }
                        }
                    }
                } catch (IOException e102) {
                    e = e102;
                    bufferedReader = null;
                    inputStreamReader2 = null;
                    Log.e("XWebNativeInterface", "initJs open jsFile in runtime assets error" + e.getMessage());
                    if (inputStreamReader2 != null) {
                        try {
                            inputStreamReader2.close();
                        } catch (Exception e422222) {
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e5222222) {
                        }
                    }
                    if (this.dge == null) {
                        this.dge = (AudioManager) activity.getSystemService("audio");
                    }
                    this.vBK = this.dge.getStreamMaxVolume(3);
                    this.vBL = (double) this.dge.getStreamVolume(3);
                    if (this.vBO == null) {
                        this.vBO = new a(activity);
                    }
                    if (this.CS == null) {
                        this.CS = activity.getWindow();
                    }
                    if (this.vBP == null) {
                        this.vBP = this.CS.getAttributes();
                    }
                    this.oUn = this.vBP.screenBrightness;
                    if (this.oUn != -1.0f) {
                        try {
                            this.oUn = (float) (((double) System.getInt(this.mActivity.getContentResolver(), "screen_brightness")) / 256.0d);
                        } catch (SettingNotFoundException e622222) {
                            Log.e("XWebNativeInterface", "brightness get error:" + e622222.getMessage());
                        }
                    }
                } catch (Throwable th42) {
                    th = th42;
                    bufferedReader = null;
                    inputStreamReader2 = null;
                    if (inputStreamReader2 != null) {
                        try {
                            inputStreamReader2.close();
                        } catch (Exception e722222) {
                            throw th;
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e52222222) {
                }
            }
        }
        if (this.dge == null) {
            this.dge = (AudioManager) activity.getSystemService("audio");
        }
        this.vBK = this.dge.getStreamMaxVolume(3);
        this.vBL = (double) this.dge.getStreamVolume(3);
        if (this.vBO == null) {
            this.vBO = new a(activity);
        }
        if (this.CS == null) {
            this.CS = activity.getWindow();
        }
        if (this.vBP == null) {
            this.vBP = this.CS.getAttributes();
        }
        this.oUn = this.vBP.screenBrightness;
        if (this.oUn != -1.0f) {
            try {
                this.oUn = (float) (((double) System.getInt(this.mActivity.getContentResolver(), "screen_brightness")) / 256.0d);
            } catch (SettingNotFoundException e6222222) {
                Log.e("XWebNativeInterface", "brightness get error:" + e6222222.getMessage());
            }
        }
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        Log.i("XWebNativeInterface", "onShowCustomView");
        this.vBm = view;
        this.vBy = customViewCallback;
        if (this.vBm != null || this.eFe.isXWalkKernel()) {
            if (this.eFe.isXWalkKernel()) {
                e.cIO();
            } else if (this.eFe.isSysKernel()) {
                e.cIS();
            }
            Log.i("XWebNativeInterface", "attach");
            if (this.vBZ) {
                Log.i("XWebNativeInterface", "attach has entered fullscreen");
                return;
            }
            mY(true);
            ViewParent viewParent = (FrameLayout) this.mActivity.getWindow().getDecorView();
            if (this.eFe.isXWalkKernel() && this.vBk.getParent() == viewParent && this.vBm != null) {
                this.vBk.addView(this.vBm, 0, new FrameLayout.LayoutParams(-1, -1, 17));
            } else if (this.vBk.getParent() != viewParent) {
                viewParent.addView(this.vBk, new FrameLayout.LayoutParams(-1, -1, 17));
                if (this.vBm != null) {
                    this.vBk.addView(this.vBm, this.vBk.getChildCount(), new FrameLayout.LayoutParams(-1, -1, 17));
                    if (this.eFe.isSysKernel()) {
                        this.vBm.setVisibility(4);
                    }
                }
                if (this.eFe.isXWalkKernel()) {
                    this.vBj = (ViewGroup) this.eFe.getParent();
                    this.vBj.removeView(this.eFe);
                    this.vBk.addView(this.eFe, this.vBk.getChildCount());
                }
                this.vBk.addView(this.vBn, this.vBk.getChildCount(), new FrameLayout.LayoutParams(-1, -1, 17));
                this.vBW = this.eFe.getBackground();
                this.eFe.setBackgroundColor(-16777216);
                if (this.eFe.isSysKernel()) {
                    this.vBk.postDelayed(new 11(this), (long) this.vBV);
                }
            }
        }
    }

    public final void onHideCustomView() {
        if (this.vBy != null) {
            this.vBy.onCustomViewHidden();
        }
        Log.i("XWebNativeInterface", "detach");
        if (this.vBZ) {
            if (this.vBW != null) {
                this.eFe.setBackground(this.vBW);
                this.vBW = null;
            }
            if (this.vBk.getParent() == ((ViewGroup) this.mActivity.getWindow().getDecorView())) {
                if (this.eFe.isXWalkKernel()) {
                    this.vBk.removeView(this.eFe);
                    this.vBj.addView(this.eFe, 0);
                }
                if (this.vBm != null) {
                    this.vBk.removeView(this.vBm);
                }
                this.vBk.removeView(this.vBn);
                this.vBn.setVisibility(8);
                if (this.vBJ != -3) {
                    this.mActivity.setRequestedOrientation(this.vBJ);
                    this.vBJ = -3;
                }
                mY(false);
                if (this.vBk.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.vBk.getParent()).removeView(this.vBk);
                    return;
                }
                return;
            }
            return;
        }
        Log.i("XWebNativeInterface", "detach has exited fullscreen");
    }

    private void ag(Runnable runnable) {
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(runnable);
        }
    }

    public final void cIz() {
        if (this.vBR != null) {
            this.vBR.cancel();
            this.vBR.purge();
            this.vBR = null;
        }
        this.vBR = new Timer();
        this.vBR.schedule(new 17(this), 4000);
    }

    public final void cIA() {
        if (this.vBR != null) {
            this.vBR.cancel();
            this.vBR.purge();
            this.vBR = null;
        }
    }

    public final boolean onDown(MotionEvent motionEvent) {
        this.vBT = 0;
        return true;
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        cIA();
        if (this.vBS) {
            cIC();
        } else {
            cIB();
        }
        return true;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent == null || motionEvent2 == null) {
            return true;
        }
        float width;
        float height;
        float x = motionEvent2.getX() - motionEvent.getX();
        float y = motionEvent2.getY() - motionEvent.getY();
        if (this.vBn.getHeight() > this.vBn.getWidth()) {
            width = (float) this.vBn.getWidth();
            height = (float) this.vBn.getHeight();
        } else {
            width = (float) this.vBn.getHeight();
            height = (float) this.vBn.getWidth();
        }
        double ceil;
        switch (this.vBT) {
            case 0:
                if (Math.abs(x) - Math.abs(y) <= 1.0f) {
                    ah(this.mActivity);
                    ceil = Math.ceil((double) (25.0f * this.eFe.getContext().getResources().getDisplayMetrics().density));
                    if (((double) motionEvent.getY()) >= 2.0d * ceil && ((double) motionEvent.getY()) <= ((double) this.vBn.getHeight()) - (ceil * 2.0d)) {
                        if (motionEvent.getX() >= ((float) this.vBn.getWidth()) / 2.0f) {
                            this.vBT = 1;
                            break;
                        }
                        this.vBT = 2;
                        break;
                    }
                    this.vBT = 0;
                    break;
                }
                this.vBT = 3;
                break;
                break;
            case 1:
                x = y * -1.0f;
                double d = (double) (((((float) this.vBK) * x) / width) * 1.2f);
                int i = (int) d;
                if (i == 0 && Math.abs(d) > 0.20000000298023224d) {
                    if (x > 0.0f) {
                        i = 1;
                    } else if (x < 0.0f) {
                        i = -1;
                    }
                }
                ceil = ((double) i) + this.vBL;
                if (ceil > ((double) this.vBK)) {
                    ceil = (double) this.vBK;
                } else if (ceil < 0.0d) {
                    ceil = 0.0d;
                }
                this.dge.setStreamVolume(3, (int) ceil, 4);
                this.vBo.setVolumnProgress((int) ((ceil / ((double) Float.valueOf((float) this.vBK).floatValue())) * 100.0d));
                this.vBo.show();
                break;
            case 2:
                height = (((-1.0f * y) / width) * 1.2f) + this.oUn;
                if (height < 0.0f) {
                    height = 0.0f;
                } else if (height > 1.0f) {
                    height = 1.0f;
                }
                this.vBP.screenBrightness = height;
                this.CS.setAttributes(this.vBP);
                this.vBo.setBrightProgress((int) (height * 100.0f));
                this.vBo.show();
                break;
            case 3:
                width = motionEvent2.getX() - motionEvent.getX();
                this.vBN = this.vBx.tua;
                if (width > 0.0f) {
                    this.vBM = (float) ((int) (((width / height) * 100.0f) + this.vBN));
                    if (this.vBM > 100.0f) {
                        this.vBM = 100.0f;
                    }
                } else {
                    this.vBM = (float) ((int) (((width / height) * 100.0f) + this.vBN));
                    if (this.vBM < 0.0f) {
                        this.vBM = 0.0f;
                    }
                }
                ceil = (this.vBC * ((double) this.vBM)) / 100.0d;
                this.vBo.setVideoTimeProgress(q(ceil, this.vBC) + "/" + q(this.vBC, this.vBC));
                this.vBo.show();
                this.vBU = ceil;
                break;
        }
        return true;
    }

    public final void onLongPress(MotionEvent motionEvent) {
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        if (this.mMode != 1 || this.vBm == null) {
            return false;
        }
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        this.vBm.getLeft();
        this.vBm.getTop();
        this.vBm.getBottom();
        this.vBm.getRight();
        int width = (int) (((float) this.vBm.getWidth()) * scaleFactor);
        int height = (int) (scaleFactor * ((float) this.vBm.getHeight()));
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        layoutParams.width = width;
        layoutParams.height = height;
        if (this.vBm == null) {
            return true;
        }
        this.vBm.setLayoutParams(layoutParams);
        return true;
    }

    public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    public final void cIB() {
        ag(new 18(this));
    }

    public final void cIC() {
        ag(new Runnable() {
            public final void run() {
                c.this.vBS = false;
                c.this.vBt.setVisibility(4);
            }
        });
    }

    private void mX(boolean z) {
        ag(new 2(this, z));
    }

    public final void e(final double d, final boolean z) {
        ag(new Runnable() {
            public final void run() {
                if (z && c.this.vBC != 0.0d) {
                    c.this.vBx.c((float) ((int) (100.0d * (d / c.this.vBC))), false);
                }
                c.this.vBq.setText(c.q(d, c.this.vBC));
                c.this.vBr.setText(c.q(c.this.vBC, c.this.vBC));
            }
        });
    }

    private static String q(double d, double d2) {
        String format = String.format("%02d", new Object[]{Integer.valueOf((int) (d / 3600.0d))});
        String format2 = String.format("%02d", new Object[]{Integer.valueOf(((int) (d % 3600.0d)) / 60)});
        String format3 = String.format("%02d", new Object[]{Integer.valueOf(((int) (d % 3600.0d)) % 60)});
        if (d2 > 3600.0d) {
            return String.format("%s:%s:%s", new Object[]{format, format2, format3});
        }
        return String.format("%s:%s", new Object[]{format2, format3});
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoGetFrame(long j, double d, String str) {
        if (j == this.vBB && this.vBU == d && str != null && str.startsWith("data:image/png;base64,")) {
            byte[] decode = Base64.decode(str.substring(22), 0);
            this.vBu.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
            this.vBu.setVisibility(0);
        }
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoPlaying() {
        Log.i("XWebNativeInterface", "onVideoPlaying");
        ag(new 5(this));
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoWaiting() {
        Log.i("XWebNativeInterface", "onVideoWaiting");
        ag(new 6(this));
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoSeeking() {
        Log.i("XWebNativeInterface", "onVideoSeeking");
        ag(new 7(this));
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoSeeked() {
        Log.i("XWebNativeInterface", "onVideoSeeked");
        ag(new 8(this));
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoPlay() {
        Log.i("XWebNativeInterface", "onVideoPlay");
        mX(false);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoPause() {
        Log.i("XWebNativeInterface", "onVideoPause");
        mX(true);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoEnterFullscreen(boolean z, long j, double d, double d2, boolean z2, boolean z3, double d3, double d4, double[] dArr) {
        Log.i("XWebNativeInterface", "onVideoEnterFullscreen:isVideoTag:" + z + ",width:" + d + ",height:" + d2 + ",pause:" + z2 + ",seeking:" + z3 + ",currentTime:" + d3 + ",duration:" + d4);
        if (this.eFe.isXWalkKernel()) {
            e.cIP();
        } else if (this.eFe.isSysKernel()) {
            e.cIT();
        }
        if (z) {
            if (this.eFe.isXWalkKernel()) {
                e.cIQ();
            } else if (this.eFe.isSysKernel()) {
                e.cIU();
            }
            this.vBA = true;
        }
        this.vBB = j;
        this.vBC = d4;
        this.vBD = d;
        this.vBE = d2;
        if (z3) {
            onVideoSeeking();
        } else {
            onVideoSeeked();
        }
        final boolean z4 = z;
        final double d5 = d;
        final double d6 = d2;
        ag(new Runnable() {
            public final void run() {
                if (z4) {
                    c.this.vBn.setVisibility(0);
                }
                c cVar = c.this;
                int i = (int) d5;
                int i2 = (int) d6;
                if (cVar.vBJ == -3) {
                    Activity activity = cVar.mActivity;
                    if (activity != null) {
                        int i3;
                        cVar.vBJ = activity.getRequestedOrientation();
                        if (i <= i2) {
                            activity.setRequestedOrientation(1);
                            i3 = 1;
                        } else {
                            activity.setRequestedOrientation(0);
                            i3 = 0;
                        }
                        cVar.tuZ = i3;
                        if (cVar.vBm != null) {
                            int min;
                            View view = cVar.vBm;
                            Display defaultDisplay = ((WindowManager) cVar.mActivity.getSystemService("window")).getDefaultDisplay();
                            Point point = new Point(0, 0);
                            defaultDisplay.getSize(point);
                            if (i3 == 0) {
                                i3 = Math.max(point.x, point.y);
                                min = Math.min(point.x, point.y);
                            } else {
                                min = Math.max(point.x, point.y);
                                i3 = Math.min(point.x, point.y);
                            }
                            double d = (((double) i) * 1.0d) / ((double) i2);
                            if (d >= (((double) i3) * 1.0d) / ((double) min)) {
                                min = (int) ((1.0d / d) * ((double) i3));
                            } else {
                                i3 = (int) (d * ((double) min));
                            }
                            view.setLayoutParams(new FrameLayout.LayoutParams(i3, min, 17));
                        }
                    }
                }
            }
        });
        onVideoTimeUpdate(d3, d4, dArr);
        mX(z2);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoExitFullscreen() {
        Log.i("XWebNativeInterface", "onVideoExitFullscreen");
        this.vBA = false;
        ag(new Runnable() {
            public final void run() {
                c.this.vBn.setVisibility(8);
            }
        });
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoTimeUpdate(double d, double d2, double[] dArr) {
        this.vBC = d2;
        e(d, true);
        ag(new 4(this, d2, dArr));
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onSpecialVideoEnterFullscreen(int i) {
        Log.i("XWebNativeInterface", "onSpecialVideoEnterFullscreen:" + i);
        e.at(i, this.eFe.isXWalkKernel());
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onSpecialVideoHook(int i) {
        Log.i("XWebNativeInterface", "onSpecialVideoHook:" + i);
        e.au(i, this.eFe.isXWalkKernel());
    }

    private void mY(boolean z) {
        if (z) {
            if ((this.mActivity.getWindow().getAttributes().flags & 2048) != 0) {
                this.vBY = true;
                this.mActivity.getWindow().clearFlags(2048);
            } else {
                this.vBY = false;
            }
            if (!this.vBZ) {
                if ((this.mActivity.getWindow().getAttributes().flags & 1024) != 0) {
                    this.vBX = true;
                } else {
                    this.vBX = false;
                    this.mActivity.getWindow().addFlags(1024);
                }
                this.vBZ = true;
                return;
            }
            return;
        }
        if (this.vBY) {
            this.mActivity.getWindow().addFlags(2048);
        }
        if (!this.vBX) {
            this.mActivity.getWindow().clearFlags(1024);
        }
        this.vCa = 0;
        this.vBZ = false;
        this.vBA = false;
    }
}
