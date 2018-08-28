package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Process;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ImageDownloadUI;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.tools.CropImageView.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.lang.reflect.Array;
import junit.framework.Assert;

public class CropImageNewUI extends MMActivity {
    private String filePath;
    private int hop = 0;
    private final int uvS = 1;
    private final int uvT = 0;
    private int uvU;
    private int uvV = 0;
    private FilterImageView uvW;
    private LinearLayout uvX;
    private CropImageView uvY;
    private ImageView uvZ;
    private View uwa;
    private int uwb = 0;
    private boolean uwc = false;
    private boolean uwd = false;
    private boolean uwe = false;

    static /* synthetic */ void a(CropImageNewUI cropImageNewUI, boolean z) {
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_OutputPath");
        if (ai.oW(stringExtra)) {
            stringExtra = cropImageNewUI.filePath;
        } else {
            byte[] e = FileOp.e(cropImageNewUI.filePath, 0, -1);
            FileOp.b(stringExtra, e, e.length);
        }
        Intent intent = new Intent();
        intent.putExtra("CropImage_Compress_Img", z);
        intent.putExtra("CropImage_OutputPath", stringExtra);
        intent.putExtra("CropImage_rotateCount", cropImageNewUI.uvY.getRotateCount() % 4);
        if (cropImageNewUI.uvW != null) {
            intent.putExtra("CropImage_filterId", cropImageNewUI.uvW.getFilterId());
        }
        intent.putExtra("from_source", cropImageNewUI.getIntent().getIntExtra("from_source", 0));
        cropImageNewUI.setResult(-1, intent);
        cropImageNewUI.finish();
    }

    static /* synthetic */ void d(CropImageNewUI cropImageNewUI) {
        if (cropImageNewUI.uvW.getFilterBmp() == null) {
            cropImageNewUI.uvW.dt(cropImageNewUI.filePath, cropImageNewUI.uwb);
        }
        cropImageNewUI.uvX.setVisibility(8);
        cropImageNewUI.uvW.setVisibility(0);
        cropImageNewUI.uvZ.setTag(Integer.valueOf(cropImageNewUI.uvZ.getVisibility()));
        cropImageNewUI.uvZ.setVisibility(8);
        cropImageNewUI.uvY.setVisibility(8);
    }

    static /* synthetic */ void g(CropImageNewUI cropImageNewUI) {
        cropImageNewUI.uvW.dt(cropImageNewUI.filePath, cropImageNewUI.uwb);
        cropImageNewUI.uvX.setVisibility(8);
        cropImageNewUI.uvW.setVisibility(0);
        cropImageNewUI.uvZ.setTag(Integer.valueOf(cropImageNewUI.uvZ.getVisibility()));
        cropImageNewUI.uvZ.setVisibility(8);
        cropImageNewUI.uvY.setVisibility(8);
        cropImageNewUI.uvW.findViewById(R.h.cropimage_filter_gallery).setVisibility(4);
    }

    static /* synthetic */ void h(CropImageNewUI cropImageNewUI) {
        x.d("MicroMsg.CropImageUI", "doShowOrNot");
        if (cropImageNewUI.uvX.getVisibility() == 0) {
            cropImageNewUI.uvX.setVisibility(4);
        } else if (cropImageNewUI.uvX.getVisibility() == 4) {
            cropImageNewUI.uvX.setVisibility(0);
        }
    }

    static /* synthetic */ void k(CropImageNewUI cropImageNewUI) {
        Bitmap bitmap;
        int[] czE = cropImageNewUI.czE();
        Bitmap fg = cropImageNewUI.fg(czE[2], czE[3]);
        Bitmap fg2 = cropImageNewUI.fg(czE[0], czE[1]);
        Bitmap bitmap2;
        if (cropImageNewUI.uwb == 0) {
            bitmap2 = fg2;
            bitmap = fg;
        } else {
            bitmap2 = fg;
            bitmap = fg2;
        }
        x.d("MicroMsg.CropImageUI", "docrop degree:" + cropImageNewUI.uwb);
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_bg_vertical");
        String stringExtra2 = cropImageNewUI.getIntent().getStringExtra("CropImage_bg_horizontal");
        if (cropImageNewUI.a(bitmap, stringExtra, true) && cropImageNewUI.a(bitmap2, stringExtra2, true)) {
            Intent intent = new Intent();
            intent.putExtra("CropImage_bg_vertical", stringExtra);
            intent.putExtra("CropImage_bg_horizontal", stringExtra2);
            if (cropImageNewUI.uvW != null) {
                intent.putExtra("CropImage_filterId", cropImageNewUI.uvW.getFilterId());
            }
            cropImageNewUI.setResult(-1, intent);
        } else {
            cropImageNewUI.setResult(-1);
        }
        cropImageNewUI.finish();
    }

    static /* synthetic */ void l(CropImageNewUI cropImageNewUI) {
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_OutputPath");
        String str = null;
        Intent intent = new Intent();
        if (cropImageNewUI.uvV == 0) {
            try {
                String u = g.u((System.currentTimeMillis()).getBytes());
                c.a(cropImageNewUI.uvY.getBmp(), 100, CompressFormat.PNG, stringExtra + u, false);
                str = g.u(FileOp.e(stringExtra + u, 0, (int) FileOp.mI(stringExtra + u)));
                if (e.cn(stringExtra + str)) {
                    x.i("MicroMsg.CropImageUI", "file is exist. need no to copy!");
                    e.deleteFile(stringExtra + u);
                } else {
                    FileOp.i(stringExtra, u, str);
                }
                intent.putExtra("emoji_type", 0);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CropImageUI", e, "", new Object[0]);
                cropImageNewUI.setResult(-2);
            }
        } else if (cropImageNewUI.uvV == 1) {
            byte[] e2 = FileOp.e(cropImageNewUI.filePath, 0, -1);
            str = g.u(e2);
            if (e.cn(stringExtra + str)) {
                x.i("MicroMsg.CropImageUI", "file is exist. need no to copy!");
            } else {
                FileOp.b(stringExtra + str, e2, e2.length);
            }
            intent.putExtra("emoji_type", 1);
        }
        intent.putExtra("CropImage_OutputPath", stringExtra + str);
        if (cropImageNewUI.uvW != null) {
            intent.putExtra("CropImage_filterId", cropImageNewUI.uvW.getFilterId());
        }
        cropImageNewUI.setResult(-1, intent);
        cropImageNewUI.finish();
    }

    static /* synthetic */ void m(CropImageNewUI cropImageNewUI) {
        String[] strArr = (cropImageNewUI.uwc || cropImageNewUI.uwd) ? new String[]{cropImageNewUI.getString(R.l.cropimage_send_hd_img)} : new String[]{cropImageNewUI.getString(R.l.cropimage_send_hd_img)};
        h.a(cropImageNewUI, "", strArr, "", false, new 14(cropImageNewUI));
    }

    static /* synthetic */ void n(CropImageNewUI cropImageNewUI) {
        Context context = cropImageNewUI;
        h.a(context, "", new String[]{cropImageNewUI.getString(R.l.retransmits), cropImageNewUI.getString(R.l.save_to_local)}, "", false, new 13(cropImageNewUI));
    }

    static /* synthetic */ void r(CropImageNewUI cropImageNewUI) {
        long longExtra = cropImageNewUI.getIntent().getLongExtra("CropImage_Msg_Id", 0);
        long longExtra2 = cropImageNewUI.getIntent().getLongExtra("CropImage_Msg_Svr_Id", 0);
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_Username");
        Intent intent = new Intent(cropImageNewUI, ImageDownloadUI.class);
        intent.putExtra("img_msg_id", longExtra);
        intent.putExtra("img_server_id", longExtra2);
        intent.putExtra("img_download_compress_type", 1);
        intent.putExtra("img_download_username", stringExtra);
        cropImageNewUI.startActivity(intent);
    }

    static /* synthetic */ void s(CropImageNewUI cropImageNewUI) {
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_ImgPath");
        int intExtra = cropImageNewUI.getIntent().getIntExtra("CropImage_CompressType", 0);
        int intExtra2 = cropImageNewUI.getIntent().getIntExtra("CropImage_Msg_Id", -1);
        Intent intent = new Intent(cropImageNewUI, MsgRetransmitUI.class);
        intent.putExtra("Retr_File_Name", stringExtra);
        intent.putExtra("Retr_Msg_Id", intExtra2);
        intent.putExtra("Retr_Msg_Type", 0);
        intent.putExtra("Retr_Compress_Type", intExtra);
        cropImageNewUI.startActivity(intent);
    }

    static /* synthetic */ void u(CropImageNewUI cropImageNewUI) {
        long mI = FileOp.mI(cropImageNewUI.filePath) / 1024;
        h.a(cropImageNewUI, cropImageNewUI.getString(R.l.cropimage_edge_upload_hd_img, new Object[]{Long.toString(mI)}), cropImageNewUI.getString(R.l.app_tip), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                CropImageNewUI.a(CropImageNewUI.this, false);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.cropimage_new;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        initView();
    }

    public void onResume() {
        super.onResume();
        setRequestedOrientation(1);
    }

    public void onDestroy() {
        if (this.uvY != null) {
            CropImageView cropImageView = this.uvY;
            if (!(cropImageView.jDx == null || cropImageView.jDx.isRecycled())) {
                x.i("MicroMsg.CropImageView", "recycle bitmap:%s", new Object[]{cropImageView.jDx.toString()});
                cropImageView.jDx.recycle();
            }
        }
        if (this.uvW != null) {
            FilterImageView filterImageView = this.uvW;
            filterImageView.uwT = null;
            if (!(filterImageView.uwX == null || filterImageView.uwX.isRecycled())) {
                x.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[]{filterImageView.uwX.toString()});
                filterImageView.uwX.recycle();
            }
            filterImageView.uwX = null;
        }
        super.onDestroy();
        x.appenderClose();
        Process.killProcess(Process.myPid());
    }

    protected final void initView() {
        setMMTitle("");
        this.uvX = (LinearLayout) findViewById(R.h.cropimage_operator_ll);
        this.uvZ = (ImageView) findViewById(R.h.cropimage_iv);
        s.bD(this.uvZ);
        this.uwa = findViewById(R.h.cropimage_frame);
        this.uvU = getIntent().getIntExtra("CropImageMode", 0);
        Assert.assertTrue("the image mode must be set", this.uvU != 0);
        this.hop = getIntent().getIntExtra("CropImage_from_scene", 0);
        boolean booleanExtra = getIntent().getBooleanExtra("CropImage_Filter", false);
        boolean booleanExtra2 = getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false);
        if (booleanExtra) {
            c(new 22(this), new 23(this));
        }
        this.uwe = false;
        this.uvY = (CropImageView) findViewById(R.h.cropimage_origin_iv);
        s.bD(this.uvY);
        this.uvY.post(new Runnable() {
            public final void run() {
                if (!CropImageNewUI.this.czD()) {
                    return;
                }
                if (!CropImageNewUI.this.uwc && !CropImageNewUI.this.uwd && CropImageNewUI.this.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                    CropImageNewUI.d(CropImageNewUI.this);
                    if (!CropImageNewUI.this.getSharedPreferences(ad.chY(), 0).getBoolean("CropImage_Filter_Show", true)) {
                        CropImageNewUI.this.uvW.findViewById(R.h.cropimage_filter_gallery).setVisibility(4);
                    }
                } else if (1 == CropImageNewUI.this.uvU) {
                    CropImageNewUI.g(CropImageNewUI.this);
                }
            }
        });
        this.uvY.setOnShortClick(new a() {
            public final void czF() {
                CropImageNewUI.h(CropImageNewUI.this);
            }
        });
        ((Button) findViewById(R.h.cropimage_rotate)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CropImageView j = CropImageNewUI.this.uvY;
                if (j.jDx == null) {
                    x.w("MicroMsg.CropImageView", "rotate not done! cause: btmp is null!");
                    return;
                }
                float[] fArr = new float[]{(float) (j.jDx.getWidth() / 2), (float) (j.jDx.getHeight() / 2)};
                j.getImageMatrix().mapPoints(fArr);
                j.getImageMatrix().postRotate(90.0f, fArr[0], fArr[1]);
                j.setImageBitmap(j.jDx);
                j.invalidate();
                j.bRV++;
            }
        });
        Button button = (Button) findViewById(R.h.cropimage_zoomin);
        button.setOnClickListener(new 5(this));
        Button button2 = (Button) findViewById(R.h.cropimage_zoomout);
        button2.setOnClickListener(new 6(this));
        al alVar = new al(new 7(this), true);
        final al alVar2 = new al(new 8(this), true);
        button.setOnTouchListener(new 9(this, alVar));
        button2.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        alVar2.J(200, 200);
                        break;
                    case 1:
                        alVar2.SO();
                        break;
                }
                return false;
            }
        });
        int i = R.l.cropimage_use;
        switch (this.uvU) {
            case 1:
                c(new Runnable() {
                    public final void run() {
                        CropImageNewUI.a(CropImageNewUI.this, CropImageNewUI.this.uvW.getCropImageIV(), CropImageNewUI.this.uvW.getCropAreaView());
                        CropImageNewUI.this.finish();
                    }
                }, new 3(this));
                this.uvW.setLimitZoomIn(false);
                FilterImageView filterImageView = this.uvW;
                if (filterImageView.uwW != null) {
                    filterImageView.uwW.setScaleType(ScaleType.MATRIX);
                    filterImageView.uwW.czG();
                }
                this.uvW.setCropMaskVisible(0);
                if (this.hop == 1) {
                    this.uvW.setCropMaskBackground(R.g.new_year_capture);
                    break;
                }
                break;
            case 2:
                this.uvY.setEnableOprate(false);
                findViewById(R.h.cropimage_ajuster_select).setVisibility(8);
                findViewById(R.h.cropimage_function_bar).setVisibility(8);
                break;
            case 3:
                this.uvX.setVisibility(8);
                break;
            case 5:
                int intExtra = getIntent().getIntExtra("CropImage_CompressType", 1);
                boolean booleanExtra3 = getIntent().getBooleanExtra("CropImage_BHasHD", false);
                if (intExtra != 1 && booleanExtra3) {
                    findViewById(R.h.cropimage_function_bar).setVisibility(0);
                    button = (Button) findViewById(R.h.cropimage_function_btn);
                    button.setBackgroundResource(R.g.btn_style_black);
                    button.setPadding(25, 8, 25, 8);
                    button.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            CropImageNewUI.r(CropImageNewUI.this);
                        }
                    });
                    break;
                }
                findViewById(R.h.cropimage_function_bar).setVisibility(8);
                break;
                break;
        }
        x.d("MicroMsg.CropImageUI", "mode is  " + this.uvU);
        17 17 = new 17(this, booleanExtra, booleanExtra2);
        if (this.uvU == 5) {
            addIconOptionMenu(0, R.g.mm_title_btn_menu, 17);
        } else if (this.uvU == 4) {
            addIconOptionMenu(0, R.g.mm_title_btn_menu, 17);
            findViewById(R.h.cropimage_function_bar).setVisibility(0);
            button = (Button) findViewById(R.h.cropimage_function_btn);
            button.setText(R.l.cropimage_done);
            button.setOnClickListener(new 18(this));
        } else {
            a(0, getString(i), 17, b.tmX);
        }
        if (booleanExtra && booleanExtra2) {
            a(0, getString(R.l.cropimage_done), 17, b.tmX);
        }
        setBackBtn(new 19(this));
        if (this.uvU == 6) {
            findViewById(R.h.cropimage_function_bar).setVisibility(8);
            a(0, getString(R.l.cropimage_use), new 20(this), b.tmX);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        x.d("MicroMsg.CropImageUI", "onConfigurationChanged, config.orientation = " + configuration.orientation);
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            x.v("MicroMsg.CropImageUI", "onConfigurationChanged");
            this.uvY.post(new 21(this));
        }
        super.onConfigurationChanged(configuration);
    }

    private boolean czD() {
        View findViewById;
        if (1 != this.uvU) {
            findViewById = findViewById(R.h.cropimage_fl);
        } else if (this.uvW != null) {
            findViewById = this.uvW.getCropAreaView();
        } else {
            findViewById = findViewById(R.h.cropimage_frame);
        }
        int width = findViewById.getWidth();
        int height = findViewById.getHeight();
        x.v("MicroMsg.CropImageUI", "scrWidth:" + width + " scrHeight:" + height);
        this.filePath = getIntent().getStringExtra("CropImage_ImgPath");
        if (FileOp.cn(this.filePath)) {
            boolean z;
            int i;
            int i2;
            int i3;
            float f;
            int i4 = 960;
            int i5 = 960;
            if (this.uvU == 2) {
                z = true;
                i = height;
                i2 = width;
            } else if (this.uvU == 3) {
                Options options = new Options();
                options.inJustDecodeBounds = true;
                Bitmap decodeFile = BitmapFactory.decodeFile(this.filePath, options);
                if (decodeFile != null) {
                    decodeFile.recycle();
                }
                i = options.outWidth;
                i3 = options.outHeight;
                f = 1.0f;
                if (i <= 640 && i3 <= 640) {
                    i4 = i3;
                    i2 = i;
                } else if (i > i3) {
                    f = ((float) i3) / ((float) i);
                    i2 = 640;
                    i4 = (int) (((float) i3) * f);
                } else {
                    f = ((float) i) / ((float) i3);
                    i4 = 640;
                    i2 = (int) (960.0f * f);
                }
                x.d("MicroMsg.CropImageUI", "w:%d h:%d width:%d height:%d scale:%f", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i4), Float.valueOf(f)});
                Button button = (Button) findViewById(R.h.cropimage_function_btn);
                if (button != null) {
                    button.setVisibility(8);
                }
                z = false;
                i = i4;
            } else if (this.uvU == 1) {
                Options options2 = new Options();
                options2.inJustDecodeBounds = true;
                Bitmap decodeFile2 = BitmapFactory.decodeFile(this.filePath, options2);
                if (decodeFile2 != null) {
                    x.i("MicroMsg.CropImageUI", "recycle bitmap:%s", new Object[]{decodeFile2.toString()});
                    decodeFile2.recycle();
                }
                if (options2.outWidth > options2.outHeight) {
                    i4 = (int) ((((double) (options2.outWidth * 960)) * 1.0d) / ((double) options2.outHeight));
                    if (i4 > 1920) {
                        i4 = 1920;
                    }
                } else {
                    i5 = (int) ((((double) (options2.outHeight * 960)) * 1.0d) / ((double) options2.outWidth));
                    if (i5 > 1920) {
                        i5 = 1920;
                    }
                }
                z = false;
                i = i5;
                i2 = i4;
            } else {
                Options options3 = new Options();
                options3.inJustDecodeBounds = true;
                c.c(options3);
                Bitmap decodeFile3 = BitmapFactory.decodeFile(this.filePath, options3);
                if (decodeFile3 != null) {
                    x.i("MicroMsg.CropImageUI", "recycle bitmap:%s", new Object[]{decodeFile3.toString()});
                    decodeFile3.recycle();
                }
                z = ai.bv(options3.outWidth, options3.outHeight) && options3.outWidth > 480;
                this.uwc = z;
                z = ai.bu(options3.outWidth, options3.outHeight) && options3.outHeight > 480;
                this.uwd = z;
                if (this.uwc || this.uwd) {
                    i5 = options3.outHeight;
                    i4 = options3.outWidth;
                }
                x.e("MicroMsg.CropImageUI", "width is " + i4 + " height is " + i5);
                z = false;
                i = i5;
                i2 = i4;
            }
            this.uwb = ExifHelper.VX(this.filePath);
            if (this.uwb == 90 || this.uwb == 270) {
                i5 = i2;
                i4 = i;
            } else {
                i5 = i;
                i4 = i2;
            }
            Bitmap e = c.e(this.filePath, i5, i4, z);
            byte[] e2 = FileOp.e(this.filePath, 0, 10);
            if (o.bv(e2)) {
                this.uvV = 1;
            } else {
                this.uvV = 0;
            }
            if (e == null) {
                finish();
                return false;
            }
            float height2;
            float f2;
            x.d("temBmp crop", "h:" + e.getHeight() + "w: " + e.getWidth());
            Bitmap b = c.b(e, (float) this.uwb);
            Matrix matrix = new Matrix();
            matrix.reset();
            float f3 = 1.0f;
            if (z) {
                f = ((float) b.getWidth()) / ((float) width);
                height2 = ((float) b.getHeight()) / ((float) height);
                f2 = f < height2 ? f : height2;
                f = width > height ? (float) height : (float) width;
                height2 = f / ((float) b.getWidth());
                f /= (float) b.getHeight();
                if (height2 > f) {
                    f = height2;
                }
                if (((double) f2) < 1.0d) {
                    matrix.postScale(f, f);
                }
            } else {
                f = ((float) b.getWidth()) / ((float) b.getHeight());
                f2 = ((float) b.getHeight()) / ((float) b.getWidth());
                x.v("MicroMsg.CropImageUI", "whDiv is " + f + " hwDiv is " + f2);
                if (f2 >= 2.0f && b.getHeight() >= 480) {
                    f2 = ((float) b.getWidth()) / ((float) width);
                    f = ((float) width) / ((float) b.getWidth());
                    if (1 == this.uvU) {
                        f2 = ((float) height) / ((float) b.getHeight());
                        if (f <= f2) {
                            f = f2;
                        }
                        matrix.postScale(f, f);
                        matrix.postTranslate(((((float) width) - (f * ((float) b.getWidth()))) / 2.0f) + ((float) findViewById.getLeft()), (float) findViewById.getTop());
                    } else if (((double) f2) > 1.0d) {
                        matrix.postScale(f, f);
                        b.getHeight();
                        matrix.postTranslate((((float) width) - (f * ((float) b.getWidth()))) / 2.0f, 0.0f);
                    } else {
                        matrix.postScale(1.0f, 1.0f);
                        if (3 == this.uvU) {
                            matrix.postTranslate((float) ((width - b.getWidth()) / 2), (float) ((height - b.getHeight()) / 2));
                        } else {
                            matrix.postTranslate((float) ((width - b.getWidth()) / 2), 0.0f);
                        }
                    }
                } else if (f < 2.0f || b.getWidth() < 480) {
                    f = ((float) width) / ((float) b.getWidth());
                    f2 = ((float) height) / ((float) b.getHeight());
                    float f4 = f < f2 ? f : f2;
                    if (f <= f2) {
                        f = f2;
                    }
                    if (1 == this.uvU) {
                        matrix.postScale(f, f);
                        matrix.postTranslate(((((float) width) - (((float) b.getWidth()) * f)) / 2.0f) + ((float) findViewById.getLeft()), ((((float) height) - (f * ((float) b.getHeight()))) / 2.0f) + ((float) findViewById.getTop()));
                    } else if (this.uvV == 1) {
                        this.uvY.setGifPath(this.filePath);
                        this.uvY.getGifWidth();
                        this.uvY.getGifHeight();
                        f = ((float) this.uvY.getGifWidth()) / ((float) width);
                        height2 = ((float) this.uvY.getGifHeight()) / ((float) height);
                        if (f <= height2) {
                            f = height2;
                        }
                        if (((double) f) > 1.0d) {
                            matrix.postScale(f, f);
                        } else {
                            f = 1.0f;
                        }
                        matrix.postTranslate((((float) width) - (((float) this.uvY.getGifWidth()) * f)) / 2.0f, (((float) height) - (f * ((float) this.uvY.getGifHeight()))) / 2.0f);
                    } else {
                        f = ((float) b.getWidth()) / ((float) width);
                        height2 = ((float) b.getHeight()) / ((float) height);
                        if (f <= height2) {
                            f = height2;
                        }
                        if (((double) f) > 1.0d) {
                            matrix.postScale(f4, f4);
                            f3 = f4;
                        }
                        matrix.postTranslate((((float) width) - (((float) b.getWidth()) * f3)) / 2.0f, (((float) height) - (((float) b.getHeight()) * f3)) / 2.0f);
                    }
                } else {
                    f = ((float) b.getHeight()) / 480.0f;
                    f2 = 480.0f / ((float) b.getHeight());
                    if (1 == this.uvU) {
                        f = ((float) width) / ((float) b.getWidth());
                        f2 = ((float) height) / ((float) b.getHeight());
                        if (f <= f2) {
                            f = f2;
                        }
                        matrix.postScale(f, f);
                        matrix.postTranslate(((((float) width) - (((float) b.getWidth()) * f)) / 2.0f) + ((float) findViewById.getLeft()), ((((float) height) - (f * ((float) b.getHeight()))) / 2.0f) + ((float) findViewById.getTop()));
                    } else if (((double) f) > 1.0d) {
                        matrix.postScale(f, f2);
                        matrix.postTranslate(0.0f, (float) ((height - 480) / 2));
                    } else {
                        matrix.postScale(1.0f, 1.0f);
                        f = (float) ((height - b.getHeight()) / 2);
                        x.d("MicroMsg.CropImageUI", " offsety " + f);
                        matrix.postTranslate(0.0f, f);
                    }
                }
            }
            if (1 == this.uvU) {
                if (this.uvW != null) {
                    this.uvW.setMatrix(matrix);
                    this.uvW.setImage(b);
                }
            } else if (this.uvV != 1) {
                this.uvY.setImageMatrix(matrix);
                this.uvY.setImageBitmap(b);
            }
            if (this.uvU == 3) {
                if (o.bv(e2)) {
                    this.uvV = 1;
                    try {
                        com.tencent.mm.plugin.gif.a dj = com.tencent.mm.plugin.gif.b.aVQ().dj(this.filePath, this.filePath);
                        this.uvY.setImageDrawable(dj);
                        dj.start();
                        matrix.reset();
                        i3 = dj.getIntrinsicWidth();
                        i2 = dj.getIntrinsicHeight();
                        f = ((float) width) / ((float) i3);
                        height2 = ((float) height) / ((float) i2);
                        f2 = f < height2 ? f : height2;
                        f = ((float) i3) / ((float) width);
                        height2 = ((float) i2) / ((float) height);
                        if (f <= height2) {
                            f = height2;
                        }
                        if (((double) f) > 1.0d) {
                            matrix.postScale(f2, f2);
                            matrix.postTranslate((((float) width) - (((float) i3) * f2)) / 2.0f, (((float) height) - (f2 * ((float) i2))) / 2.0f);
                        } else {
                            matrix.postTranslate((float) ((width - i3) / 2), (float) ((height - i2) / 2));
                        }
                        this.uvY.setImageMatrix(matrix);
                    } catch (Throwable e3) {
                        x.e("MicroMsg.CropImageUI", bi.i(e3));
                    }
                } else {
                    this.uvV = 0;
                }
                return true;
            }
            if (this.uwc || this.uwd) {
                findViewById(R.h.cropimage_rotate).setVisibility(8);
            }
            if (getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                findViewById(R.h.cropimage_function_bar).setVisibility(8);
            }
            return true;
        }
        finish();
        return false;
    }

    private void c(Runnable runnable, Runnable runnable2) {
        this.uvW = (FilterImageView) findViewById(R.h.cropimage_filter_view);
        s.bD(this.uvW);
        this.uvW.setOnConfirmImp(runnable);
        this.uvW.setOnExitImp(runnable2);
    }

    private int[] czE() {
        int i;
        DisplayMetrics displayMetrics;
        int i2;
        int max;
        int i3;
        int i4;
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i5 = rect.top;
        x.e("MicroMsg.CropImageUI", "window TitleBar.h:" + i5);
        if (i5 == 0) {
            try {
                Class cls = Class.forName("com.android.internal.R$dimen");
                i5 = getResources().getDimensionPixelSize(ai.getInt(cls.getField("status_bar_height").get(cls.newInstance()).toString(), 0));
                x.e("MicroMsg.CropImageUI", "sbar:" + i5);
                i = i5;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CropImageUI", e, "", new Object[0]);
            }
            displayMetrics = new DisplayMetrics();
            ((WindowManager) getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            i2 = (int) (((double) (67.0f * displayMetrics.density)) / 1.5d);
            i5 = Math.min(this.uwa.getWidth(), this.uwa.getHeight());
            max = Math.max(this.uwa.getWidth(), this.uwa.getHeight());
            i3 = max - (i2 * 2);
            i4 = (max + i) + i2;
            max = (i5 - (i2 * 2)) - i;
            if (this.uwb != 0) {
                i5 += i + (i2 * 2);
                i = max + i2;
            } else {
                i = max;
            }
            return new int[]{i5, i3, i, i4};
        }
        i = i5;
        displayMetrics = new DisplayMetrics();
        ((WindowManager) getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        i2 = (int) (((double) (67.0f * displayMetrics.density)) / 1.5d);
        i5 = Math.min(this.uwa.getWidth(), this.uwa.getHeight());
        max = Math.max(this.uwa.getWidth(), this.uwa.getHeight());
        i3 = max - (i2 * 2);
        i4 = (max + i) + i2;
        max = (i5 - (i2 * 2)) - i;
        if (this.uwb != 0) {
            i = max;
        } else {
            i5 += i + (i2 * 2);
            i = max + i2;
        }
        return new int[]{i5, i3, i, i4};
    }

    private Bitmap fg(int i, int i2) {
        Bitmap e = c.e(this.filePath, i2, i, true);
        if (this.uwb != 0) {
            Matrix matrix = new Matrix();
            matrix.reset();
            matrix.setRotate((float) this.uwb, (float) (e.getWidth() / 2), (float) (e.getHeight() / 2));
            Bitmap createBitmap = Bitmap.createBitmap(e, 0, 0, e.getWidth(), e.getHeight(), matrix, true);
            if (e != createBitmap) {
                x.i("MicroMsg.CropImageUI", "recycle bitmap:%s", new Object[]{e.toString()});
                e.recycle();
            }
            e = createBitmap;
        }
        x.d("MicroMsg.CropImageUI", "getcrop degree:" + this.uwb);
        return e;
    }

    private static Bitmap a(float[][] fArr, float f, float f2, float f3, float f4, CropImageView cropImageView) {
        if (cropImageView == null) {
            return null;
        }
        float[] fArr2 = new float[]{f3, f4, 1.0f};
        float[] c = m.c(fArr, new float[]{f, f2, 1.0f});
        float[] c2 = m.c(fArr, fArr2);
        int min = (int) Math.min(c[0], c2[0]);
        int min2 = (int) Math.min(c[1], c2[1]);
        if (min < 0) {
            min = 0;
        }
        if (min2 < 0) {
            min2 = 0;
        }
        int abs = (int) Math.abs(c[0] - c2[0]);
        int abs2 = (int) Math.abs(c[1] - c2[1]);
        Matrix matrix = new Matrix();
        switch (cropImageView.getRotateCount() % 4) {
            case 0:
                matrix.setRotate(0.0f, (float) (abs / 2), (float) (abs2 / 2));
                break;
            case 1:
                matrix.setRotate(90.0f, (float) (abs / 2), (float) (abs2 / 2));
                break;
            case 2:
                matrix.setRotate(180.0f, (float) (abs / 2), (float) (abs2 / 2));
                break;
            case 3:
                matrix.setRotate(270.0f, (float) (abs / 2), (float) (abs2 / 2));
                break;
        }
        Bitmap bmp = cropImageView.getBmp();
        if (min + abs > bmp.getWidth()) {
            abs = bmp.getWidth() - min;
        }
        if (min2 + abs2 > bmp.getHeight()) {
            abs2 = bmp.getHeight() - min2;
        }
        x.i("MicroMsg.CropImageUI", "rawWidth:%d, rawHeigth:%d, originalLX:%d, originalTY:%d, realWidth:%d, realHeight:%d", new Object[]{Integer.valueOf(bmp.getWidth()), Integer.valueOf(bmp.getHeight()), Integer.valueOf(min), Integer.valueOf(min2), Integer.valueOf(abs), Integer.valueOf(abs2)});
        return Bitmap.createBitmap(bmp, min, min2, abs, abs2, matrix, true);
    }

    private boolean a(Bitmap bitmap, String str, boolean z) {
        if (!(str == null || str.equals(""))) {
            try {
                if (this.hop == 1) {
                    c.a(bitmap, 30, CompressFormat.JPEG, str, z);
                    return true;
                }
                c.a(bitmap, 100, CompressFormat.PNG, str, z);
                return true;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CropImageUI", e, "", new Object[0]);
                x.e("MicroMsg.CropImageUI", "saveBitmapToImage failed:" + e.toString());
            }
        }
        return false;
    }

    private static float[][] b(Matrix matrix) {
        float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, new int[]{3, 3});
        float[] fArr2 = new float[9];
        matrix.getValues(fArr2);
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                fArr[i][i2] = fArr2[(i * 3) + i2];
            }
        }
        return fArr;
    }
}
