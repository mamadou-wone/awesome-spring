package sn.amir.boss.msscbeerservice.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sn.amir.boss.msscbeerservice.domain.Beer;
import sn.amir.boss.msscbeerservice.repository.BeerRepository;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObject();
    }

    private void loadBeerObject() {
        if (beerRepository.count() == 0){
            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(3333333333L)
                    .price(new BigDecimal("12.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("IPA")
                    .quantityToBrew(150)
                    .minOnHand(12)
                    .upc(74523333L)
                    .price(new BigDecimal("412.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("DOG")
                    .beerStyle("IPA")
                    .quantityToBrew(150)
                    .minOnHand(12)
                    .upc(74523333L)
                    .price(new BigDecimal("412.95"))
                    .build());


        }
    }
}
