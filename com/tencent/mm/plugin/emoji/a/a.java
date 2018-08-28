package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public abstract class a {
    private final String TAG;
    protected TextView gsY;
    private View icS;
    private final int icT;
    private final int icU;
    private final int icV;
    private int[] icW;
    private int icX;
    public f icY;
    protected View icZ;
    protected ImageView ida;
    protected ImageView idb;
    protected TextView idc;
    protected TextView idd;
    protected ProgressBar ide;
    protected ViewGroup idf;
    protected View idg;
    protected TextView idh;
    protected ImageView idi;
    protected View idj;
    protected ProgressBar idk;
    protected TextView idl;
    protected TextView idm;
    protected FrameLayout idn;
    protected View ido;
    Context mContext;
    private LayoutInflater mLayoutInflater;
    public int mPosition;

    protected abstract void aDj();

    protected abstract int[] aDk();

    protected abstract int aDl();

    protected abstract boolean aDr();

    public a(Context context, View view) {
        this(context, view, a.ids);
    }

    private a(Context context, View view, int i) {
        this.TAG = "MicroMsg.emoji.BaseEmojiItemHolder";
        this.icT = R.i.emoji_list_item;
        this.icU = R.i.emoji_store_v2_grid_item;
        this.icV = R.i.emoji_store_v2_grid_item_main;
        this.icW = new int[]{-1, -1};
        this.icX = -1;
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(this.mContext);
        if (view == null) {
            switch (2.idr[i - 1]) {
                case 1:
                    view = oy(this.icT);
                    break;
                case 2:
                    view = oy(this.icV);
                    break;
                case 3:
                    view = oy(this.icU);
                    break;
                default:
                    view = oy(this.icT);
                    break;
            }
        }
        this.ido = view;
        if (view != null) {
            this.icS = view;
            this.icZ = this.icS.findViewById(R.h.item_container);
            this.idb = (ImageView) this.icS.findViewById(R.h.item_tip);
            this.ida = (ImageView) this.icS.findViewById(R.h.item_icon);
            this.gsY = (TextView) this.icS.findViewById(R.h.item_name);
            this.idc = (TextView) this.icS.findViewById(R.h.item_date);
            this.idd = (TextView) this.icS.findViewById(R.h.item_introduce);
            this.ide = (ProgressBar) this.icS.findViewById(R.h.price_loading);
            this.idg = this.icS.findViewById(R.h.item_option);
            this.idf = (ViewGroup) this.icS.findViewById(R.h.item_root);
            this.idh = (TextView) this.icS.findViewById(R.h.item_state);
            this.idi = (ImageView) this.icS.findViewById(R.h.item_state_image);
            this.idj = this.icS.findViewById(R.h.item_progress_bar);
            this.idk = (ProgressBar) this.icS.findViewById(R.h.item_download_progress);
            this.idl = (TextView) this.icS.findViewById(R.h.item_category);
            this.idm = (TextView) this.icS.findViewById(R.h.item_new);
            this.idn = (FrameLayout) this.icS.findViewById(R.h.item_list_content);
        }
        aDj();
        if (i == a.ids) {
            int[] aDk = aDk();
            if (this.ida != null && aDk[0] >= 0 && aDk[1] >= 0 && !(aDk[0] == this.icW[0] && aDk[1] == this.icW[1])) {
                LayoutParams layoutParams = this.ida.getLayoutParams();
                layoutParams.width = aDk[0];
                layoutParams.height = aDk[1];
                this.ida.setLayoutParams(layoutParams);
                this.icW = aDk;
            }
            int aDl = aDl();
            if (!(this.icS == null || aDl < 0 || this.icX == aDl)) {
                this.icS.setMinimumHeight(aDl);
                if (this.icZ != null) {
                    this.icZ.setMinimumHeight(aDl);
                }
            }
        }
        view.setTag(this);
    }

    private View oy(int i) {
        if (this.mLayoutInflater == null || i <= 0) {
            return null;
        }
        return this.mLayoutInflater.inflate(i, null);
    }

    public final void setTitle(String str) {
        this.gsY.setText(str);
    }

    public final void setTitle(int i) {
        this.gsY.setText(i);
    }

    public final ImageView aDm() {
        return this.ida;
    }

    public final void oz(int i) {
        this.ida.setImageResource(i);
    }

    public final ImageView aDn() {
        return this.idb;
    }

    public final void oA(int i) {
        this.idb.setVisibility(i);
    }

    public final void oB(int i) {
        this.idb.setImageResource(i);
    }

    public final void oC(int i) {
        this.idg.setVisibility(i);
    }

    public final void aDo() {
        this.idc.setVisibility(8);
        this.idd.setVisibility(8);
    }

    public final void yX(String str) {
        this.idc.setText(str);
    }

    public final void yY(String str) {
        if (bi.oW(str)) {
            this.idd.setVisibility(8);
            return;
        }
        this.idd.setVisibility(0);
        this.idd.setText(str);
    }

    public final void a(com.tencent.mm.plugin.emoji.model.h.a aVar) {
        if (this.idg != null) {
            this.idg.setOnClickListener(new 1(this, aVar));
        }
    }

    protected boolean a(com.tencent.mm.plugin.emoji.model.h.a aVar, View view) {
        return true;
    }

    protected void b(com.tencent.mm.plugin.emoji.model.h.a aVar, View view) {
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public final String getProductId() {
        return (this.icY == null || this.icY.iez == null) ? null : this.icY.iez.rem;
    }

    public final int aDp() {
        return (this.icY == null ? null : Integer.valueOf(this.icY.mStatus)).intValue();
    }

    public final String aDq() {
        return (this.icY == null || this.icY.iez == null) ? null : this.icY.iez.rwT;
    }

    public final int getProgress() {
        return this.icY == null ? 0 : this.icY.pF;
    }

    protected final void aDs() {
        this.ide.setVisibility(8);
        this.idf.setVisibility(8);
        this.idg.setEnabled(false);
        this.idi.setVisibility(8);
        this.idk.setVisibility(0);
        this.idk.setProgress(getProgress());
        if (this.idj == null) {
            this.idk.setVisibility(0);
        } else {
            this.idj.setVisibility(0);
        }
    }

    private void aDt() {
        this.ide.setVisibility(8);
        this.idf.setBackgroundResource(R.g.btn_solid_green);
        this.idf.setVisibility(0);
        this.idg.setEnabled(true);
        this.idh.setText("");
        if (this.idj == null) {
            this.idk.setVisibility(4);
        } else {
            this.idj.setVisibility(4);
        }
        this.idh.setVisibility(0);
        this.idh.setText(R.l.emoji_store_download);
        this.idh.setTextColor(this.mContext.getResources().getColorStateList(R.e.white_text_color_selector));
        this.idi.setVisibility(8);
    }

    public void aDu() {
        if (this.icY != null && aDr()) {
            this.idh.setVisibility(8);
            this.idh.setTextColor(this.mContext.getResources().getColorStateList(R.e.black_text_color_selector));
            switch (aDp()) {
                case 0:
                    aDt();
                    return;
                case 3:
                    aDt();
                    return;
                case 4:
                case 12:
                    this.ide.setVisibility(8);
                    this.idf.setBackgroundResource(R.g.btn_solid_white);
                    this.idf.setVisibility(0);
                    if (this.idj == null) {
                        this.idk.setVisibility(4);
                    } else {
                        this.idj.setVisibility(4);
                    }
                    this.idg.setEnabled(true);
                    this.idi.setVisibility(4);
                    this.idh.setVisibility(0);
                    if (this.icY.iez != null) {
                        this.idh.setText(this.icY.iez.rwT);
                        return;
                    }
                    return;
                case 6:
                    aDs();
                    return;
                case 7:
                    if (this.icY.ieD) {
                        x.d("MicroMsg.emoji.BaseEmojiItemHolder", "jacks use emoji");
                        this.ide.setVisibility(8);
                        this.idf.setBackgroundResource(R.g.btn_solid_green);
                        this.idf.setVisibility(0);
                        this.idf.setTag(getProductId());
                        this.idg.setEnabled(true);
                        this.idh.setVisibility(0);
                        this.idh.setText(R.l.emoji_store_use);
                        this.idh.setTextColor(this.mContext.getResources().getColorStateList(R.e.white_text_color_selector));
                        this.idi.setVisibility(4);
                        if (this.idj == null) {
                            this.idk.setVisibility(4);
                            return;
                        } else {
                            this.idj.setVisibility(4);
                            return;
                        }
                    } else if (this.icY.ieF && e.cs(this.icY.iez.rwV, 64)) {
                        this.idf.setVisibility(0);
                        this.idf.setBackgroundResource(R.g.btn_solid_red);
                        this.idh.setVisibility(0);
                        this.idh.setText(R.l.emoji_store_reward);
                        this.idh.setTextColor(this.mContext.getResources().getColorStateList(R.e.white_text_color_selector));
                        this.idi.setVisibility(4);
                        this.idg.setEnabled(true);
                        if (this.idj == null) {
                            this.idk.setVisibility(4);
                            return;
                        } else {
                            this.idj.setVisibility(4);
                            return;
                        }
                    } else {
                        this.ide.setVisibility(8);
                        this.idf.setVisibility(0);
                        this.idf.setBackgroundResource(R.g.btn_solid_white);
                        this.idh.setVisibility(0);
                        this.idh.setText(R.l.emoji_store_downloaded);
                        this.idh.setTextColor(this.mContext.getResources().getColorStateList(R.e.black_text_color_disabled));
                        this.idi.setVisibility(4);
                        this.idg.setEnabled(false);
                        if (this.idj == null) {
                            this.idk.setVisibility(4);
                            return;
                        } else {
                            this.idj.setVisibility(4);
                            return;
                        }
                    }
                case 8:
                    this.ide.setVisibility(8);
                    this.idf.setBackgroundDrawable(null);
                    this.idf.setVisibility(0);
                    this.idg.setEnabled(false);
                    this.idh.setVisibility(0);
                    this.idh.setText(R.l.emoji_store_expire);
                    this.idi.setVisibility(4);
                    if (this.idj == null) {
                        this.idk.setVisibility(4);
                        return;
                    } else {
                        this.idj.setVisibility(4);
                        return;
                    }
                case 10:
                    this.ide.setVisibility(8);
                    this.idf.setBackgroundResource(R.g.btn_solid_white);
                    this.idf.setVisibility(0);
                    this.idh.setVisibility(0);
                    this.idh.setText(R.l.emoji_store_play);
                    this.idi.setVisibility(4);
                    this.idg.setEnabled(true);
                    if (this.idj == null) {
                        this.idk.setVisibility(4);
                        return;
                    } else {
                        this.idj.setVisibility(4);
                        return;
                    }
                case 11:
                    this.ide.setVisibility(0);
                    this.idf.setBackgroundResource(R.g.btn_solid_white);
                    this.idf.setVisibility(0);
                    this.idh.setVisibility(0);
                    this.idh.setText("");
                    this.idg.setEnabled(false);
                    this.idi.setVisibility(4);
                    if (this.idj == null) {
                        this.idk.setVisibility(4);
                        return;
                    } else {
                        this.idj.setVisibility(4);
                        return;
                    }
                default:
                    x.w("MicroMsg.emoji.BaseEmojiItemHolder", "unknow product status:%d", new Object[]{Integer.valueOf(aDp())});
                    return;
            }
        }
    }

    public final View aDv() {
        return this.ido;
    }
}
