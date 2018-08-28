package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ak.o;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.i;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.plugin.game.model.m.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class GameInstalledView extends LinearLayout implements OnClickListener {
    private static Map<String, Integer> jZg = new HashMap();
    private static int jZi = 6;
    private static int jZj = 7;
    private int count = 0;
    private int jNv = 0;
    private LinkedList<f> jOb = new LinkedList();
    private b jWz = new 2(this);
    private LinearLayout jZc;
    private ImageView jZd;
    private TextView jZe;
    private TextView jZf;
    private final DisplayMetrics jZh = new DisplayMetrics();
    private int jZk = 4;
    private int jZl = 1;
    private int jZm = 999;
    private a jZn;
    private LinkedList<d> jZo;
    LayoutParams jZp = new LayoutParams(-1, -2);
    private Context mContext;

    static /* synthetic */ int b(GameInstalledView gameInstalledView) {
        int i = gameInstalledView.count + 1;
        gameInstalledView.count = i;
        return i;
    }

    public GameInstalledView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.jZc = (LinearLayout) findViewById(e.game_installed_layout);
        m.a(this.jWz);
    }

    public final void ey(boolean z) {
        if (bi.cX(this.jZo)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        Iterator it;
        if (z) {
            this.jOb = com.tencent.mm.plugin.game.model.f.aTy();
            if (!(bi.cX(this.jZo) || bi.cX(this.jOb))) {
                it = this.jZo.iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    if (this.jOb.contains(dVar)) {
                        this.jOb.remove(dVar);
                        this.jOb.addFirst(dVar);
                    }
                }
            }
        } else {
            f fVar;
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.jOb);
            LinkedList linkedList2 = new LinkedList();
            linkedList2.addAll(com.tencent.mm.plugin.game.model.f.aTy());
            Collection linkedList3 = new LinkedList();
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                fVar = (f) it2.next();
                if (!(linkedList2.contains(fVar) || linkedList3.contains(fVar))) {
                    linkedList3.add(fVar);
                }
            }
            it2 = linkedList.iterator();
            while (it2.hasNext()) {
                fVar = (f) it2.next();
                if (linkedList2.contains(fVar)) {
                    linkedList2.remove(fVar);
                } else if (!g.a(this.mContext, fVar)) {
                    linkedList3.add(fVar);
                }
            }
            if (linkedList2.size() > 0) {
                Iterator it3 = linkedList2.iterator();
                while (it3.hasNext()) {
                    fVar = (f) it3.next();
                    if (!linkedList.contains(fVar)) {
                        linkedList.addFirst(fVar);
                    }
                }
            }
            if (linkedList3.size() > 0) {
                linkedList.removeAll(linkedList3);
            }
            linkedList2 = new LinkedList();
            it = linkedList.iterator();
            while (it.hasNext()) {
                linkedList2.add(g.bl(((f) it.next()).field_appId, true));
            }
            this.jOb = linkedList2;
        }
        aUX();
    }

    private void aUX() {
        if (bi.cX(this.jOb)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.jZc.removeAllViews();
        this.count = 0;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        if (this.jOb.size() >= this.jZk - 1) {
            jZj = 7;
            jZi = 6;
            int b = BackwardSupportUtil.b.b(this.mContext, (float) ((jZi << 1) + 84));
            ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.jZh);
            int i = (int) (((float) (this.jZh.widthPixels * 160)) / ((float) this.jZh.densityDpi));
            this.jZk = ((this.jZh.widthPixels - 1) / b) + 1;
            if (this.jZk == 3) {
                jZj = 3;
            }
            b = (jZi << 1) + 84;
            int i2 = (jZi + 6) + jZj;
            i = (i - 16) % b;
            if (i < i2) {
                jZi -= 2;
                BackwardSupportUtil.b.b(this.mContext, (float) ((jZi << 1) + 84));
            } else if (i > b - i2) {
                jZi = ((i - (b >> 1)) / this.jZk) + jZi;
                BackwardSupportUtil.b.b(this.mContext, (float) ((jZi << 1) + 84));
            }
        }
        this.jZp.setMargins(BackwardSupportUtil.b.b(this.mContext, (float) jZi), 0, BackwardSupportUtil.b.b(this.mContext, (float) jZi), 0);
        Iterator it = this.jOb.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            View inflate = layoutInflater.inflate(com.tencent.mm.plugin.game.f.f.installed_game_item, null);
            this.jZd = (ImageView) inflate.findViewById(e.game_icon);
            this.jZe = (TextView) inflate.findViewById(e.game_name);
            this.jZf = (TextView) inflate.findViewById(e.game_sns_info);
            Bitmap b2 = g.b(fVar.field_appId, 1, a.getDensity(this.mContext));
            if (b2 != null) {
                this.jZd.setImageBitmap(b2);
            } else {
                this.jZd.setImageResource(com.tencent.mm.plugin.game.f.d.app_panel_unknowed_icon);
            }
            this.jZe.setText(g.b(this.mContext, fVar, null));
            if (g.a(this.mContext, fVar)) {
                int DP = c.DP(fVar.field_packageName);
                if (jZg.containsKey(fVar.field_appId) && ((Integer) jZg.get(fVar.field_appId)).intValue() > DP) {
                    FileDownloadTaskInfo yO = com.tencent.mm.plugin.downloader.model.d.aCU().yO(fVar.field_appId);
                    this.jZf.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.game.f.b.gc_install_text_color));
                    if (yO.status == 1) {
                        this.jZf.setText(i.game_action_updating);
                    } else {
                        this.jZf.setText(i.game_action_update);
                    }
                } else if (bi.oW(fVar.cmI)) {
                    this.jZf.setText("");
                } else {
                    this.jZf.setText(fVar.cmI);
                    this.jZf.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.game.f.b.gc_sns_info_color));
                }
            } else {
                this.jZf.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.game.f.b.gc_install_text_color));
                this.jZf.setText(i.game_list_app_install);
            }
            inflate.setTag(fVar);
            inflate.setOnClickListener(this);
            this.jZc.addView(inflate, this.jZp);
        }
        if (this.jZn != null && this.jZn.iconUrl != null && this.jZn.title != null) {
            View inflate2 = layoutInflater.inflate(com.tencent.mm.plugin.game.f.f.installed_game_item, null);
            this.jZd = (ImageView) inflate2.findViewById(e.game_icon);
            this.jZe = (TextView) inflate2.findViewById(e.game_name);
            this.jZf = (TextView) inflate2.findViewById(e.game_sns_info);
            com.tencent.mm.ak.a.a Pj = o.Pj();
            String str = this.jZn.iconUrl;
            ImageView imageView = this.jZd;
            com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
            aVar.dXx = true;
            Pj.a(str, imageView, aVar.Pt(), new 1(this, inflate2));
            this.jZe.setText(this.jZn.title);
            this.jZf.setVisibility(8);
            inflate2.setTag(this.jZn);
            inflate2.setOnClickListener(this);
        }
    }

    public void setMoreGameInfo(a aVar) {
        this.jZn = aVar;
    }

    public void setInstalledGameInfo(LinkedList<d> linkedList) {
        this.jZo = linkedList;
    }

    public void setSourceScene(int i) {
        this.jNv = i;
    }

    public void setVersionCodes(Map<String, Integer> map) {
        if (map != null && !map.isEmpty()) {
            jZg = map;
        }
    }

    public void onClick(View view) {
        if (view.getTag() != null) {
            if (view.getTag() instanceof f) {
                f fVar = (f) view.getTag();
                FileDownloadTaskInfo yO;
                if (fVar == null || bi.oW(fVar.field_appId)) {
                    x.e("MicroMsg.GameInstalledView", "appinfo is null or appid is null");
                } else if (g.a(this.mContext, fVar)) {
                    int DP = c.DP(fVar.field_packageName);
                    if (!jZg.containsKey(fVar.field_appId) || ((Integer) jZg.get(fVar.field_appId)).intValue() <= DP) {
                        com.tencent.mm.plugin.game.model.f.ah(this.mContext, fVar.field_appId);
                        an.a(this.mContext, 10, 1002, this.jZl, 3, 0, fVar.field_appId, this.jNv, 0, null, null, null);
                        this.jOb.remove(fVar);
                        this.jOb.addFirst(fVar);
                    } else {
                        yO = com.tencent.mm.plugin.downloader.model.d.aCU().yO(fVar.field_appId);
                        if (yO.status == 1) {
                            com.tencent.mm.plugin.downloader.model.d.aCU().cl(yO.id);
                        } else {
                            if (yO.status == 3) {
                                if (!com.tencent.mm.a.e.cn(yO.path) || c.DQ(yO.path) <= DP) {
                                    com.tencent.mm.plugin.downloader.model.d.aCU().cl(yO.id);
                                } else {
                                    q.g(this.mContext, Uri.fromFile(new File(yO.path)));
                                }
                            }
                            m.j(fVar.cmE, fVar.cmJ, fVar.field_appId, "");
                            com.tencent.mm.plugin.downloader.model.e.a aVar = new com.tencent.mm.plugin.downloader.model.e.a();
                            aVar.yQ(fVar.cmE);
                            aVar.yS(g.b(this.mContext, fVar, null));
                            aVar.setAppId(fVar.field_appId);
                            aVar.yT(fVar.cmJ);
                            aVar.ef(true);
                            aVar.ox(1);
                            com.tencent.mm.plugin.downloader.model.d.aCU().a(aVar.ick);
                        }
                    }
                    ey(false);
                } else {
                    yO = com.tencent.mm.plugin.downloader.model.d.aCU().yO(fVar.field_appId);
                    if (yO == null || yO.status != 3) {
                        x.i("MicroMsg.GameInstalledView", "app not installed or download sucess : [%s]", new Object[]{fVar.field_appName});
                        ey(false);
                    } else if (bi.oW(yO.path) || !com.tencent.mm.a.e.cn(yO.path)) {
                        x.e("MicroMsg.GameInstalledView", "file status is success, while the download file not exsit:[%s]", new Object[]{yO.path});
                        com.tencent.mm.plugin.downloader.model.d.aCU().cl(yO.id);
                        ey(false);
                    } else {
                        q.g(this.mContext, Uri.fromFile(new File(yO.path)));
                    }
                }
            } else if (view.getTag() instanceof a) {
                a aVar2 = (a) view.getTag();
                Intent intent = new Intent();
                int i = 6;
                if (bi.oW(aVar2.fIb)) {
                    intent.setClass(this.mContext, GameLibraryUI.class);
                    intent.putExtra("game_report_from_scene", 1002);
                    this.mContext.startActivity(intent);
                } else {
                    i = c.r(this.mContext, aVar2.fIb, "game_center_installed_more");
                }
                an.a(this.mContext, 10, 1002, this.jZm, i, 0, null, this.jNv, 0, null, null, null);
            }
        }
    }
}
