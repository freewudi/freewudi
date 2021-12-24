package charact5;

import tools.Assert;

public class TestAssert {
    public static void main(String[] args) {
        Assert.is_true((2 + 2) == 5);
        Assert.is_false((1 + 1) == 2);
        Assert.is_true((2 + 2) == 5, "2 + 2 == 5");
        Assert.is_false((1 + 1) == 2, "1 +1 != 2");
    }

}
