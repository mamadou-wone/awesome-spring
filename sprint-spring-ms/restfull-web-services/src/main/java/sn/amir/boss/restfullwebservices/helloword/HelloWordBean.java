package sn.amir.boss.restfullwebservices.helloword;

public class HelloWordBean {

    private String name;

    public HelloWordBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HelloWordBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
