package test.constructor;

/**
 * @author Lzj Created on 2015/12/18.
 */
public class HasPrivateConstrutor {

    private String name;

    private HasPrivateConstrutor() {
    }

    public HasPrivateConstrutor(String name) {
        this.name = name;
    }


}
