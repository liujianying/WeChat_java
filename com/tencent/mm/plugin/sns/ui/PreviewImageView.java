package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.ui.w.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PreviewImageView extends LinearLayout implements w {
    private final Context context;
    private List<String> list = new ArrayList();
    private TableLayout nQm;
    private final Map<Integer, View> nQn = new HashMap();
    private final Map<Integer, TableRow> nQo = new HashMap();
    private final int nQp = 4;
    private HashMap<String, Bitmap> nQq = new HashMap();
    private a nQr;
    private boolean nQs = true;
    private boolean nQt = false;

    public PreviewImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public PreviewImageView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public void setIsShowAddImage(boolean z) {
        this.nQs = z;
    }

    public View getView() {
        return this;
    }

    public void setImageClick(a aVar) {
        this.nQr = aVar;
    }

    private void init() {
        this.nQm = (TableLayout) LayoutInflater.from(this.context).inflate(g.sns_preview_view, this, true).findViewById(f.content);
    }

    public int getCount() {
        return this.nQn.size();
    }

    public final void clean() {
        this.nQt = true;
        for (Bitmap bitmap : this.nQq.values()) {
            if (i.q(bitmap)) {
                bitmap.recycle();
            }
        }
    }

    public final void setList$22875ea3(List<String> list) {
        long currentTimeMillis = System.currentTimeMillis();
        if (list != null) {
            this.list = list;
            int i = 0;
            this.nQm.removeAllViews();
            int size = list.size() + 1;
            int i2 = 0;
            while (i < size) {
                View view;
                View view2 = (TableRow) this.nQo.get(Integer.valueOf(i2));
                if (view2 == null) {
                    view2 = new TableRow(this.context);
                    this.nQo.put(Integer.valueOf(i2), view2);
                    view = view2;
                } else {
                    view = view2;
                }
                view.removeAllViews();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= 4 || i >= size) {
                        i3 = i;
                    } else if (i >= 9) {
                        i3 = i + 1;
                        break;
                    } else {
                        String str;
                        view2 = (View) this.nQn.get(Integer.valueOf(i));
                        if (view2 == null) {
                            view2 = View.inflate(this.context, g.sns_preview_view_item, null);
                            this.nQn.put(Integer.valueOf(i), view2);
                        }
                        View view3 = view2;
                        if (i == size - 1) {
                            str = "";
                        } else {
                            str = (String) list.get(i);
                        }
                        ImageView imageView = (ImageView) view3.findViewById(f.iv);
                        if (i != size - 1) {
                            imageView.setBackgroundDrawable(null);
                            imageView.setTag(str);
                            imageView.setContentDescription(getContext().getString(j.sns_img));
                            Bitmap bitmap = (Bitmap) this.nQq.get(str);
                            if (i.q(bitmap)) {
                                imageView.setImageBitmap(bitmap);
                            } else {
                                x.d("MicroMsg.PreviewImageView", "bm is null");
                                new a(this, imageView, str).o(new String[]{""});
                            }
                        } else if (this.nQs) {
                            imageView.setBackgroundResource(e.sns_add_item);
                            imageView.setContentDescription(getContext().getString(j.sns_add_photo));
                            imageView.setImageDrawable(null);
                        } else {
                            i3 = i4 + 1;
                            i++;
                        }
                        if (this.nQr != null) {
                            if (i == size - 1) {
                                view3.setTag(Integer.valueOf(-1));
                                view3.setOnClickListener(this.nQr.nNR);
                                view3.setClickable(true);
                            } else {
                                view3.setTag(Integer.valueOf(i));
                                view3.setOnClickListener(this.nQr.nNR);
                                view3.setClickable(true);
                            }
                        }
                        view3.setLayoutParams(new LayoutParams(-2, -2));
                        view.addView(view3);
                        i3 = i4 + 1;
                        i++;
                    }
                }
                i3 = i;
                if (view.getChildCount() > 0) {
                    this.nQm.addView(view);
                }
                x.d("MicroMsg.PreviewImageView", "initlist time : " + (System.currentTimeMillis() - currentTimeMillis));
                i2++;
                i = i3;
            }
        }
    }
}
