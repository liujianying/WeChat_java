package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.a.c.a;
import com.tencent.mm.plugin.appbrand.appcache.a.d.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.c.cgu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

final class AppBrandIDKeyBatchReport$IDKeyBatchReportTask extends MainProcessTask {
    public static final Creator<AppBrandIDKeyBatchReport$IDKeyBatchReportTask> CREATOR = new Creator<AppBrandIDKeyBatchReport$IDKeyBatchReportTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandIDKeyBatchReport$IDKeyBatchReportTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandIDKeyBatchReport$IDKeyBatchReportTask[i];
        }
    };
    public String gqA;
    public int gqB;
    cgu gqC;
    public int gqy;
    int gqz;

    AppBrandIDKeyBatchReport$IDKeyBatchReportTask() {
    }

    AppBrandIDKeyBatchReport$IDKeyBatchReportTask(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        if (1 == this.gqy) {
            if (!bi.oW(this.gqA) && g.Eg().dpD) {
                Pair w = ((b) e.x(b.class)).w(this.gqA, 5, this.gqB);
                if (((Boolean) w.first).booleanValue()) {
                    x.i("MicroMsg.AppBrandIDKeyBatchReport", "report blocked by appid(%s) scene(%d) ", new Object[]{this.gqA, Integer.valueOf(this.gqB)});
                    int i = a.fiY;
                    a.n((long) ((Integer) w.second).intValue(), 167);
                    return;
                }
            }
            AppBrandIDKeyBatchReport.b.hl(0);
            AppBrandIDKeyBatchReport.b.Jv();
        } else if (2 == this.gqy) {
            AppBrandIDKeyBatchReport.b.amB();
        } else if (3 == this.gqy) {
            AppBrandIDKeyBatchReport.b.c(this.gqC);
        }
    }

    public final void g(Parcel parcel) {
        this.gqy = parcel.readInt();
        this.gqz = parcel.readInt();
        this.gqA = parcel.readString();
        this.gqB = parcel.readInt();
        if (3 == this.gqy) {
            try {
                this.gqC = new cgu();
                this.gqC.aG(parcel.createByteArray());
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandIDKeyBatchReport", "parse WxaAppRecord from parcel, e = %s", new Object[]{e});
                this.gqC = null;
            }
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.gqy);
        parcel.writeInt(this.gqz);
        parcel.writeString(this.gqA);
        parcel.writeInt(this.gqB);
        if (3 == this.gqy) {
            try {
                parcel.writeByteArray(this.gqC.toByteArray());
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandIDKeyBatchReport", "write WxaAppRecord to parcel, e = %s", new Object[]{e});
            }
        }
    }
}
