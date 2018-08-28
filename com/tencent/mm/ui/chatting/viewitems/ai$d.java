package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.s$a;
import com.tencent.mm.modelvideo.s$a.b;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.viewitems.ai.e;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class ai$d extends a {
    private static Map<String, WeakReference<ai$d>> ubi = new HashMap();
    private static SparseArray<String> ueB = new SparseArray();
    TextView mfT;
    ImageView nEI;
    ImageView tZR;
    ImageView tZS;
    TextView tZU;
    ImageView uai;
    ImageView ube;
    ImageView udn;
    View ueA;
    TextView uew;
    MMPinProgressBtn uex;
    View uey;
    ProgressBar uez;

    public static boolean b(s$a.a aVar) {
        if (aVar.eoc != b.eoh) {
            return false;
        }
        r nW = t.nW(aVar.fileName);
        if (nW == null) {
            x.w("MicroMsg.VideoItemHoder", "update status, filename %s, videoInfo not found", new Object[]{aVar.fileName});
            return false;
        } else if (nW.status != 112 && nW.status != 104 && nW.status != 103) {
            return false;
        } else {
            ah.A(new 1(nW));
            return true;
        }
    }

    public final a q(View view, boolean z) {
        ImageView imageView;
        ProgressBar progressBar;
        View view2 = null;
        super.dx(view);
        this.hrs = (TextView) view.findViewById(R.h.chatting_time_tv);
        this.ube = (ImageView) view.findViewById(R.h.chatting_content_iv);
        this.mQc = (TextView) view.findViewById(R.h.chatting_user_tv);
        this.mfT = (TextView) view.findViewById(R.h.chatting_size_iv);
        this.uew = (TextView) view.findViewById(R.h.chatting_length_iv);
        this.nEI = (ImageView) view.findViewById(R.h.chatting_status_btn);
        this.tZR = (ImageView) view.findViewById(R.h.chatting_continue_btn);
        this.tZS = (ImageView) view.findViewById(R.h.chatting_stop_btn);
        this.uex = (MMPinProgressBtn) view.findViewById(R.h.chatting_download_progress);
        this.uey = view.findViewById(R.h.chatting_video_data_area);
        this.hrH = view.findViewById(R.h.chatting_click_area);
        this.tZU = (TextView) view.findViewById(R.h.chatting_appmsg_comment_tv);
        this.jBR = (CheckBox) view.findViewById(R.h.chatting_checkbox);
        this.gFD = view.findViewById(R.h.chatting_maskview);
        this.udn = (ImageView) view.findViewById(R.h.chatting_content_mask_iv);
        if (z) {
            imageView = null;
        } else {
            imageView = (ImageView) view.findViewById(R.h.chatting_status_tick);
        }
        this.uai = imageView;
        if (z) {
            progressBar = null;
        } else {
            progressBar = (ProgressBar) view.findViewById(R.h.chatting_video_pb);
        }
        this.uez = progressBar;
        if (!z) {
            view2 = view.findViewById(R.h.uploading_view);
        }
        this.ueA = view2;
        return this;
    }

    public static void a(ai$d ai_d, bd bdVar, boolean z, int i, com.tencent.mm.ui.chatting.c.a aVar, int i2, OnClickListener onClickListener, OnLongClickListener onLongClickListener) {
        int fromDPToPix;
        String str = (String) ueB.get(ai_d.hashCode());
        if (str != null) {
            ubi.remove(str);
        }
        ueB.put(ai_d.hashCode(), bdVar.field_imgPath);
        ubi.put(bdVar.field_imgPath, new WeakReference(ai_d));
        r nW = t.nW(bdVar.field_imgPath);
        if (nW == null) {
            nW = new r();
        }
        o.Ta();
        Bitmap a = com.tencent.mm.ak.o.Pf().a(s.nL(bdVar.field_imgPath), com.tencent.mm.bp.a.getDensity(aVar.tTq.getContext()), aVar.tTq.getContext(), i2);
        ai_d.udn.setLayoutParams(new LayoutParams(0, 0));
        if (a == null) {
            fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(aVar.tTq.getContext(), 85);
            int ad = com.tencent.mm.bp.a.ad(aVar.tTq.getContext(), R.f.ChatImgLimitWidth);
            Bitmap a2 = c.a(c.ah(aVar.tTq.getContext().getResources().getColor(R.e.grey_color_01), fromDPToPix, ad), i2, fromDPToPix, ad);
            au.HU();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                ai_d.ube.setImageBitmap(c.a(a2, i2, fromDPToPix, ad));
            } else {
                ai_d.ube.setImageDrawable(com.tencent.mm.bp.a.f(aVar.tTq.getContext(), R.k.video_no_sd_icon));
                ai_d.ube.setBackground(new BitmapDrawable(a2));
            }
            ViewGroup.LayoutParams layoutParams = new LayoutParams(fromDPToPix, ad);
            ai_d.udn.setLayoutParams(layoutParams);
            if (ai_d.ueA != null) {
                ai_d.ueA.setLayoutParams(layoutParams);
            }
        } else {
            ai_d.ube.setImageBitmap(a);
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(a.getWidth(), a.getHeight());
            ai_d.udn.setLayoutParams(layoutParams2);
            if (ai_d.ueA != null) {
                ai_d.ueA.setLayoutParams(layoutParams2);
            }
        }
        if (z) {
            ai_d.mfT.setText(ai.bF((long) nW.dHI));
            ai_d.uew.setText(ai.iR(nW.enM));
            fromDPToPix = nW.status;
            x.i("MicroMsg.VideoItemHoder", "parseVideo from video status : " + fromDPToPix + " info : " + nW.getFileName());
            if (fromDPToPix == 199) {
                ai_d.nEI.setImageDrawable(com.tencent.mm.bp.a.f(aVar.tTq.getContext(), R.k.shortvideo_play_btn));
            } else {
                ai_d.nEI.setImageDrawable(com.tencent.mm.bp.a.f(aVar.tTq.getContext(), R.k.shortvideo_play_btn));
                ai_d.mfT.setVisibility(8);
            }
            if (fromDPToPix == 112 || fromDPToPix == 122 || fromDPToPix == 120) {
                ai_d.tZR.setVisibility(8);
                ai_d.nEI.setVisibility(8);
                ai_d.uex.setVisibility(0);
                ai_d.uex.setProgress(t.f(nW));
                x.v("MicroMsg.VideoItemHoder", "status begin");
                ai_d.uex.invalidate();
            } else if (fromDPToPix == 113 || fromDPToPix == bh.CTRL_INDEX || nW.Tn()) {
                ai_d.tZR.setVisibility(0);
                ai_d.tZS.setVisibility(8);
                ai_d.uex.setVisibility(8);
                ai_d.nEI.setVisibility(0);
                x.v("MicroMsg.VideoItemHoder", "status pause");
            } else {
                ai_d.tZS.setVisibility(8);
                ai_d.tZR.setVisibility(8);
                ai_d.uex.setVisibility(8);
                ai_d.nEI.setVisibility(0);
                x.v("MicroMsg.VideoItemHoder", "status gone");
            }
        } else {
            ai_d.mfT.setText(ai.bF((long) nW.dHI));
            ai_d.uew.setText(ai.iR(nW.enM));
            fromDPToPix = nW.status;
            ai_d.nEI.setImageDrawable(com.tencent.mm.bp.a.f(aVar.tTq.getContext(), R.k.shortvideo_play_btn));
            if (ai_d.uez != null) {
                ai_d.uez.setVisibility(8);
            }
            if (ai_d.ueA != null) {
                ai_d.ueA.setVisibility(8);
            }
            x.v("MicroMsg.VideoItemHoder", "video status %d", new Object[]{Integer.valueOf(fromDPToPix)});
            if (fromDPToPix == 104 || fromDPToPix == 103) {
                if (com.tencent.mm.plugin.mmsight.c.sK(nW.enN)) {
                    if (ai_d.uez != null) {
                        ai_d.uez.setVisibility(0);
                    }
                    if (ai_d.ueA != null) {
                        ai_d.ueA.setVisibility(0);
                    }
                    ai_d.uew.setText(null);
                    ai_d.mfT.setText(null);
                    ai_d.nEI.setImageDrawable(null);
                    ai_d.tZS.setVisibility(8);
                    ai_d.tZR.setVisibility(8);
                    ai_d.uex.setVisibility(8);
                } else {
                    if (ai_d.uez != null) {
                        ai_d.uez.setVisibility(8);
                    }
                    if (ai_d.ueA != null) {
                        ai_d.ueA.setVisibility(8);
                    }
                    ai_d.tZR.setVisibility(8);
                    ai_d.nEI.setVisibility(8);
                    ai_d.uex.setVisibility(0);
                    ai_d.uex.setProgress(t.g(nW));
                }
                x.v("MicroMsg.VideoItemHoder", "status begin");
            } else if (fromDPToPix == 105 || fromDPToPix == bh.CTRL_INDEX || nW.Tn()) {
                ai_d.tZR.setVisibility(0);
                ai_d.tZS.setVisibility(8);
                ai_d.uex.setVisibility(8);
                ai_d.nEI.setVisibility(0);
                x.v("MicroMsg.VideoItemHoder", "status pause");
            } else if (fromDPToPix != f$k.AppCompatTheme_ratingBarStyle) {
                ai_d.tZS.setVisibility(8);
                ai_d.tZR.setVisibility(8);
                ai_d.uex.setVisibility(8);
                ai_d.nEI.setVisibility(0);
                x.v("MicroMsg.VideoItemHoder", "status gone");
            } else if (j.SN(bdVar.field_imgPath)) {
                if (ai_d.uez != null) {
                    ai_d.uez.setVisibility(0);
                }
                if (ai_d.ueA != null) {
                    ai_d.ueA.setVisibility(0);
                }
                ai_d.uew.setText(null);
                ai_d.mfT.setText(null);
                ai_d.nEI.setImageDrawable(null);
                ai_d.tZS.setVisibility(8);
                ai_d.tZR.setVisibility(8);
                ai_d.uex.setVisibility(8);
            } else {
                t.nP(bdVar.field_imgPath);
            }
        }
        ImageView imageView = ai_d.tZS;
        e eVar = new e(bdVar, aVar.cwr(), i, bdVar.field_talker);
        eVar.hER = 4;
        imageView.setTag(eVar);
        ai_d.tZS.setOnClickListener(onClickListener);
        imageView = ai_d.tZR;
        eVar = new e(bdVar, aVar.cwr(), i, bdVar.field_talker);
        eVar.hER = 3;
        imageView.setTag(eVar);
        ai_d.tZR.setOnClickListener(onClickListener);
        View view = ai_d.hrH;
        eVar = new e(bdVar, aVar.cwr(), i, bdVar.field_talker);
        eVar.hER = 2;
        view.setTag(eVar);
        ai_d.hrH.setOnClickListener(onClickListener);
        ai_d.hrH.setOnLongClickListener(onLongClickListener);
        ai_d.hrH.setOnTouchListener(((g) aVar.O(g.class)).ctw());
    }
}
