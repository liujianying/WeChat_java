package com.tencent.mm.ui.chatting.gallery;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ac.f;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.r;
import com.tencent.mm.y.g$a;
import java.util.HashMap;
import java.util.Map;

public final class c extends r<bd> implements OnClickListener {
    private static Map<String, Integer> iYH;
    private static Map<String, Integer> tUk;
    private LayoutInflater Bc;
    String gBf;
    protected com.tencent.mm.ak.a.a.c hOC = null;
    Context mContext;
    public boolean mGh = false;
    boolean qIZ;
    private boolean qUB;
    long tNE;
    private final ImageGalleryGridUI tUi;
    boolean tUj = false;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        bd bdVar = new bd();
        bdVar.d(cursor);
        return bdVar;
    }

    public c(Context context, bd bdVar, String str) {
        super(context, bdVar);
        this.tUi = (ImageGalleryGridUI) context;
        this.gBf = str;
        this.qIZ = f.eZ(this.gBf);
        if (this.qIZ) {
            this.tNE = bdVar.field_bizChatId;
        }
        au.HU();
        this.qUB = com.tencent.mm.model.c.isSDCardAvailable();
        this.Bc = LayoutInflater.from(context);
        a aVar = new a();
        aVar.dXD = 1;
        aVar.dXY = true;
        aVar.dXF = com.tencent.mm.bp.a.fk(context) / 3;
        aVar.dXE = com.tencent.mm.bp.a.fk(context) / 3;
        aVar.dXR = R.e.pic_thum_bg_color;
        this.hOC = aVar.Pt();
    }

    public final boolean areAllItemsEnabled() {
        return false;
    }

    public final void WT() {
        if (this.qIZ) {
            au.HU();
            setCursor(com.tencent.mm.model.c.FU().ar(this.gBf, this.tNE));
            return;
        }
        au.HU();
        setCursor(com.tencent.mm.model.c.FT().GI(this.gBf));
    }

    protected final void WS() {
        if (this.qIZ) {
            au.HU();
            setCursor(com.tencent.mm.model.c.FU().ar(this.gBf, this.tNE));
            return;
        }
        au.HU();
        setCursor(com.tencent.mm.model.c.FT().GI(this.gBf));
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.Bc.inflate(R.i.image_gallary_grid_item, viewGroup, false);
            aVar = new a();
            aVar.mZb = (ImageView) view.findViewById(R.h.grid_header_item);
            aVar.tNM = view.findViewById(R.h.video_tips_root);
            aVar.tUo = (TextView) view.findViewById(R.h.file_name_tv);
            aVar.tUo.setVisibility(8);
            aVar.tUn = (ImageView) view.findViewById(R.h.file_icon);
            aVar.tNN = (TextView) view.findViewById(R.h.video_time_tv);
            aVar.tNM.setVisibility(8);
            aVar.tNP = view.findViewById(R.h.sight_tips_root);
            aVar.tNP.setVisibility(8);
            aVar.tUp = view.findViewById(R.h.file_tips_root);
            aVar.tUp.setVisibility(8);
            aVar.tNO = (ImageView) view.findViewById(R.h.grid_selected_item_mask);
            aVar.jBR = (CheckBox) view.findViewById(R.h.media_cbx);
            aVar.jBS = view.findViewById(R.h.media_cbx_clickarea);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.tNP.setVisibility(8);
        aVar.tNM.setVisibility(8);
        aVar.tUp.setVisibility(8);
        aVar.tUo.setVisibility(8);
        bd bdVar = (bd) getItem(i);
        if (bdVar != null) {
            if (!this.qUB) {
                aVar.mZb.setImageResource(R.g.nosdcard_chatting_bg);
            } else if (this.tUi instanceof ImageGalleryGridUI) {
                String str = bdVar.field_content;
                g$a g_a = null;
                if (str != null) {
                    g_a = g$a.J(str, bdVar.field_reserved);
                }
                if (this.tUi.tUq == i) {
                    aVar.tNO.setVisibility(0);
                    if (!b.bj(bdVar) || g_a == null || g_a.type == 3) {
                        if (g_a != null && g_a.type == 3) {
                            aVar.tUn.setImageDrawable(this.tUi.getResources().getDrawable(f(g_a)));
                        }
                        o.Pj().a(br(bdVar), aVar.mZb, this.hOC, new 1(this));
                    } else {
                        aVar.tUn.setImageDrawable(this.tUi.getResources().getDrawable(f(g_a)));
                        aVar.mZb.setImageResource(g(g_a));
                    }
                } else {
                    aVar.tNO.setVisibility(0);
                    aVar.tNO.setBackgroundResource(R.e.image_gallery_mask);
                    if (!b.bj(bdVar) || g_a == null || g_a.type == 3) {
                        if (g_a != null && g_a.type == 3) {
                            aVar.tUn.setImageDrawable(this.tUi.getResources().getDrawable(f(g_a)));
                        }
                        o.Pj().a(br(bdVar), aVar.mZb, this.hOC);
                    } else {
                        aVar.tUn.setImageDrawable(this.tUi.getResources().getDrawable(f(g_a)));
                        aVar.mZb.setImageResource(g(g_a));
                    }
                }
                aVar.mZb.setPadding(0, 0, 0, 0);
                int measuredWidth = aVar.mZb.getMeasuredWidth();
                int measuredHeight = aVar.mZb.getMeasuredHeight();
                if (measuredWidth > 0 && measuredHeight > 0) {
                    LayoutParams layoutParams = aVar.tNO.getLayoutParams();
                    layoutParams.width = measuredWidth;
                    layoutParams.height = measuredHeight;
                    aVar.tNO.setLayoutParams(layoutParams);
                }
                if (b.bh(bdVar)) {
                    if (aVar != null) {
                        aVar.tNM.setVisibility(0);
                        com.tencent.mm.modelvideo.r bA = i.bA(bdVar);
                        if (bA != null) {
                            aVar.tNN.setText(ai.iR(bA.enM));
                        }
                    }
                } else if (b.bi(bdVar)) {
                    aVar.tNP.setVisibility(0);
                } else if (b.bj(bdVar) && aVar != null) {
                    aVar.tUp.setVisibility(0);
                    aVar.tUo.setVisibility(0);
                    if (g_a != null) {
                        x.i("MicroMsg.ImageGalleryGridAdapter", "initFileName--->content:%s", new Object[]{ai.oV(g_a.title)});
                        if (g_a.type != 24) {
                            aVar.tUo.setText(j.a(this.mContext, ai.oV(g_a.title), aVar.tUo.getTextSize()));
                        } else {
                            aVar.tUo.setText(j.a(aVar.tUo.getContext(), aVar.tUo.getContext().getString(R.l.favorite_wenote), aVar.tUo.getTextSize()));
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("the context should be ImageGalleryGridUI");
            }
            aVar.jBR.setChecked(g.a.cwU().by(bdVar));
            aVar.jBR.setTag(bdVar);
            aVar.jBS.setTag(aVar);
            aVar.jBS.setOnClickListener(this);
            if (g.a.cwU().tVs) {
                aVar.jBR.setVisibility(0);
                aVar.jBS.setVisibility(0);
                aVar.tNO.setVisibility(0);
            } else {
                aVar.jBR.setVisibility(8);
                aVar.jBS.setVisibility(8);
                aVar.tNO.setVisibility(8);
            }
        }
        return view;
    }

    private static int f(g$a g_a) {
        if (g_a == null) {
            x.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + R.k.app_attach_file_icon_unknow);
            return R.k.app_attach_file_icon_unknow_in_gird;
        } else if (g_a.type == 5 || g_a.type == 7 || g_a.type == 15) {
            return R.k.app_attach_file_icon_url_in_gird;
        } else {
            if (g_a.type == 3) {
                return R.k.app_attach_file_icon_music_in_gird;
            }
            if (g_a.type != 6 || !iYH.containsKey(ai.oV(g_a.dwp))) {
                return R.k.app_attach_file_icon_unknow_in_gird;
            }
            x.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + iYH.get(ai.oV(g_a.dwp)));
            return ((Integer) iYH.get(ai.oV(g_a.dwp))).intValue();
        }
    }

    private static int g(g$a g_a) {
        if (g_a == null) {
            x.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + R.e.app_attach_file_bg_unknow_in_gird);
            return R.e.app_attach_file_bg_unknow_in_gird;
        } else if (g_a.type == 5 || g_a.type == 7 || g_a.type == 15) {
            return R.e.app_attach_file_bg_url_in_gird;
        } else {
            if (g_a.type != 6 || !tUk.containsKey(ai.oV(g_a.dwp))) {
                return R.e.app_attach_file_bg_unknow_in_gird;
            }
            x.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + tUk.get(ai.oV(g_a.dwp)));
            return ((Integer) tUk.get(ai.oV(g_a.dwp))).intValue();
        }
    }

    private static String br(bd bdVar) {
        String nL;
        if (bdVar.cmj() || bdVar.cmk()) {
            com.tencent.mm.modelvideo.o.Ta();
            nL = s.nL(bdVar.field_imgPath);
        } else {
            nL = o.Pf().d(bdVar.field_imgPath, false, false);
            if (!(ai.oW(nL) || nL.endsWith("hd") || !FileOp.cn(nL + "hd"))) {
                nL = nL + "hd";
            }
        }
        x.i("MicroMsg.ImageGalleryGridAdapter", "MsgInfoForMonetUri imgPath : %s", new Object[]{nL});
        if (!bdVar.cmo()) {
            return nL;
        }
        g$a gp = g$a.gp(bdVar.field_content);
        String str = null;
        if (!(gp == null || gp.bGP == null || gp.bGP.length() <= 0)) {
            b SR = ao.asF().SR(gp.bGP);
            if (SR != null) {
                str = SR.field_fileFullPath;
            }
        }
        if (str != null) {
            return str;
        }
        return nL;
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.tUj = false;
    }

    public final void onClick(View view) {
        a aVar = (a) view.getTag();
        if (aVar.jBR != null) {
            bd bdVar = (bd) aVar.jBR.getTag();
            if (bdVar != null) {
                g cwU = g.a.cwU();
                if (cwU.by(bdVar)) {
                    cwU.bx(bdVar);
                } else {
                    cwU.bw(bdVar);
                }
                if (g.a.cwU().by(bdVar)) {
                    aVar.jBR.setChecked(true);
                    aVar.tNO.setBackgroundResource(R.e.half_alpha_black);
                } else {
                    aVar.jBR.setChecked(false);
                    aVar.tNO.setBackgroundResource(R.e.image_gallery_mask);
                }
                if (!this.mGh && g.a.cwU().tTJ.size() > 1) {
                    h.mEJ.a(219, 20, 1, true);
                    this.mGh = true;
                }
            }
        }
    }

    static {
        Map hashMap = new HashMap();
        iYH = hashMap;
        hashMap.put("avi", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
        iYH.put("m4v", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
        iYH.put("vob", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
        iYH.put("mpeg", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
        iYH.put("mpe", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
        iYH.put("asx", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
        iYH.put("asf", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
        iYH.put("f4v", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
        iYH.put("flv", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
        iYH.put("mkv", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
        iYH.put("wmv", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
        iYH.put("wm", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
        iYH.put("3gp", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
        iYH.put("mp4", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
        iYH.put("rmvb", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
        iYH.put("rm", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
        iYH.put("ra", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
        iYH.put("ram", Integer.valueOf(R.k.app_attach_file_icon_video_in_gird));
        iYH.put("mp3pro", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
        iYH.put("vqf", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
        iYH.put("cd", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
        iYH.put("md", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
        iYH.put("mod", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
        iYH.put("vorbis", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
        iYH.put("au", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
        iYH.put("amr", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
        iYH.put("silk", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
        iYH.put("wma", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
        iYH.put("mmf", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
        iYH.put("mid", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
        iYH.put("midi", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
        iYH.put("mp3", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
        iYH.put("aac", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
        iYH.put("ape", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
        iYH.put("aiff", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
        iYH.put("aif", Integer.valueOf(R.k.app_attach_file_icon_music_in_gird));
        iYH.put("doc", Integer.valueOf(R.k.app_attach_file_icon_word_in_gird));
        iYH.put("docx", Integer.valueOf(R.k.app_attach_file_icon_word_in_gird));
        iYH.put("ppt", Integer.valueOf(R.k.app_attach_file_icon_ppt_in_gird));
        iYH.put("pptx", Integer.valueOf(R.k.app_attach_file_icon_ppt_in_gird));
        iYH.put("xls", Integer.valueOf(R.k.app_attach_file_icon_excel_in_gird));
        iYH.put("xlsx", Integer.valueOf(R.k.app_attach_file_icon_excel_in_gird));
        iYH.put("pdf", Integer.valueOf(R.k.app_attach_file_icon_pdf_in_gird));
        iYH.put("unknown", Integer.valueOf(R.k.app_attach_file_icon_unknow_in_gird));
        hashMap = new HashMap();
        tUk = hashMap;
        hashMap.put("doc", Integer.valueOf(R.e.app_attach_file_bg_doc_in_gird));
        tUk.put("docx", Integer.valueOf(R.e.app_attach_file_bg_doc_in_gird));
        tUk.put("ppt", Integer.valueOf(R.e.app_attach_file_bg_ppt_in_gird));
        tUk.put("pptx", Integer.valueOf(R.e.app_attach_file_bg_ppt_in_gird));
        tUk.put("xls", Integer.valueOf(R.e.app_attach_file_bg_xls_in_gird));
        tUk.put("xlsx", Integer.valueOf(R.e.app_attach_file_bg_xls_in_gird));
        tUk.put("pdf", Integer.valueOf(R.e.app_attach_file_bg_pdf_in_gird));
        tUk.put("unknown", Integer.valueOf(R.e.app_attach_file_bg_unknow_in_gird));
        tUk.put("mp3pro", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
        tUk.put("vqf", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
        tUk.put("cd", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
        tUk.put("md", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
        tUk.put("mod", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
        tUk.put("vorbis", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
        tUk.put("au", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
        tUk.put("amr", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
        tUk.put("silk", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
        tUk.put("wma", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
        tUk.put("mmf", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
        tUk.put("mid", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
        tUk.put("midi", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
        tUk.put("mp3", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
        tUk.put("aac", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
        tUk.put("ape", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
        tUk.put("aiff", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
        tUk.put("aif", Integer.valueOf(R.e.app_attach_file_bg_music_in_gird));
    }
}
