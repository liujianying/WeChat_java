package c.t.m.g;

import android.bluetooth.le.ScanResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

class da$a extends Handler {
    private /* synthetic */ da a;

    public da$a(da daVar, Looper looper) {
        this.a = daVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case BaseReportManager.MAX_READ_COUNT /*1000*/:
                da.a(this.a);
                return;
            case 2000:
                da.b(this.a);
                return;
            case 3000:
                da.a(this.a, (ScanResult) message.obj);
                return;
            default:
                return;
        }
    }
}
