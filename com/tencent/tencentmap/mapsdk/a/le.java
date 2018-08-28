package com.tencent.tencentmap.mapsdk.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class le implements OnItemClickListener, ld, lf$a {
    private static final int p = Color.argb(200, 56, 56, 56);
    public boolean a = false;
    private RelativeLayout b;
    private lf c;
    private TextView d;
    private View e;
    private View f;
    private View g;
    private Bitmap h;
    private Bitmap i;
    private float j = 1.0f;
    private final int k = 45;
    private final int l = 4;
    private final int m = 50;
    private final int n = 8;
    private int o = 0;
    private a q;
    private Context r;
    private aa s;
    private int t = -1;
    private int u = 0;
    private ov v;
    private String w;
    private boolean x = false;
    private oj y;
    private a z = null;

    private class a extends BaseAdapter {
        private Context b;
        private List<ow> c;

        public class a {
            public TextView a;
            public ImageView b;

            public a(TextView textView, ImageView imageView) {
                this.a = textView;
                this.b = imageView;
            }
        }

        public a(Context context, List<ow> list) {
            this.b = context;
            this.c = list;
        }

        public int getCount() {
            if (this.c == null) {
                return 0;
            }
            return this.c.size();
        }

        public Object getItem(int i) {
            if (this.c == null) {
                return null;
            }
            return this.c.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (this.c == null || this.c.size() == 0) {
                return null;
            }
            TextView textView;
            ImageView imageView;
            if (view != null) {
                a aVar = (a) view.getTag();
                textView = aVar.a;
                imageView = aVar.b;
            } else {
                view = new FrameLayout(this.b);
                View imageView2 = new ImageView(this.b);
                if (le.this.i != null) {
                    imageView2.setImageBitmap(le.this.i);
                }
                LayoutParams layoutParams = new FrameLayout.LayoutParams(le.this.c.getMeasuredWidth(), (int) (le.this.j * 45.0f));
                layoutParams.gravity = 17;
                view.addView(imageView2, layoutParams);
                textView = new TextView(this.b);
                textView.setGravity(17);
                layoutParams = new FrameLayout.LayoutParams(-2, (int) (le.this.j * 45.0f));
                layoutParams.gravity = 17;
                view.addView(textView, layoutParams);
                view.setTag(new a(textView, imageView2));
                View imageView3 = imageView2;
            }
            textView.setText(((ow) this.c.get(i)).a());
            if (i != le.this.t) {
                textView.setTextColor(le.p);
                imageView3.setVisibility(4);
                return view;
            }
            textView.setTextColor(-1);
            imageView3.setVisibility(0);
            return view;
        }

        public void a(List<ow> list) {
            this.c = list;
            notifyDataSetChanged();
        }
    }

    public le(Context context, aa aaVar) {
        this.s = aaVar;
        this.r = context;
        this.x = true;
    }

    private void e() {
        if (this.b == null) {
            this.q = new a(this.s.getContext(), new ArrayList());
            a(this.r);
            b(this.r);
            a(this.r, this.q);
            if (this.s.getMap() != null && this.s.getMap().c() != null && this.s.getMap().c().i() != null) {
                this.y = this.s.getMap().c().i().getIndoorMapControl();
            }
        }
    }

    private void a(Context context) {
        this.j = context.getApplicationContext().getResources().getDisplayMetrics().density;
        this.o = (int) (234.0d * ((double) this.j));
    }

    private void b(Context context) {
        this.h = kh.b(context, "indoor_background.9.png");
        this.i = kh.b(context, "item_selected_background.png");
    }

    public boolean b() {
        return this.x;
    }

    public void a(ov ovVar) {
        if (ovVar != null) {
            if (this.b == null) {
                e();
            }
            this.v = ovVar;
            a(ovVar.b());
        }
    }

    @TargetApi(9)
    private void a(Context context, a aVar) {
        this.b = new RelativeLayout(context);
        this.d = new TextView(context);
        this.e = new View(context);
        this.c = new lf(context);
        this.f = new View(context);
        this.g = new View(context);
        this.c.setChoiceMode(1);
        this.c.setAdapter(aVar);
        this.c.setOnItemClickListener(this);
        this.c.setVerticalScrollBarEnabled(false);
        this.c.setHorizontalScrollBarEnabled(false);
        this.c.setOverScrollMode(2);
        this.c.setDivider(null);
        this.c.setDividerHeight(0);
        this.c.setOnDataChangedListener(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (30.0f * this.j), -2);
        layoutParams.addRule(14, -1);
        layoutParams.topMargin = (int) (this.j * 6.0f);
        this.d.setId(this.d.hashCode());
        this.d.setText("楼层");
        this.d.setTextSize(12.0f);
        this.d.setGravity(17);
        this.d.setTextColor(Color.argb(200, 56, 56, 56));
        this.b.addView(this.d, layoutParams);
        layoutParams = new RelativeLayout.LayoutParams((int) (30.0f * this.j), (int) (1.0f * this.j));
        layoutParams.addRule(3, this.d.getId());
        layoutParams.addRule(14, -1);
        layoutParams.topMargin = (int) (this.j * 6.0f);
        this.e.setBackgroundColor(-3355444);
        this.e.setId(this.e.hashCode());
        this.b.addView(this.e, layoutParams);
        if (this.h != null) {
            byte[] ninePatchChunk = this.h.getNinePatchChunk();
            jo a = jo.a(ninePatchChunk);
            Rect rect = new Rect();
            if (a != null) {
                rect = a.a;
            }
            this.b.setBackgroundDrawable(new NinePatchDrawable(this.r.getResources(), this.h, ninePatchChunk, rect, null));
        }
        layoutParams = new RelativeLayout.LayoutParams((int) (25.0f * this.j), (int) (180.0f * this.j));
        layoutParams.addRule(3, this.e.getId());
        layoutParams.addRule(14, -1);
        this.b.addView(this.c, layoutParams);
        a(this.s);
        this.b.measure(0, 0);
        this.b.setVisibility(4);
    }

    public void a(int i, int i2) {
        if (!this.x || ((float) i2) >= ((float) this.o) + (100.0f * this.j)) {
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(8);
        }
    }

    public void a() {
        if (this.h != null) {
            this.h.recycle();
        }
        if (this.i != null) {
            this.i.recycle();
        }
    }

    public boolean a(ViewGroup viewGroup) {
        if (viewGroup.indexOfChild(this.b) < 0) {
            viewGroup.addView(this.b, f());
        }
        return true;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.s.getMap() != null) {
            if (this.z != null) {
                this.z.a.setTextColor(-16777216);
                this.z.b.setVisibility(4);
            }
            a aVar = (a) view.getTag();
            aVar.a.setTextColor(-1);
            aVar.b.setVisibility(0);
            this.z = aVar;
            this.t = i;
            this.a = true;
        }
    }

    private FrameLayout.LayoutParams f() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, this.o);
        layoutParams.gravity = 19;
        layoutParams.leftMargin = (int) (8.0f * this.j);
        return layoutParams;
    }

    public void a(boolean z) {
        if (this.s != null && this.s.getMap() != null) {
            if (this.b == null) {
                e();
            }
            ac map = this.s.getMap();
            or d = map.d();
            if (!this.x || !z || d == null || this.y == null || !this.y.a() || d.b < 18.0f) {
                if (this.b.getVisibility() == 0) {
                    this.b.setVisibility(8);
                }
            } else if (this.b.getVisibility() != 0) {
                this.b.setVisibility(0);
                a(map.c().c(d.a));
            }
        }
    }

    private void a(List<ow> list) {
        FrameLayout.LayoutParams layoutParams;
        if (list.size() < 4 && list.size() != this.u) {
            layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.height -= (4 - list.size()) * 45;
            this.s.updateViewLayout(this.b, layoutParams);
        } else if (list.size() != this.u && this.u < 4) {
            layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.height = this.o;
            this.s.updateViewLayout(this.b, layoutParams);
        }
        this.u = list.size();
        if (this.q != null) {
            this.q.a(list);
        }
    }

    private void g() {
        int c = this.v.c();
        if (this.w != null && this.a && this.w.equals(this.v.a())) {
            this.c.setItemChecked(c, true);
            this.a = false;
        } else {
            this.c.setSelectionFromTop(c, ((int) (((double) (45.0f * this.j)) + 0.5d)) * 2);
        }
        this.t = c;
        this.w = this.v.a();
    }

    public void c() {
        g();
    }
}
