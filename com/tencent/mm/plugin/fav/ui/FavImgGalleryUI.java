package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.cb;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.ui.m.f;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class FavImgGalleryUI extends MMActivity implements OnItemSelectedListener, p {
    private boolean bUY = true;
    private k gcQ;
    private ArrayList<f> gvR;
    private MMGestureGallery hDd;
    private int iYO = 0;
    private a iYP;
    private Map<String, mu> iYQ = new HashMap();
    private long iYR;
    private c iYS = new 2(this);
    private d ioF = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            f pN = FavImgGalleryUI.this.iYP.getItem(FavImgGalleryUI.this.iYO);
            if (pN != null) {
                String b = com.tencent.mm.plugin.fav.a.b.b(pN.bOz);
                if (e.cn(b)) {
                    switch (menuItem.getItemId()) {
                        case 0:
                            h.f(FavImgGalleryUI.this.iYR, 1, 0);
                            if (o.Wf(b)) {
                                Intent intent = new Intent();
                                intent.putExtra("Select_Conv_Type", 3);
                                intent.putExtra("select_is_ret", true);
                                com.tencent.mm.bg.d.b(FavImgGalleryUI.this, ".ui.transmit.SelectConversationUI", intent, 1);
                                return;
                            }
                            com.tencent.mm.plugin.fav.a.b.c(b, FavImgGalleryUI.this);
                            return;
                        case 1:
                            com.tencent.mm.plugin.fav.a.b.d(b, FavImgGalleryUI.this);
                            h.f(FavImgGalleryUI.this.iYR, 0, 0);
                            return;
                        case 2:
                            FavImgGalleryUI.a(b, FavImgGalleryUI.this.getString(i.favorite_save_fail), FavImgGalleryUI.this);
                            return;
                        case 3:
                            mu muVar = (mu) FavImgGalleryUI.this.iYQ.get(b);
                            if (muVar != null) {
                                cb cbVar = new cb();
                                cbVar.bJq.activity = FavImgGalleryUI.this;
                                cbVar.bJq.bHL = muVar.bXK.result;
                                cbVar.bJq.bJr = muVar.bXK.bJr;
                                cbVar.bJq.bJt = 7;
                                if (!(pN == null || pN.bOz == null)) {
                                    cbVar.bJq.imagePath = pN.bOz.rzo;
                                    cbVar.bJq.bJw = pN.bOz.rzq;
                                }
                                cbVar.bJq.bJs = muVar.bXK.bJs;
                                Bundle bundle = new Bundle(1);
                                bundle.putInt("stat_scene", 5);
                                cbVar.bJq.bJx = bundle;
                                com.tencent.mm.sdk.b.a.sFg.m(cbVar);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
                x.w("MicroMsg.FavImgGalleryUI", "file not exists");
            }
        }
    };

    private class a extends BaseAdapter {
        SparseBooleanArray iYW;

        private a() {
            this.iYW = new SparseBooleanArray();
        }

        /* synthetic */ a(FavImgGalleryUI favImgGalleryUI, byte b) {
            this();
        }

        public final int getCount() {
            return FavImgGalleryUI.this.gvR.size();
        }

        /* renamed from: pN */
        public final f getItem(int i) {
            if (i < FavImgGalleryUI.this.gvR.size()) {
                return (f) FavImgGalleryUI.this.gvR.get(i);
            }
            x.w("MicroMsg.FavImgGalleryUI", "get item fail, position %d error", new Object[]{Integer.valueOf(i)});
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                bVar = new b(FavImgGalleryUI.this, (byte) 0);
                view = View.inflate(FavImgGalleryUI.this.mController.tml, f.fav_img_detail_item, null);
                bVar.iYX = view.findViewById(m.e.image_gallery_download_success);
                bVar.iYY = (MultiTouchImageView) view.findViewById(m.e.image);
                bVar.eVR = (ProgressBar) view.findViewById(m.e.downloading_pb);
                bVar.iYZ = (ImageView) view.findViewById(m.e.thumb_iv);
                bVar.iZa = (TextView) view.findViewById(m.e.downloading_percent_tv);
                bVar.iZb = (LinearLayout) view.findViewById(m.e.fav_expired_btn);
                bVar.iZc = (TextView) view.findViewById(m.e.fav_expired_btn_text);
                bVar.iZc.setText(i.favorite_detail_illegal_expired_image);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            view.setLayoutParams(new LayoutParams(-1, -1));
            f pN = getItem(i);
            boolean z = this.iYW.get(i, true);
            this.iYW.put(i, false);
            Bitmap a = k.a(pN.bOz, pN.iYN, z);
            if (pN.iYN != null) {
                x.i("MicroMsg.FavImgGalleryUI", "index %d item favid %d, localid %d, itemStatus %d", new Object[]{Integer.valueOf(i), Integer.valueOf(pN.iYN.field_id), Long.valueOf(pN.iYN.field_localId), Integer.valueOf(pN.iYN.field_itemStatus)});
            }
            if (pN.bOz != null) {
                x.i("MicroMsg.FavImgGalleryUI", "item dataId %s, item data url %s, key %s, fullsize %d, thumb url %s, key %s, thumb size %d", new Object[]{pN.bOz.jdM, pN.bOz.rzo, pN.bOz.rzq, Long.valueOf(pN.bOz.rzJ), pN.bOz.dwE, pN.bOz.rzk, Long.valueOf(pN.bOz.rzU)});
            }
            if (a == null) {
                FavImgGalleryUI.this.enableOptionMenu(false);
                x.w("MicroMsg.FavImgGalleryUI", "get big image fail");
                com.tencent.mm.plugin.fav.a.c Br = ((ae) g.n(ae.class)).getFavCdnStorage().Br(pN.bOz != null ? pN.bOz.jdM : "");
                if (Br == null) {
                    bVar.iZb.setVisibility(8);
                    if (pN.iYN == null || pN.iYN.field_id >= 0) {
                        bVar.eVR.setVisibility(8);
                        bVar.iZa.setVisibility(8);
                        bVar.iYZ.setVisibility(8);
                        bVar.iYX.setVisibility(0);
                        if (pN.bOz.rAw != 0) {
                            bVar.iZb.setVisibility(0);
                        }
                        b(bVar, a(pN), "");
                    } else {
                        bVar.eVR.setVisibility(0);
                        bVar.iZa.setVisibility(0);
                        bVar.iYZ.setVisibility(0);
                        bVar.iYX.setVisibility(8);
                        bVar.iYZ.setImageBitmap(a(pN));
                        bVar.eVR.setProgress(0);
                        bVar.iZa.setText("0%");
                    }
                } else {
                    x.i("MicroMsg.FavImgGalleryUI", "fav cdnInfo status %d", new Object[]{Integer.valueOf(Br.field_status)});
                    bVar.eVR.setVisibility(0);
                    bVar.iZa.setVisibility(0);
                    bVar.iYZ.setVisibility(0);
                    bVar.iYX.setVisibility(8);
                    bVar.iYZ.setImageBitmap(a(pN));
                    int i2 = Br.field_totalLen > 0 ? ((Br.field_offset * 100) / Br.field_totalLen) - 1 : 0;
                    if (i2 < 0) {
                        i2 = 0;
                    }
                    bVar.eVR.setProgress(i2);
                    bVar.iZa.setText(i2 + "%");
                }
            } else {
                FavImgGalleryUI.this.enableOptionMenu(true);
                if (o.Wf(com.tencent.mm.plugin.fav.a.b.b(pN.bOz))) {
                    a(bVar, a, com.tencent.mm.plugin.fav.a.b.b(pN.bOz));
                } else {
                    a(bVar, a, "");
                }
            }
            return view;
        }

        private void a(b bVar, Bitmap bitmap, String str) {
            bVar.eVR.setVisibility(8);
            bVar.iZa.setVisibility(8);
            bVar.iYZ.setVisibility(8);
            bVar.iYX.setVisibility(0);
            bVar.iZb.setVisibility(8);
            b(bVar, bitmap, str);
        }

        private Bitmap a(f fVar) {
            if (fVar != null) {
                Bitmap a = k.a(fVar.bOz, fVar.iYN);
                if (a != null) {
                    return a;
                }
            }
            return com.tencent.mm.compatible.g.a.decodeResource(FavImgGalleryUI.this.getResources(), m.h.download_image_icon);
        }

        private void b(b bVar, Bitmap bitmap, String str) {
            com.tencent.mm.sdk.platformtools.k.k(bVar.iYY, bitmap.getWidth(), bitmap.getHeight());
            int width = bVar.iYY.getWidth();
            int height = bVar.iYY.getHeight();
            Matrix matrix = new Matrix();
            matrix.reset();
            float width2 = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
            float height2 = ((float) bitmap.getHeight()) / ((float) bitmap.getWidth());
            x.v("MicroMsg.FavImgGalleryUI", "whDiv is " + width2 + " hwDiv is " + height2);
            if (height2 >= 2.0f && bitmap.getHeight() >= 480) {
                height2 = ((float) width) / ((float) bitmap.getWidth());
                if (((double) (((float) bitmap.getWidth()) / ((float) width))) > 1.0d) {
                    matrix.postScale(height2, height2);
                    bitmap.getHeight();
                    matrix.postTranslate((((float) width) - (height2 * ((float) bitmap.getWidth()))) / 2.0f, 0.0f);
                } else {
                    matrix.postScale(1.0f, 1.0f);
                    matrix.postTranslate((float) ((width - bitmap.getWidth()) / 2), 0.0f);
                }
            } else if (width2 < 2.0f || bitmap.getWidth() < 480) {
                width2 = ((float) width) / ((float) bitmap.getWidth());
                height2 = ((float) height) / ((float) bitmap.getHeight());
                if (width2 >= height2) {
                    width2 = height2;
                }
                height2 = ((float) bitmap.getWidth()) / ((float) width);
                float height3 = ((float) bitmap.getHeight()) / ((float) height);
                if (height2 <= height3) {
                    height2 = height3;
                }
                if (((double) height2) > 1.0d) {
                    matrix.postScale(width2, width2);
                } else {
                    width2 = 1.0f;
                }
                matrix.postTranslate((((float) width) - (((float) bitmap.getWidth()) * width2)) / 2.0f, (((float) height) - (width2 * ((float) bitmap.getHeight()))) / 2.0f);
            } else {
                width2 = ((float) bitmap.getHeight()) / 480.0f;
                height2 = 480.0f / ((float) bitmap.getHeight());
                if (((double) width2) > 1.0d) {
                    matrix.postScale(width2, height2);
                    matrix.postTranslate(0.0f, (float) ((height - 480) / 2));
                } else {
                    matrix.postScale(1.0f, 1.0f);
                    width2 = (float) ((height - bitmap.getHeight()) / 2);
                    x.d("MicroMsg.FavImgGalleryUI", " offsety " + width2);
                    matrix.postTranslate(0.0f, width2);
                }
            }
            bVar.iYY.setImageMatrix(matrix);
            bVar.iYY.eT(bitmap.getWidth(), bitmap.getHeight());
            bVar.iYY.setMaxZoomDoubleTab(true);
            if (bi.oW(str)) {
                bVar.iYY.setImageBitmap(bitmap);
                return;
            }
            try {
                com.tencent.mm.plugin.gif.c cVar = new com.tencent.mm.plugin.gif.c(str);
                bVar.iYY.setGifDrawable(cVar);
                MultiTouchImageView multiTouchImageView = bVar.iYY;
                int fk = com.tencent.mm.bp.a.fk(FavImgGalleryUI.this.mController.tml);
                multiTouchImageView.iGo = com.tencent.mm.bp.a.fl(FavImgGalleryUI.this.mController.tml);
                multiTouchImageView.iGn = fk;
                bVar.iYY.eT(cVar.getIntrinsicWidth(), cVar.getIntrinsicHeight());
                MultiTouchImageView multiTouchImageView2 = bVar.iYY;
                if (multiTouchImageView2.tzG && multiTouchImageView2.tzH != null) {
                    ((com.tencent.mm.ui.e.b.a) multiTouchImageView2.tzH).start();
                }
                bVar.iYY.csa();
            } catch (Throwable e) {
                x.e("MicroMsg.FavImgGalleryUI", bi.i(e));
                bVar.iYY.setImageBitmap(bitmap);
            }
        }
    }

    private class b {
        ProgressBar eVR;
        View iYX;
        MultiTouchImageView iYY;
        ImageView iYZ;
        TextView iZa;
        LinearLayout iZb;
        TextView iZc;

        private b() {
        }

        /* synthetic */ b(FavImgGalleryUI favImgGalleryUI, byte b) {
            this();
        }
    }

    static /* synthetic */ void a(FavImgGalleryUI favImgGalleryUI) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        f pN = favImgGalleryUI.iYP.getItem(favImgGalleryUI.iYO);
        if (pN != null && pN.bOz.rAw == 0) {
            if (pN.iYN != null && pN.iYN.aLd()) {
                arrayList.add(Integer.valueOf(0));
                arrayList2.add(favImgGalleryUI.getString(i.favorite_share_with_friend));
            }
            if (pN.iYN != null && pN.iYN.aLe()) {
                arrayList.add(Integer.valueOf(1));
                arrayList2.add(favImgGalleryUI.getString(i.favorite_post_to_sns));
            }
            arrayList.add(Integer.valueOf(2));
            arrayList2.add(favImgGalleryUI.getString(i.favorite_save_image));
            String b = com.tencent.mm.plugin.fav.a.b.b(pN.bOz);
            mu muVar = (mu) favImgGalleryUI.iYQ.get(b);
            if (muVar == null) {
                ms msVar = new ms();
                msVar.bXH.filePath = b;
                com.tencent.mm.sdk.b.a.sFg.m(msVar);
            } else if (!bi.oW(muVar.bXK.result)) {
                arrayList.add(Integer.valueOf(3));
                arrayList2.add(favImgGalleryUI.getString(com.tencent.mm.plugin.scanner.a.aB(muVar.bXK.bJr, muVar.bXK.result) ? i.favorite_reconize_image_wxcode : i.favorite_reconize_image_qrcode));
            }
            if (favImgGalleryUI.gcQ == null) {
                favImgGalleryUI.gcQ = new k(favImgGalleryUI.mController.tml);
            }
            favImgGalleryUI.gcQ.ofp = new 5(favImgGalleryUI, arrayList, arrayList2);
            favImgGalleryUI.gcQ.ofq = favImgGalleryUI.ioF;
            favImgGalleryUI.gcQ.d(new 6(favImgGalleryUI));
            com.tencent.mm.ui.base.h.a(favImgGalleryUI.mController.tml, favImgGalleryUI.gcQ.bEo());
        }
    }

    protected final int getLayoutId() {
        return f.fav_img_gallery_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(1024, 1024);
        }
        this.bUY = getIntent().getBooleanExtra("show_share", true);
        this.hDd = (MMGestureGallery) findViewById(m.e.gallery);
        this.hDd.setVerticalFadingEdgeEnabled(false);
        this.hDd.setHorizontalFadingEdgeEnabled(false);
        this.hDd.setOnItemSelectedListener(this);
        this.hDd.setSingleClickOverListener(new 1(this));
        if (this.bUY) {
            this.hDd.setLongClickOverListener(new MMGestureGallery.c() {
                public final void aMl() {
                    if (!FavImgGalleryUI.this.isFinishing() && !FavImgGalleryUI.this.tlP) {
                        FavImgGalleryUI.a(FavImgGalleryUI.this);
                    }
                }
            });
        }
        fullScreenNoTitleBar(true);
        this.gvR = new ArrayList();
        this.iYP = new a(this, (byte) 0);
        this.hDd.setAdapter(this.iYP);
        aMk();
        setBackBtn(new 4(this));
        com.tencent.mm.sdk.b.a.sFg.b(this.iYS);
        setResult(0, getIntent());
    }

    public static void a(String str, String str2, Context context) {
        if (bi.oW(str)) {
            x.w("MicroMsg.FavImgGalleryUI", "save image fail, path is null");
        } else if (!r.a(str, context, i.cropimage_saved)) {
            Toast.makeText(context, str2, 1).show();
        }
    }

    private void aMk() {
        com.tencent.mm.plugin.fav.a.g gVar;
        Object gVar2;
        this.iYR = getIntent().getLongExtra("key_detail_info_id", -1);
        String stringExtra = getIntent().getStringExtra("key_detail_data_id");
        boolean booleanExtra = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
        String stringExtra2 = getIntent().getStringExtra("fav_note_xml");
        List arrayList = new ArrayList();
        com.tencent.mm.plugin.fav.a.g dy = ((ae) g.n(ae.class)).getFavItemInfoStorage().dy(this.iYR);
        String str = "MicroMsg.FavImgGalleryUI";
        String str2 = "show one fav info, local id is %d, get from db ok ? %B";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(this.iYR);
        objArr[1] = Boolean.valueOf(dy != null);
        x.i(str, str2, objArr);
        if (!booleanExtra || bi.oW(stringExtra2)) {
            gVar2 = dy;
        } else {
            gVar2 = com.tencent.mm.plugin.fav.a.b.Bf(stringExtra2);
        }
        if (gVar2 != null) {
            arrayList.add(gVar2);
        }
        this.gvR.clear();
        int i = -1;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            gVar2 = (com.tencent.mm.plugin.fav.a.g) arrayList.get(i2);
            int size2 = gVar2.field_favProto.rBI.size();
            int i3 = 0;
            while (i3 < size2) {
                int size3;
                vx vxVar = (vx) gVar2.field_favProto.rBI.get(i3);
                if ((vxVar.bjS != 8 || o.Wf(com.tencent.mm.plugin.fav.a.b.b(vxVar))) && (vxVar.bjS == 2 || vxVar.bjS == 8)) {
                    this.gvR.add(new f(gVar2, vxVar));
                    if (stringExtra != null && stringExtra.equals(vxVar.jdM)) {
                        size3 = this.gvR.size() - 1;
                        i3++;
                        i = size3;
                    }
                }
                size3 = i;
                i3++;
                i = size3;
            }
            if (stringExtra == null && gVar2.field_localId == this.iYR) {
                i = this.gvR.size() - 1;
            }
        }
        getIntent().removeExtra("key_detail_info_id");
        getIntent().removeExtra("key_detail_data_id");
        this.iYP.notifyDataSetChanged();
        this.hDd.post(new 8(this, i));
    }

    protected void onDestroy() {
        getIntent().putExtra("key_activity_browse_time", cql());
        com.tencent.mm.sdk.b.a.sFg.c(this.iYS);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        ((ae) g.n(ae.class)).getFavCdnStorage().a(this);
        m.Bk(1);
    }

    protected void onPause() {
        super.onPause();
        ((ae) g.n(ae.class)).getFavCdnStorage().b(this);
        m.Bk(2);
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.iYO = i;
        x.d("MicroMsg.FavImgGalleryUI", "pos:" + i);
        if (view instanceof MultiTouchImageView) {
            ((MultiTouchImageView) view).crm();
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public final void d(final com.tencent.mm.plugin.fav.a.c cVar) {
        if (cVar != null) {
            x.v("MicroMsg.FavImgGalleryUI", "on cdn status changed, status:%d", new Object[]{Integer.valueOf(cVar.field_status)});
            f pN = this.iYP.getItem(this.iYO);
            if (pN != null && bi.aG(cVar.field_dataId, "").equals(pN.bOz.jdM)) {
                ah.A(new Runnable() {
                    public final void run() {
                        int i = 0;
                        View selectedView = FavImgGalleryUI.this.hDd.getSelectedView();
                        if (selectedView != null) {
                            b bVar = (b) selectedView.getTag();
                            int i2 = cVar.field_totalLen > 0 ? ((cVar.field_offset * 100) / cVar.field_totalLen) - 1 : 0;
                            if (i2 >= 0) {
                                i = i2;
                            }
                            bVar.eVR.setProgress(i);
                            bVar.iZa.setText(i + "%");
                            if (i >= 100 || cVar.isFinished()) {
                                FavImgGalleryUI.this.iYP.notifyDataSetChanged();
                            }
                        }
                    }
                });
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (1 == i) {
            if (-1 == i2) {
                f pN = this.iYP.getItem(this.iYO);
                if (pN == null) {
                    x.i("MicroMsg.FavImgGalleryUI", "dataItem is null.");
                    return;
                }
                com.tencent.mm.plugin.fav.a.k kVar = new com.tencent.mm.plugin.fav.a.k();
                if (com.tencent.mm.plugin.fav.a.k.u(pN.iYN)) {
                    com.tencent.mm.ui.base.h.bA(this.mController.tml, getString(i.Fav_NotDownload_CannotForward));
                    return;
                }
                x.d("MicroMsg.FavImgGalleryUI", "select %s for sending", new Object[]{intent.getStringExtra("Select_Conv_User")});
                h.a(this.mController.tml, r1, pN.iYN, pN.bOz, new 10(this, com.tencent.mm.ui.base.h.a(this.mController.tml, getString(i.favorite_forward_tips), false, null)));
            } else {
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
