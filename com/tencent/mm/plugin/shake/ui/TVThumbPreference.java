package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.platformtools.y.a;
import com.tencent.mm.plugin.shake.e.b;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class TVThumbPreference extends Preference implements a {
    f gua;
    private ImageView nbF;
    private ImageView nbG;
    private ImageView nbH;
    List<String> nbI;

    public TVThumbPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nbI = null;
        setLayoutResource(R.i.tv_thumb_preference);
        setWidgetLayoutResource(0);
        y.a(this);
    }

    public TVThumbPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TVThumbPreference(Context context) {
        this(context, null);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        return super.onCreateView(viewGroup);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.nbF = (ImageView) view.findViewById(R.h.thumb_1);
        this.nbG = (ImageView) view.findViewById(R.h.thumb_2);
        this.nbH = (ImageView) view.findViewById(R.h.thumb_3);
        if (this.nbI != null && this.nbI.size() > 0) {
            b bVar = new b((String) this.nbI.get(0));
            this.nbF.setTag(bVar.Vx());
            Bitmap a = y.a(bVar);
            if (!(a == null || a.isRecycled())) {
                this.nbF.setImageBitmap(a);
            }
            this.nbF.setVisibility(0);
            if (1 < this.nbI.size()) {
                bVar = new b((String) this.nbI.get(1));
                this.nbG.setTag(bVar.Vx());
                a = y.a(bVar);
                if (!(a == null || a.isRecycled())) {
                    this.nbG.setImageBitmap(a);
                }
                this.nbG.setVisibility(0);
                if (2 < this.nbI.size()) {
                    bVar = new b((String) this.nbI.get(2));
                    this.nbH.setTag(bVar.Vx());
                    a = y.a(bVar);
                    if (!(a == null || a.isRecycled())) {
                        this.nbH.setImageBitmap(a);
                    }
                    this.nbH.setVisibility(0);
                }
            }
        }
    }

    public final void m(String str, final Bitmap bitmap) {
        if (str != null && bitmap != null && !bitmap.isRecycled()) {
            if (this.nbF != null && this.nbF.getTag() != null && str.equals((String) this.nbF.getTag())) {
                this.nbF.post(new Runnable() {
                    public final void run() {
                        TVThumbPreference.this.nbF.setImageBitmap(bitmap);
                        if (TVThumbPreference.this.gua != null) {
                            TVThumbPreference.this.gua.notifyDataSetChanged();
                        }
                    }
                });
            } else if (this.nbG != null && this.nbG.getTag() != null && str.equals((String) this.nbG.getTag())) {
                this.nbG.post(new Runnable() {
                    public final void run() {
                        TVThumbPreference.this.nbG.setImageBitmap(bitmap);
                        if (TVThumbPreference.this.gua != null) {
                            TVThumbPreference.this.gua.notifyDataSetChanged();
                        }
                    }
                });
            } else if (this.nbH != null && this.nbH.getTag() != null && str.equals((String) this.nbH.getTag())) {
                this.nbH.post(new Runnable() {
                    public final void run() {
                        TVThumbPreference.this.nbH.setImageBitmap(bitmap);
                        if (TVThumbPreference.this.gua != null) {
                            TVThumbPreference.this.gua.notifyDataSetChanged();
                        }
                    }
                });
            }
        }
    }
}
