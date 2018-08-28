package android.support.v4.d;

class e$a implements e$c {
    public static final e$a tl = new e$a(true);
    public static final e$a tm = new e$a(false);
    private final boolean tk;

    public final int b(CharSequence charSequence, int i) {
        int i2 = i + 0;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            switch (e.ab(Character.getDirectionality(charSequence.charAt(i4)))) {
                case 0:
                    if (!this.tk) {
                        i3 = 1;
                        break;
                    }
                    return 0;
                case 1:
                    if (this.tk) {
                        i3 = 1;
                        break;
                    }
                    return 1;
                default:
                    break;
            }
        }
        if (i3 == 0) {
            return 2;
        }
        if (this.tk) {
            return 1;
        }
        return 0;
    }

    private e$a(boolean z) {
        this.tk = z;
    }
}
