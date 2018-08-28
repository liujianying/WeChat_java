package com.tencent.recovery;

import com.tencent.recovery.config.Express;
import com.tencent.recovery.config.ExpressItem;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.CommonOptions.Builder;
import com.tencent.recovery.option.ProcessOptions;
import java.util.ArrayList;
import java.util.List;

public class ConstantsRecovery {

    public static final class DefaultCommonOptions {
        public static final CommonOptions vgS;

        static {
            Builder builder = new Builder();
            builder.fMk = "";
            builder.clientVersion = "";
            builder.vhv = "";
            builder.vhz = "";
            builder.vhA = "";
            vgS = builder.cEZ();
        }
    }

    public static final class DefaultExpress {
        public static final Express vgT = new Express();
        public static final Express vgU = new Express();
        public static final Express vgV = new Express();

        static {
            List arrayList = new ArrayList();
            arrayList.add(new ExpressItem(17, 1114112));
            vgT.ef(arrayList);
            arrayList = new ArrayList();
            arrayList.add(new ExpressItem(1, 1118208));
            vgU.ef(arrayList);
            arrayList = new ArrayList();
            arrayList.add(new ExpressItem(1, 1114112));
            vgV.ef(arrayList);
        }
    }

    public static final class DefaultProcessOptions {
        public static final ProcessOptions vgW;
        public static final ProcessOptions vgX;
        public static final ProcessOptions vgY;

        static {
            ProcessOptions.Builder builder = new ProcessOptions.Builder();
            builder.vhF = DefaultExpress.vgT;
            builder.cFa();
            vgW = builder.cFb();
            builder = new ProcessOptions.Builder();
            builder.vhF = DefaultExpress.vgU;
            builder.cFa();
            vgX = builder.cFb();
            builder = new ProcessOptions.Builder();
            builder.vhF = DefaultExpress.vgV;
            builder.cFa();
            vgY = builder.cFb();
        }
    }

    public static final class IntentAction {
    }

    public static final class IntentKeys {
    }

    public static final class Message {
    }

    public static final class ProcessStage {
    }

    public static final class ProcessStartFlag {
    }

    public static final class ProcessStatus {
    }

    public static final class ReportType {
    }

    public static final class SpKeys {
    }
}
