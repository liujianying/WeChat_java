package com.tencent.mm.plugin.gallery.ui;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.g.b;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.plugin.gallery.stub.GalleryStubService;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.DrawedCallBackFrameLayout;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@a(19)
public class AlbumPreviewUI extends MMActivity implements b {
    static long start = 0;
    private String bSS;
    private int dYK;
    private ProgressDialog eHw;
    private ServiceConnection hKe = new ServiceConnection() {
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            x.d("MicroMsg.AlbumPreviewUI", "onServiceConnected");
            AlbumPreviewUI.this.jBy = com.tencent.mm.plugin.gallery.stub.a.a.Q(iBinder);
            if (AlbumPreviewUI.this.jCb != null) {
                AlbumPreviewUI.this.jCb.jBy = AlbumPreviewUI.this.jBy;
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            x.d("MicroMsg.AlbumPreviewUI", "onServiceDisconnected");
            AlbumPreviewUI.this.jBy = null;
        }
    };
    private GridView jBW;
    private TextView jBX;
    private boolean jBY;
    private boolean jBZ;
    private com.tencent.mm.plugin.gallery.stub.a jBy = null;
    private long jCA = -1;
    private a.a jCB = new 7(this);
    private boolean jCC = false;
    private HashMap<String, Integer> jCD = new HashMap();
    private TextView jCa;
    private a jCb;
    private TextView jCc;
    private TextView jCd;
    private ImageFolderMgrView jCe;
    private TextView jCf;
    private ImageButton jCg;
    private String jCh;
    private String jCi;
    private int jCj;
    private String jCk;
    private boolean jCl = false;
    private boolean jCm = false;
    private boolean jCn = false;
    private boolean jCo = false;
    private boolean jCp = false;
    private boolean jCq = false;
    private boolean jCr = false;
    private int jCs;
    private int jCt;
    boolean jCu = false;
    private int jCv = 0;
    private int jCw = 0;
    private long jCx = 0;
    private long jCy;
    private int jCz = -1;
    private String toUser;

    static /* synthetic */ int D(AlbumPreviewUI albumPreviewUI) {
        int i = albumPreviewUI.jCv + 1;
        albumPreviewUI.jCv = i;
        return i;
    }

    static /* synthetic */ void e(AlbumPreviewUI albumPreviewUI) {
        if (albumPreviewUI.jCp) {
            Iterator it = albumPreviewUI.jCb.jBA.iterator();
            int i = 0;
            int i2 = 0;
            while (it.hasNext()) {
                MediaItem mediaItem = (MediaItem) it.next();
                if (mediaItem != null && mediaItem.getType() == 1) {
                    if (26214400 < e.cm(mediaItem.egA)) {
                        x.w("MicroMsg.AlbumPreviewUI", "[onClick] item:%s file size:%s", new Object[]{mediaItem, Integer.valueOf(e.cm(mediaItem.egA))});
                        i2++;
                    }
                    i++;
                }
                i = i;
            }
            if (i2 <= 0) {
                return;
            }
            if (i == i2) {
                h.bz(albumPreviewUI, albumPreviewUI.getString(R.l.gallery_select_raw_image_to_big));
            } else {
                h.bz(albumPreviewUI, albumPreviewUI.getString(R.l.gallery_select_image_some_count_to_big));
            }
        }
    }

    static /* synthetic */ void g(AlbumPreviewUI albumPreviewUI) {
        if (albumPreviewUI.jCb.jBA.size() > 0) {
            albumPreviewUI.enableOptionMenu(true);
        } else {
            albumPreviewUI.enableOptionMenu(false);
        }
    }

    static /* synthetic */ void s(AlbumPreviewUI albumPreviewUI) {
        h.i(albumPreviewUI, R.l.video_export_file_error, R.l.gallery_send_video_over_size_title);
        x.w("MicroMsg.AlbumPreviewUI", "video is import error");
    }

    static /* synthetic */ void t(AlbumPreviewUI albumPreviewUI) {
        h.i(albumPreviewUI, R.l.gallery_send_video_over_size, R.l.gallery_send_video_over_size_title);
        x.w("MicroMsg.AlbumPreviewUI", "video is over size");
    }

    static /* synthetic */ int u(AlbumPreviewUI albumPreviewUI) {
        int i = albumPreviewUI.jCw + 1;
        albumPreviewUI.jCw = i;
        return i;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jCy = System.currentTimeMillis();
        x.i("MicroMsg.AlbumPreviewUI", "onCreate");
        if (bundle != null) {
            x.i("MicroMsg.AlbumPreviewUI", "savedInstanceState not null");
            this.jCt = bundle.getInt("constants_key");
            c.aRf().qu(this.jCt);
        }
        getString(R.l.app_tip);
        this.eHw = h.a(this, getString(R.l.app_waiting), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        int intExtra = getIntent().getIntExtra("query_source_type", 3);
        int intExtra2 = getIntent().getIntExtra("query_media_type", 1);
        x.i("MicroMsg.AlbumPreviewUI", "query souce: " + intExtra + ", queryType: " + intExtra2);
        c.aRf().qt(intExtra2);
        c.aRf().qu(intExtra);
        initView();
        c.aRf().jBk.add(this);
        this.jCA = System.currentTimeMillis();
        l aRf = c.aRf();
        aRf.e(this.jCi, aRf.jBm, this.jCA);
        bindService(new Intent(this.mController.tml, GalleryStubService.class), this.hKe, 1);
        m.Bk(1);
    }

    protected void onPause() {
        super.onPause();
        this.jCr = true;
        c.aRg().aRu().removeCallbacksAndMessages(null);
        c.aRg().aRv();
        x.d("MicroMsg.AlbumPreviewUI", "shouldSaveLastChoosePath: " + this.jCm);
        if (this.jCm) {
            aRQ();
        }
        if (this.jCe.Ld) {
            ImageFolderMgrView imageFolderMgrView = this.jCe;
            if (!imageFolderMgrView.Ld) {
                x.w("MicroMsg.ImageFolderMgrView", "want to close, but it was closed");
            } else if (imageFolderMgrView.jDm) {
                x.d("MicroMsg.ImageFolderMgrView", "want to close, but it is in animation");
            } else {
                imageFolderMgrView.jDi.setVisibility(8);
                imageFolderMgrView.Ld = false;
            }
        }
        try {
            this.jBy.qv(this.dYK);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
        }
        this.dYK = 0;
    }

    protected void onResume() {
        super.onResume();
        x.d("MicroMsg.AlbumPreviewUI", "on resume");
        this.jCr = false;
    }

    protected void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.AlbumPreviewUI", "onDestroy");
        c.aRf().b(this.jCe);
        c.aRf().jBk.remove(this);
        if (this.jCv > 0 || this.jCw > 0) {
            x.d("MicroMsg.AlbumPreviewUI", "report click camera count[%d], click folder count[%d]", new Object[]{Integer.valueOf(this.jCv), Integer.valueOf(this.jCw)});
            try {
                this.jBy.al(11187, this.jCv + "," + this.jCw);
            } catch (Throwable e) {
                x.e("MicroMsg.AlbumPreviewUI", "report error, %s", new Object[]{e.getMessage()});
                x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
            }
        } else {
            x.w("MicroMsg.AlbumPreviewUI", "do not click camera or folder!");
        }
        try {
            boolean z;
            if (this.jCx > 0 || this.jBZ) {
                c.a(this.jBy, this.jCk, y(this.jCb.jBA), this.jCp, this.jBY);
            }
            com.tencent.mm.plugin.gallery.stub.a aVar = this.jBy;
            int size = this.jCb.jBA.size();
            boolean z2 = this.jCp;
            if (this.jCx > 0 || this.jBZ) {
                z = true;
            } else {
                z = false;
            }
            c.a(aVar, size, z2, z);
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e2, "", new Object[0]);
        }
        sendBroadcast(new Intent("com.tencent.mm.plugin.photoedit.action.clear"));
        c.aRi().clear();
        c.aRj().clear();
        c.aRk().clear();
        try {
            unbindService(this.hKe);
        } catch (Throwable e22) {
            x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e22, "Failed to unbindService when Activity.onDestroy is invoked.", new Object[0]);
        }
        m.Bk(2);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        this.jCt = c.aRf().aRI();
        bundle.putInt("constants_key", this.jCt);
    }

    protected final int getLayoutId() {
        return R.i.sd_card_media_folder_preview;
    }

    private void updateTitle() {
        if (c.aRf().aRJ() == 3) {
            setMMTitle(R.l.gallery_all_pic_and_video);
            this.jCa.setText(R.l.gallery_all_pic_and_video);
        } else if (c.aRf().aRJ() == 1) {
            setMMTitle(R.l.gallery_send_pic);
            this.jCa.setText(R.l.gallery_all_pic);
        } else {
            setMMTitle(R.l.gallery_all_video);
            this.jCa.setText(R.l.gallery_all_video);
        }
    }

    private static int[] y(ArrayList<MediaItem> arrayList) {
        int[] iArr = new int[4];
        iArr[0] = arrayList.size();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            MediaItem mediaItem = (MediaItem) it.next();
            if (mediaItem != null) {
                if (!bi.oW(mediaItem.mMimeType) && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                    iArr[2] = iArr[2] + 1;
                } else if (mediaItem.getType() == 2) {
                    iArr[3] = iArr[3] + 1;
                } else if (mediaItem.getType() == 1) {
                    iArr[1] = iArr[1] + 1;
                }
            }
        }
        return iArr;
    }

    private void a(AlbumItem albumItem) {
        if (albumItem != null) {
            if (bi.aG(this.jCi, "").equals(albumItem.jAQ)) {
                x.w("MicroMsg.AlbumPreviewUI", "want to reset folder, same folder, return");
                return;
            }
            c.aRk().addAll(this.jCb.jBA);
            x.d("MicroMsg.AlbumPreviewUI", "reset folder[%s], path[%s]", new Object[]{albumItem.jAQ, albumItem.aRw()});
            this.jCh = albumItem.aRw();
            this.jCi = albumItem.jAQ;
            if (albumItem.jAR != null) {
                this.jCj = albumItem.jAR.getType();
            }
            if (bi.oW(this.jCh)) {
                x.w("MicroMsg.AlbumPreviewUI", "reset folder path failed");
                this.jCh = this.jCi;
            }
            if (bi.oW(this.jCi)) {
                if (getIntent().getBooleanExtra("show_header_view", true)) {
                    this.jCb.a(this.jCB);
                }
                updateTitle();
                this.jCj = c.aRf().aRJ();
            } else {
                a aVar = this.jCb;
                a.a aVar2 = this.jCB;
                if (aVar2 == null) {
                    x.w("MicroMsg.AlbumAdapter", "removeHeader error, header is null");
                } else {
                    aVar.jBD.remove(aVar2);
                }
                this.jCa.setText(this.jCi);
            }
            this.jCb.jBz.clear();
            qz(this.jCb.jBA.size());
            this.jCb.notifyDataSetChanged();
            if (this.eHw != null) {
                this.eHw.dismiss();
            }
            getString(R.l.app_tip);
            this.eHw = h.a(this, getString(R.l.app_waiting), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            start = System.currentTimeMillis();
            String str = this.jCi;
            if (albumItem.jAR != null) {
                int type = albumItem.jAR.getType();
                x.i("MicroMsg.AlbumPreviewUI", "folder type[%d] queryType[%d]", new Object[]{Integer.valueOf(type), Integer.valueOf(c.aRf().aRJ())});
                if (c.aRf().aRJ() != 2 && albumItem.jAR.getType() == 2) {
                    str = "";
                }
                if (bi.oW(albumItem.jAQ)) {
                    type = 3;
                }
                this.jCA = System.currentTimeMillis();
                c.aRf().e(str, type, this.jCA);
            }
        }
    }

    public final void L(int i, boolean z) {
        boolean z2 = true;
        switch (c.aRf().aRJ()) {
            case 3:
                if (!bi.oW(this.bSS) && !"medianote".equals(this.toUser)) {
                    if (bi.VG() - this.jCx < 1000) {
                        x.w("MicroMsg.AlbumPreviewUI", "sendimg btn event frequence limit");
                        return;
                    }
                    x.i("MicroMsg.AlbumPreviewUI", "switch to SendImgProxyUI");
                    MediaItem mediaItem = (MediaItem) this.jCb.jBz.get(i);
                    if (mediaItem.getType() != 2) {
                        try {
                            com.tencent.mm.plugin.gallery.stub.a aVar = this.jBy;
                            String str = mediaItem.egA;
                            String str2 = this.toUser;
                            if (!this.jCl && this.jCp) {
                                z2 = false;
                            }
                            aVar.a(str, str2, z2, 0, z);
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected final void initView() {
        boolean z;
        for (String str : getIntent().getExtras().keySet()) {
            x.d("MicroMsg.AlbumPreviewUI", "key=%s | value=%s", new Object[]{str, getIntent().getExtras().get(str)});
        }
        this.bSS = getIntent().getStringExtra("GalleryUI_FromUser");
        this.toUser = getIntent().getStringExtra("GalleryUI_ToUser");
        this.jCs = getIntent().getIntExtra("max_select_count", 9);
        this.jCl = c.aRf().aRI() == 4;
        if (c.aRf().aRI() == 5) {
            z = true;
        } else {
            z = false;
        }
        this.jCn = z;
        if (c.aRf().aRI() == 9) {
            z = true;
        } else {
            z = false;
        }
        this.jCo = z;
        this.jCh = getIntent().getStringExtra("folder_path");
        this.jCi = getIntent().getStringExtra("folder_name");
        if (bi.oW(this.jCh)) {
            x.e("MicroMsg.AlbumPreviewUI", "get folder path failed");
            this.jCh = this.jCi;
        }
        this.jCp = getIntent().getBooleanExtra("key_send_raw_image", false);
        this.jCq = getIntent().getBooleanExtra("key_can_select_video_and_pic", false);
        this.jCf = (TextView) findViewById(R.h.orignal_image_tip);
        this.jCg = (ImageButton) findViewById(R.h.orignal_image);
        this.jCf.setOnClickListener(new 12(this));
        if (c.aRf().aRI() == 3) {
            this.jCg.setVisibility(0);
            this.jCf.setVisibility(0);
        } else {
            this.jCg.setVisibility(8);
            this.jCf.setVisibility(8);
        }
        if (this.jCp) {
            this.jCg.setImageResource(R.k.radio_on);
        } else {
            this.jCg.setImageResource(R.k.radio_off);
        }
        this.jCg.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AlbumPreviewUI.this.jCp = !AlbumPreviewUI.this.jCp;
                AlbumPreviewUI.e(AlbumPreviewUI.this);
                AlbumPreviewUI.this.jCf.setText(AlbumPreviewUI.this.mController.tml.getString(R.l.gallery_pic_orignal) + "");
                if (AlbumPreviewUI.this.jCp) {
                    AlbumPreviewUI.this.jCg.setImageResource(R.k.radio_on);
                } else {
                    AlbumPreviewUI.this.jCg.setImageResource(R.k.radio_off);
                }
                AlbumPreviewUI.g(AlbumPreviewUI.this);
            }
        });
        this.jCc = (TextView) findViewById(R.h.album_tips_bar);
        this.jCd = (TextView) findViewById(R.h.album_photo_edit_tips_bar);
        this.jBX = (TextView) findViewById(R.h.media_preview);
        if (c.aRf().aRI() == 0 || c.aRf().aRI() == 5 || c.aRf().aRI() == 10 || c.aRf().aRI() == 11) {
            findViewById(R.h.footer_line).setVisibility(8);
            this.jBX.setVisibility(8);
        } else {
            this.jBX.setVisibility(0);
            this.jBX.setOnClickListener(new 14(this));
            if ((c.aRf().aRJ() == 1 || c.aRf().aRJ() == 2 || c.aRf().aRJ() == 3) && this.jCs > 0) {
                15 15 = new 15(this);
                if (bi.oW(this.jCk)) {
                    a(0, qA(0), 15, s.b.tmX);
                } else {
                    addTextOptionMenu(0, this.jCk, 15);
                }
            }
        }
        this.jCe = (ImageFolderMgrView) findViewById(R.h.image_folder_mgr_view);
        ImageFolderMgrView imageFolderMgrView = this.jCe;
        c.aRf().b(imageFolderMgrView);
        c.aRf().a(imageFolderMgrView);
        c.aRf().aRK();
        this.jCe.setListener(new 16(this));
        this.jCk = getIntent().getStringExtra("send_btn_string");
        findViewById(R.h.media_folder).setOnClickListener(new 17(this));
        this.jCa = (TextView) findViewById(R.h.media_folder_tv);
        if (this.jCn) {
            showOptionMenu(false);
        }
        enableOptionMenu(false);
        this.jBW = (GridView) findViewById(R.h.media_in_folder_gv);
        this.jBW.setOnItemClickListener(new 2(this));
        this.jCb = new a(this, new a.b() {
            public final void J(int i, int i2, int i3) {
                if (i3 == 0) {
                    MediaItem qx = AlbumPreviewUI.this.jCb.getItem(AlbumPreviewUI.this.jCb.jBD.size() + i2);
                    if (qx != null && qx.getType() == 1) {
                        AlbumPreviewUI.a(AlbumPreviewUI.this, qx);
                    } else if (qx != null && qx.getType() == 2) {
                        if (AlbumPreviewUI.this.b(qx)) {
                            AlbumPreviewUI.this.qz(i);
                            AlbumPreviewUI.this.L(i2, true);
                        } else {
                            AlbumPreviewUI.this.jCb.jBA.remove(qx);
                            AlbumPreviewUI.this.jCb.notifyDataSetChanged();
                        }
                    }
                    AlbumPreviewUI.this.qz(i);
                    AlbumPreviewUI.this.L(i2, true);
                } else {
                    AlbumPreviewUI.this.qz(i);
                    AlbumPreviewUI.this.L(i2, false);
                }
                Iterator it = AlbumPreviewUI.this.jCb.aRN().iterator();
                while (it.hasNext()) {
                    if (!o.Wf((String) it.next())) {
                        return;
                    }
                }
                AlbumPreviewUI.this.jCp = true;
            }
        });
        if (this.jCl) {
            this.jCb.jBE = true;
        }
        if (this.jCq) {
            this.jCb.jBE = true;
        }
        this.jBW.setNumColumns(4);
        this.jBW.setOnScrollListener(new 4(this));
        if (getIntent().getBooleanExtra("show_header_view", true)) {
            this.jCb.a(this.jCB);
        }
        this.jCb.jBC = c.aRf().aRJ();
        this.jCb.jBx = this.jCs;
        x.i("MicroMsg.AlbumPreviewUI", "limit count = " + getIntent().getIntExtra("max_select_count", 9));
        this.jBW.setAdapter(this.jCb);
        updateTitle();
        setBackBtn(new 5(this));
        ViewGroup viewGroup = (ViewGroup) findViewById(R.h.root);
        if (viewGroup instanceof DrawedCallBackFrameLayout) {
            ((DrawedCallBackFrameLayout) viewGroup).setListener(new DrawedCallBackFrameLayout.a() {
                public final void aRL() {
                    try {
                        AlbumPreviewUI.this.jBy.aRL();
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
                    }
                    if (AlbumPreviewUI.this.jCu) {
                        try {
                            AlbumPreviewUI.this.unbindService(AlbumPreviewUI.this.hKe);
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e2, "Failed to unbindService when onViewDrawed is invoked.", new Object[0]);
                        }
                        AlbumPreviewUI.this.jCu = false;
                    }
                }
            });
        }
    }

    private void auu() {
        if (com.tencent.mm.pluginsdk.ui.tools.l.c(this.mController.tml, com.tencent.mm.compatible.util.e.dgl, "microMsg." + System.currentTimeMillis() + ".jpg", 4369)) {
            c.aRg().qs(0);
            System.gc();
            return;
        }
        Toast.makeText(this.mController.tml, getString(R.l.selectcameraapp_none), 1).show();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            x.i("MicroMsg.AlbumPreviewUI", "onKeyDown");
            setResult(-2);
            if (this.jCe.Ld) {
                this.jCe.aRT();
                return true;
            }
            finish();
            return true;
        } else if (i != 82) {
            return super.onKeyDown(i, keyEvent);
        } else {
            this.jCw++;
            this.jCe.aRT();
            return true;
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.AlbumPreviewUI", "on activity result, requestCode[%d] resultCode[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        ArrayList arrayList;
        if (4369 != i) {
            ArrayList stringArrayListExtra;
            if (4370 != i) {
                if (4371 != i) {
                    if (4372 != i) {
                        if (4373 != i) {
                            if (4375 != i) {
                                if (4376 != i) {
                                    switch (i2) {
                                        case -2:
                                            x.e("MicroMsg.AlbumPreviewUI", "WTF!!!");
                                            finish();
                                            break;
                                        case -1:
                                            if (intent == null) {
                                                intent = new Intent();
                                                intent.putExtra("CropImage_Compress_Img", true);
                                                intent.putStringArrayListExtra("CropImage_OutputPath_List", this.jCb.aRN());
                                            }
                                            x.i("MicroMsg.AlbumPreviewUI", "onActivity Result ok");
                                            this.jBZ = true;
                                            setResult(-1, intent);
                                            aRQ();
                                            finish();
                                            break;
                                        case 0:
                                            if (intent != null) {
                                                boolean z;
                                                stringArrayListExtra = intent.getStringArrayListExtra("preview_image_list");
                                                if (stringArrayListExtra != null) {
                                                    this.jCb.x(stringArrayListExtra);
                                                    this.jCb.notifyDataSetChanged();
                                                    qz(stringArrayListExtra.size());
                                                }
                                                if (intent.getBooleanExtra("CropImage_Compress_Img", true)) {
                                                    z = false;
                                                } else {
                                                    z = true;
                                                }
                                                this.jCp = z;
                                                if (!this.jCp) {
                                                    this.jCg.setImageResource(R.k.radio_off);
                                                    break;
                                                } else {
                                                    this.jCg.setImageResource(R.k.radio_on);
                                                    break;
                                                }
                                            }
                                            break;
                                    }
                                } else if (-1 != i2) {
                                    x.i("MicroMsg.AlbumPreviewUI", "REQUEST_SELECT_FOLDER goBack!");
                                    finish();
                                } else if (intent != null) {
                                    AlbumItem albumItem = (AlbumItem) intent.getParcelableExtra("select_folder_name");
                                    a(albumItem);
                                    setMMTitle(bi.aG(albumItem.jAQ, getString(R.l.gallery_all_pic_and_video)));
                                }
                            } else if (-1 == i2) {
                                if (intent == null) {
                                    intent = new Intent();
                                }
                                x.i("MicroMsg.AlbumPreviewUI", "sight capture record video, result[%s]", new Object[]{intent});
                                SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                                if (sightCaptureResult == null) {
                                    x.e("MicroMsg.AlbumPreviewUI", "sight capture result is null!");
                                    setResult(1);
                                    finish();
                                    return;
                                }
                                Serializable arrayList2 = new ArrayList();
                                String str = sightCaptureResult.lee;
                                if (!bi.oW(str)) {
                                    arrayList2.add(str);
                                    intent.putExtra("key_select_video_list", arrayList2);
                                }
                                if (sightCaptureResult.lec && !bi.oW(sightCaptureResult.lek)) {
                                    arrayList = new ArrayList();
                                    arrayList.add(sightCaptureResult.lek);
                                    intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList);
                                }
                                setResult(-1, intent);
                                finish();
                            } else {
                                return;
                            }
                        }
                        if (intent != null) {
                            intent.putExtra("GalleryUI_IsSendImgBackground", true);
                            x.e("MicroMsg.AlbumPreviewUI", "send img background, data is null!!");
                        }
                        x.i("MicroMsg.AlbumPreviewUI", "Request code sendimg proxy");
                        setResult(-1, intent);
                        this.jCu = true;
                        finish();
                    } else if (-1 == i2) {
                        if (intent == null) {
                            intent = new Intent();
                        }
                        x.i("MicroMsg.AlbumPreviewUI", "system record video, result[%s]", new Object[]{intent});
                        Serializable arrayList3 = new ArrayList();
                        String stringExtra = getIntent().getStringExtra("video_full_path");
                        if (!bi.oW(stringExtra)) {
                            arrayList3.add(stringExtra);
                            intent.putExtra("key_select_video_list", arrayList3);
                            intent.putExtra("key_selected_video_is_from_sys_camera", true);
                        }
                        setResult(-1, intent);
                        finish();
                    } else {
                        return;
                    }
                } else if (-1 == i2) {
                    if (intent != null) {
                        intent.putExtra("from_record", true);
                    }
                    x.i("MicroMsg.AlbumPreviewUI", "custom record video, result[%s]", new Object[]{intent});
                    setResult(-1, intent);
                    finish();
                } else {
                    return;
                }
            } else if (-1 != i2) {
                return;
            } else {
                if (intent.getBooleanExtra("GalleryUI_IsSendImgBackground", false)) {
                    x.i("MicroMsg.AlbumPreviewUI", "test onActivityResult");
                    setResult(-1, intent);
                    finish();
                    return;
                }
                stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                if (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) {
                    x.w("MicroMsg.AlbumPreviewUI", "send filepath is null or nil");
                    return;
                }
                x.i("MicroMsg.AlbumPreviewUI", "gallery photo:%s", new Object[]{stringArrayListExtra});
                setResult(-1, intent);
                finish();
            }
        } else if (-1 == i2) {
            String d = com.tencent.mm.pluginsdk.ui.tools.l.d(this.mController.tml.getApplicationContext(), intent, com.tencent.mm.compatible.util.e.dgl);
            if (bi.oW(d)) {
                x.w("MicroMsg.AlbumPreviewUI", "take photo, but result is null");
                return;
            }
            x.i("MicroMsg.AlbumPreviewUI", "take photo, result[%s]", new Object[]{d});
            if (c.aRf().aRI() == 0 || c.aRf().aRI() == 5 || c.aRf().aRI() == 11) {
                Intent intent2 = new Intent();
                intent2.setData(Uri.parse("file://" + Uri.encode(d)));
                x.i("MicroMsg.AlbumPreviewUI", "take photo finish");
                setResult(-1, intent2);
                finish();
            } else {
                arrayList = new ArrayList(1);
                arrayList.add(d);
                Intent intent3 = new Intent(this, ImagePreviewUI.class);
                intent3.putExtra("isTakePhoto", true);
                intent3.putExtra("max_select_count", 1);
                intent3.putExtra("send_raw_img", this.jCp);
                intent3.putStringArrayListExtra("preview_image_list", arrayList);
                intent3.putExtra("GalleryUI_FromUser", this.bSS);
                intent3.putExtra("GalleryUI_ToUser", this.toUser);
                startActivityForResult(intent3, 4370);
            }
        } else {
            return;
        }
        if (intent != null && intent.getBooleanExtra("show_photo_edit_tip", false)) {
            SharedPreferences sharedPreferences = getSharedPreferences("photo_edit_pref", 0);
            if (!sharedPreferences.getBoolean("has_show_tip", false)) {
                this.jCd.setVisibility(0);
                this.jCd.setText(getString(R.l.photo_edit_tips));
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mController.tml, R.a.fast_faded_in);
                this.jCd.startAnimation(loadAnimation);
                loadAnimation.setAnimationListener(new 8(this));
                sharedPreferences.edit().putBoolean("has_show_tip", true).commit();
            }
        }
    }

    private void qz(int i) {
        if (i == 0) {
            this.jBX.setEnabled(false);
            enableOptionMenu(false);
        } else {
            this.jBX.setEnabled(true);
            enableOptionMenu(true);
        }
        if (i == 0) {
            this.jBX.setText(R.l.gallery_pic_preview);
        } else {
            this.jBX.setText(getString(R.l.gallery_pic_preview) + "(" + i + ")");
        }
        updateOptionMenuText(0, qA(i));
    }

    private String qA(int i) {
        switch (c.aRf().aRI()) {
            case 4:
            case 7:
            case 8:
            case 13:
                if (i == 0 || this.jCs <= 1) {
                    return getString(R.l.gallery_pic_timeline_send);
                }
                return getString(R.l.gallery_pic_timeline_send) + "(" + i + "/" + this.jCs + ")";
            default:
                if (i == 0 || this.jCs <= 1) {
                    return getString(R.l.app_send);
                }
                return getString(R.l.gallery_pic_chatting_send, new Object[]{Integer.valueOf(i), Integer.valueOf(this.jCs)});
        }
    }

    public final void a(ArrayList<MediaItem> arrayList, long j) {
        if (j != this.jCA) {
            x.w("MicroMsg.AlbumPreviewUI", "%s %s, not my query, ignore.", new Object[]{Long.valueOf(j), Long.valueOf(this.jCA)});
            x.w("MicroMsg.AlbumPreviewUI", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add((MediaItem) it.next());
            }
        }
        if (this.jCb != null) {
            a aVar = new a((byte) 0);
            aVar.jCL = new WeakReference(this.jCb);
            aVar.jCM = new WeakReference(this.eHw);
            aVar.jCN = arrayList2;
            c.aRg().A(aVar);
        }
    }

    private void aRQ() {
        if (this.jCC) {
            SharedPreferences sharedPreferences = getSharedPreferences("gallery_last_choose_album", 0);
            x.i("MicroMsg.AlbumPreviewUI", "last selected folderName and path: " + this.jCi + ", " + this.jCh);
            sharedPreferences.edit().putString(c.aRf().aRJ(), this.jCi + "|" + this.jCh + "|" + this.jCj).commit();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.AlbumPreviewUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    auu();
                    return;
                } else {
                    h.a(this, getString(R.l.permission_camera_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new 9(this), null);
                    return;
                }
            default:
                return;
        }
    }

    private boolean b(MediaItem mediaItem) {
        if (mediaItem == null) {
            x.e("MicroMsg.AlbumPreviewUI", "[checkSelectedVideo] item is null!");
            return false;
        } else if (this.jBy == null) {
            x.e("MicroMsg.AlbumPreviewUI", "[checkSelectedVideo] invoker is null!");
            return false;
        } else if (c.aRf().aRI() != 3) {
            return true;
        } else {
            if (new File(mediaItem.egA).exists()) {
                try {
                    if (this.jBy.CV(mediaItem.egA) > 300) {
                        h.bz(this, getString(R.l.gallery_select_video_to_long));
                        return false;
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
                }
                return true;
            }
            h.bz(this, getString(R.l.gallery_select_video_not_exit));
            return false;
        }
    }
}
