package com.tencent.mm.plugin.gallery.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.m;
import com.tencent.mm.plugin.gallery.stub.GalleryStubService;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMNewPhotoEditUI;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

@a(19)
@TargetApi(16)
public class ImagePreviewUI extends MMActivity {
    private ServiceConnection hKe = new 1(this);
    private com.tencent.mm.plugin.gallery.stub.a jBy = null;
    private ArrayList<MediaItem> jBz;
    private HashMap<String, Integer> jCD = new HashMap();
    private boolean jCW;
    private TextView jCf;
    private boolean jCl = true;
    private boolean jCp;
    private int jCs;
    private long jCx = 0;
    private c jDA;
    private MMViewPager jDB;
    private RecyclerView jDC;
    private ArrayList<String> jDD;
    private ArrayList<String> jDE;
    private Integer jDF;
    private ImageButton jDG;
    private TextView jDH;
    private al jDI;
    private ImageButton jDJ;
    private TextView jDK;
    private ViewGroup jDL;
    private ViewGroup jDM;
    private boolean jDN = true;
    private boolean jDO = true;
    private int jDP = 0;
    private int jDQ = 10;
    private TextView jDR;
    private TextView jDS;
    private TextView jDT;
    private TextView jDU;
    private View jDV;
    private TextView jDW;
    private ProgressBar jDX;
    boolean jDY = false;
    private HashSet<String> jDZ;

    static /* synthetic */ void n(ImagePreviewUI imagePreviewUI) {
        String str;
        String stringExtra = imagePreviewUI.getIntent().getStringExtra("GalleryUI_FromUser");
        String stringExtra2 = imagePreviewUI.getIntent().getStringExtra("GalleryUI_ToUser");
        Intent intent = new Intent();
        x.i("MicroMsg.ImagePreviewUI", "edit image path:%s mPosition:%s", new Object[]{imagePreviewUI.jDA.jl(imagePreviewUI.jDF.intValue()), imagePreviewUI.jDF});
        intent.putExtra("GalleryUI_FromUser", stringExtra);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        intent.putExtra("from_scene", c.aRf().aRI());
        intent.putExtra("preview_image_list", ((f) imagePreviewUI.jDC.getAdapter()).jEl);
        if (c.aRf().aRI() == 4) {
            intent.putExtra("from_scene", 289);
        } else if (c.aRf().aRI() == 3) {
            intent.putExtra("from_scene", 290);
        }
        intent.putExtra("preview_select_image_list", imagePreviewUI.jDE);
        MediaItem qE = imagePreviewUI.jDA.qE(imagePreviewUI.jDF.intValue());
        if (qE != null) {
            x.i("MicroMsg.ImagePreviewUI", "[gotoPhotoEditUI] raw:%s orignal:%s", new Object[]{qE.jAS, qE.egA});
            str = qE.jAS;
            if (bi.oW(str)) {
                str = qE.egA;
                intent.putExtra("after_photo_edit", "");
            } else {
                intent.putExtra("after_photo_edit", qE.egA);
            }
        } else {
            x.i("MicroMsg.ImagePreviewUI", "[gotoPhotoEditUI] item == null mPosition:%s", new Object[]{imagePreviewUI.jDF});
            str = imagePreviewUI.jDA.jl(imagePreviewUI.jDF.intValue());
            qE = MediaItem.a(1, (long) imagePreviewUI.jDF.intValue(), str, str, "edit");
            ArrayList arrayList = new ArrayList();
            arrayList.add(qE);
            c.v(arrayList);
        }
        intent.putExtra("before_photo_edit", str);
        intent.setClass(imagePreviewUI, MMNewPhotoEditUI.class);
        imagePreviewUI.startActivityForResult(intent, 4372);
    }

    static /* synthetic */ void v(ImagePreviewUI imagePreviewUI) {
        if (imagePreviewUI.jDI == null || imagePreviewUI.jDI.ciq()) {
            imagePreviewUI.jDI = new al(new 15(imagePreviewUI), false);
            imagePreviewUI.jDI.J(350, 350);
            return;
        }
        imagePreviewUI.jDI.SO();
    }

    @TargetApi(16)
    public void onCreate(Bundle bundle) {
        long VG = bi.VG();
        super.onCreate(bundle);
        fullScreenNoTitleBar(true);
        new ag().post(new 12(this, VG));
        bindService(new Intent(this.mController.tml, GalleryStubService.class), this.hKe, 1);
        initView();
        x.v("MicroMsg.ImagePreviewUI", "test oncreate: %d", new Object[]{Long.valueOf(bi.bI(VG))});
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        if (this.jDI != null) {
            this.jDI.SO();
        }
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.image_gallery_plugin;
    }

    protected final void dealContentView(View view) {
        if (b.bt(this)) {
            setContentView(view);
            return;
        }
        ak.d(ak.a(getWindow(), null), this.mController.tlX);
        ((ViewGroup) this.mController.tlX.getParent()).removeView(this.mController.tlX);
        ((ViewGroup) getWindow().getDecorView()).addView(this.mController.tlX, 0);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void initView() {
        /*
        r10 = this;
        r9 = 2;
        r8 = 8;
        r1 = 1;
        r2 = 0;
        r0 = com.tencent.mm.R.h.gallery_edit_tv;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.jDS = r0;
        r0 = com.tencent.mm.R.h.gallery_edit_tv_des;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.jDT = r0;
        r0 = com.tencent.mm.R.h.item_legal_tip;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.jDU = r0;
        r0 = com.tencent.mm.R.h.item_legal_tip_layout;
        r0 = r10.findViewById(r0);
        r10.jDV = r0;
        r0 = r10.jDV;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$21;
        r3.<init>(r10);
        r4 = 100;
        r0.postDelayed(r3, r4);
        r0 = com.tencent.mm.R.h.gallery_edit_tv_btn;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.jDW = r0;
        r0 = com.tencent.mm.R.h.video_edit_progressbar;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.ProgressBar) r0;
        r10.jDX = r0;
        r0 = r10.getIntent();
        r3 = "max_select_count";
        r4 = 9;
        r0 = r0.getIntExtra(r3, r4);
        r10.jCs = r0;
        r0 = r10.getIntent();
        r3 = "key_edit_video_max_time_length";
        r4 = 10;
        r0 = r0.getIntExtra(r3, r4);
        r10.jDQ = r0;
        r0 = com.tencent.mm.plugin.gallery.model.c.aRf();
        r0 = r0.aRI();
        r3 = 4;
        if (r0 != r3) goto L_0x0117;
    L_0x0074:
        r0 = r1;
    L_0x0075:
        r10.jCl = r0;
        r3 = r10.getIntent();
        r0 = "preview_image_list";
        r0 = r3.getStringArrayListExtra(r0);
        r10.jDD = r0;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r10.jDE = r0;
        r0 = r10.jDD;
        if (r0 == 0) goto L_0x0096;
    L_0x008f:
        r0 = r10.jDE;
        r4 = r10.jDD;
        r0.addAll(r4);
    L_0x0096:
        r0 = com.tencent.mm.plugin.gallery.model.c.aRh();
        r10.jBz = r0;
        r0 = "preview_all";
        r4 = r3.getBooleanExtra(r0, r2);
        r5 = "MicroMsg.ImagePreviewUI";
        r6 = "preview all[%B] mediaitems is null[%B]";
        r7 = new java.lang.Object[r9];
        r0 = java.lang.Boolean.valueOf(r4);
        r7[r2] = r0;
        r0 = r10.jBz;
        if (r0 != 0) goto L_0x011a;
    L_0x00b5:
        r0 = r1;
    L_0x00b6:
        r0 = java.lang.Boolean.valueOf(r0);
        r7[r1] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r5, r6, r7);
        if (r4 == 0) goto L_0x00eb;
    L_0x00c1:
        r0 = r10.jBz;
        if (r0 == 0) goto L_0x00eb;
    L_0x00c5:
        r10.jCW = r1;
        r0 = "preview_position";
        r0 = r3.getIntExtra(r0, r2);
        r0 = java.lang.Integer.valueOf(r0);
        r10.jDF = r0;
        r0 = "MicroMsg.ImagePreviewUI";
        r4 = "start position=%d";
        r5 = new java.lang.Object[r1];
        r6 = r10.jDF;
        r5[r2] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r0, r4, r5);
        r0 = r10.jDF;
        r0 = r0.intValue();
        if (r0 >= 0) goto L_0x00f1;
    L_0x00eb:
        r0 = java.lang.Integer.valueOf(r2);
        r10.jDF = r0;
    L_0x00f1:
        r0 = r10.jDF;
        r0 = r0.intValue();
        com.tencent.mm.plugin.gallery.model.c.qn(r0);
        r0 = r10.jCW;
        if (r0 != 0) goto L_0x011c;
    L_0x00fe:
        r0 = r10.jDE;
        if (r0 == 0) goto L_0x010a;
    L_0x0102:
        r0 = r10.jDE;
        r0 = r0.size();
        if (r0 != 0) goto L_0x011c;
    L_0x010a:
        r0 = "MicroMsg.ImagePreviewUI";
        r1 = "not preview all items and imagepaths is null or empty";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r10.finish();
    L_0x0116:
        return;
    L_0x0117:
        r0 = r2;
        goto L_0x0075;
    L_0x011a:
        r0 = r2;
        goto L_0x00b6;
    L_0x011c:
        r0 = com.tencent.mm.R.h.orignal_image;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.ImageButton) r0;
        r10.jDG = r0;
        r0 = com.tencent.mm.R.h.orignal_image_tip;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.jCf = r0;
        r0 = com.tencent.mm.R.h.video_edit_button;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.jDH = r0;
        r0 = "send_raw_img";
        r0 = r3.getBooleanExtra(r0, r2);
        r10.jCp = r0;
        r0 = "query_source_type";
        r0 = r3.getIntExtra(r0, r2);
        r10.jDP = r0;
        r0 = r10.jCp;
        if (r0 == 0) goto L_0x039b;
    L_0x0150:
        r0 = r10.jDG;
        r3 = com.tencent.mm.R.k.radio_on;
        r0.setImageResource(r3);
    L_0x0157:
        r0 = r10.jDE;
        if (r0 == 0) goto L_0x017c;
    L_0x015b:
        r0 = r10.jDE;
        r0 = r0.size();
        if (r0 != r1) goto L_0x017c;
    L_0x0163:
        r0 = r10.jDE;
        r0 = r0.get(r2);
        r0 = (java.lang.String) r0;
        r3 = ".jpg";
        r3 = r0.endsWith(r3);
        if (r3 == 0) goto L_0x017c;
    L_0x0174:
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$10;
        r3.<init>(r0);
        com.tencent.mm.sdk.platformtools.ah.A(r3);
    L_0x017c:
        r0 = r10.jCf;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = r10.mController;
        r4 = r4.tml;
        r5 = com.tencent.mm.R.l.gallery_pic_orignal;
        r4 = r4.getString(r5);
        r3 = r3.append(r4);
        r3 = r3.toString();
        r0.setText(r3);
        r0 = r10.jDG;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$22;
        r3.<init>(r10);
        r0.setOnClickListener(r3);
        r0 = r10.jDH;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$23;
        r3.<init>();
        r0.setOnClickListener(r3);
        r0 = r10.jDW;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$24;
        r3.<init>(r10);
        r0.setOnClickListener(r3);
        r0 = r10.jCf;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$25;
        r3.<init>();
        r0.setOnClickListener(r3);
        r0 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$26;
        r0.<init>(r10);
        r10.setBackBtn(r0);
        r0 = r10.aRW();
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$27;
        r3.<init>();
        r4 = com.tencent.mm.ui.s.b.tmX;
        r10.a(r2, r0, r3, r4);
        r0 = com.tencent.mm.R.h.photos_select_checkbox;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.ImageButton) r0;
        r10.jDJ = r0;
        r0 = r10.jDJ;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$2;
        r3.<init>();
        r0.setOnClickListener(r3);
        r0 = com.tencent.mm.R.h.photos_select_tv;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.jDK = r0;
        r0 = r10.jDK;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$3;
        r3.<init>();
        r0.setOnClickListener(r3);
        r0 = r10.jCs;
        if (r0 != r1) goto L_0x020c;
    L_0x0202:
        r0 = r10.jDJ;
        r0.setVisibility(r8);
        r0 = r10.jDK;
        r0.setVisibility(r8);
    L_0x020c:
        r0 = com.tencent.mm.R.h.cropimage_operator_ll;
        r0 = r10.findViewById(r0);
        r0 = (android.view.ViewGroup) r0;
        r10.jDL = r0;
        r0 = com.tencent.mm.R.h.gallery_edit_layout;
        r0 = r10.findViewById(r0);
        r0 = (android.view.ViewGroup) r0;
        r10.jDM = r0;
        r0 = r10.jDL;
        if (r0 == 0) goto L_0x0233;
    L_0x0224:
        r0 = r10.jDL;
        r0.setVisibility(r8);
        r0 = r10.jDL;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$4;
        r3.<init>(r10);
        r0.setOnClickListener(r3);
    L_0x0233:
        r0 = r10.jDM;
        if (r0 == 0) goto L_0x0246;
    L_0x0237:
        r0 = r10.jDM;
        r0.setVisibility(r8);
        r0 = r10.jDM;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$5;
        r3.<init>(r10);
        r0.setOnClickListener(r3);
    L_0x0246:
        r0 = com.tencent.mm.R.h.photo_edit_button;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.jDR = r0;
        r0 = r10.jDR;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$6;
        r3.<init>(r10);
        r0.setOnClickListener(r3);
        r0 = com.tencent.mm.R.h.image_preview_recycler_view;
        r0 = r10.findViewById(r0);
        r0 = (android.support.v7.widget.RecyclerView) r0;
        r10.jDC = r0;
        r0 = r10.jDC;
        r0 = r0.getItemAnimator();
        r4 = 66;
        r0.RX = r4;
        r0 = r10.jDC;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$7;
        r3.<init>(r10);
        r0.a(r3);
        r0 = new com.tencent.mm.plugin.gallery.ui.g;
        r0.<init>();
        r0.setOrientation(r2);
        r3 = r10.jDC;
        r3.setLayoutManager(r0);
        r0 = r10.getResources();
        r0 = r0.getDisplayMetrics();
        r0 = r0.widthPixels;
        r0 = r0 / 7;
        r3 = new com.tencent.mm.plugin.gallery.ui.f;
        r4 = r10.jDE;
        r5 = r10.jCW;
        r3.<init>(r10, r4, r0, r5);
        r0 = r10.jDC;
        r0.setAdapter(r3);
        r0 = r10.jDC;
        r4 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$8;
        r4.<init>(r10);
        r0.post(r4);
        r0 = r10.jDE;
        r0 = r0.size();
        if (r0 <= 0) goto L_0x03a4;
    L_0x02b1:
        r0 = r10.jDC;
        r0.setVisibility(r2);
    L_0x02b6:
        r0 = r10.jDC;
        r4 = new android.support.v7.widget.v;
        r4.<init>();
        r0.setItemAnimator(r4);
        r0 = r3.jEs;
        r4 = r10.jDC;
        r0.A(r4);
        r0 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$9;
        r0.<init>(r10);
        r3.jEm = r0;
        r0 = com.tencent.mm.R.h.gallery;
        r0 = r10.findViewById(r0);
        r0 = (com.tencent.mm.ui.base.MMViewPager) r0;
        r10.jDB = r0;
        r0 = r10.jDB;
        r0.setVerticalFadingEdgeEnabled(r2);
        r0 = r10.jDB;
        r0.setHorizontalFadingEdgeEnabled(r2);
        r0 = r10.jDB;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$13;
        r3.<init>(r10);
        r0.setOnPageChangeListener(r3);
        r0 = r10.jDB;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$14;
        r3.<init>(r10);
        r0.setSingleClickOverListener(r3);
        r0 = new com.tencent.mm.plugin.gallery.ui.c;
        r0.<init>(r10);
        r10.jDA = r0;
        r0 = r10.jDC;
        r0 = r0.getAdapter();
        r0 = (com.tencent.mm.plugin.gallery.ui.f) r0;
        r3 = r10.jDA;
        r0.jEj = r3;
        r0 = "";
        r3 = r10.jCW;
        if (r3 != 0) goto L_0x03ab;
    L_0x0310:
        r3 = r10.jDA;
        r4 = r10.jDD;
        r3.A(r4);
        r3 = r10.jDA;
        r3.jCW = r2;
        r3 = r10.jDD;
        r3 = r3.size();
        if (r3 <= 0) goto L_0x03f2;
    L_0x0323:
        r0 = r10.jDD;
        r3 = r10.jDF;
        r3 = r3.intValue();
        r0 = r0.get(r3);
        r0 = (java.lang.String) r0;
        r3 = r0;
    L_0x0332:
        r0 = r10.jDB;
        r4 = r10.jDA;
        r0.setAdapter(r4);
        r0 = r10.jDB;
        r4 = r10.jDF;
        r4 = r4.intValue();
        r0.setCurrentItem(r4);
        r0 = r10.aRX();
        r4 = r10.jDA;
        r5 = r10.jDF;
        r5 = r5.intValue();
        r4 = r4.jl(r5);
        r4 = r0.indexOf(r4);
        r0 = r10.jDC;
        r0 = r0.getAdapter();
        r0 = (com.tencent.mm.plugin.gallery.ui.f) r0;
        r5 = r10.jDF;
        r5 = r5.intValue();
        r0.cH(r4, r5);
        r0 = com.tencent.mm.plugin.gallery.model.c.CS(r3);
        r10.a(r3, r0);
        r10.c(r0);
        r0 = "%d/%d";
        r3 = new java.lang.Object[r9];
        r4 = r10.jDF;
        r4 = r4.intValue();
        r4 = r4 + 1;
        r4 = java.lang.Integer.valueOf(r4);
        r3[r2] = r4;
        r2 = r10.jDA;
        r2 = r2.getCount();
        r2 = java.lang.Integer.valueOf(r2);
        r3[r1] = r2;
        r0 = java.lang.String.format(r0, r3);
        r10.setMMTitle(r0);
        goto L_0x0116;
    L_0x039b:
        r0 = r10.jDG;
        r3 = com.tencent.mm.R.k.radio_off;
        r0.setImageResource(r3);
        goto L_0x0157;
    L_0x03a4:
        r0 = r10.jDC;
        r0.setVisibility(r8);
        goto L_0x02b6;
    L_0x03ab:
        r3 = r10.jDA;
        r4 = r10.jBz;
        r5 = r3.jBz;
        r5.clear();
        r5 = r3.jBz;
        r5.addAll(r4);
        r3.reset();
        r3.notifyDataSetChanged();
        r3 = r10.jDA;
        r3.jCW = r1;
        r3 = r10.jDF;
        r3 = r3.intValue();
        r4 = r10.jBz;
        r4 = r4.size();
        if (r3 < r4) goto L_0x03d7;
    L_0x03d1:
        r3 = java.lang.Integer.valueOf(r2);
        r10.jDF = r3;
    L_0x03d7:
        r3 = r10.jBz;
        r3 = r3.size();
        if (r3 <= 0) goto L_0x03f2;
    L_0x03df:
        r0 = r10.jBz;
        r3 = r10.jDF;
        r3 = r3.intValue();
        r0 = r0.get(r3);
        r0 = (com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem) r0;
        r0 = r0.egA;
        r3 = r0;
        goto L_0x0332;
    L_0x03f2:
        r3 = r0;
        goto L_0x0332;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.initView():void");
    }

    private void CW(String str) {
        if (this.jDE.contains(str)) {
            this.jDJ.setImageResource(R.k.checkbox_unselected);
            do {
            } while (this.jDE.remove(str));
            a(this.jDE.size(), this.jDF.intValue(), str, 1);
        } else if (this.jDE.size() >= this.jCs) {
            h.bA(this.mController.tml, getResources().getQuantityString(R.j.gallery_pic_limit, this.jCs, new Object[]{Integer.valueOf(this.jCs)}));
            this.jDJ.setImageResource(R.k.checkbox_unselected);
        } else {
            this.jDE.add(str);
            this.jDJ.setImageResource(R.k.checkbox_selected);
            a(this.jDE.size(), this.jDF.intValue(), str, 0);
        }
        Iterator it = this.jDE.iterator();
        while (it.hasNext()) {
            if (!o.Wf((String) it.next())) {
                return;
            }
        }
        this.jCp = true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.ImagePreviewUI", "test onActivityResult");
        if (i == 4371) {
            if (i2 == -1) {
                setResult(-1, intent);
                finish();
            } else if (this.jDE.size() > 0) {
                CW((String) this.jDE.get(0));
            } else {
                x.e("MicroMsg.ImagePreviewUI", "selectedPath has unexpected size() [%d]", new Object[]{Integer.valueOf(this.jDE.size())});
            }
        } else if (i == 4370) {
            if (i2 == -1) {
                setResult(-1, intent);
            }
            if (intent != null) {
                setResult(-1, intent.putExtra("GalleryUI_IsSendImgBackground", true));
                finish();
            }
        }
        if (i == 4372) {
            if (i2 == -1 && intent != null) {
                this.jDY = true;
                String stringExtra = intent.getStringExtra("before_photo_edit");
                Iterator it = c.aRj().iterator();
                while (it.hasNext()) {
                    if (stringExtra.equals(((Bundle) it.next()).getString("before_photo_edit"))) {
                        it.remove();
                    }
                }
                c.aRj().add(intent.getBundleExtra("report_info"));
                String stringExtra2 = intent.getStringExtra("after_photo_edit");
                String stringExtra3 = intent.getStringExtra("tmp_photo_edit");
                x.i("MicroMsg.ImagePreviewUI", "rawEditPhotoPath:%s lastEditPhotoPath;%s", new Object[]{stringExtra, stringExtra2});
                if (this.jDD != null) {
                    this.jDD.clear();
                    Collection stringArrayListExtra = intent.getStringArrayListExtra("preview_image_list");
                    if (stringArrayListExtra != null) {
                        this.jDD.addAll(stringArrayListExtra);
                    }
                    MediaItem qE = this.jDA.qE(this.jDF.intValue());
                    if (qE == null) {
                        x.e("MicroMsg.ImagePreviewUI", "item is null!!! mPosition:%s rawEditPhotoPath:%s lastEditPhotoPath:%s", new Object[]{this.jDF, stringExtra, stringExtra2});
                        return;
                    }
                    qE.jAS = stringExtra;
                    qE.egA = stringExtra2;
                    qE.iSr = stringExtra2;
                    qE.jAT = stringExtra3;
                    qE.mMimeType = "edit";
                    c.aRi().add(qE);
                    c.aRe().a(new 11(this, intent));
                    c.aRe().b(stringExtra2, qE.getType(), stringExtra2, qE.jAU);
                    x.i("MicroMsg.ImagePreviewUI", "photo_edit_back!");
                }
            }
        } else if (intent != null) {
            setResult(-1, intent.putExtra("GalleryUI_IsSendImgBackground", true));
            finish();
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    private String aRW() {
        switch (c.aRf().aRI()) {
            case 4:
            case 7:
            case 8:
            case 13:
                if (this.jDE.size() == 0 || this.jCs <= 1) {
                    return getString(R.l.gallery_pic_timeline_send);
                }
                return getString(R.l.gallery_pic_timeline_send) + "(" + this.jDE.size() + "/" + this.jCs + ")";
            case 11:
                return getString(R.l.emoji_store_use);
            default:
                if (this.jDE.size() == 0 || this.jCs <= 1) {
                    return getString(R.l.app_send);
                }
                return getString(R.l.gallery_pic_chatting_send, new Object[]{Integer.valueOf(this.jDE.size()), Integer.valueOf(this.jCs)});
        }
    }

    private ArrayList<String> aRX() {
        if (this.jCW) {
            return this.jDE;
        }
        ArrayList<String> arrayList = new ArrayList(this.jDE.size());
        Iterator it = this.jDD.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (this.jDE.contains(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private void fl(boolean z) {
        if (c.aRf().aRI() != 4) {
            if (this.jDA == null) {
                x.i("MicroMsg.ImagePreviewUI", "[setTopTipVisibility] adapter == null");
                return;
            }
            MediaItem qE = this.jDA.qE(this.jDF.intValue());
            if (!z || qE == null) {
                this.jDV.setVisibility(8);
            } else {
                this.jDV.postDelayed(new 16(this, qE), 400);
            }
        }
    }

    private void fm(boolean z) {
        View findViewById;
        x.d("MicroMsg.ImagePreviewUI", "setFooterVisibility() called with: visible = [" + z + "], selectedNormalFooter = " + this.jDN);
        if (this.jDN) {
            findViewById = findViewById(R.h.cropimage_operator_ll);
        } else {
            findViewById = findViewById(R.h.gallery_edit_layout);
        }
        if (findViewById == null) {
            String str;
            String str2 = "MicroMsg.ImagePreviewUI";
            String str3 = "set footer[%s] visibility[%B], but footerbar null";
            Object[] objArr = new Object[2];
            if (this.jDN) {
                str = "normal";
            } else {
                str = "edit_tips";
            }
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(z);
            x.w(str2, str3, objArr);
        } else if (!z || findViewById.getVisibility() != 0) {
            if (z || findViewById.getVisibility() != 8) {
                if (z) {
                    findViewById.setVisibility(0);
                    findViewById.startAnimation(AnimationUtils.loadAnimation(this, R.a.fast_faded_in));
                } else {
                    findViewById.setVisibility(8);
                    findViewById.startAnimation(AnimationUtils.loadAnimation(this, R.a.fast_faded_out));
                }
                if (z && this.jDC.getVisibility() == 8 && this.jDE.size() > 0) {
                    this.jDC.setVisibility(0);
                    this.jDC.startAnimation(AnimationUtils.loadAnimation(this, R.a.fast_faded_in));
                } else if (!z && this.jDC.getVisibility() == 0) {
                    this.jDC.setVisibility(8);
                    this.jDC.startAnimation(AnimationUtils.loadAnimation(this, R.a.fast_faded_out));
                }
            }
        }
    }

    private void goBack() {
        boolean z = true;
        Intent intent = new Intent();
        boolean z2 = !this.jCp;
        String str = "CropImage_Compress_Img";
        if (!this.jCl) {
            z = z2;
        }
        intent.putExtra(str, z);
        intent.putStringArrayListExtra("preview_image_list", aRX());
        intent.putExtra("show_photo_edit_tip", this.jDY);
        setResult(0, intent);
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (c.aRf().aRI() == 3 && getIntent().getBooleanExtra("preview_image", false) && getIntent().getIntExtra("max_select_count", 0) == 1) {
            x.i("MicroMsg.ImagePreviewUI", "clear photo edit cache!");
            sendBroadcast(new Intent("com.tencent.mm.plugin.photoedit.action.clear"));
        }
        if (this.jDA != null) {
            this.jDA.release();
        }
        c.v(null);
        unbindService(this.hKe);
    }

    private void a(String str, MediaItem mediaItem) {
        if (mediaItem != null && mediaItem.getType() == 2 && (c.aRf().aRI() == 4 || c.aRf().aRI() == 13)) {
            boolean z;
            if (mediaItem == null || mediaItem.getType() != 1 || mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                this.jDR.setVisibility(8);
            } else {
                this.jDR.setVisibility(0);
            }
            VideoMediaItem videoMediaItem = (VideoMediaItem) mediaItem;
            enableOptionMenu(false);
            this.jDN = false;
            this.jDL.setVisibility(8);
            this.jDM.setVisibility(0);
            this.jDW.setVisibility(8);
            if (FileOp.mI(str) > 1073741824) {
                this.jDS.setText(getString(R.l.gallery_pic_video_too_large_title));
                this.jDT.setText(getString(R.l.gallery_pic_video_too_large_desc));
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (bi.oW(videoMediaItem.egB)) {
                    enableOptionMenu(false);
                    this.jDN = true;
                    this.jDL.setVisibility(0);
                    this.jDM.setVisibility(8);
                    this.jDH.setVisibility(8);
                    b(str, mediaItem);
                    CX(str);
                    m mVar = new m(str, this.jDF.intValue(), videoMediaItem, new 17(this));
                    if (e.X(mVar)) {
                        x.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", new Object[]{str});
                        return;
                    }
                    e.post(mVar, "video_analysis");
                    return;
                }
                x.d("MicroMsg.ImagePreviewUI", "got MediaItem directly path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", new Object[]{videoMediaItem.egA, Integer.valueOf(videoMediaItem.egD), Integer.valueOf(videoMediaItem.videoHeight), Integer.valueOf(videoMediaItem.videoWidth)});
                a(str, videoMediaItem);
                return;
            }
            return;
        }
        this.jDN = true;
        this.jDL.setVisibility(0);
        this.jDM.setVisibility(8);
        this.jDX.setVisibility(8);
        b(str, mediaItem);
        CX(str);
        enableOptionMenu(true);
        this.jDH.setVisibility(8);
        if (mediaItem == null || mediaItem.getType() != 1 || mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
            boolean booleanExtra = getIntent().getBooleanExtra("preview_image", false);
            x.i("MicroMsg.ImagePreviewUI", "QuerySource:%s isPreViewImage:%s  path:%s", new Object[]{Integer.valueOf(c.aRf().aRI()), Boolean.valueOf(booleanExtra), str});
            if (mediaItem != null || bi.oW(str)) {
                this.jDR.setVisibility(8);
                return;
            } else {
                this.jDR.setVisibility(0);
                return;
            }
        }
        this.jDR.setVisibility(0);
    }

    private void a(String str, VideoMediaItem videoMediaItem) {
        enableOptionMenu(false);
        this.jDN = false;
        this.jDL.setVisibility(8);
        this.jDM.setVisibility(0);
        this.jDW.setVisibility(8);
        if (c.aRf().aRI() == 13) {
            this.jDM.setVisibility(8);
            this.jDL.setVisibility(8);
            this.jDS.setVisibility(8);
            this.jDT.setVisibility(8);
            enableOptionMenu(true);
            return;
        }
        boolean z;
        if (videoMediaItem == null || videoMediaItem.videoWidth <= 0 || videoMediaItem.videoHeight <= 0 || ((float) videoMediaItem.videoWidth) / ((float) videoMediaItem.videoHeight) > 3.0f || ((float) videoMediaItem.videoWidth) / ((float) videoMediaItem.videoHeight) < 0.3f) {
            if (videoMediaItem != null) {
                x.d("MicroMsg.ImagePreviewUI", "check ratio faild width = [%d], height = [%d]", new Object[]{Integer.valueOf(videoMediaItem.videoWidth), Integer.valueOf(videoMediaItem.videoHeight)});
            }
            this.jDS.setText(getString(R.l.gallery_pic_video_special_ratio));
            this.jDT.setText(getString(R.l.gallery_pic_video_special_ratio_desc));
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            x.d("MicroMsg.ImagePreviewUI", "updateBottomLayoutCheckFormat() called with: item = [%s]", new Object[]{videoMediaItem});
            if (!(videoMediaItem == null || bi.oW(videoMediaItem.egA))) {
                String str2 = videoMediaItem.egA;
                if (bi.oW(str2)) {
                    z = true;
                } else {
                    if (this.jDZ == null) {
                        this.jDZ = new HashSet();
                        this.jDZ.add(".h264");
                        this.jDZ.add(".h26l");
                        this.jDZ.add(".264");
                        this.jDZ.add(".avc");
                        this.jDZ.add(".mov");
                        this.jDZ.add(".mp4");
                        this.jDZ.add(".m4a");
                        this.jDZ.add(".3gp");
                        this.jDZ.add(".3g2");
                        this.jDZ.add(".mj2");
                        this.jDZ.add(".m4v");
                    }
                    str2 = str2.trim();
                    int lastIndexOf = str2.lastIndexOf(".");
                    z = (lastIndexOf < 0 || lastIndexOf >= str2.length()) ? true : !this.jDZ.contains(str2.substring(lastIndexOf));
                }
                if (!z && "video/avc".equalsIgnoreCase(videoMediaItem.egB) && (bi.oW(videoMediaItem.egC) || "audio/mp4a-latm".equalsIgnoreCase(videoMediaItem.egC))) {
                    z = false;
                    if (!z) {
                        x.d("MicroMsg.ImagePreviewUI", "check duration %d", new Object[]{Integer.valueOf(videoMediaItem.egD)});
                        if (c.aRf().aRI() != 13) {
                            if (videoMediaItem.egD <= 1000) {
                                this.jDS.setText(getString(R.l.gallery_pic_video_too_short_title));
                                this.jDT.setText(getString(R.l.gallery_pic_video_too_short_desc));
                                z = true;
                            } else if (videoMediaItem.egD >= 300000) {
                                this.jDS.setText(getString(R.l.gallery_pic_video_too_long_title));
                                this.jDT.setText(getString(R.l.gallery_pic_video_too_long_desc));
                                z = true;
                            } else if (videoMediaItem.egD >= (this.jDQ * 1000) + 500) {
                                this.jDS.setText(getString(R.l.gallery_pic_edit_video));
                                this.jDT.setText(getString(R.l.gallery_pic_edit_des_config, new Object[]{Integer.valueOf(this.jDQ)}));
                                this.jDW.setVisibility(0);
                                z = true;
                            }
                            if (!z) {
                                enableOptionMenu(true);
                                this.jDN = true;
                                this.jDL.setVisibility(0);
                                this.jDM.setVisibility(8);
                                this.jDH.setVisibility(0);
                                this.jDX.setVisibility(8);
                                b(str, (MediaItem) videoMediaItem);
                                CX(str);
                            }
                        }
                        z = false;
                        if (!z) {
                            enableOptionMenu(true);
                            this.jDN = true;
                            this.jDL.setVisibility(0);
                            this.jDM.setVisibility(8);
                            this.jDH.setVisibility(0);
                            this.jDX.setVisibility(8);
                            b(str, (MediaItem) videoMediaItem);
                            CX(str);
                        }
                    }
                }
            }
            String str3 = "MicroMsg.ImagePreviewUI";
            String str4 = "check video format failed, dst format [video/avc], video format [%s]";
            Object[] objArr = new Object[1];
            objArr[0] = videoMediaItem == null ? null : videoMediaItem.egB;
            x.d(str3, str4, objArr);
            this.jDS.setText(getString(R.l.gallery_pic_video_not_support));
            this.jDT.setText(getString(R.l.gallery_pic_video_not_support_desc));
            z = true;
            if (!z) {
                x.d("MicroMsg.ImagePreviewUI", "check duration %d", new Object[]{Integer.valueOf(videoMediaItem.egD)});
                if (c.aRf().aRI() != 13) {
                    if (videoMediaItem.egD <= 1000) {
                        this.jDS.setText(getString(R.l.gallery_pic_video_too_short_title));
                        this.jDT.setText(getString(R.l.gallery_pic_video_too_short_desc));
                        z = true;
                    } else if (videoMediaItem.egD >= 300000) {
                        this.jDS.setText(getString(R.l.gallery_pic_video_too_long_title));
                        this.jDT.setText(getString(R.l.gallery_pic_video_too_long_desc));
                        z = true;
                    } else if (videoMediaItem.egD >= (this.jDQ * 1000) + 500) {
                        this.jDS.setText(getString(R.l.gallery_pic_edit_video));
                        this.jDT.setText(getString(R.l.gallery_pic_edit_des_config, new Object[]{Integer.valueOf(this.jDQ)}));
                        this.jDW.setVisibility(0);
                        z = true;
                    }
                    if (!z) {
                        enableOptionMenu(true);
                        this.jDN = true;
                        this.jDL.setVisibility(0);
                        this.jDM.setVisibility(8);
                        this.jDH.setVisibility(0);
                        this.jDX.setVisibility(8);
                        b(str, (MediaItem) videoMediaItem);
                        CX(str);
                    }
                }
                z = false;
                if (!z) {
                    enableOptionMenu(true);
                    this.jDN = true;
                    this.jDL.setVisibility(0);
                    this.jDM.setVisibility(8);
                    this.jDH.setVisibility(0);
                    this.jDX.setVisibility(8);
                    b(str, (MediaItem) videoMediaItem);
                    CX(str);
                }
            }
        }
    }

    private void c(MediaItem mediaItem) {
        if (mediaItem == null) {
            x.e("MicroMsg.ImagePreviewUI", "[updateTopTip] null == item");
        } else if (mediaItem.getType() == 2) {
            VideoMediaItem videoMediaItem = (VideoMediaItem) mediaItem;
            if (bi.oW(videoMediaItem.egB)) {
                m mVar = new m(mediaItem.egA, this.jDF.intValue(), videoMediaItem, new 18(this));
                if (e.X(mVar)) {
                    x.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", new Object[]{mediaItem.egA});
                    return;
                } else {
                    e.post(mVar, "video_analysis");
                    return;
                }
            }
            x.d("MicroMsg.ImagePreviewUI", "path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", new Object[]{videoMediaItem.egA, Integer.valueOf(videoMediaItem.egD), Integer.valueOf(videoMediaItem.videoHeight), Integer.valueOf(videoMediaItem.videoWidth)});
            if (videoMediaItem.egD >= 300000 || (videoMediaItem.egD > 0 && videoMediaItem.egD < 1000)) {
                this.jDV.setVisibility(0);
                this.jDU.setText(videoMediaItem.egD >= 300000 ? getString(R.l.gallery_pic_video_too_long_desc) : getString(R.l.gallery_pic_video_too_short_desc));
                this.jDK.setEnabled(false);
                this.jDJ.setEnabled(false);
                this.jDK.setTextColor(getResources().getColor(R.e.white_text_color_disabled));
                if (this.jDE.size() == 0) {
                    enableOptionMenu(false);
                    return;
                }
                return;
            }
            this.jDK.setEnabled(true);
            this.jDJ.setEnabled(true);
            this.jDK.setTextColor(getResources().getColor(R.e.white_text_color));
            this.jDV.setVisibility(8);
        } else if (mediaItem.getType() == 1 && !mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
            this.jDK.setEnabled(true);
            this.jDJ.setEnabled(true);
            this.jDK.setTextColor(getResources().getColor(R.e.white_text_color));
            if (this.jCp && this.jDE.contains(mediaItem.egA) && FileOp.mI(mediaItem.egA) > 26214400) {
                this.jDV.setVisibility(0);
                this.jDU.setText(getString(R.l.gallery_select_image_to_big));
                return;
            }
            this.jDV.setVisibility(8);
        } else if (mediaItem.getType() == 1 && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
            com.tencent.mm.plugin.gif.e eVar = new com.tencent.mm.plugin.gif.e(mediaItem.egA);
            int cm = com.tencent.mm.a.e.cm(mediaItem.egA);
            try {
                if ((!this.jDE.contains(mediaItem.egA) || cm == 0 || cm <= this.jBy.AA()) && eVar.khG[0] <= this.jBy.Az() && eVar.khG[1] <= this.jBy.Az()) {
                    this.jDK.setTextColor(getResources().getColor(R.e.white_text_color));
                    this.jDK.setEnabled(true);
                    this.jDJ.setEnabled(true);
                    return;
                }
                this.jDK.setTextColor(getResources().getColor(R.e.white_text_color_disabled));
                this.jDK.setEnabled(false);
                this.jDJ.setEnabled(false);
            } catch (Throwable e) {
                x.e("MicroMsg.ImagePreviewUI", bi.i(e));
            }
        }
    }

    private void b(String str, MediaItem mediaItem) {
        if (mediaItem != null && mediaItem.getType() == 2 && c.aRf().aRI() == 4) {
            this.jDJ.setVisibility(8);
            this.jDK.setVisibility(8);
            return;
        }
        if (this.jCs == 1) {
            this.jDJ.setVisibility(8);
            this.jDK.setVisibility(8);
        } else {
            this.jDJ.setVisibility(0);
            this.jDK.setVisibility(0);
        }
        if (this.jDE.contains(str)) {
            this.jDJ.setImageResource(R.k.checkbox_selected);
        } else {
            this.jDJ.setImageResource(R.k.checkbox_unselected);
        }
    }

    private void CX(String str) {
        Boolean valueOf;
        Boolean.valueOf(false);
        switch (c.aRf().aRI()) {
            case 4:
            case 7:
            case 13:
                valueOf = Boolean.valueOf(true);
                break;
            default:
                valueOf = Boolean.valueOf(false);
                break;
        }
        MediaItem CS = c.CS(str);
        if (CS != null && CS.getType() == 2) {
            valueOf = Boolean.valueOf(true);
        }
        if (CS == null && o.Wf(str)) {
            valueOf = Boolean.valueOf(true);
        } else if (CS != null && CS.mMimeType.equalsIgnoreCase("image/gif")) {
            valueOf = Boolean.valueOf(true);
        }
        if (valueOf.booleanValue()) {
            this.jDG.setVisibility(8);
            this.jCf.setVisibility(8);
            return;
        }
        this.jDG.setVisibility(0);
        this.jCf.setVisibility(0);
    }

    private void a(int i, int i2, String str, int i3) {
        x.i("MicroMsg.ImagePreviewUI", "count:%s selectPosition:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (-1 != i2 && !this.jCW) {
            this.jDC.getAdapter().c(i2, Integer.valueOf(i2));
        } else if (-1 != i2) {
            if (i3 == 0 && i > 0) {
                ((f) this.jDC.getAdapter()).jEl.add(str);
                ((f) this.jDC.getAdapter()).cH(i - 1, this.jDF.intValue());
                this.jDC.getAdapter().bm(i - 1);
                this.jDC.smoothScrollToPosition(i - 1);
            } else if (i3 == 1) {
                int indexOf = ((f) this.jDC.getAdapter()).jEl.indexOf(str);
                if (-1 != indexOf) {
                    ((f) this.jDC.getAdapter()).jEl.remove(indexOf);
                    this.jDC.getAdapter().bn(indexOf);
                }
            }
        }
        int i4;
        if (c.aRf().aRI() == 13) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        MediaItem qE = this.jDA.qE(this.jDF.intValue());
        if (i == 0 || ((this.jCl || i4 != 0) && this.jDA != null && qE != null && qE.getType() == 2)) {
            this.jDC.setVisibility(8);
        } else {
            this.jDC.setVisibility(0);
        }
    }
}
