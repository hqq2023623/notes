package zj.contract;

/**
 * 比较的规则定义在了接口的默认方法中，通过实现接口，只需要准备数据即可
 */
class StringTests implements ComparableContract<String>, EqualsContract<String> {

    @Override
    public String createValue() {
        return "foo";
    }

    @Override
    public String createSmallerValue() {
        return "bar"; // 'b' < 'f' in "foo"
    }

    @Override
    public String createNotEqualValue() {
        return "baz";
    }

}