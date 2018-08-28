package com.tencent.tinker.loader.shareutil;

public final class ShareOatUtil {

    /* renamed from: com.tencent.tinker.loader.shareutil.ShareOatUtil$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] vvv = new int[InstructionSet.values().length];

        static {
            try {
                vvv[InstructionSet.kArm.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                vvv[InstructionSet.kThumb2.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                vvv[InstructionSet.kArm64.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                vvv[InstructionSet.kX86.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                vvv[InstructionSet.kX86_64.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                vvv[InstructionSet.kMips.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                vvv[InstructionSet.kMips64.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                vvv[InstructionSet.kNone.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    private enum InstructionSet {
        kNone,
        kArm,
        kArm64,
        kThumb2,
        kX86,
        kX86_64,
        kMips,
        kMips64
    }

    private ShareOatUtil() {
        throw new UnsupportedOperationException();
    }
}
