package sn.amir.boss.msscbeerservice.web.model;

public class Main {
    public static void main(String[] args) {
        BeerDto beerDto = BeerDto.builder().build();

        System.out.println(beerDto.toString());
    }
}
