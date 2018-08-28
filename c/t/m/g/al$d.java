package c.t.m.g;

import c.t.m.g.al.a;
import java.util.ArrayList;
import java.util.List;

final class al$d extends a {
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d = false;
    public List<av.a> e;
    int f;
    private /* synthetic */ al g;

    public al$d(al alVar, boolean z, boolean z2) {
        this.g = alVar;
        super(alVar, (byte) 0);
        this.b = z;
        this.c = z2;
    }

    public final void run() {
        String str;
        List list = null;
        int i = 0;
        this.a = false;
        al.a(w.a("report_max_report_count", 10, 100, 20));
        if (this.b) {
            int size = al.e(this.g).size();
            if (size != 0) {
                List arrayList = new ArrayList();
                List arrayList2 = new ArrayList();
                int i2 = 0;
                for (int i3 = 0; i3 < size && i2 < al.e(); i3++) {
                    str = (String) al.e(this.g).get(i3);
                    arrayList2.add(new av.a(0, str));
                    arrayList.add(str);
                    i2++;
                }
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    al.e(this.g).remove(arrayList.get(i4));
                }
                if (al.e(this.g).size() == 0) {
                    this.a = true;
                }
                list = arrayList2;
            }
            this.e = list;
        } else {
            if (!av.a(this.g.c()).a(w.a("report_clear_db_num", 1, 10000, 1000))) {
                list = av.a(this.g.c()).b(al.e() + 1);
                if (list.size() <= al.e()) {
                    this.a = true;
                    al.a(this.g, true);
                } else {
                    list.remove(list.size() - 1);
                }
            }
            this.e = list;
        }
        if (this.e == null || this.e.size() == 0) {
            al.g(this.g);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (i < this.e.size()) {
            stringBuilder.append(((av.a) this.e.get(i)).b).append("\n");
            i++;
        }
        str = stringBuilder.toString();
        if (this.b && str.contains("client_report_time")) {
            str = str.replace("client_report_time", ci.a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
        }
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        this.f = length;
        byte[] a = w.a(bytes);
        al.b(a.length);
        al.i(this.g).a(a, length, this.b, this, al.h(this.g));
    }
}
