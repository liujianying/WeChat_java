package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.ViewPager.e;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.g.a.aj;
import com.tencent.mm.g.a.aq;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.g.a.gj;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMNewPhotoEditUI;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.tools.f;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import com.tencent.smtt.utils.TbsLog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

@a(3)
public class ImageGalleryUI extends MMActivity implements OnClickListener, al.a {
    public long bJC;
    protected String chatroomName;
    private View contentView;
    private int gcS;
    private int gcT;
    Bundle hDg;
    private boolean hDh = false;
    f hDi;
    int hDj = 0;
    int hDk = 0;
    int hDl = 0;
    int hDm = 0;
    public long hpD;
    private c iYS = new c<mu>() {
        {
            this.sFo = mu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            mu muVar = (mu) bVar;
            if (ImageGalleryUI.this.nMS == null || ImageGalleryUI.this.nMT == null) {
                x.e("MicroMsg.ImageGalleryUI", "not in recoging");
            } else if (muVar == null || !(muVar instanceof mu)) {
                x.e("MicroMsg.ImageGalleryUI", "receive invalid callbak");
            } else if (muVar == null || muVar.bXK.filePath.equals(ImageGalleryUI.this.nMT)) {
                x.i("MicroMsg.ImageGalleryUI", "recog result: " + muVar.bXK.result);
                if (!bi.oW(muVar.bXK.result)) {
                    ImageGalleryUI.this.nMW = muVar.bXK.result;
                    ImageGalleryUI.this.gcS = muVar.bXK.bJr;
                    ImageGalleryUI.this.gcT = muVar.bXK.bJs;
                    if (!(ImageGalleryUI.this.nMW == null || ImageGalleryUI.this.nMS == null)) {
                        ImageGalleryUI.this.nMX = true;
                    }
                    ImageGalleryUI.this.mb(false);
                }
                ImageGalleryUI.this.nMT = null;
            } else {
                x.e("MicroMsg.ImageGalleryUI", "not same filepath");
            }
            return false;
        }
    };
    private d ioF = new 4(this);
    protected MMViewPager jDB;
    private ImageView jdG;
    private boolean ldV;
    private ag mHandler = new ag(Looper.getMainLooper());
    private com.tencent.mm.ui.widget.a.d nMS;
    private String nMT;
    private String nMW;
    private boolean nMX = false;
    private c nNd = new 12(this);
    int nTB;
    int nTC;
    int nTD = 0;
    private float nTE = 1.0f;
    private int nTF = 0;
    private int nTG = 0;
    public boolean qIZ = false;
    private HashSet<Long> tPc = new HashSet();
    private boolean tRr = false;
    protected boolean tRs = false;
    private final boolean tTH = false;
    public b tTx;
    private RelativeLayout tVA;
    private boolean tVB;
    private boolean tVC = false;
    private ImageView tVD;
    private RelativeLayout tVE;
    private RelativeLayout tVF;
    private FrameLayout tVG;
    View tVH;
    Button tVI;
    Button tVJ;
    View tVK;
    private View tVL;
    protected VideoPlayerSeekBar tVM;
    private boolean tVN;
    private MultiTouchImageView tVO;
    private WxImageView tVP;
    int tVQ = 0;
    int tVR = 0;
    boolean tVS;
    ArrayList<Integer> tVT = new ArrayList();
    protected boolean tVU = false;
    protected boolean tVV = false;
    private boolean tVW;
    private String tVX = null;
    public a tVY;
    private View tVZ;
    private b.b tVy;
    private RelativeLayout tVz;
    private CheckBox tWa;
    private View tWb;
    private boolean tWc = true;
    private int tWd = 0;
    private e tWe = new 5(this);
    boolean tWf = false;
    al tWg = new al(new al.a() {
        public final boolean vD() {
            if (ImageGalleryUI.this.tWf) {
                ImageGalleryUI.this.cxh();
            }
            return false;
        }
    }, false);
    private HashMap<Long, String> tWh = new HashMap();
    private boolean tWi = false;
    private boolean tWj = false;
    private al tWk;
    private boolean tWl = false;
    private boolean tWm = false;
    protected String talker;

    /* renamed from: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$11 */
    static /* synthetic */ class AnonymousClass11 {
        static final /* synthetic */ int[] tTN = new int[b.b.values().length];

        static {
            try {
                tTN[b.b.tUe.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                tTN[b.b.tUd.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                tTN[b.b.tUg.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                tTN[b.b.tUf.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    static /* synthetic */ void h(ImageGalleryUI imageGalleryUI) {
        x.i("MicroMsg.ImageGalleryUI", "%d handle single click event.", new Object[]{Integer.valueOf(imageGalleryUI.hashCode())});
        if (imageGalleryUI.cxe()) {
            try {
                if (imageGalleryUI.tTx.cwO().cxz().tXb.getVisibility() == 0) {
                    x.d("MicroMsg.ImageGalleryUI", "%d handle single click event, it is loading video, don't show toolbar", new Object[]{Integer.valueOf(imageGalleryUI.hashCode())});
                    return;
                }
            } catch (Exception e) {
            }
            if (imageGalleryUI.tWf) {
                imageGalleryUI.cxh();
                return;
            } else {
                imageGalleryUI.cxg();
                return;
            }
        }
        imageGalleryUI.onBackPressed();
    }

    static /* synthetic */ void n(ImageGalleryUI imageGalleryUI) {
        if (imageGalleryUI.cxe()) {
            try {
                if (imageGalleryUI.tTx.cwO().cxz().tWZ.getVisibility() == 0) {
                    imageGalleryUI.tTx.cwO().cxz().tWZ.setVisibility(8);
                    imageGalleryUI.tWi = true;
                }
            } catch (Exception e) {
            }
        }
        if (imageGalleryUI.tWf) {
            imageGalleryUI.cxh();
            imageGalleryUI.tWj = true;
        }
    }

    static /* synthetic */ void t(ImageGalleryUI imageGalleryUI) {
        if (imageGalleryUI.cxe() && imageGalleryUI.tWi) {
            try {
                if (imageGalleryUI.tTx.cwO().cxz().tWZ.getVisibility() == 8) {
                    imageGalleryUI.tTx.cwO().cxz().tWZ.setVisibility(0);
                    imageGalleryUI.tWi = false;
                }
            } catch (Exception e) {
            }
        }
        if (imageGalleryUI.tWj) {
            imageGalleryUI.cxg();
            imageGalleryUI.tWj = false;
        }
    }

    static /* synthetic */ void z(ImageGalleryUI imageGalleryUI) {
        x.i("MicroMsg.ImageGalleryUI", "enterPositionAtChatRecords-->talker:%s,magId:%d", new Object[]{imageGalleryUI.talker, Long.valueOf(imageGalleryUI.tTx.ES(imageGalleryUI.tWd).field_msgId)});
        Intent intent = new Intent(imageGalleryUI.mController.tml, ChattingUI.class);
        intent.putExtra("Chat_User", imageGalleryUI.cxa());
        intent.putExtra("finish_direct", true);
        intent.putExtra("show_search_chat_content_result", true);
        intent.putExtra("key_is_biz_chat", imageGalleryUI.qIZ);
        intent.putExtra("key_biz_chat_id", imageGalleryUI.hpD);
        au.HU();
        intent.putExtra("need_hight_item", ((Boolean) com.tencent.mm.model.c.DT().get(aa.a.sSm, Boolean.valueOf(true))).booleanValue());
        intent.putExtra("msg_local_id", r4);
        intent.putExtra("img_gallery_enter_from_chatting_ui", true);
        imageGalleryUI.startActivity(intent);
        if (imageGalleryUI.tVU) {
            h.mEJ.a(219, 16, 1, true);
        } else {
            h.mEJ.a(219, 17, 1, true);
        }
    }

    protected void onPause() {
        x.i("MicroMsg.ImageGalleryUI", "on pause");
        super.onPause();
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(2048, 2048);
        }
        if (!(isFinishing() || this.tTx == null)) {
            b bVar = this.tTx;
            bVar.tTE.tWD.sendEmptyMessageDelayed(1, 200);
            bVar.tTF.cwV();
        }
        if (this.nMW != null) {
            aj ajVar = new aj();
            ajVar.bHK.activity = this;
            ajVar.bHK.bHL = this.nMW;
            com.tencent.mm.sdk.b.a.sFg.m(ajVar);
            this.nMW = null;
            this.gcT = 0;
            this.gcS = 0;
        }
        com.tencent.mm.graphics.b.d.djo.Cl();
        m.Bk(2);
    }

    /* renamed from: cwW */
    final ImageGalleryUI I() {
        if (this.tVH == null) {
            this.tVH = ((ViewStub) findViewById(R.h.image_footer_root)).inflate();
            this.tVI = (Button) this.tVH.findViewById(R.h.cropimage_function_btn);
            this.tVJ = (Button) this.tVH.findViewById(R.h.cropimage_hd_loadding_btn);
            this.tVK = this.tVH.findViewById(R.h.cropimage_hd_loadding_done_root);
        }
        return this;
    }

    protected final ImageGalleryUI cwX() {
        if (this.tVL == null) {
            this.tVL = ((ViewStub) findViewById(R.h.video_footer_root)).inflate();
            this.tVM = (VideoPlayerSeekBar) findViewById(R.h.video_player_seek_bar);
            this.tVM.setPlayBtnOnClickListener(this);
        }
        return this;
    }

    private ImageGalleryUI cwY() {
        if (this.tVE == null) {
            this.tVE = (RelativeLayout) ((ViewStub) findViewById(R.h.goto_grid_gallery_ll)).inflate();
        }
        return this;
    }

    private ImageGalleryUI cwZ() {
        if (this.tVF == null) {
            this.tVF = (RelativeLayout) ((ViewStub) findViewById(R.h.image_footer_download_rl)).inflate();
            this.tVF.findViewById(R.h.download_and_save_icon).setOnClickListener(this);
        }
        return this;
    }

    private static void N(View view, int i) {
        if (view != null) {
            view.setVisibility(i);
        }
    }

    private static int du(View view) {
        if (view != null) {
            return view.getVisibility();
        }
        return 8;
    }

    public final boolean noActionBar() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        long currentTimeMillis = System.currentTimeMillis();
        this.tWc = true;
        super.onCreate(bundle);
        if (com.tencent.mm.compatible.util.d.fR(19)) {
            getWindow().setFlags(201327616, 201327616);
            this.ldV = true;
        } else {
            getWindow().setFlags(1024, 1024);
            this.ldV = false;
        }
        initView();
        this.hDg = bundle;
        com.tencent.mm.sdk.b.a.sFg.b(this.iYS);
        com.tencent.mm.sdk.b.a.sFg.b(this.nNd);
        this.tVC = false;
        x.d("MicroMsg.ImageGalleryUI", "ImageGallery onCreate spent : %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    protected void onResume() {
        super.onResume();
        if (VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(2048);
        }
        if (!(this.tWc || this.tTx == null)) {
            FC(this.jDB.getCurrentItem());
        }
        this.tWc = false;
        if (this.tTx != null) {
            this.tTx.cwP();
        }
        m.Bk(1);
    }

    public void onStart() {
        this.tVV = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
        if (!this.tVB) {
            Bundle bundle = this.hDg;
            if (!this.hDh) {
                this.hDh = true;
                if (VERSION.SDK_INT >= 12) {
                    this.hDj = getIntent().getIntExtra("img_gallery_top", 0);
                    this.hDk = getIntent().getIntExtra("img_gallery_left", 0);
                    this.hDl = getIntent().getIntExtra("img_gallery_width", 0);
                    this.hDm = getIntent().getIntExtra("img_gallery_height", 0);
                    if (this.hDj == 0 && this.hDk == 0 && this.hDl == 0 && this.hDm == 0) {
                        bd ES = this.tTx.ES(this.jDB.getCurrentItem());
                        if (ES != null) {
                            aq aqVar = new aq();
                            aqVar.bHZ.bGS = ES;
                            com.tencent.mm.sdk.b.a.sFg.m(aqVar);
                            this.hDl = aqVar.bIa.bId;
                            this.hDm = aqVar.bIa.bIe;
                            this.hDk = aqVar.bIa.bIb;
                            this.hDj = aqVar.bIa.bIc;
                        }
                    }
                    this.hDi.u(this.hDk, this.hDj, this.hDl, this.hDm);
                    if (bundle == null) {
                        this.jDB.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                            public final boolean onPreDraw() {
                                ImageGalleryUI.this.jDB.getViewTreeObserver().removeOnPreDrawListener(this);
                                ImageGalleryUI.this.nTB = ImageGalleryUI.this.jDB.getWidth();
                                ImageGalleryUI.this.nTC = ImageGalleryUI.this.jDB.getHeight();
                                if (ImageGalleryUI.this.tTx.cwN().cmk()) {
                                    ImageGalleryUI.this.nTC = (int) ((((float) ImageGalleryUI.this.nTB) / ((float) ImageGalleryUI.this.hDl)) * ((float) ImageGalleryUI.this.hDm));
                                }
                                if (ImageGalleryUI.this.tTx.cwN().ckA()) {
                                    ImageGalleryUI.this.tVO = ImageGalleryUI.this.tTx.qC(ImageGalleryUI.this.jDB.getCurrentItem());
                                    if (ImageGalleryUI.this.tVO == null) {
                                        WxImageView qD = ImageGalleryUI.this.tTx.qD(ImageGalleryUI.this.jDB.getCurrentItem());
                                        if (qD != null) {
                                            ImageGalleryUI.this.tVP = qD;
                                        }
                                    }
                                }
                                if (ImageGalleryUI.this.tVO != null) {
                                    ImageGalleryUI.this.nTC = (int) ((((float) ImageGalleryUI.this.nTB) / ((float) ImageGalleryUI.this.tVO.getImageWidth())) * ((float) ImageGalleryUI.this.tVO.getImageHeight()));
                                    if (ImageGalleryUI.this.nTC > ImageGalleryUI.this.jDB.getHeight()) {
                                        ImageGalleryUI.this.nTC = ImageGalleryUI.this.jDB.getHeight();
                                    }
                                } else if (ImageGalleryUI.this.tVP != null) {
                                    ImageGalleryUI.this.nTC = (int) ((((float) ImageGalleryUI.this.nTB) / ((float) ImageGalleryUI.this.tVP.getWidth())) * ((float) ImageGalleryUI.this.tVP.getHeight()));
                                    if (ImageGalleryUI.this.nTC > ImageGalleryUI.this.jDB.getHeight()) {
                                        ImageGalleryUI.this.nTC = ImageGalleryUI.this.jDB.getHeight();
                                    }
                                }
                                ImageGalleryUI.this.hDi.fh(ImageGalleryUI.this.nTB, ImageGalleryUI.this.nTC);
                                if (!ImageGalleryUI.this.tVV) {
                                    ImageGalleryUI.n(ImageGalleryUI.this);
                                    ImageGalleryUI.this.tWi = false;
                                    ImageGalleryUI.this.hDi.a(ImageGalleryUI.this.jDB, ImageGalleryUI.this.jdG, new 1(this));
                                }
                                ImageGalleryUI.this.jDB.setGalleryScaleListener(new 18(ImageGalleryUI.this));
                                return true;
                            }
                        });
                    }
                }
            }
        }
        super.onStart();
    }

    protected void onDestroy() {
        x.i("MicroMsg.ImageGalleryUI", "%d image gallery ui on destroy", new Object[]{Integer.valueOf(hashCode())});
        if (this.tTx != null) {
            this.tTx.detach();
            this.tTx = null;
        }
        cxp();
        this.tWg.SO();
        com.tencent.mm.sdk.b.a.sFg.c(this.iYS);
        com.tencent.mm.sdk.b.a.sFg.c(this.nNd);
        if (this.tVM != null) {
            this.tVM.setPlayBtnOnClickListener(null);
        }
        this.tVM = null;
        super.onDestroy();
    }

    public void onBackPressed() {
        x.i("MicroMsg.ImageGalleryUI", "onBackPressed");
        if (this.tVU) {
            FD(1);
            return;
        }
        try {
            g.a.cwU().detach();
            ayH();
        } catch (Exception e) {
            x.e("MicroMsg.ImageGalleryUI", e.getMessage());
        }
    }

    private String cxa() {
        return (this.chatroomName == null || this.chatroomName.length() <= 0) ? this.talker : this.chatroomName;
    }

    protected final void initView() {
        this.hDi = new f(this.mController.tml);
        this.tWk = new al(this, false);
        this.hDh = false;
        this.talker = getIntent().getStringExtra("img_gallery_talker");
        this.tVU = getIntent().getBooleanExtra("img_gallery_enter_from_grid", false);
        this.tRs = getIntent().getBooleanExtra("img_gallery_enter_from_chatting_ui", false);
        this.tVW = getIntent().getBooleanExtra("img_gallery_enter_from_appbrand_service_chatting_ui", false);
        this.tRr = getIntent().getBooleanExtra("show_search_chat_content_result", false);
        this.qIZ = getIntent().getBooleanExtra("key_is_biz_chat", false);
        this.hpD = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.tVB = getIntent().getBooleanExtra("img_preview_only", false);
        if (!this.tVB) {
            Assert.assertTrue("MicroMsg.ImageGalleryUI initView, talker is null, stack = " + bi.cjd(), this.talker != null);
        }
        this.chatroomName = getIntent().getStringExtra("img_gallery_chatroom_name");
        this.tVV = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
        this.tVX = getIntent().getStringExtra("img_gallery_enter_video_opcode");
        boolean booleanExtra = getIntent().getBooleanExtra("img_gallery_is_restransmit_after_download", false);
        String stringExtra = getIntent().getStringExtra("img_gallery_directly_send_name");
        this.bJC = getIntent().getLongExtra("img_gallery_msg_id", 0);
        long longExtra = getIntent().getLongExtra("img_gallery_msg_svr_id", 0);
        if (this.bJC > 0 || longExtra != 0) {
            if (this.bJC == 0) {
                au.HU();
                this.bJC = com.tencent.mm.model.c.FT().I(cxa(), longExtra).field_msgId;
            }
            au.HU();
            bd dW = com.tencent.mm.model.c.FT().dW(this.bJC);
            if (dW.field_msgId <= 0) {
                x.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.bJC + ", msgSvrId = " + longExtra + ", stack = " + bi.cjd());
                finish();
                return;
            }
            this.tTx = new b(this, this.bJC, cxa(), this.qIZ, this.hpD, booleanExtra, stringExtra, Boolean.valueOf(this.tVV));
            this.tTx.tTH = false;
            this.tTx.tTB = getIntent().getBooleanExtra("start_chatting_ui", true);
            this.tTx.tTG = new b.c() {
                public final void iy() {
                    if (ImageGalleryUI.this.tTx != null) {
                        ImageGalleryUI.this.cxb();
                        ImageGalleryUI.this.tTx.O(100000);
                    }
                }
            };
            this.tVz = (RelativeLayout) findViewById(R.h.cropimage_function_bar);
            this.tVA = (RelativeLayout) findViewById(R.h.cropimage_fuction_top_bar);
            int paddingTop = this.tVA.getPaddingTop();
            if (ak.gw(this.mController.tml)) {
                paddingTop += ak.gv(this.mController.tml);
            }
            this.tVA.setPadding(0, paddingTop, 0, 0);
            this.tVD = (ImageView) findViewById(R.h.video_close_btn);
            this.tVD.setOnClickListener(this);
            Display defaultDisplay = getWindowManager().getDefaultDisplay();
            x.d("MicroMsg.ImageGalleryUI", "%d is vertical screen orient %d [%d, %d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(defaultDisplay.getWidth() < defaultDisplay.getHeight() ? 1 : 0), Integer.valueOf(defaultDisplay.getWidth()), Integer.valueOf(defaultDisplay.getHeight())});
            if (((defaultDisplay.getWidth() < defaultDisplay.getHeight() ? 1 : 0) == 0 ? null : 1) != null) {
                cxq();
            } else {
                cxr();
            }
            this.jdG = (ImageView) findViewById(R.h.gallery_bg);
            this.jdG.setLayerType(2, null);
            this.jDB = (MMViewPager) findViewById(R.h.gallery);
            this.jDB.setLayerType(2, null);
            this.jDB.setVerticalFadingEdgeEnabled(false);
            this.jDB.setHorizontalFadingEdgeEnabled(false);
            this.jDB.setSingleClickOverListener(new MMViewPager.e() {
                public final void ayI() {
                    ImageGalleryUI.h(ImageGalleryUI.this);
                }

                public final void aRZ() {
                    ImageGalleryUI.this.ayH();
                }
            });
            if (!this.tVB) {
                this.jDB.setOnPageChangeListener(this.tWe);
                this.jDB.setLongClickOverListener(new 15(this));
            }
            this.jDB.setOffscreenPageLimit(1);
            this.jDB.setAdapter(this.tTx);
            FC(100000);
            this.jDB.setCurrentItem(100000);
            this.jDB.postDelayed(new Runnable() {
                public final void run() {
                    if (ImageGalleryUI.this.tTx != null) {
                        if (g.a.cwU().tVs && ImageGalleryUI.this.tWa != null) {
                            ImageGalleryUI.this.tWa.setChecked(g.a.cwU().by(ImageGalleryUI.this.tTx.cwN()));
                            ImageGalleryUI.this.tWb.setOnClickListener(ImageGalleryUI.this);
                        }
                        if (ImageGalleryUI.this.jDB.getCurrentItem() == 100000) {
                            ImageGalleryUI.this.cxo();
                            b.b bm = b.bm(ImageGalleryUI.this.tTx.ES(100000));
                            if (!ImageGalleryUI.this.tVV && bm == b.b.tUe) {
                                ImageGalleryUI.this.tTx.Fr(100000);
                            }
                            if (bm == b.b.tUf) {
                                ImageGalleryUI.this.tTx.Fv(100000);
                            }
                        }
                    }
                }
            }, 0);
            if (g.a.cwU().tVs) {
                this.tVZ = ((ViewStub) findViewById(R.h.selected_title_bar)).inflate();
                this.tVZ.setVisibility(0);
                this.tWa = (CheckBox) this.tVZ.findViewById(R.h.media_cbx);
                this.tWb = this.tVZ.findViewById(R.h.media_cbx_clickarea);
            }
            this.tVS = getIntent().getBooleanExtra("img_gallery_enter_PhotoEditUI", false);
            com.tencent.mm.ak.e h = this.tTx.h(dW, true);
            if (h == null) {
                x.e("MicroMsg.ImageGalleryUI", "[initView] imgInfo is null!!! isSoonEnterPhotoEdit:%s", new Object[]{Boolean.valueOf(this.tVS)});
            }
            if (this.tVS && h != null && h.OM()) {
                cxs();
                this.tVS = false;
                return;
            } else if (this.tVS) {
                x.w("MicroMsg.ImageGalleryUI", "img not GetCompleted!");
                return;
            } else {
                return;
            }
        }
        x.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.bJC + ", msgSvrId = " + longExtra + ", stack = " + bi.cjd());
        finish();
    }

    private View a(b bVar, MMViewPager mMViewPager) {
        View view;
        String str = "MicroMsg.ImageGalleryUI";
        String str2 = "get current view adapter is null %b, gallery is null %b";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(bVar == null);
        objArr[1] = Boolean.valueOf(mMViewPager == null);
        x.d(str, str2, objArr);
        if (bVar == null || mMViewPager == null) {
            x.w("MicroMsg.ImageGalleryUI", "%d get current view but adapter or gallery is null", new Object[]{Integer.valueOf(hashCode())});
            view = null;
        } else if (bVar.cwN() == null) {
            return null;
        } else {
            if (bVar.cwN().ckA() || bVar.cwN().cmo()) {
                view = bVar.qC(mMViewPager.getCurrentItem());
                if (view == null) {
                    view = bVar.qD(mMViewPager.getCurrentItem());
                }
            } else {
                if (bVar.cwN().cmj() || bVar.cwN().cmk()) {
                    view = bVar.Fq(mMViewPager.getCurrentItem());
                }
                view = null;
            }
        }
        return view;
    }

    private void ayH() {
        if (this.tVC || this.tTx == null) {
            x.i("MicroMsg.ImageGalleryUI", "isRunningExitAnimation");
        } else if (this.tVB) {
            finish();
            com.tencent.mm.ui.base.b.gE(this.mController.tml);
        } else {
            int i;
            int i2;
            int i3;
            x.i("MicroMsg.ImageGalleryUI", "runExitAnimation");
            int width = this.jDB.getWidth() / 2;
            int height = this.jDB.getHeight() / 2;
            this.tTx.cwL();
            if (this.tVU) {
                gj gjVar = new gj();
                gjVar.bPx.bJC = this.tTx.ES(this.jDB.getCurrentItem()).field_msgId;
                com.tencent.mm.sdk.b.a.sFg.m(gjVar);
                i = gjVar.bPy.bId;
                i2 = gjVar.bPy.bIe;
                width = gjVar.bPy.bIb;
                i3 = gjVar.bPy.bIc;
            } else {
                bd ES = this.tTx.ES(this.jDB.getCurrentItem());
                if (ES != null) {
                    aq aqVar = new aq();
                    aqVar.bHZ.bGS = ES;
                    com.tencent.mm.sdk.b.a.sFg.m(aqVar);
                    i = aqVar.bIa.bId;
                    i2 = aqVar.bIa.bIe;
                    width = aqVar.bIa.bIb;
                    height = aqVar.bIa.bIc;
                } else {
                    i2 = 0;
                    i = 0;
                }
                if (width == 0 && height == 0) {
                    width = this.jDB.getWidth() / 2;
                    i3 = this.jDB.getHeight() / 2;
                } else {
                    if (ES != null) {
                        if (ES.field_isSend == 0) {
                            this.tVQ = com.tencent.mm.bp.a.fromDPToPix(this.mController.tml, 5);
                        }
                        if (ES.field_isSend == 1) {
                            this.tVR = com.tencent.mm.bp.a.fromDPToPix(this.mController.tml, 5);
                        }
                    }
                    i3 = height;
                }
            }
            this.nTB = this.jDB.getWidth();
            this.nTC = this.jDB.getHeight();
            if (this.tTx.cwN() != null) {
                if (this.tTx.cwN().cmk() || this.tTx.cwN().cmj()) {
                    this.nTC = (int) ((((float) this.nTB) / ((float) i)) * ((float) i2));
                }
                if (this.tTx.cwN().ckA() || this.tTx.cwN().cmo()) {
                    this.tVO = this.tTx.qC(this.jDB.getCurrentItem());
                    if (this.tVO == null) {
                        WxImageView qD = this.tTx.qD(this.jDB.getCurrentItem());
                        if (qD != null) {
                            this.tVP = qD;
                        }
                    }
                }
            }
            if (this.tVO != null) {
                this.nTC = (int) ((((float) this.nTB) / ((float) this.tVO.getImageWidth())) * ((float) this.tVO.getImageHeight()));
                if (this.nTC > this.jDB.getHeight()) {
                    if (((double) this.nTC) < ((double) this.jDB.getHeight()) * 1.5d) {
                        if (this.tVU) {
                            this.nTD = this.nTC - this.jDB.getHeight();
                        } else {
                            i2 = (this.jDB.getHeight() * i2) / this.nTC;
                        }
                    }
                    this.nTC = this.jDB.getHeight();
                }
            } else if (this.tVP != null) {
                this.nTC = (int) ((((float) this.nTB) / ((float) this.tVP.getImageWidth())) * ((float) this.tVP.getImageHeight()));
                if (this.nTC > this.jDB.getHeight()) {
                    if (((double) this.nTC) < ((double) this.jDB.getHeight()) * 1.5d) {
                        if (this.tVU) {
                            this.nTD = this.nTC - this.jDB.getHeight();
                        } else {
                            i2 = (this.jDB.getHeight() * i2) / this.nTC;
                        }
                    }
                    this.nTC = this.jDB.getHeight();
                }
            }
            f fVar = this.hDi;
            int i4 = this.tVQ;
            int i5 = this.tVR;
            fVar.nJZ = i4;
            fVar.nKa = i5;
            fVar.nKb = 0;
            fVar.nKc = 0;
            this.hDi.nJY = this.nTD;
            this.hDi.fh(this.nTB, this.nTC);
            this.hDi.u(width, i3, i, i2);
            MMViewPager mMViewPager = this.jDB;
            View a = a(this.tTx, this.jDB);
            if (a == null) {
                a = mMViewPager;
            } else if (((double) this.nTE) != 1.0d) {
                this.hDi.uzR = 1.0f / this.nTE;
                if (!(this.nTF == 0 && this.nTG == 0)) {
                    this.hDi.fi(((int) (((float) (this.jDB.getWidth() / 2)) * (1.0f - this.nTE))) + this.nTF, (int) (((float) ((this.jDB.getHeight() / 2) + this.nTG)) - (((float) (this.nTC / 2)) * this.nTE)));
                }
            }
            this.hDi.a(a, this.jdG, new 19(this), null);
        }
    }

    protected final void mb(boolean z) {
        if (this.tTx != null && this.tWd >= 0) {
            bd ES = this.tTx.ES(this.tWd);
            int bu = this.tTx.tTD.bu(ES);
            if (bu == 5 || bu == 6) {
                x.w("MicroMsg.ImageGalleryUI", "jacks fail downloaded img, return");
            } else if (this.tTx.bl(ES)) {
                x.w("MicroMsg.ImageGalleryUI", "jacks downloading, return");
            } else if (b.bh(ES) && i.bA(ES) == null) {
                x.w("MicroMsg.ImageGalleryUI", "video info is null, return now.");
            } else {
                final List arrayList = new ArrayList();
                final List arrayList2 = new ArrayList();
                arrayList.add(Integer.valueOf(0));
                arrayList2.add(getString(R.l.retransmits));
                if (com.tencent.mm.bg.d.QS("favorite")) {
                    arrayList.add(Integer.valueOf(2));
                    arrayList2.add(getString(R.l.plugin_favorite_opt));
                }
                if (b.bg(ES) || b.bk(ES)) {
                    arrayList.add(Integer.valueOf(1));
                    arrayList2.add(getString(R.l.save_img_to_local));
                } else if (b.bh(ES) || b.bi(ES)) {
                    arrayList.add(Integer.valueOf(1));
                    arrayList2.add(getString(R.l.save_video_to_local));
                } else {
                    arrayList.add(Integer.valueOf(1));
                    arrayList2.add(getString(R.l.save_to_local));
                }
                if (b.bg(ES) || b.bi(ES)) {
                    dj djVar = new dj();
                    djVar.bLf.bJC = ES.field_msgId;
                    com.tencent.mm.sdk.b.a.sFg.m(djVar);
                    if (djVar.bLg.bKE || g.U(this.mController.tml, ES.getType())) {
                        arrayList.add(Integer.valueOf(4));
                        arrayList2.add(getString(R.l.chatting_long_click_menu_open));
                    }
                }
                if (b.bg(ES)) {
                    arrayList.add(Integer.valueOf(6));
                    arrayList2.add(getString(R.l.chatting_image_long_click_photo_edit));
                }
                if (this.nMW != null && aay(this.nMW)) {
                    Object string;
                    arrayList.add(Integer.valueOf(3));
                    if (com.tencent.mm.plugin.scanner.a.aB(this.gcS, this.nMW)) {
                        string = getString(R.l.recog_wxcode_of_image_file);
                    } else {
                        string = getString(R.l.recog_qbar_of_image_file);
                    }
                    arrayList2.add(string);
                }
                if (bf.l(ES)) {
                    arrayList.clear();
                    arrayList2.clear();
                }
                if (!(this.tRr || this.qIZ || g.a.cwU().tVs || this.tVW)) {
                    arrayList.add(Integer.valueOf(5));
                    arrayList2.add(getString(R.l.chatting_image_long_click_goto_chat));
                }
                if (this.nMS == null || !this.nMX) {
                    this.nMS = new com.tencent.mm.ui.widget.a.d(this.mController.tml, 1, false);
                } else {
                    this.nMX = false;
                }
                this.nMS.ofp = new n.c() {
                    public final void a(l lVar) {
                        lVar.clear();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < arrayList.size()) {
                                lVar.e(((Integer) arrayList.get(i2)).intValue(), (CharSequence) arrayList2.get(i2));
                                i = i2 + 1;
                            } else {
                                return;
                            }
                        }
                    }
                };
                if (arrayList.size() != 0) {
                    this.nMS.ofq = this.ioF;
                    this.nMS.bXO();
                    this.nMS.uJQ = new 3(this);
                    if ((b.bg(ES) || b.bk(ES)) && true == z && au.DF().Lg() != 0) {
                        String str = null;
                        if (b.bg(ES)) {
                            com.tencent.mm.ak.e h = this.tTx.h(ES, true);
                            if (h != null) {
                                str = d.d(ES, h);
                            }
                        } else {
                            str = b.bq(ES);
                        }
                        if (str != null) {
                            ms msVar = new ms();
                            msVar.bXH.filePath = str;
                            this.nMT = str;
                            com.tencent.mm.sdk.b.a.sFg.m(msVar);
                        }
                    }
                }
            }
        }
    }

    private boolean aay(String str) {
        if (bi.oW(str)) {
            return false;
        }
        if (!this.tVW) {
            return true;
        }
        String[] split = ((String) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sTZ, "")).split("\\|");
        if (split != null && split.length > 0) {
            int length = split.length;
            int i = 0;
            while (i < length) {
                String str2 = split[i];
                if (bi.oW(str2) || !str.startsWith(str2)) {
                    i++;
                } else {
                    x.i("MicroMsg.ImageGalleryUI", "curDealQBarStr:%s, blockQrcodeStr:%s", new Object[]{str, str2});
                    return false;
                }
            }
        }
        return true;
    }

    public final void fm(boolean z) {
        int i = 8;
        if (!z || this.tVz.getVisibility() != 0) {
            if (z || this.tVz.getVisibility() != 8) {
                RelativeLayout relativeLayout = this.tVz;
                if (z) {
                    i = 0;
                }
                relativeLayout.setVisibility(i);
                this.tVz.startAnimation(AnimationUtils.loadAnimation(this.mController.tml, z ? R.a.alpha_in : R.a.alpha_out));
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.image_gallery;
    }

    protected final void onCreateBeforeSetContentView() {
        super.onCreateBeforeSetContentView();
    }

    private void cxb() {
        if (this.tTx != null && !this.tVB && this.tTx.cwM() && cwY().tVE != null) {
            if (g.a.cwU().tVs) {
                cxd();
            } else if (this.tRr) {
                cxd();
            } else {
                x.d("MicroMsg.ImageGalleryUI", "%d show enter grid is video %b", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(cxe())});
                cxc();
                cxo();
            }
        }
    }

    private void cxc() {
        int i;
        int i2 = 0;
        N(cwY().tVE, 0);
        bd bdVar = null;
        if (this.tTx != null) {
            bdVar = this.tTx.cwN();
        }
        int i3 = 1;
        if (this.tVy != b.b.tUd) {
            i3 = 0;
        }
        if (bdVar == null || !bf.l(bdVar)) {
            i = i3;
        } else {
            i = 0;
        }
        View view = cwZ().tVF;
        if (i == 0) {
            i2 = 8;
        }
        N(view, i2);
    }

    private void cxd() {
        N(cwY().tVE, 8);
        N(cwZ().tVF, 8);
    }

    private static boolean f(bd bdVar, com.tencent.mm.ak.e eVar) {
        if (eVar == null) {
            return false;
        }
        try {
            if (b.b(bdVar, eVar) == 0 && eVar.ON() && !bdVar.cmu()) {
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            x.e("MicroMsg.ImageGalleryUI", "error:" + e);
            return false;
        }
    }

    public final void FC(int i) {
        bz(this.tTx.ES(i));
    }

    private boolean cxe() {
        if (this.tVy == b.b.tUe) {
            return true;
        }
        return false;
    }

    protected final void cxf() {
        if (this.tWf) {
            this.tWg.J(4000, 4000);
        }
    }

    public final void cxg() {
        x.i("MicroMsg.ImageGalleryUI", "show video tool bar");
        fm(true);
        mc(true);
        N(this.tVH, 8);
        N(cwX().tVL, 0);
        N(this.tVD, 0);
        cwY().tVE.clearAnimation();
        if (this.tVB) {
            cxd();
        } else {
            cxc();
        }
        cxp();
        this.tWf = true;
        cxf();
    }

    public final void cxh() {
        x.i("MicroMsg.ImageGalleryUI", "hide video tool bar");
        mc(false);
        N(cwX().tVL, 8);
        N(this.tVD, 8);
        if (cxe()) {
            cxp();
            cxd();
        }
        this.tWf = false;
    }

    private void mc(boolean z) {
        x.d("MicroMsg.ImageGalleryUI", "switch tool bar bg %b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.tVA.setBackgroundResource(R.g.image_gallery_video_top_bg);
            this.tVz.setBackgroundResource(R.g.image_gallery_video_bottom_bg);
            return;
        }
        dv(this.tVA);
        dv(this.tVz);
    }

    private static void dv(View view) {
        if (com.tencent.mm.compatible.util.d.fR(16)) {
            view.setBackground(null);
        } else {
            view.setBackgroundDrawable(null);
        }
    }

    public final synchronized void bz(bd bdVar) {
        int i = 0;
        synchronized (this) {
            this.tVy = b.bm(bdVar);
            x.i("MicroMsg.ImageGalleryUI", "updateFooterInfo currGalleryType : " + this.tVy);
            if (g.a.cwU().tVs && this.tWa != null) {
                this.tWa.setChecked(g.a.cwU().by(bdVar));
            }
            switch (AnonymousClass11.tTN[this.tVy.ordinal()]) {
                case 1:
                    cxh();
                    N(this.tVH, 8);
                    md(true);
                    r bA = i.bA(bdVar);
                    if (bA != null) {
                        cwX().tVM.setVideoTotalTime(bA.enM);
                        try {
                            if (!(this.tTx.cwO() == null || this.tTx.cwO().tXa == null)) {
                                i = this.tTx.cwO().tXa.getCurrentPosition() / TbsLog.TBSLOG_CODE_SDK_BASE;
                            }
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.ImageGalleryUI", e, "", new Object[0]);
                        }
                        cwX().tVM.seek(i);
                        break;
                    }
                    break;
                case 2:
                    com.tencent.mm.ak.e h = this.tTx.h(bdVar, false);
                    cxh();
                    cxb();
                    if (h != null) {
                        this.jDB.getCurrentItem();
                        if (f(bdVar, h) && !bdVar.cmu() && h.OM()) {
                            I().tVI.setVisibility(0);
                            I().tVJ.setVisibility(8);
                            I().tVK.setVisibility(8);
                            String str = (String) this.tWh.get(Long.valueOf(h.dTK));
                            if (str == null) {
                                Map z = bl.z(h.dTV, "msg");
                                if (z == null) {
                                    x.e("MicroMsg.ImageGalleryUI", "parse cdnInfo failed. [%s]", new Object[]{h.dTV});
                                    i = -1;
                                } else {
                                    i = bi.getInt((String) z.get(".msg.img.$hdlength"), 0);
                                }
                                long j = (long) i;
                                if (j < 0) {
                                    str = "";
                                } else {
                                    BigDecimal bigDecimal = new BigDecimal(j);
                                    float floatValue = bigDecimal.divide(new BigDecimal(1048576), 2, 0).floatValue();
                                    str = floatValue > 1.0f ? ((int) floatValue) + "M" : ((int) bigDecimal.divide(new BigDecimal(1024), 2, 0).floatValue()) + "K";
                                }
                                this.tWh.put(Long.valueOf(h.dTK), str);
                            }
                            I().tVI.setText(getString(R.l.cropimage_view_hd_img_detail, new Object[]{str}));
                            N(this.tVH, 0);
                        } else {
                            N(this.tVH, 8);
                        }
                        if (!this.tVS || !h.OM() || this.tTx.cwN() == null || bdVar.field_msgId != this.tTx.cwN().field_msgId) {
                            bd cwN = this.tTx.cwN();
                            String str2 = "MicroMsg.ImageGalleryUI";
                            String str3 = "isSoonEnterPhotoEdit:%s msgId:%s curMsgId:%s getCompleted:%s";
                            Object[] objArr = new Object[4];
                            objArr[0] = Boolean.valueOf(this.tVS);
                            objArr[1] = Long.valueOf(bdVar.field_msgId);
                            objArr[2] = cwN == null ? "null" : Long.valueOf(cwN.field_msgId);
                            objArr[3] = Boolean.valueOf(h.OM());
                            x.w(str2, str3, objArr);
                            break;
                        }
                        x.i("MicroMsg.ImageGalleryUI", "get image successfully! -> gotoPhotoEditUI msgId:%s", new Object[]{Long.valueOf(bdVar.field_msgId)});
                        cxs();
                        this.tVS = false;
                        break;
                    }
                    x.w("MicroMsg.ImageGalleryUI", "updateFooterInfo img info is null");
                    break;
                    break;
                case 3:
                    cxh();
                    cxb();
                    break;
                case 4:
                    cxh();
                    cxb();
                    N(this.tVH, 8);
                    this.tTx.Fv(this.jDB.getCurrentItem());
                    break;
            }
        }
    }

    private void FD(int i) {
        x.i("MicroMsg.ImageGalleryUI", "enterGrid source : " + i);
        if (this.tTx == null) {
            x.w("MicroMsg.ImageGalleryUI", "try to enterGrid, but adapter is NULL");
            return;
        }
        h.mEJ.a(219, 13, 1, true);
        int aFL = this.tTx.aFL();
        if (this.tTx.cwN() == null) {
            x.e("MicroMsg.ImageGalleryUI", "msgInfo is null");
            return;
        }
        int Fw = this.tTx.tTz.Fw(this.jDB.getCurrentItem());
        if (this.tVU) {
            ayH();
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this.mController.tml, MediaHistoryGalleryUI.class);
        intent.addFlags(67108864);
        intent.putExtra("kintent_intent_source", i);
        intent.putExtra("kintent_talker", cxa());
        intent.putExtra("kintent_image_count", aFL);
        intent.putExtra("kintent_image_index", Fw);
        intent.putExtra("key_biz_chat_id", this.hpD);
        intent.putExtra("key_is_biz_chat", this.qIZ);
        startActivity(intent);
        com.tencent.mm.ui.base.b.gE(this.mController.tml);
        this.mHandler.postDelayed(new 7(this), 50);
    }

    public final int getCurrentItem() {
        return this.jDB.getCurrentItem();
    }

    public void onClick(View view) {
        boolean z = true;
        if (this.tTx != null) {
            if (view.getId() == R.h.goto_grid_gallery_ll) {
                FD(0);
            } else if (view.getId() == R.h.download_and_save_icon) {
                x.i("MicroMsg.ImageGalleryUI", "[oreh download_and_save] hdImg suc, curPos:%d", new Object[]{Integer.valueOf(this.jDB.getCurrentItem())});
                N(cwZ().tVF, 8);
                bd ES = this.tTx.ES(this.jDB.getCurrentItem());
                com.tencent.mm.ak.e h = this.tTx.h(ES, false);
                this.jDB.getCurrentItem();
                if (f(ES, h) && !ES.cmu() && h.OM()) {
                    this.tTx.ao(this.jDB.getCurrentItem(), true);
                } else {
                    b.b(this.mController.tml, this.tTx.cwN(), true);
                }
            } else if (view.getId() == R.h.cropimage_function_btn) {
                this.tTx.ao(this.jDB.getCurrentItem(), false);
            } else if (view.getId() == R.h.cropimage_hd_loadding_btn) {
                this.tTx.Fu(this.jDB.getCurrentItem());
                FC(this.jDB.getCurrentItem());
                cxl();
                cxm();
                cxo();
            } else if (view.getId() == R.h.actionbar_up_indicator) {
                onBackPressed();
            } else if (view.getId() == R.h.video_close_btn) {
                onBackPressed();
            } else if (view.getId() == R.h.media_cbx_clickarea) {
                boolean isChecked = this.tWa.isChecked();
                if (isChecked || g.a.cwU().tTJ.size() < 9) {
                    CheckBox checkBox = this.tWa;
                    if (isChecked) {
                        z = false;
                    }
                    checkBox.setChecked(z);
                    if (this.tWa.isChecked()) {
                        g.a.cwU().bw(this.tTx.cwN());
                        return;
                    } else {
                        g.a.cwU().bx(this.tTx.cwN());
                        return;
                    }
                }
                Toast.makeText(this, getResources().getString(R.l.gallery_select_limit, new Object[]{Integer.valueOf(9)}), 1).show();
            } else if (view.getId() == R.h.play_btn) {
                this.tTx.Fr(this.jDB.getCurrentItem());
            }
        }
    }

    public static void cxi() {
    }

    public final void md(boolean z) {
        try {
            cwX().tVM.setIsPlay(!z);
        } catch (Exception e) {
            x.e("MicroMsg.ImageGalleryUI", "set video state iv error : " + e.toString());
        }
    }

    public final boolean bIB() {
        return cwX().tVM.bPb;
    }

    public final void FE(int i) {
        if (cwX().tVL != null) {
            cwX().tVL.post(new 8(this, i));
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 82 || keyEvent.getAction() != 1) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (this.nMS != null) {
            this.nMS.bzW();
            this.nMS = null;
            return true;
        }
        mb(true);
        return true;
    }

    final void cxj() {
        if (cwY().tVE != null && !this.tWl) {
            String str = "MicroMsg.ImageGalleryUI";
            String str2 = "fadeOutEnterGirdBtn: %B";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.tVE.getVisibility() == 0);
            x.d(str, str2, objArr);
            Animation FF = FF(TbsListener$ErrorCode.ERROR_CODE_LOAD_BASE);
            FF.setFillAfter(false);
            FF.setAnimationListener(new 9(this));
            cwY().tVE.startAnimation(FF);
            this.tWl = true;
        }
    }

    final void cxk() {
        if (cwY().tVG != null && !this.tWm) {
            cwY().tVG.startAnimation(FF(TbsListener$ErrorCode.ERROR_CODE_LOAD_BASE));
            this.tWm = true;
        }
    }

    private void cxl() {
        if (cwY().tVE != null && this.tWl && !cxe()) {
            String str = "MicroMsg.ImageGalleryUI";
            String str2 = "fadeInEnterGirdBtn: %B %s";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(cwY().tVE.getVisibility() == 0);
            objArr[1] = bi.cjd();
            x.d(str, str2, objArr);
            cwY().tVE.startAnimation(cxn());
            cwZ().tVF.startAnimation(cxn());
            this.tWl = false;
        }
    }

    private void cxm() {
        boolean z = true;
        if (cwY().tVG != null && this.tWm) {
            String str = "MicroMsg.ImageGalleryUI";
            String str2 = "fadeInPositionAtChatRecordBtn: %B";
            Object[] objArr = new Object[1];
            if (cwY().tVG.getVisibility() != 0) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.d(str, str2, objArr);
            cwY().tVG.startAnimation(cxn());
            this.tWm = false;
        }
    }

    private static Animation cxn() {
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(150);
        alphaAnimation.setFillAfter(true);
        return alphaAnimation;
    }

    static Animation FF(int i) {
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration((long) i);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setInterpolator(new AccelerateInterpolator(10.0f));
        return alphaAnimation;
    }

    public final boolean vD() {
        cxj();
        cxk();
        return false;
    }

    protected final void cxo() {
        Object obj = (du(this.tVH) == 0 && du(this.tVI) == 0) ? 1 : null;
        if (obj == null && this.tTx != null) {
            x.d("MicroMsg.ImageGalleryUI", "jacks start Hide Timer");
            this.tWk.J(4000, 4000);
        }
    }

    private void cxp() {
        x.d("MicroMsg.ImageGalleryUI", "jacks stop Hide Timer");
        this.tWk.SO();
    }

    public final void FG(int i) {
        fm(true);
        cxh();
        I().tVH.setVisibility(0);
        I().tVI.setVisibility(8);
        I().tVJ.setVisibility(0);
        I().tVK.setVisibility(8);
        cxj();
        cxk();
        I().tVJ.setText(i + "%");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void finish() {
        this.tPc.clear();
        super.finish();
    }

    public final int gJ(long j) {
        if (bi.oW(this.tVX)) {
            return 0;
        }
        try {
            int e = t.e(j, this.tVX);
            if (e == -1) {
                this.tVX = null;
                e = 0;
            }
            x.d("MicroMsg.ImageGalleryUI", "get enter video op code %d %s", new Object[]{Integer.valueOf(e), this.tVX});
            return e;
        } catch (Exception e2) {
            x.e("MicroMsg.ImageGalleryUI", "get enter video op code error : " + e2.toString());
            return 0;
        }
    }

    public final void gK(long j) {
        if (!bi.oW(this.tVX) && j != 0 && t.e(j, this.tVX) == -1) {
            this.tVX = null;
            x.d("MicroMsg.ImageGalleryUI", "reset enter video op code %s", new Object[]{this.tVX});
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            x.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is vertical screen", new Object[]{Integer.valueOf(hashCode())});
            cxq();
        } else if (configuration.orientation == 2) {
            x.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is horizontal screen", new Object[]{Integer.valueOf(hashCode())});
            cxr();
        }
    }

    private void cxq() {
        x.i("MicroMsg.ImageGalleryUI", "%d handleVerticalUI image gallery ui isNavigationBarTint %b isNavBarVisibility %b navBarHeight %d", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(this.ldV), Boolean.valueOf(ak.gt(this)), Integer.valueOf(ak.gs(this))});
        if (this.ldV && r0) {
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.tVz.getLayoutParams());
            layoutParams.addRule(12);
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, r1);
            this.tVz.setLayoutParams(layoutParams);
            layoutParams = new RelativeLayout.LayoutParams(this.tVA.getLayoutParams());
            layoutParams.addRule(10);
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, 0, layoutParams.bottomMargin);
            this.tVA.setLayoutParams(layoutParams);
        }
    }

    private void cxr() {
        boolean gt = ak.gt(this);
        int gs = ak.gs(this);
        x.i("MicroMsg.ImageGalleryUI", "%d handleHorizontalUI image gallery ui isNavigationBarTint %b isNavBarVisibility %b navBarHeight %d", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(this.ldV), Boolean.valueOf(gt), Integer.valueOf(gs)});
        if (this.ldV && gt) {
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.tVz.getLayoutParams());
            layoutParams.addRule(12);
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, gs, 0);
            this.tVz.setLayoutParams(layoutParams);
            layoutParams = new RelativeLayout.LayoutParams(this.tVA.getLayoutParams());
            layoutParams.addRule(10);
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, gs, layoutParams.bottomMargin);
            this.tVA.setLayoutParams(layoutParams);
        }
    }

    private void cxs() {
        String stringExtra = getIntent().getStringExtra("GalleryUI_FromUser");
        String stringExtra2 = getIntent().getStringExtra("GalleryUI_ToUser");
        Intent intent = new Intent();
        bd cwN = this.tTx.cwN();
        x.i("MicroMsg.ImageGalleryUI", "edit image path:%s msgId:%s", new Object[]{d.d(cwN, d.bv(cwN)), Long.valueOf(cwN.field_msgId)});
        intent.putExtra("before_photo_edit", r4);
        intent.putExtra("GalleryUI_FromUser", stringExtra);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        intent.putExtra("from_scene", 291);
        intent.putExtra("after_photo_edit", "");
        intent.setClass(this, MMNewPhotoEditUI.class);
        startActivityForResult(intent, 4369);
        overridePendingTransition(0, 0);
    }

    protected final int getForceOrientation() {
        return 2;
    }
}
